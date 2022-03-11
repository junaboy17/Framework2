package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;
import com.google.common.base.Enums;

public class TC_Organization_Users_End_Date_Location extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_Users_End_Date_Location_001() {
		SoftAssert = new SoftAssert();

		int RandNum4 = SeleniumHelper.generateRandomNumber(4);
		String OrganizationName = "ACME GROUP HOME "+ RandNum4;
		String BaseLocation = "USS ENTERPRISE 1";
		String BaseLocation2 = "USS ENTERPRISE 2";
		String OtherLocation = "USS STARGAZER 1";
		String UserName = "testuser" + RandNum4;
		String ID;

		try {
			SeleniumHelper.log.info("Adding Organization with Base Location and verifying success ");
			ID = Source		.OrganizationPage()
							.addCompleteOrganizationPageAndSubmit(OrganizationName, OrganizationType.OTHER, Today, null, true, Description)
							.clickAdd()
							.LocationsPage()
							.setName(BaseLocation)
							.selectType(1)
							.setStartDate(Today, Clear)
							.GetSource()
							.LocationsPage()
							.clickActiveToggle(True)
							.DataTable()
							.clickAdd()
							.ServicePopulationsAvailableAccord()
							.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
							.clickComplete()
							.Pagefactory()
							.clickSubmit()
							.clickPopupOk()
							.OrganizationPage()
							.clickLocations()
							.DataTable()
							.readFirstResultID();

			Expected = "This Organization already has a base location for the specific date range: " + BaseLocation + " (" + ID + "). Would you like to add an end-date of " + PastDate4 + " to the previous base location record?";

			Actual = Source		.DataTable()		
								.clickAdd()
								.LocationsPage()
								.setName(BaseLocation2)
								.selectType(1)
								.setStartDate(PastDate3, Clear)
								.GetSource()
								.LocationsPage()
								.clickActiveToggle(True)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpMessage();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Adding Other Location to Organization, User/Staff, assigning Base Location and verifying success");
			Expected = FutureDate6;
			Actual = Source		.OrganizationPage()
								.clickNo()
								.Pagefactory()
								.clickBackTo()
								.Pagefactory()
								.clickDiscard()
								.DataTable()
								.clickAdd()
								.LocationsPage()
								.setName(OtherLocation)
								.selectType(2)
								.setStartDate(Today, Clear)
								.clickActiveToggle(True)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName)
								.setLastName(LastName)
								.clickUserInfoAccord()
								.setUserStartDate(Today, Clear)
								.setUserName(UserName)
								.setPassword(userPassword2)
								.setPasswordConfirmation(userPassword2)
								.DataTable()
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation(BaseLocation)
								.setUserHomeOfficeStartDate(Today, Clear)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation(OtherLocation)
								.setUserHomeOfficeStartDate(FutureDate7, Clear)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.setSearch(BaseLocation)
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = "";
			Actual = Source		.DataTable()
								.setSearch(OtherLocation, Clear)
								.readFirstResultEndDate();
					
			SoftAssert.assertEquals(Actual, Expected);			
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}