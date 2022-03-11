package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.Enumerations.Roles;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_10952_Types_Conduct_By extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Types_Conduct_By_001() {
		
		SoftAssert = new SoftAssert();
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);
		String OrganizationAssessName= "Conducted On Organization " + RandNum8;
		String BothOrgPeopAssessName = "Conducted On Both " + RandNum8;
		String PeopleAssessName = "Conducted On People " + RandNum8;

		try{
					SeleniumHelper.log.info("Navigating to add types page & verifying if App Area to Coduct Type field exist");
					Expected = "App Area To Conduct Type *";
					Actual = Source	.DataTable()
									.clickAdd()
									.TypesPage()
									.selectAppModule(Enumerations.AppModule.ASSESSMENT.getName())
									.setName(OrganizationAssessName)
									.setDescription("TC Types Conducted On 001")
									.selectLockTime(1)
									.readAppAreaToConductTypeTitle();
					SoftAssert.assertEquals(Actual, Expected);	
					
					SeleniumHelper.log.info("Adding Organization type  & verifying if App Area to Coduct Type field exist");
					Expected = "App Area To Conduct Type *"; 
					Actual = Source	.TypesPage()
									.selectAppAreaToConductType(1)
									.clickAdd()
									.PagesAvailableAccord()
									.setPage("DATA FIX")
									.setSortOrder("1")
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.selectRole(Roles.ALLAPPS.getName())
									.setDescription("TC Types Conducted On 001")
									.clickRolesComplete()
									.PagesAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(3)
									.setDescription("TC Types Conducted On 001")
									.clickSpComplete()
									.PagesAvailableAccord()
									.clickComplete()
									.DataTable()
									.clickPopupOk()
									.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.TypesPage()
									.selectAppModule(Enumerations.AppModule.ASSESSMENT.getName())
									.setName(PeopleAssessName)
									.setDescription("TC Types Conducted On 001")
									.selectLockTime(1)
									.readAppAreaToConductTypeTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding People type  & verifying if App Area to Coduct Type field exist");
					Expected = "App Area To Conduct Type *"; 
					Actual = Source	.TypesPage()
									.selectAppAreaToConductType(2)
									.clickAdd()
									.PagesAvailableAccord()
									.setPage("DATA FIX")
									.setSortOrder("1")
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.selectRole(Roles.ALLAPPS.getName())
									.setDescription("TC Types Conducted On 001")
									.clickRolesComplete()
									.PagesAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(3)
									.setDescription("TC Types Conducted On 001")
									.clickSpComplete()
									.PagesAvailableAccord()
									.clickComplete()
									.DataTable()
									.clickPopupOk()
									.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.TypesPage()
									.selectAppModule(Enumerations.AppModule.ASSESSMENT.getName())
									.setName(BothOrgPeopAssessName)
									.setDescription("TC Types Conducted On 001")
									.selectLockTime(1)
									.readAppAreaToConductTypeTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding Both type  & verifying if App Area to Coduct Type field exist");
					Expected = "App Area To Conduct Type *"; 
					Actual = Source	.TypesPage()
									.selectAppAreaToConductType(3)
									.clickAdd()
									.PagesAvailableAccord()
									.setPage("DATA FIX")
									.setSortOrder("1")
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.selectRole(Roles.ALLAPPS.getName())
									.setDescription("TC Types Conducted On 001")
									.clickRolesComplete()
									.PagesAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(3)
									.setDescription("TC Types Conducted On 001")
									.clickSpComplete()
									.PagesAvailableAccord()
									.clickComplete()
									.DataTable()
									.clickPopupOk()
									.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.setSearch(OrganizationAssessName)
									.clickFirstRow()
									.clickEdit()
									.TypesPage()
									.readAppAreaToConductTypeTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Serching for Organization type & verifying if Organization is still selected in App Area Conduct Type Field while in edit mode");
					Expected = OrganizationID; 
					Actual = Source	.TypesPage()
									.readAppAreaToConductTypeValue();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying error message when not selecting any App Area To Conduct Type");
					Expected = "Please enter a App Area To Conduct Type *"; 
					Actual = Source	.TypesPage()
									.selectAppAreaToConductType(0)
									.clickSubmitExit()
									.readTopErrorMessage(1);
					SoftAssert.assertEquals(Actual, Expected);

					SeleniumHelper.log.info("Verifying if App Area to Coduct Type field exist in view mode");
					Expected = "App Area To Conduct Type *"; 
					Actual = Source	.TypesPage()
									.selectAppAreaToConductType(1)
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.setSearch(OrganizationAssessName)
									.clickFirstRow()
									.clickView()
									.TypesPage()
									.readAppAreaToConductTypeTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying if App Area to Coduct Type field is disabled & value is correct in view mode");
					Expected = "true"; 
					Actual = Source	.TypesPage()
									.readAppAreaToConductTypeValue("disabled");
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected = OrganizationID; 
					Actual = Source	.TypesPage()
									.readAppAreaToConductTypeValue();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Enabling Lock For Use in Organization type & verifying if App Area to Coduct Type field is disabled & value is correct");
					String date = Tomorrow;	
					Expected = "true"; 
					Actual = Source	.TypesPage()
									.clickBackToTypes()
									.setSearch(OrganizationAssessName)
									.clickFirstRow()
									.clickEdit()
									.TypesPage()
									.setEndDate(date)
									.GetSource()
									.TypesPage()
									.clickLockForUseToggle()
									.clickYes()
									.TypesPage()
									.readAppAreaToConductTypeValue("disabled");				
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected = OrganizationID; 
					Actual = Source	.TypesPage()
									.readAppAreaToConductTypeValue();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Enabling Lock For Use in People type & verifying if App Area to Coduct Type field is disabled & value is correct");
					Expected = "true"; 
					Actual = Source	.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.setSearch(PeopleAssessName)
									.clickFirstRow()
									.clickEdit()
									.TypesPage()
									.setEndDate(date)
									.GetSource()
									.TypesPage()
									.clickLockForUseToggle()
									.clickYes()
									.TypesPage()
									.readAppAreaToConductTypeValue("disabled");	
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected = PeopleID; 
					Actual = Source	.TypesPage()
									.readAppAreaToConductTypeValue();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Enabling Lock For Use in Both type & verifying if App Area to Coduct Type field is disabled & value is correct");
					Expected = "true"; 
					Actual = Source	.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.setSearch(BothOrgPeopAssessName)
									.clickFirstRow()
									.clickEdit()
									.TypesPage()
									.setEndDate(date)
									.GetSource()
									.TypesPage()
									.clickLockForUseToggle()
									.clickYes()
									.TypesPage()
									.readAppAreaToConductTypeValue("disabled");	
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected = BothOrgPeopID; 
					Actual = Source	.TypesPage()
									.readAppAreaToConductTypeValue();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Anchoring Organization, verifying if Organization & Both types are avaiable, & People type is not avaiable in Assessment Forms selection");
					String[] orgValue1 =  {OrganizationAssessName + "/ Assessment", BothOrgPeopAssessName + "/ Assessment"};
					String[] orgvalue2 = {PeopleAssessName + "/ Assessment"};
					
					Source			.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.NavigationMenuBar()
									.clickOrganization()
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.SeleniumHelper()
									.verifyGivenValueDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, orgValue1);	
					
					Source		.SeleniumHelper()
								.verifyGivenValueDoNotExistDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, orgvalue2);
					
					SeleniumHelper.log.info("Anchoring People, verifying if People & Both types are avaiable, & Organization type is not avaiable in Assessment Forms selection");
					String [] peopValue1 =  {BothOrgPeopAssessName + "/ Assessment", PeopleAssessName + "/ Assessment"};
//					String [] peopValue1 =  {"Conducted On People/ Assessment", "Conducted On Both/ Assessment"};
					String [] peopValue2 = {OrganizationAssessName + "/ Assessment"};
					Source		.FormPage()
								.clickBackToAssessment()
								.GetSource()
								.SeleniumHelper()
								.refreshPage()
								.GetSource()
								.NavigationMenuBar()
								.clickPeople()
								.clickFirstRow()
								.GetSource()
								.PeoplePage()
								.clickPeopleAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.SeleniumHelper()
								.verifyGivenValueDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, peopValue1);
					
					Source		.SeleniumHelper()
								.verifyGivenValueDoNotExistDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, peopValue2);
					
					Source		.FormPage()
								.clickBackToAssessment();
					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}
	
	

