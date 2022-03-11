package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_Residential_Placement extends PeoplePage {
	@Test(priority=1)
	public void Add_Residential_Placement() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a new Person with Identifier, Association, Diagnosis and verifying success");
			Expected =	"Success!";
			Actual =	Source		.DataTable()	
									.clickAdd()
									.DemographicsPage()
									.setStartDate(PastDate45, Clear)
									.GetSource()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()	
									.clickResidentialPlacementTab()
									.clickAdd()
									.ResidentialPlacementPage()
									.setAdmitDate(PastDate30)
									.selectPlacementType(1)
									.selectResidentialPlacement(3)
									.clickSubmit()
									.readPopUpTitle();					
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Residential Placement was successfully added");
			Expected =	"IN STATE PLACEMENT / BECKET -AUBURN";
			Actual =	Source		.Pagefactory()
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
	public void Edit_Residential_Placement() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a new Person with Identifier, Association, Diagnosis and verifying success");
			Expected =	"Success!";
			Actual =	Source		.DataTable()	
									.clickAdd()
									.DemographicsPage()
									.setStartDate(PastDate45, Clear)
									.GetSource()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()	
									.clickResidentialPlacementTab()
									.clickAdd()
									.ResidentialPlacementPage()
									.setAdmitDate(PastDate30)
									.selectPlacementType(1)
									.selectResidentialPlacement(3)
									.clickSubmit()
									.readPopUpTitle();					
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Description in Residential Placement was successfully added");
			Expected =	Description;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.Pagefactory()
									.setDescription(Description)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.Pagefactory()
									.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=3)
	public void End_Residential_Placement() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a new Person with Identifier, Association, Diagnosis and verifying success");
			Expected =	"Success!";
			Actual =	Source		.DataTable()	
									.clickAdd()
									.DemographicsPage()
									.setStartDate(PastDate45, Clear)
									.GetSource()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()	
									.clickResidentialPlacementTab()
									.clickAdd()
									.ResidentialPlacementPage()
									.setAdmitDate(PastDate30)
									.selectPlacementType(1)
									.selectResidentialPlacement(3)
									.clickSubmit()
									.readPopUpTitle();					
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Discharge Date in Residential Placement and verifying successful add");
			Expected =	PastDate5;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.ResidentialPlacementPage()
									.setDischargeDate(PastDate5)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
			
}