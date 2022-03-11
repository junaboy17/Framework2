package com.eisrem.testCases.Module_Administrator;

import org.codehaus.plexus.DuplicateChildContainerException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Role_Inactive_Mods_Not_In_Menu extends AdministratorPage{
	@Test(priority=1)
	public void TC_Role_Inactive_Mods_Not_In_Menu_001() {		
		SoftAssert = new SoftAssert();
		
		String RoleName= "TC_ROLE_SELENIUM " + RandNum8;

		try{	
			SeleniumHelper.log.info("Adding a new Role and verifying Success Message");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickRoles()
								.clickAdd()
								.RolesPage()
								.setRoleName(RoleName)
								.setDescription(Description)
								.GetSource()
								.RolesPage()
								.clickAppAreaAccord()
								.setSearch(OrganizationApp)
								.GetSource()
								.RolesPage()
								.clickAppToggle(OrganizationApp, True)
								.clickAppAreaModulesAccord()
								.clickModuleToggle(LocationsModules, Active, True)
								.clickModuleToggle(LocationsModules, Add, True)
								.clickModuleToggle(LocationsModules, View, True)
								.clickModuleToggle(LocationsModules, Edit, True)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Deactivating modules and confirming Success Message");
			Expected = Success;
			Actual = Source   	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(RoleName)
								.clickFirstRow()
								.clickEdit()
								.RolesPage()
								.clickAppAreaModulesAccord()
								.clickModuleToggle(LocationsModules, Active, False)
								.clickModuleToggle(LocationsModules, Add, False)
								.clickModuleToggle(LocationsModules, View, False)
								.clickModuleToggle(LocationsModules, Edit, False)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			System.out.println(UserName);
			System.out.println(TestPassword);
			
			SeleniumHelper.log.info("Creating a new user with Role, Service Population and verifying Success Message");
			Expected = Success;
			Actual = Source   	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickOrganization()
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName)
								.setLastName(LastName)
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(UserName)
								.setPassword(TestPassword, Clear)
								.setPasswordConfirmation(TestPassword, Clear)
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole(RoleName)
								.clickComplete()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(3)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Signing in as newly created user and verifying that Location tab does not appear");
			ExpectedB = F;
			ActualB = Source   	.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut()
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
								.clickOrganization()
								.GetSource()
								.SeleniumHelper()					
								.ifWebElementExists(Source.OrganizationNavigator().LocationsTab, 1);
			SoftAssert.assertEquals(ActualB, ExpectedB);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}