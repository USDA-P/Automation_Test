package gov.sba.utils.integration;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;

public class NewWosbQuestionAnswerYesPage {
  private static final Logger logger =
      LogManager.getLogger(NewWosbQuestionAnswerYesPage.class.getName());
  WebDriver webDriver;

  public NewWosbQuestionAnswerYesPage(WebDriver mydriver) {
    this.webDriver = mydriver;
  }

  public void NewWosbQuestionAnswerYes() throws Exception {
    logger.debug(" new sole proprietorship question page");
    // Explicit wait.
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    String Actual_Text = null;
    String Expected_Text = null;
    // 8(a) question section.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Is the qualifying individual(s) currently certified by the U.S. Small Business Administration as an 8(a) Business Development (BD) Program Participant and does this woman own at least 51% of the business?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_8aq1']/fieldset/p[2]")).getText();
    Expected_Text =
        "If the qualifying individual is not currently an 8(a) BD Program Participant, please select “No”. If the qualifying individual was already approved by the 8(a) BD Program and at least 51% of the business is held by women, you are eligible for the WOSB Program as an EDWOSB and you will skip forward to the “Review” section of this application. Please upload your original 8(a) Acceptance Letter and your most recent Annual Review Letter.";
    assertEquals(Actual_Text, Expected_Text);
    // Answer No.
    webDriver.findElement(By.xpath("//label[2]")).click();
    CoreUtils.clickContinue(webDriver);
    // ==>Third Party question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Is the qualifying individual(s) certified as a WOSB or EDWOSB by an SBA-approved Third-Party Certifier?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_tpc1_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "You may self-certify for the WOSB Program through this website or you may elect to use the services of a Third-Party Certifier to demonstrate eligibility. There is no requirement to use a Third-Party Certifier. However, if you have worked with an SBA-approved Third-Party Certifier to review your business information, please upload the current Third-Party Certifier Certificate.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//fieldset/ul/li")).getText();
    Expected_Text = "El Paso Hispanic Chamber of Commerce (WOSB and EDWOSB)";
    assertEquals(Actual_Text, Expected_Text);
    // Answer Yes.
    webDriver.findElement(By.xpath("//div/input")).click();
    // Upload document.
    String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
    CoreUtils.clickContinue(webDriver);
    // ======>>>>Changes in Eligibility section.
    // Select Yes.
    webDriver.findElement(By.xpath("//div/input")).click();
    CoreUtils.clickContinue(webDriver);
    // ======>Partnership program 1st question.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Does the partnership agreement show that at least 51% of each class of partnership interest is unconditionally and directly owned by the qualifying individual(s)?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_partn_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, please upload the Partnership Agreement and any amendments; the Joint Venture Agreement if applicable. Reference: 13 C.F.R. 127.201(d)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes for both questions and upload documents..
    webDriver.findElement(By.xpath("//div/input")).click();
    // Upload document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument1 = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument1.MontanaUploadDocument(file_path_abs);
    // 2nd question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_partn_q2 > fieldset > h4")).getText();
    Expected_Text =
        "Does the partnership agreement show that the qualifying individual(s) serve as general partners, with control over all partnership decisions?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_partn_q2']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, please upload the Partnership Agreement and any amendments. Reference: 13 C.F.R. 127.202(d)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes.
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    Upload2pdfOnSamePage upload2pdfOnSame = new Upload2pdfOnSamePage(webDriver);
    upload2pdfOnSame.Upload2pdfOnSame(file_path_abs);
    CoreUtils.clickContinue(webDriver);
    // ==>Citizenship section.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Do the birth certificates, naturalization papers, or passports show the qualifying individual(s) are U.S. citizens?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper1_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, please upload birth certificates, naturalization papers, or current, unexpired U.S. passports for all qualifying individual(s).";
    assertEquals(Actual_Text, Expected_Text);
    // select Yes and Upload document.
    webDriver.findElement(By.xpath("//div/input")).click();
    // Upload document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument2 = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument2.MontanaUploadDocument(file_path_abs);
    CoreUtils.clickContinue(webDriver);
    // ==>Ownership section.1st question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Is the following statement true? The qualifying individual(s) is not subject to any conditions, executory agreements, voting trusts, or other arrangements that cause or potentially cause ownership benefits to go to another person.";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper1_q2']/fieldset/p[2]")).getText();
    Expected_Text =
        "In order for ownership to be unconditional, there cannot be any arrangements that could pass the business to a person or entity not eligible for the WOSB Program. However, stock ownership interest pledged as collateral would be still considered unconditional if the terms follow commercial practices and the owner retains control. Reference: 13 C.F.R. 127.201(b)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes
    webDriver.findElement(By.xpath("//div/input")).click();
    // 2nd question
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper2_q1 > fieldset > h4")).getText();
    Expected_Text =
        "Is the qualifying individual’s ownership direct; that is the ownership is not held through another business entity (including employee stock ownership plan) that is, in turn, owned and controlled by the qualifying individual(s)?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper2_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "Under the WOSB Program, the 51% ownership must be direct and not through another business entity or a trust (including employee stock ownership plan). Companies which attain 51% ownership by a qualifying individual(s) through a trust or other arrangement that is owned and controlled by women are generally not eligible for the program. Reference: 13 CFR 127.201(b)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes.
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/label")).click();
    // 3rd question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper2_q2 > fieldset > h4")).getText();
    Expected_Text =
        "If the 51% ownership is held through a trust, is the trust revocable, and does it designate the qualifying individual(s) as the grantor, the trustee, and the sole current beneficiary?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper2_q2']/fieldset/p[2]")).getText();
    Expected_Text =
        "If the ownership is not held through a trust, select N/A. SBA will treat ownership by a trust, such as a living trust, as the functional equivalent of ownership by the qualifying individual where the trust is revocable, and the qualifying individual is the grantor, the trustee, and the sole current beneficiary of the trust. Reference: 13 C.F.R. 127.201(c)";
    assertEquals(Actual_Text, Expected_Text);
    // select Yes and continue.
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();
    CoreUtils.clickContinue(webDriver);
    // ==>Management section.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Are the management and daily operations of the business controlled by the qualifying individual(s)?";
    assertEquals(Actual_Text, Expected_Text);
    // 1st question meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper3_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "Control means that both the long-term decision making and the day-to-day management and administration of the business operations are conducted by the qualifying individuals. Reference: 13 C.F.R. 127.202(a)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes.
    webDriver.findElement(By.xpath("//div/input")).click();
    // 2nd question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper3_q2 > fieldset > h4")).getText();
    Expected_Text =
        "Does the qualifying individual(s) hold the highest officer position in the business and does she have the managerial experience needed to run the business?";
    assertEquals(Actual_Text, Expected_Text);
    // 2nd question meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper3_q2']/fieldset/p[2]")).getText();
    Expected_Text =
        "If yes, please upload a resume to show managerial experience. The woman must have managerial experience of the extent and complexity needed to run the business. Reference: 13 C.F.R. 127.202(b)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes and upload a document.
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    // Upload document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument3 = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument3.MontanaUploadDocument(file_path_abs);
    // 3rd question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper4_q1 > fieldset > h4")).getText();
    Expected_Text =
        "Does the qualifying individual(s) have ultimate managerial and supervisory control over those who possess the required licenses or technical expertise for the business? The qualifying individual(s) herself may have the technical expertise or possess the required license for the business.";
    assertEquals(Actual_Text, Expected_Text);
    // 3rd question meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper4_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "The woman manager does not need to have the technical expertise or possess the required license to be found to control the business if she can demonstrate that she has ultimate managerial and supervisory control over those who possess the required licenses or technical expertise. Reference: 13 C.F.R. 127.202(b)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes.
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();
    // 4th question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper4_q2 > fieldset > h4")).getText();
    Expected_Text =
        "Does the qualifying individual(s) who holds the highest officer position manage the business on a full-time basis and devote full-time attention to the business during the normal working hours of similar businesses?";
    assertEquals(Actual_Text, Expected_Text);
    // 4th question meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper4_q2']/fieldset/p[2]")).getText();
    Expected_Text =
        "The qualifying individual(s) may not engage in outside employment that prevents her from devoting sufficient time and attention to the daily affairs or the business. Reference: 13 C.F.R. 127.202(c)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/input")).click();
    // 5th question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper5_q2 > fieldset > h4")).getText();
    Expected_Text =
        "Does the qualifying individual(s) fully control the business, that is, no one else has actual control or has the power to control the business?";
    assertEquals(Actual_Text, Expected_Text);
    // 5th question meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper5_q2']/fieldset/p[2]")).getText();
    Expected_Text =
        "Men or other entities may be involved in the management of the business and may be stockholders, partners or limited liability members of the business, provided that no males or other entity exercise actual control or have the power to control the business. Reference: 13 C.F.R. 127.202(g)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes.
    webDriver.findElement(By.xpath("//div[5]/fieldset/div/input")).click();
    // 6th question meaning.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_oper6_q2 > fieldset > h4")).getText();
    Expected_Text =
        "Is the qualifying individual(s) in control of long-term decision making and day-to-day operations?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper6_q2']/fieldset/p[2]")).getText();
    Expected_Text = "Reference: 13 C.F.R. 127.202(a)";
    assertEquals(Actual_Text, Expected_Text);
    // Verify link.
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String main_window = webDriver.getWindowHandle();
    logger.info("Before switching, title is = certify.sba.gov");
    webDriver.findElement(By.xpath("(//a[contains(text(),'13 C.F.R. 127.202(a)')])[2]")).click();
    assertEquals(Actual_Text, Expected_Text);
    java.util.Set<String> S1 = webDriver.getWindowHandles();
    Iterator<String> i1 = S1.iterator();
    while (i1.hasNext()) {
      String Second_window = i1.next();
      if (!main_window.equalsIgnoreCase(Second_window)) {
        webDriver.switchTo().window(Second_window);
        logger.info("After switching title is = certify.sba.gov");
        webDriver.close();
        webDriver.switchTo().window(main_window);
        logger.info("Back to manin_window = certify.sba.gov");
      } else {
        logger.info("Second Window is not thesame as first window");
      }
    }
    // Select Yes.
    webDriver.findElement(By.xpath("//div[6]/fieldset/div/input")).click();
    CoreUtils.clickContinue(webDriver);
    // ==>SBA Exam section.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Is the following statement true? The qualifying individual(s) has not received a decision from the SBA – in connection to an examination or protest – finding that the business does not qualify as a WOSB or an EDWOSB.";
    assertEquals(Actual_Text, Expected_Text);
    // 1st question meaning.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_oper6_q1']/fieldset/p[2]")).getText();
    Expected_Text =
        "Any business that SBA found to be ineligible for the WOSB Program may request that SBA re- examine its WOSB or EDWOSB eligibility at any time if it believes in good faith that it has cured the reason(s) for its ineligibility. Reference: 13 C.F.R. 127.405(g)";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes and continue.
    webDriver.findElement(By.xpath("//div/input")).click();
    CoreUtils.clickContinue(webDriver);
    // Review page.
    Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
    Expected_Text = "Women-Owned Small Business Program Self-Certification Summary";
    assertEquals(Actual_Text, Expected_Text);
    // Verify the sections.
    Actual_Text = webDriver
        .findElement(By.cssSelector("div.review_questions.question-separator > h3")).getText();
    Expected_Text = "8(a)";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[2]/h3")).getText();
    Expected_Text = "Third Party";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[3]/h3")).getText();
    Expected_Text = "Changes in Eligibility";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[4]/h3")).getText();
    Expected_Text = "Partnership";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[5]/h3")).getText();
    Expected_Text = "Citizenship";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[6]/h3")).getText();
    Expected_Text = "Ownership";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[7]/h3")).getText();
    Expected_Text = "Management";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.xpath("//form[@id='wosb']/ul/li/div/div[8]/h3")).getText();
    Expected_Text = "SBA Exam";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the submit button.
    CoreUtils.clickContinue(webDriver);
  }
}
