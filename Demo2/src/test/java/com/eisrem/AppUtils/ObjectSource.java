package com.eisrem.AppUtils;

import com.eisrem.pageFactory.Admin.LogInPage;
import com.eisrem.pageFactory.Admin.LoginAssistance;
import com.eisrem.pageFactory.Admin.ForgotPasswordPage;
import com.eisrem.pageFactory.Admin.ForgotUsernamePage;
import com.eisrem.pageFactory.Admin.NavigationMenuBar;
import com.eisrem.pageFactory.Admin.PasswordChangePage;
import com.eisrem.pageFactory.Administrator.AdministratorNavigator;
import com.eisrem.pageFactory.Administrator.AdministratorMessagesPage;
import com.eisrem.pageFactory.Administrator.LookupsPage;
import com.eisrem.pageFactory.Administrator.NotificationsPage;
import com.eisrem.pageFactory.Administrator.PagesPage;
import com.eisrem.pageFactory.Administrator.RolesPage;
import com.eisrem.pageFactory.Administrator.TypesPage;
import com.eisrem.pageFactory.Agreement.AgreementNavigator;
import com.eisrem.pageFactory.Agreement.AgreementPage;
import com.eisrem.pageFactory.Assessment_Forms.Assessment_FormsPage;
import com.eisrem.pageFactory.Assessment_Forms.Assessment_FormsNavigator;
import com.eisrem.pageFactory.Authorization.AuthorizationNavigator;
import com.eisrem.pageFactory.Authorization.AuthorizationPage;
import com.eisrem.pageFactory.Classes.AttendancePage;
import com.eisrem.pageFactory.Classes.ClassesNavigator;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.Classes.OutcomePage;
import com.eisrem.pageFactory.Classes.RosterPage;
import com.eisrem.pageFactory.CommonPage.AddressPage;
import com.eisrem.pageFactory.CommonPage.ChangePasswordPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.DocumentsPage;
import com.eisrem.pageFactory.CommonPage.DocumentsUserPage;
import com.eisrem.pageFactory.CommonPage.FormPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.CommonPage.LabelsAvailableAccord;
import com.eisrem.pageFactory.CommonPage.MessageContentAccord;
import com.eisrem.pageFactory.CommonPage.Pagefactory;
import com.eisrem.pageFactory.CommonPage.PagesAvailableAccord;
import com.eisrem.pageFactory.CommonPage.QuestionsAvailableAccord;
import com.eisrem.pageFactory.CommonPage.RolesAvailableAccord;
import com.eisrem.pageFactory.CommonPage.RowsAvailableAccord;
import com.eisrem.pageFactory.CommonPage.SectionsAvailableAccord;
import com.eisrem.pageFactory.CommonPage.ServicePopulationsAvailableAccord;
import com.eisrem.pageFactory.CommonPage.SetConditionsAccord;
import com.eisrem.pageFactory.CommonPage.WhenAccord;
import com.eisrem.pageFactory.CommonPage.WhoAccord;
import com.eisrem.pageFactory.CommonPage.ConductedTypes;
import com.eisrem.pageFactory.MyHomePage.MyClientsManagePage;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;
import com.eisrem.pageFactory.MyHomePage.MyReportsManagePage;
import com.eisrem.pageFactory.MyHomePage.MyInboxManagePage;
import com.eisrem.pageFactory.MyHomePage.ForwardPage;
import com.eisrem.pageFactory.Notes.NotesNavigator;
import com.eisrem.pageFactory.Notes.NotesPage;
import com.eisrem.pageFactory.Organization.AdditionalOrgLocAccord;
import com.eisrem.pageFactory.Organization.LocationsPage;
import com.eisrem.pageFactory.Organization.OrganizationNavigator;
import com.eisrem.pageFactory.Organization.OrganizationPage;
import com.eisrem.pageFactory.Organization.ServicesSpecialtiesPage;
import com.eisrem.pageFactory.Organization.StatusPage;
import com.eisrem.pageFactory.Organization.UserHomeOfficeAccord;
import com.eisrem.pageFactory.Organization.UserInfoAccord;
import com.eisrem.pageFactory.Organization.UserStaffPage;
import com.eisrem.pageFactory.People.PeoplePage;
import com.eisrem.pageFactory.People.RaceEthnicityPage;
import com.eisrem.pageFactory.People.AssociationsPage;
import com.eisrem.pageFactory.People.CriticalInformationPage;
import com.eisrem.pageFactory.People.DemographicsPage;
import com.eisrem.pageFactory.People.DiagnosisPage;
import com.eisrem.pageFactory.People.EnrollmentStatusPage;
import com.eisrem.pageFactory.People.LanguagePage;
import com.eisrem.pageFactory.People.LivingArrangementPage;
import com.eisrem.pageFactory.People.OtherNamesPage;
import com.eisrem.pageFactory.People.PaymentsPage;
import com.eisrem.pageFactory.People.PeopleClassesPage;
import com.eisrem.pageFactory.People.PeopleNavigator;
import com.eisrem.pageFactory.People.RelationshipsPage;
import com.eisrem.pageFactory.People.ResidentialPlacementPage;
import com.eisrem.pageFactory.Planning.PlanningNavigator;
import com.eisrem.pageFactory.Planning.PlanningPage;
import com.eisrem.pageFactory.ProcessWizard.ProcessPage;
import com.eisrem.pageFactory.ProcessWizard.ProcessWizardNavigator;
import com.eisrem.pageFactory.QuickLinks.QuickLinksNavigator;
import com.eisrem.pageFactory.QuickLinks.QuickLinksPage;
import com.eisrem.pageFactory.ReportableEvent.ReportableEventNavigator;
import com.eisrem.pageFactory.ReportableEvent.ReportableEventPage;
import com.eisrem.pageFactory.Reports.ReportsPage;
import com.eisrem.pageFactory.Search.SearchPage;
import com.eisrem.pageFactory.Classes.SchedulePage;
import com.eisrem.pageFactory.Agreement.FundSourceAccord;
import com.eisrem.testCases.CommonTest.DataTableTabTest;

public class ObjectSource {


	//Admin Pages ------------------------------------------

	public DriverFactory DriverFactory() {
		return DriverFactory.driverFactoryInstance();
	}

	public SeleniumHelper SeleniumHelper() {
		return new SeleniumHelper();
	}

	public DBConnect DBConnect() {
		return new DBConnect();
	}

	public LogInPage LogInPage() {
		return new LogInPage(DriverFactory.getDriver());
	}
	
	public LoginAssistance LoginAssistance() {
		return new LoginAssistance(DriverFactory.getDriver());
	}
	
	public ForgotUsernamePage ForgotUsernamePage() {
		return new ForgotUsernamePage(DriverFactory.getDriver());
	}
	
	public ForgotPasswordPage ForgotPasswordPage() {
		return new ForgotPasswordPage(DriverFactory.getDriver());
	}

	public PasswordChangePage PasswordChangePage() {
		return new PasswordChangePage(DriverFactory.getDriver());
	}

	public NavigationMenuBar NavigationMenuBar() {
		return new NavigationMenuBar(DriverFactory.getDriver());
	}
	
	public Pagefactory Pagefactory() {
		return new Pagefactory(DriverFactory.getDriver());
	}

	public DataTable DataTable() {
		return new DataTable(DriverFactory.getDriver());
	}


	//My Homepage Module -------------------------------------------

	public MyHomePage MyHomePage() {
		return new MyHomePage(DriverFactory.getDriver());
	}

	public MyInboxManagePage MyInboxManagePage() {
		return new MyInboxManagePage(DriverFactory.getDriver());
	}
	
	public ForwardPage ForwardPage() {
		return new ForwardPage(DriverFactory.getDriver());
	}
		
	public MyClientsManagePage MyClientsManagePage() {
		return new MyClientsManagePage(DriverFactory.getDriver());
	}

	public MyReportsManagePage MyReportsManagePage() {
		return new MyReportsManagePage(DriverFactory.getDriver());
	}


	//My Reports Module --------------------------------------------
	public ReportsPage ReportsPage() {
		return new ReportsPage(DriverFactory.getDriver());
	}


	//Process Wizard --------------------------------------------
	
	public ProcessWizardNavigator ProcessWizardNavigator() {
		return new ProcessWizardNavigator(DriverFactory.getDriver());
	}
	
	public ProcessPage ProcessPage() {
		return new ProcessPage(DriverFactory.getDriver());
	}


	//People Module---------------------------------------------

	public PeopleNavigator PeopleNavigator() {
		return new PeopleNavigator(DriverFactory.getDriver());
	}

	public PeoplePage PeoplePage() {
		return new PeoplePage(DriverFactory.getDriver());
	}

	public AssociationsPage AssociationsPage() {
		return new AssociationsPage(DriverFactory.getDriver());
	}

	public DemographicsPage DemographicsPage() {
		return new DemographicsPage(DriverFactory.getDriver());
	}

	public AddressPage AddressPage() {
		return new AddressPage(DriverFactory.getDriver());
	}
	
	public ChangePasswordPage ChangePasswordPage() {
		return new ChangePasswordPage(DriverFactory.getDriver());
	}

	public IdentifiersPage IdentifiersPage() {
		return new IdentifiersPage(DriverFactory.getDriver());
	}

	public EnrollmentStatusPage EnrollmentStatusPage() {
		return new EnrollmentStatusPage(DriverFactory.getDriver());
	}

	public CriticalInformationPage CriticalInformationPage() {
		return new CriticalInformationPage(DriverFactory.getDriver());
	}

	public RelationshipsPage RelationshipsPage() {
		return new RelationshipsPage(DriverFactory.getDriver());
	}

	public OtherNamesPage OtherNamesPage() {
		return new OtherNamesPage(DriverFactory.getDriver());
	}

	public LivingArrangementPage LivingArrangementPage() {
		return new LivingArrangementPage(DriverFactory.getDriver());
	}

	public DiagnosisPage DiagnosisPage() {
		return new DiagnosisPage(DriverFactory.getDriver());
	}

	public PeopleClassesPage PeopleClassesPage() {
		return new PeopleClassesPage(DriverFactory.getDriver());
	}

	public PaymentsPage PaymentsPage() {
		return new PaymentsPage(DriverFactory.getDriver());
	}

	public DocumentsPage DocumentsPage() {
		return new DocumentsPage(DriverFactory.getDriver());
	}
	
	public DocumentsUserPage DocumentsUserPage() {
		return new DocumentsUserPage(DriverFactory.getDriver());
	}

	public LanguagePage LanguagePage() {
		return new LanguagePage(DriverFactory.getDriver());
	}

	public RaceEthnicityPage RaceEthnicityPage() {
		return new RaceEthnicityPage(DriverFactory.getDriver());
	}
	
	public ResidentialPlacementPage ResidentialPlacementPage() {
		return new ResidentialPlacementPage(DriverFactory.getDriver());
	}


	//Organization Module---------------------------------------------

	public OrganizationNavigator OrganizationNavigator() {
		return new OrganizationNavigator(DriverFactory.getDriver());
	}

	public OrganizationPage OrganizationPage() {
		return new OrganizationPage(DriverFactory.getDriver());
	}

	public LocationsPage LocationsPage() {
		return new LocationsPage(DriverFactory.getDriver());
	}

	public UserStaffPage UserStaffPage() {
		return new UserStaffPage(DriverFactory.getDriver());
	}
	
	public UserInfoAccord UserInfoAccord() {
		return new UserInfoAccord(DriverFactory.getDriver());
	}
	
	public UserHomeOfficeAccord UserHomeOfficeAccord() {
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public AdditionalOrgLocAccord AdditionalOrgLocAccord() {
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}

	public ServicesSpecialtiesPage ServicesSpecialtiesPage() {
		return new ServicesSpecialtiesPage(DriverFactory.getDriver());
	}

	public StatusPage StatusPage() {
		return new StatusPage(DriverFactory.getDriver());
	}
	
	//Conducted Types Base Module---------------------------------------------
		public ConductedTypes ConductedTypes() {
			return new ConductedTypes(DriverFactory.getDriver());
		}


	//Assessment/Forms Module---------------------------------------------
	public Assessment_FormsPage Assessment_FormsPage() {
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}
	
	public Assessment_FormsNavigator Assessment_FormsNavigator() {
		return new Assessment_FormsNavigator(DriverFactory.getDriver());
	}

	//Authorization Module---------------------------------------------
	public AuthorizationPage AuthorizationPage() {
		return new AuthorizationPage(DriverFactory.getDriver());
	}
	
	public AuthorizationNavigator AuthorizationNavigator() {
		return new AuthorizationNavigator(DriverFactory.getDriver());
	}

	//Notes Module---------------------------------------------
	public NotesPage NotesPage() {
		return new NotesPage(DriverFactory.getDriver());
	}
	
	public NotesNavigator NotesNavigator() {
		return new NotesNavigator(DriverFactory.getDriver());
	}

	//Planning Module---------------------------------------------
	public PlanningPage PlanningPage() {
		return new PlanningPage(DriverFactory.getDriver());
	}
	
	public PlanningNavigator PlanningNavigator() {
		return new PlanningNavigator(DriverFactory.getDriver());
	}

	//ReportableEvent Module---------------------------------------------
	public ReportableEventPage ReportableEventPage() {
		return new ReportableEventPage(DriverFactory.getDriver());
	}
	
	public ReportableEventNavigator ReportableEventNavigator() {
		return new ReportableEventNavigator(DriverFactory.getDriver());
	}

	//Search Module---------------------------------------------

	public SearchPage SearchPage() {
		return new SearchPage(DriverFactory.getDriver());
	}


	//Agreement Module---------------------------------------------

	public AgreementPage AgreementPage() {
		return new AgreementPage(DriverFactory.getDriver());
	}

	public AgreementNavigator AgreementNavigator() {
		return new AgreementNavigator(DriverFactory.getDriver());
	}
	
	public FundSourceAccord FundSourceAccord() {
		return new FundSourceAccord(DriverFactory.getDriver());
	}

	//Classes Module---------------------------------------------

	public ClassesPage ClassesPage() {
		return new ClassesPage(DriverFactory.getDriver());
	}

	public ClassesNavigator ClassesNavigator() {
		return new ClassesNavigator(DriverFactory.getDriver());
	}
	
	public SchedulePage SchedulePage() {
		return new SchedulePage(DriverFactory.getDriver());
	}
	
	public RosterPage RosterPage() {
		return new RosterPage(DriverFactory.getDriver());
	}
	
	public OutcomePage OutcomePage() {
		return new OutcomePage(DriverFactory.getDriver());
	}
	
	public AttendancePage AttendancePage() {
		return new AttendancePage(DriverFactory.getDriver());
	}

	//QuickLinks Module---------------------------------------------

	public QuickLinksPage QuickLinksPage() {
		return new QuickLinksPage(DriverFactory.getDriver());
	}

	public QuickLinksNavigator QuickLinksNavigator() {
		return new QuickLinksNavigator(DriverFactory.getDriver());
	}

	//Administrator Module---------------------------------------------

	public AdministratorNavigator AdministratorNavigator() {
		return new AdministratorNavigator(DriverFactory.getDriver());
	}

	public TypesPage TypesPage() {
		return new TypesPage(DriverFactory.getDriver());
	}

	public LookupsPage LookupsPage() {
		return new LookupsPage(DriverFactory.getDriver());
	}

	public RolesPage RolesPage() {
		return new RolesPage(DriverFactory.getDriver());
	}

	public PagesPage PagesPage() {
		return new PagesPage(DriverFactory.getDriver());
	}

	public NotificationsPage NotificationsPage() {
		return new NotificationsPage(DriverFactory.getDriver());
	}


	public AdministratorMessagesPage AdministratorMessagesPage() {
		return new AdministratorMessagesPage(DriverFactory.getDriver());
	}
	
	//Common Page---------------------------------------------

	public LabelsAvailableAccord LabelsAvailableAccord() {
		return new LabelsAvailableAccord(DriverFactory.getDriver());
	}
	
	public MessageContentAccord MessageContentAccord() {
		return new MessageContentAccord(DriverFactory.getDriver());
	}

	public PagesAvailableAccord PagesAvailableAccord() {
		return new PagesAvailableAccord(DriverFactory.getDriver());
	}

	public QuestionsAvailableAccord QuestionsAvailableAccord() {
		return new QuestionsAvailableAccord(DriverFactory.getDriver());
	}

	public RolesAvailableAccord RolesAvailableAccord() {
		return new RolesAvailableAccord(DriverFactory.getDriver());
	}
	
	public RowsAvailableAccord RowsAvailableAccord() {
		return new RowsAvailableAccord(DriverFactory.getDriver());
	}

	public SectionsAvailableAccord SectionsAvailableAccord() {
		return new SectionsAvailableAccord(DriverFactory.getDriver());
	}

	public ServicePopulationsAvailableAccord ServicePopulationsAvailableAccord() {
		return new ServicePopulationsAvailableAccord(DriverFactory.getDriver());
	}
	
	public SetConditionsAccord SetConditionsAccord() {
		return new SetConditionsAccord(DriverFactory.getDriver());
	}

	public WhenAccord WhenAccord() {
		return new WhenAccord(DriverFactory.getDriver());
	}

	public WhoAccord WhoAccord() {
		return new WhoAccord(DriverFactory.getDriver());
	}
	
	public FormPage FormPage() {
		return new FormPage(DriverFactory.getDriver());
	}
	
	//Common Test---------------------------------------------
	public DataTableTabTest DataTableTabTest() {
		return new DataTableTabTest();
	}
}
