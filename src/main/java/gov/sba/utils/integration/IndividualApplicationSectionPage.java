// By Montana.
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

public class IndividualApplicationSectionPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(IndividualApplicationSectionPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	public IndividualApplicationSectionPage(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	public void IndividualApplicationSection() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		logger.info("Completing Individual Questionnaire");
		String Actual_Text = null;
		String Expected_Text = null;
		// Verify the contributor status is in NOT STARTED.
		Actual_Text = webDriver.findElement(By.linkText("Individual Contributors")).getText();
		Expected_Text = "Individual Contributors";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"))
				.getText();
		Expected_Text = "Not started";
		assertEquals(Actual_Text, Expected_Text);
		WebElement EligibilityCompleteStatus = webDriver
				.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, EligibilityCompleteStatus);
		// Click on the link to start eligibility check.
		WebElement rateElement = webDriver.findElement(By.linkText("Individual Contributors"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//article/a"), false));
		Actual_Text = webDriver.findElement(By.xpath("//article/a")).getText();
		Expected_Text = "Start your individual application now";
		assertEquals(Actual_Text, Expected_Text);
		// Click on the Add a spouse of a Disadvantaged Individual link and
		// invite this contributor.
		WebElement rateElement1 = webDriver.findElement(By.linkText("Start your individual application now"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement1);
		// Verify intro page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/div/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
		Expected_Text = "Terms and Conditions\nThe Federal government relies on the information in the forms and any documents or supplemental information submitted to determine whether your business is eligible to participate in the 8(a) Business Development Program. The definitions of important terms are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR § 124.3), and also in any statutory and regulatory provisions referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person providing information may be prosecuted for providing false information. The Government may pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
		assertEquals(Actual_Text, Expected_Text);
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Gender";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Marital Status";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		// Verify page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		// Enter SSN
		webDriver.findElement(By.xpath("//div/input")).sendKeys("123456789");
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/div/span")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//div/input")).sendKeys("123456789");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fieldset/span")));
		Actual_Text = webDriver.findElement(By.xpath("//fieldset/span")).getText();
		Expected_Text = "This field is required.";
		assertEquals(Actual_Text, Expected_Text);
		// enter address.
		webDriver.findElement(By.xpath("//fieldset/div/fieldset/input")).sendKeys("7865 testing dr country");
		webDriver.findElement(By.xpath("//div/input")).sendKeys("Washington");
		Actual_Text = webDriver.findElement(By.xpath("//select")).getText();
		Expected_Text = "Select a state\nAlabama\nAlaska\nArizona\nArkansas\nCalifornia\nColorado\nConnecticut\nDelaware\nFlorida\nGeorgia\nHawaii\nIdaho\nIllinois\nIndiana\nIowa\nKansas\nKentucky\nLouisiana\nMaine\nMaryland\nMassachusetts\nMichigan\nMinnesota\nMississippi\nMissouri\nMontana\nNebraska\nNevada\nNew Hampshire\nNew Jersey\nNew Mexico\nNew York\nNorth Carolina\nNorth Dakota\nOhio\nOklahoma\nOregon\nPennsylvania\nRhode Island\nSouth Carolina\nSouth Dakota\nTennessee\nTexas\nUtah\nVermont\nVirginia\nWashington\nWest Virginia\nWisconsin\nWyoming\nDistrict of Columbia\nPuerto Rico\nGuam\nAmerican Samoa\nU.S. Virgin Islands\nNorthern Mariana Islands";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[48]")).click();
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("20987");
		webDriver.findElement(By.xpath("//input[5]")).sendKeys("09/12/1990");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Length of residency", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Date and Place of Birth", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//input[5]")).sendKeys("04/23/1978");
		webDriver.findElement(By.xpath("//div/input")).sendKeys("Washington");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("U.S. Citizenship", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		webDriver.findElement(By.xpath("//label")).click();
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Upload Resume", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Attachment is required", webDriver.findElement(By.xpath("//fieldset/div/div/span")).getText());
		// Upload a document.
		String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument0 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument0.MontanaUploadDocument(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Applicant Firm Ownership", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/div[2]/span")).getText());
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("76");
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Bank Account Access", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Full Time Devotion", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument1 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument1.MontanaUploadDocument(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Business Affiliations", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument01 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument01.MontanaUploadDocument(file_path_abs);
		// Select yes for the 2nd question.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Prior 8(a) Involvement", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText());
		assertEquals("Please answer this question",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage ContributorUpload2 = new Upload2pdfOnSamePage(webDriver);
		ContributorUpload2.Upload2pdfOnSame(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Federal Employment", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument11 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument11.MontanaUploadDocument(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Household Federal Employment", webDriver.findElement(By.xpath("//article/h2")).getText());
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div/input")));
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument2 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument2.MontanaUploadDocument(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Financial", webDriver.findElement(By.xpath("//article/h2")).getText());
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div/input")));
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument3 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument3.MontanaUploadDocument(file_path_abs);
		// Select yes and upload documents.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage ContributorUpload3 = new Upload2pdfOnSamePage(webDriver);
		ContributorUpload3.Upload2pdfOnSame(file_path_abs);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload3pdfOnSamePage contributorUpload3 = new Upload3pdfOnSamePage(webDriver);
		contributorUpload3.Upload3pdfOnSame(file_path_abs);
		WebElement rateElement2 = webDriver.findElement(By.xpath("//div[4]/fieldset/div/label"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload4pdfOnSamePage contributorUpload4 = new Upload4pdfOnSamePage(webDriver);
		contributorUpload4.Upload4pdfOnSame(file_path_abs);
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Criminal History", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		WebElement rateElement3 = webDriver.findElement(By.xpath("//div[3]/fieldset/div/label"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[4]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label")).click();
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Attachment is required",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/div/span")).getText());
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument4 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument4.MontanaUploadDocument(file_path_abs);
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload2pdfOnSamePage ContributorUpload4 = new Upload2pdfOnSamePage(webDriver);
		ContributorUpload4.Upload2pdfOnSame(file_path_abs);
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		Upload3pdfOnSamePage contributorUpload5 = new Upload3pdfOnSamePage(webDriver);
		contributorUpload5.Upload3pdfOnSame(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Basis of Disadvantage", webDriver.findElement(By.xpath("//article/h2")).getText());
		assertEquals(
				"Black American\nHispanic American\nNative American\nAsian Pacific American\nSubcontinent Asian American\nNone of the above",
				webDriver.findElement(By.xpath("//select")).getText());
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//select")));
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[3]")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Native American Documentation", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument6 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument6.MontanaUploadDocument(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Transferred Assets", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Tax Returns", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Attachment is required", webDriver.findElement(By.xpath("//fieldset/div/div/span")).getText());
		// Upload a document.
		file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument8 = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument8.MontanaUploadDocument(file_path_abs);
		webDriver.findElement(By.id("section_submit_button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Complete the SDvD financial section.
		ContributorsFinancialSectionPage contributorsFinancialSection = new ContributorsFinancialSectionPage(webDriver);
		contributorsFinancialSection.ContributorsFinancialSection();
		// Verify section is completed.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
		Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
		Expected_Text = "8(a) Disadvantaged Individual section is complete";
		assertEquals(Actual_Text, Expected_Text);
		logger.info("8(a) Disadvantaged Individual section is complete");
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span")));
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"))
				.getText();
		Expected_Text = "Complete";
		assertEquals(Actual_Text, Expected_Text);
		WebElement IndividualStatusCOMPLETED = webDriver
				.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, IndividualStatusCOMPLETED);
		logger.info("All Required sections are completed, Ready to Review & Sign");

	}
}
