package com.eisrem.testCases.Release2021;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.People.DemographicsPage;

public class TC_BHOPS_11399_People_Incorrect_Dob_Dod_Entry_Error_Message extends PeoplePage {
		
		@Test(priority=1)
		public void People_Incorrect_Successful_DOB_Entry() {
			
			SoftAssert = new SoftAssert();

			try{
				SeleniumHelper.log.info("Entering future Date of birth  and Verifying the error message");
				Expected =	"Please enter a Date Of Birth *";
				Actual =	Source			.DataTable()
											.clickAdd()
											.DemographicsPage()
											.setFirstName(FirstName)
											.setMiddleName(MiddleName)
											.setLastName(LastName)
											.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
											.setDateOfBirth(FutureDate30)
											.clickSubmit()
											.readTopErrorMessage(1);
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Entering valid Date of Birth & verifying success message");
				Expected =	"Success!";
				Actual =	Source			.DemographicsPage()
											.setDateOfBirth(DateOfBirth, Clear)
											.clickSubmit()
											.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Entering an invalid Date of Birth and verifying correct error");
				Expected = Today;
				Actual =	Source			.Pagefactory()
											.clickPopupOk()
											.PeopleNavigator()
											.clickPeopleTab()
						                    .setSearch(FirstName)
						                    .clickFirstRow()
						                    .clickEdit()
						                    .DemographicsPage()
						                    .setDateOfBirth("aaa" + Keys.TAB, Clear)
						                    .GetSource()
											.SeleniumHelper()
											.readAttribute(Source.DemographicsPage().DateOfBirthTextBox, "last-val")
											.replace("\"", "");
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Entering a future Date of Birth and verifying correct error");
				Expected = "Please enter a valid Date. The format is MM/DD/YYYY";
				Actual =	Source			.DemographicsPage()
											.setDateOfBirth("" + Keys.TAB, Clear)
						                    .setDateOfBirth(FutureDate30, Clear)
						                    .readInvalidDobDateError();
				SoftAssert.assertEquals(Actual, Expected);

				SoftAssert.assertAll();		
						
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
			
		}
		
		@Test(priority=2)
		public void People_Incorrect_Successful_DOD_Entry() {
			
			SoftAssert = new SoftAssert();

			try{
				SeleniumHelper.log.info("Entering invalid Date of Death and Verifying the error message");
				Expected =	"Please enter a valid Date. The format is MM/DD/YYYY";
				Actual =	Source			.DataTable()
											.clickAdd()
											.Pagefactory()
											.setStartDate(PastDate5, Clear)
											.GetSource()
											.DemographicsPage()
											.setFirstName(FirstName)
											.setLastName(LastName)
											.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
											.setDateOfBirth(DateOfBirth)
											.setDateOfDeath(DateOfDeath)
											.setDateOfDeath("abc")
											.readInvalidDodDateError();
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Entering Future Date of Death and Verifying the error message");
				Expected = "Please enter a valid Date. The format is MM/DD/YYYY";
				Actual =	Source			.DemographicsPage()
											.setDateOfDeath("", Clear)
											.clickSubmit()
											.clickPopupOk()
											.PeopleNavigator()
											.clickPeopleTab()
											.setSearch(FirstName)
											.clickFirstRow()
											.clickEdit()
											.DemographicsPage()
											.setDateOfDeath(FutureDate6, Clear)
											.readInvalidDodDateError();					
				SoftAssert.assertEquals(Actual, Expected);	
				
				SeleniumHelper.log.info("Entering an Invalid Date of Death and Verifying the error message");
				Expected = Today;
				Actual =	Source			.DemographicsPage()
						                    .setDateOfDeath("aaa" + Keys.TAB, Clear)
						                    .GetSource()
											.SeleniumHelper()
											.readAttribute(Source.DemographicsPage().DateOfDeathTextBox, "last-val")
											.replace("\"", "");
				SoftAssert.assertEquals(Actual, Expected);
							
				SeleniumHelper.log.info("Entering a Date of Death that is before Start Date");
				Expected="Start Date should not be after date of death.";
				Actual =	Source			.DemographicsPage()
											.setDateOfDeath("", Clear)	
						                    .setDateOfDeath(PastDate30, Clear)
						                    .clickSubmit()
						                    .readTopErrorMessage(2);
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Entering a valid Date of Death & verifying success message");
				Expected =	"";
				Actual =	Source			.DemographicsPage()
											.setDateOfDeath(Today, Clear)
											.GetSource()
											.SeleniumHelper()
											.readAttribute(Source.DemographicsPage().DateOfDeathTextBox, "last-val").replace("\"", "");
											
				SoftAssert.assertEquals(Actual, Expected);
				
				Expected= Success;
				Actual =	Source			.Pagefactory()
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
