package gov.sba.utils.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.sba.automation.CoreUtils;
import junit.framework.TestCase;

public class ContributorDisadvantageIndividualQuetionPage extends TestCase {
	private static final Logger logger = LogManager
			.getLogger(ContributorDisadvantageIndividualQuetionPage.class.getName());
	WebDriver webDriver;
	int get_The_Row_From_Login_Data;
	String SDvDFN;
	String SDvDEmail1;
	String SDvDEmail2;
	String SDvDEmail3;
	String SDvDEmail4;

	public ContributorDisadvantageIndividualQuetionPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		SDvDFN = "Contributor1 SDVD";
		SDvDEmail1 = "norole22@mailinator.com";
		SDvDEmail1 = "norole12@mailinator.com";
		SDvDEmail1 = "norole13@mailinator.com";
		SDvDEmail1 = "akanamontana@gmail.com";

	}

	public void ContributorDisadvantageIndividualQuetion() throws Exception {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		logger.info("Completing Disadvantaged Individual Sub-questionnaire");
		String Actual_Text = null;
		String Expected_Text = null;
		Actual_Text = webDriver.findElement(By.linkText("Individual Contributors")).getText();
		Expected_Text = "Individual Contributors";
		assertEquals(Actual_Text, Expected_Text);
		// Actual_Text =
		// webDriver.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"))
		// .getText();
		// Expected_Text = "Complete";
		assertEquals(Actual_Text, Expected_Text);
		WebElement ContributorCompleteStatus = webDriver
				.findElement(By.xpath("//div[2]/div/section/div/div[2]/table/tbody/tr/td/span"));
		HighLight.highLightElement(webDriver, ContributorCompleteStatus);
		// Click on the link to start eligibility check.
		WebElement rateElement = webDriver.findElement(By.linkText("Individual Contributors"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement);
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//b[4]/a"), false));
		Actual_Text = webDriver.findElement(By.xpath("//b[4]/a")).getText();
		Expected_Text = "Add another Disadvantaged Individual, if applicable";
		assertEquals(Actual_Text, Expected_Text);
		// Click on the Add a spouse of a Disadvantaged Individual link and
		// invite this contributor.
		WebElement rateElement1 = webDriver
				.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
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
			webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor1 DVD");
			// Enter contributor's email.
			webDriver.findElement(By.id("contributor_email")).sendKeys("norole18@mailinator.com");
			// Click on the Send invitation to collaborator button.
			CoreUtils.clickContinue(webDriver);
			webDriver.navigate().back();
			WebElement rateElement3 = webDriver
					.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
			CoreUtils.clickContinue(webDriver);
			// Verify that contributor SDVD is successfully added.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
			Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
			Expected_Text = "Contributor1 DVD has been added";
			assertEquals(Actual_Text, Expected_Text);
			logger.info("invite to DVD is successfully send");
			// try {
			// Logout and login with the invited contributor.
			WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
			webDriver.findElement(By.linkText("Logout")).click();
			get_The_Row_From_Login_Data = 61;
			LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
			login_Data.Login_With_Reference();
			// Complete DvD Section.
			ContributorDvDPage contributorDvD = new ContributorDvDPage(webDriver);
			contributorDvD.ContributorDvD();
			// } catch (Error e) {
			// logger.info("Error completing the DVD questionnaire " +
			// e.getMessage());
			// }

		} catch (Error e) {
			logger.info(e.getMessage());
			if (webDriver.getPageSource().contains(
					"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
				WebElement rateElement11 = webDriver
						.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement11);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));

				// Enter Full Name of contributor.
				webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor2 DVD");
				// Enter contributor's email.
				webDriver.findElement(By.id("contributor_email")).sendKeys("norole19@mailinator.com");
				// Click on the Send invitation to collaborator button.
				CoreUtils.clickContinue(webDriver);
				webDriver.navigate().back();
				WebElement rateElement3 = webDriver
						.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
				CoreUtils.clickContinue(webDriver);
				if (webDriver.getPageSource().contains(
						"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
					WebElement rateElement111 = webDriver
							.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement111);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));

					// Enter Full Name of contributor.
					webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor2 DVD");
					// Enter contributor's email.
					webDriver.findElement(By.id("contributor_email")).sendKeys("norole3@mailinator.com");
					// Click on the Send invitation to collaborator button.
					CoreUtils.clickContinue(webDriver);
					webDriver.navigate().back();
					WebElement rateElement31 = webDriver
							.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement31);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
				} else {
					// Verify that contributor SDVD is successfully added.
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
					Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
					Expected_Text = "Contributor2 DVD has been added";
					assertEquals(Actual_Text, Expected_Text);
					logger.info("invite to DVD is successfully send");
				}
				// try {
				// Logout and login with the invited contributor.
				WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
				webDriver.findElement(By.linkText("Logout")).click();
				get_The_Row_From_Login_Data = 78;
				LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
				login_Data.Login_With_Reference();
				// Complete DvD Section.
				ContributorDvDPage contributorDvD = new ContributorDvDPage(webDriver);
				contributorDvD.ContributorDvD();
				// } catch (Error e1) {
				// logger.info("Error completing the DVD questionnaire" +
				// e1.getMessage());
				// }

			} else {
				if (webDriver.getPageSource().contains(
						"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
					WebElement rateElement11 = webDriver
							.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement11);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
					// Enter Full Name of contributor.
					webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor3 DVD");
					// Enter contributor's email.
					webDriver.findElement(By.id("contributor_email")).sendKeys("norole20@mailinator.com");
					// Click on the Send invitation to collaborator button.
					CoreUtils.clickContinue(webDriver);
					webDriver.navigate().back();
					WebElement rateElement3 = webDriver
							.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
					CoreUtils.clickContinue(webDriver);
					// Verify that contributor SDVD is successfully added.
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
					Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
					Expected_Text = "Contributor3 DVD has been added";
					assertEquals(Actual_Text, Expected_Text);
					logger.info("invite to DVD is successfully send");
					try {
						// Logout and login with the invited contributor.
						WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
						((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
						webDriver.findElement(By.linkText("Logout")).click();
						get_The_Row_From_Login_Data = 79;
						LoginPageWithReference login_Data = new LoginPageWithReference(webDriver,
								get_The_Row_From_Login_Data);
						login_Data.Login_With_Reference();
						// Complete DvD Section.
						ContributorDvDPage contributorDvD = new ContributorDvDPage(webDriver);
						contributorDvD.ContributorDvD();
					} catch (Error e0) {
						logger.info("Error completing the DVD questionnaire" + e0.getMessage());
					}

				} else {
					if (webDriver.getPageSource().contains(
							"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
						WebElement rateElement11 = webDriver
								.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
						((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement11);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
						// Enter Full Name of contributor.
						webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor4 DVD");
						// Enter contributor's email.
						webDriver.findElement(By.id("contributor_email")).sendKeys("norole21@mailinator.com");
						// Click on the Send invitation to collaborator button.
						CoreUtils.clickContinue(webDriver);
						webDriver.navigate().back();
						WebElement rateElement3 = webDriver
								.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
						((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
						CoreUtils.clickContinue(webDriver);
						// Verify that contributor SDVD is successfully added.
						wait.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
						Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
						Expected_Text = "Contributor4 DVD has been added";
						assertEquals(Actual_Text, Expected_Text);
						logger.info("invite to DVD is successfully send");
						try {
							// Logout and login with the invited contributor.
							WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
							((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
							webDriver.findElement(By.linkText("Logout")).click();
							get_The_Row_From_Login_Data = 80;
							LoginPageWithReference login_Data = new LoginPageWithReference(webDriver,
									get_The_Row_From_Login_Data);
							login_Data.Login_With_Reference();
							// Complete DvD Section.
							ContributorDvDPage contributorDvD = new ContributorDvDPage(webDriver);
							contributorDvD.ContributorDvD();
						} catch (Error e0) {
							logger.info("Error completing the DVD questionnaire" + e0.getMessage());
						}
					} else {
						if (webDriver.getPageSource().contains(
								"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
							WebElement rateElement11 = webDriver
									.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
							((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement11);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));

							// Enter Full Name of contributor.
							webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor5 DVD");
							// Enter contributor's email.
							webDriver.findElement(By.id("contributor_email")).sendKeys("norole22@mailinator.com");
							// Click on the Send invitation to collaborator
							// button.
							CoreUtils.clickContinue(webDriver);
							webDriver.navigate().back();
							WebElement rateElement3 = webDriver
									.findElement(By.linkText("Add another Disadvantaged Individual, if applicable"));
							((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
							CoreUtils.clickContinue(webDriver);
							// Verify that contributor SDVD is successfully
							// added.
							wait.until(ExpectedConditions
									.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
							Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
							Expected_Text = "Contributor5 DVD has been added";
							assertEquals(Actual_Text, Expected_Text);
							logger.info("invite to DVD is successfully send");
							try {
								// Logout and login with the invited
								// contributor.
								WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
								((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement2);
								webDriver.findElement(By.linkText("Logout")).click();
								get_The_Row_From_Login_Data = 81;
								LoginPageWithReference login_Data = new LoginPageWithReference(webDriver,
										get_The_Row_From_Login_Data);
								login_Data.Login_With_Reference();
								// Complete DvD Section.
								ContributorDvDPage contributorDvD = new ContributorDvDPage(webDriver);
								contributorDvD.ContributorDvD();
							} catch (Error e0) {
								logger.info("Error completing the DVD questionnaire" + e0.getMessage());
							}

						} else {
							if (webDriver.getPageSource().contains(
									"Please enter another email address for this contributor. He/She is already associated with another business in the system")) {
								WebElement rateElement11 = webDriver.findElement(
										By.linkText("Add another Disadvantaged Individual, if applicable"));
								((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement11);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
								// Enter Full Name of contributor.
								webDriver.findElement(By.id("contributor_full_name")).sendKeys("Contributor6 DVD");
								// Enter contributor's email.
								webDriver.findElement(By.id("contributor_email")).sendKeys("norole23@mailinator.com");
								// Click on the Send invitation to collaborator
								// button.
								CoreUtils.clickContinue(webDriver);
								webDriver.navigate().back();
								WebElement rateElement3 = webDriver.findElement(
										By.linkText("Add another Disadvantaged Individual, if applicable"));
								((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", rateElement3);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
								CoreUtils.clickContinue(webDriver);
								// Verify that contributor SDVD is successfully
								// added.
								wait.until(ExpectedConditions
										.visibilityOfElementLocated(By.xpath("//article/div/div/div/div/p")));
								Actual_Text = webDriver.findElement(By.xpath("//article/div/div/div/div/p")).getText();
								Expected_Text = "Contributor6 DVD has been added";
								assertEquals(Actual_Text, Expected_Text);
								logger.info("invite to DVD is successfully send");
								try {
									// Logout and login with the invited
									// contributor.
									WebElement rateElement2 = webDriver.findElement(By.id("profileid"));
									((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",
											rateElement2);
									webDriver.findElement(By.linkText("Logout")).click();
									get_The_Row_From_Login_Data = 82;
									LoginPageWithReference login_Data = new LoginPageWithReference(webDriver,
											get_The_Row_From_Login_Data);
									login_Data.Login_With_Reference();
									// Complete DvD Section.
									ContributorDvDPage contributorDvD = new ContributorDvDPage(webDriver);
									contributorDvD.ContributorDvD();
								} catch (Error e0) {
									logger.info("Error completing the DVD questionnaire" + e0.getMessage());
								}
							} else {
								logger.info("Need more new contributors emails");

							}
						}

					}

				}

			}

		}

	}
}
