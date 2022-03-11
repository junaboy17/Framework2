package com.eisrem.pageFactory.CommonPage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.Admin.NavigationMenuBar;
import com.eisrem.pageFactory.Administrator.NotificationsPage;

public class SetConditionsAccord extends NotificationsPage{


	public SetConditionsAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@for='selections-criteria-type-combobox']")
	public WebElement TypeTitle;
	
	@FindBy(xpath="//input[@id='selections-criteria-type-combobox']")
	public WebElement TypeTextBox;
	
	@FindBy(xpath="//div[@id='selections-criteria-type-container']/div/div/span")
	public WebElement TypeXBtn;
	
	@FindBy(xpath="//input[@id='selections-criteria-type-combobox']")
	public WebElement TypeResutlOne;
	
	@FindBy(xpath="//label[@for='selections-criteria-page-combobox']")
	public WebElement PageTitle;
	
	@FindBy(xpath="//input[@id='selections-criteria-page-combobox']")
	public WebElement PageTextBox;
	
	@FindBy(xpath="//div[@id='selections-criteria-page-container']/div/div/span")
	public WebElement PageXBtn;
	
	@FindBy(xpath="//label[@for='selections-criteria-question-combobox']")
	public WebElement QuestionTitle;
	
	@FindBy(xpath="//input[@id='selections-criteria-question-combobox']")
	public WebElement QuestionTextBox;
	
	@FindBy(xpath="//div[@id='selections-criteria-question-container']/div/div/span")
	public WebElement QuestionXBtn;
			
	@FindBy(xpath="//label[@for='selections-criteria-answer']")
	public WebElement AnswerTitle;
	
	@FindBy(xpath="//select[@id='selections-criteria-answer']")
	public WebElement AnswerDropDown;
	
	@FindBy(xpath="//label[@for='selections-criteria-property']")
	public WebElement FormatTitle;
	
	@FindBy(xpath="//select[@id='selections-criteria-property']")
	public WebElement FormatDropDown;
	
	@FindBy(xpath="//label[@for='selection-criteria-operator-option']")
	public WebElement ValueTitle;
	
	@FindBy(xpath="//input[@id='selection-criteria-operator-option'] | //input[@id='dateDropdown']")
	public WebElement ValueTextBox;
	
	@FindBy(xpath="//label[@for='selections-criteria-type2-combobox']")
	public WebElement Type2Title;
	
	@FindBy(xpath="//input[@id='selections-criteria-type2-combobox']")
	public WebElement Type2TextBox;
	
	@FindBy(xpath="//input[@id='selections-criteria-type2-combobox']")
	public WebElement Type2ResutlOne;
	
	@FindBy(xpath="//label[@for='selections-criteria-page2-combobox']")
	public WebElement Page2Title;
	
	@FindBy(xpath="//input[@id='selections-criteria-page2-combobox']")
	public WebElement Page2TextBox;
	
	@FindBy(xpath="//label[@for='selections-criteria-question2-combobox']")
	public WebElement Question2Title;
	
	@FindBy(xpath="//input[@id='selections-criteria-question2-combobox']")
	public WebElement Question2TextBox;
			
	@FindBy(xpath="//label[@for='selections-criteria-answer2']")
	public WebElement Answer2Title;
	
	@FindBy(xpath="//select[@id='selections-criteria-answer2']")
	public WebElement Answer2DropDown;
	
	@FindBy(xpath="//label[@for='selections-criteria-property2']")
	public WebElement Format2Title;
	
	@FindBy(xpath="//select[@id='selections-criteria-property2']")
	public WebElement Format2DropDown;
	
	@FindBy(xpath="//label[@for='selection-criteria-operator-option2']")
	public WebElement Value2Title;
	
	@FindBy(xpath="//input[@id='selection-criteria-operator-option2']")
	public WebElement Value2TextBox;
	
	@FindBy(xpath="//label[@for='selections-criteria-county']")
	public WebElement CountyTitle;
	
	@FindBy(xpath="//select[@id='selections-criteria-county']")
	public WebElement CountyDropDown;

	@FindBy(xpath="//label[@for='selections-criteria-city']")
	public WebElement CityTownTitle;
	
	@FindBy(xpath="//select[@id='selections-criteria-city']")
	public WebElement CityTownDropDown;
	
	@FindBy(xpath="//button[@id='addSelectionsCriteria']")
	public WebElement AddBtn;
	
	@FindBy(xpath="//button[@id='removeSelectionsCriteria']")
	public WebElement RemoveBtn;
		
	@FindBy(xpath="//label[contains(text(),'Search Criteria')]")
	public WebElement SearchCriteriaTitle;
			
	@FindBy(xpath="//select[@id='selections-criteria-preview']")
	public WebElement SearchCriteriaTextBox;

	
	public String readTypeTitle() {
		return Source.SeleniumHelper().readElement(TypeTitle);
	}
	
	public SetConditionsAccord setType(String type, String... Clear) {
		Source.SeleniumHelper().setText(TypeTextBox, type, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readPageTitle() {
		return Source.SeleniumHelper().readElement(PageTitle);
	}
	
	public SetConditionsAccord searchPage(String page, String... Clear) {
		Source.SeleniumHelper().setText(PageTextBox, page, Clear);
		Source.SeleniumHelper().sleep(1);
		return this;
	}

	public SetConditionsAccord setPage(String type, String... Clear) {
		Source.SeleniumHelper().setText(PageTextBox, type, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}

	public List<WebElement> getPageResults(String pageId) {
		return Source.SeleniumHelper().getWebElementList("//select[@id='selections-criteria-page']/option[@value='" + pageId + "']");
	}
	
	public String readQuestionTitle() {
		return Source.SeleniumHelper().readElement(QuestionTitle);
	}

	public SetConditionsAccord setQuestion(String type, String... Clear) {
		Source.SeleniumHelper().setText(QuestionTextBox, type, Clear);
		Source.SeleniumHelper().waitForLoad(3);
		List<WebElement> questionOptions = Source.SeleniumHelper().getWebElementList(By.xpath("//*[@id='selections-criteria-question-container']/div/div/ul/li"));
		for(WebElement option : questionOptions) {
			if(option.findElement(By.xpath(".//a")).getAttribute("innerHTML").contains(type)) {
				option.findElement(By.xpath(".//a")).click();
				break;
			}
		}
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readAnswerTitle() {
		return Source.SeleniumHelper().readElement(AnswerTitle);
	}
	
	public SetConditionsAccord selectAnswer(int index) {
		Source.SeleniumHelper().select(AnswerDropDown, index);
		return this;
	}
	
	public WebElement getAnswer() {
		Source.SeleniumHelper().highLightElement(AnswerDropDown);
		Source.SeleniumHelper().unhighLightElement(AnswerDropDown);
		//return AnswerDropDown.findElement(By.xpath("/option[@selected=true]"));
		return (new Select(AnswerDropDown)).getFirstSelectedOption();
	}
	
	public String readFormatTitle() {
		return Source.SeleniumHelper().readElement(FormatTitle);
	}
	
	public SetConditionsAccord selectFormat(int index) {
		Source.SeleniumHelper().select(FormatDropDown, index);
		return this;
	}
	
	public SetConditionsAccord selectFormat(String Format) {
		Source.SeleniumHelper().select(FormatDropDown, Format);
		return this;
	}
	
	public String readValueTitle() {
		return Source.SeleniumHelper().readElement(ValueTitle);
	}
	
	public SetConditionsAccord setValue(String type, String... Clear) {
		Source.SeleniumHelper().setText(ValueTextBox, type + Keys.TAB, Clear);
		return this;
	}
	
	public String readType2Title() {
		return Source.SeleniumHelper().readElement(TypeTitle);
	}
	
	public SetConditionsAccord setType2(String type, String... Clear) {
		Source.SeleniumHelper().setText(Type2TextBox, type, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readPage2Title() {
		return Source.SeleniumHelper().readElement(PageTitle);
	}

	public SetConditionsAccord setPage2(String type, String... Clear) {
		Source.SeleniumHelper().setText(Page2TextBox, type, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readQuestion2Title() {
		return Source.SeleniumHelper().readElement(QuestionTitle);
	}

	public SetConditionsAccord setQuestion2(String type, String... Clear) {
		Source.SeleniumHelper().setText(Question2TextBox, type, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readAnswer2Title() {
		return Source.SeleniumHelper().readElement(AnswerTitle);
	}
	
	public SetConditionsAccord selectAnswer2(int index) {
		Source.SeleniumHelper().select(Answer2DropDown, index);
		return this;
	}
	
	public String readFormat2Title() {
		return Source.SeleniumHelper().readElement(FormatTitle);
	}
	
	public SetConditionsAccord selectFormat2(int index) {
		Source.SeleniumHelper().select(Format2DropDown, index);
		return this;
	}
	
	public SetConditionsAccord selectFormat2(String Format) {
		Source.SeleniumHelper().select(Format2DropDown, Format);
		return this;
	}
	
	public String readValue2Title() {
		return Source.SeleniumHelper().readElement(Value2Title);
	}
	
	public SetConditionsAccord setValue2(String type, String... Clear) {
		Source.SeleniumHelper().setText(Value2TextBox, type + Keys.TAB, Clear);
		return this;
	}
	
	
	public String readCountyTitle() {
		return Source.SeleniumHelper().readElement(CountyTitle);
	}
	
	public SetConditionsAccord selectCounty(int index) {
		Source.SeleniumHelper().select(CountyDropDown, index);
		return this;
	}
	
	public String readCityTownTitle() {
		return Source.SeleniumHelper().readElement(CityTownTitle);
	}
	
	public SetConditionsAccord selectCityTown(int index) {
		Source.SeleniumHelper().select(CityTownDropDown, index);
		return this;
	}
	
	public String readAddBtnTitle() {
		return Source.SeleniumHelper().readElement(AddBtn);
	}

	public SetConditionsAccord clickSetConditionsAdd() {
		Source.SeleniumHelper().clickElement(AddBtn);
		return this;
	}
	
	public SetConditionsAccord clickSetConditionsRemove() {
		Source.SeleniumHelper().clickElement(RemoveBtn);
		return this;
	}
	
	public SetConditionsAccord clickSetConditionsRemove(int index) {
		Source.SeleniumHelper().clickElement(By.xpath("//select[@id='selections-criteria-preview']/option[" + index + "]"));
		Source.SeleniumHelper().clickElement(RemoveBtn);
		return this;
	}

	public String readRemoveBtnTitle() {
		return Source.SeleniumHelper().readElement(RemoveBtn);
	}

	public String readSearchCriteriaTitle() {
		return Source.SeleniumHelper().readElement(SearchCriteriaTitle);
	}
	
	public SetConditionsAccord setSearchCriteria(String Criteria, String... Clear) {
		Source.SeleniumHelper().setText(SearchCriteriaTextBox, Criteria, Clear);
		return this;
	}
	
	public String readSearchCriteria() {
		Source.SeleniumHelper().moveToElement(SearchCriteriaTextBox);
		Source.SeleniumHelper().highLightElement(SearchCriteriaTextBox);
		Source.SeleniumHelper().unhighLightElement(SearchCriteriaTextBox);
		By Criteria = By.xpath("//select[@id='selections-criteria-preview']/option[1]");
		return Source.SeleniumHelper().readElement(Criteria);
	}
	
	public String readSearchCriteria(int index) {
		By Criteria = By.xpath("//select[@id='selections-criteria-preview']/option[" + index + "]");
		return Source.SeleniumHelper().readElement(Criteria);
	}

	public SetConditionsAccord confirmFormatValues() {
		Source	.SeleniumHelper()
				.clickElement(FormatDropDown)
				.highLightElement(FormatDropDown);
		List<String> formatValues = new ArrayList<String>();
		for(NotificationFormat name : NotificationFormat.values())
			formatValues.add(name.getName());
		Source	.SeleniumHelper()
				.verifyAllDropDown(FormatDropDown, formatValues)
				.unhighLightElement(FormatDropDown);
		return this;
	}
	
	public String addSetConditionAndVerify(String type, String page, String question, int index) {
		Source	.SetConditionsAccord()
				.setType(type)
				.setPage(page)
				.setQuestion(question)
				.selectFormat(index)
				.clickSetConditionsAdd();			
		return Source.SetConditionsAccord().readSearchCriteria();
	}
	
	public SetConditionsAccord formatOptionDisabled(String option, BigInteger id) {
		Source.SeleniumHelper().optionDisabled(FormatDropDown, option, id.toString());
		return this;
	}
	
	public SetConditionsAccord formatOptionEnabled(String option, BigInteger id) {
		Source.SeleniumHelper().optionEnabled(FormatDropDown, option, id.toString());
		return this;
	}

	public SetConditionsAccord formatHighlight(boolean highlight) {
		if (highlight)
			Source.SeleniumHelper().highLightElement(FormatDropDown);
		else
			Source.SeleniumHelper().unhighLightElement(FormatDropDown);
		return this;
	}
	
	public SetConditionsAccord clickFormatDropDown() {
		Source.SeleniumHelper().clickElement(FormatDropDown);
		return this;
	}

	public SetConditionsAccord clickQuestionXbtn() {
		Source.SeleniumHelper().clickElement(QuestionXBtn);
		Source.SeleniumHelper().sleep(1);
		return this;
	}
	
	public String readQuestionXbtn() {
		return Source.SeleniumHelper().readElement(QuestionXBtn);
	}

	public SetConditionsAccord clickPageXbtn() {
		Source.SeleniumHelper().clickElement(PageXBtn);
		Source.SeleniumHelper().sleep(1);
		return this;
	}
	
	public String readPageXbtn() {
		return Source.SeleniumHelper().readElement(PageXBtn);
	}

	public SetConditionsAccord clickTypeXbtn() {
		Source.SeleniumHelper().clickElement(TypeXBtn);
		Source.SeleniumHelper().sleep(1);
		return this;
	}
	
	public String readTypeXbtn() {
		return Source.SeleniumHelper().readElement(TypeXBtn);
	}


}
