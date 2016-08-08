package gov.sba.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.sba.utils.helpers.LoginHelpers;

public class CologinPage {
	private static final Logger logger = LogManager.getLogger(TestSearchPage.class.getName());
	WebDriver webDriver;

	public CologinPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void Cologin() throws Exception {
		logger.debug("Using test login   : " + LoginHelpers.getLoginData().getEmail());
		logger.debug("Using test password: " + LoginHelpers.getLoginData().getPassword());
		webDriver.findElement(By.xpath(".//*[@id=\"gov_login_box\"]/form[1]/button")).click();
		webDriver.findElement(By.name("user[email]")).sendKeys(LoginHelpers.getLoginData().getEmail());
		webDriver.findElement(By.name("user[password]")).sendKeys(LoginHelpers.getLoginData().getPassword());
		webDriver.findElement(By.id("business_signin")).click();
		String url = webDriver.getCurrentUrl();
		org.junit.Assert.assertTrue(url.contains("contracting_officer/access_requests"));
	}
}