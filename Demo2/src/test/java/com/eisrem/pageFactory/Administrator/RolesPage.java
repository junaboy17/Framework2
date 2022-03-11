package com.eisrem.pageFactory.Administrator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;

public class RolesPage extends AdministratorNavigator{

	public RolesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	ObjectSource Source = new ObjectSource();

	@FindBy(xpath="//h3[contains(text(),'Add Role')]")
	public WebElement AddRolePageTitle;

	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;

	//Role Info link begins

	@FindBy(xpath="//a[contains(text(),'Role Info:')]")
	public WebElement RoleInfoAccord;

	@FindBy(xpath="//label[@for='roleName']")
	public WebElement RoleNameTitle;

	@FindBy(xpath="//input[@id='roleName']")
	public WebElement RoleNameTextbox;

	@FindBy(xpath="//input[@id='roleName']")
	public WebElement RoleNameTextBox;

	@FindBy(xpath="//label[contains(text(),'Description')]")
	public WebElement RoleDescriptionTitle;

	@FindBy(xpath="//textarea[@id='AddRolesDesc']")
	public WebElement RoleDescriptionTextBox;

	@FindBy(xpath="//label[contains(text(),'View All')]")
	public WebElement ViewAllClientsToggleTitle;

	@FindBy(xpath="//label[contains(text(),'View All')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement ViewAllClientsToggle;

	@FindBy(xpath="//label[contains(text(),'View All')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement ViewAllClientsToggleAttribute;

	//App Area Link begins

	@FindBy(xpath="//a[contains(text(),'App Area:')]")
	public WebElement AppAreaLink;

	@FindBy(xpath="//div[@id= 'roles_app_table_length']//label")
	public WebElement AppAreaShowEntries;

	@FindBy(xpath="//select[@aria-controls='roles_app_table']")
	public WebElement AppAreaShowEntriesDropdown;

	@FindBy(xpath="//div[@id='roles_app_table_info']")
	public WebElement AppAreaShowNoOfEntries;

	@FindBy(xpath="//div[@id='roles_app_table_filter'] //label")
	public WebElement AppAreaSearchTitle;

	@FindBy(xpath="//input[@aria-controls='roles_app_table']")
	public WebElement AppAreaSearchTextBox;

	@FindBy(xpath="//th[@aria-controls='roles_app_table'] [text()='App Name']")
	public WebElement AppAreaAppNameList;

	@FindBy(xpath="//th[@aria-controls='roles_app_table'] [text()='Active']")
	public WebElement AppAreaActiveList;

	@FindBy(xpath="//tbody/tr[1]/td[1]")
	public WebElement AdministratorAppTitle;

	@FindBy(xpath="//tbody/tr[2]/td[1]")
	public WebElement AgreementAppTitle;

	@FindBy(xpath="//tbody/tr[3]/td[1]")
	public WebElement AssessmentFormsAppTitle;

	@FindBy(xpath="//tbody/tr[4]/td[1]")
	public WebElement AuthorizationAppTitle;

	@FindBy(xpath="//tbody/tr[5]/td[1]")
	public WebElement ClassesAppTitle;

	@FindBy(xpath="//tbody/tr[6]/td[1]")
	public WebElement MyHomepageAppTitle;

	@FindBy(xpath="//tbody/tr[7]/td[1]")
	public WebElement NotesAppTitle;

	@FindBy(xpath="//tbody/tr[8]/td[1]")
	public WebElement OrganizationAppTitle;

	@FindBy(xpath="//tbody/tr[9]/td[1]")
	public WebElement PeopleAppTitle;

	@FindBy(xpath="//tbody/tr[10]/td[1]")
	public WebElement PlanningAppTitle;

	@FindBy(xpath="//tbody/tr[1]/td[1]")
	public WebElement ProcessWizardAppTitle;

	@FindBy(xpath="//tbody/tr[2]/td[1]")
	public WebElement QuickLinksAppTitle;

	@FindBy(xpath="//tbody/tr[3]/td[1]")
	public WebElement ReportableEventAppTitle;

	@FindBy(xpath="//tbody/tr[4]/td[1]")
	public WebElement ReportsAppTitle;

	@FindBy(xpath="//tbody/tr[5]/td[1]")
	public WebElement SearchAppTitle;

	@FindBy(xpath="//a[@id='roles_app_table_previous']")
	public WebElement AppAreaPreviousBtn;

	@FindBy(xpath="//a[@id='roles_app_table_next']")
	public WebElement AppAreaNextBtn;


	//App Area Modules Link begins

	@FindBy(xpath="//a[contains(text(),'App Area Modules:')]")
	public WebElement AppAreaModulesAccord;

	@FindBy(xpath="//div[@id= 'roles_modules_table_length'] //label")
	public WebElement AppAreaModulesShowEntries;

	@FindBy(xpath="//select[@aria-controls='roles_modules_table']")
	public WebElement AppAreaModulesShowEntriesDropdown;

	@FindBy(xpath="//div[@id='roles_modules_table_filter']//label")
	public WebElement AppAreaModulesSearchTitle;

	@FindBy(xpath="//input[@aria-controls='roles_modules_table']")
	public WebElement AppAreaModulesSearchTextBox;

	@FindBy(xpath="//th[@aria-controls='roles_modules_table'] [text()='App Area']")
	public WebElement AppAreaModulesAppAreaList;

	@FindBy(xpath="//th[@aria-controls='roles_modules_table'] [text()='Modules']")
	public WebElement AppAreaModulesModulesList;

	@FindBy(xpath="//th[@aria-controls='roles_modules_table'] [text()='Active']")
	public WebElement AppAreaModulesActiveList;

	@FindBy(xpath="//th[@aria-controls='roles_modules_table'] [text()='Add']")
	public WebElement AppAreaModulesAddList;

	@FindBy(xpath="//th[@aria-controls='roles_modules_table'] [text()='View']")
	public WebElement AppAreaModulesViewList;

	@FindBy(xpath="//th[@aria-controls='roles_modules_table'] [text()='Edit']")
	public WebElement AppAreaModulesEditList;

	@FindBy(xpath="//a[@id='roles_modules_table_previous']")
	public WebElement AppAreaModulesPreviousBtn;

	@FindBy(xpath="//a[@id='roles_modules_table_next']")
	public WebElement AppAreaModulesNextBtn;

	@FindBy(xpath="//button[contains(text(),'Back To Roles')]")
	public WebElement BackToRolesBtn;

	public String readAddRolePageTitle() {
		return Source.SeleniumHelper().readElement(AddRolePageTitle);
	}

	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}

	public String readRoleInfoAccord() {
		return Source.SeleniumHelper().readElement(RoleInfoAccord);
	}

	public RolesPage clickRoleInfoAccord() {
		Source.SeleniumHelper().clickElement(RoleInfoAccord);
		return this;
	}

	public String readRoleNameTitle() {
		return Source.SeleniumHelper().readElement(RoleNameTitle);
	}

	public String readRoleDescriptionTitle() {
		return Source.SeleniumHelper().readElement(RoleDescriptionTitle);
	}

	public String readViewAllClientsToggleTitle() {
		return Source.SeleniumHelper().readElement(ViewAllClientsToggleTitle);
	}

	public RolesPage clickViewAllClientsToggle() {
		Source.SeleniumHelper().clickElement(ViewAllClientsToggle);
		return this;
	}

	public String readViewAllClientsToggle() {
		return ViewAllClientsToggleAttribute.getAttribute("last-val");
	}

	public RolesPage clickViewAllClientsToggle(String value) {
		String active = readViewAllClientsToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickViewAllClientsToggle();
		}
		return this;
	}


	public RolesPage setRoleName(String value, String... Clear) {
		Source.SeleniumHelper().setText(RoleNameTextbox, value, Clear);
		return this;
	}

	//App Area link begins

	public String readAppAreaLink() {
		return Source.SeleniumHelper().readElement(AppAreaLink);
	}

	public RolesPage clickAppAreaAccord() {
		Source.SeleniumHelper().clickElement(AppAreaLink);
		return new RolesPage(DriverFactory.getDriver());
	}

	public String readAppAreaShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(AppAreaShowEntries);
	}

	public RolesPage selectAppAreaShowEntries(int index) {
		Source.SeleniumHelper().select(AppAreaShowEntriesDropdown, index);
		return this;
	}

	public String readAppAreaSearchTitle() {
		return Source.SeleniumHelper().readElement(AppAreaSearchTitle);
	}

	public RolesPage setSearchAppArea(String value, String... Clear) {
		Source.SeleniumHelper().setText(AppAreaSearchTextBox, value, Clear);
		return this;
	}

	public RolesPage clickAppAreaAppNameList() {
		Source.SeleniumHelper().clickElement(AppAreaAppNameList);
		return this;
	}

	public String readAppAreaAppNameList() {
		return Source.SeleniumHelper().readElement(AppAreaAppNameList);
	}

	public RolesPage clickAppAreaActive() {
		Source.SeleniumHelper().clickElement(AppAreaActiveList);
		return this;
	}

	public String readAppAreaActiveList() {
		return Source.SeleniumHelper().readElement(AppAreaActiveList);
	}

	//Will interact with all toggles with given app name in app area
	public WebElement appToggleElement(String AppName) {
		String path = "//td[contains(text(),'" + AppName +"')]/..//div[contains(@class,'bootstrap-switch bootstrap')]";
		return Source.SeleniumHelper().getWebElement(By.xpath(path));
	}
	
	public WebElement appToggleElement(String AppName, boolean Input) {
		String path = "//td[contains(text(),'" + AppName +"')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input";
		return DriverFactory.getDriver().findElement(By.xpath(path));
	}

	public RolesPage clickAppToggle(String AppName) {
		Source.SeleniumHelper().clickElement(appToggleElement(AppName));
		return this;
	}

	public String readAppToggle(String AppName) {
		return appToggleElement(AppName, true).getAttribute("last-val");
	}

	public RolesPage clickAppToggle(String AppName, String reqValue) {
		String value = readAppToggle(AppName);

		if(reqValue.equalsIgnoreCase(value)) {

		}
		else {
			clickAppToggle(AppName);
		}
		return this;
	}
	//	

	public String readAdministratorAppTitle() {
		return Source.SeleniumHelper().readElement(AdministratorAppTitle).replace(" Select", "");
	}

	public String readAgreementAppTitle() {
		return Source.SeleniumHelper().readElement(AgreementAppTitle).replace(" Select", "");
	}

	public String readAssessmentFormsAppTitle() {
		return Source.SeleniumHelper().readElement(AssessmentFormsAppTitle).replace(" Select", "");
	}

	public String readAuthorizationAppTitle() {
		return Source.SeleniumHelper().readElement(AuthorizationAppTitle).replace(" Select", "");
	}

	public String readClassesAppTitle() {
		return Source.SeleniumHelper().readElement(ClassesAppTitle).replace(" Select", "");
	}

	public String readMyHomepageAppTitle() {
		return Source.SeleniumHelper().readElement(MyHomepageAppTitle).replace(" Select", "");
	}

	public String readNotesAppTitle() {
		return Source.SeleniumHelper().readElement(NotesAppTitle).replace(" Select", "");
	}

	public String readOrganizationAppTitle() {
		return Source.SeleniumHelper().readElement(OrganizationAppTitle).replace(" Select", "");
	}

	public String readPeopleAppTitle() {
		return Source.SeleniumHelper().readElement(PeopleAppTitle).replace(" Select", "");
	}

	public String readPlanningAppTitle() {
		return Source.SeleniumHelper().readElement(PlanningAppTitle).replace(" Select", "");
	}

	public String readProcessWizardAppTitle() {
		return Source.SeleniumHelper().readElement(ProcessWizardAppTitle).replace(" Select", "");
	}

	public String readQuickLinksAppTitle() {
		return Source.SeleniumHelper().readElement(QuickLinksAppTitle).replace(" Select", "");
	}

	public String readReportableEventAppTitle() {
		return Source.SeleniumHelper().readElement(ReportableEventAppTitle).replace(" Select", "");
	}

	public String readReportsAppTitle() {
		return Source.SeleniumHelper().readElement(ReportsAppTitle).replace(" Select", "");
	}

	public String readSearchAppTitle() {
		return Source.SeleniumHelper().readElement(SearchAppTitle).replace(" Select", "");
	}

	public RolesPage clickAppAreaPrevious() {
		Source.SeleniumHelper().clickElement(AppAreaPreviousBtn);
		return this;
	}

	public String readAppAreaPreviousBtn() {
		return Source.SeleniumHelper().readElement(AppAreaPreviousBtn);
	}

	public RolesPage clickAppAreaNext() {
		Source.SeleniumHelper().clickElement(AppAreaNextBtn);
		return this;
	}

	public String readAppAreaNextBtn() {
		return Source.SeleniumHelper().readElement(AppAreaNextBtn);
	}


	//App Area Modules link begins

	public String readAppAreaModulesLink() {
		return Source.SeleniumHelper().readElement(AppAreaModulesAccord);
	}

	public RolesPage clickAppAreaModulesAccord() {
		Source.SeleniumHelper().clickElement(AppAreaModulesAccord);
		return this;
	}

	public String readAppAreaModulesShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(AppAreaModulesShowEntries);
	}

	public RolesPage selectAppAreaModulesShowEntries(int index) {
		Source.SeleniumHelper().select(AppAreaModulesShowEntriesDropdown, index);
		return this;
	}

	public String readAppAreaModulesSearchTitle() {
		return Source.SeleniumHelper().readElement(AppAreaModulesSearchTitle);
	}

	public RolesPage setSearchAppAreaModules(String value, String... Clear) {
		Source.SeleniumHelper().setText(AppAreaModulesSearchTextBox, value, Clear);
		return this;
	}

	public RolesPage clickAppAreaModulesList() {
		Source.SeleniumHelper().clickElement(AppAreaModulesAppAreaList);
		return this;
	}

	public String readAppAreaModulesAppAreaList() {
		return Source.SeleniumHelper().readElement(AppAreaModulesAppAreaList);
	}

	public RolesPage clickAppAreaModulesModules() {
		Source.SeleniumHelper().clickElement(AppAreaModulesModulesList);
		return this;
	}

	public String readAppAreaModulesModulesList() {
		return Source.SeleniumHelper().readElement(AppAreaModulesModulesList);
	}

	public RolesPage clickAppAreaModulesActive() {
		Source.SeleniumHelper().clickElement(AppAreaModulesActiveList);
		return this;
	}

	public String readAppAreaModulesActiveList() {
		return Source.SeleniumHelper().readElement(AppAreaModulesActiveList);
	}

	public RolesPage clickAppAreaModulesAdd() {
		Source.SeleniumHelper().clickElement(AppAreaModulesAddList);
		return this;
	}

	public String readAppAreaModulesAddList() {
		return Source.SeleniumHelper().readElement(AppAreaModulesAddList);
	}

	public RolesPage clickAppAreaModulesView() {
		Source.SeleniumHelper().clickElement(AppAreaModulesViewList);
		return this;
	}

	public String readAppAreaModulesViewList() {
		return Source.SeleniumHelper().readElement(AppAreaModulesViewList);
	}

	public RolesPage clickAppAreaModulesEdit() {
		Source.SeleniumHelper().clickElement(AppAreaModulesEditList);
		return this;
	}

	public String readAppAreaModulesEditList() {
		return Source.SeleniumHelper().readElement(AppAreaModulesEditList);
	}

	public RolesPage clickAppAreaModulesPrevious() {
		Source.SeleniumHelper().clickElement(AppAreaModulesPreviousBtn);
		return this;
	}

	public String readAppAreaModulesPreviousBtn() {
		return Source.SeleniumHelper().readElement(AppAreaModulesPreviousBtn);
	}

	public RolesPage clickAppAreaModulesNext() {
		Source.SeleniumHelper().clickElement(AppAreaModulesNextBtn);
		return this;
	}

	public String readAppAreaModulesNextBtn() {
		return Source.SeleniumHelper().readElement(AppAreaModulesNextBtn);
	}

	//Will interact with all toggles with given app name in app area
	public WebElement moduleToggleElement(String Module, String Toggle) {
		String path = null;
		
		if(Toggle.equalsIgnoreCase("Active")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[3]//div[contains(@class,'bootstrap-switch bootstrap')]";
		}else if(Toggle.equalsIgnoreCase("Add")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[4]//div[contains(@class,'bootstrap-switch bootstrap')]";
		}else if (Toggle.equalsIgnoreCase("View")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[5]//div[contains(@class,'bootstrap-switch bootstrap')]";
		}else if (Toggle.equalsIgnoreCase("Edit")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[6]//div[contains(@class,'bootstrap-switch bootstrap')]";
		}else {
			Log.info("Invalid Module/Toggle");
		}
		
		return Source.SeleniumHelper().getWebElement(By.xpath(path));
	}
	
	public WebElement moduleToggleElement(String Module, String Toggle, boolean Input) {
		String path = null;
		
		if(Toggle.equalsIgnoreCase("Active")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[3]//div[contains(@class,'bootstrap-switch bootstrap')]//input";
		}else if(Toggle.equalsIgnoreCase("Add")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[4]//div[contains(@class,'bootstrap-switch bootstrap')]//input";
		}else if (Toggle.equalsIgnoreCase("View")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[5]//div[contains(@class,'bootstrap-switch bootstrap')]//input";
		}else if (Toggle.equalsIgnoreCase("Edit")) {
			path = "//td[contains(text(),'" + Module + "')]/..//td[6]//div[contains(@class,'bootstrap-switch bootstrap')]//input";
		}else {
			Log.info("Invalid Module/Toggle");
		}
		
		return DriverFactory.getDriver().findElement(By.xpath(path));
	}

	public RolesPage clickModuleToggle(String Module, String Toggle) {
		Source.SeleniumHelper().clickElement(moduleToggleElement(Module, Toggle));
		return this;
	}

	public String readModuleToggle(String Module, String Toggle) {
		return moduleToggleElement(Module, Toggle, true).getAttribute("last-val");
	}

	public RolesPage clickModuleToggle(String Module, String Toggle, String reqValue) {
		String value = readModuleToggle(Module, Toggle);

		if(reqValue.equalsIgnoreCase(value)) {

		}
		else {
			clickModuleToggle(Module, Toggle);
		}
		return this;
	}
	//

	public RolesPage clickBackToRoles() {
		Source.SeleniumHelper().clickElement(BackToRolesBtn);
		return new RolesPage(DriverFactory.getDriver());
	}

	public String readBackToRolesBtn() {
		return Source.SeleniumHelper().readElement(BackToRolesBtn);
	}		


}
