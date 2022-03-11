package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class TC_BHOPS_11549_Login_Change_Password_Legend_Check extends MyHomePage {

	
	@Test(priority=1)
	public void TC_Change_Password_Legend_Check() {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Confirming that 'Verification' legend is present on Change Password page");

			Expected= True;
			
			Actual=Source	.MyHomePage()
							.expandUserMenu()
							.selectChangePassword()
							.GetSource()
							.ChangePasswordPage()
							.checkLegendExists();
					
		 		
			SoftAssert.assertEquals(Actual, Expected);
		 
			SoftAssert.assertAll();	
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
}
	
}


