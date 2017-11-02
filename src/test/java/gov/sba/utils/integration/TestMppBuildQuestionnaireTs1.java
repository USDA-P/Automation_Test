// @Montana
package gov.sba.utils.integration;

import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;
import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMppBuildQuestionnaireTs1 extends TestCase {
	private static final Logger logger = LogManager.getLogger(TestMppBuildQuestionnaireTs1.class.getName());
	private static WebDriver webDriver;
	int get_The_Row_From_Login_Data;
	String DunsNumber;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();

		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 25;
		DunsNumber = null;
	}

	@Test
	public void testMppBuildQuestionnaireTs1() throws Exception {
		// try {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		String Actual_Text;
		String Expected_Text;
		// JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		// Login to dashboard.
		logger.info("Mpp question test Scenario 1 possitive");
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		// Get the vendor Duns Number.
		webDriver.findElement(By.xpath("//li[4]/a/span")).click();
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//p[2]/span"), false));
		DunsNumber = webDriver.findElement(By.xpath("//p[2]/span")).getText();
		webDriver.findElement(By.xpath("//a/span")).click();
		logger.info("The Duns number for this business is " + DunsNumber);
		// Verify if there is an existing program on the dashboard and
		// delete to start a new certification.
		// Delete second draft if any.
		DeleteDraftCertPage deleteDraftCert11111 = new DeleteDraftCertPage(webDriver);
		deleteDraftCert11111.DeleteDraftCert();
		// Start the application.
		AddOrStartNewMppProgramPage addOrStartNewMppProgram = new AddOrStartNewMppProgramPage(webDriver);
		addOrStartNewMppProgram.AddOrStartNewMppProgram();
		// MPP Questions Section, 8(a) Participants. Answer=NO.
		// Verifying Question.
		Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
		Expected_Text = "Are you an existing 8(a) firm in your final 6 months of the program, wishing to transfer your Mentor-Protégé relationship to the All Small Mentor-Protégé Program?";
		assertEquals(Actual_Text, Expected_Text);
		// Verifying detail meaning for question.
		Actual_Text = webDriver.findElement(By.xpath("//p[2]")).getText();
		Expected_Text = "If yes, please upload your dated 8(a) Mentor-Protégé Approval Letter and your current 8(a) Mentor-Protégé Agreement. You are eligible for the All Small Mentor-Protégé Program and you will skip forward to the “Review” section of this application.";
		assertEquals(Actual_Text, Expected_Text);
		// Click on the continue button without answering the question and
		// verify error message.
		CoreUtils.clickContinue(webDriver);
		Actual_Text = webDriver.findElement(By.id("answers[117][value]-error")).getText();
		Expected_Text = "Please answer this question";
		assertEquals(Actual_Text, Expected_Text);
		// Select No and commit.
		webDriver.findElement(By.cssSelector("label.yes")).click();
		// Upload document.
		String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
		MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
		MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
		// FillApplCreatePages.finalSignatureSubmit(webDriver);
		CoreUtils.clickContinue(webDriver);
		// Enter a valid DUNS# and verify business.
		webDriver.findElement(By.id("duns-value-167")).sendKeys(DunsNumber);
		webDriver.findElement(By.xpath("//a[@id='search-duns-167']")).click();
		webDriver.findElement(By.xpath("//a[@id='search-duns-167']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		logger.info(webDriver.switchTo().alert().getText());
		webDriver.switchTo().alert().accept();
		CoreUtils.clickContinue(webDriver);
		// Review page.
		Actual_Text = webDriver.findElement(By.xpath("//article/h2")).getText();
		Expected_Text = "Review";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
		Expected_Text = "All Small Mentor Protégé Program Program Self-Certification Summary";
		assertEquals(Actual_Text, Expected_Text);
		// 8(a) question verify.
		// Click on change your answer and verify.
		// ====>>>open when the upload java scrit error is resolved.
		// webDriver.findElement(By.linkText("Change answer")).click();
		// Actual_Text =
		// webDriver.findElement(By.cssSelector("#currently_attached >
		// h4")).getText();
		// Expected_Text = "Documents previously added";
		// assertEquals(Actual_Text, Expected_Text);
		// CoreUtils.clickContinue(webDriver);
		// Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
		// Expected_Text = "Business Info";
		// assertEquals(Actual_Text, Expected_Text);
		// CoreUtils.clickContinue(webDriver);
		// Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
		// Expected_Text = "Review";
		// assertEquals(Actual_Text, Expected_Text);
		CoreUtils.clickContinue(webDriver);
		// logger.info(webDriver.switchTo().alert().getText());
		// webDriver.switchTo().alert().accept();
		// Verify first paragraph
		logger.info("  Verify first paragraph");
		// Verify Second paragraph
		logger.info("  Verify second paragraph");
		if (webDriver.getCurrentUrl().contains("qa.sba-one")) {
			MppSignaturePage mppSignature = new MppSignaturePage(webDriver);
			mppSignature.MppSignature();
			webDriver.findElement(By.xpath("//a/span")).click();
			WebElement ActiveCert = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[5]"));
			HighLight.highLightElement(webDriver, ActiveCert);
			webDriver.findElement(By.id("profileid")).click();
			webDriver.findElement(By.linkText("Logout")).click();
		} else {
			MppSignaturePage mppSignature = new MppSignaturePage(webDriver);
			mppSignature.MppSignature();
			webDriver.findElement(By.xpath("//a/span")).click();
			WebElement ActiveCert = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[5]"));
			HighLight.highLightElement(webDriver, ActiveCert);
			webDriver.findElement(By.id("profileid")).click();
			webDriver.findElement(By.linkText("Logout")).click();
		}
		// Login as MPP-analyst and return MPP back to vendor.
		get_The_Row_From_Login_Data = 29;
		LoginPageWithReference login_Data61 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data61.Login_With_Reference();
		// webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
		webDriver.findElement(By.id("query")).sendKeys(DunsNumber);
		webDriver.findElement(By.xpath("//form/div/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4/a")));
		webDriver.findElement(By.xpath("//h4/a")).click();
		if (webDriver.getPageSource().contains("Return to Vendor")) {
			webDriver.findElement(By.linkText("Return to Vendor")).click();
			// webDriver.switchTo().alert().accept();
			webDriver.findElement(By.id("profileid")).click();
			webDriver.findElement(By.linkText("Logout")).click();
		} else {
			logger.info("Return to Vendor Link is missing please verify why.");
			webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
			webDriver.findElement(By.id("submit_button")).click();
			webDriver.findElement(By.linkText("Determination")).click();
			webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
			webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
			webDriver.findElement(By.linkText("Vendor Overview")).click();
			webDriver.findElement(By.id("profileid")).click();
			webDriver.findElement(By.linkText("Logout")).click();
		}
		// } catch (Exception e) {
		// ScreenShotPage screenShot = new ScreenShotPage(webDriver);
		// screenShot.ScreenShot();
		// ogger.info(e.getMessage());
		// Assert.fail();
		// }

		logger.info("Success");
	}

	@After
	public void tearDown() throws Exception {
		webDriver.close();
	}
}
