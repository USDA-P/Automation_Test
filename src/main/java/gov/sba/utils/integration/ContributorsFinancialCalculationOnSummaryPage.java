// by Montana.
package gov.sba.utils.integration;

import java.text.NumberFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.TestCase;

public class ContributorsFinancialCalculationOnSummaryPage extends TestCase {
	private static final Logger logger = LogManager
			.getLogger(ContributorsFinancialCalculationOnSummaryPage.class.getName());
	WebDriver webDriver;

	public ContributorsFinancialCalculationOnSummaryPage(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	public void ContributorsFinancialCalculationOnSummary() throws Exception {
		Object Actual_Assets = null;
		Object Expected_Assets = null;
		Object Actual_TotalLiabilities = null;
		Object Expected_TotalLiabilities = null;
		Object Actual_NetWorthValue = null;
		Object Expected_NetWorthValue = null;
		// =====>>>>>Calculate Begins here..
		// try {
		logger.info("Calculations for all the table data.");
		logger.info("Validating calculations for partner's Total Assets");
		// Cash on Hand.
		// ==>>Get the cash on hand value and convert to integer, then remove
		// the dollar sign for
		// calculation purpose.
		String COH = null;
		COH = webDriver.findElement(By.xpath("//td[2]")).getText();
		logger.info("Cash on Hand value with dollar sign is" + COH);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(COH);
		String COH1;
		COH1 = number.toString();
		logger.info("Cash on hand without the dollar sign is " + number.toString());
		// Convert the string value to integer.
		int value1 = Integer.parseInt(COH1);
		logger.info("Cash on Hand success");
		// Savings Account(s) Balances.
		// ==>>Get the Savings Account(s) Balances value and convert to integer.
		String SAB = null;
		SAB = webDriver.findElement(By.xpath("//tr[2]/td[2]")).getText();
		logger.info("Savings Account(s) Balances value is" + SAB);
		NumberFormat format1 = NumberFormat.getCurrencyInstance();
		Number number1 = format1.parse(SAB);
		String SAB1;
		SAB1 = number1.toString();
		logger.info("Savings Account(s) Balances without the dollar sign is " + number1.toString());
		// Convert the string value to integer.
		int value2 = Integer.parseInt(SAB1);
		logger.info("Savings Account(s) Balances success");
		// Checking Account(s) Balances.
		// ==>>Get the Checking Account(s) Balances Balances value and convert
		// to integer.
		String CAB = null;
		CAB = webDriver.findElement(By.xpath("//tr[3]/td[2]")).getText();
		logger.info("Checking Account(s) Balances value is" + CAB);
		NumberFormat format2 = NumberFormat.getCurrencyInstance();
		Number number2 = format2.parse(CAB);
		String CAB1;
		CAB1 = number2.toString();
		logger.info("Checking Account(s) Balances without the dollar sign is " + number2.toString());
		// Convert the string value to integer.
		int value3 = Integer.parseInt(CAB1);
		logger.info("Checking Account(s) Balances success");
		// Accounts & Notes Receivable.
		// ==>>Get the Accounts & Notes Receivable value and convert to integer.
		String ANR = null;
		ANR = webDriver.findElement(By.xpath("//tr[4]/td[2]")).getText();
		logger.info("Accounts & Notes Receivable value is" + ANR);
		NumberFormat format3 = NumberFormat.getCurrencyInstance();
		Number number3 = format3.parse(ANR);
		String ANR1;
		ANR1 = number3.toString();
		logger.info("Accounts & Notes Receivable without the dollar sign is " + number3.toString());
		// Convert the string value to integer.
		int value4 = Integer.parseInt(ANR1);
		logger.info("Accounts & Notes Receivable success");
		// IRA, 401K or Other Retirement Account.
		// ==>>Get the IRA, 401K or Other Retirement Account value and convert
		// to integer.
		String ORA = null;
		ORA = webDriver.findElement(By.xpath("//tr[5]/td[2]")).getText();
		logger.info("IRA, 401K or Other Retirement Account value is" + ORA);
		NumberFormat format4 = NumberFormat.getCurrencyInstance();
		Number number4 = format4.parse(ORA);
		String ORA1;
		ORA1 = number4.toString();
		logger.info("IRA, 401K or Other Retirement Account without the dollar sign is " + number4.toString());
		// Convert the string value to integer.
		int value5 = Integer.parseInt(ORA1);
		logger.info("IRA, 401K or Other Retirement Account success");
		// Roth IRA.
		// ==>>Get the Roth IRA value and convert to integer.
		String RIRA = null;
		RIRA = webDriver.findElement(By.xpath("//tr[6]/td[2]")).getText();
		logger.info("Roth IRA value is" + RIRA);
		NumberFormat format5 = NumberFormat.getCurrencyInstance();
		Number number5 = format5.parse(RIRA);
		String RIRA1;
		RIRA1 = number5.toString();
		logger.info("Roth IRA value without the dollar sign is " + number5.toString());
		// Convert the string value to integer.
		int value6 = Integer.parseInt(RIRA1);
		logger.info("Roth IRA success");
		// ==>>Get Cash Surrender Value of Whole Life Insurance value and
		// convert to integer.
		String CSVLI = null;
		CSVLI = webDriver.findElement(By.xpath("//tr[7]/td[2]")).getText();
		logger.info("Cash Surrender Value of Whole Life Insurance is" + CSVLI);
		NumberFormat format6 = NumberFormat.getCurrencyInstance();
		Number number6 = format6.parse(CSVLI);
		String CSVLI1;
		CSVLI1 = number6.toString();
		logger.info("Cash Surrender Value of Whole Life Insurance " + number6.toString());
		// Convert the string value to integer.
		int value7 = Integer.parseInt(CSVLI1);
		logger.info("Cash Surrender Value of Whole Life Insurance success");
		// ==>>Get Stocks and Bonds or Mutual Funds? value and convert to
		// integer.
		String SB = null;
		SB = webDriver.findElement(By.xpath("//tr[8]/td[2]")).getText();
		logger.info("Stocks and Bonds or Mutual Funds? is" + SB);
		NumberFormat format7 = NumberFormat.getCurrencyInstance();
		Number number7 = format7.parse(SB);
		String SB1;
		SB1 = number7.toString();
		logger.info("Stocks and Bonds or Mutual Funds? without dollar sign is " + number7.toString());
		// Convert the string value to integer.
		int value8 = Integer.parseInt(SB1);
		logger.info("Cash Surrender Value of Whole Life Insurance success");
		// ==>>Get Real Estate (Primary Residence) value and convert to integer.
		String REPR = null;
		REPR = webDriver.findElement(By.xpath("//tr[9]/td[2]")).getText();
		logger.info("Real Estate (Primary Residence) is" + REPR);
		NumberFormat format8 = NumberFormat.getCurrencyInstance();
		Number number8 = format8.parse(REPR);
		String REPR1;
		REPR1 = number8.toString();
		logger.info("Real Estate (Primary Residence) without dollar sign is " + number8.toString());
		// Convert the string value to integer.
		int value9 = Integer.parseInt(REPR1);
		logger.info("Real Estate (Primary Residence) success");
		// ==>>Get Other Real Estate value and convert to integer.
		String ORE = null;
		ORE = webDriver.findElement(By.xpath("//tr[10]/td[2]")).getText();
		logger.info("Other Real Estate is" + ORE);
		NumberFormat format9 = NumberFormat.getCurrencyInstance();
		Number number9 = format9.parse(ORE);
		String ORE1;
		ORE1 = number9.toString();
		logger.info("Other Real Estate without dollar sign is " + number9.toString());
		// Convert the string value to integer.
		int value10 = Integer.parseInt(ORE1);
		logger.info("Other Real Estate success");
		// ==>>Get Automobiles value and convert to integer.
		String AM = null;
		AM = webDriver.findElement(By.xpath("//tr[11]/td[2]")).getText();
		logger.info("Automobiles value is" + AM);
		NumberFormat format10 = NumberFormat.getCurrencyInstance();
		Number number10 = format10.parse(AM);
		String AM1;
		AM1 = number10.toString();
		logger.info("Automobiles without dollar sign is " + number10.toString());
		// Convert the string value to integer.
		int value11 = Integer.parseInt(AM1);
		logger.info("Automobiles success");
		// ==>>Get Other Personal Property/Assets value and convert to integer.
		String OPP = null;
		OPP = webDriver.findElement(By.xpath("//tr[12]/td[2]")).getText();
		logger.info("Other Personal Property/Assets value is" + OPP);
		NumberFormat format11 = NumberFormat.getCurrencyInstance();
		Number number11 = format11.parse(OPP);
		String OPP1;
		OPP1 = number11.toString();
		logger.info("Other Personal Property/Assets without dollar sign is " + number11.toString());
		// Convert the string value to integer.
		int value12 = Integer.parseInt(OPP1);
		logger.info("Other Personal Property/Assets success");
		// ==>>Get Applicant's Business Equity value and convert to integer.
		String ABE = null;
		ABE = webDriver.findElement(By.xpath("//tr[13]/td[2]")).getText();
		logger.info("Applicant's Business Equity value is" + ABE);
		NumberFormat format12 = NumberFormat.getCurrencyInstance();
		Number number12 = format12.parse(ABE);
		String ABE1;
		ABE1 = number12.toString();
		logger.info("Applicant's Business Equity without dollar sign is " + number12.toString());
		// Convert the string value to integer.
		int value13 = Integer.parseInt(ABE1);
		logger.info("Applicant's Business Equity success");
		// ==>>Get Applicant's Equity in Other Firms value and convert to
		// integer.
		String AEOF = null;
		AEOF = webDriver.findElement(By.xpath("//tr[14]/td[2]")).getText();
		logger.info("Applicant's Equity in Other Firms value is " + AEOF);
		NumberFormat format13 = NumberFormat.getCurrencyInstance();
		Number number13 = format13.parse(AEOF);
		String AEOF1;
		AEOF1 = number13.toString();
		logger.info("Applicant's Equity in Other Firms without dollar sign is " + number13.toString());
		// Convert the string value to integer.
		int value14 = Integer.parseInt(AEOF1);
		logger.info("Applicant's Equity in Other Firms success");
		// ==>>Get Total Assets(sum of all the assets) value and convert to
		// integer.
		String TA = null;
		TA = webDriver.findElement(By.xpath("//tr[15]/td[2]")).getText();
		logger.info("Applicant's Equity in Other Firms value is " + TA);
		NumberFormat format14 = NumberFormat.getCurrencyInstance();
		Number number14 = format14.parse(TA);
		String TA1;
		TA1 = number14.toString();
		logger.info("Applicant's Equity in Other Firms without dollar sign is " + number14.toString());
		// Convert the string value to integer.
		int TotalAssets = Integer.parseInt(TA1);
		logger.info("Total Assets success");
		// =====>>>Add all the assets and verify that it matches the total on
		// the total assets box.
		int TotalAsset = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10
				+ value11 + value12 + value13 + value14;
		logger.info(TotalAsset);
		logger.info("total assets calculated is " + TotalAssets);
		// verify the calculation for Total Assets is correct.
		Actual_Assets = TotalAssets;
		Expected_Assets = TotalAsset;
		assertEquals(Actual_Assets, Expected_Assets);
		logger.info("Total Assts calculations seccessfull");
		// ======>>>>>Total Liabilities calculations.
		logger.info("Validating calculations for partner's Total Liabilities");
		// Get Accounts Payable value and convert to integer.
		String AP = null;
		AP = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr/td[2]")).getText();
		logger.info("Accounts Payable value is " + AP);
		NumberFormat format15 = NumberFormat.getCurrencyInstance();
		Number number15 = format15.parse(AP);
		String AP1;
		AP1 = number15.toString();
		logger.info("Accounts Payable without dollar sign is " + number15.toString());
		// Convert the string value to integer.
		int value15 = Integer.parseInt(AP1);
		logger.info("Accounts Payable success");
		// ==>>Get Notes Payable to Banks & Others value and convert to integer.
		String NPTBOV = null;
		NPTBOV = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[2]")).getText();
		logger.info("Notes Payable to Banks & Others value is " + NPTBOV);
		NumberFormat format16 = NumberFormat.getCurrencyInstance();
		Number number16 = format16.parse(NPTBOV);
		String NPTBOV1;
		NPTBOV1 = number16.toString();
		logger.info("Notes Payable to Banks & Others without dollar sign is " + number16.toString());
		// Convert the string value to integer.
		int value16 = Integer.parseInt(NPTBOV1);
		logger.info("Notes Payable to Banks & Others success");
		// ==>>Get Installment Account (Auto) value and convert to integer.
		String IAA = null;
		IAA = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[3]/td[2]")).getText();
		logger.info("Installment Account (Auto) value is " + IAA);
		NumberFormat format17 = NumberFormat.getCurrencyInstance();
		Number number17 = format17.parse(IAA);
		String IAA1;
		IAA1 = number17.toString();
		logger.info("Installment Account (Auto) without dollar sign is " + number17.toString());
		// Convert the string value to integer.
		int value17 = Integer.parseInt(IAA1);
		logger.info("Installment Account (Auto) success");
		// ==>>Get Installment Account (Other) and convert to integer.
		String IAO = null;
		IAO = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[4]/td[2]")).getText();
		logger.info("Installment Account (Other) value is " + IAO);
		NumberFormat format18 = NumberFormat.getCurrencyInstance();
		Number number18 = format18.parse(IAO);
		String IAO1;
		IAO1 = number18.toString();
		logger.info("Installment Account (Other) without dollar sign is " + number18.toString());
		// Convert the string value to integer.
		int value18 = Integer.parseInt(IAO1);
		logger.info("Installment Account (Other) success");
		// ==>>Get Loan(s) Against Life Insurance and convert to integer.
		String LALI = null;
		LALI = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[5]/td[2]")).getText();
		logger.info("Loan(s) Against Life Insurance value is " + LALI);
		NumberFormat format19 = NumberFormat.getCurrencyInstance();
		Number number19 = format19.parse(LALI);
		String LALI1;
		LALI1 = number19.toString();
		logger.info("Loan(s) Against Life Insurance without dollar sign is " + number19.toString());
		// Convert the string value to integer.
		int value19 = Integer.parseInt(LALI1);
		logger.info("Loan(s) Against Life Insurance success");
		// ==>>Get Mortgage (Primary Residence) and convert to integer.
		String MPR = null;
		MPR = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[6]/td[2]")).getText();
		logger.info("Mortgage (Primary Residence) value is " + MPR);
		NumberFormat format20 = NumberFormat.getCurrencyInstance();
		Number number20 = format20.parse(MPR);
		String MPR1;
		MPR1 = number20.toString();
		logger.info("Mortgage (Primary Residence) without dollar sign is " + number20.toString());
		// Convert the string value to integer.
		int value20 = Integer.parseInt(MPR1);
		logger.info("Mortgage (Primary Residence) success");
		// ==>>Get Mortgages on other Real Estate and convert to integer.
		String MOORE = null;
		MOORE = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[7]/td[2]")).getText();
		logger.info("Mortgages on other Real Estate value is " + MOORE);
		NumberFormat format21 = NumberFormat.getCurrencyInstance();
		Number number21 = format21.parse(MOORE);
		String MOORE1;
		MOORE1 = number21.toString();
		logger.info("Mortgages on other Real Estate without dollar sign is " + number21.toString());
		// Convert the string value to integer.
		int value21 = Integer.parseInt(MOORE1);
		logger.info("Mortgages on other Real Estate success");
		// ==>>Get Unpaid Taxes and convert to integer.
		String UT = null;
		UT = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[8]/td[2]")).getText();
		logger.info("Unpaid Taxes value is " + UT);
		NumberFormat format22 = NumberFormat.getCurrencyInstance();
		Number number22 = format22.parse(UT);
		String UT1;
		UT1 = number22.toString();
		logger.info("Unpaid Taxes without dollar sign is " + number22.toString());
		// Convert the string value to integer.
		int value22 = Integer.parseInt(UT1);
		logger.info("Unpaid Taxes success");
		// ==>>Get Other Liabilities and convert to integer.
		String OL = null;
		OL = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[9]/td[2]")).getText();
		logger.info("Other Liabilities value is " + OL);
		NumberFormat format23 = NumberFormat.getCurrencyInstance();
		Number number23 = format23.parse(OL);
		String OL1;
		OL1 = number23.toString();
		logger.info("Other Liabilities without dollar sign is " + number23.toString());
		// Convert the string value to integer.
		int value23 = Integer.parseInt(OL1);
		logger.info("Other Liabilities success");
		// ==>>Get Total Liabilities and convert to integer.
		String TL = null;
		TL = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[10]/td[2]")).getText();
		logger.info("Other Liabilities value is " + TL);
		NumberFormat format24 = NumberFormat.getCurrencyInstance();
		Number number24 = format24.parse(TL);
		String TL1;
		TL1 = number24.toString();
		logger.info("Other Liabilities without dollar sign is " + number24.toString());
		// Convert the string value to integer.
		int TotalLiabilities = Integer.parseInt(TL1);
		logger.info("Other Liabilities success");
		// ======>>>>Add all the liabilities value and verify if it matches the
		// total liabilities
		// value.
		int TotalLiabilitie = value15 + value16 + value17 + value18 + value19 + value20 + value21 + value22 + value23;
		logger.info(TotalLiabilitie);
		logger.info("total assets calculated is " + TotalLiabilities);
		// verify the calculation is correct.
		Actual_TotalLiabilities = TotalLiabilities;
		Expected_TotalLiabilities = TotalLiabilitie;
		assertEquals(Actual_TotalLiabilities, Expected_TotalLiabilities);
		logger.info("Total Liabilities calculations seccessfull");
		// Get Net Worth and convert to integer.
		String NW = null;
		NW = webDriver.findElement(By.xpath("//div[2]/table/tbody/tr[11]/td[2]")).getText();
		logger.info("Net Worth value is " + NW);
		NumberFormat format25 = NumberFormat.getCurrencyInstance();
		Number number25 = format25.parse(NW);
		String NW1;
		NW1 = number25.toString();
		logger.info("Net Worth without dollar sign is " + number25.toString());
		// Convert the string value to integer.
		int NetWorth = Integer.parseInt(NW1);
		logger.info("Net Worth success");
		// =======>>>Net Worth calculation.
		logger.info("Calculating the Neth Worth");
		// Subtracting Total Assets from Total Liabilities to get the Net Worth.
		int TotalNetWorth = TotalAsset - TotalLiabilitie;
		logger.info("Calculated Net Worth value is " + TotalNetWorth);
		logger.info("Net Worth seccessfull");
		// =====>>>>verify the calculation for Total Assets is correct.
		Actual_NetWorthValue = NetWorth;
		Expected_NetWorthValue = TotalNetWorth;
		assertEquals(Actual_NetWorthValue, Expected_NetWorthValue);
		logger.info("Total Assts calculations seccessfull");
		// =======>>>>>Sources of Income verification.
		// ==>>Get Salary and convert to integer.
		String Salary = null;
		Salary = webDriver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td[2]")).getText();
		logger.info("Salary value is " + Salary);
		NumberFormat format26 = NumberFormat.getCurrencyInstance();
		Number number26 = format26.parse(Salary);
		String Salary1;
		Salary1 = number26.toString();
		logger.info("Salary without dollar sign is " + number26.toString());
		// Convert the string value to integer.
		int value24 = Integer.parseInt(Salary1);
		logger.info("Salary success");
		// ==>>Get Investment Income and convert to integer.
		String IN = null;
		IN = webDriver.findElement(By.xpath("//div[3]/div/table/tbody/tr[2]/td[2]")).getText();
		logger.info("Investment Income value is " + IN);
		NumberFormat format27 = NumberFormat.getCurrencyInstance();
		Number number27 = format27.parse(IN);
		String IN1;
		IN1 = number27.toString();
		logger.info("Investment Income without dollar sign is " + number27.toString());
		// Convert the string value to integer.
		int value25 = Integer.parseInt(IN1);
		logger.info("Investment Income success");
		// ==>>Get Real Estate Income and convert to integer.
		String REI = null;
		REI = webDriver.findElement(By.xpath("//div[3]/div/table/tbody/tr[3]/td[2]")).getText();
		logger.info("Real Estate Income value is " + REI);
		NumberFormat format28 = NumberFormat.getCurrencyInstance();
		Number number28 = format28.parse(REI);
		String REI1;
		REI1 = number28.toString();
		logger.info("Real Estate Income without dollar sign is " + number28.toString());
		// Convert the string value to integer.
		int value26 = Integer.parseInt(REI1);
		logger.info("Real Estate Income success");
		// ==>>Get Other Income and convert to integer.
		String OI = null;
		OI = webDriver.findElement(By.xpath("//div[3]/div/table/tbody/tr[4]/td[2]")).getText();
		logger.info("Other Income value is " + OI);
		NumberFormat format29 = NumberFormat.getCurrencyInstance();
		Number number29 = format29.parse(OI);
		String OI1;
		OI1 = number29.toString();
		logger.info("Other Income value without dollar sign is " + number29.toString());
		// Convert the string value to integer.
		int value27 = Integer.parseInt(OI1);
		logger.info("Other Income success");
		// =====>>>>>Calculating the total Sources of Income.
		int TotalIncome = value24 + value25 + value26 + value27;
		logger.info("Total Sources of Income is " + TotalIncome);
		// } catch (Exception e) {
		// logger.info(e.getMessage());
		// Assert.fail();
		// }
	}
}
