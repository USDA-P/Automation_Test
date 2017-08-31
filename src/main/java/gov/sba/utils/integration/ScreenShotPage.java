package gov.sba.utils.integration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotPage {
  private static final Logger logger = LogManager.getLogger(ScreenShotPage.class.getName());
  WebDriver webDriver;

  public ScreenShotPage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void ScreenShot() throws Exception {
    // Take screenshot and store as a file format

		File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
	    try {
      // now copy the screenshot to desired location using copyFile method

      FileUtils.copyFile(src, new File("C:/SbaProject/sba-automation-develop/MontanaScreenShots/"
          + System.currentTimeMillis() + ".png"));
    }

    catch (IOException e) {
      logger.info(e.getMessage());

      {

        System.out.println(e.getMessage());

      }

    }

  }
}
