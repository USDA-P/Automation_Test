package gov.sba.utils.integration;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOrStartEightACertificationPage {
  private static final Logger logger =
      LogManager.getLogger(AddOrStartEightACertificationPage.class.getName());
  WebDriver webDriver;

  public AddOrStartEightACertificationPage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void AddOrStartEightACertification() throws Exception {
    String Actual_Text = null;
    String Expected_Text = null;
    // Verify for active certification on the dashboard.
    if (webDriver.getPageSource().contains("Active")) {
      logger.info("There is (are) an active certification on the dashboard");
      // Click on the certification link.
      webDriver.findElement(By.linkText("Programs")).click();
      Actual_Text = webDriver.findElement(By.xpath("//h1[2]")).getText();
      Expected_Text = "Join a new program";
      assertEquals(Actual_Text, Expected_Text);
      webDriver.findElement(By.id("certificate_type_eight_a")).click();
      // Click on the Start a new application button.
      webDriver.findElement(By.id("add_certification")).click();
      // Verify link 13 CFR § 124.3.
      webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      String main_window = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("124.3")).click();
      java.util.Set<String> S = webDriver.getWindowHandles();
      Iterator<String> i = S.iterator();
      while (i.hasNext()) {
        String Second_window = i.next();
        if (!main_window.equalsIgnoreCase(Second_window)) {
          webDriver.switchTo().window(Second_window);
          logger.info("After switching title is =" + webDriver.getTitle());
          webDriver.close();
          webDriver.switchTo().window(main_window);
          logger.info("Back to manin_window = certify.sba.gov");
        } else {
          logger.info("Second Window is not thesame as first window");

        }
      }
      // Verify and validate the terms for the certification.
      Actual_Text = webDriver.findElement(By.cssSelector("p")).getText();
      Expected_Text =
          "The Federal government relies on the information in the forms and any documents or supplemental information submitted to determine whether your business is eligible to participate in the 8(a) Business Development Program. The definition of important terms are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR § 124.3), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person providing information may be prosecuted if they have provided false information. The Government may pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
      assertEquals(Actual_Text, Expected_Text);
    } else {
      Actual_Text = webDriver.findElement(By.cssSelector("div.usa-font-lead")).getText();
      Expected_Text =
          "To get started on an application, select which program you'd like to join below. You may only upload documents to certify.SBA.gov during the application process. While completing the online questionnaire, you will be instructed to upload documents to support your answers. These online applications replace any forms released by SBA for these contracting programs in the past.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver
          .findElement(By.xpath("//article[@id='main-content']/section/article/div/div[2]"))
          .getText();
      Expected_Text =
          "Get started now on your WOSB self-certification, EDWOSB self-certification, All Small Business Mentor-Protégé agreement, or 8(a) Initial Application.";
      assertEquals(Actual_Text, Expected_Text);
      // Click on the EDWOSB link.
      webDriver.findElement(By.linkText("8(a) Document Upload")).click();
      // Verify link 13 CFR § 124.3.
      webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      String main_window = webDriver.getWindowHandle();
      logger.info("Before switching, title is = certify.sba.gov");
      webDriver.findElement(By.linkText("124.3")).click();
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
      // Verify and validate the terms for the certification.
      Actual_Text = webDriver.findElement(By.cssSelector("p")).getText();
      Expected_Text =
          "The Federal government relies on the information in the forms and any documents or supplemental information submitted to determine whether your business is eligible to participate in the 8(a) Business Development Program. The definition of important terms are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 CFR § 124.3), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person providing information may be prosecuted if they have provided false information. The Government may pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
      assertEquals(Actual_Text, Expected_Text);
    }
  }
}
