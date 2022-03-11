package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11224_People_Add_Identifier_Duplicate_Error_Message extends PeoplePage {
	
	@Test(priority=1)
	public void People_Add_Identifier_Duplicate_Error_Message(){
		
		SoftAssert = new SoftAssert();
		String FirstName2 = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String MedicaidIdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
			
			SeleniumHelper.log.info("Verifying Error message after adding duplicate People Identifier");
			ID =	Source		.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphicsWithIdentifier(FirstName2, LastName, Enumerations.Gender.MALE, DateOfBirth, Identifier.MEDICAID, MedicaidIdentifierNumber)
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickPeopleTab()
								.setSearch(FirstName2)
								.readFirstResultID()
								.replace("Select", EmptyString)
								.replace(" ", EmptyString);
			
			Expected ="Please correct the following errors:";
			Actual = Source		.PeopleNavigator()
								.clickIdentifierTab()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(Identifier.MEDICAID.getIndex())
								.setIdentifiersIdNumber(MedicaidIdentifierNumber)
								.clickSubmit()
								.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected ="ERROR Message:\n"
					+ "Conflict with existing identifier:\n"
					+ "Client ID=" + ID + ", MEDICAID ID=" + MedicaidIdentifierNumber + ", Start Date=" + Today + ", End Date=null";
			Actual = Source		.DataTable()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
	
	
	
}
