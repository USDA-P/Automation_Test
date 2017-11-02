package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.TestCase;

public class ContributorOtherIndividualsQuestionPage extends TestCase {
	private static final Logger logger = LogManager.getLogger(ContributorOtherIndividualsQuestionPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;
	String SDvDFN;
	String SDvDEmail1;
	String SDvDEmail2;
	String SDvDEmail3;
	String SDvDEmail4;

	public ContributorOtherIndividualsQuestionPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		SDvDFN = "Contributor1 SDVD";
		SDvDEmail1 = "norole22@mailinator.com";
		SDvDEmail1 = "norole12@mailinator.com";
		SDvDEmail1 = "norole13@mailinator.com";
		SDvDEmail1 = "akanamontana@gmail.com";

	}

	public void ContributorOtherIndividualsQuestion() throws Exception {
		// try {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		logger.info("Other Individuals section");
		logger.info("Completing spouse of a Disadvantaged Individual Sub-questionnaire");
		String Actual_Text = null;
		String Expected_Text = null;
		Actual_Text = webDriver.findElement(By.linkText("Individual Contributors")).getText();
		Expected_Text = "Individual Contributors";
		assertEquals(Actual_Text, Expected_Text);
		Actual_Text = webDriver.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"))
				.getText();
		Expected_Text = "Complete";
		assertEquals(Actual_Text, Expected_Text);
		WebElement ContributorCompleteStatus = webDriver
				.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, ContributorCompleteStatus);
		// Click on the link to start eligibility check.
		WebElement rateElement = webDriver.findElement(By.linkText("Individual Contributors"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.linkText("Add other individuals"), false));
		Actual_Text = webDriver.findElement(By.linkText("Add other individuals")).getText();
		Expected_Text = "Add other individuals";
		assertEquals(Actual_Text, Expected_Text);
		// Click on the Add a spouse of a Disadvantaged Individual link and
		// invite this contributor.
		WebElement rateElement1 = webDriver.findElement(By.linkText("Add other individuals"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[3]/fieldset/ul/li/label")));
		// Validate the send invitation button is present and to make sure users
		// can't send empty data
		// as request// open when de fix.
		// try {
		// assertTrue(isElementPresent(By.name("commit")));
		// CoreUtils.clickContinue(webDriver);
		// Actual_Text = webDriver.findElement(By.xpath("enter when error is
		// fixed")).getText();
		// Expected_Text = "Please enter full name and email.";
		// assertEquals(Actual_Text, Expected_Text);
		// logger.info("Sending invite to SDVD");
		// } catch (Error e) {
		// logger.info(e.getMessage());
		// }
		// Try to send an invalid email(Email that is already associated to a
		// business.
		// try {
		// webDriver.findElement(By.xpath("//form[2]/fieldset/ul/li/input")).sendKeys("Contributor1
		// SDVD");
		// webDriver.findElement(By.xpath("//form[2]/fieldset/ul/li[2]/input")).sendKeys("norole22@mailinator.com");
		// CoreUtils.clickContinue(webDriver);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
		// Actual_Text =
		// webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
		// Expected_Text = "Contributor1 SDVD has been added";
		// assertEquals(Actual_Text, Expected_Text);
		// logger.info("Invite was sent to SDVD");
		// } catch (Error e) {
		// logger.info(e.getMessage());
		// }
		try {
			// Enter Full Name of contributor.
			webDriver.findElement(By.xpath("//form[3]/fieldset/ul/li/input")).sendKeys("Contributor3 OtherIndividuals");
			// Enter contributor's email.
			webDriver.findElement(By.xpath("//form[3]/fieldset/ul/li[2]/input")).sendKeys("norole13@mailinator.com");
			// Click on the Send invitation to collaborator button.
			jse.executeScript("arguments[0].scrollIntoView()",
					webDriver.findElement(By.xpath("//form[3]/fieldset/input")));
			webDriver.findElement(By.xpath("//form[3]/fieldset/input")).click();
			// Verify that contributor SDVD is successfully added.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
			Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
			Expected_Text = "Contributor3 OtherIndividuals has been added";
			assertEquals(Actual_Text, Expected_Text);
			logger.info("invite to OtherIndividuals is successfully send");
			try {
				// Logout and login with the invited contributor.
				WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
				webDriver.findElement(By.linkText("Logout")).click();
				get_The_Row_From_Login_Data = 62;
				LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
				login_Data.Login_With_Reference();
				// Complete OI test page.
				ContributorOITestPage contributorOITest = new ContributorOITestPage(webDriver);
				contributorOITest.ContributorOITest();

			} catch (Error e0) {
				logger.info("Error completing the OI questionnaire " + e0.getMessage());
			}

		} catch (Error e) {
			logger.info(e.getMessage());
			if (webDriver.getPageSource().contains(
					"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
				// Click on the Add a spouse of a Disadvantaged Individual link
				// and
				// invite this contributor.
				WebElement rateElement0 = webDriver.findElement(By.linkText("Add other individuals"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement0);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[3]/fieldset/ul/li/label")));
				// Enter Full Name of contributor.
				webDriver.findElement(By.xpath("//form[3]/fieldset/ul/li/input"))
						.sendKeys("Contributor3 OtherIndividuals");
				// Enter contributor's email.
				webDriver.findElement(By.xpath("//form[3]/fieldset/ul/li[2]/input"))
						.sendKeys("norole12@mailinator.com");
				// Click on the Send invitation to collaborator button.
				jse.executeScript("arguments[0].scrollIntoView()",
						webDriver.findElement(By.xpath("//form[3]/fieldset/input")));
				webDriver.findElement(By.xpath("//form[3]/fieldset/input")).click();
				// Verify that contributor SDVD is successfully added.
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
				Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
				Expected_Text = "Contributor3 OtherIndividuals has been added";
				assertEquals(Actual_Text, Expected_Text);
				logger.info("invite to OtherIndividuals is successfully send");
				try {
					// Logout and login with the invited contributor.
					WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
					webDriver.findElement(By.linkText("Logout")).click();
					get_The_Row_From_Login_Data = 86;
					LoginPageWithReference login_Data = new LoginPageWithReference(webDriver,
							get_The_Row_From_Login_Data);
					login_Data.Login_With_Reference();
					// Complete OI test page.
					ContributorOITestPage contributorOITest = new ContributorOITestPage(webDriver);
					contributorOITest.ContributorOITest();
				} catch (Error e0) {
					logger.info("Error completing the OI questionnaire " + e0.getMessage());
				}

			} else {
				if (webDriver.getPageSource().contains(
						"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
					// Click on the Add a spouse of a Disadvantaged Individual
					// link and
					// invite this contributor.
					WebElement rateElement0 = webDriver.findElement(By.linkText("Add other individuals"));
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement0);
					wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[3]/fieldset/ul/li/label")));
					// Enter Full Name of contributor.
					webDriver.findElement(By.xpath("//form[3]/fieldset/ul/li/input"))
							.sendKeys("Contributor3 OtherIndividuals");
					// Enter contributor's email.
					webDriver.findElement(By.xpath("//form[3]/fieldset/ul/li[2]/input"))
							.sendKeys("norole11@mailinator.com");
					// Click on the Send invitation to collaborator button.
					jse.executeScript("arguments[0].scrollIntoView()",
							webDriver.findElement(By.xpath("//form[3]/fieldset/input")));
					webDriver.findElement(By.xpath("//form[3]/fieldset/input")).click();
					// Verify that contributor SDVD is successfully added.
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
					Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
					Expected_Text = "Contributor3 OtherIndividuals has been added";
					assertEquals(Actual_Text, Expected_Text);
					logger.info("invite to OtherIndividuals is successfully send");
					try {
						// Logout and login with the invited contributor.
						WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
						((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
						webDriver.findElement(By.linkText("Logout")).click();
						get_The_Row_From_Login_Data = 87;
						LoginPageWithReference login_Data = new LoginPageWithReference(webDriver,
								get_The_Row_From_Login_Data);
						login_Data.Login_With_Reference();
						// Complete OI test page.
						ContributorOITestPage contributorOITest = new ContributorOITestPage(webDriver);
						contributorOITest.ContributorOITest();
					} catch (Error e0) {
						logger.info("Error completing the OI questionnaire " + e0.getMessage());
					}
				} else {
					logger.info("Need more new contributors emails");
				}
			}
		}
		// } catch (Exception e) {
		// ScreenShotPage screenShot = new ScreenShotPage(webDriver);
		// screenShot.ScreenShot();
		// logger.info(e.getMessage());
		// Assert.fail();
		// }
	}
}
