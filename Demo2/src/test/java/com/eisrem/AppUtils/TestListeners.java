package com.eisrem.AppUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TestListeners implements ITestListener{
	ExtentManager em = new ExtentManager();

	ExtentReports extent = em.createInstance();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ObjectSource Source = new ObjectSource();
	String methodName;

	public void onTestStart(ITestResult result) {
		ExtentTest test = 	extent.createTest(result.getClass().getSimpleName()
				+ ": " 
				+ result.getTestClass().getName().substring(21) + " - "
				+ result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getName() + " Successful</b>";
		Markup m = MarkupHelper.createLabel(logText,  ExtentColor.GREEN); 
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		methodName = result.getName();
		String dir = System.getProperty("User.dir") + "./build/screenshots/";
		String dir2 =  "https://oit-ct1altmitch.som.w2k.state.me.us/jenkins/job/BH/job/Selenium%20Test/job/Sample%20Build/ws/build/Screenshots/";
		String screenshotName = methodName + " " + SeleniumHelper.dateOnly() + ".png";
		if (ITestResult.FAILURE == result.getStatus()) {

			String logText = "<b>Test Method " + methodName + " Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentTest.get().log(Status.FAIL, m);
			
			String message = Arrays.toString(result.getThrowable().getStackTrace());

			String exceptionMessage = result.getThrowable().getMessage();
			extentTest.get().fail("<details><summary><b><font color=red>" + "Exception occured, click to see details:"
					+ "</font></b></summary>" + exceptionMessage.replace(",", "<br>") + "</details> \n"
					+ "<details><summary><b>" + message.replace(",", "<br>") + "</details> \n");
//			try {
//				screenshotName = Source.SeleniumHelper().takeScreenShot(methodName);
//			}catch(Exception e) {
//				SeleniumHelper.log.error("Error. Unable to take screenshot for test case " + methodName);
//			}

			try {
				if(Configuration.Enviornment.screenshotEnv.equalsIgnoreCase("local")) {
					extentTest.get().fail("<b><font color=red>" + "Screenshot of Failed Page" + "</font></b>",
							MediaEntityBuilder.createScreenCaptureFromPath(dir+screenshotName).build());
				}else {
					extentTest.get().fail("<b><font color=red>" + "Screenshot of Failed Page" + "</font></b>",
							MediaEntityBuilder.createScreenCaptureFromPath(dir2+screenshotName).build());
				}

			}catch(IOException e) {
				extentTest.get().fail("Test Failed.  Unable to attach screenshot");
			}

		}

	}

	public void onTestSkipped(ITestResult result) {
		methodName = result.getMethod().getMethodName();
		String logText = "<b>Test Method " + methodName + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		extentTest.get().log(Status.SKIP, m);

		String exceptionMessage = result.getThrowable().getLocalizedMessage();
		extentTest.get().skip("<details><summary><b><font color=blue> Exception occured:"
				+ "<details><summary><b>" + exceptionMessage.replace(",", "<br>") + "</details> \n");
	}

	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
	}



}
