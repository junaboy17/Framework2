package com.eisrem.testCases.Release2021;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11848_Invalid_Username_Error_Msg extends LogInPage {
	
	@Test(priority=1)
	public void TC_BHOPS_11848_Invalid_Username_Error_Msg() {
	
		SoftAssert = new SoftAssert();
		try {
		SeleniumHelper.log.info("Logging in with User that has invalid username & verifying error message. First Attempt");	
		Expected = "Invalid username or password. Click Here for instructions for log in assistance.";
		Actual = Source		.LogInPage()	
							.setUserName("teststststsst")
							.setPassword(RandAlpha1)
							.clickSignIn()
							.GetSource()
							.LogInPage()
							.readErrorMessage();
		
		assertEquals(Actual, Expected);
		}
		
		catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}