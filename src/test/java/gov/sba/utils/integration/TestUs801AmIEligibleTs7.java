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

@Category({ gov.sba.utils.integration.StableTests.class, gov.sba.utils.integration.DericTests.class })

public class TestUs801AmIEligibleTs7 extends TestCase {
	private static final Logger logger = LogManager.getLogger(TestUs801AmIEligibleTs7.class.getName());
	public WebDriver webDriver;
	String naics;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();

		webDriver.get(TestHelpers.getBaseUrl());
		// webDriver.manage().window().maximize();
		naics = "335932";
	}

	@Test
	public void testUs801AmIEligibleTs7() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		try {
			// Open Firefox,Chrome or IE and navigate to the certify.sba.gov
			// landing
			// page.
			logger.info(
					"User is NOT eligible for Any of the programs because user answer NO for Qs6: 8(a), WOSB, EDWOSB & Hob-zone");
			WebDriverWait wait = new WebDriverWait(webDriver, 30);
			// Locate the Am I Eligible or the Find Out button on the
			// Certify.SBA.Gov landing page and click on it.
			webDriver.findElement(By.xpath("//div[@id='header_nav']/header/nav/div/ul/li[3]/a/span")).click();
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(".//*[@id='am-i']/h1"), false));
			// Verify that user navigates to the am i eligible page.
			String actual_Text = webDriver.findElement(By.xpath(".//*[@id='am-i']/h1")).getText();
			String expected_Text = "Is there an SBA Contracting Program for me?";
			assertEquals(expected_Text, actual_Text);
			// Locate the first question and select NO and verify the More
			// Detail
			// meaning of the question.
			String actual_Text2 = webDriver.findElement(By.cssSelector("div.usa-width-one-half > p.lead-para"))
					.getText();
			String expected_Text2 = "Are the qualifying individual(s) of the firm who are applying for SBA small business programs U.S. citizens?";
			assertEquals(actual_Text2, expected_Text2);
			// Validate the meaning for question one.
			String actual_Text3 = webDriver.findElement(By.cssSelector("div.details.usa-width-one-half > p")).getText();
			String expected_Text3 = "A U.S.citizenmeans a person born or naturalized in the United States. Resident aliens and holders of permanent visas are not considered to be citizens for program purposes.";
			assertEquals(actual_Text3, expected_Text3);
			// verify and click on the Yes button.
			jse.executeScript("arguments[0].scrollIntoView()",
					webDriver.findElement(By.cssSelector("button.yes_button")));
			webDriver.findElement(By.cssSelector("button.yes_button")).click();
			wait.until(ExpectedConditions.elementSelectionStateToBe(
					By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p"), false));
			// Locate the 2nd question and select yes and verify the More Detail
			// meaning of the question.
			String actual_error3 = webDriver
					.findElement(By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p")).getText();
			String expected_error3 = "Is the 51% ownership of the firm unconditional and direct?";
			assertEquals(actual_error3, expected_error3);
			// Verify the detail meaning for the 2nd question.
			String actual_error = webDriver
					.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li")).getText();
			String expected_error = "Qualifying individual(s) mustunconditionally and directly own and controlat least 51% of the business.";
			assertEquals(actual_error, expected_error);
			String actual_error4 = webDriver
					.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li[2]"))
					.getText();
			String expected_error4 = "In general, the 51%ownershipmay not be through another business entity.";
			assertEquals(actual_error4, expected_error4);
			String actual_error5 = webDriver
					.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li[3]"))
					.getText();
			String expected_error5 = "Controlmeans that both the long-term decision making and the day-to-day management of the business are controlled by qualifying individual(s).";
			assertEquals(actual_error5, expected_error5);
			// verify and click on the yes button.
			jse.executeScript("arguments[0].scrollIntoView()",
					webDriver.findElement(By.id("yes_button_unconditional_direct_51_percent")));
			webDriver.findElement(By.id("yes_button_unconditional_direct_51_percent")).click();
			wait.until(
					ExpectedConditions.elementSelectionStateToBe(By.xpath("//div[@id='for_profit']/div/div/p"), false));
			// Locate the Third question and select NO and verify the More
			// Detail
			// meaning of the question.
			String actual_Text6 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div/p")).getText();
			String expected_Text6 = "Is the firm organized for profit?";
			assertEquals(actual_Text6, expected_Text6);
			logger.info("Third question was validated");
			// Validate the More details text.
			String actual_Text7 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li")).getText();
			String expected_Text7 = "Non-profit entities are ineligible to participate in most SBA small business programs.";
			assertEquals(actual_Text7, expected_Text7);
			String actual_Text8 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li[2]"))
					.getText();
			String expected_Text8 = "The firm may be in the legal form of an individual proprietorship, partnership, limited liability company, S Corporation, or C Corporation.";
			assertEquals(actual_Text8, expected_Text8);
			String actual_Text9 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li[3]"))
					.getText();
			String expected_Text9 = "Exceptions: This rule does not necessarily apply to Community Development Corporations (CDC) or businesses interested in participating as mentors in Mentor Protégé programs.";
			assertEquals(actual_Text9, expected_Text9);
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("yes_button_for_profit")));
			webDriver.findElement(By.id("yes_button_for_profit")).click();
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//div[@id='non_suspended']/div/div/p"),
					false));
			// Locate the 4th question and select yes and verify the More Detail
			// meaning of the question.
			String actual_Text10 = webDriver.findElement(By.xpath("//div[@id='non_suspended']/div/div/p")).getText();
			String expected_Text10 = "Do you affirm that neither this firm, nor any of its owners, have ever been debarred or suspended by any federal entity?";
			assertEquals(actual_Text10, expected_Text10);
			logger.info("4th question was validated");
			String actual_Text11 = webDriver.findElement(By.xpath("//div[@id='non_suspended']/div/div[2]/p")).getText();
			String expected_Text11 = "Debarred or suspended firms or firms owned by debarred or suspended individual(s) are ineligible for admission to SBA small business programs.";
			assertEquals(actual_Text11, expected_Text11);
			jse.executeScript("arguments[0].scrollIntoView()",
					webDriver.findElement(By.id("yes_button_non_suspended")));
			webDriver.findElement(By.id("yes_button_non_suspended")).click();
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//div[@id='us_business']/div/div/p"),
					false));
			// Locate the 6th question and select Yes and verify the More Detail
			// meaning of the question.
			String actual_Text14 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div/p")).getText();
			String expected_Text14 = "Does the firm have a place of business in the U.S. and operate primarily within the United States, or makes a significant contribution to the U.S. economy through payment of taxes or use of American products, materials or labors?";
			assertEquals(actual_Text14, expected_Text14);
			logger.info("6th question was validated");
			String actual_Text15 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div[2]/p[2]"))
					.getText();
			String expected_Text15 = "None";
			assertEquals(actual_Text15, expected_Text15);
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("yes_button_us_business")));
			webDriver.findElement(By.id("yes_button_us_business")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("no_button_small_naics")));
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("no_button_small_naics")));
			webDriver.findElement(By.id("no_button_small_naics")).click();
			// Verify searched results.
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("span.message"), false));
			String actual_Text17 = webDriver.findElement(By.cssSelector("span.message")).getText();
			String expected_Text17 = "In order to participate in SBA small business programs, the firm must be designated as small in accordance with its primary NAICS code.";
			assertEquals(actual_Text17, expected_Text17);
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.linkText("Exit")));
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
