// TS_Created_By_Deepa_Patri
package gov.sba.utils.integration;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.Contributor8aDisadvantagedIndAppPage.*;
import static gov.sba.pageObjetcs.MasterApplication8a.*;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.verify_Row_In_A_Table_And_Return;

/*
 * Documentation for Workflow WorkFlows for 8a Initial program - Accommodating best minimal Workflow
 * Tests TestWorkFlow8aInitialWithOnlyVendorSubApp---Vendor Create 8a Initial Program: select yes to
 * all questionnaires on all sub sections + With Vendor admin sub application only in Contributor
 * section. login with SBA 8a Cod supervisor and verify the newly submitted cases in Unassigned
 * table and assign to BOS Analyst.
 */
// Still in progress
@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkFlow8aInitialWithOnlyVendorSubApp {
  // Set The variabl.es/Define
  Logger logger = LogManager.getLogger(TestWorkFlow8aInitialWithOnlyVendorSubApp.class.getName());
  private static WebDriver webDriver;
  /* int get_The_Row_From_Login_Data; */
  String duns_Number, email, password;

  @Before
  public void setUp() throws Exception {
    if (get_Stop_Execution_Flag())
      return;
    clear_Env_Chrome();
    //logger.info("Set as head");
    TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    String[] details = findUnusedDunsNumber("");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
  }

  @Test
  public void testWorkFlow8aInitialWithOnlyVendorSubApp() throws Exception {
    try {

      /* return_All_Applications(webDriver, 11, "165324125"); */
      /* delete_All_Application_Draft(webDriver, email, password, duns_Number); */
      /* Login to Dashboard. */
      /* delete_All_Application_Draft(webDriver, get_The_Row_From_Login_Data, "165324125"); */
      /*
       * new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data) .Login_With_Reference();
       */
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      //navigationMenuClick(webDriver, "logout");
      /* new programs_Page().select_MyCertifications_Table(webDriver, "Delete_8a_Initial_Draft"); */
      //webDriver.navigate().to("https://certify.qa.sba-one.net/questionnaires/eight_a_initial/sba_applications/new?application_type_id=initial&certificate_type_id=eight_a_initial");
      join_New_Program_CheckBoxes(webDriver, "8A");
            /* masterApp_8a_Page_Click(webDriver,"page_basiceligibility"); */
      /* Basic Eligibility Page */
      BasicEligiblity_General_Assessment_Page(webDriver, "Yes", "no", "Yes", "Yes", "Yes");
      BasicEligiblity_Prior_8a_Involvement_Page(webDriver, "no", "Yes", "Yes");
      BasicEligiblity_Outside_Assistance_Page(webDriver, "Yes");
      BasicEligiblity_Business_Size_Page(webDriver, "Yes", "Yes");
      BasicEligiblity_Size_Determination_Page(webDriver);
      /* Basic ownership Page */
      /* logger.info(webDriver.getPageSource()); */

      masterApp_8a_Page_Click(webDriver, "page_business_ownership");
      Business_Ownership_Entity_Ownership_Page(webDriver, "yes");
      Business_Ownership_Ownership_Details_Page(webDriver, "yes", "no", "no", "no");
      Business_Ownership_Corporations_Page(webDriver);
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      /* Character Page */
      masterApp_8a_Page_Click(webDriver, "page_character_link");
      character_Page(webDriver, "yes", "no", "no", "no");
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      /* Potential for success page */
      masterApp_8a_Page_Click(webDriver, "page_potential_for_Success_link");
      generic_file_Upld(webDriver);
      click_Element(webDriver, "Application_Common_Submit_Button");
      potential_For_Sucess_Revenue_Page(webDriver, "Yes", "Yes", "5", "Yes - Add it");
      potential_For_Sucess_Page_Sucesss(webDriver, "No", "No", "na");
      potential_For_Sucess_Page_Review(webDriver);
      masterApp_8a_Page_Click(webDriver, "page_control_link");
      control_Page_Firm_Control(webDriver, "no", "no", "no", "na", "no", "yes");
      control_Page_Leased_Facility(webDriver, "yes");
      firm_Control_Page_Review(webDriver);
      /* Contributor Page- Vendor Admin Sub application */
      masterApp_8a_Page_Click(webDriver, "page_contributors_Start_Indv_Cont");
      disAdvApp_Gender_Info_Page(webDriver, "Male");
      disAdvApp_MaritalStatus_Page(webDriver, "Married");
      disAdvApp_SocialSecNum_Page(webDriver, "12345678");
      disAdvApp_ContactInfo_Page(webDriver, "12345678");
      disAdvApp_CuurentHomeAddress_Page(webDriver, "mclean", "mclean", "AL", "10002", "US",
          "01/01/2019");
      disAdvApp_LengthofResidency_Page(webDriver, "yes");
      disAdvApp_DateandPlaceofBirth_Page(webDriver, "01/01/2019", "Mclean", "India");
      disAdvApp_Us_Citizenship_Page(webDriver, "yes");
      generic_file_Upld(webDriver);
      click_Element(webDriver, "Application_Common_Continue_Button");
      /* disAdvApp_UploadResume_Page(webDriver); */
      disAdvApp_Appl_Firm_Ownership_Page(webDriver, "80", "Anything");
      disAdvApp_Bank_Acct_Access_Page(webDriver, "yes", "Anything");
      disAdvApp_Full_Time_Devotion_Page(webDriver, "yes");
      disAdvApp_Business_Affiliations_Page(webDriver, "yes", "yes", "something To Test");
      disAdvApp_8a_Prior_Involvement_Page(webDriver, "yes", "yes", "yes");
      disAdvApp_8a_Federal_Employment_Page(webDriver, "yes");
      disAdvApp_8a_Household_Federal_Employment_Page(webDriver, "yes");
      disAdvApp_8a_Financial_Page(webDriver, "yes", "yes", "yes", "yes");
      disAdvApp_8a_Criminal_History_Page(webDriver, "yes", "Anything", "yes", "yes", "yes");
      disAdvApp_criminal_Hist_Doc_Page(webDriver);
      disAdvApp_Basic_Of_Disadvantage_Page(webDriver, "Black American", "Anything");
      disAdvApp_Social_Narrative_Page(webDriver);
      disAdvApp_Transfer_Assets_Page(webDriver, "Yes", "Anything");
      disAdvApp_Tax_Returns_Page(webDriver);
      disAdvApp_financial_CashOnHand_Page(webDriver, "01/01/2019", "111", "111", "111");
      disAdvApp_financial_OtherSource_Page(webDriver, "111", "111", "Anything", "111", "111");
      disAdvApp_financial_Notes_Receivable_Page(webDriver, "Yes");
      disAdvApp_financial_Retirement_Account_Page(webDriver, "Yes", "Yes");
      disAdvApp_financial_Life_Insurance_Page(webDriver, "Yes", "Yes");
      disAdvApp_financial_StocksAndBonds_Page(webDriver, "Yes");
      disAdvApp_financial_RealEstate_Page(webDriver, "Yes", "Yes", "Yes", "Yes", "Yes", "Yes");
      disAdvApp_financial_RealEstateOther_Page(webDriver, "Yes", "Yes", "Yes", "Yes", "Yes", "Yes");
      disAdvApp_financial_Personal_Property_Page(webDriver, "Yes", "Yes");
      disAdvApp_financial_NotesPayableandOther_Page(webDriver, "Yes");
      disAdvApp_financial_Assessed_Taxes_Page(webDriver, "Yes");
      // Personal summary Report
      disAdvApp_financial_PersonalSummary_Page(webDriver);
      disAdvApp_financial_PrivacyStatements_Page(webDriver);
      disAdvApp_financial_Review_Page(webDriver);
      disAdvApp_Signature_Page(webDriver);
      /* To complete 8a Master Application. */
      master8aApp_final_ReviewSign(webDriver);
      navigationMenuClick(webDriver, "DASHBOARD");
      List<WebElement> all_Cells = verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"8(a) Initial Application", "", "Pending", "", "", "", ""});
      Assert.assertNotNull(all_Cells);
      /* For Demo Start - July 6 */
     navigationMenuClick(webDriver, "LOGOUT");
      //navigationBarClick(webDriver, "LOGOUT");
      webDriver.get(TestHelpers.getBaseUrl());
      click_Element(webDriver, "SBA_Login_Button");
      setText_Element(webDriver, "SBA_Login_Email", "sba_supervisor_8a_cods_5@mailinator.com");
      setText_Element(webDriver, "SBA_Login_Pwd", "password");
      click_Element(webDriver, "SBA_Login_Sign_in");
      /* For Demo End - July 6 */
    } catch (Exception e) {
      logger.info(e.toString());
      take_ScreenShot_TestCaseName(webDriver, new String[] {"testWorkFlow8aInitialWithOnlyVendorSubApp", "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    //webDriver.quit();
  }
}


