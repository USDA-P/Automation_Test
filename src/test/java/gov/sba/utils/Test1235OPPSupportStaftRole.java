package gov.sba.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.TestCase;
import java.util.*;

public class Test1235OPPSupportStaftRole extends TestCase {
	// Set The variabl.es/Define
	private static WebDriver webDriver;
	private static final Logger logger_US1235 = LogManager.getLogger(Test1235OPPSupportStaftRole.class.getName());
	int get_The_Row_From_Login_Data;

	@Before
	public void setUp() throws Exception {

		webDriver = TestHelpers.getDefaultWebDriver();
		webDriver.get(TestHelpers.getBaseUrl());
		webDriver.manage().window().maximize();
		get_The_Row_From_Login_Data = 28;
	}

	@Test
	public void testMainTest() throws Exception {
		// Login to dashboard.
		LoginPageWithReference login_Data = new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
		login_Data.Login_With_Reference();
		Thread.sleep(3000);
		// Need to submit the application in EDWosb, Wosb,MPP
		// Log in As OppSupport Staft - validate as per the US1235 cceptance
		// criteria
		// on Opp Support Staft/Admin page
		try {
			// Opp Supp Staft search vendor records.
			WebElement Search_Textbox = webDriver.findElement(By.xpath("//input[@id='query']"));
			Search_Textbox.sendKeys("159165917");
			Search_Textbox.sendKeys(Keys.ENTER);
			// Click on the Business Name - opp Supp Staft can access
			// Draft,Completed Application
			WebElement business_Name = webDriver.findElement(By.xpath(
					"//article[@id='main-content']/div[@id='business_search']//div[contains(@class,'business_search_result_per_entry')]//h4/a[contains(text(),'Legal Business Name')]"));
			business_Name.click();
			// Find Draft,Active,compeleted certification
			WebElement program_Table = webDriver.findElement(By.xpath("//table[@id='certifications']"));
			List<WebElement> rows_table = program_Table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();

			for (int row = 0; row < rows_count; row++) {
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				int columns_count = Columns_row.size();
				for (int column = 0; column < columns_count; column++) {
					String celtext = Columns_row.get(column).getText();
					logger_US1235.info(
							"Cell Value Of row number " + row + " and column number " + column + " Is " + celtext);

				}
				logger_US1235.info("--------------------------------------------------");
			}
			// Help Link- opp supp Staff cannot have edit functionality on Help
			// Page
			WebElement Help_Link = webDriver.findElement(By.xpath("//a[@href='/help_pages']"));
			Help_Link.click();
			Boolean element_Not_Found = false;
			try {
				@SuppressWarnings("unused")
				WebElement HelpPage_Edit = webDriver.findElement(By.xpath("//a[@href='/help_pages/edit']"));
				logger_US1235.info("Opp supp Staft not having Edit on Help Page-HelpPage_Edit");
			} catch (Exception e) {
				element_Not_Found = true;
				logger_US1235.info("Test case Passed-HelpPage_Edit funtionality");
			}
			Assert.assertEquals(element_Not_Found, true);
		} catch (Exception e) {
			logger_US1235.info("Search TextBox is on Main Navigator is not present" + e.toString());
			// logger_US1081.info("test failed as return_vendor link dididnot
			// work");
		}
	}

	@After
	public void tearDown() throws Exception {
		webDriver.quit();
	}
}