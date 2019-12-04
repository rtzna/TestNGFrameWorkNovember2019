package com.hubspot.tests;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.bson.LazyBSONObject;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.hubspot.listeners.TestAllureListener.class)



public class LoginPageTest {
	
	Logger log = Logger.getLogger("LoginPageTest");
	
	
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		log.info("Browser is launching...");
		prop = new Properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		log.info("Set up is configured");
	}
	
	
	@Test(priority =1, description ="This method is getting title")
	public void loginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	@Test(priority=2, description ="inValid username and invalid Password")
	public void loginTest() throws InterruptedException{
		loginPage.doLogin("mrty_5@hotmail.com", "1456.Rtyzn");
		Thread.sleep(3000);
	}
	@Test(priority =3, description = "invalid username and password")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest2() throws InterruptedException{
		loginPage.doLogin("bobler", "teststt");
		Thread.sleep(3000);
	}
	@Test(priority=4,description = "Rustu valid user name", enabled=true)
	public void loginTest3() throws InterruptedException{
		loginPage.doLogin("noemail@hotmail.com", "Test1234");
		log.info("Login testlogs : correct user and correct pass");
		Thread.sleep(3000);}
	@AfterMethod
	public void close(){
		basePage.quitBrowser();
	}

}
