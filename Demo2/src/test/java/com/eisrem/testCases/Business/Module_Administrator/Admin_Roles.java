package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.pageFactory.Administrator.RolesPage;

public class Admin_Roles extends AdministratorPage {

	@Test(priority=1)
	public void Add_Role() {

		SoftAssert = new SoftAssert();
		
		int RandNum4 = SeleniumHelper.generateRandomNumber(4);
		String RoleName= "TC_ROLE_SELENIUM " + RandNum4;

		try{
			SeleniumHelper.log.info("Verifying Quick Links function is working successfully");
			Expected =	True;
			Actual =	Source		.AdministratorNavigator()
									.clickRoles()
									.clickAdd()
									.RolesPage()
									.setRoleName(RoleName)
									.clickActiveToggle(True)
									.setDescription(Description)
									.GetSource()
									.RolesPage()
									.clickViewAllClientsToggle(True)
									.clickAppAreaAccord()
									.clickAppToggle(PeopleApp, True)
									.clickAppToggle(OrganizationApp, True)
									.clickAppToggle(My_HomepageApp, True)
									.clickAppToggle(NotesApp, True)
									.clickAppAreaModulesAccord()
									.selectAppAreaModulesShowEntries(2)
									.setSearchAppAreaModules(NotesApp)
									.clickModuleToggle(NotesModules, Active, True)
									.clickModuleToggle(NotesModules, Add, True)
									.clickModuleToggle(NotesModules, View, True)
									.clickModuleToggle(NotesModules, Edit, True)
									.setSearchAppAreaModules(OrganizationApp, Clear)
									.clickModuleToggle(OrganizationsModules, View, True)
									.setSearchAppAreaModules(PeopleApp, Clear)
									.clickModuleToggle(DemographicsModules, Active, True)
									.clickModuleToggle(DemographicsModules, View, True)
									.clickModuleToggle(PeopleModules, Active, True)
									.clickModuleToggle(PeopleModules, View, True)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(RoleName)
									.clickFirstRow()
									.clickView()
									.RolesPage()
									.readActiveToggle();				
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Active and View All Clients toggles are set to YES");
			Expected =	True;
			Actual =	Source		.RolesPage()
					.readViewAllClientsToggle();				
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=2)
	public void Assign_Role() {

		SoftAssert = new SoftAssert();
		int randNum5 = SeleniumHelper.generateRandomNumber(5);
		String [] AppList = {AppAreas, My_HomepageApp, PeopleApp, OrganizationApp, NotesApp};
		String RoleName= "TC_ROLE_SELENIUM " + randNum5;
		String UserName = "OIT" + randNum5;
		String OrganizationName = "ACME GROUP HOME "+ randNum5;

		try{
			SeleniumHelper.log.info("Verifying Assign Roles function is working successfully");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
									.clickRoles()
									.clickAdd()
									.RolesPage()
									.setRoleName(RoleName)
									.clickActiveToggle(True)
									.setDescription(Description)
									.GetSource()
									.RolesPage()
									.clickViewAllClientsToggle(True)
									.clickAppAreaAccord()
									.clickAppToggle(PeopleApp, True)
									.clickAppToggle(OrganizationApp, True)
									.clickAppToggle(My_HomepageApp, True)
									.clickAppToggle(NotesApp, True)
									.clickAppAreaModulesAccord()
									.selectAppAreaModulesShowEntries(2)
									.setSearchAppAreaModules(NotesApp)
									.clickModuleToggle(NotesModules, Active, True)
									.clickModuleToggle(NotesModules, Add, True)
									.clickModuleToggle(NotesModules, View, True)
									.clickModuleToggle(NotesModules, Edit, True)
									.setSearchAppAreaModules(OrganizationApp, Clear)
									.clickModuleToggle(OrganizationsModules, View, True)
									.setSearchAppAreaModules(PeopleApp, Clear)
									.clickModuleToggle(DemographicsModules, Active, True)
									.clickModuleToggle(DemographicsModules, View, True)
									.clickModuleToggle(PeopleModules, Active, True)
									.clickModuleToggle(PeopleModules, View, True)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Adding an Organization");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.NavigationMenuBar()
									.clickOrganization()
									.clickAdd()
									.OrganizationPage()
									.setOrganizationName(OrganizationName)
									.selectOrganizationType(2)
									.clickActiveToggle(True)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);			

			SeleniumHelper.log.info("Adding a Location");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.LocationsPage()
									.setName(LocationName2)
									.clickActiveToggle(True)
									.GetSource()
									.LocationsPage()
									.selectType(1)
									.setPhone(PhoneNumber)
									.clickAddLocStateUserToggle(True)
									.clickAddLocProviderUserToggle(True)
									.clickAdd()
									.ServicePopulationsAvailableAccord()
									.selectServicePopulation(3)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Adding a User/Staff");
			Expected =	"Users Home/Base Office:";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.UserStaffPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.setEmail(Email)
									.setTelephone(PhoneNumber)
									.clickActiveToggle(True)
									.GetSource()
									.UserStaffPage()
									.setTitle("CS USER")
									.clickUserInfoAccord()
									.clickUserActiveToggle(True)
									.setUserName(UserName)
									.setPassword(TestPassword)
									.setPasswordConfirmation(TestPassword)
									.GetSource()
									.UserHomeOfficeAccord()	
									.clickUserHomeOfficeAdd()
									.setUserBaseLocation(LocationName2)
									.clickComplete()
									.UserInfoAccord()
									.readUserHomeOfficeAccord();		
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Assigning a Role");
			Expected =	"Roles Available:";
			Actual =	Source		.UserInfoAccord()
									.clickRolesAvaiableAccord()
									.clickRolesAdd()
									//RoleName/16 
									.selectRole(RoleName)
									.clickRolesComplete()
									.UserInfoAccord()
									.readRolesAvailableAccord();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Assigning a Service Population");
			Expected =	"Service Population Available:";
			Actual =	Source		.UserInfoAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(3)
									.clickComplete()
									.UserInfoAccord()
									.readServicePopulationAvailableAccord();
			SoftAssert.assertEquals(Actual, Expected);	

			Expected =	Success;
			Actual =	Source		.Pagefactory()
					.clickSubmit()
					.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Testing new user login, changing password and using new password to log in and verify module access");
			Source		.Pagefactory()
						.clickPopupOk()
						.NavigationMenuBar()
						.clickWelcomeUser()
						.clickLogout()
						.GetSource()
						.LogInPage()
						.setUserName(UserName)
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
						.setUserName(UserName)
						.setPassword(TestNewPassword)
						.clickSignIn()
						.GetSource()
						.NavigationMenuBar()
						.VerifyModuleAccess(AppList);
						SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=3)
	public void Test_Notes_Access_For_Role() {
		SoftAssert = new SoftAssert();
		int RandNum6 = SeleniumHelper.generateRandomNumber(6);
		String [] AppList = {AppAreas, My_HomepageApp, PeopleApp, OrganizationApp, NotesApp};
		String RoleName= "TC_ROLE_SELENIUM " + RandNum6;
		String UserName = "OIT" + RandNum6;
		String OrganizationName = "ACME GROUP HOME "+ RandNum6;

		try{
			SeleniumHelper.log.info("Verifying Assign Roles function is working successfully");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
									.clickRoles()
									.clickAdd()
									.RolesPage()
									.setRoleName(RoleName)
									.clickActiveToggle(True)
									.setDescription(Description)
									.GetSource()
									.RolesPage()
									.clickViewAllClientsToggle(True)
									.clickAppAreaAccord()
									.clickAppToggle(PeopleApp, True)
									.clickAppToggle(OrganizationApp, True)
									.clickAppToggle(My_HomepageApp, True)
									.clickAppToggle(NotesApp, True)
									.clickAppAreaModulesAccord()
									.selectAppAreaModulesShowEntries(2)
									.setSearchAppAreaModules(NotesApp)
									.clickModuleToggle(NotesModules, Active, True)
									.clickModuleToggle(NotesModules, Add, True)
									.clickModuleToggle(NotesModules, View, True)
									.clickModuleToggle(NotesModules, Edit, True)
									.setSearchAppAreaModules(OrganizationApp, Clear)
									.clickModuleToggle(OrganizationsModules, View, True)
									.setSearchAppAreaModules(PeopleApp, Clear)
									.clickModuleToggle(DemographicsModules, Active, True)
									.clickModuleToggle(DemographicsModules, View, True)
									.clickModuleToggle(PeopleModules, Active, True)
									.clickModuleToggle(PeopleModules, View, True)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Adding an Organization");
			Expected =	Success;
			Actual =	Source		
									.Pagefactory()
									.clickPopupOk()
									.AdministratorNavigator()
									.clickTypes()
									.setSearch("Transition Note V4/ Notes")
									.clickFirstRow()
									.clickEdit()
									.DataTable()
									.setSearch("Transition Note (V4)")
									.clickFirstRow()
									.clickEdit()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(RoleName)
									.clickRolesComplete()
									.Pagefactory()
									.clickComplete()
									.SeleniumHelper().sleep(20)
									.DataTable()
									.setSearch("Transition Discharge Note V3")
									.clickFirstRow()
									.clickEdit()
									.DataTable()
									.clickAdd()
									.RolesAvailableAccord()
									.selectRole(RoleName)
									.clickRolesComplete()
									.Pagefactory()
									.clickComplete()
									.SeleniumHelper().sleep(20)
									.DataTable()
									.clickSubmit()
																	
									.GetSource()
									.SeleniumHelper().sleep(20)
									.GetSource()
									.NavigationMenuBar()
									.clickOrganization()
									.clickAdd()
									.OrganizationPage()
									.setOrganizationName(OrganizationName)
									.selectOrganizationType(2)
									.clickActiveToggle(True)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);			

			SeleniumHelper.log.info("Adding a Location");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.LocationsPage()
									.setName(LocationName2)
									.clickActiveToggle(True)
									.GetSource()
									.LocationsPage()
									.selectType(1)
									.setPhone(PhoneNumber)
									.clickAddLocStateUserToggle(True)
									.clickAddLocProviderUserToggle(True)
									.clickAdd()
									.ServicePopulationsAvailableAccord()
									.selectServicePopulation(3)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Adding a User/Staff");
			Expected =	"Users Home/Base Office:";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.UserStaffPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.setEmail(Email)
									.setTelephone(PhoneNumber)
									.clickActiveToggle(True)
									.GetSource()
									.UserStaffPage()
									.setTitle("CS USER")
									.clickUserInfoAccord()
									.clickUserActiveToggle(True)
									.setUserName(UserName)
									.setPassword(TestPassword)
									.setPasswordConfirmation(TestPassword)
									.GetSource()
									.UserHomeOfficeAccord()	
									.clickUserHomeOfficeAdd()
									.setUserBaseLocation(LocationName2)
									.clickComplete()
									.UserInfoAccord()
									.readUserHomeOfficeAccord();		
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Assigning a Role");
			Expected =	"Roles Available:";
			Actual =	Source		.UserInfoAccord()
									.clickRolesAvaiableAccord()
									.clickRolesAdd()
									//RoleName
									.selectRole(RoleName)
									.clickRolesComplete()
									.UserInfoAccord()
									.readRolesAvailableAccord();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Assigning a Service Population");
			Expected =	"Service Population Available:";
			Actual =	Source		.UserInfoAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(3)
									.clickComplete()
									.UserInfoAccord()
									.readServicePopulationAvailableAccord();
			SoftAssert.assertEquals(Actual, Expected);	

			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Testing new user login, changing password and using new password to log in and verify module access");
			Source		.Pagefactory()
						.clickPopupOk()
						.NavigationMenuBar()
						.clickWelcomeUser()
						.clickLogout()
						.GetSource()
						.LogInPage()
						.setUserName(UserName)
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
						.setUserName(UserName)
						.setPassword(TestNewPassword)
						.clickSignIn()
						.GetSource()
						.NavigationMenuBar()
						.VerifyModuleAccess(AppList);

			SeleniumHelper.log.info("Verifying module access");			
			SoftAssert.assertEquals(Actual, Expected);	

			Expected =	JeanneTest + "/ Transition Note V4";
			Actual =	Source		.NavigationMenuBar()
									.clickPeople()
									.setSearch(JeanneClient)
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickNotes()
									.DataTable()
									.clickAdd()
									.NotesPage()
									//No notes available
									.selectNotesType(1)
									.setTitle(JeanneTest)
									.clickStartNotes()
									.selectValue(1, "District", 8)
									.selectValue(1, "Youth", 1)
									.setText(8, "Signature", JeanneSignature)
									.clickSubmitAllPages()
									.clickGoBackToList()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);		

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=4)
	public void End_Date_Role() {

		SoftAssert = new SoftAssert();
		int RandNum6 = SeleniumHelper.generateRandomNumber(6);
		
		String [] AppList = {AppAreas, My_HomepageApp, PeopleApp, OrganizationApp, NotesApp};
		String RoleName= "TC_ROLE_SELENIUM " + RandNum6;
		String UserName = "OIT" + RandNum6;
		String OrganizationName = "ACME GROUP HOME "+ RandNum6;

		try{
			SeleniumHelper.log.info("Verifying Assign Roles function is working successfully");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
									.clickRoles()
									.clickAdd()
									.RolesPage()
									.setRoleName(RoleName)
									.clickActiveToggle(True)
									.setDescription(Description)
									.GetSource()
									.RolesPage()
									.clickViewAllClientsToggle(True)
									.clickAppAreaAccord()
									.clickAppToggle(PeopleApp, True)
									.clickAppToggle(OrganizationApp, True)
									.clickAppToggle(My_HomepageApp, True)
									.clickAppToggle(NotesApp, True)
									.clickAppAreaModulesAccord()
									.selectAppAreaModulesShowEntries(2)
									.setSearchAppAreaModules(NotesApp)
									.clickModuleToggle(NotesModules, Active, True)
									.clickModuleToggle(NotesModules, Add, True)
									.clickModuleToggle(NotesModules, View, True)
									.clickModuleToggle(NotesModules, Edit, True)
									.setSearchAppAreaModules(OrganizationApp, Clear)
									.clickModuleToggle(OrganizationsModules, View, True)
									.setSearchAppAreaModules(PeopleApp, Clear)
									.clickModuleToggle(DemographicsModules, Active, True)
									.clickModuleToggle(DemographicsModules, View, True)
									.clickModuleToggle(PeopleModules, Active, True)
									.clickModuleToggle(PeopleModules, View, True)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Adding an Organization");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.NavigationMenuBar()
									.clickOrganization()
									.clickAdd()
									.OrganizationPage()
									.setOrganizationName(OrganizationName)
									.selectOrganizationType(2)
									.clickActiveToggle(True)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);			

			SeleniumHelper.log.info("Adding a Location");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.LocationsPage()
									.setName(LocationName2)
									.clickActiveToggle(True)
									.GetSource()
									.LocationsPage()
									.selectType(1)
									.setPhone(PhoneNumber)
									.clickAddLocStateUserToggle(True)
									.clickAddLocProviderUserToggle(True)
									.clickAdd()
									.ServicePopulationsAvailableAccord()
									.selectServicePopulation(3)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Adding a User/Staff");
			Expected =	"Users Home/Base Office:";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.UserStaffPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.setEmail(Email)
									.setTelephone(PhoneNumber)
									.clickActiveToggle(True)
									.GetSource()
									.UserStaffPage()
									.setTitle("CS USER")
									.clickUserInfoAccord()
									.clickUserActiveToggle(True)
									.setUserName(UserName)
									.setPassword(TestPassword)
									.setPasswordConfirmation(TestPassword)
									.GetSource()
									.UserHomeOfficeAccord()	
									.clickUserHomeOfficeAdd()
									.setUserBaseLocation(LocationName2)
									.clickComplete()
									.UserInfoAccord()
									.readUserHomeOfficeAccord();		
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Assigning a Role");
			Expected =	"Roles Available:";
			Actual =	Source		.UserInfoAccord()
									.clickRolesAvaiableAccord()
									.clickRolesAdd()
									//RoleName
									.selectRole(RoleName)
									.clickRolesComplete()
									.UserInfoAccord()
									.readRolesAvailableAccord();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Assigning a Service Population");
			Expected =	"Service Population Available:";
			Actual =	Source		.UserInfoAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(3)
									.clickComplete()
									.UserInfoAccord()
									.readServicePopulationAvailableAccord();
			SoftAssert.assertEquals(Actual, Expected);	

			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Testing new user login, changing password and using new password to log in and verify module access");
			Source		.Pagefactory()
						.clickPopupOk()
						.NavigationMenuBar()
						.clickWelcomeUser()
						.clickLogout()
						.GetSource()
						.LogInPage()
						.setUserName(UserName)
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
						.setUserName(UserName)
						.setPassword(TestNewPassword)
						.clickSignIn()
						.GetSource()
						.NavigationMenuBar()
						.VerifyModuleAccess(AppList);
	
			Expected =	"Login";
			Actual =	Source		.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);

			Source.DriverFactory().openBrowser(Browser);
			Source.SeleniumHelper().goToUrl(Configuration.Url.testPortal);
			Source		.LogInPage()
			.setUserName(Configuration.User.testUser)
			.setPassword(Configuration.Password.testPassword)
			.clickSignIn()
			.clickAdministrator();

			Expected =	Today;
			Actual =	Source		.AdministratorNavigator()
									.clickRoles()
									.setSearch("TC_Role_Selenium")
									.clickFirstRow()
									.clickEdit()
									.Pagefactory()
									.setEndDate(Today)
									.clickActiveToggle(False)
									.clickSubmit()
									.DataTable()
									.readFirstResultEndDate();				
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}