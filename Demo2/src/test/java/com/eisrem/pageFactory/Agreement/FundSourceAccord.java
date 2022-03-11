package com.eisrem.pageFactory.Agreement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundSourceAccord extends AgreementNavigator{

	public FundSourceAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Add Agreement')]")
	public WebElement AddAgreementTitle;
	
	@FindBy(xpath="//a[contains(text(),'Agreement Info:')]")
	public WebElement AgreementInfoAccord;
	
	@FindBy(xpath="//li[@id='agrmnt-tab']")
	public WebElement AgreementTabTitle;
	
	@FindBy(xpath="//label[@for = 'srvType-startdate']")
	public WebElement StartDateTitle;
	
	@FindBy(xpath="//input[@id='srvType-startdate']")
	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//label[@for = 'srvType-enddate']")
	public WebElement EndDateTitle;
				
	@FindBy(xpath="//input[@id='srvType-enddate']")
	public WebElement EndDateTextBox;
	
	@FindBy(xpath="//label[@for = 'srvType']")
	public WebElement ServiceTypeTitle;
	
	@FindBy(xpath="//select[@id='srvType']")
	public WebElement ServiceTypeDropDown;
	
	@FindBy(xpath="//label[@for = 'srvType-cost']")
	public WebElement AmountTitle;
	
	@FindBy(xpath="//input[@id='srvType-cost']")
	public WebElement AmountTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Program Area')]")
	public WebElement ProgramAreaTitle;
	
	@FindBy(xpath="//select[@id='programArea']")
	public WebElement ProgramAreaDropdown;
	
	@FindBy(xpath="//label[contains(text(),'Fiscal Year')]")
	public WebElement FiscalYearTitle;
	
	@FindBy(xpath="//input[@id='datepicker_year_fisc']")
	public WebElement FiscalYearTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Funding Type')]")
	public WebElement FundingTypeTitle;
		
	@FindBy(xpath="//select[@id='fndngType']")
	public WebElement FundingTypeDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Agency')]")
	public WebElement AgencyTitle;
		
	@FindBy(xpath="//input[@id='agency']")
	public WebElement AgencyTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Appropriation Unit')]")
	public WebElement AppropriationUnitTitle;
	
	@FindBy(xpath="//select[@id='apprUnit']")
	public WebElement AppropriationUnitDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Object')]")
	public WebElement ObjectTitle;
	
	@FindBy(xpath="//input[@id='obj']")
	public WebElement ObjectTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Reporting Organization')]")
	public WebElement ReportingOrganizationTitle;
	
	@FindBy(xpath="//select[@id='reportOrg']")
	public WebElement ReportingOrganizationDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Activity')]")
	public WebElement ActivityTitle;
	
	@FindBy(xpath="//select[@id='activity']")
	public WebElement ActivityDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Settlement Type')]")
	public WebElement SettlementTypeTitle;
	
	@FindBy(xpath="//select[@id='stlmntType']")
	public WebElement SettlementTypeDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Accounting String Type')]")
	public WebElement AccountingStringTypeTitle;
	
	@FindBy(xpath="//select[@id='acctStringType']")
	public WebElement AccountingStringDropDown;
	
	
	public String readAddAgreementTitle() {
		return Source.SeleniumHelper().readElement(AddAgreementTitle);
	}
	
	public String readAgreementInfoAccord() {
		return Source.SeleniumHelper().readElement(AgreementInfoAccord);
	}
	
	public FundSourceAccord clickLinkTitle() {
		Source.SeleniumHelper().clickElement(AgreementInfoAccord);
		return this;
	}
	
	public String readAgreementTabTitle() {
		return Source.SeleniumHelper().readElement(AgreementTabTitle);
	}
	
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}
	
	public FundSourceAccord setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, date, true, Clear);
		return this;
	}
	
	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}
	
	public FundSourceAccord setEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(EndDateTextBox, date, true, Clear);
		return this;
	}
	
	public String readServiceTypeTitle() {
		return Source.SeleniumHelper().readElement(ServiceTypeTitle);
	}
	
	public FundSourceAccord selectServiceType(int index) {
		Source.SeleniumHelper().select(ServiceTypeDropDown, index);
		return this;
	}
	
	public String readAmountTitle() {
		return Source.SeleniumHelper().readElement(AmountTitle);
	}
	
	public FundSourceAccord setAmount(String amt, String... Clear) {
		Source.SeleniumHelper().setText(AmountTextBox, amt, Clear);
		return this;
	}
	
	public String readProgramAreaTitle() {
		return Source.SeleniumHelper().readElement(ProgramAreaTitle);
	}
	
	public FundSourceAccord selectProgramArea(int index) {
		Source.SeleniumHelper().select(ProgramAreaDropdown, index);
		return this;
	}
	
	public FundSourceAccord selectProgramArea(String value) {
		Source.SeleniumHelper().select(ProgramAreaDropdown, value);
		return this;
	}
			
	public String readFiscalYearTitle() {
		return Source.SeleniumHelper().readElement(FiscalYearTitle);
	}
	
	public FundSourceAccord setFiscalYear(String year, String... Clear) {
		Source.SeleniumHelper().setText(FiscalYearTextBox, year, true, Clear);
		return this;
	}
	
	public String readFundingTypeTitle() {
		return Source.SeleniumHelper().readElement(FundingTypeTitle);
	}
	
	public FundSourceAccord selectFundingType(int index) {
		Source.SeleniumHelper().select(FundingTypeDropDown, index);
		return this;
	}
	
	public FundSourceAccord selectFundingType(String value) {
		Source.SeleniumHelper().select(FundingTypeDropDown, value);
		return this;
	}
	
	public String readAgencyTitle() {
		return Source.SeleniumHelper().readElement(AgencyTitle);
	}
	
	public FundSourceAccord setAgency(String Agency, String... Clear) {
		Source.SeleniumHelper().setText(AgencyTextBox, Agency, Clear);
		return this;
	}
	
	public String readAppropriationUnitTitle() {
		return Source.SeleniumHelper().readElement(AppropriationUnitTitle);
	}
	
	public FundSourceAccord selectAppropriationUnit(int index) {
		Source.SeleniumHelper().select(AppropriationUnitDropDown, index);
		return this;
	}
	
	public FundSourceAccord selectAppropriationUnit(String value) {
		Source.SeleniumHelper().select(AppropriationUnitDropDown, value);
		return this;
	}
	
	public String readObjectTitle() {
		return Source.SeleniumHelper().readElement(ObjectTitle);
	}
		
	public FundSourceAccord setObject(int num, String... Clear) {
		Source.SeleniumHelper().setText(ObjectTextBox, num, Clear);
		return this;
	}
	
	public String readReportingOrganizationTitle() {
		return Source.SeleniumHelper().readElement(ReportingOrganizationTitle);
	}
	public FundSourceAccord selectReportingOrganization(int index) {
		Source.SeleniumHelper().select(ReportingOrganizationDropDown, index);
		return this;
	}
	
	public FundSourceAccord selectReportingOrganization(String value) {
		Source.SeleniumHelper().select(ReportingOrganizationDropDown, value);
		return this;
	}
	
	public String readActivityTitle() {
		return Source.SeleniumHelper().readElement(ActivityTitle);
	}
	
	public FundSourceAccord selectActivity(int index) {
		Source.SeleniumHelper().select(ActivityDropDown, index);
		return this;
	}
	
	public FundSourceAccord selectActivity(String value) {
		Source.SeleniumHelper().select(ActivityDropDown, value);
		return this;
	}
	
	public String readSettlementTypeTitle() {
		return Source.SeleniumHelper().readElement(SettlementTypeTitle);
	}
	
	public FundSourceAccord selectSettlementType(int index) {
		Source.SeleniumHelper().select(SettlementTypeDropDown, index);
		return this;
	}
	
	public FundSourceAccord selectSettlementType(String value) {
		Source.SeleniumHelper().select(SettlementTypeDropDown, value);
		return this;
	}
	
	public String readAccountingStringTypeTitle() {
		return Source.SeleniumHelper().readElement(AccountingStringTypeTitle);
	}
	
	public FundSourceAccord selectAccountingString(int index) {
		Source.SeleniumHelper().select(AccountingStringDropDown, index);
		return this;
	}
		
	public FundSourceAccord selectAccountingString(String value) {
		Source.SeleniumHelper().select(AccountingStringDropDown, value);
		return this;
	}

}
