package gov.sba.utils.integration;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.sba.automation.CoreUtils;

public class StartWosbProgramPage {
  private static final Logger logger = LogManager.getLogger(StartWosbProgramPage.class.getName());
  WebDriver webDriver;

  public StartWosbProgramPage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void StartWosbProgram() throws Exception {
    String Actual_Text = null;
    String Expected_Text = null;
    // Verify for active certification on the dashboard.
    if (webDriver.getPageSource().contains("Active")) {
      logger.info("There is (are) an active certification on the dashboard");
      // Click on the certification link.
      webDriver.findElement(By.linkText("//li[2]/a/span")).click();
      // Select the WSOB program.
      webDriver.findElement(By.id("certificate_type_wosb")).click(); // Click
                                                                     // on
                                                                     // the
                                                                     // Start
                                                                     // a
                                                                     // new
                                                                     // application
                                                                     // button.
      webDriver.findElement(By.id("add_certification")).click();
      // Verify and validate the terms for the certification.
      Actual_Text =
          webDriver.findElement(By.xpath("//form[@id='new_sba_application']/div[2]/p")).getText();
      Expected_Text =
          "All small businesses that are interested in submitting an offer on a solicitation that has been set aside for Women-Owned Small Businesses (WOSB) and Economically Disadvantaged Women-Owned Small Businesses (EDWOSB) under the WOSB Program must complete this certification prior to submitting the offer. This includes checking all boxes presented and having an authorized officer of the woman-owned small business or economically disadvantaged woman-owned small business electronically sign and date the certification. You must upload all other required documents as indicated here-in to the WOSB Program Repository. For questions, please e-mail wosb@sba.gov.";
      assertEquals(Actual_Text, Expected_Text);
      Actual_Text = webDriver.findElement(By.xpath("//form[@id='new_sba_application']/div[2]/p[2]"))
          .getText();
      Expected_Text =
          "Please read the following certification statements. The Federal government relies on the information in this form and any documents or supplemental information submitted to determine whether the business is eligible for a contract authorized under the WOSB Program. The definitions for the terms used in this certification are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 C.F.R. Part 127), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person signing this certification may be prosecuted if they have provided false information. Any action taken with respect to this certification does not affect the Government's right to pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
      assertEquals(Actual_Text, Expected_Text);
      // Click on the Accept button..
      CoreUtils.clickContinue(webDriver);
    } else {
      if (webDriver.getPageSource().contains("Pending")) {
        logger.info("There is (are) an active certification on the dashboard");
        // Click on the certification link.
        webDriver.findElement(By.linkText("//li[2]/a/span")).click();
        // Select the WSOB program.
        webDriver.findElement(By.id("certificate_type_wosb")).click();
        // Click on the Start a new application button.
        webDriver.findElement(By.id("add_certification")).click();
        // Verify and validate the terms for the certification.
        Actual_Text =
            webDriver.findElement(By.xpath("//form[@id='new_sba_application']/div[2]/p")).getText();
        Expected_Text =
            "All small businesses that are interested in submitting an offer on a solicitation that has been set aside for Women-Owned Small Businesses (WOSB) and Economically Disadvantaged Women-Owned Small Businesses (EDWOSB) under the WOSB Program must complete this certification prior to submitting the offer. This includes checking all boxes presented and having an authorized officer of the woman-owned small business or economically disadvantaged woman-owned small business electronically sign and date the certification. You must upload all other required documents as indicated here-in to the WOSB Program Repository. For questions, please e-mail wosb@sba.gov.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div[2]/p[2]")).getText();
        Expected_Text =
            "Please read the following certification statements. The Federal government relies on the information in this form and any documents or supplemental information submitted to determine whether the business is eligible for a contract authorized under the WOSB Program. The definitions for the terms used in this certification are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 C.F.R. Part 127), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person signing this certification may be prosecuted if they have provided false information. Any action taken with respect to this certification does not affect the Government's right to pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
        assertEquals(Actual_Text, Expected_Text);
        // Click on the Accept button..
        CoreUtils.clickContinue(webDriver);
      } else {
        Actual_Text = webDriver.findElement(By.cssSelector("div.usa-font-lead")).getText();
        Expected_Text =
            "To get started on an application, select which program you'd like to join below. You may only upload documents to certify.SBA.gov during the application process. While completing the online questionnaire, you will be instructed to upload documents to support your answers. These online applications replace any forms released by SBA for these contracting programs in the past.";
        assertEquals(Actual_Text, Expected_Text);
        webDriver.findElement(By.linkText("WOSB self-certification")).click();
        // Verify and validate the terms for the certification.
        Actual_Text =
            webDriver.findElement(By.xpath("//form[@id='new_sba_application']/div[2]/p")).getText();
        Expected_Text =
            "All small businesses that are interested in submitting an offer on a solicitation that has been set aside for Women-Owned Small Businesses (WOSB) and Economically Disadvantaged Women-Owned Small Businesses (EDWOSB) under the WOSB Program must complete this certification prior to submitting the offer. This includes checking all boxes presented and having an authorized officer of the woman-owned small business or economically disadvantaged woman-owned small business electronically sign and date the certification. You must upload all other required documents as indicated here-in to the WOSB Program Repository. For questions, please e-mail wosb@sba.gov.";
        assertEquals(Actual_Text, Expected_Text);
        Actual_Text = webDriver
            .findElement(By.xpath("//form[@id='new_sba_application']/div[2]/p[2]")).getText();
        Expected_Text =
            "Please read the following certification statements. The Federal government relies on the information in this form and any documents or supplemental information submitted to determine whether the business is eligible for a contract authorized under the WOSB Program. The definitions for the terms used in this certification are set forth in the Small Business Act, U.S. Small Business Administration (SBA) regulations (13 C.F.R. Part 127), and also any statutory and regulatory provision referenced in those authorities. In addition, please note that the SBA may request further clarification or supporting documentation in order to assist in the verification of any of the information provided and that each person signing this certification may be prosecuted if they have provided false information. Any action taken with respect to this certification does not affect the Government's right to pursue criminal, civil or administrative remedies for incorrect or incomplete information given, even if correct information has been included in other materials submitted to SBA.";
        assertEquals(Actual_Text, Expected_Text);
        // Click on the Accept button..
        CoreUtils.clickContinue(webDriver);
      }
    }
  }
}
