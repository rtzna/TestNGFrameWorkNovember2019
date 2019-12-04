package com.hubspot.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class ExtendReportListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
				
	}

	public void onStart(ITestContext arg0) {
				
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
				
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the test case is failed: "+ result.getName());
				
	}

	public void onTestSkipped(ITestResult skipped) {
		System.out.println(skipped.getName());
	}

	public void onTestStart(ITestResult context) {
		Reporter.log("About to begin executing test: "+ context.getName(), true);
				
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test is passed: " +result.getName());
				
	}
	
	
	//Why we use listener? We can get somer reports. We can get HTML report and mailable report or TestNG report. All report are generated after the tests
	//Listener report: it starts with test case stop with test case. If you have any problem listener can report you.
	
	

}
