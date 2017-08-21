// TS Created by Deepa Patri
package gov.sba.utils.integration;

import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.DatabaseUtils.findUnusedDunsNumber;
import static gov.sba.pageObjetcs.EDWOSBCooperationQuestionnairePage.*;
import static gov.sba.pageObjetcs.EDWOSBFinancialDataSection.*;
import static gov.sba.pageObjetcs.NewAddBusinessPartern413Deepa.Edwosb_legalseparation;
import static gov.sba.pageObjetcs.NewAddBusinessPartern413Deepa.NewFinancialQuestion;
import static gov.sba.pageObjetcs.ProgramsPage.join_New_Program_CheckBoxes;
import static gov.sba.utils.integration.FillApplCreatePages.finalSignatureSubmit;

/*
 * Documentation for Workflow WorkFlows for EDWOSB - Accommodating best minimal Workflow Tests
 * TestWorkflowEDWOSB + 07 Vendor admin create EDWOSB application for corporation business type with
 * having 8a No,one business partners 413 form and all other yes Analyst Review the Submitted
 * application, Supervisor approves it.
 */


@Category({gov.sba.utils.integration.StableTests.class})
public class TestWorkflowEDWOSB07 extends TestCase {
  private static final Logger logger = LogManager.getLogger(TestWorkflowEDWOSB07.class.getName());
  private static WebDriver webDriver;
  int stop_Exec = 1;
  String duns_Number, email, password;

  @Before
  public void setUp() throws Exception {
    get_Stop_Execution_Flag();
    clear_Env_Chrome();
    logger.info("Set as head");
    //TestHelpers.set_Headless();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
    String[] details = findUnusedDunsNumber("corp");
    email = details[0];
    password = details[1];
    duns_Number = details[2];
    /* duns_Number = "376736143";get_The_Row_From_Login_Data = 64; */

  }

  @Test
  public void testWorkflowEDWOSB07() throws Exception {
    try {
      new LoginPageWithDetails(webDriver, email, password).Login_With_Details();
      join_New_Program_CheckBoxes(webDriver, "EDWOSB");
      /* EDwosb questionnaire till Scorp-Coperation */
      Edwosb_Questionnaire_8a_Page(webDriver, "no");
      Edwosb_Questionnaire_ThridParty_Page(webDriver, "yes");
      Edwosb_Questionnaire_ChangeEligiblity_Page(webDriver, "yes");
      EDWOSB_Questionnaire_cooperation_Scorp_Page(webDriver, "yes", "yes", "yes", "yes", "yes",
          "yes");
      Edwosb_Questionnaire_CitizenShip_Page(webDriver, "yes");
      EDWOSB_Questionnaire_cooperation_Ownership_Page(webDriver, "yes", "yes", "yes");
      EDWOSB_Questionnaire_cooperation_Management_Page(webDriver, "yes", "yes", "yes", "yes", "yes",
          "yes");
      Edwosb_Questionnaire_SBAExam_Page(webDriver, "yes");
      Edwosb_Questionnaire_NetWorth_Page(webDriver, "yes");
      Edwosb_Questionnaire_AdjustedGrossIncome_Page(webDriver, "yes", "Yes");
      Edwosb_Questionnaire_Assets_Page(webDriver, "yes", "yes", "yes");
      Edwosb_Questionnaire_EconomicDisadvantage_Page(webDriver, "yes");
      accept_Alert(webDriver,15);
      /* 413 form to including first and secnodn partners */
      NewFinancialQuestion(webDriver, "deepa", "patri", "123456789", "deepa@gmail.com", "12", "VA",
          "12345", "123-123-1234", "123-123-1234", "MClean", "USA");
      accept_Alert(webDriver,15);
      Edwosb_legalseparation(webDriver, "no");
      /* EDWOSB financial question page */
      edwosb_financial_CashOnHand_Page(webDriver, "01/01/2018", "111", "111", "111");
      edwosb_financial_OtherSource_Page(webDriver, "111", "111", "other income comments", "111",
          "111");
      edwosb_financial_Notes_Receivable_Page(webDriver, "yes");
      edwosb_financial_Retirement_Account_Page(webDriver, "yes", "yes");
      edwosb_financial_Life_Insurance_Page(webDriver, "yes", "yes");
      edwosb_financial_StocksAndBonds_Page(webDriver, "yes");
      edwosb_financial_RealEstate_Page(webDriver, "yes", "yes", "yes", "yes", "yes", "yes");
      edwosb_financial_RealEstateOther_Page(webDriver, "yes", "yes", "yes", "yes", "yes", "yes");
      edwosb_financial_Personal_Property_Page(webDriver, "yes", "yes");
      edwosb_financial_NotesPayableandOther_Page(webDriver, "yes");
      edwosb_financial_Assessed_Taxes_Page(webDriver, "yes");
      edwosb_financial_Adjusted_Gross_Income_Page(webDriver);
      edwosb_financial_PersonalSummary_Page(webDriver);
      edwosb_financial_PrivacyStatements_Page(webDriver);
      edwosb_financial_Review_Page(webDriver);
      finalSignatureSubmit(webDriver);

      /* if (stop_Exec == 1) {return;} /* TODO Working On */

    } catch (Exception e) {
      logger.debug(e.toString());
      take_ScreenShot_TestCaseName(webDriver,
          new String[] {TestWorkflowEDWOSB07.class.getName(), "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }
}
