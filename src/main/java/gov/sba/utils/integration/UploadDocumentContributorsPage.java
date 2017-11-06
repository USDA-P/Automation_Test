package gov.sba.utils.integration;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDocumentContributorsPage {
	private static final Logger logger = LogManager.getLogger(UploadDocumentContributorsPage.class.getName());
	WebDriver webDriver;

	public UploadDocumentContributorsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void UploadDocumentContributors(String upload_Path) throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 40);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		Thread.sleep(2000);
		logger.debug("Uploading a new document");
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.cssSelector("#add-req-doc-button > a")));
		webDriver.findElement(By.cssSelector("#add-req-doc-button > a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.id("doc-upload-button")).click();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.linkText("Choose a .pdf file")));
		Actions act = new Actions(webDriver);
		act.doubleClick(webDriver.findElement(By.linkText("Choose a .pdf file"))).build().perform();
		StringSelection ss = new StringSelection(upload_Path);
		Thread.sleep(1000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("attach")));
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("attach")));
		Actions act1 = new Actions(webDriver);
		act1.doubleClick(webDriver.findElement(By.id("attach"))).build().perform();
		Thread.sleep(2000);
	}

}
