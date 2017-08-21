// @Montana
package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

@Category({gov.sba.utils.integration.UnstableTests.class})

public class TestElasticSearchForAnalyst extends TestCase {

  private static final Logger logger =
      LogManager.getLogger(TestElasticSearchForAnalyst.class.getName());
  private static WebDriver webDriver;
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    webDriver = TestHelpers.getDefaultWebDriver();

    webDriver.get(TestHelpers.getBaseUrl());
    webDriver.manage().window().maximize();
    get_The_Row_From_Login_Data = 0;
  }

  @Test
  public void testElasticSearchForAnalyst() throws Exception {
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    // try{
    String Actual_Text;
    String Expected_Text;
	JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    logger.info("Apply Analyst permissions to All Cases page, Elastic Search");
    // Login to dashboard.
    LoginPageWithReference login_Data =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    // TestWorkFlowxx8aInProgress to start a new certification.
    DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
    deleteDraftCert.DeleteDraftCert();
    // webDriver.navigate().to("https://certify.qa.sba-one.net/sba_analyst/cases/all_cases/");
    // webDriver.navigate().to("http://localhost/sba_analyst/cases/all_cases/");
    // Verify the All case page.
    Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
    Expected_Text = "Cases";
    assertEquals(Actual_Text, Expected_Text);
    // Verify Status.
    webDriver.findElement(By.xpath("//div/div[2]/button")).click();
    // Click on the search button without selecting any filter and verify.
    webDriver.findElement(By.xpath("//form/div/div/ul/li/button")).click();
    // Select program, Review Type and status.
    webDriver.findElement(By.id("hubzone")).click();
    webDriver.findElement(By.id("continuing_eligibility")).click();
    webDriver.findElement(By.id("proposed_ineligible")).click();
    // Enter invalid data on the date range owner and the search box and
    // verify.
    // From date.
    webDriver.findElement(By.id("date_of_birth_1")).sendKeys("Test");
    webDriver.findElement(By.id("date_of_birth_2")).sendKeys("Test");
    webDriver.findElement(By.id("date_of_birth_3")).sendKeys("Test");
    // To date
    webDriver.findElement(By.xpath("//div[3]/div/input")).sendKeys("Test");
    webDriver.findElement(By.xpath("//div[3]/div[2]/input")).sendKeys("Tes2");
    webDriver.findElement(By.xpath("//div[3]/div[3]/input")).sendKeys("Tes4");
    webDriver.findElement(By.cssSelector("input.autocomplete.ui-autocomplete-input"))
        .sendKeys("Testing234");
    // Enter an invalid search data.
    // webDriver.findElement(By.id("search-field-small")).sendKeys("Testing234");
    // Click the search button.
    webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    webDriver.findElement(By.id("search-field-small")).clear();
    // Verify that no data is return.
    if (webDriver.getPageSource().contains("EDWOSB")) {
      logger.info("Search return EDWOSB application");
    } else {
      if (webDriver.getPageSource().contains("WOSB")) {
        logger.info("Search return WOSB application");
      } else {

        // Fail test if Mpp or 8a application is return.
        if (webDriver.getPageSource().contains("MPP, 8(a) Document Upload")) {
          logger.info("Search return MPP application");
          logger.info("Search return an 8(a) or MPP application");
          Assert.fail(); // Only WOSB & EDWOSB are supposed to be
                         // return if any.
        } else {

          logger.info("Search successful");

        }
      }
    }

    if (webDriver.getPageSource().contains("WOSB")) {
      logger.info("Search return WOSB application");
    } else {
      if (webDriver.getPageSource().contains("EDWOSB")) {
        logger.info("Search return EDWOSB application");
      } else {
        // Fail test if Mpp or 8a application is return.
        if (webDriver.getPageSource().contains("MPP, 8(a) Document Upload")) {
          logger.info("Search return MPP application");
          logger.info("Search return an 8(a) or MPP application");
          Assert.fail(); // Only WOSB & EDWOSB are supposed to be
                         // return if any.
        } else {
          Actual_Text = webDriver
              .findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td")).getText();
          Expected_Text = "No results found.";
          assertEquals(Actual_Text, Expected_Text);
          logger.info("Search successful");

        }
      }
    }

    if (webDriver.getPageSource().contains("Pending")) {
      logger.info("Search return MPP application, Permission failed");
      Assert.fail(); // Only WOSB & EDWOSB are supposed to be return if
                     // any.
    } else {
      logger.info("Search successful, Permission Pass");
    }

    if (webDriver.getPageSource().contains("8(a) Document Upload")) {
      logger.info("Search return MPP application, Permission failed");
      Assert.fail(); // Only WOSB & EDWOSB are supposed to be return if
                     // any.
    } else {
      logger.info("Search successful, Permission Pass");
    }
    // Click on the clear filter button.
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.name("commit")));
    webDriver.findElement(By.name("commit")).click();
    Thread.sleep(2000);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/input")).getText();
    Expected_Text = "Testing234";
    assertNotSame(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.id("search-field-small")).getText();
    Expected_Text = "Testing234";
    assertNotSame(Actual_Text, Expected_Text);
    WebElement OwnerBoxCleared = webDriver.findElement(By.xpath("//div[2]/div/input"));
    HighLight.highLightElement(webDriver, OwnerBoxCleared);
    // Logout, log back in and submit some application.
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("profileid")));

    Actions act = new Actions(webDriver);
    act.doubleClick(webDriver.findElement(By.id("profileid"))).build().perform();
    webDriver.findElement(By.linkText("Logout")).click();
    // Login to dashboard.
    get_The_Row_From_Login_Data = 3;
    LoginPageWithReference login_Data1 =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data1.Login_With_Reference();
    // TestWorkFlowxx8aInProgress to start a new certification.
    DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
    deleteDraftCert1.DeleteDraftCert();
    DeleteDraftCertPage deleteDraftCert13 = new DeleteDraftCertPage(webDriver);
    deleteDraftCert13.DeleteDraftCert();
    AddOrStartCertificationPage addOrStartCertification =
        new AddOrStartCertificationPage(webDriver);
    addOrStartCertification.AddOrStartCertification();
    // Start new 8(a) application.
    EDWOSBEightATestPage eDWOSBEightATest = new EDWOSBEightATestPage(webDriver);
    eDWOSBEightATest.EDWOSBEightATest();
    // Verify for active and Draft program on the dashboard, if draft
    // TestWorkFlowxx8aInProgress and start a new one.
    webDriver.findElement(By.linkText("Dashboard")).click();
    // Verify if there is an existing certification on the dashboard and
    // TestWorkFlowxx8aInProgress to start a new certification.
    DeleteDraftCertPage deleteDraftCert2 = new DeleteDraftCertPage(webDriver);
    deleteDraftCert2.DeleteDraftCert();
    AddOrStartNewMppProgramPage1 addOrStartNewMppProgram =
        new AddOrStartNewMppProgramPage1(webDriver);
    addOrStartNewMppProgram.AddOrStartNewMppProgram();
    // Start new 8(a) application.
    EdwobEightAMppTestPage edwobEightAMppTest = new EdwobEightAMppTestPage(webDriver);
    edwobEightAMppTest.EdwobEightAMppTest();
    // verify the two active programs.
    WebElement MppPending = webDriver.findElement(By.xpath("//table[2]/tbody/tr/td[3]"));
    HighLight.highLightElement(webDriver, MppPending);
    WebElement EdwosbActive = webDriver.findElement(By.xpath("//td[6]"));
    HighLight.highLightElement(webDriver, EdwosbActive);
    // Logout and login back as an analyst.
    webDriver.findElement(By.linkText("Logout")).click();
    get_The_Row_From_Login_Data = 0;
    LoginPageWithReference login_Data2 =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data2.Login_With_Reference();
    // webDriver.navigate().to("https://certify.qa.sba-one.net/sba_analyst/cases/all_cases/");
    // filter by DUNs and verify.
    webDriver.findElement(By.id("search-field-small")).clear();
    webDriver.findElement(By.id("search-field-small")).sendKeys("EDWOSB");
    // Click on the search button.
    webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    if (webDriver.getPageSource().contains("EDWOSB")) {
      logger.info("Search return EDWOSB application");
    } else {
      if (webDriver.getPageSource().contains("WOSB")) {
        logger.info("Search return WOSB application");
      } else {

        // Fail test if Mpp or 8a application is return.
        if (webDriver.getPageSource().contains("8(a) Document Upload")) {
          logger.info("Search return MPP application");
          logger.info("Search return an 8(a) or MPP application");
          Assert.fail(); // Only WOSB & EDWOSB are supposed to be
                         // return if any.
        } else {

          logger.info("Search successful");

        }
      }
    }

    if (webDriver.getPageSource().contains("WOSB")) {
      logger.info("Search return WOSB application");
    } else {
      if (webDriver.getPageSource().contains("EDWOSB")) {
        logger.info("Search return EDWOSB application");
      } else {
        // Fail test if Mpp or 8a application is return.
        if (webDriver.getPageSource().contains("Pending")) {
          logger.info("Search return MPP application");
          logger.info("Search return an 8(a) or MPP application");
          Assert.fail(); // Only WOSB & EDWOSB are supposed to be
                         // return if any.
        } else {
          Actual_Text = webDriver
              .findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td")).getText();
          Expected_Text = "No results found.";
          assertEquals(Actual_Text, Expected_Text);
          logger.info("Search successful");

        }

      }
    }
    // Filter search MPP program only.
    webDriver.findElement(By.cssSelector("li > button.usa-accordion-button")).click();
    webDriver.findElement(By.id("mpp")).click();
    webDriver.findElement(By.cssSelector("input.autocomplete.ui-autocomplete-input"))
        .sendKeys("Analyst1 X");
    webDriver.findElement(By.id("search-field-small")).clear();
    webDriver.findElement(By.id("search-field-small")).sendKeys("MPP Application");
    webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    // Verify that only the MPP program is return.
    if (webDriver.getPageSource().contains("Pending")) {
      logger.info("Search return MPP application, pass");
    } else {
      if (webDriver.getPageSource().contains("EDWOSB")) {
        logger.info("Search return EDWOSB application even when filter by MPP only, failed");
        Assert.fail(); // Only Only MPP should be return.
      } else {
        // Fail test if Mpp or 8a application is return.
        if (webDriver.getPageSource().contains("WOSB")) {
          logger.info("Search return WOSB application, even when filter by MPP only, failed");
          logger.info("Search return an 8(a) or MPP application");
          Assert.fail(); // Only WOSB & EDWOSB are supposed to be
                         // return if any.
        } else {
          logger.info("Search successful, only MPP applications are being return");
        }
      }
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[3]")).getText();
      Expected_Text = "EDWOSB";
      assertNotSame(Actual_Text, Expected_Text);
      // Navigate back to case page, search the business and return the
      // EDWOSB certification.
      webDriver.navigate().to("https://certify.qa.sba-one.net/sba_analyst/cases");
      webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
      webDriver.findElement(By.id("query")).sendKeys("172115728");
      webDriver.findElement(By.xpath("//form/div/button")).click();
      webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
      if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.linkText("Logout")).click();
      } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      }
      // Login as MPP-analyst and return MPP back to vendor.
      get_The_Row_From_Login_Data = 29;
      LoginPageWithReference login_Data61 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data61.Login_With_Reference();
      webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
      webDriver.findElement(By.id("query")).sendKeys("172115728");
      webDriver.findElement(By.xpath("//form/div/button")).click();
      webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
      if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.linkText("Logout")).click();
      } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      }
      get_The_Row_From_Login_Data = 3;
      LoginPageWithReference login_Data11 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data11.Login_With_Reference();
      // TestWorkFlowxx8aInProgress one draft.
      DeleteDraftCertPage deleteDraftCert21 = new DeleteDraftCertPage(webDriver);
      deleteDraftCert21.DeleteDraftCert();
      logger.info("SUCCESS");
    }
  }

  // catch(Exception e){
  // Thread.sleep(2000);
  // ScreenShotPage1 screenShot = new ScreenShotPage1(webDriver);
  // screenShot.ScreenShot();
  // logger.info("Error");
  // Assert.fail(); //fail test in case of any element identification failure
  // }
  // }
  @After
  public void tearDown() throws Exception {
    webDriver.close();
  }
}
