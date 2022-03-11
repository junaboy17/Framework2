package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11598_Notifications_View_Message_Content_Popup_Check extends AdministratorPage {

	
	@Test(priority=1)
	public void TC_Notifications_View_Message_Content_Popup_Check() {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Save/discard popup should not appear after clicking back to notifications");

			Expected="false";
			Actual=Source	.AdministratorNavigator()
				.clickNotifications()
				.clickFirstRow()
				.clickView()
				.NotificationsPage()
				.clickMessageContent()
				.clickBackToNotifications()
				.isSaveDiscardPopupPresent(10);
		 		
			SoftAssert.assertEquals(Actual, Expected);
		 
			SoftAssert.assertAll();	
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
}
	
}


