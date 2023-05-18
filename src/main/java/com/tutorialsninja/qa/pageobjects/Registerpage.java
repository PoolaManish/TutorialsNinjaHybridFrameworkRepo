package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastnamefield;
	
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	
	@FindBy(id="input-telephone")
    private WebElement telephonefield;
	
	
	@FindBy(id="input-password")
    private WebElement passwordfield ;
	
	
	@FindBy(id="input-confirm")
    private WebElement passwordconfirmfield ;
	
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacypolicycheckboxfield;
	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement clickonsubmitbutton;
	
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement yesnewsletteroption;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateemailaddresswarning;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacypolicywarning;
	
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnamewarning;
	
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnamewarning;
	
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailaddresswarning;
	
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephonewarning;
	
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarning;
	
	
	public Registerpage (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void enterfirstname(String firstNameText) {
		
		firstnamefield.sendKeys(firstNameText);
	}
	
	public void  enterlastname(String lastNameText) {
		
		lastnamefield.sendKeys(lastNameText);
		
	}
	
	public void enteremail(String emailText) {
		
		emailfield.sendKeys(emailText);
		
	}
	
	public void entertelephone(String telephonetext) {
			
		telephonefield.sendKeys(telephonetext);
			
	}
	
	public void enterpassword(String passwordText) {
		
		passwordfield.sendKeys(passwordText);
		
   }
	
	public void enterpasswordconfirm(String passwordconfirmText) {
			
		passwordconfirmfield.sendKeys(passwordconfirmText);
			
	}
	
	public void selectnewsletteroption() {
		
		yesnewsletteroption.click();
	}
	
		
	public void selectprivacypolicy() {
		
		privacypolicycheckboxfield.click();
		
	}
	
	public Accountsuccesspage clickonsubmitbutton() {
		
		clickonsubmitbutton.click();
		
		return new Accountsuccesspage(driver);
	}
	
	
	public String retrieveduplicateemailaddresswarning() {
		
		String duplicateemailaddresswarningtext = duplicateemailaddresswarning.getText();
		
		return duplicateemailaddresswarningtext;
	}
	
	
	public String retrieveprivacypolicywarning() {
		
	String privacypolicywarningtext = privacypolicywarning.getText();
	
	return privacypolicywarningtext;
		
		
	}
	
	public String retrievefirstnamewarning() {
		
		String firstnamewarningtext = firstnamewarning.getText();
		
		return firstnamewarningtext;
		
		
	}
	
	public String retrievelastnamewarning() {
		
		String lastnamewarningtext = lastnamewarning.getText();
		
		return lastnamewarningtext;
		
	}
		
	public String retrieveemailaddresswarning() {
			
			String emailaddresswarningtext = emailaddresswarning.getText();
			
			return emailaddresswarningtext;
			
		}
	
	public String retrievetelephonenumberswarning() {
		
		String telephonenumberwarningtext = telephonewarning.getText();
		
		return telephonenumberwarningtext;
		
	}
	
	public String retrievepasswordwarning() {
			
			String passwordwarningtext = passwordwarning.getText();
			
			return passwordwarningtext;
			
		}
		
	
	
}
