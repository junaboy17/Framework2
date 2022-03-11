package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.SearchPage;


public class TC_Search_Trimed_Whitespace extends SearchPage{
	@Test(priority=1)
	public void TC_Search_Trimed_Whitespace_001() {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = UserId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.USER.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setValue(Source.SeleniumHelper().valueWithWhitespace(UserId))
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditUserHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}