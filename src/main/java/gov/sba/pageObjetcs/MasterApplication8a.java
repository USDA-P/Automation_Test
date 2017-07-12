// Ts Created by Deepa patri
package gov.sba.pageObjetcs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.pageObjetcs.Contributor8aDisadvantagedIndAppPage.*;
import static gov.sba.pageObjetcs.Contributor8aSpouseSubapplicationPage.*;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;

public class MasterApplication8a {

    private static final Logger logger = LogManager.getLogger(MasterApplication8a.class.getName());

    public static void masterApp_8a_Page_Click(WebDriver webDriver, String link_To_Click) throws Exception {
        // Elements tag: @8a_Initial_Program
        if (!link_To_Click.equals(null) && !link_To_Click.equals("")) {
            switch (link_To_Click.toLowerCase()) {
                case "page_contributors":
                    click_Element(webDriver, "8a_Application_Page_Contributers_Link");
                    break;
                case "page_contributors_start_indv_cont":
                    click_Element(webDriver, "8a_Application_Page_Contributers_Link");
                    click_Element(webDriver, "8a_Application_Page_Contributers_Link_Start_Indv");
                    click_Element(webDriver, "Application_Common_Accept_Button");
                    break;
                case "page_basiceligibility":
                    click_Element(webDriver, "8a_Application_Page_BasicEligibility_Link");
                    break;
                case "page_business_ownership":
                    click_Element(webDriver, "8a_Application_Page_Business_Ownership_Link");
                    break;
                case "page_character_link":
                    click_Element(webDriver, "8a_Application_Page_Character_Link");
                    break;
                case "page_potential_for_success_link":
                    click_Element(webDriver, "8a_Application_Page_Potential_for_Success_Link");
                    break;
                case "page_control_link":
                    click_Element(webDriver, "8a_Application_Page_Control_Link");
                    break;
            }

        }
    }

    public static void potential_For_Sucess_Revenue_Page(WebDriver webDriver, String revCode, String prim2years, String primPer, String addFiscal) throws Exception {
        /*Elements tag: Potntial Sucess*/
        if (!revCode.equals(null) && !revCode.equals("")) {
            switch (revCode.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Potential_Sucess_Revenue_NAICS_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Potential_Sucess_Revenue_NAICS_No");
                    setText_Element(webDriver,"Potential_Sucess_Revenue_NAICS_Comment","QA Testing");
                    break;

            }
        }
        if (!prim2years.equals(null) && !prim2years.equals("")) {
            switch (prim2years.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Potential_Sucess_Revenue_Primary_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Potential_Sucess_Revenue_Primary_No");
                    generic_file_Upld(webDriver);
                    break;

            }
        }

        if (!primPer.equals(null) && !primPer.equals("")) {
            setText_Element(webDriver, "Potential_Sucess_Revenue_Precentage", primPer);
        }

        if (!addFiscal.equals(null) && !addFiscal.equals("")) {

        /*Hard code contracts Values*/
            click_Element(webDriver, "Potential_Sucess_Present_Past_Contracts_Insert_Row");
            List<WebElement> cells = find_Elements(webDriver, "Potential_Sucess_Present_Past_Contracts_All_Cells");
            cells.get(0).sendKeys("10/10/2001");
            cells.get(1).sendKeys("DeepaXXXX");
            cells.get(2).sendKeys("123456");
            cells.get(3).sendKeys("Testing");
            cells.get(4).sendKeys("a12345");
            click_Element(webDriver, "Potential_Sucess_Present_Past_Contracts_Btn_Insert");
        }

        generic_file_Upld(webDriver, "Potential_Sucess_Present_Past_balance_Sheet_Attach_All");
        click_Element(webDriver, "Application_Common_Section_Submit_Button_Id");


    }

    public static void potential_For_Sucess_Page_Sucesss(WebDriver webDriver, String loan, String licences, String bonding) throws Exception {
            /*Elements tag: Potntial Sucess*/
        if (!loan.equals(null) && !loan.equals("")) {
            switch (loan.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Loan_Agree_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Loan_Agree_No");
                    break;

            }
        }
        if (!licences.equals(null) && !licences.equals("")) {
            switch (licences.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Special_License_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Special_License_No");
                    break;

            }
        }

        if (!bonding.equals(null) && !bonding.equals("")) {
            switch (bonding.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Bonding_Ability_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Bonding_Ability_No");
                    break;
                case "na":
                    click_Element(webDriver, "Potential_Sucess_Sucess_Bonding_Ability_NA");
                    break;

            }
        }


        click_Element(webDriver, "Application_Common_Section_Submit_Button_Id");
    }

    public static void firm_Control_Page_Review(WebDriver webDriver) throws Exception {
            /*Elements tag: Potntial Sucess*/
        click_Element(webDriver, "Application_Common_Submit_Button");
        accept_Alert(webDriver, 3);
    }

    public static void potential_For_Sucess_Page_Review(WebDriver webDriver) throws Exception {
            /*Elements tag: Potntial Sucess*/
        click_Element(webDriver, "Application_Common_Submit_Button");
        accept_Alert(webDriver, 3);
    }

    public static void Contributor_Page(WebDriver webDriver, String link_To_Click) throws Exception {
        // Elements tag: @8a_Initial_Program- Contributor
        if (!link_To_Click.equals(null) && !link_To_Click.equals("")) {
            switch (link_To_Click.toLowerCase()) {
                case "8a_disadvind_contributor":
                    click_Element(webDriver, "Contributor_Add_DisAdv_Ind_Link");
                    break;
                case "8a_addspouse_contributor":
                    click_Element(webDriver, "Contributor_Add_Spouse_Ind_Link");
                    break;
                case "8a_addbuspart_contributor":
                    click_Element(webDriver, "Contributor_Add_Business_Ind_Link");
                    break;
            }
        }
    }

    public static void BasicEligiblity_General_Assessment_Page(WebDriver webDriver, String ProfileYesNo, String BrokenYesNo, String RevenueYesNo, String CitizenYesNo, String DBANameYesNo) throws Exception {
        try {
            // Elements tag: @8a_Initial_Program Basic Eligiblity -General Assessment
            if (!ProfileYesNo.equals(null) && !ProfileYesNo.equals("")) {
                switch (ProfileYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_profit_business_Yes");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_profit_business_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any button
            if (!BrokenYesNo.equals(null) && !BrokenYesNo.equals("")) {
                switch (BrokenYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_a_broker_Yes");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_a_broker_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any button
            if (!RevenueYesNo.equals(null) && !RevenueYesNo.equals("")) {
                switch (RevenueYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_any_revenue_Yes");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_any_revenue_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any buttonbutton
            if (!CitizenYesNo.equals(null) && !CitizenYesNo.equals("")) {
                switch (CitizenYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_U.S._citizens_Yes");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_U.S._citizens_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any buttonbutton
            if (!DBANameYesNo.equals(null) && !DBANameYesNo.equals("")) {
                switch (DBANameYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_DBA_Name_Yes");
                        setText_Element(webDriver, "BasicEligibility_General_Assessment_DBA_Name_Yes_Comment",
                            "QA Testing");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_General_Assessment_DBA_Name_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any buttonbutton
            click_Element(webDriver, "Application_Common_Submit_Button");
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

    public static void BasicEligiblity_Prior_8a_Involvement_Page(WebDriver webDriver, String PartcipantYesNo, String SubmittedYesNo, String AssetYesNo) throws Exception { try {
        // Elements tag: @8a_Initial_Program Basic Eligiblity-Prior 8(a) Involvement
        if (!PartcipantYesNo.equals(null) && !PartcipantYesNo.equals("")) {
            switch (PartcipantYesNo.toLowerCase()) {
                case "yes":
                    click_Element(webDriver,
                        "BasicEligibility_Prior_8a_Involvement_Program_Participant_Yes");
                    break;
                case "no":
                    click_Element(webDriver,
                        "BasicEligibility_Prior_8a_Involvement_Program_Participant_No");
                    break;
            }
        }
        Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
        // click any buttonbutton
        if (!SubmittedYesNo.equals(null) && !SubmittedYesNo.equals("")) {
            switch (SubmittedYesNo.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "BasicEligibility_Prior_8a_Involvement_Submitted_Yes");
                    setText_Element(webDriver, "BasicEligibility_Prior_8a_InvolvementSubmitted_Yes_Comment",
                        "QA");
                    break;
                case "no":
                    click_Element(webDriver, "BasicEligibility_Prior_8a_Involvement_Submitted_No");
                    break;
            }
        }
        Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
        // click any buttonbutton
        if (!AssetYesNo.equals(null) && !AssetYesNo.equals("")) {
            switch (AssetYesNo.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "BasicEligibility_Prior_8a_Involvement_firm_assets_Yes");
                    generic_file_Upld(webDriver);
            /*new newMppUploadDocumentPageDeepa(webDriver) .deepaUploadMppDocument(fixturesDir() + "Upload.pdf");*/

                    break;
                case "no":
                    click_Element(webDriver, "BasicEligibility_Prior_8a_Involvement_firm_assets_No");
                    break;
            }
        }
        Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
        // click any buttonbutton
        click_Element(webDriver, "Application_Common_Submit_Button");
    } catch (Exception e) {
        logger.info(e.toString());
        throw e;
    }
    }

    public static void BasicEligiblity_Outside_Assistance_Page(WebDriver webDriver, String YesNo) throws Exception {
        try {
            // Elements tag: @8a_Initial_Program Basic Eligiblity-Prior 8(a) Involvement
            if (!YesNo.equals(null) && !YesNo.equals("")) {
                switch (YesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_Outside_Assitance_Yes");
                        generic_file_Upld(webDriver);
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_Outside_Assitance_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any buttonbutton
            click_Element(webDriver, "Application_Common_Submit_Button");
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

    public static void BasicEligiblity_Business_Size_Page(WebDriver webDriver, String NAICSYesNo, String SizeYesNo) throws Exception {
        try {
            // Elements tag: @8a_Initial_Program Basic Eligiblity-Prior 8(a) Involvement
            if (!NAICSYesNo.equals(null) && !NAICSYesNo.equals("")) {
                switch (NAICSYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_Business_Size_NAICS_Yes");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_Business_Size_NAICS_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any buttonbutton
            if (!SizeYesNo.equals(null) && !SizeYesNo.equals("")) {
                switch (SizeYesNo.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "BasicEligibility_Business_Size_Determination_Yes");
                        break;
                    case "no":
                        click_Element(webDriver, "BasicEligibility_Business_Size_Determination_No");
                        break;
                }
            }
            Thread.sleep(1200);// Sleep Needed here as elements are dynamically moving by the time we
            // click any buttonbutton
            click_Element(webDriver, "Application_Common_Submit_Button");

        } catch (Exception e) {
            logger.info(e.toString());
            logger.info(e.toString());
            throw e;
        }
    }

    public static void BasicEligiblity_Size_Determination_Page(WebDriver webDriver) throws Exception {
        try {
            // Elements tag: @8a_Initial_Program Basic Eligiblity-Prior 8(a) Involvement
            generic_file_Upld(webDriver);
            new Select(find_Element(webDriver, "BasicEligibility_SBA_Office")).selectByIndex(1);
            setText_Element(webDriver, "BasicEligibility_determination_Date", "05/31/2017");
            click_Element(webDriver, "Application_Common_Submit_Button");
            accept_Alert(webDriver, 2);
            Thread.sleep(3000);
            click_Element(webDriver, "Application_Common_Submit_Button");
            accept_Alert(webDriver, 8);
            Thread.sleep(2000);
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

    public static void Business_Ownership_Entity_Ownership_Page(WebDriver webDriver, String yesno) throws Exception {
        try {
            // Elements tag: @8a_Initial_Business_Ownership -Entity_Ownership
            setText_Element(webDriver,"Business_ownership_Entity_Ownership_Individual","1");
            setText_Element(webDriver,"Business_ownership_Entity_Ownership_Other_Firms","1");
            setText_Element(webDriver,"Business_ownership_Entity_Ownership_AIT","1");
            setText_Element(webDriver,"Business_ownership_Entity_Ownership_ANC","1");
            setText_Element(webDriver,"Business_ownership_Entity_Ownership_CDC","1");
            setText_Element(webDriver,"Business_ownership_Entity_Ownership_NHO","1");
            if (!yesno.equals(null) && !yesno.equals("")) {
                switch (yesno.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "Business_ownership_Entity_Ownership_Appl_Yes");
                        generic_file_Upld(webDriver);
                        setText_Element(webDriver,"Business_ownership_Entity_Ownership_Appl_Yes_Text","qa");
                        break;
                    case "no":
                        click_Element(webDriver, "Business_ownership_Entity_Ownership_Appl_No");
                        break;
                }
            }
            // click any button
            click_Element(webDriver, "Application_Common_Submit_Button");
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

    public static void Business_Ownership_Ownership_Details_Page(WebDriver webDriver, String Appyesno,String Firmyesno,String Othyesnona,String Orgyesnona) throws Exception { try {
        // Elements tag: @8a_Initial_Business_Ownership -Entity_Ownership
        new Select(find_Element(webDriver, "Business_ownership_Ownership_Details_Prin_Owner")).selectByIndex(1);
        if (!Appyesno.equals(null) && !Appyesno.equals("")) {
            switch (Appyesno.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Business_ownership_Ownership_Details_Firms_Owner_Yes");
                    generic_file_Upld(webDriver);
                    setText_Element(webDriver,"Business_ownership_Ownership_Details_Firms_Owner_Yes_Text","qa");
                    break;
                case "no":
                    click_Element(webDriver, "Business_ownership_Ownership_Details_Firms_Owner_No");
                    break;
            }
        }
        if (!Firmyesno.equals(null) && !Firmyesno.equals("")) {
            switch (Firmyesno.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Business_ownership_Ownership_Details_Appl_Firm_Yes");
                    generic_file_Upld(webDriver);
                    setText_Element(webDriver,"Business_ownership_Ownership_Details_Firms_Owner_Yes_Text","qa");
                    break;
                case "no":
                    click_Element(webDriver, "Business_ownership_Ownership_Details_Appl_Firm_No");
                    break;
            }
        }
        if (!Othyesnona.equals(null) && !Othyesnona.equals("")) {
            switch (Othyesnona.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Business_ownership_Entity_Ownership_Oth_Firm_Yes");
                    generic_file_Upld(webDriver);
                    break;
                case "no":
                    click_Element(webDriver, "Business_ownership_Entity_Ownership_Oth_Firm_No");
                    break;
                case "N/A":
                    click_Element(webDriver, "Business_ownership_Entity_Ownership_Oth_Firm_NA");
                    break;
            }
        }
        if (!Orgyesnona.equals(null) && !Orgyesnona.equals("")) {
            switch (Orgyesnona.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Business_ownership_Entity_Ownership_Oth_Org_Yes");
                    generic_file_Upld(webDriver);
                    break;
                case "no":
                    click_Element(webDriver, "Business_ownership_Entity_OwnershipOth_Org_No");
                    break;
                case "N/A":
                    click_Element(webDriver, "Business_ownership_Entity_OwnershipOth_Org_NA");
                    break;
            }
        }
        // click any button
        click_Element(webDriver, "Application_Common_Submit_Button");
    } catch (Exception e) {
        logger.info(e.toString());
        throw e;
    }
    }
    public static void Business_Ownership_Corporations_Page(WebDriver webDriver) throws Exception {
        try {
            // Elements tag: @8a_Initial_Program-Business_ownership-Corporation
            generic_file_Upld(webDriver,"Business_ownership_Cooperations_Up1_Attach_All");
            generic_file_Upld(webDriver,"Business_ownership_Relvant_Up1_Attach_All");
            generic_file_Upld(webDriver,"Business_ownership_AppFirm_Up1_Attach_All");
            click_Element(webDriver, "Application_Common_Submit_Button");
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

    public static void character_Page(WebDriver webDriver, String fdyesno,String Finyesno,String layesno,String bankyesno) throws Exception {
        try {
            // Elements tag: @8a_Initial_ character_Page
            if (!fdyesno.equals(null) && !fdyesno.equals("")) {
                switch (fdyesno.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver,
                            "Character_appl_firm_Federal_entity_Yes");
                        generic_file_Upld(webDriver);
                        break;
                    case "no":
                        click_Element(webDriver,
                            "Character_appl_firm_Federal_entity_No");
                        break;
                }
            }
            if (!Finyesno.equals(null) && !Finyesno.equals("")) {
                switch (Finyesno.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver,
                            "Character_financial_obligations_Yes");
                        generic_file_Upld(webDriver);
                        break;
                    case "no":
                        click_Element(webDriver, "Character_financial_obligations_No");
                        break;
                }
            }
            if (!layesno.equals(null) && !layesno.equals("")) {
                switch (layesno.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "Character_pending_lawsuit_Yes");
                        generic_file_Upld(webDriver);
                        break;
                    case "no":
                        click_Element(webDriver, "Character_pending_lawsuit_No");
                        break;

                }
            }
            if (!bankyesno.equals(null) && !bankyesno.equals("")) {
                switch (bankyesno.toLowerCase()) {
                    case "yes":
                        click_Element(webDriver, "Character_bankruptcy_Yes");
                        generic_file_Upld(webDriver);
                        break;
                    case "no":
                        click_Element(webDriver, "Character_bankruptcy_No");
                        break;
                }
            }
            // click any button
            click_Element(webDriver, "Application_Common_Submit_Button");
        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

    public static void control_Page_Firm_Control(WebDriver webDriver, String existAgree, String bondSupport, String firmsProvide, String disad, String coLocated, String leaseOther ) throws Exception {
            /*Elements tag: Potntial Sucess*/
        if (!existAgree.equals(null) && !existAgree.equals("")) {
            switch (existAgree.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Exist_Agree_Yes");
                    generic_file_Upld(webDriver, "Control_Page_Firm_Control_Exist_Agree_Yes_Attach_All");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Exist_Agree_No");
                    break;

            }
        }
        if (!bondSupport.equals(null) && !bondSupport.equals("")) {
            switch (bondSupport.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Bond_Supp_Yes");
                    generic_file_Upld(webDriver, "Control_Page_Firm_Control_Bond_Supp_Yes_Attach_All");
                    setText_Element(webDriver, "Control_Page_Firm_Control_Bond_Supp_Yes_Comment", "SomeValue");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Bond_Supp_No");
                    break;

            }
        }

        if (!firmsProvide.equals(null) && !firmsProvide.equals("")) {
            switch (firmsProvide.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Provide_Yes");
                    generic_file_Upld(webDriver, "Control_Page_Firm_Control_Firm_Provide_Yes_Attach_All");
                    setText_Element(webDriver, "Control_Page_Firm_Control_Firm_Provide_Yes_Comment", "SomeValue");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Provide_No");
                    break;

            }
        }

        if (!disad.equals(null) && !disad.equals("")) {
            switch (disad.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Disad_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Disad_No");
                    setText_Element(webDriver, "Control_Page_Firm_Control_Firm_Disad_No_Comment", "SomeValue");
                    break;
                case "na":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Disad_NA");
                    break;

            }
        }

        generic_file_Upld(webDriver, "Control_Page_Firm_Control_Bank_Account_Signature_Attach_All");

        if (!coLocated.equals(null) && !coLocated.equals("")) {
            switch (coLocated.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_CoLocate_Yes");
                    generic_file_Upld(webDriver, "Control_Page_Firm_Control_Firm_CoLocate_Yes_Attach_All");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_CoLocate_No");
                    break;

            }
        }

        if (!leaseOther.equals(null) && !leaseOther.equals("")) {
            switch (leaseOther.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Lease_Other_Yes");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Lease_Other_No");
                    break;
            }
        }

        click_Element(webDriver, "Application_Common_Section_Submit_Button_Id");
    }

    public static void control_Page_Leased_Facility(WebDriver webDriver, String leased_facility) throws Exception  {

        if (!leased_facility.equals(null) && !leased_facility.equals("")) {
            switch (leased_facility.toLowerCase()) {
                case "yes":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Leased_Facility_Yes");
                    setText_Element(webDriver, "Control_Page_Firm_Control_Firm_Leased_Facility_Yes_Comment", "SomeValue");
                    break;
                case "no":
                    click_Element(webDriver, "Control_Page_Firm_Control_Firm_Leased_Facility_No");
                    break;

            }
        }

        click_Element(webDriver, "Application_Common_Section_Submit_Button_Id");
    }

    public static void master8aApp_final_ReviewSign(WebDriver webDriver) throws Exception  {
        try {
            click_Element(webDriver,"8a_MasterApp_ReviewSign_Button");
            click_Element(webDriver, "8a_AllApp_Signature_id");
            click_Element(webDriver,"Application_Common_Submit_Button");

        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }
    public static void contributorsubApp_8aDisAdvInd(WebDriver webDriver) throws Exception  {
        try {
            disAdvApp_Gender_Info_Page(webDriver, "Male");
            disAdvApp_MaritalStatus_Page(webDriver, "Married");
            disAdvApp_SocialSecNum_Page(webDriver, "12345678");
            disAdvApp_ContactInfo_Page(webDriver, "12345678");
            disAdvApp_CuurentHomeAddress_Page(webDriver, "mclean", "mclean", "AL", "10002", "US", "01/01/2019");
            disAdvApp_LengthofResidency_Page(webDriver, "yes");
            disAdvApp_DateandPlaceofBirth_Page(webDriver, "01/01/2019", "Mclean", "India");
            disAdvApp_Us_Citizenship_Page(webDriver, "yes");
            /*generic_file_Upld(webDriver);*/
            /*click_Element(webDriver, "Application_Common_Continue_Button");*/
            disAdvApp_UploadResume_Page(webDriver);
            disAdvApp_Appl_Firm_Ownership_Page(webDriver, "80", "Anything");
           disAdvApp_Bank_Acct_Access_Page(webDriver, "yes", "Anything");
            disAdvApp_Full_Time_Devotion_Page(webDriver, "yes");
            disAdvApp_Business_Affiliations_Page(webDriver, "yes", "yes", "something To Test");
            disAdvApp_8a_Prior_Involvement_Page(webDriver, "yes", "yes", "yes");
            disAdvApp_8a_Federal_Employment_Page(webDriver, "yes");
            disAdvApp_8a_Household_Federal_Employment_Page(webDriver, "yes");
            disAdvApp_8a_Financial_Page(webDriver, "yes", "yes", "yes", "yes");
            disAdvApp_8a_Criminal_History_Page(webDriver, "yes", "Anything", "yes", "yes", "yes");
            disAdvApp_criminal_Hist_Doc_Page(webDriver);
            disAdvApp_Basic_Of_Disadvantage_Page(webDriver, "Black American", "Anything");
            disAdvApp_Social_Narrative_Page(webDriver);
            disAdvApp_Transfer_Assets_Page(webDriver, "Yes", "Anything");
           disAdvApp_Tax_Returns_Page(webDriver);
            disAdvApp_financial_CashOnHand_Page(webDriver, "01/01/2019", "111", "111", "111");
            disAdvApp_financial_OtherSource_Page(webDriver, "111", "111", "Anything", "111", "111");
            disAdvApp_financial_Notes_Receivable_Page(webDriver, "Yes");
            disAdvApp_financial_Retirement_Account_Page(webDriver, "Yes", "Yes");
           disAdvApp_financial_Life_Insurance_Page(webDriver,"Yes","Yes");
            disAdvApp_financial_StocksAndBonds_Page(webDriver,"Yes");
            disAdvApp_financial_RealEstate_Page(webDriver, "Yes", "Yes", "Yes", "Yes", "Yes",
                "Yes");
            disAdvApp_financial_RealEstateOther_Page(webDriver, "Yes", "Yes", "Yes", "Yes", "Yes",
                "Yes");
            disAdvApp_financial_Personal_Property_Page(webDriver, "Yes", "Yes");
            disAdvApp_financial_NotesPayableandOther_Page(webDriver, "Yes");
            disAdvApp_financial_Assessed_Taxes_Page(webDriver, "Yes");
            // Personal summary Report
           disAdvApp_financial_PersonalSummary_Page(webDriver);
            disAdvApp_financial_PrivacyStatements_Page(webDriver);
            disAdvApp_financial_Review_Page(webDriver);
           disAdvApp_Signature_Page(webDriver);

        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }
    public static void contributorsubApp_8aSpouse(WebDriver webDriver) throws Exception  {
        try {
            spousesubapp_Gender_Info_Page(webDriver, "Male");
            spousesubapp_MaritalStatus_Page(webDriver, "Married");
            spousesubapp_SocialSecNum_Page(webDriver, "12345678");
            spousesubapp_ContactInfo_Page(webDriver, "12345678");
            spousesubapp_CuurentHomeAddress_Page(webDriver, "mclean", "mclean", "AL", "10002", "US", "01/01/2019");
            spousesubapp_Role_Appl_firm_Page(webDriver,"yes");
            spousesubapp_LengthofResidency_Page(webDriver,"no");
            spousesubapp_PreviousHomeAddress_Page(webDriver,"yes","11220","mclean","DC","10002","US");
            spousesubapp_DateandPlaceofBirth_Page(webDriver, "01/01/2019", "Mclean", "India");
            spousesubapp_Us_Citizenship_Page(webDriver, "no");
            spousesubapp_Resident_Alien_Page(webDriver,"yes");
            /*generic_file_Upld(webDriver);*/
            /*click_Element(webDriver, "Application_Common_Continue_Button");*/
            spousesubapp_UploadResume_Page(webDriver);
            spousesubapp_Appl_Firm_Ownership_Page(webDriver, "80", "Anything");
            spousesubapp_Bank_Acct_Access_Page(webDriver, "yes", "Anything");
            spousesubapp_Prior_Ownership_Page(webDriver, "yes","Anything","yes");
            spousesubapp_Business_Affiliations_Page(webDriver, "yes", "yes", "something To Test");
            spousesubapp_8a_Prior_Involvement_Page(webDriver, "yes", "yes", "yes");
            spousesubapp_8a_Federal_Employment_Page(webDriver, "yes");
            spousesubapp_8a_Financial_Page(webDriver, "yes", "yes", "yes", "yes");
            spousesubapp_8a_Criminal_History_Page(webDriver, "yes", "Anything", "yes", "yes", "yes");
            spousesubapp_criminal_Hist_Doc_Page(webDriver);
            spousesubapp_Tax_Returns_Page(webDriver);
            spousesubapp_financial_CashOnHand_Page(webDriver, "01/01/2019", "111", "111", "111");
            spousesubapp_financial_OtherSource_Page(webDriver, "111", "111", "Anything", "111", "111");
            spousesubapp_financial_Notes_Receivable_Page(webDriver, "Yes");
            spousesubapp_financial_Retirement_Account_Page(webDriver, "Yes", "Yes");
            spousesubapp_financial_Life_Insurance_Page(webDriver,"Yes","Yes");
            spousesubapp_financial_StocksAndBonds_Page(webDriver,"Yes");
            spousesubapp_financial_RealEstate_Page(webDriver, "Yes", "Yes", "Yes", "Yes", "Yes",
                "Yes");
            spousesubapp_financial_RealEstateOther_Page(webDriver, "Yes", "Yes", "Yes", "Yes", "Yes",
                "Yes");
            spousesubapp_financial_Personal_Property_Page(webDriver, "Yes", "Yes");
            spousesubapp_financial_NotesPayableandOther_Page(webDriver, "Yes");
            spousesubapp_financial_Assessed_Taxes_Page(webDriver, "Yes");
            // Personal summary Report
            spousesubapp_financial_PersonalSummary_Page(webDriver);
            spousesubapp_financial_PrivacyStatements_Page(webDriver);
            spousesubapp_financial_Review_Page(webDriver);
            spousesubapp_Signature_Page(webDriver);

        } catch (Exception e) {
            logger.info(e.toString());
            throw e;
        }
    }

}
