package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.Admin.NavigationMenuBar;
import com.eisrem.pageFactory.Administrator.PagesPage;

public class RowsAvailableAccord extends DataTable{


	public RowsAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(xpath="//div[@id= 'row_table_length']//label")
	public WebElement ShowEntries;

	@FindBy(xpath="//select[@aria-controls='row_table']")
	public WebElement ShowEntriesDropdown;
	
	@FindBy(xpath="//div[@id='row_table_info']")
	public WebElement ShowNoOfEntries;	

	@FindBy(xpath="//table[@id='row_table']//tbody//tr[@role='row'][1]")
	public WebElement FirstRow;
	
	@FindBy(xpath="//a[@aria-controls='row_table']//span[contains(text(),'Add')]")
	public WebElement AddButton;
		
	@FindBy(xpath="//a[@aria-controls='row_table']//span[contains(text(),'Edit')]")
	public WebElement EditButton;
	
	@FindBy(xpath="//a[@aria-controls='row_table']//span[contains(text(),'View')]")
	public WebElement ViewButton;
	
	@FindBy(xpath="//a[@aria-controls='row_table']//span[contains(text(),'Excel')]")
	public WebElement ExcelButton;
	
	@FindBy(xpath="//div[@id='row_table_filter'] //label")
	public WebElement SearchTitle;

	@FindBy(xpath="//input[@aria-controls='row_table']")
	public WebElement SearchTextBox;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Id']")
	public WebElement IdList;
	
	@FindBy(xpath="//table[@id='row_table']//thead/tr[1]/th[1]/img[1]")
	public WebElement IdSection;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Name']")
	public WebElement NameTypeList;
	
	@FindBy(xpath="//table[@id='row_table']//thead/tr[1]/th[2]/img[1]")
	public WebElement NameTypeSection;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Start Today']")
	public WebElement StartDateList;
	
	@FindBy(xpath="//table[@id='row_table']//thead/tr[1]/th[3]/img[1]")
	public WebElement StartDateSection;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='End Today']")
	public WebElement EndDateList;
	
	@FindBy(xpath="//table[@id='row_table']//thead/tr[1]/th[4]/img[1]")
	public WebElement EndDateSection;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Modified Today']")
	public WebElement ModifiedDateList;
	
	@FindBy(xpath="//table[@id='row_table']//thead/tr[1]/th[5]/img[1]")
	public WebElement ModifiedDateSection;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Active']")
	public WebElement ActiveList;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Active']/img[1]")
	public WebElement ActiveSort;
	
	@FindBy(xpath="(//th[contains(text(),'Sort Order')])[2]")
	public WebElement SortOrderList;
	
	@FindBy(xpath="//th[@aria-controls='row_table'] [text()='Sort Order']/img[1]")
	public WebElement SortOrderSort;
	
	@FindBy(xpath="//a[@id='row_table_previous']")
	public WebElement PreviousBtn;

	@FindBy(xpath="//a[@id='row_table_next']")
	public WebElement NextBtn;
	
	@FindBy(xpath="//iframe[@id='rowName_ifr']")
	public WebElement RowNameIFrame;
	
	@FindBy(xpath="//*[@data-id='rowName']/p")
	public WebElement RowNameTextBox;
	
	@FindBy(xpath="//input[@id='rowName']")
	public WebElement RowNameTextBoxNF;

	@FindBy(xpath="//input[@id='rowSortOrder']")
	public WebElement SortOrderTextBox;

	@FindBy(xpath="//textarea[@id='rowDesc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//iframe[@id='rowInstruction_ifr']")
	public WebElement RowInstructionIFrame;
	
	@FindBy(xpath="//*[@data-id='rowInstruction']/p")
	public WebElement RowInstructionTextBox;

	@FindBy(xpath="//div[@id='row-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-row_descFlag')]")
	public WebElement ShowDescriptionToggle;
	
	@FindBy(xpath="//div[@id='row-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-row_descFlag')]")
	public WebElement ShowDescriptionToggleAttribute;
	
	@FindBy(xpath="//input[@id='row_descFlag']")
	public WebElement ShowDescriptionFlag;

	@FindBy(xpath="//div[@id='row-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-row_nameFlag')]")
	public WebElement ShowNameToggle;
	
	@FindBy(xpath="//input[@id='row_nameFlag']")
	public WebElement ShowNameFlag;

	@FindBy(xpath="//div[@id='row-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-row_activeFlag')]")
	public WebElement ActiveToggle;
	
	@FindBy(xpath="//input[@id='row_activeFlag']")
	public WebElement ActiveFlag;
	
	@FindBy(xpath="//div[@id='row-tab-pane']//button[text()='Back']")
	public WebElement BackBtn;
	
	@FindBy(xpath="//div[@id='row-tab-pane']//button[text()='Save']")
	public WebElement SaveBtn;

	@FindBy(xpath="//div[@id='row-tab-pane']//button[text()='Settings']")
	public WebElement SettingsBtn;
	
	@FindBy(xpath="//div[@id='row-tab-pane']//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;
	
	public SectionsAvailableAccord clickRowSave() {
		Source.SeleniumHelper().clickElement(SaveBtn);
		return Source.SectionsAvailableAccord();
	}
	
	public SectionsAvailableAccord clickRowBack() {
		Source.SeleniumHelper().clickElement(BackBtn);
		return Source.SectionsAvailableAccord();
	}
	
	public ObjectSource clickRowSettings() {
		Source.SeleniumHelper().clickElement(SettingsBtn);
		return new ObjectSource();
	}
	
	public String readShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(ShowEntries);
	}
	
	public String readSearchTitle() {
		return Source.SeleniumHelper().readElement(SearchTitle);
	}
	
	public RowsAvailableAccord setSearch(String value, String... clear) {
		Source.SeleniumHelper().setText(SearchTextBox, value, clear);
		return this;
	}
			
	public RowsAvailableAccord selectShowEntries(int index) {
		Source.SeleniumHelper().select(ShowEntriesDropdown, index);
		return this;
	}
	
	public RowsAvailableAccord clickRowFirstRow() {
		Source.SeleniumHelper().clickElement(FirstRow);
		return this;
	}
			
	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}

	public RowsAvailableAccord clickRowAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return this;
	}
	
	public String readEditBtn() {
		return Source.SeleniumHelper().readElement(EditButton);
	}

	public RowsAvailableAccord clickRowEdit() {
		Source.SeleniumHelper().clickElement(EditButton);
		return this;
	}
	
	public String readViewButton() {
		return Source.SeleniumHelper().readElement(ViewButton);
	}

	public RowsAvailableAccord clickRowView() {
		Source.SeleniumHelper().clickElement(ViewButton);
		return this;
	}
	
	public String readExcelBtn() {
		return Source.SeleniumHelper().readElement(ExcelButton);
	}

	public RowsAvailableAccord clickRowExcel() {
		Source.SeleniumHelper().clickElement(ExcelButton);
		return this;
	}
	
	public String readSortOrderList() {
		return Source.SeleniumHelper().readElement(SortOrderList);
	}
		
	public RowsAvailableAccord clickIdSort() {
		Source.SeleniumHelper().clickElement(IdList);
		return this;
	}
	
	public String readIdList() {
		return Source.SeleniumHelper().readElement(IdList);
	}
	
	public RowsAvailableAccord clickNameType() {
		Source.SeleniumHelper().clickElement(NameTypeList);
		return this;
	}
	
	public String readNameTypeList() {
		return Source.SeleniumHelper().readElement(NameTypeList);
	}
	
	public RowsAvailableAccord clickStartDateSort() {
		Source.SeleniumHelper().clickElement(StartDateList);
		return this;
	}
	
	public String readStartDateList() {
		return Source.SeleniumHelper().readElement(StartDateList);
	}
	
	public RowsAvailableAccord clickEndDateSort() {
		Source.SeleniumHelper().clickElement(EndDateList);
		return this;
	}
	
	public String readEndDateList() {
		return Source.SeleniumHelper().readElement(EndDateList);
	}
	
	public RowsAvailableAccord clickModifiedDateSort() {
		Source.SeleniumHelper().clickElement(ModifiedDateList);
		return this;
	}
	
	public String readModifiedDateList() {
		return Source.SeleniumHelper().readElement(ModifiedDateList);
	}
	
	public RowsAvailableAccord clickPrevious() {
		Source.SeleniumHelper().clickElement(PreviousBtn);
		return this;
	}
	
	public String readPreviousBtn() {
		return Source.SeleniumHelper().readElement(PreviousBtn);
	}
	
	public RowsAvailableAccord clickNext() {
		Source.SeleniumHelper().clickElement(NextBtn);
		return this;
	}
	
	public String readNextBtn() {
		return Source.SeleniumHelper().readElement(NextBtn);
	}
	
	public RowsAvailableAccord setRowName(String RowName, String... Clear) {
		if(Configuration.Config.iFrame==true) {
			Source.SeleniumHelper().setText(RowNameIFrame, RowNameTextBox, RowName, Clear);
		}
		else {
			Source.SeleniumHelper().setText(RowNameTextBoxNF, RowName, Clear);
		}
		
		return this;
	}
	
	public RowsAvailableAccord setSortOrder(String SortOrder, String... clear) {
		Source.SeleniumHelper().setText(SortOrderTextBox, SortOrder, clear);
		return this;
	}
	
	public RowsAvailableAccord setDescription(String Description, String... clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, Description, clear);
		return this;
	}
	
	public RowsAvailableAccord setRowInstruction(String RowInstruction, String... clear) {
		Source.SeleniumHelper().setText(RowInstructionIFrame, RowInstructionTextBox, RowInstruction, Clear);
		return this;
	}
	
	public String readShowDescriptionToggle() {
		return ShowDescriptionToggleAttribute.getAttribute("last-val");
	}
	
	public RowsAvailableAccord clickShowDescriptionToggle() {
		Source.SeleniumHelper().clickElement(ShowDescriptionToggle);
		return this;
	}
	
	public RowsAvailableAccord clickShowDescriptionToggle(String value) {
		String active = readShowDescriptionToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickShowDescriptionToggle();
		}
		return this;
	}
	
	public RowsAvailableAccord clickShowNameToggle() {
		Source.SeleniumHelper().clickElement(ShowNameToggle);
		return this;
	}
	
	public RowsAvailableAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}
	
	public SectionsAvailableAccord clickRowsBack() {
		Source.SeleniumHelper().clickElement(BackBtn);
		return new SectionsAvailableAccord(DriverFactory.getDriver());
	}

	public RowsAvailableAccord clickRowSubmit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return new RowsAvailableAccord(DriverFactory.getDriver());
	}
	
	public PagesPage clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return new PagesPage(DriverFactory.getDriver());
	}
	
	public RowsAvailableAccord addRowAndSubmit(String page, String section, String name, int sortOrder, String description, boolean showDescription, 
			boolean showName, boolean active)
	{
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
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
					.clickRowAdd()
					.setRowName(name == null ? RowName : name)
					.setSortOrder(String.valueOf(sortOrder))
					.setDescription(description == null ? EmptyString : description);
					
					if((showDescription && ShowDescriptionFlag.getAttribute("last-val").equals("false"))
							|| (!showDescription && ShowDescriptionFlag.getAttribute("last-val").equals("true")))
						clickShowDescriptionToggle();
					
					if((showName && ShowNameFlag.getAttribute("last-val").equals("false"))
							|| (!showName && ShowNameFlag.getAttribute("last-val").equals("true")))
						clickShowNameToggle();
					
					if((active && ActiveFlag.getAttribute("last-val").equals("false"))
							|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
						clickActiveToggle();

					Source	.RowsAvailableAccord()
							.clickRowSubmit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5);
		return this;
	}
	
	public RowsAvailableAccord addRow(String name, int sortOrder, String description, boolean showDescription, 
			boolean showName, boolean active)
	{

		Source   	.RowsAvailableAccord()
					.clickRowAdd()
					.setRowName(name == null ? RowName : name)
					.setSortOrder(String.valueOf(sortOrder))
					.setDescription(description == null ? EmptyString : description);
					
					if((showDescription && ShowDescriptionFlag.getAttribute("last-val").equals("false"))
							|| (!showDescription && ShowDescriptionFlag.getAttribute("last-val").equals("true")))
						clickShowDescriptionToggle();
					
					if((showName && ShowNameFlag.getAttribute("last-val").equals("false"))
							|| (!showName && ShowNameFlag.getAttribute("last-val").equals("true")))
						clickShowNameToggle();
					
					if((active && ActiveFlag.getAttribute("last-val").equals("false"))
							|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
						clickActiveToggle();
		return this;
	}
	
	public RowsAvailableAccord addRowAndSubmit(String page, String section)
	{
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
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
					.clickRowAdd()
					.setRowName(RowName)
					.setSortOrder("1")
					.clickRowSubmit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return this;
	}
	
	public RowsAvailableAccord addRow()
	{
		String RowName= "TC_Row_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source   	.RowsAvailableAccord()
					.clickRowAdd()
					.setRowName(RowName)
					.setSortOrder("1");
		return this;
	}
	
	public String addRowGetNameAndSubmit(String page, String section)
	{
		String RowName= RowPrefix + SeleniumHelper.generateRandomNumber(8);
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
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
					.clickRowAdd()
					.setRowName(RowName)
					.setSortOrder("1")
					.clickSubmitExit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return RowName;
	}
	
	public String addRowGetName()
	{
		String RowName= "TC_Row_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source   	.RowsAvailableAccord()
					.clickRowAdd()
					.setRowName(RowName)
					.setSortOrder("1");
		return RowName;
	}

}
