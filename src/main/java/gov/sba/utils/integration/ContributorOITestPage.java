package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.sba.automation.CoreUtils;
import junit.framework.TestCase;

public class ContributorOITestPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(ContributorOITestPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;
	String SDvDFN;
	String SDvDEmail1;
	String SDvDEmail2;
	String SDvDEmail3;
	String SDvDEmail4;

	public ContributorOITestPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		SDvDFN = "Contributor1 SDVD";
		SDvDEmail1 = "norole22@mailinator.com";
		SDvDEmail1 = "norole12@mailinator.com";
		SDvDEmail1 = "norole13@mailinator.com";
		SDvDEmail1 = "akanamontana@gmail.com";

	}

	public void ContributorOITest() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		logger.info("Completing Disadvantaged Individual Sub-questionnaire");
		String Actual_Text = null;
		String Expected_Text = null;
		// Verify intro page for 8(a) Business Partner(other
		// individuals).
		WebElement rateElement4 = webDriver.findElement(By.linkText("Start Application"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/div/p")));
		Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
		Expected_Text = "Terms and Conditions\nThe Federal government relies on the information in the forms and any documents or supplemental information submitted to determine whether your business is eligible to participate in the 8(a) Business Development Program. The definitions of important terms are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR § 124.3), and also in any statutory and regulatory provisions referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person providing information may be prosecuted for providing false information. The Government may pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
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
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		// Verify page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.id("input-type-text-703-error")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		// Enter SSN
		webDriver.findElement(By.xpath("//div/input")).sendKeys("123456789");
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.id("input-type-text-704-error")).getText();
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
		assertEquals("Please answer this question", webDriver.findElement(By.id("answers[707][value]-error")).getText());
		webDriver.findElement(By.xpath("//label[2]")).click();
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Previous Home Address";
		assertEquals(Actual_Text, Expected_Text);
		// Enter previous address.
		webDriver.findElement(By.xpath("//fieldset/div/fieldset/input")).sendKeys("7865 testing dr country");
		webDriver.findElement(By.xpath("//div/input")).sendKeys("Washington");
		Actual_Text = webDriver.findElement(By.xpath("//select")).getText();
		Expected_Text = "Select a state\nAlabama\nAlaska\nArizona\nArkansas\nCalifornia\nColorado\nConnecticut\nDelaware\nFlorida\nGeorgia\nHawaii\nIdaho\nIllinois\nIndiana\nIowa\nKansas\nKentucky\nLouisiana\nMaine\nMaryland\nMassachusetts\nMichigan\nMinnesota\nMississippi\nMissouri\nMontana\nNebraska\nNevada\nNew Hampshire\nNew Jersey\nNew Mexico\nNew York\nNorth Carolina\nNorth Dakota\nOhio\nOklahoma\nOregon\nPennsylvania\nRhode Island\nSouth Carolina\nSouth Dakota\nTennessee\nTexas\nUtah\nVermont\nVirginia\nWashington\nWest Virginia\nWisconsin\nWyoming\nDistrict of Columbia\nPuerto Rico\nGuam\nAmerican Samoa\nU.S. Virgin Islands\nNorthern Mariana Islands";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//select")).click();
		webDriver.findElement(By.xpath("//option[48]")).click();
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("20987");
		// enter Dates of Residence.
		// try{
		// From
		// webDriver.findElement(By.id("start-date-month")).sendKeys("06");
		// webDriver.findElement(By.id("start-date-day")).sendKeys("12");
		// webDriver.findElement(By.id("start-date-year")).sendKeys("2017");
		// To
		// webDriver.findElement(By.id("end-date-month")).sendKeys("01");
		// webDriver.findElement(By.id("end-date-day")).sendKeys("12");
		// webDriver.findElement(By.id("end-date-year")).sendKeys("1990");
		// CoreUtils.clickContinue(webDriver);
		// Actual_Text =
		// webDriver.findElement(By.cssSelector("error")).getText();
		// Expected_Text = "The start date should come before the end
		// date";
		// assertEquals(Actual_Text, Expected_Text);
		// } catch (Error e) {
		// logger.info(e.getMessage());
		// }
		try {
			// From
			webDriver.findElement(By.id("start-date-month")).sendKeys("01");
			webDriver.findElement(By.id("start-date-day")).sendKeys("12");
			webDriver.findElement(By.id("start-date-year")).sendKeys("1990");
			// To
			webDriver.findElement(By.id("end-date-month")).sendKeys("06");
			webDriver.findElement(By.id("end-date-day")).sendKeys("12");
			webDriver.findElement(By.id("end-date-year")).sendKeys("2017");
			CoreUtils.clickContinue(webDriver);
		} catch (Error e) {
			logger.info(e.getMessage());
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Date and Place of Birth", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//input[5]")).sendKeys("04/23/1978");
		webDriver.findElement(By.xpath("//div/input")).sendKeys("TestDataForPlace");
		Select dropdown = new Select(webDriver.findElement(By.xpath("//select")));
		dropdown.selectByVisibleText("United States");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("U.S. Citizenship", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[713][value]-error")).getText());
		webDriver.findElement(By.xpath("//label[2]")).click();
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Resident Alien";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//label[2]")).click();
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// click on continue.
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Applicant Firm Ownership";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("76");
		// Enter comment.
		webDriver.findElement(By.xpath("//textarea")).sendKeys(
				"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
		// Click on Resident Alien question and change answer to yes.
		CoreUtils.clickContinue(webDriver);
		webDriver.findElement(By.xpath("//li[9]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("U.S. Citizenship", webDriver.findElement(By.xpath("//article/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Applicant Firm Ownership";
		assertEquals(Actual_Text, Expected_Text);
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Bank Account Access", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Select No.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Prior Ownership", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Select all NO.
		webDriver.findElement(By.xpath("//label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Business Affiliations", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Select all NO.
		webDriver.findElement(By.xpath("//label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Prior 8a Involvement", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[722][value]-error")).getText());
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[723][value]-error")).getText());
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[724][value]-error")).getText());
		// Select all no.
		webDriver.findElement(By.xpath("//label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Federal Employment", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[725][value]-error")).getText());
		// select NO.
		webDriver.findElement(By.xpath("//label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Financial", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[726][value]-error")).getText());
		// Select all NO.
		webDriver.findElement(By.xpath("//label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Criminal History", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify section is required.
		CoreUtils.clickContinue(webDriver);
		assertEquals("Please answer this question",
				webDriver.findElement(By.id("answers[730][value]-error")).getText());
		// Select all NO.
		webDriver.findElement(By.xpath("//label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")));
		webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click();
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Review", webDriver.findElement(By.xpath("//article/h2")).getText());
		// Verify that user can change their answers.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[17]/div[3]/div/div[2]/p/a")));
		webDriver.findElement(By.xpath("//div[17]/div[3]/div/div[2]/p/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Criminal History", webDriver.findElement(By.xpath("//article/h2")).getText());
		CoreUtils.clickContinue(webDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/h2")));
		assertEquals("Review", webDriver.findElement(By.xpath("//article/h2")).getText());
		CoreUtils.clickContinue(webDriver);
		// wait.until(ExpectedConditions.alertIsPresent());
		// webDriver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/h2")));
		assertEquals("Signature", webDriver.findElement(By.xpath("//article/div/h2")).getText());
		webDriver.findElement(By.xpath("//label")).click();
		CoreUtils.clickContinue(webDriver);
		assertEquals("8(a) Business Partner section is complete",
				webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText());
		// Logout and verify contributor status is on draft.
		webDriver.findElement(By.id("profileid")).click();
		webDriver.findElement(By.linkText("Logout")).click();
	}
}