package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;
import junit.framework.TestCase;

public class PotentialForSuccessMasterAppSectionPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(PotentialForSuccessMasterAppSectionPage.class.getName());
	WebDriver webDriver;

	public PotentialForSuccessMasterAppSectionPage(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	public void PotentialForSuccessMasterAppSection() throws Exception {
		logger.info("Character section question begins");
		String Actual_Text = null;
		String Expected_Text = null;
		// Verify the Character Section link.
		Actual_Text = webDriver.findElement(By.linkText("Potential for Success")).getText();
		Expected_Text = "Potential for Success";
		assertEquals(Actual_Text, Expected_Text);
		// Verify Status.
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/div/section/div/div[2]/table/tbody/tr/td/span"))
				.getText();
		Expected_Text = "Not started";
		assertEquals(Actual_Text, Expected_Text);
		WebElement EligibilityCompleteStatus = webDriver
				.findElement(By.xpath("//div[3]/div/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, EligibilityCompleteStatus);
		// Click on the link to start Potential for Success.
		WebElement rateElement = webDriver.findElement(By.linkText("Potential for Success"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		assertEquals("", webDriver.getTitle());
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Taxes".equals(webDriver.findElement(By.cssSelector("h2")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		webDriver.findElement(By.id("section_submit_button")).click();
		try {
			assertEquals("Attachment is required", webDriver.findElement(By.xpath("//div/span")).getText());
		} catch (Error e) {
			logger.info(e.getMessage());
		}
		String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
		CoreUtils.clickContinue(webDriver);
		assertEquals("", webDriver.getTitle());
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Revenue".equals(webDriver.findElement(By.cssSelector("h2")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		CoreUtils.clickContinue(webDriver);
		try {
			assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
		} catch (Error e) {
			logger.info(e.getMessage());
		}
		// select yes for both question.
		webDriver.findElement(By.xpath("//div/input")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
		webDriver.findElement(By.xpath("//div/div[2]/input")).sendKeys("87");
		webDriver.findElement(By.xpath("//tr[3]/td/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td/input")).sendKeys("12333");
		webDriver.findElement(By.xpath("//td[2]/input")).clear();
		webDriver.findElement(By.xpath("//td[2]/input")).sendKeys("kbfkjdhfjkadkjf");
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).sendKeys("5678jjh");
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).sendKeys("thebdb 34");
		webDriver.findElement(By.xpath("//td[6]/button")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("The award date should be in MM/DD/YYYY format\nThe NAICS code should be a 5 or 6 digit number"
						.equals(webDriver.findElement(By.xpath("//div[2]/div/div/p")).getText()))
					break;
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			Thread.sleep(1000);
		}
		assertEquals("The award date should be in MM/DD/YYYY format\nThe NAICS code should be a 5 or 6 digit number",
				webDriver.findElement(By.xpath("//div[2]/div/div/p")).getText());
		webDriver.findElement(By.xpath("//tr[3]/td/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td/input")).sendKeys("03/12/2016");
		webDriver.findElement(By.xpath("//td[2]/input")).clear();
		webDriver.findElement(By.xpath("//td[2]/input")).sendKeys("The Alliace");
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).sendKeys("123456");
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).sendKeys("Perform");
		webDriver.findElement(By.xpath("//tr[3]/td[5]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[5]/input")).sendKeys("67");
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//td[6]/button")));
		webDriver.findElement(By.xpath("//td[6]/button")).click();
		webDriver.findElement(By.id("section_submit_button")).click();
		webDriver.findElement(By.id("answers_632_value")).clear();
		webDriver.findElement(By.id("answers_632_value")).sendKeys("56");
		webDriver.findElement(By.linkText("Add a row")).click();
		webDriver.findElement(By.xpath("//tr[3]/td/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td/input")).sendKeys("12/23/2009");
		webDriver.findElement(By.xpath("//td[2]/input")).clear();
		webDriver.findElement(By.xpath("//td[2]/input")).sendKeys("Google1");
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).sendKeys("12345");
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).sendKeys("Testing Time");
		webDriver.findElement(By.xpath("//tr[3]/td[5]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[5]/input")).sendKeys("123456");
		webDriver.findElement(By.xpath("//td[6]/button")).click();
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.linkText("Add a row")));
		webDriver.findElement(By.linkText("Add a row")).click();
		webDriver.findElement(By.xpath("//tr[3]/td/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td/input")).sendKeys("10/23/1998");
		webDriver.findElement(By.xpath("//td[2]/input")).clear();
		webDriver.findElement(By.xpath("//td[2]/input")).sendKeys("Petco");
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[3]/input")).sendKeys("123456");
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[4]/input")).sendKeys("pets");
		webDriver.findElement(By.xpath("//tr[3]/td[5]/input")).clear();
		webDriver.findElement(By.xpath("//tr[3]/td[5]/input")).sendKeys("6000");
		webDriver.findElement(By.xpath("//td[6]/button")).click();
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage ContributorUpload21 = new Upload2pdfOnSamePage(webDriver);
		ContributorUpload21.Upload2pdfOnSame(file_path_abs);
		CoreUtils.clickContinue(webDriver);
		assertEquals("", webDriver.getTitle());
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Potential for Success".equals(webDriver.findElement(By.cssSelector("h2")).getText()))
					break;
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		webDriver.findElement(By.xpath("//div/input")).click();
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument11 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument11.MontanaUploadDocument(file_path_abs);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage ContributorUpload211 = new Upload2pdfOnSamePage(webDriver);
		ContributorUpload211.Upload2pdfOnSame(file_path_abs);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload3pdfOnSamePage contributorUpload3 = new Upload3pdfOnSamePage(webDriver);
		contributorUpload3.Upload3pdfOnSame(file_path_abs);
		CoreUtils.clickContinue(webDriver);
		assertEquals("", webDriver.getTitle());
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Review".equals(webDriver.findElement(By.cssSelector("h2")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[4]/div/div[2]/p/a")));
		webDriver.findElement(By.xpath("//div[4]/div/div[2]/p/a")).click();
		assertEquals("", webDriver.getTitle());
		CoreUtils.clickContinue(webDriver);
		assertEquals("", webDriver.getTitle());
		CoreUtils.clickContinue(webDriver);
		assertEquals("", webDriver.getTitle());
		try {
			CoreUtils.clickContinue(webDriver);
			// webDriver.switchTo().alert().accept();
		} catch (Error e) {
			logger.info(e.getMessage());
		}
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/div/section/div/div[2]/table/tbody/tr/td/span"))
				.getText();
		Expected_Text = "Complete";
		assertEquals(Actual_Text, Expected_Text);
		WebElement EligibilityCompleteStatus1 = webDriver
				.findElement(By.xpath("//div[3]/div/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, EligibilityCompleteStatus1);
	}
}
