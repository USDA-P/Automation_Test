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

import static gov.sba.automation.AssertionUtils.delete_All_Application_Draft;
import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.pageObjetcs.MasterApplication8a.*;
import static gov.sba.pageObjetcs.ProgramsPage.contributor_login;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;
import static gov.sba.pageObjetcs.VendorDashboardPage.click_On_App_In_Vend_Dash;

/*
 * Documentation for Workflow WorkFlows for 8a Initial program - Accommodating best minimal Workflow Tests
 * TestWorkflow8aInital SelectingNoAllSections---Vendor Create 8a Initial Program: select no to all questionnaires on all sub sections +
 * With  Vendor admin sub application and 8a disadvantage individual sub application in Contributor section.
 * login with SBA 8a Cod supervisor and verify the newly submitted cases in Unassigned table and assign to BOS Analyst.
 */
// Still in progress
@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkflow8aInitalSelectingNoAllSections extends TestCase {
    // Set The variabl.es/Define
    Logger logger = LogManager.getLogger(TestWorkflow8aInitalSelectingNoAllSections.class.getName());
    private static WebDriver webDriver;
    int get_The_Row_From_Login_Data;
    String duns_Number, email, password;
    @Before public void setUp() throws Exception {
        if (get_Stop_Execution_Flag()) return;
        clear_Env_Chrome();
        logger.info("Set as head");
        TestHelpers.set_Headless();
        webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
        webDriver.get(TestHelpers.getBaseUrl());
        get_The_Row_From_Login_Data =43;
       /* String[] details = findUnusedDunsNumber("");
        email = details[0];
        password = details[1];
        duns_Number = details[2];
       */
    }

    @Test public void testMainTest() throws Exception {
        try {

            /*return_All_Applications(webDriver, 11, "165324125");144754156*/
            /*delete_All_Application_Draft(webDriver, email, password, duns_Number);*/
            /*Login to Dashboard.*/
            delete_All_Application_Draft(webDriver, get_The_Row_From_Login_Data, "165324125");
            new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data).Login_With_Reference();

          /*  new LoginPageWithDetails(webDriver, email, password).Login_With_Details(); */

            webDriver.navigate().to("https://certify.qa.sba-one.net/questionnaires/eight_a_initial/sba_applications/new?application_type_id=initial&certificate_type_id=eight_a_initial");
            click_Element(webDriver, "Application_Common_Accept_Button");
            /*asterApp_8a_Page_Click(webDriver,"page_basiceligibility");*/
         /*   Basic Eligibility Page selecting all no  */
            BasicEligiblity_General_Assessment_Page(webDriver, "no", "no", "no", "no", "no");
            BasicEligiblity_Prior_8a_Involvement_Page(webDriver, "no", "no", "no");
            BasicEligiblity_Outside_Assistance_Page(webDriver, "no");
            BasicEligiblity_Business_Size_Page(webDriver, "no", "no");
            Thread.sleep(5000);
            click_Element(webDriver, "Application_Common_Submit_Button");
            accept_Alert(webDriver, 8);
            /*BasicEligiblity_Size_Determination_Page(webDriver);*/
           /* Basic ownership Page selecting all no  */
            masterApp_8a_Page_Click(webDriver,"page_business_ownership");
            Business_Ownership_Entity_Ownership_Page(webDriver,"no");
            Business_Ownership_Ownership_Details_Page(webDriver,"no","no","no","no");
            generic_file_Upld(webDriver);
            /*Business_Ownership_Corporations_Page(webDriver);*/
            click_Element(webDriver,"Application_Common_Submit_Button");
            accept_Alert(webDriver, 10);
          /* Character Page selecting all no */
            masterApp_8a_Page_Click(webDriver,"page_character_link");
            character_Page(webDriver,"no","no","no","no");
            click_Element(webDriver,"Application_Common_Submit_Button");
            accept_Alert(webDriver, 10);
            /*Potential for success page selectinh all no */
            masterApp_8a_Page_Click(webDriver,"page_potential_for_Success_link");
            generic_file_Upld(webDriver);
            click_Element(webDriver,"Application_Common_Submit_Button");
            potential_For_Sucess_Revenue_Page(webDriver, "no", "no", "5", "Yes - Add it");
            potential_For_Sucess_Page_Sucesss(webDriver, "no", "no", "no");
            potential_For_Sucess_Page_Review(webDriver);
            masterApp_8a_Page_Click(webDriver, "page_control_link");
            control_Page_Firm_Control(webDriver, "no","no","no","no","no","no");
             /* control_Page_Leased_Facility(webDriver, "yes");*/
            firm_Control_Page_Review(webDriver);
           /*Contributor Page- Vendor Admin Sub application  */
            masterApp_8a_Page_Click(webDriver, "page_contributors_Start_Indv_Cont");
            contributorsubApp_8aDisAdvInd(webDriver);
           /*TO Do :: Contributor Page- 8a DisAdvantaged Individual Sub application*/
            masterApp_8a_Page_Click(webDriver, "page_contributors");
            Contributor_Page(webDriver, "8a_disadvind_contributor");
            contributor_login(webDriver, "norole10", "norole10@mailinator.com");
            navigationMenuClick(webDriver,"LOGOUT");
            click_Element(webDriver, "SBA_Login_Button");
            setText_Element(webDriver, "SBA_Login_Email", "norole10@mailinator.com");
            setText_Element(webDriver, "SBA_Login_Pwd", "password");
            click_Element(webDriver, "SBA_Login_Sign_in");
            click_Element(webDriver, "Application_Common_Accept_Button");
            contributorsubApp_8aDisAdvInd(webDriver);
            navigationMenuClick(webDriver,"LOGOUT");
            /*TO Do :: Contributor Page- 8a Spouse Sub application*/
            new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data).Login_With_Reference();
            click_On_App_In_Vend_Dash(webDriver, "8aInitial");
            masterApp_8a_Page_Click(webDriver, "page_contributors");
            Contributor_Page(webDriver, "8a_addspouse_contributor");
            contributor_login(webDriver, "norole2", "norole2@mailinator.com");
            navigationMenuClick(webDriver,"LOGOUT");
            click_Element(webDriver, "SBA_Login_Button");
            setText_Element(webDriver, "SBA_Login_Email", "norole2@mailinator.com");
            setText_Element(webDriver, "SBA_Login_Pwd", "password");
            click_Element(webDriver, "SBA_Login_Sign_in");
            click_Element(webDriver, "Application_Common_Accept_Button");
            contributorsubApp_8aSpouse(webDriver);

           /* navigationMenuClick(webDriver,"LOGOUT");*/

           /* Create new Contributor user to submit their individual sub application*/
             /*navigationMenuClick(webDriver,"LOGOUT");*/
             /*Create New Vendor*/
            /* String Email = "Deepa.test." + get_currentTimestamp() +"@mailinator.com";
             createVendorUser(webDriver,"Deepa","test1", Email,"Deepa.test2@mailinator.com");*/
            /*Activate the Account*/
            /* activateEmail(TestHelpers.getDefaultWebDriver(), Email);
             webDriver.get(TestHelpers.getBaseUrl());
             click_Element(webDriver, "SBA_Login_Button");
             setText_Element(webDriver, "SBA_Login_Email", "deepa.parternship@mailinator.com");
             setText_Element(webDriver, "SBA_Login_Pwd", "password");
             click_Element(webDriver, "SBA_Login_Sign_in");
             */
          /* Log in back ith vendor admin and click on 8a Inital Progam draft application and click on contributor section */
           /* click_On_App_In_Vend_Dash(webDriver, "8aInitial");
            Contributor_Page(webDriver, "8a_disadvind_contributor");
            contributor_login(webDriver, "Deepa", Email);*/
                   /* To complete 8a Master Application.*/
                    /*master8aApp_final_ReviewSign(webDriver);
                    navigationMenuClick(webDriver, "DASHBOARD");
                    List<WebElement> all_Cells = verify_Row_In_A_Table_And_Return(webDriver,
                        new String[] {"8(a) Initial Application", "", "Pending", "", "", "", ""});
                    assertNotNull(all_Cells);
                    /*For Demo Start - July 6*/
                   /* Thread.sleep(4000);
                    navigationMenuClick(webDriver, "Logout");
                    webDriver.get(TestHelpers.getBaseUrl());
                    click_Element(webDriver, "SBA_Login_Button");
                    setText_Element(webDriver, "SBA_Login_Email", "sba_supervisor_8a_cods_5@mailinator.com");
                    setText_Element(webDriver, "SBA_Login_Pwd", "password");
                    click_Element(webDriver, "SBA_Login_Sign_in");
            */
            /*For Demo End - July 6*/
            /*Contributor_Page(webDriver, "8a_AddSpouse_contributor");
            ProgramsPage.contributor_login(webDriver, "norole10", "norole10@mailinator.com");
            Contributor_Page(webDriver, "8a_AddSpouse_contributor");
            ProgramsPage.contributor_login(webDriver, "norole11", "norole11@mailinator.com");*/


        } catch (Exception e) {
            logger.info(e.toString());
            take_ScreenShot_TestCaseName(webDriver, new String[]{"TestWorkflowMPP05", "Exception"});
            throw e;
        }
    }

    @After public void tearDown() throws Exception {
        // webDriver.quit();
    }
}


