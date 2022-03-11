package com.eisrem.testCases.Module_Organization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Location_Address_Add_Edit_View extends OrganizationPage {

	String orgName = "ACME";
	@Test(priority=1)
	
	public  void Location_Address_Add() {
		
		SoftAssert = new SoftAssert();

		int zip = 5;
		String phoneNumber = "2079999999";
		String address = "123 SELENIUM ST.";		
		
		try {
			SeleniumHelper.log.info("Anchoring on Organization, creating Location, adding address to Location.");

			Source	
					//Create Location
					.LocationsPage()
					.addCompleteLocationAndSubmit(orgName)
					.clickFirstRow()
					.clickAnchor()
					// Add Address
					.OrganizationNavigator()
					.clickAddress()	
					.clickAdd()
					.AddressPage()
					.clickSubmit()	// unhappy path
					.GetSource()
					.FormPage()
					.continueIfError()  	
					.GetSource()
					.AddressPage()
					.FillRequiredAddress(address, 1, "ME", "AUGUSTA", zip, phoneNumber, "Selenium test record.")
					.clickSubmit()
					.clickPopupOk()
					;

			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
	
@Test(priority=2)
	
	public  void Location_Address_Edit() {
		
		SoftAssert = new SoftAssert();
		int zip = 2;
		String phoneNumber = "2071001010";
		String address = "45 NEW SELENIUM ST.";
		
		try {
			SeleniumHelper.log.info("Anchoring on Organization and Location, making changes to address.");

			Source
				//Anchor on Organization
				.OrganizationPage()
//				.setSearch("42989")
				.clickFirstRow()
				.clickAnchor()
				//Anchor on Location
				.OrganizationNavigator()
				.clickLocations()
				.clickFirstRow()
				.clickAnchor()
				// Making changes to the Address
				.OrganizationNavigator()
				.clickAddress()
				.DataTable()
				.isEmptyThrowError()
				.clickFirstRow()
				.clickEdit()
				.AddressPage()
				.EditAddress(address, "ME", "BANGOR", zip, phoneNumber, "New Selenium Description")
				.clickSubmit()
				.clickPopupOk()
				;
			
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}

@Test(priority=3)

	public  void Location_Address_View() {
		
		SoftAssert = new SoftAssert();
		
		try {
			SeleniumHelper.log.info("Anchoring on Organization and Location, "
					+ "and using View functionality for Location Address.");
	
			Source
				//Anchor on Organization
				.OrganizationPage()
				.setSearch(orgName)
				.clickFirstRow()
				.clickAnchor()
				//Anchor on Location
				.OrganizationNavigator()
				.clickLocations()
				.clickFirstRow()
				.clickAnchor()
				// View the Address
				.OrganizationNavigator()
				.clickAddress()
				.DataTable()
				.isEmptyThrowError()
				.clickFirstRow()
				.clickView()
				.AddressPage()
				.clickBackTo()
				;
			
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
}