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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.AnalystCasesPage.return_DunsNo_Cases_Table;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.click_On_App_In_Vend_Dash;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;
import static gov.sba.utils.integration.FillApplCreatePages.page8aFillUp;

/*
 * Documentation for Workflow WorkFlows for EDWOSB - Accommodating best minimal Workflow Tests
 * TestWorkflowEDWOSB + 01. Vendor Draft Create , logout. Update draft submit , Analyst Review,
 * Supervisor Approve - 8a Yes 02. Vendor Create , Submit, Analyst Review, Supervisor Approve - 8a
 * No 03. Vendor Create , Submit, Analyst Review, Supervisor Reject - Declined 04. Vendor Create ,
 * Submit, Analyst return, Vendor Change Draft , Resubmit, Analyst Review, Supervisor Approve 05.
 * Vendor Create , Submit, Analyst return, Vendor Change Draft , Resubmit, AAnalyst Review,
 * Supervisor reject 06. Vendor Create , Submit, Annual Review, ReSubmit, Supervisor Review,
 * Supervisor Approve 07. Vendor Create , Submit, Annual Review, ReSubmit, Supervisor Review,
 * Supervisor Reject
 */


@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkflowEDWOSB04 extends TestCase {
  Logger logger = LogManager.getLogger(TestWorkflowWOSB03.class.getName());
  private static WebDriver webDriver;
  int stop_Exec = 1;
  String duns_Number, email, password;

  /* int get_The_Row_From_Login_Data; */
  @Before
  public void setUp() throws Exception {
    get_Stop_Execution_Flag();
    clear_Env_Chrome();
    logger.info("Set as head");
    // TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    String[] details = findUnusedDunsNumber("corp");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
    /* duns_Number = "158112285";get_The_Row_From_Login_Data = 63; */
  }

  @Test
  public void testWorkflowEDWOSB04() throws Exception {
    try {
      /*
       * return_All_Applications(webDriver, 55, duns_Number);
       * delete_All_Application_Draft(webDriver, email, password, duns_Number);
       */
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      join_New_Program_CheckBoxes(webDriver, "EDWOSB");
      new NewScorpQuestionPageDeepa(webDriver).NewScorpQuestionPageDeepa();
      new NewFinancialSectionQuestionDeepa(webDriver).NewFinancialQuestion();
      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 11).Login_With_Reference();

      /* Verify Download Zip or generate Zip link displayed on vendor overview page -APP-473 */
      return_DunsNo_Cases_Table(webDriver, duns_Number, "EDWOSB");
      navigationBarClick(webDriver, "LOGOUT");
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      /* Resubmit the application */
      click_On_App_In_Vend_Dash(webDriver, "EDWOSB");
      page8aFillUp(webDriver, "Yes");
      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 55).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
      click_Element(webDriver, "Application_Common_Submit_Button_Id");
      Thread.sleep(2000); // Sleep neded here
      click_Element(webDriver, "Application_Common_Save_Notes_Id");
      Thread.sleep(2000); // Sleep neded here
     //  double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();
      Thread.sleep(2000); // Sleep neded here
      click_Element(webDriver, "Application_Common_Submit_Button");
      Thread.sleep(1000); // Sleep neded here
      click_Element(webDriver, "SBA_Review_Return_For_Mod");
      click_Element(webDriver, "SBA_Review_Determination_Save_Button");
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");
      navigationBarClick(webDriver, "LOGOUT");
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      click_On_App_In_Vend_Dash(webDriver, "EDWOSB");
      page8aFillUp(webDriver, "Yes");
      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 55).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
      click_Element(webDriver, "Application_Common_Submit_Button_Id");
      // double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();
      click_Element(webDriver, "SBA_Review_Determ_Made");
      new Select(find_Element(webDriver, "Analyst_Review_Determ_Decision")).selectByIndex(1);
      /* if (stop_Exec == 1) { return;}/* TODO Hard Coded Duns Number */
      click_Element(webDriver, "Application_Common_Submit_Button");
      assertTrue(find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Active"));
      if (stop_Exec == 1) {
        return;
      } /* TODO DE exists App-1499 */
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Decision: SBA Approved"));
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");

      navigationBarClick(webDriver, "LOGOUT");

    } catch (Exception e) {
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
