package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.Administrator.NotificationsPage;

public class MessageContentAccord extends NotificationsPage{

	public MessageContentAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class =' text-center col-xs-4 col-sm-4 col-md-4 col-lg-4'] [1]")
	public WebElement TypeTitle;

	@FindBy(xpath="//select[@class='form-control'] [@groupname='NOTIFICATIONS.MESSAGE_TYPE']")
	public WebElement TypeDropDown;

	@FindBy(xpath="//div[@class =' text-center col-xs-4 col-sm-4 col-md-4 col-lg-4'] [2]")
	public WebElement ValueTitle;

	@FindBy(xpath="//input[@class='form-control'] [@onchange='messageValueChange(event)']")
	public WebElement ValueTextBox;
	
	@FindBy(xpath="//select[@class='form-control'] [@onchange='messageValueChange(event)']")
	public WebElement ValueSelectBox;
	
	@FindBy(xpath="//input[@class='form-control'] [@onchange='messageValueChange(event)'] | //select[@class='form-control'] [@onchange='messageValueChange(event)']")
	public WebElement ValueBox;

	@FindBy(xpath="//div[@class =' text-center col-xs-4 col-sm-4 col-md-4 col-lg-4'] [3]")
	public WebElement ControlsTitle;

	@FindBy(xpath="//button[@id='addMessageCriteria']")
	public WebElement AddCriteriaBtn;

	@FindBy(xpath="//button[@id='removeMessageCriteria']")
	public WebElement RemoveCriteriaBtn;

	@FindBy(xpath="//label[contains(text(),'Message Preview')]")
	public WebElement MessagePreviewTitle;

	@FindBy(xpath="//textarea[@id='message-preview']")
	public WebElement MessagePreviewTextBox;
	
	public String readMessageContentTypeTitle() {
		return Source.SeleniumHelper().readElement(TypeTitle);
	}
	
	public MessageContentAccord selectMessageContentType(int index) {
		Source.SeleniumHelper().select(TypeDropDown, index);
		return this;
	}
	
	public MessageContentAccord selectMessageContentType(int rownum, int index) {
		Source.SeleniumHelper().select(By.xpath("//div[@class='row message-criterion'][" + rownum + "]//select[@groupname='NOTIFICATIONS.MESSAGE_TYPE']"), index);
		return this;
	}
	
	public String readMessageContentValueTitle() {
		return Source.SeleniumHelper().readElement(ValueTitle);
	}

	public MessageContentAccord setMessageContentValue(String value, String... Clear) {
		Source.SeleniumHelper().setText(ValueTextBox, value, Clear);
		return this;
	}
	
	public MessageContentAccord selectMessageContentValue(int rownum, int index) {
		Source.SeleniumHelper().select(By.xpath("//div[@class='row message-criterion'][" + rownum + "]//select[@onchange='messageValueChange(event)']"), index);
		return this;
	}
	
	public String isMessageContentValueEnabled()
	{
		Source.SeleniumHelper().highLightElement(ValueBox);
		Boolean enabled = ValueBox.isEnabled();
		Source.SeleniumHelper().unhighLightElement(ValueBox);
		return Boolean.toString(enabled);
	}
		
	public String readMessageContentControlsTitle() {
		return Source.SeleniumHelper().readElement(ControlsTitle);
	}
	
	public String readMessageContentAddCriteriaBtnTitle() {
		return Source.SeleniumHelper().readElement(AddCriteriaBtn);
	}

	public SetConditionsAccord clickMessageContentAddCriteria() {
		Source.SeleniumHelper().clickElement(AddCriteriaBtn);
		return new SetConditionsAccord(DriverFactory.getDriver());
	}
	
	public SetConditionsAccord clickMessageContentAddCriteria(int rownum) {
		Source.SeleniumHelper().clickElement(By.xpath("//div[@class='row message-criterion']["+ rownum +"]//button[@id='addMessageCriteria']"));
		return new SetConditionsAccord(DriverFactory.getDriver());
	}
	
	public String readMessageContentRemoveCriteriaBtnTitle() {
		return Source.SeleniumHelper().readElement(RemoveCriteriaBtn);
	}

	public SetConditionsAccord clickMessageContentRemoveCriteria() {
		Source.SeleniumHelper().clickElement(RemoveCriteriaBtn);
		return new SetConditionsAccord(DriverFactory.getDriver());
	}
	
	public String readMessageContentMessagePreviewBtnTitle() {
		return Source.SeleniumHelper().readElement(MessagePreviewTitle);
	}

	public MessageContentAccord setMessageContentMessagePreview(String preview, String... Clear) {
		Source.SeleniumHelper().setText(MessagePreviewTextBox, preview, Clear);
		return this;
	}

}
