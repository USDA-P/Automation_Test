package gov.sba.utils.integration;

import static gov.sba.automation.AssertionUtils.delete_All_Application_Draft;
import static gov.sba.automation.AssertionUtils.return_All_Applications;
import static gov.sba.automation.CommonApplicationMethods.accept_Alert;
import static gov.sba.automation.CommonApplicationMethods.clear_Env_Chrome;
import static gov.sba.automation.CommonApplicationMethods.click_Element;
import static gov.sba.automation.CommonApplicationMethods.find_Element;
import static gov.sba.automation.CommonApplicationMethods.get_Stop_Execution_Flag;
import static gov.sba.automation.CommonApplicationMethods.navigationBarClick;
import static gov.sba.automation.CommonApplicationMethods.navigationMenuClick;
import static gov.sba.automation.CommonApplicationMethods.search_Cases_Duns_Number_Table;
import static gov.sba.automation.CommonApplicationMethods.take_ScreenShot_TestCaseName;
import static gov.sba.pageObjetcs.analyst_Cases_Page.return_DunsNo_Cases_Table;
import static gov.sba.pageObjetcs.programs_Page.generic_file_Upld;
import static gov.sba.pageObjetcs.programs_Page.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.vendor_Dashboard_Page.click_On_App_In_Vend_Dash;
import static gov.sba.pageObjetcs.vendor_Dashboard_Page.verify_Row_In_A_Table_And_Return;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;
import static gov.sba.utils.integration.FillApplCreatePages.page8aFillUpDunsNo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

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
public class TestWorkflowMPP05 extends TestCase {
  Logger logger = LogManager.getLogger(gov.sba.utils.integration.TestWorkflowMPP05.class.getName());
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
    duns_Number = "196374813";
    get_The_Row_From_Login_Data = 41;
  }

  /*
   * Test US1647- MPP financial section link disabled for application not having financial partners
   * information
   */
  @Test
  public void testMainTest() throws Exception {
    try {
      return_All_Applications(webDriver, 29, duns_Number);
      delete_All_Application_Draft(webDriver, 41, duns_Number);
      new LoginPageWithReference(webDriver, 41).Login_With_Reference();
      join_New_Program_CheckBoxes(webDriver, "MPP");
      page8aFillUpDunsNo(webDriver, "Yes", duns_Number);
      finalSignatureSubmit(webDriver);
      List<WebElement> all_Cells = verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "", "Pending", "", "", "", ""});
      assertNotNull(all_Cells);
      /*
       * Verify the Summary page, Expire date and Issue date in vendor dashboard Summary Page
       * title--- //Us1699,!457,1463 /*TODO For expiry date and Issue date
       */

      click_On_App_In_Vend_Dash(webDriver, "MPP");
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 29).Login_With_Reference();
      /* Verify Download Zip or generate Zip link displayed on vendor overview page -APP-473 */
      return_DunsNo_Cases_Table(webDriver, duns_Number, "MPP");
      navigationBarClick(webDriver, "LOGOUT");

      new LoginPageWithReference(webDriver, 41).Login_With_Reference();
      /* Resubmit the application */
      click_On_App_In_Vend_Dash(webDriver, "MPP");
      click_Element(webDriver, "Sba_App_Remove");
      accept_Alert(webDriver, 10);
      generic_file_Upld(webDriver);
      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);

      finalSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 56).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Businesss_Name_Link");
      click_Element(webDriver, "Application_Common_Submit_Button_Id");
      click_Element(webDriver, "Application_Common_Save_Notes_Id");
      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "SBA_Review_Return_For_Mod");
      click_Element(webDriver, "SBA_Review_Determination_Save_Button");
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");
      navigationBarClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 41).Login_With_Reference();

      /* Return Again */
      click_On_App_In_Vend_Dash(webDriver, "MPP");
      click_Element(webDriver, "Sba_App_Remove");
      accept_Alert(webDriver, 10);
      generic_file_Upld(webDriver);
      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      finalSignatureSubmit(webDriver);

      navigationMenuClick(webDriver, "LOGOUT");
      new LoginPageWithReference(webDriver, 56).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      click_Element(webDriver, "SBA_Legal_Businesss_Name_Link");
      click_Element(webDriver, "Application_Common_Submit_Button_Id");
      click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      click_Element(webDriver, "SBA_Review_Determ_Made");
      new Select(find_Element(webDriver, "Analyst_Review_Determ_Decision")).selectByIndex(0);

      if (stop_Exec == 1) {
        return;
      } /* TODO Hard Code Duns No Remove */

      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Status: Ineligible"));
      assertTrue(
          find_Element(webDriver, "SBA_Review_Nav").getText().contains("Decision: SBA Declined"));
      navigationBarClick(webDriver, "LOGOUT");

    } catch (Exception e) {
      logger.info("Search TextBox is on Main Navigator is not present" + e.toString());
      take_ScreenShot_TestCaseName(webDriver, new String[] {"TestWorkflowMPP05", "Exception"});
      throw e;

    }
  }


  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}


