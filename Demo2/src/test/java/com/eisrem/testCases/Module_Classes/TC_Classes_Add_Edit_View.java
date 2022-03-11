package com.eisrem.testCases.Module_Classes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.ClassesPage;

public class TC_Classes_Add_Edit_View extends ClassesPage {

	@Test 
	public void Classes_Add_001(){
		SoftAssert = new SoftAssert();
		
		String ClassName = "Selenium Test Class " + SeleniumHelper.generateRandomNumber(4);
		
		try {
		SeleniumHelper.log.info("Verifying Classes add functionality");
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
						.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying if class was created successfully");
		
		Expected = ClassName;
		Actual = Source	.ClassesPage()
						.clickGoBackToList()
						.DataTable()
						.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
		}
	
	
	@Test 
	public void Classes_Edit_001(){
		SoftAssert = new SoftAssert();
		
		try {
		SeleniumHelper.log.info("Verifying Classes edit functionality");
		
		Expected = Success;
		Actual = Source	.DataTable()
						.clickFirstRow()
						.clickEdit()
						.ClassesPage()
						.setSeatsAvailable(String.valueOf(RandNum4), Clear)
						.setDescription("Updated Test" + RandNum4, Clear)
						.clickSubmit()
						.readPopUpTitle();		
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Navigating back to edit page and verifying updated value");
		
		Expected = String.valueOf(RandNum4);
		Actual = Source	.ClassesPage()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.SeleniumHelper()
						.readAttribute(Source.ClassesPage().SeatsAvailableTextBox, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = "Updated Test" + RandNum4;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.ClassesPage().DescriptionTextBox, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);		

		SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
		}
	
	
	@Test 
	public void Classes_View_001(){
		
		SoftAssert = new SoftAssert();
		
		try {
		SeleniumHelper.log.info("Verifying Classes view functionality");
		Expected = True;
		Actual = Source	.DataTable()
						.clickFirstRow()
						.clickView()
						.SeleniumHelper()
						.readAttribute(Source.ClassesPage().ClassNameTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying if editing is disabled in view mode");
		
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.ClassesPage().SeatsAvailableTextBox, "disabled");
		Expected = True;
		SoftAssert.assertEquals(Actual, Expected);
		
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.ClassesPage().StartDateTextBox, "disabled");
		Expected = True;
		SoftAssert.assertEquals(Actual, Expected);
		
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.ClassesPage().DescriptionTextBox, "disabled");
		Expected = True;
		SoftAssert.assertEquals(Actual, Expected);
		
		Source.Pagefactory().clickBackTo();
		
		SoftAssert.assertAll();
	}
	
	catch(Exception e) {
		Source	.SeleniumHelper()
		.assertFail();
	}
	
	}
}
