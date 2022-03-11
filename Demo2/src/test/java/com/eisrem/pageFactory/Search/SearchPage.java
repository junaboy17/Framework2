package com.eisrem.pageFactory.Search;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class SearchPage extends DataTable{

	public SearchPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Search')]")
	public WebElement SearchPageTitle;

	@FindBy(xpath="//a[contains(text(),'Search')]")
	public WebElement SearchTab;

	@FindBy(xpath="//label[@for='searchFor']")
	public WebElement SearchForTitle;

	@FindBy(xpath="//label[@for='searchBy']")
	public WebElement SearchByTitle;

	@FindBy(xpath="//label[@for='condition']")
	public WebElement SearchConditionTitle;

	@FindBy(xpath="//select[@id='searchFor']")
	public WebElement SearchForDropdown;

	@FindBy(xpath="//select[@id='searchBy']")
	public WebElement SearchByDropdown;

	@FindBy(xpath="//select[@id='condition']")
	public WebElement SearchConditionDropdown;

	@FindBy(xpath="//select[@id='restrictBy']")
	public WebElement SearchRestrictByDropdown;
	
	@FindBy(xpath="//input[@id='searchByType-combobox']")
	public WebElement SearchByTypeDropdown;
	
	@FindBy(xpath="//input[@id='startDate']")
	public WebElement SearchByStartDate;
	
	@FindBy(xpath="//input[@id='endDate']")
	public WebElement SearchByEndDate;

	@FindBy(xpath="//button[@id='addSearchCriteria']")
	public WebElement SearchAddButton;

	@FindBy(xpath="//button[@id='removeSearchCriteria']")
	public WebElement SearchRemoveButton;

	@FindBy(xpath="//label[contains(text(),'Search Criteria')]")
	public WebElement SearchCriteriaTitle;
	
	@FindBy(xpath="//select[@id='searchCriteria']")
	public WebElement SearchCriteria;

	@FindBy(xpath="//button[contains(text(),'Search')]")
	public WebElement SearchButton;
	
	@FindBy(xpath="//input[@id='searchText']")
	public WebElement ValueTextBox;
	
	@FindBy(xpath="//label[@for='searchText']")
	public WebElement ValueTitle;
	
	@FindBy(xpath="//input[@id='searchByType-combobox']")
	public WebElement TypeTextBox;
	
	@FindBy(xpath="//label[@for='searchByType-combobox']")
	public WebElement TypeTitle;
	
	@FindBy(xpath="//label[contains(@for,'firstSubmitDate')]")
	public WebElement FirstSubmitDateTitle;

	@FindBy(xpath="//input[contains(@id,'firstSubmitDate')]")
	public WebElement FirstSubmitDateTextBox;

	@FindBy(xpath="//label[contains(@for,'lastSubmitDate')]")
	public WebElement LastSubmitDateTitle;

	@FindBy(xpath="//input[contains(@id,'lastSubmitDate')]")
	public WebElement LastSubmitDateTextBox;
	
	@FindBy(xpath="//input[@id='addressText']")
	public WebElement AddressTextBox;
	
	@FindBy(xpath="//label[@for='addressText']")
	public WebElement AddressTitle;
	
	@FindBy(xpath="//select[@id='city']")
	public WebElement CityTownTextBox;
	
	@FindBy(xpath="//label[@for='city']")
	public WebElement CityTownTitle;
	
	@FindBy(xpath="//table[@id='searchResults']//tbody//tr[1]//td[1]//a[1]")
	public WebElement FirstRowIdLink;
	
	@FindBy(xpath="//h3[@class='addEditHeader']")
	public WebElement SearchResultHeader;
	
	public SearchPage clickFirstRowIDLink() {
		Source.SeleniumHelper().clickElement(FirstRowIdLink);
		return this;
	}
	
	public String readSearchResultTitle() {
		return Source.SeleniumHelper().readElement(SearchResultHeader);
	}

	public String readSearchPageTitle() {
		return Source.SeleniumHelper().readElement(SearchPageTitle);
	}

	public String readSearchForTitle() {
		return Source.SeleniumHelper().readElement(SearchForTitle);
	}

	public String readSearchByTitle() {
		return Source.SeleniumHelper().readElement(SearchByTitle);
	}

	public String readSearchConditionTitle() {
		return Source.SeleniumHelper().readElement(SearchConditionTitle);
	}

	public String readSearchAddBtn() {
		return Source.SeleniumHelper().readElement(SearchAddButton);
	}

	public SearchPage clickSearchAdd() {
		Source.SeleniumHelper().clickElement(SearchAddButton);
		return this;
	}

	public String readSearchRemoveBtn() {
		return Source.SeleniumHelper().readElement(SearchRemoveButton);
	}

	public SearchPage clickSearchRemove() {
		Source.SeleniumHelper().clickElement(SearchRemoveButton);
		return this;
	}

	public String readSearchCritetria() {
		return Source.SeleniumHelper().readElement(SearchCriteriaTitle);
	}

	public String readSearchBtn() {
		return Source.SeleniumHelper().readElement(SearchButton);
	}

	public SearchPage clickSearch() {
		Source.SeleniumHelper().clickElement(SearchButton);
		return this;
	}
	
	public SearchPage setSearchFor(String name) {
		Source.SeleniumHelper().select(SearchForDropdown, name);
		return this;
	}
	
	public SearchPage setSearchFor(int index) {
		Source.SeleniumHelper().select(SearchForDropdown, index);
		return this;
	}
	
	public SearchPage setSearchBy(String name) {
		Source.SeleniumHelper().select(SearchByDropdown, name);
		return this;
	}
	
	public SearchPage setSearchBy(int index) {
		Source.SeleniumHelper().select(SearchByDropdown, index);
		return this;
	}
	
	public SearchPage setSearchCondition(String name) {
		Source.SeleniumHelper().select(SearchConditionDropdown, name);
		return this;
	}
	
	public SearchPage setSearchCondition(int index) {
		Source.SeleniumHelper().select(SearchConditionDropdown, index);
		return this;
	}
	
	public SearchPage setSearchRestrictBy(String name) {
		Source.SeleniumHelper().select(SearchRestrictByDropdown, name);
		return this;
	}
	
	public SearchPage setSearchRestrictBy(int index) {
		Source.SeleniumHelper().select(SearchRestrictByDropdown, index);
		return this;
	}
	
	public SearchPage setValue(String value, String... Clear) {
		Source.SeleniumHelper().setText(ValueTextBox, value, Clear);
		return this;
	}

	public SearchPage setCondition(String condition) {
		Source.SeleniumHelper().select(SearchConditionDropdown, condition);
		return this;
	}

	public SearchPage setStartDate(String startDate) {
		Source.SeleniumHelper().setText(SearchByStartDate, startDate + Keys.TAB, Clear);
		return this;
	}
	
	public SearchPage setEndDate(String endDate) {
		Source.SeleniumHelper().setText(SearchByEndDate, endDate + Keys.TAB, Clear);
		return this;
	}
	
	public String readValueTitle() {
		return Source.SeleniumHelper().readElement(ValueTitle);
	}
	
	public SearchPage setType(String type, String... Clear) {
		Source.SeleniumHelper().setText(SearchByTypeDropdown, type, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readTypeTitle() {
		return Source.SeleniumHelper().readElement(TypeTitle);
	}
	
	public String readFirstSubmitDateTitle() {
		return Source.SeleniumHelper().readElement(FirstSubmitDateTitle);
	}

	public SearchPage setFirstSubmitDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(FirstSubmitDateTextBox, date + Keys.TAB, Clear);
		return this;
	}

	public String readFirstSubmitDateValue() {
		return Source.SeleniumHelper().getWebElement(FirstSubmitDateTextBox).getAttribute("original-val");
	}

	public String readLastSubmitDateTitle() {
		return Source.SeleniumHelper().readElement(LastSubmitDateTitle);
	}

	public SearchPage setLastSubmitDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(LastSubmitDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public String readLastSubmitDateValue() {
		return Source.SeleniumHelper().getWebElement(LastSubmitDateTextBox).getAttribute("original-val");
	}
	
	public SearchPage setAddress(String address, String... Clear) {
		Source.SeleniumHelper().setText(AddressTextBox, address, Clear);
		return this;
	}
	
	public String readAddressTitle() {
		return Source.SeleniumHelper().readElement(AddressTitle);
	}
	
	public SearchPage setCity(String city) {
		Source.SeleniumHelper().select(CityTownTextBox, city);
		return this;
	}
	
	public String readCityTownTitle() {
		return Source.SeleniumHelper().readElement(CityTownTextBox);
	}

	public String isSearchEnabled() {
		return Boolean.toString(SearchButton.isEnabled());
	}

	public String isListBoxSizeEqual(int size) {
		Select criteria = new Select(SearchCriteria);
		return Boolean.toString(criteria.getOptions().size() == size);
	}
	
	public SearchPage selectSearchCriteria(int index) {
		Source.SeleniumHelper().select(SearchCriteria, index);
		return this;
	}
	
	public SearchPage removeSearchCriteria(int index) {
		Source.SeleniumHelper().select(SearchCriteria, index);
		clickSearchRemove();
		return this;
	}

}
