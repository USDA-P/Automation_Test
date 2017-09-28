// TS_Created_By_Deepa_Patri
package gov.sba.utils.integration;

import gov.sba.automation.DatabaseUtils;
import gov.sba.automation.FixtureUtils;
import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;
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

import java.util.ArrayList;
import java.util.List;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.Contributor8aDisadvantagedIndAppPage.*;
import static gov.sba.pageObjetcs.MasterApplication8a.*;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.pageObjetcs.VendorDashboardPage.verify_Row_In_A_Table_And_Return;

// Still in progress
@Category({gov.sba.utils.integration.UnstableTests.class})
public class TestWorkFlow8a01 extends TestCase {
  // Set The variabl.es/Define
  Logger logger = LogManager.getLogger(TestWorkFlow8a01.class.getName());
  String[][] appFirm;
  private static WebDriver webDriver;
  /* int get_The_Row_From_Login_Data; */
  String duns_Number, email, password;
  String app_Firm_Name, app_Firm_Address, app_Firm_State;

  @Before
  public void setUp() throws Exception {
    if (get_Stop_Execution_Flag())
      return;
    clear_Env_Chrome();
    logger.info("Set as head");
    // TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    /* get_The_Row_From_Login_Data = 43; */
    String[] details = findUnusedDunsNumber("");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
    appFirm = DatabaseUtils.getApplication_Firm(duns_Number);
    app_Firm_Name    = appFirm[0][0];
    app_Firm_Address = appFirm[0][1];
    app_Firm_State   = appFirm[0][2];
  }

  @Test
  public void testWorkFlow8a01() throws Exception {
    try {

      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();

       join_New_Program_CheckBoxes(webDriver, "8A");
      /* Basic Eligibility Page */
      BasicEligiblity_General_Assessment_Page(webDriver, "Yes", "no", "Yes", "Yes", "Yes");
      BasicEligiblity_Prior_8a_Involvement_Page(webDriver, "no", "Yes", "Yes");
      BasicEligiblity_Outside_Assistance_Page(webDriver, "Yes");
      BasicEligiblity_Business_Size_Page(webDriver, "Yes", "Yes");
      BasicEligiblity_Size_Determination_Page(webDriver);
      /* Basic ownership Page */
      masterApp_8a_Page_Click(webDriver, "page_business_ownership");
      Business_Ownership_Entity_Ownership_Page(webDriver, "yes");
      Business_Ownership_Ownership_Details_Page(webDriver, "yes", "no", "no", "no");
      Business_Ownership_Corporations_Page(webDriver);
      /* generic_file_Upld(webDriver); */
      /* generic_file_Upld(webDriver); */
      /* generic_file_Upld(webDriver); */
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      /* Character Page */
      masterApp_8a_Page_Click(webDriver, "page_character_link");
      character_Page(webDriver, "yes", "no", "no", "no");
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 10);
      /* Potential for success page */
      masterApp_8a_Page_Click(webDriver, "page_potential_for_Success_link");
      generic_file_Upld(webDriver);
      click_Element(webDriver, "Application_Common_Submit_Button");
      potential_For_Sucess_Revenue_Page(webDriver, "Yes", "Yes", "5", "Yes - Add it");
      potential_For_Sucess_Page_Sucesss(webDriver, "No", "No", "na");
      potential_For_Sucess_Page_Review(webDriver);
      masterApp_8a_Page_Click(webDriver, "page_control_link");
      control_Page_Firm_Control(webDriver, "no", "no", "no", "na", "no", "yes");
      control_Page_Leased_Facility(webDriver, "yes");
      firm_Control_Page_Review(webDriver);
      /* Contributor Page- Vendor Admin Sub application */
      masterApp_8a_Page_Click(webDriver, "page_contributors_Start_Indv_Cont");
      contributorsubApp_8aDisAdvInd(webDriver);
      /* To complete 8a Master Application. */
      master8aApp_final_ReviewSign(webDriver);
      navigationMenuClick(webDriver, "DASHBOARD");
      List<WebElement> all_Cells = verify_Row_In_A_Table_And_Return(webDriver,
          new String[] {"8(a) Initial Application", "", "Pending", "", "", "", ""});
      assertNotNull(all_Cells);

      /* Create a file and write the output into the file*/
      //String file_Path = FixtureUtils.fixturesDir() + "test8asubmission_output.txt";
      //delete_Any_File(file_Path);
      //create_Any_File(file_Path);
      //write_file(file_Path, appFirm[0][1]);
      /* APp-1145*/
      /* 8a cod's supervsior page displaying the Unassigned cases */
      navigationMenuClick(webDriver, "Logout");
      webDriver.get(TestHelpers.getBaseUrl());
      click_Element(webDriver, "SBA_Login_Button");
      setText_Element(webDriver, "SBA_Login_Email", "sba_supervisor_8a_cods_5@mailinator.com");
      setText_Element(webDriver, "SBA_Login_Pwd", "password");
      click_Element(webDriver, "SBA_Login_Sign_in");
      List<WebElement> row_Header = find_Elements(webDriver,"SBA_Supervisor_Unassigned_Cases_Table");
      String[] header_Names_Array =
              new String[] {"Date Submitted", "Applicant Firm", "Applicant Firm Location", "Actions"};
      String[] header_Names_Array_Validate = new String[4];
      java.util.Iterator<WebElement> list_elements = row_Header.iterator();
      int i = 0;
      while (list_elements.hasNext()) {
        logger.info(i);
        header_Names_Array_Validate[i] = list_elements.next().getText();
        i = i + 1;
      }
      Assert.assertArrayEquals(header_Names_Array, header_Names_Array_Validate);
      List<ArrayList<String>> ui_rows_array = new ArrayList<>();
      String xpath_For_Row = "//article[@id='main-content']//header[ h2[ contains(text(),'Unassigned Cases')] ]/table/tbody/tr[ td [position()=2]/a[ contains(text(),'"+  app_Firm_Name + "') ] ]";
      String xpath_For_Row_Link = "//article[@id='main-content']//header[ h2[ contains(text(),'Unassigned Cases')] ]/table/tbody/tr/td [position()=2]/a[ contains(text(),'"+  app_Firm_Name + "') ] ";
      List<WebElement> rows_Body = webDriver.findElements(By
              .xpath(xpath_For_Row));
      for (int j = 0; j < rows_Body.size(); j++) {
        ArrayList<String> ui_rows_Cell = new ArrayList<>();
        logger.info(rows_Body.get(j).getAttribute("innerHTML"));
        List<WebElement> rows_Body_Cells = rows_Body.get(j).findElements(By.xpath("td"));

        logger.info("+++++++" + rows_Body_Cells.size());
        ui_rows_Cell.add(rows_Body_Cells.get(0).getText().toUpperCase());
        logger.info(rows_Body_Cells.get(0).getText().toUpperCase());
        ui_rows_Cell.add(rows_Body_Cells.get(1).getText().toUpperCase());
        logger.info(rows_Body_Cells.get(1).getText().toUpperCase());
        ui_rows_Cell.add(rows_Body_Cells.get(2).getText().toUpperCase());
        logger.info(rows_Body_Cells.get(2).getText().toUpperCase());
        ui_rows_Cell.add(rows_Body_Cells.get(3).getText().toUpperCase());
        logger.info(rows_Body_Cells.get(3).getText().toUpperCase());
        ui_rows_array.add(ui_rows_Cell);
      }

      logger.info(ui_rows_array.toString());

      //click_Element(webDriver,"xpath", xpath_For_Row_Link);

      /* For Demo End - July 6 */

    } catch (Exception e) {
      logger.info(e.toString());
      take_ScreenShot_TestCaseName(webDriver, new String[] {"TestWorkFlow8a01", "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    //webDriver.quit();
  }
}


