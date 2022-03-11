package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.MainPage;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Administrator.AdministratorMessagesPage;

public class TC_Login_Timeout extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Login_Timeout_001() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Logging in & triggering session time out");
					SeleniumHelper.log.info("Verifying session timeout title");
					Expected =	"Session TimeOut Warning!";
									Source	.SeleniumHelper()
											.endCurrentUserSession();
									
					String date = 	SeleniumHelper.dateCustom("EEE MMM dd yyyy h:mm:ss a");
					
					Actual = Source	.DataTable().readPopUpTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying session timeout message to include proper day time format");
					Expected = "If you do not want to lose your current progress, click the \"Keep Me Logged In!\" button. It is "
							+ date + " Eastern Standard Time. EIS will time out in 5 minutes and you will lose any unsaved data.";
					Actual = 	Source		.DataTable()
											.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying successful Log out");
					Expected = "Login";
					Actual = 	Source		.DataTable()
											.clickLogMeOff()
											.readLogInTitle();
					SoftAssert.assertEquals(Actual, Expected);

					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

