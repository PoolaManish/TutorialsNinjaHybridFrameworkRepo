package com.tutorials.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.Homepage;
import com.tutorialsninja.qa.pageobjects.Searchpage;

public class SearchTest extends Base {
	
	Searchpage searchpage;
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		Homepage homepage = new Homepage(driver);
		homepage.enterproductintosearchboxfield(dataprop.getProperty("validproduct"));
		searchpage = homepage.clickonsearchbutton();
		Assert.assertTrue(searchpage.displaystatusofhpvalidproduct(),"Valid product hp is not displayed in the search results");
		
		
	}
	
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		Homepage homepage = new Homepage(driver);
		homepage.enterproductintosearchboxfield(dataprop.getProperty("invalidproduct"));
		searchpage = homepage.clickonsearchbutton();
		String actualsearchmessage = searchpage.retrievenoproductmessagetext();
		Assert.assertEquals(actualsearchmessage,"abcde","No product message in search results  is not displayed");
		
		
	}
	
	
	@Test(priority=3,dependsOnMethods={"verifySearchWithValidProduct","verifySearchWithInvalidProduct"})
	public void verifySearchWithoutAnyProduct() {
		
		Homepage homepage = new Homepage(driver);
		searchpage = homepage.clickonsearchbutton();
		String actualsearchmessage = searchpage.retrievenoproductmessagetext();
		Assert.assertEquals(actualsearchmessage,dataprop.getProperty("noproducttextinsearchresults"),"No product message in search results  is not displayed");
		
		
	}

}
