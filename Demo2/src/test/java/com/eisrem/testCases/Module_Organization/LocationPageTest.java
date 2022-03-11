package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;

public class LocationPageTest extends OrganizationPage{
	
	@Test(priority=1)
	public void LocationPageTitleCheck() {
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create Organization for test");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId(OrganizationName, OrganizationType.OTHER, Today, null, 
					T, Description);
			
			SeleniumHelper.log.info("Verifying 'Start Date' title");
			Expected ="Start Date *";
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.readStartDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'End Date' title");
			Expected ="End Date";
			Actual = Source		.LocationsPage()
								.readEndDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Name' title");
			Expected ="Name *";
			Actual = Source		.LocationsPage()
								.readNameTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Active' title");
			Expected ="Active?";
			Actual = Source		.LocationsPage()
								.readActiveTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Type' title");
			Expected ="Type *";
			Actual = Source		.LocationsPage()
								.readTypeTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Phone' title");
			Expected ="Phone";
			Actual = Source		.LocationsPage()
								.readPhoneTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Fax' title");
			Expected ="Fax";
			Actual = Source		.LocationsPage()
								.readFaxTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'TTY' title");
			Expected ="TTY";
			Actual = Source		.LocationsPage()
								.readTTYTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Description' title");
			Expected ="Description";
			Actual = Source		.LocationsPage()
								.readDescriptionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Add as Additional Location to State Users' title");
			Expected ="Add as Additional Location to State Users?";
			Actual = Source		.LocationsPage()
								.readAddLocStateUserToggleTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Add as Additional Location for Provider Users?' title");
			Expected ="Add as Additional Location for Provider Users?";
			Actual = Source		.LocationsPage()
								.readAddLocProviderUserToggleTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			Source.OrganizationPage().endDateOrganization(orgId);
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Location_Add_001() {
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create Organization for test");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId(OrganizationName, OrganizationType.OTHER, Today, null, 
					T, Description);
			
			SeleniumHelper.log.info("Verifying adding a location without required field creates error messages");
			Expected = "Please enter a Name *";
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.clickSubmit()
								.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying Type error message");
			Expected = "Please enter a Type *";
			Actual = Source		.LocationsPage()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verifying Location successfully created");
			Expected = Success;
			Actual = Source		.LocationsPage()
								.setName(LocationName)
								.selectType(LocationType.OTHER_LOCATION.getName())
								.toggleActive(T)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.addServicePopulation(Today, null, ServicePopulations.ADULT_MH.getName(), Description)
								.GetSource()
								.LocationsPage()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);	
			
			SeleniumHelper.log.info("End Date Organization");
			Source.OrganizationPage().clickPopupOk().OrganizationPage().endDateOrganization(orgId);
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
