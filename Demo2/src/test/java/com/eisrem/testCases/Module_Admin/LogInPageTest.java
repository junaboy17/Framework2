package com.eisrem.testCases.Module_Admin;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class LogInPageTest extends LogInPage{

	@Test(priority=1)
	public void UsernameCheck() {
		SoftAssert = new SoftAssert();

		try {
		SeleniumHelper.log.info("Verifying username title");
		Expected = "Username";
		Actual = Source.LogInPage().readUsernameTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying username with valid User and blank Password");
		Source.LogInPage()	.setUserName(User)
							.clickSignIn();

		Expected = "Please Enter UserName and Password";
		Actual = Source.LogInPage().readErrorMessage();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying username with invalid User and valid Password");
		Source.LogInPage()	.setUserName("baduser")
							.setPassword(Pass)
							.clickSignIn();

		Expected = "Invalid username or password. Click Here for instructions for log in assistance.";
		Actual = Source.LogInPage().readErrorMessage();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	@Test(priority=2)
	public void PasswordCheck() {
		SoftAssert = new SoftAssert();

		try {
		SeleniumHelper.log.info("Verifying Password title");
		Expected = "Password";
		Actual = Source.LogInPage().redPasswordTitle();
		SoftAssert.assertEquals(Actual, Expected);

		//Password test with only Password and blank User name
		SeleniumHelper.log.info("Verifying Password with valid Password and blank User");
		Source.LogInPage()	.setPassword("passwordonly")
							.clickSignIn();

		Expected = "Please Enter UserName and Password";
		Actual = Source.LogInPage().errorMessage.getText();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Password with valid User and invalid Password");
		Source.LogInPage()	.setUserName(User)
							.setPassword("badpassword")
							.clickSignIn();

		Expected = "Invalid username or password. Click Here for instructions for log in assistance.";
		Actual = Source.LogInPage().readErrorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Password with valid User and invalid Password");
		Source.LogInPage()	.setUserName(User)
							.setPassword(Pass, Yes)
							.clickSignIn();

		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	@Test(priority=3)
	public void LogInLogOutTest() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying successful Log in");
		
			Source				.LogInPage()	
								.setUserName(User)
								.setPassword(Pass)
								.clickSignIn();

			Expected = "Welcome " + User;
			Actual = Source.NavigationMenuBar().readWelcomeUserDropdown();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying successful Log out");
		
			Source				.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut();
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}
