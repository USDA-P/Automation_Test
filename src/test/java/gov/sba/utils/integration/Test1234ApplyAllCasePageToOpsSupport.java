package gov.sba.utils.integration;

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

public class Test1234ApplyAllCasePageToOpsSupport extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(Test1234ApplyAllCasePageToOpsSupport.class.getName());
  private static WebDriver webDriver;
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    webDriver = TestHelpers.getDefaultWebDriver();

    webDriver.get(TestHelpers.getBaseUrl());
    webDriver.manage().window().maximize();
    get_The_Row_From_Login_Data = 28;

  }

  @Test
  public void testApplyAllCasePageToOpsSupport() throws Exception {
    logger.info("Adding All Case page to ops support admin.");
    String Actual_Text;
    String Expected_Text;
    // Login to dashboard.
    LoginPageWithReference login_Data =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    // Verify that the Case tap was added.
    WebElement Case = webDriver.findElement(By.linkText("Cases"));
    HighLight.highLightElement(webDriver, Case);
    Actual_Text = webDriver.findElement(By.linkText("Cases")).getText();
    Expected_Text = "Cases";
    assertEquals(Actual_Text, Expected_Text);
    // Verify that upon clicking, user is navigated to the all case page.
    webDriver.findElement(By.linkText("Cases")).click();
    WebElement AllCase = webDriver.findElement(By.cssSelector("h1"));
    HighLight.highLightElement(webDriver, AllCase);
    Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
    Expected_Text = "Cases";
    assertEquals(Actual_Text, Expected_Text);
    logger.info("Success");
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
