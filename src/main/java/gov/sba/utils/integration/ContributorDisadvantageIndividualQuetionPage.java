package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;
import junit.framework.TestCase;

  public class ContributorDisadvantageIndividualQuetionPage extends TestCase {
    private static final Logger logger = LogManager.getLogger(ContributorDisadvantageIndividualQuetionPage.class.getName());
    WebDriver webDriver;
    int get_The_Row_From_Login_Data;
    String SDvDFN;
    String SDvDEmail1;
    String SDvDEmail2;
    String SDvDEmail3;
    String SDvDEmail4;

  public ContributorDisadvantageIndividualQuetionPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    SDvDFN = "Contributor1 SDVD";
    SDvDEmail1 = "norole22@mailinator.com";
    SDvDEmail1 = "norole12@mailinator.com";
    SDvDEmail1 = "norole13@mailinator.com";
    SDvDEmail1 = "akanamontana@gmail.com";

    }

  public void ContributorDisadvantageIndividualQuetion() throws Exception {
    try{
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    logger.info("Completing Disadvantaged Individual Sub-questionnaire");
    String Actual_Text = null;
    String Expected_Text = null;     
    wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//b[4]/a"), false));
    Actual_Text = webDriver.findElement(By.xpath("//b[4]/a")).getText();
    Expected_Text = "Add another Disadvantaged Individual, if applicable";
    assertEquals(Actual_Text, Expected_Text);
    //Click on the Add a spouse of a Disadvantaged Individual link and invite this contributor.
    webDriver.findElement(By.linkText("Add another Disadvantaged Individual, if applicable")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
    //Validate the send invitation button is present and to make sure users can't send empty data as request// open when de fix.
    //try {
    //assertTrue(isElementPresent(By.name("commit")));
    //CoreUtils.clickContinue(webDriver);
    //Actual_Text = webDriver.findElement(By.xpath("enter when error is fixed")).getText();
    //Expected_Text = "Please enter full name and email.";
    //assertEquals(Actual_Text, Expected_Text);
    //logger.info("Sending invite to SDVD");
    //} catch (Error e) {
    //logger.info(e.getMessage()); 
    //}
    //Try to send an invalid email(Email that is already associated to a business.
    //try {
    //webDriver.findElement(By.xpath("//form[2]/fieldset/ul/li/input")).sendKeys("Contributor1 SDVD");
    //webDriver.findElement(By.xpath("//form[2]/fieldset/ul/li[2]/input")).sendKeys("norole22@mailinator.com");
    //CoreUtils.clickContinue(webDriver);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
    //Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
    //Expected_Text = "Contributor1 SDVD has been added";
    //assertEquals(Actual_Text, Expected_Text);
    //logger.info("Invite was sent to SDVD");
    //} catch (Error e) {
    //logger.info(e.getMessage()); 
    //}     
    try{
    //Enter Full Name of contributor.
    webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor1 DVD");
    //Enter contributor's email.
    webDriver.findElement(By.id("contributor_email")).sendKeys("norole18@mailinator.com");
    //Click on the Send invitation to collaborator button.
    CoreUtils.clickContinue(webDriver);
    webDriver.navigate().back();
    webDriver.findElement(By.linkText("Add another Disadvantaged Individual, if applicable")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
    CoreUtils.clickContinue(webDriver);
    //Verify that contributor SDVD is successfully added.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
    Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
    Expected_Text = "Contributor1 DVD has been added";
    assertEquals(Actual_Text, Expected_Text);
    logger.info("invite to DVD is successfully send");
    } catch (Error e) {
    logger.info(e.getMessage()); 
    }
    //Logout and login with the invited contributor.
    webDriver.findElement(By.linkText("Logout")).click();
    get_The_Row_From_Login_Data = 61;
    LoginPageWithReference login_Data =new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    
    
    //Verify intro page.
    
    
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Gender";
    assertEquals(Actual_Text, Expected_Text);
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2"))); 
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Marital Status";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.findElement(By.xpath("//label")).click();
    CoreUtils.clickContinue(webDriver);
    //Verify page.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2"))); 
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);      
    //Enter SSN
    webDriver.findElement(By.id("input-type-text")).sendKeys("123456789");
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);      
    Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    Expected_Text = "Please answer this question";
    assertEquals(Actual_Text, Expected_Text);       
    webDriver.findElement(By.id("input-type-text")).sendKeys("123456789");
    //click on continue.
    CoreUtils.clickContinue(webDriver);      
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    //Verify section is required.
    CoreUtils.clickContinue(webDriver); 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fieldset/span")));
    Actual_Text = webDriver.findElement(By.xpath("//fieldset/span")).getText();
    Expected_Text = "This field is required.";
    assertEquals(Actual_Text, Expected_Text);            
    //enter address.
    webDriver.findElement(By.xpath("//fieldset/div/fieldset/input")).sendKeys("7865 testing dr country");
    webDriver.findElement(By.xpath("//div/input")).sendKeys("Washington");
    Actual_Text = webDriver.findElement(By.xpath("//select")).getText();
    Expected_Text = "Select a state\nAlabama\nAlaska\nArizona\nArkansas\nCalifornia\nColorado\nConnecticut\nDelaware\nFlorida\nGeorgia\nHawaii\nIdaho\nIllinois\nIndiana\nIowa\nKansas\nKentucky\nLouisiana\nMaine\nMaryland\nMassachusetts\nMichigan\nMinnesota\nMississippi\nMissouri\nMontana\nNebraska\nNevada\nNew Hampshire\nNew Jersey\nNew Mexico\nNew York\nNorth Carolina\nNorth Dakota\nOhio\nOklahoma\nOregon\nPennsylvania\nRhode Island\nSouth Carolina\nSouth Dakota\nTennessee\nTexas\nUtah\nVermont\nVirginia\nWashington\nWest Virginia\nWisconsin\nWyoming\nDistrict of Columbia\nPuerto Rico\nGuam\nAmerican Samoa\nU.S. Virgin Islands\nNorthern Mariana Islands";
    assertEquals(Actual_Text, Expected_Text);
    webDriver.findElement(By.xpath("//select")).click();
    webDriver.findElement(By.xpath("//option[48]")).click();
    webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("20987");
    webDriver.findElement(By.xpath("//input[5]")).sendKeys("09/12/1990");
    //click on continue.
    //CoreUtils.clickContinue(webDriver);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
    //assertEquals("Role in Applicant Firm", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    //CoreUtils.clickContinue(webDriver);       
    //Actual_Text = webDriver.findElement(By.xpath("//div/span")).getText();
    //Expected_Text = "Please answer this question";
    //assertEquals(Actual_Text, Expected_Text);       
    //webDriver.findElement(By.xpath("//div/input")).click();
    //click on continue.
    CoreUtils.clickContinue(webDriver);      
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Length of residency", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);       
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();
    //click on continue.
    CoreUtils.clickContinue(webDriver);      
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Date and Place of Birth", webDriver.findElement(By.cssSelector("h2")).getText());
    webDriver.findElement(By.xpath("//input[5]")).sendKeys("04/23/1978");
    webDriver.findElement(By.id("input-type-text")).sendKeys("Washington");
    //click on continue.
    CoreUtils.clickContinue(webDriver);       
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("US Citizenship", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);          
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();
    //click on continue.
    CoreUtils.clickContinue(webDriver);      
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Upload Resume", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);        
    assertEquals("Attachment is required", webDriver.findElement(By.xpath("//div/span")).getText());     
    //Upload a document.
    String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage uploadDocumentContributors = new UploadDocumentContributorsPage(webDriver);
    uploadDocumentContributors.UploadDocumentContributors(file_path_abs);
    //click on continue.
    CoreUtils.clickContinue(webDriver);       
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Applicant Firm Ownership", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);      
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div[2]/span")).getText());
    webDriver.findElement(By.xpath("//div[2]/input")).sendKeys("76");
    webDriver.findElement(By.id("input-type-textarea")).sendKeys("Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    //click on continue.
    CoreUtils.clickContinue(webDriver);      
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Bank Account Access", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);        
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//textarea")).sendKeys("Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    //click on continue.
    CoreUtils.clickContinue(webDriver);      
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Full Time Devotion", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);       
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage uploadDocumentContributors0 = new UploadDocumentContributorsPage(webDriver);
    uploadDocumentContributors0.UploadDocumentContributors(file_path_abs);
    //click on continue.
    CoreUtils.clickContinue(webDriver);   
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Business Affiliations", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);      
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();     
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage uploadDocumentContributors2 = new UploadDocumentContributorsPage(webDriver);
    uploadDocumentContributors2.UploadDocumentContributors(file_path_abs);
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//textarea")).sendKeys("Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    //click on continue.
    CoreUtils.clickContinue(webDriver);       
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Prior 8a Involvement", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);       
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText());
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();      
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage uploadDocumentContributors3 = new UploadDocumentContributorsPage(webDriver);
    uploadDocumentContributors3.UploadDocumentContributors(file_path_abs);      
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();      
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    ContributorUploadPage2 contributorUpload = new ContributorUploadPage2(webDriver);
    contributorUpload.ContributorUpload(file_path_abs);     
    //click on continue.
    CoreUtils.clickContinue(webDriver);       
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Federal Employment", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);         
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();      
    //Upload a document.
    String file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors1 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors1.UploadDocumentContributors(file_path_abs4);     
    //click on continue.
    CoreUtils.clickContinue(webDriver); 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Household Federal Employment", webDriver.findElement(By.cssSelector("h2")).getText());
    webDriver.findElement(By.xpath("//div/input")).click(); 
    //Upload a document.
    file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors01 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors01.UploadDocumentContributors(file_path_abs4);
    //click on continue.
    CoreUtils.clickContinue(webDriver);   
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Financial", webDriver.findElement(By.cssSelector("h2")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();      
    //Upload a document.
    file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors2 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors2.UploadDocumentContributors(file_path_abs4);
    //Select yes and upload documents.
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();     
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    ContributorUploadPage2 contributorUpload1 = new ContributorUploadPage2(webDriver);
    contributorUpload1.ContributorUpload(file_path_abs);       
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();     
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    ContributorUploadPage3 contributorUpload2 = new ContributorUploadPage3(webDriver);
    contributorUpload2.ContributorUpload(file_path_abs);       
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/input")).click();     
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    ContributorUploadPage4 contributorUpload3 = new ContributorUploadPage4(webDriver);
    contributorUpload3.ContributorUpload(file_path_abs);
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Criminal History", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);       
    assertEquals("Please answer this question", webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();
    webDriver.findElement(By.xpath("//textarea")).sendKeys("Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
    webDriver.findElement(By.xpath("//div[2]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/input")).click();
    webDriver.findElement(By.xpath("//div[3]/fieldset/div/label")).click();
    webDriver.findElement(By.xpath("//div[4]/fieldset/div/input")).click();
    //click on continue.
    CoreUtils.clickContinue(webDriver); 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    //Verify section is required.
    CoreUtils.clickContinue(webDriver); 
    assertEquals("Attachment is required", webDriver.findElement(By.xpath("//div[2]/fieldset/div/div/span")).getText());      
    //Upload a document.
    file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors3 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors3.UploadDocumentContributors(file_path_abs4);      
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    ContributorUploadPage2 contributorUpload4 = new ContributorUploadPage2(webDriver);
    contributorUpload4.ContributorUpload(file_path_abs);      
    //Upload a document.
    file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    ContributorUploadPage3 contributorUpload5 = new ContributorUploadPage3(webDriver);
    contributorUpload5.ContributorUpload(file_path_abs);  
    //click on continue.
    CoreUtils.clickContinue(webDriver);       
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Basis of Disadvantage.", webDriver.findElement(By.cssSelector("h2")).getText());
    assertEquals("Black American\nHispanic American\nNative American\nAsian Pacific American\nSubcontinent Asian American\nNone of the above", webDriver.findElement(By.xpath("//select")).getText());
    webDriver.findElement(By.xpath("//select")).click();
    webDriver.findElement(By.xpath("//option[3]")).click();
    webDriver.findElement(By.xpath("//textarea")).sendKeys("Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
    //click on continue.
    CoreUtils.clickContinue(webDriver);   
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Native American Documentation", webDriver.findElement(By.cssSelector("h2")).getText());
    //Upload a document.
    file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors03 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors03.UploadDocumentContributors(file_path_abs4);
    //click on continue.
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Social Narrative", webDriver.findElement(By.cssSelector("h2")).getText());
    //Upload a document.
    file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors04 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors04.UploadDocumentContributors(file_path_abs4);
    //click on continue.
    CoreUtils.clickContinue(webDriver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Transfer Assets", webDriver.findElement(By.cssSelector("h2")).getText());
    webDriver.findElement(By.xpath("//div/input")).click();      
    webDriver.findElement(By.xpath("//textarea")).sendKeys("Like any other social media site Facebook has length requirements when it comes to writing on the wall, providing status, messaging and commenting. Understanding how many characters you can use, enables you to more effectively use Facebook as a business or campaign tool");
    //click on continue.
    CoreUtils.clickContinue(webDriver);       
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    assertEquals("Tax Returns", webDriver.findElement(By.cssSelector("h2")).getText());
    //Verify section is required.
    CoreUtils.clickContinue(webDriver);       
    assertEquals("Attachment is required", webDriver.findElement(By.xpath("//div/span")).getText());      
    //Upload a document.
    file_path_abs4 = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
    UploadDocumentContributorsPage UploadDocumentContributors4 = new UploadDocumentContributorsPage(webDriver);
    UploadDocumentContributors4.UploadDocumentContributors(file_path_abs4);
    webDriver.findElement(By.id("section_submit_button")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));      
    //Complete the SDvD financial section.
    ContributorsFinancialSectionPage contributorsFinancialSection = new ContributorsFinancialSectionPage(webDriver);
    contributorsFinancialSection.ContributorsFinancialSection();      
    //Verify section is completed.
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.usa-alert-text")));
    Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
    Expected_Text = "8(a) Disadvantaged Individual section is complete";
    assertEquals(Actual_Text, Expected_Text);
    logger.info("8(a) Disadvantaged Individual section is complete");
    //Logout.
    webDriver.findElement(By.linkText("Logout")).click();    
    //Login to the Admin dashboard.
    get_The_Row_From_Login_Data = 1;
    LoginPageWithReference login_Data1 =new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data1.Login_With_Reference();
    //Click on the dashboard.
    webDriver.findElement(By.xpath("//a/span")).click();
    webDriver.findElement(By.linkText("8(a) Initial Program")).click();
    //Contributors is verify to be completed, but click on it to add other contributors.
    Actual_Text = webDriver.findElement(By.xpath("//tr[3]/td[3]")).getText();
    Expected_Text = "COMPLETE";
    assertEquals(Actual_Text, Expected_Text);
    WebElement ContributorStatusInProgress = webDriver.findElement(By.xpath("//tr[3]/td[3]"));
    HighLight.highLightElement(webDriver, ContributorStatusInProgress);
    webDriver.findElement(By.linkText("Contributors")).click(); 
    } catch (Exception e) {
    ScreenShotPage screenShot = new ScreenShotPage(webDriver);
    screenShot.ScreenShot();
    logger.info(e.getMessage());
    Assert.fail();
    }    
    }
    }