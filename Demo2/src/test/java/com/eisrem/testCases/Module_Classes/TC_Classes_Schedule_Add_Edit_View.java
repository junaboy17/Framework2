package com.eisrem.testCases.Module_Classes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.ClassesPage;

public class TC_Classes_Schedule_Add_Edit_View extends ClassesPage {

	@Test 
	public void Classes_Schedule_Add_001(){
		SoftAssert = new SoftAssert();
		String ClassName = "Selenium Test Class " + SeleniumHelper.generateRandomNumber(4);
		
		SeleniumHelper.log.info("Verifying Schedule add functionality");
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
						.clickSchedule()
						.clickAdd()
						.SchedulePage()
						.setClassDate(Today)
						.selectStartTime(3, 3, 3, 2)
						.selectEndTime(4, 4, 4, 2)
						.setDescription(Description)
						.clickSubmit()
						.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying if Schedule was added successfully");
		
		Expected = Today + " 03:02:02 PM - 04:03:03 PM";
		Actual = Source	.SchedulePage()
						.clickGoBackToList()
						.DataTable()
						.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
				
	}
	
	@Test 
	public void Classes_Schedule_Edit_001(){
		SoftAssert = new SoftAssert();
		int randnum = SeleniumHelper.generateRandomNumber(1, 12);
		
		SeleniumHelper.log.info("Verifying Schedule Edit functionality");
		Expected = Success;
		Actual = Source	.DataTable()
						.clickFirstRow()
						.clickAnchor()
						.ClassesNavigator()
						.clickSchedule()
						.clickAdd()
						.SchedulePage()
						.setClassDate(Today)
						.selectStartTime(3, 3, 3, 2)
						.selectEndTime(4, 4, 4, 2)
						.setDescription(Description)
						.clickSubmit()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.SchedulePage()
						.selectStartTimeMin(randnum)
						.selectEndTimeHr(randnum)
						.setDescription(Description + RandNum2, Clear)
						.clickSubmit()
						.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying if Schedule was edited successfully");
		
		Expected = String.valueOf(randnum-1);
		Actual = Source	.Pagefactory()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.SeleniumHelper()
						.readAttribute(Source.SchedulePage().StartTimeMinDropDown, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = String.valueOf(randnum);
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.SchedulePage().EndTimeHrDropDown, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = Description + RandNum2;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.SchedulePage().DescriptionTextBox, "last-val")
						.replace("\"", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
				
	}
	
	@Test 
	public void Classes_Schedule_View_001(){
		SoftAssert = new SoftAssert();
		
		SeleniumHelper.log.info("Verifying Classes view functionality");
		Expected = "View Schedule";
		Actual = Source	.DataTable()
						.clickFirstRow()
						.clickAnchor()
						.SchedulePage()
						.clickSchedule()
						.clickAdd()
						.SchedulePage()
						.setClassDate(Today)
						.selectStartTime(3, 3, 3, 2)
						.selectEndTime(4, 4, 4, 2)
						.setDescription(Description)
						.clickSubmit()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickView()
						.SchedulePage()
						.readPageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying if editing is disabled in view mode");
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.SchedulePage().ClassDateTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.SchedulePage().StartTimeMinDropDown, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.SchedulePage().EndTimeMinDropDown, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source	.SeleniumHelper()
						.readAttribute(Source.SchedulePage().DescriptionTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
	
		Source.SchedulePage().clickBackTo();
		
		SoftAssert.assertAll();
				
	}
	
}
