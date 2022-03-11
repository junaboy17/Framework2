package com.eisrem.testCases.Module_MyHomePage;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.PeoplePage;

public class TC_MyHomepage_MyInbox_Forward_Inactive_User extends MyHomePage{

	@Test(priority=1)
	public void TC_MyHomepage_MyInbox_Forward_Inactive_Users() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying items in the Inbox can only be forwarded to Active Users");
			Expected = "518719 LARRABEE, ELLIE, NURSE CONSULTANT";
			Actual = Source		.MyHomePage()
								.clickMyInboxFirstResultID()
								.clickForwardToAnotherRecipient()
								.setAvailableSearch("518719")
								.readAvailableResult(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Inactive Users do not appear when trying to forward items from the Inbox");
			SizeExpected = 0;
			SizeActual = Source		.ForwardPage()
									.setAvailableSearch("157598", Clear)
									.GetSource()
									.SeleniumHelper()
									.getSelectSize(Source.ForwardPage().AvailableClientsDropdown);
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}
