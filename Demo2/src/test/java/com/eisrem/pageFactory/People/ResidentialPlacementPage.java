package com.eisrem.pageFactory.People;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.Enumerations.PNMILevel;
import com.eisrem.AppUtils.Enumerations.PNMIPlacement;
import com.eisrem.AppUtils.Enumerations.PlacementType;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class ResidentialPlacementPage extends PeopleNavigator{


	public ResidentialPlacementPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='ResidentialPlacement-tab']//a")
	public WebElement ResidentialPlacementLink;

	@FindBy(xpath="//input[@id='admitDate']")
	public WebElement AdmitDate;

	@FindBy(xpath="//label[@for='admitDate']")
	public WebElement AdmitDateTitle;

	@FindBy(xpath="//input[@id='dischargeDate']")
	public WebElement DischargeDate;

	@FindBy(xpath="//label[@for='dischargeDate']")
	public WebElement DischargeDateTitle;

	@FindBy(xpath="//select[@id='type']")
	public WebElement PlacementTypeDropdown;

	@FindBy(xpath="//label[@for='type']")
	public WebElement PlacementTypeDropdownTitle;

	@FindBy(xpath="//select[@id='placement']")
	public WebElement PnmiPlacementDropdown;

	@FindBy(xpath="//label[@for='placement']")
	public WebElement PnmiPlacementDropdownTitle;

	@FindBy(xpath="//select[@id='level']")
	public WebElement LevelDropdown;

	@FindBy(xpath="//label[@for='level']")
	public WebElement LevelDropdownTitle;

	@FindBy(xpath="//button[contains(text(),'Back To Residential Placement')]")
	public WebElement BackToResidentialPlacementBtn;

	public String readLinkTitle() {
		return Source.SeleniumHelper().readElement(ResidentialPlacementLink);
	}

	public String readResidentialPlacementTitle() {
		return Source.SeleniumHelper().readElement(AdmitDate);
	}

	public String readAdmitDateTitle() {
		return Source.SeleniumHelper().readElement(AdmitDateTitle);
	}

	public String readDischargeDateTitle() {
		return Source.SeleniumHelper().readElement(DischargeDateTitle);
	}

	public String readPlacementTypeDropdownTitle() {
		return Source.SeleniumHelper().readElement(PlacementTypeDropdownTitle);
	}

	public String readPnmiPlacementDropdownTitle() {
		return Source.SeleniumHelper().readElement(PnmiPlacementDropdownTitle);
	}

	public String readLevelDropdownTitle() {
		return Source.SeleniumHelper().readElement(LevelDropdownTitle);
	}

	public ResidentialPlacementPage setAdmitDate(String date,String... Clear) {
		Source.SeleniumHelper().setText(AdmitDate, date + Keys.TAB + Keys.TAB, Clear);	
		return this;
	}

	public ResidentialPlacementPage setDischargeDate(String date,String... Clear) {
		Source.SeleniumHelper().setText(DischargeDate, date + Keys.TAB, Clear);	
		return this;
	}

	public ResidentialPlacementPage selectPlacementType(int value) {
		Source.SeleniumHelper().select(PlacementTypeDropdown, value);
		return this;
	}

	public ResidentialPlacementPage selectResidentialPlacement(int value) {
		Source.SeleniumHelper().select(PnmiPlacementDropdown, value);
		return this;
	}

	public ResidentialPlacementPage selectResidentialLevel(int value) {
		Source.SeleniumHelper().select(LevelDropdown, value);
		return this;
	}

	public String readAdmitDateValue() {
		return Source.SeleniumHelper().readElement(AdmitDate);
	}	

	public String readDischargeDateValue() {
		return Source.SeleniumHelper().readElement(DischargeDate);
	}	

	public String readPlacementTypeDropdownValue() {
		return Source.SeleniumHelper().readAttribute(PlacementTypeDropdown, "value");
	}

	public String readPnmiPlacementDropdownValue() {
		return Source.SeleniumHelper().readAttribute(PnmiPlacementDropdown, "value");
	}

	public String readLevelDropdownValue() {
		return Source.SeleniumHelper().readAttribute(LevelDropdown, "value");
	}

	public String readBackToResidentialPlacementBtn() {
		return Source.SeleniumHelper().readElement(BackToResidentialPlacementBtn);
	}

	public ResidentialPlacementPage clickBackToResidentialPlacementBtn() {
		Source.SeleniumHelper().clickElement(BackToResidentialPlacementBtn);
		return this;
	}

	public ResidentialPlacementPage createResidentialPlacementIfNoData() {
		Actual = Source		.DataTable()
							.readDataTable(1, 1);

		if(Actual.equalsIgnoreCase("No data available")) {
			Source		.DataTable()
						.clickAdd()
						.ResidentialPlacementPage()
						.setAdmitDate(Today, Clear)
						.selectPlacementType(PlacementType.IN_STATE_PLACEMENT.getIndex())
						.selectResidentialPlacement(PNMIPlacement.AMERICAN_SCHOOL_FOR_THE_DEAF_CT.getIndex())
						.selectResidentialLevel(PNMILevel.MH_I.getIndex())
						.setDescription(Description)
						.clickSubmit()
						.clickPopupOk();
		}
		
		return this;
	}
	
	public ResidentialPlacementPage createResidentialPlacementIfNoData(String AdmitDate, PlacementType type, PNMIPlacement Placement, PNMILevel Level, String Description) {
		Actual = Source		.DataTable()
							.readDataTable(1, 1);

		if(Actual.equalsIgnoreCase("No data available")) {
			Source		.DataTable()
						.clickAdd()
						.ResidentialPlacementPage()
						.setAdmitDate(AdmitDate, Clear)
						.selectPlacementType(type.getIndex())
						.selectResidentialPlacement(Placement.getIndex())
						.selectResidentialLevel(Level.getIndex())
						.setDescription(Description)
						.clickSubmit()
						.clickPopupOk();
		}
		
		return this;
	}
}
