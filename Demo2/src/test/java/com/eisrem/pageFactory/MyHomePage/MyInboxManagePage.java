package com.eisrem.pageFactory.MyHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Admin.LogInPage;
import com.eisrem.pageFactory.CommonPage.DataTable;


public class MyInboxManagePage extends DataTable{

	public MyInboxManagePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='mynotifications-date']")
	public WebElement NotificationDateTextBox;
	
	@FindBy(xpath="//button[contains(text(),'Back To My Inbox')]")
	public WebElement BackToMyInboxBtn;

	@FindBy(xpath="//button[@onclick = 'forwardMyNotifications()']")
	public WebElement ForwardToAnotherRecipientBtn;
	
	@FindBy(xpath="//input[@id='mynotifications-subject']")
	public WebElement SubjectTextBox;

	public String readNotificationDate() {
		return Source.SeleniumHelper().readAttribute(NotificationDateTextBox, "value");
	}
	
	public MyHomePage clickBackToMyInbox() {
		Source.SeleniumHelper().clickElement(BackToMyInboxBtn);
		return new MyHomePage(DriverFactory.getDriver());
	}
	
	public String readSubject() {
		return Source.SeleniumHelper().readElement(SubjectTextBox);
	}

	public ForwardPage clickForwardToAnotherRecipient() {
		Source.SeleniumHelper().clickElement(ForwardToAnotherRecipientBtn);
		return new ForwardPage(DriverFactory.getDriver());
	}

}

