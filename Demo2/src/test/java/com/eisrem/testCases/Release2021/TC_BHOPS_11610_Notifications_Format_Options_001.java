package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.AppAreaConductType;
import com.eisrem.AppUtils.Enumerations.AppModule;
import com.eisrem.AppUtils.Enumerations.LockTime;
import com.eisrem.AppUtils.Enumerations.NotificationFormat;
import com.eisrem.AppUtils.Enumerations.QuestionType;
import com.eisrem.AppUtils.Enumerations.Roles;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11610_Notifications_Format_Options_001 extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Format_Options_001() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Confirm dropdown values for Format");
					Source	.AdministratorNavigator()
							.clickNotifications()
							.clickAdd()
							.SetConditionsAccord()
							.setType("Data Fix Form")
							.setPage("Data Fix Form")
							.setQuestion("Agency Name")
							.confirmFormatValues() //Soft Asserts run in this method call
							.GetSource()
							.NotificationsPage()
							.clickBackToNotifications()
							.clickDiscard();
					SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
	
	

