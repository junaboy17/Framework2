package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_12323_Location_Addresses_Auto_End_Date_SameType extends OrganizationPage{


	@Test(priority=1)
	public void TC_Location_Addresses_Auto_End_Date_SameType_001() {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);
		String LocationName = "AUGUSTA/3 Group Home "+ SeleniumHelper.generateRandomNumber(4);
		String Address1 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		String Address2 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		try{
			SeleniumHelper.log.info("Creating Organization, Location with out end date, & Associtated address with & with out end date");
					Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getName())
								.setStartDate(SeleniumHelper.dateOnlyPast(28), Clear)
								.clickActiveToggle(True)
								.GetSource()
								.OrganizationPage()
								.clickSubmit()
								.clickPopupOk()
								.LocationsPage()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(2)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
								.setStartDate(SeleniumHelper.dateOnlyPast(28), Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.clickPopupOk()		
								.OrganizationNavigator()
								.clickAddress()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(2)
								.setAddress1TextBox(Address1)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
								.setStartDate(SeleniumHelper.dateOnlyPast(28), Clear)							
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(2)
								.setAddress1TextBox(Address2)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
								.clickSubmit()
								.clickPopupOk();
			
			SeleniumHelper.log.info("Adding end date to Location & verifying Address with no end date was end dated & verifying Address with end date was not changed");
			Expected = Yesterday;
			Actual = 	Source	.OrganizationNavigator()
								.clickAddress()
								.setSearch(Address1, Clear)
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}