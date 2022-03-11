package com.eisrem.pageFactory.People;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.Enumerations.Identifier;
import com.eisrem.pageFactory.Admin.LogInPage;
import com.eisrem.pageFactory.Assessment_Forms.Assessment_FormsPage;
import com.eisrem.pageFactory.CommonPage.AddressPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.DocumentsPage;

public class PeoplePage extends PeopleNavigator{


	public PeoplePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@aria-controls = 'tableName']//span[contains(text(),'Anchor')]")
	public WebElement AnchorBtn;	

	public ObjectSource clickPeopleAnchor() {
		Source.SeleniumHelper().clickElement(AnchorBtn);
		return new ObjectSource();
	}
	
	public AssociationsPage AddPeople() {
		Source	.DataTable()
				.clickAdd()
				.DemographicsPage()
				.fillRequiredDemogrphics()
				.clickSubmit()
				.clickPopupOk();
		return new AssociationsPage(DriverFactory.getDriver());
	}
	
	public AssociationsPage AddPeople(String firstName, String lastName, Enumerations.Gender gender, String dateOfBirth) {
		Source	.DataTable()
				.clickAdd()
				.DemographicsPage()
				.fillRequiredDemogrphics(firstName,lastName, gender, dateOfBirth)
				.clickSubmit()
				.clickPopupOk();
		return new AssociationsPage(DriverFactory.getDriver());
	}

	public RaceEthnicityPage AddPeopleWithLanguage_Ethnicity() {
		Source	.DataTable()
				.clickAdd()
				.DemographicsPage()
				.fillRequiredDemogrphics()
				.clickSubmit()
				.clickPopupOk()
				.PeopleNavigator()
				.clickLanguageTab()
				.FillLanguage()
				.clickSubmit()
				.clickPopupOk()
				.PeopleNavigator()
				.clickRaceEthinicityTab()
				.FillRaceEthnicity()
				.clickSubmit()
				.clickPopupOk();
		return new RaceEthnicityPage(DriverFactory.getDriver());
	}
	
	public AssociationsPage AddPeopleWith_Identifier() {
		Source	.DataTable()
				.clickAdd()
				.DemographicsPage()
				.fillRequiredDemogrphicsWithIdentifier()
				.clickSubmit()
				.clickPopupOk();
		return new AssociationsPage(DriverFactory.getDriver());
	}
	
	public AssociationsPage AddPeopleWith_Identifier(String firstName, String lastName, Enumerations.Gender gender, String dateOfBirth, Identifier identifierType, String identifierNumber) {
		Source	.DataTable()
				.clickAdd()
				.DemographicsPage()
				.fillRequiredDemogrphicsWithIdentifier(firstName, lastName, gender, dateOfBirth, identifierType, identifierNumber)
				.clickSubmit()
				.clickPopupOk();
		return new AssociationsPage(DriverFactory.getDriver());
	}

	public RaceEthnicityPage AddPeopleWith_Identifier_Language_Ethnicity() {
		Source	.DataTable()
				.clickAdd()
				.DemographicsPage()
				.fillRequiredDemogrphics()
				.clickSubmit()
				.clickPopupOk()
				.PeopleNavigator()
				.clickLanguageTab()
				.FillLanguage()
				.clickSubmit()
				.clickPopupOk()
				.PeopleNavigator()
				.clickRaceEthinicityTab()
				.FillRaceEthnicity();
		return new RaceEthnicityPage(DriverFactory.getDriver());
	}
	
	public AddressPage AddAddress() {
		 Source 	.PeopleNavigator()
		 			.clickAddressTab()
		 			.AddAddress();
		return new AddressPage(DriverFactory.getDriver());
	}
	
	public String addPersonReturnId()
	{
		return Source.NavigationMenuBar().clickPeople().AddPeople().GetSource().PeopleNavigator().clickPeopleTab().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}

	public void endDateAndSubmit(String peopleSearchTerm) {
			Source	.NavigationMenuBar()
					.clickPeople()
					.setSearch(peopleSearchTerm == null ? FullName : peopleSearchTerm)
					.clickFirstRow()
					.clickEdit()
					.PeoplePage()
					.setEndDate(Today, Clear)
					.clickSubmit()
					.clickPopupOk();
	}
}
