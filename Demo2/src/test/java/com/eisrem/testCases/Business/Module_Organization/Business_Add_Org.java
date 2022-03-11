package com.eisrem.testCases.Business.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class Business_Add_Org extends OrganizationPage{


	@Test(priority=1)
	public void Add_Org_Add_Screen() {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Verifying successful creation of Organization");
			Expected ="true";
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
								.readActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Success;
			Actual = Source		.OrganizationPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			String id = Source		.OrganizationPage()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrganizationName)
									.readFirstResultID()
									.replace("Select", EmptyString);	
			
			SeleniumHelper.log.info("Verifying the Organization info is updated on top");
			Expected = "Anchored to:\n"
					+ "OrgId: " + id + " | OrgName: " + OrganizationName;
			Actual = Source		.OrganizationPage()
								.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);	
			
	
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void Add_Base_Org_Location() {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Verifying successful creation of Organization");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
								.clickActiveToggle(True)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			ID = Source				.OrganizationPage()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrganizationName)
									.readDataTable(1, 1)
									.replace("Select", EmptyString);	
			
			SeleniumHelper.log.info("Verifying the Organization info is updated on top");
			Expected = "Anchored to:\n"
					+ "OrgId: " + ID + "| OrgName: " + OrganizationName;
			Actual = Source		.Pagefactory()
								.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);	
			
			
			SeleniumHelper.log.info("Verifying the Successful addition of a Location");
			Expected = Success;
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying the Successful addition of an Address");
			Expected = Success;
			Actual = Source		
								.OrganizationPage()
								.clickPopupOk()		
								.OrganizationNavigator()
								.clickAddress()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);					
								
			SeleniumHelper.log.info("Verifying the Successful addition of an Indetifier");
			Expected = Success;
			Actual = Source		.OrganizationPage()
								.clickPopupOk()		
								.OrganizationNavigator()
								.clickIdentifier()
								.DataTable()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(String.valueOf(RandNum8))
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);					
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void Other_Location() {
		SoftAssert = new SoftAssert();
		int Rand4 = SeleniumHelper.generateRandomNumber(4);
		String OrganizationName = "ACME GROUP HOME "+ Rand4;
		String LocationName = "AUGUSTA/3 GROUP HOME "+ Rand4;
		String [] Options = {"AUGUSTA"};
		
		try{
			SeleniumHelper.log.info("Verifying successful creation of Other Location & verifying the succeful Msg");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
								.clickActiveToggle(True)
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(2)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
//								.clickAddLocProviderUserToggle()
								.clickActiveToggle(True)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			String locid = Source	.Pagefactory()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickLocations()
									.setSearch(LocationName)
									.readDataTable(1, 1)
									.replace("Select", EmptyString)
									.replace(" ", EmptyString);

			Expected = OrganizationName + "/ " + LocationName;
			Actual = Source			.OrganizationNavigator()
									.clickUsersStaff()
									.clickAdd()
									.UserStaffPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.setEmail(Email)
									.setTelephone(PhoneNumber)
									.setTitle("CS USER")
//									.setTerminationDate(Tomorrow, "y")
									.clickStaffActiveToggle(True)
									.GetSource()
									.UserStaffPage()
									.clickUserInfoAccord()
									.setUserName(TestUserName)
									.setPassword(TestPassword)
									.setPasswordConfirmation(TestPassword)
									.GetSource()
									.UserHomeOfficeAccord()
									.clickUserHomeOfficeAdd()
									.setUserBaseLocation(locid)
									.clickComplete()
									.UserInfoAccord()
									.clickAdditionalOrgLocationAccord()
									.clickAdditionalOrgLocAdd()
									.selectAdditionalOrgLocServicePopulation(3)
									.setAdditionalOrgLocOrganizaiton(OrganizationName)
									.GetSource()
									.SeleniumHelper()
									.selectMultiSelectOptions(Options, Source.AdditionalOrgLocAccord().AdditionalOrgLocLocationsBtn)
									.GetSource()
									.UserStaffPage()
//									.chooseFirstAdditionalOrgLocLocations()
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.UserStaffPage()
									.clickUserInfoAccord()
									.clickAdditionalOrgLocationAccord()
									.readAdditionalOrgLocFirstRowLocation()
									.replace("Select", EmptyString);	
//			Source.SeleniumHelper().containsText(Actual, Expected);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying successful creation of Address");
			Expected = Success;
			Actual = Source		.UserStaffPage()
								.clickBackToUserStaff()
								.clickAddress()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox("3 GROUP WAY")
								.selectState("ME")
								.selectCity("AUGUSTA")
								.selectZipcode(1)
								.DataTable()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			
			SeleniumHelper.log.info("Verifying the Successful addition of a Location");
			Expected = OrganizationName + "/ " + LocationName;
			Actual = Source		
					.AddressPage()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickOrganizations()
								.setSearch("DHHS")
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch("518672")
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.setAdditionalOrgLocSearch(LocationName, Clear)
								.readAdditionalOrgLocFirstRowLocation()
								.replace("Select", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	
	@Test(priority=4)
	public void Add_Org_Staff_User() {
		SoftAssert = new SoftAssert();
		int RandNum4 = SeleniumHelper.generateRandomNumber(4);
		String OrganizationName = "ACME GROUP HOME "+ RandNum4;
		String TestUserName = FirstName + LastName + RandNum4;
		String LocationName = "AUGUSTA/3 GROUP HOME "+ RandNum4;

		try{
			SeleniumHelper.log.info("Verifying successful creation of Organization");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
								.clickActiveToggle(True)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying if locations tab is active");
			ExpectedB = T;
			ActualB = Source	.OrganizationPage()
								.clickPopupOk()
								.OrganizationNavigator()
								.isActiveTab(LocationsTab);
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			
			ID = Source			.OrganizationNavigator()
								.clickOrganizations()
								.setSearch(OrganizationName)
								.readDataTable(1, 1)
								.replace("Select", EmptyString);	
			
			SeleniumHelper.log.info("Verifying the Organization info is updated on top");
			Expected = "Anchored to:\n"
					+ "OrgId: " + ID + "| OrgName: " + OrganizationName;
			Actual = Source		.OrganizationPage()
								.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying the Successful addition of a Location");
			Expected = Success;
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
								.clickActiveToggle(True)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying if Users/Staff tab is active");
			ExpectedB = T;
			ActualB = Source		.LocationsPage()
									.clickPopupOk()
									.OrganizationNavigator()
									.isActiveTab(UsersStaffTab);
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			String locid = Source	.OrganizationNavigator()
									.clickLocations()
									.setSearch(LocationName)
									.readDataTable(1, 1)
									.replace("Select", EmptyString)
									.replace(" ", EmptyString);	
			
			SeleniumHelper.log.info("Verifying the User tab is active after clicking complete in User Home/Base Office Page");
			Expected = active;
			Actual = Source			.OrganizationNavigator()
									.clickUsersStaff()
									.clickAdd()
									.UserStaffPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.setEmail(Email)
									.setTelephone(PhoneNumber)
									.setTitle("CS USER")
//									.setTerminationDate(Tomorrow, "y")
									.clickStaffActiveToggle(True)
									.GetSource()
									.UserStaffPage()
									.clickUserInfoAccord()
									.setUserName(TestUserName)
									.setPassword(TestPassword)
									.setPasswordConfirmation(TestPassword)
									.GetSource()
									.UserHomeOfficeAccord()
									.clickUserHomeOfficeAdd()
									.setUserBaseLocation(locid)
									.clickComplete()
									.UserInfoAccord()
									.isActiveUserTab();									
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying the User tab is active after clicking complete in Roles Page");
			Expected =active;
			Actual = Source		.RolesAvailableAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole(7)
								.clickComplete()
								.UserInfoAccord()
								.isActiveUserTab();	
			SoftAssert.assertEquals(Actual, Expected);	
			
			
			SeleniumHelper.log.info("Verifying the User tab is active after clicking complete in Service Population");
			Expected = active;
			Actual = Source		
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(3)
								.clickComplete()
								.UserInfoAccord()
								.isActiveUserTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying the Successful addition of User/Staff");
			Expected = Success;
			Actual = Source		
								.UserStaffPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=5)
	public void Verify_State_Staff_Access() {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Verifying successful creation of Organization");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
								.clickActiveToggle(True)
								.setStartDate(Today, "Y")
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying if locations tab is active");
			ExpectedB = T;
			ActualB = Source		.OrganizationPage()
									.clickPopupOk()
									.OrganizationNavigator()
									.isActiveTab(LocationsTab);
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			
			String id = Source		.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrganizationName)
									.readDataTable(1, 1)
									.replace("Select", EmptyString);	
			
			SeleniumHelper.log.info("Verifying the Organization info is updated on top");
			Expected = "Anchored to:\n"
					+ "OrgId: " + id + "| OrgName: " + OrganizationName;
			Actual = Source		.OrganizationPage()
								.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying the Successful addition of a Location");
			Expected = Success;
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
								.clickActiveToggle(True)
								.setStartDate(Today, "Y")
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(Today, "Y")
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying successful addition of an Address");
			Expected = Success;
			Actual = Source			.Pagefactory()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickAddress()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress(Address, WorkAddressType, State, City, Zip, PhoneNumber, Description)
									.setStartDate(Today, "Y")
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying the Successful addition of an Indetifier");
			Expected = Success;
			Actual = Source		.OrganizationPage()
								.clickPopupOk()		
								.OrganizationNavigator()
								.clickIdentifier()
								.DataTable()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(String.valueOf(SeleniumHelper.generateRandomNumber(8)))
								.DataTable()
								.setStartDate(Today, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			SeleniumHelper.log.info("Verifying the User tab is active after clicking complete in Service Population");
			Expected = OrganizationName + "/ " + LocationName;
			Actual = Source		.OrganizationPage()
								.clickPopupOk()		
								.OrganizationNavigator()
								.clickOrganizations()
								.setSearch("DHHS")
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch("518672")
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.setAdditionalOrgLocSearch(OrganizationName)
								.readAdditionalOrgLocFirstRowLocation()
								.replace("Select", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}