package com.eisrem.Hooks;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;

import org.apache.log4j.Logger;


public class PasswordChange extends MainPage{

	@BeforeMethod
	public void testSetUp1(ITestResult result) {
		SeleniumHelper.log.info("Begin Test : " + result.getMethod().getMethodName());
		
		if(Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("dev")) {
				Source.DriverFactory().openBrowser(Browser);
				Source.SeleniumHelper().goToUrl(Configuration.Url.devPortal);
				Source	.LogInPage()
						.setUserName(Configuration.User.devUser)
						.setPassword(Configuration.Password.devPassword)
						.clickSignIn()
						.clickWelcomeUser()
						.clickChangePassword();
		}
		
		else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("uat")) {
			Source.DriverFactory().openBrowser(Browser);
			Source.SeleniumHelper().goToUrl(Configuration.Url.testPortal);
			Source	.LogInPage()
					.setUserName(Configuration.User.testUser)
					.setPassword(Configuration.Password.testPassword)
					.clickSignIn()
					.clickWelcomeUser()
					.clickChangePassword();
		}
		
		else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("local")) {
			Source.DriverFactory().openBrowser(Browser);
			Source.SeleniumHelper().goToUrl(Configuration.Url.localPortal);
			Source	.LogInPage()
					.setUserName(Configuration.User.devUser)
					.setPassword(Configuration.Password.devPassword)
					.clickSignIn()
					.clickWelcomeUser()
					.clickChangePassword();
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


