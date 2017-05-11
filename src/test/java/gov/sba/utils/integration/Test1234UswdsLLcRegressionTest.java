package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;

public class Test1234UswdsLLcRegressionTest extends TestCase {
	private static final Logger logger = LogManager.getLogger(Test1234UswdsLLcRegressionTest.class.getName());
	private static WebDriver webDriver;
	int get_The_Row_From_Login_Data;

	@Before
	public void setUp() throws Exception {
		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 5;
	}

	@Test
	public void testMainTest() throws Exception {
		logger.info("Test EDWOSB llc Flow");
		// Login to dashboard.
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		Thread.sleep(3000);
		// Verify if there is an existing certification on the dashboard and
		// delete to start a new certification.
		DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
		deleteDraftCert.DeleteDraftCert();
		// delete second draft if any.
		DeleteDraftCertPage deleteDraftCert1 = new DeleteDraftCertPage(webDriver);
		deleteDraftCert1.DeleteDraftCert();
		// Verify for active and Draft certification on the dashboard, if draft
		// delete and start a new one.
		Thread.sleep(2000);
		AddOrStartCertificationPage addOrStartCertification = new AddOrStartCertificationPage(webDriver);
		addOrStartCertification.AddOrStartCertification();
		Thread.sleep(2000);
		// LLc test questions section.
		NewLlcquestionsPage newLlcquestions = new NewLlcquestionsPage(webDriver);
		newLlcquestions.NewLlcquestions();
		// Financial section.
		FinancialSectionPage financialsection = new FinancialSectionPage(webDriver);
		financialsection.Financialsection();
		// Submit and Return the submitted certification back to vendor.
		LLcReturnCertPage lLcReturnCert = new LLcReturnCertPage(webDriver);
		lLcReturnCert.LLcReturnCert();
		// Login with the vendor and verify the return draft.
		get_The_Row_From_Login_Data = 5;
		LoginPageWithReference login_Data1 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data1.Login_With_Reference();
		WebElement ReturnDraft = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[5]"));
		HighLight.highLightElement(webDriver, ReturnDraft);
		webDriver.findElement(By.linkText("Logout")).click();
		logger.info("Success");
	}

	@After
	public void tearDown() throws Exception {
		webDriver.close();
	}
}
