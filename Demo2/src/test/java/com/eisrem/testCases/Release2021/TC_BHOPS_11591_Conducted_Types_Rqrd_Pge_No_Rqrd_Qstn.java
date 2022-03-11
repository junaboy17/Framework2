package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class TC_BHOPS_11591_Conducted_Types_Rqrd_Pge_No_Rqrd_Qstn extends AdministratorPage  {

	@Test(priority=1)

	public void TC_Conducted_Types_Rqrd_Pge_No_Rqrd_Qstn()  {
		
		SoftAssert = new SoftAssert();
		try {
			SeleniumHelper.log.info("Creating a Type - with ONE page (required) that has no required questions,"
					+ "and at least ONE combobox question (People, Organization, User, or People)."
					+ " Testing to ensure that the conducted type fails to submit when not answering any"
					+ "of these combobox questions.");
									
					Source			//Add First Page with required question	
									.PagesPage()
									.addPage("Required Page with No Required Questions",null ,null , F, null)
									.GetSource()
									.SectionsAvailableAccord()
									.addSection("Section 1", 1, null, F, F, T)
									.GetSource()
									.RowsAvailableAccord()
									.addRow("Row 1", 1, null, F, F, T)
									.GetSource()
									
									
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.CONDUCTED_TYPE_SEARCH.getIndex())
									.setQuestionLabel("Conducted Type Lookup")
									.setSortOrder("1")
									.clickQASave()
									.clickPopupOk()
									//.GetSource()
									
									
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.ORGANIZATION_LOOKUP.getIndex())
									.setQuestionLabel("Organization Lookup")
									.setSortOrder("2")
									.clickQASave()
									.clickPopupOk()
									//.GetSource()
									
									
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.USER_LOOKUP.getIndex())
									.setQuestionLabel("User Lookup")
									.setSortOrder("3")
									.clickQASave()
									.clickPopupOk()
									//.GetSource()
									
									
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.PERSON_LOOKUP.getIndex())
									.setQuestionLabel("Person Lookup")
									.setSortOrder("4")
									.clickQASave()
									.clickPopupOk()
									//.GetSource()
									
									
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
									
									// add a new type with 2 pages created above
									.GetSource()
									.TypesPage()
									.addType("One required page and one non-required dropdown", 
											null, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), 
											"TC_Conducted_Types_Rqrd_Pge_No_Rqrd_Qstn", T, F, AppAreaConductType.BOTH.getIndex())
									
									//Add Page 1
									.GetSource()
									.PagesAvailableAccord()
									.addPage("Required Page with No Required Questions", 1, null, null, null, T, T)
									.addRoleToPage(Roles.ALLAPPS.getIndex())
									.clickServicePopulationAvailableAccord()
									.GetSource()
									.PagesAvailableAccord()
									.addServicePopulationToPage(ServicePopulations.CHILDRENS.getIndex())
									.clickComplete()
									.QuestionsAvailableAccord()
									.clickPopupOk()
									//.clickCompleteAndOk()
									
									//Lock type for use
									.TypesPage() 
									.clickLockForUseToggle()
									.clickYes()
									.TypesPage()
									.clickSubmitExit()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									
					
							/*
							 *Creating a person 
							 */
							.GetSource()
							.NavigationMenuBar()
							.clickPeople()
							.DataTable()
							.clickAdd()
							.DemographicsPage()
							.fillAllDemogrphicsNoIdentifier()
							.clickSubmit()
							.clickPopupOk();
					
					String[] comboboxNames = {"Person Lookup", "Organization Lookup", "User Lookup", "Conducted Type Lookup"};
					String[] searchTerms = {"BACON", "central office", "WILSON, TARAN"};
					String[] searchTerms2 = {"BAMBINO", "4269", "HODGES, BRAD"};
					String[] clear = {};
					String conductedTypeId = "";
					String conductedTypeId2 = "";
					
					for(int i = 0; i < comboboxNames.length; i++) {
						// anchor on a client and conduct the type
						Expected ="Unable to Save Submission, Please answer the following required page(s): Required Page with No Required Questions";
						Actual = Source
										.NavigationMenuBar()
										.clickNotes()
										.clickAdd()
										.NotesPage()
										.selectType("One required page and one non-required dropdown/ Notes")
										.setTitle("Selenium Test")
										.clickStartAssessment()
										.clickSubmitAllPages()
										.readTopErrorMessage(2);
						
						SoftAssert.assertEquals(Expected, Actual);
						
										Source.FormPage()
										.setComboBox(comboboxNames[i], i != 3 ? searchTerms[i] : conductedTypeId, clear);
						
										
										
						Expected ="Unable to Save Submission, Please answer the following required page(s): Required Page with No Required Questions";
						Actual = Source
								.FormPage()
								.searchComboBoxWithoutSetting(comboboxNames[i], i != 3 ? searchTerms[i] : conductedTypeId, "clear".split("e"))
								.clickSubmitAllPages()
								.readTopErrorMessage(2);
				
						SoftAssert.assertEquals(Expected, Actual);
				
						
						
						
						
						Source.FormPage()
								.setComboBox(comboboxNames[i], i != 3 ? searchTerms[i] : conductedTypeId2, "clear".split("e"));
						
						Expected = "Operation completed successfully.";
						if(i == 0) {
							
							Actual = Source.FormPage()
									.clickSubmitAllPages()
									.readPopUpMessage();
							
							conductedTypeId = Source.FormPage()
									.clickGoBackToList()
									.DataTable()
									.getDataByRow("1")
									.get(DataTableHeaders.ID)
									.replaceAll("[^0-9]", "");
						} else if(i == 1) {
							
							Actual = Source.FormPage()
									.clickSubmitAllPages()
									.readPopUpMessage();
							
							conductedTypeId2 = Source.FormPage()
									.clickGoBackToList()
									.DataTable()
									.getDataByRow("1")
									.get(DataTableHeaders.ID)
									.replaceAll("[^0-9]", "");
						} else {
							Actual = Source.FormPage()
										.clickSubmitAllPages()
										.readPopUpMessage();
						
							Source.FormPage()
										.clickGoBackToList();
						}
						
						SoftAssert.assertEquals(Expected, Actual);
						
						
						
						
						
						Expected ="Unable to Save Submission, Please answer the following required page(s): Required Page with No Required Questions";
						Actual = Source
										.NavigationMenuBar()
										.clickNotes()
										.clickFirstRow()
										.clickEdit()
										.FormPage()
										.searchComboBoxWithoutSetting(comboboxNames[i], i != 3 ? searchTerms2[i] : conductedTypeId2, "clear".split("e"))
										.clickSubmitAllPages()
										.readTopErrorMessage(2);
						
						SoftAssert.assertEquals(Expected, Actual);
						
										Source.FormPage()
										.setComboBox(comboboxNames[i], i != 3 ? searchTerms2[i] : conductedTypeId2, "clear".split("e"));
						
										
										
						Expected = "Operation completed successfully.";
						Actual = Source.FormPage()
									.clickSubmitAllPages()
									.readPopUpMessage();
						
						Source.FormPage()
									.clickGoBackToList();
						
						SoftAssert.assertEquals(Expected, Actual);
						
					}
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
