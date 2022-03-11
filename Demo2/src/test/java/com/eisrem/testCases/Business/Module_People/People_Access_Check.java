package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.Hooks.PeoplePage;

public class People_Access_Check extends BusinessUserLogIn {
	
	@Test(priority=1)
	public void People_Access_Check_001() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying People Tab- Anchor Add Edit View Excel");
			Expected =	"People";
			Actual =	Source		.NavigationMenuBar()
									.clickPeople()
									.DataTable()
									.setSearch("Jeanne")
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickPeopleTab()
									.readPeopleTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Anchor;
			Actual =	Source		.DataTable()
									.readAnchorBtn();
			SoftAssert.assertEquals(Actual, Expected);
				
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Demographics tab is viewable");
			Expected =	"Demographics";
			Actual =	Source		.DemographicsPage()
									.clickDemographicsTab()
									.readDemographicsTab();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	"View Demographics";
			Actual =	Source		.DemographicsPage()
									.readViewDemographicsTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Identifiers Accord- View Excel");
			Expected =	View;
			Actual =	Source		.IdentifiersPage()
									.clickIdentifiersAccord()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Status Accord- Grayed Out");
			Expected =	True;
			Actual =	Source		.DemographicsPage()
									.clickStatusAccord()
									.HouseholdTextBox.getAttribute("disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Address Tab- Add Edit View Excel");
			
			Expected =	"Address";
			Actual =	Source		.PeopleNavigator()
									.clickAddressTab()
									.GetSource()
									.PeopleNavigator()
									.readAddressTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Identifiers Tab- Add Edit View Excel");
			
			Expected =	"Identifier";
			Actual =	Source		.PeopleNavigator()
									.clickIdentifierTab()
									.GetSource()
									.PeopleNavigator()
									.readIdentifierTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Relationship Tab- Add Edit View Excel");
			
			Expected =	"Relationships";
			Actual =	Source		.PeopleNavigator()
									.clickRelationshipsTab()
									.readRelationshipsTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Add;
			Actual =	Source		.DataTable()
									.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Edit;
			Actual =	Source		.DataTable()
									.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Documents Tab- Add Edit View Excel");
			
			Expected =	"Documents";
			Actual =	Source		.PeopleNavigator()
									.clickDocumentsTab()
									.GetSource()
									.PeopleNavigator()
									.readDocumentsTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Add;
			Actual =	Source		.DataTable()
									.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Diagnosis Tab- Add Edit View Excel");
			
			Expected =	"Diagnosis";
			Actual =	Source		.PeopleNavigator()
									.clickDiagnosisTab()
									.readDiagnosisTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Add;
			Actual =	Source		.DataTable()
									.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Edit;
			Actual =	Source		.DataTable()
									.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Enrollment Status Tab- Add Edit View Excel");
			
			Expected =	"Enrollment Status";
			Actual =	Source		.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.GetSource()
									.PeopleNavigator()
									.readEnrollmentStatusTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Residential Placement Tab- Add Edit View Excel");
			
			Expected =	"Residential Placement";
			Actual =	Source		.PeopleNavigator()
									.clickResidentialPlacementTab()
									.GetSource()
									.PeopleNavigator()
									.readResidentialPlacementTab();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}

		
}
	
	

