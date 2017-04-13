package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.TestCase;

  public class TestApp580ElasticSearchForAnalyst extends TestCase {

    private static final Logger logger = LogManager
            .getLogger(TestApp580ElasticSearchForAnalyst.class.getName());
    private static WebDriver webDriver;
    int get_The_Row_From_Login_Data;

    @Before
    public void setUp() throws Exception {
        webDriver = TestHelpers.getDefaultWebDriver();
        webDriver.get(TestHelpers.getBaseUrl());
        webDriver.manage().window().maximize();
        get_The_Row_From_Login_Data = 0;
    }

    @Test
    public void testMainTest() throws Exception {
        String Actual_Text;
        String Expected_Text;
        logger.info("Apply Analyst permissions to All Cases page, Elastic Search");
        // Login to dashboard.
        LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
        login_Data.Login_With_Reference();
        Thread.sleep(3000);
        // delete to start a new certification.
        DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
        deleteDraftCert.DeleteDraftCert();
        Thread.sleep(2000);
        webDriver.navigate().to("https://certify.qa.sba-one.net/sba_analyst/cases/all_cases/");
        //webDriver.navigate().to("http://localhost/sba_analyst/cases/all_cases/");
        //Verify the All case page.
        Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
        Expected_Text = "All cases";
        assertEquals(Actual_Text, Expected_Text);
        //Verify Status.
        webDriver.findElement(By.cssSelector("li > button.usa-accordion-button")).click(); 
        //Click on the search button without selecting any filter and verify.
        webDriver.findElement(By.xpath("//div/div[2]/button")).click();
        //Select program, Review Type and status.
        webDriver.findElement(By.id("hubzone")).click();
        webDriver.findElement(By.id("continuing_eligibility")).click();
        webDriver.findElement(By.id("proposed_ineligible")).click();
        //Enter invalid data on the date range owner and the search box and verify.
        //From date.
        webDriver.findElement(By.id("date_of_birth_1")).sendKeys("Test");
        webDriver.findElement(By.id("date_of_birth_2")).sendKeys("Test");
        webDriver.findElement(By.id("date_of_birth_3")).sendKeys("Test");
        //To date
        webDriver.findElement(By.xpath("//div[3]/div/input")).sendKeys("Test");
        webDriver.findElement(By.xpath("//div[3]/div[2]/input")).sendKeys("Tes2");
        webDriver.findElement(By.xpath("//div[3]/div[3]/input")).sendKeys("Tes4");
        webDriver.findElement(By.cssSelector("input.autocomplete.ui-autocomplete-input")).sendKeys("Testing234");
        //Enter an invalid search data.
        webDriver.findElement(By.id("search-field-small")).sendKeys("Testing234");
        //Click the search button.
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();        
        //Verify that no data is return.
        Actual_Text = webDriver.findElement(By.cssSelector("td")).getText();
        Expected_Text = "No results found.";
        assertEquals(Actual_Text, Expected_Text);
        WebElement NoReturnData =webDriver.findElement(By.cssSelector("td"));
        HighLight.highLightElement(webDriver, NoReturnData);
        //Click on the clear filter button.
        webDriver.findElement(By.name("commit")).click();        
        Thread.sleep(2000);
        Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/input")).getText();
        Expected_Text = "Testing234";
        assertNotSame(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.id("search-field-small")).getText();
        Expected_Text = "Testing234";
        assertNotSame(Actual_Text, Expected_Text);
        WebElement OwnerBoxCleared =webDriver.findElement(By.xpath("//div[2]/div/input"));
        HighLight.highLightElement(webDriver, OwnerBoxCleared);
        //Logout, log back in and submit some application.
        webDriver.findElement(By.linkText("Logout")).click();
        // Login to dashboard.
        get_The_Row_From_Login_Data = 3;
        LoginPageWithReference login_Data1 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
        login_Data1.Login_With_Reference();
        Thread.sleep(3000);
        // delete to start a new certification.
        DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
        deleteDraftCert1.DeleteDraftCert();
        Thread.sleep(2000);
        DeleteDraftCertPage deleteDraftCert13 = new DeleteDraftCertPage(webDriver);
        deleteDraftCert13.DeleteDraftCert();
        AddOrStartCertificationPage addOrStartCertification = new AddOrStartCertificationPage(webDriver);
        addOrStartCertification.AddOrStartCertification();
        // Start new 8(a) application.
        EDWOSBEightATestPage eDWOSBEightATest = new EDWOSBEightATestPage(webDriver);
        eDWOSBEightATest.EDWOSBEightATest();
        // Verify for active and Draft program on the dashboard, if draft
        // delete and start a new one.
        webDriver.findElement(By.linkText("Dashboard")).click();
        //Verify if there is an existing certification on the dashboard and
        // delete to start a new certification.
        DeleteDraftCertPage deleteDraftCert2 = new DeleteDraftCertPage(webDriver);
        deleteDraftCert2.DeleteDraftCert();
        Thread.sleep(2000);
        AddOrStartNewMppProgramPage1 addOrStartNewMppProgram = new AddOrStartNewMppProgramPage1(webDriver);
        addOrStartNewMppProgram.AddOrStartNewMppProgram();
        // Start new 8(a) application.
        EdwobEightAMppTestPage edwobEightAMppTest = new EdwobEightAMppTestPage(webDriver);
        edwobEightAMppTest.EdwobEightAMppTest();
        //verify the two active programs.
        WebElement MppPending =webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[5]"));
        HighLight.highLightElement(webDriver, MppPending);
        WebElement EdwosbActive =webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr[2]/td[5]"));
        HighLight.highLightElement(webDriver, EdwosbActive);
        //Logout and login back as an analyst.
        webDriver.findElement(By.linkText("Logout")).click();
        get_The_Row_From_Login_Data = 0;
        LoginPageWithReference login_Data2 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
        login_Data2.Login_With_Reference();
        webDriver.navigate().to("https://certify.qa.sba-one.net/sba_analyst/cases/all_cases/");
        //filter by DUNs and verify.
        webDriver.findElement(By.id("search-field-small")).sendKeys("172115728");
        //Click on the search button.
        webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //Verify that the MPP and EDWOSB programs are return.
        Thread.sleep(2000);
        Actual_Text = webDriver.findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[2]/a")).getText();
        Expected_Text = "172115728";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.xpath("//div[@id='table-search']/table/tbody/tr[2]/td[2]/a")).getText();
        Expected_Text = "172115728";
        assertEquals(Actual_Text, Expected_Text);
        //Filter search EDWOSB program only.
        webDriver.findElement(By.cssSelector("li > button.usa-accordion-button")).click();
        webDriver.findElement(By.id("edwosb")).click();
        webDriver.findElement(By.cssSelector("input.autocomplete.ui-autocomplete-input")).sendKeys("Analyst2 X");
        Thread.sleep(4000);
        webDriver.findElement(By.id("search-field-small")).sendKeys("172115728");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //Verify that only the EDWOSB program is return.
        Thread.sleep(2000);
        Actual_Text = webDriver.findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[3]")).getText();
        Expected_Text = "EDWOSB";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.linkText("172115728")).getText();
        Expected_Text = "172115728";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[3]")).getText();
        Expected_Text = "MPP";
        assertNotSame(Actual_Text, Expected_Text);
        //Filter search MPP program only.
        webDriver.findElement(By.cssSelector("li > button.usa-accordion-button")).click();
        webDriver.findElement(By.id("mpp")).click();
        webDriver.findElement(By.cssSelector("input.autocomplete.ui-autocomplete-input")).sendKeys("Analyst2 X");
        Thread.sleep(4000);
        webDriver.findElement(By.id("search-field-small")).sendKeys("172115728");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //Verify that only the MPP program is return.
        Thread.sleep(2000);
        Actual_Text = webDriver.findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[3]")).getText();
        Expected_Text = "MPP";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.linkText("172115728")).getText();
        Expected_Text = "172115728";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.xpath("//div[@id='table-search']/table/tbody/tr/td[3]")).getText();
        Expected_Text = "EDWOSB";
        assertNotSame(Actual_Text, Expected_Text);
        //Navigate back to case page, search the business and return the EDWOSB certification.
        Thread.sleep(3000);
        webDriver.navigate().to("https://certify.qa.sba-one.net/sba_analyst/cases");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
        webDriver.findElement(By.id("query")).sendKeys("172115728");
        webDriver.findElement(By.xpath("//form/div/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
        Thread.sleep(2000);
        if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.linkText("Logout")).click();
        } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.linkText("Logout")).click();
        }
        // Login as MPP-analyst and return MPP back to vendor.
        get_The_Row_From_Login_Data = 29;
        LoginPageWithReference login_Data61 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
        login_Data61.Login_With_Reference();
        webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
        webDriver.findElement(By.id("query")).sendKeys("172115728");
        webDriver.findElement(By.xpath("//form/div/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.linkText("Entity 81 Legal Business Name")).click();
        Thread.sleep(2000);
        if (webDriver.getPageSource().contains("Return to Vendor")) {
        webDriver.findElement(By.linkText("Return to Vendor")).click();
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.linkText("Logout")).click();
        } else {
        logger.info("Return to Vendor Link is missing please verify why.");
        webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.id("submit_button")).click();
        webDriver.findElement(By.linkText("Determination")).click();
        webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
        webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
        webDriver.findElement(By.linkText("Vendor Overview")).click();
        webDriver.findElement(By.linkText("Logout")).click();
        }
        get_The_Row_From_Login_Data = 3;
        LoginPageWithReference login_Data11 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
        login_Data11.Login_With_Reference();
        //delete one draft.
        Thread.sleep(2000);
        DeleteDraftCertPage deleteDraftCert21 = new DeleteDraftCertPage(webDriver);
        deleteDraftCert21.DeleteDraftCert();       
        logger.info("SUCCESS");
    }

    @After
    public void tearDown() throws Exception {
        webDriver.close();
    }
        }
