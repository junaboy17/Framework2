package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class People_OtherNames_Test extends PeoplePage {

	@Test(priority=1)
	public void OtherNames_Add_001() {

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
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=2)
	public void OtherNames_Edit_001() {

		SoftAssert = new SoftAssert();

		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);
		String updatedfName = FirstName + SeleniumHelper.generateRandomAlpha(4);
		String updatedlName = LastName + SeleniumHelper.generateRandomAlpha(4);


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
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Editing Other Name and verifying successful change");
			Expected =	updatedlName.toUpperCase() + ", " + updatedfName.toUpperCase() + "/ FORMER NAME";
			Actual =	Source		.DataTable()
									.setSearch(lName)
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.setFirstName(updatedfName, Clear)
									.setLastName(updatedlName, Clear)
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
	public void OtherNames_View_001() {

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

	@Test(priority=4)
	public void OtherNames_Record_Format_001() {

		SoftAssert = new SoftAssert();

		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);
		String newfName = FirstName + SeleniumHelper.generateRandomAlpha(4);
		String newlName = LastName + SeleniumHelper.generateRandomAlpha(4);

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

			SeleniumHelper.log.info("Adding a new Other Name and confirming new Other Name displays correctly");
			Expected =	newlName.toUpperCase() + ", " + newfName.toUpperCase() + "/ FORMER NAME";
			Actual =	Source		.DataTable()
									.clickAdd()
									.OtherNamesPage()
									.selectType(1)
									.GetSource()
									.DemographicsPage()
									.setFirstName(newfName)
									.setLastName(newlName)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(newlName)
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);


			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}


}
