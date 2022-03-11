package com.eisrem.pageFactory.Administrator;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.Pagefactory;

	public class LookupsPage extends AdministratorNavigator{

		public LookupsPage(WebDriver driver) {
			super (driver);
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//h3[contains(text(),'Add Lookups')]")
		public WebElement AddLookupsPageTitle;
		
		@FindBy(xpath="//p[@class='required-note']")
		public WebElement NoteTitle;
			
		@FindBy(xpath="//a[contains(text(),'Lookups Info:')]")
		public WebElement LookupsInfoLink;
		
		@FindBy(xpath="//li[@id='lookup_tab']")
		public WebElement GroupTab;
			
		@FindBy(xpath="//label[@for='groupName']")
		public WebElement GroupNameTitle;
		
		@FindBy(xpath="//input[@id='groupName']")
		public WebElement GroupNameTextBox;
		
		@FindBy(xpath="//label[@for='category']")
		public WebElement CategoryTitle;
		
		@FindBy(xpath="//input[@id='category']")
		public WebElement CategoryTextBox;
		
		@FindBy(xpath="//label[contains(text(),'Description')]")
		public WebElement DescriptionTitle;
		
		@FindBy(xpath="//textarea[@id='AddLookupsDesc']")
		public WebElement DescriptionTextBox;
		
		@FindBy(xpath="//label[contains(text(),'Multiple Allowed')]")
		public WebElement MultipleAllowedTitle;
		
		@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-4 col-sm-6'][2]//div[@class='bootstrap-switch-container']")
		public WebElement MultipleAllowedToggle;
		
		@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-4 col-sm-6'][2]//div[@class='bootstrap-switch-container']//input")
		public WebElement MultipleAllowedToggleAttribute;
		
		@FindBy(xpath="//label[contains(text(),'System Lookup')]")
		public WebElement SystemLookupTitle;
					
		@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-4 col-sm-6'][3]//div[@class='bootstrap-switch-container']")
		public WebElement SystemLookUpToggle;
		
		@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-4 col-sm-6'][3]//div[@class='bootstrap-switch-container']//input")
		public WebElement SystemLookUpToggleAttribute;
		
		@FindBy(xpath="//a[contains(text(),'Labels Available:')]")
		public WebElement LabelsAvailableLink;
		
		@FindBy(xpath="//button[contains(text(),'Submit')]")
		public WebElement SubmitBtn;
		
		@FindBy(xpath="//button[contains(text(),'Print')]")
		public WebElement PrintBtn;
		
		@FindBy(xpath="//button[contains(text(),'Back To Lookups')]")
		public WebElement BackToLookupsBtn;	
		
		@FindBy(xpath="//button[contains(text(),'Sort Labels Alpha')]")
		public WebElement SortLabelsAlphaBtn;	

		
		public String readAddLookupsPageTitle() {
			return Source.SeleniumHelper().readElement(AddLookupsPageTitle);
		}
		
		public String readNoteTitle() {
			return Source.SeleniumHelper().readElement(NoteTitle);
		}
		
		public String readLookupsInfoLink() {
			return Source.SeleniumHelper().readElement(LookupsInfoLink);
		}
		
		public LookupsPage clickLookupsInfo() {
			Source.SeleniumHelper().clickElement(LookupsInfoLink);
			return this;
		}
		
		public String readGroupTab() {
			return Source.SeleniumHelper().readElement(GroupTab);
		}
		
		public String readStartDateTitle() {
			return Source.SeleniumHelper().readElement(StartDateTitle);
		}
		
		public String readEndDateTitle() {
			return Source.SeleniumHelper().readElement(EndDateTitle);
		}
		
		public String readGroupNameTitle() {
			return Source.SeleniumHelper().readElement(GroupNameTitle);
		}
		
		public String readCategoryTitle() {
			return Source.SeleniumHelper().readElement(CategoryTitle);
		}
		
		public String readDescriptionTitle() {
			return Source.SeleniumHelper().readElement(DescriptionTitle);
		}
		
		public LookupsPage setCategory(String name, String... Clear) {
			Source.SeleniumHelper().setText(CategoryTextBox, name, Clear);			
			return this;
		}

		public String readMultipleAllowedTitle() {
			return Source.SeleniumHelper().readElement(MultipleAllowedTitle);
		}
				
		public LookupsPage clickMultipleAllowedToggle() {
			Source.SeleniumHelper().clickElement(MultipleAllowedToggle);
			return this;
		}

		public String readMultipleAllowedToggle() {
			return MultipleAllowedToggleAttribute.getAttribute("last-val");
		}
		
		public LookupsPage clickMultipleAllowedToggle(String value) {
			String active = readMultipleAllowedToggle();

			if(value.equalsIgnoreCase(active)) {

			}
			else {
				clickMultipleAllowedToggle();
			}
			return this;
		}
		
		public String readSystemLookupTitle() {
			return Source.SeleniumHelper().readElement(SystemLookupTitle);
		}
	
		
		public LookupsPage clickSystemLookUpToggle() {
			Source.SeleniumHelper().clickElement(SystemLookUpToggle);
			return this;
		}

		public String readSystemLookUpToggle() {
			return SystemLookUpToggleAttribute.getAttribute("last-val");
		}
		
		public LookupsPage clickSystemLookUpToggle(String value) {
			String active = readSystemLookUpToggle();

			if(value.equalsIgnoreCase(active)) {

			}
			else {
				clickSystemLookUpToggle();
			}
			return this;
		}
		
		public String readLabelsAvailableLinkTitle() {
			return Source.SeleniumHelper().readElement(LabelsAvailableLink);
		}
		
		public LookupsPage clickLabelsAvailableAccord() {
			Source.SeleniumHelper().clickElement(LabelsAvailableLink);
			return this;
		}
		
		public LookupsPage clickSubmit() {
			Source.SeleniumHelper().clickElement(SubmitBtn);
			return this;
		}
		
		public String readSubmitBtn() {
			return Source.SeleniumHelper().readElement(SubmitBtn);
		}
		
		public LookupsPage clickPrint() {
			Source.SeleniumHelper().clickElement(PrintBtn);
			return this;
		}
		
		public String readPrintBtn() {
			return Source.SeleniumHelper().readElement(PrintBtn);
		}
		
		public LookupsPage clickBackToLookups() {
			Source.SeleniumHelper().clickElement(BackToLookupsBtn);
			return this;
		}
		
		public String readBackToLookupsBtn() {
			return Source.SeleniumHelper().readElement(BackToLookupsBtn);
		}
		
		public LookupsPage setGroupName(String name, String... Clear) {
			Source.SeleniumHelper().setText(GroupNameTextBox, name, Clear);			
			return this;
		}
		
		public LookupsPage switchSystemLookUpToggle(boolean active) {
			if((active && SystemLookUpToggleAttribute.getAttribute("last-val").equals("false"))
					|| (!active && SystemLookUpToggleAttribute.getAttribute("last-val").equals("true")))
				Source.SeleniumHelper().clickElement(SystemLookUpToggle);
			return this;
		}
		
		public LookupsPage clickSortLabelsAlpha() {
			Source.SeleniumHelper().clickElement(SortLabelsAlphaBtn);
			return this;
		}
	}
