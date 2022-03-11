package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_10953_Pages_View_Preview_TestForm extends AdministratorPage {

	@Test(priority = 1)
	public void TC_Pages_View_Preview() {
		SoftAssert = new SoftAssert();
		
		String PageName= "Screening and Response Tool";

		try {
			SeleniumHelper.log.info("Verifying all fields are grayed out in Preview");
			Expected = True;

			Actual = Source.AdministratorNavigator()
					.clickPages()
					.setSearch(PageName)
					.clickFirstRow()
					.clickView()
					.PagesPage()
					.clickPreview()
					.isQuestionDisabled();

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + " Expected: " + Expected);

			SoftAssert.assertAll();

		} catch (Exception e) {
			Source.SeleniumHelper().assertFail();
		}
	}
	
	
	@Test(priority = 2)	
	public void TC_Pages_View_TestForm() {
		SoftAssert = new SoftAssert();

		String PageName= "Screening and Response Tool";
	
		try {
			SeleniumHelper.log.info("Verifying all fields are grayed out in Test Page");
			Expected = True;

			Actual = Source.AdministratorNavigator()
					.clickPages()
					.setSearch(PageName)
					.clickFirstRow()
					.clickView()
					.PagesPage()
					.clickTestPage()
					.isQuestionDisabled();

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + " Expected: " + Expected);

			SoftAssert.assertAll();

		} catch (Exception e) {
			Source.SeleniumHelper().assertFail();
		}
	}

}