package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.AppAreaConductType;
import com.eisrem.AppUtils.Enumerations.AppModule;
import com.eisrem.AppUtils.Enumerations.LockTime;
import com.eisrem.AppUtils.Enumerations.QuestionType;
import com.eisrem.AppUtils.Enumerations.Roles;
import com.eisrem.AppUtils.Enumerations.ServicePopulations;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class TC_BHOPS_11921_Pages_Question_Lock_Form extends AdministratorPage {


	@Test(priority=1)
	public void TC_Pages_Question_Lock_Form() {
		
		SoftAssert = new SoftAssert();
		
		int randNum4 = SeleniumHelper.generateRandomNumber(4);
		String LockFormPage = "11921 LOCK FORM PAGE " + randNum4;
		String LockTestSection = "11921 LOCK TEST SECTION " + randNum4;
		String LockTestRow = "11921 LOCK TEST ROW " + randNum4;
		String LockFormTestType = "11921 LOCK FORM TEST TYPE" + randNum4;
		String Notes = LockFormTestType + "/ Notes";
				
		try{
			SeleniumHelper.log.info("Verifying lock form functionality");

							//Add page with required question	
					Source  .PagesPage()
							.addPage(LockFormPage,null ,null , F,Description)
							.GetSource()
							.SectionsAvailableAccord()
							.addSection(LockTestSection, 1, Description, F, F, T)
							.GetSource()
							.RowsAvailableAccord()
							.addRow(LockTestRow, 1, null, F, F, T)
							.GetSource()
							.QuestionsAvailableAccord()
							.clickQAAdd()
					    	.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
							.setQuestionLabel("QUESTION 1")
							.setSortOrder(OneN)
							.clickLockFormToggle()
							.clickQASave()
							.clickPopupOkIfExist()
							
							.RowsAvailableAccord()
							.clickRowsBack()
							.GetSource()
							.SectionsAvailableAccord()
							.clickSectionsBack()
							.GetSource()
							.PagesPage()
							.clickLockForUseToggle()
							.clickYes()
							.PagesPage()	
							.clickSubmitExit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5)
														
							// add a new type with page created above
							.GetSource()
							.TypesPage()
							.addType(LockFormTestType, 
									null, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), 
									Description, F, F, AppAreaConductType.PEOPLE.getIndex())
							
							//Add Page
							.GetSource()
							.PagesAvailableAccord()
							.addPage(LockFormPage, 1, null, null, null, T, T)
							.addRoleToPage(Roles.ALLAPPS.getIndex())
				 			.clickServicePopulationAvailableAccord()
							.GetSource()
							.PagesAvailableAccord()
							.addServicePopulationToPage(ServicePopulations.CHILDRENS.getIndex())
							.clickCompleteAndOk()
							
							//Lock type for use
							.TypesPage() 
							.clickLockForUseToggle()
							.clickYes()
							.TypesPage()
							.clickSubmitExit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5)

							// add and anchor client and conduct the type
							.GetSource()
							.NavigationMenuBar()
							.clickPeople()
							.clickAdd()
							.DemographicsPage()
							.fillRequiredDemogrphics()
							.clickSubmit()
							.clickPopupOk()
							.PeopleNavigator()
							.clickPeopleTab()
							.clickFirstRow()
							.clickAnchor()
							.NavigationMenuBar()
							.clickNotes()
							.clickAdd()
							.NotesPage()
							.selectType(Notes)
							.setTitle("Selenium Test")
							.clickStartAssessment()
							.setText(1, "QUESTION 1", "ABC")
							.clickSubmitAllPages()
							.clickGoBackToList()
							.NotesNavigator()
							.clickFirstRow()
							.clickEdit()
							.FormPage()
					        .checkAllWebElementsDisabled();
									
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
			
		}
	
	}

}