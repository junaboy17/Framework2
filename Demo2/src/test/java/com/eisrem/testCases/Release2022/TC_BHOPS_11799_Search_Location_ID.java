package com.eisrem.testCases.Release2022;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.SearchPage;

public class TC_BHOPS_11799_Search_Location_ID extends SearchPage {
	
	@Test(priority=1)
	public void TC_Search_Location_ID() {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setValue(OneN)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);
				
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				SeleniumHelper.log.info("Verify Search loads results");
				Expected = EditLocationHeader;					
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
	
	

