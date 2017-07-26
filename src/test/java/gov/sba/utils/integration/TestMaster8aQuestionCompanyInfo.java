package gov.sba.utils.integration;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import gov.sba.automation.CoreUtils;
import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

@Category({gov.sba.utils.integration.UnstableTests.class})

public class TestMaster8aQuestionCompanyInfo extends TestCase {

  private static final Logger logger =
      LogManager.getLogger(TestMaster8aQuestionCompanyInfo.class.getName());
  private static WebDriver webDriver;
  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {
    webDriver = TestHelpers.getDefaultWebDriver();

    webDriver.get(TestHelpers.getBaseUrl());
    webDriver.manage().window().maximize();
    get_The_Row_From_Login_Data = 12;
  }

  @Test
  public void testMaster8aQuestionCompanyInfo() throws Exception {
    String Actual_Text;
    String Expected_Text;
    logger.info(
        "As an 8(a) applicant, I want to enter my business' Control information on an 8(a) application, No with skip to review flow.");
    // Login to dashboard.
    LoginPageWithReference login_Data =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    // TestWorkFlowxx8aInProgress to start a new certification.
    DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
    deleteDraftCert.DeleteDraftCert();
    // TestWorkFlowxx8aInProgress to start a new certification.
    DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
    deleteDraftCert1.DeleteDraftCert();
    webDriver.navigate().to(
        "https://certify.qa.sba-one.net/questionnaires/eight_a_initial/sba_applications/new?application_type_id=initia");
    // webDriver.navigate().to("http://localhost/questionnaires/eight_a_initial/sba_applications/new?application_type_id=initial&certificate_type_id=eight_a");
    CoreUtils.clickContinue(webDriver);
    // Verify the Basic Company Info link.
    Actual_Text = webDriver.findElement(By.linkText("Company Info")).getText();
    Expected_Text = "Company Info";
    assertEquals(Actual_Text, Expected_Text);
    // Verify Status.
    Actual_Text = webDriver.findElement(By.xpath("//tr[5]/td[3]")).getText();
    Expected_Text = "NOT STARTED";
    assertEquals(Actual_Text, Expected_Text);
    WebElement CompanyInfoStatusNotStarted = webDriver.findElement(By.xpath("//tr[5]/td[3]"));
    HighLight.highLightElement(webDriver, CompanyInfoStatusNotStarted);
    // Click on the contributor link and verify page.
    webDriver.findElement(By.linkText("Company Info")).click();
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Company Stuff";
    assertEquals(Actual_Text, Expected_Text);
    // 1st question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Have you performed work in the NAICS code in which you’re requesting business development assistance?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text =
        webDriver.findElement(By.xpath("//div[@id='answers_prior_naics_code_work']/fieldset/p[2]"))
            .getText();
    Expected_Text =
        "You must have prior experience in the NAICS code in the NAICS code in which you’re seeking assistance.";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes.
    webDriver.findElement(By.id("answers_195_value_yes")).click();
    // 2nd question.
    Actual_Text = webDriver
        .findElement(By.cssSelector("#answers_small_for_mpp_naics_code > fieldset > h4")).getText();
    Expected_Text =
        "Are you considered small for the NAICS code in which you’re requesting business development assistance?";
    assertEquals(Actual_Text, Expected_Text);
    // Detail Section.
    Actual_Text = webDriver
        .findElement(By.xpath("//div[@id='answers_small_for_mpp_naics_code']/fieldset/p[2]"))
        .getText();
    Expected_Text =
        "To qualify as a protégé firm, your business must qualify as small for the NAICS code for which it is seeking business development assistance. Size standards have been established for types of economic activity, or industry, under the North American Industry Classification System (NAICS). To determine the size standard associated with a particular NAICS code, refer to the table of size standards in the Small Business Size Regulations. Reference: 13 CFR 121.201";
    assertEquals(Actual_Text, Expected_Text);
    // verify link.
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String main_window = webDriver.getWindowHandle();
    logger.info("Before switching, title is = certify.sba.gov");
    webDriver.findElement(By.linkText("13 CFR 121.201")).click();
    assertEquals(Actual_Text, Expected_Text);
    java.util.Set<String> S = webDriver.getWindowHandles();
    Iterator<String> i = S.iterator();
    while (i.hasNext()) {
      String Second_window = i.next();
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
    // Select Yes and continue.
    webDriver.findElement(By.id("answers_196_value_yes")).click();
    CoreUtils.clickContinue(webDriver);
    // Verify the More Co Stuff page.
    // 1st question.
    Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
    Expected_Text =
        "Have you received a size redetermination letter from the SBA that subsequently found you to be small in that NAICS code?";
    assertEquals(Actual_Text, Expected_Text);
    // Select Yes and continue.
    webDriver.findElement(By.id("answers_197_value_yes")).click();
    CoreUtils.clickContinue(webDriver);
    // Click on the Save and Continue button.
    Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
    Expected_Text = "8(A) Company Information Summary";
    assertEquals(Actual_Text, Expected_Text);
    // Navigate back and verify in-progress status for the draft.
    webDriver.findElement(By.xpath("//a/span")).click();
    // click on the draft 8(a) Initial Program.
    webDriver.findElement(By.linkText("8(a) Initial Program")).click();
    Actual_Text = webDriver.findElement(By.xpath("//tr[5]/td[3]")).getText();
    Expected_Text = "IN PROGRESS";
    assertEquals(Actual_Text, Expected_Text);
    WebElement EligibilityInProgressStatus = webDriver.findElement(By.xpath("//tr[5]/td[3]"));
    HighLight.highLightElement(webDriver, EligibilityInProgressStatus);
    webDriver.findElement(By.linkText("Company Info")).click();
    webDriver.findElement(By.id("eight_a_company_stuff_too")).click();
    CoreUtils.clickContinue(webDriver);
    Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
    Expected_Text = "Review";
    assertEquals(Actual_Text, Expected_Text);
    // Click on the Submit button.
    CoreUtils.clickContinue(webDriver);
    webDriver.switchTo().alert().accept();
    // Verify status.
    Actual_Text = webDriver.findElement(By.xpath("//tr[5]/td[3]")).getText();
    Expected_Text = "COMPLETE";
    assertEquals(Actual_Text, Expected_Text);
    WebElement CompanyInfoStatusCompleted = webDriver.findElement(By.xpath("//tr[5]/td[3]"));
    HighLight.highLightElement(webDriver, CompanyInfoStatusCompleted);
    webDriver.findElement(By.linkText("Logout")).click();

  }

  @After
  public void tearDown() throws Exception {
    webDriver.close();
  }
}
