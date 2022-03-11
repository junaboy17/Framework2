package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class TC_MyHomePage_Header_Functionality extends MyHomePage{

	@Test(priority=1)
	public void TC_MyHomePage_Manage_001() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'My Home Page' Header Functionality");
		Expected = "Change Password";
		Actual = Source		.NavigationMenuBar()
							.clickWelcomeUser()
							.readChangePasswordLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = "Logout";
		Actual = Source		.NavigationMenuBar()
							.readLogOutLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	

}
