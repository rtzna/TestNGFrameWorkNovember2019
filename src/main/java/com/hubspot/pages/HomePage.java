package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constans;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	//locators
	By userInfo = By.xpath("//span[contains(text(),'Rustu')]");
	By header = By.xpath("//i18n-string[contains(text(), 'Set up')]");
	
	//constructor
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	//Methods
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constans.HOME_PAGE_TITLE);
		//return driver.getTitle();
	}
	public boolean verifyLoggedinUserInfoName(){
		
		return elementUtil.isElementDisplayed(userInfo);
		
		//return driver.findElement(userInfo).isDisplayed();
		
	}
	public String getHomePageHeader() {
		return elementUtil.doGetText(header);
		
		//return driver.findElement(header).getText();
	}
	public String getLoggedinUserName(){
		
		return elementUtil.doGetText(userInfo);
		//return driver.findElement(userInfo).getText();
		
	}
	
}
