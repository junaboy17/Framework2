package com.eisrem.testCases.Business.Module_People;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class Enrollment_Add_Edit_End extends PeoplePage {

	@Test(priority=1)
	public void Add_Enrollment() {

		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Adding Enrollment Status and verifying success");
			Expected =	"OADS Eligible";
			Actual =	Source		.DataTable()			
									.setSearch("333415")
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.setStartDate(PastDate7, Clear)
									.GetSource()
									.EnrollmentStatusPage()
									.selectStatus(2)
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
	public void Edit_Enrollment() {

		SoftAssert = new SoftAssert();
	
		try{
			
			SeleniumHelper.log.info("Adding Enrollment Status and verifying success");
			Expected =	"OADS Eligible";
			Actual =	Source		.DataTable()			
									.setSearch("333415")
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.setStartDate(PastDate7, Clear)
									.GetSource()
									.EnrollmentStatusPage()
									.selectStatus(2)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Enrollment Status and verifying success");
			Expected =	"Test Data";
			Actual =	Source		.DataTable()			
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.setDescription("Test Data")
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=3)
	public void End_Enrollment() {

		SoftAssert = new SoftAssert();
	
		try{
			
			SeleniumHelper.log.info("Adding Enrollment Status and verifying success");
			Expected =	"OADS Eligible";
			Actual =	Source		.DataTable()
									.setSearch("333415")
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.setStartDate(PastDate7, Clear)
									.GetSource()
									.EnrollmentStatusPage()
									.selectStatus(2)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Enrollment Status and verifying success");
			Expected =	PastDate3;
			Actual =	Source		.DataTable()			
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.setEndDate(PastDate3)
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
}
