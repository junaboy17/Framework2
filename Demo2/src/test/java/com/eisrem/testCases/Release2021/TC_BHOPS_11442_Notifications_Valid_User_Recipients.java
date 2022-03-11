package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11442_Notifications_Valid_User_Recipients extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Valid_User_Recipients() {
		
		SoftAssert = new SoftAssert();

		try{
				SeleniumHelper.log.info("Adding a Notification, confirming that User recipients MUST be valid/selected before clicking 'Complete'.");
				Expected = "Please enter a User";
				Actual = Source	.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.clickActiveToggle()
								.setNotificationName("SELENIUM NOTIFICATION")
								.setNotificationsCriteria("Data Fix Form")
								.GetSource()
								.SetConditionsAccord()
								.setType("Data Fix Form")
								.setPage("Data Fix Form")
								.setQuestion("Agency Name")
								.selectFormat("TYPE/ANSWER IS EDITED")
								.clickSetConditionsAdd()
								.GetSource()
								.WhenAccord()
								.clickWhenAccord()
								.setNotifyIn("15")
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration("1")
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(1)
								.searchForUser("taran")
								.clickComplete()
								.Pagefactory()
								.readTopErrorMessage(1);
				SoftAssert.assertEquals(Actual, Expected);
				
				Expected = "WILSON, TARAN, COMPUTER PROGRAMMER/ USER";
				Actual = Source	.WhoAccord()
								.setUser("taran")
								.clickComplete()
								.NotificationsPage()
								.clickSubmitExit()
								.GetSource()
								.Pagefactory()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.readFirstResultNameType();
				SoftAssert.assertEquals(Actual, Expected);


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

