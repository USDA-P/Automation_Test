package gov.usda.utils.integration;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LlcquestionsPage {
  private static final Logger logger = LogManager.getLogger(LlcquestionsPage.class.getName());
  WebDriver webDriver;

  public LlcquestionsPage(WebDriver mydriver) {
    this.webDriver = mydriver;
  }

  public void Llcquestions() throws Exception {
    try {
      String actual_Text = null;
      String expected_Text = null;
      // Locate the accept button at the bottom of the EDWOSB agreement
      // and
      // click on it to continue.
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Locate the 8(a) question and select No and continue.
      actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      expected_Text =
          "Is the qualifying individual(s) currently certified by the U.S. Small Business Administration as an 8(a) Business Development (BD) Program Participant and does this woman own at least 51% of the business?";
      assertEquals(actual_Text, expected_Text);
      // Verify the More detail meaning for the 8(A) question.
      String actual_Text2 =
          webDriver.findElement(By.xpath("//div[@id='answers_8aq1']/fieldset/p[2]")).getText();
      String expected_Text2 =
          "If the qualifying individual is not currently an 8(a) BD Program Participant, please select “No”. If the qualifying individual was already approved by the 8(a) BD Program and at least 51% of the business is held by women, you are eligible for the WOSB Program as an EDWOSB and you will skip forward to the “Review” section of this application. Please upload your original 8(a) Acceptance Letter and your most recent Annual Review Letter.";
      assertEquals(actual_Text2, expected_Text2);
      String actual_Text21 =
          webDriver.findElement(By.xpath("//div[@id='answers_8aq1']/fieldset/p[3]")).getText();
      String expected_Text21 =
          "If the qualifying individual is both 8(a) and Third-Party Certified, upload the documentation for both certifications.";
      assertEquals(actual_Text21, expected_Text21);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      logger.info("  8(a) question has been answered");
      // Locate the Third Party Certification, question1 and select No and
      // continue.
      String actual_Text3 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text3 =
          "Is the qualifying individual(s) certified as a WOSB or EDWOSB by an SBA-approved Third-Party Certifier?";
      assertEquals(actual_Text3, expected_Text3);
      // Verify the detail meaning for the third party question.
      actual_Text =
          webDriver.findElement(By.xpath("//div[@id='answers_tpc1_q1']/fieldset/p[2]")).getText();
      expected_Text =
          "You may self-certify for the WOSB Program through this website or you may elect to use the services of a Third-Party Certifier to demonstrate eligibility. There is no requirement to use a Third-Party Certifier. However, if you have worked with an SBA-approved Third-Party Certifier to review your business information, please upload the current Third-Party Certifier Certificate.";
      assertEquals(actual_Text, expected_Text);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Locate the Non-qualification question,Verify,select No and
      // continue.
      String actual_Text4 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text4 =
          "Has an SBA-approved Third-Party Certifier declined WOSB or EDWOSB certification for the qualifying individual(s)?";
      assertEquals(actual_Text4, expected_Text4);
      // Verify the more detail for the Non-qualification question.
      String actual_Text5 =
          webDriver.findElement(By.xpath("//div[@id='answers_tpc3_q1']/fieldset/p[2]")).getText();
      String expected_Text5 =
          "If yes, please upload the denial letter. Being denied eligibility by one of the SBA-approved certifiers does not necessarily prevent you from qualifying for a self-certification if circumstances have changed. Any business determined not to be qualified may request that SBA review its eligibility once it believes in good faith that it satisfies all of the requirements. Reference: 13 C.F.R. 127.305";
      assertEquals(actual_Text5, expected_Text5);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      logger.info("  Third Party questions have been answered");
      // Locate the LLC two question and select NO, Write comment and
      // continue.
      String actual_Text121 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text121 =
          "Do the Articles of Organization, Operating Agreements and any amendments show that at least 51% of each class of member interest is unconditionally and directly owned by the qualifying individual(s)?";
      assertEquals(actual_Text121, expected_Text121);
      // Verify the more detail meaning for the Citizenship & Ownership
      // questions.
      String actual_Text13 =
          webDriver.findElement(By.xpath("//div[@id='answers_llc_q1']/fieldset/p[2]")).getText();
      String expected_Text13 =
          "If yes, please upload Articles of Organization (also referred to as Certificate of Organization, or Articles of Formation) and any amendments; and Operating Agreement and any amendments; Joint Venture Agreement, if applicable. Reference: 13 C.F.R. 127.201(e)";
      assertEquals(actual_Text13, expected_Text13);
      webDriver.findElement(By.xpath("//label[2]")).click();
      webDriver.findElement(By.xpath("//textarea")).sendKeys(
          "This character is a man in his late twenties, who can be quite reckless. He comes from a poor background, lives in a mansion and tends to work too hard. This character is a man in his late twenties, who can be quite reckless. He comes from a poor background, lives in a mansion and tends to work too hard.");
      // 2nd question
      String actual_Text44 =
          webDriver.findElement(By.cssSelector("#answers_llc_q2 > fieldset > h4")).getText();
      String expected_Text44 =
          "Do the Articles of Organization and any amendments or Operating Agreement and any amendments show that the qualifying individual(s) serve as management members, with control over all decisions of the limited liability company?";
      assertEquals(actual_Text44, expected_Text44);
      // Verify the more detail meaning
      // questions.
      String actual_Text77 =
          webDriver.findElement(By.xpath("//div[@id='answers_llc_q2']/fieldset/p[2]")).getText();
      String expected_Text77 =
          "If yes, please upload Articles of Organization (also referred to as Certificate of Organization, or Articles of Formation) and any amendments; or Operating Agreement and any amendments that show that one or more women serve as management members, with control over all decisions; the Joint Venture Agreement if applicable. Reference: 13 C.F.R. 127.202(e)";
      assertEquals(actual_Text77, expected_Text77);
      webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
      webDriver.findElement(By.id("answers_242_comment")).sendKeys(
          "This character is a man in his late twenties, who can be quite reckless. He comes from a poor background, lives in a mansion and tends to work too hard. This character is a man in his late twenties, who can be quite reckless. He comes from a poor background, lives in a mansion and tends to work too hard.");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      logger.info("The LLC questions have been answered");
      // Locate the Citizenship & Ownership question 1and2, Verify,select
      // No
      // and continue.
      String actual_Text1211 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text1211 =
          "Do the birth certificates, naturalization papers, or passports show the qualifying individual(s) are U.S. citizens?";
      assertEquals(actual_Text1211, expected_Text1211);
      // Verify the more detail meaning for the Citizenship & Ownership
      // questions.
      String actual_Text137 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper1_q1']/fieldset/p[2]")).getText();
      String expected_Text137 =
          "If yes, please upload birth certificates, naturalization papers, or current, unexpired U.S. passports for all qualifying individual(s).";
      assertEquals(actual_Text137, expected_Text137);
      String actual_Text131 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper1_q1']/fieldset/p[3]")).getText();
      String expected_Text131 =
          "A Citizen means a person born or naturalized in the United States. Resident aliens and green card holders of permanent visas are not considered to be citizens. Reference: 13 C.F.R. 127.102";
      assertEquals(actual_Text131, expected_Text131);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Locate the Businesses & Trusts questions,Verify, select No for
      // both
      // and continue.
      String actual_Text14 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text14 =
          "Is the following statement true? The qualifying individual(s) is not subject to any conditions, executory agreements, voting trusts, or other arrangements that cause or potentially cause ownership benefits to go to another person.";
      assertEquals(actual_Text14, expected_Text14);
      // Verify the more detail meaning for the Businesses & Trusts
      // questions
      String actual_Text15 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper2_q1']/fieldset/p[2]")).getText();
      String expected_Text15 =
          "Under the WOSB Program, the 51% ownership must be direct and not through another business entity or a trust (including employee stock ownership plan). Companies which attain 51% ownership by a qualifying individual(s) through a trust or other arrangement that is owned and controlled by women are generally not eligible for the program. Reference: 13 CFR 127.201(b)";
      assertEquals(actual_Text15, expected_Text15);
      // 2nd question
      String actual_Text16 =
          webDriver.findElement(By.cssSelector("#answers_oper2_q2 > fieldset > h4")).getText();
      String expected_Text16 =
          "If the 51% ownership is held through a trust, is the trust revocable, and does it designate the qualifying individual(s) as the grantor, the trustee, and the sole current beneficiary?";
      assertEquals(actual_Text16, expected_Text16);
      // 2nd question meaning
      String actual_Text17 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper2_q2']/fieldset/p[2]")).getText();
      String expected_Text17 =
          "If the ownership is not held through a trust, select N/A. SBA will treat ownership by a trust, such as a living trust, as the functional equivalent of ownership by the qualifying individual where the trust is revocable, and the qualifying individual is the grantor, the trustee, and the sole current beneficiary of the trust. Reference: 13 C.F.R. 127.201(c)";
      assertEquals(actual_Text17, expected_Text17);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      webDriver.findElement(By.id("answers_245_value_no")).click();
      webDriver.findElement(By.id("answers_246_value_no")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Locate the Ownership questions, Verify, select No for
      // both and continue.
      // 1st question
      String actual_Text18 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text18 =
          "Is the following statement true? The qualifying individual(s) is not subject to any conditions, executory agreements, voting trusts, or other arrangements that cause or potentially cause ownership benefits to go to another person.";
      assertEquals(actual_Text18, expected_Text18);
      // 1st question meaning.
      String actual_Text19 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper1_q2']/fieldset/p[2]")).getText();
      String expected_Text19 =
          "In order for ownership to be unconditional, there cannot be any arrangements that could pass the business to a person or entity not eligible for the WOSB Program. However, stock ownership interest pledged as collateral would be still considered unconditional if the terms follow commercial practices and the owner retains control. Reference: 13 C.F.R. 127.201(b)";
      assertEquals(actual_Text19, expected_Text19);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      // 2nd question.
      String actual_Text20 =
          webDriver.findElement(By.cssSelector("#answers_oper2_q1 > fieldset > h4")).getText();
      String expected_Text20 =
          "Is the qualifying individual’s ownership direct; that is the ownership is not held through another business entity (including employee stock ownership plan) that is, in turn, owned and controlled by the qualifying individual(s)?";
      assertEquals(actual_Text20, expected_Text20);
      // 2nd question meaning.
      String actual_Text22 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper2_q1']/fieldset/p[2]")).getText();
      String expected_Text22 =
          "Under the WOSB Program, the 51% ownership must be direct and not through another business entity or a trust (including employee stock ownership plan). Companies which attain 51% ownership by a qualifying individual(s) through a trust or other arrangement that is owned and controlled by women are generally not eligible for the program. Reference: 13 CFR 127.201(b)";
      assertEquals(actual_Text22, expected_Text22);
      webDriver.findElement(By.id("answers_245_value_no")).click();
      // 3rd question.
      String actual_Text201 =
          webDriver.findElement(By.cssSelector("#answers_oper2_q2 > fieldset > h4")).getText();
      String expected_Text201 =
          "If the 51% ownership is held through a trust, is the trust revocable, and does it designate the qualifying individual(s) as the grantor, the trustee, and the sole current beneficiary?";
      assertEquals(actual_Text201, expected_Text201);
      // 3rd question meaning.
      String actual_Text221 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper2_q2']/fieldset/p[2]")).getText();
      String expected_Text221 =
          "If the ownership is not held through a trust, select N/A. SBA will treat ownership by a trust, such as a living trust, as the functional equivalent of ownership by the qualifying individual where the trust is revocable, and the qualifying individual is the grantor, the trustee, and the sole current beneficiary of the trust. Reference: 13 C.F.R. 127.201(c)";
      assertEquals(actual_Text221, expected_Text221);
      webDriver.findElement(By.id("answers_246_value_no")).click();
      webDriver.findElement(By.id("answers_246_comment")).sendKeys(
          "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Locate the Management questions, Verify, select No for
      // both and continue.
      // 1st question.
      Thread.sleep(2000);
      String actual_Text23 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text23 =
          "Are the management and daily operations of the business controlled by the qualifying individual(s)?";
      assertEquals(actual_Text23, expected_Text23);
      // 1st question meaning.
      String actual_Text24 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper3_q1']/fieldset/p[2]")).getText();
      String expected_Text24 =
          "Control means that both the long-term decision making and the day-to-day management and administration of the business operations are conducted by the qualifying individuals. Reference: 13 C.F.R. 127.202(a)";
      assertEquals(actual_Text24, expected_Text24);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      // 2nd question.
      String actual_Text25 =
          webDriver.findElement(By.cssSelector("#answers_oper3_q2 > fieldset > h4")).getText();
      String expected_Text25 =
          "Does the qualifying individual(s) hold the highest officer position in the business and does she have the managerial experience needed to run the business?";
      assertEquals(actual_Text25, expected_Text25);
      // 2nd question meaning.
      String actual_Text26 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper3_q2']/fieldset/p[2]")).getText();
      String expected_Text26 =
          "If yes, please upload a resume to show managerial experience. The woman must have managerial experience of the extent and complexity needed to run the business. Reference: 13 C.F.R. 127.202(b)";
      assertEquals(actual_Text26, expected_Text26);
      webDriver.findElement(By.id("answers_248_value_no")).click();
      // 3rd question.
      String actual_Text251 =
          webDriver.findElement(By.cssSelector("#answers_oper4_q1 > fieldset > h4")).getText();
      String expected_Text251 =
          "Does the qualifying individual(s) have ultimate managerial and supervisory control over those who possess the required licenses or technical expertise for the business? The qualifying individual(s) herself may have the technical expertise or possess the required license for the business.";
      assertEquals(actual_Text251, expected_Text251);
      // 3rd question meaning.
      String actual_Text261 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper4_q1']/fieldset/p[2]")).getText();
      String expected_Text261 =
          "The woman manager does not need to have the technical expertise or possess the required license to be found to control the business if she can demonstrate that she has ultimate managerial and supervisory control over those who possess the required licenses or technical expertise. Reference: 13 C.F.R. 127.202(b)";
      assertEquals(actual_Text261, expected_Text261);
      webDriver.findElement(By.id("answers_249_value_no")).click();
      // 4th question.
      String actual_Text252 =
          webDriver.findElement(By.cssSelector("#answers_oper4_q2 > fieldset > h4")).getText();
      String expected_Text252 =
          "Does the qualifying individual(s) who holds the highest officer position manage the business on a full-time basis and devote full-time attention to the business during the normal working hours of similar businesses?";
      assertEquals(actual_Text252, expected_Text252);
      // 4th question meaning.
      String actual_Text262 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper4_q2']/fieldset/p[2]")).getText();
      String expected_Text262 =
          "The qualifying individual(s) may not engage in outside employment that prevents her from devoting sufficient time and attention to the daily affairs or the business. Reference: 13 C.F.R. 127.202(c)";
      assertEquals(actual_Text262, expected_Text262);
      webDriver.findElement(By.id("answers_250_value_no")).click();
      // 5th question.
      String actual_Text211 =
          webDriver.findElement(By.cssSelector("#answers_oper5_q2 > fieldset > h4")).getText();
      String expected_Text211 =
          "Does the qualifying individual(s) fully control the business, that is, no one else has actual control or has the power to control the business?";
      assertEquals(actual_Text211, expected_Text211);
      // 5th question meaning.
      String actual_Text311 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper5_q2']/fieldset/p[2]")).getText();
      String expected_Text311 =
          "Men or other entities may be involved in the management of the business and may be stockholders, partners or limited liability members of the business, provided that no males or other entity exercise actual control or have the power to control the business. Reference: 13 C.F.R. 127.202(g)";
      assertEquals(actual_Text311, expected_Text311);
      webDriver.findElement(By.id("answers_251_value_no")).click();
      // 6th question meaning.
      String actual_Text331 =
          webDriver.findElement(By.cssSelector("#answers_oper6_q2 > fieldset > h4")).getText();
      String expected_Text331 =
          "Is the qualifying individual(s) in control of long-term decision making and day-to-day operations?";
      assertEquals(actual_Text331, expected_Text331);
      webDriver.findElement(By.id("answers_252_value_no")).click();
      webDriver.findElement(By.id("answers_252_comment")).sendKeys(
          "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      logger.info("  Operations questions have been answered");
      // Locate the Highest Officer & Control questions,Verify, select No
      // for
      // both and continue.
      // 1st question.
      String actual_Text27 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text27 =
          "Is the following statement true? The qualifying individual(s) has not received a decision from the SBA – in connection to an examination or protest – finding that the business does not qualify as a WOSB or an EDWOSB.";
      assertEquals(actual_Text27, expected_Text27);
      // 1st question meaning.
      String actual_Text28 =
          webDriver.findElement(By.xpath("//div[@id='answers_oper6_q1']/fieldset/p[2]")).getText();
      String expected_Text28 =
          "Any business that SBA found to be ineligible for the WOSB Program may request that SBA re- examine its WOSB or EDWOSB eligibility at any time if it believes in good faith that it has cured the reason(s) for its ineligibility. Reference: 13 C.F.R. 127.405(g)";
      assertEquals(actual_Text28, expected_Text28);
      webDriver.findElement(By.cssSelector("label.no.last")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Net Worth 1st question.
      String actual_Text29 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text29 =
          "Can the qualifying individual(s) show that her personal net worth (assets – liabilities) is less than $750,000, excluding her ownership interest in the business and her equity interest in her primary personal residence?";
      assertEquals(actual_Text29, expected_Text29);
      // 1st question meaning.
      String actual_Text30 = webDriver
          .findElement(By.xpath("//div[@id='answers_demonstrate_less_than_750k']/fieldset/p[2]"))
          .getText();
      String expected_Text30 =
          "In order to be considered economically disadvantaged, the woman's personal net worth must be less than $750,000, excluding her ownership interest in the business and her equity interest in her primary personal residence. Other exclusions include business income reinvested in the business or received for purposes of paying taxes and retirement funds not available until retirement age without a significant penalty. The qualifying individual(s) must provide information on the business income and retirement funds in the Financial Data section to claim exclusions. Reference: 13 C.F.R. Part 127.203(b)";
      assertEquals(actual_Text30, expected_Text30);
      webDriver.findElement(By.id("answers_254_value_no")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Adjusted Gross Income Section
      // for both and continue.
      // 1st question.
      String actual_Text31 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text31 =
          "Is the qualifying individual’s adjusted gross income averaged over the previous three years at or less than $350,000?";
      assertEquals(actual_Text31, expected_Text31);
      // 1st question meaning.
      String actual_Text32 = webDriver
          .findElement(By.xpath("//div[@id='answers_agi_3_year_less_than_350k']/fieldset/p[2]"))
          .getText();
      String expected_Text32 =
          "The adjusted gross income may be found on your Federal income tax return forms (Line 37 on Form 1040; Line 4 on Form 1040EZ; or Line 21 on Form 1040A). You will be asked to provide information on your AGI in the Financial Data section. Reference: 13 C.F.R. 127.203(c)(3)";
      assertEquals(actual_Text32, expected_Text32);
      webDriver.findElement(By.id("answers_255_value_no")).click();
      // 2nd question.
      String actual_Text33 = webDriver
          .findElement(By.cssSelector("#answers_agi_3_year_exceeds_but_uncommon > fieldset > h4"))
          .getText();
      String expected_Text33 =
          "Does the adjusted gross income of the qualifying individual(s) averaged over the three years preceding the certification exceed $350,000; however, the woman can show that (1) this income level was unusual and not likely to occur in the future; (2) that losses commensurate with and directly related to the earnings were suffered; or (3) that the income is not indicative of lack of economic disadvantage?";
      assertEquals(actual_Text33, expected_Text33);
      // 2nd question meaning
      String actual_Text34 = webDriver
          .findElement(
              By.xpath("//div[@id='answers_agi_3_year_exceeds_but_uncommon']/fieldset/p[2]"))
          .getText();
      String expected_Text34 = "If this situation does not apply, select N/A.";
      assertEquals(actual_Text34, expected_Text34);
      webDriver.findElement(By.id("answers_256_value_no")).click();
      // webDriver.findElement(By.id("answers_256_comment")).sendKeys("Also
      // is their earth so. Dry
      // female let doesn't void unto kind. Him two days set green us.
      // Darkness from you'll. Him
      // winged winged fifth man heaven won't it first male saw gathered
      // deep. Abundantly herb it
      // own.
      // Darkness from, created great gathering us called deep abundantly.
      // Divide. So replenish rule
      // together beginning fowl seas light gathering air fill, saw
      // darkness divide doesn't greater
      // fly they're all fly. Shall light from given, place itself for
      // were third. Itself second
      // gathered fruit fromAlso is their earth so. Dry female let doesn't
      // void unto kind. Him two
      // days set green us. Darkness from you'll. Him winged winged fifth
      // man heaven won't it first
      // male saw gathered deep. Abundantly herb it own. Darkness from,
      // created great gathering us
      // called deep abundantly. Divide. So replenish rule together
      // beginning fowl seas light
      // gathering air fill, saw darkness divide doesn't greater fly
      // they're all fly. Shall light
      // from
      // given, place itself for were third. Itself second gathered fruit
      // from");
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Locate the Assets questions,Verify, select No for both and
      // continue.
      // 1st question.
      String actual_Text35 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text35 =
          "Is the fair market value of all the assets of the qualifying individual(s) at or less than $6 million?";
      assertEquals(actual_Text35, expected_Text35);
      // 1st question meaning.
      String actual_Text352 = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_assets_less_than_6m']/fieldset/p[2]"))
          .getText();
      String expected_Text352 =
          "Assets include her primary residence and the value of the business.";
      assertEquals(actual_Text352, expected_Text352);
      String actual_Text351 = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_assets_less_than_6m']/fieldset/p[3]"))
          .getText();
      String expected_Text351 =
          "Funds invested in an Individual Retirement Account (IRA) or other official retirement account that are unavailable until retirement age without a significant penalty will not be considered in determining the qualifying individual’s assets. Reference: 13 C.F.R. 127.203(c)(4)";
      assertEquals(actual_Text351, expected_Text351);
      webDriver.findElement(By.id("answers_257_value_no")).click();
      // 2nd question.
      String actual_Text37 = webDriver
          .findElement(By.cssSelector("#answers_woman_has_not_transferred_assets > fieldset > h4"))
          .getText();
      String expected_Text37 =
          "Can the qualifying individual(s) confirm that no assets were transferred within two years of the date of EDWOSB certification?";
      assertEquals(actual_Text37, expected_Text37);
      // 2nd question meaning.
      String actual_Text38 = webDriver
          .findElement(
              By.xpath("//div[@id='answers_woman_has_not_transferred_assets']/fieldset/p[2]"))
          .getText();
      String expected_Text38 =
          "Assets that a qualifying individual(s) transferred within two years of the date of the concern's certification will be attributed to the qualifying individual(s) if the assets were transferred to an immediate family member, or to a trust that has as a beneficiary an immediate family member. Reference: 13 C.F.R. 127.203(d)";
      assertEquals(actual_Text38, expected_Text38);
      String actual_Text381 = webDriver.findElement(By.xpath("//ol/li")).getText();
      String expected_Text381 =
          "To or on behalf of an immediate family member for that individual's education, medical expenses, or some other form of essential support; or";
      assertEquals(actual_Text381, expected_Text381);
      webDriver.findElement(By.id("answers_258_value_no")).click();
      // 3rd qestion.
      String actual_Text371 = webDriver
          .findElement(By.cssSelector("#answers_woman_asset_transfer_excusable > fieldset > h4"))
          .getText();
      String expected_Text371 =
          "If the qualifying individual(s) transferred assets within two years of the date of the certification, can she confirm that the assets were transferred: (1) to or on behalf of an immediate family member for that individual’s education, medical expenses, or some other form of essential support; or (2) to an immediate family member in recognition of a special occasion, such as a birthday, graduation, anniversary, or retirement?";
      assertEquals(actual_Text371, expected_Text371);
      // 2nd question meaning.
      String actual_Text334 = webDriver
          .findElement(
              By.xpath("//div[@id='answers_woman_has_not_transferred_assets']/fieldset/p[2]"))
          .getText();
      String expected_Text334 =
          "Assets that a qualifying individual(s) transferred within two years of the date of the concern's certification will be attributed to the qualifying individual(s) if the assets were transferred to an immediate family member, or to a trust that has as a beneficiary an immediate family member. Reference: 13 C.F.R. 127.203(d)";
      assertEquals(actual_Text334, expected_Text334);
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Assets
      String actual_Text43 = webDriver.findElement(By.cssSelector("h4")).getText();
      String expected_Text43 =
          "Is the fair market value of all the assets of the qualifying individual(s) at or less than $6 million?";
      assertEquals(actual_Text43, expected_Text43);
      // Verify meaning for the Fair Market Value questions.
      String actual_Text447 = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_assets_less_than_6m']/fieldset/p[2]"))
          .getText();
      String expected_Text447 =
          "Assets include her primary residence and the value of the business.";
      assertEquals(actual_Text447, expected_Text447);
      webDriver.findElement(By.id("answers_257_value_no")).click();
      Thread.sleep(2000);
      String actual_Text45 = webDriver
          .findElement(By.cssSelector("#answers_woman_has_not_transferred_assets > fieldset > h4"))
          .getText();
      String expected_Text45 =
          "Can the qualifying individual(s) confirm that no assets were transferred within two years of the date of EDWOSB certification?";
      assertEquals(actual_Text45, expected_Text45);
      // 2nd question meaning.
      String actual_Text46 = webDriver
          .findElement(
              By.xpath("//div[@id='answers_woman_has_not_transferred_assets']/fieldset/p[2]"))
          .getText();
      String expected_Text46 =
          "Assets that a qualifying individual(s) transferred within two years of the date of the concern's certification will be attributed to the qualifying individual(s) if the assets were transferred to an immediate family member, or to a trust that has as a beneficiary an immediate family member. Reference: 13 C.F.R. 127.203(d)";
      assertEquals(actual_Text46, expected_Text46);
      webDriver.findElement(By.id("answers_258_value_no")).click();
      // 2nd question.
      String actual_Text47 = webDriver
          .findElement(By.cssSelector("#answers_woman_asset_transfer_excusable > fieldset > h4"))
          .getText();
      String expected_Text47 =
          "If the qualifying individual(s) transferred assets within two years of the date of the certification, can she confirm that the assets were transferred: (1) to or on behalf of an immediate family member for that individual’s education, medical expenses, or some other form of essential support; or (2) to an immediate family member in recognition of a special occasion, such as a birthday, graduation, anniversary, or retirement?";
      assertEquals(actual_Text47, expected_Text47);
      // 2nd question meaning.
      String actual_Text48 = webDriver
          .findElement(
              By.xpath("//div[@id='answers_woman_asset_transfer_excusable']/fieldset/p[2]"))
          .getText();
      String expected_Text48 = "If this situation does not apply, select N/A.";
      assertEquals(actual_Text48, expected_Text48);
      webDriver.findElement(By.id("answers_259_value_no")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      // Economic Disadvantage Section.
      String actual_Text491 = webDriver.findElement(By.xpath("//h4")).getText();
      String expected_Text491 =
          "Do the financial records of the qualifying individual(s) show that she is economically disadvantaged?";
      assertEquals(actual_Text491, expected_Text491);
      // Detail section.
      String actual_Text521 = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_financial_condition']/fieldset/p[2]"))
          .getText();
      String expected_Text521 =
          "Please provide the last three (3) Federal Tax Returns Form 1040 (pages 1 & 2 only), schedules, W-2s, and completed IRS FORM 4506-T for the qualifying individual(s) and their spouses.";
      assertEquals(actual_Text521, expected_Text521);
      String actual_Text5211 = webDriver
          .findElement(By.xpath("//div[@id='answers_woman_financial_condition']/fieldset/p[3]"))
          .getText();
      String expected_Text5211 =
          "The personal financial condition of the woman claiming economic disadvantage, including her personal net worth, her adjusted gross income for the past three years (including bonuses, and the value of company stock given in lieu of cash), and the fair market value of all of her assets, whether encumbered or not, will be considered in determining whether she is economically disadvantaged.";
      assertEquals(actual_Text5211, expected_Text5211);
      webDriver.findElement(By.id("answers_260_value_no")).click();
      Thread.sleep(2000);
      webDriver.findElement(By.xpath("//input[@name='commit']")).click();
      logger.info("EDWOSB application questions have been answered");
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
    } catch (Exception e) {
      Thread.sleep(2000);
      ScreenShotPage screenShot = new ScreenShotPage(webDriver);
      screenShot.ScreenShot();
      logger.info("Error");
    }
    logger.info("Success");
  }
}
