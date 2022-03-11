package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_10817_People_Identifier_Uppercase_MECare extends PeoplePage {
	
	@Test(priority=1)
	public void Uppercase_MECare_Identifiers_Tab() {
		
		SoftAssert = new SoftAssert();
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);

		try{
					SeleniumHelper.log.info("Verifying Medicaid ID is changed from lowercase to uppercase in people module when adding from identifier tab");
					SeleniumHelper.log.info("Logging in to system & adding new  medicaid ID to an individual with smaller case letter in identifier tab");
					Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickIdentifierTab()
									.DataTable()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(1)
									.setIdentifiersIdNumber(RandNum8 + "a")
									.clickSubmit()
									.DataTable()
									.clickPopupOk();
					
					SeleniumHelper.log.info("Verifying last letter for the medicaid id has been changed to capital in identifier result tab");		
					Expected = RandNum8 + "A/" + " MEDICAID";
					Actual = Source.DataTable().readFirstResultNameType();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Clicking edit & verifying last letter for the medicaid id has been changed to capital in edit identifier ID number text box");	
					Expected = RandNum8 + "A";
					Actual =	Source 	.DataTable()
										.clickFirstRow()
										.clickEdit()
										.IdentifiersPage()
										.readIdentifiersIdNumber();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Editing current medicaid id to include smaller case last letter & Verifying last letter for the medicaid id has been changed to capital in identifier result tab");
					Expected = RandNum8 + "B/" + " MEDICAID";
					Actual =	 Source	.IdentifiersPage()
										.setIdentifiersIdNumber(RandNum8 + "b", "Y")
										.clickSubmit()
										.DataTable()
										.clickPopupOk()
										.DataTable()
										.readFirstResultNameType();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying last letter for the medicaid id has been changed to capital in view identifier tab ID number text box");	
					Expected = RandNum8 + "B";		
					Actual =	Source 	.DataTable()
										.clickFirstRow()
										.clickView()
										.IdentifiersPage()
										.readIdentifiersIdNumber();
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2)
	public void Uppercase_MECare_Demographics_Tab() {
		
		SoftAssert = new SoftAssert();
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);

		try{
					SeleniumHelper.log.info("Verifying Medicaid ID is changed from lowercase to uppercase in people module when adding from demographics identifiers accordian");
					SeleniumHelper.log.info("Logging in to system & adding new  medicaid ID to an individual with smaller case letter in demographics identifiers accordian");
					Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.setFirstName(FirstName)
									.setMiddleName(MiddleName)
									.setLastName(LastName)
									.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
									.setDateOfBirth(DateOfBirth)
									.clickIdentifiersAccord()
									.DataTable()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(1)
									.setIdentifiersIdNumber(RandNum8 + "a")
									.clickComplete()
									.DemographicsPage()
									.clickStatusAccord()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickIdentifierTab();
					
					SeleniumHelper.log.info("Verifying last letter for the medicaid id has been changed to capital in identifier result tab");	
					Expected = RandNum8 + "A/" + " MEDICAID";
					Actual = Source.DataTable().readFirstResultNameType();
					SoftAssert.assertEquals(Actual, Expected);
								
					SeleniumHelper.log.info("Verifying last letter for the medicaid id has been changed to capital in view identifier tab ID number text box");	
					Expected = RandNum8 + "A";		
					Actual =	Source 	.DataTable()
										.clickFirstRow()
										.clickView()
										.IdentifiersPage()
										.readIdentifiersIdNumber();					
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Navigating back to demographics identifiers accordian & verifying last letter for the medicaid id has been changed to capital in result tab");
					Expected = RandNum8 + "A/" + " MEDICAID";		
					Actual =	Source 	.NavigationMenuBar()
										.clickPeople()
										.GetSource()
										.DataTable()
										.setSearch(FirstName)
										.clickFirstRow()
										.clickEdit()
										.DemographicsPage()
										.clickIdentifiersAccord()
										.DataTable()
										.readFirstResultNameType();
					
					SeleniumHelper.log.info("Clicking edit & verifying last letter for the medicaid id has been changed to capital in demographics edit identifier ID number text box");	
					Expected = RandNum8 + "A";
					Actual =	Source 	.DataTable()
										.clickFirstRow()
										.clickEdit()
										.IdentifiersPage()
										.readIdentifiersIdNumber();				
					SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

