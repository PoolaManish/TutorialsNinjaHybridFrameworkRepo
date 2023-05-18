package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement edityouraccountinformatiooption;
	
	
	//need to create a constructor
	
	public Accountpage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	//Actions
	
	public boolean getdisplaystatusofedityouraccountinformation() {
		
		boolean displaystatus = edityouraccountinformatiooption.isDisplayed();
		
		return displaystatus;
		
	}

}
