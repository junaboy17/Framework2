package com.eisrem.pageFactory.CommonPage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.QuestionType;
import com.eisrem.pageFactory.Administrator.PagesPage;

import edu.emory.mathcs.backport.java.util.Collections;

public class QuestionsAvailableAccord extends PagesPage{


	public QuestionsAvailableAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Questions Available:')]")
	public WebElement QuestionsAvailableAccordion;
			
	@FindBy(xpath="//div[@id= 'ques_table_length']//label")
	public WebElement ShowEntries;

	@FindBy(xpath="//select[@aria-controls='ques_table']")
	public WebElement ShowEntriesDropdown;
	
	@FindBy(xpath="//div[@id='ques_table_info']")
	public WebElement ShowNoOfEntries;	
	
	@FindBy(xpath="//table[@id='ques_table']//tbody//tr[@role='row'][1]")
	public WebElement FirstRow;
	
	@FindBy(xpath="//a[@aria-controls='ques_table']//span[contains(text(),'Add')]")
	public WebElement AddButton;
		
	@FindBy(xpath="//a[@aria-controls='ques_table']//span[contains(text(),'Edit')]")
	public WebElement EditButton;
	
	@FindBy(xpath="//a[@aria-controls='ques_table']//span[contains(text(),'View')]")
	public WebElement ViewButton;
	
	@FindBy(xpath="//a[@aria-controls='ques_table']//span[contains(text(),'Excel')]")
	public WebElement ExcelButton;
	
	@FindBy(xpath="//div[@id='ques_table_filter'] //label")
	public WebElement SearchTitle;

	@FindBy(xpath="//input[@aria-controls='ques_table']")
	public WebElement SearchTextBox;
	
	@FindBy(xpath="//th[@aria-controls='ques_table'] [text()='Id']")
	public WebElement IdList;
	
	@FindBy(xpath="//table[@id='ques_table']//thead/tr[1]/th[1]/img[1]")
	public WebElement IdSection;
	
	@FindBy(xpath="//th[@aria-controls='ques_table'] [text()='Name']")
	public WebElement NameTypeList;
	
	@FindBy(xpath="//table[@id='ques_table']//thead/tr[1]/th[2]/img[1]")
	public WebElement NameTypeSection;
	
	@FindBy(xpath="//th[@aria-controls='ques_table'] [text()='Start Today']")
	public WebElement StartDateList;
	
	@FindBy(xpath="//table[@id='ques_table']//thead/tr[1]/th[3]/img[1]")
	public WebElement StartDateSection;
	
	@FindBy(xpath="//th[@aria-controls='ques_table'] [text()='End Today']")
	public WebElement EndDateList;
	
	@FindBy(xpath="//table[@id='ques_table']//thead/tr[1]/th[4]/img[1]")
	public WebElement EndDateSection;
	
	@FindBy(xpath="//th[@aria-controls='ques_table'] [text()='Modified Today']")
	public WebElement ModifiedDateList;
	
	@FindBy(xpath="//table[@id='ques_table']//thead/tr[1]/th[5]/img[1]")
	public WebElement ModifiedDateSection;
	
	@FindBy(xpath="//a[@id='ques_table_previous']")
	public WebElement PreviousBtn;

	@FindBy(xpath="//a[@id='ques_table_next']")
	public WebElement NextBtn;
	
	@FindBy(xpath="//select[@id='quesType']")
	public WebElement QuestionTypeDropDown;
	
	@FindBy(xpath="//select[@id='calcStyle']")
	public WebElement CalcStyleDropDown;

	@FindBy(xpath="//iframe[@id='quesLabel_ifr']")
	public WebElement QuestionLabelIFrame;
	
	@FindBy(xpath="//*[@data-id='quesLabel']/p")
	public WebElement QuestionLabelTextBox;
	
	@FindBy(xpath="//input[@id='quesLabel']")
	public WebElement QuestionLabelTextBoxNF;

	@FindBy(xpath="//input[@id='quesSortOrder']")
	public WebElement SortOrderTextBox;
	
	@FindBy(xpath="//input[@id='scoreMax']")
	public WebElement MaxScore;
	
	@FindBy(xpath="//input[@id='scoreMin']")
	public WebElement MinScore;
	
	@FindBy(xpath="//button[@id='addValue']")
	public WebElement AddValueAnswer;
	
	@FindBy(xpath="//div[@id='textValue']//div[1]//input")
	public WebElement AnswerValue1TextBox;
	
	@FindBy(xpath="//div[@id='textValue']/div[2]/input")
	public WebElement AnswerValue2TextBox;
	
	@FindBy(xpath="//div[@id='textValue']/div[3]/input")
	public WebElement AnswerValue3TextBox;
	
	public By AnswerValue2TB = By.xpath("//div[@id='textValue']/div[2]/input");
	
	@FindBy(xpath="//div[@id='textValue']/div[1]//span//span")
	public WebElement AnswerValue1Remove;
	
	@FindBy(xpath="//div[@id='textValue']/div/input")
	public List<WebElement> AnswerValueTextBoxAll;

	@FindBy(xpath="//select[@id='quesRelated']")
	public WebElement RelateToQuestionDropDown;

	@FindBy(xpath="//span[@class='multiselect-selected-text']")
	public WebElement RelateToAnswerDropDown;
	
	@FindBy(xpath="//*[@id='ansRelated']")
	public WebElement RelateToAnswerDropDownSelect;
	
	@FindBy(xpath="//iframe[@id='quesInstruction_ifr']")
	public WebElement QAInstructionIFrame;
	
	@FindBy(xpath="//*[@data-id='quesInstruction']/p")
	public WebElement QAInstructionTextBox;

	@FindBy(xpath="//div[@id='question-tab-pane']//div[contains(@class,'bootstrap-switch-id-question_activeFlag')]")
	public WebElement ActiveToggle;
	
	@FindBy(xpath="//input[@id='question_activeFlag']")
	public WebElement ActiveFlag;
	
	@FindBy(xpath="//div[@id='question-tab-pane']//div[contains(@class,'bootstrap-switch-id-lockForm')]")
	public WebElement LockFormToggle;
	
	@FindBy(xpath="//input[@id='lockForm']")
	public WebElement LockFormFlag;

	@FindBy(xpath="//div[@id='question-tab-pane']//div[contains(@class,'bootstrap-switch-id-quesRequired')]")
	public WebElement RequiredToggle;
	
	@FindBy(xpath="//input[@id='quesRequired']")
	public WebElement RequiredFlag;
	
	@FindBy(xpath="//div[@id='question-tab-pane']//button[text()='Save']")
	public WebElement SaveBtn;
	
	@FindBy(xpath="//div[@id='question-tab-pane']//button[text()='Back']")
	public WebElement BackBtn;
	//***
	@FindBy(xpath="//button[@id='loadLookupImport']")
	public WebElement LoadFromLookupBtn;
	
	@FindBy(xpath="//label[@for = 'question-lookup-combobox']")
	public WebElement LookupTitle;
	
	@FindBy(xpath="//input[@id='question-lookup-combobox']")
	public WebElement LookupSearchComboBox;
	//***
	@FindBy(xpath="//a[contains(text(),'Roles Available:')]")
	public WebElement RolesAvailableAccordion;
	
	@FindBy(xpath="//div[@id='question-tab-pane']//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;
	
	@FindBy(xpath="//*[@id=\"textValue\"]/div[1]/span")
	public WebElement FirstXBtn;
	
	@FindBy(xpath="//button[@id='sortAlpha']")
	public WebElement SortAlphaButton;
	
	
    @FindBy(xpath="//input[@name='option[]']")
	public WebElement answerValueTextBox;
    
	public String readShowEntriesTitle() {
		return Source.SeleniumHelper().readElement(ShowEntries);
	}
	
	public String readSearchTitle() {
		return Source.SeleniumHelper().readElement(SearchTitle);
	}
	
	public QuestionsAvailableAccord setSearch(String value, String... Clear) {
		Source.SeleniumHelper().setText(SearchTextBox, value, Clear);
		return this;
	}
			
	public QuestionsAvailableAccord selectShowEntries(int index) {
		Source.SeleniumHelper().select(ShowEntriesDropdown, index);
		return this;
	}
	
	public QuestionsAvailableAccord clickQAFirstRow() {
		Source.SeleniumHelper().clickElement(FirstRow);
		return this;
	}
		
	public String readAddBtn() {
		return Source.SeleniumHelper().readElement(AddButton);
	}

	public QuestionsAvailableAccord clickQAAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return this;
	}
	
	public String readEditBtn() {
		return Source.SeleniumHelper().readElement(EditButton);
	}

	public QuestionsAvailableAccord clickQAEdit() {
		Source.SeleniumHelper().clickElement(EditButton);
		return this;
	}
	
	public String readViewBtn() {
		return Source.SeleniumHelper().readElement(ViewButton);
	}

	public QuestionsAvailableAccord clickQAView() {
		Source.SeleniumHelper().clickElement(ViewButton);
		return this;
	}
	
	public String readExcelBtn() {
		return Source.SeleniumHelper().readElement(ExcelButton);
	}

	public QuestionsAvailableAccord clickRaExcel() {
		Source.SeleniumHelper().clickElement(ExcelButton);
		return this;
	}
		
	public QuestionsAvailableAccord clickIdSort() {
		Source.SeleniumHelper().clickElement(IdList);
		return this;
	}
	
	public String readIdList() {
		return Source.SeleniumHelper().readElement(IdList);
	}
	
	public QuestionsAvailableAccord clickNameType() {
		Source.SeleniumHelper().clickElement(NameTypeList);
		return this;
	}
	
	public String readNameTypeList() {
		return Source.SeleniumHelper().readElement(NameTypeList);
	}
	
	public QuestionsAvailableAccord clickStartDateSort() {
		Source.SeleniumHelper().clickElement(StartDateList);
		return this;
	}
	
	public String readStartDateList() {
		return Source.SeleniumHelper().readElement(StartDateList);
	}
	
	public QuestionsAvailableAccord clickEndDateSort() {
		Source.SeleniumHelper().clickElement(EndDateList);
		return this;
	}
	
	public String readEndDateList() {
		return Source.SeleniumHelper().readElement(EndDateList);
	}
	
	public QuestionsAvailableAccord clickModifiedDateSort() {
		Source.SeleniumHelper().clickElement(ModifiedDateList);
		return this;
	}
	
	public String readModifiedDateList() {
		return Source.SeleniumHelper().readElement(ModifiedDateList);
	}
	
	public QuestionsAvailableAccord clickPrevious() {
		Source.SeleniumHelper().clickElement(PreviousBtn);
		return this;
	}
	
	public String readPreviousBtn() {
		return Source.SeleniumHelper().readElement(PreviousBtn);
	}
	
	public QuestionsAvailableAccord clickNext() {
		Source.SeleniumHelper().clickElement(NextBtn);
		return this;
	}
	
	public String readNextBtn() {
		return Source.SeleniumHelper().readElement(NextBtn);
	}
	
	public QuestionsAvailableAccord selectQuestionType(int index) {
		Source.SeleniumHelper().select(QuestionTypeDropDown, index);
		return this;
	}
	
	public QuestionsAvailableAccord selectQuestionType(String name) {
		Source.SeleniumHelper().select(QuestionTypeDropDown, name);
		return this;
	}
	
	public QuestionsAvailableAccord selectCalculationStyle(int index) {
		Source.SeleniumHelper().select(CalcStyleDropDown, index);
		return this;
	}
	
	public QuestionsAvailableAccord setQuestionLabel(String QuestionLabel, String... Clear) {
		if(Configuration.Config.iFrame==true) {
			Source.SeleniumHelper().setText(QuestionLabelIFrame, QuestionLabelTextBox, QuestionLabel, Clear);
		}
		else {
			Source.SeleniumHelper().setText(QuestionLabelTextBoxNF, QuestionLabel, Clear);
		}
		
		return this;
	}
	
	public QuestionsAvailableAccord setQuestionLabel(String QuestionLabel) {
		if(Configuration.Config.iFrame==true) {
			Source.SeleniumHelper().setText(QuestionLabelIFrame, QuestionLabelTextBox, QuestionLabel, Clear);
		}
		else {
			Source.SeleniumHelper().setText(QuestionLabelTextBoxNF, QuestionLabel, Clear);
		}
		
		return this;
	}
	
	public QuestionsAvailableAccord setSortOrder(String SortOrder, String... Clear) {
		Source.SeleniumHelper().setText(SortOrderTextBox, SortOrder, Clear);
		return this;
	}
	
	public QuestionsAvailableAccord setMinValue(String value, String... Clear) {
		Source.SeleniumHelper().setText(MinScore, value, Clear);
		return this;
	}
	
	public QuestionsAvailableAccord setMaxValue(String value, String... Clear) {
		Source.SeleniumHelper().setText(MaxScore, value, Clear);
		return this;
	}
	
	public QuestionsAvailableAccord clickAddValueAnswer() {
		Source.SeleniumHelper().clickElement(AddValueAnswer);
		return this;
	}
	
	public WebElement answerTextBoxElement(int Answer, String action) {
		String path = null;
		String Path = null;
		
		if(Answer==1) {
			path = "//div[@id='textValue']//div[1]";
		}else if(Answer==2) {
			path = "//div[@id='textValue']//div[2]";
		}else if(Answer==3) {
			path = "//div[@id='textValue']//div[3]";
		}else if(Answer==4) {
			path = "//div[@id='textValue']//div[4]";
		}else if(Answer==5) {
			path = "//div[@id='textValue']//div[5]";
		}

		if(action.equalsIgnoreCase("value")) {
			Path = path + "//input";
		}
		else if(action.equalsIgnoreCase("remove")) {
			Path = path + "//span//span";
		}
		
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(Path));
		return element;
	}
	
	public QuestionsAvailableAccord clickRemoveAnswerField1() {
		Source.SeleniumHelper().clickElement(AnswerValue1Remove);
		return this;
	}
	
	public QuestionsAvailableAccord clickRemoveAnswerField(int AnswerNum) {
		By Answer = By.xpath("//div[@id='textValue']//div[" + AnswerNum + "]//span//span");
		Source.SeleniumHelper().clickElement(Answer);
		return this;
	}
	
	public QuestionsAvailableAccord setAnswerValue(int AnswerNum, String AnswerValue, String... Clear) {
		By Answer = By.xpath("//div[@id='textValue']//div[" + AnswerNum + "]//input");
		Source.SeleniumHelper().setText(Answer, AnswerValue, Clear);
		return this;
	}
	
	public String readAnswerValue(int Answer) {
		return Source.SeleniumHelper().getAttribute(answerTextBoxElement(Answer, "value"), "original-val");
	}
	
	public String readAnswerValue() {
		return Source.SeleniumHelper().getAttribute(AnswerValue1TextBox, "original-val");
	}
	
	public String readAnswerValue2() {
		return Source.SeleniumHelper().getAttribute(AnswerValue2TextBox, "original-val");
	}
	
	public String readAnswerValue3() {
		return Source.SeleniumHelper().getAttribute(AnswerValue3TextBox, "original-val");
	}
	
	public QuestionsAvailableAccord selectRelateToQuestionDropDown(int index) {
		Source.SeleniumHelper().select(RelateToQuestionDropDown, index);
		return this;
	}
	
	public QuestionsAvailableAccord selectRelateToQuestionDropDown(String question) {
		Source.SeleniumHelper().select(RelateToQuestionDropDown, question);
		return this;
	}
	
	public String readFirstRelateToQuestionDropDown() {
		return Source.SeleniumHelper().getFirstSelectedValue(RelateToQuestionDropDown);
	}
	
	public QuestionsAvailableAccord selectRelateToAnswer(Integer[] indexes) {
		Source.SeleniumHelper().selectMultiSelectOptions(indexes, RelateToAnswerDropDown);
		return this;
	}
	
	public QuestionsAvailableAccord selectRelateToAnswer(String[] answers) {
		Source.SeleniumHelper().selectMultiSelectOptions(answers, RelateToAnswerDropDown);
		return this;
	}
	
	public QuestionsAvailableAccord setQuestionInstruction(String QuestionInstruction, String... Clear) {
		Source.SeleniumHelper().setText(QAInstructionIFrame, QAInstructionTextBox, QuestionInstruction, Clear);
		return this;
	}
	
	public QuestionsAvailableAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}
	
	public QuestionsAvailableAccord clickLockFormToggle() {
		Source.SeleniumHelper().clickElement(LockFormToggle);
		return this;
	}
	
	public QuestionsAvailableAccord clickRequiredToggle() {
		Source.SeleniumHelper().clickElement(RequiredToggle);
		return this;
	}
	
	public QuestionsAvailableAccord clickQASave() {
		Source.SeleniumHelper().clickElement(SaveBtn);
		return this;
	}
	
	public RowsAvailableAccord clickQABack() {
		Source.SeleniumHelper().clickElement(BackBtn);
		return new RowsAvailableAccord(DriverFactory.getDriver());
	}
	//**
	public QuestionsAvailableAccord clickLoadFromLookup() {
		Source.SeleniumHelper().clickElement(LoadFromLookupBtn);
		return this;
	}
	
	public QuestionsAvailableAccord setLookupSearch(String search, String... Clear) {
		Source.SeleniumHelper().setText(LookupSearchComboBox, search, true, Clear);
		return this;
	}
	//***
	public PagesPage clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return this;
	}
	
	public RolesAvailableAccord clickRolesAvailableAccordion() {
		Source.SeleniumHelper().clickElement(RolesAvailableAccordion);
		return new RolesAvailableAccord(DriverFactory.getDriver());
	}
	
	public RowsAvailableAccord clickQuestionsAvailableAccordion() {
		Source.SeleniumHelper().clickElement(QuestionsAvailableAccordion);
		return new RowsAvailableAccord(DriverFactory.getDriver());
	}
	
	public boolean allFieldsDisabled() {
		return !Source.SeleniumHelper()	.getWebElement(QuestionTypeDropDown)
									.isEnabled()
				&& !Source.SeleniumHelper()	.getWebElement(QuestionLabelTextBoxNF)
									.isEnabled()
				&& !Source.SeleniumHelper()	.getWebElement(SortOrderTextBox)
									.isEnabled()
				&& !Source.SeleniumHelper()	.getWebElement(answerTextBoxElement(1, "value"))
									.isEnabled()
				&& !Source.SeleniumHelper()	.getWebElement(RelateToQuestionDropDown)
									.isEnabled()
				&& !Source.SeleniumHelper()	.getWebElement(ActiveToggle)
									.isEnabled()
				&& !Source.SeleniumHelper()	.getWebElement(RequiredToggle)
									.isEnabled();
	}
	
	public QuestionsAvailableAccord addQuestionAndSubmit(String page, String section, String row, String label, 
			int type, int sortOrder, LinkedList<String> values, String relateToQuestion, LinkedList<String> relateToAnswer,
			boolean active, boolean required)
	{
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
		String searchRow = (page == null ? RowPrefix : row);
		Source   	.NavigationMenuBar()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.GetSource()
					.DataTable()
					.setSearch(searchSection)
					.clickFirstRow()
					.clickEdit()
					.RowsAvailableAccord()
					.setSearch(searchRow)
					.clickRowFirstRow()
					.clickRowEdit()
					.GetSource()
					.QuestionsAvailableAccord()
					.clickQAAdd()
					.setQuestionLabel(label == null ? EmptyString : label)
					.selectQuestionType(type)
					.setSortOrder(String.valueOf(sortOrder));
		
					if(values != null && values.size() > 0)
					{
						int index = 1;
						for(String value : values)
						{
							Source.QuestionsAvailableAccord().setAnswerValue(index, value).clickAddValueAnswer();
							index++;
						}
					}
					
					if(relateToQuestion != null)
						Source.QuestionsAvailableAccord().selectRelateToQuestionDropDown(relateToQuestion);
					
					if(relateToAnswer != null && relateToAnswer.size() > 0)
						for(String answer : relateToAnswer)
							Source.QuestionsAvailableAccord().selectRelateToAnswer(new String[] {answer});
					
					if((active && ActiveFlag.getAttribute("last-val").equals("false"))
							|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
						clickActiveToggle();
					
					if((required && RequiredFlag.getAttribute("last-val").equals("false"))
							|| (!required && RequiredFlag.getAttribute("last-val").equals("true")))
						clickRequiredToggle();
					
					
					Source	.QuestionsAvailableAccord()
							.clickSubmitExit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5);
		return this;
	}
	
	public QuestionsAvailableAccord addQuestion(String label, int type, int sortOrder, LinkedList<String> values, 
			String relateToQuestion, LinkedList<String> relateToAnswer, boolean active, boolean required)
	{
		Source   	.QuestionsAvailableAccord()
					.clickQAAdd()
					.setQuestionLabel(label == null ? EmptyString : label)
					.selectQuestionType(type)
					.setSortOrder(String.valueOf(sortOrder));
		
					if(values != null && values.size() > 0)
					{
						int index = 1;
						for(String value : values)
						{
							Source.QuestionsAvailableAccord().setAnswerValue(index, value).clickAddValueAnswer();
							index++;
						}
					}
					
					if(relateToQuestion != null)
						Source.QuestionsAvailableAccord().selectRelateToQuestionDropDown(relateToQuestion);
					
					if(relateToAnswer != null && relateToAnswer.size() > 0)
						for(String answer : relateToAnswer)
							Source.QuestionsAvailableAccord().selectRelateToAnswer(new String[] {answer});
					
					if((active && ActiveFlag.getAttribute("last-val").equals("false"))
							|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
						clickActiveToggle();
					
					if((required && RequiredFlag.getAttribute("last-val").equals("false"))
							|| (!required && RequiredFlag.getAttribute("last-val").equals("true")))
						clickRequiredToggle();
		return this;
	}
	
	public QuestionsAvailableAccord addQuestionAndSubmit(String page, String section, String row)
	{
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
		String searchRow = (page == null ? RowPrefix : row);
		Source   	.NavigationMenuBar()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.GetSource()
					.DataTable()
					.setSearch(searchSection)
					.clickFirstRow()
					.clickEdit()
					.RowsAvailableAccord()
					.setSearch(searchRow)
					.clickRowFirstRow()
					.clickRowEdit()
					.GetSource()
					.QuestionsAvailableAccord()
					.clickQAAdd()
					.setQuestionLabel(QuestionLabel)
					.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
					.setSortOrder("1")
					.clickSubmitExit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return this;
	}
	
	public QuestionsAvailableAccord addQuestion()
	{
		String QuestionLabel= "TC_Question_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source   	.QuestionsAvailableAccord()
					.clickQAAdd()
					.setQuestionLabel(QuestionLabel)
					.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
					.setSortOrder("1");
		return this;
	}
	
	public String addQuestionGetNameAndSubmit(String page, String section, String row)
	{
		String QuestionLabel= "TC_Question_Selenium " + SeleniumHelper.generateRandomNumber(8);
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
		String searchRow = (page == null ? RowPrefix : row);
		Source   	.NavigationMenuBar()
					.GetSource()
					.DataTable()
					.setSearch(searchPage)
					.clickFirstRow()
					.clickEdit()
					.PagesPage()
					.GetSource()
					.DataTable()
					.setSearch(searchSection)
					.clickFirstRow()
					.clickEdit()
					.RowsAvailableAccord()
					.setSearch(searchRow)
					.clickRowFirstRow()
					.clickRowEdit()
					.GetSource()
					.QuestionsAvailableAccord()
					.clickQAAdd()
					.setQuestionLabel(QuestionLabel)
					.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
					.setSortOrder("1")
					.clickSubmitExit()
					.GetSource()
					.SeleniumHelper()
					.sleep(5);
		return QuestionLabel;
	}
	
	public String addQuestionGetName()
	{
		String QuestionLabel= "TC_Question_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source   	.QuestionsAvailableAccord()
					.clickQAAdd()
					.setQuestionLabel(QuestionLabel)
					.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
					.setSortOrder("1");
		return QuestionLabel;
	}

	public String isRemoveButtonHidden() {
		return Boolean.toString(Source.SeleniumHelper().isWebElementHidden(FirstXBtn));
	}

	public String isRelatedToQuestionAlphaSort() {
		return Boolean.toString(Source.SeleniumHelper().isSortedAlpha(Source.SeleniumHelper().getWebElementList("//*[@id='quesRelated']/option")));
	}

	public String readRequired() {
		return RequiredFlag.getAttribute("last-val");
	}
	
	public String readActive() {
		return ActiveFlag.getAttribute("last-val");
	}
	
	public QuestionsAvailableAccord setQuestionRequired() {
		if(RequiredFlag.getAttribute("last-val").equals("false"))
			clickRequiredToggle();
		 return this;
	}

	public QuestionsAvailableAccord clickSortAlpha() {
		Source.SeleniumHelper().clickElement(SortAlphaButton);
		return this;
	}

	public Boolean answersSorted(List<String> unsorted) {
		List<String> sorted = Source.SeleniumHelper().sortData(unsorted);
		List<String> anwers = Source.SeleniumHelper().getTextFromInputWebElements(AnswerValueTextBoxAll);
		anwers.remove(0); //remove empty element at start
		return sorted.equals(anwers);
	}
	
	public String isAnswerTextBoxDisabled() {
		String x= Source	.SeleniumHelper()
				.getAttribute( Source.SeleniumHelper().getWebElement(answerValueTextBox), Disabled);
		return x;
	}
}