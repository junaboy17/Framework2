package com.eisrem.testCases.Module_Classes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.ClassesPage;

public class TC_Classes_Roster_Add_Edit_View extends ClassesPage {

	@Test 
	public void Classes_Roster_Add_001(){
		SoftAssert = new SoftAssert();
		String ClassName = "Selenium Test Class " + SeleniumHelper.generateRandomNumber(4);
		
		SeleniumHelper.log.info("Verifying Roster add functionality");
		Expected = Success;
		Actual = Source	.DataTable()
						.clickAdd()
						.ClassesPage()
						.setClassName(ClassName)
						.setSeatsAvailable(String.valueOf(RandNum3))
						.selectServicePopulation(3)
						.selectProgramType(1)
						.selectOrganizationLocation(1)
						.setDescription(Description)
						.setEndDate(FutureDate7)
						.clickSubmit()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickAnchor()
						.ClassesNavigator()
						.clickRoster()
						.clickAdd()
						.RosterPage()
						.selectTypeOfMemberDropDown(2)
						.setPaymentProcessedDate(Today)
						.setPaymentConfirmationNum(String.valueOf(RandNum8))
						.setNotes("Selenium Test" + RandNum3)
						.clickSubmit()
						.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying if Roster was added successfully");
		
		Expected = "PERSON/";
		Actual = Source	.Pagefactory()
						.clickGoBackToList()
						.DataTable()
						.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
				
	}
	
	@Test 
	public void Classes_Roster_Edit_001(){
		SoftAssert = new SoftAssert();
				
		SeleniumHelper.log.info("Verifying Roster Edit functionality");
		Expected = Success;
		Actual = Source	.DataTable()
						.clickFirstRow()
						.clickAnchor()
						.ClassesNavigator()
						.clickRoster()
						.clickAdd()
						.RosterPage()
						.selectTypeOfMemberDropDown(2)
						.setPaymentProcessedDate(Today)
						.setPaymentConfirmationNum(String.valueOf(RandNum8))
						.setNotes("Selenium Test")
						.clickSubmit()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.RosterPage()
						.setPaymentProcessedDate(FutureDate7, Clear)
						.setPaymentConfirmationNum(String.valueOf(RandNum4), Clear)
						.setNotes("Selenium Test" + RandNum3, Clear)
						.clickSubmit()
						.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying if Roster was edited successfully");
		
		Expected = FutureDate7;
		Actual = Source	.Pagefactory()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.SeleniumHelper()
						.readAttribute(Source.RosterPage().PaymentProcessedDateTextBox, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = String.valueOf(RandNum4);
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.RosterPage().PaymentConfirmationTextBox, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = "Selenium Test" + RandNum3;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.Pagefactory().DescriptionTextBox, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
				
	}
	
	@Test 
	public void Classes_Roster_View_001(){
		SoftAssert = new SoftAssert();
		
		SeleniumHelper.log.info("Verifying Roster view functionality");
		Expected = "View Roster";
		Actual = Source	.DataTable()
						.clickFirstRow()
						.clickAnchor()
						.ClassesNavigator()
						.clickRoster()
						.clickAdd()
						.RosterPage()
						.selectTypeOfMemberDropDown(2)
						.setPaymentProcessedDate(Today)
						.setPaymentConfirmationNum(String.valueOf(RandNum8))
						.setNotes("Selenium Test")
						.clickSubmit()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickView()
						.RosterPage()
						.readPageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying if editing is disabled in view mode");
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.RosterPage().TypeOfMemberDropDown, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.RosterPage().PaymentProcessedDateTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.RosterPage().PaymentConfirmationTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.RosterPage().DescriptionTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
	
		Source.SchedulePage().clickBackTo();
		
		SoftAssert.assertAll();
				
	}
	
}
