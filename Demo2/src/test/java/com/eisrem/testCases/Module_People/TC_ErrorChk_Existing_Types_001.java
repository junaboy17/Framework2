package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

import net.bytebuddy.description.modifier.EnumerationState;

public class TC_ErrorChk_Existing_Types_001 extends PeoplePage {

	@Test(priority=1)
	public void TC_People_Associations_Existing_Assoc_ErrorChk_001() {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.DemographicsPage()
								.setFirstName(FirstName)
								.setLastName(LastName)
								.selectDemographicsGender(2)
								.setDateOfBirth(DateOfBirth)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = Success;
			Actual = Source		.Pagefactory()
					.clickPopupOk()
					.DataTable()
					.clickAdd()
					.AssociationsPage()
					.selectAssociationType(3)
					.selectServicePopulation("SUBSTANCE USE")
					.setEndDateTTextBox(Today)
					.clickSubmit()
					.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Conflict with existing Association, 1435284, Start Date=12/21/2021, End Date=12/21/2021. If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\r\n"
					+ "Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\r\n"
					+ "OBH: EIS.OBH@maine.gov");
			Expected = "Conflict with existing Association, 1435284, Start Date=12/21/2021, End Date=12/21/2021. If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\\r\\n\"\r\n"
					+ "					+ \"Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\\r\\n\"\r\n"
					+ "					+ \"OBH: EIS.OBH@maine.gov";
			Actual = Source		.Pagefactory()
					.clickPopupOk()
					.DataTable()
					.clickAdd()
					.AssociationsPage()
					.selectAssociationType(3)
					.selectServicePopulation("SUBSTANCE USE")
					.clickSubmit()
					.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = "Associations";
			Actual = Source		.AssociationsPage()
					.clickBackToAssociation()
					.readAssociationsTab();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
}