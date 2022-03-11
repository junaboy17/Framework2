package com.eisrem.AppUtils;

import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class Data extends Enumerations {

	//Common Variables 

	protected ObjectSource Source = new ObjectSource();
	protected SoftAssert SoftAssert;
	protected static String Actual;
	protected static String Expected;
	protected static String Expected2;
	protected boolean ActualB;
	protected boolean ExpectedB;
	protected static int SizeActual;
	protected static int SizeExpected;
	protected static String ID;
	protected Logger Log = Logger.getLogger(this.getClass().getSimpleName());
	protected static String Yes = "Yes";
	protected static String No = "No";
	protected static String True = "true";
	protected static String False = "false";
	protected static boolean T = true;
	protected static boolean F = false;
	protected static String active ="active";
	protected static String Active ="Active";
	protected static String Success ="Success!";
	protected static String Clear = "Y";
	protected static String Disabled = "disabled";
	protected static String None = "None";
	protected static String EmptyString = "";

	//Dates
	protected static String FutureDate30 = SeleniumHelper.dateOnlyFuture(30);
	protected static String FutureDate6 = SeleniumHelper.dateOnlyFuture(6);
	protected static String FutureDate7 = SeleniumHelper.dateOnlyFuture(7);
	protected static String Tomorrow = SeleniumHelper.dateOnlyFuture(1);
	protected static String FutureDate2 = SeleniumHelper.dateOnlyFuture(2);
	protected static String TodayDash = SeleniumHelper.dateOnly("-");
	protected static String StartDate = SeleniumHelper.dateOnly();
	protected static String Today = SeleniumHelper.dateOnly();
	protected static String Yesterday = SeleniumHelper.dateOnlyPast(1);
	protected static String PastDate = SeleniumHelper.dateOnlyPast(2);
	protected static String PastDate3 = SeleniumHelper.dateOnlyPast(3);
	protected static String PastDate4 = SeleniumHelper.dateOnlyPast(4);
	protected static String PastDate5 = SeleniumHelper.dateOnlyPast(5);
	protected static String PastDate7 = SeleniumHelper.dateOnlyPast(7);
	protected static String PastDate30 = SeleniumHelper.dateOnlyPast(30);
	protected static String PastDate45 = SeleniumHelper.dateOnlyPast(45);
	

	//Random Numbers / Alpha
	protected static String RandAlpha1 = SeleniumHelper.generateRandomAlpha(1);
	protected static String RandAlpha2 = SeleniumHelper.generateRandomAlpha(2);
	protected static String RandAlpha3 = SeleniumHelper.generateRandomAlpha(3);
	protected static int RandNum1 = SeleniumHelper.generateRandomNumber(1);
	protected static int RandNum2 = SeleniumHelper.generateRandomNumber(2);
	protected static int RandNum3 = SeleniumHelper.generateRandomNumber(3);
	protected static int RandNum4 = SeleniumHelper.generateRandomNumber(4);
	protected static int RandNum5 = SeleniumHelper.generateRandomNumber(5);
	protected static int RandNum6 = SeleniumHelper.generateRandomNumber(6);
	protected static int RandNum7 = SeleniumHelper.generateRandomNumber(7);
	protected static int RandNum8 = SeleniumHelper.generateRandomNumber(8);
	protected static int RandNum9 = SeleniumHelper.generateRandomNumber(9);
	protected static int RandNum10 = SeleniumHelper.generateRandomNumber(10);
	protected static String RandMoneyAmount = RandNum3 + "." + RandNum2;
	
	//Numbers As String Name
	protected static String Zero = "Zero";
	protected static String One = "One";
	protected static String Two = "Two";
	protected static String Three = "Three";
	protected static String Four = "Four";
	protected static String Five = "Five";
	
	//Numbers As String Number
	protected static String ZeroN = "0";
	protected static String OneN = "1";
	protected static String TwoN = "2";
	protected static String ThreeN = "3";
	protected static String FourN = "4";
	protected static String FiveN = "5";

	//Reg Ex
	protected static String FullDateRegEx = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2} [AP]M\\z";
	protected static String OnlyDateRegEx = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

	//Error Message
	//Login Page
	protected static String UserNotActiveErrorMessage = "Username is no longer active. Please have your supervisor submit the Adding/Editing/Ending Users form in EIS to request access.";
	
	//People
	protected static String FirstName = "Chris";
	protected static String MiddleName = "P";
	protected static String LastName = "Bacon";
	protected static String FullName = LastName + ", " + FirstName;
	protected static String State = "ME";
	protected static String Address = RandNum3 + " SELENIUM ST";
	protected static String City = "AUGUSTA";
	protected static int Zip = 1;
	protected static int LegalAddressType = 1;	
	protected static int WorkAddressType = 4;	
	protected static String PhoneNumber = String.valueOf(RandNum10);
	protected static String Email = FirstName + LastName + RandNum4 + "@Test.Gov";
	protected static String FirstName2 = "Leana";
	protected static String BusinessFirstName = "Travis" + RandNum3;
	protected static String MiddleName2 = "B";
	protected static String LastName2 = "Johnson";
	protected static String BusinessLastName = "Randy";
	protected static String DateOfBirth = "08/28/2019";
	protected static String DateOfDeath = "08/28/2020";
	protected static String DateOfDeath2 = "05/01/2021";
	protected static String PlaceOfBirth = "TWO RIVERS";
	protected static String Household = "Full House";
	protected static String JeanneDOBOnly =	"10/06/2004";
	protected static String JeanneAge = "17";
	protected static String JeanneDOB =	"BAMBINO, JEANNE ("+ JeanneDOBOnly +")";
	protected static String JeanneAnchoredData = "People ID: 333415 | Name: " + JeanneDOB + " | Age: "+ JeanneAge +" | DOB: "+ JeanneDOBOnly +" | Medicaid: 14569328A | ";
	protected static String JeanneClient = "Bambino, Jeanne";
	protected static String JeanneID = "333415";
	protected static String JeanneSignature = "Jeanne Tondreau";
	protected static String JeanneTest = "Test Bambino";
	protected static String TestClient = "MONTOYA, INIGO";
	protected static String TestClient2 = "BACON, CHRIS";
	protected static String SeleniumUserID = "571797";
	
	//Diagnosis Info
	protected static String PrimaryDiagnosis = "Primary Diagnosis";
	protected static String SecondaryDiagnosis = "Secondary Diagnosis";
	protected static String SecondaryDiagnosis2 = "Secondary Diagnosis(2)";
	protected static String TertiaryDiagnosis = "Tertiary Diagnosis";
	protected static String OtherDiagnosis = "Other Diagnosis";
	
	//Staff User Module
	protected static String UserFirstName = "Mashed";
	protected static String UserLastName = "Potatoes";
	protected static String UserPhoneNumber = String.valueOf(RandNum10);
	protected static String UserSupervisor = "Poppers";
	protected static String UserTitle = "Jalapeno";
	protected static String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
	protected static String UserNamePrefix = "OIT";
	protected static String UserPassword = "Summer" + SeleniumHelper.generateRandomAlpha(6) + "12!";
	protected static String userName2 = "SAMHSNONADMIN";
	protected static String userPassword2 = "Orange123(";
	
	//Common Module Data
	protected static String Description = "SELENIUM TEST RECORD";
	protected static String UpdateDescription = "UPDATED SELENIUM TEST RECORD";
	protected static String CopyRightYear = "2022";
	protected int SleepSec = 5;
	protected String Anchor = "Anchor";
	protected String Add = "Add";
	protected String Edit = "Edit";
	protected String View = "View";
	protected String Excel = "Excel";
	protected String Submit = "Submit";
	protected String Print = "Print";
	protected String BackToAssessment = "Back To Assessment";
	protected String GoBackToList = "Go back to List";
	protected String GoBackToPeople = "Go back to People";
	protected String SubmitAllPages = "Submit All Pages";
	protected String Continue = "Continue";
	protected static String SortOrderText = "Sort Order";

	//Identifier Tab
	protected static String MedicaidIdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();

	//Assessment Module
	protected static String DataFixAssessmentType = "Data Fix Form/ Assessment";
	protected static String DataFixForm = "Data Fix Form";
	protected static String DataFixFormV2 = "Data Fix Form (V2)";
	protected static String DataFixFormV2Assessment = "Data Fix Form (V2)/ Assessment";
	protected static String AnsaNumber7 = "ANSA-CRIME MODULE #7";
	protected static String AnsaRequiredModules = "ANSA - REQUIRED MODULES";
	protected static String CheckOffList = "Check Off List";
	protected static String Ansa = "ANSA";
	protected static String ConductedTypeTitle = "TC_Conducted_Types_Selenium " + RandNum8;
	protected static String ConductedTypePrefix = "TC_Conducted_Types_Selenium";
	
	//Module
	protected static String ClassNamePreFix = "SELENIUM TEST";
	protected static String ClassName = ClassNamePreFix + " " + RandNum4;
	protected static String SearchTerm2 = "2 ANTHONY AVE";
	protected static String ComboboxSearchTerm = "ACME";
	protected static String FullSearch = "36227";

	// Organization Module
	protected static String OrganizationsTab = "Organizations";
	protected static String LocationsTab = "Locations";
	protected static String UsersStaffTab = "Users/Staff";
	protected static String SevicesSpecialtiesTab = "Services/Specialties";
	protected static String AddressTab = "Address";
	protected static String IndentifierTab = "Identifier";
	protected static String StatusTab = "Status";
	protected static String DocumentsTab = "Documents";
	protected static String OrganizationName = "ACME GROUP HOME "+ RandNum4;
	protected static String OrganizationPrefix = "ACME GROUP HOME ";
	protected static String LocationName = "AUGUSTA/3 GROUP HOME "+ RandNum4;
	protected static String LocationName2 = "GARDINER/2 TEST DRIVE "+ RandNum3;
	protected static String OrgDHHS = "DHHS";
	protected static String OrgUserWithIdent = "GOODWIN, EBEN";
	protected static String UserStaffName = "Wood";
	protected static String ActiveLocation = "ActiveLocation";
	protected static String InactiveLocation = "InactiveLocation";

	//Administrator Module
	protected static String OrganizationID = "1000004434";
	protected static String PeopleID = "1000004435";
	protected static String BothOrgPeopID = "1000004436";
	protected static String TypeName = "TC_Types_Selenium " + RandNum8;
	protected static String TypePrefix = "TC_Types_Selenium";
	protected static String PageName= "TC_Pages_Selenium " + RandNum8;
	protected static String PagePrefix = "TC_Pages_Selenium";
	protected static String SectionName= "TC_Section_Selenium " + RandNum8;
	protected static String SectionPrefix = "TC_Section_Selenium";
	protected static String RowName= "TC_Row_Selenium " + RandNum8;
	protected static String RowPrefix = "TC_Row_Selenium";
	protected static String QuestionLabel= "TC_Question_Selenium " + RandNum8;
	protected static String QuestionPrefix = "TC_Question_Selenium";
	protected static String OrganizationAssessName= "Conducted On Organization " + RandNum8;
	protected static String PeopleAssessName = "Conducted On People " + RandNum8;
	protected static String BothOrgPeopAssessName = "Conducted On Both " + RandNum8;
	protected static String NotificationName = "TC_My_Inbox_Date_Format_" + RandNum8 ;
	protected static String DescriptionUpdated = "Updated!"  + RandNum8 ;
	protected static String SectionsTable = "section_table";
	protected static String RowsTable = "row_table";
	protected static String QuestionsTable = "ques_table";
	protected static String RoleTable = "ques-roles-table";
	protected static String RoleName= "TC_ROLE_SELENIUM " + RandNum8;
	protected static String RolePrefix = "TC_Role_Selenium";
	
	//App Area
	protected static String AppAreas = "App Areas";
	protected static String AdministratorApp = "ADMINISTRATOR";
	protected static String AgreementApp = "AGREEMENT";
	protected static String Assessment_FormsApp = "ASSESSMENT/FORMS";
	protected static String AuthorizationApp = "AUTHORIZATION";
	protected static String ClassesApp = "CLASSES";
	protected static String My_HomepageApp = "MY HOMEPAGE";
	protected static String NotesApp = "NOTES";
	protected static String OrganizationApp = "ORGANIZATION";
	protected static String PeopleApp = "PEOPLE";
	protected static String PlanningApp = "PLANNING";
	protected static String Process_WizardApp = "PROCESS WIZARD";
	protected static String Quick_LinksApp = "QUICK LINKS";
	protected static String Reportable_EventApp = "REPORTABLE EVENT";
	protected static String ReportsApp = "REPORTS";
	protected static String SearchApp = "SEARCH";
	
	//Roles Modules
	protected static String NotesModules = "Notes";
	protected static String AddressModules = "Address";
	protected static String DocumentsModules = "Documents";
	protected static String IdentifierModules = "Identifier";
	protected static String LocationsModules = "Locations";
	protected static String OrganizationsModules = "Organizations";
	protected static String Services_SpecialtiesModules = "Services/Specialties";
	protected static String StatusModules = "Status";
	protected static String Users_StaffModules = "Users/Staff";
	protected static String Enrollment_StatusModules = "Enrollment Status";
	protected static String AssociationsModules = "Associations";
	protected static String ClassesModules = "Classes";
	protected static String Critical_InformationModules = "Critical Information";
	protected static String DemographicsModules = "Demographics";
	protected static String DiagnosisModules = "Diagnosis";
	protected static String LanguageModules = "Language";
	protected static String Living_ArrangementModules = "Living Arrangement";
	protected static String Other_NamesModules = "Other Names";
	protected static String PaymentsModules = "Payments";
	protected static String PeopleModules = "People";
	protected static String Race_Ethnicity_Othermodules = "Race/Ethnicity/Other";
	protected static String RelationshipsModules = "Relationships";
	protected static String Residential_PlacementModules = "Residential Placement";
	protected static String TypesModules = "Types";
	
	//Reportable Events
	protected static String OCFSType = "OCFS REPORTABLE EVENT FORM/ Reportable Event";
	protected String BackToReportableEvent = "Back To Reportable Event";
	
	//Notes
	protected static String NotesType = "Transition Note V4/ Notes";
	protected String BackToNotes = "Back To Notes";

	//Admin
	protected static String User = Configuration.User.baseUser;
	protected static String Pass = Configuration.Password.basePassword;
	protected static String Browser = Configuration.Browser.baseBrowser;
	protected static String Url = Configuration.Url.basePortal;
	protected static String UserEmail = Configuration.User.baseUserEmail;
	protected static String TestUserName = FirstName + LastName + RandNum4;
	protected static String TestPassword = "Summer21#";
	protected static String TestNewPassword = "Summer11#";
	protected static String TestBadCredentialsPassword = "Spring17#";
	protected static String TestBadCredentialsUsername = "OITBADCREDENTIALS";
	
	//Search
	protected static String CentralOffice = "Central Office";
	protected static String EditAssessmentHeader = "Edit Assessment/forms";
	protected static String EditReportableEventHeader = "Edit Reportable Event";
	protected static String EditNotesHeader = "Edit Note";
	protected static String EditPlanningHeader = "Edit Planning";
	protected static String OcfsReportableEventForm = "OCFS REPORTABLE EVENT FORM/ Reportable Event";
	protected static String EditLocationHeader = "Edit Location";
	protected static String LocationIdentifier = "1053319566";
	protected static String LocationCity = "AUGUSTA";
	protected static String LocationAddress = "2 ANTHONY AVE";
	protected static String EditOrganizationHeader = "Edit Organization";
	protected static String UserFullName = "USER, SELENIUM";
	protected static String SecondUserName = "HANKS, TOM";
	protected static String UserId = "571797";
	protected static String EditUserHeader = "Edit Staff/User";
	
	//Documents
	
	protected static String DocumentName= "TC_Document_Selenium " + RandNum8;
	protected static String DocumentPrefix = "TC_Document_Selenium";
	protected static String DocumentTestUser= "TEST, SELENIUM";
	protected static String UsersTable = "usersTable";
	protected static String DocumentPath = "/src/test/resources/UploadDocuments/";
	protected static String DocumentFile = "eis_pdf_upload.pdf";
	//Testing what can be tested in dev with below information
	protected static String DocumentIdDevOrg = "4042"; //IronMan 2 document 
	protected static String DocumentIdDevPeo = "8081"; //IronMan 2 document 
	protected static String DocumentUserDevOrg = "MOSS, HOWARD";
	protected static String DocumentUserDevPeo = "DORSO, LYNN";
}
