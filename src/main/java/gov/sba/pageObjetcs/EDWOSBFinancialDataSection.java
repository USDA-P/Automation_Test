package gov.sba.pageObjetcs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;

public class EDWOSBFinancialDataSection {
  private static final Logger logger =
      LogManager.getLogger(EDWOSBFinancialDataSection.class.getName());

  public static void edwosb_financial_CashOnHand_Page(WebDriver webDriver, String Date,
      String Currency, String SavingBal, String CheckingBal) throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_CashOnHand Page
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_363_setText", Date);
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_364_setText", Currency);
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_365_setText", SavingBal);
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_366_setText", CheckingBal);
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_OtherSource_Page(WebDriver webDriver, String Salary,
      String OtherIncome, String OthIncText, String AppFirm, String EquityFirm) throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_CashOnHand Page
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_367_setText", Salary);
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_368_setText", OtherIncome);

      if (Integer.valueOf(OtherIncome) > 0) {
        setText_Element(webDriver, "EDWOSB_financial_Page_Ans_368_comment", OthIncText);
      }
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_369_setText", AppFirm);
      setText_Element(webDriver, "EDWOSB_financial_Page_Ans_370_setText", EquityFirm);
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_Notes_Receivable_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @vcontributor_8a_DisAdv_financial_Notes Receivable Page
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_371_Y");
            click_Element(webDriver, "EDWOSB_financial_Notes_Receivable_New_Button");
            setText_Element(webDriver, "EDWOSB_financial_Notes_Name_Of_Debtor", "ABC");
            setText_Element(webDriver, "EDWOSB_financial_Notes_Addr_Of_Debtor", "1234");
            setText_Element(webDriver, "EDWOSB_financial_Notes_Original_Balance", "100");
            setText_Element(webDriver, "EDWOSB_financial_Notes_Current_Balance", "100");
            setText_Element(webDriver, "EDWOSB_financial_Notes_Payment_Amount", "100");
            setText_Element(webDriver, "EDWOSB_financial_Notes_Type_Of_Collateral", "XYZ");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_371_N");
            break;
        }
        click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");
      }

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_Retirement_Account_Page(WebDriver webDriver, String IRAYesNo,
      String OTHYesNo) throws Exception {
    try {
      // Elements Tags: @contributor_8a_DisAdv_financial_Retirement Accounts #Do you have a Roth
      // IRA?
      if (!IRAYesNo.equals(null) && !IRAYesNo.equals("")) {
        switch (IRAYesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_372_Y");
            click_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_IRA_New_Button");
            new Select(find_Element(webDriver, "EDWOSB_financial_Retirement Accounts_IRA_Type"))
                .selectByValue("Roth IRA");
            setText_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_IRA_TotVal", "9999");
            setText_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_IRA_Contributions",
                "100");
            WebElement aa =
                find_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_IRA_Date_Of_InCon");
            aa.clear();
            aa.sendKeys("05/31/2017");
            aa.sendKeys(Keys.TAB);
            setText_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_IRA_Name_Of_InvCom",
                "ABC");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            generic_file_Upld(webDriver);
            break;
          case "No":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_372_N");
            break;
        }
      }
      // Elements Tags: @vendor_Admin_8a_financial_Retirement Accounts Do you have any other
      // retirement accounts?
      if (!OTHYesNo.equals(null) && !OTHYesNo.equals("")) {
        switch (OTHYesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_373_Y");
            click_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_OTH_New_Button");
            new Select(find_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_OTH_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_OTH_TotalValue",
                "9999");
            setText_Element(webDriver, "EDWOSB_financial_Retirement_Accounts_OTH_Name_Of_InvCom",
                "ABC");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            generic_file_Upld(webDriver, "EDWOSB_financial_Retirement_Accounts_OTH_All");
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_373_N");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_Life_Insurance_Page(WebDriver webDriver, String PolicyYesNo,
      String LoanesNo) throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Life_Insurance
      if (!PolicyYesNo.equals(null) && !PolicyYesNo.equals("")) {
        switch (PolicyYesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_Yes");
            click_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_New_Button");
            setText_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_Name", "ABC");
            setText_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_Cash", "9999");
            setText_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_Amount", "100");
            setText_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_Beneficiaries",
                "XYZ");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Life_Insurance_Policy_No");
            break;
        }
      }
      // Elements Tags: @Contributor_8a_Disadv_life insurance
      // retirement accounts?
      if (!LoanesNo.equals(null) && !LoanesNo.equals("")) {
        switch (LoanesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Life_Insurance_Loan_Yes");
            setText_Element(webDriver, "EDWOSB_financial_Life_Insurance_Loan_Balance", "100");
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Life_Insurance_Loan_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_StocksAndBonds_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Retirement Accounts #Do you have a Roth IRA?
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_377_Y");
            click_Element(webDriver, "EDWOSB_financial_StockandBonds_New_Button");
            new Select(find_Element(webDriver, "8a_DisAdv_financial_StockandBonds_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "EDWOSB_financial_StockandBonds_Name", "ABCD");
            setText_Element(webDriver, "EDWOSB_financial_StockandBonds_totlVal", "100");
            setText_Element(webDriver, "EDWOSB_financial_StockandBonds_Share", "10");
            setText_Element(webDriver, "EDWOSB_financial_StockandBonds_Cost", "1000");
            setText_Element(webDriver, "EDWOSB_financial_StockandBonds_Market_Val", "1000");
            WebElement stdate = find_Element(webDriver, "EDWOSB_financial_StockandBonds_Date");
            stdate.clear();
            stdate.sendKeys("05/31/2017");
            stdate.sendKeys(Keys.TAB);
            setText_Element(webDriver, "EDWOSB_financial_StockandBonds_dividends", "10");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_378_N");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_RealEstate_Page(WebDriver webDriver, String YesNo,
      String JointOwnedYesNo, String MortageNameYesNo, String ndMortageYesNo,
      String ndMortageNameYesNo, String IncomeYesNo) throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Real Estate
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_378_Y");
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Primary_Address", "ABCD");
            if (!JointOwnedYesNo.equals(null) && !JointOwnedYesNo.equals("")) {
              switch (JointOwnedYesNo) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Jointly_Owned_Yes");
                  setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Percentage_Ownership",
                      "100");
                  setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Percentage_Mortage",
                      "10");
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Jointly_Owned_No");
              }
            }
            if (!MortageNameYesNo.equals(null) && !MortageNameYesNo.equals("")) {
              switch (MortageNameYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Name_Mortage_Yes");
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Name_Mortage_No");
              }
            }
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Current_Residence_Val",
                "11111");
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Mortage_Balance_Val", "111");

            if (!ndMortageYesNo.equals(null) && !ndMortageYesNo.equals("")) {
              switch (ndMortageYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_2nd_Mortgage_Yes");
                  if (!ndMortageNameYesNo.equals(null) && !ndMortageNameYesNo.equals("")) {
                    switch (ndMortageNameYesNo.toLowerCase()) {
                      case "yes":
                        click_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Name_2nd_Mortgage_Yes");
                        setText_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Percentage_2nd_Mortgage", "11");
                        setText_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_CurrBal_2nd_Mortgage", "1111");
                        break;
                      case "no":
                        click_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Name_2nd_Mortgage_No");
                    }
                  }
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_2nd_Mortgage_No");
              }
            }
            if (!IncomeYesNo.equals(null) && !IncomeYesNo.equals("")) {
              switch (IncomeYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Income_yes");
                  setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Income_Val", "1000");
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Income_No");
              }
            }

            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_378_N");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_RealEstateOther_Page(WebDriver webDriver, String YesNo,
      String OthJointOwnedYesNo, String OthMortageNameYesNo, String OthndMortageYesNo,
      String OthndMortageNameYesNo, String OthIncomeYesNo) throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Real Estate Other
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_380_Y");
            click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Add_Button");
            new Select(find_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Type"))
                .selectByIndex(1);
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Address", "11111");
            if (!OthJointOwnedYesNo.equals(null) && !OthJointOwnedYesNo.equals("")) {
              switch (OthJointOwnedYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Jointly_Owned_Yes");
                  setText_Element(webDriver,
                      "EDWOSB_financial_Real_Estate_Oth_Percentage_RealEstate", "100");
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Jointly_Owned_No");
              }
            }
            if (!OthMortageNameYesNo.equals(null) && !OthMortageNameYesNo.equals("")) {
              switch (OthMortageNameYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Name_Mortage_Yes");
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Name_Mortage_No");
              }
            }
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Percentage_Mortage", "11");
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Current_Val", "111");
            setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Mortage_Balance_Val",
                "111");

            if (!OthndMortageYesNo.equals(null) && !OthndMortageYesNo.equals("")) {
              switch (OthndMortageYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_2nd_Mortgage_Yes");
                  if (!OthndMortageNameYesNo.equals(null) && !OthndMortageNameYesNo.equals("")) {
                    switch (OthndMortageNameYesNo.toLowerCase()) {
                      case "yes":
                        click_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Oth_Name_2nd_Mortgage_Yes");
                        setText_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Oth_Percentage_2nd_Mortgage", "11");
                        setText_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Oth_CurrBal_2nd_Mortgage", "1111");
                        break;
                      case "no":
                        click_Element(webDriver,
                            "EDWOSB_financial_Real_Estate_Oth_Name_2nd_Mortgage_No");
                    }
                  }
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_2nd_Mortgage_No");
              }
            }
            if (!OthIncomeYesNo.equals(null) && !OthIncomeYesNo.equals("")) {
              switch (OthIncomeYesNo.toLowerCase()) {
                case "yes":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Income_yes");
                  setText_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Income_Val", "1000");
                  break;
                case "no":
                  click_Element(webDriver, "EDWOSB_financial_Real_Estate_Oth_Income_No");
              }
            }

            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_380_N");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_Personal_Property_Page(WebDriver webDriver,
      String PersonalYesNo, String OthPersonalYesNo) throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Retirement Accounts #Do you have a Roth IRA?
      if (!PersonalYesNo.equals(null) && !PersonalYesNo.equals("")) {
        switch (PersonalYesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Personal_Property_Yes");
            click_Element(webDriver, "EDWOSB_financial_Personal_Property_New_Button");
            setText_Element(webDriver, "EDWOSB_financial_Personal_Property_CurrVal", "100");
            setText_Element(webDriver, "EDWOSB_financial_Personal_Property_LoadBal", "1000");
            setText_Element(webDriver, "EDWOSB_financial_Personal_Property_DescAss", "10ToT2010");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Page_Ans_382_N");
            break;
        }
      }
      if (!OthPersonalYesNo.equals(null) && !OthPersonalYesNo.equals("")) {
        switch (OthPersonalYesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Oth_Personal_Property_Yes");
            click_Element(webDriver, "EDWOSB_financial_Oth_Personal_Property_New_Button");
            setText_Element(webDriver, "EDWOSB_financial_Oth_Personal_Property_CurrVal", "100");
            setText_Element(webDriver, "EDWOSB_financial_Oth_Personal_Property_LoadBal", "1000");
            setText_Element(webDriver, "EDWOSB_financial_Oth_Personal_Property_DescAss",
                "10ToT2012");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Oth_Personal_Property_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_NotesPayableandOther_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Notes Payable and Other Liabilities
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_Yes");
            click_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_New_Button");
            new Select(
                find_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_Type"))
                    .selectByIndex(1);
            setText_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_OrgBal",
                "100");
            setText_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_CurrBal",
                "1000");
            setText_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_Amount",
                "1000");
            setText_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_Collateral",
                "100");
            setText_Element(webDriver, "EDWOSB_financial_NotesPayable_OtherLiabilities_Noteholder",
                "1000");
            setText_Element(webDriver,
                "EDWOSB_financial_NotesPayable_OtherLiabilities_Addressholder", "1000");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "8a_DisAdv_financial_NotesPayable_OtherLiabilities_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  public static void edwosb_financial_Assessed_Taxes_Page(WebDriver webDriver, String YesNo)
      throws Exception {
    try {
      // Elements Tags: @vendor_Admin_8a_financial_Assessed Taxes Start
      if (!YesNo.equals(null) && !YesNo.equals("")) {
        switch (YesNo.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_financial_Assessed_Taxes_Yes");
            click_Element(webDriver, "EDWOSB_financial_Assessed_Taxes_New_Button");
            setText_Element(webDriver, "EDWOSB_financial_Assessed_Taxes_Whom_Payable", "ABCD");
            setText_Element(webDriver, "EDWOSB_financial_Assessed_Taxes_Amount", "1000");
            WebElement whenduedate =
                find_Element(webDriver, "EDWOSB_financial_Assessed_Taxes_Whendue");
            whenduedate.clear();
            whenduedate.sendKeys("05/31/2017");
            whenduedate.sendKeys(Keys.TAB);
            setText_Element(webDriver, "EDWOSB_financial_Assessed_Property_Tax_Lien", "100");
            click_Element(webDriver, "Application_Common_Create_button");
            Thread.sleep(2000);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_financial_Assessed_Taxes_No");
            break;
        }
      }
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

  public static void edwosb_financial_PersonalSummary_Page(WebDriver webDriver) throws Exception {
    try { // Elements Tags: Application_Common_Continue_Button
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

  public static void edwosb_financial_PrivacyStatements_Page(WebDriver webDriver) throws Exception {
    try { /* Elements Tags: Application_Common_Continue_Button */
      click_Element(webDriver, "Application_Common_Continue_Button");
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }

  public static void edwosb_financial_Review_Page(WebDriver webDriver) throws Exception {
    try {
      // Elements Tags: Application_Common_Submit_Button
      accept_Alert(webDriver, 4);
      click_Element(webDriver, "Application_Common_Submit_Button");
      accept_Alert(webDriver, 4);
    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }

  }
  }

