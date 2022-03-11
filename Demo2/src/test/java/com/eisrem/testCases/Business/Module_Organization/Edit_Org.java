package com.eisrem.testCases.Business.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class Edit_Org extends OrganizationPage{
	
	@Test(priority=1)
	public void Edit_Org_Name() {
		SoftAssert = new SoftAssert();
		
		String OrgName = "ACME GROUP HOME" + SeleniumHelper.generateRandomNumber(5);
		String UpdatedOrgName = "ACME GROUP BEHAVIORAL HOME" + SeleniumHelper.generateRandomNumber(5);
		String LocName = "Gardiner/2 Test Drive" + RandNum3;
		
		
		try{
			SeleniumHelper.log.info("Creating new Organization and verifying successful creation");
			String ID = Source		.DataTable()
									.clickAdd()
									.OrganizationPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.OrganizationPage()
									.setOrganizationName(OrgName)
									.selectOrganizationType(2)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrgName)
									.readFirstResultID();
								
			Expected = "Anchored to:\n"
					+ "OrgId: " + ID + " | OrgName: " + OrgName;
				Actual = Source		.OrganizationNavigator()
									.clickLocations()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Locations, Service Populations, Identifiers, Editing Organization Name and then verifying successful change");
			Expected = UpdatedOrgName + "/ PROVIDER";
				Actual = Source		.DataTable()
									.clickAdd()
									.LocationsPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.LocationsPage()
									.setName(LocName)
									.selectType(1)
									.setPhone(PhoneNumber)
									.clickAddLocStateUserToggle(True)
									.clickAdd()
									.ServicePopulationsAvailableAccord()
									.setStartDate(PastDate30, Clear)
									.selectServicePopulation(3)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickAddress()
									.clickAdd()
									.AddressPage()
									.selectAddressType(4)
									.setAddress1TextBox(Address)
									.selectCity("GARDINER")
									.selectZipcode(1)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickIdentifier()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(2)
									.setIdentifiersIdNumber(RandNum3)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrgName)
									.clickFirstRow()
									.clickEdit()
									.OrganizationPage()
									.setOrganizationName(UpdatedOrgName, Clear)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=2)
	public void Edit_Org_Loc_Name() {
		SoftAssert = new SoftAssert();
		
		String OrgName = "ACME GROUP HOME" + SeleniumHelper.generateRandomNumber(3);
		String LocName = "Gardiner/2 Test Drive" + RandNum3;
		String UpdatedLocName = "Gardiner/2 Test Avenue" + RandNum3;
		
		
		try{
			SeleniumHelper.log.info("Creating new Organization and verifying successful creation");
			String ID = Source		.DataTable()
									.clickAdd()
									.OrganizationPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.OrganizationPage()
									.setOrganizationName(OrgName)
									.selectOrganizationType(2)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrgName)
									.readFirstResultID();
								
			Expected = "Anchored to:\n"
					+ "OrgId: " + ID + " | OrgName: " + OrgName;
				Actual = Source		.OrganizationNavigator()
									.clickLocations()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Locations, Service Populations, Identifiers, Editing Location Name and then verifying successful change");
			Expected = "* " + UpdatedLocName.toUpperCase() + "/ BASE";
				Actual = Source		.DataTable()
									.clickAdd()
									.LocationsPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.LocationsPage()
									.setName(LocName)
									.selectType(1)
									.setPhone(PhoneNumber)
									.clickAddLocStateUserToggle(True)
									.clickAdd()
									.ServicePopulationsAvailableAccord()
									.setStartDate(PastDate30, Clear)
									.selectServicePopulation(3)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickAddress()
									.clickAdd()
									.AddressPage()
									.selectAddressType(4)
									.setAddress1TextBox(Address)
									.selectCity("GARDINER")
									.selectZipcode(1)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickIdentifier()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(2)
									.setIdentifiersIdNumber(RandNum4)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrgName)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickLocations()
									.setSearch(LocName)
									.clickFirstRow()
									.clickEdit()
									.LocationsPage()
									.setName(UpdatedLocName, Clear)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=3)
	public void Edit_Org_Address() {
		SoftAssert = new SoftAssert();
		
		String OrgName = "ACME GROUP HOME" + SeleniumHelper.generateRandomNumber(4);
		String LocName = "Gardiner/2 Test Drive" + RandNum3;
		
		try{
			SeleniumHelper.log.info("Creating new Organization and verifying successful creation");
			String ID = Source		.DataTable()
									.clickAdd()
									.OrganizationPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.OrganizationPage()
									.setOrganizationName(OrgName)
									.selectOrganizationType(2)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrgName)
									.readFirstResultID();
								
			Expected = "Anchored to:\n"
					+ "OrgId: " + ID + " | OrgName: " + OrgName;
				Actual = Source		.OrganizationNavigator()
									.clickLocations()
									.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Locations, Service Populations, Identifiers, Editing Address and then verifying successful change");
			Expected = LocationAddress + "/ WORK";
				Actual = Source		.DataTable()
									.clickAdd()
									.LocationsPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.LocationsPage()
									.setName(LocName)
									.selectType(1)
									.setPhone(PhoneNumber)
									.clickAddLocStateUserToggle(True)
									.clickAdd()
									.ServicePopulationsAvailableAccord()
									.setStartDate(PastDate30, Clear)
									.selectServicePopulation(3)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickAddress()
									.clickAdd()
									.AddressPage()
									.selectAddressType(4)
									.setAddress1TextBox(Address)
									.selectCity("GARDINER")
									.selectZipcode(1)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickIdentifier()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(2)
									.setIdentifiersIdNumber(RandNum5)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickOrganizations()
									.setSearch(OrgName)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickLocations()
									.setSearch(LocName)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickAddress()
									.clickFirstRow()
									.clickEdit()
									.AddressPage()
									.setAddress1TextBox(LocationAddress, Clear)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
}