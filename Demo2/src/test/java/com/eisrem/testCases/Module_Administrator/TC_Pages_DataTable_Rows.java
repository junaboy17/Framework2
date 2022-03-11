package com.eisrem.testCases.Module_Administrator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.QuestionType;
import com.eisrem.Hooks.AdministratorPage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TC_Pages_DataTable_Rows extends AdministratorPage{
	
	@Test(priority=1)
	public void TC_Pages_DataTable_Rows_001() {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying 'Show Entries' Drop Down");
			Expected = False;
			Actual = Source	.AdministratorNavigator()
					.clickPages()
					.GetSource()
					.DataTable()
					.validateRecordIds();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
	
}