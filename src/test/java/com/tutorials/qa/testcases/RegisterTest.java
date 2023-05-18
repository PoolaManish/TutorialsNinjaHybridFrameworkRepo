package com.tutorials.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.Accountsuccesspage;
import com.tutorialsninja.qa.pageobjects.Homepage;
import com.tutorialsninja.qa.pageobjects.Registerpage;
import com.tutorialsninja.qa.utils.Utitlites;

public class RegisterTest extends Base {
	
	Registerpage registerpage;
	Accountsuccesspage accountsuccesspage;
	
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		Homepage homepage = new Homepage(driver);
		homepage.clickonMyAccount();
		registerpage = homepage.selectregisteroption();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
	
	
	@Test(priority=1)
	public void verifyRegisterAnAccountWithMandatoryFields() {
		
		
	    registerpage.enterfirstname(dataprop.getProperty("firstname"));
		registerpage.enterlastname(dataprop.getProperty("lastname"));
		registerpage.enteremail(Utitlites.generateEmailWithTimeStamp());
		registerpage.entertelephone(dataprop.getProperty("telephonenumber"));
		registerpage.enterpassword(prop.getProperty("validPassword"));
		registerpage.enterpasswordconfirm(prop.getProperty("validPassword"));
		registerpage.selectprivacypolicy();
		accountsuccesspage = registerpage.clickonsubmitbutton();
				
		
		String actualsuccessheading = accountsuccesspage.retrieveaccountsuccesspageheading();
		Assert.assertEquals(actualsuccessheading,dataprop.getProperty("accountsuccessfullycreatedheading"),"Account Success page is not displayed");
		
		
	}
	
	
	    @Test(priority=2)
        public void verifyRegisterAccountByProvidingAllFields() {
        	
	    	
	    	registerpage.enterfirstname(dataprop.getProperty("firstname"));
	    	registerpage.enterlastname(dataprop.getProperty("lastname"));
	    	registerpage.enteremail(Utitlites.generateEmailWithTimeStamp());
			registerpage.entertelephone(dataprop.getProperty("telephonenumber"));
			registerpage.enterpassword(prop.getProperty("validPassword"));
			registerpage.enterpasswordconfirm(prop.getProperty("validPassword"));
            registerpage.selectnewsletteroption();
			registerpage.selectprivacypolicy();
			accountsuccesspage = registerpage.clickonsubmitbutton();
			String actualsuccessheading = accountsuccesspage.retrieveaccountsuccesspageheading();
			Assert.assertEquals(actualsuccessheading,dataprop.getProperty("accountsuccessfullycreatedheading"),"Account Success page is not displayed");
			
			
        }
	    
	    
	    
	    @Test(priority=3)
	    public void verifyRegisterAccountWithExistingEmailAddress() {
	    	
	    	registerpage.enterfirstname(dataprop.getProperty("firstname"));
	    	registerpage.enterlastname(dataprop.getProperty("lastname")); 	
	    	registerpage.enteremail(prop.getProperty("validEmail"));
	    	registerpage.entertelephone(dataprop.getProperty("telephonenumber"));
			registerpage.enterpassword(prop.getProperty("validPassword"));
			registerpage.enterpasswordconfirm(prop.getProperty("validPassword"));
            registerpage.selectnewsletteroption();
			registerpage.selectprivacypolicy();
			registerpage.clickonsubmitbutton();
			String actualwarning = registerpage.retrieveduplicateemailaddresswarning();
			Assert.assertTrue(actualwarning.contains(dataprop.getProperty("duplicateemailwarning")),"Warning message regarding duplicate email address  is not displayed");
			

	    }
	    
	    
	    @Test(priority=4)
	    public void verifyRegisterAccountWithoutFillingAnyDetails() {
	    	
	    	
	    	registerpage.clickonsubmitbutton();
			
	    	
	    	String actualprivacypolicywarning = registerpage.retrieveprivacypolicywarning();
	    	Assert.assertTrue(actualprivacypolicywarning.contains(dataprop.getProperty("privacypolicywarning")),"Privacy policy warning message is not displayed");
	    	
	    	String actualfirstnamewarning = registerpage.retrievefirstnamewarning();
	    	Assert.assertTrue(actualfirstnamewarning.contains(dataprop.getProperty("firstnamewarning")),"First name warning message is not displayed");
	    	
	    	String actuallastnamewarning = registerpage.retrievelastnamewarning();
	    	Assert.assertTrue(actuallastnamewarning.contains(dataprop.getProperty("lastnamewarning")),"Last name warning message is not displayed");
	    	
	    	String actualemailaddresswarning = registerpage.retrieveemailaddresswarning();
	    	Assert.assertTrue(actualemailaddresswarning.contains(dataprop.getProperty("emailaddresswarning")),"Email address warning message is not displayed");
	    	
	    	
	    	String actualtelephonewarning = registerpage.retrievetelephonenumberswarning();
	    	Assert.assertTrue(actualtelephonewarning.contains(dataprop.getProperty("telephonewarning")),"Telephone warning message is not displayed");
	    	
	    	String actualpasswordwarning = registerpage.retrievepasswordwarning();
	    	Assert.assertTrue(actualpasswordwarning.contains(dataprop.getProperty("passwordwarning")),"Password warning message is not displayed");  	
	    	
	    }

}
