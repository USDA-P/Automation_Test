package gov.sba.utils.integration;
// TS_Created_By_Deepa_Patri

import static gov.sba.automation.AssertionUtils.delete_All_Application_Draft;
import static gov.sba.automation.AssertionUtils.return_All_Applications;
import static gov.sba.automation.CommonApplicationMethods.clear_Env_Chrome;
import static gov.sba.automation.CommonApplicationMethods.click_Element;
import static gov.sba.automation.CommonApplicationMethods.find_Element;
import static gov.sba.automation.CommonApplicationMethods.get_Stop_Execution_Flag;
import static gov.sba.automation.CommonApplicationMethods.navigationBarClick;
import static gov.sba.automation.CommonApplicationMethods.navigationMenuClick;
import static gov.sba.automation.CommonApplicationMethods.search_Cases_Duns_Number_Table;
import static gov.sba.pageObjetcs.analyst_Cases_Page.return_DunsNo_Cases_Table;
import static gov.sba.pageObjetcs.programs_Page.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.vendor_Dashboard_Page.click_On_App_In_Vend_Dash;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;
import static gov.sba.utils.integration.FillApplCreatePages.page8aFillUp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

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
public class TestWorkflowEDWOSB05 extends TestCase {
  Logger logger = LogManager.getLogger(TestWorkflowEDWOSB05.class.getName());
  private static WebDriver webDriver;
  int stop_Exec = 1;
  String duns_Number, email, password;
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    get_Stop_Execution_Flag();
    clear_Env_Chrome();
    webDriver = TestHelpers.getDefaultWebDriver();
    webDriver.get(TestHelpers.getBaseUrl());
    duns_Number = "376736143";
    get_The_Row_From_Login_Data = 64;
  }

  /*
   * Test US1647- Edwosb financial section link disabled for application not having financial
   * partners information
   */
  @Test
  public void testMainTest() throws Exception {
    try {

      return_All_Applications(webDriver, 11, duns_Number);
      delete_All_Application_Draft(webDriver, 64, duns_Number);
      new LoginPageWithReference(webDriver, 64).Login_With_Reference();
      join_New_Program_CheckBoxes(webDriver, "EDWOSB");
      page8aFillUp(webDriver, "Yes");

      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 11).Login_With_Reference();
      /* Verify Download Zip or generate Zip link displayed on vendor overview page -APP-473 */
      return_DunsNo_Cases_Table(webDriver, duns_Number, "EDWOSB");
      navigationBarClick(webDriver, "LOGOUT");

      new LoginPageWithReference(webDriver, 64).Login_With_Reference();
      /* Resubmit the application */
      click_On_App_In_Vend_Dash(webDriver, "EDWOSB");

      page8aFillUp(webDriver, "Yes");
      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 55).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Businesss_Name_Link");
      click_Element(webDriver, "Application_Common_Submit_Button_Id");
      click_Element(webDriver, "Application_Common_Save_Notes_Id");
      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "SBA_Review_Return_For_Mod");
      click_Element(webDriver, "SBA_Review_Determination_Save_Button");
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");
      navigationBarClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 64).Login_With_Reference();
      click_On_App_In_Vend_Dash(webDriver, "EDWOSB");
      page8aFillUp(webDriver, "Yes");
      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 55).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Businesss_Name_Link");
      click_Element(webDriver, "Application_Common_Submit_Button_Id");
      click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      click_Element(webDriver, "SBA_Review_Determ_Made");
      new Select(find_Element(webDriver, "Analyst_Review_Determ_Decision")).selectByIndex(0);
      /* TODO Duns No Hard Coding */
      if (stop_Exec == 1) {
        return;
      }

      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Ineligible"));
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Decision: SBA Declined"));
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