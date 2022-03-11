package com.eisrem.pageFactory.Agreement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgreementPage extends AgreementNavigator{

	public AgreementPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Add Agreement')]")
	public WebElement AddAgreementTitle;
	
	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;
	
	@FindBy(xpath="//a[contains(text(),'Agreement')]")
	public WebElement AgreementInfoLink;
				
	@FindBy(xpath="//a[@data-toggle='tab']")
	public WebElement AgreementTab;
	
	@FindBy(xpath="//label[@for='agrmnt-startdate']")
	public WebElement StartDateTitle;
	
	@FindBy(xpath="//input[@id='agrmnt-startdate']")
	public WebElement StartDateSelectBox;
	
	@FindBy(xpath="//label[@for='agrmnt-enddate']")
	public WebElement EndDateTitle;
	
	@FindBy(xpath="//input[@id='agrmnt-enddate']")
	public WebElement EndDateSelectBox;
	
	@FindBy(xpath="//label[@for='agrmnt-type']")
	public WebElement TypeTitle;
	
	@FindBy(xpath="//select[@id='agrmnt-type']")
	public WebElement TypeSelectBox;
	
	@FindBy(xpath="//label[@for='agrmntNm']")
	public WebElement AgreementNameTitle;
	
	@FindBy(xpath="//input[@id='agrmntNm']")
	public WebElement AgreementNameTextBox;
		
	@FindBy(xpath="//label[@for='agrmntCtrctNum']")
	public WebElement AgreementContractNumberTitle;
	
	@FindBy(xpath="//input[@id='agrmntCtrctNum']")
	public WebElement AgreementContractNumberTextBox;
		
	@FindBy(xpath="//label[@for='agrmntCtrctMngr-combobox']")
	public WebElement AgreementManagerTitle;
	
	@FindBy(xpath="//input[@id='agrmntCtrctMngr-combobox']")
	public WebElement AgreementManagerSelectBox;
	
	@FindBy(xpath="//label[@for='agrmnt-org-combobox']")
	public WebElement OrganizationNameTitle;
	
	@FindBy(xpath="//input[@id='agrmnt-org-combobox']")
	public WebElement OrganizationNameTextBox;
	
	@FindBy(xpath="//input[@id='agrmnt-org-combobox']")
	public WebElement OrganizationNameOptions;
	
	@FindBy(xpath="//label[@for='orgFdrlBilId']")
	public WebElement OrganizationFederallBillingIdTitle;
	
	@FindBy(xpath="//select[@id='orgFdrlBilId']")
	public WebElement OrganizationFederallBillingIdSelectBox;
	
	@FindBy(xpath="//label[@for='email']")
	public WebElement OrganizationContactEmailAddressTitle;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement OrganizationContactEmailAddressTextBox;
	
	@FindBy(xpath="//label[@for='srvType-totalCost']")
	public WebElement TotalAmtRemainingTitle;
	
	@FindBy(xpath="//input[@id='srvType-totalCost']")
	public WebElement TotalAmtRemainingTextBox;
	
	@FindBy(xpath="//label[@for='agrmnt-desc']")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[@id='agrmnt-desc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Active?')]")
	public WebElement ActiveBtn;
	
	@FindBy(xpath="//div[@class='form-control fake-form-control']//div[1]//div")
	public WebElement ActiveYesNoBtn;
	
	@FindBy(xpath="//div[@class='form-control fake-form-control']//div[1]//div//input")
	public WebElement ActiveYesNoBtnAttribute;
	
	@FindBy(xpath="//a[contains(text(),'Fund Source Info:')]")
	public WebElement FundSourceInfoLink;
	
	@FindBy(xpath="//div[@id= 'srv-type-table_length']")
	public WebElement FundSourceInfoShowEntries;

	@FindBy(xpath="//select[@aria-controls='srv-type-table']")
	public WebElement FundSourceInfoShowEntriesDropdown;
		
	@FindBy(xpath="//a[@aria-controls='srv-type-table']//span[contains(text(),'Add')]")
	public WebElement FundSourceInfoAddButton;
		
	@FindBy(xpath="//a[@aria-controls='srv-type-table']//span[contains(text(),'Edit')]")
	public WebElement FundSourceInfoEditButton;
	
	@FindBy(xpath="//a[@aria-controls='srv-type-table']//span[contains(text(),'Excel')]")
	public WebElement FundSourceInfoExcelButton;
	
	@FindBy(xpath="//div[@id='srv-type-table_filter'] //label")
	public WebElement FundSourceInfoSearchTitle;

	@FindBy(xpath="//input[@aria-controls='srv-type-table']")
	public WebElement FundSourceInfoSearchTextBox;
	
	@FindBy(xpath="//th[@aria-controls='srv-type-table'] [text()='ID']")
	public WebElement FundSourceInfoIdList;
	
	@FindBy(xpath="//thead/tr[1]/th[1]/img[1]")
	public WebElement FundSourceInfoIdSection;
	
	@FindBy(xpath="//th[@aria-controls='srv-type-table'] [text()='Type']")
	public WebElement FundSourceInfoTypeList;
	
	@FindBy(xpath="//thead/tr[1]/th[2]/img[1]")
	public WebElement FundSourceInfoTypeSection;
	
	@FindBy(xpath="//th[@aria-controls='srv-type-table'] [text()='Start Date']")
	public WebElement FundSourceInfoStartDateList;
	
	@FindBy(xpath="//thead/tr[1]/th[3]/img[1]")
	public WebElement FundSourceInfoStartDateSection;
	
	@FindBy(xpath="//th[@aria-controls='srv-type-table'] [text()='End Date']")
	public WebElement FundSourceInfoEndDateList;
	
	@FindBy(xpath="//thead/tr[1]/th[4]/img[1]")
	public WebElement FundSourceInfoEndDateSection;
	
	@FindBy(xpath="//th[@aria-controls='srv-type-table'] [text()='Modified Date']")
	public WebElement FundSourceInfoModifiedDateList;
	
	@FindBy(xpath="//thead/tr[1]/th[5]/img[1]")
	public WebElement FundSourceInfoModifiedDateSection;
	
	@FindBy(xpath="//a[@id='srv-type-table_previous']")
	public WebElement FundSourceInfoPreviousBtn;

	@FindBy(xpath="//a[@id='srv-type-table_next']")
	public WebElement FundSourceInfoNextBtn;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement SubmitBtn;
				
	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To Agreements')]")
	public WebElement BackToAgreementsBtn;
		
	public String readAddAgreementTitle() {
		return Source.SeleniumHelper().readElement(AddAgreementTitle);
	}
	
	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}
	
	public String readAgreementTabTitle() {
		return Source.SeleniumHelper().readElement(AgreementTab);
	}
	
	public String readLinkTitle() {
		return Source.SeleniumHelper().readElement(AgreementInfoLink);
	}
	
	public AgreementPage clickAgreementInfoAccord() {
		Source.SeleniumHelper().clickElement(AgreementInfoLink);
		return this;
	}
	
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}
	
	public AgreementPage setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateSelectBox, date, true, Clear);
		return this;
	}
	
	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}
	
	public AgreementPage setEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(EndDateSelectBox, date, true, Clear);
		return this;
	}
		
	public String readTypeTitle() {
		return Source.SeleniumHelper().readElement(TypeTitle);
	}
	
	public AgreementPage selectType(int index) {
		Source.SeleniumHelper().select(TypeSelectBox, index);
		return this;
	}
		
	public String readAgreementNameTitle() {
		return Source.SeleniumHelper().readElement(AgreementNameTitle);
	}
	
	public AgreementPage setAgreementName(String name, String... Clear) {
		Source.SeleniumHelper().setText(AgreementNameTextBox, name, Clear);
		return this;
	}
			
	public String readAgreementContractNumberTitle() {
		return Source.SeleniumHelper().readElement(AgreementContractNumberTitle);
	}
	
	public AgreementPage setAgreementContractNum(int number, String... Clear) {
		Source.SeleniumHelper().setText(AgreementContractNumberTextBox, number, Clear);
		return this;
	}
	
	public AgreementPage setAgreementContractNum(String value, String... Clear) {
		Source.SeleniumHelper().setText(AgreementContractNumberTextBox, value);
		return this;
	}
	
	public String readAgreementManagerTitle() {
		return Source.SeleniumHelper().readElement(AgreementManagerTitle);
	}
	
	public AgreementPage setAgreementManager(String Name, String... Clear) {
		Source.SeleniumHelper().setText(AgreementManagerSelectBox, Name, true, Clear);
		return this;
	}
		
	public String readOrgNameTitle() {
		return Source.SeleniumHelper().readElement(OrganizationNameTitle);
	}
	
	public AgreementPage setOrgName(String OrgName, String... Clear) {
		Source.SeleniumHelper().setText(OrganizationNameTextBox, OrgName, true, Clear);
		return this;
	}
	
	public String readOrgFederalBillingIdTitle() {
		return Source.SeleniumHelper().readElement(OrganizationFederallBillingIdTitle);
	}
	
	public AgreementPage selectOrgFederallBillingId(int index) {
		Source.SeleniumHelper().select(OrganizationFederallBillingIdSelectBox, index);
		return this;
	}
	
	public AgreementPage selectOrgFederallBillingId(String value) {
		Source.SeleniumHelper().select(OrganizationFederallBillingIdSelectBox, value);
		return this;
	}
	
	public String readOrgContactEmailAddressTitle() {
		return Source.SeleniumHelper().readElement(OrganizationContactEmailAddressTitle);
	}
		
	public AgreementPage setOrgContactEmailAdress(String Email, String... Clear) {
		Source.SeleniumHelper().setText(OrganizationContactEmailAddressTextBox, Email, Clear);
		return this;
	}
		
	public String readTotalAmountRemainingTitle() {
		return Source.SeleniumHelper().readElement(TotalAmtRemainingTitle);
	}
	//
	public AgreementPage setTotalAmtRemaining(String Amt, String... Clear) {
		Source.SeleniumHelper().setText(TotalAmtRemainingTextBox, Amt);
		return this;
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public String readActiveBtnTitle() {
		return Source.SeleniumHelper().readElement(ActiveBtn);
	}
	
	public String readActiveYesNoBtnTitle() {
		return Source.SeleniumHelper().readElement(ActiveYesNoBtn);
	}
	
	public String readFundSourceInfoLinkTitle() {
		return Source.SeleniumHelper().readElement(FundSourceInfoLink);
	}
	
	public AgreementPage clickFundSourceInfoLinkTitle() {
		Source.SeleniumHelper().clickElement(FundSourceInfoLink);
		return this;
	}
	
	public String readFundSourceInfoShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(FundSourceInfoShowEntries);
	}
	
	public AgreementPage selectFundSourceInfoShowEntries(int index) {
		Source.SeleniumHelper().select(FundSourceInfoShowEntriesDropdown, index);
		return this;
	}
	
	public String readFundSourceInfoSearchTitle() {
		return Source.SeleniumHelper().readElement(FundSourceInfoSearchTitle);
	}
	
	public AgreementPage setSearchFundSourceInfo(String value, String... Clear) {
		Source.SeleniumHelper().setText(FundSourceInfoSearchTextBox, value, Clear);
		return this;
	}
		
	public String readFundSourceInfoAddBtn() {
		return Source.SeleniumHelper().readElement(FundSourceInfoAddButton);
	}

	public AgreementPage clickFundSourceInfoAdd() {
		Source.SeleniumHelper().clickElement(FundSourceInfoAddButton);
		return this;
	}
	
	public String readFundSourceInfoEditBtn() {
		return Source.SeleniumHelper().readElement(FundSourceInfoEditButton);
	}

	public AgreementPage clickFundSourceInfoEdit() {
		Source.SeleniumHelper().clickElement(FundSourceInfoEditButton);
		return this;
	}
	
	public String readFundSourceInfoExcelBtn() {
		return Source.SeleniumHelper().readElement(FundSourceInfoExcelButton);
	}

	public AgreementPage clickFundSourceInfoExcel() {
		Source.SeleniumHelper().clickElement(FundSourceInfoExcelButton);
		return this;
	}
		
	public AgreementPage clickFundSourceInfoIdList() {
		Source.SeleniumHelper().clickElement(FundSourceInfoIdList);
		return this;
	}
	
	public String readFundSourceInfoIdList() {
		return Source.SeleniumHelper().readElement(FundSourceInfoIdList);
	}
	
	public AgreementPage clickFundSourceInfoType() {
		Source.SeleniumHelper().clickElement(FundSourceInfoTypeList);
		return this;
	}
	
	public String readFundSourceInfoTypeList() {
		return Source.SeleniumHelper().readElement(FundSourceInfoTypeList);
	}
	
	public AgreementPage clickFundSourceInfoStartDate() {
		Source.SeleniumHelper().clickElement(FundSourceInfoStartDateList);
		return this;
	}
	
	public String readFundSourceInfoStartDateList() {
		return Source.SeleniumHelper().readElement(FundSourceInfoStartDateList);
	}
	
	public AgreementPage clickFundSourceInfoEndDate() {
		Source.SeleniumHelper().clickElement(FundSourceInfoEndDateList);
		return this;
	}
	
	public String readFundSourceInfoEndDateList() {
		return Source.SeleniumHelper().readElement(FundSourceInfoEndDateList);
	}
	
	public AgreementPage clickFundSourceInfoModifiedDate() {
		Source.SeleniumHelper().clickElement(FundSourceInfoModifiedDateList);
		return this;
	}
	
	public String readFundSourceInfoModifiedDateList() {
		return Source.SeleniumHelper().readElement(FundSourceInfoModifiedDateList);
	}
		
	public AgreementPage clickFundSourceInfoPrevious() {
		Source.SeleniumHelper().clickElement(FundSourceInfoPreviousBtn);
		return this;
	}
	
	public String readFundSourceInfoPreviousBtn() {
		return Source.SeleniumHelper().readElement(FundSourceInfoPreviousBtn);
	}
	
	public AgreementPage clickFundSourceInfoNext() {
		Source.SeleniumHelper().clickElement(FundSourceInfoNextBtn);
		return this;
	}
	
	public String readFundSourceInfoNextBtn() {
		return Source.SeleniumHelper().readElement(FundSourceInfoNextBtn);
	}
	
	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}
	
	public AgreementPage clickSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return this;
	}
				
	public String readBackToAgreementsBtn() {
		return Source.SeleniumHelper().readElement(BackToAgreementsBtn);
	}
	
	public AgreementPage clickBackToAgreements() {
		Source.SeleniumHelper().clickElement(BackToAgreementsBtn);
		return this;
	}
	
	public AgreementPage setOrgNameAgreements(String partialName, int option) {
		Source.SeleniumHelper().clearElement(OrganizationNameTextBox);
		Source.SeleniumHelper().setText(OrganizationNameTextBox, partialName);
		By orgLink = By.xpath("//input[@id='agrmnt-org-combobox']/..//ul//li[" + option + "]");
		Source.SeleniumHelper().clickElement(orgLink);
		return this;
	}
	
	public AgreementPage checkIfBaseLocsFirst() throws Exception {
		List<WebElement> locations= Source.SeleniumHelper().getWebElementList(By.xpath("//*[@id='agrmnt-org-container']/div/div/ul/li"));
		int listSize = locations.size();
		boolean isOtherLoc = false;
		for(int i = 0; i <= listSize - 1; i++) {
			if(locations.get(i).getAttribute("data-value").endsWith("/ BASE")) {
				if(isOtherLoc) throw new Exception("Base Location not in order!");	// if Base location appears after Other location, throw error
			}
			else if(!locations.get(i).getAttribute("data-value").endsWith("/ BASE") && !isOtherLoc) {
				isOtherLoc = true;
			}
		}
		return this;
	}

}
