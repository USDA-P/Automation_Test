// Ts Created by Deepa Patri
package gov.sba.pageObjetcs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.automation.FixtureUtils.fixturesDir;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;


public class Contributor8aSpouseSubapplicationPage {

  private static final Logger logger =
      LogManager.getLogger(Contributor8aSpouseSubapplicationPage.class.getName());




  public static void spousesubapp_Gender_Info_Page(WebDriver webDriver, String which_Gender)
      throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_Gender
      if (!which_Gender.equals(null) && !which_Gender.equals("")) {
        switch (which_Gender) {
          case "Male":
            new Select(find_Element(webDriver, "8a_spousesubapp_Gender")).selectByIndex(1);
            break;
          case "Female":
            new Select(find_Element(webDriver, "8a_spousesubapp_Gender")).selectByIndex(2);
            break;
        }
        click_Element(webDriver, "Application_Common_Continue_Button");
      }

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_MaritalStatus_Page(WebDriver webDriver, String which_Status)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_martial_Status
    if (!which_Status.equals(null) && !which_Status.equals("")) {
      switch (which_Status) {
        case "UnMarried":
          click_Element(webDriver, "8a_spousesubapp_Status_Unmarried");
          break;
        case "Married":
          click_Element(webDriver, "8a_spousesubapp_Status_Married");
          break;
        case "LegallySeperated":
          click_Element(webDriver, "8a_spousesubapp_Status_LegallySeperated");
          break;

      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }


  }

  public static void spousesubapp_SocialSecNum_Page(WebDriver webDriver, String ssntext)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_Social_Secuirty_Number Page
    setText_Element(webDriver, "8a_spousesubapp_Social_Security_Number:", ssntext);
    click_Element(webDriver, "Application_Common_Continue_Button");
  }

  public static void spousesubapp_ContactInfo_Page(WebDriver webDriver, String cotactinfo)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_ContactInfo Page
    setText_Element(webDriver, "8a_spousesubApp_Page_Contact_Info", cotactinfo);
    click_Element(webDriver, "Application_Common_Continue_Button");
  }

  public static void spousesubapp_CuurentHomeAddress_Page(WebDriver webDriver, String StreetAdd,
      String CityAdd, String State, String Zip, String Contry, String Date) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_CurrentHomeAddress Page
    setText_Element(webDriver, "8a_spouseSubApp_StreetAddress", StreetAdd);
    setText_Element(webDriver, "8a_spouseSubApp_City", CityAdd);
    new Select(find_Element(webDriver, "8a_spouseSubApp_State")).selectByValue(State);
    setText_Element(webDriver, "8a_spouseSubApp_Zip", Zip);
    new Select(find_Element(webDriver, "8a_spouseSubApp_country")).selectByValue(Contry);
    setText_Element(webDriver, "8a_spouseSubApp_DateOfresidenecy", Date);

    click_Element(webDriver, "Application_Common_Continue_Button");
  }

  public static void spousesubapp_Role_Appl_firm_Page(WebDriver webDriver, String which_value)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Full_time_Devotion Citizenship Page
    if (!which_value.equals(null) && !which_value.equals("")) {
      switch (which_value.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouseSubApp_Role_Applicant_Firm_yes");
          break;
        case "no":
          click_Element(webDriver, "8a_spouseSubApp_Role_Applicant_Firm_yes");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_LengthofResidency_Page(WebDriver webDriver, String which_value)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_length of Residency
    if (!which_value.equals(null) && !which_value.equals("")) {
      switch (which_value.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouseSubApp_length_of_Residency_yes");
          break;
        case "no":
          click_Element(webDriver, "8a_spouseSubApp_length_of_Residency_no");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }
    public static void spousesubapp_PreviousHomeAddress_Page(WebDriver webDriver,String which_value,String StreetAdd,String CityAdd, String State, String Zip, String Country) throws Exception {
        // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_PreviousHomeAddress Page
        if (!which_value.equals(null) && !which_value.equals("")) {
            switch (which_value.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "8a_sposueSubapp_Page_presentAdd_yes");
                    break;
                case "no":
                    click_Element(webDriver, "8a_sposueSubapp_Page_presentAdd_no");
                    break;
            }
            setText_Element(webDriver, "8a_sposueSubapp_Page_PreviousStAdd", StreetAdd);
            setText_Element(webDriver, "8a_sposueSubapp_Page_PreviousCity", CityAdd);
            new Select(find_Element(webDriver, "8a_sposueSubapp_Page_PreviousState")).selectByValue(State);
            setText_Element(webDriver, "8a_sposueSubapp_Page_PreviousZip", Zip);
            new Select(find_Element(webDriver, "8a_sposueSubapp_Page_Previouscountry")).selectByValue(Country);
            setText_Element(webDriver, "8a_sposueSubapp_Page_DateOfFromMonth", "01");
            setText_Element(webDriver, "8a_sposueSubapp_Page_DateOfFromDay", "02");
            setText_Element(webDriver, "8a_sposueSubapp_Page_DateOfFromYear", "1999");
            setText_Element(webDriver, "8a_sposueSubapp_Page_DateOfToMonth", "01");
            setText_Element(webDriver, "8a_sposueSubapp_Page_DateOfToDay", "02");
            setText_Element(webDriver, "8a_sposueSubapp_Page_DateOfToYear", "2019");
            click_Element(webDriver, "Application_Common_Continue_Button");
        }
    }


    public static void spousesubapp_DateandPlaceofBirth_Page(WebDriver webDriver, String DtofBirth,
      String Place, String Country) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_Date and palce of Birth
    // page
    setText_Element(webDriver, "8a_spouseSubapp_DateofBirth", DtofBirth);
    setText_Element(webDriver, "8a_spouseSubapp_PlaceofBirth", Place);
    new Select(find_Element(webDriver, "8a_spouseSubapp_CountryofBirth")).selectByValue(Country);
    click_Element(webDriver, "Application_Common_Continue_Button");
  }

  public static void spousesubapp_Us_Citizenship_Page(WebDriver webDriver, String which_value)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp__US Citizenship Page
    if (!which_value.equals(null) && !which_value.equals("")) {
      switch (which_value.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouseSubapp_US_Citizenship_yes");
          /*new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
            generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_spouseSubapp_US_citizenship_no");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_Resident_Alien_Page(WebDriver webDriver, String which_value)
      throws Exception {
    // Elements Tags: @contributor_spouse_SubApp__US Citizenship Page
    if (!which_value.equals(null) && !which_value.equals("")) {
      switch (which_value.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouseSubapp_Resident_Alien_yes");
         case "no":
          click_Element(webDriver, "8a_spouseSubapp_Resident_Alien_no");
          break;
      }
      setText_Element(webDriver,"8a_spouseSubapp_Resident_Alien_comment","QA testing");
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_UploadResume_Page(WebDriver webDriver) throws Exception {
    // Elements Tags: @contributor_8a_DisAdv_Application_Page_UploadResumePage

    try {
       //Still for some 8a sub application qa automation pdf is not seeded in qa
       /* generic_file_Upld(webDriver); */
      click_Element(webDriver, "8a_spouse_UpdResume_Up1_Add_Req");
      Thread.sleep(1500);
      click_Element(webDriver, "8a_spouse_UpdResume_Up1_Add_Req_Upload");
      Thread.sleep(1500);
      click_Element(webDriver, "8a_spouse_UpdResume_Up1_Add_Req_Choose");
      Thread.sleep(1500);
      doUpload_Action();
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }


  }

  public static void spousesubapp_Appl_Firm_Ownership_Page(WebDriver webDriver,
      String firm_Name_Percent, String positons) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_spouse_Appl_Firm_Ownership Page
    setText_Element(webDriver, "8a_spouseSubapp_Firm_Owner_Percent", firm_Name_Percent);
    setText_Element(webDriver, "8a_spouseSubapp_Firm_All_Positions", positons);
    click_Element(webDriver, "Application_Common_Continue_Button");
  }

  public static void spousesubapp_Bank_Acct_Access_Page(WebDriver webDriver, String yesOrNO,
      String textVal) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Bank_Acct_Access Page
    if (!yesOrNO.equals(null) && !yesOrNO.equals("")) {
      switch (yesOrNO.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Bank_Acct_Access_Yes");
          setText_Element(webDriver, "8a_sposue_Bank_Acct_Access_Yes_Text", textVal);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Bank_Acct_Access_No");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }
    public static void spousesubapp_Prior_Ownership_Page(WebDriver webDriver, String yesOrNO,
        String textVal, String majorYesOrNo) throws Exception {
        // Elements Tags: @contributor_spouse_SubApp_Bank_Acct_Access Page
        if (!yesOrNO.equals(null) && !yesOrNO.equals("")) {
            switch (yesOrNO.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "8a_spouse_Prior_Ownership_former_employer_Yes");
                    setText_Element(webDriver, "8a_spouse_Prior_Ownership_former_employer_comment", textVal);
                    break;
                case "no":
                    click_Element(webDriver, "8a_spouse_Prior_Ownership_former_employer_No");
                    break;
            }
            click_Element(webDriver, "Application_Common_Continue_Button");
        }
        if (!majorYesOrNo.equals(null) && !majorYesOrNo.equals("")) {
            switch (majorYesOrNo.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "8a_spouse_Prior_Ownership_majority_owner_Yes");
                    generic_file_Upld(webDriver);
                    break;
                case "no":
                    click_Element(webDriver, "8a_spouse_Prior_Ownership_majority_owner_no");
                    break;
            }
            click_Element(webDriver, "Application_Common_Continue_Button");
        }
    }


  public static void spousesubapp_Business_Affiliations_Page(WebDriver webDriver, String ans1,
      String ans2, String ans2Text) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Business_Affiliation Page
    if (!ans1.equals(null) && !ans1.equals("") && !ans2.equals(null) && !ans2.equals("")) {
      switch (ans1.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Business_Affiliation_AnyOther_Yes");
         /* new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
         generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Business_Affiliation_AnyOther_No");
          break;
      }

      switch (ans2.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Business_Affiliation_RelationOwnContract_Yes");
          setText_Element(webDriver, "8a_spouse_Business_Affiliation_RelationOwnContract_Yes_Text",
              ans2Text);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Business_Affiliation_RelationOwnContract_No");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_8a_Prior_Involvement_Page(WebDriver webDriver, String ans1,
      String ans2, String ans3) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Prior 8a Involvement Page Page
    if (!ans1.equals(null) && !ans1.equals("") && !ans2.equals(null) && !ans2.equals("")
        && !ans3.equals(null) && !ans3.equals("")) {
      switch (ans1) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_Involvement_Owned_Yes");
          /*new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
          generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "88a_spouse_Prior_8a_Involvement_Owned_No");
          break;
      }
      switch (ans2) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_Involvement_Owned_one-time-only_Yes");
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_Involvement_Owned_one-time-only_No");
          break;
      }
      switch (ans3) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_Involvement_Owned_ever_owned_Yes");
          generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_Involvement_Owned_ever_owned_No");
          }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_8a_Federal_Employment_Page(WebDriver webDriver,
      String which_value) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Federal Employment Page
    if (!which_value.equals(null) && !which_value.equals("")) {

      switch (which_value.toLowerCase()) {
        case "yes":
          click_Element(webDriver, "8a_Spouse_Federal_Employment_Yes");
          /*new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
           generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_Spouse_Federal_Employment_No");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_8a_Financial_Page(WebDriver webDriver, String ans1, String ans2,
      String ans3, String ans4) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Prior 8a Involvement Page Page
    if (!ans1.equals(null) && !ans1.equals("") && !ans2.equals(null) && !ans2.equals("")
        && !ans3.equals(null) && !ans3.equals("") && !ans3.equals(null) && !ans3.equals("")) {
      switch (ans1) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_personal bankruptcy_Yes");
         /* new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
          generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_personal bankruptcy_No");
          break;
      }
      switch (ans2) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_Previously_SBA loan_Yes");
         /* new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
         generic_file_Upld(webDriver);

          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_Previously_SBA loan_No");
          break;
      }
      switch (ans3) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_pending_civil_lawsuit_Yes");
            generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_pending_civil_lawsuit_No");
          break;
      }
      switch (ans4) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_paying_Yes");
            generic_file_Upld(webDriver);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_paying_No");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_8a_Criminal_History_Page(WebDriver webDriver, String ans1,
      String ans1_Text, String ans2, String ans3, String ans4) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Prior 8a Involvement Page Page
    if (!ans1.equals(null) && !ans1.equals("") && !ans2.equals(null) && !ans2.equals("")
        && !ans3.equals(null) && !ans3.equals("") && !ans3.equals(null) && !ans3.equals("")) {
      switch (ans1) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Hist_names_Yes");
          setText_Element(webDriver, "8a_spouse_Prior_8a_criminal_Hist_names_Yes_text", ans1_Text);
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Hist_names_No");
          break;
      }
      switch (ans2) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Charges_Yes");
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Charges_No");
          break;
      }
      switch (ans3) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Offense_Yes");
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Offense_No");
          break;
      }
      switch (ans4) {
        case "yes":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Violations_Yes");
          break;
        case "no":
          click_Element(webDriver, "8a_spouse_Prior_8a_criminal_Violations_No");
          break;
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    }
  }

  public static void spousesubapp_criminal_Hist_Doc_Page(WebDriver webDriver) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Crim_Hist_Doc
    try {
        generic_file_Upld(webDriver, "8a_spouse_CrimHistDoc_Up1_Attach_All");
        generic_file_Upld(webDriver, "8a_spouse_CrimHistDoc_Up2_Attach_All");
        generic_file_Upld(webDriver, "8a_spouse_CrimHistDoc_Up3_Attach_All");
        click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }
  public static void spousesubapp_Tax_Returns_Page(WebDriver webDriver) throws Exception {
    // Elements Tags: @contributor_spouse_SubApp_Social_Narrative
    try {
      generic_file_Upld(webDriver);
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

     public static void spousesubapp_financial_CashOnHand_Page(WebDriver webDriver, String Date,
      String Currency, String SavingBal, String CheckingBal) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_CashOnHand Page
      setText_Element(webDriver, "8a_spouse_financial_CashOnHand_Date", Date);
      setText_Element(webDriver, "8a_spouse_financial_CashOnHand_Dollar", Currency);
      setText_Element(webDriver, "8a_spouse_financial_CashOnHand_Saving", SavingBal);
      setText_Element(webDriver, "8a_spouse_financial_CashOnHand_Checking", CheckingBal);
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_OtherSource_Page(WebDriver webDriver, String Salary,
      String OtherIncome, String OthIncText, String AppFirm, String EquityFirm) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_CashOnHand Page
      setText_Element(webDriver, "8a_spouse_financial_OtherSource_Salary", Salary);
      setText_Element(webDriver, "8a_spouse_financial_OtherSource_OtherIncome", OtherIncome);

      if (Integer.valueOf(OtherIncome) > 0) {
        setText_Element(webDriver, "8a_spouse_financial_OtherSource_OtherIncome_Text", OthIncText);
      }
      setText_Element(webDriver, "8a_spouse_financial_OtherSource_Appfirm", AppFirm);
      setText_Element(webDriver, "8a_spouse_financial_OtherSource_EquityFirm", EquityFirm);
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_Notes_Receivable_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_Master_Application_Page_Gender
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_Notes_Receivable_Yes");
            click_Element(webDriver, "8a_spouse_financial_Notes_Receivable_New_Button");
            setText_Element(webDriver, "8a_spouse_financial_Notes_Name_Of_Debtor", "ABC");
            setText_Element(webDriver, "8a_spouse_financial_Notes_Addr_Of_Debtor", "1234");
            setText_Element(webDriver, "8a_spouse_financial_Notes_Original_Balance", "100");
            setText_Element(webDriver, "8a_spouse_financial_Notes_Current_Balance", "100");
            setText_Element(webDriver, "8a_spouse_financial_Notes_Payment_Amount", "100");
            setText_Element(webDriver, "8a_spouse_financial_Notes_Type_Of_Collateral", "XYZ");
            click_Element(webDriver, "Application_Common_Create_button");
            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_Notes_Receivable_No");
            break;
        }
        click_Element(webDriver, "Application_Common_Continue_Button");
      }

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_Retirement_Account_Page(WebDriver webDriver,
      String IRAYesNo, String OTHYesNo) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Retirement Accounts #Do you have a Roth
      // IRA?
      if (!IRAYesNo.equals(null) && !IRAYesNo.equals("")) {
        switch (IRAYesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_Yes");
            click_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_New_Button");
            new Select(find_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_TotVal",
                "9999");
            setText_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_Contributions",
                "100");
            setText_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_Date_Of_InCon",
                "05/31/2017");
            setText_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_Name_Of_InvCom",
                "ABC");
            click_Element(webDriver, "Application_Common_Create_button");
             Thread.sleep(2000);
            /*new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
            generic_file_Upld(webDriver);
            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_IRA_No");
            break;
        }
      }
      // Elements Tags: @contributor_spouse_SubApp_financial_Retirement Accounts Do you have any
      // other retirement accounts?
      if (!OTHYesNo.equals(null) && !OTHYesNo.equals("")) {
        switch (OTHYesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_OTH_Yes");
            click_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_OTH_New_Button");
            new Select(find_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_OTH_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_OTH_TotalValue",
                "9999");
            setText_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_OTH_Name_Of_InvCom",
                "100");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            /*new newMppUploadDocumentPageDeepa(webDriver).deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/
             generic_file_Upld(webDriver);
            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_Retirement_Accounts_OTH_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_Life_Insurance_Page(WebDriver webDriver,
      String PolicyYesNo, String LoanesNo) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Retirement Accounts #Do you have a Roth
      // IRA?
      if (!PolicyYesNo.equals(null) && !PolicyYesNo.equals("")) {
        switch (PolicyYesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_Yes");
            click_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_New_Button");
            setText_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_Name", "ABC");
            setText_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_Cash", "9999");
            setText_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_Amount", "100");
            setText_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_Beneficiaries",
                "XYZ");
            click_Element(webDriver, "Application_Common_Create_button");
             Thread.sleep(2000);
            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_Life_Insurance_Policy_No");
            break;
        }
      }
      // Elements Tags: @contributor_spouse_SubApp_financial_Retirement Accounts Do you have any
      // other retirement accounts?
      if (!LoanesNo.equals(null) && !LoanesNo.equals("")) {
        switch (LoanesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_Life_Insurance_Loan_Yes");
            setText_Element(webDriver, "8a_spouse_financial_Life_Insurance_Loan_Balance", "100");
            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_Life_Insurance_Loan_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_StocksAndBonds_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Retirement Accounts #Do you have a Roth
      // IRA?
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_StockandBonds_Yes");
            click_Element(webDriver, "8a_spouse_financial_StockandBonds_New_Button");
            new Select(find_Element(webDriver, "8a_spouse_financial_StockandBonds_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_Name", "ABCD");
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_totalVal", "100");
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_Share", "10");
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_Cost", "1000");
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_Market_Val", "1000");
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_Date", "05/31/2017");
            setText_Element(webDriver, "8a_spouse_financial_StockandBonds_dividends", "10");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_StockandBonds_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_RealEstate_Page(WebDriver webDriver, String YesNo,
      String JointOwnedYesNo, String MortageNameYesNo, String ndMortageYesNo,
      String ndMortageNameYesNo, String IncomeYesNo) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Real Estate
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo) {
          case "Yes":
            click_Element(webDriver, "8a_spouse_financial_Real_Estate_Yes");
            setText_Element(webDriver, "8a_spouse_financial_Real_Estate_Primary_Address", "ABCD");
            if (!JointOwnedYesNo.equals(null) && !JointOwnedYesNo.equals("")) {
              switch (JointOwnedYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_Jointly_Owned_Yes");
                  setText_Element(webDriver, "8a_spouse_financial_Real_Estate_Percentage_Ownership",
                      "100");
                  setText_Element(webDriver, "8a_spouse_financial_Real_Estate_Percentage_Mortage",
                      "10");
                  break;
                case "No":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_Jointly_Owned_No");
              }
            }
            if (!MortageNameYesNo.equals(null) && !MortageNameYesNo.equals("")) {
              switch (MortageNameYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_Name_Mortage_Yes");
                  break;
                case "No":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_Name_Mortage_No");
              }
            }
            setText_Element(webDriver, "8a_spouse_financial_Real_Estate_Current_Residence_Val",
                "11111");
            setText_Element(webDriver, "8a_spouse_financial_Real_Estate_Mortage_Balance_Val",
                "111");

            if (!ndMortageYesNo.equals(null) && !ndMortageYesNo.equals("")) {
              switch (ndMortageYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_2nd_Mortgage_Yes");
                  if (!ndMortageNameYesNo.equals(null) && !ndMortageNameYesNo.equals("")) {
                    switch (ndMortageNameYesNo) {
                      case "Yes":
                        click_Element(webDriver,
                            "8a_spouse_financial_Real_Estate_Name_2nd_Mortgage_Yes");
                        setText_Element(webDriver,
                            "8a_spouse_financial_Real_Estate_Percentage_2nd_Mortgage", "11");
                        setText_Element(webDriver,
                            "8a_spouse_financial_Real_Estate_CurrBal_2nd_Mortgage", "1111");
                        break;
                      case "No":
                        click_Element(webDriver,
                            "8a_spouse_financial_Real_Estate_Name_2nd_Mortgage_No");
                    }
                  }
                  break;
                case "No":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_2nd_Mortgage_No");
              }
            }
            if (!IncomeYesNo.equals(null) && !IncomeYesNo.equals("")) {
              switch (IncomeYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_Income_yes");
                  setText_Element(webDriver, "8a_spouse_financial_Real_Estate_Income_Val", "1000");
                  break;
                case "No":
                  click_Element(webDriver, "8a_spouse_financial_Real_Estate_Income_No");
              }
            }

            break;
          case "No":
            click_Element(webDriver, "8a_spouse_financial_Real_Estate_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_RealEstateOther_Page(WebDriver webDriver, String YesNo,
      String OthJointOwnedYesNo, String OthMortageNameYesNo, String OthndMortageYesNo,
      String OthndMortageNameYesNo, String OthIncomeYesNo) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Real Estate Other
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo) {
          case "Yes":
            click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Yes");
            click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Add_Button");
            new Select(find_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Address", "11111");
            if (!OthJointOwnedYesNo.equals(null) && !OthJointOwnedYesNo.equals("")) {
              switch (OthJointOwnedYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Jointly_Owned_Yes");
                  setText_Element(webDriver,
                      "8a_Spouse_financial_Real_Estate_Oth_Percentage_RealEstate", "100");
                  break;
                case "No":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Jointly_Owned_No");
              }
            }
            if (!OthMortageNameYesNo.equals(null) && !OthMortageNameYesNo.equals("")) {
              switch (OthMortageNameYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Name_Mortage_Yes");
                  break;
                case "No":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Name_Mortage_No");
              }
            }
            setText_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Percentage_Mortage",
                "11");
            setText_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Current_Val", "111");
            setText_Element(webDriver,"8a_Spouse_financial_Real_Estate_Oth_Mortage_Balance_Val","111");
            if (!OthndMortageYesNo.equals(null) && !OthndMortageYesNo.equals("")) {
              switch (OthndMortageYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_2nd_Mortgage_Yes");
                  if (!OthndMortageNameYesNo.equals(null) && !OthndMortageNameYesNo.equals("")) {
                    switch (OthndMortageNameYesNo) {
                      case "Yes":
                        click_Element(webDriver,
                            "8a_Spouse_financial_Real_Estate_Oth_Name_2nd_Mortgage_Yes");
                        setText_Element(webDriver,
                            "8a_Spouse_financial_Real_Estate_Oth_Percentage_2nd_Mortgage", "11");
                        setText_Element(webDriver,
                            "8a_Spouse_financial_Real_Estate_Oth_CurrBal_2nd_Mortgage", "1111");
                        break;
                      case "No":
                        click_Element(webDriver,
                            "8a_Spouse_financial_Real_Estate_Oth_Name_2nd_Mortgage_No");
                    }
                  }
                  break;
                case "No":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_2nd_Mortgage_No");
              }
            }
            if (!OthIncomeYesNo.equals(null) && !OthIncomeYesNo.equals("")) {
              switch (OthIncomeYesNo) {
                case "Yes":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Income_yes");
                  setText_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Income_Val",
                      "1000");
                  break;
                case "No":
                  click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_Income_No");
              }
            }

            break;
          case "No":
            click_Element(webDriver, "8a_Spouse_financial_Real_Estate_Oth_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_Personal_Property_Page(WebDriver webDriver,
      String PersonalYesNo, String OthPersonalYesNo) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Retirement Accounts #Do you have a Roth
      // IRA?
      if (!PersonalYesNo.equals(null) && !PersonalYesNo.equals("")) {
        switch (PersonalYesNo) {
          case "Yes":
            click_Element(webDriver, "8a_Spouse_financial_Personal_Property_Yes");
            click_Element(webDriver, "8a_Spouse_financial_Personal_Property_New_Button");
            setText_Element(webDriver, "8a_Spouse_financial_Personal_Property_CurrVal", "100");
            setText_Element(webDriver, "8a_Spouse_financial_Personal_Property_LoadBal", "1000");
            setText_Element(webDriver, "8a_Spouse_financial_Personal_Property_DescAss",
                "10ToT2010");
            click_Element(webDriver, "Application_Common_Create_button");
             Thread.sleep(2000);
            break;
          case "No":
            click_Element(webDriver, "8a_Spouse_financial_Personal_Property_No");
            break;
        }
      }
      if (!OthPersonalYesNo.equals(null) && !OthPersonalYesNo.equals("")) {
        switch (OthPersonalYesNo) {
          case "Yes":
            click_Element(webDriver, "8a_Spouse_financial_Oth_Personal_Property_Yes");
            click_Element(webDriver, "8a_Spouse_financial_Oth_Personal_Property_New_Button");
            setText_Element(webDriver, "8a_Spouse_financial_Oth_Personal_Property_CurrVal", "100");
            setText_Element(webDriver, "8a_Spouse_financial_Oth_Personal_Property_LoadBal", "1000");
            setText_Element(webDriver, "8a_Spouse_financial_Oth_Personal_Property_DescAss",
                "10ToT2012");
            click_Element(webDriver, "Application_Common_Create_button");
             Thread.sleep(2000);
            break;
          case "No":
            click_Element(webDriver, "8a_Spouse_financial_Oth_Personal_Property_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_NotesPayableandOther_Page(WebDriver webDriver,
      String YesNo) throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Notes Payable and Other Liabilities
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo) {
          case "Yes":
            click_Element(webDriver, "8a_Spouse_financial_NotesPayable_OtherLiabilities_Yes");
            click_Element(webDriver,"8a_Spouse_financial_NotesPayable_OtherLiabilities_New_Button");
            new Select(find_Element(webDriver, "8a_Spouse_financial_NotesPayable_OtherLiabilities_Type")).selectByIndex(1);
            setText_Element(webDriver, "8a_Spouse_financial_NotesPayable_OtherLiabilities_OrgBal","100");
            setText_Element(webDriver, "8a_Spouse_financial_NotesPayable_OtherLiabilities_CurrBal","1000");
            setText_Element(webDriver, "8a_Spouse_financial_NotesPayable_OtherLiabilities_Amount","1000");
            setText_Element(webDriver,"8a_Spouse_financial_NotesPayable_OtherLiabilities_Collateral", "100");
            setText_Element(webDriver,"8a_Spouse_financial_NotesPayable_OtherLiabilities_Noteholder", "1000");
            setText_Element(webDriver,"8a_Spouse_financial_NotesPayable_OtherLiabilities_Addressholder", "1000");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "No":
            click_Element(webDriver, "8a_Spouse_financial_NotesPayable_OtherLiabilities_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void spousesubapp_financial_Assessed_Taxes_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @contributor_spouse_SubApp_financial_Assessed Taxes Start
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo) {
          case "Yes":
            click_Element(webDriver, "8a_Spouse_financial_Assessed_Taxes_Yes");
            click_Element(webDriver, "8a_Spouse_financial_Assessed_Taxes_New_Button");
            setText_Element(webDriver, "8a_Spouse_financial_Assessed_Taxes_Whom_Payable", "ABCD");
            setText_Element(webDriver, "8a_Spouse_financial_Assessed_Taxes_Amount", "1000");
            setText_Element(webDriver, "8a_Spouse_financial_Assessed_Taxes_Whendue", "05/31/2017");
            setText_Element(webDriver,"8a_Spouse_financial_Assessed_Property_Tax_Lien","111111");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "No":
            click_Element(webDriver, "8a_Spouse_financial_Assessed_Taxes_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

  public static void spousesubapp_financial_PersonalSummary_Page(WebDriver webDriver)
      throws Exception {
    try { // Elements Tags: Application_Common_Continue_Button
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

  public static void spousesubapp_financial_PrivacyStatements_Page(WebDriver webDriver)
      throws Exception {
    try { /* Elements Tags: Application_Common_Continue_Button */
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

  public static void spousesubapp_financial_Review_Page(WebDriver webDriver) throws Exception {
    try {
      // Elements Tags: Application_Common_Submit_Button
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 4);
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

    public static void spousesubapp_Signature_Page(WebDriver webDriver) throws Exception {
        try {
            // Elements Tags: contributor_8a_DisAdv_Signature Page
            click_Element(webDriver, "8a_AllApp_Signature_id");
            click_Element(webDriver, "Application_Common_Continue_Button");
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }

    }

    public static void doUpload_Action() throws Exception {
        StringSelection ss = new StringSelection(fixturesDir() + "Upload.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        logger.info("Uploading a new document - Clicked on Upload");

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(300);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(300);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(300);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(300);
        logger.info("Uploading a new document - Alt tab done");

        robot.keyPress(KeyEvent.VK_F4);
        Thread.sleep(300);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        Thread.sleep(300);
        logger.info("Uploading a new document - Clicked on F4");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(300);
        logger.info("Uploading a new document - Clicked on Tab");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(300);
        logger.info("Uploading a new document - Clicked on Tab2");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(300);
        logger.info("Uploading a new document - Clicked on Tab3");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(300);

        logger.info("Uploading a new document - Clicked on Tab4");
        robot.keyPress(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(300);
        logger.info("Uploading a new document - Clicked on Paste");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        logger.info("Uploading a new document - Clicked on All Enters");
    }
}
