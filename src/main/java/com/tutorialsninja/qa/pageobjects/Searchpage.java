package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validhpproduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement nodproductmessage;
	
	public Searchpage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	public boolean displaystatusofhpvalidproduct() {
		
		boolean displaystatus = validhpproduct.isDisplayed();
		
		return displaystatus;
	}
	
	public String retrievenoproductmessagetext() {
		
		String noproductmessagetext = nodproductmessage.getText();
		
		return noproductmessagetext;
	}

}
