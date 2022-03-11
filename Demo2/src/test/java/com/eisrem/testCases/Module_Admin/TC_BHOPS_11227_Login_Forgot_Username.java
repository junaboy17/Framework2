package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11227_Login_Forgot_Username extends LogInPage {
	
	@Test(priority=1)
	public void TC_Login_Forgot_Username_001() {
		SoftAssert = new SoftAssert();
		
		try{
			
			SeleniumHelper.log.info("Confirm Navigation to Forgot Username");	
			Expected = "Forgot Username\nfor EIS.";
			Actual = Source		.LogInPage()	
								.clickforgotUsername()
								.GetSource()
								.ForgotUsernamePage()
								.readForgotUsernameTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Navigation To Success Screen");
			Expected = "Username Email Sent";
			Actual = Source		.ForgotUsernamePage()	
								.setEmail(UserEmail.toUpperCase(), EmptyString)
								.setVerificationCodeOnScreen(EmptyString)
								.clickEmailMeMyUsernameBtn()
								.readSuccessMessageHeader();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Success Message text");
			Expected = "An email has been sent to the provided email address with associated username. If you do not receive an email within the next 10 minutes, please contact:";
			Actual = Source		.ForgotUsernamePage()
								.readSuccessMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Success Message different email case");
			Expected = "Username Email Sent";
			Actual = Source		.ForgotUsernamePage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()
								.clickforgotUsername()
								.GetSource()
								.ForgotUsernamePage()
								.setEmail(UserEmail.toLowerCase(), EmptyString)
								.setVerificationCodeOnScreen(EmptyString)
								.clickEmailMeMyUsernameBtn()
								.readSuccessMessageHeader();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Confirm Navigation and Error for No Usernames with Email");	
			Expected = "No Username is associated with that email. Please contact the appropriate Admin Staff for further assistance:\n"
					+ "Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "EIS.OBH@maine.gov";
			Actual = Source		.ForgotUsernamePage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()	
								.clickforgotUsername()
								.GetSource()
								.ForgotUsernamePage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()
								.clickforgotUsername()
								.GetSource()
								.ForgotUsernamePage()
								.setEmail(String.valueOf(RandNum10), EmptyString)
								.setVerificationCodeOnScreen(EmptyString)
								.clickEmailMeMyUsernameBtn()
								.errorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Navigation To Login");	
			Expected = "Login";
			Actual = Source		.ForgotUsernamePage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()
								.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
}	
	

