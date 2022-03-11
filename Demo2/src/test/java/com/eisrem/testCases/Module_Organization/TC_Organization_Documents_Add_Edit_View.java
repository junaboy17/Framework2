package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Documents_Add_Edit_View extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Organization_Documents_Add_001() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding Documents");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickDocuments()
			                    .clickAdd()
			                    .DocumentsPage()
			                    .setTitle(DocumentName)
								.setDocumentFile(DocumentPath, DocumentFile)
								.clickAdd()
								.DocumentsUserPage()
								.setUser(UserFullName)
								.clickComplete()
								.DocumentsPage()
								.clickSubmit()
								.readPopUpMessage();
			 
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }

	@Test(priority=2)
	public void TC_Organization_Documents_Edit_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing Documents");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
							    .clickDocuments()
							    .clickFirstRow()
			                    .clickEdit()
			                    .DocumentsPage()
			                    .setDescription("SELENIUM TEST RECORD")
			                    .clickSubmit()
			                    .readPopUpMessage();
			
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
	
	@Test(priority=3)
	public void TC_Organization_Documents_View_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Viewing Documents");
			Expected =True;

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
							    .clickDocuments()
							    .clickFirstColumnLink()
							    .clickView()
							    .SeleniumHelper()
								.getAttribute(Source.DocumentsPage().TitleTextbox, "disabled");
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.DocumentsPage().DescriptionTextBox, "disabled");
			
			SoftAssert.assertEquals(Actual, Expected);
						
		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
}