package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;
import junit.framework.TestCase;

public class BusinessOwnershipSubsectionMasterCcorpPage extends TestCase {
	private static final Logger logger = LogManager
			.getLogger(BusinessOwnershipSubsectionMasterCcorpPage.class.getName());
	WebDriver webDriver;

	public BusinessOwnershipSubsectionMasterCcorpPage(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	public void BusinessOwnershipSubsectionMasterCcorp() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		String Actual_Text = null;
		String Expected_Text = null;
		logger.info("Starting business ownership subsection for 8a initial");
		// Verify and click on the business ownership link.
		Actual_Text = webDriver.findElement(By.linkText("Business Ownership")).getText();
		Expected_Text = "Business Ownership";
		assertEquals(Actual_Text, Expected_Text);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		WebElement rateElement = webDriver.findElement(By.linkText("Business Ownership"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify and validate the questions for this section.
		// First question.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Who owns the applicant firm? Please detail the ownership percentages of the applicant firm:";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_ownership_percentage']/fieldset/p[3]"))
				.getText();
		Expected_Text = "An entity-owned firm is a firm that is owned by an American Indian Tribe, an Alaska Native Corporation, a Community Development Corporation, or a Native Hawaiian Organization. For example, American Indian Tribe (AIT) means that the firm is owned by a Native American Tribe not an individual who is of Native American descent. If the applicant firm is owned by individual(s) then only fill in the “Individuals” percentage above.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_ownership_percentage']/fieldset/p[4]"))
				.getText();
		Expected_Text = "American Indian Tribe (AIT) means any Indian tribe, band, nation, or other organized group or community of Indians, which is recognized as eligible for the special programs and services provided by the United States to Indians because of their status as Indians, or is recognized as such by the State in which the tribe, band, nation, group, or community resides.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_ownership_percentage']/fieldset/p[5]"))
				.getText();
		Expected_Text = "An Alaska Native Corporation (ANC) means any Regional Corporation, Village Corporation, Urban Corporation, or Group Corporation organized under the laws of the State of Alaska in accordance with the Alaska Native Claims Settlement Act, as amended 43 U.S.C. 1601, et seq.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_ownership_percentage']/fieldset/p[6]"))
				.getText();
		Expected_Text = "A Community Development Corporation (CDC) means a nonprofit organization responsible to residents of the area it serves which has received financial assistance under 42 U.S.C. 9805, et seq.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_ownership_percentage']/fieldset/p[7]"))
				.getText();
		Expected_Text = "An Native Hawaiian Organization (NHO) means any community service organization serving Native Hawaiians in the State of Hawaii which is a non-profit corporation that has filed articles of incorporation with the Director (or the designee thereof) of the Hawaii Department of Commerce and Consumer Affairs, or any successor agency, is controlled by Native Hawaiians, and whose business activities will principally benefit such Native Hawaiians.";
		assertEquals(Actual_Text, Expected_Text);
		// Second question.
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/h4")).getText();
		Expected_Text = "Is the applicant firm at least 51% or more unconditionally owned by another entity?";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_51_percent_owned_other_entity']/fieldset/p[2]")).getText();
		Expected_Text = "If yes, identify which type of entity and upload the corresponding 1010 form described below. An entity-owned firm is a firm that is owned by, or a wholly owned subsidiary of, an American Indian Tribe, an Alaska Native Corporation, a Community Development Corporation, or a Native Hawaiian Organization.13 C.F.R. § 124.3";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_51_percent_owned_other_entity']/fieldset/p[3]")).getText();
		Expected_Text = "American Indian Tribe (AIT) means any Indian tribe, band, nation, or other organized group or community of Indians, which is recognized as eligible for the special programs and services provided by the United States to Indians because of their status as Indians, or is recognized as such by the State in which the tribe, band, nation, group, or community resides. Upload the1010-AIT.";
		assertEquals(Actual_Text, Expected_Text);
		// Verify link.
		logger.info("Before switching title is =" + webDriver.getWindowHandle());
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//p[3]/a")));
		webDriver.findElement(By.xpath("//p[3]/a")).click();
		String winHandleBefore = webDriver.getWindowHandle();
		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
			logger.info("After switching window is =" + webDriver.getCurrentUrl());
		}
		webDriver.close();
		webDriver.switchTo().window(winHandleBefore);
		logger.info("Back to main window = " + webDriver.getCurrentUrl());
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_51_percent_owned_other_entity']/fieldset/p[4]")).getText();
		Expected_Text = "An Alaska Native Corporation (ANC) means any Regional Corporation, Village Corporation, Urban Corporation, or Group Corporation organized under the laws of the State of Alaska in accordance with the Alaska Native Claims Settlement Act, as amended 43 U.S.C. 1601, et seq. Upload the 1010-ANC.";
		assertEquals(Actual_Text, Expected_Text);
		// verify link.
		logger.info("Before switching title is =" + webDriver.getWindowHandle());
		webDriver.findElement(By.xpath("//p[4]/a")).click();
		String winHandleBefore1 = webDriver.getWindowHandle();
		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
			logger.info("After switching window is =" + webDriver.getCurrentUrl());
		}
		webDriver.close();
		webDriver.switchTo().window(winHandleBefore1);
		logger.info("Back to main window = " + webDriver.getCurrentUrl());
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_51_percent_owned_other_entity']/fieldset/p[5]")).getText();
		Expected_Text = "A Community Development Corporation (CDC) means a nonprofit organization responsible to residents of the area it serves which has received financial assistance under 42 U.S.C. 9805, et seq. Upload the1010-CDC.";
		assertEquals(Actual_Text, Expected_Text);
		// verify link.
		logger.info("Before switching title is =" + webDriver.getWindowHandle());
		webDriver.findElement(By.xpath("//p[5]/a")).click();
		String winHandleBefore2 = webDriver.getWindowHandle();
		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
			logger.info("After switching window is =" + webDriver.getCurrentUrl());
		}
		webDriver.close();
		webDriver.switchTo().window(winHandleBefore2);
		logger.info("Back to main window = " + webDriver.getCurrentUrl());
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_51_percent_owned_other_entity']/fieldset/p[6]")).getText();
		Expected_Text = "An Native Hawaiian Organization (NHO) means any community service organization serving Native Hawaiians in the State of Hawaii which is a non-profit corporation that has filed articles of incorporation with the Director (or the designee thereof) of the Hawaii Department of Commerce and Consumer Affairs, or any successor agency, is controlled by Native Hawaiians, and whose business activities will principally benefit such Native Hawaiians. Upload the 1010-NHO.";
		assertEquals(Actual_Text, Expected_Text);
		// verify link.
		logger.info("Before switching title is =" + webDriver.getWindowHandle());
		webDriver.findElement(By.xpath("//p[6]/a")).click();
		String winHandleBefore3 = webDriver.getWindowHandle();
		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
			logger.info("After switching window is =" + webDriver.getCurrentUrl());
		}
		webDriver.close();
		webDriver.switchTo().window(winHandleBefore3);
		logger.info("Back to main window = " + webDriver.getCurrentUrl());
		// Enter invalid individuals percentages and validate the error
		// message..
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/div[2]/span")).getText();
		Expected_Text = "This field is required.";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("300.89");
		webDriver.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("300.89");
		webDriver.findElement(By.xpath("//div[3]/div[2]/input")).sendKeys("300.89");
		webDriver.findElement(By.xpath("//div[4]/div[2]/input")).sendKeys("300.89");
		webDriver.findElement(By.xpath("//div[5]/div[2]/input")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//div[6]/div[2]/input")).sendKeys("Testing");
		// Select No for the last question.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//label[2]")));
		webDriver.findElement(By.xpath("//label[2]")).click();
		// Click on the continue button.
		CoreUtils.clickContinue(webDriver);
		// Validate that user must enter % less than or equal to 100%.
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/div[2]/span")).getText();
		Expected_Text = "Please enter a value less than or equal to 100.";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[6]/div[2]/span")).getText();
		Expected_Text = "This field is required.";
		assertEquals(Actual_Text, Expected_Text);
		// Clear all the invalid data and enter valid once and continue.
		webDriver.findElement(By.xpath("//div[2]/input")).clear();
		webDriver.findElement(By.xpath("//div[2]/div[2]/input")).clear();
		webDriver.findElement(By.xpath("//div[3]/div[2]/input")).clear();
		webDriver.findElement(By.xpath("//div[4]/div[2]/input")).clear();
		webDriver.findElement(By.xpath("//div[5]/div[2]/input")).clear();
		webDriver.findElement(By.xpath("//div[6]/div[2]/input")).clear();
		// Enter valid data.
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("50");
		webDriver.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("98");
		webDriver.findElement(By.xpath("//div[3]/div[2]/input")).sendKeys("40");
		webDriver.findElement(By.xpath("//div[4]/div[2]/input")).sendKeys("58");
		webDriver.findElement(By.xpath("//div[5]/div[2]/input")).sendKeys("34");
		webDriver.findElement(By.xpath("//div[6]/div[2]/input")).sendKeys("45");
		// Select Yes, upload a document and continue.
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//fieldset/div/input")));
		webDriver.findElement(By.xpath("//fieldset/div/label")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// Upload document.
		String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
		CoreUtils.clickContinue(webDriver);
		// Ownership Details section.
		logger.info("Ownership Details section");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Ownership Details";
		assertEquals(Actual_Text, Expected_Text);
		// verify that section is required.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//div/span"), false));
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[5]/fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		// Verify and validate the questions.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "How did the Principal Owner(s) acquire the applicant firm?";
		assertEquals(Actual_Text, Expected_Text);
		// Drop-down.
		Actual_Text = webDriver.findElement(By.xpath("//select")).getText();
		Expected_Text = "Started the applicant firm\nBought the applicant firm\nAcquired the applicant firm as a gift, an inheritance, or a transfer\nAcquired the applicant firm through a merger or consolidation";
		assertEquals(Actual_Text, Expected_Text);
		// 2nd question.
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/h4")).getText();
		Expected_Text = "Has the applicant firm’s ownership, legal structure, or name changed in the past two years?";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/p")).getText();
		Expected_Text = "If yes, explain the changes and identify all prior owners, ownership percentage, and dates of ownership within the last two years. Please upload the stock, purchase or sales agreements and evidence of compliance with all terms and conditions of the stock, purchase or sales agreements.";
		assertEquals(Actual_Text, Expected_Text);
		// 3rd question.
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/h4")).getText();
		Expected_Text = "Does the applicant firm have any buy-sell agreements, shareholder agreements, or other similar arrangements which may impact the unconditional ownership of the disadvantaged individuals?";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/p")).getText();
		Expected_Text = "If yes, upload copies of the agreements. SBA treats unexercised stock options held by non-disadvantaged individuals as being exercised, which impacts ownership.";
		assertEquals(Actual_Text, Expected_Text);
		// 4th question.
		Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/h4")).getText();
		Expected_Text = "Does the applicant firm currently have ownership interest in any other firm?";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver
				.findElement(By.xpath("//div[@id='answers_ownership_interest_in_other_firm']/fieldset/p[2]")).getText();
		Expected_Text = "If the firm is entity-owned, select ‘Not applicable’; this information is requested elsewhere. If yes, attach the following information for each firm:";
		assertEquals(Actual_Text, Expected_Text);
		// 5th question.
		Actual_Text = webDriver.findElement(By.xpath("//div[5]/fieldset/h4")).getText();
		Expected_Text = "Does another firm or other organization have more than 10% ownership interest in the applicant firm?";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//div[5]/fieldset/p[2]")).getText();
		Expected_Text = "If the firm is entity-owned, select ‘Not applicable’; this information is requested elsewhere. If yes, attach the following information for each firm:";
		assertEquals(Actual_Text, Expected_Text);
		// Select all NO and continue.
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[3]")).click();
		webDriver.findElement(By.xpath("//label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[5]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[5]/fieldset/div/label[2]")).click();
		// click on the continue button.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//article/h2"), false));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Corporations";
		assertEquals(Actual_Text, Expected_Text);
		// Click back on Entity Ownership and verify that notes are being saved.
		WebElement rateElement1 = webDriver.findElement(By.xpath("//aside/ul/li/ul/li/a"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement1);
		Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
		Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
		assertEquals(Actual_Text, Expected_Text);
		logger.info("Entity Ownership notes are being saved");
		// click on the continue button.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//article/h2"), false));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Ownership Details";
		assertEquals(Actual_Text, Expected_Text);
		// change answer from No to Yes, add comment and upload doc when
		// required.
		WebElement rateElement2 = webDriver.findElement(By.xpath("//div/input"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// Upload document.
		String file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument1 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument1.MontanaUploadDocument(file_path_abs1);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage ContributorUpload2 = new Upload2pdfOnSamePage(webDriver);
		ContributorUpload2.Upload2pdfOnSame(file_path_abs);
		WebElement rateElement21 = webDriver.findElement(By.xpath("//div[4]/fieldset/div/input"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement21);
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload3pdfOnSamePage contributorUpload3 = new Upload3pdfOnSamePage(webDriver);
		contributorUpload3.Upload3pdfOnSame(file_path_abs);
		WebElement rateElement3 = webDriver.findElement(By.xpath("//div[5]/fieldset/div/input"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload4pdfOnSamePage contributorUpload4 = new Upload4pdfOnSamePage(webDriver);
		contributorUpload4.Upload4pdfOnSame(file_path_abs);
		// click on the continue button.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Corporations";
		assertEquals(Actual_Text, Expected_Text);
		// Verify that this section is required.
		CoreUtils.clickContinue(webDriver);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/div/span")));
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/div/span")).getText();
		Expected_Text = "Attachment is required";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/p")).getText();
		Expected_Text = "Documents should show that the applicant firm is at least 51% unconditionally and directly owned by one or more individual(s) claiming disadvantaged status, unless it is entity-owned.";
		assertEquals(Actual_Text, Expected_Text);
		// Upload document.
		String file_path_abs2 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument5 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument5.MontanaUploadDocument(file_path_abs2);
		// 2nd upload.
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/h4")).getText();
		Expected_Text = "Please upload all relevant documents from the following list:\nStock certificates (front and back)\nStock ledgers\nRegisters\nTransmutation agreements (for community property states)\nVoting agreements";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/p")).getText();
		Expected_Text = "Documents should show that at least 51% of each class of voting stock outstanding and 51% of the aggregate of all stock outstanding must be owned by the individual(s) claiming disadvantaged status, unless the applicant firm is entity-owned. A transmutation agreement is only required if the individual claiming disadvantaged status is married and resides in a community property state (i.e. California). A transmutation agreement is not required for entity-owned firms. Reference: 13 CFR § 124.105(d)";
		assertEquals(Actual_Text, Expected_Text);
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage contributorUpload2 = new Upload2pdfOnSamePage(webDriver);
		contributorUpload2.Upload2pdfOnSame(file_path_abs);
		;
		// 3rd upload.
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/h4")).getText();
		Expected_Text = "Please upload the applicant firm’s current Certificate of Good Standing.";
		assertEquals(Actual_Text, Expected_Text);
		// Details.
		Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/p")).getText();
		Expected_Text = "If the applicant firm does not have a Certificate of Good Standing, it may have a similar document from the state where the applicant firm is incorporated or organized. It is also known as the Certificate of Existence or Certificate of Status.";
		assertEquals(Actual_Text, Expected_Text);
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload3pdfOnSamePage MontanaUploadDocument7 = new Upload3pdfOnSamePage(webDriver);
		MontanaUploadDocument7.Upload3pdfOnSame(file_path_abs);
		// click on the continue button.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//article/h2"), false));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Review";
		assertEquals(Actual_Text, Expected_Text);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		// wait.until(ExpectedConditions.alertIsPresent());
		// webDriver.switchTo().alert().accept();
		// verify section is completed.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/section/div/div[2]/table/tbody/tr/td/span")));
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
		Expected_Text = "Complete";
		assertEquals(Actual_Text, Expected_Text);
		WebElement EligibilityCompleteStatus = webDriver
				.findElement(By.xpath("//div[2]/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, EligibilityCompleteStatus);

	}

}
