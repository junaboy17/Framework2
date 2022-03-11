package com.eisrem.testCases.Module_QuickLinks;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.QuickLinksPage;

public class TC_Links_Check_URL_300_Chars_Max_Length extends QuickLinksPage{


	@Test(priority=1)
	public void CheckURL300CharsMaxLength() {
		SoftAssert = new SoftAssert();
		String URL300 = "https://portal.devlb.state.me.us/eisrem/welcome12/" + SeleniumHelper.generateRandomAlpha(250);
		String URL350 = "https://portal.devlb.state.me.us/eisrem/welcome12/" + SeleniumHelper.generateRandomAlpha(300);
		String DisplayedName = "Selenium Test" + RandNum4 ;
		
		try{
			SeleniumHelper.log.info("Verifying the URL length when entering Above 300 characters.");
			Expected = URL350;
			Actual = Source   	.QuickLinksPage()
								.clickAdd()
								.QuickLinksPage()
								.setDisplayedName(DisplayedName)
								.setLinkURL(URL350)
								.readLinkURLValue();
			SoftAssert.assertEquals(Actual.replace("\"", EmptyString), Expected.substring(0, 300));
			
			SeleniumHelper.log.info("Verifying the URL length when entering exactly 300 characters.");
			Expected = URL300;
			Actual = Source   	.NavigationMenuBar()
								.clickQuickLinks()
								.clickDiscard()
								.DataTable()
								.clickAdd()
								.QuickLinksPage()
								.setDisplayedName(DisplayedName)
								.setLinkURL(URL300)
								.readLinkURLValue();
			SoftAssert.assertEquals(Actual.replace("\"", EmptyString), Expected);

			SeleniumHelper.log.info("Verifying the URL length when entering exactly 300 characters after a successful addition of a Link.");
			Expected = URL300;
			Actual = Source   	.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.Pagefactory()
								.clickPopupOk()
								.QuickLinksPage()
								.clickSubmitExit()
								.clickPopupOk()
								.DataTable()
								.setSearch(DisplayedName)
								.clickFirstRow()
								.clickView()
								.QuickLinksPage()
								.readLinkURLValue();
			SoftAssert.assertEquals(Actual.replace("\"", EmptyString), Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}



}