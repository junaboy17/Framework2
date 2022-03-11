package com.eisrem.pageFactory.CommonPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.Administrator.AdministratorNavigator;

public class LabelsAvailableAccord extends AdministratorNavigator{


	public LabelsAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='lblName']")
	public WebElement LabelNameTextBox;
	
	@FindBy(xpath="//input[@id='lblSortOrder']")
	public WebElement LabelSortOrderBox;
	
	@FindBy(xpath="//label[contains(text(),'Active')]")
	public WebElement ActiveTitle;
	
	@FindBy(xpath="//div[contains(@class , 'bootstrap-switch-mini bootstrap-switch-id-lblActiveFlag')]")
	public WebElement ActiveToggle;
	
	@FindBy(xpath="//div[contains(@class , 'bootstrap-switch-mini bootstrap-switch-id-lblActiveFlag')]//input")
	public WebElement ActiveToggleAttribute;
	
	@FindBy(xpath="//label[contains(text(),'Indent')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement LabelIndentFlagToggle;
	
	@FindBy(xpath="//label[contains(text(),'Indent')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement LabelIndentFlagToggleAttribute;
	
	public LabelsAvailableAccord setLabelName(String name, String... Clear) {
		Source.SeleniumHelper().setText(LabelNameTextBox, name, Clear);			
		return this;
	}
	
	public LabelsAvailableAccord setLabelSortOrder(int sortOrder, String... Clear) {
		Source.SeleniumHelper().setText(LabelSortOrderBox, sortOrder, Clear);			
		return this;
	}
	
	public String readActiveTitle() {
		return Source.SeleniumHelper().readElement(ActiveTitle);
	}
	
	public LabelsAvailableAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}

	public String readActiveToggle() {
		return ActiveToggleAttribute.getAttribute("last-val");
	}
	
	public LabelsAvailableAccord clickActiveToggle(String value) {
		String active = readActiveToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickActiveToggle();
		}
		return this;
	}
	
	public LabelsAvailableAccord switchLabelIndentFlag(boolean active) {
		if((active && LabelIndentFlagToggleAttribute.getAttribute("last-val").equals("false"))
				|| (!active && LabelIndentFlagToggleAttribute.getAttribute("last-val").equals("true")))
			Source.SeleniumHelper().clickElement(LabelIndentFlagToggle);
		return this;
	}
	
	public LabelsAvailableAccord clickIndentInListToggle() {
		Source.SeleniumHelper().clickElement(LabelIndentFlagToggle);
		return this;
	}

	public String readIndentInListToggle() {
		return LabelIndentFlagToggleAttribute.getAttribute("last-val");
	}
	
	public LabelsAvailableAccord clickIndentInListToggle(String value) {
		String active = readIndentInListToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickIndentInListToggle();
		}
		return this;
	}
	//			
	
	public List<Integer> getLabelsSortOrder(){
		List<Integer> sortOrderList = new ArrayList<Integer>();
		List<WebElement> rows;
		
		rows =  Source.SeleniumHelper().getWebElementList("//table[@id='label_table']/tbody/tr/td[3]");	// sort order column
		for (WebElement row : rows)
			sortOrderList.add(Integer.valueOf(row.getText()));

		return sortOrderList;
	}

}
