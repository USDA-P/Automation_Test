package gov.sba.utils;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.TestCase;

public class TestUS1609AnalystViewsListOfAppsVisions extends TestCase {
	private static WebDriver webDriver;
	private static final Logger logger = LogManager.getLogger(TestUS1609AnalystViewsListOfAppsVisions.class.getName());
	int get_The_Row_From_Login_Data;

	@Before
	public void setUp() throws Exception {

		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 17;

	}

	@Test
	public void testMainTest() throws Exception {
		String Actual_Text = null;
		String Expected_Text = null;
		// Login to dashboard.
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		Thread.sleep(3000);
		logger.info("Versioning: MVP 1 - Analyst views a list of revisions to an application");
		// Verify if there is an existing certification on the dashboard and
		// delete to start a new certification.
		DeleteDraftCertPage deleteDraftCert = new DeleteDraftCertPage(webDriver);
		deleteDraftCert.DeleteDraftCert();
		// Verify for active and Draft certification on the dashboard, if draft
		// delete and start a new EDWOSB certification.
		Thread.sleep(4000);
		AddOrStartCertificationPage addOrStartCertification = new AddOrStartCertificationPage(webDriver);
		addOrStartCertification.AddOrStartCertification();

		// Start new 8(a) application.
		EdwobEightAMppTest1Page edwobEightAMppTest1 = new EdwobEightAMppTest1Page(webDriver);
		edwobEightAMppTest1.EdwobEightAMppTest1();
		// Logout and login as an analyst.
		webDriver.findElement(By.linkText("Logout")).click();
		get_The_Row_From_Login_Data = 31;
		LoginPageWithReference login_Data1 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data1.Login_With_Reference();
		// Search for the business with submitted certification.
		webDriver.findElement(By.id("query")).sendKeys("144291293");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		webDriver.findElement(By.linkText("Entity 127 Legal Business Name")).click();
		Thread.sleep(6000);
		// Verify the fist version alert.
		webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
		Thread.sleep(3000);
		Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
		Expected_Text = "New version (v1) created 11/07/2016";
		assertEquals(Actual_Text, Expected_Text);
		WebElement V1 = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
		HighLight.highLightElement(webDriver, V1);
		Thread.sleep(5000);
		WebElement AlertV1 = webDriver.findElement(By.cssSelector("p.usa-alert-text"));
		HighLight.highLightElement(webDriver, AlertV1);
		// Take screenshot and store as a file format
		ScreenShotPage1 screenShot = new ScreenShotPage1(webDriver);
		screenShot.ScreenShot();
		Thread.sleep(4000);
		webDriver.findElement(By.xpath("//a[contains(text(),'Vendor Overview')]")).click();
		// Locate and click on the return to vendor link.
		webDriver.findElement(By.linkText("Return to Vendor")).click();
		webDriver.switchTo().alert().accept();
		Thread.sleep(3000);
		Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
		Expected_Text = "A new application has been reopenned for the vendor";
		assertEquals(Actual_Text, Expected_Text);
		// Logout and login as the vendor with the clone certification and
		// re-submit.
		webDriver.findElement(By.linkText("Logout")).click();

		get_The_Row_From_Login_Data = 17;
		LoginPageWithReference login_Data11 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data11.Login_With_Reference();
		Thread.sleep(3000);
		webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.name("commit")).click();
		Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
		Expected_Text = "Review";
		assertEquals(Actual_Text, Expected_Text);
		webDriver.findElement(By.name("commit")).click();
		webDriver.switchTo().alert().accept();
		logger.info("Step 11 - Click to accept the statements");
		webDriver.findElement(By.id("legal_0")).click();
		webDriver.findElement(By.id("legal_1")).click();
		webDriver.findElement(By.id("legal_2")).click();
		webDriver.findElement(By.id("legal_3")).click();
		webDriver.findElement(By.id("legal_4")).click();
		webDriver.findElement(By.id("legal_5")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.id("accept-button")).click();
		Thread.sleep(3000);
		Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
		Expected_Text = "Your application has been submitted";
		assertEquals(Actual_Text, Expected_Text);
		WebElement RESUBMIT = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[4]"));
		HighLight.highLightElement(webDriver, RESUBMIT);
		// Logout and login as an analyst.
		webDriver.findElement(By.linkText("Logout")).click();
		get_The_Row_From_Login_Data = 31;
		LoginPageWithReference login_Data2 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data2.Login_With_Reference();
		// Search for the business with submitted certification.
		webDriver.findElement(By.id("query")).sendKeys("144291293");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		webDriver.findElement(By.linkText("Entity 127 Legal Business Name")).click();
		Thread.sleep(6000);
		// Verify the fist version alert.
		webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
		Thread.sleep(3000);
		Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
		Expected_Text = "New version (v2) created 11/07/2016";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.linkText("View previous version")).getText();
		Expected_Text = "View previous version";
		assertEquals(Actual_Text, Expected_Text);
		WebElement V2 = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
		HighLight.highLightElement(webDriver, V2);
		Thread.sleep(5000);
		WebElement AlertV2 = webDriver.findElement(By.cssSelector("p.usa-alert-text"));
		HighLight.highLightElement(webDriver, AlertV2);
		Thread.sleep(2000);
		// Take screenshot and store as a file format
		ScreenShotPage screenShot1 = new ScreenShotPage(webDriver);
		screenShot1.ScreenShot();
		// Click to view previous version.
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String main_window = webDriver.getWindowHandle();
		logger.info("Before switching, title is = certify.sba.gov");
		webDriver.findElement(By.linkText("View previous version")).click();
		Thread.sleep(5000);
		assertEquals(Actual_Text, Expected_Text);
		java.util.Set<String> S = webDriver.getWindowHandles();
		Iterator<String> i = S.iterator();
		while (i.hasNext()) {
			String Second_window = i.next();
			if (!main_window.equalsIgnoreCase(Second_window)) {
				webDriver.switchTo().window(Second_window);
				webDriver.manage().window().maximize();
				Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
				Expected_Text = "You are in view-only mode";
				Thread.sleep(5000);
				WebElement NewText = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
				HighLight.highLightElement(webDriver, NewText);
				// Take screenshot and store as a file format
				ScreenShotPage screenShot3 = new ScreenShotPage(webDriver);
				screenShot3.ScreenShot();
				Thread.sleep(3000);
				webDriver.close();
				webDriver.switchTo().window(main_window);
				logger.info("Back to manin_window = certify.sba.gov");
			} else {
				logger.info("Second Window is thesame as first window");

			}

			// Click on the vendor overview link.
			webDriver.findElement(By.xpath("//a[contains(text(),'Vendor Overview')]")).click();
			// Locate and click on the return to vendor link.
			webDriver.findElement(By.linkText("Return to Vendor")).click();
			webDriver.switchTo().alert().accept();
			Thread.sleep(3000);
			Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
			Expected_Text = "A new application has been reopenned for the vendor";
			assertEquals(Actual_Text, Expected_Text);
			// Logout and login as the vendor with the clone certification and
			// re-submit.
			webDriver.findElement(By.linkText("Logout")).click();

			get_The_Row_From_Login_Data = 17;
			LoginPageWithReference login_Data111 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data111.Login_With_Reference();
			Thread.sleep(3000);
			webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
			Thread.sleep(2000);
			webDriver.findElement(By.name("commit")).click();
			Actual_Text = webDriver.findElement(By.cssSelector("h2")).getText();
			Expected_Text = "Review";
			assertEquals(Actual_Text, Expected_Text);
			webDriver.findElement(By.name("commit")).click();
			webDriver.switchTo().alert().accept();
			logger.info("Step 11 - Click to accept the statements");
			webDriver.findElement(By.id("legal_0")).click();
			webDriver.findElement(By.id("legal_1")).click();
			webDriver.findElement(By.id("legal_2")).click();
			webDriver.findElement(By.id("legal_3")).click();
			webDriver.findElement(By.id("legal_4")).click();
			webDriver.findElement(By.id("legal_5")).click();
			Thread.sleep(2000);
			webDriver.findElement(By.id("accept-button")).click();
			Thread.sleep(3000);
			Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
			Expected_Text = "Your application has been submitted";
			assertEquals(Actual_Text, Expected_Text);
			WebElement RESUBMIT3 = webDriver.findElement(By.xpath("//table[@id='certifications']/tbody/tr/td[4]"));
			HighLight.highLightElement(webDriver, RESUBMIT3);
			// Logout and login as an analyst.
			webDriver.findElement(By.linkText("Logout")).click();
			get_The_Row_From_Login_Data = 31;
			LoginPageWithReference login_Data21 = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data21.Login_With_Reference();
			// Search for the business with submitted certification.
			webDriver.findElement(By.id("query")).sendKeys("144291293");
			webDriver.findElement(By.xpath("//button[@type='submit']")).click();
			webDriver.findElement(By.linkText("Entity 127 Legal Business Name")).click();
			Thread.sleep(6000);
			// Verify the 2nd version alert.
			webDriver.findElement(By.linkText("EDWOSB Self-Certification")).click();
			Thread.sleep(3000);
			Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
			Expected_Text = "New version (v3) created 11/07/2016";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver.findElement(By.linkText("View previous version")).getText();
			Expected_Text = "View previous version";
			assertEquals(Actual_Text, Expected_Text);
			WebElement V3 = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
			HighLight.highLightElement(webDriver, V3);
			Thread.sleep(5000);
			WebElement AlertV3 = webDriver.findElement(By.cssSelector("p.usa-alert-text"));
			HighLight.highLightElement(webDriver, AlertV3);
			Thread.sleep(2000);
			// Take screenshot and store as a file format
			ScreenShotPage screenShot11 = new ScreenShotPage(webDriver);
			screenShot11.ScreenShot();
			// Click to view previous version.
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window2 = webDriver.getWindowHandle();
			logger.info("Before switching, title is = certify.sba.gov");
			webDriver.findElement(By.linkText("View previous version")).click();
			assertEquals(Actual_Text, Expected_Text);
			java.util.Set<String> S2 = webDriver.getWindowHandles();
			Iterator<String> i2 = S2.iterator();
			while (i2.hasNext()) {
				String Second_window1 = i2.next();
				if (!main_window2.equalsIgnoreCase(Second_window1)) {
					webDriver.switchTo().window(Second_window1);
					logger.info("After switching title is =" + webDriver.getTitle());
					Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
					Expected_Text = "You are in view-only mode";
					Thread.sleep(5000);
					WebElement NewText = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
					HighLight.highLightElement(webDriver, NewText);
					// Take screenshot and store as a file format
					ScreenShotPage screenShot3 = new ScreenShotPage(webDriver);
					screenShot3.ScreenShot();
					Thread.sleep(3000);
					webDriver.close();
					webDriver.switchTo().window(main_window2);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}

			Thread.sleep(3000);
			// Locate, verify and click on the Revision history link.
			Actual_Text = webDriver.findElement(By.linkText("Revision history")).getText();
			Expected_Text = "Revision history";
			assertEquals(Actual_Text, Expected_Text);
			webDriver.findElement(By.linkText("Revision history")).click();
			// Verify page.
			Thread.sleep(7000);
			Actual_Text = webDriver.findElement(By.cssSelector("h1")).getText();
			Expected_Text = "Revision History";
			assertEquals(Actual_Text, Expected_Text);
			// Take screenshot and store as a file format
			Thread.sleep(4000);
			ScreenShotPage3 screenShot3 = new ScreenShotPage3(webDriver);
			screenShot3.ScreenShot3();
			// Verify versions1.
			Actual_Text = webDriver.findElement(By.linkText("Version 1")).getText();
			Expected_Text = "Version 1";
			assertEquals(Actual_Text, Expected_Text);
			logger.info("Before switching, title is = certify.sba.gov");
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window0 = webDriver.getWindowHandle();
			logger.info("Before switching, title is =" + webDriver.getTitle());
			webDriver.findElement(By.linkText("Version 1")).click();
			java.util.Set<String> S0 = webDriver.getWindowHandles();
			Iterator<String> i0 = S0.iterator();
			while (i0.hasNext()) {
				String Second_window0 = i0.next();
				if (!main_window0.equalsIgnoreCase(Second_window0)) {
					webDriver.switchTo().window(Second_window0);
					Thread.sleep(1000);
					logger.info("After switching title is =" + webDriver.getTitle());
					Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
					Expected_Text = "You are in view-only mode (Version #1)";
					Thread.sleep(5000);
					WebElement ReadOnly = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
					HighLight.highLightElement(webDriver, ReadOnly);
					webDriver.close();
					webDriver.switchTo().window(main_window0);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}

			Thread.sleep(3000);
			// Verify versions2.
			logger.info("Before switching, title is = certify.sba.gov");
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String main_window01 = webDriver.getWindowHandle();
			logger.info("Before switching, title is =" + webDriver.getTitle());
			webDriver.findElement(By.linkText("Version 2")).click();
			java.util.Set<String> S01 = webDriver.getWindowHandles();
			Iterator<String> i01 = S01.iterator();
			while (i01.hasNext()) {
				String Second_window0 = i01.next();
				if (!main_window01.equalsIgnoreCase(Second_window0)) {
					webDriver.switchTo().window(Second_window0);
					Thread.sleep(1000);
					logger.info("After switching title is =" + webDriver.getTitle());
					Actual_Text = webDriver.findElement(By.cssSelector("h3.usa-alert-heading")).getText();
					Expected_Text = "You are in view-only mode";
					Thread.sleep(5000);
					WebElement ReadOnly1 = webDriver.findElement(By.cssSelector("h3.usa-alert-heading"));
					HighLight.highLightElement(webDriver, ReadOnly1);
					Thread.sleep(3000);
					webDriver.close();
					webDriver.switchTo().window(main_window01);
					logger.info("Back to manin_window = certify.sba.gov");
				} else {
					logger.info("Second Window is not thesame as first window");
				}
			}

			// Verify versions3.
			Actual_Text = webDriver.findElement(By.cssSelector("td")).getText();
			Expected_Text = "Version 3";
			assertEquals(Actual_Text, Expected_Text);
			Actual_Text = webDriver
					.findElement(By.xpath("//article[@id='main-content']/div[2]/div[2]/table/tbody/tr/td[2]"))
					.getText();
			Expected_Text = "Submitted";
			assertEquals(Actual_Text, Expected_Text);
			Thread.sleep(4000);
			WebElement Version3 = webDriver.findElement(By.cssSelector("td"));
			HighLight.highLightElement(webDriver, Version3);
			WebElement ApplicationStatus = webDriver
					.findElement(By.xpath("//article[@id='main-content']/div[2]/div[2]/table/tbody/tr/td[2]"));
			HighLight.highLightElement(webDriver, ApplicationStatus);
			// Click on the vendor overview link.
			webDriver.findElement(By.xpath("//a[contains(text(),'Vendor Overview')]")).click();
			// Locate and click on the return to vendor link.
			webDriver.findElement(By.linkText("Return to Vendor")).click();
			webDriver.switchTo().alert().accept();
			Thread.sleep(3000);
			Actual_Text = webDriver.findElement(By.cssSelector("p.usa-alert-text")).getText();
			Expected_Text = "A new application has been reopenned for the vendor";
			assertEquals(Actual_Text, Expected_Text);

			webDriver.findElement(By.linkText("Logout")).click();
			return;

		}

	}

	@After
	public void tearDown() throws Exception {
		webDriver.quit();
	}
}
