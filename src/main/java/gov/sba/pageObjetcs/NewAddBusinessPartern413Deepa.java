/* Created BY Deepa Patri */
package gov.sba.pageObjetcs;

import gov.sba.automation.CommonApplicationMethods;
import gov.sba.utils.integration.ScorpQuestionsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static gov.sba.automation.CommonApplicationMethods.*;
import static gov.sba.pageObjetcs.ProgramsPage.generic_file_Upld;

public class NewAddBusinessPartern413Deepa {
  private static final Logger logger = LogManager.getLogger(ScorpQuestionsPage.class.getName());

  public static void NewFinancialQuestion(WebDriver webDriver, String Firstname, String lastname,
      String Ssn, String Email, String Address, String State, String Postalcode, String HPhone,
      String BPhone, String City, String Co) throws Exception {
    /* Validate that user successfully navigated to the Financial Data */
    click_Element(webDriver, "EDWOSB_Questionnaire_Page_FinancialPage_Link");

    // Validate the Personal Information.

    click_Element(webDriver, "EDWOSB_Questionnaire_Page_Add_Person");
    logger.info("the page to Create and Add new Record is Present, PASS");
        setText_Element(webDriver, "EDWOSB_Questionnaire_Page_FirstName", Firstname);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_LastName", lastname);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_SSN", Ssn);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_Email", Email);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_Address", Address);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_State", State);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_Postal", Postalcode);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_HPhone", HPhone);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_Bphone", BPhone);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_City", City);
    setText_Element(webDriver, "EDWOSB_Questionnaire_Page_Co", Co);
    new Select(find_Element(webDriver, "EDWOSB_Questionnaire_Page_title")).selectByIndex(2);
    new Select(find_Element(webDriver, "EDWOSB_Questionnaire_Page_MaritalSt")).selectByIndex(2);

    CommonApplicationMethods.click_Element(webDriver, "EDWOSB_Questionnaire_Page_Done_Button");
  }

  public static void Edwosb_legalseparation(WebDriver webDriver, String yesno) throws Exception {
    /* Elements tag: 8a_Questionnaire */
    try {
      if (!yesno.equals(null) && !yesno.equals("")) {
        switch (yesno.toLowerCase()) {
          case "yes":
            click_Element(webDriver, "EDWOSB_Questionnaire_Page_Ans_423_Y");
            generic_file_Upld(webDriver);
            break;
          case "no":
            click_Element(webDriver, "EDWOSB_Questionnaire_Page_Ans_423_N");
            click_Element(webDriver, "EDWOSB_Questionnaire_Page_Commit");
            break;

        }
      }

    } catch (Exception e) {
      logger.info(e.toString());
      throw e;
    }
  }

  private void assertEquals(String actual_Text1, String expected_Text1) {
    // TODO Auto-generated method stub
  }
}
