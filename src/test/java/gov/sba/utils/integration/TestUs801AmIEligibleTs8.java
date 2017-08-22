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

public class TestUs801AmIEligibleTs8 extends TestCase {
	private static final Logger logger = LogManager.getLogger(TestUs801AmIEligibleTs8.class.getName());
	public WebDriver webDriver;
	String naics;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();

		webDriver.get(TestHelpers.getBaseUrl());
		// webDriver.manage().window().maximize();
		naics = "315220";
	}

	@Test
	public void testUs801AmIEligibleTs8() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		if (webDriver.getCurrentUrl().contains("qa.sba-one")) {
			try {
				// Open Firefox,Chrome or IE and navigate to the certify.sba.gov
				// landing
				// page.
				logger.info(
						"User is NOT eligible for Any of the programs because user answer NO for Qs7 and the rest of the questions that apply: 8(a), WOSB, EDWOSB & Hob-zone");
				WebDriverWait wait = new WebDriverWait(webDriver, 30);
				// Locate the Am I Eligible or the Find Out button on the
				// Certify.SBA.Gov landing page and click on it.
				webDriver.findElement(By.xpath("//div[@id='header_nav']/header/nav/div/ul/li[3]/a/span")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(".//*[@id='am-i']/h1"), false));
				// Verify that user is navigated to the right page.
				String actual_error6 = webDriver.findElement(By.xpath(".//*[@id='am-i']/h1")).getText();
				String expected_error6 = "Is there an SBA Contracting Program for me?";
				assertEquals(actual_error6, expected_error6);
				// Locate the first question and select Yes and verify the More
				// Detail
				// meaning of the question.
				String actual_Text2 = webDriver.findElement(By.cssSelector("div.usa-width-one-half > p.lead-para"))
						.getText();
				String expected_Text2 = "Are the qualifying individual(s) of the firm who are applying for SBA small business programs U.S. citizens?";
				assertEquals(actual_Text2, expected_Text2);
				// Validate the meaning for question one.
				String actual_Text3 = webDriver.findElement(By.cssSelector("div.details.usa-width-one-half > p"))
						.getText();
				String expected_Text3 = "A U.S.citizenmeans a person born or naturalized in the United States. Resident aliens and holders of permanent visas are not considered to be citizens for program purposes.";
				assertEquals(actual_Text3, expected_Text3);
				// verify and click on the Yes button.
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.cssSelector("button.yes_button")));
				webDriver.findElement(By.cssSelector("button.yes_button")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(
						By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p"), false));
				// Locate the 2nd question and select No and verify the More
				// Detail
				// meaning of the question.
				String actual_error3 = webDriver
						.findElement(By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p")).getText();
				String expected_error3 = "Is the 51% ownership of the firm unconditional and direct?";
				assertEquals(actual_error3, expected_error3);
				// Verify the detail meaning for the 2nd question.
				String actual_error = webDriver
						.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li"))
						.getText();
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
				wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//div[@id='for_profit']/div/div/p"),
						false));
				// Locate the Third question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text6 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div/p")).getText();
				String expected_Text6 = "Is the firm organized for profit?";
				assertEquals(actual_Text6, expected_Text6);
				logger.info("Third question was validated");
				// Validate the More details text.
				String actual_Text7 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li"))
						.getText();
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
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("yes_button_for_profit")));
				webDriver.findElement(By.id("yes_button_for_profit")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='non_suspended']/div/div/p"), false));
				// Locate the 4th question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text10 = webDriver.findElement(By.xpath("//div[@id='non_suspended']/div/div/p"))
						.getText();
				String expected_Text10 = "Do you affirm that neither this firm, nor any of its owners, have ever been debarred or suspended by any federal entity?";
				assertEquals(actual_Text10, expected_Text10);
				logger.info("4th question was validated");
				String actual_Text11 = webDriver.findElement(By.xpath("//div[@id='non_suspended']/div/div[2]/p"))
						.getText();
				String expected_Text11 = "Debarred or suspended firms or firms owned by debarred or suspended individual(s) are ineligible for admission to SBA small business programs.";
				assertEquals(actual_Text11, expected_Text11);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("yes_button_non_suspended")));
				webDriver.findElement(By.id("yes_button_non_suspended")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//div[@id='us_business']/div/div/p"),
						false));
				// Locate the 5th question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text12 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div/p")).getText();
				String expected_Text12 = "Does the firm have a place of business in the U.S. and operate primarily within the United States, or makes a significant contribution to the U.S. economy through payment of taxes or use of American products, materials or labors?";
				assertEquals(actual_Text12, expected_Text12);
				logger.info("5th question was validated");
				String actual_Text13 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div[2]/p[2]"))
						.getText();
				String expected_Text13 = "None";
				assertEquals(actual_Text13, expected_Text13);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("yes_button_us_business")));
				webDriver.findElement(By.id("yes_button_us_business")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//div[@id='small_naics']/div/div/p"),
						false));
				// Locate the 6th question and select Yes and verify the More
				// Detail
				// meaning of the question.
				String actual_Text14 = webDriver.findElement(By.xpath("//div[@id='small_naics']/div/div/p")).getText();
				String expected_Text14 = "Is the firm considered small in accordance with its primary North American Industry Classification System (NAICS) code?";
				assertEquals(actual_Text14, expected_Text14);
				logger.info("6th question was validated");
				String actual_Text15 = webDriver.findElement(By.xpath("//div[@id='small_naics']/div/div[2]/ul/li"))
						.getText();
				String expected_Text15 = "SBA’s size standards define whether a business entity is small and, thus, eligible for Government programs and preferences reserved for “small business” concerns. Size standards have been established for types of economic activity, or industry, under the North American Industry Classification System (NAICS). To determine the size standard associated with a particular NAICS code, refer to the table of size standards in the Small Business Size Regulations, 13 CFR § 121.201. Size standards are expressed in annual receipts for services NAICS codes and in number of employees for manufacturing NAICS codes. Information about how SBA calculates a firm’s size can be found in the Code of Federal Regulations (CFR) at 13 CFR § 121.104 and 13 CFR § 121.106.";
				assertEquals(actual_Text15, expected_Text15);
				String actual_Text16 = webDriver.findElement(By.xpath("//div[@id='small_naics']/div/div[2]/ul/li[2]"))
						.getText();
				String expected_Text16 = "If you do not know the NAICS code(s) in which your business operates, please review the NAICS manual available at http://www.census.gov/eos/www/naics/.";
				assertEquals(actual_Text16, expected_Text16);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("yes_button_small_naics")));
				webDriver.findElement(By.id("yes_button_small_naics")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='women_owning_business']/div/div/p"), false));
				// Locate the 7th question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text17 = webDriver.findElement(By.xpath("//div[@id='women_owning_business']/div/div/p"))
						.getText();
				String expected_Text17 = "Are the qualifying individual(s) of the firm women who own at least 51% of the firm?";
				assertEquals(actual_Text17, expected_Text17);
				logger.info("7th question was validated");
				String actual_Text18 = webDriver
						.findElement(By.xpath("//div[@id='women_owning_business']/div/div[2]/p")).getText();
				String expected_Text18 = "None";
				assertEquals(actual_Text18, expected_Text18);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_women_owning_business")));
				webDriver.findElement(By.id("no_button_women_owning_business")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='naics_fed_set_asides']/div/div/p"), false));
				// Verify that user is being navigated to the 10th question
				// because
				// user select NO for the 7th question.
				String actual_Text19 = webDriver.findElement(By.xpath("//div[@id='naics_fed_set_asides']/div/div/p"))
						.getText();
				String expected_Text19 = "Are WOSB Federal Contract Program set-asides available in your primary NAICS code?";
				assertEquals(actual_Text19, expected_Text19);
				logger.info("===Question 8 was not skipped after answering NO for question 7");
				// Validate the detail meaning for Q7
				String actual_Text20 = webDriver
						.findElement(By.xpath("//div[@id='naics_fed_set_asides']/div/div[2]/p[2]")).getText();
				String expected_Text20 = "The federal government may restrict competition under the WOSB Program only in certain industries.13 C.F.R. 127.500. SBA has designated those industries applicable to the WOSB Program by North American Industry Classification System (NAICS) code. There are two types of set-asides under the WOSB Program: set asides for Woman Owned Small Businesses and set asides for Economically Disadvantaged Woman Owned Small Businesses. The type of set-aside allowed under the WOSB Program is dictated by the applicable NAICS code of the solicitation. To learn more about the types of set-asides and the designations available via this program, please visitSBA.gov/WOSB.";
				assertEquals(actual_Text20, expected_Text20);
				String actual_Text21 = webDriver.findElement(By.cssSelector("label")).getText();
				String expected_Text21 = "Enter the NAICS code in which your business operates:";
				assertEquals(actual_Text21, expected_Text21);
				// Enter a valid NAICS Code.
				webDriver.findElement(By.id("naics_code")).sendKeys(naics);
				jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("naics_button")));
				webDriver.findElement(By.id("naics_button")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(
						By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div/p"), false));
				// Validate the detail meaning for Q8
				String actual_Text22 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div/p")).getText();
				String expected_Text22 = "Are the qualifying individual(s) economically disadvantaged women under the guidelines of the Women-Owned Small Business (WOSB) Program?";
				assertEquals(actual_Text22, expected_Text22);
				// Verify the detail meaning.
				String actual_Text23 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/p[2]"))
						.getText();
				String expected_Text23 = "Firms owned by economically disadvantaged women may qualify as Economically Disadvantaged Women-Owned Small Businesses (EDWOSBs) under the WOSB Program. Under this program, the determination of whether an individual is an economically disadvantaged woman requires an evaluation of her total assets, net worth, and personal income for the past three years. To be considered an economically disadvantaged woman for the WOSB program, the individual must meet the thresholds described below:";
				assertEquals(actual_Text23, expected_Text23);
				String actual_Text24 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/ul/li"))
						.getText();
				String expected_Text24 = "The woman’s total assets must be valued at $6 million or less. This calculation is based on the fair market value of all assets, including the primary residence and the value of the business concern. This calculation excludes funds invested in a qualified IRA account or other official retirement account that are unavailable until retirement age without a significant penalty.";
				assertEquals(actual_Text24, expected_Text24);
				String actual_Text25 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/ul/li[2]"))
						.getText();
				String expected_Text25 = "The woman’s net worth must be less than $750,000. This calculation excludes the woman’s ownership interest in the applicant concern, her equity interest in her primary personal residence, funds invested in a qualified IRA account or other official retirement account, and income received from an S Corp, LLC or partnership that was reinvested in the business or used for paying taxes arising in the normal course of operations of the business.";
				assertEquals(actual_Text25, expected_Text25);
				logger.info("===Question 9 was not skipped after answering NO for question 7");
				// Select NO for question 9.
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_economically_disadvantaged_wosb")));
				webDriver.findElement(By.id("no_button_economically_disadvantaged_wosb")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(
						By.xpath("//div[@id='economically_disadvantaged_8a']/div/div/p"), false));
				// Locate the 10th question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text26 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div/p")).getText();
				String expected_Text26 = "Are the individual(s) interested in participating in SBA small business programs economically disadvantaged under 8(a) BD Program guidelines?";
				assertEquals(actual_Text26, expected_Text26);
				logger.info("10th question was validated");
				// Validate the detail meaning.
				String actual_Text27 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/p[2]")).getText();
				String expected_Text27 = "Firms owned by economically disadvantaged individuals may qualify for the 8(a) BD Program. Under the 8(a) BD Program, the determination of whether an individual is economically disadvantaged requires an evaluation of the individual’s total assets, net worth, and personal income for the past three years. To be considered an economically disadvantaged individual for the 8(a) BD Program, the individual must meet the thresholds described below:";
				assertEquals(actual_Text27, expected_Text27);
				String actual_Text28 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li")).getText();
				String expected_Text28 = "The individual’s total assets must be valued at $4 million or less. This calculation is based on the fair market value of all assets, including the primary residence and the value of the business concern. This calculation excludes funds invested in a qualified IRA account or other official retirement account.";
				assertEquals(actual_Text28, expected_Text28);
				String actual_Text29 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li[2]"))
						.getText();
				String expected_Text29 = "The individual’s net worth must be less than $250,000. This calculation excludes the individual’s ownership interest in the applicant concern, the individual’s equity interest in his or her primary residence, funds invested in a qualified Individual Retirement Accounts (IRA) or other official retirement account that is unavailable until retirement age without a significant penalty, and income received from an S Corp, LLC or partnership that was reinvested in the business or used for paying taxes arising in the normal course of operations of the business.";
				assertEquals(actual_Text29, expected_Text29);
				String actual_Text30 = webDriver
						.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li[3]"))
						.getText();
				String expected_Text30 = "The individual’s personal income must be $250,000 or less. This calculation is based on the individual’s adjusted gross income averaged over the last three years.";
				assertEquals(actual_Text30, expected_Text30);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_economically_disadvantaged_8a")));
				webDriver.findElement(By.id("no_button_economically_disadvantaged_8a")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='socially_disadvantaged']/div/div/p"), false));
				// Verify that user is being navigated to the 13th question
				// because
				// user select NO for the 10th question.
				String actual_Text31 = webDriver.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div/p"))
						.getText();
				String expected_Text31 = "Do you identify as one of the following?";
				assertEquals(actual_Text31, expected_Text31);
				// Verify the detail meaning.
				String actual_Text32 = webDriver
						.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div[2]/ul/li[2]")).getText();
				String expected_Text32 = "If you are not a member of a presumed group, you may still be eligible for admission to the 8(a) BD program on a case-by-case basis if you demonstrate you have experienced bias of a chronic and substantial nature.";
				assertEquals(actual_Text32, expected_Text32);
				logger.info(
						"User Successfully navigated to the 13th question ':Do you identify as one of the following?'");
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_socially_disadvantaged")));
				webDriver.findElement(By.id("no_button_socially_disadvantaged")).click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(
						By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div/p"), false));
				// Locate the 14th question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text33 = webDriver
						.findElement(By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div/p")).getText();
				String expected_Text33 = "Do you consider yourself socially disadvantaged because of you experienced bias of a chronic and substantial nature?";
				assertEquals(actual_Text33, expected_Text33);
				logger.info("14th question was validated");
				// Validate the detail meaning.
				String actual_Text34 = webDriver
						.findElement(By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div[2]/p[2]")).getText();
				String expected_Text34 = "If you are not a member of a presumed group, you may still be eligible for admission to the 8(a) BD program on a case-by-case basis if you demonstrate you have experienced bias of a chronic and substantial nature.";
				assertEquals(actual_Text34, expected_Text34);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_socially_disadvantaged_chronic")));
				webDriver.findElement(By.id("no_button_socially_disadvantaged_chronic")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='eighta_certified']/div/div/p"), false));
				// Locate the next question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text35 = webDriver.findElement(By.xpath("//div[@id='eighta_certified']/div/div/p"))
						.getText();
				String expected_Text35 = "Has the firm previously been certified as an 8(a) participant?";
				assertEquals(actual_Text35, expected_Text35);
				logger.info("15th question was validated");
				// Verify the detail meaning.
				String actual_Text36 = webDriver
						.findElement(By.xpath("//div[@id='eighta_certified']/div/div[2]/ul/li[2]")).getText();
				String expected_Text36 = "This applies to any business that previously participated in the 8(a) BD Program, even if ownership and control of the firm has completely changed.";
				assertEquals(actual_Text36, expected_Text36);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_eighta_certified")));
				webDriver.findElement(By.id("no_button_eighta_certified")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='eighta_one_time_used']/div/div/p"), false));
				// Locate the next question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text37 = webDriver.findElement(By.xpath("//div[@id='eighta_one_time_used']/div/div/p"))
						.getText();
				String expected_Text37 = "Have any individual(s) claiming social and economic disadvantage previously used their one time 8(a) eligibility to qualify a business for the 8(a) BD Program?";
				assertEquals(actual_Text37, expected_Text37);
				logger.info("Claiming EDWOSB question was validated");
				// Validate the detail meaning.
				String actual_Text38 = webDriver
						.findElement(By.xpath("//div[@id='eighta_one_time_used']/div/div[2]/ul/li")).getText();
				String expected_Text38 = "If you are not a member of a presumed group, you may still be eligible for admission to the 8(a) BD program on a case-by-case basis if you demonstrate you have experienced bias of a chronic and substantial nature.";
				assertEquals(actual_Text38, expected_Text38);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_eighta_one_time_used")));
				webDriver.findElement(By.id("no_button_eighta_one_time_used")).click();
				wait.until(ExpectedConditions
						.elementSelectionStateToBe(By.xpath("//div[@id='address_in_hubzone']/div/div/p"), false));
				// Locate the next question and select NO and verify the More
				// Detail
				// meaning of the question.
				String actual_Text39 = webDriver.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div/p"))
						.getText();
				String expected_Text39 = "Is the address of the location where the majority of the firm’s employees work located in a HUBZone?";
				assertEquals(actual_Text39, expected_Text39);
				logger.info(" question was validated");
				// Verify the detail meaning.
				String actual_Text40 = webDriver
						.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div[2]/ul/li")).getText();
				String expected_Text40 = "The Historically Underutilized Business Zone (HUBZone) program provides federal contracting assistance for qualified small business firms located in HUBZones in an effort to increase employment opportunities, investment, and economic development in such areas.";
				assertEquals(actual_Text40, expected_Text40);
				String actual_Text41 = webDriver
						.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div[2]/ul/li[2]")).getText();
				String expected_Text41 = "Use the HUBZone Map to find out if your principal office is located in a HUBZone.";
				assertEquals(actual_Text41, expected_Text41);
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.id("no_button_address_in_hubzone")));
				webDriver.findElement(By.id("no_button_address_in_hubzone")).click();
				// Verify searched results.
				wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("div.not_eligible"), false));
				// 8(a)
				String actual_Text4 = webDriver.findElement(By.cssSelector("div.not_eligible")).getText();
				String expected_Text4 = "Based on the information you provided, you may not be eligible for the 8(a) BD Program:\nQualifying individuals must meet the economically disadvantaged financial criteria to participate in the program. However, many factors are taken into consideration during application review and it is possible that you may still qualify to participate. Contact your local SBA 8(a) Business Office for more information.\nQualifying individuals must meet socially disadvantaged criteria in order to participate in the program.";
				assertEquals(actual_Text4, expected_Text4);
				// Women-Owned Small Business (WOSB)
				String actual_Text5 = webDriver.findElement(By.cssSelector("#wosb > div.not_eligible")).getText();
				String expected_Text5 = "Based on the information you provided, you may not be eligible for the WOSB Program:\nTo certify as a WOSB or EDWOSB the firm must be owned by women.";
				assertEquals(actual_Text5, expected_Text5);
				// Economically Disadvantaged Women-Owned Small Business
				// (EDWOSB)
				String actual_Text42 = webDriver.findElement(By.cssSelector("#edwosb > div.not_eligible")).getText();
				String expected_Text42 = "Based on the information you provided, you may not be eligible for the EDWOSB Program:\nTo certify as a WOSB or EDWOSB the firm must be owned by women.\nTo qualify for EDWOSB the firm must be economically disadvantaged.";
				assertEquals(actual_Text42, expected_Text42);
				// Historically Underutilized Business Zone (HUBZone) Program
				String actual_Text43 = webDriver.findElement(By.cssSelector("#hubzone > div.not_eligible > b"))
						.getText();
				String expected_Text43 = "Based on the information you provided, you may not be eligible for the HUBZone Program:";
				assertEquals(actual_Text43, expected_Text43);
			} catch (Exception e) {
				ScreenShotPage screenShot = new ScreenShotPage(webDriver);
				screenShot.ScreenShot();
				logger.info(e.getMessage());
				Assert.fail();
			}
		} else {
			if (webDriver.getCurrentUrl().contains("staging")) {
				try {
					// Open Firefox,Chrome or IE and navigate to the
					// certify.sba.gov
					// landing
					// page.
					logger.info(
							"User is NOT eligible for Any of the programs because user answer NO for Qs7 and the rest of the questions that apply: 8(a), WOSB, EDWOSB & Hob-zone");
					WebDriverWait wait = new WebDriverWait(webDriver, 30);
					// Locate the Am I Eligible or the Find Out button on the
					// Certify.SBA.Gov landing page and click on it.
					webDriver.findElement(By.xpath("//div[@id='header_nav']/header/nav/div/ul/li[3]/a/span")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(".//*[@id='am-i']/h1"), false));
					// Verify that user is navigated to the right page.
					String actual_error6 = webDriver.findElement(By.xpath(".//*[@id='am-i']/h1")).getText();
					String expected_error6 = "Is there an SBA Contracting Program for me?";
					assertEquals(actual_error6, expected_error6);
					// Locate the first question and select Yes and verify the
					// More
					// Detail
					// meaning of the question.
					String actual_Text2 = webDriver.findElement(By.cssSelector("div.usa-width-one-half > p.lead-para"))
							.getText();
					String expected_Text2 = "Are the qualifying individual(s) of the firm who are applying for SBA small business programs U.S. citizens?";
					assertEquals(actual_Text2, expected_Text2);
					// Validate the meaning for question one.
					String actual_Text3 = webDriver.findElement(By.cssSelector("div.details.usa-width-one-half > p"))
							.getText();
					String expected_Text3 = "A U.S.citizenmeans a person born or naturalized in the United States. Resident aliens and holders of permanent visas are not considered to be citizens for program purposes.";
					assertEquals(actual_Text3, expected_Text3);
					// verify and click on the Yes button.
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.cssSelector("button.yes_button")));
					webDriver.findElement(By.cssSelector("button.yes_button")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(
							By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p"), false));
					// Locate the 2nd question and select No and verify the More
					// Detail
					// meaning of the question.
					String actual_error3 = webDriver
							.findElement(By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/p"))
							.getText();
					String expected_error3 = "Is the 51% ownership of the firm unconditional and direct?";
					assertEquals(actual_error3, expected_error3);
					// Verify the detail meaning for the 2nd question.
					String actual_error = webDriver
							.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li"))
							.getText();
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
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='for_profit']/div/div/p"), false));
					// Locate the Third question and select NO and verify the
					// More
					// Detail
					// meaning of the question.
					String actual_Text6 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div/p"))
							.getText();
					String expected_Text6 = "Is the firm organized for profit?";
					assertEquals(actual_Text6, expected_Text6);
					logger.info("Third question was validated");
					// Validate the More details text.
					String actual_Text7 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li"))
							.getText();
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
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("yes_button_for_profit")));
					webDriver.findElement(By.id("yes_button_for_profit")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='non_suspended']/div/div/p"), false));
					// Locate the 4th question and select NO and verify the More
					// Detail
					// meaning of the question.
					String actual_Text10 = webDriver.findElement(By.xpath("//div[@id='non_suspended']/div/div/p"))
							.getText();
					String expected_Text10 = "Do you affirm that neither this firm, nor any of its owners, have ever been debarred or suspended by any federal entity?";
					assertEquals(actual_Text10, expected_Text10);
					logger.info("4th question was validated");
					String actual_Text11 = webDriver.findElement(By.xpath("//div[@id='non_suspended']/div/div[2]/p"))
							.getText();
					String expected_Text11 = "Debarred or suspended firms or firms owned by debarred or suspended individual(s) are ineligible for admission to SBA small business programs.";
					assertEquals(actual_Text11, expected_Text11);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("yes_button_non_suspended")));
					webDriver.findElement(By.id("yes_button_non_suspended")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='us_business']/div/div/p"), false));
					// Locate the 5th question and select NO and verify the More
					// Detail
					// meaning of the question.
					String actual_Text12 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div/p"))
							.getText();
					String expected_Text12 = "Does the firm have a place of business in the U.S. and operate primarily within the United States, or makes a significant contribution to the U.S. economy through payment of taxes or use of American products, materials or labors?";
					assertEquals(actual_Text12, expected_Text12);
					logger.info("5th question was validated");
					String actual_Text13 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div[2]/p[2]"))
							.getText();
					String expected_Text13 = "None";
					assertEquals(actual_Text13, expected_Text13);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("yes_button_us_business")));
					webDriver.findElement(By.id("yes_button_us_business")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='small_naics']/div/div/p"), false));
					// Locate the 6th question and select Yes and verify the
					// More Detail
					// meaning of the question.
					String actual_Text14 = webDriver.findElement(By.xpath("//div[@id='small_naics']/div/div/p"))
							.getText();
					String expected_Text14 = "Is the firm considered small in accordance with its primary North American Industry Classification System (NAICS) code?";
					assertEquals(actual_Text14, expected_Text14);
					logger.info("6th question was validated");
					String actual_Text15 = webDriver.findElement(By.xpath("//div[@id='small_naics']/div/div[2]/ul/li"))
							.getText();
					String expected_Text15 = "SBA’s size standards define whether a business entity is small and, thus, eligible for Government programs and preferences reserved for “small business” concerns. Size standards have been established for types of economic activity, or industry, under the North American Industry Classification System (NAICS). To determine the size standard associated with a particular NAICS code, refer to the table of size standards in the Small Business Size Regulations, 13 CFR § 121.201. Size standards are expressed in annual receipts for services NAICS codes and in number of employees for manufacturing NAICS codes. Information about how SBA calculates a firm’s size can be found in the Code of Federal Regulations (CFR) at 13 CFR § 121.104 and 13 CFR § 121.106.";
					assertEquals(actual_Text15, expected_Text15);
					String actual_Text16 = webDriver
							.findElement(By.xpath("//div[@id='small_naics']/div/div[2]/ul/li[2]")).getText();
					String expected_Text16 = "If you do not know the NAICS code(s) in which your business operates, please review the NAICS manual available at http://www.census.gov/eos/www/naics/.";
					assertEquals(actual_Text16, expected_Text16);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("yes_button_small_naics")));
					webDriver.findElement(By.id("yes_button_small_naics")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(
							By.xpath("//div[@id='women_owning_business']/div/div/p"), false));
					// Locate the 7th question and select NO and verify the More
					// Detail
					// meaning of the question.
					String actual_Text17 = webDriver
							.findElement(By.xpath("//div[@id='women_owning_business']/div/div/p")).getText();
					String expected_Text17 = "Are the qualifying individual(s) of the firm women who own at least 51% of the firm?";
					assertEquals(actual_Text17, expected_Text17);
					logger.info("7th question was validated");
					String actual_Text18 = webDriver
							.findElement(By.xpath("//div[@id='women_owning_business']/div/div[2]/p")).getText();
					String expected_Text18 = "None";
					assertEquals(actual_Text18, expected_Text18);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_women_owning_business")));
					webDriver.findElement(By.id("no_button_women_owning_business")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='naics_fed_set_asides']/div/div/p"), false));
					// Verify that user is being navigated to the 10th question
					// because
					// user select NO for the 7th question.
					String actual_Text19 = webDriver
							.findElement(By.xpath("//div[@id='naics_fed_set_asides']/div/div/p")).getText();
					String expected_Text19 = "Are WOSB Federal Contract Program set-asides available in your primary NAICS code?";
					assertEquals(actual_Text19, expected_Text19);
					logger.info("===Question 8 was not skipped after answering NO for question 7");
					// Validate the detail meaning for Q7
					String actual_Text20 = webDriver
							.findElement(By.xpath("//div[@id='naics_fed_set_asides']/div/div[2]/p[2]")).getText();
					String expected_Text20 = "The federal government may restrict competition under the WOSB Program only in certain industries.13 C.F.R. 127.500. SBA has designated those industries applicable to the WOSB Program by North American Industry Classification System (NAICS) code. There are two types of set-asides under the WOSB Program: set asides for Woman Owned Small Businesses and set asides for Economically Disadvantaged Woman Owned Small Businesses. The type of set-aside allowed under the WOSB Program is dictated by the applicable NAICS code of the solicitation. To learn more about the types of set-asides and the designations available via this program, please visitSBA.gov/WOSB.";
					assertEquals(actual_Text20, expected_Text20);
					String actual_Text21 = webDriver.findElement(By.cssSelector("label")).getText();
					String expected_Text21 = "Enter the NAICS code in which your business operates:";
					assertEquals(actual_Text21, expected_Text21);
					// Enter a valid NAICS Code.
					webDriver.findElement(By.id("naics_code")).sendKeys(naics);
					jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("naics_button")));
					webDriver.findElement(By.id("naics_button")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(
							By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div/p"), false));
					// Validate the detail meaning for Q8
					String actual_Text22 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div/p")).getText();
					String expected_Text22 = "Are the qualifying individual(s) economically disadvantaged women under the guidelines of the Women-Owned Small Business (WOSB) Program?";
					assertEquals(actual_Text22, expected_Text22);
					// Verify the detail meaning.
					String actual_Text23 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/p[2]"))
							.getText();
					String expected_Text23 = "Firms owned by economically disadvantaged women may qualify as Economically Disadvantaged Women-Owned Small Businesses (EDWOSBs) under the WOSB Program. Under this program, the determination of whether an individual is an economically disadvantaged woman requires an evaluation of her total assets, net worth, and personal income for the past three years. To be considered an economically disadvantaged woman for the WOSB program, the individual must meet the thresholds described below:";
					assertEquals(actual_Text23, expected_Text23);
					String actual_Text24 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/ul/li"))
							.getText();
					String expected_Text24 = "The woman’s total assets must be valued at $6 million or less. This calculation is based on the fair market value of all assets, including the primary residence and the value of the business concern. This calculation excludes funds invested in a qualified IRA account or other official retirement account that are unavailable until retirement age without a significant penalty.";
					assertEquals(actual_Text24, expected_Text24);
					String actual_Text25 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/ul/li[2]"))
							.getText();
					String expected_Text25 = "The woman’s net worth must be less than $750,000. This calculation excludes the woman’s ownership interest in the applicant concern, her equity interest in her primary personal residence, funds invested in a qualified IRA account or other official retirement account, and income received from an S Corp, LLC or partnership that was reinvested in the business or used for paying taxes arising in the normal course of operations of the business.";
					assertEquals(actual_Text25, expected_Text25);
					logger.info("===Question 9 was not skipped after answering NO for question 7");
					// Select NO for question 9.
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_economically_disadvantaged_wosb")));
					webDriver.findElement(By.id("no_button_economically_disadvantaged_wosb")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(
							By.xpath("//div[@id='economically_disadvantaged_8a']/div/div/p"), false));
					// Locate the 10th question and select NO and verify the
					// More Detail
					// meaning of the question.
					String actual_Text26 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div/p")).getText();
					String expected_Text26 = "Are the individual(s) interested in participating in SBA small business programs economically disadvantaged under 8(a) BD Program guidelines?";
					assertEquals(actual_Text26, expected_Text26);
					logger.info("10th question was validated");
					// Validate the detail meaning.
					String actual_Text27 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/p[2]"))
							.getText();
					String expected_Text27 = "Firms owned by economically disadvantaged individuals may qualify for the 8(a) BD Program. Under the 8(a) BD Program, the determination of whether an individual is economically disadvantaged requires an evaluation of the individual’s total assets, net worth, and personal income for the past three years. To be considered an economically disadvantaged individual for the 8(a) BD Program, the individual must meet the thresholds described below:";
					assertEquals(actual_Text27, expected_Text27);
					String actual_Text28 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li"))
							.getText();
					String expected_Text28 = "The individual’s total assets must be valued at $4 million or less. This calculation is based on the fair market value of all assets, including the primary residence and the value of the business concern. This calculation excludes funds invested in a qualified IRA account or other official retirement account.";
					assertEquals(actual_Text28, expected_Text28);
					String actual_Text29 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li[2]"))
							.getText();
					String expected_Text29 = "The individual’s net worth must be less than $250,000. This calculation excludes the individual’s ownership interest in the applicant concern, the individual’s equity interest in his or her primary residence, funds invested in a qualified Individual Retirement Accounts (IRA) or other official retirement account that is unavailable until retirement age without a significant penalty, and income received from an S Corp, LLC or partnership that was reinvested in the business or used for paying taxes arising in the normal course of operations of the business.";
					assertEquals(actual_Text29, expected_Text29);
					String actual_Text30 = webDriver
							.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li[3]"))
							.getText();
					String expected_Text30 = "The individual’s personal income must be $250,000 or less. This calculation is based on the individual’s adjusted gross income averaged over the last three years.";
					assertEquals(actual_Text30, expected_Text30);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_economically_disadvantaged_8a")));
					webDriver.findElement(By.id("no_button_economically_disadvantaged_8a")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(
							By.xpath("//div[@id='socially_disadvantaged']/div/div/p"), false));
					// Verify that user is being navigated to the 13th question
					// because
					// user select NO for the 10th question.
					String actual_Text31 = webDriver
							.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div/p")).getText();
					String expected_Text31 = "Do you identify as one of the following?";
					assertEquals(actual_Text31, expected_Text31);
					// Verify the detail meaning.
					String actual_Text32 = webDriver
							.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div[2]/ul/li[2]")).getText();
					String expected_Text32 = "If you are not a member of a presumed group, you may still be eligible for admission to the 8(a) BD program on a case-by-case basis if you demonstrate you have experienced bias of a chronic and substantial nature.";
					assertEquals(actual_Text32, expected_Text32);
					logger.info(
							"User Successfully navigated to the 13th question ':Do you identify as one of the following?'");
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_socially_disadvantaged")));
					webDriver.findElement(By.id("no_button_socially_disadvantaged")).click();
					wait.until(ExpectedConditions.elementSelectionStateToBe(
							By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div/p"), false));
					// Locate the 14th question and select NO and verify the
					// More Detail
					// meaning of the question.
					String actual_Text33 = webDriver
							.findElement(By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div/p")).getText();
					String expected_Text33 = "Do you consider yourself socially disadvantaged because of you experienced bias of a chronic and substantial nature?";
					assertEquals(actual_Text33, expected_Text33);
					logger.info("14th question was validated");
					// Validate the detail meaning.
					String actual_Text34 = webDriver
							.findElement(By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div[2]/p[2]"))
							.getText();
					String expected_Text34 = "If you are not a member of a presumed group, you may still be eligible for admission to the 8(a) BD program on a case-by-case basis if you demonstrate you have experienced bias of a chronic and substantial nature.";
					assertEquals(actual_Text34, expected_Text34);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_socially_disadvantaged_chronic")));
					webDriver.findElement(By.id("no_button_socially_disadvantaged_chronic")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='eighta_certified']/div/div/p"), false));
					// Locate the next question and select NO and verify the
					// More Detail
					// meaning of the question.
					String actual_Text35 = webDriver.findElement(By.xpath("//div[@id='eighta_certified']/div/div/p"))
							.getText();
					String expected_Text35 = "Has the firm previously been certified as an 8(a) participant?";
					assertEquals(actual_Text35, expected_Text35);
					logger.info("15th question was validated");
					// Verify the detail meaning.
					String actual_Text36 = webDriver
							.findElement(By.xpath("//div[@id='eighta_certified']/div/div[2]/ul/li[2]")).getText();
					String expected_Text36 = "This applies to any business that previously participated in the 8(a) BD Program, even if ownership and control of the firm has completely changed.";
					assertEquals(actual_Text36, expected_Text36);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_eighta_certified")));
					webDriver.findElement(By.id("no_button_eighta_certified")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='eighta_one_time_used']/div/div/p"), false));
					// Locate the next question and select NO and verify the
					// More Detail
					// meaning of the question.
					String actual_Text37 = webDriver
							.findElement(By.xpath("//div[@id='eighta_one_time_used']/div/div/p")).getText();
					String expected_Text37 = "Have any individual(s) claiming social and economic disadvantage previously used their one time 8(a) eligibility to qualify a business for the 8(a) BD Program?";
					assertEquals(actual_Text37, expected_Text37);
					logger.info("Claiming EDWOSB question was validated");
					// Validate the detail meaning.
					String actual_Text38 = webDriver
							.findElement(By.xpath("//div[@id='eighta_one_time_used']/div/div[2]/ul/li")).getText();
					String expected_Text38 = "If you are not a member of a presumed group, you may still be eligible for admission to the 8(a) BD program on a case-by-case basis if you demonstrate you have experienced bias of a chronic and substantial nature.";
					assertEquals(actual_Text38, expected_Text38);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_eighta_one_time_used")));
					webDriver.findElement(By.id("no_button_eighta_one_time_used")).click();
					wait.until(ExpectedConditions
							.elementSelectionStateToBe(By.xpath("//div[@id='address_in_hubzone']/div/div/p"), false));
					// Locate the next question and select NO and verify the
					// More Detail
					// meaning of the question.
					String actual_Text39 = webDriver.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div/p"))
							.getText();
					String expected_Text39 = "Is the address of the location where the majority of the firm’s employees work located in a HUBZone?";
					assertEquals(actual_Text39, expected_Text39);
					logger.info(" question was validated");
					// Verify the detail meaning.
					String actual_Text40 = webDriver
							.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div[2]/ul/li")).getText();
					String expected_Text40 = "The Historically Underutilized Business Zone (HUBZone) program provides federal contracting assistance for qualified small business firms located in HUBZones in an effort to increase employment opportunities, investment, and economic development in such areas.";
					assertEquals(actual_Text40, expected_Text40);
					String actual_Text41 = webDriver
							.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div[2]/ul/li[2]")).getText();
					String expected_Text41 = "Use the HUBZone Map to find out if your principal office is located in a HUBZone.";
					assertEquals(actual_Text41, expected_Text41);
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.id("no_button_address_in_hubzone")));
					webDriver.findElement(By.id("no_button_address_in_hubzone")).click();
					// Verify searched results.
					wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("div.not_eligible"), false));
					// 8(a)
					String actual_Text4 = webDriver.findElement(By.cssSelector("div.not_eligible")).getText();
					String expected_Text4 = "Based on the information you provided, you may not be eligible for the 8(a) BD Program:\nQualifying individuals must meet the economically disadvantaged financial criteria to participate in the program. However, many factors are taken into consideration during application review and it is possible that you may still qualify to participate. Contact your local SBA 8(a) Business Office for more information.\nQualifying individuals must meet socially disadvantaged criteria in order to participate in the program.";
					assertEquals(actual_Text4, expected_Text4);
					// Women-Owned Small Business (WOSB)
					String actual_Text5 = webDriver.findElement(By.cssSelector("#wosb > div.not_eligible")).getText();
					String expected_Text5 = "Based on the information you provided, you may not be eligible for the WOSB Program:\nTo certify as a WOSB or EDWOSB the firm must be owned by women.";
					assertEquals(actual_Text5, expected_Text5);
					// Economically Disadvantaged Women-Owned Small Business
					// (EDWOSB)
					String actual_Text42 = webDriver.findElement(By.cssSelector("#edwosb > div.not_eligible"))
							.getText();
					String expected_Text42 = "Based on the information you provided, you may not be eligible for the EDWOSB Program:\nTo certify as a WOSB or EDWOSB the firm must be owned by women.\nTo qualify for EDWOSB the firm must be economically disadvantaged.";
					assertEquals(actual_Text42, expected_Text42);
					// Historically Underutilized Business Zone (HUBZone)
					// Program
					String actual_Text43 = webDriver.findElement(By.cssSelector("#hubzone > div.not_eligible > b"))
							.getText();
					String expected_Text43 = "Based on the information you provided, you may not be eligible for the HUBZone Program:";
					assertEquals(actual_Text43, expected_Text43);
				} catch (Exception e) {
					ScreenShotPage screenShot = new ScreenShotPage(webDriver);
					screenShot.ScreenShot();
					logger.info(e.getMessage());
					Assert.fail();
				}
			} else {

				if (webDriver.getCurrentUrl().contains("localhost")) {
					logger.info("Success No NAICS in local ENV");
				} else {
					logger.info("Please make sure the env you are running the test is added to the params, fyi env is "
							+ webDriver.getCurrentUrl());
					ScreenShotPage screenShot = new ScreenShotPage(webDriver);
					screenShot.ScreenShot();
					Assert.fail();
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
