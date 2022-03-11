package com.eisrem.testCases.Module_MyHomePage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class TC_Login_Legend_Check extends MyHomePage{

	@Test(priority = 1)
	public void TC_Login_Legend_Check_001() {
		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Tag Name for Login title");
		Expected = "legend";
		Actual = Source   	.NavigationMenuBar()
							.clickWelcomeUser()
							.clickLogOut()
							.GetSource()
							.SeleniumHelper()
							.getWebElement(Source.LogInPage().logInTitle)
							.getTagName();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Tag Name for Reset Password Title");
		Expected = "legend";
		Actual = Source   	.LogInPage()
							.clickForgotPassword()
							.GetSource()
							.SeleniumHelper()
							.getWebElement(Source.ForgotPasswordPage().verificationTitle)
							.getTagName();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
