package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11926_Role_End_Date_People extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_BHOPS_11926_Role_End_Date_People_01() {
		
		SoftAssert = new SoftAssert();

		try{
			//We will add a new user to work with and capture the user id and the name
			SeleniumHelper.log.info("Creating new user to work with");
			String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			
			String newUserId = Source.UserStaffPage().addCompleteUserAndReturnId(OrgDHHS, "RON", "BURGUNDY", Email, PhoneNumber, T,
					null, null, Today, null, T, PastDate, null, UserName, UserPassword, UserPassword, Description);
			
			//User will need to change password
			String newPassword = UserPassword + SeleniumHelper.generateRandomNumber(4);
				
			//Three roles with names
			String roleA = RolePrefix.toUpperCase() + SeleniumHelper.generateRandomNumber(8);
			String roleB = RolePrefix.toUpperCase() + SeleniumHelper.generateRandomNumber(8);
			String roleC = RolePrefix.toUpperCase() + SeleniumHelper.generateRandomNumber(8);
			
			
			SeleniumHelper.log.info("Add first role");
			Source			.NavigationMenuBar()
							.clickAdministrator()
							.clickRoles()
							.clickAdd()
							.RolesPage()
							.setRoleName(roleA, Clear)
							.setStartDate(PastDate, Clear)
							.GetSource()
							.RolesPage()
							.clickAppAreaAccord()
							.clickAppToggle(AdministratorApp)
							.clickSubmit()
							.clickPopupOk();
			 
			SeleniumHelper.log.info("Add second role");
			Source			.NavigationMenuBar()
							.clickAdministrator()
							.clickRoles()
							.clickAdd()
							.RolesPage()
							.setRoleName(roleB, Clear)
							.setStartDate(Yesterday, Clear)
							.GetSource()
							.RolesPage()
							.clickAppAreaAccord()
							.clickAppToggle(AgreementApp)
							.clickSubmit()
							.clickPopupOk();
				 
			SeleniumHelper.log.info("Add third role");
			Source			.NavigationMenuBar()
							.clickAdministrator()
							.clickRoles()
							.clickAdd()
							.RolesPage()
							.setRoleName(roleC, Clear)
							.setStartDate(Today, Clear)
							.GetSource()
							.RolesPage()
							.clickAppAreaAccord()
							.clickAppToggle(Assessment_FormsApp)
							.clickSubmit()
							.clickPopupOk();
			
			SeleniumHelper.log.info("Edit user");
			Source	.NavigationMenuBar().clickOrganization().setSearch(OrgDHHS).clickFirstRow().clickAnchor();
			Source	.OrganizationNavigator().clickUsersStaff().setSearch(newUserId).clickFirstRow().clickEdit();
			
			SeleniumHelper.log.info("Continue test with edit - editing existing user and confirming modified date");
			Source			.UserStaffPage()
							.clickUserInfoAccord()
							.clickRolesAvaiableAccord()
							.addRole(PastDate, null, roleA, Description)
							.addRole(Yesterday, null, roleB, Description)
							.addRole(Today, null, roleC, Description)
							.clickSubmit()
							.clickPopupOk();
			
			SeleniumHelper.log.info("Verifying successful Log out");
			Source			.MyHomePage()
							.expandUserMenu()
							.clickLogout();
			
			SeleniumHelper.log.info("Change new user password and log in");
			Source			.LogInPage()
							.setUserName(UserName)
							.setPassword(UserPassword)
							.clickSignIn()
							.GetSource()
							.ChangePasswordPage()
							.setCurrentPassword(UserPassword, Clear)
							.setNewPassword(newPassword, Clear)
							.setConfirmNewPassword(newPassword, Clear)
							.clickSubmit();
			
			SeleniumHelper.log.info("Verifying app areas based on roles Administrator");
			Expected = "ADMINISTRATOR";
			Actual = Source			.LogInPage()
							.setUserName(UserName)
							.setPassword(newPassword)
							.clickSignIn()
							.GetSource()
							.NavigationMenuBar()
							.readAdministratorLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying app areas based on roles");
			Expected = "ASSESSMENT/FORMS";
			Actual = Source			.NavigationMenuBar()
							.readAssessmentFormsLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying app areas based on roles");
			Expected = "AGREEMENT";
			Actual = Source			.NavigationMenuBar()
							.readAgreementLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying successful Log out");
			Source			.MyHomePage()
							.expandUserMenu()
							.clickLogout();
			
			SeleniumHelper.log.info("Login as user and ennd date a role");
			Source			.LogInPage()
							.setUserName(Configuration.User.testUser)
							.setPassword(Configuration.Password.testPassword)
							.clickSignIn()
							.clickAdministrator()
							.clickRoles()
							.setSearch(roleB, Clear)
							.clickFirstRow()
							.clickEdit()
							.RolesPage()
							.setEndDate(Yesterday, Clear)
							.clickSubmit()
							.clickPopupOk();
			
			SeleniumHelper.log.info("Verifying successful Log out");
			Source			.MyHomePage()
							.expandUserMenu()
							.clickLogout();
			
			SeleniumHelper.log.info("Verifying app areas based on roles");
			Expected = "ADMINISTRATOR";
			Actual = Source	.LogInPage()
							.setUserName(UserName)
							.setPassword(newPassword)
							.clickSignIn()
							.GetSource()
							.NavigationMenuBar()
							.readAdministratorLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying app areas based on roles");
			Expected = "ASSESSMENT/FORMS";
			Actual = Source	.NavigationMenuBar()
							.readAssessmentFormsLink();	
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying successful Log out");
			Source			.MyHomePage()
							.expandUserMenu()
							.clickLogout();
			
			SeleniumHelper.log.info("Login as user and ennd date a role");
			Source			.LogInPage()
							.setUserName(Configuration.User.testUser)
							.setPassword(Configuration.Password.testPassword)
							.clickSignIn();
			
			SeleniumHelper.log.info("Edit user");
			Source	.NavigationMenuBar().clickOrganization().setSearch(OrgDHHS).clickFirstRow().clickAnchor();
			Source	.OrganizationNavigator().clickUsersStaff().setSearch(newUserId).clickFirstRow().clickEdit();
			
			
			SeleniumHelper.log.info("Confirm Role was end dated");
			Expected = Yesterday;
			Actual = Source	.UserStaffPage()
							.clickUserInfoAccord()
							.clickRolesAvaiableAccord()
							.setSearch(roleB, Clear)
							.readFirstRowEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("End date user");
			Source.UserStaffPage().endDateUserAndSubmit(OrgDHHS, newUserId, T);

				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
	
	

