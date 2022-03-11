package com.eisrem.pageFactory.CommonPage;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.AppAreaConductType;
import com.eisrem.AppUtils.Enumerations.AppModule;
import com.eisrem.AppUtils.Enumerations.LockTime;
import com.eisrem.AppUtils.Enumerations.Roles;
import com.eisrem.AppUtils.Enumerations.ServicePopulations;
import com.eisrem.pageFactory.Administrator.TypesPage;

public class PagesAvailableAccord extends TypesPage{

	public PagesAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='type-pge-combobox']")
	public WebElement PageTextBox;
	
	@FindBy(xpath="//input[@id='pgSortOrder']")
	public WebElement SortOrderTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Required')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement RequiredToggle;
	
	@FindBy(xpath="//input[@id='pgRequired']")
	public WebElement RequiredFlag;
	
	@FindBy(xpath="//label[contains(text(),'Required')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement RequiredToggleAttribute;
	
	@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-6 col-xs-12']//div[@class='bootstrap-switch-container']")
	public WebElement ActiveToggle;
	
	@FindBy(xpath="//input[@id='page_activeFlag']")
	public WebElement ActiveFlag;
	
	@FindBy(xpath="//div[@class='form-group col-lg-4 col-md-6 col-xs-12']//div[@class='bootstrap-switch-container']//input")
	public WebElement ActiveToggleAttribute;
	
	@FindBy(xpath="//select[@id='pgRelated']")
	public WebElement TriggeredByPageDropDown;
	
	@FindBy(xpath="//select[@id='quesRelated']")
	public WebElement TriggeredByQuestionDropDown;
	
	@FindBy(xpath="//button[@class='multiselect dropdown-toggle btn btn-default']")
	public WebElement TriggeredByAnswerBtn;
	
	@FindBy(xpath="//*[@id='ansRelated']")
	public WebElement TriggeredByAnswerSelect;
	
	@FindBy(xpath="//a[contains(text(),'Service Population Available:')]")
	public WebElement ServicePopulationAvailableAccord;
	
	
	public PagesAvailableAccord setPage(String value, String... Clear) {
		Source.SeleniumHelper().setText(PageTextBox, value, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public PagesAvailableAccord setSortOrder(String SortOrder, String... Clear) {
		Source.SeleniumHelper().setText(SortOrderTextBox, SortOrder, Clear);
		return this;
	}
	
	public PagesAvailableAccord clickRequired() {
		Source.SeleniumHelper().clickElement(RequiredToggle);
		return this;
	}
	
	public PagesAvailableAccord clickActiveSort() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}
	
	public PagesAvailableAccord selectTriggeredByPage(int index) {
		Source.SeleniumHelper().select(TriggeredByPageDropDown, index);
		return this;
	}
	
	public PagesAvailableAccord selectTriggeredByPage(String page) {
		Source.SeleniumHelper().select(TriggeredByPageDropDown, page);
		return this;
	}
	
	public PagesAvailableAccord selectTriggeredByQuestion(int index) {
		Source.SeleniumHelper().select(TriggeredByQuestionDropDown, index);
		return this;
	}
	
	public PagesAvailableAccord selectTriggeredByQuestion(String question) {
		Source.SeleniumHelper().select(TriggeredByQuestionDropDown, question);
		return this;
	}
	
	public PagesAvailableAccord clickTriggeredByAnswer() {
		Source.SeleniumHelper().clickElement(TriggeredByAnswerBtn);
		return this;
	}
	
	public PagesAvailableAccord selectTriggeredByAnswer(String answer) {
		Source.SeleniumHelper().clickElement(TriggeredByAnswerBtn);
		Source.SeleniumHelper().select(TriggeredByAnswerSelect, answer);
		return this;
	}
	
	public ServicePopulationsAvailableAccord clickServicePopulationAvailableAccord() {
		Source.SeleniumHelper().clickElement(ServicePopulationAvailableAccord);
		return new ServicePopulationsAvailableAccord(DriverFactory.getDriver());
	}
	
	public PagesAvailableAccord addPageAndComplete() {
		SeleniumHelper.log.info("Adding Page to type and clicking complete");
		Source	 .PagesAvailableAccord()
				.setPage(DataFixForm)
				.setSortOrder("1")
				.clickComplete();
		return this;
	}
	
	public PagesAvailableAccord addPage() {
		SeleniumHelper.log.info("Adding Page to type");
		Source	 .PagesAvailableAccord()
				.setPage(DataFixForm)
				.setSortOrder("1");
		return this;
	}
	
	public PagesAvailableAccord addPage(String pageName, int sortOrder, String triggeredByPage, String triggeredByQuestion,
			LinkedList<String> triggeredByAnswer, Boolean required, Boolean active) {
		SeleniumHelper.log.info("Adding Page to type");
		Source	.PagesAvailableAccord()
				.clickAdd()
				.PagesAvailableAccord()
				.setPage(pageName)
				.setSortOrder(String.valueOf(sortOrder));
			
				if(triggeredByPage != null)
				{
					Source.PagesAvailableAccord().selectTriggeredByPage(triggeredByPage).clickPopupOk();
					
					if(triggeredByQuestion != null) {
						Source.PagesAvailableAccord().selectTriggeredByQuestion(triggeredByQuestion);
						
						if(triggeredByAnswer != null && triggeredByAnswer.size() > 0)
							for(String answer : triggeredByAnswer)
								Source.PagesAvailableAccord()
								.selectTriggeredByAnswer_MultiSelect(answer);
//								.selectTriggeredByAnswer(answer);
					}
				}
				
				if((active && ActiveFlag.getAttribute("last-val").equals("false"))
						|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
					Source.PagesAvailableAccord().clickActiveToggle();
				
				if((required && RequiredFlag.getAttribute("last-val").equals("false"))
						|| (!required && RequiredFlag.getAttribute("last-val").equals("true")))
				{
					Source.PagesAvailableAccord().clickRequired();
					if(!required && triggeredByPage != null)
						Source.PagesAvailableAccord().clickPopupOk();
						
				}
		return this;
	}

	public String hasTriggeredQuestions() {
		return Boolean.toString(new Select(TriggeredByQuestionDropDown).getFirstSelectedOption().getText().equals(None));
	}

	public String isTriggeredByPopulated(String page, String question, String answer) {
		return Boolean.toString(Source.SeleniumHelper().getFirstSelectedValue(TriggeredByPageDropDown).equals(page)
				&& Source.SeleniumHelper().getFirstSelectedValue(TriggeredByQuestionDropDown).equals(question)
				&& Source.SeleniumHelper().getFirstSelectedValue(TriggeredByAnswerSelect).equals(answer));
	}

	public PagesAvailableAccord addRoleToPage(int roleIndex) {
		Source
				.RolesAvailableAccord()
				.clickRolesAdd()
				.selectRole(roleIndex)
				.clickRolesComplete();
		return this;
	}
	
	public PagesAvailableAccord addServicePopulationToPage(int servPopIndex) {
		Source
				.ServicePopulationsAvailableAccord()
				.clickSpAdd()
				.selectServicePopulation(servPopIndex)
				.clickSpComplete();
		return this;
	}
	
	public PagesAvailableAccord selectTriggeredByAnswer_MultiSelect(String answer) {
		//updated xpath for answer select - Arif
		Source.SeleniumHelper().clickElement(TriggeredByAnswerBtn);
		By answerSelect = By.xpath("//ul[@class='multiselect-container dropdown-menu']//label[contains(text(), '" + answer + "')]//input");
		WebElement e = Source.SeleniumHelper().getWebElement(answerSelect);
		e.click();
		return this;
	}
	
}
