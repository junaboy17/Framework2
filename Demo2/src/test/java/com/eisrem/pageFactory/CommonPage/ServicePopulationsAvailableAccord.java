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
import com.eisrem.pageFactory.Admin.NavigationMenuBar;
import com.eisrem.pageFactory.Administrator.AdministratorMessagesPage;

public class ServicePopulationsAvailableAccord extends AdministratorMessagesPage{


	public ServicePopulationsAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Service Population')]")
	public WebElement ServicePopulationsAvailableAccord;

	@FindBy(xpath="//div[@id= 'servicePopTable_length']//label")
	public WebElement ShowEntries;

	@FindBy(xpath="//select[@aria-controls='servicePopTable']")
	public WebElement ShowEntriesDropdown;
	
	@FindBy(xpath="//div[@id='servicePopTable_info']")
	public WebElement ShowNoOfEntries;	
	
	@FindBy(xpath="//a[@aria-controls='servicePopTable']//span[contains(text(),'Add')] | //a[@aria-controls='sp-picker-table']//span[contains(text(),'Add')]")
	public WebElement AddButton;
		
	@FindBy(xpath="//a[@aria-controls='servicePopTable']//span[contains(text(),'Edit')] | //a[@aria-controls='sp-picker-table']//span[contains(text(),'Edit')]")
	public WebElement EditButton;
	
	@FindBy(xpath="//a[@aria-controls='servicePopTable']//span[contains(text(),'View')] | //a[@aria-controls='sp-picker-table']//span[contains(text(),'View')]")
	public WebElement ViewButton;
	
	@FindBy(xpath="//a[@aria-controls='servicePopTable']//span[contains(text(),'Excel')] | //a[@aria-controls='sp-picker-table']//span[contains(text(),'Excel')]")
	public WebElement ExcelButton;
	
	@FindBy(xpath="//table[contains(@id,'sp-picker-table')]//tbody//tr[@role='row'][1]")
	public WebElement SPFirstRow;
	
	@FindBy(xpath="//div[@id='servicePopTable_filter'] //label")
	public WebElement SearchTitle;

	@FindBy(xpath="//input[@aria-controls='servicePopTable'] | //input[@aria-controls='sp-picker-table']")
	public WebElement SearchTextBox;
	
	@FindBy(xpath="//th[@aria-controls='servicePopTable'] [text()='Id']")
	public WebElement IdList;
	
	@FindBy(xpath="//table[@id='servicePopTable']//thead/tr[1]/th[1]/img[1]")
	public WebElement IdSection;
	
	@FindBy(xpath="//th[@aria-controls='servicePopTable'] [text()='Name/Type']")
	public WebElement NameTypeList;
	
	@FindBy(xpath="//table[@id='servicePopTable']//thead/tr[1]/th[2]/img[1]")
	public WebElement NameTypeSection;
		
	@FindBy(xpath="//th[@aria-controls='servicePopTable'] [text()='Start Date']")
	public WebElement StartDateList;
	
	@FindBy(xpath="//table[@id='servicePopTable']//thead/tr[1]/th[3]/img[1]")
	public WebElement StartDateSection;

	@FindBy(xpath="//th[@aria-controls='servicePopTable'] [text()='End Date']")
	public WebElement EndDateList;
	
	@FindBy(xpath="//table[@id='servicePopTable']//thead/tr[1]/th[4]/img[1]")
	public WebElement EndDateSection;
	
	@FindBy(xpath="//th[@aria-controls='servicePopTable'] [text()='Modified Date']")
	public WebElement ModifiedDateList;
	
	@FindBy(xpath="//table[@id='servicePopTable']//thead/tr[1]/th[5]/img[1]")
	public WebElement ModifiedDateSection;
		
	@FindBy(xpath="//a[@id='servicePopTable_previous']")
	public WebElement PreviousBtn;

	@FindBy(xpath="//a[@id='servicePopTable_next']")
	public WebElement NextBtn;
	
	@FindBy(xpath="//label[contains(@for,'sp-startdate')]")
	public WebElement StartDateTitle;
	
	@FindBy(xpath="//input[contains(@id,'startdate')]/..//span")
	public WebElement StartDateIcon;
	
	@FindBy(xpath="//input[contains(@id,'sp-startdate')]")
	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//label[contains(@for,'sp-enddate')]")
	public WebElement EndDateTitle;
	
	@FindBy(xpath="//input[contains(@id,'sp-enddate')]")
	public WebElement EndDateTextBox;
	
	@FindBy(xpath="//label[@for='sp']")
	public WebElement ServicePopulationTitle;
	
	@FindBy(xpath="//select[contains(@id,'sp')]")
	public WebElement ServicePopulationDropdown;
	
	@FindBy(xpath="//label[@for='sp-desc']")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[@id='sp-desc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//label[@for = 'sp-active']")
	public WebElement ActiveBtnTitle;

	@FindBy(xpath="//label[@for = 'sp-active']/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement ActiveToggle;

	@FindBy(xpath="//label[@for = 'sp-active']/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement ActiveToggleAttribute;

	@FindBy(xpath="//button[@onclick='updateAdministratorMessageServicePop()'] | //button[@onclick='completeSP()']")
	public WebElement SpCompleteBtn;
	
	@FindBy(xpath="//button[@onclick='cancelSP()']")
	public WebElement CancelBtn;
	
	public String readServicePopulationsAvailableAccordTitle() {
		return Source.SeleniumHelper().readElement(ServicePopulationsAvailableAccord);
	}
	
	public ServicePopulationsAvailableAccord clickServicePopulationAvailableAccord() {
		Source.SeleniumHelper().clickElement(ServicePopulationsAvailableAccord);
		return new ServicePopulationsAvailableAccord(DriverFactory.getDriver());
	}
	
	public String readShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(ShowEntries);
	}
	
	public ServicePopulationsAvailableAccord selectShowEntries(int index) {
		Source.SeleniumHelper().select(ShowEntriesDropdown, index);
		return this;
	}
	
	public String readSearchTitle() {
		return Source.SeleniumHelper().readElement(SearchTitle);
	}
	
	public ServicePopulationsAvailableAccord setSearch(String value, String... Clear) {
		Source.SeleniumHelper().setText(SearchTextBox, value, Clear);
		return this;
	}
		
	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}

	public ServicePopulationsAvailableAccord clickSpAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return this;
	}
	
	public String readEditBtn() {
		return Source.SeleniumHelper().readElement(EditButton);
	}

	public ServicePopulationsAvailableAccord clickSpEdit() {
		Source.SeleniumHelper().clickElement(EditButton);
		return this;
	}
	
	public String readExcelBtn() {
		return Source.SeleniumHelper().readElement(ExcelButton);
	}

	public ServicePopulationsAvailableAccord clickSpExcel() {
		Source.SeleniumHelper().clickElement(ExcelButton);
		return this;
	}
	
	public ServicePopulationsAvailableAccord clickSPFirstRow() {
		Source.SeleniumHelper().clickElement(SPFirstRow);
		return this;
	}
		
	public ServicePopulationsAvailableAccord clickIdSort() {
		Source.SeleniumHelper().clickElement(IdList);
		return this;
	}
	
	public String readIdList() {
		return Source.SeleniumHelper().readElement(IdList);
	}
	
	public ServicePopulationsAvailableAccord clickNameType() {
		Source.SeleniumHelper().clickElement(NameTypeList);
		return this;
	}
	
	public String readNameTypeList() {
		return Source.SeleniumHelper().readElement(NameTypeList);
	}
	
	public ServicePopulationsAvailableAccord clickStartDateSort() {
		Source.SeleniumHelper().clickElement(StartDateList);
		return this;
	}
	
	public String readStartDateList() {
		return Source.SeleniumHelper().readElement(StartDateList);
	}
	
	public ServicePopulationsAvailableAccord clickEndDateSort() {
		Source.SeleniumHelper().clickElement(EndDateList);
		return this;
	}
	
	public String readEndDateList() {
		return Source.SeleniumHelper().readElement(EndDateList);
	}
	
	public ServicePopulationsAvailableAccord clickSPModifiedDate() {
		Source.SeleniumHelper().clickElement(ModifiedDateList);
		return this;
	}
	
	public String readModifiedDateList() {
		return Source.SeleniumHelper().readElement(ModifiedDateList);
	}
	
	public ServicePopulationsAvailableAccord clickPrevious() {
		Source.SeleniumHelper().clickElement(PreviousBtn);
		return this;
	}
	
	public String readPreviousBtn() {
		return Source.SeleniumHelper().readElement(PreviousBtn);
	}
	
	public ServicePopulationsAvailableAccord clickNext() {
		Source.SeleniumHelper().clickElement(NextBtn);
		return this;
	}
	
	public String readNextBtn() {
		return Source.SeleniumHelper().readElement(NextBtn);
	}
	
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}
	
	public ServicePopulationsAvailableAccord clickStartDateIcon() {
		Source.SeleniumHelper().clickElement(StartDateIcon);
		return this;
	}
	
	public ServicePopulationsAvailableAccord setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, date + Keys.TAB, Clear);
		return this;
	}

	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}
	
	public String readEndDate() {
		return Source.SeleniumHelper().getWebElement(EndDateTextBox).getAttribute("value");
	}
	
	public ServicePopulationsAvailableAccord setEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(EndDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public String readServicePopulationTitle() {
		return Source.SeleniumHelper().readElement(ServicePopulationTitle);
	}
	
	public ServicePopulationsAvailableAccord selectServicePopulation(int index) {
		Source.SeleniumHelper().select(ServicePopulationDropdown, index);
		return this;
	}
	
	public ServicePopulationsAvailableAccord selectServicePopulation(String ServiceProvider) {
		Source.SeleniumHelper().select(ServicePopulationDropdown, ServiceProvider);
		return this;
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public String readDescriptionTextBoxValue() {
		return Source.SeleniumHelper().readElement(DescriptionTextBox);
	}
	
	public ServicePopulationsAvailableAccord setDescription(String value, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, value, Clear);
		return this;
	}
	
	public String readActiveTitle() {
		return Source.SeleniumHelper().readElement(ActiveBtnTitle);
	}

	public ServicePopulationsAvailableAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}

	public String readActiveToggle() {
		return ActiveToggleAttribute.getAttribute("last-val");
	}

	public ServicePopulationsAvailableAccord clickActiveToggle(String value) {
		String active = readActiveToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickActiveToggle();
		}
		return this;
	}

	public ObjectSource clickSpComplete() {
		Source.SeleniumHelper().clickElement(SpCompleteBtn);
		return new ObjectSource();
	}

	public ServicePopulationsAvailableAccord clickSpCancel() {
		Source.SeleniumHelper().clickElement(CancelBtn);
		return this;
	}

	public ServicePopulationsAvailableAccord clickSpRow(int row) {
		Source.DataTable().clickRow("sp-picker-table", row);
		return this;
	}
	
	public String readViewBtn() {
		return Source.SeleniumHelper().readElement(ViewButton);
	}

	public ServicePopulationsAvailableAccord clickSpView() {
		Source.SeleniumHelper().clickElement(ViewButton);
		return this;
	}
	
	public ServicePopulationsAvailableAccord addServicePopulation(String startDate, String endDate, String servicePopulationName, String description) {
		SeleniumHelper.log.info("Adding Service Population");
		Source   	.ServicePopulationsAvailableAccord()
					.clickSpAdd()
					.setStartDate(startDate == null ? Today : startDate, EmptyString)
					.setEndDate(endDate == null ? EmptyString : endDate, EmptyString)
					.setDescription(description == null ? EmptyString : description)
					.selectServicePopulation(servicePopulationName)
					.clickSpComplete();
		return this;
	}
	
	public ServicePopulationsAvailableAccord addServicePopulation( int servicePopulationName, String description, String SPActive) {
		SeleniumHelper.log.info("Adding Service Population");
		Source   	.ServicePopulationsAvailableAccord()
					.clickServicePopulationAvailableAccord()
					.clickSpAdd()
					.selectServicePopulation(servicePopulationName)
					.setDescription(description == null ? EmptyString : description)
					.clickActiveToggle(SPActive)
					.clickSpComplete()
					.Pagefactory()
					.clickPopupOk();
		return this;
	}
	
	public ServicePopulationsAvailableAccord addServicePopulation() {
		SeleniumHelper.log.info("Adding Service Population");
		Source   	.ServicePopulationsAvailableAccord()
					.clickSpAdd()
					.setStartDate(Today)
					.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
					.setDescription(Description)
					.clickSpComplete();
		return this;
	}
	
}
