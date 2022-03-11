package com.eisrem.testCases.Business.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class Add_Org_Staff extends OrganizationPage{


	@Test(priority=1)
	public void Add_Org_Provider_Staff_User() {
		SoftAssert = new SoftAssert();
		int RandNum5 = SeleniumHelper.generateRandomNumber(5);
		String OrganizationName = "ACME GROUP HOME "+ RandNum5;
		String LocationName = "GARDINER/2 TEST DRIVE "+ RandNum5;
		String FirstName = "Chris" + RandNum5;
		String LastName = "Bacon";
		String PhoneNumber = String.valueOf(RandNum10);
		String Email = FirstName + LastName + "@Test.Gov";
		String TestUserName = FirstName + LastName;
		String TestPassword = "Summer21#";

		try{
			SeleniumHelper.log.info("Verifying successful addition of Provider Staff User");
			
				String ID = Source		.DataTable()
										.clickAdd()
										.OrganizationPage()
										.setOrganizationName(OrganizationName)
										.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.GetSource()
										.OrganizationNavigator()
										.clickOrganizations()
										.readFirstResultID();
				
			Expected = "Anchored to:\n"
						+ "OrgId: " + ID + " | OrgName: " + OrganizationName;
				
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.DataTable()
								.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);

			ExpectedB = T;	
			ActualB = Source	.OrganizationNavigator()
								.isActiveTab(LocationsTab);
			SoftAssert.assertEquals(ActualB, ExpectedB);

			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
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

			Expected = Success;
			Actual = Source			.OrganizationNavigator()
									.clickUsersStaff()
									.clickAdd()
									.UserStaffPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.setEmail(Email)
									.setTelephone(PhoneNumber)
									.setTitle("CS USER")
									.clickStaffActiveToggle(True)
									.GetSource()
									.UserStaffPage()
									.clickUserInfoAccord()
									.setUserName(TestUserName)
									.setPassword(TestPassword)
									.setPasswordConfirmation(TestPassword)
									.clickUserActiveToggle(True)
									.GetSource()
									.UserHomeOfficeAccord()
									.clickUserHomeOfficeAdd()
									.setUserBaseLocation(locid)
									.clickComplete()
									.UserInfoAccord()
									.clickAdditionalOrgLocationAccord()
									.clickAdditionalOrgLocAdd()
									.selectAdditionalOrgLocServicePopulation(3)
									.setAdditionalOrgLocOrganizaiton("DHHS/ STATE OF MAINE")
									.chooseFirstAdditionalOrgLocLocations()
									.clickComplete()
									.RolesAvailableAccord()
									.clickRolesAvaiableAccord()
									.clickRolesAdd()
									.selectRole(Roles.CS_PROVIDER_ROLE.getName())
									.clickComplete()
									.ServicePopulationsAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
									.clickComplete()
									.UserStaffPage()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying user is taken back to UserStaff page after successful addition");
			ExpectedB = true;
			ActualB = Source		.Pagefactory()
									.clickPopupOk()
									.OrganizationNavigator()
									.isActiveTab(UsersStaffTab);
			SoftAssert.assertEquals(Actual, Expected);


			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=2)
	public void Verify_Provider_Staff_Access() {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);
		String LocationName = "GARDINER/2 TEST DRIVE "+ SeleniumHelper.generateRandomNumber(4);
		String FirstName = "Chris" + RandNum2;
		String LastName = "Bacon" + RandNum3;
		String PhoneNumber = String.valueOf(RandNum10);
		String Email = FirstName + LastName + RandNum4 + "@Test.Gov";
		String TestUserName = FirstName + LastName;

		String[] Values =  {"App Areas", "MY HOMEPAGE", "PEOPLE", "ORGANIZATION", "ASSESSMENT/FORMS", "NOTES", "REPORTABLE EVENT", "QUICK LINKS"};		

		try{
			SeleniumHelper.log.info("Add a provider user & verifying authorization access");
			
			String ID = Source	.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
								.clickActiveToggle(True)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.GetSource()
								.OrganizationNavigator()
								.clickOrganizations()
								.readFirstResultID();
			
			Expected = "Anchored to:\n"
					+ "OrgId: " + ID + " | OrgName: " + OrganizationName;
			
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.DataTable()
								.readAnchoredInfo();
		SoftAssert.assertEquals(Actual, Expected);
								
			Expected = Success;	
			Actual = Source				
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
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


			Source			.OrganizationNavigator()
							.clickUsersStaff()
							.clickAdd()
							.UserStaffPage()
							.setFirstName(FirstName)
							.setLastName(LastName)
							.setEmail(Email)
							.setTelephone(PhoneNumber)
							.setTitle("CS USER")
							.clickStaffActiveToggle(True)
							.GetSource()
							.UserStaffPage()
							.clickUserInfoAccord()
							.setUserName(TestUserName)
							.setPassword(TestPassword)
							.setPasswordConfirmation(TestPassword)
							.clickUserActiveToggle(True)
							.GetSource()
							.UserHomeOfficeAccord()
							.clickUserHomeOfficeAdd()
							.setUserBaseLocation(locid)
							.clickComplete()		
							.RolesAvailableAccord()
							.clickRolesAvaiableAccord()
							.clickRolesAdd()
							.selectRole(Roles.CS_PROVIDER_ROLE.getName())
							.clickComplete()
							.ServicePopulationsAvailableAccord()
							.clickServicePopulationAvailableAccord()
							.clickSpAdd()
							.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
							.clickComplete()
							.UserStaffPage()
							.clickSubmit()
							.clickPopupOk()
							.NavigationMenuBar()
							.clickPeople()
							.setSearch(JeanneClient)
							.clickFirstRow()
							.clickAnchor()
							.PeopleNavigator()
							.clickAssociationsTab()
							.clickAdd()
							.AssociationsPage()
							.selectAssociationType(AssociationType.ORGANIZATION.getName())
							.setOrganization(OrganizationName)
							.clickSubmit()
							.clickPopupOk()
							.NavigationMenuBar()
							.LogOut()
							.LogIn(TestUserName, TestPassword, Clear)
							.GetSource()
							.PasswordChangePage()
							.setCurrentPassword(TestPassword)
							.setNewPassword(TestNewPassword)
							.setConfirmNewPassword(TestNewPassword)
							.clickSubmit()
							.GetSource()
							.LogInPage()
							.LogIn(TestUserName, TestNewPassword, Clear)
							.VerifyModuleAccess(Values);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

}