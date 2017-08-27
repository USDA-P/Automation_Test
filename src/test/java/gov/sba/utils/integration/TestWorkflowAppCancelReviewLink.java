// TS_Created_By_Deepa_Patri
package gov.sba.utils.integration;

import gov.sba.automation.CommonApplicationMethods;
import gov.sba.automation.DatabaseUtils;
import gov.sba.automation.TestHelpers;
import gov.sba.pageObjetcs.ProgramsPage;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.utils.integration.FillApplCreatePages.pageCaseOverviewFillup;


@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkflowAppCancelReviewLink extends TestCase {
  /* Set The variables Define */
  Logger logger = LogManager.getLogger(TestWorkflowAppCancelReviewLink.class.getName());
  WebDriver webDriver;
  int get_The_Row_From_Login_Data;
  String duns_Number, email, password;

  @Before
  public void setUp() throws Exception {
    CommonApplicationMethods.clear_Env_Chrome();
   // TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    String[] details = findUnusedDunsNumber("");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
  }

  @Test
  public void testWorkflowAppCancelReviewLink() throws Exception {
    try {
      /*
       * return_All_Applications(webDriver, 55, duns_Number);
       * delete_All_Application_Draft(webDriver, email, password, duns_Number);
       */

      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      ProgramsPage.join_New_Program_CheckBoxes(webDriver, "WOSB");
      FillApplCreatePages.page8aFillUp(webDriver, "Yes");
      FillApplCreatePages.finalSignatureSubmit(webDriver);

      navigationMenuClick(webDriver, "Logout");
      new LoginPageWithReference(webDriver, 11).Login_With_Reference();

      /* Start Common Function Click on Case Link on main navigator */
      navigationBarClick(webDriver, "Cases");
      /* Update - case page based on Elastic search clear the input text before set text */

      casesPageSearch(webDriver, duns_Number);
      List<WebElement> current_Row = find_Elements(webDriver, "xpath",
          "//div[@id='table-search']/table/tbody/tr [ td[position()=2]/a[contains(text(),'"
              + duns_Number
              + "')] and td[position()=3 and contains(text(),'WOSB') and not(contains(text(),'EDWOSB'))] ]");

      if (current_Row.size() > 0) {

        logger.info(current_Row.get(0).getAttribute("innerHTML"));
        current_Row.get(0).findElement(By.xpath("td/a[contains(text(),'Legal Business Name')]"))
            .click();
        verify_Text(webDriver, "Case_CaseOverview_title", "Case Overview");
        Select dropdown = new Select(find_Element(webDriver, "Case_Current_ReviewType"));
        assertEquals(1, dropdown.getOptions().size());

        assertEquals("Initial Review", dropdown.getFirstSelectedOption().getText());

        new Select(find_Element(webDriver, "SBA_Case_Overview_Select_Reviewer_Id"))
            .selectByIndex(0);
        new Select(find_Element(webDriver, "SBA_Case_Overview_Select_Owner_Id")).selectByIndex(1);
        new Select(find_Element(webDriver, "SBA_Case_Overview_Select_Supervisor_Id"))
            .selectByIndex(1);

        click_Element(webDriver, "Case_Submit_Button");
        click_Element(webDriver, "SBA_Case_Overview_Link");

        /* Verify Cancel Review link -APP 77 Acceptance Criteria */
        click_Element(webDriver, "SBA_Case_Cancel_Review_Link");
        accept_Alert(webDriver, 10);

        String sql_Q = "select count(case_number) from sbaone.reviews "
            + "		where workflow_state = 'cancelled' " + "	and sba_application_id 	 = "
            + "								(select max(id) from sbaone.sba_applications where organization_id = "
            + returnOrganization_Id(duns_Number) + " and deleted_at is null )";

        logger.info(sql_Q);

        String[][] count_Case = DatabaseUtils.queryForData(sql_Q, 1, 1);

        assertEquals(count_Case[0][0], "1");

        navigationBarClick(webDriver, "Cases");
        casesPageSearch(webDriver, duns_Number);

        find_Element(webDriver, "xpath",
            "//div[@id='table-search']/table/tbody/tr[ td[position()=2]/a[contains(text(),'"
                + duns_Number + "')] ]")
                    .findElement(By.xpath("td/a[contains(text(),'Legal Business Name')]")).click();

        pageCaseOverviewFillup(webDriver, "Initial Review", "Analyst1 X", "Analyst1 X",
            "Analyst1 X");
        click_Element(webDriver, "Case_Submit_Button");
        click_Element(webDriver, "Case_SaveNotes_Button");

        click_Element(webDriver, "SBA_Case_Overview_Link");
        assertNull(find_Element(webDriver, "SBA_Case_Cancel_Review_Link", true));

      }

    } catch (Exception e) {
      logger.info(e.toString());
      CommonApplicationMethods.take_ScreenShot_TestCaseName(webDriver,
          new String[] {"TestWorkflowAppCancelReviewLink", "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
