package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	//This are Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	
	@FindBy(linkText="Register")
	private WebElement registeroption;
	
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchboxfield;
	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchbutton;
	
	
	public Homepage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
			
	}
	
	//Actions
	
	public void clickonMyAccount() {
		
		myAccountDropMenu.click();
	}
	
	public Loginpage  Selectloginoption() {
		
		loginOption.click();
		return new Loginpage(driver);
	}
	
    public Registerpage selectregisteroption() {
    	
    	registeroption.click();
    	
    	return new Registerpage(driver);
    	
    }
    
    public void enterproductintosearchboxfield(String producttext) {
    	
    	searchboxfield.sendKeys(producttext);
    }
    
    public Searchpage clickonsearchbutton() {
    	
    	searchbutton.click();
    	
    	return new Searchpage(driver);
    }
}
