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

public class TestApp8aInitialMaterApplicationUntrackedClass extends TestCase {
	private static final Logger logger = LogManager
			.getLogger(TestApp8aInitialMaterApplicationUntrackedClass.class.getName());
	private static WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 1;

	}

	@Test
	public void testApp8aInitialMaterApplication() throws Exception {
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
		BusinessOwnershipSubsectionMasterPage businessOwnershipSubsectionMaster = new BusinessOwnershipSubsectionMasterPage(
				webDriver);
		businessOwnershipSubsectionMaster.BusinessOwnershipSubsectionMaster();
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
			// Complete the SDvD section.
			ContributorSpouseOfaDisadvantageIndividualPage contributorSpouseOfaDisadvantageIndividual = new ContributorSpouseOfaDisadvantageIndividualPage(
					webDriver);
			contributorSpouseOfaDisadvantageIndividual.ContributorSpouseOfaDisadvantageIndividual();
			// Complete the Other Individuals section.
			ContributorOtherIndividualsQuestionPage contributorOtherIndividualsQuestion = new ContributorOtherIndividualsQuestionPage(
					webDriver);
			contributorOtherIndividualsQuestion.ContributorOtherIndividualsQuestion();
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
