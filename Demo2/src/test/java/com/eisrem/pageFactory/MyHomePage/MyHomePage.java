package com.eisrem.pageFactory.MyHomePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.DataTable;


public class MyHomePage extends DataTable{

	public MyHomePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	ObjectSource Source = new ObjectSource();

	@FindBy(xpath="//h3[contains(text(),'My Home Page')]")
	public WebElement MyHomePageTitle;

	@FindBy(xpath="//a[contains(text(),'My Dashboard')]")
	public WebElement MyDashboardTab;

	@FindBy(xpath="//a[contains(text(),'My Inbox')]")
	public WebElement MyInboxLink;

	@FindBy(xpath="//div[@id= 'my-inbox-table_length']//label")
	public WebElement MyInboxShowEntries;

	@FindBy(xpath="//select[@aria-controls='my-inbox-table']")
	public WebElement MyInboxShowEntriesDropdown;

	@FindBy(xpath="//span[contains(text(),'Dismiss')]")
	public WebElement MyInboxDismissButton;

	@FindBy(xpath="//span[text()='Excel']")
	public WebElement MyInboxExcelButton;

	@FindBy(xpath="//div[@id='my-inbox-table_filter'] //label")
	public WebElement MyInboxSearchTitle;

	@FindBy(xpath="//input[@aria-controls='my-inbox-table']")
	public WebElement MyInboxSearchTextBox;

	@FindBy(xpath="//th[@aria-controls='my-inbox-table'] [text()='ID']")
	public WebElement MyInboxIdList;

	@FindBy(xpath="//thead/tr[1]/th[1]/img[1]")
	public WebElement IdSort;

	@FindBy(xpath="//th[@aria-controls='my-inbox-table'] [text()='Name']")
	public WebElement MyInboxNameList;

	@FindBy(xpath="//thead/tr[1]/th[2]/img[1]")
	public WebElement NameSort;

	@FindBy(xpath="//th[@aria-controls='my-inbox-table'] [text()='Date']")
	public WebElement MyInboxDateList;

	@FindBy(xpath="//thead/tr[1]/th[3]/img[1]")
	public WebElement DateSort;

	@FindBy(xpath="//th[@aria-controls='my-inbox-table'] [text()='Source']")
	public WebElement MyInboxSourceList;

	@FindBy(xpath="//thead/tr[1]/th[4]/img[1]")
	public WebElement SourceSort;

	@FindBy(xpath="//a[@id='my-inbox-table_previous']")
	public WebElement MyInboxPreviousButton;

	@FindBy(xpath="//a[@id='my-inbox-table_next']")
	public WebElement MyInboxNextButton;

	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]")
	public WebElement MyInboxFirstRow;

	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]//td[1]")
	public WebElement MyInboxFirstResultIDValue;

	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]//td[1]//a[1]")
	public WebElement MyInboxFirstResultIDLink;

	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]//td[2]")
	public WebElement MyInboxFirstResultNameValue;

	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]//td[3]")
	public WebElement MyInboxFirstResultDateValue;

	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]//td[4]")
	public WebElement MyInboxFirstResultSourceValue;
	
	@FindBy(xpath="//table[@id='my-inbox-table']//tbody//tr[1]//td[4]/a")
	public WebElement MyInboxFirstResultGoBtn;


	//My Clients link starts

	@FindBy(xpath="//a[contains(text(),'My Clients:')]")
	public WebElement MyClientsLink;

	@FindBy(xpath="//div[@id= 'my-people-table_length']//label")
	public WebElement MyClientsShowEntries;

	@FindBy(xpath="//select[@aria-controls='my-people-table']")
	public WebElement MyClientsShowEntriesDropdown;

	@FindBy(xpath="//a[@aria-controls='my-people-table']//span [text()='Manage']")
	public WebElement MyClientsManageButton;

	@FindBy(xpath="//a[@aria-controls='my-people-table']//span [text()='Excel']")
	public WebElement MyClientsExcelButton;

	@FindBy(xpath="//div[@id='my-people-table_filter'] //label")
	public WebElement MyClientsSearchTitle;

	@FindBy(xpath="//input[@aria-controls='my-people-table']")
	public WebElement MyClientsSearchTextBox;
	
	@FindBy(xpath="//table[@id='my-people-table']//thead/tr")
	public WebElement MyClientsAllHeader;
	
	@FindBy(xpath="//table[@id='my-people-table']//tbody/tr")
	public List <WebElement> MyClientsAllData;

	@FindBy(xpath="//th[@aria-controls='my-people-table'] [text()='ID']")
	public WebElement MyClientsIdList;

	@FindBy(xpath="//th[@aria-controls='my-people-table'] [text()='Name']")
	public WebElement MyClientsNameListTitle;

	@FindBy(xpath="//th[@aria-controls='my-people-table'] [text()='DOB']")
	public WebElement MyClientsDOBListTitle;

	@FindBy(xpath="//th[@aria-controls='my-people-table'] [text()='Gender']")
	public WebElement MyClientsGenderList;

	@FindBy(xpath="//th[@aria-controls='my-people-table'] [text()='Medicaid ID']")
	public WebElement MyClientsMedicaidIDList;
	
	@FindBy(xpath="//div[@id='my-people-table_info']")
	public WebElement MyClientsShowingNumOfEntries;

	@FindBy(xpath="//a[@id='my-people-table_previous']")
	public WebElement MyClientsPreviousButton;

	@FindBy(xpath="//a[@id='my-people-table_next']")
	public WebElement MyClientsNextButton;

	//My Reports link starts

	@FindBy(xpath="//a[contains(text(),'My Reports:')]")
	public WebElement MyReportsLink;

	@FindBy(xpath="//div[@id= 'my-reports-table_length']//label")
	public WebElement MyReportsShowEntries;

	@FindBy(xpath="//select[@aria-controls='my-reports-table']")
	public WebElement MyReportsShowEntriesDropdown;

	@FindBy(xpath="//a[@aria-controls='my-reports-table']//span [text()='Run']")
	public WebElement MyReportsRunButton;

	@FindBy(xpath="//a[@aria-controls='my-reports-table']//span [text()='Manage']")
	public WebElement MyReportsManageButton;

	@FindBy(xpath="//a[@aria-controls='my-reports-table']//span [text()='Excel']")
	public WebElement MyReportsExcelButton;

	@FindBy(xpath="//div[@id='my-reports-table_filter'] //label")
	public WebElement MyReportsSearchTitle;

	@FindBy(xpath="//input[@aria-controls='my-reports-table']")
	public WebElement MyReportsSearchTextBox;

	@FindBy(xpath="//th[@aria-controls='my-reports-table'] [text()='ID']")
	public WebElement MyReportsIdList;

	@FindBy(xpath="//th[@aria-controls='my-reports-table'] [text()='Name/Type']")
	public WebElement MyReportsNameTypeList;

	@FindBy(xpath="//th[@aria-controls='my-reports-table'] [text()='Created Date']")
	public WebElement MyReportsCreatedDateList;

	@FindBy(xpath="//th[@aria-controls='my-reports-table'] [text()='Modified Date']")
	public WebElement MyReportsModifiedDateList;

	@FindBy(xpath="//th[@aria-controls='my-reports-table'] [text()='Report Type']")
	public WebElement MyReportsReportTypeList;

	@FindBy(xpath="//a[@id='my-reports-table_previous']")
	public WebElement MyReportsPreviousButton;

	@FindBy(xpath="//a[@id='my-reports-table_next']")
	public WebElement MyReportsNextButton;


	public String readMyHomePageTitle() {
		return Source.SeleniumHelper().readElement(MyHomePageTitle);
	}

	public String readMyDashboardTab() {
		return Source.SeleniumHelper().readElement(MyDashboardTab);
	}

	public MyHomePage clickMyDashboard() {
		Source.SeleniumHelper().clickElement(MyDashboardTab);
		return this;
	}

	public String readMyInboxLink() {
		return Source.SeleniumHelper().readElement(MyInboxLink);
	}

	public MyHomePage clickMyInbox() {
		Source.SeleniumHelper().clickElement(MyInboxLink);
		return this;
	}
	
//	public MyHomePage checkNewInboxMessage() {
//		Source.SeleniumHelper().sleep(600).
//		ifWebElementExists(path, sec)
//		return this;
//	}

	public String readMyInboxShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(MyInboxShowEntries);
	}

	public MyHomePage clickMyInboxShowEntries() {
		Source.SeleniumHelper().clickElement(MyInboxShowEntriesDropdown);
		return this;
	}

	public String readMyInboxDismissBtn() {
		return Source.SeleniumHelper().readElement(MyInboxDismissButton);
	}

	public MyHomePage clickMyInboxDismiss() {
		Source.SeleniumHelper().clickElement(MyInboxDismissButton);
		return this;
	}

	public String readMyInboxExcelBtn() {
		return Source.SeleniumHelper().readElement(MyInboxExcelButton);
	}

	public MyHomePage clickMyInboxExcel() {
		Source.SeleniumHelper().clickElement(MyInboxExcelButton);
		return this;
	}

	public String readMyInboxSearchTitle() {
		return Source.SeleniumHelper().readElement(MyInboxSearchTitle);
	}

	public MyHomePage setSearchMyInbox(String value, String... Clear) {
		Source.SeleniumHelper().setText(MyInboxSearchTextBox, value, Clear);
		return this;
	}

	public MyHomePage clickMyInboxId() {
		Source.SeleniumHelper().clickElement(MyInboxIdList);
		return this;
	}

	public String readMyInboxIdList() {
		return Source.SeleniumHelper().readElement(MyInboxIdList);
	}

	public MyHomePage clickMyInboxName() {
		Source.SeleniumHelper().clickElement(MyInboxNameList);
		return this;
	}

	public String readMyInboxNameList() {
		return Source.SeleniumHelper().readElement(MyInboxNameList);
	}

	public MyHomePage clickMyDate() {
		Source.SeleniumHelper().clickElement(MyInboxDateList);
		return this;
	}

	public String readMyInboxDateList() {
		return Source.SeleniumHelper().readElement(MyInboxDateList);
	}

	public MyHomePage clickMyInboxSource() {
		Source.SeleniumHelper().clickElement(MyInboxSourceList);
		return this;
	}

	public String readMyInboxSourceList() {
		return Source.SeleniumHelper().readElement(MyInboxSourceList);
	}

	public MyHomePage clickMyInboxPrevious() {
		Source.SeleniumHelper().clickElement(MyInboxPreviousButton);
		return this;
	}

	public String readMyInboxPreviousBtn() {
		return Source.SeleniumHelper().readElement(MyInboxPreviousButton);
	}

	public MyHomePage clickMyInboxNext() {
		Source.SeleniumHelper().clickElement(MyInboxNextButton);
		return this;
	}

	public String readMyInboxNextBtn() {
		return Source.SeleniumHelper().readElement(MyInboxNextButton);
	}

	public MyHomePage clickMyInboxFirstRow() {
		Source.SeleniumHelper().clickElement(MyInboxFirstRow);
		return this;
	}

	public String readMyInboxFirstRow() {
		return Source.SeleniumHelper().readElement(MyInboxFirstRow);
	}

	public String readMyInboxFirstResultIDValue() {
		return Source.SeleniumHelper().readElement(MyInboxFirstResultIDValue);
	}

	public MyInboxManagePage clickMyInboxFirstResultID() {
		Source.SeleniumHelper().clickElement(MyInboxFirstResultIDLink);
		return new MyInboxManagePage(DriverFactory.getDriver());
	}

	public String readMyInboxFirstResultNameValue() {
		return Source.SeleniumHelper().readElement(MyInboxFirstResultNameValue);
	}

	public String readMyInboxFirstResultDateValue() {
		return Source.SeleniumHelper().readElement(MyInboxFirstResultDateValue);
	}

	public String readMyInboxFirstResultSourceValue() {
		return Source.SeleniumHelper().readElement(MyInboxFirstResultGoBtn);
	}
	
	public MyHomePage clickMyInboxFirstResultGoBtn() {
		Source.SeleniumHelper().clickElement(MyInboxFirstResultGoBtn);
		return this;
	}

	//My Clients link start

	public String readMyClientsLink() {
		return Source.SeleniumHelper().readElement(MyClientsLink);
	}

	public MyHomePage clickMyClients() {
		Source.SeleniumHelper().clickElement(MyClientsLink);
		return this;
	}

	public String readMyClientsShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(MyClientsShowEntries);
	}

	public MyHomePage clickMyClientsShowEntries() {
		Source.SeleniumHelper().clickElement(MyClientsShowEntriesDropdown);
		return this;
	}

	public String readMyClientsManageBtn() {
		return Source.SeleniumHelper().readElement(MyClientsManageButton);
	}

	public MyClientsManagePage clickMyClientsManage() {
		Source.SeleniumHelper().clickElement(MyClientsManageButton);
		return new MyClientsManagePage(DriverFactory.getDriver());
	}

	public String readMyClientsExcelBtn() {
		return Source.SeleniumHelper().readElement(MyClientsExcelButton);
	}

	public MyHomePage clickMyClientsExcel() {
		Source.SeleniumHelper().clickElement(MyClientsExcelButton);
		return this;
	}

	public String readMyClientsSearchTitle() {
		return Source.SeleniumHelper().readElement(MyClientsSearchTitle);
	}

	public MyHomePage setSearchMyClients(String value, String... Clear) {
		Source.SeleniumHelper().setText(MyClientsSearchTextBox, value, Clear);
		return this;
	}

	public MyHomePage clickMyClientsIdList() {
		Source.SeleniumHelper().clickElement(MyClientsIdList);
		return this;
	}

	public String readMyClientsId() {
		return Source.SeleniumHelper().readElement(MyClientsIdList);
	}

	public MyHomePage clickMyClientsName() {
		Source.SeleniumHelper().clickElement(MyClientsNameListTitle);
		return this;
	}

	public String readMyClientsNameList() {
		return Source.SeleniumHelper().readElement(MyClientsNameListTitle);
	}

	public String readMyClientsDOBList() {
		return Source.SeleniumHelper().readElement(MyClientsDOBListTitle);
	}

	public MyHomePage clickMyClientsDOB() {
		Source.SeleniumHelper().clickElement(MyClientsDOBListTitle);
		return new MyHomePage(DriverFactory.getDriver());
	}

	public String readMyClientsGenderList() {
		return Source.SeleniumHelper().readElement(MyClientsGenderList);
	}

	public MyHomePage clickMyClientsMedicaidID() {
		Source.SeleniumHelper().clickElement(MyClientsMedicaidIDList);
		return this;
	}

	public String readMyClientsMedicaidIDList() {
		return Source.SeleniumHelper().readElement(MyClientsMedicaidIDList);
	}
	
	public String readMyClientsShowingNumOfEntries() {
		return Source.SeleniumHelper().readElement(MyClientsShowingNumOfEntries);
	}

	public MyHomePage clickMyClientsPrevious() {
		Source.SeleniumHelper().clickElement(MyClientsPreviousButton);
		return this;
	}

	public String readMyClientsPreviousButton() {
		return Source.SeleniumHelper().readElement(MyClientsPreviousButton);
	}

	public MyHomePage clickMyClientsNext() {
		Source.SeleniumHelper().clickElement(MyClientsNextButton);
		return this;
	}

	public String readMyClientsNextButton() {
		return Source.SeleniumHelper().readElement(MyClientsNextButton);
	}

	public MyHomePage RemoveAllSelectedClientsAndSave() {
		clickMyClientsManage()
		.RemoveAllSelectedClients(T);
		return this;
	}
	
	public MyHomePage AddUpTo100AvailableClientsAndSave() {
		clickMyClientsManage()
		.AddUpTo100AvailableClients(T);
		return this;
	}
	
	//Reports link begins

	public String readMyReportsLink() {
		return Source.SeleniumHelper().readElement(MyReportsLink);
	}

	public MyHomePage clickMyReports() {
		Source.SeleniumHelper().clickElement(MyReportsLink);
		return this;
	}

	public String readMyReportsShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(MyReportsShowEntries);
	}

	public MyHomePage clickMyReportsShowEntries() {
		Source.SeleniumHelper().clickElement(MyReportsShowEntriesDropdown);
		return this;
	}
	public String readMyReportsRunBtn() {
		return Source.SeleniumHelper().readElement(MyReportsRunButton);
	}

	public MyReportsManagePage clickMyReportsRun() {
		Source.SeleniumHelper().clickElement(MyReportsRunButton);
		return new MyReportsManagePage(DriverFactory.getDriver());
	}

	public String readMyReportsManageBtn() {
		return Source.SeleniumHelper().readElement(MyReportsManageButton);
	}

	public MyReportsManagePage clickMyReportsManage() {
		Source.SeleniumHelper().clickElement(MyReportsManageButton);
		return new MyReportsManagePage(DriverFactory.getDriver());
	}

	public String readMyReportsExcelBtn() {
		return Source.SeleniumHelper().readElement(MyReportsExcelButton);
	}

	public MyHomePage clickMyReportsExcel() {
		Source.SeleniumHelper().clickElement(MyReportsExcelButton);
		return this;
	}

	public String readMyReportsSearchTitle() {
		return Source.SeleniumHelper().readElement(MyReportsSearchTitle);
	}

	public MyHomePage setSearchMyReports(String value, String... Clear) {
		Source.SeleniumHelper().setText(MyReportsSearchTextBox, value, Clear);
		return this;
	}

	public MyHomePage clickMyReportsId() {
		Source.SeleniumHelper().clickElement(MyReportsIdList);
		return this;
	}

	public String readMyReportsIdList() {
		return Source.SeleniumHelper().readElement(MyReportsIdList);
	}

	public MyHomePage clickMyReportsNameType() {
		Source.SeleniumHelper().clickElement(MyReportsNameTypeList);
		return this;
	}

	public String readMyReportsNameTypeList() {
		return Source.SeleniumHelper().readElement(MyReportsNameTypeList);
	}

	public MyHomePage clickMyReportsCreatedDate() {
		Source.SeleniumHelper().clickElement(MyReportsCreatedDateList);
		return this;
	}

	public String readMyReportsCreatedDateList() {
		return Source.SeleniumHelper().readElement(MyReportsCreatedDateList);
	}

	public String readMyReportsModifiedDateList() {
		return Source.SeleniumHelper().readElement(MyReportsModifiedDateList);
	}

	public MyHomePage clickMyReportsReportType() {
		Source.SeleniumHelper().clickElement(MyReportsReportTypeList);
		return this;
	}

	public String readMyReportsReportTypeList() {
		return Source.SeleniumHelper().readElement(MyReportsReportTypeList);
	}

	public MyHomePage clickMyReportsPrevious() {
		Source.SeleniumHelper().clickElement(MyReportsPreviousButton);
		return this;
	}

	public String readMyReportsPreviousBtn() {
		return Source.SeleniumHelper().readElement(MyReportsPreviousButton);
	}

	public MyHomePage clickMyReportsNext() {
		Source.SeleniumHelper().clickElement(MyReportsNextButton);
		return this;
	}

	public String readMyReportsNextBtn() {
		return Source.SeleniumHelper().readElement(MyReportsNextButton);
	}

	//Will read data from data table with given column & row
	public String readDataTable(String TableName, int Row, int Column) {
		String Table = null;

		if(TableName.equalsIgnoreCase("Inbox")) {
			Table = "my-inbox-table";
		}else if(TableName.equalsIgnoreCase("Clients")) {
			Table = "my-people-table";
		}else if(TableName.equalsIgnoreCase("Reports")) {
			Table = "my-reports-table";
		}else {
			Log.info("Incorrect Table");
		}

		By data = By.xpath("//table[contains(@id,'" + Table + "')]//tr[" + Row + "]//td[" + Column + "]");
		return Source.SeleniumHelper().readElement(data);
	}

	//Will read data from data table with given column & row
	public Boolean ifDataExist(String TableName, int Row, int Column) {
		String Table = null;

		if(TableName.equalsIgnoreCase("Inbox")) {
			Table = "my-inbox-table";
		}else if(TableName.equalsIgnoreCase("Clients")) {
			Table = "my-people-table";
		}else if(TableName.equalsIgnoreCase("Reports")) {
			Table = "my-reports-table";
		}else {
			Log.info("Incorrect Table");
		}

		By data = By.xpath("//table[contains(@id,'" + Table + "')]//tr[" + Row + "]//td[" + Column + "]");
		return Source.SeleniumHelper().ifWebElementExists(data);
	}

	//Will read or click page tab in data table with given tab number
	public DataTable clickPageTab(String TableName, int TabNum) {
		By pageTab = By.xpath("//a[@data-dt-idx='" + TabNum + "']");
		Source.SeleniumHelper().clickElement(pageTab);
		return this;
	}

	public String readPageTab(String TableName, int TabNum) {
		By pageTab = By.xpath("//a[@data-dt-idx='" + TabNum + "']");
		return Source.SeleniumHelper().readElement(pageTab);
	}
	
	public MyHomePage addClient(String ClientName) {
						clickMyClientsManage()
						.setAvailableFilter(ClientName)
						.selectAvailableClient(1)
						.clickAdd()
						.clickSaveMyClients()
						.clickGoBackToList();
		return this;
	}
	
	public MyHomePage addFirstClient() {
						clickMyClientsManage()
						.selectAvailableClient(1)
						.clickAdd()
						.clickSaveMyClients()
						.clickGoBackToList();
		return this;
	}
	
	public MyHomePage removeClient(String ClientName) {
						clickMyClientsManage()
						.setSelectedFilter(ClientName)
						.selectSelectedClient(1)
						.clickRemove()
						.clickSaveMyClients()
						.clickGoBackToList();
		return this;
	}
	
	public MyHomePage removeFirstClient() {
						clickMyClientsManage()
						.selectSelectedClient(1)
						.clickRemove()
						.clickSaveMyClients()						
						.clickGoBackToList();
		return this;
	}
		
	public MyHomePage AddAllAvailableClients() {
						clickMyClientsManage()
						.selectAllAvailableClients()
						.clickAdd()
						.clickSaveMyClients()
						.clickGoBackToList();
		return this;
	}

}
