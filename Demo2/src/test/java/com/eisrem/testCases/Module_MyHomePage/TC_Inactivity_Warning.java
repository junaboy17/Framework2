package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class TC_Inactivity_Warning extends MyHomePage{

	@Test(priority=1)
	public void TC_Login_Legend_Check_001() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Logging in & triggering session time out");
			
			Expected =	"Session TimeOut Warning!";
						Source	.SeleniumHelper()
								.endCurrentUserSession();
									
			SeleniumHelper.log.info("Verifying session timeout title");			
			Actual = Source		.DataTable()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
