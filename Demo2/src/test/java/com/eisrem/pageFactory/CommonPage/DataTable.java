package com.eisrem.pageFactory.CommonPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.ObjectSource;

public class DataTable extends Pagefactory{

	public DataTable(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class= 'dataTables_length']//label")
	public WebElement ShowEntries;

	@FindBy(xpath="//div[@class= 'dataTables_length']//select")
	public WebElement ShowEntriesDropdown;

	@FindBy(xpath="//div[@class='dataTables_info']")
	public WebElement ShowNoOfEntries;	

	@FindBy(xpath="//span[contains(text(),'Add')]")
	public WebElement AddButton;

	@FindBy(xpath="//a//span[contains(text(),'Anchor')]")
	public WebElement AnchorButton;

	@FindBy(xpath="//span[contains(text(),'Edit')]")
	public WebElement EditButton;

	@FindBy(xpath="//span[contains(text(),'Run')]")
	public WebElement RunButton;

	@FindBy(xpath="//span[contains(text(),'Remove')]")
	public WebElement RemoveButton;

	@FindBy(xpath="//span[contains(text(),'View')]")
	public WebElement ViewButton;

	@FindBy(xpath="//span[contains(text(),'Excel')]")
	public WebElement ExcelButton;

	@FindBy(xpath="//label[contains(text(),'Search')]")
	public WebElement SearchTitle;

	@FindBy(xpath="//input[@type='search']")
	public WebElement SearchTextBox;

	@FindBy(xpath="//th[contains(text(),'ID')] | //th[contains(text(),'Id')]")
	public WebElement IdList;

	@FindBy(xpath="//th[contains(text(),'ID')]/img | //th[contains(text(),'Id')]/img")
	public WebElement IdSort;

	@FindBy(xpath="//th[contains(text(),'Name')]")
	public WebElement NameList;

	@FindBy(xpath="//th[contains(text(),'Name')]/img[1]")
	public WebElement NameSort;

	@FindBy(xpath="//th[contains(text(),'Sort Order')]")
	public WebElement SortOrderList;

	@FindBy(xpath="//th[contains(text(),'Sort Order')]/img")
	public WebElement SortOrderSort;

	@FindBy(xpath="//th[contains(text(),'Required')]")
	public WebElement RequiredList;

	@FindBy(xpath="//thead/tr[1]/th[4]/img[1]")
	public WebElement RequiredSort;

	@FindBy(xpath="//th[contains(text(),'Page Locked')]")
	public WebElement PageLockedList;

	@FindBy(xpath="//th[contains(text(),'Page Locked')]/img")
	public WebElement PageLockedSort;

	@FindBy(xpath="//th[contains(text(),'Lookup Score')]")
	public WebElement LookupScoreList;

	@FindBy(xpath="//th[contains(text(),'Lookup Score')]/img")
	public WebElement LookupScoreSort;

	@FindBy(xpath="//th[contains(text(),'Indent')]")
	public WebElement IndentList;

	@FindBy(xpath="//th[contains(text(),'Indent')]/img")
	public WebElement IndentSort;

	@FindBy(xpath="//th[contains(text(),'Start Date')]")
	public WebElement StartDateList;

	@FindBy(xpath="//th[contains(text(),'Start Date')]/img")
	public WebElement StartDateSort;

	@FindBy(xpath="//th[contains(text(),'End Date')]")
	public WebElement EndDateList;

	@FindBy(xpath="//th[contains(text(),'End Date')]/img")
	public WebElement EndDateSort;

	@FindBy(xpath="//th[contains(text(),'Active')]")
	public WebElement ActiveList;

	@FindBy(xpath="//th[contains(text(),'Active')]/img")
	public WebElement ActiveSort;	

	@FindBy(xpath="//th[contains(text(),'Modified Date')]")
	public WebElement ModifiedDateList;

	@FindBy(xpath="//th[contains(text(),'Modified Date')]/img[1]")
	public WebElement ModifiedDateSort;

	@FindBy(xpath="//th[contains(text(),'Type')]")
	public WebElement TypeList;

	@FindBy(xpath="//th[contains(text(),'Type')]/img[1]")
	public WebElement TypeSort;

	@FindBy(xpath="//th[contains(text(),'App Area')]")
	public WebElement AppAreaSection;

	@FindBy(xpath="//th[contains(text(),'Modules')]")
	public WebElement ModulesSection;

	@FindBy(xpath="//th[contains(text(),'Add')]")
	public WebElement AddSection;

	@FindBy(xpath="//th[contains(text(),'View')]")
	public WebElement ViewSection;

	@FindBy(xpath="//th[contains(text(),'Edit')]")
	public WebElement EditSection;

	@FindBy(xpath="//a[contains(text(),'Previous')]")
	public WebElement PreviousBtn;

	@FindBy(xpath="//a[contains(text(),'Next')]")
	public WebElement nextBtn;

	@FindBy(xpath="//table//tbody//tr[@role='row'][1]")
	public WebElement FirstRow;

	@FindBy(xpath="//table//tbody//tr[@role='row'][2]")
	public WebElement SecondRow;

	@FindBy(xpath="//a[@data-dt-idx='1']")
	public WebElement pageTab1;

	@FindBy(xpath="//a[@data-dt-idx='2']")
	public WebElement pageTab2;

	@FindBy(xpath="//a[@data-dt-idx='3']")
	public WebElement pageTab3;

	@FindBy(xpath="//a[@data-dt-idx='4']")
	public WebElement pageTab4;

	@FindBy(xpath="//a[@data-dt-idx='5']")
	public WebElement pageTab5;

	@FindBy(xpath="//a[@data-dt-idx='6']")
	public WebElement pageTab6;
	
	@FindBy(xpath="//a[@data-dt-idx='7']")
	public WebElement pageTab7;

	@FindBy(xpath="//a[contains(@class,'paginate_button')]")
	public List<WebElement> pageTabAll;

	@FindBy(xpath="//tbody//tr")
	public List <WebElement> allDataResult;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[1]//td[1] | //table[contains(@id,'searchResults')]//tr[1]//td[1]")
	public WebElement FirstResultID;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[1]//td[2] | //table[contains(@id,'searchResults')]//tr[1]//td[1]")
	public WebElement FirstResultNameType;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[2]//td[2] | //table[contains(@id,'searchResults')]//tr[2]//td[1]")
	public WebElement SecondResultNameType;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[3]//td[2] | //table[contains(@id,'searchResults')]//tr[3]//td[1]")
	public WebElement ThirdResultNameType;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[4]//td[2] | //table[contains(@id,'searchResults')]//tr[4]//td[1]")
	public WebElement FourthResultNameType;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[1]//td[3] | //table[contains(@id,'searchResults')]//tr[]//td[1]")
	public WebElement FirstResultStartDate;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[1]//td[4] | //table[contains(@id,'searchResults')]//tr[1]//td[1]")
	public WebElement FirstResultEndDate;

	@FindBy(xpath="//table[contains(@id,'table')]//tr[1]//td[5] | //table[contains(@id,'searchResults')]//tr[1]//td[1]")
	public WebElement FirstResultModifiedDate;

	@FindBy(xpath="//p[@class='copyright']")
	public WebElement copyrightTitle;

	@FindBy(xpath="//td[contains(@class, 'dataTables_empty')]")
	public WebElement emptyDataTable;

	//Functions
	public String readShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(ShowEntries);
	}

	public DataTable selectShowEntries(int index) {
		Source.SeleniumHelper().select(ShowEntriesDropdown, index);
		return this;
	}

	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}

	public ObjectSource clickAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return new ObjectSource();
	}

	public String readRunBtn() {
		return Source.SeleniumHelper().readElement(RunButton);
	}

	public ObjectSource clickRun() {
		Source.SeleniumHelper().clickElement(RunButton);
		return new ObjectSource();
	}

	public String readRemoveBtn() {
		return Source.SeleniumHelper().readElement(RemoveButton);
	}

	public DataTable clickRemove() {
		Source.SeleniumHelper().clickElement(RemoveButton);
		return this;
	}

	public String readAnchorBtn() {
		return Source.SeleniumHelper().readElement(AnchorButton);
	}

	public ObjectSource clickAnchor() {
		Source.SeleniumHelper().clickElement(AnchorButton);
		return new ObjectSource();
	}

	public String readEditBtn() {
		return Source.SeleniumHelper().readElement(EditButton);
	}

	public ObjectSource clickEdit() {
		Source.SeleniumHelper().clickElement(EditButton);
		return new ObjectSource();
	}

	public String readViewBtn() {
		return Source.SeleniumHelper().readElement(ViewButton);
	}

	public ObjectSource clickView() {
		Source.SeleniumHelper().clickElement(ViewButton);
		return new ObjectSource();
	}

	public String readExcelBtn() {
		return Source.SeleniumHelper().readElement(ExcelButton);
	}

	public ObjectSource clickExcel() {
		Source.SeleniumHelper().clickElement(ExcelButton);
		return new ObjectSource();
	}

	public DataTable clickIdSort() {
		Source.SeleniumHelper().clickElement(IdList);
		return this;
	}

	public String readIdList() {
		return Source.SeleniumHelper().readElement(IdList);
	}

	public String readActiveList() {
		return Source.SeleniumHelper().readElement(ActiveList);
	}

	public DataTable clickActiveSort() {
		Source.SeleniumHelper().clickElement(ActiveList);
		return this;
	}

	public String readTypeList() {
		return Source.SeleniumHelper().readElement(TypeList);
	}

	public DataTable clickTypeSort() {
		Source.SeleniumHelper().clickElement(TypeList);
		return this;
	}

	public String readNameList() {
		return Source.SeleniumHelper().readElement(NameList);
	}

	public DataTable clickNameSort() {
		Source.SeleniumHelper().clickElement(NameList);
		return this;
	}

	public String readSortOrderList() {
		return Source.SeleniumHelper().readElement(SortOrderList);
	}

	public DataTable clickSortOrder() {
		Source.SeleniumHelper().clickElement(SortOrderList);
		return this;
	}
	
//	public DataTable clickIDSort() {
//		Source.SeleniumHelper().clickElement(SortOrderList);
//		return this;
//	}

	public String readRequiredList() {
		return Source.SeleniumHelper().readElement(RequiredList);
	}

	public DataTable clickRequiredList() {
		Source.SeleniumHelper().clickElement(RequiredList);
		return this;
	}

	public String readPageLockedList() {
		return Source.SeleniumHelper().readElement(PageLockedList);
	}

	public DataTable clickPageLocked() {
		Source.SeleniumHelper().clickElement(PageLockedList);
		return this;
	}

	public DataTable clickLookupScore() {
		Source.SeleniumHelper().clickElement(LookupScoreList);
		return this;
	}

	public String readLookupScoreList() {
		return Source.SeleniumHelper().readElement(LookupScoreList);
	}

	public DataTable clickIndentSort() {
		Source.SeleniumHelper().clickElement(IndentList);
		return this;
	}

	public String readIndentList() {
		return Source.SeleniumHelper().readElement(IndentList);
	}

	public DataTable clickStartDateSort() {
		Source.SeleniumHelper().clickElement(StartDateList);
		return this;
	}

	public String readStartDateList() {
		return Source.SeleniumHelper().readElement(StartDateList);
	}

	public DataTable clickEndDateSort() {
		Source.SeleniumHelper().clickElement(EndDateList);
		return this;
	}

	public String readEndDateList() {
		return Source.SeleniumHelper().readElement(EndDateList);
	}

	public DataTable clickModifiedDateSort() {
		Source.SeleniumHelper().clickElement(ModifiedDateList);
		return this;
	}

	public String readModifiedDateList() {
		return Source.SeleniumHelper().readElement(ModifiedDateList);
	}

	public String readAppAreaList() {
		return Source.SeleniumHelper().readElement(AppAreaSection);
	}

	public String readModulesList() {
		return Source.SeleniumHelper().readElement(ModulesSection);
	}

	public String readAddList() {
		return Source.SeleniumHelper().readElement(AddSection);
	}

	public String readViewList() {
		return Source.SeleniumHelper().readElement(ViewSection);
	}

	public String readEditList() {
		return Source.SeleniumHelper().readElement(EditSection);
	}

	public DataTable clickPrevious() {
		Source.SeleniumHelper().clickElement(PreviousBtn);
		return this;
	}

	public String readPreviousBtn() {
		return Source.SeleniumHelper().readElement(PreviousBtn);
	}

	public DataTable clickNext() {
		Source.SeleniumHelper().clickElement(nextBtn);
		return this;
	}

	public String readNextBtn() {
		return Source.SeleniumHelper().readElement(nextBtn);
	}

	public DataTable clickFirstRow() {
		Source.SeleniumHelper().clickElement(FirstRow);
		return this;
	}

	public DataTable clickSecondRow() {
		Source.SeleniumHelper().clickElement(SecondRow);
		return this;
	}

	public DataTable clickPageTab1() {
		Source.SeleniumHelper().clickElement(pageTab1);
		return this;
	}

	public String readPageTab1() {
		return Source.SeleniumHelper().readElement(pageTab1);
	}

	public DataTable clickPageTab2() {
		Source.SeleniumHelper().clickElement(pageTab2);
		return this;
	}

	public String readPageTab2() {
		return Source.SeleniumHelper().readElement(pageTab2);
	}

	public DataTable clickPageTab3() {
		Source.SeleniumHelper().clickElement(pageTab3);
		return this;
	}

	public String readPageTab3() {
		return Source.SeleniumHelper().readElement(pageTab3);
	}

	public DataTable clickPageTab4() {
		Source.SeleniumHelper().clickElement(pageTab4);
		return this;
	}

	public String readPageTab4() {
		return Source.SeleniumHelper().readElement(pageTab4);
	}

	public DataTable clickPageTab5() {
		Source.SeleniumHelper().clickElement(pageTab5);
		return this;
	}

	public String readPageTab5() {
		return Source.SeleniumHelper().readElement(pageTab5);
	}

	public DataTable clickPageTab6() {
		Source.SeleniumHelper().clickElement(pageTab6);
		return this;
	}

	public String readPageTab6() {
		return Source.SeleniumHelper().readElement(pageTab6);
	}
	
	public DataTable clickPageTab7() {
		Source.SeleniumHelper().clickElement(pageTab7);
		return this;
	}

	public String readPageTab7() {
		return Source.SeleniumHelper().readElement(pageTab7);
	}

	public int getSizePageTabAll() {

		return pageTabAll.size();
	}

	public String readShowNoOfEntries() {
		return Source.SeleniumHelper().readElement(ShowNoOfEntries);
	}

	public String readSearchTitle() {
		return Source.SeleniumHelper().readElement(SearchTitle);
	}

	public DataTable setSearch(String value, String... Clear) {
		Source	.SeleniumHelper()
		.setText(SearchTextBox, value + Keys.TAB, Clear);
		return this;
	}

	public String readCopyright() {
		return Source.SeleniumHelper().readElement(copyrightTitle);
	}

	public String readFirstResultID() {
		return Source.SeleniumHelper().readElement(FirstResultID).replace(" Select", EmptyString);
	}

	public String readFirstResultNameType() {
		return Source.SeleniumHelper().readElement(FirstResultNameType);
	}

	public String readSecondResultNameType() {
		return Source.SeleniumHelper().readElement(SecondResultNameType);
	}

	public String readThirdResultNameType() {
		return Source.SeleniumHelper().readElement(ThirdResultNameType);
	}

	public String readFourthResultNameType() {
		return Source.SeleniumHelper().readElement(FourthResultNameType);
	}

	public String readFirstResultStartDate() {
		return Source.SeleniumHelper().readElement(FirstResultStartDate);
	}

	public String readFirstResultEndDate() {
		return Source.SeleniumHelper().readElement(FirstResultEndDate);
	}

	public String readFirstResultModifiedDate() {
		return Source.SeleniumHelper().readElement(FirstResultModifiedDate);
	}

	//Will read data from data table with given column & row
	public String readDataTable(int Row, int Column) {
		By data = By.xpath("//table[contains(@id,'table')]//tr[" + Row + "]//td[" + Column + "]");
		return Source.SeleniumHelper().readElement(data);
	}

	//Will read data from data table with given column & row
	public String readDataTable(String TableName, int Row, int Column) {
		By data = By.xpath("//table[contains(@id,'"+ TableName + "')]//tr[" + Row + "]//td[" + Column + "]");
		return Source.SeleniumHelper().readElement(data);
	}

	//Will click row based on table name and row # given
	public DataTable clickRow(int Row) {
		By row = By.xpath("//table[contains(@id,'table')]//tbody//tr[" + Row + "]");
		Source.SeleniumHelper().clickElement(row);
		return this;
	}	

	//Will click row based on table name and row # given
	public DataTable clickRow(String TableName, int Row) {
		By row = By.xpath("//table[contains(@id,'"+ TableName + "')]//tbody//tr[" + Row + "]");
		Source.SeleniumHelper().clickElement(row);
		return this;
	}	

	//Will read or click page tab in data table with given tab number
	public DataTable clickPageTab(int TabNum) {
		By pageTab = By.xpath("//a[@data-dt-idx='" + TabNum + "']");
		Source.SeleniumHelper().clickElement(pageTab);
		return this;
	}

	public String readPageTab(int TabNum) {
		By pageTab = By.xpath("//a[@data-dt-idx='" + TabNum + "']");
		return Source.SeleniumHelper().readElement(pageTab);
	}

	//Used to validate for duplicate ids
	//local table would consist of tables not in main navigation area 
	public String validateRecordIds(String localTableName){
		Boolean duplicated = false;
		List<Integer> prevIds = new ArrayList<Integer>();
		List<Integer> nextIds;

		for (int i = 0; i < 5; i++) {
			nextIds = getRecordIds(true, localTableName);
			for (Integer id : prevIds) 
				for (Integer nextId : nextIds)
					if (id.equals(nextId)) 
						duplicated = true;
			prevIds.clear();
			prevIds.addAll(nextIds);
			nextIds.clear();
			clickNext();
		}

		return Boolean.toString(duplicated);
	}

	//Used when specific table id is not known
	public String validateRecordIds(){
		Boolean duplicated = false;
		List<Integer> prevIds = new ArrayList<Integer>();
		List<Integer> nextIds;

		for (int i = 0; i < 5; i++) {
			nextIds = getRecordIds(false);
			for (Integer id : prevIds) 
				for (Integer nextId : nextIds)
					if (id.equals(nextId)) 
						duplicated = true;
			prevIds.clear();
			prevIds.addAll(nextIds);
			nextIds.clear();
			clickNext();
		}

		return Boolean.toString(duplicated);
	}

	//local table would consist of tables not in main navigation areas
	public List<Integer> getRecordIds(Boolean localTable, String... localTableName){
		List<Integer> allIds = new ArrayList<Integer>();
		List<WebElement> rows;

		//Due to loading we need sleep before and after to process the ids
		Source.SeleniumHelper().sleep(5);
		if (localTable)
			rows =  Source.SeleniumHelper().getWebElementList("//table[@id='" + localTableName + "']/tbody/tr/td[1]");
		else
			rows =  Source.SeleniumHelper().getWebElementList("//table[@id='tableName']/tbody/tr/td[1]");

		for (WebElement row : rows)
			allIds.add(Integer.valueOf(row.getText().replace(" Select", EmptyString)));

		Source.SeleniumHelper().sleep(5);
		return allIds;
	}

	public DataTable isEmptyThrowError(String... localTableName) throws Exception {

		if(Source.SeleniumHelper().ifWebElementExists(emptyDataTable, 1)) 
			throw new Exception("No Records");
		return this;
	}

	public DataTable clickFirstColumnLink() {
		Source.SeleniumHelper().clickElement(By.xpath("//tbody/tr[1]/td/a[1]"));
		return this;
	}

	public DataTable clickFirstRowNameLink() {
		Source.SeleniumHelper().clickElement(By.xpath("//tbody/tr[1]/td[2]/a[1]"));
		return this;
	}

	public HashMap<DataTableHeaders,String> getDataByRow(String row, String tableName) throws Exception {
		try {
			if (row == null)
				row = OneN;
			if (tableName == null)
				tableName = "tableName";

			HashMap<DataTableHeaders,String> x = new HashMap<DataTableHeaders,String>();
			x.put(DataTableHeaders.ID, Source.SeleniumHelper().readElement(By.xpath("//*[@id='"+ tableName +"']/tbody/tr["+ row + "]/td[1]")));
			x.put(DataTableHeaders.NAME_TYPE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='"+ tableName + "']/tbody/tr["+ row + "]/td[2]")));
			x.put(DataTableHeaders.START_DATE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='"+ tableName + "']/tbody/tr["+ row + "]/td[3]")));
			x.put(DataTableHeaders.END_DATE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='"+ tableName + "']/tbody/tr["+ row + "]/td[4]")));
			x.put(DataTableHeaders.MODIFIED_DATE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='"+ tableName + "']/tbody/tr["+ row + "]/td[5]")));
			return x;
		}
		catch (Exception e) {
			throw new Exception("Unable to map data by row \n " + e.getStackTrace().toString());
		}
	}

	public HashMap<DataTableHeaders,String> getDataByRow(String row) throws Exception {
		try {
			if (row == null)
				row = OneN;

			HashMap<DataTableHeaders,String> x = new HashMap<DataTableHeaders,String>();
			x.put(DataTableHeaders.ID, Source.SeleniumHelper().readElement(By.xpath("//*[@id='tableName']/tbody/tr["+ row + "]/td[1]")));
			x.put(DataTableHeaders.NAME_TYPE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='tableName']/tbody/tr["+ row + "]/td[2]")));
			x.put(DataTableHeaders.START_DATE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='tableName']/tbody/tr["+ row + "]/td[3]")));
			x.put(DataTableHeaders.END_DATE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='tableName']/tbody/tr["+ row + "]/td[4]")));
			x.put(DataTableHeaders.MODIFIED_DATE,  Source.SeleniumHelper().readElement(By.xpath("//*[@id='tableName']/tbody/tr["+ row + "]/td[5]")));
			return x;
		}
		catch (Exception e) {
			throw new Exception("Unable to map data by row \n " + e.getStackTrace().toString());
		}
	}
}
