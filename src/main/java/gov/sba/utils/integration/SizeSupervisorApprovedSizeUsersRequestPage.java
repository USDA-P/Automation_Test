package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class SizeSupervisorApprovedSizeUsersRequestPage extends TestCase {

	private static final Logger logger = LogManager
			.getLogger(SizeSupervisorApprovedSizeUsersRequestPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	public SizeSupervisorApprovedSizeUsersRequestPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		get_The_Row_From_Login_Data = 101;

	}

	public void SizeSupervisorApprovedSizeUsersRequest() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		String Actual_Text = null;
		String Expected_Text = null;
		logger.info("Completing Process, CODS supervisors Approved Access Request from another Cods Supervisors.");
		// Login to dashboard.
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
		Actual_Text = webDriver.findElement(By.xpath("//h3")).getText();
		Expected_Text = "New Access Requests";
		assertEquals(Actual_Text, Expected_Text);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("View requests")));
			assertTrue(isElementPresent(By.linkText("View requests")));
		} catch (Error e) {
			logger.info(e.getMessage());
		}
		// Click on the View request button.
		webDriver.findElement(By.linkText("View requests")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "Access Requests";
		assertEquals(Actual_Text, Expected_Text);
		// Approve the request.
		try {
			Actions act = new Actions(webDriver);
			act.doubleClick(webDriver.findElement(By.linkText("Approve"))).build().perform();
			webDriver.switchTo().alert().accept();
			Thread.sleep(2000);
		} catch (Error e) {
			logger.info(e.getMessage());
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/p")));
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/p")).getText();
		Expected_Text = "Approved";
		assertEquals(Actual_Text, Expected_Text);
		// Logout.
		webDriver.findElement(By.id("profileid")).click();
		webDriver.findElement(By.linkText("Logout")).click();
	}

	private boolean isElementPresent(By linkText) {
		// TODO Auto-generated method stub
		return false;
	}
}
