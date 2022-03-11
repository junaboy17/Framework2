package com.eisrem.pageFactory.MyHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Admin.LogInPage;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;


public class ForwardPage extends DataTable{

	public ForwardPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//textarea[@id = 'forwardMessage']")
	public WebElement ForwardMessageTextBox;
	
	@FindBy(xpath="//input[@id= 'forwardNotificationsDuaListBox-unselectedOptions-filter']")
	public WebElement AvailableFilterTextBox;
	
	@FindBy(xpath="//button[@id = 'forwardNotificationsDuaListBox-moveRightBtn']")
	public WebElement AddBtn;
	
	@FindBy(xpath="//button[@id = 'forwardNotificationsDuaListBox-moveLeftBtn']")
	public WebElement RemoveBtn;
	
	@FindBy(xpath="//button[@id = 'forwardNotificationsDuaListBox-saveSubmitBtn']")
	public WebElement ForwardBtn;
			
	@FindBy(xpath="//select[@id='forwardNotificationsDuaListBox-unselectedOptions']")
	public WebElement AvailableClientsDropdown;
	
	public ForwardPage setForwardMessage(String message, String... Clear) {
		Source.SeleniumHelper().setText(ForwardMessageTextBox, message, Clear);
		return this;
	}
	
	public ForwardPage setAvailableSearch(String value, String... Clear) {
		Source	.SeleniumHelper()
		.setText(AvailableFilterTextBox, value + Keys.TAB, Clear);
		return this;
	}
	
	public ForwardPage selectAvailableClient(int position) {
		Source.SeleniumHelper().select(AvailableClientsDropdown, position);
		return this;
	}
	
	public String readAvailableResult(int position) {
		return Source.SeleniumHelper().readElement(By.xpath("//select[@id='forwardNotificationsDuaListBox-unselectedOptions']/option["+ position +"]"));
	}
		
	public ForwardPage clickAddName() {
		Source.SeleniumHelper().clickElement(AddBtn);
		return this;
	}
	
	public ForwardPage clickForward() {
		Source.SeleniumHelper().clickElement(ForwardBtn);
		return this;
	}	
}