package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.SearchPage;


public class TC_Search_Button_Functionality extends SearchPage{
	@Test(priority=1)
	public void TC_Search_Button_Functionality_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verify Search is enabled with criteria added");
			Expected = True;
			Actual = Source   	.SearchPage()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.NAME.getName())
								.setValue(CentralOffice)
								.clickSearchAdd()
								.setSearchBy(SearchBy.ADDRESS.getName())
								.setSearchCondition(SearchCondition.AND.getName())
								.setAddress("2 ANTHONY AVE")
								.setCity("FORT KENT")
								.clickSearchAdd()
								.isSearchEnabled();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying Search Criteria size");
			Expected = True;
			Actual = Source   	.SearchPage()
								.isListBoxSizeEqual(2);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying Search Criteria size is reduced");
			Expected = True;
			Actual = Source   	.SearchPage()
								.removeSearchCriteria(1)
								.isListBoxSizeEqual(1);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying Search Criteria size is reduced");
			Expected = True;
			Actual = Source   	.SearchPage()
								.removeSearchCriteria(0)
								.isListBoxSizeEqual(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying Search Button is disabled");
			Expected = False;
			Actual = Source   	.SearchPage()
								.isSearchEnabled();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verify Search is enabled with criteria added after removal");
			Expected = True;
			Actual = Source   	.SearchPage()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.NAME.getName())
								.setValue(CentralOffice)
								.clickSearchAdd()
								.isSearchEnabled();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}