package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Notifications_Add_Role extends AdministratorPage{
	@Test(priority=1)
	public void TC_Notification_Add_Role_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Adding a new Recipient to an existing notification and verifying success message");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickNotifications()
								.DataTable()
								.setSearch("selenium")
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(2)
								.selectRole(10)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}