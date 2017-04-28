//TS Created By _deepa patri
package gov.sba.utils.integration;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.sba.automation.utils.CommonApplicationMethods;
import gov.sba.automation.utils.DatabaseUtils;
import junit.framework.TestCase;

@Category({ gov.sba.utils.integration.StableTests.class })
public class TestApp170LinkDunsNo8a extends TestCase {
    // Set The variabl.es/Define
    WebDriver webDriver;
    private static final Logger TestApp170LinkDunsNo = LogManager.getLogger(TestApp170LinkDunsNo8a.class.getName());
    String duns_Number, email, password;

    @Before
    public void setUp() throws Exception {
        CommonApplicationMethods.clear_Env_Chrome();
        webDriver = TestHelpers.getDefaultWebDriver();
        webDriver.get(TestHelpers.getBaseUrl());
        CommonApplicationMethods.focus_window();
        String[] details = DatabaseUtils.findUnusedDunsNumber();
        email = details[0];
        password = details[1];
        duns_Number = details[2];
    }

    @Test
    public void testMainTest() throws Exception {
        try {

            LoginPageWithDetails login_Data = new LoginPageWithDetails(webDriver, email, password);
            login_Data.Login_With_Details();

            CommonApplicationMethods.navigationMenuClick(webDriver, "Programs");
            CommonApplicationMethods.createApplication(webDriver, "8A");
            String file_path_abs = FixtureUtils.fixturesDir() + "Upload.pdf";
            TestApp170LinkDunsNo.info(file_path_abs);
            fillApplCreatePages.page8aFillUp(webDriver, "Yes", file_path_abs);
            fillApplCreatePages.finalSignatureSubmit8A(webDriver);
            CommonApplicationMethods.navigationMenuClick(webDriver, "Logout");

            // Click on Case Link on main navigator-- 8(a) Analyst
            LoginPageWithReference login_Data_01 = new LoginPageWithReference(webDriver, 57);
            login_Data_01.Login_With_Reference();
            String typ_App_Passed = "8(a) Document Upload";
            CommonApplicationMethods.navigationMenuClick(webDriver, "Cases");
            CommonApplicationMethods.casesPageSearch(webDriver, duns_Number);
            if (!webDriver.getPageSource().contains("No results found")) {
                // All cases page 8(a) Analyst
                String xpath_Value = "//div[@id='table-search']/table/tbody/tr[ " + "td/a[contains(text(),'"
                        + duns_Number + "')]	and " + "td[position()=3 and (text() = '" + typ_App_Passed + "')]"
                        + "]";
                List<WebElement> current_Row = webDriver.findElements(By.xpath(xpath_Value));
                // Vendor Overview page should display clicking on Duns Number
                // Link
                if (current_Row.size() > 0) {
                    current_Row.get(0).findElement(By.xpath("td[2]/a")).click();

                    WebElement asset_Exists = webDriver.findElement(By.xpath(
                            "//p[ b[contains(text(),'DUNS:')] and span[contains(text(),'" + duns_Number + "')] ]"));
                    assertEquals(asset_Exists.getText(), "DUNS:" + duns_Number);
                }
            }

        } catch (Exception e) {
            TestApp170LinkDunsNo.info(e.toString());
            CommonApplicationMethods.take_ScreenShot_TestCaseName(webDriver, new String[]{"TestApp170LinkDunsNo8a", "Exception"});
            throw e;
        }
    }

    @After
    public void tearDown() throws Exception {
        webDriver.quit();
    }
}