package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Documents_Access extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Organization_Documents_Access_001() {
		
		SoftAssert = new SoftAssert();
		
		String title = "DOCUMENT TITLE - SELENIUM" + RandAlpha3;

		try{
			SeleniumHelper.log.info("Adding Documents");
			Expected =Success;

			Actual=Source		.OrganizationPage()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickDocuments()
								.clickAdd()
								.DocumentsPage()
								.setTitle(title)
								.setDocumentFile(DocumentPath, DocumentFile)
								.clickAdd()
								.DocumentsUserPage()
								.setUser("K", Clear)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
}