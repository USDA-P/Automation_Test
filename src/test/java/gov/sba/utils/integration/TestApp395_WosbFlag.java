//TS Created By _deepa patri
package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import gov.sba.automation.utils.CommonApplicationMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import junit.framework.TestCase;
@Category({ gov.sba.utils.integration.StableTests.class })
public class TestApp395_WosbFlag extends TestCase {

//Get the questions names for which Prepopulate flag set to true
//Start create New Wosb/Edwosb application
//Check the Answers are prepopulating with previous answers.
private static WebDriver webDriver;
private static final Logger logger_TestApp395 = LogManager.getLogger(TestApp395_WosbFlag.class.getName());
 String duns_Number, email, password;
 int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    CommonApplicationMethods.clear_Env_Chrome();
    webDriver = TestHelpers.getDefaultWebDriver();
    webDriver.get(TestHelpers.getBaseUrl());
    CommonApplicationMethods.focus_window();
    get_The_Row_From_Login_Data = 10;

  }
  @Test

  public void testMainTest() throws Exception {
    // Login to dashboard.
    try {
      // Check Dashboard Pending status
    LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data.Login_With_Reference();

      //Return the Applicatiom;
      if (CommonApplicationMethods.checkApplicationExists(webDriver, "WOSB", "Active"))
       { CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
         CommonApplicationMethods.return_all_Applications(webDriver, 11, "159165917");
         login_Data = new LoginPageWithReference(webDriver, 10);
         login_Data.Login_With_Reference();
       }
      CommonApplicationMethods.deleteApplication(webDriver, "Edwosb", "Draft");
      CommonApplicationMethods.deleteApplication( webDriver, "Wosb", "Draft");

      //start New WOSB Applicatiom
      CommonApplicationMethods.navigationMenuClick(webDriver, "Programs");
      CommonApplicationMethods.createApplication(webDriver,"WOSB");
      NewLLCQuestionanireDeepa NewLLCQuestionanireDeepa = new NewLLCQuestionanireDeepa();
      NewLLCQuestionanireDeepa.NewLLCQuestionanireDeepa(webDriver);
      fillApplCreatePages.finalSignatureSubmit(webDriver);

      //Return the Applicatiom;
       CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
       CommonApplicationMethods.return_all_Applications(webDriver, 11, "159165917");
      //Delete All the Draft Applications
      login_Data = new LoginPageWithReference(webDriver, 10);
      login_Data.Login_With_Reference();
      CommonApplicationMethods.deleteApplication(webDriver, "wosb", "Draft");

      //start New WOSB Applicatiom again - to check the prepopulation
      CommonApplicationMethods.navigationMenuClick(webDriver, "Programs");
      CommonApplicationMethods.createApplication(webDriver, "WOSB");

      String checkBoxElement = webDriver.findElement(By.id("answers_188_value_no")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      CommonApplicationMethods.click_Element(webDriver, "WOSB_Questionnaire_Page_Ans_188_N");
      CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");
      logger_TestApp395.info(" 8(a) question assert not being prepopulated");

      checkBoxElement = webDriver.findElement(By.id("answers_189_value_no")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      CommonApplicationMethods.click_Element(webDriver, "WOSB_Questionnaire_Page_Ans_189_Y");
      String file_path_abs = FixtureUtils.fixturesDir() + "Upload.pdf";
      fillApplCreatePages.page8aFillUp(webDriver, "Yes", file_path_abs);
      CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");

      checkBoxElement = webDriver.findElement(By.id("answers_190_value_yes")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      CommonApplicationMethods.click_Element(webDriver, "WOSB_Questionnaire_Page_Ans_190_Y");
      CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_201_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_202_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

   CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_203_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_204_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_205_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_206_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_207_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));
      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_208_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));
      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_209_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));
      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_210_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_211_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));

      assertTrue(CommonApplicationMethods.find_Element(webDriver,"WOSB_Questionnaire_Page_Ans_212_N" ).getAttribute("outerHTML").toLowerCase().contains("checked"));


   CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");

   checkBoxElement = webDriver.findElement(By.id("answers_213_value_no")).getAttribute("outerHTML");
    assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      CommonApplicationMethods.click_Element(webDriver, "WOSB_Questionnaire_Page_Ans_213_N");
      CommonApplicationMethods.click_Element(webDriver, "Application_Common_Submit_Button");

     //Review Section
      CommonApplicationMethods.click_Element(webDriver, "Application_Common_Submit_Button");
      CommonApplicationMethods.accept_Optional_Alert(webDriver);
    fillApplCreatePages.finalSignatureSubmit(webDriver);
    //Check if the Active certificate is exist-Then Return by analyst
      CommonApplicationMethods.checkApplicationExists(webDriver,"wosb","Active");
      CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
      CommonApplicationMethods.return_all_Applications(webDriver, 11, "159165917");
    } catch (Exception e) {
      logger_TestApp395.info(e.toString());
      CommonApplicationMethods.take_ScreenShot_TestCaseName(webDriver, new String[]{"TestApp395_WosbFlag", "Exception"});
      throw new Exception("Error: ", e);
    }
  }

  @After
  public void tearDown() throws Exception {
     webDriver.quit();
  }
}
