// TS_Created_By_Deepa_Patri
package gov.sba.utils.integration;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.click_On_App_In_Vend_Dash;
import static gov.sba.pageObjetcs.VendorDashboardPage.verify_Row_In_A_Table_And_Return;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;
import static gov.sba.utils.integration.FillApplCreatePages.page8aFillUpDunsNo;

/*
 * Documentation for Workflow WorkFlows for MPP - Accommodating best minimal Workflow Tests
 * TestWorkflowMPP + 01. Vendor Draft Create , logout. Update draft submit , Analyst Review,
 * Supervisor Approve - 8a Yes 02. Vendor Create , Submit, Analyst Review, Supervisor Approve - 8a
 * No 03. Vendor Create , Submit, Analyst Review, Supervisor Reject - Declined 04. Vendor Create ,
 * Submit, Analyst return, Vendor Change Draft , Resubmit, Analyst Review, Supervisor Approve 05.
 * Vendor Create , Submit, Analyst return, Vendor Change Draft , Resubmit, AAnalyst Review,
 * Supervisor reject 06. Vendor Create , Submit, Vendor Create another Submit 06. Vendor Create
 * ......
 * 
 */


@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkflowMPP01 extends TestCase {
  Logger logger = LogManager.getLogger(TestWorkflowMPP01.class.getName());
  private static WebDriver webDriver;
  int stop_Exec = 1;
  String duns_Number, email, password;
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    get_Stop_Execution_Flag();
    clear_Env_Chrome();
    logger.info("Set as head");
    // TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    String[] details = findUnusedDunsNumber("");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
    /* duns_Number = "158112285";get_The_Row_From_Login_Data = 63; */

  }

  @Test
  public void testWorkflowMPP01() throws Exception {
    try {

      // return_All_Applications(webDriver, 56, duns_Number);
      // delete_All_Application_Draft(webDriver, email, password, duns_Number);
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      join_New_Program_CheckBoxes(webDriver, "MPP");
      page8aFillUpDunsNo(webDriver, "Yes", duns_Number);
      navigationMenuClick(webDriver, "Logout");
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      click_On_App_In_Vend_Dash(webDriver, "MPP");
      finalSignatureSubmit(webDriver);
      List<WebElement> all_Cells = verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "", "Pending", "", "", "", ""});
      assertNotNull(all_Cells);
      /* Verify the Summary page, Expire date and Issue date in vendor dashboard */
      /* Summary Page title Us1699,!457,1463 */

      /* TODO For expiry date and Issue date */
      navigationMenuClick(webDriver, "Logout");

      /* TODO For expiry date and Issue date */

      new LoginPageWithReference(webDriver, 29).Login_With_Reference();
      navigationBarClick(webDriver, "Cases");
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
      assertEquals("Case Overview", find_Element(webDriver, "Case_CaseOverview_title").getText());
      assertEquals("Open application summary",
          find_Element(webDriver, "SBA_Case_Overview_Open_Application_Summary").getText());
      assertEquals("Return to Vendor",
          find_Element(webDriver, "SBA_Case_Overview_Return_to_vendor").getText());
      click_Element(webDriver, "Case_Submit_Button");

      /* Verify the Question review page */
      assertNotNull(find_Element(webDriver, "SBA_Question_Review_Fill_Up_SideNav", true));
      List<WebElement> dropdown =
          new Select(find_Element(webDriver, "SBA_Assesment_Status")).getOptions();
      logger.info(dropdown.get(0).getText());
      assertEquals("Confirmed", dropdown.get(0).getText());
      assertEquals("Not reviewed", dropdown.get(1).getText());
      assertEquals("Information missing", dropdown.get(2).getText());

      assertEquals("Makes vendor ineligible", dropdown.get(3).getText());
      assertEquals("Needs further review", dropdown.get(4).getText());
      click_Element(webDriver, "SBA_Note_Link");
      setText_Element(webDriver, "SBA_Assesments_Note_Body", "Adding notes QA");
      click_Element(webDriver, "Application_Common_Save_Notes_Id");

      /* For MPP Financial review link not exist */
      assertNull(find_Element(webDriver, "SBA_Question_Financial_Review_SideNav", true));

      /* Signature page */
      assertNotNull(find_Element(webDriver, "SBA_Question_Signature_Review_SideNav", true));
      dropdown =
          new Select(find_Element(webDriver, "SBA_Question_Assesment_Status_Options")).getOptions();
      assertEquals("Confirmed", dropdown.get(0).getText());
      assertEquals("Not reviewed", dropdown.get(1).getText());
      assertEquals("Information missing", dropdown.get(2).getText());
      assertEquals("Makes vendor ineligible", dropdown.get(3).getText());
      assertEquals("Needs further review", dropdown.get(4).getText());
      click_Element(webDriver, "SBA_Note_Link");
      setText_Element(webDriver, "SBA_Assesment_Note_Body", "Adding notes QA Signature Page");
      click_Element(webDriver, "SBA_Common_Page_Commit");

      /* Determination page */
      assertNotNull(find_Element(webDriver, "SBA_Question_Determinations_SideNav", true));
      assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Review_Started").getText(),
          "Review Started");
      assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Return_For_Mod").getText(),
          "Return for Modification");
      assertEquals(find_Element(webDriver, "SBA_Question_New_Determination_Reccomend_For_Eligibile")
          .getText(), "Recommend Eligible");
      assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Reccomend_For_InEligibile")
              .getText(),
          "Recommend Ineligible");
      setText_Element(webDriver, "SBA_Assesment_Note_Body", "Qa Test");

      /* Verify on Analyst Detremination page -Determination Made, Decision not displayed */
      assertNull(find_Element(webDriver, "SBA_Review_Determ_Made", true));
      assertNull(find_Element(webDriver, "SBA_Review_Determ_Decision", true));

      /* if (stop_Exec == 1) { return; } /* TODO DE exists on submit */
      click_Element(webDriver, "Application_Common_Submit_Button");
     // double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();

      assertTrue(find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Pending"));
      navigationBarClick(webDriver, "LOGOUT");

      /* Supervisor Flow - Approve */
      new LoginPageWithReference(webDriver, 56).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
     // double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();

      click_Element(webDriver, "SBA_Review_Determ_Made");
      assertNotNull(find_Element(webDriver, "Analyst_Review_Determ_Decision", true));
      new Select(find_Element(webDriver, "Analyst_Review_Determ_Decision")).selectByIndex(1);
      click_Element(webDriver, "Application_Common_Submit_Button");
      /* if (stop_Exec == 1) { return; } /* TODO Remove Hard coded duns_Number */

      assertTrue(find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Active"));
      if (stop_Exec == 1) {
        return;
      } /* TODO DE APP-1499 exist */
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Decision: SBA Approved"));


    } catch (Exception e) {
      logger.info(e.toString());
      take_ScreenShot_TestCaseName(webDriver, new String[] {"TestWorkflowMPP01", "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
