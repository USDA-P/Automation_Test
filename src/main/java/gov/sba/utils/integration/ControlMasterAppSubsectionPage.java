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

public class ControlMasterAppSubsectionPage extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(ControlMasterAppSubsectionPage.class.getName());
  WebDriver webDriver;

  public ControlMasterAppSubsectionPage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void ControlMasterAppSubsection() throws Exception {
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    logger.info("Control section question begins");
    String Actual_Text = null;
    String Expected_Text = null;
    // Verify the Basic Eligibility link.
    Actual_Text = webDriver.findElement(By.linkText("Control")).getText();
    Expected_Text = "Control";
    assertEquals(Actual_Text, Expected_Text);
    // Verify Status.
    Actual_Text = webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "Not started";
    assertEquals(Actual_Text, Expected_Text);
    WebElement EligibilityCompleteStatus = webDriver
			.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
	HighLight.highLightElement(webDriver, EligibilityCompleteStatus);
    // Click on the link to start eligibility check.
    WebElement rateElement = webDriver.findElement(By.linkText("Control"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement);
	JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    // Verify intro page.
    // Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
    // Expected_Text =
    // "The Federal government relies on the information in the forms and any documents or
    // supplemental information submitted to determine whether your business is eligible to
    // participate in the 8(a) Business Development Program. The definition of important terms are
    // set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13
    // CFR § 124.3), and also any statutory and regulatory provision referenced in those
    // authorities. In addition, please note that the SBA may request further clarification or
    // supporting documentation in order to assist in the verification of any of the information
    // provided and that each person providing information may be prosecuted if they have provided
    // false information. The Government may pursue criminal, civil or administrative remedies for
    // incorrect or incomplete information given, even if correct information has been included in
    // other materials submitted to SBA.";
    // assertEquals(Actual_Text, Expected_Text);
    // Click on the accept button.
    // CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Firm Control";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the on the Save and continue button and verify that user is
    // prompted to answer the question.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);
    // Verify question and detail section and Select Yes and upload a
    // document.
    // 1st question. 1.4a
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Does the applicant firm have any existing agreements that might impact ownership or control? These may include:\n• joint venture\n• mentor protégé\n• indemnity\n• consulting\n• distributorship\n• licensing\n• teaming\n• trust\n• franchise\n• management";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(
            By.xpath("//div[@id='answers_eight_a_control_existing_agreements']/fieldset/p[2]"))
        .getText();
    Expected_Text = "If yes, upload the agreements.";
    assertEquals(Actual_Text, Expected_Text);
    // 2nd question. 1.4b
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_support > fieldset > h4")).getText();
    Expected_Text =
        "Do any other firms or individuals provide financial support or bonding support to the applicant firm?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_support']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, provide the names, the nature of assistance, and copies of agreements governing that relationship.";
    assertEquals(Actual_Text, Expected_Text);
    // 3rd question. 1.4c
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_permits > fieldset > h4")).getText();
    Expected_Text =
        "Do any other firms or individuals provide licensing, certifications, or permits to the applicant firm?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_permits']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, provide the names, the nature of assistance, a copy of the license or certification, and copies of agreements governing that relationship.";
    assertEquals(Actual_Text, Expected_Text);
    // 4th question. 1.4d
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_high_compensation > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is the individual claiming disadvantaged status the highest compensated in the applicant firm?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(
            By.xpath("//div[@id='answers_eight_a_control_high_compensation']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If no, provide an explanation of how the individual(s) claiming disadvantaged status lower compensation is in the best interest of the applicant firm. If the applicant firm is entity-owned, respond ‘Not applicable’.";
    assertEquals(Actual_Text, Expected_Text);
    // 5th question. 1.4e
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_signature_cards > fieldset > h4"))
        .getText();
    Expected_Text = "Please upload all business bank account signature cards.";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_signature_cards']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "The cards can be obtained from the financial institution. If a signature card is not available, upload a letter from the bank identifying all individuals with signatory authority on all bank accounts.";
    assertEquals(Actual_Text, Expected_Text);
    // 6th question. 1.4f
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_share_resources > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is the applicant firm co-located with another firm at any of its locations or does it share any resources with any other firms?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_share_resources']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, upload the agreement and terms of the arrangements. Resources may include the following: sharing of telephone or fax numbers, P.O. Box, office space, yard, warehouse, facilities, equipment, or employees.";
    assertEquals(Actual_Text, Expected_Text);
    // 7th question, 1.4g
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_lease > fieldset > h4")).getText();
    Expected_Text =
        "Does the applicant firm lease or use office space or other facilities from any other firm?";
    assertEquals(Actual_Text, Expected_Text);
    // No Detail section.
    // Select yes to all question.
    // question1, 1.4a
    webDriver.findElement(By.xpath("//label[2]")).click();
    // question2, 1.4b
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")));
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
    // question 3, 1.4c
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")));
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")));
    // question 4, 1.4d
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click();
    // question 5, 1.4e Upload Doc only
    // Upload a document.
    String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload4pdfOnSamePage contributorUpload4 = new Upload4pdfOnSamePage(webDriver);
	contributorUpload4.Upload4pdfOnSame(file_path_abs);
    // question 6, 1.4f with comment.
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[6]/fieldset/div/label[2]")));
    webDriver.findElement(By.xpath("//div[6]/fieldset/div/label[2]")).click();
    // question 7, 1.4g select with skip to Review.
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[7]/fieldset/div/label[2]")));
    webDriver.findElement(By.xpath("//div[7]/fieldset/div/label[2]")).click();
    // Click on the save and continue button and verify that user is
    // requested to enter comment.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/span")).getText();
    Expected_Text = "Comment is required";
    assertEquals(Actual_Text, Expected_Text);
    // Enter comment.
    webDriver.findElement(By.id("answers_176_comment")).sendKeys(
        "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    CoreUtils.clickContinue(webDriver);
    // Review Page.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("div.review_questions.question-separator > h3")).getText();
    Expected_Text = "Firm Control";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/div/p")).getText();
    Expected_Text =
        "Do any other firms or individuals provide financial support or bonding support to the applicant firm?";
    // Navigate back and verify in-progress status for the draft.
    webDriver.findElement(By.xpath("//a/span")).click();
    // click on the draft 8(a) Initial Program.
    WebElement rateElement2 = webDriver.findElement(By.linkText("8(a) Initial Application"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement2);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span")));
    Actual_Text = webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "In progress";
    assertEquals(Actual_Text, Expected_Text);
    WebElement CharacterInProgressStatus1 = webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
    HighLight.highLightElement(webDriver, CharacterInProgressStatus1);
	WebElement rateElement111 = webDriver.findElement(By.linkText("Control"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement111);  
    WebElement rateElement4 = webDriver.findElement(By.id("eight_a_firm_control"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement4); 
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the Submit button.
    CoreUtils.clickContinue(webDriver);
    logger.info(
        "Control section first scenario with NO selection is completed, second scenario for YES selection begins");
    // ++++++++++======>>>>>
    // Click on the control link.
    WebElement rateElement6 = webDriver.findElement(By.linkText("Control"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement6);     
    WebElement rateElement41 = webDriver.findElement(By.id("eight_a_firm_control"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement41); 
    // CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Firm Control";
    assertEquals(Actual_Text, Expected_Text);
    // Verify question and detail section and Select Yes and upload a
    // document.
    // 1st question. 1.4a
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Does the applicant firm have any existing agreements that might impact ownership or control? These may include:\n• joint venture\n• mentor protégé\n• indemnity\n• consulting\n• distributorship\n• licensing\n• teaming\n• trust\n• franchise\n• management";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(
            By.xpath("//div[@id='answers_eight_a_control_existing_agreements']/fieldset/p[2]"))
        .getText();
    Expected_Text = "If yes, upload the agreements.";
    assertEquals(Actual_Text, Expected_Text);
    // 2nd question. 1.4b
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_support > fieldset > h4")).getText();
    Expected_Text =
        "Do any other firms or individuals provide financial support or bonding support to the applicant firm?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_support']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, provide the names, the nature of assistance, and copies of agreements governing that relationship.";
    assertEquals(Actual_Text, Expected_Text);
    // 3rd question. 1.4c
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_permits > fieldset > h4")).getText();
    Expected_Text =
        "Do any other firms or individuals provide licensing, certifications, or permits to the applicant firm?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_permits']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, provide the names, the nature of assistance, a copy of the license or certification, and copies of agreements governing that relationship.";
    assertEquals(Actual_Text, Expected_Text);
    // 4th question. 1.4d
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_high_compensation > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is the individual claiming disadvantaged status the highest compensated in the applicant firm?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(
            By.xpath("//div[@id='answers_eight_a_control_high_compensation']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If no, provide an explanation of how the individual(s) claiming disadvantaged status lower compensation is in the best interest of the applicant firm. If the applicant firm is entity-owned, respond ‘Not applicable’.";
    assertEquals(Actual_Text, Expected_Text);
    // 5th question. 1.4e
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_signature_cards > fieldset > h4"))
        .getText();
    Expected_Text = "Please upload all business bank account signature cards.";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_signature_cards']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "The cards can be obtained from the financial institution. If a signature card is not available, upload a letter from the bank identifying all individuals with signatory authority on all bank accounts.";
    assertEquals(Actual_Text, Expected_Text);
    // 6th question. 1.4f
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_share_resources > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is the applicant firm co-located with another firm at any of its locations or does it share any resources with any other firms?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_eight_a_control_share_resources']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, upload the agreement and terms of the arrangements. Resources may include the following: sharing of telephone or fax numbers, P.O. Box, office space, yard, warehouse, facilities, equipment, or employees.";
    assertEquals(Actual_Text, Expected_Text);
    // 7th question, 1.4g
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_eight_a_control_lease > fieldset > h4")).getText();
    Expected_Text =
        "Does the applicant firm lease or use office space or other facilities from any other firm?";
    assertEquals(Actual_Text, Expected_Text);
    // No Detail section.
    // Select yes to all question.
    // question1, 1.4a
    webDriver.findElement(By.xpath("//div/input")).click();
    // Upload a document.
    String file_path_abs1 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument.MontanaUploadDocument(file_path_abs1);
    // question2, 1.4b
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    // Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload2pdfOnSamePage ContributorUpload2 = new Upload2pdfOnSamePage(webDriver);
	ContributorUpload2.Upload2pdfOnSame(file_path_abs);
    // question 3, 1.4c
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")));
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();
    // Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload3pdfOnSamePage contributorUpload3 = new Upload3pdfOnSamePage(webDriver);
	contributorUpload3.Upload3pdfOnSame(file_path_abs);
    // question 4, 1.4d
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[4]/fieldset/div/input")));
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/input")).click();
    // question 5, 1.4e Upload Doc only
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload4pdfOnSamePage contributorUpload41 = new Upload4pdfOnSamePage(webDriver);
	contributorUpload41.Upload4pdfOnSame(file_path_abs);
    // question 6, 1.4f with comment.
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[6]/fieldset/div/input")));
    webDriver.findElement(By.xpath("//div[6]/fieldset/div/input")).click();
    // question 6, Upload Doc only
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
	Upload5pdfOnSamePage contributorUpload5 = new Upload5pdfOnSamePage(webDriver);
	contributorUpload5.Upload5pdfOnSame(file_path_abs);
    // question 7, 1.4g select with no skip.
		jse.executeScript("arguments[0].scrollIntoView()",
				webDriver.findElement(By.xpath("//div[7]/fieldset/div/input")));
	    webDriver.findElement(By.xpath("//div[7]/fieldset/div/input")).click();
    // Enter comment.
    webDriver.findElement(By.id("answers_174_comment")).sendKeys(
        "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    // Enter comment.
    webDriver.findElement(By.id("answers_175_comment")).sendKeys(
        "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    CoreUtils.clickContinue(webDriver);
    // Leased facility Section 1.4.1a
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Leased Facility";
    assertEquals(Actual_Text, Expected_Text);
    // 1st question on section 1.4.1a
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Do any Principals of the applicant firm have a financial or any other interest in or familial relationship with the owner of the leased facility?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text = webDriver
        .findElement(
            By.xpath("//div[@id='answers_eight_a_control_lease_relationship']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "If yes, provide the name of the other business and the name of the principal who has an interest in or familial relationship with the owner of the leased facility.";
    assertEquals(Actual_Text, Expected_Text);
    // Select yes.
    webDriver.findElement(By.xpath("//div/input")).click();
    // Enter comment.
    webDriver.findElement(By.id("answers_180_comment")).sendKeys(
        "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    CoreUtils.clickContinue(webDriver);
    // Review Page.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("div.review_questions.question-separator > h3")).getText();
    Expected_Text = "Firm Control";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/div/p")).getText();
    Expected_Text =
        "Do any other firms or individuals provide financial support or bonding support to the applicant firm?";
    // Navigate back and verify in-progress status for the draft.
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//a/span")));
    webDriver.findElement(By.xpath("//a/span")).click();
    // click on the draft 8(a) Initial Program.
    WebElement rateElement7 = webDriver.findElement(By.linkText("8(a) Initial Application"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement7);
	jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span")));    
	Actual_Text = webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "In progress";
    assertEquals(Actual_Text, Expected_Text);
		WebElement CharacterInProgressStatus11 = webDriver
				.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
	    HighLight.highLightElement(webDriver, CharacterInProgressStatus11);
    WebElement rateElement51 = webDriver.findElement(By.linkText("Control"));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", rateElement51);   	
    webDriver.findElement(By.id("eight_a_control_leased_facility")).click();
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the Submit button.
    CoreUtils.clickContinue(webDriver);
    // webDriver.switchTo().alert().accept();
    // Verify status.
    Actual_Text = webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span")).getText();
    Expected_Text = "Complete";
    assertEquals(Actual_Text, Expected_Text);
    WebElement ControlComplteStatus = webDriver.findElement(By.xpath("//div[3]/div[2]/section/div/div[2]/table/tbody/tr/td/span"));
    HighLight.highLightElement(webDriver, ControlComplteStatus);
  }
}
