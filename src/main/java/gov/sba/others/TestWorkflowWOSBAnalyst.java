// TS_Created_By_Deepa_Patri
package gov.sba.others;

import static gov.sba.automation.AssertionUtils.delete_All_Application_Draft;
import static gov.sba.automation.AssertionUtils.return_All_Applications;
import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;
import static gov.sba.utils.integration.FillApplCreatePages.page8aFillUp;
import static gov.sba.utils.integration.NewLLCQuestionanireDeepa.newLLCQuestionanireDeepa;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.sba.automation.CommonApplicationMethods;
import gov.sba.automation.DatabaseUtils;
import gov.sba.automation.TestHelpers;
import gov.sba.pageObjetcs.ProgramsPage;
import gov.sba.utils.integration.FillApplCreatePages;
import gov.sba.utils.integration.LoginPageWithDetails;
import gov.sba.utils.integration.LoginPageWithReference;
import junit.framework.TestCase;


@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkflowWOSBAnalyst extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(TestWorkflowWOSBAnalyst.class.getName());
  private static WebDriver webDriver;
  String duns_Number, email, password;

  int get_The_Row_From_Login_Data;

  @Before
  public void setUp() throws Exception {

    CommonApplicationMethods.clear_Env_Chrome();
    webDriver = TestHelpers.getDefaultWebDriver();

    webDriver.get(TestHelpers.getBaseUrl());
    // CommonApplicationMethods.focus_window();
    get_The_Row_From_Login_Data = 50;
  }

  @Test
  // US1647 -Analyst page for Wosb application
  public void testWorkflowWOSBAnalyst() throws Exception {
    LoginPageWithReference login_Data =
        new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data);
    login_Data.Login_With_Reference();
    try {
      // Return the Applicatiom;
      return_All_Applications(webDriver, 11, "263426685");
      delete_All_Application_Draft(webDriver, get_The_Row_From_Login_Data, duns_Number);
      new LoginPageWithReference(webDriver, get_The_Row_From_Login_Data).Login_With_Reference();
      // start New WOSB Applicatiom
      ProgramsPage.join_New_Program_CheckBoxes(webDriver, "WOSB");
      newLLCQuestionanireDeepa(webDriver);
      FillApplCreatePages.finalSignatureSubmit(webDriver);

      CommonApplicationMethods.navigationMenuClick(webDriver, "LOGOUT");
      navigationBarClick(webDriver, "Cases");
      // casesPageSearch(webDriver, "146323332");
      List<WebElement> current_Row_WOSB = find_Elements(webDriver, "xpath",
          "//div[@id='table-search']/table/tbody/tr[  td[position()=2]/a[contains(text(),'263426685')]  ]/td[1]/a");
      current_Row_WOSB.get(0).click();
      assertEquals("Case Overview", find_Element(webDriver, "Case_CaseOverview_title").getText());
      assertEquals("Open application summary",
          find_Element(webDriver, "SBA_Case_Overview_Open_Application_Summary").getText());
      assertEquals("Return to Vendor",
          find_Element(webDriver, "SBA_Case_Overview_Return_to_vendor").getText());
      click_Element(webDriver, "Case_Submit_Button");
      // Verify the Question review page
      assertNotNull(find_Element(webDriver, "SBA_Question_Review_Fill_Up_SideNav", true));
      List<WebElement> dropdown =
          new Select(find_Element(webDriver, "SBA_Assesment_Status")).getOptions();
      logger.info(dropdown.get(0).getText());
      assertEquals("Confirmed", dropdown.get(0).getText());
      assertEquals("Not reviewed", dropdown.get(1).getText());
      assertEquals("Information missing", dropdown.get(2).getText());

      assertEquals("Makes vendor ineligible", dropdown.get(3).getText());
      assertEquals("Needs further review", dropdown.get(4).getText());
      click_Element(webDriver, "SBA_Note_Link");
      setText_Element(webDriver, "SBA_Assesments_Note_Body", "Adding notes QA");
      click_Element(webDriver, "Application_Common_Save_Notes_Id");

      // For Wosb Financial review link not exist
      assertNull(find_Element(webDriver, "SBA_Question_Financial_Review_SideNav", true));
      // CommonApplicationMethods.click_Element(webDriver, "SBA_WOSB_Table_Link");
      // Signature page
      assertNotNull(find_Element(webDriver, "SBA_Question_Signature_Review_SideNav", true));
      dropdown =
          new Select(find_Element(webDriver, "SBA_Question_Assesment_Status_Options")).getOptions();
      assertEquals("Confirmed", dropdown.get(0).getText());
      assertEquals("Not reviewed", dropdown.get(1).getText());
      assertEquals("Information missing", dropdown.get(2).getText());
      assertEquals("Makes vendor ineligible", dropdown.get(3).getText());
      assertEquals("Needs further review", dropdown.get(4).getText());
      click_Element(webDriver, "SBA_Note_Link");
      setText_Element(webDriver, "SBA_Assesment_Note_Body", "Adding notes QA Signature Page");
      click_Element(webDriver, "SBA_Common_Page_Commit");
      // Determination page
      assertNotNull(find_Element(webDriver, "SBA_Question_Determinations_SideNav", true));
      Assert.assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Review_Started").getText(),
          "Review Started");
      Assert.assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Return_For_Mod").getText(),
          "Return for Modification");
      Assert.assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Reccomend_For_Eligibile")
              .getText(),
          "Recommend Eligible");
      Assert.assertEquals(
          find_Element(webDriver, "SBA_Question_New_Determination_Reccomend_For_InEligibile")
              .getText(),
          "Recommend Ineligible");

      setText_Element(webDriver, "SBA_Assesment_Note_Body", "Qa Test");
      // Verify on Analyst Detremination page -Determination Made, Decision not displayed
      assertNull(find_Element(webDriver, "SBA_Review_Determ_Made", true));
      assertNull(find_Element(webDriver, "SBA_Review_Determ_Decision", true));

      click_Element(webDriver, "Application_Common_Submit_Button");

     //  double_Click_Element(webDriver, "SBA_Question_Determinations_SideNav");
      new Actions(webDriver).doubleClick(find_Element(webDriver, "SBA_Question_Determinations_SideNav")).build().perform();
      click_Element(webDriver, "SBA_Review_Return_For_Mod");
      // click_Element(webDriver, "SBA_Signature_Review_Save_Continue");


    } catch (Exception e) {
      logger.info(e.toString());
      take_ScreenShot_TestCaseName(webDriver,
          new String[] {"TestWorkflowWOSBAnalyst", "Exception"});
      throw e;

    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }

  @Category({gov.sba.utils.integration.StableTests.class})

  public static class TestEDWOSBRenewal extends TestCase {
    private static final Logger logger = LogManager.getLogger(TestEDWOSBRenewal.class.getName());
    private static WebDriver webDriver;
    String duns_Number, email, password;
    int get_The_Row_From_Login_Data;

    @Before
    public void setUp() throws Exception {
      get_Stop_Execution_Flag();
      clear_Env_Chrome();
      webDriver = TestHelpers.getDefaultWebDriver();
      webDriver.get(TestHelpers.getBaseUrl());
      // CommonApplicationMethods.focus_window();
      String[] details = DatabaseUtils.findUnusedDunsNumber("");
      email = details[0];
      password = details[1];
      duns_Number = details[2];
    }

    // TODO: may be this is cut-and-paste issue, we should keep only one main test per file!
    // XXX: please review and remove one if applicable!
    @Test
    public void testMainTest() throws Exception {

      // Login to dashboard.
      LoginPageWithDetails login_Data = new LoginPageWithDetails(webDriver, email, password);
      login_Data.Login_With_Details();
      try {
        // Create application Mpp/Edwosb
        ProgramsPage.join_New_Program_CheckBoxes(webDriver, "EDWOSB");
        page8aFillUp(webDriver, "Yes");
        finalSignatureSubmit(webDriver);

        List<WebElement> count_Active = find_Elements(webDriver, "xpath",
            "//table[@id='certifications']/tbody/tr[ td[1]/a[ contains(text(),'EDWOSB') ] and td[5][ contains(text(),'Active') ]]");
        assertEquals(count_Active.size(), 1);
        logger.info("Doc has been uploaded.-Edwosb application submitted sucessfully");

        // update the expiry date to current date to make thecertificate to expire
        // --after the midnight cron job runs check the status of the certificate to - Expired --
        // APP387
        String sql_Q_01 =
            "update sbaone.certificates set expiry_date = CURRENT_TIMESTAMP where organization_id = (select id from sbaone.organizations where duns_number = '"
                + duns_Number + "')";
        new DatabaseUtils().executeSQLScript(sql_Q_01);
        // check the status of the certificate to - Expired - verify the Renewal link - submit new
        // renew application
        webDriver.navigate().refresh();
        List<WebElement> count_ReNew = find_Elements(webDriver, "xpath",
            "//table[@id='certifications']/tbody/tr[ td[1]/a[ contains(text(),'EDWOSB') ] and td[7]/a[ contains(text(),'Renew')] ]");
        assertEquals(count_ReNew.size(), 1);
        // Create new renew application - submit
        count_ReNew.get(0).findElement(By.xpath("td[7]/a")).click();
        click_Element(webDriver, "Application_Common_Accept_Button");
        page8aFillUp(webDriver, "Yes");
        finalSignatureSubmit(webDriver);
        // Verify the old application's status - Expired The renewed Application's status - Active
        List<WebElement> count_Edwosb_Active = find_Elements(webDriver, "xpath",
            "//table[@id='certifications']/tbody/tr[ td[1]/a[ contains(text(),'EDWOSB Self-Certification') ] and td[5][ contains(text(),'Active') ]]");
        assertTrue(count_Edwosb_Active.size() > 0);
        List<WebElement> count_Edwosb_Expire = find_Elements(webDriver, "xpath",
            "//*[@id='certifications']/tbody/tr" + "["
                + "td[position()=1]/a[contains(text(),'EDWOSB')]" + " and "
                + "td[position()=5 and (contains(text(),'Expired'))]" + "]");
        assertEquals(count_Edwosb_Expire.size(), 1);
      } catch (Exception e) {
        logger.info(e.toString());
        take_ScreenShot_TestCaseName(webDriver,
            new String[] {TestEDWOSBRenewal.class.getName(), "Exception"});
        throw e;
      }
    }

    @After
    public void tearDown() throws Exception {
      webDriver.quit();
    }
  }
}
