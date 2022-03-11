package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class Duplicate_Entry extends PeoplePage {
	
	@Test(priority=1)
	public void Duplicate_Associations() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying error message for duplicate associations entry");
			Expected = "Conflict with existing Association";
			Actual = Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsWithIdentifier()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME BEHAVIORAL HEALTHCARE")
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME BEHAVIORAL HEALTHCARE")
									.clickSubmit()
									.readTopErrorMessage(2);
			Source.SeleniumHelper().containsText(Actual, Expected);

			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		

	@Test(priority=2)
	public void Duplicate_Identifier_Accordion() {
		
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		String IdentifierNumber2 = SeleniumHelper.generateRandomMedicaidIdentifier();
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying error message for duplicate identifier entry");
			ID = 	Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
									.setDateOfBirth(DateOfBirth)
									.clickIdentifiersAccord()
									.DataTable()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(1)
									.setIdentifiersIdNumber(IdentifierNumber)
									.clickComplete()
									.DemographicsPage()
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
									.clickPeopleTab()
									.readFirstResultID()
									.replace("Select", EmptyString)
									.replace(" ", EmptyString);
			
			Expected = "ERROR Message:\n"
					+ "Conflict with existing identifier:\n"
					+ "Client ID=" + ID + ", MEDICAID ID=" + IdentifierNumber + ", Start Date=" + Today + ", End Date=null";
			Actual = Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.setFirstName(FirstName)
									.setLastName(LastName)
									.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
									.setDateOfBirth(DateOfBirth)
									.clickIdentifiersAccord()
									.DataTable()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(1)
									.setIdentifiersIdNumber(IdentifierNumber)
									.clickComplete()
									.DemographicsPage()
									.clickSubmit()
									.readTopErrorMessage(2);
			Source.SeleniumHelper().containsText(Actual, Expected);
			
			Expected =	"Success!";
			Actual = Source			.DataTable()
									.clickFirstRow()
									.clickEdit()
									.IdentifiersPage()
									.setIdentifiersIdNumber(IdentifierNumber2, "Y")
									.clickComplete()
									.DemographicsPage()
									.clickSubmit()
									.readPopUpTitle();
			Source.SeleniumHelper().containsText(Actual, Expected);
									
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

