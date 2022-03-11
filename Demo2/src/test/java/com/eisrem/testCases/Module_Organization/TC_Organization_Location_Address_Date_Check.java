package com.eisrem.testCases.Module_Organization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Location_Address_Date_Check extends OrganizationPage {


	@Test(priority=1)
	
	public  void Location_Address_Add() {
		
		SoftAssert = new SoftAssert();
		
		String orgName = "ACME";
		String locName = "SELENIUM DATES TEST #" + SeleniumHelper.generateRandomNumber(4);
		String startDate = "03/10/2020";
		String endtDate = "03/12/2020";
		String servPopl = "CHILDRENS";
		int zip = 5;
		String phoneNumber = "2079999999";
		String address = "123 SELENIUM ST.";		
		
		try {
			SeleniumHelper.log.info("Anchoring on Organization, creating Location, adding address to Location, "
					+ "verifying Address End Date after/later Location's End Date cannot be entered.");

			Source	
				//Create Location
				.LocationsPage()
				.addCompleteLocationAndSubmit(orgName,locName, null, startDate, endtDate, 
						phoneNumber, null, null, null, true, false, false, servPopl, startDate, endtDate, null)
				.clickAddress()	
				.clickAdd()
				.AddressPage()
				.setAddress1TextBox(address)
				.selectAddressType(1)
				.selectState(State)
				.selectCity(City)
				.selectZipcode(zip)
				.setPhoneNumberTextBox(phoneNumber)
				.setDescription(Description)
				.setStartDate(startDate, "Y")
				.setEndDate("03/13/2020",  "Y")			
				;
			
			Expected = EmptyString;
			Actual = Source
						.AddressPage()
						.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			Source
				.AddressPage().setEndDate(endtDate,  "Y")
				.clickSubmit()
				.clickPopupOk()
				;
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
}