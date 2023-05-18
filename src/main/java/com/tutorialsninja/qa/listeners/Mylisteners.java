package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReport;
import com.tutorialsninja.qa.utils.Utitlites;

public class Mylisteners implements ITestListener {
	
	ExtentReports extentreport;
	ExtentTest extenttest;

	
	
	@Override
	public void onStart(ITestContext context) {
		
		extentreport = ExtentReport.generateExtentReport();
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		
		extenttest = extentreport.createTest(result.getName());
		extenttest.log(Status.INFO,result.getName()+" started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		extenttest.log(Status.PASS,result.getName()+" got successfully executed");

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
	     String destinationscreenshotpath = Utitlites.captureScreenshot(driver,result.getName());
	    
	    extenttest.addScreenCaptureFromPath(destinationscreenshotpath);   // we taken screenshot and attached to the report
	    extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.FAIL,result.getName()+" got failed");   
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.SKIP,result.getName()+" got skkiped");
		

		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
		
		
		String pathofextentreport = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html";
		File extentReport = new File(pathofextentreport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
