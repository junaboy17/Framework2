package com.eisrem.testCases.Business.Module_People;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class Date_Test extends PeoplePage {
	
	@Test(priority=1)
	public void DOB_in_Future() {
		
		SoftAssert = new SoftAssert();
		String fName = FirstName + SeleniumHelper.generateRandomAlpha(4);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(4);
		
		try{
			SeleniumHelper.log.info("Entering future Date of birth and Verifying the error message");
			Expected =	"Please enter a Date Of Birth *";
			Actual = Source		.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphics(fName, lName, Enumerations.Gender.MALE, FutureDate30)
								.clickSubmit()
								.readTopErrorMessage(1);									
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Entering a valid Date of Birth and Verifying Success");
			Expected =	Success;
			Actual = Source		.DemographicsPage()
								.setDateOfBirth(DateOfBirth, Clear)
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
	public void DOD_in_Future() {
		
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Entering invalid Date of Death and Verifying the error message");
			Expected =	"Please enter a valid Date. The format is MM/DD/YYYY";
			Actual =	Source		.DataTable()
									.setSearch(FirstName)
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.setDateOfDeath(FutureDate7, Clear)
									.readInvalidDodDateError();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Success;
			Actual =	Source		.DemographicsPage()
									.setDateOfDeath(EmptyString, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Entering valid Date of Death and Verifying Success");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickBackTo()
									.DataTable()
									.setSearch(FirstName)
									.clickFirstRow()
									.clickEdit()
									.DemographicsPage()
									.setDateOfDeath(Today, Clear)
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
	
	

