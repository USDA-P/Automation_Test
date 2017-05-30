/**
 * Created by deepa on 5/15/2017.
 */
package gov.sba.pageObjetcs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static gov.sba.automation.CommonApplicationMethods.click_Element;
import static gov.sba.automation.CommonApplicationMethods.navigationMenuClick;

public class programs_Page {

    public static void select_MyCertifications_Table(WebDriver webDriver, String which_Cert) throws Exception {
        //  Elements Tags: @My_Contracting_Programs
        if (!which_Cert.equals(null) && !which_Cert.equals("")) {
            switch (which_Cert) {
                case "8a_Initial_Program":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Create_App_8a_Inital");
                    break;
                case "EDWOSB_Self_Cert":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Create_App_EDWOSB");
                    break;
                case "WOSB_Self_Cert":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Create_App_WOSB");
                    break;
                case "MPP_Program":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Create_App_MPP");
                    break;
                case "8a_Upload":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Create_App_8a_upload");
                    break;
                case "Delete_8a_Initial_Draft":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Delete_App_8a_Inital_Delete");
                    break;
                case "Delete_EDWOSB_Draft":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Delete_App_EDWOSB_Delete");
                    break;
                case "Delete_WOSB_Draft":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Delete_App_WOSB_Delete");
                    break;
                case "Delete_MPP_Draft":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Delete_App_MPP_Delete");
                    break;
                case "Delete_8a_UpD_Draft":
                    click_Element(webDriver, "SBA_My_Cont_Pgm_Delete_App_8a_upload_Delete");
                    break;
            }
        }



    }

    public static void select_MyCertifications_Links(WebDriver webDriver, String which_Cert) throws Exception {
        //Elements Tags: @Links_Under_DashBoard
        if (!which_Cert.equals(null) && !which_Cert.equals("")) {
            switch (which_Cert) {
                case "WOSB_Self_Cert":
                    click_Element(webDriver, "SBA_Certificate_Links_Wosb");
                    break;
                case "EDWOSB_Self_Cert":
                    click_Element(webDriver, "SBA_Certificate_Links_EdWosb");
                    break;
                case "MPP":
                    click_Element(webDriver, "SBA_Certificate_Links_Mpp");
                    break;
                case "8a_Upload":
                    click_Element(webDriver, "SBA_Certificate_Links_8ADocUpload");
                    break;
            }
        }

    }

    public static void join_New_Program_CheckBoxes(WebDriver webDriver, String which_Cert) throws Exception {
        //  Elements tag: @Join_New_Program_Page
        if (!which_Cert.equals(null) && !which_Cert.equals("")) {
            navigationMenuClick(webDriver, "Programs");
            switch (which_Cert.toUpperCase()) {
                case "EDWOSB":
                    click_Element(webDriver, "JoinNewPgm_Create_App_EDWOSB");
                    break;
                case "WOSB":
                    click_Element(webDriver, "JoinNewPgm_Create_App_WOSB");
                    break;
                case "MPP":
                    click_Element(webDriver, "JoinNewPgm_Create_App_MPP");
                    break;
                case "8A":
                    click_Element(webDriver, "JoinNewPgm_Create_App_8A");
                    break;
                default:
                    Assert.assertEquals("Edwosb or WOSB or MPP or 8a", "Not Found");
                    break;
            }
            Thread.sleep(1500); // Needed - Deepa, Figuring Enabled click
            click_Element(webDriver, "JoinNewPgm_Add_Cert");
            click_Element(webDriver, "Application_Common_Accept_Button");
        }


    }

}
