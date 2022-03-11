package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.PeoplePage;

public class TC_Discard_Check extends AdministratorPage{

	@Test(priority=1)
	public void TC_Discard_Check_001() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Editing a Notification and verifying the Discard button is working properly");	
		Expected = "Do you want to save your changes?";
		String OriginalVal = Source		.AdministratorNavigator()
										.clickNotifications()
										.readFirstResultNameType();
		
		Actual = Source		.DataTable()	
							.clickFirstRow()
							.clickEdit()
							.NotificationsPage()
							.setNotificationName("NEW NOTIFICATION", Clear)
							.GetSource()
							.NavigationMenuBar()
							.clickMyHomePage()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Editing People and verifying the Discard button is working properly");	
		Expected = "Do you want to save your changes?";
		Actual = Source		.Pagefactory()
							.clickDiscard()
							.NavigationMenuBar()
							.clickPeople()
							.clickFirstRow()
							.clickEdit()
							.DemographicsPage()
							.setFirstName("Testname", Clear)
							.setEndDate(PastDate4, Clear)
							.GetSource()
							.NavigationMenuBar()
							.clickSearch()
							.GetSource()
							.Pagefactory()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying no changes have been made");	
		Expected = EmptyString;
		Actual = Source		.Pagefactory()
							.clickDiscard()
							.NavigationMenuBar()
							.clickPeople()
							.readFirstResultEndDate();
		SoftAssert.assertEquals(Actual, Expected);

		Expected = OriginalVal;
		Actual = Source		.NavigationMenuBar()
							.clickAdministrator()
							.clickNotifications()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
	
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}