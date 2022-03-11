package com.eisrem.pageFactory.Admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.People.PeoplePage;
import com.eisrem.pageFactory.Administrator.TypesPage;
import com.eisrem.pageFactory.Agreement.AgreementPage;
import com.eisrem.pageFactory.Assessment_Forms.Assessment_FormsPage;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;
import com.eisrem.pageFactory.Organization.OrganizationPage;
import com.eisrem.pageFactory.QuickLinks.QuickLinksPage;
import com.eisrem.pageFactory.Reports.ReportsPage;
import com.eisrem.pageFactory.Search.SearchPage;
import org.testng.asserts.SoftAssert;

import edu.emory.mathcs.backport.java.util.Arrays;

public class NavigationMenuBar extends DataTable{

	public NavigationMenuBar(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@data-aria-label =\"User menu\"]")
	public WebElement WelcomeUserDropdown;

	@FindBy(xpath="//a[@href='javascript:changePassword()']")
	public WebElement ChangePasswordLink;
	
	@FindBy(xpath="//ul[contains(@class, 'dropdown-menu dropdown-user')]//li[2]")
	public WebElement LogOutLink;

	@FindBy(xpath="//h4[contains(text(),'App Areas')]")
	public WebElement AppAreas;

	@FindBy(xpath="//a[@id='14']")
	public WebElement MyHomePageLink;

	@FindBy(xpath="//a[@id='5']")
	public WebElement ReportsLink;

	@FindBy(xpath="//a[@id='13']")
	public WebElement ProcessWizardLink;

	@FindBy(xpath="//a[@id='4']")
	public WebElement PeopleLink;

	@FindBy(xpath="//a[@id='2']")
	public WebElement OrganizationLink;

	@FindBy(xpath="//a[@id='6']")
	public WebElement AssessmentFormsLink;

	@FindBy(xpath="//a[@id='10']")
	public WebElement AuthorizationLink;

	@FindBy(xpath="//a[@id='7']")
	public WebElement NotesLink;

	@FindBy(xpath="//a[@id='1']")
	public WebElement PlanningLink;

	@FindBy(xpath="//a[@id='8']")
	public WebElement ReportableEventLink;

	@FindBy(xpath="//a[@id='21']")
	public WebElement SearchLink;

	@FindBy(xpath="//a[@id='15']")
	public WebElement AgreementLink;

	@FindBy(xpath="//a[@id='18']")
	public WebElement ClassesLink;

	@FindBy(xpath="//a[@id='23']")
	public WebElement QuickLinks;

	@FindBy(xpath="//a[@id='3']")
	public WebElement AdministratorLink;
	
	@FindBy(xpath="//ul[@id='side-menu']//li")
	public String AvaiableLinks = "//ul[@id='side-menu']//li";

	public String readWelcomeUserDropdown() {
		return Source.SeleniumHelper().readElement(WelcomeUserDropdown);
	}

	public NavigationMenuBar clickWelcomeUser() {
		Source.SeleniumHelper().clickElement(WelcomeUserDropdown);
		return this;
	}	

	public String readChangePasswordLink() {
		return Source.SeleniumHelper().readElement(ChangePasswordLink);
	}

	public NavigationMenuBar clickChangePassword() {
		Source.SeleniumHelper().clickElement(ChangePasswordLink);
		return this;
	}
	
	public String readLogOutLink() {
		return Source.SeleniumHelper().readElement(LogOutLink);
	}

	public LogInPage clickLogOut() {
		Source.SeleniumHelper().clickElement(LogOutLink);
		return new LogInPage(DriverFactory.getDriver());
	}

	public String readAppAreasTitle() {
		return Source.SeleniumHelper().readElement(AppAreas);
	}

	public String readMyHomePageTitle() {
		return Source.SeleniumHelper().readElement(MyHomePageLink);
	}

	public MyHomePage clickMyHomePage() {
		Source.SeleniumHelper().clickElement(MyHomePageLink);
		return new MyHomePage(DriverFactory.getDriver());
	}

	public String readReports() {
		return Source.SeleniumHelper().readElement(ReportsLink);
	}

	public ReportsPage clickReports() {
		Source.SeleniumHelper().clickElement(ReportsLink);
		return new ReportsPage(DriverFactory.getDriver());
	}

	public String readProcessWizardTitle() {
		return Source.SeleniumHelper().readElement(ProcessWizardLink);
	}

	public String readPeopleTitle() {
		return Source.SeleniumHelper().readElement(PeopleLink);
	}

	public PeoplePage clickPeople() {
		Source.SeleniumHelper().clickElement(PeopleLink);
		return new PeoplePage(DriverFactory.getDriver());
	}

	public String readOrganizationTitle() {
		return Source.SeleniumHelper().readElement(OrganizationLink);
	}

	public OrganizationPage clickOrganization() {
		Source.SeleniumHelper().clickElement(OrganizationLink);
		return new OrganizationPage(DriverFactory.getDriver());
	}

	public Assessment_FormsPage clickAssessmentForms() {
		Source.SeleniumHelper().clickElement(AssessmentFormsLink);
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}
	
	public String readAssessmentFormsLink() {
		return Source.SeleniumHelper().readElement(AssessmentFormsLink);
	}

	public String readAuthorization() {
		return Source.SeleniumHelper().readElement(AuthorizationLink);
	}
	
	public Assessment_FormsPage clickAuthorization() {
		Source.SeleniumHelper().clickElement(AuthorizationLink);
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}

	public String readNotesLink() {
		return Source.SeleniumHelper().readElement(NotesLink);
	}
	
	public Assessment_FormsPage clickNotes() {
		Source.SeleniumHelper().clickElement(NotesLink);
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}

	public String readReportableEventLink() {
		return Source.SeleniumHelper().readElement(ReportableEventLink);
	}
	
	public Assessment_FormsPage clickReportableEvent() {
		Source.SeleniumHelper().clickElement(ReportableEventLink);
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}

	public String readPlanningLink() {
		return Source.SeleniumHelper().readElement(PlanningLink);
	}
	
	public Assessment_FormsPage clickPlanning() {
		Source.SeleniumHelper().clickElement(PlanningLink);
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}

	public String readSearchLink() {
		return Source.SeleniumHelper().readElement(SearchLink);
	}

	public SearchPage clickSearch() {
		Source.SeleniumHelper().clickElement(SearchLink);
		return new SearchPage(DriverFactory.getDriver());
	}

	public String readAgreementLink() {
		return Source.SeleniumHelper().readElement(AgreementLink);
	}

	public AgreementPage clickAgreement() {
		Source.SeleniumHelper().clickElement(AgreementLink);
		return new AgreementPage(DriverFactory.getDriver());
	}

	public String readClassesLink() {
		return Source.SeleniumHelper().readElement(ClassesLink);
	}

	public ClassesPage clickClasses() {
		Source.SeleniumHelper().clickElement(ClassesLink);
		return new ClassesPage(DriverFactory.getDriver());
	}

	public String readQuickLinksLink() {
		return Source.SeleniumHelper().readElement(QuickLinks);
	}

	public QuickLinksPage clickQuickLinks() {
		Source.SeleniumHelper().clickElement(QuickLinks);
		return new QuickLinksPage(DriverFactory.getDriver());
	}

	public String readAdministratorLink() {
		return Source.SeleniumHelper().readElement(AdministratorLink);
	}

	public TypesPage clickAdministrator() {
		Source.SeleniumHelper().clickElement(AdministratorLink);
		return new TypesPage(DriverFactory.getDriver());
	}
	
	public LogInPage LogOut() {
		 clickWelcomeUser()
		.clickLogOut();
		return new LogInPage(DriverFactory.getDriver());
	}
	
	//Will verify user access to available application. Requires array of applications including "App Areas" as first application. 
	//Ex. String [] AppList = {AppAreas, My_HomepageApp, PeopleApp, OrganizationApp, NotesApp};
	public NavigationMenuBar VerifyModuleAccess(String [] List ) {
		SoftAssert = new SoftAssert();
		@SuppressWarnings("unchecked")
		List<String> Value = Arrays.asList(List);
		List<WebElement> Values = DriverFactory.getDriver().findElements(By.xpath(AvaiableLinks));
		int ActualModuleSize = Values.size();
		try {
			int x = 0;
			for(WebElement i: Values) {
				Actual = Source.SeleniumHelper().readElement(i);
				Expected = Value.get(x);
				if(Actual.equals(Expected)) {
					SoftAssert.assertEquals(Actual, Expected);
				}else {
					SoftAssert.assertEquals(Actual, Expected);
				}
				
				x++;
			}
		}catch(Exception e){
			Log.info("User does not have the proper module access");
			Log.info("Expected number of values: " + Value.size());
			Log.info("Actual number of values: " + ActualModuleSize);
		}finally {
			SoftAssert.assertAll();
		}
		
		return new NavigationMenuBar(DriverFactory.getDriver());
	}
	
}
