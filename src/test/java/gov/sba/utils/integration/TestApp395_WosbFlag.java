package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xslf.model.geom.IfElseExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import junit.framework.TestCase;

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
    get_The_Row_From_Login_Data = 9;

  }
  @Test

  public void testMainTest() throws Exception {
    // Login to dashboard.
    try {
      // Check Dashboard Pending status
    LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
      Thread.sleep(2000);
      //Return the Applicatiom;
      if (CommonApplicationMethods.checkApplicationExists(webDriver, "EDWOSB", "Active"))
       { CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
         CommonApplicationMethods.return_all_Applications(webDriver, 11, "148832876");
         login_Data = new LoginPageWithReference(webDriver, 9);
         login_Data.Login_With_Reference();
       }
      CommonApplicationMethods.deleteApplication(webDriver, "Edwosb", "Draft");
      CommonApplicationMethods.deleteApplication( webDriver, "Wosb", "Draft");

      //start New Applicatiom

      CommonApplicationMethods.navigationMenuClick(webDriver, "Programs");
      webDriver.findElement(By.id("certificate_type_edwosb")).click();
      webDriver.findElement(By.id("add_certification")).click();
      webDriver.findElement(By.className("accept_button")).click();
      NewScorpQuestionPage scorpQuestionsPage = new NewScorpQuestionPage(webDriver);
      scorpQuestionsPage.NewScorpQuestion();
      NewFinancialSectionQuestion financialsection = new NewFinancialSectionQuestion(webDriver);
      financialsection.NewFinancialQuestion();
      fillApplCreatePages.finalSignatureSubmit(webDriver);

      //Return the Applicatiom;
     // CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
     // CommonApplicationMethods.return_all_Applications(webDriver, 11, "148832876");
      //Delete All the Draft Applications
     // CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
     // login_Data = new LoginPageWithReference(webDriver, 9);
     // login_Data.Login_With_Reference();
     // CommonApplicationMethods.deleteApplication(webDriver, "Edwosb", "Draft");

      //start New WOSB Applicatiom again - to check the prepopulation
      CommonApplicationMethods.navigationMenuClick(webDriver, "Programs");
      webDriver.findElement(By.id("certificate_type_wosb")).click();
      webDriver.findElement(By.id("add_certification")).click();
      webDriver.findElement(By.className("accept_button")).click();
      String checkBoxElement = webDriver.findElement(By.id("answers_169_value_no")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      Thread.sleep(2000);
      webDriver.findElement(By.id("answers_169_value_no")).click();
      webDriver.findElement(By.name("commit")).click();
      logger_TestApp395.info("  8(a) question has been answered");
      Thread.sleep(2000);
      checkBoxElement = webDriver.findElement(By.id("answers_170_value_no")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      Thread.sleep(2000);
      webDriver.findElement(By.id("answers_170_value_yes")).click();
      String file_path_abs = FixtureUtils.fixturesDir() + "Upload.pdf";
      fillApplCreatePages.page8aFillUp(webDriver, "Yes", file_path_abs);
      webDriver.findElement(By.name("commit")).click();
      Thread.sleep(2000);

      checkBoxElement = webDriver.findElement(By.id("answers_171_value_yes")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      webDriver.findElement(By.id("answers_171_value_yes")).click();
      webDriver.findElement(By.name("commit")).click();
      Thread.sleep(2000);

      checkBoxElement = webDriver.findElement(By.id("answers_173_value_yes")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_173_value_yes")).click();
      //webDriver.findElement(By.name("commit")).click();
      Thread.sleep(2000);

      checkBoxElement = webDriver.findElement(By.id("answers_174_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_174_value_yes")).click();
      //webDriver.findElement(By.name("commit")).click();
      Thread.sleep(2000);

      checkBoxElement = webDriver.findElement(By.id("answers_175_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_175_value_yes")).click();
      Thread.sleep(2000);

      checkBoxElement = webDriver.findElement(By.id("answers_176_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
     // webDriver.findElement(By.id("answers_176_value_yes")).click();

      checkBoxElement = webDriver.findElement(By.id("answers_177_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_177_value_yes")).click();

      checkBoxElement = webDriver.findElement(By.id("answers_178_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_178_value_yes")).click();

      checkBoxElement = webDriver.findElement(By.id("answers_179_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_179_value_yes")).click();

      webDriver.findElement(By.name("commit")).click();

      checkBoxElement = webDriver.findElement(By.id("answers_184_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
     // webDriver.findElement(By.id("answers_184_value_no")).click();

      webDriver.findElement(By.name("commit")).click();

      checkBoxElement = webDriver.findElement(By.id("answers_185_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_185_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_186_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_186_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_187_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_187_value_no")).click();

      webDriver.findElement(By.name("commit")).click();

      checkBoxElement = webDriver.findElement(By.id("answers_188_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_188_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_189_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_189_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_190_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_190_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_191_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      //webDriver.findElement(By.id("answers_191_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_192_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      webDriver.findElement(By.id("answers_192_value_no")).click();
      checkBoxElement = webDriver.findElement(By.id("answers_193_value_no")).getAttribute("outerHTML");
      assertTrue(checkBoxElement.toLowerCase().contains("checked"));
      webDriver.findElement(By.id("answers_193_value_no")).click();
      webDriver.findElement(By.name("commit")).click();


      checkBoxElement = webDriver.findElement(By.id("answers_194_value_no")).getAttribute("outerHTML");
      assertFalse(checkBoxElement.toLowerCase().contains("checked"));
      webDriver.findElement(By.id("answers_194_value_no")).click();
      webDriver.findElement(By.name("commit")).click();

      //Check if the Active certificate is exist-Then Return by analyst
      CommonApplicationMethods.checkApplicationExists(webDriver,"Edwosb","Active");
      CommonApplicationMethods.navigationMenuClick(webDriver,"LOGOUT");
      CommonApplicationMethods.return_all_Applications(webDriver, 11, "148832876");
    } catch (Exception e) {
      logger_TestApp395.info(e.toString());
      throw new Exception("Error: ", e);
    }
  }

  @After
  public void tearDown() throws Exception {
     webDriver.quit();
  }
}