package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;


public class TC_Conducted_Type_Required_Question_Asterisk_001 extends PeoplePage  {

	@Test(priority=1)

	public void confirmRelatedQstnAsterisk() {
		SoftAssert = new SoftAssert();	
		String ctTitle = "Conducted Type "  + SeleniumHelper.generateRandomNumber(4);
		String ctType = "OCFS REPORTABLE EVENT FORM/ Reportable Event";
		String programLabel = "PROGRAM COMPLETING THE FORM (CHOOSE ONLY ONE)";
		String programOtherLabel = "PROGRAM TYPE OTHER";
		try {
			SeleniumHelper.log.info("Conducting a reportable event with related questions, " + 
					"confirm question is marked as required if triggered.");
						
			Source	.DataTable()
					.setSearch(TestClient2)
					.clickFirstRow()
					.clickAnchor()
					.NavigationMenuBar()
					.clickReportableEvent()
					.DataTable()
					.clickAdd()
					.ReportableEventPage()
					.setTitle(ctTitle)
					.selectReportableEventType(ctType)
					.setDescription("Testing Related Questions Asterisk")
					.clickStartReportableEvent()
					.clickFormContinue()
					.continueIfError()
					.fillForm2()
					.selectValue(2, programLabel, "PROGRAM TYPE OTHER")
					.setText(2, programOtherLabel,  "", Clear)
					.checkFieldRequired(2,programOtherLabel)
					.clickContinue()
					.FormPage()
					.continueIfError()
					.selectValue(2, programLabel, 2)
					.checkFieldNonRequired(2,programOtherLabel)
					.clickContinue()
					.NavigationMenuBar()
					.clickMyHomePage()
					.clickDiscard();
		SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
