package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11402_People_001 extends PeoplePage {
	
	@Test(priority=1)
	public void People_Add_001() {
		
		SoftAssert = new SoftAssert();
		String fName = FirstName + SeleniumHelper.generateRandomAlpha(4);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(4);

		try{
			
			SeleniumHelper.log.info("Verifying successful addition of an individual in People module & verifying Service Population associations");
			Expected =	"USER, SELENIUM, / INDIVIDUAL";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsNoIdentifier(fName, MiddleName, lName, Enumerations.Gender.MALE, DateOfBirth,
											Household, MaritalStatus.DIVORCED, MilitaryStatus.ACTIVE_RESERVE, MilitaryService.AIR_FORCE, CitizenshipStatus.NOT_A_US_CITIZEN, Country.AFGHANISTAN)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected2 =	"CHILDRENS/ SERVICE POPULATION";
			Expected =	"ADULT MH/ SERVICE POPULATION";
			Actual =	Source		.DataTable()
									.readSecondResultNameType();
			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected, Expected2));
			
			Actual =	Source		.DataTable()
									.readThirdResultNameType();
			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected, Expected2));
			
			Expected =	"DHHS/ STATE OF MAINE, CENTRAL OFFICE/ ORGANIZATION";
			Actual =	Source		.DataTable()
									.readFourthResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying successful addition of an individual in People module & verifying defualt associations");
			Expected =	fName.toUpperCase();
			Actual =	Source		.PeopleNavigator()
									.clickPeopleTab()
									.setSearch(fName, Clear)
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.readFirstNameValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying demographics");
			Expected =	lName.toUpperCase();
			Actual =	Source		.DemographicsPage()
									.readLastNameValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Enumerations.Gender.MALE.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readGenderValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	"08/28/2019";
			Actual =	Source		.DemographicsPage()
									.readDateOfBirthValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Household;
			Actual =	Source		.DemographicsPage()
									.clickStatusAccord()
									.readHouseholdValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	MaritalStatus.DIVORCED.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readMaritalValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	MilitaryStatus.ACTIVE_RESERVE.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readMilitaryValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	CitizenshipStatus.NOT_A_US_CITIZEN.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readCitizenshipValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	MilitaryService.AIR_FORCE.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readMilitaryServiceValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Country.AFGHANISTAN.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readCountryOfCitizenshipValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting Primary Language & English Proficiency to an individual & verifying all value");
			Expected =	Language.AMHARIC.getIdAsString();
			Actual =	Source		.PeopleNavigator()
									.clickLanguageTab()
									.selectPrimaryLanguage(Language.AMHARIC.getIndex())
									.selectEnglishProficiency(EnglishProficiency.NOT_PROFICIENT.getIndex())
									.clickSubmit()
									.clickPopupOk()
									.LanguagePage()
									.clickLanguageTab()
									.readPrimaryLanguageValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	EnglishProficiency.NOT_PROFICIENT.getIdAsString();
			Actual =	Source		.LanguagePage()
									.readEnglishProficiencyValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting Race/Ethnicity & verifying all value");
			Expected =	PlaceOfBirth;
			Actual =	Source		.PeopleNavigator()
									.clickRaceEthinicityTab()
									.setPlaceOfBirth(PlaceOfBirth, "Y")
									.selectReligion(Religion.AGNOSTIC.getIndex())
									.selectRace(Race.AMERICAN_INDIAN_ALASKAN_NATIVE.getIndex())
									.selectEthncity(Ethnicity.AMERICAN_INDIAN_ALASKAN_NATIVE.getName())
									.clickSubmit()
									.clickPopupOk()
									.RaceEthnicityPage()
									.clickRaceEthinicityTab()
									.readPlaceOfBirthValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Religion.AGNOSTIC.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readReligionValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Race.AMERICAN_INDIAN_ALASKAN_NATIVE.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readRaceValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Ethnicity.AMERICAN_INDIAN_ALASKAN_NATIVE.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readEthnicityValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2)
	public void People_Edit_001() {
		
		SoftAssert = new SoftAssert();
		
		String fName = FirstName + SeleniumHelper.generateRandomAlpha(4);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(4);

		try{
			
			SeleniumHelper.log.info("Verifying successful addition of an individual in People module after editing");
			Expected =	fName.toUpperCase();
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsNoIdentifier()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickPeopleTab()
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.fillAllDemogrphicsNoIdentifier(fName, MiddleName, lName, Enumerations.Gender.NON_BINARY, DateOfBirth,
											Household+1, MaritalStatus.MARRIED_SEPARATED, MilitaryStatus.DISHONORABLE_DISCHARGE, MilitaryService.ARMY, CitizenshipStatus.NOT_A_US_CITIZEN_ALIEN_RESIDENT, Country.ALBANIA, Clear)
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickPeopleTab()
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.readFirstNameValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying demographics");
			Expected =	lName.toUpperCase();
			Actual =	Source		.DemographicsPage()
									.readLastNameValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Gender.NON_BINARY.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readGenderValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	DateOfBirth;
			Actual =	Source		.DemographicsPage()
									.readDateOfBirthValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Household+1;
			Actual =	Source		.DemographicsPage()
									.clickStatusAccord()
									.readHouseholdValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	MaritalStatus.MARRIED_SEPARATED.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readMaritalValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	MilitaryStatus.DISHONORABLE_DISCHARGE.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readMilitaryValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	CitizenshipStatus.NOT_A_US_CITIZEN_ALIEN_RESIDENT.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readCitizenshipValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	MilitaryService.ARMY.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readMilitaryServiceValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Country.ALBANIA.getIdAsString();
			Actual =	Source		.DemographicsPage()
									.readCountryOfCitizenshipValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting Primary Language & English Proficiency to an individual & verifying all value");
			Expected =	Language.AMHARIC.getIdAsString();
			Actual =	Source		.PeopleNavigator()
									.clickLanguageTab()
									.selectPrimaryLanguage(Language.AMHARIC.getIndex())
									.selectEnglishProficiency(EnglishProficiency.NOT_PROFICIENT.getIndex())
									.clickSubmit()
									.clickPopupOk()
									.LanguagePage()
									.clickLanguageTab()
									.GetSource()
									.SeleniumHelper()
									.sleep(2)
									.GetSource()
									.LanguagePage()
									.readPrimaryLanguageValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	EnglishProficiency.NOT_PROFICIENT.getIdAsString();
			Actual =	Source		.LanguagePage()
									.readEnglishProficiencyValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting Race/Ethnicity & verifying all value");
			Expected =	PlaceOfBirth;
			Actual =	Source		.PeopleNavigator()
									.clickRaceEthinicityTab()
									.setPlaceOfBirth(PlaceOfBirth, "Y")
									.selectReligion(Religion.AGNOSTIC.getIndex())
									.selectRace(Race.AMERICAN_INDIAN_ALASKAN_NATIVE.getIndex())
									.selectEthncity(Ethnicity.AMERICAN_INDIAN_ALASKAN_NATIVE.getName())
									.clickSubmit()
									.clickPopupOk()
									.RaceEthnicityPage()
									.clickRaceEthinicityTab()
									.GetSource()
									.SeleniumHelper()
									.sleep(2)
									.GetSource()
									.RaceEthnicityPage()
									.readPlaceOfBirthValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Religion.AGNOSTIC.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readReligionValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Race.AMERICAN_INDIAN_ALASKAN_NATIVE.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readRaceValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Ethnicity.AMERICAN_INDIAN_ALASKAN_NATIVE.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readEthnicityValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing same person & verifying All Language fields & Ethnicity fields have not changed");
			Expected =	Language.AMHARIC.getIdAsString();
			Actual =	Source		.PeopleNavigator()
									.clickPeopleTab()
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.fillAllDemogrphicsNoIdentifier()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickLanguageTab()
									.GetSource()
									.SeleniumHelper()
									.sleep(2)
									.GetSource()
									.LanguagePage()
									.readPrimaryLanguageValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	EnglishProficiency.NOT_PROFICIENT.getIdAsString();
			Actual =	Source		.LanguagePage()
									.readEnglishProficiencyValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	PlaceOfBirth;
			Actual =	Source		.PeopleNavigator()
									.clickRaceEthinicityTab()
									.readPlaceOfBirthValue();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Religion.AGNOSTIC.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readReligionValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Race.AMERICAN_INDIAN_ALASKAN_NATIVE.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readRaceValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Ethnicity.AMERICAN_INDIAN_ALASKAN_NATIVE.getIdAsString();
			Actual =	Source		.RaceEthnicityPage()
									.readEthnicityValue();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
	
	
	
}
