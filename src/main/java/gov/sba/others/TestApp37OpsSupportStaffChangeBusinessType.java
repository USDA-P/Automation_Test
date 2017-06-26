// TS_Created_By_Deepa_Patri
package gov.sba.others;

import static gov.sba.automation.CommonApplicationMethods.click_Element;
import static gov.sba.automation.CommonApplicationMethods.find_Element;
import static gov.sba.automation.CommonApplicationMethods.navigationBarClick;
import static gov.sba.automation.CommonApplicationMethods.navigationMenuClick;
import static gov.sba.automation.CommonApplicationMethods.non_Vendor_searchDuns_Number;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import gov.sba.automation.CommonApplicationMethods;
import gov.sba.automation.DatabaseUtils;
import gov.sba.automation.TestHelpers;
import gov.sba.utils.integration.LoginPageWithDetails;
import gov.sba.utils.integration.LoginPageWithReference;
import gov.sba.utils.integration.NewScorpQuestionPageDeepa;
import junit.framework.TestCase;

@Ignore
@Category({gov.sba.utils.integration.StableTests.class})

public class TestApp37OpsSupportStaffChangeBusinessType extends TestCase {
  private static final Logger logger_37OpsSpStfCh =
      LogManager.getLogger(TestApp37OpsSupportStaffChangeBusinessType.class.getName());
  // Set The variabl.es/Define
  WebDriver webDriver;
  String duns_Number, email, password;

  @Before
  public void setUp() throws Exception {
    CommonApplicationMethods.get_Stop_Execution_Flag();
    CommonApplicationMethods.clear_Env_Chrome();
    webDriver = TestHelpers.getDefaultWebDriver();
    webDriver.get(TestHelpers.getBaseUrl());
    // CommonApplicationMethods.focus_window();
    String[] details = DatabaseUtils.findUnusedDunsNumber();
    email = details[0];
    password = details[1];
    duns_Number = details[2];
  }

  @Test
  public void testMainTest() throws Exception {

    new LoginPageWithReference(webDriver, 27).Login_With_Reference();

    try {

      non_Vendor_searchDuns_Number(webDriver, duns_Number);
      click_Element(webDriver, "Ops_Support_Cases_Search_Results_First");
      click_Element(webDriver, "Ops_Support_Cases_Search_Vendor_Supp_Link");
      click_Element(webDriver, "Ops_Support_Change_Business_Link");
      new Select(find_Element(webDriver, "Ops_Support_Change_Business_Type")).selectByIndex(2);
      click_Element(webDriver, "Application_Common_Save_button");
      navigationBarClick(webDriver, "Logout");

      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();

      // Verify the Business type is changes to Scorp[from LLC]
      click_Element(webDriver, "Vendor_Admin_Dashboard_More_Details");

      assertTrue(find_Element(webDriver, "Vendor_Admin_Dashboard_More_Details_Id").getText()
          .contains("S-Corporation"));

      // programs_Page.join_New_Program_CheckBoxes(webDriver, "EDWOSB");
      navigationMenuClick(webDriver, "Programs");
      click_Element(webDriver, "JoinNewPgm_Create_App_EDWOSB");
      click_Element(webDriver, "JoinNewPgm_Add_Cert");
      click_Element(webDriver, "Application_Common_Accept_Button");

      new NewScorpQuestionPageDeepa(webDriver).NewScorpQuestionPageDeepa();

    } catch (Exception e) {
      logger_37OpsSpStfCh.info(e.toString());
      CommonApplicationMethods.take_ScreenShot_TestCaseName(webDriver,
          new String[] {"TestApp37OpsSupportStaffChangeBusinessType", "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}