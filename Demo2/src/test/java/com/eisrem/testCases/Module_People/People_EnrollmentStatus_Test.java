package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_EnrollmentStatus_Test extends PeoplePage {

	@Test(priority=1)
	public void EnrollmentStatus_Add_001() {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Enrollment Status and confirming Enrollment Status was successfully added");
			Expected =	"V9 Status";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.selectStatus(1)
									.setDescription(Description)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=2)
	public void EnrollmentStatus_Edit_001() {

		SoftAssert = new SoftAssert();
		
		String v9 = "V9 Status";

		try{

			SeleniumHelper.log.info("Editing Enrollment Status and Confirming Enrollment Status was successfully edited");
			Expected =	v9;
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.selectStatus(1)
									.setDescription(Description)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Tomorrow;
			Actual =	Source		.DataTable()
									.setSearch(v9)
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.setEndDate(Tomorrow)
									.GetSource()
									.EnrollmentStatusPage()
									.setDescription(UpdateDescription, Clear)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=3)
	public void EnrollmentStatus_View_001() {

		SoftAssert = new SoftAssert();
		
		String v9 = "V9 Status";

		try{

			SeleniumHelper.log.info("Editing Enrollment Status and Confirming Enrollment Status was successfully edited");
			Expected =	v9;
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.selectStatus(1)
									.setDescription(Description)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Description;
			Actual =	Source		.DataTable()
									.setSearch(v9)
									.clickFirstRow()
									.clickView()
									.EnrollmentStatusPage()
									.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	True;
			Actual =	Source		.SeleniumHelper()
									.getAttribute(Source.EnrollmentStatusPage().StatusDropdown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}
