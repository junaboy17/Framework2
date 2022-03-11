package com.eisrem.Hooks;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.SeleniumHelper;

public class LogInPage extends MainPage{
	
	@BeforeMethod
	public void testSetUp1(ITestResult result) {
		SeleniumHelper.log.info("Begin Test : " + result.getMethod().getMethodName());
		
		if(Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("dev")) {
			Source.DriverFactory().openBrowser(Browser);
			Source.SeleniumHelper().goToUrl(Configuration.Url.devPortal);
		}
		
		else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("uat")) {
			Source.DriverFactory().openBrowser(Browser);
			Source.SeleniumHelper().goToUrl(Configuration.Url.testPortal);
		}
		
		else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("local")) {
			Source.DriverFactory().openBrowser(Browser);
			Source.SeleniumHelper().goToUrl(Configuration.Url.localPortal);
		}
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		String MethodName = result.getName();
		
		if(ITestResult.FAILURE == result.getStatus()) {
			Source.SeleniumHelper().takeScreenShot(MethodName);
		}
		System.out.println(Data.EmptyString);
		Source.SeleniumHelper().sleep(2);
		Source.SeleniumHelper().quitBrowser();
	}

	
}
