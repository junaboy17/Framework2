package com.eisrem.testCases.Release2022;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_12063_Org_Combobox_Restrict_By_SP extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_BHOPS_12063_Org_Combobox_Restrict_By() {
		
		SoftAssert = new SoftAssert();
		String baseName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String otherLocName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		//User will need to change password
		String newPassword = UserPassword + SeleniumHelper.generateRandomNumber(4);

		try{
				SeleniumHelper.log.info("Creating new Org to work with");
				String newOrgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId(OrganizationPrefix + SeleniumHelper.generateRandomNumber(8), OrganizationType.OTHER, Today, null, true, Description);
				//Add Base
				Source.LocationsPage().addCompleteLocationAndSubmit(newOrgId, baseName, LocationType.BASE, Today, null,
						null, null, null, null, T, T, F, ServicePopulations.CHILDRENS.getName(), Today, null, null);
				//Add Other Location
				Source.LocationsPage().addCompleteLocationAndSubmit(newOrgId, otherLocName, LocationType.OTHER_LOCATION, Today, null,
						null, null, null, null, T, T, F, ServicePopulations.CHILDRENS.getName(), Today, null, null);
				
				//We will add a new user to work with and capture the user id and the name
				SeleniumHelper.log.info("Creating new user to work with");
				Source.UserStaffPage().addCompleteUserAndRemainOnUserPage(OrganizationPrefix, "TOM", "HANKS", Email, PhoneNumber, T,
						null, null, Today, null, T, Today, null, UserName, UserPassword, UserPassword, Description)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAvaiableAccord()
								.addRole()
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.addServicePopulation(Today, Tomorrow,ServicePopulations.ADULT_MH.getName(), Description)
								.GetSource()
								.UserStaffPage()
								.clickSubmit()
								.clickPopupOk();
				
				SeleniumHelper.log.info("Continue test with edit - editing existing user and confirming modified date");
				Source					.NavigationMenuBar()
										.LogOut();
				
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
				
				SeleniumHelper.log.info("Verifying loc not in Association list");
				Expected = False;
				Actual = Source			.LogInPage()
								.setUserName(UserName)
								.setPassword(newPassword)
								.clickSignIn()
								.GetSource()
								.NavigationMenuBar()
								.clickPeople()
								.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeoplePage()
								.clickAssociationsTab()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(AssociationType.ORGANIZATION.getName())
								.isOrgAssociationInDropdown(newOrgId, otherLocName);
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				SeleniumHelper.log.info("Verifying loc not in User base location list");
				Expected = False;
				Actual = Source			
								.AssociationsPage()
								.clickBackToAssociation()
								.GetSource()
								.UserStaffPage()
								.addCompleteUserAndRemainOnUserPage(OrgDHHS)
								.GetSource()
								.UserHomeOfficeAccord()
								.clickUserHomeOfficeAdd()
								.GetSource()
								.UserHomeOfficeAccord()
								.isOrgAssociationInDropdown(newOrgId, otherLocName);
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
	
	

