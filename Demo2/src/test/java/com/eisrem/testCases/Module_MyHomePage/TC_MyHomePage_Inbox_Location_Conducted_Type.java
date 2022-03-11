package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.OrganizationPage;

public class TC_MyHomePage_Inbox_Location_Conducted_Type extends OrganizationPage{

	@Test(priority=1)
	public void TC_MyHomePage_Inbox_Location_Conducted_Type_001() {
		
		SoftAssert = new SoftAssert();
		
		String title = "TC_Homepage_" + RandNum4;

		try{
			SeleniumHelper.log.info("test");
			Expected =	Success;						
			Actual = Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickFirstRow()
								.clickAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.selectAssessmentType(4)
								.setTitle(title)
								.clickStartAssessment()
								.fillForm()
								.clickSubmitAllPages()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("test");
			Expected =	"Test NOTIFICATION 2931923 Modified";						
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickMyHomePage()
								.GetSource()
								.SeleniumHelper()
								.Wait(360)
								.refreshPage()
								.GetSource()
								.MyHomePage()
								.readMyInboxFirstResultNameValue();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("test");
			Expected =	"Edit Assessment/forms";						
			Actual = Source		.MyHomePage()
								.clickMyInboxFirstResultGoBtn()
								.GetSource()
								.FormPage()
								.readHeader();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}
