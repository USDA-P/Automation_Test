// @Montana
package gov.sba.utils.integration;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

public class TestRestrictCoAccessToActiveOrPendingMppRecords extends TestCase {
  // Set The variabl.es/Define
  private static WebDriver webDriver;
  private static final Logger logger =
      LogManager.getLogger(TestRestrictCoAccessToActiveOrPendingMppRecords.class.getName());
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {

    webDriver = TestHelpers.getDefaultWebDriver();
    webDriver.get(TestHelpers.getBaseUrl());
    webDriver.manage().window().maximize();
    get_The_Row_From_Login_Data = 3;

  }

  @Test
  public void testRestrictCoAccessToActiveOrPendingMppRecords() throws Exception {
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    String Actual_Text = null;
    String Expected_Text = null;
    // Login to dashboard.
    LoginPageWithReference login_Data =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    logger.info("US1531Restrict search results on Request Access to View Records page for CO role");
    // Verify if there is an existing certification on the dashboard and
    // TestWorkFlowxx8aInProgress to start a new certification.
    DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
    deleteDraftCert.DeleteDraftCert();
    // Delete second draft if any.
    DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
    deleteDraftCert1.DeleteDraftCert();
    // Verify for active and Draft certification on the dashboard, if draft
    // TestWorkFlowxx8aInProgress and start a new EDWOSB certification.
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
    // Logout and login as a CO.
    webDriver.findElement(By.linkText("Logout")).click();
    get_The_Row_From_Login_Data = 16;
    LoginPageWithReference login_Data1 =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data1.Login_With_Reference();
    webDriver.manage().window().maximize();
    // Verify if the CO account has a role, if not request a co role for the
    // account.
    if (webDriver.getPageSource().contains("Welcome to certify.SBA.gov!")) {
      logger.info("The CO Account has no role, new CO role is requested.");
      Actual_Text = webDriver.findElement(By.xpath("//article/div/div/p")).getText();
      Expected_Text =
          "If you are a federal contracting officer, contracting specialist, or authorized SBA personnel, please request access to the system by selecting the role below.";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.id("role_name_checkbox_Legacy_CO_CO")).click();
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Search valid DUNs with no Active certification and verify
      // message.
      webDriver.findElement(By.id("duns_number")).sendKeys("135453634");
      webDriver.findElement(By.id("find_business")).click();
      wait.until(ExpectedConditions
          .elementSelectionStateToBe(By.xpath(".//*[@id='vendor_found_not_certified']/h3"), false));
      Actual_Text =
          webDriver.findElement(By.xpath(".//*[@id='vendor_found_not_certified']/h3")).getText();
      Expected_Text =
          "The vendor has not completed self-certification in certify.SBA.gov. Please contact the vendor to direct them to complete self-certification.";
      assertEquals(Actual_Text, Expected_Text);
      WebElement NewText =
          webDriver.findElement(By.xpath(".//*[@id='vendor_found_not_certified']/h3"));
      HighLight.highLightElement(webDriver, NewText);
      // Take screenshot and store as a file format
      ScreenShotPage screenShot = new ScreenShotPage(webDriver);
      screenShot.ScreenShot();
      // Search Invalid DUNs verify message.
      webDriver.findElement(By.id("duns_number")).clear();
      webDriver.findElement(By.id("duns_number")).sendKeys("135000634");
      webDriver.findElement(By.id("find_business")).click();
      wait.until(ExpectedConditions
          .elementSelectionStateToBe(By.xpath(".//*[@id='no_vendor_found']/h3"), false));
      Actual_Text = webDriver.findElement(By.xpath(".//*[@id='no_vendor_found']/h3")).getText();
      Expected_Text =
          "No vendor exists in certify.SBA.gov for the DUNS number you have entered. Please contact the vendor to direct them to self-certify at certify.SBA.gov.";
      assertEquals(Actual_Text, Expected_Text);
      WebElement NewText1 = webDriver.findElement(By.xpath(".//*[@id='no_vendor_found']/h3"));
      HighLight.highLightElement(webDriver, NewText1);
      // Take screenshot and store as a file format
      ScreenShotPage screenShot1 = new ScreenShotPage(webDriver);
      screenShot1.ScreenShot();
      // Search valid DUNs With active MPP and WOSB verify..
      webDriver.findElement(By.id("duns_number")).clear();
      webDriver.findElement(By.id("duns_number")).sendKeys("172115728");
      webDriver.findElement(By.id("find_business")).click();
      wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("vendor_name"), false));
      Actual_Text = webDriver.findElement(By.id("vendor_name")).getText();
      Expected_Text = "Entity 81 Legal Business Name";
      assertEquals(Actual_Text, Expected_Text);
      // Enter a Solicitation and NAICS number.
      webDriver.findElement(By.id("access_request_solicitation_number")).sendKeys("1721157");
      webDriver.findElement(By.id("access_request_solicitation_naics")).sendKeys("656782");
      // On type of procurement, select WOSB set-aside.
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/input")));
      webDriver.findElement(By.xpath("//li/input")).click();
      // Click on i accept.
      webDriver.findElement(By.xpath("//div/div/input")).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_request_access")));
      webDriver.findElement(By.id("submit_request_access")).click();
      Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
      Expected_Text = "Review vendor certifications";
      assertEquals(Actual_Text, Expected_Text);
      // Logout and login to the requested vendors profile and accept the
      // request.
      webDriver.findElement(By.linkText("Logout")).click();
      get_The_Row_From_Login_Data = 3;
      LoginPageWithReference login_Data11 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data11.Login_With_Reference();
      // click on the Business link.
      webDriver.findElement(By.linkText("Business")).click();
      // Click on Manage CO access.
      webDriver.findElement(By.linkText("Manage CO access")).click();
      // Click on the accept button.
      webDriver.findElement(By.xpath("//input[@value='Accept']")).click();
      wait.until(ExpectedConditions.alertIsPresent());
      webDriver.switchTo().alert().accept();
      // Logout and login to the requester, CO profile and verify that CO
      // sees only the WOSB and not the MPP certification.
      webDriver.findElement(By.linkText("Logout")).click();
      get_The_Row_From_Login_Data = 16;
      LoginPageWithReference login_Data2 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data2.Login_With_Reference();
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[7]")).getText();
      Expected_Text = "EDWOSB";
      assertEquals(Actual_Text, Expected_Text);
      // Verify the EDWOSB.
      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String main_window = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("EDWOSB")).click();
      java.util.Set<String> S1 = webDriver.getWindowHandles();
      Iterator<String> i1 = S1.iterator();
      while (i1.hasNext()) {
        String Second_window = i1.next();
        if (!main_window.equalsIgnoreCase(Second_window)) {
          webDriver.switchTo().window(Second_window);
          logger.info("After switching title is = certify.sba.gov");
          webDriver.close();
          webDriver.switchTo().window(main_window);
          logger.info("Back to manin_window = certify.sba.gov");
        } else {
          logger.info("Second Window is not thesame as first window");
        }
      }
      // Take screenshot and store as a file format
      ScreenShotPage screenShot11 = new ScreenShotPage(webDriver);
      screenShot11.ScreenShot();
      webDriver.findElement(By.linkText("Logout")).click();
      // Login as MPP-analyst and return MPP back to vendor.
      get_The_Row_From_Login_Data = 29;
      LoginPageWithReference login_Data61 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data61.Login_With_Reference();
      // webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
      webDriver.findElement(By.id("query")).sendKeys("172115728");
      webDriver.findElement(By.xpath("//form/div/button")).click();
      wait.until(
          ExpectedConditions.elementToBeClickable(By.linkText("Entity 81 Legal Business Name")));
      webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
      if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        // webDriver.switchTo().alert().accept();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      }
      // Login as WOSB-analyst and return WOSB program back to vendor.
      get_The_Row_From_Login_Data = 0;
      LoginPageWithReference login_Data71 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data71.Login_With_Reference();
      webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
      webDriver.findElement(By.id("query")).sendKeys("172115728");
      webDriver.findElement(By.xpath("//form/div/button")).click();
      wait.until(
          ExpectedConditions.elementToBeClickable(By.linkText("Entity 81 Legal Business Name")));
      webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
      if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        // webDriver.switchTo().alert().accept();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
        logger.info("Success");
      }
    } else {
      // Click on the My Request Link.
      webDriver.findElement(By.linkText("Request access")).click();
      Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
      Expected_Text = "Request access to view records";
      assertEquals(Actual_Text, Expected_Text);
      // Search valid DUNs with no Active certification and verify
      // message.
      webDriver.findElement(By.id("duns_number")).sendKeys("135453634");
      webDriver.findElement(By.id("find_business")).click();
      wait.until(ExpectedConditions
          .elementSelectionStateToBe(By.xpath(".//*[@id='vendor_found_not_certified']/h3"), false));
      Thread.sleep(2000);
      Actual_Text =
          webDriver.findElement(By.xpath(".//*[@id='vendor_found_not_certified']/h3")).getText();
      Expected_Text =
          "The vendor has not completed self-certification in certify.SBA.gov. Please contact the vendor to direct them to complete self-certification.";
      assertEquals(Actual_Text, Expected_Text);
      WebElement NewText =
          webDriver.findElement(By.xpath(".//*[@id='vendor_found_not_certified']/h3"));
      HighLight.highLightElement(webDriver, NewText);
      // Take screenshot and store as a file format
      ScreenShotPage screenShot2 = new ScreenShotPage(webDriver);
      screenShot2.ScreenShot();
      // Search Invalid DUNs verify message.
      webDriver.findElement(By.id("duns_number")).clear();
      webDriver.findElement(By.id("duns_number")).sendKeys("1721157");
      webDriver.findElement(By.id("find_business")).click();
      wait.until(ExpectedConditions
          .elementSelectionStateToBe(By.xpath("//div[@id='no_vendor_found']/h3"), false));
      Thread.sleep(2000);
      Actual_Text = webDriver.findElement(By.xpath("//div[@id='no_vendor_found']/h3")).getText();
      Expected_Text =
          "No vendor exists in certify.SBA.gov for the DUNS number you have entered. Please contact the vendor to direct them to self-certify at certify.SBA.gov.";
      assertEquals(Actual_Text, Expected_Text);
      WebElement NewText1 = webDriver.findElement(By.xpath("//div[@id='no_vendor_found']/h3"));
      HighLight.highLightElement(webDriver, NewText1);
      // Take screenshot and store as a file format
      ScreenShotPage screenShot3 = new ScreenShotPage(webDriver);
      screenShot3.ScreenShot();
      // Search valid DUNs With active MPP and WOSB verify..
      webDriver.findElement(By.id("duns_number")).clear();
      webDriver.findElement(By.id("duns_number")).sendKeys("172115728");
      webDriver.findElement(By.id("find_business")).click();
      // Enter a Solicitation and NAICS number.
      webDriver.findElement(By.id("access_request_solicitation_number")).sendKeys("1721157");
      webDriver.findElement(By.id("access_request_solicitation_naics")).sendKeys("656782");
      // On type of procurement, select WOSB set-aside.
      webDriver.findElement(By.id("access_request_procurement_type_wosb_set_aside")).click();
      // Click on i accept.
      webDriver.findElement(By.id("contracting_officer_certification")).click();
      webDriver.findElement(By.id("submit_request_access")).click();
      wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("h2"), false));
      Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
      Expected_Text = "Review vendor certifications";
      assertEquals(Actual_Text, Expected_Text);
      // Logout and login to the requested vendors profile and accept the
      // request.
      webDriver.findElement(By.linkText("Logout")).click();
      get_The_Row_From_Login_Data = 3;
      LoginPageWithReference login_Data11 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data11.Login_With_Reference();
      // click on the Business link.
      webDriver.findElement(By.linkText("Business")).click();
      // Click on Manage CO access.
      webDriver.findElement(By.linkText("Manage CO access")).click();
      // Click on the accept button.
      webDriver.findElement(By.xpath("//input[@value='Accept']")).click();
      wait.until(ExpectedConditions.alertIsPresent());
      webDriver.switchTo().alert().accept();
      // Logout and login to the requester, CO profile and verify that CO
      // sees only the WOSB and not the MPP certification.
      webDriver.findElement(By.linkText("Logout")).click();
      get_The_Row_From_Login_Data = 16;
      LoginPageWithReference login_Data2 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data2.Login_With_Reference();
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[7]")).getText();
      Expected_Text = "EDWOSB";
      assertEquals(Actual_Text, Expected_Text);
      // Verify the EDWOSB.
      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String main_window = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("EDWOSB")).click();
      java.util.Set<String> S1 = webDriver.getWindowHandles();
      Iterator<String> i1 = S1.iterator();
      while (i1.hasNext()) {
        String Second_window = i1.next();
        if (!main_window.equalsIgnoreCase(Second_window)) {
          webDriver.switchTo().window(Second_window);
          logger.info("After switching title is = certify.sba.gov");
          webDriver.close();
          webDriver.switchTo().window(main_window);
          logger.info("Back to manin_window = certify.sba.gov");
        } else {
          logger.info("Second Window is not thesame as first window");
        }
      }
      // Take screenshot and store as a file format
      ScreenShotPage screenShot11 = new ScreenShotPage(webDriver);
      screenShot11.ScreenShot();
      webDriver.findElement(By.linkText("Logout")).click();
      // Login as MPP-analyst and return MPP back to vendor.
      get_The_Row_From_Login_Data = 29;
      LoginPageWithReference login_Data61 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data61.Login_With_Reference();
      // webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
      webDriver.findElement(By.id("query")).sendKeys("172115728");
      webDriver.findElement(By.xpath("//form/div/button")).click();
      wait.until(
          ExpectedConditions.elementToBeClickable(By.linkText("Entity 81 Legal Business Name")));
      webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
      if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        // webDriver.switchTo().alert().accept();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      }
      // Login as WOSB-analyst and return WOSB program back to vendor.
      get_The_Row_From_Login_Data = 0;
      LoginPageWithReference login_Data71 =
          new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
      login_Data71.Login_With_Reference();
      // webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
      webDriver.findElement(By.id("query")).sendKeys("172115728");
      webDriver.findElement(By.xpath("//form/div/button")).click();
      wait.until(
          ExpectedConditions.elementToBeClickable(By.linkText("Entity 81 Legal Business Name")));
      webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
      if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        // webDriver.switchTo().alert().accept();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.id("profileid")).click();
        webDriver.findElement(By.linkText("Logout")).click();
      }
      logger.info("Success");
    }

  }

  @After
  public void tearDown() throws Exception {
    webDriver.close();
  }
}
