/* Created by deepa on 5/15/2017. */

package gov.sba.pageObjetcs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

import static gov.sba.automation.CommonApplicationMethods.*;

public class ProgramsPage {

  public static void select_MyCertifications_Table(WebDriver webDriver, String which_Cert)
      throws Exception {
    // Elements Tags: @My_Contracting_Programs
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

  public static void select_MyCertifications_Links(WebDriver webDriver, String which_Cert)
      throws Exception {
    // Elements Tags: @Links_Under_DashBoard
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

  public static void join_New_Program_CheckBoxes(WebDriver webDriver, String which_Cert)
      throws Exception {
    // Elements tag: @Join_New_Program_Page
    if (!which_Cert.equals(null) && !which_Cert.equals("")) {
      //navigationMenuClick(webDriver, "Programs");
      navigationClick(webDriver,"Programs");
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
      click_Element(webDriver, "JoinNewPgm_Add_Cert");
      click_Element(webDriver, "Application_Common_Accept_Button");
    }


  }

  public static void generic_file_Upld(WebDriver webDriver) throws Exception {
    // Elements Tags: @Generic file attach-upload
    try {
      click_Element(webDriver, "File_Up1_Add_Req");
      Thread.sleep(800);
      click_Element(webDriver, "File_Up1_Choose_Doc_Library");
      Thread.sleep(800);
      click_Element(webDriver, "File_Up1_Choose_Doc");
      Thread.sleep(900);
      click_Element(webDriver, "File_Up1_Associate_Button");
      Thread.sleep(600);
      /*
       * Between file association and some JS execution we need time. Both before and after JHS the
       * button is still valid. But if we click sooner than its failing
       */

      Actions actions = new Actions(webDriver);

      //actions.moveToElement(find_Element(webDriver, "Application_Common_Submit_Button")).click().perform();
      click_Element(webDriver, "Application_Common_Submit_Button");

      click_Element(webDriver, "Application_Common_Submit_Button");
      Thread.sleep(900);
    } catch (Exception e) {
      throw e;
    }
  }

  public static void generic_file_Upld(WebDriver webDriver, String add_File_Locator)
      throws Exception {
    // Elements Tags: @Generic file attach-upload
    try {
      Map locator = getLocator(add_File_Locator);

      click_Element(webDriver, "xpath", locator.get("L1").toString());
      Thread.sleep(800);
      click_Element(webDriver, "xpath", locator.get("L2").toString());
      Thread.sleep(800);
      click_Element(webDriver, "xpath", locator.get("L3").toString());
      Thread.sleep(900);
      click_Element(webDriver, "xpath", locator.get("L4").toString());
      Thread.sleep(900);
    } catch (Exception e) {
      throw e;
    }
  }


  public static void contributor_Spouse_login(WebDriver webDriver, String FullName,
      String EmailAddress) throws Exception {
    // Elements Tags: @Generic file attach-upload
    try {
      setText_Element(webDriver, "Contributor_Login_FullName_8a_Spouse", FullName);
      setText_Element(webDriver, "Contributor_Login_EmailAddress_8a_Spouse", EmailAddress);
      click_Element(webDriver, "Contributor_Login_Button_8a_Spouse");
    } catch (Exception e) {
      throw e;
    }
  }

  public static void contributor_Disadv_login(WebDriver webDriver, String FullName,
      String EmailAddress) throws Exception {
    // Elements Tags: @Generic file attach-upload
    try {
      setText_Element(webDriver, "Contributor_Login_FullName_8a_Disadv", FullName);
      setText_Element(webDriver, "Contributor_Login_EmailAddress_8a_Disadv", EmailAddress);
      click_Element(webDriver, "Contributor_Login_Button_8a_Disadv");
    } catch (Exception e) {
      throw e;
    }
  }

  public static void contributor_BusinessPartner_login(WebDriver webDriver, String FullName,
      String EmailAddress) throws Exception {
    // Elements Tags: @Generic file attach-upload
    try {
      setText_Element(webDriver, "Contributor_Login_FullName_8a_BusinessPartner", FullName);
      setText_Element(webDriver, "Contributor_Login_EmailAddress_8a_BusinessPartner", EmailAddress);
      click_Element(webDriver, "Contributor_Login_Button_8a_BusinessPartner");
    } catch (Exception e) {
      throw e;
    }
  }
}


