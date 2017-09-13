package gov.sba.utils.integration;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DataBaseExicutionPage {
	
	
	
  private static final Logger logger = LogManager.getLogger(DataBaseExicutionPage.class.getName());
  //WebDriver webDriver;

  public DataBaseExicutionPage(WebDriver webDriver) {
    //this.webDriver = webDriver;
  }
  public void DataBaseExicution() throws Exception {
try{
	logger.info("Running clean up command in the database.");
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://db.qa.sba-one.net:5432/sbaone_qa", "app_ruby", "rubypassword");
	PreparedStatement stmt = con.prepareStatement("select * from sbaone.users;");
	ResultSet Rs = stmt.executeQuery();
	while(Rs.next()){
		logger.info(Rs.getInt(1)+" "+Rs.getString(2));
	}
	
}
catch (Exception ex){
	logger.info(ex.getMessage());
	
	
}
}
}