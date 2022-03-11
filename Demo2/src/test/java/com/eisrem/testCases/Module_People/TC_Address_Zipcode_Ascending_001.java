package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class TC_Address_Zipcode_Ascending_001 extends PeoplePage {

	@Test(priority=1)
	public void TC_Address_Zipcode_Asc_People() {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding a new person and verifying zipcodes are in Ascending order");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, Today)
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickAddressTab()
								.clickAdd()
								.AddressPage()
								.selectAddressType(1)
								.setAddress1TextBox(Address)
								.selectCity("AUGUSTA")
								.GetSource()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.AddressPage()
								.selectZipcode(5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.Pagefactory()
								.clickBackTo()
								.PeopleNavigator()
								.clickRelationshipsTab()
								.clickAdd()
								.RelationshipsPage()
								.selectType(1)
								.setFirstName(FirstName)
								.setLastName(LastName)
								.clickAdd()
								.AddressPage()
								.selectAddressType(1)
								.setAddress1TextBox(Address)
								.selectCity("AUGUSTA")
								.GetSource()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.AddressPage()
								.selectZipcode(5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

		@Test(priority=2)
		public void TC_Address_Zipcode_Asc_Organization() {
			SoftAssert = new SoftAssert();

			try{

				SeleniumHelper.log.info("Adding organization and verifying zipcodes are in Ascending order");
				Expected = Success;
				Actual = Source		.NavigationMenuBar()
									.clickOrganization()
									.clickAdd()
									.OrganizationPage()
									.setOrganizationName(OrganizationName)
									.selectOrganizationType("OTHER")
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.LocationsPage()
									.setName(LocationName)
									.selectType(2)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickAddress()
									.clickAdd()
									.AddressPage()
									.selectAddressType(1)
									.setAddress1TextBox(Address)
									.selectCity("AUGUSTA")
									.GetSource()
									.SeleniumHelper()
									.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
									.GetSource()
									.AddressPage()
									.selectZipcode(5)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.SeleniumHelper()
									.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
				SoftAssert.assertAll();

			}catch(Exception e) {
				Source	.SeleniumHelper()
				.assertFail();
			}
		
}
}


