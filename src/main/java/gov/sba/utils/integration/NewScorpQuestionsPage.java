package gov.sba.utils.integration;

import static org.junit.Assert.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NewScorpQuestionsPage {
  private static final Logger logger = LogManager.getLogger(NewScorpQuestionsPage.class.getName());
  WebDriver webDriver;

  public NewScorpQuestionsPage(WebDriver mydriver) {
    this.webDriver = mydriver;
  }

  public void NewScorpQuestions() throws Exception {
    logger.debug(" new Scorp question page");
    try {
      String Actual_Text = null;
      String Expected_Text = null;
      // Locate the accept button at the bottom of the EDWOSB agreement and
      // click on it to continue.
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
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
      Actual_Text =
          webDriver.findElement(By.xpath("//div[@id='answers_8aq1']/fieldset/p[3]")).getText();
      Expected_Text =
          "If the qualifying individual is both 8(a) and Third-Party Certified, upload the documentation for both certifications.";
      assertEquals(Actual_Text, Expected_Text);
      // Answer No.
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // ==>Third Party section.
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
      // select no and continue.
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // ==>Non-qualification section page.
      Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      Expected_Text =
          "Has an SBA-approved Third-Party Certifier declined WOSB or EDWOSB certification for the qualifying individual(s)?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text =
          webDriver.findElement(By.xpath("//div[@id='answers_tpc3_q1']/fieldset/p[2]")).getText();
      Expected_Text =
          "If yes, please upload the denial letter. Being denied eligibility by one of the SBA-approved certifiers does not necessarily prevent you from qualifying for a self-certification if circumstances have changed. Any business determined not to be qualified may request that SBA review its eligibility once it believes in good faith that it satisfies all of the requirements. Reference: 13 C.F.R. 127.305";
      assertEquals(Actual_Text, Expected_Text);
      // select no and continue.
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // ==>Corporation & S-Corp program 1st question.
      Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      Expected_Text =
          "Do the corporation’s stock ledger and stock certificates show that the qualifying individual(s) own at least 51% of all outstanding stock?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text =
          webDriver.findElement(By.xpath("//div[@id='answers_corp1_q1']/fieldset/p[2]")).getText();
      Expected_Text =
          "If yes, please upload the front and back pages of all stock certificates and ledgers.";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//label[2]")).click();
      webDriver.findElement(By.xpath("//textarea")).sendKeys(
          "Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
      // 2nd question.
      Actual_Text =
          webDriver.findElement(By.cssSelector("#answers_corp1_q2 > fieldset > h4")).getText();
      Expected_Text = "Does the corporation have more than one class of voting stock?";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
      // 3rd question.
      Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/h4")).getText();
      Expected_Text =
          "Do the corporation’s stock ledger and stock certificates show that at least 51% of each class of voting stock is owned by the qualifying individual(s)?";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
      // 4th question
      Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/h4")).getText();
      Expected_Text =
          "In answering the corporate questions above did you consider unexercised stock options or similar agreements held by the qualifying individual(s)?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text =
          webDriver.findElement(By.xpath("//div[@id='answers_corp1_q3']/fieldset/p[2]")).getText();
      Expected_Text =
          "Do not consider unexercised stock options that are held by the qualifying individual(s). If you answered “yes” to this question, please return to the questions above and revise your answers.";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click();
      // 5th question.
      Actual_Text = webDriver.findElement(By.xpath("//div[5]/fieldset/h4")).getText();
      Expected_Text =
          "Does the corporation have any unexercised stock options or similar agreements?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail meaning.
      Actual_Text = webDriver.findElement(By.xpath("//div[5]/fieldset/p[2]")).getText();
      Expected_Text =
          "In determining unconditional ownership of the business, any unexercised stock options or similar agreements held by a woman will be disregarded. However, any unexercised stock option or other agreement, including the right to convert non-voting stock or debentures into voting stock, held by any other individual or entity will be treated as having been exercised. Reference: 13 C.F.R. 127.201(f)";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//div[5]/fieldset/div/label[2]")).click();
      // 6th question.
      Actual_Text =
          webDriver.findElement(By.cssSelector("#answers_corp4_q1 > fieldset > h4")).getText();
      Expected_Text =
          "Are any unexercised stock options or similar agreements held by the qualifying individual(s)?";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//div[6]/fieldset/div/label[2]")).click();
      // 7th question.
      Actual_Text = webDriver.findElement(By.xpath("//div[7]/fieldset/h4")).getText();
      Expected_Text =
          "Do the Articles of Incorporation and By-laws show that the qualifying individual(s) control the Board of Directors?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver.findElement(By.xpath("//div[7]/fieldset/p[2]")).getText();
      Expected_Text =
          "If yes, please upload Articles of Incorporation and any amendments; By-laws and any amendments; all stock certificates issued, including the front and back copies signed in accordance with the By-laws (this also applies to all cancelled stock certificates); and the Joint Venture Agreement, if applicable. Women are considered to control the Board of Directors when either: (1) one or more women own at least 51% of all voting stock of the business, are on the Board of Directors and have the percentage of voting stock necessary to overcome any super majority voting requirements; or (2) women comprise the majority of voting directors through actual numbers or, where permitted by state law, through weighted voting. Reference: 13 C.F.R. 127.202(f)";
      assertEquals(Actual_Text, Expected_Text);
      // Select No and continue.
      webDriver.findElement(By.xpath("//div[7]/fieldset/div/label[2]")).click();
      webDriver.findElement(By.xpath("//div[7]/fieldset/div[4]/textarea")).sendKeys(
          "Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
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
      // select no and continue.
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
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
      webDriver.findElement(By.xpath("//label[2]")).click();
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
      webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
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
      // select no and continue.
      webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
      webDriver.findElement(By.xpath("//textarea")).sendKeys(
          "Also is their earth so. Dry given, place itself for were third. Itself second gathered fruit from");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
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
      webDriver.findElement(By.xpath("//label[2]")).click();
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
      webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
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
      webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click(); // 4th question.
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
      webDriver.findElement(By.xpath("//div[4]/fieldset/div/label[2]")).click(); // 5th question.
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
      webDriver.findElement(By.xpath("//div[5]/fieldset/div/label[2]")).click(); // 5th question.
      // 6th question meaning.
      Actual_Text =
          webDriver.findElement(By.cssSelector("#answers_oper6_q2 > fieldset > h4")).getText();
      Expected_Text =
          "Is the qualifying individual(s) in control of long-term decision making and day-to-day operations?";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.xpath("//div[6]/fieldset/div/label[2]")).click(); // 5th question.
      webDriver.findElement(By.xpath("//textarea")).sendKeys(
          "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      Thread.sleep(2000);
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
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      Thread.sleep(2000);
      // ==>Net Worth section.
      Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      Expected_Text =
          "Can the qualifying individual(s) show that her personal net worth (assets – liabilities) is less than $750,000, excluding her ownership interest in the business and her equity interest in her primary personal residence?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='answers_demonstrate_less_than_750k']/fieldset/p[2]"))
          .getText();
      Expected_Text =
          "In order to be considered economically disadvantaged, the woman's personal net worth must be less than $750,000, excluding her ownership interest in the business and her equity interest in her primary personal residence. Other exclusions include business income reinvested in the business or received for purposes of paying taxes and retirement funds not available until retirement age without a significant penalty. The qualifying individual(s) must provide information on the business income and retirement funds in the Financial Data section to claim exclusions. Reference: 13 C.F.R. Part 127.203(b)";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='answers_demonstrate_less_than_750k']/fieldset/p[3]"))
          .getText();
      Expected_Text =
          "SBA may consider a spouse's financial situation in determining a woman's access to credit and capital. When married, an individual claiming economic disadvantage must submit separate financial information for her spouse, unless the individual and the spouse are legally separated.";
      assertEquals(Actual_Text, Expected_Text);
      // select no and continue.
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      Thread.sleep(2000);
      // ==>Adjusted Gross Income section.
      Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      Expected_Text =
          "Is the qualifying individual’s adjusted gross income averaged over the previous three years at or less than $350,000?";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.cssSelector("#answers_agi_3_year_exceeds_but_uncommon > fieldset > h4"))
          .getText();
      Expected_Text =
          "Does the adjusted gross income of the qualifying individual(s) averaged over the three years preceding the certification exceed $350,000; however, the woman can show that (1) this income level was unusual and not likely to occur in the future; (2) that losses commensurate with and directly related to the earnings were suffered; or (3) that the income is not indicative of lack of economic disadvantage?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver.findElement(By.xpath("//p[2]")).getText();
      Expected_Text =
          "In answering this question, you may consider the adjusted gross income (AGI) on your Federal income tax return forms (Line 37 on Form 1040; Line 4 on Form 040EZ; or Line 21 on Form 1040(A). Please note that this is rough guidance and should not be construed as the official SBA’s position on calculating the AGI. You will be asked to provide information on your AGI in the Financial Data section.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver.findElement(By.xpath("//p[3]")).getText();
      Expected_Text =
          "Income received by an EDWOSB that is an S corporation, LLC, or partnership will be excluded from an individual's income where the EDWOSB provides documentary evidence demonstrating that the income was reinvested in the EDWOSB or the distribution was solely for the purposes of paying taxes arising in the normal course of operations of the business concern. Losses from the S corporation, LLC or partnership, however, are losses to the EDWOSB only, not losses to the individual, and cannot be used to reduce a woman's personal income. Reference13 C.F.R. 127.203(c)(3)";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/p[2]")).getText();
      Expected_Text = "If this situation does not apply, select N/A.";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.xpath("//label[2]")).click();
      // 2nd question.
      Actual_Text = webDriver
          .findElement(By.cssSelector("#answers_agi_3_year_exceeds_but_uncommon > fieldset > h4"))
          .getText();
      Expected_Text =
          "Does the adjusted gross income of the qualifying individual(s) averaged over the three years preceding the certification exceed $350,000; however, the woman can show that (1) this income level was unusual and not likely to occur in the future; (2) that losses commensurate with and directly related to the earnings were suffered; or (3) that the income is not indicative of lack of economic disadvantage?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver
          .findElement(
              By.xpath("//div[@id='answers_agi_3_year_exceeds_but_uncommon']/fieldset/p[2]"))
          .getText();
      Expected_Text = "If this situation does not apply, select N/A.";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      Thread.sleep(2000);
      // ==>Assets section.
      Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      Expected_Text =
          "Is the fair market value of all the assets of the qualifying individual(s) at or less than $6 million?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_assets_less_than_6m']/fieldset/p[3]"))
          .getText();
      Expected_Text =
          "Funds invested in an Individual Retirement Account (IRA) or other official retirement account that are unavailable until retirement age without a significant penalty will not be considered in determining the qualifying individual’s assets. Reference: 13 C.F.R. 127.203(c)(4)";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.xpath("//label[2]")).click();
      // 2nd question.
      Actual_Text = webDriver
          .findElement(By.cssSelector("#answers_woman_has_not_transferred_assets > fieldset > h4"))
          .getText();
      Expected_Text =
          "Can the qualifying individual(s) confirm that no assets were transferred within two years of the date of EDWOSB certification?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver
          .findElement(
              By.xpath("//div[@id='answers_woman_has_not_transferred_assets']/fieldset/p[2]"))
          .getText();
      Expected_Text =
          "Assets that a qualifying individual(s) transferred within two years of the date of the concern's certification will be attributed to the qualifying individual(s) if the assets were transferred to an immediate family member, or to a trust that has as a beneficiary an immediate family member. The transferred assets within the two-year period will not be attributed to the woman if the transfer was:";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
      Thread.sleep(2000);
      // 3rd question.
      Actual_Text = webDriver
          .findElement(By.cssSelector("#answers_woman_asset_transfer_excusable > fieldset > h4"))
          .getText();
      Expected_Text =
          "If the qualifying individual(s) transferred assets within two years of the date of the certification, can she confirm that the assets were transferred: (1) to or on behalf of an immediate family member for that individual’s education, medical expenses, or some other form of essential support; or (2) to an immediate family member in recognition of a special occasion, such as a birthday, graduation, anniversary, or retirement?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver
          .findElement(
              By.xpath("//div[@id='answers_woman_asset_transfer_excusable']/fieldset/p[2]"))
          .getText();
      Expected_Text = "If this situation does not apply, select N/A.";
      assertEquals(Actual_Text, Expected_Text);
      // select no and continue.
      webDriver.findElement(By.xpath("//div[3]/fieldset/div/label[2]")).click();
      Thread.sleep(2000);
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // ==>Economic Disadvantage section.
      Actual_Text = webDriver.findElement(By.xpath("//h4")).getText();
      Expected_Text =
          "Do the financial records of the qualifying individual(s) show that she is economically disadvantaged?";
      assertEquals(Actual_Text, Expected_Text);
      // Detail section.
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_financial_condition']/fieldset/p[2]"))
          .getText();
      Expected_Text =
          "Please provide the last three (3) Federal Tax Returns Form 1040, schedules, W-2s, and completed IRS FORM 4506-T for the qualifying individual(s) and their spouses.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_financial_condition']/fieldset/p[3]"))
          .getText();
      Expected_Text =
          "The personal financial condition of the woman claiming economic disadvantage, including her personal net worth, her adjusted gross income for the past three years (including bonuses, and the value of company stock given in lieu of cash), and the fair market value of all of her assets, whether encumbered or not, will be considered in determining whether she is economically disadvantaged.";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.xpath("//label[2]")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Validate that user successfully navigated to the Financial Data
      // section.
      Thread.sleep(2000);
      String actual_Text49 = webDriver
          .findElement(By.xpath("//article[@id='main-content']/section/article/h2")).getText();
      String expected_Text49 = "Financial Data";
      assertEquals(actual_Text49, expected_Text49);
      String actual_Text52 =
          webDriver.findElement(By.xpath("//div[@id='answers_owners']/fieldset/p/b")).getText();
      String expected_Text52 =
          "This section must be completed by each individual claiming economic disadvantage in connection with the 8(a) Program and/or the Women-Owned Small Business Federal Contract Program.";
      assertEquals(actual_Text52, expected_Text52);
      // Validate the Personal Information.
      webDriver.findElement(By.xpath("//fieldset/div[2]/button")).click();
      Thread.sleep(2000);
      logger.info("the page to Create and Add new Record is Present, PASS");
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
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//button[2]")).click();
      Thread.sleep(3000);
      // Select No for question Is anyone listed above divorced? If yes,
      // please provide separation documents.
      Actions act4 = new Actions(webDriver);
      act4.doubleClick(webDriver.findElement(By.xpath("//label[2]"))).build().perform();
      // Locate the Continue Button and click on it to continue.
      Thread.sleep(3000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
    }

   catch (Exception e) {
    ScreenShotPage screenShot = new ScreenShotPage(webDriver);
    screenShot.ScreenShot();
    logger.info(e.getMessage());    }
    }
  }



