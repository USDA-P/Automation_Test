//TS_Created_By_Deepa_Patri
package gov.sba.others;
import gov.sba.utils.integration.LoginPageWithDetails;
import gov.sba.utils.integration.LoginPageWithReference;
import gov.sba.utils.integration.NewScorpQuestionPageDeepa;
import gov.sba.utils.integration.fillApplCreatePages;


import gov.sba.automation.CommonApplicationMethods;
import gov.sba.automation.DatabaseUtils;
import gov.sba.automation.FixtureUtils;
import gov.sba.automation.TestHelpers;
import gov.sba.pageObjetcs.programs_Page;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static gov.sba.automation.CommonApplicationMethods.casesPageSearch;
import static gov.sba.automation.CommonApplicationMethods.navigationBarClick;
import static gov.sba.automation.CommonApplicationMethods.navigationMenuClick;
@Ignore
@Category({gov.sba.utils.integration.StableTests.class})
public class TestApp170LinkDunsNo8a extends TestCase {
  private static final Logger TestApp170LinkDunsNo =
          LogManager.getLogger(TestApp170LinkDunsNo8a.class.getName());
  // Set The variabl.es/Define
  WebDriver webDriver;
  String duns_Number, email, password;

  @Before
  public void setUp() throws Exception {
    CommonApplicationMethods.get_Stop_Execution_Flag();
    CommonApplicationMethods.clear_Env_Chrome();
    webDriver = TestHelpers.getDefaultWebDriver();
    CommonApplicationMethods.get_Stop_Execution_Flag();
    webDriver.get(TestHelpers.getBaseUrl());
    //CommonApplicationMethods.focus_window();
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

      programs_Page.join_New_Program_CheckBoxes(webDriver, "8A");
      fillApplCreatePages.page8aFillUp(webDriver, "Yes");
      fillApplCreatePages.finalSignatureSubmit8A(webDriver);
      navigationMenuClick(webDriver, "Logout");

      // Click on Case Link on main navigator-- 8(a) Analyst
      LoginPageWithReference login_Data_01 = new LoginPageWithReference(webDriver, 57);
      login_Data_01.Login_With_Reference();
      String typ_App_Passed = "8(a) Document Upload";
      navigationBarClick(webDriver, "Cases");
      casesPageSearch(webDriver, duns_Number);
      if (!webDriver.getPageSource().contains("No results found")) {
        // All cases page 8(a) Analyst
        String xpath_Value =
                "//div[@id='table-search']/table/tbody/tr[ " + "td/a[contains(text(),'" + duns_Number
                        + "')]	and " + "td[position()=3 and (text() = '" + typ_App_Passed + "')]" + "]";
        List<WebElement> current_Row = webDriver.findElements(By.xpath(xpath_Value));
        // Vendor Overview page should display clicking on Duns Number
        // Link
        if (current_Row.size() > 0) {
          current_Row.get(0).findElement(By.xpath("td[2]/a")).click();

          WebElement asset_Exists = webDriver
                  .findElement(By.xpath("//p[ b[contains(text(),'DUNS:')] and span[contains(text(),'"
                          + duns_Number + "')] ]"));
          assertEquals(asset_Exists.getText(), "DUNS:" + duns_Number);
        }
      }

    } catch (Exception e) {
      TestApp170LinkDunsNo.info(e.toString());
      CommonApplicationMethods.take_ScreenShot_TestCaseName(webDriver, new String[] {"TestApp170LinkDunsNo8a", "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
