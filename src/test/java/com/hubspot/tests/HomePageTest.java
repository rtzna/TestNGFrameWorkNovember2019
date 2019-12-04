package com.hubspot.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;

public class HomePageTest {
	
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		Thread.sleep(5000);
	}

	@Test
	public void verifyHomePageTitle(){
		String title = homePage.getHomePageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, "Account Setup | HubSpot");
		
	}
	@Test
	public void verifyHomePageHeader(){
	String headerValue = homePage.getHomePageHeader();
	System.out.println("Home Page Header is: " +headerValue);
	Assert.assertEquals(headerValue, "Set up your HubSpot account");
	
	}
	@Test
	public void verifyUserInfo(){
	String username =homePage.getLoggedinUserName();
	System.out.println("User name is: "+ username);
	Assert.assertEquals(username, "Rustu");
	}
	@AfterMethod
	public void close(){
		driver.close();
	}

}
