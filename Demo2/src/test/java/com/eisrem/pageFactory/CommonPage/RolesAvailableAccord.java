package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.Roles;
import com.eisrem.pageFactory.Admin.NavigationMenuBar;
import com.eisrem.pageFactory.Administrator.PagesPage;
import com.eisrem.pageFactory.Administrator.TypesPage;
import com.eisrem.pageFactory.Organization.UserInfoAccord;

public class RolesAvailableAccord extends DataTable{


	public RolesAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='SectionsAccordion_RolesAvailable_heading'] | //a[contains(text(),'Roles Available:')]")
	public WebElement RolesAvaiableAccord;
			
	@FindBy(xpath="//div[@id= 'rolesTable_length']//label")
	public WebElement ShowEntries;

	@FindBy(xpath="//select[@aria-controls='rolesTable'] | //select[@aria-controls='role-picker-table'] | //a[@aria-controls='ques-roles-table']")
	public WebElement ShowEntriesDropdown;
	
	@FindBy(xpath="//div[@id='rolesTable_info']")
	public WebElement ShowNoOfEntries;	
	
	@FindBy(xpath="//a[@aria-controls='role-picker-table']//span[contains(text(),'Add')] | //a[@aria-controls='rolesTable']//span[contains(text(),'Add')] | //a[@aria-controls='ques-roles-table']//span[contains(text(),'Add')]")
	public WebElement AddButton;
		
	@FindBy(xpath="//a[@aria-controls='role-picker-table']//span[contains(text(),'Edit')] | //a[@aria-controls='rolesTable']//span[contains(text(),'Edit')] | //a[@aria-controls='ques-roles-table']//span[contains(text(),'Edit')]")
	public WebElement EditButton;
	
	@FindBy(xpath="//a[@aria-controls='role-picker-table']//span[contains(text(),'View')] | //a[@aria-controls='rolesTable']//span[contains(text(),'View')] | //a[@aria-controls='ques-roles-table']//span[contains(text(),'View')]")
	public WebElement ViewButton;
	
	@FindBy(xpath="//a[@aria-controls='role-picker-table']//span[contains(text(),'Excel')] | //a[@aria-controls='rolesTable']//span[contains(text(),'Excel')] | //a[@aria-controls='ques-roles-table']//span[contains(text(),'Excel')]")
	public WebElement ExcelButton;
	
	@FindBy(xpath="//div[@id='rolesTable_filter'] //label")
	public WebElement SearchTitle;

	@FindBy(xpath="//input[@aria-controls='rolesTable'] | //input[@aria-controls='role-picker-table']")
	public WebElement SearchTextBox;
	
	@FindBy(xpath="//table[contains(@id,'rolesTable')]//tbody//tr[@role='row'][1] | //table[contains(@id,'role-picker-table')]//tbody//tr[@role='row'][1]")
	public WebElement RolesAvailableFirstRow;
	
	@FindBy(xpath="//table[contains(@id,'ques-roles-table')]//tbody//tr[@role='row'][1]")
	public WebElement QuestionFirstRow;
		
	@FindBy(xpath="//th[@aria-controls='rolesTable'] [text()='Id']")
	public WebElement IdList;
	
	@FindBy(xpath="//table[@id='rolesTable']//thead/tr[1]/th[1]/img[1]")
	public WebElement IdSection;
	
	@FindBy(xpath="//th[@aria-controls='rolesTable'] [text()='Name/Type']")
	public WebElement NameTypeList;
	
	@FindBy(xpath="//table[@id='rolesTable']//thead/tr[1]/th[2]/img[1]")
	public WebElement NameTypeSection;
	
	@FindBy(xpath="//th[@aria-controls='rolesTable'] [text()='Start Date']")
	public WebElement StartDateList;
	
	@FindBy(xpath="//table[@id='rolesTable']//thead/tr[1]/th[3]/img[1]")
	public WebElement StartDateSection;
	
	@FindBy(xpath="//th[@aria-controls='rolesTable'] [text()='End Date']")
	public WebElement EndDateList;
	
	@FindBy(xpath="//table[@id='rolesTable']//thead/tr[1]/th[4]/img[1]")
	public WebElement EndDateSection;
	
	@FindBy(xpath="//th[@aria-controls='rolesTable'] [text()='Modified Date']")
	public WebElement ModifiedDateList;
	
	@FindBy(xpath="//table[@id='rolesTable']//thead/tr[1]/th[5]/img[1]")
	public WebElement ModifiedDateSection;
	
	@FindBy(xpath="//table[@id='role-picker-table']//tbody//tr[1]//td[4]")
	public WebElement FirstRowEndDate;
	
	@FindBy(xpath="//a[@id='rolesTable_previous']")
	public WebElement PreviousBtn;

	@FindBy(xpath="//a[@id='rolesTable_next']")
	public WebElement NextBtn;
	
	@FindBy(xpath="//label[contains(@for,'startdate')]")
	public WebElement StartDateTitle;
	
	@FindBy(xpath="//input[contains(@id,'startdate')]")
	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//input[contains(@id,'startdate')]/..//span")
	public WebElement StartDateIcon;
	
	@FindBy(xpath="//label[contains(@for,'enddate')]")
	public WebElement EndDateTitle;
	
	@FindBy(xpath="//input[contains(@id,'enddate')]")
	public WebElement EndDateTextBox;
	
	@FindBy(xpath="//label[@for='role'] | //label[@for='quesRole']")
	public WebElement RoleTitle;
	
	@FindBy(xpath="//select[@id='role'] | //select[@id='quesRole']")
	public WebElement RoleDropDown;
	
	@FindBy(xpath="//label[@for = 'role-active']")
	public WebElement ActiveBtnTitle;

	@FindBy(xpath="//label[@for = 'role-active']/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement ActiveToggle;

	@FindBy(xpath="//label[@for = 'role-active']/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement ActiveToggleAttribute;
	
	@FindBy(xpath="//label[contains(text(),'Add')]")
	public WebElement AddToggleTitle;
	
	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6'][2]//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement AddToggle;
	
	@FindBy(xpath="//input[@id='role-add']")
	public WebElement AddFlag;
	
	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6'][2]//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement AddToggleAttribute;
	
	@FindBy(xpath="//label[contains(text(),'Edit')]")
	public WebElement EditToggleTitle;
	
	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6'][3]//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement EditToggle;
	
	@FindBy(xpath="//input[@id='quesRole-update'] | //input[@id='role-edit'] | //input[@id='role-update']")
	public WebElement EditFlag;
	
	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6'][3]//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement EditToggleAttribute;
	
	@FindBy(xpath="//label[contains(text(),'View')]")
	public WebElement ViewToggleTitle;
	
	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6'][4]//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement ViewToggle;
	
	@FindBy(xpath="//input[@id='role-view'] | //input[@id='role-read']")
	public WebElement ViewFlag;
	
	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6'][4]//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement ViewToggleAttribute;
	
	@FindBy(xpath="//label[@for='role-desc'] | //label[@for='quesRole-desc']")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[@id='role-desc'] | //textarea[@id='quesRole-desc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//button[@onclick='completeRole()'] | //button[@onclick='completeQuestionRole()'] | //button[@onclick='updateAdministratorMessageRole()']")
	public WebElement CompleteBtn;
	
	@FindBy(xpath="//button[@onclick='cancelRole()'] | //button[@onclick='cancelQuestionRole()']")
	public WebElement CancelBtn;
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody/tr/td[6]")
	public WebElement FirstCalenderBox;

	@FindBy(xpath="//div[@class='form-group col-md-4 col-sm-6 required ']/div/div")
	public WebElement UserStartDateTextBoxTEMP;
	
	public RolesAvailableAccord clickRolesAvaiableAccord() {
		Source.SeleniumHelper().clickElement(RolesAvaiableAccord);
		return new RolesAvailableAccord(DriverFactory.getDriver());
	}
	
	public String readShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(ShowEntries);
	}
	
	public String readSearchTitle() {
		return Source.SeleniumHelper().readElement(SearchTitle);
	}
	
	public RolesAvailableAccord setSearch(String value, String... Clear) {
		Source.SeleniumHelper().setText(SearchTextBox, value, Clear);
		return this;
	}
			
	public RolesAvailableAccord selectShowEntries(int index) {
		Source.SeleniumHelper().select(ShowEntriesDropdown, index);
		return this;
	}
		
	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}

	public RolesAvailableAccord clickRolesAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return this;
	}
	
	public String readEditBtn() {
		return Source.SeleniumHelper().readElement(EditButton);
	}

	public RolesAvailableAccord clickRolesEdit() {
		Source.SeleniumHelper().clickElement(EditButton);
		return this;
	}
	
	public String readViewBtn() {
		return Source.SeleniumHelper().readElement(ViewButton);
	}

	public RolesAvailableAccord clickRolesView() {
		Source.SeleniumHelper().clickElement(ViewButton);
		return this;
	}
	
	public String readExcelBtn() {
		return Source.SeleniumHelper().readElement(ExcelButton);
	}
	
	public String readActiveTitle() {
		return Source.SeleniumHelper().readElement(ActiveBtnTitle);
	}

	public RolesAvailableAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}

	public String readActiveToggle() {
		return ActiveToggleAttribute.getAttribute("last-val");
	}

	public RolesAvailableAccord clickActiveToggle(String value) {
		String active = readActiveToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickActiveToggle();
		}
		return this;
	}

	public RolesAvailableAccord clickRolesExcel() {
		Source.SeleniumHelper().clickElement(ExcelButton);
		return this;
	}
	
	public RolesAvailableAccord clickRolesFirstRow() {
		Source.SeleniumHelper().clickElement(RolesAvailableFirstRow);
		return this;
	}
	
	public RolesAvailableAccord clickQuestionRolesFirstRow() {
		Source.SeleniumHelper().clickElement(QuestionFirstRow);
		return this;
	}
		
	public RolesAvailableAccord clickIdSort() {
		Source.SeleniumHelper().clickElement(IdList);
		return this;
	}
	
	public String readIdList() {
		return Source.SeleniumHelper().readElement(IdList);
	}
	
	public RolesAvailableAccord clickNameType() {
		Source.SeleniumHelper().clickElement(NameTypeList);
		return this;
	}
	
	public String readNameTypeList() {
		return Source.SeleniumHelper().readElement(NameTypeList);
	}
	
	public RolesAvailableAccord clickStartDateSort() {
		Source.SeleniumHelper().clickElement(StartDateList);
		return this;
	}
	
	public String readStartDateList() {
		return Source.SeleniumHelper().readElement(StartDateList);
	}
	
	public RolesAvailableAccord clickEndDateSort() {
		Source.SeleniumHelper().clickElement(EndDateList);
		return this;
	}
	
	public String readEndDateList() {
		return Source.SeleniumHelper().readElement(EndDateList);
	}
	
	public RolesAvailableAccord clickModifiedDateSort() {
		Source.SeleniumHelper().clickElement(ModifiedDateList);
		return this;
	}
	
	public String readModifiedDateList() {
		return Source.SeleniumHelper().readElement(ModifiedDateList);
	}
	
	public String readFirstRowEndDate() {
		return Source.SeleniumHelper().readElement(FirstRowEndDate);
	}
	
	public RolesAvailableAccord clickPrevious() {
		Source.SeleniumHelper().clickElement(PreviousBtn);
		return this;
	}
	
	public String readPreviousBtn() {
		return Source.SeleniumHelper().readElement(PreviousBtn);
	}
	
	public RolesAvailableAccord clickNext() {
		Source.SeleniumHelper().clickElement(NextBtn);
		return this;
	}
	
	public String readNextBtn() {
		return Source.SeleniumHelper().readElement(NextBtn);
	}
	
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}
	
	public RolesAvailableAccord setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public RolesAvailableAccord clickStartDateIcon() {
		Source.SeleniumHelper().clickElement(StartDateIcon);
		return this;
	}

	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}
	
	public RolesAvailableAccord setEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(EndDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public RolesAvailableAccord setStartDateTEMP() {
		Source.SeleniumHelper().clickElement(UserStartDateTextBoxTEMP).clickElement(FirstCalenderBox);
		return this;
	}
	
	public String readRoleTitle() {
		return Source.SeleniumHelper().readElement(RoleTitle);
	}
	
	public RolesAvailableAccord selectRole(int index) {
		Source.SeleniumHelper().select(RoleDropDown, index);
		return this;
	}
	
	public RolesAvailableAccord selectRole(String type) {
		Source.SeleniumHelper().select(RoleDropDown, type);
		return this;
	}
	
	public String readAddToggleTitle() {
		return Source.SeleniumHelper().readElement(AddToggleTitle);
	}
	
	public String readAddToggleAttribute() {
		return	AddToggleAttribute.getAttribute("last-val");
	}
	
	public RolesAvailableAccord clickAddToggle() {
		Source.SeleniumHelper().clickElement(AddToggle);
		return this;
	}
	
	public String readEditToggleTitle() {
		return Source.SeleniumHelper().readElement(EditToggleTitle);
	}
	
	public String readEditToggleAttribute() {
		return	EditToggleAttribute.getAttribute("last-val");
	}
	
	public RolesAvailableAccord clickEditToggle() {
		Source.SeleniumHelper().clickElement(EditToggle);
		return this;
	}
	
	public RolesAvailableAccord clickEditToggle(String value) {
		String active = readEditToggleAttribute();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickEditToggle();
		}
		return this;
	}
	
	public String readViewToggleTitle() {
		return Source.SeleniumHelper().readElement(ViewToggleTitle);
	}
	
	public String readViewToggleAttribute() {
		return	ViewToggleAttribute.getAttribute("last-val");
	}
	
	public RolesAvailableAccord clickViewToggle() {
		Source.SeleniumHelper().clickElement(ViewToggle);
		return this;
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public RolesAvailableAccord setDescription(String value, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, value, Clear);
		return this;
	}
	
	public ObjectSource clickRolesComplete() {
		Source.SeleniumHelper().clickElement(CompleteBtn);
		return new ObjectSource();
	}
	
	public RolesAvailableAccord clickRolesCancel() {
		Source.SeleniumHelper().clickElement(CancelBtn);
		return this;
	}

	public RolesAvailableAccord clickRolesRow(int row) {
		Source.DataTable().clickRow("role-picker-table", row);
		return this;
	}
	
	public RolesAvailableAccord toggleAdd(boolean add) {
		if((add && AddFlag.getAttribute("last-val").equals("false"))
				|| (!add && AddFlag.getAttribute("last-val").equals("true")))
			clickAddToggle();
		return this;
	}
	
	public RolesAvailableAccord toggleEdit(boolean edit) {
		if((edit && EditFlag.getAttribute("last-val").equals("false"))
				|| (!edit && EditFlag.getAttribute("last-val").equals("true")))
			clickEditToggle();
		return this;
	}
	
	public RolesAvailableAccord toggleView(boolean view) {
		if((view && ViewFlag.getAttribute("last-val").equals("false"))
				|| (!view && ViewFlag.getAttribute("last-val").equals("true")))
			clickViewToggle();
		return this;
	}
	
	public RolesAvailableAccord addQARoleAndSubmit(String page, String section, String row, String question, String startDate, String endDate, 
			String roleName, boolean edit, String description) {
		SeleniumHelper.log.info("Adding QA Role and submitting page");
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
		String searchRow = (page == null ? RowPrefix : row);
		String searchQuestion = (page == null ? QuestionPrefix : question);
		Source   	.NavigationMenuBar()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.GetSource()
					.DataTable()
					.setSearch(searchSection)
					.clickFirstRow()
					.clickEdit()
					.RowsAvailableAccord()
					.setSearch(searchRow)
					.clickRowFirstRow()
					.clickRowEdit()
					.GetSource()
					.QuestionsAvailableAccord()
					.setSearch(searchQuestion)
					.clickQAFirstRow()
					.clickQAEdit()
					.GetSource()
					.RolesAvailableAccord()
					.clickRolesAdd()
					//.setStartDate(startDate == null ? Today : startDate)
					.setEndDate(endDate == null ? EmptyString : endDate)
					.setDescription(description == null ? EmptyString : description)
					.GetSource()
					.RolesAvailableAccord()
					.selectRole(roleName);
					
		toggleEdit(edit);
		
		Source   	.RolesAvailableAccord()
					.clickRolesComplete()
					.QuestionsAvailableAccord()
					.clickSubmitExit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return this;
	}
	
	public RolesAvailableAccord addRole(String startDate, String endDate, String roleName, boolean edit, String description) {	
		SeleniumHelper.log.info("Adding Role");
		Source   	.RolesAvailableAccord()
					.clickRolesAdd()
					//.setStartDate(startDate == null ? Today : startDate)
					.setEndDate(endDate == null ? EmptyString : endDate)
					.setDescription(description == null ? EmptyString : description)
					.GetSource()
					.RolesAvailableAccord()
					.selectRole(roleName);
		
		toggleEdit(edit);
		
		Source   	.RolesAvailableAccord()
					.clickRolesComplete();
		return this;
	}
	
	public RolesAvailableAccord addRoleAndSubmit(String startDate, String endDate, String roleName, 
			boolean edit, boolean add, boolean view, String description) {
		SeleniumHelper.log.info("Adding Role");
		Source   	.RolesAvailableAccord()
					.clickRolesAdd()
					.selectRole(roleName)
					//.setStartDate(startDate == null ? Today : startDate)
					.setEndDate(endDate == null ? EmptyString : endDate)
					.setDescription(description == null ? EmptyString : description);
		
		toggleAdd(add);
		toggleEdit(edit);
		toggleView(view);
		
		Source		.RolesAvailableAccord()
					.clickRolesComplete()
					.QuestionsAvailableAccord()
					.clickSubmitExit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return this;
	}
	
	public RolesAvailableAccord addRole(String startDate, String endDate, String roleName, 
			boolean edit, boolean add, boolean view, String description) {
		SeleniumHelper.log.info("Adding Role");
		Source   	.RolesAvailableAccord()
					.clickRolesAdd()
					.selectRole(roleName)
					//.setStartDate(startDate == null ? Today : startDate)
					.setEndDate(endDate == null ? EmptyString : endDate)
					.setDescription(description == null ? EmptyString : description);
		
		toggleAdd(add);
		toggleEdit(edit);
		toggleView(view);
		
		Source		.RolesAvailableAccord()
					.clickRolesComplete();
		return this;
	}
	
	public RolesAvailableAccord addRole(String startDate, String endDate, String roleName, String description) {
		SeleniumHelper.log.info("Adding Role");
		Source   	.RolesAvailableAccord()
					.clickRolesAdd()
					.setStartDate(startDate == null ? Today : startDate, Clear)
					.setEndDate(endDate == null ? EmptyString : endDate, Clear)
					.GetSource()
					.RolesAvailableAccord()
					.selectRole(roleName)
					.setDescription(description == null ? EmptyString : description);
		
		Source		.RolesAvailableAccord()
					.clickRolesComplete();
		return this;
	}
	
	public RolesAvailableAccord addQARoleAndSubmit(String page, String section, String row, String question) {
		SeleniumHelper.log.info("Adding QA Role, submitting page and returning names");
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
		String searchRow = (page == null ? RowPrefix : row);
		String searchQuestion = (page == null ? QuestionPrefix : question);
		Source   	.NavigationMenuBar()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.GetSource()
					.DataTable()
					.setSearch(searchSection)
					.clickFirstRow()
					.clickEdit()
					.RowsAvailableAccord()
					.setSearch(searchRow)
					.clickRowFirstRow()
					.clickRowEdit()
					.GetSource()
					.QuestionsAvailableAccord()
					.setSearch(searchQuestion)
					.clickQAFirstRow()
					.clickQAEdit()
					.GetSource()
					.RolesAvailableAccord()
					.clickRolesAdd()
					.selectRole(Roles.ALLAPPS.getName())
					.clickRolesComplete()
					.QuestionsAvailableAccord()
					.clickSubmitExit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return this;
	}
	
	public RolesAvailableAccord addRole() {
		SeleniumHelper.log.info("Adding Role");
		Source   	.RolesAvailableAccord()
					.clickRolesAdd()
					.selectRole(Roles.ALLAPPS.getName())
					.clickRolesComplete();
		return this;
	}
	
	public RolesAvailableAccord addRole(String roleName, String description, String roleActive) {
		SeleniumHelper.log.info("Adding Role");
		Source   	.RolesAvailableAccord()
					.clickRolesAdd()
					.GetSource()
					.RolesAvailableAccord()
					.selectRole(roleName)
					.setDescription(description == null ? EmptyString : description)
					.clickActiveToggle(roleActive)
					.clickRolesComplete()
					.Pagefactory()
					.clickPopupOk();
		return this;
	}
}
