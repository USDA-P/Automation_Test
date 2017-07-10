package gov.sba.pageObjetcs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static gov.sba.automation.CommonApplicationMethods.*;

public class TestCreateVendorUser {
    private static final Logger logger = LogManager.getLogger(TestCreateVendorUser.class.getName());
    public static void createVendorUser(WebDriver webDriver, String FName,String LName, String Email, String StPswd) throws Exception {
        try {
            click_Element(webDriver, "SBA_GetStarted_Login");
            setText_Element(webDriver, "SBA_First_Name", FName);
            setText_Element(webDriver, "SBA_Last_Name", LName);
            setText_Element(webDriver, "SBA_Email_Address", Email);
            setText_Element(webDriver, "SBA_Confirm_Email", Email);
            click_Element(webDriver, "SBA_Create_Continue");
                /* test with incorrect email address*/
                /* */
            setText_Element(webDriver, "SBA_Login_Pwd", StPswd);
            setText_Element(webDriver, "SBA_Confirm_Password", StPswd);
            click_Element(webDriver, "SBA_Accept_CheckBox");
            webDriver.switchTo().frame(find_Element(webDriver, "xpath", "//iframe[contains(@title,'recaptcha widget')]"));
            click_Element(webDriver, "SBA_Recaptcha");
            Thread.sleep(1800); /*Sleep for the JS to complete*/
            webDriver.switchTo().defaultContent();
            click_Element(webDriver, "SBA_Create_Account");
            Thread.sleep(1800);
            logger.info(find_Element(webDriver, "SBA_verify_Account").getText());

        } catch (Exception e) {
            logger.info(e.toString());
            take_ScreenShot_TestCaseName(webDriver,
                new String[] {"TestCreateVendorUser", "Exception"});
            throw e;
        }
    }
    public static void activateEmail(WebDriver webDriver_01, String Email) throws Exception {
        try {
            webDriver_01.get("https://www.mailinator.com/");
            setText_Element(webDriver_01,"Mailinator_Input_ID", Email);
            find_Element(webDriver_01,"Mailinator_Input_ID").sendKeys(Keys.ENTER);
            click_Element(webDriver_01,"Malinator_Activate");
            Thread.sleep(1800);
            webDriver_01.switchTo().frame("publicshowmaildivcontent");
            click_Element(webDriver_01,"Activate_Account");

        } catch (Exception e) {
            logger.info(e.toString());
            take_ScreenShot_TestCaseName(webDriver_01, new String[]{"TestCreateVendorUser", "Exception"});
            throw e;
        }
}


}
