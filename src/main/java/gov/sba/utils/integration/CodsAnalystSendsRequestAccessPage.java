package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.TestCase;

public class CodsAnalystSendsRequestAccessPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(CodsAnalystSendsRequestAccessPage.class.getName());
	WebDriver webDriver;

	public CodsAnalystSendsRequestAccessPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void CodsAnalystSendsRequestAccess() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		String Actual_Text = null;
		String Expected_Text = null;
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		logger.info("Completing Request access for CODS Analyst");
		// Verify the Selecting role is required before user can continue.
		try {
			webDriver.findElement(By.xpath("//form/button")).click();
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("h1"), false));
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "What program will you be supporting?";
			assertNotSame(Actual_Text, Expected_Text);
		} catch (Exception e) {
			ScreenShotPage screenShot = new ScreenShotPage(webDriver);
			screenShot.ScreenShot();
			logger.info(e.getMessage());
		}
		// Select SBA Analyst.
		webDriver.findElement(By.xpath("//li[2]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/button")));
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
		webDriver.findElement(By.xpath("//form/button")).click();
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("h1"), false));
		// Verify the Program page.
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "What program will you be supporting?";
		assertEquals(Actual_Text, Expected_Text);
		// Verify that user can not continue without selecting a program.
		try {
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
			webDriver.findElement(By.xpath("//form/button")).click();
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("h1"), false));
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "What is your business unit?";
			assertNotSame(Actual_Text, Expected_Text);
		} catch (Exception e) {
			ScreenShotPage screenShot = new ScreenShotPage(webDriver);
			screenShot.ScreenShot();
			logger.info(e.getMessage());
		}
		// Select 8a.
		webDriver.findElement(By.xpath("//li/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/button")));
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
		webDriver.findElement(By.xpath("//form/button")).click();
		// Select CODs for Business unit.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "What is your business unit?";
		assertEquals(Actual_Text, Expected_Text);
		// Select Area Office.
		webDriver.findElement(By.xpath("//li/input")).click();
		// Click on the Next button.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
		webDriver.findElement(By.xpath("//form/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "Where is your duty station?";
		// Verify and Select duty station.
		Actual_Text = webDriver.findElement(By.id("duty_station_duty_station")).getText();
		Expected_Text = "San Francisco\nPhiladelphia";
		assertEquals(Actual_Text, Expected_Text);
		// Click the back button and select CODS
		webDriver.findElement(By.xpath("//form/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "What is your business unit?";
		assertEquals(Actual_Text, Expected_Text);
		// Unchecked Area Office.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//li/input")));
		webDriver.findElement(By.xpath("//li/input")).click();
		// Select CODS.
		webDriver.findElement(By.id("bu_cods")).click();
		// Click on Next.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
		webDriver.findElement(By.xpath("//form/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "Where is your duty station?";
		assertEquals(Actual_Text, Expected_Text);
		// Verify that user can not continue without selecting a program.
		try {
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
			webDriver.findElement(By.xpath("//form/button")).click();
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "You would like to use certify.SBA.gov as:";
			assertNotSame(Actual_Text, Expected_Text);
		} catch (Exception e) {
			ScreenShotPage screenShot = new ScreenShotPage(webDriver);
			screenShot.ScreenShot();
			logger.info(e.getMessage());
		}
		// Verify and Select duty station.
		Actual_Text = webDriver.findElement(By.id("duty_station_duty_station")).getText();
		Expected_Text = "San Francisco\nPhiladelphia";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.id("duty_station_duty_station")).click();
		webDriver.findElement(By.xpath("//option")).click();
		try {
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
			webDriver.findElement(By.xpath("//form/button")).click();
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "You would like to use certify.SBA.gov as:";
			assertNotSame(Actual_Text, Expected_Text);
		} catch (Exception e) {
			ScreenShotPage screenShot = new ScreenShotPage(webDriver);
			screenShot.ScreenShot();
			logger.info(e.getMessage());
		}
		// Select a duty station.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("duty_station_duty_station")));
		webDriver.findElement(By.id("duty_station_duty_station")).click();
		webDriver.findElement(By.xpath("//option[2]")).click();
		// Click on Next.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
		webDriver.findElement(By.xpath("//form/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "You would like to use certify.SBA.gov as:";
		assertEquals(Actual_Text, Expected_Text);
		// click on the Submit request button.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//form/button")));
		webDriver.findElement(By.xpath("//form/button")).click();
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "Thank you!";
		assertEquals(Actual_Text, Expected_Text);
		// Logout
		webDriver.findElement(By.linkText("Logout")).click();
		logger.info("CODS Supervisor request is Successfull");
	}
}
