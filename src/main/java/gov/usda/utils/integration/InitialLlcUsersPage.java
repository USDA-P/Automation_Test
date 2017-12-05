package gov.usda.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.TestCase;

public class InitialLlcUsersPage extends TestCase {

	private static final Logger logger = LogManager
			.getLogger(gov.usda.utils.integration.InitialLlcUsersPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	public InitialLlcUsersPage(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	public void InitialLlcUsers() throws Exception {
		logger.debug("Draft cert will be deleted");
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		// Verify if there is an existing certification on the dashboard.
		if (webDriver.getPageSource().contains("Pending")) {
			// Logout and try another user.
			WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
			WebElement rateElement = webDriver.findElement(By.linkText("Logout"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
			get_The_Row_From_Login_Data = 5;
			LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data.Login_With_Reference();
			if (webDriver.getPageSource().contains("Pending")) {
				// Logout and try another user.
				WebElement rateElement21 = webDriver.findElement(By.id("profileid"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement21);
				WebElement rateElement1 = webDriver.findElement(By.linkText("Logout"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement1);
				get_The_Row_From_Login_Data = 76;
				LoginPageWithReference login_Data1 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
				login_Data1.Login_With_Reference();
			} else {
				logger.info(
						"No return or pending 8a application associated with this account, a new application is being created");
			}
		} else {
			if (webDriver.getPageSource().contains("Pending")) {
				// Logout and try another user.
				WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
				WebElement rateElement = webDriver.findElement(By.linkText("Logout"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
				get_The_Row_From_Login_Data = 88;
				LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
				login_Data.Login_With_Reference();
			} else {
				logger.info(
						"No return or pending 8a application associated with this account, a new application is being created");
			}
		}
	}
}
