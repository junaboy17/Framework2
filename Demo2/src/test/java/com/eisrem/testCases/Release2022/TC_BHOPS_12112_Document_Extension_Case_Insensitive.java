package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_12112_Document_Extension_Case_Insensitive extends OrganizationPage {
	@Test(priority=1)
	public void Documents_Add_001() {

		SoftAssert = new SoftAssert();
		
		String TestTitle = "TEST" + SeleniumHelper.generateRandomNumber(4);
		String TestTitle2 = "TEST" + SeleniumHelper.generateRandomNumber(4);
		String DocumentFile2 = "eis_pdf_upload2.PDF";

		try{

			SeleniumHelper.log.info("Adding documents with .PDF and .pdf extension");
			Expected = Success;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickDocuments()
									.clickAdd()
									.DocumentsPage()
									.setTitle(TestTitle)
									.setDocumentFile(DocumentPath, DocumentFile)
									.setDescription(Description, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying new Document record was added Successfully");
			Expected = TestTitle;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = Success;
			Actual =	Source		.OrganizationNavigator()
									.clickDocuments()
									.clickAdd()
									.DocumentsPage()
									.setTitle(TestTitle2)
									.setDocumentFile(DocumentPath, DocumentFile2)
									.setDescription(Description, Clear)
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