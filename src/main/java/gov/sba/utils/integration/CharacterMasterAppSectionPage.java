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

public class CharacterMasterAppSectionPage extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(CharacterMasterAppSectionPage.class.getName());
  WebDriver webDriver;

  public CharacterMasterAppSectionPage(WebDriver webDriver) {
    this.webDriver = webDriver;

  }

  public void CharacterMasterAppSection() throws Exception {
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    logger.info("Character section question begins");
    String Actual_Text = null;
    String Expected_Text = null;
    // Verify the Character Section link.
    Actual_Text = webDriver.findElement(By.linkText("Character")).getText();
    Expected_Text = "Character";
    assertEquals(Actual_Text, Expected_Text);
    // Verify Status.
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "Not started";
    assertEquals(Actual_Text, Expected_Text);
    WebElement EligibilityCompleteStatus = webDriver
			.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
	HighLight.highLightElement(webDriver, EligibilityCompleteStatus);
    // Click on the link to start eligibility check.
    WebElement rateElement = webDriver.findElement(By.linkText("Character"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Character";
    assertEquals(Actual_Text, Expected_Text);
	JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Has the applicant firm (under any name) ever been debarred or suspended by any Federal entity?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16a']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, provide the details regarding the debarment or suspension. Debarred or suspended firms or firms owned by debarred or suspended persons are ineligible for admission to the 8(a) Business Development program. If you have documents showing the debarment has been lifted please upload.";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.findElement(By.id("answers_169_value_no")).click();
    // webDriver.findElement(By.xpath("//input[@name='commit']")).click();
    // Delinquent Liens Section.
    // Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    // Expected_Text = "Delinquent Liens";
    // assertEquals(Actual_Text, Expected_Text);
    // Click on the on the Save and continue button and verify that user is
    // prompted to answer the question.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.id("answers[170][value]-error")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_character_16b > fieldset > h4")).getText();
    Expected_Text =
        "Does the applicant firm have any outstanding delinquent Federal, state or local financial obligations or liens filed against it?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16b']/fieldset/p[2]")).getText();
    Expected_Text =
        "Report any obligations including delinquent tax returns and delinquent SBA loans. If yes, provide any of the following that may apply:";
    assertEquals(Actual_Text, Expected_Text);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_170_value_no")));
    webDriver.findElement(By.id("answers_170_value_no")).click();
    // Click on the on the Save and continue button and verify that user is
    // prompted to answer the question.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.id("answers[171][value]-error")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_character_16c > fieldset > h4")).getText();
    Expected_Text = "Is the applicant firm a defendant in any pending lawsuit?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16c']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, summarize its interest in the suit, the claims, the current status, and provide a copy of the complaint, answer, and/or counterclaim filed in the suit.";
    assertEquals(Actual_Text, Expected_Text);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_171_value_no")));
    webDriver.findElement(By.id("answers_171_value_no")).click();
    // Click on the on the Save and continue button and verify that user is
    // prompted to answer the question.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.id("answers[172][value]-error")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_character_16d > fieldset > h4")).getText();
    Expected_Text =
        "Has the applicant firm filed for bankruptcy or insolvency within the past 7 years?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16d']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, provide details and a copy of the bankruptcy court’s final order or discharge.";
    assertEquals(Actual_Text, Expected_Text);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_172_value_no")));
    webDriver.findElement(By.id("answers_172_value_no")).click();
    CoreUtils.clickContinue(webDriver);
    // Review Section.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("div.review_questions.question-separator > h3")).getText();
    Expected_Text = "Character";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("div.usa-width-three-fourths > p")).getText();
    Expected_Text =
        "Has the applicant firm (under any name) ever been debarred or suspended by any Federal entity?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(
            By.cssSelector("#character_16b > div.usa-grid-full > div.usa-width-three-fourths > p"))
        .getText();
    Expected_Text =
        "Does the applicant firm have any outstanding delinquent Federal, state or local financial obligations or liens filed against it?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[@id='character_16c']/div/div/p")).getText();
    Expected_Text = "Is the applicant firm a defendant in any pending lawsuit?";
    assertEquals(Actual_Text, Expected_Text);
    // Navigate back and verify in-progress status for the draft.
    webDriver.findElement(By.xpath("//a/span")).click();
    // click on the draft 8(a) Initial Program.
    WebElement rateElement2 = webDriver.findElement(By.linkText("8(a) Initial Application"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement2);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span")));
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "In progress";
    assertEquals(Actual_Text, Expected_Text);
    WebElement CharacterInProgressStatus = webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
    HighLight.highLightElement(webDriver, CharacterInProgressStatus);
    WebElement rateElement1 = webDriver.findElement(By.linkText("Character"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement1);    // Thread.sleep(2000);
    webDriver.findElement(By.id("character")).click();
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    CoreUtils.clickContinue(webDriver);
    logger.info("Character section first scenario completed, second scenario begins");
    WebElement rateElement21 = webDriver.findElement(By.linkText("Character"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement21);    
    webDriver.findElement(By.id("character")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Character";
    assertEquals(Actual_Text, Expected_Text);
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Has the applicant firm (under any name) ever been debarred or suspended by any Federal entity?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16a']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, provide the details regarding the debarment or suspension. Debarred or suspended firms or firms owned by debarred or suspended persons are ineligible for admission to the 8(a) Business Development program. If you have documents showing the debarment has been lifted please upload.";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.findElement(By.id("answers_169_value_yes")).click();
    // Upload a document.
    String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_character_16b > fieldset > h4")).getText();
    Expected_Text =
        "Does the applicant firm have any outstanding delinquent Federal, state or local financial obligations or liens filed against it?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16b']/fieldset/p[2]")).getText();
    Expected_Text =
        "Report any obligations including delinquent tax returns and delinquent SBA loans. If yes, provide any of the following that may apply:";
    assertEquals(Actual_Text, Expected_Text);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_170_value_yes")));
    webDriver.findElement(By.id("answers_170_value_yes")).click();
    // Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload2pdfOnSamePage ContributorUpload2 = new Upload2pdfOnSamePage(webDriver);
	ContributorUpload2.Upload2pdfOnSame(file_path_abs);
    // Pending Lawsuit section.
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_character_16c > fieldset > h4")).getText();
    Expected_Text = "Is the applicant firm a defendant in any pending lawsuit?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16c']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, summarize its interest in the suit, the claims, the current status, and provide a copy of the complaint, answer, and/or counterclaim filed in the suit.";
    assertEquals(Actual_Text, Expected_Text);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_171_value_yes")));
    webDriver.findElement(By.id("answers_171_value_yes")).click();
    // Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload3pdfOnSamePage contributorUpload3 = new Upload3pdfOnSamePage(webDriver);
	contributorUpload3.Upload3pdfOnSame(file_path_abs);
    // Verify question and detail section and Select Yes and upload a
    // document.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_character_16d > fieldset > h4")).getText();
    Expected_Text =
        "Has the applicant firm filed for bankruptcy or insolvency within the past 7 years?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_character_16d']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, provide details and a copy of the bankruptcy court’s final order or discharge.";
    assertEquals(Actual_Text, Expected_Text);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_172_value_yes")));
    webDriver.findElement(By.id("answers_172_value_yes")).click();
    // Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload4pdfOnSamePage contributorUpload4 = new Upload4pdfOnSamePage(webDriver);
	contributorUpload4.Upload4pdfOnSame(file_path_abs);
    CoreUtils.clickContinue(webDriver);
    // Review Section.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("div.review_questions.question-separator > h3")).getText();
    Expected_Text = "Character";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("div.usa-width-three-fourths > p")).getText();
    Expected_Text =
        "Has the applicant firm (under any name) ever been debarred or suspended by any Federal entity?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(
            By.cssSelector("#character_16b > div.usa-grid-full > div.usa-width-three-fourths > p"))
        .getText();
    Expected_Text =
        "Does the applicant firm have any outstanding delinquent Federal, state or local financial obligations or liens filed against it?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[@id='character_16c']/div/div/p")).getText();
    Expected_Text = "Is the applicant firm a defendant in any pending lawsuit?";
    assertEquals(Actual_Text, Expected_Text);
    // Navigate back and verify in-progress status for the draft.
    webDriver.findElement(By.xpath("//a/span")).click();
    // click on the draft 8(a) Initial Program.
    WebElement rateElement211 = webDriver.findElement(By.linkText("8(a) Initial Application"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement211);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span")));
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "In progress";
    assertEquals(Actual_Text, Expected_Text);
    WebElement CharacterInProgressStatus1 = webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
    HighLight.highLightElement(webDriver, CharacterInProgressStatus1);
	WebElement rateElement111 = webDriver.findElement(By.linkText("Character"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement111);   
    webDriver.findElement(By.id("character")).click();
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    CoreUtils.clickContinue(webDriver);
    // webDriver.switchTo().alert().accept();
    // Click on the Save and Continue button.
    // Verify status.
    // Verify Status.
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "Complete";
		assertEquals(Actual_Text, Expected_Text);
	    WebElement EligibilityCompleteStatus1 = webDriver
			.findElement(By.xpath("//div[2]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
	HighLight.highLightElement(webDriver, EligibilityCompleteStatus1);

  }
}
