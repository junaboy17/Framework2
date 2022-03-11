package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class OtherName_Add_Edit_End extends PeoplePage {

	@Test(priority=1)
	public void Add_OtherNames() {

		SoftAssert = new SoftAssert();

		String fName = "Jeanne " + SeleniumHelper.generateRandomAlpha(3);
		String lName = "Pumpkin";

		try{
			
			SeleniumHelper.log.info("Adding Other Name to an existing person and confirming successful add");
			Expected =	lName.toUpperCase() + ", " + fName.toUpperCase() + "/ FORMER NAME";
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickOtherNamesTab()
									.clickAdd()
									.OtherNamesPage()
									.selectType(1)
									.GetSource()
									.DemographicsPage()
									.setFirstName(fName)
									.setMiddleName(MiddleName)
									.setLastName(lName)
									.clickSubmit()
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
	public void Edit_OtherNames() {

		SoftAssert = new SoftAssert();

		String fName = "Jeanne " + SeleniumHelper.generateRandomAlpha(3);
		String lName = "Pumpkin";
		String updatedfName = fName;
		String updatedlName = lName;

		try{

			SeleniumHelper.log.info("Adding Other Name to an existing person and confirming successful add");
			Expected =	lName.toUpperCase() + ", " + fName.toUpperCase() + "/ FORMER NAME";
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickOtherNamesTab()
									.clickAdd()
									.OtherNamesPage()
									.selectType(1)
									.GetSource()
									.DemographicsPage()
									.setFirstName(fName)
									.setMiddleName(MiddleName)
									.setLastName(lName)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	updatedlName.toUpperCase() + ", " + updatedfName.toUpperCase() + "/ FORMER NAME";
			SeleniumHelper.log.info("Editing Other Name and verifying successful change");
			Actual =	Source		.DataTable()
									.setSearch(fName)
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.setSuffix("JR")
									.clickSubmit()
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


	@Test(priority=3)
	public void End_OtherNames() {

		SoftAssert = new SoftAssert();

		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);

		try{

			SeleniumHelper.log.info("Adding Other Name to an existing person and confirming successful add");
			Expected =	lName.toUpperCase() + ", " + fName.toUpperCase() + "/ FORMER NAME";
			Actual =	Source		.DataTable()
									.clickAdd()	
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickOtherNamesTab()
									.clickAdd()
									.OtherNamesPage()
									.selectType(1)
									.GetSource()
									.DemographicsPage()
									.setFirstName(fName)
									.setLastName(lName)
									.setDescription(Description)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(lName)
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Viewing Other Name and confirming Other Name displays correctly");
			Expected =	fName.toUpperCase();
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.OtherNamesPage()
									.GetSource()
									.DemographicsPage()
									.readFirstNameValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	lName.toUpperCase();
			Actual =	Source		.DemographicsPage()
									.readLastNameValue();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}
