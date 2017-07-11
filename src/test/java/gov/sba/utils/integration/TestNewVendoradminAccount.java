package gov.sba.utils.integration;


import gov.sba.automation.TestHelpers;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.pageObjetcs.TestCreateVendorUser.activateEmail;
import static gov.sba.pageObjetcs.TestCreateVendorUser.createVendorUser;


public class TestNewVendoradminAccount extends TestCase {
    String name = TestNewVendoradminAccount.class.getName();
    Logger logger = LogManager.getLogger(name);
    private static WebDriver webDriver;
    int stop_Exec = 1;
    String  Email;

    @Before public void setUp() throws Exception {
        get_Stop_Execution_Flag();
        clear_Env_Chrome();
        TestHelpers.set_Headless();
        webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver(), 10, 10,10);
        webDriver.get(TestHelpers.getBaseUrl());
    }

    @Test
    public void testMainTest() throws Exception {
        try {

            /*Create New Vendor*/
            Email = "Deepa.test." + get_currentTimestamp() +"@mailinator.com";
            createVendorUser(webDriver,"Deepa","test1", Email,"Deepa.test2@mailinator.com");
            /*Activate the Account*/
            activateEmail(TestHelpers.getDefaultWebDriver(), Email);
            /* Re login with the account to verify its activated */

        }catch (Exception e){
            take_ScreenShot_TestCaseName(webDriver, new String[] {name, "Exception"});
            throw e;
        }

    }
}
