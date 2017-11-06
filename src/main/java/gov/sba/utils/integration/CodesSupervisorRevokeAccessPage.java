package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class CodesSupervisorRevokeAccessPage extends TestCase {

  private static final Logger logger =
      LogManager.getLogger(CodesSupervisorRevokeAccessPage.class.getName());
  WebDriver webDriver;
  int get_The_Row_From_Login_Data;

  public CodesSupervisorRevokeAccessPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    get_The_Row_From_Login_Data = 70;

  }

  public void CodesSupervisorRevokeAccess() throws Exception {
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    String Actual_Text = null;
    String Expected_Text = null;
    logger.info(
        "Completing Process, CODS supervisors Revoked Access Request from another Cods Supervisors.");
    // Login to dashboard.
    LoginPageWithReference login_Data =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    // Verify the Program page.
    wait.until(ExpectedConditions.elementSelectionStateToBe(By.linkText("Management"), false));
    Actual_Text = webDriver.findElement(By.linkText("Management")).getText();
    Expected_Text = "Management";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the management link.
    try {
      webDriver.findElement(By.linkText("Management")).click();
      wait.until(
          ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/section/article/h1")));
      Actual_Text = webDriver.findElement(By.xpath("//body/section/article/h1")).getText();
      Expected_Text = "Revoke analyst access";
      assertEquals(Actual_Text, Expected_Text);
    } catch (Exception e) {
      ScreenShotPage screenShot = new ScreenShotPage(webDriver);
      screenShot.ScreenShot();
      logger.info(e.getMessage());
    }
    // Verify Revoke link and click on it to revoke access.
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Revoke")));
      webDriver.findElement(By.linkText("Revoke")).click();
      webDriver.switchTo().alert().accept();
      Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
      Expected_Text = "Access request has been revoked";
      assertEquals(Actual_Text, Expected_Text);
    } catch (Exception e) {
      ScreenShotPage screenShot = new ScreenShotPage(webDriver);
      screenShot.ScreenShot();
      logger.info(e.getMessage());
    }
    if (webDriver.getPageSource().contains("Accepted")) {
      webDriver.findElement(By.linkText("Revoke")).click();
      webDriver.switchTo().alert().accept();
      Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
      Expected_Text = "Access request has been revoked";
      assertEquals(Actual_Text, Expected_Text);
    } else {
      logger.info("No Accepted request as of now, all good.");
    }
    // Logout.
    webDriver.findElement(By.id("profileid")).click();
    webDriver.findElement(By.linkText("Logout")).click();
  }
}
