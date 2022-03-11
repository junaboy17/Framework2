package com.eisrem.testCases.Business.Module_QuickLinks;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BusinessUserLogIn;
import edu.emory.mathcs.backport.java.util.Arrays;

public class Quick_Links_Access_Check extends BusinessUserLogIn {

	@Test(priority=1)
	public void Quick_Links() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Quick Links function is working successfully");
			Expected =	"View";
			Actual =	Source		.NavigationMenuBar()
									.clickQuickLinks()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	"Excel";
			Actual =	Source		.QuickLinksPage()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying quick links working correctly");
			Expected =	"Reportable Events";
			Actual =	Source		.DataTable()
									.setSearch("reportable events web page")
									.clickFirstRowNameLink()
									.GetSource()
									.SeleniumHelper()
									.switchWindow()
									.GetSource()
									.ReportableEventPage()
									.readReportableEventsTitle();
													
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}
		

	
	

