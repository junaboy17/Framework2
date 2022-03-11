package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.CommonPage.Pagefactory;

public class People_Diagnosis_Test extends PeoplePage {
	@Test(priority=1)
	public void Diagnosis_Add_001() {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Diagnosis and confirming success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickRow(RandNum1)
									.clickAnchor()
									.PeopleNavigator()
									.clickDiagnosisTab()
									.DataTable()
									.clickAdd()
									.DiagnosisPage()
									.setDiagnosis(PrimaryDiagnosis, "475148")
									.setDiagnosisStartDate(PrimaryDiagnosis, Today)
									.setDiagnosisBy(PrimaryDiagnosis, "test", Clear)
									.setDiagnosis(SecondaryDiagnosis, "475148")
									.setDiagnosisStartDate(SecondaryDiagnosis, Today)
									.setDiagnosisBy(SecondaryDiagnosis, "test2", Clear)
									.setDiagnosis(SecondaryDiagnosis2, "475148")
									.setDiagnosisStartDate(SecondaryDiagnosis2, Today)
									.setDiagnosisBy(SecondaryDiagnosis2, "test3", Clear)
									.setDiagnosis(TertiaryDiagnosis, "475148")
									.setDiagnosisStartDate(TertiaryDiagnosis, Today)
									.setDiagnosisBy(TertiaryDiagnosis, "test4", Clear)
									.setOtherDiagnosis("Cholera")
									.setDiagnosisStartDate(OtherDiagnosis, Today)
									.setDiagnosisBy(OtherDiagnosis, "test5", Clear)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirming Diagnosis was added");
			Expected = "CHOLERA- -A00 / CHOLERA- -A00 / CHOLERA- -A00 / CHOLERA- -A00";
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
	public void Diagnosis_Edit_001() {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Diagnosis and confirming success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickRow(RandNum1)
									.clickAnchor()
									.PeopleNavigator()
									.clickDiagnosisTab()
									.DataTable()
									.clickAdd()
									.DiagnosisPage()
									.setDiagnosis(PrimaryDiagnosis, "475148")
									.setDiagnosisStartDate(PrimaryDiagnosis, Today)
									.setDiagnosisBy(PrimaryDiagnosis, "test", Clear)
									.setDiagnosis(SecondaryDiagnosis, "475148")
									.setDiagnosisStartDate(SecondaryDiagnosis, Today)
									.setDiagnosisBy(SecondaryDiagnosis, "test2", Clear)
									.setDiagnosis(SecondaryDiagnosis2, "475148")
									.setDiagnosisStartDate(SecondaryDiagnosis2, Today)
									.setDiagnosisBy(SecondaryDiagnosis2, "test3", Clear)
									.setDiagnosis(TertiaryDiagnosis, "475148")
									.setDiagnosisStartDate(TertiaryDiagnosis, Today)
									.setDiagnosisBy(TertiaryDiagnosis, "test4", Clear)
									.setOtherDiagnosis("Cholera")
									.setDiagnosisStartDate(OtherDiagnosis, Today)
									.setDiagnosisBy(OtherDiagnosis, "test5", Clear)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirming Diagnosis was added");
			Expected = "CHOLERA- -A00 / CHOLERA- -A00 / CHOLERA- -A00 / CHOLERA- -A00";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();								
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Diagnosis and confirming success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickEdit()
									.DiagnosisPage()
									.setDescription(UpdateDescription, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirming Diagnosis was editted successfully");
			Expected = UpdateDescription;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.Pagefactory()
									.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void Diagnosis_View_001() {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Diagnosis and confirming success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickRow(RandNum1)
									.clickAnchor()
									.PeopleNavigator()
									.clickDiagnosisTab()
									.DataTable()
									.clickAdd()
									.DiagnosisPage()
									.setDiagnosis(PrimaryDiagnosis, "475148")
									.setDiagnosisStartDate(PrimaryDiagnosis, Today)
									.setDiagnosisBy(PrimaryDiagnosis, "test", Clear)
									.setDiagnosis(SecondaryDiagnosis, "475148")
									.setDiagnosisStartDate(SecondaryDiagnosis, Today)
									.setDiagnosisBy(SecondaryDiagnosis, "test2", Clear)
									.setDiagnosis(SecondaryDiagnosis2, "475148")
									.setDiagnosisStartDate(SecondaryDiagnosis2, Today)
									.setDiagnosisBy(SecondaryDiagnosis2, "test3", Clear)
									.setDiagnosis(TertiaryDiagnosis, "475148")
									.setDiagnosisStartDate(TertiaryDiagnosis, Today)
									.setDiagnosisBy(TertiaryDiagnosis, "test4", Clear)
									.setOtherDiagnosis("Cholera")
									.setDiagnosisStartDate(OtherDiagnosis, Today)
									.setDiagnosisBy(OtherDiagnosis, "test5", Clear)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirming Diagnosis was added");
			Expected = "CHOLERA- -A00 / CHOLERA- -A00 / CHOLERA- -A00 / CHOLERA- -A00";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();								
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Viewing Diagnosis and confirming fields cannot be changed");
			Expected = True;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.DiagnosisPage()
									.readDiagnosisAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual =	Source 		.DiagnosisPage()
									.readDiagnosisStartDateAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual =	Source 		.DiagnosisPage()
									.readDiagnosisEndDateAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual =	Source 		.DiagnosisPage()
									.readDiagnosisByAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}