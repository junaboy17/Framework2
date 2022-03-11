package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.MainPage;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Administrator.AdministratorMessagesPage;

public class TC_Security extends AdministratorPage {

	@Test(priority=1)
	public void TC_Login_Timeout_001() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Logging in & triggering session time out");
			SeleniumHelper.log.info("Verifying session timeout title");
			Expected =	"Session TimeOut Warning!";
			Actual = Source	.SeleniumHelper()
							.endCurrentUserSession(10)
							.GetSource()
							.Pagefactory()
							.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			String URL = Source	.SeleniumHelper()
								.getCurrentURL();

			ExpectedB = true;
			if(URL.contains("/home")) {
				ActualB = true;
			}else {
				ActualB = false;
			}

			SoftAssert.assertEquals(ActualB, ExpectedB);

			Expected =	"Session TimeOut Warning!";
			Actual = Source	.Pagefactory()
							.clickKeepMeLoggedIn()
							.NavigationMenuBar()
							.clickPeople()
							.GetSource()
							.SeleniumHelper()
							.endCurrentUserSession(10)
							.GetSource()
							.Pagefactory()
							.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = "Login";
			Actual = Source	.Pagefactory()
							.clickLogMeOff()
							.GetSource()
							.SeleniumHelper()
							.navigateToUrl(Configuration.Url.testPortalHome)
							.GetSource()
							.LogInPage()
							.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);

			String URL2 = Source .SeleniumHelper()
								 .getCurrentURL();

			ExpectedB = true;
			if(URL2.contains("/welcome")) {
				ActualB = true;
			}else {
				ActualB = false;
			}

			SoftAssert.assertEquals(ActualB, ExpectedB);

			Source	.SeleniumHelper()
					.navigateToUrl(Configuration.Url.testPortal);

			ExpectedB = true;
			if(URL2.contains("/welcome")) {
				ActualB = true;
			}else {
				ActualB = false;
			}

			SoftAssert.assertEquals(ActualB, ExpectedB);

			Expected =	"MY HOMEPAGE";
			Actual = Source	.LogInPage()
							.setUserName(Configuration.User.testUser)
							.setPassword(Configuration.Password.testPassword)
							.clickSignIn()
							.readMyHomePageTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}


}



