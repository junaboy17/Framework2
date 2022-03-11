package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11228_Notifications_Add_Frequency_Format_Default_Check extends AdministratorPage {

	
	@Test(priority=1)
	public void TC_Notifications_Add_Frequency_Format_Default_Check() {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Save/discard popup should not appear after clicking back to notifications");

			
			Source	.AdministratorNavigator()
				.clickNotifications()
				.clickAdd()
				.NotificationsPage()
				.clickWhenAccord()
				.confirmFrequencyValue("5")
			.confirmWhenFrequencyOccurence("MINUTES");
		 		
			
		 
			SoftAssert.assertAll();	
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
}
}
