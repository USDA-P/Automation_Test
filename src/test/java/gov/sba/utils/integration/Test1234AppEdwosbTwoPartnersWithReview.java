// @Montana
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

public class Test1234AppEdwosbTwoPartnersWithReview extends TestCase {
	private static final Logger logger = LogManager.getLogger(Test1234AppEdwosbTwoPartnersWithReview.class.getName());
	private static WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		// webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 8;

	}

	@Test
	public void test1234AppEdwosbTwoPartnersWithReview() throws Exception {
		// try {
		logger.info("Test EDWOSB Sole-Proprietorship two partners on form413 with review");
		// Login to Dashboard.
		// get business Duns.
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		// Verify if there is an existing certification on the dashboard and
		// delete to start a new certification.
		DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
		deleteDraftCert.DeleteDraftCert();
		// Delete second draft if any.
		DeleteDraftCertPage deleteDraftCert11111 = new DeleteDraftCertPage(webDriver);
		deleteDraftCert11111.DeleteDraftCert();
		// Verify if there is an existing Active or draft Application.
		// Start the application.
		AddOrStartCertificationPage addOrStartCertification = new AddOrStartCertificationPage(webDriver);
		addOrStartCertification.AddOrStartCertification();
		// partnership test for 1st person.
		NewSoleProprietorQuestionsPage newSoleProprietorQuestions = new NewSoleProprietorQuestionsPage(webDriver);
		newSoleProprietorQuestions.NewSoleProprietorQuestions();
		// Financial section for first partner.
		FinancialSectionFirstPartnerPage financialSectionFirstPartner = new FinancialSectionFirstPartnerPage(webDriver);
		financialSectionFirstPartner.FinancialSectionFirstPartner();
		// Financial section for Second partner.
		FinancialSectionSecondPartnerPage financialSectionSecondPartner = new FinancialSectionSecondPartnerPage(
				webDriver);
		financialSectionSecondPartner.FinancialSectionSecondPartner();
		// Submit and Return the submitted certification back to vendor.
		SoleProprietorReturnCertFirstAndSecondPartnerAfterReviewPage soleProprietorReturnCertFirstAndSecondPartnerAfterReview = new SoleProprietorReturnCertFirstAndSecondPartnerAfterReviewPage(
				webDriver);
		soleProprietorReturnCertFirstAndSecondPartnerAfterReview
				.SoleProprietorReturnCertFirstAndSecondPartnerAfterReview();
		// Login with the vendor and verify the return draft.
		get_The_Row_From_Login_Data = 8;
		LoginPageWithReference login_Data1 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data1.Login_With_Reference();
		WebElement ReturnDraft = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[5]"));
		HighLight.highLightElement(webDriver, ReturnDraft);
		WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
		webDriver.findElement(By.linkText("Logout")).click();
		// } catch (Exception e) {
		// ScreenShotPage screenShot = new ScreenShotPage(webDriver);
		// screenShot.ScreenShot();
		// logger.info(e.getMessage());
		// Assert.fail();
		// }
		logger.info("Success");

	}

	@After
	public void tearDown() throws Exception {
		webDriver.close();
	}
}
