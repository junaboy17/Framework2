package com.eisrem.pageFactory.CommonPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.People.PeoplePage;

public class ConductedTypes extends DataTable{

	public ConductedTypes(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	//Add Assesment

	@FindBy(xpath="//select[@id='type']")
	public WebElement ConductedTypeDropDown;

	@FindBy(xpath="//select[@id='type']")
	public List<WebElement> ConductedTypeValues;

	@FindBy(xpath="//select[@id='user-loc']")
	public WebElement OrganizationDropDown;

	@FindBy(xpath="//input[@id='typeConductorName']")
	public WebElement TitleTextBox;

	@FindBy(xpath="//button[@id='startButton']")
	public WebElement StartAssessmentBtn;
	
	//------------------------------------------------------------------------------

	public ConductedTypes selectType(String assessmentType) {
		Source.SeleniumHelper().select(ConductedTypeDropDown, assessmentType);
		return this;
	}

	public ConductedTypes selectType(int assessmentType) {
		Source.SeleniumHelper().select(ConductedTypeDropDown, assessmentType);
		return this;
	}

	public ConductedTypes selectOrganization(int organization) {
		Source.SeleniumHelper().select(OrganizationDropDown, organization);
		return this;
	}
	
	public ConductedTypes selectOrganization(String organization) {
		Source.SeleniumHelper().select(OrganizationDropDown, organization);
		return this;
	}

	public ConductedTypes setTitle(String title, String... Clear) {
		Source.SeleniumHelper().setText(TitleTextBox, title, Clear);
		return this;
	}

	public FormPage clickStartAssessment() {
		Source.SeleniumHelper().clickElement(StartAssessmentBtn);
		return new FormPage(DriverFactory.getDriver());
	}
	public ConductedTypes addCompleteConductedTypeAndSubmit(ConductTypeOn conductOn, AppModule appModule, String peopleIdOrSearchTerm, String organizationIdOrSearchTerm, String locationIdOrSearchTerm, String startDate, String endDate,
			String type, String organization, String title, String description, boolean fillForm)
	{
		switch(conductOn)
		{
			case PEOPLE:
				Source.NavigationMenuBar().clickPeople().setSearch(peopleIdOrSearchTerm).clickFirstRow().clickAnchor();
				break;
			case ORGANIZATION:
				Source.NavigationMenuBar().clickOrganization().setSearch(organizationIdOrSearchTerm).clickFirstRow().clickAnchor();
				break;
			case LOCATION:
				Source.NavigationMenuBar().clickOrganization().setSearch(organizationIdOrSearchTerm).clickFirstRow().clickAnchor().OrganizationNavigator().clickLocations().setSearch(locationIdOrSearchTerm).clickFirstRow().clickAnchor();
				break;
			default:
				break;
		}
		
		switch(appModule)
		{
			case ASSESSMENT:
				Source.NavigationMenuBar().clickAssessmentForms().clickAdd();
				break;
			case NOTES:
				Source.NavigationMenuBar().clickNotes().clickAdd();
				break;
//			case PLANNING:
//				Source.NavigationMenuBar().clickPlanning().clickAdd();
//				break;
			case REPORTABLE_EVENT:
				Source.NavigationMenuBar().clickReportableEvent().clickAdd();
				break;
			default:
				break;
		}
		
		Source.DataTable().setStartDate(startDate == null ? Today : startDate, EmptyString).setEndDate(endDate == null ? EmptyString : endDate, EmptyString);
		
		if (type == null)
			selectType(1);
		else
			selectType(type);
		
		selectOrganization(organization == null ? "DHHS, CENTRAL OFFICE" : organization);
		setTitle(title == null ? ConductedTypeTitle : title);
		setDescription(description == null ? Description : description);
		
		Source.SeleniumHelper().sleep(1);
		
		clickStartAssessment();
		
		Source.SeleniumHelper().sleep(10);
		
		if(fillForm)
			Source.FormPage().fillFormWithRequired();
		
		Source.FormPage().clickSubmitAllPages().clickCTBackToList();
		
		return this;
	}
	
	//stays on form page
	public ConductedTypes addConductedTypeStayOnForm(ConductTypeOn conductOn, AppModule appModule, String peopleIdOrSearchTerm, String organizationIdOrSearchTerm, String locationIdOrSearchTerm, String startDate, String endDate,
			String type, String organization, String title, String description)
	{
		switch(conductOn)
		{
			case PEOPLE:
				Source.NavigationMenuBar().clickPeople().setSearch(peopleIdOrSearchTerm).clickFirstRow().clickAnchor();
				break;
			case ORGANIZATION:
				Source.NavigationMenuBar().clickOrganization().setSearch(organizationIdOrSearchTerm).clickFirstRow().clickAnchor();
				break;
			case LOCATION:
				Source.NavigationMenuBar().clickOrganization().setSearch(organizationIdOrSearchTerm).clickFirstRow().clickAnchor().OrganizationNavigator().clickLocations().setSearch(locationIdOrSearchTerm).clickFirstRow().clickAnchor();
				break;
			default:
				break;
		}
		
		switch(appModule)
		{
			case ASSESSMENT:
				Source.NavigationMenuBar().clickAssessmentForms().clickAdd();
				break;
			case NOTES:
				Source.NavigationMenuBar().clickNotes().clickAdd();
				break;
//			case PLANNING:
//				Source.NavigationMenuBar().clickPlanning().clickAdd();
//				break;
			case REPORTABLE_EVENT:
				Source.NavigationMenuBar().clickReportableEvent().clickAdd();
				break;
			default:
				break;
		}
		
		Source.DataTable().setStartDate(startDate == null ? Today : startDate, EmptyString).setEndDate(endDate == null ? EmptyString : endDate, EmptyString);
		
		if (type == null)
			selectType(1);
		else
			selectType(type);
		
		selectOrganization(organization == null ? "DHHS, CENTRAL OFFICE" : organization);
		setTitle(title == null ? ConductedTypeTitle : title);
		setDescription(description == null ? Description : description);
		clickStartAssessment();
		
		return this;
	}
}
