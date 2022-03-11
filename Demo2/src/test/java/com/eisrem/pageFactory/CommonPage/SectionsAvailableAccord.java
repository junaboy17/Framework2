package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.Admin.NavigationMenuBar;
import com.eisrem.pageFactory.Administrator.AdministratorNavigator;
import com.eisrem.pageFactory.Administrator.PagesPage;

public class SectionsAvailableAccord extends AdministratorNavigator{


	public SectionsAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(xpath="//iframe[@id='sectionName_ifr']")
	public WebElement SectionNameIFrame;
	
	@FindBy(xpath = "//*[@data-id='sectionName']/p")
	public WebElement SectionNameTextBox;
	
	@FindBy(xpath = "//input[@id='sectionName']")
	public WebElement SectionNameTextBoxNF;
	
	@FindBy(xpath="//input[@id='secSortOrder']")
	public WebElement SortOrderTextBox;

	@FindBy(xpath="//textarea[@id='sectionDesc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//iframe[@id='sectionInstruction_ifr']")
	public WebElement SectionInstructionIFrame;
	
	@FindBy(xpath="//*[@data-id='sectionInstruction']/p")
	public WebElement SectionInstructionTextBox;

	@FindBy(xpath="//div[@id='section-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-section_descFlag')]")
	public WebElement ShowDescriptionToggle;
	
	@FindBy(xpath="//div[@id='section-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-section_descFlag')]//input")
	public WebElement ShowDescriptionToggleAttribute;
	
	@FindBy(xpath="//input[@id='section_descFlag']")
	public WebElement ShowDescriptionFlag;

	@FindBy(xpath="//div[@id='section-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-section_nameFlag')]")
	public WebElement ShowNameToggle;
	
	@FindBy(xpath="//input[@id='section_nameFlag']")
	public WebElement ShowNameFlag;

	@FindBy(xpath="//div[@id='section-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-on bootstrap-switch-mini bootstrap-switch-id-section_activeFlag')]")
	public WebElement ActiveToggle;
	
	@FindBy(xpath="//input[@id='section_activeFlag']")
	public WebElement ActiveFlag;
	
	@FindBy(xpath="//div[@id='section-tab-pane']//button[text()='Back']")
	public WebElement BackBtn;
	
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Rows Available:')]")
	public WebElement RowsAvailableAccordion;
		
	public SectionsAvailableAccord setSectionName(String SectionName, String... Clear) {
		if(Configuration.Config.iFrame==true) {
			Source.SeleniumHelper().setText(SectionNameIFrame, SectionNameTextBox, SectionName, Clear);
		}
		else {
			Source.SeleniumHelper().setText(SectionNameTextBoxNF, SectionName, Clear);
		}
		
		return this;
	}
		
	public SectionsAvailableAccord setSortOrder(String SortOrder, String... Clear) {
		Source.SeleniumHelper().setText(SortOrderTextBox, SortOrder, Clear);
		return this;
	}
	
	public SectionsAvailableAccord setDescription(String Description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, Description, Clear);
		return this;
	}
	
	public SectionsAvailableAccord setSectionInstruction(String SectionInstruction, String... Clear) {
		Source.SeleniumHelper().setText(SectionInstructionIFrame, SectionInstructionTextBox, SectionInstruction, Clear);
		return this;
	}
	
	public String readShowDescriptionToggle() {
		return ShowDescriptionToggleAttribute.getAttribute("last-val");
	}
	
	public SectionsAvailableAccord clickShowDescriptionToggle() {
		Source.SeleniumHelper().clickElement(ShowDescriptionToggle);
		return this;
	}
	
	public SectionsAvailableAccord clickShowDescriptionToggle(String value) {
		String active = readShowDescriptionToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickShowDescriptionToggle();
		}
		return this;
	}
	
	public SectionsAvailableAccord clickShowNameToggle() {
		Source.SeleniumHelper().clickElement(ShowNameToggle);
		return this;
	}
	
	public SectionsAvailableAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}
	
	public PagesPage clickSectionsBack() {
		Source.SeleniumHelper().clickElement(BackBtn);
		return new PagesPage(DriverFactory.getDriver());
	}
	
	public PagesPage clickSectionSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return new PagesPage(DriverFactory.getDriver());
	}
	
	public RowsAvailableAccord clickRowsAvailableAccordion() {
		Source.SeleniumHelper().clickElement(RowsAvailableAccordion);
		return new RowsAvailableAccord(DriverFactory.getDriver());
	}
	
	public SectionsAvailableAccord addSectionAndSubmit(String page, String name, int sortOrder, String description, boolean showDescription, 
			boolean showName, boolean active)
	{
		String searchPage = (page == null ? PagePrefix : page);
		Source   	.AdministratorNavigator()
					.clickPages()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.clickAdd()
					.SectionsAvailableAccord()
					.setSectionName(name == null ? SectionName : name)
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
					
					Source	.SectionsAvailableAccord()
							.clickSectionSubmit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5);
		return this;
	}
	
	public SectionsAvailableAccord addSection(String name, int sortOrder, String description, boolean showDescription, 
			boolean showName, boolean active)
	{
		Source   	.SectionsAvailableAccord()
					.clickAdd()
					.SectionsAvailableAccord()
					.setSectionName(name == null ? SectionName : name)
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
	
	public SectionsAvailableAccord addSectionAndSubmit(String page)
	{
		String searchPage = (page == null ? PagePrefix : page);
		Source   	.AdministratorNavigator()
					.clickPages()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.clickAdd()
					.SectionsAvailableAccord()
					.setSectionName(SectionName)
					.setSortOrder(OneN)
					.clickSectionSubmit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return this;
	}
	
	public SectionsAvailableAccord addSection()
	{
		String SectionName= "TC_Section_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source  	.PagesPage()
					.clickAdd()
					.SectionsAvailableAccord()
					.setSectionName(SectionName)
					.setSortOrder(OneN);
		return this;
	}
	
	public String addSectionGetNameAndSubmit(String page)
	{
		String SectionName= "TC_Section_Selenium " + SeleniumHelper.generateRandomNumber(8);
		String searchPage = (page == null ? PagePrefix : page);
		Source   	.AdministratorNavigator()
					.clickPages()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.clickAdd()
					.SectionsAvailableAccord()
					.setSectionName(SectionName)
					.setSortOrder(OneN)
					.clickSectionSubmit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return SectionName;
	}
	
	public String addSectionGetName()
	{
		String SectionName= "TC_Section_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source   	.PagesPage()
					.clickAdd()
					.SectionsAvailableAccord()
					.setSectionName(SectionName)
					.setSortOrder(OneN);
		return SectionName;
	}

}
