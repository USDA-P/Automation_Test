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

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.verify_Row_In_A_Table_And_Return;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;

/*
 * Documentation for Workflow WorkFlows for MPP - Accommodating best minimal Workflow Tests
 * TestWorkflowMPP +10 Vendor admin create MPP application with having size detemination, No Active
 * Agreement and without Needs The Answers are pre-populated while resubmitting another
 * application..
 */
@Category({StableTests.class})
public class TestWorkflowMPP10 extends TestCase {
  Logger logger = LogManager.getLogger(TestWorkflowMPP10.class.getName());
  private static WebDriver webDriver;
  int stop_Exec = 1;
  String duns_Number, email, password;
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    get_Stop_Execution_Flag();
    clear_Env_Chrome();
    logger.info("Set as head");
     TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    String[] details = findUnusedDunsNumber("");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
    /* duns_Number = "196374813"; get_The_Row_From_Login_Data = 41; */

  }

  @Test
  public void testWorkflowMPP10() throws Exception {
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
      MPPQuestionaairePage.size_Determination(webDriver, "Yes");
      MPPQuestionaairePage.size_ReDetermination(webDriver, "Yes");
      MPPQuestionaairePage.reDetermination_Info(webDriver);
      generic_file_Upld(webDriver);
      MPPQuestionaairePage.plan_Agreement(webDriver, "No");
      generic_file_Upld(webDriver);
      MPPQuestionaairePage.determination_Needs_Page(webDriver, "No", "No", "No", "No", "No", "No");
      generic_file_Upld(webDriver);
      MPPQuestionaairePage.mpp_BusinessInfo(webDriver, duns_Number);

      /* Review Page submit */
      // if (stop_Exec == 1) { return;} /* TODO DE App-1296 Exist on Submit Button on review Page*/
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      finalSignatureSubmit(webDriver);
      assertNotNull(verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "", "Pending", "", "", "", ""}));
      /* Verify the answers are being pre- populated while Resubmitting another the application */
      join_New_Program_CheckBoxes(webDriver, "MPP");
      MPPQuestionaairePage.answers_8a_Questioannaire(webDriver, "assert_no");
      MPPQuestionaairePage.eligibilityPage(webDriver, "assert_yes", "assert_yes", "assert_no",
          "assert_no");
      /* if (stop_Exec == 1) { return; } /* TODO Working On */

    } catch (Exception e) {
      logger.info("NACIS Code not popluating for this duns number" + e.toString());
      take_ScreenShot_TestCaseName(webDriver, new String[] {"TestWorkflowMPP10", "Exception"});
      throw e;

    }
  }


  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
