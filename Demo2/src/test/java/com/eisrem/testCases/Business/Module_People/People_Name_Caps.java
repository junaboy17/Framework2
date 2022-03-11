package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class People_Name_Caps extends PeoplePage {

	@Test(priority=1)
	public void TC_People_Name_Caps() {

		SoftAssert = new SoftAssert();
		
		String FName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String people = LastName + ", " + FName +  " (" + DateOfBirth + ")";
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
			SeleniumHelper.log.info("Adding a Person with Identifier and verifying successful add");
			Expected =	people.toUpperCase();
			Actual =	Source			.PeoplePage()
										.AddPeopleWith_Identifier(FName, LastName, Enumerations.Gender.MALE, DateOfBirth, Enumerations.Identifier.MEDICAID, IdentifierNumber)
										.GetSource()
										.PeopleNavigator()
										.clickPeopleTab()
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