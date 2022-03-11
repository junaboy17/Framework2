package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Conducted_Type_Date_Enforcement_001 extends OrganizationPage  {

	@Test(priority=1)

	public void test1()  {
		
		SoftAssert = new SoftAssert();
		String locName = "SELENIUM TEST LOCATION";
		String locType = "OTHER_LOCATION";
		String title = "Conducted Type "  + RandNum4;
		String ctType = "Data Fix Form (V2)/ Assessment";
		try {
			SeleniumHelper.log.info("Creating a location with end date, anchor on this location, " + 
									"conducting a type trying to enter End Date after the Location End Date. Confirm End Date cannot be after the Location End Date.");
										
			Source
					// Anchor on an org
				.DataTable()
				.clickFirstRow()
				.clickAnchor()
					// Create Location with end date
				.OrganizationNavigator()
				.clickLocations()
				.DataTable()
				.clickAdd()
				.LocationsPage()
				.setName(locName)
				.selectType(locType)
				.toggleActive(T)
				.setEndDate(Tomorrow)
				.clickSubmit()
				.clickPopupOk()
					// Anchor on this location
				.OrganizationNavigator()
				.clickLocations()
				.DataTable()
				.clickFirstRow()
				.clickAnchor()
					// Conduct a type trying to enter end date after the location end date
				.NavigationMenuBar()
				.clickAssessmentForms()
				.DataTable()
				.clickAdd()
				.Assessment_FormsPage()
				.setTitle(title)
				.selectType(ctType)
				.setDescription("DESCRIPTION FROM CREATION")
				.setEndDate(FutureDate30)	// end date field will be empty as it cannot be after location end date
				.GetSource()
				.Assessment_FormsPage()
				.clickStartAssessment()
				.fillForm()
				.clickSubmitAllPages()
				.clickGoBackToList();
			
			Expected = "\"\"";
			Actual = Source					// confirm the conducted type end date field is empty
					.DataTable()
					.clickFirstRow()
					.clickEdit()
					.Assessment_FormsPage()
					.clickAssessmentsFormsTab()
					.readEndDateValue()
					;
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "\"" + Tomorrow + "\"" ;
			Actual = Source					// confirm the conducted type end date field is filled if date is no later than Location End Date
					
					.Assessment_FormsPage()
					.clickAssessmentsFormsTab()
					.setEndDate(Tomorrow)
					.clickSubmit()
					.clickPopupOk()
					.DataTable()
					.clickFirstRow()
					.clickEdit()
					.Assessment_FormsPage()
					.clickAssessmentsFormsTab()
					.readEndDateValue()
					;
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}


	