package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.Pagefactory;

public class UserStaffPage extends OrganizationNavigator{


	public UserStaffPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'User Info:')]")
	public WebElement UserInfoAccord;
	
	@FindBy(xpath="//a[contains(text(),'Staff Info')]")
	public WebElement staffInfoAccord;
	
	// Staff Info Accord Section
	
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement LastName;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@id='phoneNumber']")
	public WebElement Telephone;
	
	@FindBy(xpath="//label[contains(text(),'Staff Active')]")
	public WebElement StaffActiveTitle;
	
	@FindBy(xpath="//label[contains(text(),'Staff Active')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement StaffActiveToggle;
	
	@FindBy(xpath="//label[contains(text(),'Staff Active')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement StaffActiveToggleAttribute;
	
	@FindBy(xpath="//input[@id='title']")
	public WebElement Title;
	
	@FindBy(xpath="//input[@id='supervisor-combobox']")
	public WebElement Supervisor;
	
	@FindBy(xpath="//input[@id='datepicker_empDate_staff']")
	public WebElement EmploymentDate;
	
	@FindBy(xpath="//input[@id='datepicker_termDate_staff']")
	public WebElement TerminationDate;	
	
	@FindBy(xpath="//button[contains(text(),'Back To User/Staff')]")
	public WebElement BackToUserStaffBtn;
	
	

	public UserInfoAccord clickUserInfoAccord() {
		Source.SeleniumHelper().clickElement(UserInfoAccord);
		return new UserInfoAccord(DriverFactory.getDriver());
	}
	
	public UserStaffPage setFirstName(String name, String... Clear) {
		Source	.SeleniumHelper()
				.setText(FirstName, name, Clear);
		return this;
	}
	
	public UserStaffPage setLastName(String name, String... Clear) {
		Source	.SeleniumHelper()
				.setText(LastName, name, Clear);
		return this;
	}
	
	public UserStaffPage setEmail(String email, String... Clear) {
		Source	.SeleniumHelper()
				.setText(Email, email, Clear);
		return this;
	}
	
	public UserStaffPage setTelephone(String telephone, String... Clear) {
		Source	.SeleniumHelper()
				.setText(Telephone, telephone, Clear);
		return this;
	}
	
	public String readStaffActiveTitle() {
		return Source.SeleniumHelper().readElement(StaffActiveTitle);
	}
	
	public UserStaffPage clickStaffActiveToggle() {
		Source.SeleniumHelper().clickElement(StaffActiveToggle);
		return this;
	}
	
	public String readStaffActiveToggle() {
		return StaffActiveToggleAttribute.getAttribute("last-val");
	}
	
	public UserStaffPage clickStaffActiveToggle(String value) {
		String StaffActive = readStaffActiveToggle();
		
		if(value.equalsIgnoreCase(StaffActive)) {
			
		}
		else {
			clickStaffActiveToggle();
		}
		return this;
	}
	
	public UserStaffPage setTitle(String title, String... Clear) {
		Source	.SeleniumHelper()
				.setText(Title, title, Clear);
		return this;
	}
	
	public UserStaffPage setSupervisor(String supervisor, String... Clear) {
		Source	.SeleniumHelper()
				.setText(Supervisor, supervisor, Clear);
		return this;
	}
	
	public UserStaffPage setEmploymentDate(String employmentDate, String... Clear) {
		Source	.SeleniumHelper()
				.setText(EmploymentDate, employmentDate, Clear);
		return this;
	}
	
	public UserStaffPage setTerminationDate(String terminationDate, String... Clear) {
		Source	.SeleniumHelper()
				.setText(TerminationDate, terminationDate, Clear);
		return this;
	}
	
	public UserStaffPage clickBackToUserStaff() {
		Source.SeleniumHelper().clickElement(BackToUserStaffBtn);
		return new UserStaffPage(DriverFactory.getDriver());
	}
	
	public UserStaffPage toggleStaffActive(boolean active) {
		if((active && StaffActiveToggleAttribute.getAttribute("last-val").equals("false"))
				|| (!active && StaffActiveToggleAttribute.getAttribute("last-val").equals("true")))
		{
			//toggle twice in case datepicker has popup over toggle element
			Source.SeleniumHelper().clickElement(staffInfoAccord);
			Source.SeleniumHelper().clickElement(staffInfoAccord);
			clickStaffActiveToggle();
		}
		return this;
	}
	
	public UserStaffPage addCompleteUserAndSubmit(String orgSearchTerm, String firstName, String lastName, String email, String phone,
			boolean staffActive, String title, String supervisor, String employmentDate, String terminationDate, Boolean userActive, 
			String startDate, String endDate, String userName, String password, String confirmPassword, String description){
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().clickAdd();
		Source			.UserStaffPage()
						.setFirstName(firstName == null ? UserFirstName : firstName)
						.setLastName(lastName == null ? UserLastName : lastName)
						.setEmail(email == null ? UserEmail : email)
						.setTelephone(phone == null ? PhoneNumber : phone)
						.setSupervisor(supervisor == null ? UserSupervisor : supervisor)
						.setEmploymentDate(employmentDate == null ? Today : employmentDate)
						.setTerminationDate(terminationDate == null ? EmptyString : terminationDate);
		
		toggleStaffActive(staffActive);
		clickUserInfoAccord();
		Source.UserInfoAccord().toggleUserActive(userActive);
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		Source			.UserInfoAccord()
						.setUserStartDate(startDate == null ? Today : startDate, Clear)
						.setUserEndDate(endDate == null ? EmptyString : endDate)
						.setUserName(userName == null ? username : userName)
						.setPassword(password == null ? UserPassword : password)
						.setPasswordConfirmation(confirmPassword == null ? UserPassword : confirmPassword)
						.setDescription(description == null ? Description : description);
						
		Source			.UserStaffPage().clickSubmit().clickPopupOk();
		
		return this;
	}
	
	public UserStaffPage addCompleteUserAndRemainOnUserPage(String orgSearchTerm, String firstName, String lastName, String email, String phone,
			boolean staffActive, String title, String supervisor, String employmentDate, String terminationDate, Boolean userActive, 
			String startDate, String endDate, String userName, String password, String confirmPassword, String description){
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().clickAdd();
		Source			.UserStaffPage()
						.setFirstName(firstName == null ? UserFirstName : firstName)
						.setLastName(lastName == null ? UserLastName : lastName)
						.setEmail(email == null ? UserEmail : email)
						.setTelephone(phone == null ? PhoneNumber : phone)
						.setSupervisor(supervisor == null ? UserSupervisor : supervisor)
						.setEmploymentDate(employmentDate == null ? Today : employmentDate)
						.setTerminationDate(terminationDate == null ? EmptyString : terminationDate);
		
		toggleStaffActive(staffActive);
		clickUserInfoAccord();
		Source.UserInfoAccord().toggleUserActive(userActive);
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		Source			.UserInfoAccord()
						.setUserStartDate(startDate == null ? Today : startDate, Clear)
						.setUserEndDate(endDate == null ? EmptyString : endDate)
						.setUserName(userName == null ? username : userName)
						.setPassword(password == null ? UserPassword : password)
						.setPasswordConfirmation(confirmPassword == null ? UserPassword : confirmPassword)
						.setDescription(description == null ? Description : description);
		return this;
	}
	
	public String addCompleteUserAndReturnId(String orgSearchTerm, String firstName, String lastName, String email, String phone,
			boolean staffActive, String title, String supervisor, String employmentDate, String terminationDate, Boolean userActive, 
			String startDate, String endDate, String userName, String password, String confirmPassword, String description){
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().clickAdd();
						setFirstName(firstName == null ? UserFirstName : firstName)
						.setLastName(lastName == null ? UserLastName : lastName)
						.setEmail(email == null ? UserEmail : email)
						.setTelephone(phone == null ? PhoneNumber : phone);
		toggleStaffActive(staffActive);
						setSupervisor(supervisor == null ? UserSupervisor : supervisor)
						.setEmploymentDate(employmentDate == null ? Today : employmentDate)
						.setTerminationDate(terminationDate == null ? EmptyString : terminationDate);
		
		clickUserInfoAccord();
		Source.UserInfoAccord().toggleUserActive(userActive);
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		Source			.UserInfoAccord()
						.setUserStartDate(startDate == null ? Today : startDate, Clear)
						.setUserEndDate(endDate == null ? EmptyString : endDate)
						.setUserName(userName == null ? username : userName)
						.setPassword(password == null ? UserPassword : password)
						.setPasswordConfirmation(confirmPassword == null ? UserPassword : confirmPassword)
						.setDescription(description == null ? Description : description);
						
		return			Source.UserStaffPage().clickSubmit().clickPopupOk().DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}
	
	public UserStaffPage addCompleteUserAndSubmit(String orgSearchTerm){
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().clickAdd();
		Source			.UserStaffPage()
						.setFirstName(UserFirstName)
						.setLastName(UserLastName)
						.setEmail(UserEmail)
						.setTelephone(PhoneNumber)
						.setSupervisor(UserSupervisor)
						.setEmploymentDate(Today, Clear)
						.setTerminationDate(EmptyString);
		
		toggleStaffActive(true);
		clickUserInfoAccord();
		Source.UserInfoAccord().toggleUserActive(true);
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		Source			.UserInfoAccord()
						.setUserStartDate(Today, Clear)
						.setUserEndDate(EmptyString)
						.setUserName(username)
						.setPassword(UserPassword)
						.setPasswordConfirmation(UserPassword)
						.setDescription(Description);
						
		Source			.UserStaffPage().clickSubmit().clickPopupOk();
		return this;
	}
	
	public String addCompleteUserAndReturnId(String orgSearchTerm){
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().clickAdd();
		Source			.UserStaffPage()
						.setFirstName(UserFirstName)
						.setLastName(UserLastName)
						.setEmail(UserEmail)
						.setTelephone(PhoneNumber)
						.setSupervisor(UserSupervisor)
						.setEmploymentDate(Today, Clear)
						.setTerminationDate(EmptyString);
		
		toggleStaffActive(true);
		clickUserInfoAccord();
		Source.UserInfoAccord().toggleUserActive(true);
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		Source			.UserInfoAccord()
						.setUserStartDate(Today, Clear)
						.setUserEndDate(EmptyString)
						.setUserName(username)
						.setPassword(UserPassword)
						.setPasswordConfirmation(UserPassword)
						.setDescription(Description);
						
		return			Source.UserStaffPage().clickSubmit().clickPopupOk().DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}
	
	public UserStaffPage addCompleteUserAndRemainOnUserPage(String orgSearchTerm){
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().clickAdd();
		Source			.UserStaffPage()
						.setFirstName(UserFirstName)
						.setLastName(UserLastName)
						.setEmail(UserEmail)
						.setTelephone(PhoneNumber)
						.setSupervisor(UserSupervisor)
						.setEmploymentDate(Today, Clear)
						.setTerminationDate(EmptyString);
		
		toggleStaffActive(true);
		clickUserInfoAccord();
		Source.UserInfoAccord().toggleUserActive(true);
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		Source			.UserInfoAccord()
						.setUserStartDate(Today, Clear)
						.setUserEndDate(EmptyString)
						.setUserName(username)
						.setPassword(UserPassword)
						.setPasswordConfirmation(UserPassword)
						.setDescription(Description);
						
		return			this;
	}
	
	public UserStaffPage endDateUserAndSubmit(String orgSearchTerm, String userSearchTerm, boolean deactivateUser) {
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		Source			.SeleniumHelper().refreshPage().Wait(2);
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().setSearch(userSearchTerm == null ? username : userSearchTerm).clickFirstRow().clickEdit();
		
		clickUserInfoAccord();
		
		Source			.UserInfoAccord()
						.setUserEndDate(Today, Clear);

		Source.UserInfoAccord().toggleUserActive(deactivateUser);
		Source.UserStaffPage().clickSubmit().clickPopupOk();
		
		return this;		
	}
	
	public UserStaffPage endDateUser(String orgSearchTerm, String userSearchTerm, boolean deactivateUser) {
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickUsersStaff().setSearch(userSearchTerm == null ? username : userSearchTerm).clickFirstRow().clickEdit();
		
		clickUserInfoAccord();
		
		Source			.UserInfoAccord()
						.setUserEndDate(Today, Clear);
	
		Source.UserInfoAccord().toggleUserActive(deactivateUser);
		
		return this;		
	}
}
