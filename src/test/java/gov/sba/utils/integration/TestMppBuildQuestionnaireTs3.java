// @Montana
package gov.sba.utils.integration;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.CoreUtils;
import gov.sba.automation.FixtureUtils;
import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

public class TestMppBuildQuestionnaireTs3 extends TestCase {
	private static final Logger logger = LogManager.getLogger(TestMppBuildQuestionnaireTs3.class.getName());
	private static WebDriver webDriver;
	int get_The_Row_From_Login_Data;
	String DunsNumber;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();

		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 20;
	}

	@Test
	public void testMppBuildQuestionnaireTs3() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 30);
			String Actual_Text;
			String Expected_Text;
			// Login to dashboard.
			JavascriptExecutor jse = (JavascriptExecutor) webDriver;
			logger.info("Mpp question test Scenario 3 possitive + skip Logic");
			LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data.Login_With_Reference();
			// Get the vendor Duns Number.
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//p[2]/span"), false));
			DunsNumber = webDriver.findElement(By.xpath("//p[2]/span")).getText();
			logger.info("The Duns number for this business is " + DunsNumber);
			// Verify if there is an existing program on the dashboard and
			// TestWorkFlowxx8aInProgress to start a new certification.
			DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
			deleteDraftCert.DeleteDraftCert();
			DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
			deleteDraftCert1.DeleteDraftCert();
			// Verify for active and Draft certification on the dashboard, if
			// draft
			// delete and start a new one, if active or pending, Return it.
			ReturnActiveCert4Page returnActiveCert = new ReturnActiveCert4Page(webDriver);
			returnActiveCert.ReturnActiveCert4();
			ReturnActiveCert4Page returnActiveCert1 = new ReturnActiveCert4Page(webDriver);
			returnActiveCert1.ReturnActiveCert4();
			ReturnPendingCert4Page ReturnPendingCert4 = new ReturnPendingCert4Page(webDriver);
			ReturnPendingCert4.ReturnPendingCert4();
			ReturnPendingCert4Page ReturnPendingCert41 = new ReturnPendingCert4Page(webDriver);
			ReturnPendingCert41.ReturnPendingCert4();
			// Verify if there is an existing certification on the dashboard and
			// TestWorkFlowxx8aInProgress to start a new certification.
			DeleteDraftCertPage deleteDraftCert11 = new DeleteDraftCertPage(webDriver);
			deleteDraftCert11.DeleteDraftCert();
			// Delete second draft if any.
			DeleteDraftCertPage deleteDraftCert111 = new DeleteDraftCertPage(webDriver);
			deleteDraftCert111.DeleteDraftCert();
			// Delete second draft if any.
			DeleteDraftCertPage deleteDraftCert1111 = new DeleteDraftCertPage(webDriver);
			deleteDraftCert1111.DeleteDraftCert();
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
			// Select No and commit.
			webDriver.findElement(By.id("answers_117_value_no")).click();
			CoreUtils.clickContinue(webDriver);
			// Eligibility Section, Verifying Question.
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "Are you either a for-profit business or an agricultural cooperative?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mentor_for_profit > fieldset > h4")).getText();
			Expected_Text = "Is your Mentor a for-profit business?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_prior_sba_mpp_determination > fieldset > h4"))
					.getText();
			Expected_Text = "Has the SBA ever made a determination of affiliation between you and the Mentor?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver
					.findElement(By.cssSelector("#answers_mentor_over_40_percent_protege > fieldset > h4")).getText();
			Expected_Text = "Does the Mentor own or plan to own more than 40 percent equity interest in your firm?";
			assertEquals(Actual_Text, Expected_Text);
			// Verify detail meaning for questions.
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_for_profit_or_ag_coop']/fieldset/p[2]"))
					.getText();
			Expected_Text = "Except for small agricultural cooperatives, only business entities organized for-profit are eligible for small business assistance from the SBA.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mentor_for_profit']/fieldset/p[2]"))
					.getText();
			Expected_Text = "A mentor is defined as “a for-profit business concern of any size.”";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver
					.findElement(By.xpath("//div[@id='answers_mentor_over_40_percent_protege']/fieldset/p[2]"))
					.getText();
			Expected_Text = "To raise capital for the Protégé firm the Mentor may generally own an equity interest of up to 40% in the Protégé firm. Reference: 13 CFR 124.520(d)(2)";
			assertEquals(Actual_Text, Expected_Text);
			// Click on the continue button without answering the question and
			// verify error message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.id("answers[118][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.id("answers[119][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.id("answers[120][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.id("answers[121][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Select yes for the first two questions.
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_118_value_yes")));
			webDriver.findElement(By.id("answers_118_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_119_value_yes")));
			webDriver.findElement(By.id("answers_119_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_120_value_no")));
			webDriver.findElement(By.id("answers_120_value_no")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_121_value_no")));
			webDriver.findElement(By.id("answers_121_value_no")).click();
			CoreUtils.clickContinue(webDriver);
			// NAICS Code Section, Verifying Question.
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "Please select the NAICS code for which you are creating a mentor-protégé relationship:";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_prior_naics_code_work > fieldset > h4"))
					.getText();
			Expected_Text = "Have you performed work in the NAICS code in which you’re requesting business development assistance?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_small_for_mpp_naics_code > fieldset > h4"))
					.getText();
			Expected_Text = "Are you considered small for the NAICS code in which you’re requesting business development assistance?";
			assertEquals(Actual_Text, Expected_Text);
			// Verifying detail meaning for questions.
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_naics_code']/fieldset/p[2]"))
					.getText();
			Expected_Text = "A Mentor-Protégé Agreement must be in a NAICS code that is identified in SAM.gov as a protégé’s primary or secondary code.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_naics_code']/fieldset/p[3]"))
					.getText();
			Expected_Text = "The NAICS codes listed above are the primary or secondary codes associated with your business in SAM.gov. You may update your SAM.gov profile to include an additional NAICS code if the correct NAICS is not listed. If you add a code to your SAM.gov profile, please wait 24 hours for us to receive the update and then return to continue your application.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_prior_naics_code_work']/fieldset/p[2]"))
					.getText();
			Expected_Text = "You must have prior experience in the NAICS code in the NAICS code in which you’re seeking assistance.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_small_for_mpp_naics_code']/fieldset/p[2]"))
					.getText();
			Expected_Text = "To qualify as a protégé firm, your business must qualify as small for the NAICS code for which it is seeking business development assistance. Size standards have been established for types of economic activity, or industry, under the North American Industry Classification System (NAICS). To determine the size standard associated with a particular NAICS code, refer to the table of size standards in the Small Business Size Regulations. Reference: 13 CFR 121.201";
			assertEquals(Actual_Text, Expected_Text);
			// Click on the continue button without answering the question and
			// verify error message.
			CoreUtils.clickContinue(webDriver);
			// Select A NAICS code from t he drop down.
			WebElement mySelect = webDriver.findElement(By.xpath("//*[@id='answers_122_value']"));
			Select dropdown = new Select(mySelect);
			dropdown.selectByIndex(1);
			Actual_Text = webDriver.findElement(By.id("answers[123][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.id("answers[124][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Select yes for the first two questions.
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_123_value_yes")));
			webDriver.findElement(By.id("answers_123_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_124_value_yes")));
			webDriver.findElement(By.id("answers_124_value_yes")).click();
			CoreUtils.clickContinue(webDriver);
			// Size Determination Section(Sub-Subsection 1.1), Verifying
			// Question.
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_size_determination']/fieldset/h4"))
					.getText();
			Expected_Text = "Have you ever received a size determination letter from the SBA that found you to be “other than small” in the NAICS code in which you’re requesting business development assistance?";
			assertEquals(Actual_Text, Expected_Text);
			// Click on the continue button without answering the question and
			// verify error message.
			// webDriver.findElement(By.xpath("//input[@name='commit']")).click();
			// Actual_Text =
			// webDriver.findElement(By.id("answers[125][value]-error")).getText();
			// Expected_Text = "Please answer this question";
			// assertEquals(Actual_Text, Expected_Text);
			// Select yes for the first two questions.
			webDriver.findElement(By.id("answers_125_value_no")).click();
			CoreUtils.clickContinue(webDriver);
			// Verify the Size Redetermination Section(Sub-Subsection 1.2) is
			// disabled , Verifying Question.
			// Training Section(Subsection 2.1), Verifying Question.
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_completion_cert']/fieldset/h4"))
					.getText();
			Expected_Text = "Please view the Mentor-Protégé Program training module and upload the certificate of completion.";
			assertEquals(Actual_Text, Expected_Text);
			// Upload a document.
			String file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
			MontanaUploadDocumentPage MontanaUploadDocument = new MontanaUploadDocumentPage(webDriver);
			MontanaUploadDocument.MontanaUploadDocument(file_path_abs);
			Actions act1 = new Actions(webDriver);
			act1.doubleClick(webDriver.findElement(By.xpath("//input[@name='commit']"))).build().perform();
			// Plan and Agreements
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("h2"), false));
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Plans and Agreements";
			assertEquals(Actual_Text, Expected_Text);
			// Click on the continue button without answering the question and
			// verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.id("answers_131_attachment-error")).getText();
			Expected_Text = "Attachment is required";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.id("answers[132][value]-error")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Upload a document.
			file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
			MontanaUploadDocumentPage MontanaUploadDocument1 = new MontanaUploadDocumentPage(webDriver);
			MontanaUploadDocument1.MontanaUploadDocument(file_path_abs);
			// Select yes for the Second questions.
			webDriver.findElement(By.id("answers_132_value_no")).click();
			Actions act3 = new Actions(webDriver);
			act3.doubleClick(webDriver.findElement(By.xpath("//input[@name='commit']"))).build().perform();
			// verify Active Agreements Section Disabled.
			// MPP Agreement Section.
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "Please upload the written Mentor-Protégé Agreement signed and dated by both the Mentor and the Protégé.";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.id("answers_135_attachment-error")).getText();
			Expected_Text = "Attachment is required";
			assertEquals(Actual_Text, Expected_Text);
			// Upload a document.
			file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
			MontanaUploadDocumentPage MontanaUploadDocument2 = new MontanaUploadDocumentPage(webDriver);
			MontanaUploadDocument2.MontanaUploadDocument(file_path_abs);
			Actions act31 = new Actions(webDriver);
			act31.doubleClick(webDriver.findElement(By.xpath("//input[@name='commit']"))).build().perform();
			// Protégé Needs Section.
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("article.usa-width-two-thirds > p"),
					false));
			Actual_Text = webDriver.findElement(By.cssSelector("article.usa-width-two-thirds > p")).getText();
			Expected_Text = "In this subsection you’ll be asked to identify the type(s) of assistance you’re seeking from your Mentor. There are six categories to choose from, and you may select any or all that apply to your situation.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//article[@id='main-content']/section/article/p[2]"))
					.getText();
			Expected_Text = "Based on your selection(s), you will then be asked to specify: 1) what are your needs within the selected area; 2) what activities the Mentor is going to do to support each of your needs; 3) the timeline for meeting each of your needs; and 4) how you will measure whether each of your needs have been successfully met.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "Will the Mentor be providing the Protégé with “Management and Technical” assistance?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mpp_providing_financial > fieldset > h4"))
					.getText();
			Expected_Text = "Will the Mentor be providing the Protégé with “Financial” assistance?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mpp_providing_contracting > fieldset > h4"))
					.getText();
			Expected_Text = "Will the Mentor be providing the Protégé with “Contracting” assistance?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mpp_providing_trade_ed > fieldset > h4"))
					.getText();
			Expected_Text = "Will the Mentor be providing the Protégé with “International Trade Education” assistance?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mpp_providing_biz_dev > fieldset > h4"))
					.getText();
			Expected_Text = "Will the Mentor be providing the Protégé with “Business Development” assistance?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mpp_providing_gen_admin > fieldset > h4"))
					.getText();
			Expected_Text = "Will the Mentor be providing the Protégé with “General and/or Administrative” assistance?";
			assertEquals(Actual_Text, Expected_Text);
			// Details.
			Actual_Text = webDriver
					.findElement(By.xpath("//div[@id='answers_mpp_providing_mgmt_and_tech']/fieldset/p[2]")).getText();
			Expected_Text = "This type of assistance might include help with internal business processes and management systems. Reference: 13 CFR 124.520 a) and e)";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_providing_financial']/fieldset/p[2]"))
					.getText();
			Expected_Text = "This type of assistance might take the form of equity investments or loans. Reference: 13 CFR 124.520 a) and e)";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver
					.findElement(By.xpath("//div[@id='answers_mpp_providing_contracting']/fieldset/p[2]")).getText();
			Expected_Text = "This type of assistance might include navigating the contracting process, understanding your obligations as a government contractor, or developing your capability to compete for government contracts. Reference: 13 CFR 124.520 a) and e)";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_providing_trade_ed']/fieldset/p[2]"))
					.getText();
			Expected_Text = "This type of assistance might include learning how to export, developing an international business plan, or identifying which international markets are right for your business. Reference: 13 CFR 124.520 a) and e)";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_providing_biz_dev']/fieldset/p[2]"))
					.getText();
			Expected_Text = "This type of assistance might include help with strategic planning, identifying potential new markets for your business, or finding new contracting and partnership opportunities. Reference: 13 CFR 124.520 a) and e)";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_providing_gen_admin']/fieldset/p[2]"))
					.getText();
			Expected_Text = "This type of assistance might include help with general business processes, or other administrative support. Reference: 13 CFR 124.520 a) and e)";
			assertEquals(Actual_Text, Expected_Text);
			// Verify all reference links 1.
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window3111 = webDriver.getWindowHandle();
			logger.info("Before switching, title is = certify.sba.gov");
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("13 CFR 124.520 a) and e)")));
			webDriver.findElement(By.linkText("13 CFR 124.520 a) and e)")).click();
			assertEquals(Actual_Text, Expected_Text);
			java.util.Set<String> S3111 = webDriver.getWindowHandles();
			Iterator<String> i3111 = S3111.iterator();
			while (i3111.hasNext()) {
				String Second_window1 = i3111.next();
				if (!main_window3111.equalsIgnoreCase(Second_window1)) {
					webDriver.switchTo().window(Second_window1);
					logger.info("After switching title is =" + webDriver.getTitle());
					webDriver.close();
					webDriver.switchTo().window(main_window3111);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}
			// Link 2.
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window31111 = webDriver.getWindowHandle();
			logger.info("Before switching, title is = certify.sba.gov");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[2]")));
			webDriver.findElement(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[2]")).click();
			assertEquals(Actual_Text, Expected_Text);
			java.util.Set<String> S31111 = webDriver.getWindowHandles();
			Iterator<String> i31111 = S31111.iterator();
			while (i31111.hasNext()) {
				String Second_window1 = i31111.next();
				if (!main_window31111.equalsIgnoreCase(Second_window1)) {
					webDriver.switchTo().window(Second_window1);
					logger.info("After switching title is =" + webDriver.getTitle());
					webDriver.close();
					webDriver.switchTo().window(main_window31111);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}
			// Link 3.
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window4 = webDriver.getWindowHandle();
			logger.info("Before switching, title is = certify.sba.gov");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[3]")));
			webDriver.findElement(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[3]")).click();
			assertEquals(Actual_Text, Expected_Text);
			java.util.Set<String> S4 = webDriver.getWindowHandles();
			Iterator<String> i4 = S4.iterator();
			while (i4.hasNext()) {
				String Second_window1 = i4.next();
				if (!main_window4.equalsIgnoreCase(Second_window1)) {
					webDriver.switchTo().window(Second_window1);
					logger.info("After switching title is =" + webDriver.getTitle());
					webDriver.close();
					webDriver.switchTo().window(main_window4);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}
			// link 4.
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window41 = webDriver.getWindowHandle();
			logger.info("Before switching, title is = certify.sba.gov");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[4]")));
			webDriver.findElement(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[4]")).click();
			assertEquals(Actual_Text, Expected_Text);
			java.util.Set<String> S41 = webDriver.getWindowHandles();
			Iterator<String> i41 = S41.iterator();
			while (i41.hasNext()) {
				String Second_window1 = i41.next();
				if (!main_window41.equalsIgnoreCase(Second_window1)) {
					webDriver.switchTo().window(Second_window1);
					logger.info("After switching title is =" + webDriver.getTitle());
					webDriver.close();
					webDriver.switchTo().window(main_window41);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}
			// Link 5.
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window5 = webDriver.getWindowHandle();
			logger.info("Before switching, title is = certify.sba.gov");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[5]")));
			webDriver.findElement(By.xpath("(//a[contains(text(),'13 CFR 124.520 a) and e)')])[5]")).click();
			assertEquals(Actual_Text, Expected_Text);
			java.util.Set<String> S5 = webDriver.getWindowHandles();
			Iterator<String> i5 = S5.iterator();
			while (i5.hasNext()) {
				String Second_window1 = i5.next();
				if (!main_window5.equalsIgnoreCase(Second_window1)) {
					webDriver.switchTo().window(Second_window1);
					logger.info("After switching title is =" + webDriver.getTitle());
					webDriver.close();
					webDriver.switchTo().window(main_window5);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}
			// **** Select Yes for all question in this section.
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_136_value_yes")));
			webDriver.findElement(By.id("answers_136_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_137_value_yes")));
			webDriver.findElement(By.id("answers_137_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_138_value_yes")));
			webDriver.findElement(By.id("answers_138_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_139_value_yes")));
			webDriver.findElement(By.id("answers_139_value_yes")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("answers_140_value_yes")));
			webDriver.findElement(By.id("answers_140_value_yes")).click();
			Actions act6 = new Actions(webDriver);
			act6.doubleClick(webDriver.findElement(By.id("answers_141_value_yes"))).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='commit']")));
			Actions act4 = new Actions(webDriver);
			act4.doubleClick(webDriver.findElement(By.xpath("//input[@name='commit']"))).build().perform(); // Management/Technical
			// Needs
			// Section,
			// verifying
			// questions.
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("article.usa-width-two-thirds > p"),
					false));
			Actual_Text = webDriver.findElement(By.cssSelector("article.usa-width-two-thirds > p")).getText();
			Expected_Text = "What are your needs within this area, activities the Mentor will do to support those needs, the timeline for meeting those needs, and the way you will measure whether needs are met? Your answers to these questions are the basis for your Mentor-Protégé relationship and should match what you outline in your Mentor-Protégé Agreement.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "What are your needs within the selected area?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mandt_activities > fieldset > h4")).getText();
			Expected_Text = "What activities is the Mentor going to do to support this need within the Mentor-Protégé relationship?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mandt_timeline > fieldset > h4")).getText();
			Expected_Text = "What are the details of the timeline for accomplishing this need within the Mentor-Protégé relationship?";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("#answers_mandt_success > fieldset > h4")).getText();
			Expected_Text = "How will success be measured for this need within the Mentor-Protégé relationship?";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Enter more than 500 words and verify.
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[2]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[3]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[4]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			CoreUtils.clickContinue(webDriver);
			// Financial Needs Section.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Financial Needs";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Enter more than 500 words and verify.
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[2]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[3]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[4]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			CoreUtils.clickContinue(webDriver);
			// Contracting Needs Section.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Contracting Needs";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Enter more than 500 words and verify.
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[2]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[3]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[4]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			CoreUtils.clickContinue(webDriver);
			// Trade Education Needs Section.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Intl Trade Education Needs";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Enter more than 500 words and verify.
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[2]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[3]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[4]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			CoreUtils.clickContinue(webDriver);
			// Business Development Needs Section.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Business Development Needs";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Enter more than 500 words and verify.
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[2]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[3]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[4]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			CoreUtils.clickContinue(webDriver);
			// General/ Administrative Needs Section.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "General/Administrative Needs";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[3]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[4]/fieldset/div/span")).getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Enter more than 500 words and verify.
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[2]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[3]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			webDriver.findElement(By.xpath("//div[4]/fieldset/div/textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from");
			CoreUtils.clickContinue(webDriver);
			// Section 3/ Training, Verifying question.
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "Please upload the Mentor’s certificate of completion for the Mentor-Protégé Program training module.";
			assertEquals(Actual_Text, Expected_Text);
			// Details.
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mentor_mpp_training_cert']/fieldset/p[2]"))
					.getText();
			Expected_Text = "Both the Protégé and the Mentor must complete the Mentor-Protégé Program training module. The Protégé must upload the Mentor’s certificate of completion.";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.id("answers_166_attachment-error")).getText();
			Expected_Text = "Attachment is required";
			assertEquals(Actual_Text, Expected_Text);
			// Upload a document.
			file_path_abs = FixtureUtils.fixturesDir() + "MainTestUploadDoc.pdf";
			MontanaUploadDocumentPage MontanaUploadDocument3 = new MontanaUploadDocumentPage(webDriver);
			MontanaUploadDocument3.MontanaUploadDocument(file_path_abs);
			CoreUtils.clickContinue(webDriver);
			// Subsection 3.2: Business info, Verifying question.
			Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
			Expected_Text = "Please provide the Mentor’s DUNS number:";
			assertEquals(Actual_Text, Expected_Text);
			// Details.
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_duns']/fieldset/p[2]")).getText();
			Expected_Text = "The Mentor in the Mentor-Protégé Agreement must have an active record on SAM.gov. If the DUNS number provided does not match an active SAM.gov record, the Mentor firm must update SAM.gov. If the DUNS number does not match the Mentor’s firm name, please verify the correct DUNS number has been provided to you.";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_duns']/fieldset/p[3]")).getText();
			Expected_Text = "If the Mentor firm has updated SAM.gov within the last 24 hours, you need to wait 24 hours before the update is reflected here, at which time you may return to the application and proceed.";
			assertEquals(Actual_Text, Expected_Text);
			// Attempt to commit and verify alert message.
			CoreUtils.clickContinue(webDriver);
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_duns']/fieldset/div/div/span"))
					.getText();
			Expected_Text = "Please answer this question";
			assertEquals(Actual_Text, Expected_Text);
			// Go back to the needs section and verify that needs text entered
			// are being saved.
			// Financial needs.
			webDriver.findElement(By.id("management_and_tech")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
			assertEquals(Actual_Text, Expected_Text);
			// management/technical needs.
			webDriver.findElement(By.id("financial")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
			assertEquals(Actual_Text, Expected_Text);
			// Contracting needs.
			webDriver.findElement(By.id("contracting")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
			assertEquals(Actual_Text, Expected_Text);
			// Trade Education needs.
			webDriver.findElement(By.id("trade_education")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
			assertEquals(Actual_Text, Expected_Text);
			// Business Development needs.
			webDriver.findElement(By.id("business_dev")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
			assertEquals(Actual_Text, Expected_Text);
			// General/Administrative needs.
			webDriver.findElement(By.id("general_admin")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from";
			assertEquals(Actual_Text, Expected_Text);
			// click on training to continue.
			webDriver.findElement(By.id("mentor_training")).click();
			CoreUtils.clickContinue(webDriver);
			// General/Administrative needs.
			webDriver.findElement(By.id("general_admin")).click();
			webDriver.findElement(By.xpath("//textarea")).clear();
			webDriver.findElement(By.xpath("//textarea")).sendKeys(
					"Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from all vines in the garden of Eden.");
			CoreUtils.clickContinue(webDriver);
			webDriver.findElement(By.id("general_admin")).click();
			Actual_Text = webDriver.findElement(By.xpath("//textarea")).getText();
			Expected_Text = "Also is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit fromAlso is their earth so. Dry female let doesn't void unto kind. Him two days set green us. Darkness from you'll. Him winged winged fifth man heaven won't it first male saw gathered deep. Abundantly herb it own. Darkness from, created great gathering us called deep abundantly. Divide. So replenish rule together beginning fowl seas light gathering air fill, saw darkness divide doesn't greater fly they're all fly. Shall light from given, place itself for were third. Itself second gathered fruit from all vines in the garden of Eden.";
			assertNotSame(Actual_Text, Expected_Text);
			CoreUtils.clickContinue(webDriver);
			// Training.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Training";
			assertEquals(Actual_Text, Expected_Text);
			CoreUtils.clickContinue(webDriver);
			// Enter an invalid DUNS# and verify message.
			webDriver.findElement(By.xpath("//input[@id='duns-value-167']")).sendKeys(DunsNumber);
			webDriver.findElement(By.xpath("//a[@id='search-duns-167']")).click();
			Actual_Text = webDriver.findElement(By.xpath("//div[@id='answers_mpp_duns']/fieldset/div/div/span"))
					.getText();
			Expected_Text = "You must confirm the DUNS number";
			assertEquals(Actual_Text, Expected_Text);
			webDriver.findElement(By.xpath("//a[@id='search-duns-167']")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			logger.info(webDriver.switchTo().alert().getText());
			webDriver.switchTo().alert().accept();
			CoreUtils.clickContinue(webDriver);
			// Review page.
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Review";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "All Small Mentor Protégé Program Program Self-Certification Summary";
			assertEquals(Actual_Text, Expected_Text);
			CoreUtils.clickContinue(webDriver);
			// logger.info(webDriver.switchTo().alert().getText());
			// webDriver.switchTo().alert().accept();
			// Step - Verify the Signature page for MPP
			logger.info("Step  - Verify the Signature page for MPP");
			// Verify you are on the Signature page
			logger.info("  Verify you are on the Signature page");
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Signature";
			assertEquals(Actual_Text, Expected_Text);
			// Verify title
			logger.info("  Verify title");
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "All Small Mentor Protégé Program Program Self-Certification Summary";
			assertEquals(Actual_Text, Expected_Text);
			// Verify first paragraph
			logger.info("  Verify first paragraph");
			Actual_Text = webDriver.findElement(By.xpath("//label[2]")).getText();
			Expected_Text = "All the statements and information provided in this form and any documents submitted are true, accurate and complete. If assistance was obtained in completing this form and the supporting documentation, I have personally reviewed the information and it is true and accurate. I understand that these statements are made for the purpose of determining eligibility for participation in the All Small MPP.";
			assertEquals(Actual_Text, Expected_Text);
			// Verify third paragraph
			logger.info("  Verify third paragraph");
			Actual_Text = webDriver.findElement(By.xpath("//label[3]")).getText();
			Expected_Text = "I understand that the information submitted may be given to Federal, State and local agencies for determining violations of law and other purposes.";
			assertEquals(Actual_Text, Expected_Text);
			// Verify fourth paragraph
			logger.info("  Verify fourth paragraph");
			Actual_Text = webDriver.findElement(By.xpath("//label[4]")).getText();
			Expected_Text = "I understand that I may not misrepresent my status as a small business to: 1) obtain a contract under the Small Business Act; or 2) obtain any benefit under a provision of Federal law that references the All Small MPP for a definition of program eligibility.";
			assertEquals(Actual_Text, Expected_Text);
			// Verify fifth paragraph
			logger.info("  Verify fifth paragraph");
			// Verify sixth paragraph
			logger.info("  Verify sixth paragraph");
			Actual_Text = webDriver.findElement(By.xpath("//label[6]")).getText();
			Expected_Text = "Warning: By clicking the Submit button, you are certifying that you are representing on your own behalf that the information provided in this application, and any document or supplemental information submitted, is true and correct as of the date set forth opposite your signature. Any intentional or negligent misrepresentation of the information contained in this certification may result in criminal, civil or administrative sanctions including, but not limited to: 1) fines of up to $500,000, and imprisonment of up to 10 years, or both, as set forth in 15 U.S.C. § 645 and 18 U.S.C. § 1001, as well as any other applicable criminal laws; 2) treble damages and civil penalties under the False Claims Act; 3) double damages and civil penalties under the Program Fraud Civil Remedies Act; 4) suspension and/or debarment from all Federal procurement and non-procurement transactions; and 5) program termination.";
			assertEquals(Actual_Text, Expected_Text);
			// Step 9 - Click the Continue button
			logger.info("Step 9 - Click the Continue button");
			webDriver.findElement(By.id("accept-button")).click();
			// Step 10 - Accept the error message
			logger.info(webDriver.switchTo().alert().getText());
			Actual_Text = webDriver.switchTo().alert().getText();
			Expected_Text = "In order to submit your application, you must accept all of the conditions of authorization.";
			assertEquals(Actual_Text, Expected_Text);
			wait.until(ExpectedConditions.alertIsPresent());
			webDriver.switchTo().alert().accept();
			// Step 11 - Accept the statements and click Continue
			logger.info("Step 11 - Click to accept the statements");
			webDriver.findElement(By.id("legal_0")).click();
			webDriver.findElement(By.id("legal_1")).click();
			webDriver.findElement(By.id("legal_2")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("legal_3")));
			webDriver.findElement(By.id("legal_3")).click();
			webDriver.findElement(By.id("legal_4")).click();
			jse.executeScript("arguments[0].scrollIntoView()", webDriver.findElement(By.id("legal_5")));
			webDriver.findElement(By.id("legal_5")).click();
			webDriver.findElement(By.id("accept-button")).click();
			webDriver.findElement(By.xpath("//a/span")).click();
			WebElement ActiveCert = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[5]"));
			HighLight.highLightElement(webDriver, ActiveCert);
			webDriver.findElement(By.linkText("Logout")).click();
			// Login as MPP-analyst and return MPP back to vendor.
			get_The_Row_From_Login_Data = 56;
			LoginPageWithReference login_Data61 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data61.Login_With_Reference();
			// webDriver.findElement(By.xpath("//button[@id='searchtext']")).click();
			webDriver.findElement(By.id("query")).sendKeys(DunsNumber);
			webDriver.findElement(By.xpath("//form/div/button")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4/a")));
			webDriver.findElement(By.xpath("//h4/a")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Return to Vendor")));
			if (webDriver.getPageSource().contains("Return to Vendor")) {
				webDriver.findElement(By.linkText("Return to Vendor")).click();
				// webDriver.switchTo().alert().accept();
				webDriver.findElement(By.id("profileid")).click();
				webDriver.findElement(By.linkText("Logout")).click();
			} else {
				logger.info("Return to Vendor Link is missing please verify why.");
				webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_button")));
				webDriver.findElement(By.id("submit_button")).click();
				webDriver.findElement(By.linkText("Determination")).click();
				webDriver.findElement(By.id("review_workflow_state_returned_for_modification")).click();
				webDriver.findElement(By.xpath("//form[@id='new_determination']/input[5]")).click();
				webDriver.findElement(By.linkText("Vendor Overview")).click();
				webDriver.findElement(By.id("profileid")).click();
				webDriver.findElement(By.linkText("Logout")).click();
			}
		} catch (Exception e) {
			ScreenShotPage screenShot = new ScreenShotPage(webDriver);
			screenShot.ScreenShot();
			logger.info(e.getMessage());
			Assert.fail();
		}

		logger.info("Success");
	}

	@After
	public void tearDown() throws Exception {
		webDriver.close();
	}
}
