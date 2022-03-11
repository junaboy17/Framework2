package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.RolesAvailableAccord;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;

public class OrganizationPage extends OrganizationNavigator{

	public OrganizationPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Add Organization')]")
	public WebElement AddOrganizationTitle;
	
	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;
	
	@FindBy(xpath="//a[contains(text(),'Org General Info:')]")
	public WebElement OrgGeneralInfoLink;
	
	@FindBy(xpath="//label[@for='datepicker_startDate_org']")
	public WebElement StartDateTitle;
	
	@FindBy(xpath="//input[@id='datepicker_startDate_org']")
	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//label[@for='datepicker_endDate_org']")
	public WebElement EndDateTitle;
	
	@FindBy(xpath="//input[@id='datepicker_endDate_org']")
	public WebElement EndDateTextBox;
	
	@FindBy(xpath="//label[@for='orgNm']")
	public WebElement OrganizationNameTitle;
	
	@FindBy(xpath="//input[@id='orgNm']")
	public WebElement OrganizationNameTextBox;
	
	@FindBy(xpath="//label[@for='orgType']")
	public WebElement OrganizationTypeTitle;
	
	@FindBy(xpath="//select[@id='orgType']")
	public WebElement OrganizationTypeSelectBox;
	
	@FindBy(xpath="//label[contains(text(),'Description')]")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[@id='desc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//a[contains(text(),'Tax Info:')]")
	public WebElement TaxInfoLink;
	
	@FindBy(xpath="//label[contains(text(),'Industry Classification')]")
	public WebElement TaxInfoIndustryClassificationTitle;
	
	@FindBy(xpath="//select[@id='industryClassfication']")
	public WebElement TaxInfoIndustryClassificationSelectBox;
	
	@FindBy(xpath="//label[contains(text(),'Tax Status')]")
	public WebElement TaxInfoTaxStatusTitle;
	
	@FindBy(xpath="//select[@id='taxStatus']")
	public WebElement TaxInfoTaxStatusSelectBox;
	
	@FindBy(xpath="//label[contains(text(),'Fiscal Year Start Month')]")
	public WebElement TaxInfoFiscalYearStartMonthTitle;
	
	@FindBy(xpath="//input[@id='datepicker_startDate_fisc']")
	public WebElement TaxInfoFiscalYearStartMonthSelectBox;
	
	@FindBy(xpath="//label[contains(text(),'Fiscal Year End Month')]")
	public WebElement TaxInfoFiscalYearEndMonthTitle;
	
	@FindBy(xpath="//input[@id='datepicker_endDate_fisc']")
	public WebElement TaxInfoFiscalYearEndMonthSelectBox;
	
	@FindBy(xpath="//button[contains(text(),'Back To Organizations')]")
	public WebElement BackToOrganizationsBtn;
	
	@FindBy(xpath="//input[@id='activeFlag']")
	public WebElement ActiveFlag;
	
	
	public String readAddOrganizationTitle() {
		return Source.SeleniumHelper().readElement(AddOrganizationTitle);
	}
	
	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}
	
	public String readLinkTitle() {
		return Source.SeleniumHelper().readElement(OrgGeneralInfoLink);
	}
	
	public OrganizationPage clickOrgGeneralInfoLink() {
		Source.SeleniumHelper().clickElement(OrgGeneralInfoLink);
		return this;
	}
	
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}
	
	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}
	
	public String readOrganizationNameTitle() {
		return Source.SeleniumHelper().readElement(OrganizationNameTitle);
	}
	
	public OrganizationPage setOrganizationName(String value, String... Clear) {
		Source.SeleniumHelper().setText(OrganizationNameTextBox, value, Clear);
		return this;
	}
	
	public String readOrganizationTypeTitle() {
		return Source.SeleniumHelper().readElement(OrganizationTypeTitle);
	}
	
	public OrganizationPage selectOrganizationType(int index) {
		Source.SeleniumHelper().select(OrganizationTypeSelectBox, index);
		return this;
	}
	
	public OrganizationPage selectOrganizationType(String name) {
		Source.SeleniumHelper().select(OrganizationTypeSelectBox, name);
		return this;
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public String readTaxInfoLinkTitle() {
		return Source.SeleniumHelper().readElement(TaxInfoLink);
	}
	
	public OrganizationPage clickTaxInfoLinkTitle() {
		Source.SeleniumHelper().clickElement(TaxInfoLink);
		return this;
	}
	
	public String readTaxInfoIndustryClassificationTitle() {
		return Source.SeleniumHelper().readElement(TaxInfoIndustryClassificationTitle);
	}
	
	public String readTaxInfoTaxStatusTitle() {
		return Source.SeleniumHelper().readElement(TaxInfoTaxStatusTitle);
	}
	
	public String readTaxInfoFiscalYearStartMonthTitle() {
		return Source.SeleniumHelper().readElement(TaxInfoFiscalYearStartMonthTitle);
	}
	
	public String readTaxInfoFiscalYearEndMonthTitle() {
		return Source.SeleniumHelper().readElement(TaxInfoFiscalYearEndMonthTitle);
	}
	
	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}
	
	public String readBackToOrganizationsBtn() {
		return Source.SeleniumHelper().readElement(BackToOrganizationsBtn);
	}
	
	public OrganizationPage clickBackToOrganizations() {
		Source.SeleniumHelper().clickElement(BackToOrganizationsBtn);
		return this;
	}
	
	public OrganizationPage toggleActive(boolean active) {
		if((active && ActiveFlag.getAttribute("last-val").equals("false"))
				|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
			clickActiveToggle();
		return this;
	}
	
	public OrganizationPage addCompleteOrganizationPageAndSubmit()
	{
		Source			.NavigationMenuBar().clickOrganization().clickAdd();
		
		Source			.OrganizationPage()
						.setOrganizationName(OrganizationName)
						.selectOrganizationType(OrganizationType.OTHER.getName())
						.setStartDate(Today, EmptyString)
						.setDescription(Description, EmptyString);
						
		Source			.OrganizationPage().clickSubmit().clickPopupOk();						
		return this;
	}
	
	public String addCompleteOrganizationPageSubmitAndReturnId()
	{
		Source			.NavigationMenuBar().clickOrganization().clickAdd();
		
		Source			.OrganizationPage()
						.setOrganizationName(OrganizationName)
						.selectOrganizationType(OrganizationType.OTHER.getName())
						.setStartDate(Today, EmptyString)
						.setDescription(Description, EmptyString);
											
		return Source.OrganizationPage().clickSubmit().clickPopupOk().OrganizationNavigator().clickOrganizations().DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);						
	}
	
	public OrganizationPage addCompleteOrganizationPageAndSubmit(String name, OrganizationType type, String startDate, String endDate, Boolean active,
			String description)
	{
		Source			.NavigationMenuBar().clickOrganization().clickAdd();
		
		Source			.OrganizationPage()
						.setOrganizationName(name == null ? OrganizationName : name)
						.selectOrganizationType(type == null ? OrganizationType.OTHER.getName() : type.getName())
						.setStartDate(startDate == null ? Today : startDate, EmptyString)
						.setEndDate(endDate == null ? EmptyString : endDate, EmptyString)
						.setDescription(description == null ? Description : description, EmptyString);
		
		toggleActive(active);
						
		Source			.OrganizationPage().clickSubmit().clickPopupOk();						
		return this;
	}
	
	public String addCompleteOrganizationPageSubmitAndReturnId(String name, OrganizationType type, String startDate, String endDate, Boolean active,
			String description)
	{
		Source			.NavigationMenuBar().clickOrganization().clickAdd();
		
		Source			.OrganizationPage()
						.setOrganizationName(name == null ? OrganizationName : name)
						.selectOrganizationType(type == null ? OrganizationType.OTHER.getName() : type.getName())
						.setStartDate(startDate == null ? Today : startDate, EmptyString)
						.setEndDate(endDate == null ? EmptyString : endDate, EmptyString)
						.setDescription(description == null ? Description : description, EmptyString);
		
		toggleActive(active);
						
		return Source.OrganizationPage().clickSubmit().clickPopupOk().OrganizationNavigator().clickOrganizations().DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);						
	}
	
	public OrganizationPage endDateOrganization(String searchResult, String endDate)
	{
		Source			.NavigationMenuBar().clickOrganization().setSearch(searchResult == null ? OrganizationName : searchResult).clickFirstRow().clickEdit();
		Source			.OrganizationPage().setEndDate(endDate == null ? Today : endDate, EmptyString);
		Source			.OrganizationPage().clickSubmit().clickPopupOk();	
		
		return this;
	}
	
	public OrganizationPage endDateOrganization(String searchResult)
	{
		Source			.NavigationMenuBar().clickOrganization().setSearch(searchResult == null ? OrganizationName : searchResult).clickFirstRow().clickEdit();
		Source			.OrganizationPage().setEndDate(Today, EmptyString);
		Source			.OrganizationPage().clickSubmit().clickPopupOk();	
		
		return this;
	}

}
