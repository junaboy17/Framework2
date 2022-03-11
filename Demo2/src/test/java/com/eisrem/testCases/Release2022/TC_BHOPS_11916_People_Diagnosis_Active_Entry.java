package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;

public class TC_BHOPS_11916_People_Diagnosis_Active_Entry extends PeoplePage {
	@Test(priority=1)
	public void TC_BHOPS_11916_People_Diagnosis_Active_Entry() {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Diagnosis and confirming error message");
			Expected = "Please correct the following errors:";
			
			DataTable dt = Source		
					.DataTable()
					.clickAdd()
					.DemographicsPage()
					.fillRequiredDemogrphicsWithIdentifier()
					.clickSubmit()
					.clickPopupOk()
					.PeopleNavigator()
					.clickPeopleTab()
					.clickFirstRow()
					.clickAnchor()
					.PeopleNavigator()
					.clickDiagnosisTab();
			
		          dt.clickAdd()
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
			        .clickPopupOk();
			
	        String message = dt.clickAdd()
			        .DiagnosisPage()
			        .setDiagnosis(PrimaryDiagnosis, "475148")
			        .setDiagnosisStartDate(PrimaryDiagnosis, Today)
			        .setDiagnosisBy(PrimaryDiagnosis, "test", Clear)
			        .clickSubmit()
			        .readTopErrorMessage(2);
			                                                			
			Expected = "Active Diagnosis Exists. Please End Date the existing Diagnosis";
			Actual =	Source		
									.DataTable()
									.readTopErrorMessage(2);								
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}