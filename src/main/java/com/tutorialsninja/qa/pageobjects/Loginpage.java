package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	//Objects
	
	@FindBy(name="email")
	private WebElement emailaddressfield;
	
	
	@FindBy(name="password")
	private WebElement passwordaddressfield;
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailpasswordnotmatchingWarning;
	
		public Loginpage(WebDriver driver) {
			
			this.driver = driver;
			
			PageFactory.initElements(driver,this);
			
		}
		
		
		//Actions
		
		public void enteremailaddress(String emailText) {
			
			emailaddressfield.sendKeys(emailText);
		}
		
		public void enterpasswordfield(String passwordText) {
			
			passwordaddressfield.sendKeys(passwordText);
			
		}
		
		public Accountpage clickonloginbutton() {
			
			loginbutton.click();
			
		return new Accountpage(driver);
			
		}
		
		public String retriveemailpasswordnotmatchingwarningmessagetext() {
			
			String warningtext = emailpasswordnotmatchingWarning.getText();
			
			return warningtext;
			
		}
		
		
	}

    


