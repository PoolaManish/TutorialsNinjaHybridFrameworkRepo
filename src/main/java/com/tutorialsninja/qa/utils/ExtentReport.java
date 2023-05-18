package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentreport = new ExtentReports();
		
		File extentreportfile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extentreportfile);

		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Tutorialsninja Test Automation Reuslts");
		sparkreporter.config().setDocumentTitle("TN Automation Report");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkreporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		try {
		FileInputStream fis = new FileInputStream(configPropFile);
		configProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		
		}
		extentreport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentreport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
	    extentreport.setSystemInfo("Email",configProp.getProperty("validEmail"));
	    extentreport.setSystemInfo("Password",configProp.getProperty("validPassword"));
	    extentreport.setSystemInfo("Operating System",System.getProperty("os.name"));
	    extentreport.setSystemInfo("Username",System.getProperty("user.name"));
	    extentreport.setSystemInfo("Java version",System.getProperty("java.version"));
	
	  return extentreport;
	
	}

}
