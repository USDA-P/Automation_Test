package gov.sba.utils;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class US801_Am_I_Eligible_TS9 {
	private static final Logger logger = LogManager.getLogger(Edith_Password_Regression_Test_1.class.getName());

	public WebDriver webDriver;
	String NAICS;

	@Before
	public void Setup() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		NAICS = "335932";
	}

	@Test
	public void MainTest() throws Exception {
		logger.info("User is eligible for ALL programs, 8(a), WOSB, EDWOSB & Hob-zone");
		// Locate the Am I Eligible or the Find Out button on the
		webDriver.findElement(By.linkText("Am I eligible?")).click();
		Thread.sleep(4000);

		// Verify that user is navigated to the right page.
		String actual_error6 = webDriver.findElement(By.xpath(".//*[@id='am-i']/h1")).getText();
		String expected_error6 = "Is there an SBA Small Business Program for me?";
		assertEquals(actual_error6, expected_error6);
		// Locate the first question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text2 = webDriver.findElement(By.cssSelector("div.usa-width-one-half > p.lead-para")).getText();
		String expected_Text2 = "Are the qualifying individual(s) of the firm who are applying for SBA small business programs U.S. citizens?";
		assertEquals(actual_Text2, expected_Text2);
		// Validate the meaning for question one.
		String actual_Text3 = webDriver.findElement(By.cssSelector("div.details.usa-width-one-half > p")).getText();
		String expected_Text3 = "A Citizen means a person born or naturalized in the United States. Resident ailens and holders of permanent visas are not considered to be citizens. 13 C.F.R. 127.102";
		assertEquals(actual_Text3, expected_Text3);
		// verify and click on the Yes button.
		webDriver.findElement(By.xpath(".//*[@id='us_citizen']/div[1]/div[1]/div/button[1]")).click();
		Thread.sleep(5000);
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
				.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li[2]")).getText();
		String expected_error4 = "In general, the 51%ownershipmay not be through another business entity.";
		assertEquals(actual_error4, expected_error4);
		String actual_error5 = webDriver
				.findElement(By.xpath("//div[@id='unconditional_direct_51_percent']/div/div[2]/ul/li[3]")).getText();
		String expected_error5 = "Controlmeans that both the long-term decision making and the day-to-day management of the business are controlled by qualifying individual(s).";
		assertEquals(actual_error5, expected_error5);
		Thread.sleep(4000);
		// verify and click on the No button.
		webDriver.findElement(By.xpath(".//*[@id='unconditional_direct_51_percent']/div[1]/div[1]/div/button[1]"))
				.click();

		Thread.sleep(5000);
		// Locate the 3rd question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_error7 = webDriver
				.findElement(By.cssSelector(
						"#for_profit > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_error7 = "Is the firm organized for profit?";
		assertEquals(actual_error7, expected_error7);
		// Verify the detail meaning for the 3rd question.
		String actual_error9 = webDriver
				.findElement(By.cssSelector(
						"#for_profit > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_error9 = "Non-profit entities are ineligible to participate in most SBA small business programs.";
		assertEquals(actual_error9, expected_error9);
		String actual_error10 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li[2]"))
				.getText();
		String expected_error10 = "The firm may be in the legal form of an individual proprietorship, partnership, limited liability company, S Corporation, or C Corporation.";
		assertEquals(actual_error10, expected_error10);
		String actual_error11 = webDriver.findElement(By.xpath("//div[@id='for_profit']/div/div[2]/ul/li[3]"))
				.getText();
		String expected_error11 = "Exceptions: This rule does not necessarily apply to a Community Development Corporations (CDC) or businesses interested in participating as mentors in Mentor Prot�g� programs.";
		assertEquals(actual_error11, expected_error11);
		Thread.sleep(4000);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#for_profit > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 4th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text4 = webDriver
				.findElement(By.cssSelector(
						"#non_suspended > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text4 = "Do you affirm that neither this firm, nor any of its owners, have ever been debarred or suspended by any federal entity?";
		assertEquals(actual_Text4, expected_Text4);
		// Verify the detail meaning for the 4th question.
		String actual_Text11 = webDriver
				.findElement(By.cssSelector(
						"#non_suspended > div.q.makeitonehundredpercent > div.details.usa-width-one-half > p"))
				.getText();
		String expected_Text11 = "Debarred or suspended firms or firms owned by debarred or suspended individual(s) are ineligible for admission to SBA small business programs.";
		assertEquals(actual_Text11, expected_Text11);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#non_suspended > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 5th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text12 = webDriver
				.findElement(By.cssSelector(
						"#us_business > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text12 = "Does the firm have a place of business in the U.S. and operate primarily within the United States, or makes a significant contribution to the U.S. economy through payment of taxes or use of American products, materials or labors?";
		assertEquals(actual_Text12, expected_Text12);
		// Verify the detail meaning for the 5th question.
		String actual_Text13 = webDriver.findElement(By.xpath("//div[@id='us_business']/div/div[2]/p[2]")).getText();
		String expected_Text13 = "None";
		assertEquals(actual_Text13, expected_Text13);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#us_business > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 6th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text14 = webDriver
				.findElement(By.cssSelector(
						"#small_naics > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text14 = "Is the firm considered small in accordance with its primary North American Industry Classification System (NAICS) code?";
		assertEquals(actual_Text14, expected_Text14);
		// Verify the detail meaning for the 6th question.
		String actual_Text15 = webDriver
				.findElement(By.cssSelector(
						"#small_naics > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text15 = "SBA�s size standards define whether a business entity is small and, thus, eligible for Government programs and preferences reserved for �small business� concerns. Size standards have been established for types of economic activity, or industry, under the North American Industry Classification System (NAICS). To determine the size standard associated with a particular NAICS code, refer to the table of size standards in theSmall Business Size Regulations, 13 CFR � 121.201. Size standards are expressed in annual receipts for services NAICS codes and in number of employees for manufacturing NAICS codes. Information about how SBA calculates a firm�s size can be found in the Code of Federal Regulations (CFR) at13 CFR � 121.104and13 CFR � 121.106.";
		assertEquals(actual_Text15, expected_Text15);
		String actual_Text16 = webDriver.findElement(By.xpath("//div[@id='small_naics']/div/div[2]/ul/li[2]"))
				.getText();
		String expected_Text16 = "If you do not know the NAICS code(s) in which your business operates, please review the NAICS manual available athttp://www.census.gov/eos/www/naics/";
		assertEquals(actual_Text16, expected_Text16);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#small_naics > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 7th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text17 = webDriver
				.findElement(By.cssSelector(
						"#women_owning_business > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text17 = "Are the qualifying individual(s) of the firm women who own at least 51% of the firm?";
		assertEquals(actual_Text17, expected_Text17);
		// Verify the detail meaning for the 7th question.
		String actual_Text18 = webDriver
				.findElement(By.cssSelector(
						"#women_owning_business > div.q.makeitonehundredpercent > div.details.usa-width-one-half > p"))
				.getText();
		String expected_Text18 = "To qualify for the WOSB Program, one or more women mustunconditionally and directly own and controlat least 51 percent of the business and be U.S. citizen(s).\n\nIn general, the 51 percentownershipmay not be through another business entity or trusts (including stock ownership plan), executory agreements, or other arrangements that cause or potentially cause ownership benefits to go to another. See 13 C.F.R. 127.201 for additional information.\n\nControlby one or more women means that both the long-term decision making and the day-to-day management and administration of the business operations are controlled by women. See 13 C.F.R. 127.202 for additional information.";
		assertEquals(actual_Text18, expected_Text18);
		String actual_Text19 = webDriver
				.findElement(By.cssSelector(
						"#women_owning_business > div.q.makeitonehundredpercent > div.details.usa-width-one-half > p"))
				.getText();
		String expected_Text19 = "To qualify for the WOSB Program, one or more women mustunconditionally and directly own and controlat least 51 percent of the business and be U.S. citizen(s).\n\nIn general, the 51 percentownershipmay not be through another business entity or trusts (including stock ownership plan), executory agreements, or other arrangements that cause or potentially cause ownership benefits to go to another. See 13 C.F.R. 127.201 for additional information.\n\nControlby one or more women means that both the long-term decision making and the day-to-day management and administration of the business operations are controlled by women. See 13 C.F.R. 127.202 for additional information.";
		assertEquals(actual_Text19, expected_Text19);
		String actual_Text20 = webDriver
				.findElement(By.cssSelector(
						"#women_owning_business > div.q.makeitonehundredpercent > div.details.usa-width-one-half > p"))
				.getText();
		String expected_Text20 = "To qualify for the WOSB Program, one or more women mustunconditionally and directly own and controlat least 51 percent of the business and be U.S. citizen(s).\n\nIn general, the 51 percentownershipmay not be through another business entity or trusts (including stock ownership plan), executory agreements, or other arrangements that cause or potentially cause ownership benefits to go to another. See 13 C.F.R. 127.201 for additional information.\n\nControlby one or more women means that both the long-term decision making and the day-to-day management and administration of the business operations are controlled by women. See 13 C.F.R. 127.202 for additional information.";
		assertEquals(actual_Text20, expected_Text20);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#women_owning_business > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 8th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text21 = webDriver
				.findElement(By.cssSelector(
						"#naics_fed_set_asides > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text21 = "Are WOSB Federal Contract Program set-asides available in your primary NAICS code?";
		assertEquals(actual_Text21, expected_Text21);
		// Verify the detail meaning for the 8th question.
		String actual_Text22 = webDriver.findElement(By.xpath("//div[@id='naics_fed_set_asides']/div/div[2]/p[2]"))
				.getText();
		String expected_Text22 = "The federal government may restrict competition under the WOSB Program only in certain industries.13 C.F.R. 127.500. SBA has designated those industries applicable to the WOSB Program by North American Industry Classification System (NAICS) code. If a contract is not assigned one of those designated NAICS codes, the contract cannot be set-aside under the WOSB Program.";
		assertEquals(actual_Text22, expected_Text22);
		String actual_Text23 = webDriver.findElement(By.xpath("//div[@id='naics_fed_set_asides']/div/div[2]/p[3]"))
				.getText();
		String expected_Text23 = "The most recent list of NAICS codes applicable to the WOSB Program can be found at SBA�s website atSBA.gov/WOSB.";
		assertEquals(actual_Text23, expected_Text23);
		// Enter valid NAICS Code.
		webDriver.findElement(By.id("naics_code")).sendKeys("335932");
		// verify and click on the Yes button.
		webDriver.findElement(By.id("naics_button")).click();
		Thread.sleep(5000);
		// Locate the 9th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text24 = webDriver
				.findElement(By.cssSelector(
						"#economically_disadvantaged_wosb > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text24 = "Are the qualifying individual(s) economically disadvantaged women under the guidelines of the Women-Owned Small Business (WOSB) Program?";
		assertEquals(actual_Text24, expected_Text24);
		// Verify the detail meaning for the 9th question.
		String actual_Text25 = webDriver
				.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/p[2]")).getText();
		String expected_Text25 = "Firms owned by economically disadvantaged women may qualify as Economically Disadvantaged Women-Owned Small Businesses (EDWOSBs) under the WOSB Program. Under this program, the determination of whether an individual is an economically disadvantaged woman requires an evaluation of her total assets, net worth, and personal income for the past three years. To be considered an economically disadvantaged woman for the WOSB program, the individual must meet the thresholds described below:";
		assertEquals(actual_Text25, expected_Text25);
		String actual_Text26 = webDriver
				.findElement(By.cssSelector(
						"#economically_disadvantaged_wosb > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text26 = "The woman�s total assets must be valued at $6 million or less. This calculation is based on the fair market value of all assets, including the primary residence and the value of the business concern. This calculation excludes funds invested in a qualified IRA account or other official retirement account that are unavailable until retirement age without a significant penalty.";
		assertEquals(actual_Text26, expected_Text26);
		String actual_Text27 = webDriver
				.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/ul/li[2]")).getText();
		String expected_Text27 = "The woman�s net worth must be less than $750,000. This calculation excludes the woman�s ownership interest in the applicant concern, her equity interest in her primary personal residence, funds invested in a qualified IRA account or other official retirement account, and income received from an S Corp, LLC or partnership that was reinvested in the business or used for paying taxes arising in the normal course of operations of the business.";
		assertEquals(actual_Text27, expected_Text27);
		String actual_Text28 = webDriver
				.findElement(By.xpath("//div[@id='economically_disadvantaged_wosb']/div/div[2]/ul/li[3]")).getText();
		String expected_Text28 = "The woman�s personal income must be $350,000 or less. This calculation is based on the woman�s adjusted gross income averaged over the last three years.";
		assertEquals(actual_Text28, expected_Text28);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#economically_disadvantaged_wosb > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 10th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text29 = webDriver
				.findElement(By.cssSelector(
						"#economically_disadvantaged_8a > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text29 = "Are the individual(s) interested in participating in SBA small business programs economically disadvantaged under 8(a) BD Program guidelines?";
		assertEquals(actual_Text29, expected_Text29);
		// Verify the detail meaning for the 10th question.
		String actual_Text30 = webDriver
				.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/p[2]")).getText();
		String expected_Text30 = "Firms owned by economically disadvantaged individuals may qualify for the 8(a) BD Program. Under the 8(a) BD Program, the determination of whether an individual is economically disadvantaged requires an evaluation of the individual�s total assets, net worth, and personal income for the past three years. To be considered an economically disadvantaged individual for the 8(a) BD Program, the individual must meet the thresholds described below:";
		assertEquals(actual_Text30, expected_Text30);
		String actual_Text31 = webDriver
				.findElement(By.cssSelector(
						"#economically_disadvantaged_8a > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text31 = "The individual�s total assets must be valued at $4 million or less. This calculation is based on the fair market value of all assets, including the primary residence and the value of the business concern. This calculation excludes funds invested in a qualified IRA account or other official retirement account.";
		assertEquals(actual_Text31, expected_Text31);
		String actual_Text32 = webDriver
				.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li[2]")).getText();
		String expected_Text32 = "The individual�s net worth must be less than $250,000. This calculation excludes the individual�s ownership interest in the applicant concern, the individual�s equity interest in his or her primary residence, funds invested in a qualified Individual Retirement Accounts (IRA) or other official retirement account that is unavailable until retirement age without a significant penalty, and income received from an S Corp, LLC or partnership that was reinvested in the business or used for paying taxes arising in the normal course of operations of the business.";
		assertEquals(actual_Text32, expected_Text32);
		String actual_Text33 = webDriver
				.findElement(By.xpath("//div[@id='economically_disadvantaged_8a']/div/div[2]/ul/li[3]")).getText();
		String expected_Text33 = "The individual�s personal income must be $250,000 or less. This calculation is based on the individual�s adjusted gross income averaged over the last three years.";
		assertEquals(actual_Text33, expected_Text33);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#economically_disadvantaged_8a > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 11th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text34 = webDriver
				.findElement(By.cssSelector(
						"#socially_disadvantaged > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text34 = "Do you identify as one of the following?";
		assertEquals(actual_Text34, expected_Text34);
		
		String actual_Text36 = webDriver
				.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div[2]/ul/li[2]")).getText();
		String expected_Text36 = "This applies to any business that previously participated in the 8(a) BD Program, even if ownership and control of the firm has completely changed.";
		assertEquals(actual_Text36, expected_Text36);
		// Validate all the race.
		String actual_Text37 = webDriver
				.findElement(By.cssSelector(
						"#socially_disadvantaged > div.q.makeitonehundredpercent > div.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text37 = "Black American";
		assertEquals(actual_Text37, expected_Text37);
		String actual_Text38 = webDriver.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div/ul/li[2]"))
				.getText();
		String expected_Text38 = "Asian Pacific American";
		assertEquals(actual_Text38, expected_Text38);
		String actual_Text39 = webDriver.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div/ul/li[3]"))
				.getText();
		String expected_Text39 = "Hispanic American";
		assertEquals(actual_Text39, expected_Text39);
		String actual_Text40 = webDriver.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div/ul/li[4]"))
				.getText();
		String expected_Text40 = "Native American";
		assertEquals(actual_Text40, expected_Text40);
		String actual_Text41 = webDriver.findElement(By.xpath("//div[@id='socially_disadvantaged']/div/div/ul/li[5]"))
				.getText();
		String expected_Text41 = "Subcontinent Asian American";
		assertEquals(actual_Text41, expected_Text41);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#socially_disadvantaged > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 12th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text42 = webDriver
				.findElement(By.cssSelector(
						"#socially_disadvantaged_chronic > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text42 = "Do you consider yourself socially disadvantaged because of you experienced bias of a chronic and substantial nature?";
		assertEquals(actual_Text42, expected_Text42);
		// Verify the detail meaning for the 12th question.
		String actual_Text43 = webDriver
				.findElement(By.xpath("//div[@id='socially_disadvantaged_chronic']/div/div[2]/p[2]")).getText();
		String expected_Text43 = "An individual or firm that previously participated in the 8(a) BD Program may still be eligible for other SBA small business programs.";
		assertEquals(actual_Text43, expected_Text43);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#socially_disadvantaged_chronic > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 13th question and select NO and verify the More Detail
		// meaning of the question.
		String actual_Text44 = webDriver
				.findElement(By.cssSelector(
						"#eighta_certified > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text44 = "Has the firm previously been certified as an 8(a) participant?";
		assertEquals(actual_Text44, expected_Text44);
		// Verify the detail meaning for the 13th question.
		String actual_Text45 = webDriver
				.findElement(By.cssSelector(
						"#eighta_certified > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text45 = "There is a �one time use of eligibility� restriction for individuals and firms to participate in the 8(a) BD Program.";
		assertEquals(actual_Text45, expected_Text45);
		String actual_Text46 = webDriver.findElement(By.xpath("//div[@id='eighta_certified']/div/div[2]/ul/li[2]"))
				.getText();
		String expected_Text46 = "This applies to any business that previously participated in the 8(a) BD Program, even if ownership and control of the firm has completely changed.";
		assertEquals(actual_Text46, expected_Text46);
		// verify and click on the NO button.
		webDriver
				.findElement(By.cssSelector(
						"#eighta_certified > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.no_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 14th question and select NO and verify the More Detail
		// meaning of the question.
		String actual_Text47 = webDriver
				.findElement(By.cssSelector(
						"#eighta_one_time_used > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text47 = "Have any individual(s) claiming social and economic disadvantage, previously used their one time 8(a) eligibility to qualify a business for the 8(a) BD Program?";
		assertEquals(actual_Text47, expected_Text47);
		// Verify the detail meaning for the 14th question.
		String actual_Text48 = webDriver
				.findElement(By.cssSelector(
						"#eighta_one_time_used > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text48 = "An individual or firm that previously participated in the 8(a) BD Program may still be eligible for other SBA small business programs.";
		assertEquals(actual_Text48, expected_Text48);
		// verify and click on the NO button.
		webDriver
				.findElement(By.cssSelector(
						"#eighta_one_time_used > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.no_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 15th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text49 = webDriver
				.findElement(By.cssSelector(
						"#address_in_hubzone > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text49 = "Is the firm�s business address located in a HUBZone?";
		assertEquals(actual_Text49, expected_Text49);
		// Verify the detail meaning for the 15th question.
		String actual_Text50 = webDriver
				.findElement(By.cssSelector(
						"#address_in_hubzone > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text50 = "The Historically Underutilized Business Zone (HUBZone) program provides federal contracting assistance for qualified small business firms located in HUBZones in an effort to increase employment opportunities, investment, and economic development in such areas.";
		assertEquals(actual_Text50, expected_Text50);
		String actual_Text51 = webDriver.findElement(By.xpath("//div[@id='address_in_hubzone']/div/div[2]/ul/li[2]"))
				.getText();
		String expected_Text51 = "Use the HUBZone Maps to find out if your principal office is located in a HUBZone.";
		assertEquals(actual_Text51, expected_Text51);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#address_in_hubzone > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(5000);
		// Locate the 16th question and select Yes and verify the More Detail
		// meaning of the question.
		String actual_Text52 = webDriver
				.findElement(By.cssSelector(
						"#employees_in_hubzone > div.q.makeitonehundredpercent > div.usa-width-one-half > p.lead-para"))
				.getText();
		String expected_Text52 = "Do 35% or more of the firm�s employees reside in a HUBZone?";
		assertEquals(actual_Text52, expected_Text52);
		// Verify the detail meaning for the 16th question.
		String actual_Text53 = webDriver
				.findElement(By.cssSelector(
						"#employees_in_hubzone > div.q.makeitonehundredpercent > div.details.usa-width-one-half > ul > li"))
				.getText();
		String expected_Text53 = "A firm which has at least 35 percent of its employees residing in a HUBZone may qualify for the HUBZone program.";
		assertEquals(actual_Text53, expected_Text53);
		String actual_Text54 = webDriver.findElement(By.xpath("//div[@id='employees_in_hubzone']/div/div[2]/ul/li[2]"))
				.getText();
		String expected_Text54 = "Use the HUBZone Maps to find out if your employees reside in a HUBZone.";
		assertEquals(actual_Text54, expected_Text54);
		// verify and click on the Yes button.
		webDriver
				.findElement(By.cssSelector(
						"#employees_in_hubzone > div.q.makeitonehundredpercent > div.usa-width-one-half > div.answer > button.yes_button"))
				.click();
		Thread.sleep(3000);
		// Verify searched results.
		Thread.sleep(4000);
		String actual_Text0 = webDriver.findElement(By.cssSelector("div.eligible > p > b")).getText();
		String expected_Text0 = "Based on the information you provided, you may be eligible for the WOSB Program.";
		assertEquals(actual_Text0, expected_Text0);

		String actual_Text5 = webDriver.findElement(By.cssSelector("#hubzone > div.eligible > p > b")).getText();
		String expected_Text5 = "Based on the information you provided, you may be eligible for the HUBZone Program.";
		assertEquals(actual_Text5, expected_Text5);

		String actual_Text6 = webDriver.findElement(By.cssSelector("#wosb > div.eligible > p > b")).getText();
		String expected_Text6 = "Based on the information you provided, you may be eligible for the WOSB Program.";
		assertEquals(actual_Text6, expected_Text6);

		String actual_Text7 = webDriver.findElement(By.cssSelector("#edwosb > div.eligible > p > b")).getText();
		String expected_Text7 = "Based on the information you provided, you may be eligible for the EDWOSB program.";
		assertEquals(actual_Text7, expected_Text7);

	}

	@After
	public void EndTest() throws Exception {
		webDriver.quit();
	}

}
