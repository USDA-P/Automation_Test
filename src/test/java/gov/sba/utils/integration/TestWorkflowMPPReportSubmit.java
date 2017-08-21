/* TS Created by Deepa Patri */
package gov.sba.utils.integration;

/*
 * Documentation for Workflow WorkFlows for MPP - Accommodating best minimal Workflow Tests
 * TestWorkflowMPPReportReturn Vendor admin create MPP application ,approved by supervisor submit
 * Mpp annual report Mpp analyst gets Submitted the MPP annual report ..
 */

import gov.sba.automation.DatabaseUtils;
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

import java.util.Map;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.click_On_App_In_Vend_Dash;
import static gov.sba.pageObjetcs.VendorDashboardPage.verify_Row_In_A_Table_And_Return;
import static gov.sba.utils.integration.FillApplCreatePages.*;


@Category({StableTests.class})
public class TestWorkflowMPPReportSubmit extends TestCase {
  Logger logger =
      LogManager.getLogger(gov.sba.utils.integration.TestWorkflowMPPReportSubmit.class.getName());
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
  public void testWorkflowMPPReportSubmit() throws Exception {
    try {
      /*
       * App-!279,App-1219 return_All_Applications(webDriver, 56, duns_Number);
       * delete_All_Application_Draft(webDriver, email, password, duns_Number);
       */
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      join_New_Program_CheckBoxes(webDriver, "MPP");
      page8aFillUpDunsNo(webDriver, "Yes", duns_Number);
      finalSignatureSubmit(webDriver);
      assertNotNull(verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "", "Pending", "", "", "", ""}));
      navigationMenuClick(webDriver, "LOGOUT");
      /* Supervisor make Determination SBA Approve */
      new LoginPageWithReference(webDriver, 56).Login_With_Reference();
      search_Cases_Duns_Number_Table(webDriver, duns_Number);
      String get_Business_Name = find_Element(webDriver, "SBA_Legal_Business_Name_Link").getText();
      click_Element(webDriver, "SBA_Legal_Business_Name_Link");
      /* case Overview Page */
      verify_Text(webDriver, "Case_CaseOverview_title", "Case Overview");
      click_Element(webDriver, "Case_Submit_Button");
      //double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();
      /* Determination SBA Approved */
      click_Element(webDriver, "SBA_Review_Determ_Made");
      assertNotNull(find_Element(webDriver, "Analyst_Review_Determ_Decision", true));
      new Select(find_Element(webDriver, "Analyst_Review_Determ_Decision")).selectByIndex(1);
      click_Element(webDriver, "Application_Common_Submit_Button");
      click_Element(webDriver, "SBA_Analyst_Review_Vendor_Overview");
      navigationBarClick(webDriver, "LOGOUT");
      /* Make changes in Database - next-annual-report-date to current date */
      String sql_Q_01 =
          "update sbaone.certificates set next_annual_report_date = CURRENT_TIMESTAMP where organization_id = (select id from sbaone.organizations where type = 'Certificate::Mpp' and duns_number = '"
              + duns_Number + "')";
      new DatabaseUtils().executeSQLScript(sql_Q_01);

      /* Log in to vendor admin account */
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      /* For demo - used sleep -will remove sleep after demo */
      assertNotNull(verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "", "Active", "", "", "", "New Annual Report"}));
      click_On_App_In_Vend_Dash(webDriver, "mppreport");
      click_Element(webDriver, "Application_Common_Accept_Button");
      generic_file_Upld(webDriver);
      accept_Alert(webDriver, 10);
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      Thread.sleep(500);
      mppReportSignatureSubmit(webDriver);
      navigationMenuClick(webDriver, "LOGOUT");
      /* Log in as MPP analyst verify the MPP annual report */
      new LoginPageWithReference(webDriver, 29).Login_With_Reference();
      click_Element(webDriver, "SBA_Analyst_Annual_Report_Link");
      String xpath_Business_Name_Report =
          "//a [ contains (@href, 'annual_reports') and contains( text(), 'replace_Value' ) ]"
              .replace("replace_Value", get_Business_Name);
      click_Element(webDriver, "xpath", xpath_Business_Name_Report);
      /* Submitted Mpp Annual report below assertions */
      find_Element(webDriver, "SBA_MPP_Report_Approve");
      find_Element(webDriver, "SBA_MPP_Report_Decline");
      find_Element(webDriver, "SBA_MPP_Report_Return");
      /* Verify the status as approved after Mpp Report is return by the MPP ana;yst */
      /* Verify on the Vendor dashbaord page -App-1279 */
      navigationBarClick(webDriver, "Cases");
      Map locator = getLocator("Cases_Page_Search_Duns_Link");
      String loc = locator.get("Locator").toString();
      String val = locator.get("Value").toString().replace("duns_Number_Replace", duns_Number);
      click_Element(webDriver, loc, val);
      assertNotNull(verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"MPP Application", "Annual Report", "", "", "", "", ""}));

      /* For Demo on -7-21 */

    } catch (Exception e) {
      logger.info("Search TextBox is on Main Navigator is not present" + e.toString());
      take_ScreenShot_TestCaseName(webDriver,
          new String[] {"TestWorkflowMPPReportSubmit", "Exception"});
      throw e;

    }
  }


  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}

