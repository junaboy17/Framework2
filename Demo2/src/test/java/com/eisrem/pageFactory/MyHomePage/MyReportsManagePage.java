package com.eisrem.pageFactory.MyHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;


public class MyReportsManagePage extends DataTable{

	public MyReportsManagePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	ObjectSource Source = new ObjectSource();

	@FindBy(xpath="//h3[contains(text(),'My Reports')]")
	public WebElement MyReportsManagePageTitle;
		
	@FindBy(xpath="//a[contains(text(),'My Reports')]")
	public WebElement MyReportsLinkTitle;	
		
	@FindBy(xpath="//label[contains(text(),'Available')]")
	public WebElement AvailableTitle;
	
	@FindBy(xpath="//input[@id='myReportsDualListBox-unselectedOptions-filter']")
	public WebElement AvailableFilterTextBox;
	
	@FindBy(xpath="//button[@id='myReportsDualListBox-moveRightBtn']")
	public WebElement AddButton;
	
	@FindBy(xpath="//button[@id='myReportsDualListBox-moveLeftBtn']")
	public WebElement RemoveButton;
	
	@FindBy(xpath="//button[@id='myReportsDualListBox-saveSubmitBtn']")
	public WebElement SaveButton;
		
	@FindBy(xpath="//label[contains(text(),'Selected')]")
	public WebElement SelectedTitle;
	
	@FindBy(xpath="//input[@id='myReportsDualListBox-selectedOptions-filter']")
	public WebElement SelectedFilterTextBox;
	
	@FindBy(xpath="//select[@id='myReportsDualListBox-selectedOptions']//option[1]")
	public WebElement SelectedFirstRow;
	
	@FindBy(xpath="//div[@style='padding-top:45px;padding-bottom:15px;']/span")
	public WebElement TransitionReportTitle;
		
	public String readMyReportsManagePageTitle() {
		return Source.SeleniumHelper().readElement(MyReportsManagePageTitle);
	}
		
	public String readMyReportsLinkTitle() {
		return Source.SeleniumHelper().readElement(MyReportsLinkTitle);
	}
	
	public String readAvailableTitle() {
		return Source.SeleniumHelper().readElement(AvailableTitle);
	}
	
	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}
	
	public MyReportsManagePage clickMyReportsAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return this;
	}
	
	public String readRemoveBtn() {
		return Source.SeleniumHelper().readElement(RemoveButton);
	}
	
	public MyReportsManagePage clickRemove() {
		Source.SeleniumHelper().clickElement(RemoveButton);
		return new MyReportsManagePage(DriverFactory.getDriver());
	}
	
	public String readSaveBtn() {
		return Source.SeleniumHelper().readElement(SaveButton);
	}
	
	public MyReportsManagePage clickSaveMyReports() {
		Source.SeleniumHelper().clickElement(SaveButton);
		return this;
	}
	
	public String readSelectedTitle() {
		return Source.SeleniumHelper().readElement(SelectedTitle);
	}
	
	public MyReportsManagePage setAvailableFilter(String Reports, String... Clear) {
		Source.SeleniumHelper().setText(AvailableFilterTextBox, Reports + Keys.TAB, Clear).sleep(3);
		return this;
	}
	
	public MyReportsManagePage selectAvailableReport(int ReportNum) {
		By Report = By.xpath("//select[@id='myReportsDualListBox-unselectedOptions']//option[" + ReportNum + "]");
		Source.SeleniumHelper().clickElement(Report);
		return this;
	}
	
	public MyReportsManagePage selectAvailableReport(String ReportNum) {
		By Report = By.xpath("//select[@id='myReportsDualListBox-unselectedOptions']//option[contains(text(), '" + ReportNum + "')]");
		Source.SeleniumHelper().clickElement(Report);
		return this;
	}
	
	public MyReportsManagePage setSelectedFilter(String Report, String... Clear) {
		Source.SeleniumHelper().setText(SelectedFilterTextBox, Report + Keys.TAB, Clear);
		return this;
	}
	
	public MyReportsManagePage selectSelectedReport(int ReportNum) {
		By Report = By.xpath("//select[@id='myReportsDualListBox-selectedOptions']//option[" + ReportNum + "]");
		Source.SeleniumHelper().clickElement(Report);
		return this;
	}
	
	public MyReportsManagePage selectSelectedReport(String ReportNum) {
		By Report = By.xpath("//select[@id='myReportsDualListBox-selectedOptions']//option[contains(text(), '" + ReportNum + "')]");
		Source.SeleniumHelper().clickElement(Report);
		return this;
	}
	
	public MyReportsManagePage selectAllAvailableReports() {
				selectAvailableReport(1)
				.GetSource()
				.SeleniumHelper()
				.selectAll();
		return this;
	}
	
	public MyReportsManagePage selectAllSelectedReports() {
				selectSelectedReport(1)
				.GetSource()
				.SeleniumHelper()
				.selectAll();
		return this;
	}
	
	public MyReportsManagePage RemoveAllSelectedReports() {
		boolean Value = Source. SeleniumHelper().ifWebElementExists(SelectedFirstRow, 1);

		if(Value == T) {
			selectSelectedReport(1)
			.GetSource()
			.SeleniumHelper()
			.selectAll()
			.GetSource()
			.MyReportsManagePage()
			.clickRemove();
		}
		return this;
	}
	
	public MyReportsManagePage RemoveAllSelectedReports(boolean GoToHomePage) {
		if(GoToHomePage == T) {
		boolean Value = Source. SeleniumHelper().ifWebElementExists(SelectedFirstRow, 1);

		if(Value == T) {
			selectSelectedReport(1)
			.GetSource()
			.SeleniumHelper()
			.selectAll()
			.GetSource()
			.MyReportsManagePage()
			.clickRemove()
			.clickSaveMyReports()
			.clickGoBackToList();
		}
		else {
			Source	.NavigationMenuBar()
					.clickMyHomePage();
		}
	}else {
		RemoveAllSelectedReports();
	}
		return this;
	}
	
	public String readTransitionReportTitle() {
		return Source.SeleniumHelper().readElement(TransitionReportTitle);
	}
	
	public ObjectSource GetSource() {
		return new ObjectSource();
	}
	
	}

