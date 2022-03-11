package com.eisrem.pageFactory.People;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.AddressPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.DocumentsPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Reports.ReportsPage;
import com.eisrem.testCases.Module_People.PeoplePageTest;

public class PeopleNavigator extends DataTable{

	public PeopleNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='7_People_tab']")
	public WebElement PeopleTab;
	
	@FindBy(xpath="//li[@id='30_Associations_tab']")
	public WebElement AssociationsTab;
	
	@FindBy(xpath="//li[@id='33_Demographics_tab']")
	public WebElement DemographicsTab;
	
	@FindBy(xpath="//li[@id='8_Address_tab']")
	public WebElement AddressTab;
	
	@FindBy(xpath="//li[@id='10_Identifier_tab']")
	public WebElement IdentifierTab;
	
	@FindBy(xpath="//li[@id='11_EnrollmentStatus_tab']")
	public WebElement EnrollmentStatusTab;
	
	@FindBy(xpath="//li[@id='12_CriticalInformation_tab']")
	public WebElement CriticalInformationTab;
	
	@FindBy(xpath="//li[@id='18_Relationships_tab']")
	public WebElement RelationshipsTab;
	
	@FindBy(xpath="//li[@id='14_OtherNames_tab']")
	public WebElement OtherNamesTab;
	
	@FindBy(xpath="//li[@id='9_LivArrangement_tab']")
	public WebElement LivingArrangementTab;
	
	@FindBy(xpath="//li[@id='17_Diagnosis_tab']")
	public WebElement DiagnosisTab;
	
	@FindBy(xpath="//li[@id='40_ClassHistory_tab']")
	public WebElement ClassesTab;
	
	@FindBy(xpath="//li[@id='42_PeoplePayments_tab']")
	public WebElement PaymentsTab;
	
	@FindBy(xpath="//li[@id='45_Documents_tab']")
	public WebElement DocumentsTab;
	
	@FindBy(xpath="//li[@id='48_Language_tab']")
	public WebElement LanguageTab;
	
	@FindBy(xpath="//li[@id='49_RaceEthnicityOther_tab']")
	public WebElement RaceEthinicityTab;
	
	@FindBy(xpath="//li[@id='50_ResidentialPlacement_tab']")
	public WebElement ResidentialPlacementTab;
	
	
	public String readPeopleTab() {
		return Source.SeleniumHelper().readElement(PeopleTab);
	}
	
	public PeoplePage clickPeopleTab() {
		Source.SeleniumHelper().clickElement(PeopleTab);
		return new PeoplePage(DriverFactory.getDriver());
	}
	
	public String readAssociationsTab() {
		return Source.SeleniumHelper().readElement(AssociationsTab);
	}
	
	public AssociationsPage clickAssociationsTab() {
		Source.SeleniumHelper().clickElement(AssociationsTab);
		return new AssociationsPage(DriverFactory.getDriver());
	}
	
	public String readDemographicsTab() {
		return Source.SeleniumHelper().readElement(DemographicsTab);
	}
	
	public DemographicsPage clickDemographicsTab() {
		Source.SeleniumHelper().clickElement(DemographicsTab);
		return new DemographicsPage(DriverFactory.getDriver());
	}
	
	public String readAddressTab() {
		return Source.SeleniumHelper().readElement(AddressTab);
	}
	
	public AddressPage clickAddressTab() {
		Source.SeleniumHelper().clickElement(AddressTab);
		return new AddressPage(DriverFactory.getDriver());
	}
	
	public String readIdentifierTab() {
		return Source.SeleniumHelper().readElement(IdentifierTab);
	}
	
	public IdentifiersPage clickIdentifierTab() {
		Source.SeleniumHelper().clickElement(IdentifierTab);
		return new IdentifiersPage(DriverFactory.getDriver());
	}
	
	public String readEnrollmentStatusTab() {
		return Source.SeleniumHelper().readElement(EnrollmentStatusTab);
	}
	
	public EnrollmentStatusPage clickEnrollmentStatusTab() {
		Source.SeleniumHelper().clickElement(EnrollmentStatusTab);
		return new EnrollmentStatusPage(DriverFactory.getDriver());
	}
	
	public String readCriticalInformationTab() {
		return Source.SeleniumHelper().readElement(CriticalInformationTab);
	}
	
	public CriticalInformationPage clickCriticalInformationTab() {
		Source.SeleniumHelper().clickElement(CriticalInformationTab);
		return new CriticalInformationPage(DriverFactory.getDriver());
	}
	
	public String readRelationshipsTab() {
		return Source.SeleniumHelper().readElement(RelationshipsTab);
	}
	
	public RelationshipsPage clickRelationshipsTab() {
		Source.SeleniumHelper().clickElement(RelationshipsTab);
		return new RelationshipsPage(DriverFactory.getDriver());
	}
	
	public String readOtherNamesTab() {
		return Source.SeleniumHelper().readElement(OtherNamesTab);
	}
	
	public RelationshipsPage clickOtherNamesTab() {
		Source.SeleniumHelper().clickElement(OtherNamesTab);
		return new RelationshipsPage(DriverFactory.getDriver());
	}
	
	public String readLivingArrangementTab() {
		return Source.SeleniumHelper().readElement(LivingArrangementTab);
	}
	
	public LivingArrangementPage clickLivingArrangementTab() {
		Source.SeleniumHelper().clickElement(LivingArrangementTab);
		return new LivingArrangementPage(DriverFactory.getDriver());
	}
	
	public String readDiagnosisTab() {
		return Source.SeleniumHelper().readElement(DiagnosisTab);
	}
	
	public String readResidentialPlacementTab() {
		return Source.SeleniumHelper().readElement(ResidentialPlacementTab);
	}
	
	public DiagnosisPage clickDiagnosisTab() {
		Source.SeleniumHelper().clickElement(DiagnosisTab);
		return new DiagnosisPage(DriverFactory.getDriver());
	}
	
	public String readClassesTab() {
		return Source.SeleniumHelper().readElement(ClassesTab);
	}
	
	public ClassesPage clickClassesTab() {
		Source.SeleniumHelper().clickElement(ClassesTab);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
	public String readPaymentsTab() {
		return Source.SeleniumHelper().readElement(PaymentsTab);
	}
	
	public PaymentsPage clickPaymentsTab() {
		Source.SeleniumHelper().clickElement(PeopleTab);
		return new PaymentsPage(DriverFactory.getDriver());
	}
	
	public String readDocumentsTab() {
		return Source.SeleniumHelper().readElement(DocumentsTab);
	}
	
	public DocumentsPage clickDocumentsTab() {
		Source.SeleniumHelper().clickElement(DocumentsTab);
		return new DocumentsPage(DriverFactory.getDriver());
	}
	
	public String readLanguageTabTitle() {
		return Source.SeleniumHelper().readElement(LanguageTab);
	}
	
	public LanguagePage clickLanguageTab() {
		Source.SeleniumHelper().clickElement(LanguageTab);
		return new LanguagePage(DriverFactory.getDriver());
	}
	
	public String readRaceEthinicityTabTitle() {
		return Source.SeleniumHelper().readElement(RaceEthinicityTab);
	}
	
	public RaceEthnicityPage clickRaceEthinicityTab() {
		Source.SeleniumHelper().clickElement(RaceEthinicityTab);
		return new RaceEthnicityPage(DriverFactory.getDriver());
	}
	
	public ResidentialPlacementPage clickResidentialPlacementTab() {
		Source.SeleniumHelper().clickElement(ResidentialPlacementTab);
		return new ResidentialPlacementPage(DriverFactory.getDriver());
	}
	
}
