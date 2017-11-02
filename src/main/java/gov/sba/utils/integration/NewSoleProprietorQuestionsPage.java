package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.CoreUtils;
import junit.framework.TestCase;

public class NewSoleProprietorQuestionsPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(NewSoleProprietorQuestionsPage.class.getName());
	WebDriver webDriver;

	public NewSoleProprietorQuestionsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void NewSoleProprietorQuestions() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 40);
		logger.debug(" new sole proprietorship question page");
		String Actual_Text = null;
		String Expected_Text = null;
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;

		// Locate the accept button at the bottom of the EDWOSB agreement and
		// click on it to continue.
		CoreUtils.clickContinue(webDriver);
		// 8(a) question section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Is the qualifying individual(s) currently certified by the U.S. Small Business Administration as an 8(a) Business Development (BD) Program Participant and does this woman own at least 51% of the business?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_8aq1']/fieldset/p[2]")).getText();
		Expected_Text = "If the qualifying individual is not currently an 8(a) BD Program Participant, please select “No”. If the qualifying individual was already approved by the 8(a) BD Program and at least 51% of the business is held by women, you are eligible for the WOSB Program as an EDWOSB and you will skip forward to the “Review” section of this application. Please upload your original 8(a) Acceptance Letter and your most recent Annual Review Letter.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_8aq1']/fieldset/p[3]")).getText();
		Expected_Text = "If the qualifying individual is both 8(a) and Third-Party Certified, upload the documentation for both certifications.";
		assertEquals(Actual_Text, Expected_Text);
		// Answer No.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		// ==>Third Party section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Is the qualifying individual(s) certified as a WOSB or EDWOSB by an SBA-approved Third-Party Certifier?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_tpc1_q1']/fieldset/p[2]")).getText();
		Expected_Text = "You may self-certify for the WOSB Program through this website or you may elect to use the services of a Third-Party Certifier to demonstrate eligibility. There is no requirement to use a Third-Party Certifier. However, if you have worked with an SBA-approved Third-Party Certifier to review your business information, please upload the current Third-Party Certifier Certificate.";
		assertEquals(Actual_Text, Expected_Text);
		// select no and continue.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		// ==>Non-qualification section page.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Has an SBA-approved Third-Party Certifier declined WOSB or EDWOSB certification for the qualifying individual(s)?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_tpc3_q1']/fieldset/p[2]")).getText();
		Expected_Text = "If yes, please upload the denial letter. Being denied eligibility by one of the SBA-approved certifiers does not necessarily prevent you from qualifying for a self-certification if circumstances have changed. Any business determined not to be qualified may request that SBA review its eligibility once it believes in good faith that it satisfies all of the requirements. Reference: 13 C.F.R. 127.305";
		assertEquals(Actual_Text, Expected_Text);
		// select no and continue.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		// ==>Citizenship section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Do the birth certificates, naturalization papers, or passports show the qualifying individual(s) are U.S. citizens?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper1_q1']/fieldset/p[2]")).getText();
		Expected_Text = "If yes, please upload birth certificates, naturalization papers, or current, unexpired U.S. passports for all qualifying individual(s).";
		assertEquals(Actual_Text, Expected_Text);
		// select no and continue.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		// ==>Ownership section.1st question.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Is the following statement true? The qualifying individual(s) is not subject to any conditions, executory agreements, voting trusts, or other arrangements that cause or potentially cause ownership benefits to go to another person.";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper1_q2']/fieldset/p[2]")).getText();
		Expected_Text = "In order for ownership to be unconditional, there cannot be any arrangements that could pass the business to a person or entity not eligible for the WOSB Program. However, stock ownership interest pledged as collateral would be still considered unconditional if the terms follow commercial practices and the owner retains control. Reference: 13 C.F.R. 127.201(b)";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		// 2nd question
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper2_q1 > fieldset > h4")).getText();
		Expected_Text = "Is the qualifying individual’s ownership direct; that is the ownership is not held through another business entity (including employee stock ownership plan) that is, in turn, owned and controlled by the qualifying individual(s)?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper2_q1']/fieldset/p[2]")).getText();
		Expected_Text = "Under the WOSB Program, the 51% ownership must be direct and not through another business entity or a trust (including employee stock ownership plan). Companies which attain 51% ownership by a qualifying individual(s) through a trust or other arrangement that is owned and controlled by women are generally not eligible for the program. Reference: 13 CFR 127.201(b)";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		// 3rd question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper2_q2 > fieldset > h4")).getText();
		Expected_Text = "If the 51% ownership is held through a trust, is the trust revocable, and does it designate the qualifying individual(s) as the grantor, the trustee, and the sole current beneficiary?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper2_q2']/fieldset/p[2]")).getText();
		Expected_Text = "If the ownership is not held through a trust, select N/A. SBA will treat ownership by a trust, such as a living trust, as the functional equivalent of ownership by the qualifying individual where the trust is revocable, and the qualifying individual is the grantor, the trustee, and the sole current beneficiary of the trust. Reference: 13 C.F.R. 127.201(c)";
		assertEquals(Actual_Text, Expected_Text);
		// select no and continue.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry given, place itself for were third. Itself second gathered fruit from");
		CoreUtils.clickContinue(webDriver);
		// ==>Management section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Are the management and daily operations of the business controlled by the qualifying individual(s)?";
		assertEquals(Actual_Text, Expected_Text);
		// 1st question meaning.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper3_q1']/fieldset/p[2]")).getText();
		Expected_Text = "Control means that both the long-term decision making and the day-to-day management and administration of the business operations are conducted by the qualifying individuals. Reference: 13 C.F.R. 127.202(a)";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		// 2nd question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper3_q2 > fieldset > h4")).getText();
		Expected_Text = "Does the qualifying individual(s) hold the highest officer position in the business and does she have the managerial experience needed to run the business?";
		assertEquals(Actual_Text, Expected_Text);
		// 2nd question meaning.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper3_q2']/fieldset/p[2]")).getText();
		Expected_Text = "If yes, please upload a resume to show managerial experience. The woman must have managerial experience of the extent and complexity needed to run the business. Reference: 13 C.F.R. 127.202(b)";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		// 3rd question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper4_q1 > fieldset > h4")).getText();
		Expected_Text = "Does the qualifying individual(s) have ultimate managerial and supervisory control over those who possess the required licenses or technical expertise for the business? The qualifying individual(s) herself may have the technical expertise or possess the required license for the business.";
		assertEquals(Actual_Text, Expected_Text);
		// 3rd question meaning.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper4_q1']/fieldset/p[2]")).getText();
		Expected_Text = "The woman manager does not need to have the technical expertise or possess the required license to be found to control the business if she can demonstrate that she has ultimate managerial and supervisory control over those who possess the required licenses or technical expertise. Reference: 13 C.F.R. 127.202(b)";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		// 4th question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper4_q2 > fieldset > h4")).getText();
		Expected_Text = "Does the qualifying individual(s) who holds the highest officer position manage the business on a full-time basis and devote full-time attention to the business during the normal working hours of similar businesses?";
		assertEquals(Actual_Text, Expected_Text);
		// 4th question meaning.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper4_q2']/fieldset/p[2]")).getText();
		Expected_Text = "The qualifying individual(s) may not engage in outside employment that prevents her from devoting sufficient time and attention to the daily affairs or the business. Reference: 13 C.F.R. 127.202(c)";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click();
		// 5th question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper5_q2 > fieldset > h4")).getText();
		Expected_Text = "Does the qualifying individual(s) fully control the business, that is, no one else has actual control or has the power to control the business?";
		assertEquals(Actual_Text, Expected_Text);
		// 5th question meaning.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper5_q2']/fieldset/p[2]")).getText();
		Expected_Text = "Men or other entities may be involved in the management of the business and may be stockholders, partners or limited liability members of the business, provided that no males or other entity exercise actual control or have the power to control the business. Reference: 13 C.F.R. 127.202(g)";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[5]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[5]/fieldset/div/label[2]")).click();
		// 6th question meaning.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_oper6_q2 > fieldset > h4")).getText();
		Expected_Text = "Is the qualifying individual(s) in control of long-term decision making and day-to-day operations?";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[6]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[6]/fieldset/div/label[2]")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		// ==>SBA Exam section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Is the following statement true? The qualifying individual(s) has not received a decision from the SBA – in connection to an examination or protest – finding that the business does not qualify as a WOSB or an EDWOSB.";
		assertEquals(Actual_Text, Expected_Text);
		// 1st question meaning.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_oper6_q1']/fieldset/p[2]")).getText();
		Expected_Text = "Any business that SBA found to be ineligible for the WOSB Program may request that SBA re- examine its WOSB or EDWOSB eligibility at any time if it believes in good faith that it has cured the reason(s) for its ineligibility. Reference: 13 C.F.R. 127.405(g)";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		// ==>Net Worth section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Can the qualifying individual(s) show that her personal net worth (assets – liabilities) is less than $750,000, excluding her ownership interest in the business and her equity interest in her primary personal residence?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_demonstrate_less_than_750k']/fieldset/p[2]"))
				.getText();
		Expected_Text = "In order to be considered economically disadvantaged, the woman's personal net worth must be less than $750,000, excluding her ownership interest in the business and her equity interest in her primary personal residence. Other exclusions include business income reinvested in the business or received for purposes of paying taxes and retirement funds not available until retirement age without a significant penalty. The qualifying individual(s) must provide information on the business income and retirement funds in the Financial Data section to claim exclusions. Reference: 13 C.F.R. Part 127.203(b)";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_demonstrate_less_than_750k']/fieldset/p[3]"))
				.getText();
		Expected_Text = "SBA may consider a spouse's financial situation in determining a woman's access to credit and capital. When married, an individual claiming economic disadvantage must submit separate financial information for her spouse, unless the individual and the spouse are legally separated.";
		assertEquals(Actual_Text, Expected_Text);
		// select no and continue.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		// ==>Adjusted Gross Income section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Is the qualifying individual’s adjusted gross income averaged over the previous three years at or less than $350,000?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_agi_3_year_less_than_350k']/fieldset/p[2]"))
				.getText();
		Expected_Text = "In answering this question, you may consider the adjusted gross income (AGI) on your Federal income tax return forms (Line 37 on Form 1040; Line 4 on Form 040EZ; or Line 21 on Form 1040(A). Please note that this is rough guidance and should not be construed as the official SBA’s position on calculating the AGI. You will be asked to provide information on your AGI in the Financial Data section.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/p[2]")).getText();
		Expected_Text = "If this situation does not apply, select N/A.";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		// 2nd question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_agi_3_year_exceeds_but_uncommon > fieldset > h4"))
				.getText();
		Expected_Text = "Does the adjusted gross income of the qualifying individual(s) averaged over the three years preceding the certification exceed $350,000; however, the woman can show that (1) this income level was unusual and not likely to occur in the future; (2) that losses commensurate with and directly related to the earnings were suffered; or (3) that the income is not indicative of lack of economic disadvantage?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_agi_3_year_exceeds_but_uncommon']/fieldset/p[2]")).getText();
		Expected_Text = "If this situation does not apply, select N/A.";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		// ==>Assets section.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Is the fair market value of all the assets of the qualifying individual(s) at or less than $6 million?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_woman_assets_less_than_6m']/fieldset/p[3]"))
				.getText();
		Expected_Text = "Funds invested in an Individual Retirement Account (IRA) or other official retirement account that are unavailable until retirement age without a significant penalty will not be considered in determining the qualifying individual’s assets. Reference: 13 C.F.R. 127.203(c)(4)";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		// 2nd question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_woman_has_not_transferred_assets > fieldset > h4"))
				.getText();
		Expected_Text = "Can the qualifying individual(s) confirm that no assets were transferred within two years of the date of EDWOSB certification?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_woman_has_not_transferred_assets']/fieldset/p[2]")).getText();
		Expected_Text = "Assets that a qualifying individual(s) transferred within two years of the date of the concern's certification will be attributed to the qualifying individual(s) if the assets were transferred to an immediate family member, or to a trust that has as a beneficiary an immediate family member. The transferred assets within the two-year period will not be attributed to the woman if the transfer was:";
		assertEquals(Actual_Text, Expected_Text);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		// 3rd question.
		Actual_Text = webDriver.findElement(By.cssSelector("#answers_woman_asset_transfer_excusable > fieldset > h4"))
				.getText();
		Expected_Text = "If the qualifying individual(s) transferred assets within two years of the date of the certification, can she confirm that the assets were transferred: (1) to or on behalf of an immediate family member for that individual’s education, medical expenses, or some other form of essential support; or (2) to an immediate family member in recognition of a special occasion, such as a birthday, graduation, anniversary, or retirement?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_woman_asset_transfer_excusable']/fieldset/p[2]")).getText();
		Expected_Text = "If this situation does not apply, select N/A.";
		assertEquals(Actual_Text, Expected_Text);
		// select no and continue.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));

		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		// ==>Economic Disadvantage section.
		Actual_Text = webDriver.findElement(By.xpath("//h4")).getText();
		Expected_Text = "Do the financial records of the qualifying individual(s) show that she is economically disadvantaged?";
		assertEquals(Actual_Text, Expected_Text);
		// Detail section.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_woman_financial_condition']/fieldset/p[2]"))
				.getText();
		Expected_Text = "Please provide the last three (3) Federal Tax Returns Form 1040, schedules, W-2s, and completed IRS FORM 4506-T for the qualifying individual(s) and their spouses.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_woman_financial_condition']/fieldset/p[3]"))
				.getText();
		Expected_Text = "The personal financial condition of the woman claiming economic disadvantage, including her personal net worth, her adjusted gross income for the past three years (including bonuses, and the value of company stock given in lieu of cash), and the fair market value of all of her assets, whether encumbered or not, will be considered in determining whether she is economically disadvantaged.";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//article[@id='main-content']/section/article/h2")));
		// Validate that user successfully navigated to the Financial Data
		// section.
		String actual_Text49 = webDriver.findElement(By.xpath("//article[@id='main-content']/section/article/h2"))
				.getText();
		String expected_Text49 = "Financial Data";
		assertEquals(actual_Text49, expected_Text49);
		String actual_Text52 = webDriver.findElement(By.xpath("//div[@id='answers_owners']/fieldset/p/b")).getText();
		String expected_Text52 = "This section must be completed by each individual claiming economic disadvantage in connection with the 8(a) Program and/or the Women-Owned Small Business Federal Contract Program.";
		assertEquals(actual_Text52, expected_Text52);
		// Validate the Personal Information.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//fieldset/div[2]/button")));
		webDriver.findElement(By.xpath("//fieldset/div[2]/button")).click();
		logger.info("the page to Create and Add new Record is Present, PASS");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("owners__first_name")));
		webDriver.findElement(By.id("owners__first_name")).sendKeys("Denzel");
		webDriver.findElement(By.id("owners__last_name")).sendKeys("Washington");
		webDriver.findElement(By.id("owners__title")).click();
		webDriver.findElement(By.xpath("//option[2]")).click();
		webDriver.findElement(By.id("owners__ssn")).sendKeys("187669987");
		webDriver.findElement(By.id("owners__email")).sendKeys("DWashington@mailinator.com");
		webDriver.findElement(By.id("owners__marital_status")).click();
		webDriver.findElement(By.xpath("//div[5]/span/select/option[3]")).click();
		webDriver.findElement(By.id("owners__address")).sendKeys("8765 Weems dr");
		webDriver.findElement(By.id("owners__city")).sendKeys("Manassas");
		webDriver.findElement(By.id("owners__state")).sendKeys("Virginia");
		webDriver.findElement(By.id("owners__postal_code")).sendKeys("28776");
		webDriver.findElement(By.id("owners__country")).sendKeys("United State");
		webDriver.findElement(By.id("owners__home_phone")).sendKeys("7024762987");
		webDriver.findElement(By.id("owners__business_phone")).sendKeys("7023764876");
		webDriver.findElement(By.xpath("//button[2]")).click();
		// Select No for question Is anyone listed above divorced? If yes,
		// please provide separation documents.
		Actions act4 = new Actions(webDriver);
		act4.doubleClick(webDriver.findElement(By.xpath("//label[2]"))).build().perform();
		// Locate the Continue Button and click on it to continue.
		CoreUtils.clickContinue(webDriver);
	}

}
