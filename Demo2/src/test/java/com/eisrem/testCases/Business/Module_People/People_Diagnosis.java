package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_Diagnosis extends PeoplePage {
	@Test(priority=1)
	public void Add_Diagnosis() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a new Person with Identifier, Association, Diagnosis and verifying success");
			Expected =	Success;
			Actual =	Source		.DataTable()	
									.clickAdd()
									.DemographicsPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickDiagnosisTab()
									.clickAdd()
									.DiagnosisPage()
									.setDiagnosis(PrimaryDiagnosis, "480348")
									.setDiagnosisStartDate(PrimaryDiagnosis, PastDate45)
									.setDiagnosisBy(PrimaryDiagnosis, "Dr. Spook")
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Diagnosis was successfully added");
			Expected =	"ANXIETY DISORDER, UNSPECIFIED- -F419 / / /";
			Actual =	Source		.Pagefactory()
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
	public void Edit_Diagnosis() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a new Person with Identifier, Association, Diagnosis and verifying success");
			Expected =	Success;
			Actual =	Source		.DataTable()	
									.clickAdd()
									.DemographicsPage()
									.setStartDate(PastDate30, Clear)
									.GetSource()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickDiagnosisTab()
									.clickAdd()
									.DiagnosisPage()
									.setDiagnosis(PrimaryDiagnosis, "480348")
									.setDiagnosisStartDate(PrimaryDiagnosis, PastDate45)
									.setDiagnosisBy(PrimaryDiagnosis, "Dr. Spook")
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Diagnosis was successfully added");
			Expected =	"ANXIETY DISORDER, UNSPECIFIED- -F419 / / /";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Diagnosis By and verifying sucessful edit");
			Expected =	"Dr. Spook MD";
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickEdit()
									.DiagnosisPage()
									.setDiagnosisBy(PrimaryDiagnosis, "Dr. Spook MD", Clear)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.DiagnosisPage()
									.readDiagnosisBy(PrimaryDiagnosis).replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=3)
	public void End_Date_Diagnosis() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a new Person with Identifier, Association, Diagnosis and verifying success");
			Expected =	Success;
			Actual =	Source		.DataTable()	
									.clickAdd()
									.DemographicsPage()
									.setStartDate(PastDate45, Clear)
									.GetSource()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickDiagnosisTab()
									.clickAdd()
									.DiagnosisPage()
									.setDiagnosis(PrimaryDiagnosis, "480348")
									.setDiagnosisStartDate(PrimaryDiagnosis, PastDate45)
									.setDiagnosisBy(PrimaryDiagnosis, "Dr. Spook")
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Diagnosis was successfully added");
			Expected =	"ANXIETY DISORDER, UNSPECIFIED- -F419 / / /";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Diagnosis End Date and verifying sucessful edit");
			Expected =	PastDate30;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickEdit()
									.DiagnosisPage()
									.setDiagnosisEndDate(PrimaryDiagnosis, PastDate30)
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