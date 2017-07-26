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

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

public class TestStaticLandingPageForEightAInterim extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(TestStaticLandingPageForEightAInterim.class.getName());
  private static WebDriver webDriver;
  int get_The_Row_From_Login_Data;
  String BaseUrl;

  @Before
  public void setUp() throws Exception {
    webDriver = TestHelpers.getDefaultWebDriver();

    BaseUrl = "https://certify.qa.sba-one.net/8a-docs/";
    webDriver.manage().window().maximize();
    get_The_Row_From_Login_Data = 4;

  }

  @Test
  public void testStaticLandingPageForEightAInterim() throws Exception {
    String Actual_Text = null;
    String Expected_Text = null;
    logger.info("Create a static landing page for 8a Interim");
    webDriver.get(BaseUrl);
    // Verify that user is navigated to the correct 8(a) landing page.
    Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
    Expected_Text = "SBA 8(a) Business Development Program";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Welcome to certify.SBA.gov!";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("article.usa-width-one-whole > p")).getText();
    Expected_Text =
        "You have been directed to certify.SBA.gov from BDMIS in order to submit the supporting documentation required for your 8(a) application submission. Please review the instructions below in full before establishing your account and attempting to submit your PDF documents. Please feel free to submit any questions you may have to 8aquestions@sba.gov.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("h3")).getText();
    Expected_Text = "Instructions:";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.xpath("//article[@id='main-content']/div/section/article/p[2]")).getText();
    Expected_Text = "Please download the following:";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//h3[2]")).getText();
    Expected_Text = "Contacts for Assistance:";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//p[3]")).getText();
    Expected_Text =
        "For general questions about uploading 8(a) documents, please email: certify@sba.gov.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("ol > li")).getText();
    Expected_Text =
        "For your convenience, we have attached the document below for you to download.\nGuidance to Submitting an 8(a) Application.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.xpath("//article[@id='main-content']/div/section/article/ol/li[2]"))
        .getText();
    Expected_Text =
        "User Guide for certify.SBA.gov. This guide provides instructions on how to establish an account for certify.SBA.gov as well as other important information.";
    assertEquals(Actual_Text, Expected_Text);
    // Verify that the Create an Account button navigates to the
    // registration page.
    webDriver.findElement(By.cssSelector("button.button-full")).click();
    Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
    Expected_Text = "New User Registration";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.navigate().back();
    // Verify the login button navigates to the login page.
    webDriver.findElement(By.linkText("Login")).click();
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Sign in to certify.SBA.gov";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.navigate().back();
    Thread.sleep(2000);
    // Verify the 2nd download links.
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String main_window1 = webDriver.getWindowHandle();
    logger.info("Before switching, title is = certify.sba.gov");
    webDriver.findElement(By.linkText("Guidance to Submitting an 8(a) Application")).click();
    Thread.sleep(2000);
    java.util.Set<String> S1 = webDriver.getWindowHandles();
    Iterator<String> i1 = S1.iterator();
    while (i1.hasNext()) {
      String Second_window1 = i1.next();
      if (!main_window1.equalsIgnoreCase(Second_window1)) {
        webDriver.switchTo().window(Second_window1);
        logger.info("After switching title is =" + webDriver.getTitle());
        Actual_Text = webDriver.findElement(By.xpath("//div[4]/div/div/div[2]/div")).getText();
        Expected_Text = "8(a) Business Development Program";
        assertEquals(Actual_Text, Expected_Text);
        WebElement Guidance = webDriver.findElement(By.cssSelector("div.textLayer"));
        HighLight.highLightElement(webDriver, Guidance);
        Thread.sleep(2000);
        webDriver.close();
        webDriver.switchTo().window(main_window1);
        logger.info("Back to manin_window = certify.sba.gov");
      } else {
        logger.info("Second Window is thesame as first window");
      }
      Thread.sleep(3000);
      // Verify the 1st download links.
      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String main_window = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("User Guide for certify.SBA.gov")).click();
      Thread.sleep(5000);
      java.util.Set<String> S = webDriver.getWindowHandles();
      Iterator<String> i = S.iterator();
      while (i.hasNext()) {
        String Second_window = i.next();
        if (!main_window.equalsIgnoreCase(Second_window)) {
          webDriver.switchTo().window(Second_window);
          logger.info("After switching title is =" + webDriver.getTitle());
          Actual_Text = webDriver.findElement(By.xpath("//div[4]/div/div/div[2]/div")).getText();
          Expected_Text = "User Instructions for";
          assertEquals(Actual_Text, Expected_Text);
          WebElement UserGuide = webDriver.findElement(By.cssSelector("div.textLayer"));
          HighLight.highLightElement(webDriver, UserGuide);
          Thread.sleep(2000);
          webDriver.close();
          webDriver.switchTo().window(main_window);
          logger.info("Back to manin_window = certify.sba.gov");
        } else {
          logger.info("Second Window is thesame as first window");
        }
        logger.info("Success");
        return;
      }
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.close();
  }
}
