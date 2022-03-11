package com.eisrem.pageFactory.MyHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.Assessment_Forms.Assessment_FormsPage;
import com.eisrem.pageFactory.CommonPage.FormPage;
import com.eisrem.pageFactory.CommonPage.Pagefactory;
import com.eisrem.pageFactory.Notes.NotesPage;


public class MyClientsManagePage extends Pagefactory{

	public MyClientsManagePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'My Clients')]")
	public WebElement MyClientsManagePageTitle;

	@FindBy(xpath="//a[contains(text(),'My Clients')]")
	public WebElement MyClientsAccord;	

	@FindBy(xpath="//label[contains(text(),'Available')]")
	public WebElement AvailableTitle;
	
	@FindBy(xpath="//input[@id='myPeopleDualListBox-unselectedOptions-filter']")
	public WebElement AvailableFilterTextBox;
	
	@FindBy(xpath="//select[@id='myPeopleDualListBox-unselectedOptions']")
	public WebElement AvailableDropDown;
	
	@FindBy(xpath="//select[@id='myPeopleDualListBox-unselectedOptions']/option[1]")
	public WebElement AvailableFirstRow;
	
	@FindBy(xpath="//div[@id='myPeopleDualListBox-recordStatus']")
	public WebElement ShowingAvaiableEntriesMsg;

	@FindBy(xpath="//button[@id='myPeopleDualListBox-moveRightBtn']")
	public WebElement AddButton;

	@FindBy(xpath="//button[@id='myPeopleDualListBox-moveLeftBtn']")
	public WebElement RemoveButton;

	@FindBy(xpath="//button[@id='myPeopleDualListBox-saveSubmitBtn']")
	public WebElement SaveButton;

	@FindBy(xpath="//label[contains(text(),'Selected')]")
	public WebElement SelectedTitle;

	@FindBy(xpath="//input[@id='myPeopleDualListBox-selectedOptions-filter']")
	public WebElement SelectedFilterTextBox;
	
	@FindBy(xpath="//select[@id='myPeopleDualListBox-selectedOptions']")
	public WebElement SelectedDropDown;
	
	@FindBy(xpath="//select[@id='myPeopleDualListBox-selectedOptions']//option[1]")
	public WebElement SelectedFirstRow;
			
	public String readMyClientsManagePageTitle() {
		return Source.SeleniumHelper().readElement(MyClientsManagePageTitle);
	}

	public String readMyClientsAccord() {
		return Source.SeleniumHelper().readElement(MyClientsAccord);
	}

	public String readAvailableTitle() {
		return Source.SeleniumHelper().readElement(AvailableTitle);
	}
	
	public String readAvailableFirstRow() {
		return Source.SeleniumHelper().readElement(AvailableFirstRow);
	}
	
	public MyClientsManagePage setAvailableFilter(String Clients, String... Clear) {
		Source.SeleniumHelper().setText(AvailableFilterTextBox, Clients + Keys.TAB, Clear).sleep(3);
		return this;
	}
	
	public MyClientsManagePage selectAvailableClient(int Client) {
		By Person = By.xpath("//select[@id='myPeopleDualListBox-unselectedOptions']//option[" + Client + "]");
		Source.SeleniumHelper().clickElement(Person);
		return this;
	}
	
	public MyClientsManagePage selectAvailableClient(String Client) {
		By Person = By.xpath("//select[@id='myPeopleDualListBox-unselectedOptions']//option[contains(text(), '" + Client + "')]");
		Source.SeleniumHelper().clickElement(Person);
		return this;
	}
	
	public String readShowingAvaiableEntriesMsg() {
		return Source.SeleniumHelper().readElement(ShowingAvaiableEntriesMsg);
	}

	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}
	
	public MyClientsManagePage clickAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return this;
	}

	public String readRemoveBtn() {
		return Source.SeleniumHelper().readElement(RemoveButton);
	}
	
	public MyClientsManagePage clickRemove() {
		Source.SeleniumHelper().clickElement(RemoveButton);
		return new MyClientsManagePage(DriverFactory.getDriver());
	}

	public String readSaveBtn() {
		return Source.SeleniumHelper().readElement(SaveButton);
	}
	
	public MyClientsManagePage clickSaveMyClients() {
		Source.SeleniumHelper().clickElement(SaveButton);
		return this;
	}

	public String readSelectedTitle() {
		return Source.SeleniumHelper().readElement(SelectedTitle);
	}
	
	public MyClientsManagePage setSelectedFilter(String Client, String... Clear) {
		Source.SeleniumHelper().setText(SelectedFilterTextBox, Client + Keys.TAB, Clear);
		return this;
	}
	
	public MyClientsManagePage selectSelectedClient(int Client) {
		By Person = By.xpath("//select[@id='myPeopleDualListBox-selectedOptions']//option[" + Client + "]");
		Source.SeleniumHelper().clickElement(Person);
		return this;
	}
	
	public MyClientsManagePage selectSelectedClient(String Client) {
		By Person = By.xpath("//select[@id='myPeopleDualListBox-selectedOptions']//option[contains(text(), '" + Client + "')]");
		Source.SeleniumHelper().clickElement(Person);
		return this;
	}
	
	public MyClientsManagePage selectAllAvailableClients() {
				selectAvailableClient(1)
				.GetSource()
				.SeleniumHelper()
				.selectAll();
		return this;
	}
	
	public MyClientsManagePage selectAllSelectedClients() {
				selectSelectedClient(1)
				.GetSource()
				.SeleniumHelper()
				.selectAll();
		return this;
	}
	
	public MyClientsManagePage RemoveAllSelectedClients() {
		boolean Value = Source. SeleniumHelper().ifWebElementExists(SelectedFirstRow, 1);

		if(Value == T) {
			selectSelectedClient(1)
			.GetSource()
			.SeleniumHelper()
			.selectAll()
			.GetSource()
			.MyClientsManagePage()
			.clickRemove();
		}
		return this;
	}
	
	public MyClientsManagePage RemoveAllSelectedClients(boolean GoToHomePage) {
		if(GoToHomePage == T) {
		boolean Value = Source. SeleniumHelper().ifWebElementExists(SelectedFirstRow, 1);

		if(Value == T) {
			selectSelectedClient(1)
			.GetSource()
			.SeleniumHelper()
			.selectAll()
			.GetSource()
			.MyClientsManagePage()
			.clickRemove()
			.clickSaveMyClients()
			.clickGoBackToList();
		}
		else {
			Source	.NavigationMenuBar()
					.clickMyHomePage();
		}
	}else {
		RemoveAllSelectedClients();
	}
		return this;
	}
	
	public MyClientsManagePage AddUpTo100AvailableClients() {
		boolean Value = Source. SeleniumHelper().ifWebElementExists(AvailableFirstRow, 1);

		if(Value == T) {
			selectAvailableClient(1)
			.GetSource()
			.SeleniumHelper()
			.selectAll()
			.GetSource()
			.MyClientsManagePage()
			.clickAdd();
		}
		return this;
	}
	
	public MyClientsManagePage AddUpTo100AvailableClients(boolean GoToHomePage) {
	if(GoToHomePage == T) {
		
		boolean Value = Source. SeleniumHelper().ifWebElementExists(AvailableFirstRow, 1);
	
		if(Value == T) {
			selectAvailableClient(1)
			.GetSource()
			.SeleniumHelper()
			.selectAll()
			.GetSource()
			.MyClientsManagePage()
			.clickAdd()
			.clickSaveMyClients()
			.clickGoBackToList();
		}
		else {
			Source	.NavigationMenuBar()
					.clickMyHomePage();
		}
	}else {
		AddUpTo100AvailableClients();
	}
		return this;
	}
}

