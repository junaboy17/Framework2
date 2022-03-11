package com.eisrem.testCases.Module_People;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;


public class LanguagePageTest extends PeoplePage{


	@Test(priority=1)
	public void LanguagePageTitleCheck() {
		SoftAssert = new SoftAssert();

		try{	
		SeleniumHelper.log.info("Verifying 'Language' link title");
		Expected ="Language";
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickAnchor()
							.PeopleNavigator()
							.clickLanguageTab()
							.readLanguageTabTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Language Primary Language title");
		Expected ="Primary Language";
		Actual = Source		.LanguagePage()
							.readPrimaryLanguageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Language English Proficiency title");
		Expected ="English Proficiency";
		Actual = Source		.LanguagePage()
							.readEnglishProficiencyTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Submit' btn title");
		Expected ="Submit";
		Actual = Source		.DemographicsPage()
							.readSubmitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Print' btn title");
		Expected ="Print";
		Actual = Source		.DemographicsPage()
							.readPrintBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To Demographics' btn title");
		Expected ="Back To People";
		Actual = Source		.DemographicsPage()
							.readBackToPeopleBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
		
	
	
}