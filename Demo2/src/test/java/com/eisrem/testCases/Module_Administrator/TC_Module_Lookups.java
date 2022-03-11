package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Module_Lookups extends AdministratorPage{

	@Test(priority=1)
		public void TC_Look_Label_Auto_Mod_Answer_001() {		
			SoftAssert = new SoftAssert();
			String groupName = "Selenium Group " + SeleniumHelper.generateRandomAlpha(5);
			String PageName = "Selenium Test " + SeleniumHelper.generateRandomAlpha(4);
				
			try{
			SeleniumHelper.log.info("Adding Lookup with Labels and verifying success");
			Expected = Success;
			Actual = Source		.AdministratorNavigator()
								.clickLookups()
								.clickAdd()
								.LookupsPage()
								.setGroupName(groupName)
								.clickLabelsAvailableAccord()
								.clickAdd()
								.LabelsAvailableAccord()
								.setLabelName("label 1")
								.setLabelSortOrder(1)
								.clickComplete()
								.Pagefactory()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.LookupsPage()
								.clickLabelsAvailableAccord()
								.clickAdd()
								.LabelsAvailableAccord()
								.setLabelName("label 2")
								.setLabelSortOrder(2)
								.clickComplete()
								.Pagefactory()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.LookupsPage()
								.clickLabelsAvailableAccord()
								.clickAdd()
								.LabelsAvailableAccord()
								.setLabelName("disabled label")
								.setLabelSortOrder(3)
								.clickActiveToggle(False)
								.clickComplete()
								.Pagefactory()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Page with Section, Row, Question and verifying success");
			Expected = PageName;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.AdministratorNavigator()
								.clickPages()
								.clickAdd()
								.PagesPage()
								.setPageName(PageName)
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName("Section 1")
								.setSortOrder("1")
								.GetSource()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName("Row 1")
								.setSortOrder("1")
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel("test question")
								.setSortOrder("1")
								.clickLoadFromLookup()
								.setLookupSearch(groupName)
								.clickComplete()						
								.QuestionsAvailableAccord()
								.clickQASave()
								.GetSource()
								.SeleniumHelper()
								.sleep(5)
								.GetSource()
								.RowsAvailableAccord()
								.clickSubmitExit()
								.GetSource()
								.SeleniumHelper()
								.sleep(5)
								.GetSource()
								.DataTable()
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Lookup, editing Label and adding new Label");
			Expected = Success;
			Actual = Source		.AdministratorNavigator()
								.clickLookups()
								.setSearch(groupName)
								.clickFirstRow()
								.clickEdit()
								.LookupsPage()
								.setDescription(UpdateDescription, Clear)
								.GetSource()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.LookupsPage()
								.clickLabelsAvailableAccord()
								.clickFirstRow()
								.clickEdit()
								.LabelsAvailableAccord()
								.clickActiveToggle(False)
								.clickComplete()
								.Pagefactory()
								.clickPopupOk()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.LookupsPage()
								.clickLabelsAvailableAccord()
								.DataTable()
								.setSearch("disabled label")
								.clickFirstRow()
								.clickEdit()
								.LabelsAvailableAccord()
								.clickActiveToggle(True)
								.clickComplete()
								.Pagefactory()
								.clickPopupOk()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.LookupsPage()
								.clickLabelsAvailableAccord()
								.DataTable()
								.clickAdd()
								.LabelsAvailableAccord()
								.setLabelName("label 4")
								.clickComplete()
								.Pagefactory()
								.clickPopupOk()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Page and verifying Answer Values display correctly");
			Expected = "label 4";
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.AdministratorNavigator()
								.clickPages()
								.DataTable()
								.setSearch(PageName)
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.setSearch("section 1")
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch("row 1")
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch("test question")
								.clickQAFirstRow()
								.clickQAEdit()
								.readAnswerValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
	
			Expected = "label 2";
			Actual = Source		.QuestionsAvailableAccord()
								.readAnswerValue2().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "disabled label";
			Actual = Source		.QuestionsAvailableAccord()
								.readAnswerValue3().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
									
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Lookups_Add_001() {		
		SoftAssert = new SoftAssert();
		
		String groupName = "Selenium Group " + SeleniumHelper.generateRandomAlpha(5);
		String labelName = "testLabel " + SeleniumHelper.generateRandomAlpha(4);
					
		try{
		SeleniumHelper.log.info("Adding Lookup with Label and verifying success");
		Expected = Success;
		Actual = Source		.AdministratorNavigator()
							.clickLookups()
							.clickAdd()
							.LookupsPage()
							.setGroupName(groupName)
							.setCategory("test")
							.setDescription(Description)
							.GetSource()
							.LookupsPage()
							.clickLabelsAvailableAccord()
							.clickAdd()
							.LabelsAvailableAccord()
							.setLabelName(labelName)
							.setLabelSortOrder(1)
							.clickComplete()
							.Pagefactory()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Lookup was created successfully");
		Expected = labelName;
		Actual = Source		.Pagefactory()
							.clickPopupOk()
							.LookupsPage()
							.clickLabelsAvailableAccord()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
								
		SoftAssert.assertAll();
	
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}
	
	@Test(priority=3)
	public void TC_Lookups_Edit_001() {		
		SoftAssert = new SoftAssert();
							
		try{
		SeleniumHelper.log.info("Editing Lookup with Label and verifying success");
		Expected = Success;
		Actual = Source		.AdministratorNavigator()
							.clickLookups()
							.clickFirstRow()
							.clickEdit()
							.Pagefactory()
							.setDescription(UpdateDescription, Clear)
							.GetSource()
							.LookupsPage()
							.clickLabelsAvailableAccord()
							.clickFirstRow()
							.clickEdit()
							.LabelsAvailableAccord()
							.setLabelName("Label Name Updated", Clear)
							.setLabelSortOrder(1, Clear)
							.clickComplete()
							.Pagefactory()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Label was edited successfully");
		Expected = "Label Name Updated";
		Actual = Source		.Pagefactory()
							.clickPopupOk()
							.LookupsPage()
							.clickLabelsAvailableAccord()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Sort Order");
		Expected = "1";
		Actual = Source		.DataTable()
							.readDataTable(1, 3);
		SoftAssert.assertEquals(Actual, Expected);
								
		SoftAssert.assertAll();
	
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}
	
	@Test(priority=4)
	public void TC_Lookups_View_001() {		
		SoftAssert = new SoftAssert();
			
		try{
		SeleniumHelper.log.info("Viewing Lookup and verifying textboxes are disabled");
		Expected = True;
		Actual = Source		.AdministratorNavigator()
							.clickLookups()
							.clickFirstRow()
							.clickView()
							.SeleniumHelper()
							.readAttribute(Source.Pagefactory().StartDateTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.LookupsPage().GroupNameTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.LookupsPage().CategoryTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
								
		SoftAssert.assertAll();
	
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}
	
	@Test(priority=5)
	public void TC_Load_From_Lookup_001() {		
		SoftAssert = new SoftAssert();
		
		String gName = "Group Name" + SeleniumHelper.generateRandomAlpha(5);
		String pName = "Selenium Test Page" + SeleniumHelper.generateRandomAlpha(6);
			
		try{
		SeleniumHelper.log.info("Adding Lookup with Label and verifying success");
		Expected = Success;
		Actual = Source		.AdministratorNavigator()
							.clickLookups()
							.clickAdd()
							.LookupsPage()
							.setGroupName(gName)
							.setCategory("Test")
							.setDescription(Description)
							.GetSource()
							.LookupsPage()
							.clickLabelsAvailableAccord()
							.clickAdd()
							.LabelsAvailableAccord()
							.setLabelName("TC LABELNAME")
							.setLabelSortOrder(1)
							.clickComplete()
							.Pagefactory()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Adding Page and then editing Page and confirming Success");
		Expected = Success;
		Actual = Source		.Pagefactory()
							.clickPopupOk()
							.Pagefactory()
							.clickSubmit()
							.clickPopupOk()
							.AdministratorNavigator()
							.clickPages()
							.clickAdd()
							.PagesPage()
							.setPageName(pName)
							.setDescription("TC_Pages_Test")
							.clickSubmit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5)
							.DataTable()
							.setSearch(pName)
							.clickFirstRow()
							.clickEdit()
							.DataTable()
							.clickAdd()
							.SectionsAvailableAccord()
							.setSectionName("Selenium Section")
							.setSortOrder("1")
							.GetSource()
							.RowsAvailableAccord()
							.clickRowAdd()
							.setRowName("Selenium Row")
							.setSortOrder("1")
							.setDescription("Row Description")
							.clickRowSave()
							.GetSource()
							.SeleniumHelper()
							.sleep(5)
							.GetSource()
							.QuestionsAvailableAccord()
							.clickQAAdd()
							.selectQuestionType(1)
							.setQuestionLabel("TC LABEL")
							.setSortOrder("1")
							.clickLoadFromLookup()
							.setLookupSearch("Test")
							.clickComplete()
							.QuestionsAvailableAccord()
							.clickSubmitExit()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
								
		SoftAssert.assertAll();
	
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}
	
	@Test(priority=5)
	public void TC_Administrator_Lookup_Add_001() {		
		SoftAssert = new SoftAssert();
		
		String gName = "Selenium Category" + SeleniumHelper.generateRandomNumber(5);
					
		try{
		SeleniumHelper.log.info("Adding Lookup with Label and verifying success");
		Expected = Success;
		Actual = Source		.AdministratorNavigator()
							.clickLookups()
							.clickAdd()
							.LookupsPage()
							.setGroupName(gName)
							.clickLabelsAvailableAccord()
							.clickAdd()
							.LabelsAvailableAccord()
							.setLabelName("TC LABELNAME")
							.setLabelSortOrder(1)
							.clickComplete()
							.Pagefactory()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Adding Label with the same name and verifying duplicate cannot be entered");
		Expected = "There is already a Lookup with that group name. Please use another.";
		Actual = Source		.Pagefactory()
							.clickPopupOk()
							.Pagefactory()
							.clickSubmit()
							.clickPopupOk()
							.DataTable()
							.clickAdd()
							.LookupsPage()
							.setGroupName(gName)
							.clickSubmit()
							.readTopErrorMessage(2);
		SoftAssert.assertEquals(Actual, Expected);
								
		SoftAssert.assertAll();
	
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}
	
}