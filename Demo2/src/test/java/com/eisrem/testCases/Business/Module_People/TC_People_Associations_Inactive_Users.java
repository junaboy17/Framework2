package com.eisrem.testCases.Business.Module_People;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.AssociationType;
import com.eisrem.AppUtils.Enumerations.ServicePopulations;
import com.eisrem.Hooks.AdministratorPage;

public class TC_People_Associations_Inactive_Users extends AdministratorPage {
	
	@Test(priority=1)
public void TC_People_Associations_Inactive_Users_001() {
		
		SoftAssert = new SoftAssert();
		
		try{
				//Create an active user
				SeleniumHelper.log.info("Creating new user to work with Active");
				String activeId = Source.UserStaffPage().addCompleteUserAndRemainOnUserPage(OrganizationPrefix, "TOM", "HANKS", Email, PhoneNumber, T,
						null, null, Today, null, T, Today, null, UserName + SeleniumHelper.generateRandomAlpha(5), UserPassword, UserPassword, Description)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAvaiableAccord()
								.addRole()
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.addServicePopulation(Today, Tomorrow,ServicePopulations.CHILDRENS.getName(), Description)
								.GetSource()
								.UserStaffPage()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.readFirstResultID();
				
				SeleniumHelper.log.info("Creating new user to work with Inactive");
				String inactiveId = Source.UserStaffPage().addCompleteUserAndRemainOnUserPage(OrganizationPrefix, "WILSON", "HANKS", Email, PhoneNumber, F,
						null, null, Today, null, T, Today, null, UserName + SeleniumHelper.generateRandomAlpha(5), UserPassword, UserPassword, Description)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAvaiableAccord()
								.addRole()
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.addServicePopulation(Today, Tomorrow,ServicePopulations.CHILDRENS.getName(), Description)
								.GetSource()
								.UserStaffPage()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.readFirstResultID();
				
				SeleniumHelper.log.info("Creating new person to work with");
				String peoId = Source.PeoplePage().addPersonReturnId();
				
				SeleniumHelper.log.info("Verifying user in Association list");
				Expected = True;
				Actual = Source			.PeopleNavigator()
								.setSearch(peoId, Clear)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(AssociationType.INDIVIDUAL.getName())
								.isPeopleAssociationInDropdown(activeId, activeId);
				
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				
				SeleniumHelper.log.info("Verifying user not in Association list");
				Expected = False;
				Actual = Source			
								.AssociationsPage()
								.selectAssociationType(AssociationType.INDIVIDUAL.getName())
								.isPeopleAssociationInDropdown(inactiveId, inactiveId);
				
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
	
	

