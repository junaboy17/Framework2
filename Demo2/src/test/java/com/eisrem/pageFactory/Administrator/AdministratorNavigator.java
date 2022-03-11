package com.eisrem.pageFactory.Administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.RolesAvailableAccord;

public class AdministratorNavigator extends DataTable{

	public AdministratorNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//a[contains(text(),'Roles Available:')]")
	public WebElement RolesAvailableAccord;
	
	@FindBy(xpath="//li[@id='23_Types_tab']")
	public WebElement typesTab;
	
	@FindBy(xpath="//li[@id='21_Role_tab']")
	public WebElement RolesTab;
	
	@FindBy(xpath="//li[@id='34_Pages_tab']")
	public WebElement PagesTab;
	
	@FindBy(xpath="//li[@id='35_Notifications_tab']")
	public WebElement NotificationsTab;
	
	@FindBy(xpath="//li[@id='22_LookupGroup_tab']")
	public WebElement LookupsTab;
	
	@FindBy(xpath="//li[@id='44_AdministratorMessage_tab']")
	public WebElement AdministratorMessagesTab;
	
	public String readTypesTab() {
		return Source.SeleniumHelper().readElement(typesTab);
	}
	
	public AdministratorNavigator clickTypes() {
		Source.SeleniumHelper().clickElement(typesTab);
		return this;
	}
	
	public String readRolesTab() {
		return Source.SeleniumHelper().readElement(RolesTab);
	}
	
	public AdministratorNavigator clickRoles() {
		Source.SeleniumHelper().clickElement(RolesTab);
		return this;
	}
	
	public String readPagesTab() {
		return Source.SeleniumHelper().readElement(PagesTab);
	}
	
	public AdministratorNavigator clickPages() {
		Source.SeleniumHelper().clickElement(PagesTab);
		return this;
	}
	
	public String readNotificationsTab() {
		return Source.SeleniumHelper().readElement(NotificationsTab);
	}
	
	public NotificationsPage clickNotifications() {
		Source.SeleniumHelper().clickElement(NotificationsTab);
		return new NotificationsPage(DriverFactory.getDriver());
	}
	
	public String readLookupsTab() {
		return Source.SeleniumHelper().readElement(LookupsTab);
	}
	
	public AdministratorNavigator clickLookups() {
		Source.SeleniumHelper().clickElement(LookupsTab);
		return this;
	}
	
	public String readAdministratorMessagesTab() {
		return Source.SeleniumHelper().readElement(AdministratorMessagesTab);
	}
	
	public AdministratorNavigator clickAdministratorMessages() {
		Source.SeleniumHelper().clickElement(AdministratorMessagesTab);
		return this;
	}
	
	public RolesAvailableAccord clickRolesAvailableAccord() {
		Source.SeleniumHelper().clickElement(RolesAvailableAccord);
		return new RolesAvailableAccord(DriverFactory.getDriver());
	}
	
	

}
