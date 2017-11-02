package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.TestCase;

public class DeleteDraftCertPage extends TestCase {

	private static final Logger logger = LogManager
			.getLogger(gov.sba.utils.integration.DeleteDraftCertPage.class.getName());
	WebDriver webDriver;

	public DeleteDraftCertPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void DeleteDraftCert() throws Exception {
		logger.debug("Draft cert will be deleted");
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		// Verify if there is an existing certification on the dashboard and
		// delete to start a new certification.
		if (webDriver.getPageSource().contains("Delete")) {
			webDriver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
			// WebElement rateElement =
			// webDriver.findElement(By.linkText("Delete"));
			JavascriptExecutor jse2 = (JavascriptExecutor) webDriver;
			jse2.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.linkText("Delete")));
			webDriver.findElement(By.linkText("Delete")).click();
			// Actions act = new Actions(webDriver);
			// act.doubleClick(webDriver.findElement(By.linkText("Delete"))).build().perform();
			Thread.sleep(2000);
			webDriver.switchTo().alert().accept();
			if (webDriver.getPageSource().contains("Delete")) {
				webDriver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
				// WebElement rateElement =
				// webDriver.findElement(By.linkText("Delete"));
				JavascriptExecutor jse21 = (JavascriptExecutor) webDriver;
				jse21.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.linkText("Delete")));
				webDriver.findElement(By.linkText("Delete")).click();
				// Actions act = new Actions(webDriver);
				// act.doubleClick(webDriver.findElement(By.linkText("Delete"))).build().perform();
				Thread.sleep(2000);
				webDriver.switchTo().alert().accept();

			} else {
				logger.info("No Draft application on the dashboard, all good.");
			}
		}
	}
}
