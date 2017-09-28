// TS_Created_By_Deepa_Patri
package gov.sba.utils.integration;

import gov.sba.automation.CommonApplicationMethods;
import gov.sba.automation.FixtureUtils;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.PrintWriter;
//delete_Any_File_For_Headless

@Category({gov.sba.utils.integration.StableTests.class})
public class TestXxxxxFinalCleanUp {

  @Before
  public void setUp() throws Exception {}

  @Test
  public static void testXxxxxFinalCleanUp() throws Exception {
    PrintWriter writer = new PrintWriter(FixtureUtils.rootDirExecutionFile(), "UTF-8");
    writer.println("Should_Execution_Stop: \"False\"");
    writer.close();
    CommonApplicationMethods.delete_Any_File_For_Headless();
   // CommonApplicationMethods.delete_Any_File(FixtureUtils.fixturesDir() + "test8asubmission_output.txt");
  }

  @After
  public void tearDown() throws Exception {

  }
}
