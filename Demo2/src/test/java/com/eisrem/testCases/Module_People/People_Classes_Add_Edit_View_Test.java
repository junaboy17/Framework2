package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_Classes_Add_Edit_View_Test extends PeoplePage {
	
	@Test(priority=1)
	public void Classes_Add_001() {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Successful add of a class to an individual");
			Expected ="Success!";
			Actual = Source		.PeoplePage()
					//To create a new class if XSELENUM TEST is not avaiable
//								.clickClasses()
//								.clickAdd()
//								.ClassesPage()
//								.setClassName(ClassName)
//								.setSeatsAvailable("50")
//								.setStartDate(FutureDate2, Clear)
//								.setEndDate("03/04/2024")
//								.selectServicePopulation(3)
//								.selectOrganizationLocation(3)
//								.setDescription("Test")
//								.clickSubmitExit()
//								.DataTable()
//								.clickGoBackToList()
//								.SeleniumHelper()
//								.refreshPage()
//								.GetSource()
//								.NavigationMenuBar()
//								.clickPeople()
								.AddPeople()
								.clickClassesTab()
								.clickAdd()
								.PeopleClassesPage()
//								.setClassType(ClassName)
								.setClassType(ClassNamePreFix)
								.setPaymentProcessDate(Today)
								.setPaymentConfirmationNumber("325462")
								.clickPaymentProcessedToggle()
								.setNotes("SELENIUM TEST RECORD - ADD")
								.clickSubmitExit()
								.GetSource()
								.DataTable()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);		
			
			SoftAssert.assertAll();
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=2)
	public void Classes_Edit_001() {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Successful edit of a class info for an individual");
			Expected ="Success!";
			Actual = Source		.PeoplePage()
								.AddPeople()
								.clickClassesTab()
								.clickAdd()
								.PeopleClassesPage()
								.setClassType(ClassNamePreFix)
								.setPaymentProcessDate(Today)
								.setPaymentConfirmationNumber("325462")
								.clickPaymentProcessedToggle()
								.setNotes("SELENIUM TEST RECORD - ADD")
								.clickSubmitExit()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PeopleClassesPage()
								.setPaymentProcessDate(FutureDate2, "y")
								.setPaymentConfirmationNumber("2312313", "y")
								.setNotes("SELENIUM TEST RECORD - UPDATED")
								.clickSubmitExit()
								.GetSource()
								.DataTable()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();
				
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
	
	}		
	
	@Test(priority=3)
	public void Classes_View_001() {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Successful view of a class info & if fields are disabled for an individual");
			Expected = True;
			Actual = Source		.PeoplePage()
								.AddPeople()
								.clickClassesTab()
								.clickAdd()
								.PeopleClassesPage()
								.setClassType(ClassNamePreFix)
								.setPaymentProcessDate(Today)
								.setPaymentConfirmationNumber("325462")
								.clickPaymentProcessedToggle()
								.setNotes("SELENIUM TEST RECORD - ADD")
								.clickSubmitExit()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.SeleniumHelper()
								.readAttribute(Source.PeopleClassesPage().ClassTypeTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
					Source		.PeopleClassesPage()
								.clickBackToClasses();	
			System.out.println(Actual);
			
			SoftAssert.assertAll();
				
			}catch(Exception e) {
				Source	.SeleniumHelper()	
						.assertFail();
			}
	
		}
	
	}
	

