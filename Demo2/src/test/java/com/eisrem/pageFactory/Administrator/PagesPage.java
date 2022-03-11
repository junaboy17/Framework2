package com.eisrem.pageFactory.Administrator;

	import java.util.HashMap;
import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.SectionsAvailableAccord;

	public class PagesPage extends AdministratorNavigator{

		public PagesPage(WebDriver driver) {
			super (driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//h3[contains(text(),'Add Pages')]")
		public WebElement AddPagesTitle;
		
		@FindBy(xpath="//p[@class='required-note'][1]")
		public WebElement NoteTitle;
		
		@FindBy(xpath="//p[@class='required-note'][2]")
		public WebElement AddPageCompleteTitle;
		
		@FindBy(xpath="//a[contains(text(),'Pages Info:')]")
		public WebElement PagesInfoLink;
		
		@FindBy(xpath="//ul[@id='types-pills']")
		public WebElement PageTabTitle;
		
		@FindBy(xpath="//label[@for='pageName']")
		public WebElement PageNameTitle;
		
		@FindBy(xpath="//input[@id='pageName']")
		public WebElement PageNameTextBox;
			
		@FindBy(xpath="//label[contains(text(),'Lock For Use')]")
		public WebElement LockForUseBtn;
		
		@FindBy(xpath="//div[@id='types-tab-content']//div[1]//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]")
		public WebElement LockForUseToggle;
		
		@FindBy(xpath="//*[@id=\"activeFlag\"]")
		public WebElement ActiveFlag;
		
		@FindBy(xpath="//*[@id=\"lockformFlag\"]")
		public WebElement LockFormFlag;
		
		@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-6 col-xs-12'] [1] //input")
		public WebElement LockForUseYesNoBtnAttribute;
		
		@FindBy(xpath="//label[contains(text(),'Description')]")
		public WebElement DescriptionTitle;
		
		@FindBy(xpath="//textarea[@id='pageDesc']")
		public WebElement DescriptionTextBox;
		
		@FindBy(xpath="//button[contains(text(),'Preview')]")
		public WebElement PreviewBtn;
		
		@FindBy(xpath="//button[contains(text(),'Copy Page')]")
		public WebElement CopyPageBtn;
		
		@FindBy(xpath="//button[contains(text(),'Test Page')]")
		public WebElement TestPageBtn;
		
		@FindBy(xpath="//button[contains(text(),'Submit & Exit')]")
		public WebElement SubmitExitBtn;
		
		@FindBy(xpath="//button[contains(text(),'Reset')]")
		public WebElement ResetBtn;
		
		@FindBy(xpath="//a[contains(text(),'Sections Available:')]")
		public WebElement SectionsAvailableLink;
		
		@FindBy(xpath="//button[@class = 'btn btn-warning full-width']")
		public WebElement BackBtn;
		
		@FindBy(xpath="//p[text()='Trigger Related Question']/../input")
		public WebElement TriggerRelatedQuestions;

		@FindBy(xpath="//input[starts-with(@id,'renderTypeQuestion')]")
		public WebElement RenderTypeQuestion;
		
		public String readAddPagesTitle() {
			return Source.SeleniumHelper().readElement(AddPagesTitle);
		}
		
		public String readNoteTitle() {
			return Source.SeleniumHelper().readElement(NoteTitle);
		}
		
		public String readAddPageCompleteTitle() {
			return Source.SeleniumHelper().readElement(AddPageCompleteTitle);
		}
			
		public String readPagesInfoLink() {
			return Source.SeleniumHelper().readElement(PagesInfoLink);
		}
		
		public PagesPage clickPagesInfo() {
			 Source.SeleniumHelper().clickElement(PagesInfoLink);
			return this;
		}
		
		public String readPageTab() {
			return Source.SeleniumHelper().readElement(PageTabTitle);
		}
		
		public String readPageNameTitle() {
			return Source.SeleniumHelper().readElement(PageNameTitle);
		}
		
		public PagesPage setPageName(String pageName, String... Clear) {
			Source	.SeleniumHelper()
					.setText(PageNameTextBox, pageName, Clear);
			return this;
		}
		
		public String readLockForUseBtn() {
			return Source.SeleniumHelper().readElement(LockForUseBtn);
		}
		
		public String readLockForUseToggle() {
			return Source.SeleniumHelper().readElement(LockForUseToggle);
		}
		
		public PagesPage clickLockForUseToggle() {
			 Source.SeleniumHelper().clickElement(LockForUseToggle);
			return this;
		}
			
		public String readDescriptionTitle() {
			return Source.SeleniumHelper().readElement(DescriptionTitle);
		}
		
		public String readPreviewBtn() {
			return Source.SeleniumHelper().readElement(PreviewBtn);
		}
		
		public PagesPage clickPreview() {
			 Source.SeleniumHelper().clickElement(PreviewBtn);
			return this;
		}
		
		public String readCopyPageBtn() {
			return Source.SeleniumHelper().readElement(CopyPageBtn);
		}
		
		public PagesPage clickCopyPage() {
			 Source.SeleniumHelper().clickElement(CopyPageBtn);
			return this;
		}
		
		public String readTestPageBtn() {
			return Source.SeleniumHelper().readElement(TestPageBtn);
		}
		
		public PagesPage clickTestPage() {
			 Source.SeleniumHelper().clickElement(TestPageBtn);
			return this;
		}
		
		public PagesPage clickTestBack() {
			 Source.SeleniumHelper().clickElement(BackBtn);
			return this;
		}
		
		public String readSectionsAvailableLink() {
			return Source.SeleniumHelper().readElement(SectionsAvailableLink);
		}
		
		public SectionsAvailableAccord clickSectionsAvailable() {
			 Source.SeleniumHelper().clickElement(SectionsAvailableLink);
			return new SectionsAvailableAccord(DriverFactory.getDriver());
		}
		
		public String readSubmitExitBtn() {
			return Source.SeleniumHelper().readElement(SubmitExitBtn);
		}
		
		public PagesPage clickSubmitExit() {
			 Source.SeleniumHelper().clickElement(SubmitExitBtn);
			return this;
		}
		
		public PagesPage clickSubmitExit(int sec) {
			 Source	.SeleniumHelper()
			 		.clickElement(SubmitExitBtn)
			 		.Wait(sec);
			return this;
		}
		
		public String readResetBtn() {
			return Source.SeleniumHelper().readElement(ResetBtn);
		}
			
		public PagesPage clickReset() {
			Source.SeleniumHelper().clickElement(ResetBtn);
			return this;
		}
		
		public String readBackToListBtn() {
			return Source.SeleniumHelper().readElement(BackToListBtn);
		}
		
		public PagesPage addPageAndSubmit(String name, String startDate, String endDate, boolean lockForUse, String description)
		{
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(name == null ? PageName : name)
						.setStartDate(startDate == null ? Today : startDate)
						.setEndDate(endDate == null ? EmptyString : endDate)
						.setDescription(Description == null ? EmptyString : description);
			
			if((lockForUse && ActiveFlag.getAttribute("last-val").equals("false"))
					|| (!lockForUse && ActiveFlag.getAttribute("last-val").equals("true")))
				Source.PagesPage().clickLockForUseToggle().clickYes();
						
				Source	.PagesPage()
						.clickSubmit()
						.GetSource()
						.SeleniumHelper()
						.sleep(5);
			return this;
		}
		
		public PagesPage addPage(String name, String startDate, String endDate, boolean lockForUse, String description)
		{
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(name == null ? PageName : name)
						.setStartDate(startDate == null ? Today : startDate)
						.setEndDate(endDate == null ? EmptyString : endDate)
						.setDescription(description == null ? EmptyString : description);				
			
			if((lockForUse && ActiveFlag.getAttribute("last-val").equals("false"))
					|| (!lockForUse && ActiveFlag.getAttribute("last-val").equals("true")))
				Source.PagesPage().clickLockForUseToggle().clickYes();

			return this;
		}
		
		public String addPageUnlockedGetNameAndSubmit() {
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
				
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName)
						.clickSubmit()
						.GetSource()
						.SeleniumHelper()
						.sleep(5);
			return PageName;
		}
		
		public String addPageUnlockedGetName(Boolean complete) {
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
				
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName);
			return PageName;
		}
		
		public PagesPage addPageUnlockedAndSubmit() {
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName)
						.clickSubmit()
						.clickPopupOk();
			return this;
		}
		
		public PagesPage addPageUnlocked() {
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName);
			return this;
		}
		
		public String addPageLockedGetNameAndSubmit() {
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
				
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName)
						.clickLockForUseToggle()
						.clickYes()
						.PagesPage()
						.clickSubmit()
						.clickPopupOk();
			return PageName;
		}
		
		public String addPageLockedGetName() {
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
				
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName)
						.clickLockForUseToggle()
						.clickYes();
			return PageName;
		}
		
		public PagesPage addPageLockedAndSubmit() {
			
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName)
						.clickLockForUseToggle()
						.clickYes()
						.PagesPage()
						.clickSubmit()
						.clickPopupOk();
			
			return this;
		}
		
		public PagesPage addPageLocked() {
			
			String PageName= "TC_Pages_Selenium " + SeleniumHelper.generateRandomNumber(8);
			Source   	.AdministratorNavigator()
						.clickPages()
						.clickAdd()
						.PagesPage()
						.setPageName(PageName)
						.clickLockForUseToggle()
						.clickYes();
			return this;
		}
		
		public PagesPage lockPageAndSubmit (String page){
			String searchPage = (page == null ? PagePrefix : page);
			Source		.AdministratorNavigator()
						.clickPages()
						.DataTable()
						.setSearch(searchPage)
						.clickFirstRow()
						.clickEdit()
						.PagesPage()
						.clickLockForUseToggle()
						.clickYes()
						.PagesPage()
						.clickSubmit()
						.clickPopupOk();

			return this;
		}
		
		public PagesPage lockPage (String page){
			String searchPage = (page == null ? PagePrefix : page);
			Source		.AdministratorNavigator()
						.clickPages()
						.DataTable()
						.setSearch(searchPage)
						.clickFirstRow()
						.clickEdit()
						.PagesPage()
						.clickLockForUseToggle()
						.clickYes();
			return this;
		}
		
		public PagesPage endDatePageAndSubmit(String page, String endDate) {
			String searchPage = (page == null ? PagePrefix : page);
			Source
				.AdministratorNavigator()
				.clickPages()
				.GetSource()
				.DataTable()
				.setSearch(searchPage)
				.clickFirstRow()
				.clickEdit()
				.PagesPage()
				.setEndDate(endDate == null ? Today : endDate)
				.GetSource()
				.PagesPage()
				.clickSubmitExit()
				.GetSource()
				.SeleniumHelper()
				.sleep(5);
			return this;
		}
		
		public PagesPage endDatePage(String page, String endDate) {
			String searchPage = (page == null ? PagePrefix : page);
			Source
				.AdministratorNavigator()
				.clickPages()
				.GetSource()
				.DataTable()
				.setSearch(searchPage)
				.clickFirstRow()
				.clickEdit()
				.PagesPage()
				.setEndDate(endDate == null ? Today : endDate);
			return this;
		}
		
		public PagesPage addCompletePage(boolean lockPage)
		{
			int Random8 = SeleniumHelper.generateRandomNumber(8);
			String PageName= "TC_Pages_Selenium " + Random8;
			String SectionName= "TC_Section_Selenium " + Random8;
			String RowName= "TC_Row_Selenium " + Random8;
			String QuestionLabel= "TC_Question_Selenium " + Random8;
			
			Source .PagesPage()
					.addPage(PageName, Today, null, false, null)
					.GetSource()
					.SectionsAvailableAccord()
					.addSection(SectionName, 1, null, true, true, true)
					.GetSource()
					.RowsAvailableAccord().addRow(RowName, 1, null, true, true, true)
					.GetSource()
					.QuestionsAvailableAccord()
					.addQuestion(QuestionLabel, QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, true, false)
					.GetSource()
					.RolesAvailableAccord()
					.addRole(Today, null, Roles.ALLAPPS.getName(), true, EmptyString)
					.GetSource()
					.QuestionsAvailableAccord()
					.clickSubmitExit()
					.clickPopupOk();
			
			if(lockPage)
				lockPage(PagePrefix);
			
			return this;
		}
		
		public HashMap<String, String> addCompletePageGetNames(boolean lockPage)
		{
			int Random8 = SeleniumHelper.generateRandomNumber(8);
			String PageName= "TC_Pages_Selenium " + Random8;
			String SectionName= "TC_Section_Selenium " + Random8;
			String RowName= "TC_Row_Selenium " + Random8;
			String QuestionLabel= "TC_Question_Selenium " + Random8;
			
			HashMap<String, String> names = new HashMap<String, String>();
			names.put("PageName", PageName);
			names.put("SectionName", SectionName);
			names.put("RowName", RowName);
			names.put("QuestionLabel", QuestionLabel);
			Source .PagesPage()
					.addPage(names.get("PageName"), Today, null, false, null)
					.GetSource()
					.SectionsAvailableAccord()
					.addSection(names.get("SectionName"), 1, null, true, true, true)
					.GetSource()
					.RowsAvailableAccord().addRow(names.get("RowName"), 1, null, true, true, true)
					.GetSource()
					.QuestionsAvailableAccord()
					.addQuestion(names.get("QuestionLabel"), QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, true, false)
					.GetSource()
					.RolesAvailableAccord()
					.addRole(Today, null, Roles.ALLAPPS.getName(), true, EmptyString)
					.GetSource()
					.QuestionsAvailableAccord()
					.clickSubmitExit()
					.clickPopupOk();
			
			if(lockPage)
				lockPage(PagePrefix);
			
			return names;
		}
		
		public PagesPage addCompletePage(String pageName, String pageStartDate, String pageEndDate, String pageDescription, Boolean lockPage,
				String sectionName, int sectionSortOrder, String sectionDescription, Boolean sectionShowDescription, Boolean sectionShowName,
				Boolean sectionActive, String rowName, int rowSortOrder, String rownDescription, Boolean rowShowDescription, Boolean rowShowName,
				Boolean rowActive, String questionLabel, int questionType, int questionSortOrder, LinkedList<String> questionValues, String relateToQuestion, 
				LinkedList<String> relateToAnswer, boolean questionActive, boolean questionRequired, String roleStartDate, String roleEndDate, String roleName,
				Boolean roleEdit, String roleDescription)
		{
			Source .PagesPage()
					.addPage(pageName, pageStartDate, pageEndDate, false, pageDescription)
					.GetSource()
					.SectionsAvailableAccord()
					.addSection(sectionName, sectionSortOrder, sectionDescription, sectionShowDescription, sectionShowName, sectionActive)
					.GetSource()
					.RowsAvailableAccord().addRow(rowName, rowSortOrder, rownDescription, rowShowDescription, rowShowName, rowActive)
					.GetSource()
					.QuestionsAvailableAccord()
					.addQuestion(questionLabel, questionType, questionSortOrder, questionValues, relateToQuestion, relateToAnswer, questionActive, questionRequired)
					.GetSource()
					.RolesAvailableAccord()
					.addRole(roleStartDate, roleEndDate, roleName, roleEdit, roleDescription)
					.GetSource()
					.QuestionsAvailableAccord()
					.clickSubmitExit()
					.clickPopupOk();
			
			if(lockPage)
				lockPageAndSubmit(PagePrefix);
			
			return this;
		}

		public String isTriggeredExist() {
			return Boolean.toString(
					Source	.SeleniumHelper()
							.clickElement(TriggerRelatedQuestions)
							.checkWebElementExists(TriggerRelatedQuestions, 1));
		}

		public String isQuestionDisabled() {
			return Source	.SeleniumHelper()
							.getAttribute( Source.SeleniumHelper().getWebElement(RenderTypeQuestion), Disabled);
		}
		
}
