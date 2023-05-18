package com.tutorials.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.Accountpage;
import com.tutorialsninja.qa.pageobjects.Homepage;
import com.tutorialsninja.qa.pageobjects.Loginpage;
import com.tutorialsninja.qa.utils.Utitlites;

public class LoginTest extends Base {
	
	Loginpage loginpage;
	
	public WebDriver driver;
	

	@BeforeMethod
	public void setup() {
		
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		Homepage homepage =  new Homepage(driver);
		homepage.clickonMyAccount();
		loginpage = homepage.Selectloginoption();
		
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
	@Test(priority=1,dataProvider="supplyTestdata")
	public void VerifyLoginWithValidCredentials(String email,String password) {
		
		
	    loginpage.enteremailaddress(email);
		loginpage.enterpasswordfield(password);
		Accountpage accountpage  = loginpage.clickonloginbutton();
		Assert.assertTrue(accountpage.getdisplaystatusofedityouraccountinformation(),"Edit Your Account Information option is not displayed");
		
	
	}
	
	@DataProvider
	public Object[][] supplyTestdata() {
		
		
		Object[][] data = Utitlites.getTestDataFromExcel("Login");
	
		return data;
	
	}
	
	
		@Test(priority=2)
		public void VerifyLoginWithInvalidCredentials() {
			
		loginpage.enteremailaddress(Utitlites.generateEmailWithTimeStamp());
		loginpage.enterpasswordfield(dataprop.getProperty("invalidPassword"));
		loginpage.clickonloginbutton();
		String ActualWarningMessage = loginpage.retriveemailpasswordnotmatchingwarningmessagetext();
		String ExpectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage),"Expected Warning Message is not disaplayed");
		
		
	}
		
		
		@Test(priority=3)
		public void VerifyLoginWithInvalidEmailAndValidPassword() {
		
			
		    loginpage.enteremailaddress(Utitlites.generateEmailWithTimeStamp());
			loginpage.enterpasswordfield(prop.getProperty("validPassword"));
			loginpage.clickonloginbutton();
			String ActualWarningMessage = loginpage.retriveemailpasswordnotmatchingwarningmessagetext();
			String ExpectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
			Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage),"Expected Warning Message is not disaplayed");
			
		}
		
		
		
		@Test(priority=4)
		public void VerifyLoginWithValidEmailAndInvalidPassword() {
			
			
			loginpage.enteremailaddress(prop.getProperty("validEmail"));
			loginpage.enterpasswordfield(dataprop.getProperty("invalidPassword"));
			loginpage.clickonloginbutton();
			String ActualWarningMessage = loginpage.retriveemailpasswordnotmatchingwarningmessagetext();
			String ExpectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
			Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage),"Expected Warning Message is not disaplayed");
			
		}
		
		
		@Test(priority=5)
		public void VerifyLoginWithoutProvidingCredentials() {
			
			loginpage.clickonloginbutton();
			String ActualWarningMessage = loginpage.retriveemailpasswordnotmatchingwarningmessagetext();
			String ExpectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
			Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage),"Expected Warning Message is not disaplayed");
				
		}
		
}
