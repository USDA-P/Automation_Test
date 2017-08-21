package gov.sba.utils.integration;

import gov.sba.automation.TestHelpers;
import gov.sba.pageObjetcs.MPPQuestionaairePage;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.verify_Row_In_A_Table_And_Return;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;

/*
 * Documentation for Workflow WorkFlows for MPP - Accommodating best minimal Workflow Tests
 * TestWorkflowMPP + 08- Vendor admin create MPP application with no size detemination,Active
 * Agreement and without Needs Analyst Review the Submitted MPP application, Supervisor approves it.
 */


@Category({StableTests.class})
public class TestWorkflowMPP08 extends TestCase {
  Logger logger = LogManager.getLogger(TestWorkflowMPP08.class.getName());
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
    /* duns_Number = "196374813"; get_The_Row_From_Login_Data = 41; */

  }

  @Test
  public void testWorkflowMPP08() throws Exception {
    try {

      /*
       * return_All_Applications(webDriver, 56, duns_Number);
       * delete_All_Application_Draft(webDriver, email, password, duns_Number);
       */
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      join_New_Program_CheckBoxes(webDriver, "MPP");
      MPPQuestionaairePage.answers_8a_Questioannaire(webDriver, "No");
      MPPQuestionaairePage.eligibilityPage(webDriver, "Yes", "Yes", "No", "No");
      MPPQuestionaairePage.select_NALCS_Code(webDriver, "Yes", "Yes");
      MPPQuestionaairePage.size_Determination(webDriver, "No");
      generic_file_Upld(webDriver);
      MPPQuestionaairePage.plan_Agreement(webDriver, "Yes");
      MPPQuestionaairePage.activeAgreement(webDriver);
      generic_file_Upld(webDriver);
      generic_file_Upld(webDriver);
      MPPQuestionaairePage.determination_Needs_Page(webDriver, "No", "No", "No", "No", "No", "No");
      generic_file_Upld(webDriver);
      MPPQuestionaairePage.mpp_BusinessInfo(webDriver, duns_Number);

      /* Review Page submit */
      /*
       * if (stop_Exec == 1) { return; } /* TODO DE App-1296 Exist on Submit Button on review Page
       */

      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      finalSignatureSubmit(webDriver);
      assertNotNull(verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "", "Pending", "", "", "", ""}));
      navigationMenuClick(webDriver, "LOGOUT");
      /* Analyst Login start Review Process */
      new LoginPageWithReference(webDriver, 29).Login_With_Reference();
      navigationBarClick(webDriver, "Cases");
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      /* case Overview Page */
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
      assertEquals("Case Overview", find_Element(webDriver, "Case_CaseOverview_title").getText());
      assertEquals("Open application summary",
          find_Element(webDriver, "SBA_Case_Overview_Open_Application_Summary").getText());
      assertEquals("Return to Vendor",
          find_Element(webDriver, "SBA_Case_Overview_Return_to_vendor").getText());
      click_Element(webDriver, "Case_Submit_Button");
      /* Question review page */
      click_Element(webDriver, "SBA_Note_Link");
      setText_Element(webDriver, "SBA_Assesments_Note_Body", "Adding notes QAquestion Review page");
      click_Element(webDriver, "SBA_Common_Page_Commit");
      /* Signature page */
      click_Element(webDriver, "SBA_Note_Link");
      setText_Element(webDriver, "SBA_Assesment_Note_Body", "Adding notes QA Signature Page");
      click_Element(webDriver, "SBA_Common_Page_Commit");
      /* Determination page */
      assertNull(find_Element(webDriver, "SBA_Review_Determ_Made", true));
      assertNull(find_Element(webDriver, "SBA_Review_Determ_Decision", true));
      /* if (stop_Exec == 1) {return; } /* TODO DE exists on submit App-1148 */

      click_Element(webDriver, "Application_Common_Submit_Button");
      assertTrue(find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Pending"));
      navigationBarClick(webDriver, "LOGOUT");
      /* Supervisor make Determination SBA Approve */
      new LoginPageWithReference(webDriver, 56).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
      // double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();
      /* Determination SBA Approved */
      click_Element(webDriver, "SBA_Review_Determ_Made");
      assertNotNull(find_Element(webDriver, "Analyst_Review_Determ_Decision", true));
      new Select(find_Element(webDriver, "Analyst_Review_Determ_Decision")).selectByIndex(1);
      click_Element(webDriver, "Application_Common_Submit_Button");
      assertTrue(find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Active"));
      if (stop_Exec == 1) {
        return;
      } /* TODO DE APP-1499 exist */
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Decision: SBA Approved"));

    } catch (Exception e) {
      logger.info("NACIS Code not popluating for this duns number" + e.toString());
      take_ScreenShot_TestCaseName(webDriver, new String[] {"TestWorkflowMPP08", "Exception"});
      throw e;

    }
  }


  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}


