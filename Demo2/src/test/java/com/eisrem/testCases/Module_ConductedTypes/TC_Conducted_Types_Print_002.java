package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_Conducted_Types_Print_002 extends PeoplePage {

	@Test(priority=1)
	public void Assessment_Add_Print() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Conducting a type, printing it, visually verifying printing outcome.");

			int typeId = 1000075416;	// CS INDIVIDUAL PLANNING FUNDS FORM V2
	
			Source		.DataTable()
						.setSearch(TestClient2)
						.clickFirstRow()
						.clickAnchor()

						.NavigationMenuBar()
						.clickAssessmentForms()
						.DataTable()	
						.clickAdd()
						.Assessment_FormsPage()
						.selectAssessmentTypeById(String.valueOf(typeId))
						.setTitle("TC_Conducted_Types_Print_002")
						.setDescription(String.valueOf(typeId))
						.GetSource()
						.Assessment_FormsPage()
						.clickStartAssessment()
						.fillForm()
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						// Select created type for viewing
						.NavigationMenuBar()
						.DataTable()
						.clickFirstRow()
						.clickView()
						.Assessment_FormsPage()
						// switching to the first tab and click Print
						.clickAssessmentsFormsTab()
						.clickPrint()
						;
			SeleniumHelper.log.warn("Type [" + String.valueOf(typeId)
			+ "] - The browser window will close within next 10 sec.Please verify the printing outcome.");

			Source.SeleniumHelper().sleep(10);

			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
}
