package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class TC_Combobox extends PeoplePage {

	@Test(priority=1)
	public void TC_Combobox_TypeAmpersand_001() {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = Success;
			Actual = Source		.DataTable()
								.setSearch(LastName)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(2)
								.setOrganizationAssociation("R&", Clear)
								.clickBackToAssociation()
								.clickDiscard()
								.PeopleNavigator()
								.readAssociationsTab();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Combobox_Row_Count_001() {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = Success;
			Actual = Source		.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName("Test Notification")
								.setDescription(Description)
								.GetSource()
								.SetConditionsAccord()
								.setType("Initial Contact")
								.setPage("Beyond")
								.readQuestionXbtn();
								
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}


}


