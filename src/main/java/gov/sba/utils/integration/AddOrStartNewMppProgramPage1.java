package gov.sba.utils.integration;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.TestCase;

public class AddOrStartNewMppProgramPage1 extends TestCase {

  private static final Logger logger =
      LogManager.getLogger(AddOrStartNewMppProgramPage1.class.getName());
  WebDriver webDriver;

  public AddOrStartNewMppProgramPage1(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void AddOrStartNewMppProgram() throws Exception {
    String Actual_Text = null;
    String Expected_Text = null;
    // Verify for active certification on the dashboard.
    if (webDriver.getPageSource().contains("Pending")) {
      logger.info("There is (are) an active certification on the dashboard");
      // Click on the certification link.
      webDriver.findElement(By.xpath("//li[2]/a/span")).click();
      Actual_Text = webDriver.findElement(By.xpath("//h1[2]")).getText();
      Expected_Text = "Join a new program";
      assertEquals(Actual_Text, Expected_Text);
      // Click on the add new certification button.
      Actions act1 = new Actions(webDriver);
      act1.doubleClick(webDriver.findElement(By.id("certificate_type_mpp"))).build().perform();
      webDriver.findElement(By.id("add_certification")).click();
      // Verify and validate the terms for the certification.
      Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
      Expected_Text = "Purpose:";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
      Expected_Text =
          "The All Small Business Mentor-Protégé Program (MPP) is designed to enhance the capabilities of protégé firms by requiring approved mentors to provide business development assistance to protégé firms and to improve protégé firms’ ability to successfully compete for federal contracts. This assistance may include:";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text =
          webDriver.findElement(By.cssSelector("div.usa-width-three-fourths > ul > li")).getText();
      Expected_Text = "technical and/or management assistance";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[2]")).getText();
      Expected_Text = "financial assistance in the form of equity investments and/or loans";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[3]")).getText();
      Expected_Text =
          "subcontracts (either from the Mentor to the Protégé or from the Protégé to the Mentor)";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[4]")).getText();
      Expected_Text =
          "and/or assistance in performing prime contracts with the Government through joint venture arrangements.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[2]")).getText();
      Expected_Text =
          "Mentors are encouraged to provide assistance relating to the performance of contracts set aside or reserved for small business so that protégé firms may more fully develop their capabilities.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/h4[2]")).getText();
      Expected_Text = "Instructions:";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[3]")).getText();
      Expected_Text =
          "A Mentor-Protégé relationship should be established before starting this application – this is not a matching program. The Protégé firm must provide the following information and any supporting documentation in PDF format in order to complete the MPP application process.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/h4[3]")).getText();
      Expected_Text = "Disclaimer:";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[4]")).getText();
      Expected_Text =
          "Please read the following certification statements. The Federal government relies on the information in this form and any documents or supplemental information submitted to determine whether the business is eligible to participate in the All Small Business Mentor-Protégé Program. The definition of the terms used in this certification are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR Part 124.520 and 125.9), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person signing this certification may be prosecuted if they have provided false information. Any action taken with respect to this certification does not affect the Government’s right to pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
      assertEquals(Actual_Text, Expected_Text);
      // Verify links on the table.
      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String main_window = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("Mentor-Protégé Program training module")).click();
      assertEquals(Actual_Text, Expected_Text);
      java.util.Set<String> S1 = webDriver.getWindowHandles();
      Iterator<String> i1 = S1.iterator();
      while (i1.hasNext()) {
        String Second_window = i1.next();
        if (!main_window.equalsIgnoreCase(Second_window)) {
          webDriver.switchTo().window(Second_window);
          logger.info("After switching title is = certify.sba.gov");
          webDriver.close();
          webDriver.switchTo().window(main_window);
          logger.info("Back to manin_window = certify.sba.gov");
        } else {
          logger.info("Second Window is not thesame as first window");

        }
      }
      Thread.sleep(2000);
      // Verify the SAM.gov link.
      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      String main_window2 = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("SAM.gov")).click();
      assertEquals(Actual_Text, Expected_Text);
      java.util.Set<String> S2 = webDriver.getWindowHandles();
      Iterator<String> i2 = S2.iterator();
      while (i2.hasNext()) {
        String Second_window1 = i2.next();
        if (!main_window2.equalsIgnoreCase(Second_window1)) {
          webDriver.switchTo().window(Second_window1);
          logger.info("After switching title is =" + webDriver.getTitle());
          webDriver.close();
          webDriver.switchTo().window(main_window2);
          logger.info("Back to manin_window = certify.sba.gov");
        } else {
          logger.info("Second Window is not thesame as first window");
        }
        Thread.sleep(2000);
        webDriver.findElement(By.name("commit")).click();
      }

    } else {
      if (webDriver.getPageSource().contains("Active")) {
        logger.info("There is (are) an active certification on the dashboard");
        // Click on the certification link.
        webDriver.findElement(By.xpath("//li[2]/a/span")).click();
        Actual_Text = webDriver.findElement(By.xpath("//h1[2]")).getText();
        Expected_Text = "Join a new program";
        assertEquals(Actual_Text, Expected_Text);
        // Click on the add new certification button.
        Actions act1 = new Actions(webDriver);
        act1.doubleClick(webDriver.findElement(By.id("certificate_type_mpp"))).build().perform();
        webDriver.findElement(By.id("add_certification")).click();
        // Verify and validate the terms for the certification.
        Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
        Expected_Text = "Purpose:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
        Expected_Text =
            "The All Small Business Mentor-Protégé Program (MPP) is designed to enhance the capabilities of protégé firms by requiring approved mentors to provide business development assistance to protégé firms and to improve protégé firms’ ability to successfully compete for federal contracts. This assistance may include:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.cssSelector("div.usa-width-three-fourths > ul > li"))
            .getText();
        Expected_Text = "technical and/or management assistance";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[2]")).getText();
        Expected_Text = "financial assistance in the form of equity investments and/or loans";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[3]")).getText();
        Expected_Text =
            "subcontracts (either from the Mentor to the Protégé or from the Protégé to the Mentor)";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[4]")).getText();
        Expected_Text =
            "and/or assistance in performing prime contracts with the Government through joint venture arrangements.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[2]")).getText();
        Expected_Text =
            "Mentors are encouraged to provide assistance relating to the performance of contracts set aside or reserved for small business so that protégé firms may more fully develop their capabilities.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/h4[2]")).getText();
        Expected_Text = "Instructions:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[3]")).getText();
        Expected_Text =
            "A Mentor-Protégé relationship should be established before starting this application – this is not a matching program. The Protégé firm must provide the following information and any supporting documentation in PDF format in order to complete the MPP application process.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/h4[3]")).getText();
        Expected_Text = "Disclaimer:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[4]")).getText();
        Expected_Text =
            "Please read the following certification statements. The Federal government relies on the information in this form and any documents or supplemental information submitted to determine whether the business is eligible to participate in the All Small Business Mentor-Protégé Program. The definition of the terms used in this certification are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR Part 124.520 and 125.9), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person signing this certification may be prosecuted if they have provided false information. Any action taken with respect to this certification does not affect the Government’s right to pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
        assertEquals(Actual_Text, Expected_Text);
        // Verify links on the table.
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String main_window = webDriver.getWindowHandle();
        logger.info("Before switching, title is = certify.sba.gov");
        webDriver.findElement(By.linkText("Mentor-Protégé Program training module")).click();
        assertEquals(Actual_Text, Expected_Text);
        java.util.Set<String> S1 = webDriver.getWindowHandles();
        Iterator<String> i1 = S1.iterator();
        while (i1.hasNext()) {
          String Second_window = i1.next();
          if (!main_window.equalsIgnoreCase(Second_window)) {
            webDriver.switchTo().window(Second_window);
            logger.info("After switching title is = certify.sba.gov");
            webDriver.close();
            webDriver.switchTo().window(main_window);
            logger.info("Back to manin_window = certify.sba.gov");
          } else {
            logger.info("Second Window is not thesame as first window");

          }
        }
        Thread.sleep(2000);
        // Verify the SAM.gov link.
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String main_window2 = webDriver.getWindowHandle();
        logger.info("Before switching, title is = certify.sba.gov");
        webDriver.findElement(By.linkText("SAM.gov")).click();
        assertEquals(Actual_Text, Expected_Text);
        java.util.Set<String> S2 = webDriver.getWindowHandles();
        Iterator<String> i2 = S2.iterator();
        while (i2.hasNext()) {
          String Second_window1 = i2.next();
          if (!main_window2.equalsIgnoreCase(Second_window1)) {
            webDriver.switchTo().window(Second_window1);
            logger.info("After switching title is =" + webDriver.getTitle());
            webDriver.close();
            webDriver.switchTo().window(main_window2);
            logger.info("Back to manin_window = certify.sba.gov");
          } else {
            logger.info("Second Window is not thesame as first window");
          }
          Thread.sleep(2000);
          webDriver.findElement(By.name("commit")).click();
        }

      } else {
        Actual_Text = webDriver
            .findElement(By.xpath("//article[@id='main-content']/section/article/div/div[2]"))
            .getText();
        Expected_Text =
            "Get started now on your WOSB self-certification, EDWOSB self-certification, All Small Business Mentor-Protégé agreement, or 8(a) Document Upload.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.cssSelector("div.usa-font-lead")).getText();
        Expected_Text =
            "To get started on an application, select which program you'd like to join below. You may only upload documents to certify.SBA.gov during the application process. While completing the online questionnaire, you will be instructed to upload documents to support your answers. These online applications replace any forms released by SBA for these contracting programs in the past.";
        assertEquals(Actual_Text, Expected_Text);
        // Click on the WOSB link.
        webDriver.findElement(By.linkText("All Small Business Mentor-Protégé agreement")).click();
        // Verify and validate the terms for the certification.
        Actual_Text = webDriver.findElement(By.cssSelector("h4")).getText();
        Expected_Text = "Purpose:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.xpath("//form/div/div/p")).getText();
        Expected_Text =
            "The All Small Business Mentor-Protégé Program (MPP) is designed to enhance the capabilities of protégé firms by requiring approved mentors to provide business development assistance to protégé firms and to improve protégé firms’ ability to successfully compete for federal contracts. This assistance may include:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver.findElement(By.cssSelector("div.usa-width-three-fourths > ul > li"))
            .getText();
        Expected_Text = "technical and/or management assistance";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[2]")).getText();
        Expected_Text = "financial assistance in the form of equity investments and/or loans";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[3]")).getText();
        Expected_Text =
            "subcontracts (either from the Mentor to the Protégé or from the Protégé to the Mentor)";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/ul/li[4]")).getText();
        Expected_Text =
            "and/or assistance in performing prime contracts with the Government through joint venture arrangements.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[2]")).getText();
        Expected_Text =
            "Mentors are encouraged to provide assistance relating to the performance of contracts set aside or reserved for small business so that protégé firms may more fully develop their capabilities.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/h4[2]")).getText();
        Expected_Text = "Instructions:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[3]")).getText();
        Expected_Text =
            "A Mentor-Protégé relationship should be established before starting this application – this is not a matching program. The Protégé firm must provide the following information and any supporting documentation in PDF format in order to complete the MPP application process.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/h4[3]")).getText();
        Expected_Text = "Disclaimer:";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div/div/p[4]")).getText();
        Expected_Text =
            "Please read the following certification statements. The Federal government relies on the information in this form and any documents or supplemental information submitted to determine whether the business is eligible to participate in the All Small Business Mentor-Protégé Program. The definition of the terms used in this certification are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR Part 124.520 and 125.9), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person signing this certification may be prosecuted if they have provided false information. Any action taken with respect to this certification does not affect the Government’s right to pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
        assertEquals(Actual_Text, Expected_Text);
        // Verify links on the table.
        logger.info("Before switching, title is = certify.sba.gov");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String main_window = webDriver.getWindowHandle();
        logger.info("Before switching, title is =" + webDriver.getTitle());
        webDriver.findElement(By.linkText("Mentor-Protégé Program training module")).click();
        java.util.Set<String> S1 = webDriver.getWindowHandles();
        Iterator<String> i1 = S1.iterator();
        while (i1.hasNext()) {
          String Second_window = i1.next();
          if (!main_window.equalsIgnoreCase(Second_window)) {
            webDriver.switchTo().window(Second_window);
            Thread.sleep(1000);
            logger.info("After switching title is =" + webDriver.getTitle());
            webDriver.close();
          }
        }
        Thread.sleep(2000);
        webDriver.switchTo().window(main_window);
        logger.info("Back to manin_window " + webDriver.getTitle());
        // Verify the SAM.gov link.
        logger.info("Before switching, title is = certify.sba.gov");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String main_window1 = webDriver.getWindowHandle();
        logger.info("Before switching, title is =" + webDriver.getTitle());
        webDriver.findElement(By.linkText("SAM.gov")).click();
        java.util.Set<String> S11 = webDriver.getWindowHandles();
        Iterator<String> i11 = S11.iterator();
        while (i11.hasNext()) {
          String Second_window = i11.next();
          if (!main_window1.equalsIgnoreCase(Second_window)) {
            webDriver.switchTo().window(Second_window);
            Thread.sleep(1000);
            logger.info("After switching title is =" + webDriver.getTitle());
            webDriver.close();
          }
        }
        webDriver.switchTo().window(main_window1);
        logger.info("Back to manin_window " + webDriver.getTitle());
        // Click on the Accept button.
        Thread.sleep(2000);
        webDriver.findElement(By.name("commit")).click();

      }
    }
  }
}
