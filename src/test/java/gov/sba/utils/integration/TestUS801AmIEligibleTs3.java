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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

@Category({gov.sba.utils.integration.StableTests.class, gov.sba.utils.integration.DericTests.class})

public class TestUS801AmIEligibleTs3 extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(TestUS801AmIEligibleTs3.class.getName());
  private static WebDriver webDriver;

  @Before
  public void setUp() throws Exception {
    webDriver = TestHelpers.getDefaultWebDriver();

    webDriver.get(TestHelpers.getBaseUrl());
    // webDriver.manage().window().maximize();
  }

  @Test
  public void testUS801AmIEligibleTs3() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    try {
      // Open Firefox,Chrome or IE and navigate to the certify.sba.gov
      // landing
      // page.
      logger.info(
          "User is NOT eligible for Any of the programs because user answer NO for Qs2: 8(a), WOSB, EDWOSB & Hob-zone");
      WebDriverWait wait = new WebDriverWait(webDriver, 30);
      // Locate the Am I Eligible or the Find Out button on the
      // Certify.SBA.Gov landing page and click on it.
      webDriver.findElement(By.xpath("//div[@id='header_nav']/header/nav/div/ul/li[3]/a/span"))
          .click();
      wait.until(
          ExpectedConditions.elementSelectionStateToBe(By.xpath(".//*[@id='am-i']/h1"), false));
      // Verify that user navigates to the am i eligible page.
      String actual_Text = webDriver.findElement(By.xpath(".//*[@id='am-i']/h1")).getText();
      String expected_Text = "Is there an SBA Contracting Program for me?";
      assertEquals(expected_Text, actual_Text);
      // Locate the first question and select NO and verify the More
      // Detail
      // meaning of the question.
      String actual_Text2 =
          webDriver.findElement(By.cssSelector("div.usa-width-one-half > p.lead-para")).getText();
      String expected_Text2 =
          "Are the qualifying individual(s) of the firm who are applying for SBA small business programs U.S. citizens?";
      assertEquals(actual_Text2, expected_Text2);
      // Validate the meaning for question one.
      String actual_Text3 =
          webDriver.findElement(By.cssSelector("div.details.usa-width-one-half > p")).getText();
      String expected_Text3 =
          "A U.S.citizenmeans a person born or naturalized in the United States. Resident aliens and holders of permanent visas are not considered to be citizens for program purposes.";
      assertEquals(actual_Text3, expected_Text3);
      // verify and click on the Yes button.
      jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.cssSelector("button.yes_button")));
      webDriver.findElement(By.cssSelector("button.yes_button")).click();
      wait.until(ExpectedConditions.elementSelectionStateToBe(
          By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p"), false));
      // Locate the 2nd question and select No and verify the More Detail
      // meaning of the question.
      String actual_error3 = webDriver
          .findElement(By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p"))
          .getText();
      String expected_error3 = "Is the 51% ownership of the firm unconditional and direct?";
      assertEquals(actual_error3, expected_error3);
      // Verify the detail meaning for the 2nd question.
      String actual_error = webDriver
          .findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li"))
          .getText();
      String expected_error =
          "Qualifying individual(s) mustunconditionally and directly own and controlat least 51% of the business.";
      assertEquals(actual_error, expected_error);
      String actual_error4 = webDriver
          .findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li[2]"))
          .getText();
      String expected_error4 =
          "In general, the 51%ownershipmay not be through another business entity.";
      assertEquals(actual_error4, expected_error4);
      String actual_error5 = webDriver
          .findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li[3]"))
          .getText();
      String expected_error5 =
          "Controlmeans that both the long-term decision making and the day-to-day management of the business are controlled by qualifying individual(s).";
      assertEquals(actual_error5, expected_error5);
      // verify and click on the No button.
      jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.id("no_button_unconditional_direct_51_percent")));
      webDriver.findElement(By.id("no_button_unconditional_direct_51_percent")).click();
      wait.until(
          ExpectedConditions.elementSelectionStateToBe(By.cssSelector("span.message"), false));
      // Verify searched results.
      String actual_error7 = webDriver.findElement(By.cssSelector("span.message")).getText();
      String expected_error7 =
          "In order to participate in SBA small business programs, the owner or owners of the firm must be unconditional and direct.";
      assertEquals(actual_error7, expected_error7);
      // Click on the Exit button.
      jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.linkText("Exit")));
      webDriver.findElement(By.linkText("Exit")).click();
    } catch (Exception e) {
      ScreenShotPage screenShot = new ScreenShotPage(webDriver);
      screenShot.ScreenShot();
      logger.info(e.getMessage());
      Assert.fail();
    }
    logger.info("Success");

  }

  @After
  public void tearDown() throws Exception {
    webDriver.close();
  }
}
