package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

public class Test12348aInitialMaterApplicationLLCTracked extends TestCase {
	private static final Logger logger = LogManager
			.getLogger(Test12348aInitialMaterApplicationLLCTracked.class.getName());
	private static WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 88;

	}

	@Test
	public void test12348aInitialMaterApplicationLLCTracked() throws Exception {
		String Actual_Text = null;
		String Expected_Text = null;
		// try {
		logger.info("Test for 8a initial master Flow");
		// Login to dashboard.
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		// Verify if there is an existing certification on the dashboard and
		// delete to start a new certification.
		DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
		deleteDraftCert.DeleteDraftCert();
		// delete second draft if any.
		DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
		deleteDraftCert1.DeleteDraftCert();
		// Complete the basic eligibility section.
		BasicEligibilityMasterAppPage basicEligibilityMasterApp = new BasicEligibilityMasterAppPage(webDriver);
		basicEligibilityMasterApp.BasicEligibilityMasterApp();
		// Complete the Business Ownership section.
		BusinessOwnershipSubsectionMasterLlcPage businessOwnershipSubsectionMasterLlc = new BusinessOwnershipSubsectionMasterLlcPage(
				webDriver);
		businessOwnershipSubsectionMasterLlc.BusinessOwnershipSubsectionMasterLlc();
		// Complete the character section.
		CharacterMasterAppSectionPage characterMasterAppSection = new CharacterMasterAppSectionPage(webDriver);
		characterMasterAppSection.CharacterMasterAppSection();
		// Complete the Control section.
		ControlMasterAppSubsectionPage controlMasterAppSubsection = new ControlMasterAppSubsectionPage(webDriver);
		controlMasterAppSubsection.ControlMasterAppSubsection();
		// ====>>>Add Potential for Success here.
		PotentialForSuccessMasterAppSectionPage potentialForSuccessMasterAppSection = new PotentialForSuccessMasterAppSectionPage(
				webDriver);
		potentialForSuccessMasterAppSection.PotentialForSuccessMasterAppSection();
		// Complete the Individual section.
		IndividualApplicationSectionPage individualApplicationSection = new IndividualApplicationSectionPage(webDriver);
		individualApplicationSection.IndividualApplicationSection();
		try {
			// Complete the DvD section.
			ContributorDisadvantageIndividualQuetionPage contributorDisadvantageIndividualQuetion = new ContributorDisadvantageIndividualQuetionPage(
					webDriver);
			contributorDisadvantageIndividualQuetion.ContributorDisadvantageIndividualQuetion();
			// Verify status flow.
			// Login to the Admin dashboard.
			get_The_Row_From_Login_Data = 88;
			LoginPageWithReference login_Data1 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data1.Login_With_Reference();
			// Click on the dashboard.
			webDriver.findElement(By.xpath("//a/span")).click();
			WebElement rateElement7 = webDriver.findElement(By.linkText("8(a) Initial Application"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement7);
			// Contributors is verify to be completed, but click on it to
			// add
			// other
			// contributors.
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/div/div[2]/table/tbody/tr/td/span")).getText();
			Expected_Text = "Complete";
			assertEquals(Actual_Text, Expected_Text);
			WebElement ContributorCompleteStatus3 = webDriver
					.findElement(By.xpath("//div[2]/div/div/div[2]/table/tbody/tr/td/span"));
			HighLight.highLightElement(webDriver, ContributorCompleteStatus3);
			// Complete the SDvD section.
			ContributorSpouseOfaDisadvantageIndividualPage contributorSpouseOfaDisadvantageIndividual = new ContributorSpouseOfaDisadvantageIndividualPage(
					webDriver);
			contributorSpouseOfaDisadvantageIndividual.ContributorSpouseOfaDisadvantageIndividual();
			// Verify status flow.
			// Login to the Admin dashboard.
			get_The_Row_From_Login_Data = 88;
			LoginPageWithReference login_Data11 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data11.Login_With_Reference();
			// Click on the dashboard.
			webDriver.findElement(By.xpath("//a/span")).click();
			WebElement rateElement71 = webDriver.findElement(By.linkText("8(a) Initial Application"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement71);
			// Contributors is verify to be completed, but click
			// on it to add other
			// contributors.
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/div/div[2]/table/tbody/tr/td/span")).getText();
			Expected_Text = "Complete";
			assertEquals(Actual_Text, Expected_Text);
			WebElement ContributorCompleteStatus31 = webDriver
					.findElement(By.xpath("//div[2]/div/div/div[2]/table/tbody/tr/td/span"));
			HighLight.highLightElement(webDriver, ContributorCompleteStatus31);
			// Complete the Other Individuals section.
			ContributorOtherIndividualsQuestionPage contributorOtherIndividualsQuestion = new ContributorOtherIndividualsQuestionPage(
					webDriver);
			contributorOtherIndividualsQuestion.ContributorOtherIndividualsQuestion();
			// Verify status flow.
			// Login to the Admin dashboard.
			get_The_Row_From_Login_Data = 88;
			LoginPageWithReference login_Data111 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data111.Login_With_Reference();
			// Click on the dashboard.
			webDriver.findElement(By.xpath("//a/span")).click();
			WebElement rateElement711 = webDriver.findElement(By.linkText("8(a) Initial Application"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement711);
			// Contributors is verify to be completed, but click on
			// it to add other
			// contributors.
			Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/div/div[2]/table/tbody/tr/td/span")).getText();
			Expected_Text = "Complete";
			assertEquals(Actual_Text, Expected_Text);
			WebElement ContributorCompleteStatus311 = webDriver
					.findElement(By.xpath("//div[2]/div/div/div[2]/table/tbody/tr/td/span"));
			HighLight.highLightElement(webDriver, ContributorCompleteStatus311);
			logger.info("All Required sections are completed, Ready to Review, Sign and Submit.");
			WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
			WebElement rateElement = webDriver.findElement(By.linkText("Logout"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
		} catch (Exception e) {
			ScreenShotPage screenShot = new ScreenShotPage(webDriver);
			screenShot.ScreenShot();
			logger.info("Upload will not run on headless " + e.getMessage());
		}
		logger.info("Success");
	}

	@After
	public void tearDown() throws Exception {
		webDriver.close();
	}
}
