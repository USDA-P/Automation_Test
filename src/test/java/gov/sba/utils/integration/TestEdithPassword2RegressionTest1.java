// @Montana
package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

public class TestEdithPassword2RegressionTest1 extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(TestEdithPassword2RegressionTest1.class.getName());
  private static WebDriver webDriver;
  String myurl;
  String Email;
  String PassW;
  String Old_PassW;
  String New_PassW;
  String New_PassW2;

  @Before
  public void setUp() throws Exception {
    webDriver = TestHelpers.getDefaultWebDriver();
    webDriver.get(TestHelpers.getBaseUrl());
    webDriver.manage().window().maximize();
    Email = "jw_llc@mailinator.com";
    Old_PassW = "password";
    New_PassW = "The Quick Brown Fox Jumps Over The Lazy 12345";
    New_PassW2 = "The Quick Brown Fox Jumps Over The Lazy Dog 123456";
  }

  @Test
  public void testEdithPassword2RegressionTest1() throws Exception {
      WebDriverWait wait = new WebDriverWait(webDriver, 30);
      // Open Firefox,Chrome,and IE and navigate to the valid url.
      webDriver.findElement(By.cssSelector("button.button-full")).click();
      webDriver.findElement(By.id("user_email")).sendKeys(Email);
      // Locate the password search box and enter a valid password.
      webDriver.findElement(By.id("user_password")).sendKeys(Old_PassW);
      // Locate the user Sign-in button and click on it.
      webDriver.findElement(By.id("business_signin")).click();
      if (webDriver.getPageSource().contains("Dashboard")) {
        // Locate the My Profile button on the left navigation and click
        // on it.
        logger.info("First attempt to log-in with current password was successful, PASS");
        webDriver.findElement(By.linkText("Profile")).click();
        // Verify and click on the link Edit Passphrase.
        String actual_Text4 = webDriver.findElement(By.linkText("Edit passphrase")).getText();
        String expected_Text4 = "Edit passphrase";
        assertEquals(actual_Text4, expected_Text4);
        webDriver.findElement(By.linkText("Edit passphrase")).click();
        // Verify that user is navigated to the change password page.
        String actual_Text5 = webDriver.findElement(By.cssSelector("h1")).getText();
        String expected_Text5 = "Edit passphrase";
        assertEquals(actual_Text5, expected_Text5);
        // Locate the current password search box and enter a valid
        // current
        // password.
        webDriver.findElement(By.id("user_current_password")).sendKeys(Old_PassW);
        // locate that new password search box and enter the new
        // password you
        // wish to update to.
        webDriver.findElement(By.id("user_password")).sendKeys(New_PassW);
        // Verify the strength of the new password and accept only
        // better or
        // strong password.
        Thread.sleep(2000);
        String actual_Text6 = webDriver.findElement(By.id("text_strength")).getText();
        String expected_Text6 = "Passphrase strength  -  Strong";
        assertEquals(actual_Text6, expected_Text6);
        // Locate the confirm new password search box and re-enter the
        // new
        // password.
        webDriver.findElement(By.id("user_password_confirmation")).sendKeys(New_PassW);
        // Locate the Update button and click on it.
        webDriver.findElement(By.id("submit")).click();
        // Verify that User sees alert message 'Your account has been
        // updated
        // successfully'.
        assertTrue(
            webDriver.getPageSource().contains("Your account has been updated successfully."));
        logger.info("User change password Successfully");
        // webDriver.findElement(By.id("labelid")).click();
        // Click on the log-out button.
        WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
		WebElement rateElement = webDriver.findElement(By.linkText("Logout"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);        assertFalse(webDriver.getPageSource().contains("Signed out successfully"));
        logger.info("Successful sign out alert message not present");
        // Locate and click on the log-in link.
        webDriver.findElement(By.cssSelector("button.button-full")).click();
        // Locate the email search box and enter a valid email.
        webDriver.findElement(By.id("user_email")).sendKeys(Email);
        // Locate the password search box and enter a valid password.
        webDriver.findElement(By.id("user_password")).sendKeys(New_PassW);
        // Locate the user Sign-in button and click on it.
        webDriver.findElement(By.id("business_signin")).click();
        // Verify that user logged in successfully with the new updated
        // password.
        assertTrue(webDriver.getPageSource().contains("135453634"));
        logger.info("Password Update is Successful");
      } else {
        if (webDriver.getPageSource().contains("Invalid email or password")) {
          // webDriver.findElement(By.xpath(".//*[@id='labelid']")).click();
          // Locate the email search box and enter a valid email.
          webDriver.findElement(By.id("user_email")).sendKeys(Email);
          // Locate the password search box and enter a valid
          // password.
          webDriver.findElement(By.id("user_password")).sendKeys(New_PassW);
          // Locate the user Sign-in button and click on it.
          webDriver.findElement(By.id("business_signin")).click();
          if (webDriver.getPageSource()
              .contains("You have one more attempt before your account is locked.")) {
            // Locate the email search box and enter a valid email.
            webDriver.findElement(By.id("user_email")).sendKeys(Email);
            // Locate the password search box and enter a valid
            // password.
            webDriver.findElement(By.id("user_password")).sendKeys(New_PassW2);
            // Locate the user Sign-in button and click on it.
            webDriver.findElement(By.id("business_signin")).click();
            // Locate the My Profile button on the left navigation
            // and click on
            // it.
            String actual_Text = webDriver.findElement(By.linkText("Profile")).getText();
            String expected_Text = "Profile";
            assertEquals(actual_Text, expected_Text);
            webDriver.findElement(By.linkText("Profile")).click();
            // Verify and click on the link Edit Passphrase.
            String actual_Text1 = webDriver.findElement(By.linkText("Edit passphrase")).getText();
            String expected_Text1 = "Edit passphrase";
            assertEquals(actual_Text1, expected_Text1);
            webDriver.findElement(By.linkText("Edit passphrase")).click();
            wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("h1"), false));
            // Verify that user is navigated to the change password
            // page.
            String actual_Text2 = webDriver.findElement(By.cssSelector("h1")).getText();
            String expected_Text2 = "Edit passphrase";
            assertEquals(actual_Text2, expected_Text2);
            // Locate the current password search box and enter a
            // valid current
            // password.
            webDriver.findElement(By.id("user_current_password")).sendKeys(New_PassW2);
            // locate that new password search box and enter the new
            // password
            // you wish to update to.
            webDriver.findElement(By.id("user_password")).sendKeys(New_PassW);
            // Verify the strength of the new password and accept
            // only better or
            // strong password.
            Thread.sleep(1000);
            String actual_Text3 = webDriver.findElement(By.id("text_strength")).getText();
            String expected_Text3 = "Passphrase strength  -  Strong";
            assertEquals(actual_Text3, expected_Text3);
            // Locate the confirm new password search box and
            // re-enter the new
            // password.
            webDriver.findElement(By.id("user_password_confirmation")).sendKeys(New_PassW);
            // Locate the Update button and click on it.
            webDriver.findElement(By.id("submit")).click();
            // Verify that User sees alert message 'Your account has
            // been
            // updated successfully'.
            assertTrue(
                webDriver.getPageSource().contains("Your account has been updated successfully."));
            logger.info("User change password Successfully");
            // webDriver.findElement(By.id("labelid")).click();
            // Locate the logout button and click on it then log
            // back in with
            // the new password.
            WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
    		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
    		WebElement rateElement = webDriver.findElement(By.linkText("Logout"));
    		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);            // Locate and click on the log-in link.
            webDriver.findElement(By.cssSelector("button.button-full")).click();
            // Locate the email search box and enter a valid email.
            webDriver.findElement(By.id("user_email")).sendKeys(Email);
            // Locate the password search box and enter a valid
            // password.
            webDriver.findElement(By.id("user_password")).sendKeys(New_PassW);
            // Locate the user Sign-in button and click on it.
            webDriver.findElement(By.id("business_signin")).click();
            // Verify that user logged in successfully with the new
            // updated
            // password.
            assertTrue(webDriver.getPageSource().contains("135453634"));
            logger.info("Password Update is Successful");
            return;
          } else {

            // Locate the My Profile button on the left navigation
            // and click on
            // it.
            String actual_Text = webDriver.findElement(By.linkText("Profile")).getText();
            String expected_Text = "Profile";
            assertEquals(actual_Text, expected_Text);
            webDriver.findElement(By.linkText("Profile")).click();
            // Verify and click on the link Edit Passphrase.
            String actual_Text4 = webDriver.findElement(By.linkText("Edit passphrase")).getText();
            String expected_Text4 = "Edit passphrase";
            assertEquals(actual_Text4, expected_Text4);
            webDriver.findElement(By.linkText("Edit passphrase")).click();
            // Verify that user is navigated to the change password
            // page.
            String actual_Text2 = webDriver.findElement(By.cssSelector("h1")).getText();
            String expected_Text2 = "Edit passphrase";
            assertEquals(actual_Text2, expected_Text2);
            // Locate the current password search box and enter a
            // valid current
            // password.
            webDriver.findElement(By.id("user_current_password")).sendKeys(New_PassW);
            // locate that new password search box and enter the new
            // password
            // you wish to update to.
            webDriver.findElement(By.id("user_password")).sendKeys(New_PassW2);
            // Verify the strength of the new password and accept
            // only better or
            // strong password.
            Thread.sleep(1000);
            String actual_Text3 = webDriver.findElement(By.id("text_strength")).getText();
            String expected_Text3 = "Passphrase strength  -  Strong";
            assertEquals(actual_Text3, expected_Text3);
            // Locate the confirm new password search box and
            // re-enter the new
            // password.
            webDriver.findElement(By.id("user_password_confirmation")).sendKeys(New_PassW2);
            // Locate the Update button and click on it.
            webDriver.findElement(By.id("submit")).click();
            // Verify that User sees alert message 'Your account has
            // been
            // updated successfully'.
            assertTrue(
                webDriver.getPageSource().contains("Your account has been updated successfully."));
            logger.info("User change password Successfully");
            // webDriver.findElement(By.id("labelid")).click();
            // Locate the logout button and click on it then log
            // back in with
            // the new password.
            WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
    		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
    		WebElement rateElement = webDriver.findElement(By.linkText("Logout"));
    		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);            
    		// Locate and click on the log-in link.
            webDriver.findElement(By.cssSelector("button.button-full")).click();
            // Locate the email search box and enter a valid email.
            webDriver.findElement(By.id("user_email")).sendKeys(Email);
            // Locate the password search box and enter a valid
            // password.
            webDriver.findElement(By.id("user_password")).sendKeys(New_PassW2);
            // Locate the user Sign-in button and click on it.
            webDriver.findElement(By.id("business_signin")).click();
            // Verify that user logged in successfully with the new
            // updated
            // password.
            assertTrue(webDriver.getPageSource().contains("135453634"));
            logger.info("Password Update is Successful");
            return;
          }
        }
      }

    logger.info("Success");
  }

  @After
  public void tearDown() throws Exception {
    webDriver.close();
  }
}
