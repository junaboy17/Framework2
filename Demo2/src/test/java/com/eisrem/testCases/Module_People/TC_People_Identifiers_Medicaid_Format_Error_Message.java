package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_People_Identifiers_Medicaid_Format_Error_Message extends PeoplePage {
	
	@Test(priority=1)
	public void Medicaid_Format_Error_Message_001() {	
		
		SoftAssert = new SoftAssert();
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);

		try{
					SeleniumHelper.log.info("Verifying error Message after trying to add identifier In identifier accordion with invalid ID format");
					Expected = "Incorrect formatting of Medicaid ID - 8 digits followed by 1 capital letter.";
					Actual =  	Source	.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphics()
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickPeopleTab()
										.DataTable()
										.clickFirstRow()
										.clickEdit()
										.DemographicsPage()
										.clickIdentifiersAccord()
										.DataTable()
										.clickAdd()
										.IdentifiersPage()
										.selectIdentifiersType(1)
										.setIdentifiersIdNumber("2342344a")
										.clickComplete()
										.IdentifiersPage()
										.readInvalidIDErrorMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Changing identifier type & verifying if error Message is visiable");
					ExpectedB =	false;
					ActualB = 	Source	.IdentifiersPage()
										.selectIdentifiersType(2)
										.GetSource()
										.SeleniumHelper()
										.ifWebElementExists(Source	.IdentifiersPage()
																	.InvalidIDErrorMessage, 1);		
					SoftAssert.assertEquals(ActualB, ExpectedB);	
					
					SeleniumHelper.log.info("Editing exixting Identifier ID Number in identifiers Accordion & Verifying error Message");
					Expected =	"Incorrect formatting of Medicaid ID - 8 digits followed by 1 capital letter.";
					Actual = 	Source	.IdentifiersPage()
										.selectIdentifiersType(1)
										.setIdentifiersIdNumber(RandNum8 + "A", "y")
										.clickComplete()
										.DemographicsPage()
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickPeopleTab()
										.DataTable()
										.clickFirstRow()
										.clickEdit()
										.DemographicsPage()
										.clickIdentifiersAccord()
										.DataTable()
										.clickFirstRow()
										.clickEdit()
										.IdentifiersPage()
										.setIdentifiersIdNumber("235234a", "y")
										.clickComplete()
										.IdentifiersPage()
										.readInvalidIDErrorMessage();
					SoftAssert.assertEquals(Actual, Expected);	
					
					SeleniumHelper.log.info("Verifying error Message after trying to add identifier In identifier Tab with invalid ID format");
					Expected =	"Incorrect formatting of Medicaid ID - 8 digits followed by 1 capital letter.";
					Actual = 	Source	.IdentifiersPage()
										.setIdentifiersIdNumber(RandNum8 + "B", "y")
										.clickComplete()
										.DemographicsPage()
										.clickSubmit()
										.clickPopupOk()
										.SeleniumHelper()
										.refreshPage()
										.GetSource()
										.NavigationMenuBar()
										.clickPeople()
										.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphics()
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickIdentifierTab()
										.DataTable()
										.clickAdd()
										.IdentifiersPage()
										.selectIdentifiersType(1)
										.setIdentifiersIdNumber("2356215a")
										.clickSubmit()
										.readInvalidIDErrorMessage();
					SoftAssert.assertEquals(Actual, Expected);	
					
					SeleniumHelper.log.info("Changing identifier type & verifying if error Message is visiable");
					ExpectedB =	false;
					ActualB = 	Source	.IdentifiersPage()
										.selectIdentifiersType(2)
										.GetSource()
										.SeleniumHelper()
										.ifWebElementExists(Source	.IdentifiersPage()
																	.InvalidIDErrorMessage, 1);		
					SoftAssert.assertEquals(ActualB, ExpectedB);
					
					SeleniumHelper.log.info("Editing exixting Identifier ID Number in identifiers Tab & Verifying error Message");
					Expected =	"Incorrect formatting of Medicaid ID - 8 digits followed by 1 capital letter.";
					Actual = 	Source	.IdentifiersPage()
										.selectIdentifiersType(1)
										.setIdentifiersIdNumber(RandNum8 + "C", "y")
										.clickSubmit()
										.DataTable()
										.clickPopupOk()
										.DataTable()
										.clickFirstRow()
										.clickEdit()
										.IdentifiersPage()
										.setIdentifiersIdNumber("2356215a", "y")
										.clickSubmit()
										.readInvalidIDErrorMessage();
					SoftAssert.assertEquals(Actual, Expected);	
					
								Source	.IdentifiersPage()
										.setIdentifiersIdNumber(RandNum8 + "D", "y")
										.clickSubmit()
										.DataTable()
										.clickPopupOk();
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

