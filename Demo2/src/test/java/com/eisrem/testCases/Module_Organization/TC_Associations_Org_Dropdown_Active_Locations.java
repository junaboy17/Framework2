package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Associations_Org_Dropdown_Active_Locations extends OrganizationPage{
	@Test(priority=1)
	public void TC_Associations_Org_Dropdown_Active_Locations_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Create Organization 5 days start before today");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId(OrganizationName, OrganizationType.OTHER, SeleniumHelper.dateOnlyPast(5), null, 
					T, Description);
			
			SeleniumHelper.log.info("Create Location 5 days start before today");
			String activeLocId = Source.LocationsPage().addCompleteLocationSubmitAndReturnId(orgId, ActiveLocation, LocationType.BASE, SeleniumHelper.dateOnlyPast(5), null, 
					PhoneNumber, PhoneNumber, PhoneNumber, Description, T, F, F, ServicePopulations.CHILDRENS, SeleniumHelper.dateOnlyPast(5), null, null);
			
			SeleniumHelper.log.info("Create Location 5 days start before today that was end dated the following day");
			String inactiveLocId = Source.LocationsPage().addCompleteLocationSubmitAndReturnId(orgId, InactiveLocation, LocationType.OTHER_LOCATION, SeleniumHelper.dateOnlyPast(5), SeleniumHelper.dateOnlyPast(4), 
					PhoneNumber, PhoneNumber, PhoneNumber, Description, T, F, F, ServicePopulations.CHILDRENS, SeleniumHelper.dateOnlyPast(5), SeleniumHelper.dateOnlyPast(4), null);
			
			SeleniumHelper.log.info("Create Person to test ony");
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Confirm association is in drop down");
			Expected = True;
			Actual = Source		.AssociationsPage()
								.addCompleteAssociation(peoId, Today, null, AssociationType.ORGANIZATION, null, orgId, null, null, Description)
								.isOrgAssociationInDropdown(activeLocId, orgId);
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm association is successfully created");
			Expected = Success;
			Actual = Source		.AssociationsPage()
								.setOrganization(orgId, EmptyString)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm inactive location association is not present");
			Expected = False;
			Actual = Source		.DataTable()
								.clickPopupOk()
								.AssociationsPage()
								.addCompleteAssociation(peoId, Today, null, AssociationType.ORGANIZATION, null, orgId, null, null, Description)
								.isOrgAssociationInDropdown(inactiveLocId, orgId);
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm association has error message when no association selected");
			Expected = "value cannot be empty";
			Actual = Source		.AssociationsPage()
								.clickSubmit()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			Source.AssociationsPage().clickBackToAssociation().clickDiscard();
			Source.LocationsPage().endDateLocation(orgId, activeLocId);
			//Source.OrganizationPage().endDateOrganization(orgId);
			Source.NavigationMenuBar().clickPeople().setSearch(peoId).clickFirstRow().clickEdit().PeoplePage().setEndDate(Today, EmptyString);
	
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}