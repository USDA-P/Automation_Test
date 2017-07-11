/**
 * Created by deepa on 5/15/2017.
 */
package gov.sba.pageObjetcs;

import static gov.sba.automation.CommonApplicationMethods.click_Element;
import static gov.sba.automation.CommonApplicationMethods.find_Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VendorDashboardPage {

  public static List<WebElement> verify_Row_In_A_Table_And_Return(WebDriver webDriver,
      String[] values_To_Check) throws Exception {

    List<WebElement> table_Rows =
        find_Elements(webDriver, "SBA_Table_My_Certifications_All_Rows", true);
    for (int i = 0; i < table_Rows.size(); i++) {
      int c1 = 0;
      int c2 = 0;

      WebElement single_Row = table_Rows.get(i);
      List<WebElement> all_Cells = single_Row.findElements(By.xpath("td"));
      for (int j = 0; j < all_Cells.size(); j++) {
        WebElement cell = all_Cells.get(j);
        if (values_To_Check[j].length() > 0) {
          c1 = c1 + 1;
          if (cell.getText().equals(values_To_Check[j])) {
            c2 = c2 + 1;
          }
        }
      } // Second loop: Finish for all cells

      if (c1 == c2) {
        return all_Cells;
      }
    } // Frist loop : Finish for all rows
    return null;
  }

  public static void click_On_App_In_Vend_Dash(WebDriver webDriver, String values_To_Click)
      throws Exception {
    List<WebElement> links = null;
    switch (values_To_Click.toLowerCase()) {
      case "wosb":
        click_Element(webDriver, "SBA_WOSB_Table_Link");
        // find_Elements(webDriver, "SBA_WOSB_Table_Link").get(0).click();
        break;
      case "edwosb":
        click_Element(webDriver, "SBA_EDWOSB_Table_Link");
        // find_Elements(webDriver, "SBA_EDWOSB_Table_Link").get(0).click();
        break;
      case "mpp":
        click_Element(webDriver, "SBA_MPP_Table_Link");
        // find_Elements(webDriver, "SBA_MPP_Table_Link").get(0).click();
        break;
      case "8aInitial":
        click_Element(webDriver, "SBA_8aInitial_Table_Link");
        // find_Elements(webDriver, "SBA_MPP_Table_Link").get(0).click();
       break;
    }
  }


}
