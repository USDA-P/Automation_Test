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

public class ContributorDvDPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(ContributorDvDPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;
	String SDvDFN;
	String SDvDEmail1;
	String SDvDEmail2;
	String SDvDEmail3;
	String SDvDEmail4;

	public ContributorDvDPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		SDvDFN = "Contributor1 SDVD";
		SDvDEmail1 = "norole22@mailinator.com";
		SDvDEmail1 = "norole12@mailinator.com";
		SDvDEmail1 = "norole13@mailinator.com";
		SDvDEmail1 = "akanamontana@gmail.com";

	}

	public void ContributorDvD() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		logger.info("Completing Disadvantaged Individual Sub-questionnaire");
		String Actual_Text = null;
		String Expected_Text = null;
		// Verify intro page for DvD.
		WebElement rateElement4 = webDriver.findElement(By.linkText("Start Application"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/div/p")));
		Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
		Expected_Text = "The Federal government relies on the information in the forms and any documents or supplemental information submitted to determine whether your business is eligible to participate in the 8(a) Business Development Program. The definitions of important terms are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR § 124.3), and also in any statutory and regulatory provisions referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person providing information may be prosecuted for providing false information. The Government may pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
		assertEquals(Actual_Text, Expected_Text);
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Gender";
		assertEquals(Actual_Text, Expected_Text);
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Marital Status";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label")).click();
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
		jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//select")));
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[48]")).click();
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("20987");
		webDriver.findElement(By.xpath("//input[5]")).sendKeys("09/12/1990");
		// click on continue.
		// CoreUtils.clickContinue(webDriver);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// assertEquals("Role in Applicant Firm",
		// webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		// CoreUtils.clickContinue(webDriver);
		// Actual_Text =
		// webDriver.findElement(By.xpath("//fieldset/div/span")).getText();
		// Expected_Text = "Please answer this question";
		// assertEquals(Actual_Text, Expected_Text);
		// webDriver.findElement(By.xpath("//label")).click();
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
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage uploadDocumentContributors = new UploadDocumentContributorsPage(webDriver);
		uploadDocumentContributors.UploadDocumentContributors(file_path_abs);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Upload Resume", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Attachment is required", webDriver.findElement(By.xpath("//fieldset/div/div/span")).getText());
		// Upload a document.
		String file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage uploadDocumentContributors1 = new UploadDocumentContributorsPage(webDriver);
		uploadDocumentContributors1.UploadDocumentContributors(file_path_abs1);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		// Verify section is required.
		try {
			CoreUtils.clickContinue(webDriver);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("76");
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
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
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage uploadDocumentContributors0 = new UploadDocumentContributorsPage(webDriver);
		uploadDocumentContributors0.UploadDocumentContributors(file_path_abs1);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Business Affiliations", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		// CoreUtils.clickContinue(webDriver);
		// assertEquals("Please answer this question",
		// webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		// assertEquals("Please answer this question",
		// webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage uploadDocumentContributors2 = new UploadDocumentContributorsPage(webDriver);
		uploadDocumentContributors2.UploadDocumentContributors(file_path_abs1);
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
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		assertEquals("Please answer this question",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText());
		assertEquals("Please answer this question",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage uploadDocumentContributors3 = new UploadDocumentContributorsPage(webDriver);
		uploadDocumentContributors3.UploadDocumentContributors(file_path_abs1);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		ContributorUploadPage2 contributorUpload = new ContributorUploadPage2(webDriver);
		contributorUpload.ContributorUpload(file_path_abs1);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Federal Employment", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question", webDriver.findElement(By.xpath("//fieldset/div/span")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		String file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage UploadDocumentContributors1 = new UploadDocumentContributorsPage(webDriver);
		UploadDocumentContributors1.UploadDocumentContributors(file_path_abs4);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Household Federal Employment", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage UploadDocumentContributors01 = new UploadDocumentContributorsPage(webDriver);
		UploadDocumentContributors01.UploadDocumentContributors(file_path_abs4);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Financial", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		// Upload a document.
		file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage UploadDocumentContributors2 = new UploadDocumentContributorsPage(webDriver);
		UploadDocumentContributors2.UploadDocumentContributors(file_path_abs4);
		// Select yes and upload documents.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		ContributorUploadPage2 contributorUpload1 = new ContributorUploadPage2(webDriver);
		contributorUpload1.ContributorUpload(file_path_abs1);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		ContributorUploadPage3 contributorUpload2 = new ContributorUploadPage3(webDriver);
		contributorUpload2.ContributorUpload(file_path_abs1);
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[4]/fieldset/div/label")));
		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label")).click();
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		ContributorUploadPage4 contributorUpload3 = new ContributorUploadPage4(webDriver);
		contributorUpload3.ContributorUpload(file_path_abs1);
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
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[4]/fieldset/div/label")));
		// webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label")).click();
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Attachment is required",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/div/span")).getText());
		// Upload a document.
		file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage UploadDocumentContributors3 = new UploadDocumentContributorsPage(webDriver);
		UploadDocumentContributors3.UploadDocumentContributors(file_path_abs4);
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		ContributorUploadPage2 contributorUpload4 = new ContributorUploadPage2(webDriver);
		contributorUpload4.ContributorUpload(file_path_abs1);
		// Upload a document.
		file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		ContributorUploadPage3 contributorUpload5 = new ContributorUploadPage3(webDriver);
		contributorUpload5.ContributorUpload(file_path_abs1);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Basis of Disadvantage", webDriver.findElement(By.xpath("//article/h2")).getText());
		assertEquals(
				"Black American\nHispanic American\nNative American\nAsian Pacific American\nSubcontinent Asian American\nNone of the above",
				webDriver.findElement(By.xpath("//select")).getText());
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[6]")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		// Other Basis of Disadvantage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Other Basis of Disadvantage", webDriver.findElement(By.xpath("//article/h2")).getText());
		// verify the Other Basis of Disadvantage drop-down.
		webDriver.findElement(By.xpath("//option[4]")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Social Narrative", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Upload a document.
		file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage UploadDocumentContributors04 = new UploadDocumentContributorsPage(webDriver);
		UploadDocumentContributors04.UploadDocumentContributors(file_path_abs4);
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
		file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		UploadDocumentContributorsPage UploadDocumentContributors4 = new UploadDocumentContributorsPage(webDriver);
		UploadDocumentContributors4.UploadDocumentContributors(file_path_abs4);
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Complete the SDvD financial section.
		InvitedContributorsFinancialSectionPage contributorsFinancialSection = new InvitedContributorsFinancialSectionPage(
				webDriver);
		contributorsFinancialSection.InvitedContributorsFinancialSection();
		// Verify section is completed.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.usa-alert-text")));
		Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
		Expected_Text = "8(a) Disadvantaged Individual section is complete";
		assertEquals(Actual_Text, Expected_Text);
		logger.info("8(a) Disadvantaged Individual section is complete");
		// Logout.
		webDriver.findElement(By.id("profileid")).click();
		webDriver.findElement(By.linkText("Logout")).click();

	}
}
