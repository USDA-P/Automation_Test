package gov.sba.utils.integration;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;

public class FinancialSectionSecondPartnerPage {
  private static final Logger logger =
      LogManager.getLogger(FinancialSectionSecondPartnerPage.class.getName());
  private WebDriver webDriver;
  int get_The_Row_From_Login_Data;

  public FinancialSectionSecondPartnerPage(WebDriver mydriver) {
    this.webDriver = mydriver;
  }

  public void FinancialSectionSecondPartner() throws Exception {
    WebDriverWait wait = new WebDriverWait(webDriver, 40);
    String Actual_Text = null;
    String Expected_Text = null;
	JavascriptExecutor jse = (JavascriptExecutor) webDriver;

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    // Locate section for 'Cash on Hand' enter all valid data as required.
    // Locate the As of Date: Search box for user and enter the information
    // as required.
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Cash On Hand";
    assertEquals(Actual_Text, Expected_Text);
    // questions validation.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "As of Date:";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_cash_on_hand > fieldset > h4")).getText();
    Expected_Text = "Cash on Hand";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_savings_balance > fieldset > h4")).getText();
    Expected_Text = "Savings Account(s) Balance";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_checking_balance > fieldset > h4")).getText();
    Expected_Text = "Checking Account(s) Balance";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_edwosb_cash_as_of_date']/fieldset/p")).getText();
    Expected_Text =
        "Use the date of the information provided (i.e. the last date of the previous month). The information must be no older than 30 days old.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_cash_on_hand > fieldset > p")).getText();
    Expected_Text =
        "The sum of all coins and currency that are not on deposit with a financial institution.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_checking_balance > fieldset > p")).getText();
    Expected_Text =
        "Include funds held domestically and in foreign financial institutions. Include funds held in certificates of deposit and money market accounts as part of the Savings Account(s) Balance.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement CashOnHand =
        webDriver.findElement(By.xpath("//div[@id='answers_edwosb_cash_as_of_date']/fieldset/p"));
    HighLight.highLightElement(webDriver, CashOnHand);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_checking_balance > fieldset > p")).getText();
    Expected_Text =
        "Include funds held domestically and in foreign financial institutions. Include funds held in certificates of deposit and money market accounts as part of the Savings Account(s) Balance.";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/fieldset/p")));
    WebElement AccountB = webDriver.findElement(By.xpath("//div[4]/fieldset/p"));
    HighLight.highLightElement(webDriver, AccountB);
    webDriver.findElement(By.xpath("//input[5]")).sendKeys("01/26/2017");
    // Locate the Cash on Hand Search box for Pual Washington and enter the
    // information as required.
    webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("2000");
    // Locate the Savings Account(s) Balance Search box for Pual Washington
    // and enter the information as required.
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/div[2]/input")).sendKeys("5000");
    // Locate the Checking Account(s) Balance Search box for Pual Washington
    // and enter the information as required.
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/div[2]/input")).sendKeys("45000");
    // Locate the Continue button and click on it to continue.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']")));
    CoreUtils.clickContinue(webDriver);
    // Locate section for Other Source of Income enter all valid data as
    // required.
    // Locate the Salary search box and enter salary.
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Other Sources Of Income";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Salary";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_other_income_comment > fieldset > h4"))
        .getText();
    Expected_Text = "Other Income";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_biz_equity > fieldset > h4")).getText();
    Expected_Text = "Your Equity in the Applicant Firm";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_edwosb_equity_in_other_firms > fieldset > h4"))
        .getText();
    Expected_Text = "Your Equity in Other Firms";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_edwosb_salary']/fieldset/p")).getText();
    Expected_Text = "Include yearly salary from applicant firm or other salaried positions.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_edwosb_other_income_comment > fieldset > p"))
            .getText();
    Expected_Text = "Include income from any other sources that have not been included elsewhere.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("#answers_edwosb_biz_equity > fieldset > p"))
        .getText();
    Expected_Text =
        "This is the value of the individual’s equity interest in the applicant firm. The applicant firm is the firm seeking certification with SBA. Use the applicant firm’s current balance sheet to determine the value of the equity interest. The value of equity interest equals the applicant firm’s net worth multiplied by the individual’s ownership percentage.";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("#answers_edwosb_biz_equity > fieldset > p"))
        .getText();
    Expected_Text =
        "This is the value of the individual’s equity interest in the applicant firm. The applicant firm is the firm seeking certification with SBA. Use the applicant firm’s current balance sheet to determine the value of the equity interest. The value of equity interest equals the applicant firm’s net worth multiplied by the individual’s ownership percentage.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement OtherSource =
        webDriver.findElement(By.xpath("//div[@id='answers_edwosb_salary']/fieldset/p"));
    HighLight.highLightElement(webDriver, OtherSource);
    WebElement OtherIncome = webDriver
        .findElement(By.cssSelector("#answers_edwosb_other_income_comment > fieldset > p"));
    HighLight.highLightElement(webDriver, OtherIncome);
    WebElement AppBuzEquity =
        webDriver.findElement(By.cssSelector("#answers_edwosb_biz_equity > fieldset > p"));
    HighLight.highLightElement(webDriver, AppBuzEquity);
    WebElement AppEquityOtherFirm = webDriver
        .findElement(By.cssSelector("#answers_edwosb_equity_in_other_firms > fieldset > p"));
    HighLight.highLightElement(webDriver, AppEquityOtherFirm);
    // Click on the continue button to veriy section is required.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']")));
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/span")).getText();
    Expected_Text = "This field is required.";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("70000");
    // Locate the Other Income search box and enter Other Income.
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/div[2]/input")).sendKeys("80000");
    // Locate the applicant Business Type and enter amount of applicant
    // equity.
    // Enter comment.
    webDriver.findElement(By.xpath("//textarea")).sendKeys(
        "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/div[2]/input")).sendKeys("800000");
    // Locate the applicant equity in other firm and enter applicant
    // business equity.
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/div[2]/input")).sendKeys("50000");
    // Locate the continue button and click on it to continue.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']")));
    CoreUtils.clickContinue(webDriver);
    // Locate and YES for question 'Do you have any notes receivable from
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you have any notes receivable from others?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_notes_receivable']/fieldset/p")).getText();
    Expected_Text =
        "Include shareholder/officer/member/partner loans from individual to applicant firm, as well as any loans given to other individuals or companies.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement NotesDetail =
        webDriver.findElement(By.xpath("//div[@id='answers_notes_receivable']/fieldset/p"));
    HighLight.highLightElement(webDriver, NotesDetail);
    // others?'.
    webDriver.findElement(By.cssSelector("label.yes")).click();
    // Click on the continue button to veriy section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/span")).getText();
    Expected_Text = "At least one row is required";
    webDriver.findElement(By.xpath("//div/a/span")).click();
    logger.info(
        "User is prompted to enter Atleast one row  field or to select no if not applicable. Valid error Message is ");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DTE_Field_debtor_name")));
    // Locate the 'Name of Debtor' search box and enter a valid name.
    webDriver.findElement(By.id("DTE_Field_debtor_name")).sendKeys("John Mall");
    // Locate the 'Address of Debtor' search box and enter a valid address.
    webDriver.findElement(By.id("DTE_Field_debtor_address")).sendKeys("8765 Kings st MD 23445");
    // Locate the 'Original Balance' search box and enter a valid balance.
    webDriver.findElement(By.id("DTE_Field_original_balance")).sendKeys("80000");
    // Locate the 'Current Balance' Search box and enter a valid balance.
    webDriver.findElement(By.id("DTE_Field_current_balance")).sendKeys("20000");
    // Locate the 'Payment Amount(Calculated Annually)' and enter a valid
    // Amount.
    webDriver.findElement(By.id("DTE_Field_pay_amount")).sendKeys("60000");
    // Locate the 'How Secured or Endorsed / Type of Collateral' search box
    // and enter a valid Collateral type(s).
    webDriver.findElement(By.id("DTE_Field_collateral_type")).sendKeys("secured");
    // Locate the 'Create' button at the Right bottom of the Create new
    // entry page and click on it .
    webDriver.findElement(By.cssSelector("button.btn")).click();
    // locate the 'CONTINUE' button at the right bottom of the page and
    // click on it to save
    CoreUtils.clickContinue(webDriver);
    // Select Yes for the two question on Retirement Accounts.
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you have a Roth IRA?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver.findElement(By.cssSelector("fieldset > p")).getText();
    Expected_Text =
        "If yes, upload information on the terms and restrictions of the account. Supplying the most recent account statement from you IRA provider will suffice in most cases. SBA will not include the funds in calculating your net worth if the statement indicates that the funds are not available until retirement age without a significant penalty.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement RothDetail = webDriver.findElement(By.cssSelector("fieldset > p"));
    HighLight.highLightElement(webDriver, RothDetail);
    // Click on the continue button to veriy section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//div/a/span")).click();
    webDriver.findElement(By.id("DTE_Field_total_value")).sendKeys("98000000");
    webDriver.findElement(By.id("DTE_Field_contributions_thus_far")).sendKeys("98000");
    webDriver.findElement(By.id("DTE_Field_date_of_initial_contribution")).clear();
    webDriver.findElement(By.id("DTE_Field_date_of_initial_contribution")).sendKeys("09/24/2017");
    webDriver.findElement(By.id("DTE_Field_investment_company")).sendKeys("The Alliance One");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn")));
    webDriver.findElement(By.cssSelector("button.btn")).click();
    // Upload document.
    String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
    MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
    // Verify the expanded second question.
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_other_retirement_accounts > fieldset > h4"))
            .getText();
    Expected_Text = "Do you have any other retirement accounts?";
    assertEquals(Actual_Text, Expected_Text);
    // Details.
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_other_retirement_accounts > fieldset > p")).getText();
    Expected_Text =
        "Include all other retirement accounts such as traditional IRA, 401K, Self Employed Pension Plan, Thrift Savings Plan, etc. Include retirement accounts that could be held in a trust. If yes, upload information on the terms and restrictions of the account. Supplying the most recent account statement from your retirement account provider will suffice in most cases. SBA will not include the funds in calculating your net worth if the statement indicates that the funds are not available until retirement age without a significant penalty.";
    assertEquals(Actual_Text, Expected_Text);
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//div[2]/fieldset/div[2]/div[2]/div/a/span")));
    webDriver.findElement(By.xpath("//div[2]/fieldset/div[2]/div[2]/div/a/span")).click();
    webDriver.findElement(By.id("DTE_Field_type")).click();
    webDriver.findElement(By.xpath("//option[4]")).click();
    webDriver.findElement(By.id("DTE_Field_total_value")).sendKeys("68700000");
    webDriver.findElement(By.id("DTE_Field_investment_company")).sendKeys("The Alliance One");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn")));
    webDriver.findElement(By.cssSelector("button.btn")).click();
    /// Upload document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    Upload2pdfOnSamePage upload2pdfOnSame = new Upload2pdfOnSamePage(webDriver);
    upload2pdfOnSame.Upload2pdfOnSame(file_path_abs);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']")));
    CoreUtils.clickContinue(webDriver);
    // Life Insurance section.
    // Click on the continue button to verify section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you have a life insurance policy that has a cash surrender value?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_life_insurance_cash_surrender > fieldset > h4"))
        .getText();
    Expected_Text = "Do you have a life insurance policy that has a cash surrender value?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_life_insurance_cash_surrender']/fieldset/p"))
        .getText();
    Expected_Text =
        "The cash surrender value is the total received if a life insurance policy is cancelled. This does not apply to term life insurance policies.";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@id='answers_life_insurance_cash_surrender']/fieldset/p")));
    WebElement LifeInsuranceDetail = webDriver
        .findElement(By.xpath("//div[@id='answers_life_insurance_cash_surrender']/fieldset/p"));
    HighLight.highLightElement(webDriver, LifeInsuranceDetail);
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//div/a/span")).click();
    webDriver.findElement(By.id("DTE_Field_company_name")).sendKeys("21 century");
    webDriver.findElement(By.id("DTE_Field_cash_surrender_value")).sendKeys("2000000");
    webDriver.findElement(By.id("DTE_Field_face_amount")).sendKeys("500000");
    webDriver.findElement(By.id("DTE_Field_beneficiaries")).sendKeys("John Peter");
    webDriver.findElement(By.cssSelector("button.btn")).click();
    // Locate and select yes for question, Do you have loan against a life
    // insurance.
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_life_insurance_loans > fieldset > h4")).getText();
    Expected_Text = "Do you have any loans against a life insurance policy?";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/fieldset/div/label")));
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("5000000");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']")));
    // And remove this two line
    // webDriver.findElement(By.xpath("//label[2]")).click();
    // webDriver.findElement(By.xpath("//div[2]/fieldset/div/label[2]")).click();
    CoreUtils.clickContinue(webDriver);
    // Select Yes for the Stock and Bonds Section.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Stocks & Bonds";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the continue button to verify section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you have any stocks, bonds or mutual funds?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_stocks_bonds']/fieldset/p")).getText();
    Expected_Text =
        "Total value equals the Market Value Quotation multiplied by the number of shares.";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//div[@id='answers_stocks_bonds']/fieldset/p")));
    WebElement StocksBonds =
        webDriver.findElement(By.xpath("//div[@id='answers_stocks_bonds']/fieldset/p"));
    HighLight.highLightElement(webDriver, StocksBonds);
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//div/a/span")).click();
    webDriver.findElement(By.id("DTE_Field_securities_name")).sendKeys("Test 2000");
    webDriver.findElement(By.id("DTE_Field_total_value")).sendKeys("50000");
    webDriver.findElement(By.id("DTE_Field_num_of_shares")).sendKeys("60");
    webDriver.findElement(By.id("DTE_Field_cost")).sendKeys("5900000");
    webDriver.findElement(By.id("DTE_Field_market_value")).sendKeys("9800000");
    webDriver.findElement(By.id("DTE_Field_date")).clear();
    webDriver.findElement(By.id("DTE_Field_date")).sendKeys("04/12/2016");
    webDriver.findElement(By.id("DTE_Field_interest_dividends")).sendKeys("7600000");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn")));
    webDriver.findElement(By.cssSelector("button.btn")).click();
    CoreUtils.clickContinue(webDriver);
    logger.info("Heyyyy! Stocks and Bones section answered.");
    // Select Yes for Real Estate - Primary Residence Section questions.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Real Estate - Primary Residence";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the continue button to verify section is required.
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span")));
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you own your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label.yes")));
    webDriver.findElement(By.cssSelector("label.yes")).click();
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_address_1 > fieldset > h4")).getText();
    Expected_Text = "What is the address of your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div/div[2]/fieldset/h4")).getText();
    Expected_Text = "Is your primary residence jointly owned?";
    assertEquals(Actual_Text, Expected_Text);
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/fieldset/h4")));
    Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/h4")).getText();
    Expected_Text = "What percentage of ownership do you have in your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/h4")).getText();
    Expected_Text =
        "What percentage of the mortgage are you responsible for in your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[5]/fieldset/h4")).getText();
    Expected_Text = "Is your name on the mortgage?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[6]/fieldset/h4")).getText();
    Expected_Text = "What is the current value of your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.xpath("//div[7]/fieldset/h4")).getText();
    Expected_Text = "What is the mortgage balance on your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    // ===> Add Mikes questions here.
    Actual_Text = webDriver.findElement(By.xpath("//div[8]/fieldset/h4")).getText();
    Expected_Text =
        "Is there a lien, 2nd mortgage or Home Equity Line of Credit on your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    // Actual_Text = webDriver.findElement(By.xpath("//div[9]/fieldset/h4")).getText();
    // Expected_Text = "Do you receive income from your primary residence (rent, etc.)?";
    // assertEquals(Actual_Text, Expected_Text);
    // Details.
    Actual_Text = webDriver.findElement(By.cssSelector("fieldset > p")).getText();
    Expected_Text =
        "Report the total value of your primary residence, not your proportional share.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement PRDetails = webDriver.findElement(By.cssSelector("fieldset > p"));
    HighLight.highLightElement(webDriver, PRDetails);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/input")));
    webDriver.findElement(By.xpath("//div[2]/input"))
        .sendKeys("8597 weems rd 2000 ln manassas va 30998");
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/div[2]/input")).sendKeys("50");
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/div[2]/input")).sendKeys("98");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[5]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[5]/fieldset/div/input")).click();
    // mydriver.findElement(By.xpath(".//*[@id='answers_48_2_5_value']")).sendKeys(Percentage);
    webDriver.findElement(By.xpath("//div[6]/fieldset/div/div[2]/input")).sendKeys("78");
    webDriver.findElement(By.xpath("//div[7]/fieldset/div/div[2]/input")).sendKeys("76");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[8]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[8]/fieldset/div/input")).click();
    logger.info("Heyyyy! Verifying the newly added question on Real Estate");
    // Verify the new added question.
    // A-Question.
    Actual_Text = webDriver
        .findElement(
            By.cssSelector("#answers_real_estate_second_mortgage_your_name_1 > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is your name on the lien, 2nd mortgage or Home Equity Line of Credit against your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    // B-Question
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_second_mortgage_value_1 > fieldset > h4"))
        .getText();
    Expected_Text = "What is the current balance of the lien(s)?";
    assertEquals(Actual_Text, Expected_Text);
    WebElement NewQuestionA = webDriver.findElement(
        By.cssSelector("#answers_real_estate_second_mortgage_your_name_1 > fieldset > h4"));
    HighLight.highLightElement(webDriver, NewQuestionA);
    WebElement NewQuestionB = webDriver.findElement(
        By.cssSelector("#answers_real_estate_second_mortgage_value_1 > fieldset > h4"));
    HighLight.highLightElement(webDriver, NewQuestionB);
    // Answers yes for A question.
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[9]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[9]/fieldset/div/input")).click();
    // Verify question triggered.
    Actual_Text = webDriver
        .findElement(
            By.cssSelector("#answers_real_estate_second_mortgage_percent_1 > fieldset > h4"))
        .getText();
    Expected_Text =
        "What percentage of the lien, 2nd mortgage or Home Equity Line of Credit are you responsible for in your primary residence?";
    assertEquals(Actual_Text, Expected_Text);
    WebElement NewQuestionT = webDriver.findElement(
        By.cssSelector("#answers_real_estate_second_mortgage_percent_1 > fieldset > h4"));
    HighLight.highLightElement(webDriver, NewQuestionT);
    webDriver.findElement(By.xpath("//div[10]/fieldset/div/div[2]/input")).sendKeys("87");
    webDriver.findElement(By.xpath("//div[11]/fieldset/div/div[2]/input")).sendKeys("500");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[12]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[12]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[13]/fieldset/div/div[2]/input")).sendKeys("50");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section_submit_button")));
    CoreUtils.clickContinue(webDriver);
    logger.info("Heyyyy! Real Estate - Primary Residence section answered.");
    // Select Yes for Real Estate - Other section.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Real Estate - Other";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the continue button to verify section is required.
    wait.until(ExpectedConditions.elementToBeClickable(By.id("section_submit_button")));
    Actions act = new Actions(webDriver);
    act.doubleClick(webDriver.findElement(By.id("section_submit_button"))).build().perform();
    wait.until(ExpectedConditions.alertIsPresent());
    webDriver.switchTo().alert().accept();
    webDriver.findElement(By.xpath("//div/input")).click();
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_other_real_estate > fieldset > h4")).getText();
    Expected_Text = "List your other real estate holdings:";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.findElement(By.xpath("//fieldset/a/span")).click();
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_type_1 > fieldset > h4")).getText();
    Expected_Text = "What type of Other Real Estate do you own?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_address_1 > fieldset > h4")).getText();
    Expected_Text = "What is the address of your Other Real Estate?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_jointly_owned_1 > fieldset > h4"))
        .getText();
    Expected_Text = "Is your Other Real Estate jointly owned?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_name_on_mortgage_1 > fieldset > h4"))
        .getText();
    Expected_Text = "Is your name on the mortgage?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_value_1 > fieldset > h4")).getText();
    Expected_Text = "What is the current value of your Other Real Estate?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_mortgage_balance_1 > fieldset > h4"))
        .getText();
    Expected_Text = "What is the mortgage balance on your Other Real Estate?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_second_mortgage_1 > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is there a lien, 2nd mortgage or Home Equity Line of Credit on your Other Real Estate?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_real_estate_rent_income_1 > fieldset > h4"))
            .getText();
    Expected_Text = "Do you receive income from your Other Real Estate (rent, etc.)?";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@id='answers_real_estate_address_1']/fieldset/div/div[2]/input")));
    webDriver
        .findElement(
            By.xpath("//div[@id='answers_real_estate_address_1']/fieldset/div/div[2]/input"))
        .sendKeys("1000 go rd, NJ 20990");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//div[4]/fieldset/div/div[2]/input")));
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/div[2]/input")).sendKeys("80");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[5]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[5]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[6]/fieldset/div/div[2]/input")).sendKeys("90");
    webDriver.findElement(By.xpath("//div[7]/fieldset/div/div[2]/input")).sendKeys("76");
    webDriver.findElement(By.xpath("//div[8]/fieldset/div/div[2]/input")).sendKeys("87");
    // Select yes for the last two question.
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[9]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[9]/fieldset/div/input")).click();
    logger.info("Heyyyy! Verifying the newly added question on Real Estate");
    // Verify the new added question.
    // A-Question.
    Actual_Text = webDriver
        .findElement(
            By.cssSelector("#answers_real_estate_second_mortgage_your_name_1 > fieldset > h4"))
        .getText();
    Expected_Text =
        "Is your name on the lien, 2nd mortgage or Home Equity Line of Credit against your other real estate?";
    assertEquals(Actual_Text, Expected_Text);
    // B-Question
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_real_estate_second_mortgage_value_1 > fieldset > h4"))
        .getText();
    Expected_Text = "What is the current balance of the lien(s)?";
    assertEquals(Actual_Text, Expected_Text);
    WebElement NewQuestionREO = webDriver.findElement(
        By.cssSelector("#answers_real_estate_second_mortgage_your_name_1 > fieldset > h4"));
    HighLight.highLightElement(webDriver, NewQuestionREO);
    WebElement NewQuestionReoB = webDriver.findElement(
        By.cssSelector("#answers_real_estate_second_mortgage_value_1 > fieldset > h4"));
    HighLight.highLightElement(webDriver, NewQuestionReoB);
    // Answers yes for A question.
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[10]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[10]/fieldset/div/input")).click();
    // Verify question triggered.
    Actual_Text = webDriver
        .findElement(
            By.cssSelector("#answers_real_estate_second_mortgage_percent_1 > fieldset > h4"))
        .getText();
    Expected_Text =
        "What percentage of the lien, 2nd mortgage or Home Equity Line of Credit are you responsible for in your other real estate?";
    assertEquals(Actual_Text, Expected_Text);
    WebElement NewQuestionReoT = webDriver.findElement(
        By.cssSelector("#answers_real_estate_second_mortgage_percent_1 > fieldset > h4"));
    HighLight.highLightElement(webDriver, NewQuestionReoT);
    webDriver.findElement(By.xpath("//div[11]/fieldset/div/div[2]/input")).sendKeys("87");
    webDriver.findElement(By.xpath("//div[12]/fieldset/div/div[2]/input")).sendKeys("500");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[13]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[13]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[14]/fieldset/div/div[2]/input")).sendKeys("50");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fieldset/a/span")));
    // Click on the add button to another real estate other section.
    // ======>>>Open this when DE app-1040 is fix.
    webDriver.findElement(By.xpath("//fieldset/a/span")).click();
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//div[2]/div/div/fieldset/div/div[2]/select")));
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div/fieldset/div/div[2]/select")));

    webDriver.findElement(By.xpath("//div[2]/div/div/fieldset/div/div[2]/select")).click();
    webDriver.findElement(By.xpath("//div[2]/div/div/fieldset/div/div[2]/select/option[3]"))
        .click();
    webDriver.findElement(By.xpath("//div[2]/div/div[2]/fieldset/div/div[2]/input"))
        .sendKeys("1000Long rd Denmark");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[3]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/div/div[3]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[2]/div/div[4]/fieldset/div/div[2]/input")).sendKeys("76");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[5]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/div/div[5]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[2]/div/div[6]/fieldset/div/div[2]/input")).sendKeys("76");
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[7]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/div/div[7]/fieldset/div/div[2]/input"))
        .sendKeys("760000000");
    webDriver.findElement(By.xpath("//div[2]/div/div[8]/fieldset/div/div[2]/input"))
        .sendKeys("870099878");
    // ON the last two question, select Yes to trigger the new question then select No .
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[9]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/div/div[9]/fieldset/div/input")).click();
    WebElement SecondForm = webDriver.findElement(By.xpath("//div[2]/div/div[10]/fieldset/h4"));
    HighLight.highLightElement(webDriver, SecondForm);
    WebElement SecondForm1 = webDriver.findElement(By.xpath("//div[2]/div/div[12]/fieldset/h4"));
    HighLight.highLightElement(webDriver, SecondForm1);
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[10]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/div/div[10]/fieldset/div/input")).click();
    WebElement SecondForm2 = webDriver.findElement(By.xpath("//div[2]/div/div[11]/fieldset/h4"));
    HighLight.highLightElement(webDriver, SecondForm2);
    // Select no to disable section.
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[10]/fieldset/div/label[2]")));

    webDriver.findElement(By.xpath("//div[2]/div/div[10]/fieldset/div/label[2]")).click();
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[9]/fieldset/div/label[2]")));

    webDriver.findElement(By.xpath("//div[2]/div/div[9]/fieldset/div/label[2]")).click();
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/div/div[13]/fieldset/div/label[2]")));

    webDriver.findElement(By.xpath("//div[2]/div/div[13]/fieldset/div/label[2]")).click();
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    // Beginning Test For Personal Property.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Personal Property";
    assertEquals(Actual_Text, Expected_Text);
    logger.info("User is being navigated to the Personal Property section, PASS");
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you own any vehicles?";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_other_personal_property > fieldset > h4")).getText();
    Expected_Text = "Do you own any other personal property or assets?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver.findElement(By.xpath("//fieldset/p")).getText();
    Expected_Text =
        "If the vehicle is jointly owned or the loan on the vehicle is a joint debt, include only the individual’s share of the vehicle value and loan balance. You can find the current value of vehicles in the Kelley Blue Book.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement PersonalProperty = webDriver.findElement(By.xpath("//fieldset/p"));
    HighLight.highLightElement(webDriver, PersonalProperty);
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//div/a/span")).click();
    // Locate current value search box and enter a valid value for you
    // automobile.
    webDriver.findElement(By.id("DTE_Field_current_value")).sendKeys("70000000");
    // Locate the Loan Balance search box and enter a valid balance.
    webDriver.findElement(By.id("DTE_Field_loan_balance")).sendKeys("20000000");
    // Locate the description of asset search box and enter the
    // make,model and year of your automobile.
    webDriver.findElement(By.id("DTE_Field_asset_description")).sendKeys("nissan maxima");
    webDriver.findElement(By.xpath("//div[3]/button")).click();
    // Does any of the above listed property is pledged as security?
    // question.
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_other_personal_property > fieldset > h4")).getText();
    Expected_Text = "Do you own any other personal property or assets?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/p")).getText();
    Expected_Text =
        "Include all household goods, jewelry, art, boats, antiques, etc with a value over $2,500. (For example, enter a line for household furnishing with the total value of all furniture.) Include any assets held by a revocable trust for which you are the grantor and beneficiary. If the property is jointly owned, include only the individual’s share of the property.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement OtherPersonalProperty = webDriver.findElement(By.xpath("//div[2]/fieldset/p"));
    HighLight.highLightElement(webDriver, OtherPersonalProperty);
    // Select Yes for question; 'Do you own any other personal property or
    // assets?.
    jse.executeScript("arguments[0].scrollIntoView()",webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")));

    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[2]/fieldset/div[2]/div[2]/div/a/span")).click();
    webDriver.findElement(By.id("DTE_Field_current_value")).sendKeys("456000000");
    webDriver.findElement(By.id("DTE_Field_loan_balance")).sendKeys("453000");
    webDriver.findElement(By.id("DTE_Field_asset_description")).sendKeys("TOYOTA CAMRY");
    webDriver.findElement(By.cssSelector("button.btn")).click();
    CoreUtils.clickContinue(webDriver);
    // Verify that User navigate to the Next section of 'Notes Payable' in
    // form 413 successfully.
    // Click on the continue button to veriy section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    assertTrue(webDriver.getPageSource().contains("Notes Payable"));
    logger.info("User is being navigated to the 'Notes Payable' section on the form 413, Pass");
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Notes Payable and Other Liabilities";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you have any notes payable or other liabilities?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_notes_payable']/fieldset/p")).getText();
    Expected_Text =
        "List any notes payable including credit cards and personal lines of credit. Include loans owed to the applicant firm, other companies, and individuals. Exclude mortgage and vehicle loans, etc. if listed in previous sections. If you have additional liens or debts against your vehicles or personal property, list them. List all other liabilities, including accounts payable. Do not include contingent liabilities.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement NotesPayable =
        webDriver.findElement(By.xpath("//div[@id='answers_notes_payable']/fieldset/p"));
    HighLight.highLightElement(webDriver, NotesPayable);
    WebElement otherAccountsPayable =
        webDriver.findElement(By.xpath("//div[@id='answers_notes_payable']/fieldset/p"));
    HighLight.highLightElement(webDriver, otherAccountsPayable);
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//div/a/span")).click();
    // Verify the added drop down Type. Open when on develop.
    Actual_Text = webDriver.findElement(By.id("DTE_Field_type")).getText();
    Expected_Text =
        "Credit Card\nLien on Vehicle\nLien on Personal Property\nPersonal Loan\nPersonal Line of Credit\nOther";
    assertEquals(Actual_Text, Expected_Text);
    WebElement rateElement = webDriver.findElement(By.id("DTE_Field_type"));
	((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
    webDriver.findElement(By.xpath("//option[5]")).click();
    // Original balance.
    webDriver.findElement(By.id("DTE_Field_original_balance")).sendKeys("98090000");
    // current balance.
    webDriver.findElement(By.id("DTE_Field_current_balance")).sendKeys("8766000");
    // payment amount.
    webDriver.findElement(By.id("DTE_Field_payment_amount")).sendKeys("8760000");
    // How Secured.
    webDriver.findElement(By.id("DTE_Field_collateral_type")).sendKeys("Private home");
    // Name of note-holder
    webDriver.findElement(By.id("DTE_Field_noteholder")).sendKeys("Lost Man");
    // Address of note-holder
    webDriver.findElement(By.id("DTE_Field_noteholder_address"))
        .sendKeys("8576 jumple ln manassas va 20998");
    webDriver.findElement(By.cssSelector("button.btn")).click();
    CoreUtils.clickContinue(webDriver);
    // US660 'Assessed Taxes' test begin here.
    logger.info("US660'Assessed Taxes' test begin here");
    // Verify that user successfully navigated to the section 'Assessed
    // Taxes' on form 413.
    // Click on the continue button to veriy section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    assertTrue(webDriver.getPageSource().contains("Assessed Taxes"));
    logger.info("User successfully navigated to the section 'Assessed Taxes' on Form 413, Pass");
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Do you have any Assessed Taxes that were unpaid?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_assessed_taxes']/fieldset/p")).getText();
    Expected_Text =
        "Include only assessed taxes that are unpaid. This includes past due personal Federal, state, county, and city taxes. Do not include estimated taxes or business taxes. If this is a joint debt, include only the individual’s share of the debt.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement AssessedTaxes =
        webDriver.findElement(By.xpath("//div[@id='answers_assessed_taxes']/fieldset/p"));
    HighLight.highLightElement(webDriver, AssessedTaxes);
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//div/a/span")).click();
    webDriver.findElement(By.id("DTE_Field_whom_payable")).sendKeys("Test Running");
    webDriver.findElement(By.id("DTE_Field_amount")).sendKeys("1000045");
    webDriver.findElement(By.id("DTE_Field_when_due")).clear();
    webDriver.findElement(By.id("DTE_Field_when_due")).sendKeys("03/24/2017");
    webDriver.findElement(By.id("DTE_Field_property_tax_lien")).sendKeys("Factory");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/button")));
    webDriver.findElement(By.xpath("//div[3]/button")).click();
    // Locate and click on the continue button.
    CoreUtils.clickContinue(webDriver);
    // Click on the continue button to veriy section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/span")).getText();
    Expected_Text = "Please answer this question";
    // Locate the next 3 search boxes for Adjusted Gross Income and enter
    // valid data.
    // Verify the question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text = "Adjusted Gross Income (As shown on tax returns for Most Recent tax year)";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_agi_year_2 > fieldset > h4")).getText();
    Expected_Text = "Adjusted Gross Income (As shown on tax returns for previous tax year)";
    assertEquals(Actual_Text, Expected_Text);
    Actual_Text =
        webDriver.findElement(By.cssSelector("#answers_agi_year_3 > fieldset > h4")).getText();
    Expected_Text =
        "Adjusted Gross Income (As shown on tax returns for year before previous tax year)";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//div[@id='answers_agi_year_3']/fieldset/p")));
    // Detail Section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_agi_year_3']/fieldset/p")).getText();
    Expected_Text =
        "Use the adjusted gross income (AGI) on your Federal income tax return forms (Line 37 on Form 1040; Line 4 on 1040EZ; or Line 21 on Form 1040(a). Please note that this is rough guidance and should not be construed as SBA’s official position on calculating the AGI.";
    assertEquals(Actual_Text, Expected_Text);
    WebElement AdjustedGrossIncome =
        webDriver.findElement(By.xpath("//div[@id='answers_agi_year_3']/fieldset/p"));
    HighLight.highLightElement(webDriver, AdjustedGrossIncome);
    webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("30000");
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/div[2]/input")).sendKeys("10000");
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/div[2]/input")).sendKeys("20000");
    // Locate and click on the continue button.
    CoreUtils.clickContinue(webDriver);
    // Verify that user is being navigated to the Summary Page.
    String actual_Text6 = webDriver.findElement(By.cssSelector("h2")).getText();
    String expected_Text6 = "Denzel Washington";
    assertEquals(actual_Text6, expected_Text6);
    // Calculations for Partner's financial summary.
    AdminFinancialCalculationOnSummaryPage adminFinancialCalculationOnSummary =
        new AdminFinancialCalculationOnSummaryPage(webDriver);
    adminFinancialCalculationOnSummary.AdminFinancialCalculationOnSummary();
    CoreUtils.clickContinue(webDriver);
    logger.info(
        "Detail test for the Privacy Statements section for Paul Washington on form413 begins here");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    // Verify that user is being navigated to the Privacy Statements Page.
    String actual_Text1 = webDriver.findElement(By.cssSelector("h2")).getText();
    String expected_Text1 = "Privacy Statements";
    assertEquals(actual_Text1, expected_Text1);
    // Click on the save and continue button.
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    // Verify that user is being navigated to the Review Page.
    String actual_Text2 = webDriver.findElement(By.cssSelector("h2")).getText();
    String expected_Text2 = "Review";
    assertEquals(actual_Text2, expected_Text2);
    webDriver.findElement(By.xpath("//form/ul/li[2]/a")).click();
    // Total assets.
    Actual_Text = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[11]/td[2]")).getText();
    Expected_Text = "$550,412,068.00";
    assertEquals(Actual_Text, Expected_Text);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[4]")));
    webDriver.findElement(By.xpath("//input[4]")).click();
    wait.until(ExpectedConditions.alertIsPresent());
    logger.info(webDriver.switchTo().alert().getText());
    webDriver.switchTo().alert().accept();
    // Verify that user is being navigated to the Signature Page.
    String actual_Text4 = webDriver.findElement(By.cssSelector("h2")).getText();
    String expected_Text4 = "Signature";
    assertEquals(actual_Text4, expected_Text4);
    // Verify that the accept button is present..
    String actual_Text5 = webDriver.findElement(By.id("accept-button")).getText();
    String expected_Text5 = "Accept";
    assertEquals(actual_Text5, expected_Text5);
  }

  private void assertEquals(String actual_Text1, String expected_Text1) {
    // TODO Auto-generated method stub
  }
}
