package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_11358_Location_Addresses_Auto_End_Date extends OrganizationPage{


	@Test(priority=1)
	public void TC_Location_Addresses_Auto_End_Date_001() {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);
		String LocationName = "AUGUSTA/3 Group Home "+ SeleniumHelper.generateRandomNumber(4);
		String Address1 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		String Address2 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		String Address3 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		String Address4 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		String Address5 = Address + " " + SeleniumHelper.generateRandomNumber(2);
		String Date1 = SeleniumHelper.dateOnlyFuture(10);
		String Date2 = SeleniumHelper.dateOnlyFuture(15);
		String Date3 = SeleniumHelper.dateOnlyFuture(20);
		String Date4 = SeleniumHelper.dateOnlyFuture(25);

		try{
			SeleniumHelper.log.info("Creating Organization, Location with out end date, & Associtated address with & with out end date");
					Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.PROVIDER.getIndex())
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
								.selectAddressType(1)
								.setAddress1TextBox(Address1)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
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
								.clickPopupOk()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(3)
								.setAddress1TextBox(Address3)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
								.setEndDate(Date1, Clear)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(4)
								.setAddress1TextBox(Address4)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
								.setEndDate(Date2, Clear)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickAdd()
								.AddressPage()
								.selectAddressType(5)
								.setAddress1TextBox(Address5)
								.selectState(State)
								.selectCity(City)
								.selectZipcode(Zip)
								.setEndDate(Date3, Clear)
								.clickSubmit()
								.clickPopupOk();
			
			SeleniumHelper.log.info("Adding end date to Location & verifying Address with no end date was end dated & verifying Address with end date was not changed");
			Expected = Today;
			Actual = 	Source	.OrganizationNavigator()
								.clickLocations()
								.clickFirstRow()
								.clickEdit()
								.LocationsPage()
								.setEndDate(Today, Clear)
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickAddress()
								.setSearch(Address1, Clear)
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual = Source		.DataTable()
								.setSearch(Address2, Clear)
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Date1;
			Actual = Source		.DataTable()
								.setSearch(Address3, Clear)
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Date2;
			Actual = Source		.DataTable()
								.setSearch(Address4, Clear)
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Date3;
			Actual = Source		.DataTable()
								.setSearch(Address5, Clear)
								.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);
			
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}