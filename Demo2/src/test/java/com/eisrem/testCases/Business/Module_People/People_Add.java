package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class People_Add extends PeoplePage {
	
	@Test(priority=1)
	public void Add_With_Identifier_Accordian_001() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying people add with Identifier accordion");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphicsWithIdentifier()
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
	public void Add_With_Association_Tab_001() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying People add with Association tab");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphicsWithIdentifier()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.clickAdd()
										.AssociationsPage()
										.selectAssociationType(2)
										.setOrganization("ACME BEHAVIORAL HEALTHCARE")
										.clickSubmit()
										.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);		
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		

	@Test(priority=3)
	public void Add_Client_With_Address_Tab() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Add client with Address tab");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphicsWithIdentifier()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.clickAdd()
										.AssociationsPage()
										.selectAssociationType(2)
										.setOrganization("ACME BEHAVIORAL HEALTHCARE")
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickAddressTab()
										.DataTable()
										.clickAdd()
										.AddressPage()
										.selectAddressType(1)
										.setAddress1TextBox("123 Selenium st")
										.selectState("ME")
										.selectCity("AUGUSTA")
										.selectZipcode(5)
										.setDescription("Selenium Test Record", "y")
										.clickSubmit()
										.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);		
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=4)
	
	public void Add_With_Identifier_Tab_001() {
		
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying People add with Identifier tab");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.setFirstName(FirstName)
										.setMiddleName(MiddleName)
										.setLastName(LastName)
										.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
										.setDateOfBirth(DateOfBirth)
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickIdentifierTab()
										.clickAdd()
										.IdentifiersPage()
										.selectIdentifiersType(1)
										.setIdentifiersIdNumber(IdentifierNumber)
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