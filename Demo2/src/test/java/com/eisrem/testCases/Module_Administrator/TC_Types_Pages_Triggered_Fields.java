package com.eisrem.testCases.Module_Administrator;

import java.util.LinkedList;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Types_Pages_Triggered_Fields extends AdministratorPage{
	@Test(priority=1)
	public void TC_Types_Pages_Triggered_Fields_001() {		
		SoftAssert = new SoftAssert();
		try{
			LinkedList<String> triggeredAnswers = new LinkedList<String>();		
			triggeredAnswers.add("null");
			
			SeleniumHelper.log.info("Create Type with two pages. Second page triggered by first page, question and answer");
			Expected = True;
			Actual = Source 	.AdministratorNavigator()
								.clickTypes()
								.GetSource()
								.TypesPage()
								.addType(TypeName, Today, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), Description, F, F, AppAreaConductType.BOTH.getIndex())
								.GetSource()
								.PagesAvailableAccord()
								.addPage(DataFixFormV2.toUpperCase(), 1, null, null, null, F, T)
								.clickCompleteAndOk()
								.PagesAvailableAccord()
								.addPage(DataFixFormV2.toUpperCase(), 2, DataFixFormV2.toUpperCase(), "Agency Name", triggeredAnswers, F, T)
								.clickCompleteAndOk()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk()
								.DataTable()
								.setSearch(TypeName)
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.clickSecondRow()
								.clickEdit()
								.PagesAvailableAccord()
								.isTriggeredByPopulated(DataFixFormV2.toUpperCase(), "Agency Name", triggeredAnswers.getFirst());
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date Type and Pages");
			Source				.PagesAvailableAccord()	
								.clickCancel()
								.PagesAvailableAccord()
								.GetSource()
								.TypesPage()
								.setEndDate(Today, "")
								.GetSource()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk();
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}