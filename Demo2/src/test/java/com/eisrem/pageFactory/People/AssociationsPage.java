package com.eisrem.pageFactory.People;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;


public class AssociationsPage extends PeopleNavigator{

	public AssociationsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Add Association')]")
	public WebElement AddAssociationTitle;	

	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;

	@FindBy(xpath="//a[contains(text(),'Association Info:')]")
	public WebElement AssociationInfoLink;

	@FindBy(xpath="//label[@for='assctn-startdate']")
	public WebElement StartDateTitle;

	@FindBy(xpath="//input[@id='assctn-startdate']")
	public WebElement StartDateTextBox;

	@FindBy(xpath="//label[@for='assctn-enddate']")
	public WebElement EndDateTitle;

	@FindBy(xpath="//input[@id='assctn-enddate']")
	public WebElement EndDateTextBox;

	@FindBy(xpath="//label[@for='assctn-type']")
	public WebElement AssociationTypeTitle;

	@FindBy(xpath="//select[@id='assctn-type']")
	public WebElement AssociationTypeDropDown;

	@FindBy(xpath="//label[@for='assctn-spop']")
	public WebElement ServicePopulationTitle;

	@FindBy(xpath="//select[@id='assctn-spop']")
	public WebElement ServicePopulationDropDown;

	@FindBy(xpath="//select[@id='assctn-org-pop']")
	public WebElement ServicePopulationsTextBox;
	
	@FindBy(xpath="//select[@id='assctn-title']")
	public WebElement IndividualTitleTextBox;

	@FindBy(xpath="//label[contains(text(),'Organization')]")
	public WebElement OrganizationTitle;

	@FindBy(xpath="//input[@id='assctn-org-combobox']")
	public WebElement OrganizationTextBox;
		
	@FindBy(xpath="//input[@id='assctn-indvdl-combobox']")
	public WebElement IndividualTextBox;

	@FindBy(xpath="//label[@for='assctn-desc']")
	public WebElement DescriptionTitle;

	@FindBy(xpath="//textarea[@id='assctn-desc']")
	public WebElement DescriptionTextBox;

	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;

	@FindBy(xpath="//button[contains(text(),'Back To Association')]")
	public WebElement BackToAssociationBtn;

	@FindBy(xpath="//button[contains(text(),'OK')]")
	public WebElement OkBtn;

	@FindBy(xpath="//*[@id='assctn-org-container']/div/div/ul/li")
	public List<WebElement> OrganizationSearchList;
	
	@FindBy(xpath="//*[@id='assctn-indvdl-container']/div/div/ul/li")
	public List<WebElement> IndividualSearchList;

	public String readAddAssociationTitle() {
		return Source.SeleniumHelper().readElement(AddAssociationTitle);
	}

	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}

	public String readAssociationInfoLinkTitle() {
		return Source.SeleniumHelper().readElement(AssociationInfoLink);
	}

	public AssociationsPage clickAssociationInfoLink() {
		Source.SeleniumHelper().clickElement(AssociationInfoLink);
		return new AssociationsPage(DriverFactory.getDriver());
	}

	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}

	public AssociationsPage setStartDateTitle(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, date, Clear);
		return this;
	}

	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}

	public AssociationsPage setEndDateTTextBox(String date, String... Clear) {
		Source.SeleniumHelper().setText(EndDateTextBox, date, Clear);
		return this;
	}

	public String readAssociationTypeTitle() {
		return Source.SeleniumHelper().readElement(AssociationTypeTitle);
	}

	public AssociationsPage selectAssociationType(int Association) {
		Source.SeleniumHelper().select(AssociationTypeDropDown, Association);
		return this;
	}
	
	public AssociationsPage selectAssociationType(String Association) {
		Source.SeleniumHelper().select(AssociationTypeDropDown, Association);
		return this;
	}

	public AssociationsPage selectServicePopulation(String servPop) {
		Source.SeleniumHelper().select(ServicePopulationDropDown, servPop);	
		return this;
	}

	public String readOrganizationTitle() {
		return Source.SeleniumHelper().readElement(OrganizationTitle);
	}

	public AssociationsPage setOrganization(String organization, String... Clear) {
		Source.SeleniumHelper().setText(OrganizationTextBox, organization, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().clickElement(By.cssSelector("#assctn-org-container > div > div > ul > li > a"));
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public AssociationsPage setOrganizationAssociation(String partialName,String organization, String... Clear) {
		Source.SeleniumHelper().setText(OrganizationTextBox, partialName, Clear);	
		Source.SeleniumHelper().clickElement(By.linkText(organization));
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public AssociationsPage setOrganizationAssociationNoSelect(String text, String... Clear) {
		Source.SeleniumHelper().setText(OrganizationTextBox, text, Clear);	
		return this;
	}
	
	public AssociationsPage setOrganizationAssociation(String partialName,int position, String... Clear) {
		By xpath = By.xpath("//ul[@class='typeahead typeahead-long dropdown-menu']/li[" + position + "]");
		Source.SeleniumHelper().setText(OrganizationTextBox, partialName, Clear);	
		Source.SeleniumHelper().clickElement(xpath);
		return this;
	}
	
	public AssociationsPage setIndividual(String individual, String... Clear) {
		Source.SeleniumHelper().setText(IndividualTextBox, individual, Clear);	
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().clickElement(By.cssSelector("#assctn-indvdl-container > div > div > ul > li > a"));
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	
	public String isOrgAssociationInDropdown(String comparisonText, String searchTerm)
	{
		return Boolean.toString(Source.SeleniumHelper().isInComboboxBySimilarText(OrganizationTextBox, OrganizationSearchList, comparisonText, searchTerm));
	}
	
	public String isPeopleAssociationInDropdown(String comparisonText, String searchTerm)
	{
		return Boolean.toString(Source.SeleniumHelper().isInComboboxBySimilarText(IndividualTextBox, IndividualSearchList, comparisonText, searchTerm));
	}

	public AssociationsPage setServicePopulationConfirmation(String servicePopulation, String... Clear) {
		Source.SeleniumHelper().setText(ServicePopulationsTextBox, servicePopulation, Clear);	
		return this;
	}

	public String readServicePopulationTitle() {
		return Source.SeleniumHelper().readElement(ServicePopulationTitle);
	}
	
	public AssociationsPage setIndividualTitle(String title, String... Clear) {
		Source.SeleniumHelper().setText(IndividualTitleTextBox, title, Clear);	
		return this;
	}

	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}

	public AssociationsPage setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description, Clear);
		return this;
	}

	public String readBackToAssociationBtn() {
		return Source.SeleniumHelper().readElement(BackToAssociationBtn);
	}

	public AssociationsPage clickBackToAssociation() {
		Source.SeleniumHelper().clickElement(BackToAssociationBtn);
		return this;
	}
	
	public boolean checkIfBaseLocsIsFirst() {
		List<String> orgValues = new ArrayList<String>();
		for(WebElement i: OrganizationSearchList) {
			orgValues.add(i.getText());
		}
		
		String baseId=null;
		for(String value : orgValues ) {

			if(value.endsWith("BASE")) {
				baseId=value.split(" ")[0];
			}
				else if (value.endsWith("OTHER_LOCATION")) {
					String other=value.split(" ")[0];
					if(baseId!=null && !baseId.equals(other)) {
						return false;
				}
			}
		}
			
		return true;
	}

//	public boolean checkIfBaseLocsIsFirst() {
//		int listSize = OrganizationSearchList.size();
//		System.out.println(listSize);
//		
//		List<String> orgValues = new ArrayList<String>();
//		for(WebElement i: OrganizationSearchList) {
//			orgValues.add(i.getText());
//		}	
//		
//		for(String i: orgValues) {
//			System.out.println(i);
//		}
//		
//		List<String> baseId = new ArrayList<String>();
//		List<String> otherId = new ArrayList<String>();
//		int baseCounter = 0; 
//		int otherCounter = 0; 
//		
//		for(String i: orgValues) {
//			if(i.endsWith("BASE")) {
//				baseId.add(i.split(" ")[0]);
//				baseCounter++;
//			}
//			else if(i.endsWith("OTHER_LOCATION")) {
//				otherId.add(i.split(" ")[0]);	
//				otherCounter++;
//				if(baseId!=null && !baseId.equals(otherId)) {
//					return false;
//				}
//			}
//			
//		}
//
//		return true;
//	}

	public AssociationsPage addCompleteAssociationAndSubmit(String peoSearchTerm, String startDate, String endDate, AssociationType type, 
			String indSearchTerm, String orgSearchTerm, ServicePopulations servPop, IndividualTitle title, String description) {
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab().clickAdd();
		Source.AssociationsPage().selectAssociationType(type.getName());
		
		switch(type)
		{
			case INDIVIDUAL:
				Source.AssociationsPage().setIndividual(indSearchTerm == null ? TestClient : indSearchTerm);
				Source.AssociationsPage().setIndividualTitle(title == IndividualTitle.NULL ? IndividualTitle.ADVOCATE_STATE.getName() : title.getName());
				break;
			case ORGANIZATION:
				Source.AssociationsPage().setOrganization(orgSearchTerm == null ? OrganizationName : orgSearchTerm);
				break;
			case SERVICE_POPULATION:
			default:
				Source.AssociationsPage().setServicePopulationConfirmation(servPop == ServicePopulations.NULL ? ServicePopulations.CHILDRENS.getName() :servPop.getName());
				break;
		}
		
		Source	.AssociationsPage().setStartDateTitle(startDate == null ? Today : startDate, EmptyString)
				.setEndDateTTextBox(endDate == null ? EmptyString : endDate, EmptyString)
				.setDescription(description == null ? Description : description);
		
		Source	.AssociationsPage().clickSubmit().clickPopupOk();
		return this;
	}
	
	public AssociationsPage addCompleteAssociationAndSubmit(String peoSearchTerm) {
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab().clickAdd();
		Source.AssociationsPage().selectAssociationType(AssociationType.SERVICE_POPULATION.getName())
								 .selectServicePopulation(ServicePopulations.CHILDRENS.getName());
		Source	.AssociationsPage().clickSubmit().clickPopupOk();
		return this;
	}
	
	public AssociationsPage addCompleteAssociation(String peoSearchTerm, String startDate, String endDate, AssociationType type, 
			String indSearchTerm, String orgSearchTerm, ServicePopulations servPop, IndividualTitle title, String description) {
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab().clickAdd();
		Source.AssociationsPage().selectAssociationType(type.getName());
		
		switch(type)
		{
			case INDIVIDUAL:
				Source.AssociationsPage().setIndividual(indSearchTerm == null ? TestClient : indSearchTerm);
				Source.AssociationsPage().setIndividualTitle(title == IndividualTitle.NULL ? IndividualTitle.ADVOCATE_STATE.getName() : title.getName());
				break;
			case ORGANIZATION:
				Source.AssociationsPage().setOrganization(orgSearchTerm == null ? OrganizationName : orgSearchTerm);
				break;
			case SERVICE_POPULATION:
			default:
				Source.AssociationsPage().setServicePopulationConfirmation(servPop == ServicePopulations.NULL ? ServicePopulations.CHILDRENS.getName() :servPop.getName());
				break;
		}
		
		Source	.AssociationsPage().setStartDateTitle(startDate == null ? Today : startDate, EmptyString)
				.setEndDateTTextBox(endDate == null ? EmptyString : endDate, EmptyString)
				.setDescription(description == null ? Description : description);
		return this;
	}
	
	public String addCompleteAssociationSubmitAndReturnId(String peoSearchTerm, String startDate, String endDate, AssociationType type, 
			String indSearchTerm, String orgSearchTerm, ServicePopulations servPop, IndividualTitle title, String description) {
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab().clickAdd();
		Source.AssociationsPage().selectAssociationType(type.getName());
		
		switch(type)
		{
			case INDIVIDUAL:
				Source.AssociationsPage().setIndividual(indSearchTerm == null ? TestClient : indSearchTerm);
				Source.AssociationsPage().setIndividualTitle(title == IndividualTitle.NULL ? IndividualTitle.ADVOCATE_STATE.getName() : title.getName());
				break;
			case ORGANIZATION:
				Source.AssociationsPage().setOrganization(orgSearchTerm == null ? OrganizationName : orgSearchTerm);
				break;
			case SERVICE_POPULATION:
			default:
				Source.AssociationsPage().setServicePopulationConfirmation(servPop == ServicePopulations.NULL ? ServicePopulations.CHILDRENS.getName() :servPop.getName());
				break;
		}
		
		Source	.AssociationsPage().setStartDateTitle(startDate == null ? Today : startDate, EmptyString)
				.setEndDateTTextBox(endDate == null ? EmptyString : endDate, EmptyString)
				.setDescription(description == null ? Description : description);
		
		return Source	.AssociationsPage().clickSubmit().clickPopupOk().DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}
	
	public String addCompleteAssociationSubmitAndReturnId(String peoSearchTerm) {
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab().clickAdd();
		Source.AssociationsPage().selectAssociationType(AssociationType.SERVICE_POPULATION.getName())
								 .selectServicePopulation(ServicePopulations.CHILDRENS.getName());
		Source	.AssociationsPage().clickSubmit().clickPopupOk();
		return Source	.AssociationsPage().clickSubmit().clickPopupOk().DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}
	
	public AssociationsPage endDateAssociation(String peoSearchTerm, String associationSearchTerm)
	{
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab();
		Source.DataTable().setSearch(associationSearchTerm == null ? TestClient : associationSearchTerm, EmptyString).clickEdit();
		Source.AssociationsPage().setEndDateTTextBox(Today, EmptyString).clickSubmit().clickPopupOk();
		return this;
	}
	
	public AssociationsPage endDateAssociation(String peoSearchTerm, String associationSearchTerm, String endDate)
	{
		Source.NavigationMenuBar().clickPeople().setSearch(peoSearchTerm == null ? TestClient : peoSearchTerm, EmptyString).clickFirstRow().clickAnchor().PeopleNavigator().clickAssociationsTab();
		Source.DataTable().setSearch(associationSearchTerm == null ? TestClient : associationSearchTerm, EmptyString).clickEdit();
		Source.AssociationsPage().setEndDateTTextBox(endDate == null ? Today : endDate, EmptyString).clickSubmit().clickPopupOk();
		return this;
	}
	
	
	
}
