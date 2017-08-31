// TS_Created_By_Deepa_Patri
package gov.sba.utils.integration;

import gov.sba.automation.CommonApplicationMethods;
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

@Category({gov.sba.utils.integration.StableTests.class})

public class TestWorkflowAppMppPrepareLinkAndCopyUdates extends TestCase {
  private static final Logger logger =
      LogManager.getLogger(TestWorkflowAppMppPrepareLinkAndCopyUdates.class);
  private static WebDriver webDriver;

  @Before
  public void setUp() throws Exception {
    get_Stop_Execution_Flag();
    clear_Env_Chrome();
    webDriver = set_Timeouts(TestHelpers.getDefaultWebDriver());
    webDriver.get(TestHelpers.getBaseUrl());
  }

  @Test
  public void testWorkflowAppMppPrepareLinkAndCopyUdates() throws Exception {

    try {
      String expected_Text;
      navigationMenuClickNewQA(webDriver, "Prepare");
      /* Check the Top part of the text for MPP Link */

      expected_Text = "All Small Mentor-Protégé Program Preparation Checklist";
      assertEquals(expected_Text, find_Element(webDriver, "id", "mpp-anc").getText());
      click_Element(webDriver, "xpath", "//a[contains( @href , '#mpp-anc' )]");

      /* Check the bottom part of the text for MPP Link */
      expected_Text =
          " A Mentor-Protégé relationship should be established before starting the application – this is not a matching program. The Protégé firm must meet the size standard for small in the NAICS code in which they are seeking business development assistance.";
      String xpath = "//p [ contains( text(), 'replace_Text') ]";
      find_Element(webDriver, "xpath", xpath.replace("replace_Text", expected_Text));

    } catch (Exception e) {
      logger.info("Link is not present" + e.toString());
      CommonApplicationMethods.take_ScreenShot_TestCaseName(webDriver,
          new String[] {TestWorkflowAppMppPrepareLinkAndCopyUdates.class.getName(), "Exception"});
      throw e;
    }
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
  }

}
