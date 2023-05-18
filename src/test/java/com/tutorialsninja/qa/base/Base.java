package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.tutorialsninja.qa.utils.Utitlites;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public void loadPropertiesFile() {
		
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
		
		dataprop = new Properties();
		File datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try {
		FileInputStream fis2 = new FileInputStream(datapropfile);
		dataprop.load(fis2);
		}catch(Throwable e) {
			
			e.printStackTrace();
		}
		
		
		
		try {
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		} catch(Throwable e) {
			
			e.printStackTrace();
		}
	}
	

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
		
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			EdgeOptions options2 = new EdgeOptions();
			options2.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver();
			
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utitlites.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
