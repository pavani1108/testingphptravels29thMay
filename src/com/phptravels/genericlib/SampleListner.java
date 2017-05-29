package com.phptravels.genericlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;





public class SampleListner implements ITestListener{

	@Override
	public void onTestFailure(ITestResult resultObj) {
		String failedTestNAme = resultObj.getMethod().getMethodName();
	    
	    EventFiringWebDriver edriver = new EventFiringWebDriver(Browser.driver);
	    File srcFile = edriver.getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\Raveesh\\workspace\\SeleniumActitimeFrameWork\\screenShot\\"+failedTestNAme+".png") );
		                                                                                    } catch (IOException e) {}
	    
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
