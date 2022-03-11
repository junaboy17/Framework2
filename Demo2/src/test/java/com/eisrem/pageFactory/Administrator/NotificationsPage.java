package com.eisrem.pageFactory.Administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.MessageContentAccord;
import com.eisrem.pageFactory.CommonPage.Pagefactory;
import com.eisrem.pageFactory.CommonPage.PagesAvailableAccord;
import com.eisrem.pageFactory.CommonPage.SetConditionsAccord;
import com.eisrem.pageFactory.CommonPage.WhenAccord;
import com.eisrem.pageFactory.CommonPage.WhoAccord;

public class NotificationsPage extends AdministratorNavigator{

	public NotificationsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Add Notifications')]")
	public WebElement AddNotificationsPageTitle;

	@FindBy(xpath="//a[contains(text(),'Notifications')]")
	public WebElement NotificationsAccordian;

	@FindBy(xpath="//a[text()='Notification']")
	public WebElement NotificationTab;

	@FindBy(xpath="//label[@for='notifications-name']")
	public WebElement NotificationNameTitle;

	@FindBy(xpath="//input[@id='notifications-name']")
	public WebElement NotificationNameTextBox;

	@FindBy(xpath="//button[text()='Save']")
	public WebElement SaveBtn;

	@FindBy(xpath="//button[text()='Back']")
	public WebElement BackBtn;
	
	@FindBy(xpath="//button[text()='Copy Notification']")
	public WebElement CopyNotificationBtn;

	@FindBy(xpath="//label[text()='Notification Description:']")
	public WebElement CriteriaTitle;

	@FindBy(xpath="//textarea[@id='notifications-descr']")
	public WebElement CriteriaTextBox;

	@FindBy(xpath="//label[contains(text(),'Active?')]")
	public WebElement ActiveTitle;

	@FindBy(xpath="//div[@id='Notification-tab-pane']//div[1]//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]")
	public WebElement ActiveToggle;

	@FindBy(xpath="//input[@id='notifications-active']")
	public WebElement ActiveToggleAttribute;

	@FindBy(xpath="//label[contains(text(),'Send Email?')]")
	public WebElement SendEmailTitle;

	@FindBy(xpath="//div[@id='Notification-tab-pane']/div[2]//div[2]//div[2]//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]")
	public WebElement SendEmailToggle;
	
	@FindBy(xpath="//div[@id='Notification-tab-pane']/div[2]//div[2]//div[2]//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]//input")
	public WebElement SendEmailToggleAttribute;

	@FindBy(xpath="//label[contains(text(),'Last Run Date')]")
	public WebElement LastRunDateTitle;

	@FindBy(xpath="//input[@id='lastRunDate']")
	public WebElement LastRunDateTextBox;

	@FindBy(xpath="//a[contains(text(),'Set Conditions')]")
	public WebElement SetConditionsLink;

	@FindBy(xpath="//a[contains(text(),'When (Frequency, Occurance, Expiry Date)')]")
	public WebElement WhenLink;

	@FindBy(xpath="//a[contains(text(),'Who (Recipients)')]")
	public WebElement WhoRecipientsLink;

	@FindBy(xpath="//a[contains(text(),'Message Content')]")
	public WebElement MessageContentLink;

	@FindBy(xpath="//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;

	@FindBy(xpath="//button[contains(text(),'Save & Test')]")
	public WebElement SaveTestBtn;

	@FindBy(xpath="//button[contains(text(),'Back To Notifications')]")
	public WebElement BackToNotificationsBtn;
	
	@FindBy(xpath="//select[@id='selections-criteria-property']/option[contains(text(),'CONTAINS (TEXT AREA/NARRATIVE)')]")
	public WebElement ContainsFormat;

	public String readAddNotificationsTitle() {
		return Source.SeleniumHelper().readElement(AddNotificationsPageTitle);
	}

	public String readAccord() {
		return Source.SeleniumHelper().readElement(NotificationsAccordian);
	}

	public NotificationsPage clickNotificationsAccordian() {
		Source.SeleniumHelper().clickElement(NotificationsAccordian);
		return this;
	}

	public String readNotificationTab() {
		return Source.SeleniumHelper().readElement(NotificationTab);
	}

	public String readNameTitle() {
		return Source.SeleniumHelper().readElement(NotificationNameTitle);
	}

	public NotificationsPage setNotificationName(String name, String... Clear) {
		Source.SeleniumHelper().setText(NotificationNameTextBox, name, Clear);
		return this;
	}

	public String readSaveBtnTitle() {
		return Source.SeleniumHelper().readElement(SaveBtn);
	}

	public String readBackBtnTitle() {
		return Source.SeleniumHelper().readElement(BackBtn);
	}
	
	public boolean readIfBackBtnDisabled() {
		return BackBtn.isEnabled();
	}
	
	public NotificationsPage clickCopyNotification() {
		Source.SeleniumHelper().clickElement(CopyNotificationBtn);
		return this;
	}

	public String readCriteriaTitle() {
		return Source.SeleniumHelper().readElement(CriteriaTitle);
	}

	public NotificationsPage setNotificationsCriteria(String criteria, String... Clear) {
		Source.SeleniumHelper().setText(CriteriaTextBox, criteria, Clear);
		return this;
	}

	public String readActiveTitle() {
		return Source.SeleniumHelper().readElement(ActiveTitle);
	}

	public String readActiveToggle() {
		return Source.SeleniumHelper().readElement(ActiveToggle);
	}
	
	public String readActiveToggleBtn() {
		return ActiveToggleAttribute.getAttribute("last-val");
	}
	
	public NotificationsPage clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return new WhenAccord(DriverFactory.getDriver());
	}

	public String readSendEmailBtnTitle() {
		return Source.SeleniumHelper().readElement(SendEmailTitle);
	}
	
	public String readSendEmailToggle() {
		return Source.SeleniumHelper().readElement(SendEmailToggle);
	}
	
	public String readIfSendEmailToggleDisabled() {
		return SendEmailToggleAttribute.getAttribute("disabled");
	}
	
	public NotificationsPage clickSendEmailToggle() {
		Source.SeleniumHelper().clickElement(SendEmailToggle);
		return this;
	}
	
	public NotificationsPage clickSendEmailToggle(String value) {
		String active = readSendEmailToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickSendEmailToggle();
		}
		return this;
	}

	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}

	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}

	public String readLastRunDateTitle() {
		return Source.SeleniumHelper().readElement(LastRunDateTitle);
	}

	public String readSetConditionsLink() {
		return Source.SeleniumHelper().readElement(SetConditionsLink);
	}

	public SetConditionsAccord clickSetConditionsLink() {
		Source.SeleniumHelper().clickElement(SetConditionsLink);
		return new SetConditionsAccord(DriverFactory.getDriver());
	}

	public String readWhenLinkTitle() {
		return Source.SeleniumHelper().readElement(WhenLink);
	}

	public WhenAccord clickWhenAccord() {
		Source.SeleniumHelper().clickElement(WhenLink);
		return new WhenAccord(DriverFactory.getDriver());
	}

	public String readWhoRecipientsLink() {
		return Source.SeleniumHelper().readElement(WhoRecipientsLink);
	}

	public WhoAccord clickWhoRecipientsAccord() {
		Source.SeleniumHelper().clickElement(WhoRecipientsLink);
		return new WhoAccord(DriverFactory.getDriver());
	}

	public String readMessageContentLink() {
		return Source.SeleniumHelper().readElement(MessageContentLink);
	}

	public MessageContentAccord clickMessageContent() {
		Source.SeleniumHelper().clickElement(MessageContentLink);
		return new MessageContentAccord(DriverFactory.getDriver());
	}

	public String readSubmitExitBtn() {
		return Source.SeleniumHelper().readElement(SubmitExitBtn);
	}

	public SetConditionsAccord clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return new SetConditionsAccord(DriverFactory.getDriver());
	}

	public String readSaveTestBtn() {
		return Source.SeleniumHelper().readElement(SaveTestBtn);
	}

	public PagesAvailableAccord clickSaveTest() {
		Source.SeleniumHelper().clickElement(SaveTestBtn);
		return new PagesAvailableAccord(DriverFactory.getDriver());
	}	

	public String readBackToNotificationsBtn() {
		return Source.SeleniumHelper().readElement(BackToNotificationsBtn);
	}

	public NotificationsPage clickBackToNotifications() {
		Source.SeleniumHelper().clickElement(BackToNotificationsBtn);
		return this;
	}
	
	public String readContainsFormatEnabled() {
		return Boolean.toString(Source.SeleniumHelper().getWebElement(ContainsFormat).isEnabled());
	}
	
	public NotificationsPage DisableNotification(String NotificationName) {
		Source	.NavigationMenuBar()
				.clickAdministrator()
				.GetSource()
				.AdministratorNavigator()
				.clickNotifications()
				.setSearch(NotificationName)
				.clickFirstRow()
				.clickEdit()
				.Pagefactory()
				.clickActiveToggle("false")
				.GetSource()
				.NotificationsPage()
				.clickSendEmailToggle("false")
				.clickSave();
				
				
			
		return this;
	}
	
}
