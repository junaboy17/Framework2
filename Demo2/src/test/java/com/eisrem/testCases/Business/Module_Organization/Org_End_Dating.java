package com.eisrem.testCases.Business.Module_Organization;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class Org_End_Dating extends OrganizationPage{
	@Test(priority=1)
	public void End_Dating_Org() {
		SoftAssert = new SoftAssert();

		String userName = "GEORGEB" + SeleniumHelper.generateRandomNumber(6);
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(6);
		
		try{
			SeleniumHelper.log.info("Adding Organization with Location and Service Population");
			String idNum = Source		.DataTable()
										.setSearch(ComboboxSearchTerm)
										.clickAdd()
										.OrganizationPage()
										.setStartDate(PastDate30, Clear)
										.GetSource()
										.OrganizationPage()
										.setOrganizationName(OrganizationName)
										.selectOrganizationType(Enumerations.OrganizationType.PROVIDER.getIndex())
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.OrganizationNavigator()
										.clickOrganizations()
										.readDataTable(1, 1).replace("Select", "");
			Expected = "Anchored to:\n"
					+ "OrgId: " + idNum + "| OrgName: " + OrganizationName;
			
			Actual =	Source		.OrganizationPage()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(LocationName2)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(5))
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Services Specialties and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickServicesSpecialties()
								.ServicesSpecialtiesPage()
								.clickAdd()
								.ServicesSpecialtiesPage()
								.selectServices("RCS")
								.selectSpecialties("BASIC RATE")
								.chooseCovergeArea("STATEWIDE")
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Staff/User and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickGoBackToList()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName2)
								.setLastName(LastName2)
								.setEmail(Email)
								.setTelephone(PhoneNumber)
								.setTitle("CS USER")
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserStartDate(PastDate30, Clear)
								.setUserName(userName)
								.setPassword(userPassword2, Clear)
								.setPasswordConfirmation(userPassword2, Clear)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.AdditionalOrgLocAccord()
								.selectAdditionalOrgLocServicePopulation(3)
								.setAdditionalOrgLocOrganizaiton("36227")
								.chooseAdditionalOrgLocLocations("SANTABASE")
								.clickComplete()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole("CS PROVIDER ROLE")
								.clickComplete()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding End Date to Organization and verifying success");
			Expected = PastDate5;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickOrganization()
								.DataTable()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickEdit()
								.OrganizationPage()
								.setEndDate(PastDate5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickView()
								.OrganizationPage()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying End Dates successfully appear");
			Expected = PastDate5;
			Actual =	Source	.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickUsersStaff()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickServicesSpecialties()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
	
			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickAddress()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickIdentifier()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying User Active Toggle is set to No");
			Expected = False;
			Actual =	Source	.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readUserActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying End Dates successfully appear");
			Expected = PastDate5;
			Actual =	Source	.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.readDataTable("addtnl-loc-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.readDataTable("role-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.readDataTable("sp-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void End_Dating_Org_Staff_Access_Check() {
		SoftAssert = new SoftAssert();

		String userName = "GEORGEB" + SeleniumHelper.generateRandomNumber(6);
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(6);
		
		try{
			SeleniumHelper.log.info("Adding Organization with Location and Service Population");
			
			String idNum = Source		.DataTable()
										.setSearch(ComboboxSearchTerm)
										.clickAdd()
										.OrganizationPage()
										.setStartDate(PastDate30, Clear)
										.GetSource()
										.OrganizationPage()
										.setOrganizationName(OrganizationName)
										.selectOrganizationType("PROVIDER")
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.OrganizationNavigator()
										.clickOrganizations()
										.readDataTable(1, 1).replace("Select", "");
			Expected = "Anchored to:\n"
					+ "OrgId: " + idNum + "| OrgName: " + OrganizationName;
			
			Actual =	Source		.OrganizationPage()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(LocationName2)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(5))
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Services Specialties and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickServicesSpecialties()
								.DataTable()
								.clickAdd()
								.ServicesSpecialtiesPage()
								.selectStartDate(Today, Clear)
								.selectServices("RCS")
								.selectSpecialties("BASIC RATE")
								.chooseCovergeArea("STATEWIDE")
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Staff/User and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickGoBackToList()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()								
								.UserStaffPage()
								.setFirstName("George")
								.setLastName("Bambi")
								.setEmail(Email)
								.setTelephone(PhoneNumber)
								.setTitle("CS USER")
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(userName)
								.setPassword(userPassword2, Clear)
								.setPasswordConfirmation(userPassword2, Clear)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()					
								.selectAdditionalOrgLocServicePopulation(3)
								.setAdditionalOrgLocOrganizaiton("36227")
								.chooseAdditionalOrgLocLocations("SANTABASE")
								.clickComplete()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.GetSource()
								.RolesAvailableAccord()
								.selectRole("CS PROVIDER ROLE")
								.clickComplete()
								.UserInfoAccord()
								.GetSource()
								.SeleniumHelper().sleep(5)
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding End Date to Organization and verifying success");
			Expected = PastDate5;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickOrganization()
								.DataTable()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickEdit()
								.OrganizationPage()
								.setEndDate(PastDate5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickView()
								.OrganizationPage()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying End Dates successfully appear");
			Expected = PastDate5;
			Actual =	Source	.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickUsersStaff()
								.DataTable()
   								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickServicesSpecialties()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
	
			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickAddress()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickIdentifier()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying User Active Toggle is set to No");
			Expected = False;
			Actual =	Source	.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readUserActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying End Dates successfully appear");
			Expected = PastDate5;
			Actual =	Source	.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.readDataTable("addtnl-loc-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.readDataTable("role-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.readDataTable("sp-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying End Date Organization does not appear in list");
			Expected = "No matching records found";
			Actual =	Source	.NavigationMenuBar()
								.clickOrganization()
								.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch("148938")
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.setAdditionalOrgLocSearch(OrganizationName)
								.readDataTable("addtnl-loc-picker-table", 1, 1);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void End_Dating_Org_Location() {
		SoftAssert = new SoftAssert();

		String userName = "GEORGEB" + SeleniumHelper.generateRandomNumber(6);
		String locName = "GARDINER/SMURFDRIVE" + SeleniumHelper.generateRandomNumber(4);
		String locName2 = "GARDINER/2 TEST DRIVE "+ SeleniumHelper.generateRandomNumber(4);
		String OrgName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);	
		String SnowManAddress = "2 Snow Man Drive";

		try{
			SeleniumHelper.log.info("Adding Organization with Location and Service Population");
			
			String idNum = Source		.DataTable()
										.setSearch(ComboboxSearchTerm)
										.clickAdd()
										.OrganizationPage()
										.setStartDate(PastDate30, Clear)
										.GetSource()
										.OrganizationPage()
										.setOrganizationName(OrgName)
										.selectOrganizationType("PROVIDER")
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.OrganizationNavigator()
										.clickOrganizations()
										.readDataTable(1, 1).replace("Select", "");
			Expected = "Anchored to:\n"
					+ "OrgId: " + idNum + "| OrgName: " + OrgName;
						
			Actual =	Source		.OrganizationPage()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(locName2)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(5))
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Services Specialties and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickServicesSpecialties()
								.ServicesSpecialtiesPage()
								.clickAdd()
								.ServicesSpecialtiesPage()
								.selectServices("RCS")
								.selectSpecialties("BASIC RATE")
								.chooseCovergeArea("STATEWIDE")
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding second Location and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickGoBackToList()
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(locName)
								.selectType(2)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationPage()
								.clickAddress()
								.clickAdd()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(SnowManAddress)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Adding Staff/User and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName2)
								.setLastName(LastName2)
								.setEmail(Email)
								.setTelephone(PhoneNumber)
								.setTitle("CS USER")
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(userName)
								.setPassword(userPassword2, Clear)
								.setPasswordConfirmation(userPassword2, Clear)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation(locName2)
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.AdditionalOrgLocAccord()
								.selectAdditionalOrgLocServicePopulation(3)
								.setAdditionalOrgLocOrganizaiton("36227")
								.chooseAdditionalOrgLocLocations("SANTABASE")
								.clickComplete()
								.AdditionalOrgLocAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.AdditionalOrgLocAccord()
								.selectAdditionalOrgLocServicePopulation(3)
								.setAdditionalOrgLocOrganizaiton(OrgName)
								.chooseAdditionalOrgLocLocations(locName)
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole("CS PROVIDER ROLE")
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Person with Identifiers, Associations and verifying Success");
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()								
								.NavigationMenuBar()								
								.clickPeople()
								.clickAdd()
								.DemographicsPage()
								.setFirstName("Jeanne")
								.setLastName("Butternut")
								.selectDemographicsGender(1)
								.setDateOfBirth(DateOfBirth)
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.DemographicsPage()
								.clickIdentifiersAccord()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(Enumerations.Identifier.MEDICAID.getIndex())
								.setIdentifiersIdNumber(MedicaidIdentifierNumber)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickAssociationsTab()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(2)
								.setOrganization(OrgName)
								.GetSource()
								.Pagefactory()
								.clickSubmit()		
								.clickPopupOk()	
								.DataTable()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(2)
								.setOrganizationAssociation(OrgName, 2)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Assessment and verifying Success");
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()	
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate7, Clear)
								.GetSource()
								.Assessment_FormsPage()
								.selectAssessmentType(DataFixFormV2Assessment)
								.selectOrganization(12)
								.setTitle("Smurf Test")
								.clickStartAssessment()
								.fillForm()
								.clickSubmitAllPages()
								.readPopUpTitle();
			
			SeleniumHelper.log.info("End dating Organization Location and verifying Organization Location no longer appears");
			Expected = "No matching records found";
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickOrganization()
								.setSearch(OrgName)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickFirstRow()
								.clickAnchor()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.LocationsPage()
								.setEndDate(Today)
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.setAdditionalOrgLocSearch(locName)
								.readDataTable("addtnl-loc-picker-table", 1, 1);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	@Test(priority=4)
	public void End_Dating_Provider_User() {
		SoftAssert = new SoftAssert();

		String userName = "GEORGEB" + SeleniumHelper.generateRandomNumber(6);
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(6);
		
		try{
			SeleniumHelper.log.info("Adding Organization with Location and Service Population");
			
			String idNum = Source		.DataTable()
										.setSearch(ComboboxSearchTerm)
										.clickAdd()
										.OrganizationPage()
										.setStartDate(PastDate30, Clear)
										.GetSource()
										.OrganizationPage()
										.setOrganizationName(OrganizationName)
										.selectOrganizationType(Enumerations.OrganizationType.PROVIDER.getIndex())
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.OrganizationNavigator()
										.clickOrganizations()
										.readDataTable(1, 1).replace("Select", "");
			Expected = "Anchored to:\n"
					+ "OrgId: " + idNum + "| OrgName: " + OrganizationName;
			
			Actual =	Source		.OrganizationPage()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(LocationName2)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(5))
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Staff, Home Office, Roles and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.DataTable()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName2)
								.setLastName(LastName2)
								.setEmail(Email)
								.setTelephone(PhoneNumber)
								.clickStaffActiveToggle(True)
								.setTitle("CS USER")
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(userName)
								.setPassword(TestPassword, Clear)
								.setPasswordConfirmation(TestPassword, Clear)
								.GetSource()
								.UserHomeOfficeAccord()
								.clickUserHomeOfficeAdd()
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole("CS PROVIDER ROLE")
								.clickComplete()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging out, logging in with new User and verifying successfully able to login");
			Expected = "My Home Page";
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut()
								.setUserName(userName)
								.setPassword(TestPassword)
								.clickSignIn()
								.GetSource()
								.PasswordChangePage()
								.setCurrentPassword(TestPassword)
								.setNewPassword(TestNewPassword)
								.setConfirmNewPassword(TestNewPassword)
								.clickSubmit()
								.GetSource()
								.LogInPage()
								.setUserName(userName)
								.setPassword(TestNewPassword)
								.clickSignIn()
								.GetSource()
								.MyHomePage()
								.readMyHomePageTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging out of newly created User, logging back in as admin, and deactivating new User");
			Expected = False;
			Actual =	Source	.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut()
								.setUserName(Configuration.User.testUser)
								.setPassword(Configuration.Password.testPassword)
								.clickSignIn()
								.clickOrganization()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickStaffActiveToggle(False)
								.clickUserInfoAccord()
								.clickUserActiveToggle(False)
								.setEndDate(Today)
								.clickSubmit()
								.GetSource()
								.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.readStaffActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = False;
			Actual =	Source	.UserStaffPage()
								.clickUserInfoAccord()
								.readUserActiveToggle();							
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual =	Source	.UserInfoAccord()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual =	Source	.DataTable()
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual =	Source	.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.readDataTable("role-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Source				.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.readDataTable("sp-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying New User has been successfully deactivated");
			Expected = UserNotActiveErrorMessage;
			Actual =	Source	.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut()
								.GetSource()
								.LogInPage()
								.setUserName(userName)
								.setPassword(TestNewPassword)
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=5)
	public void Change_User_Base_Location() {
		SoftAssert = new SoftAssert();

		int RandNum5 = SeleniumHelper.generateRandomNumber(5);
		String userName = "GEORGEB" + RandNum5;
		String OrganizationName = "ACME GROUP HOME "+ RandNum5;
		String UserFirstName = "Chris" + RandNum5;
		String UserLastName = "Bacon";
		String UserEmail = UserFirstName + UserLastName + "@Test.Gov";
		String UserPhoneNumber = String.valueOf(RandNum10);
		
		try{
			SeleniumHelper.log.info("Adding Organization with Location and Service Population");
			
			String idNum = Source		.DataTable()
										.setSearch(ComboboxSearchTerm)
										.clickAdd()
										.OrganizationPage()
										.setStartDate(PastDate30, Clear)
										.GetSource()
										.OrganizationPage()
										.setOrganizationName(OrganizationName)
										.selectOrganizationType(Enumerations.OrganizationType.PROVIDER.getIndex())
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.OrganizationNavigator()
										.clickOrganizations()
										.readDataTable(1, 1).replace("Select", "");
			Expected = "Anchored to:\n"
					+ "OrgId: " + idNum + "| OrgName: " + OrganizationName;
			
			Actual =	Source		.OrganizationPage()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(LocationName2)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30 + Keys.TAB, Clear)
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(RandNum5)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Location with Service Population and verifying Success message");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(Address)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(2)
								.setPhone(UserPhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Staff/User, User Info and verifying Success message");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(UserFirstName)
								.setLastName(UserLastName)
								.setEmail(UserEmail)
								.clickStaffActiveToggle(True)
								.setTitle("CS USER")
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserStartDate(PastDate45, Clear)
								.setUserName(userName)
								.setPassword(TestPassword)
								.setPasswordConfirmation(TestPassword)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserHomeOfficeStartDate(PastDate30, Clear)
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.GetSource()
								.RolesAvailableAccord()
								.selectRole(Enumerations.Roles.CS_PROVIDER_ROLE.getIndex())
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Staff/User and verifying Success message");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickOrganization()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserHomeOfficeStartDate(Today, Clear)
								.setUserBaseLocation(" ")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying End Date is successfully added");
			Expected = Yesterday;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDataTable("loc-picker-table", 2, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=6)
	public void End_Dating_Org_Not_In_Dropdowns() {
		SoftAssert = new SoftAssert();

		String userName = "GEORGEB" + SeleniumHelper.generateRandomNumber(6);
		String OrgName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(6);
		String NoMatch = "No matching records found";
		
		try{
			SeleniumHelper.log.info("Adding Organization with Location and Service Population");
			
			String idNum = Source		.DataTable()
										.setSearch(ComboboxSearchTerm)
										.clickAdd()
										.OrganizationPage()
										.setStartDate(PastDate30, Clear)
										.GetSource()
										.OrganizationPage()
										.setOrganizationName(OrgName)
										.selectOrganizationType(Enumerations.OrganizationType.PROVIDER.getIndex())
										.clickActiveToggle(True)
										.clickSubmit()
										.clickPopupOk()
										.OrganizationNavigator()
										.clickOrganizations()
										.readDataTable(1, 1).replace("Select", "");
			Expected = "Anchored to:\n"
					+ "OrgId: " + idNum + "| OrgName: " + OrgName;
			
			Actual =	Source		.OrganizationPage()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.LocationsPage()
								.setName(LocationName2)
								.clickActiveToggle(True)
								.GetSource()
								.LocationsPage()
								.selectType(1)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle(True)
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Address and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address)
								.selectCity("GARDINER")
								.selectZipcode(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.Pagefactory()
								.setStartDate(PastDate30, Clear)
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(5))
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Services Specialties and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickServicesSpecialties()
								.ServicesSpecialtiesPage()
								.clickAdd()
								.ServicesSpecialtiesPage()
								.selectServices("RCS")
								.selectSpecialties("BASIC RATE")
								.chooseCovergeArea("STATEWIDE")
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Staff/User and verifying success");
			Expected = Success;
			Actual =	Source	.Pagefactory()
								.clickGoBackToList()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName2)
								.setLastName(LastName2)
								.setEmail(Email)
								.setTelephone(PhoneNumber)
								.setTitle("CS USER")
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserStartDate(PastDate30, Clear)
								.setUserName(userName)
								.setPassword(userPassword2, Clear)
								.setPasswordConfirmation(userPassword2, Clear)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.AdditionalOrgLocAccord()
								.selectAdditionalOrgLocServicePopulation(3)
								.setAdditionalOrgLocOrganizaiton("36227")
								.chooseAdditionalOrgLocLocations("SANTABASE")
								.clickComplete()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole("CS PROVIDER ROLE")
								.clickComplete()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding End Date to Organization and verifying success");
			Expected = PastDate5;
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickOrganization()
								.DataTable()
								.setSearch(OrgName)
								.clickFirstRow()
								.clickEdit()
								.OrganizationPage()
								.setEndDate(PastDate5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(OrgName)
								.clickFirstRow()
								.clickView()
								.OrganizationPage()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying End Dates successfully appear");
			Expected = PastDate5;
			Actual =	Source	.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(OrgName)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickUsersStaff()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickServicesSpecialties()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
	
			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickLocations()
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickAddress()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.OrganizationNavigator()
								.clickIdentifier()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying User Active Toggle is set to No");
			Expected = False;
			Actual =	Source	.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readUserActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying End Dates successfully appear");
			Expected = PastDate5;
			Actual =	Source	.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.readDataTable("addtnl-loc-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.readDataTable("role-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			Expected = PastDate5;
			Actual =	Source	.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.readDataTable("sp-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = NoMatch;
			Actual =	Source	.NavigationMenuBar()
								.clickOrganization()
								.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch("148938")
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.setAdditionalOrgLocSearch(OrgName)
								.readAdditionalOrgLocFirstRowID();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = NoMatch;
			Actual =	Source	.UserInfoAccord()
								.clickUserHomeOfficeAccord()
								.setUserHomeOfficeSearch(OrgName)
								.readUserHomeOfficeFirstRowID();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = NoMatch;
			Actual =	Source	.NavigationMenuBar()
								.clickPeople()
								.setSearch("333415")
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.setSearch(OrgName)
								.readFirstResultID();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}