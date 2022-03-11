package com.eisrem.testCases.Module_Admin;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_Login_CapsLock_Check extends LogInPage{

	@Test(priority=1)
	public void TC_Login_CapsLock_Chck() {
		SoftAssert = new SoftAssert();
//
		try {
		SeleniumHelper.log.info("Verifying username title");
		
		Expected = "Caps Lock is enabled!";
		Source  	.LogInPage()
        			.setUserName(Configuration.User.testUser, Clear);
				 
		Source			.SeleniumHelper()
						.ToggleCapsLock(true);
		
		Actual = Source	.LogInPage()
						.readCapsLockErrorMessage();
					
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = "My Home Page";
		Actual = Source  	.LogInPage()
		        			.setPassword(Configuration.Password.testPassword)
		        			.clickSignIn()
		        			.GetSource()
		        			.MyHomePage()
		        			.readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);
			
		SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}
