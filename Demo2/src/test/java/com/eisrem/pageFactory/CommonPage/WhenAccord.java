package com.eisrem.pageFactory.CommonPage;

	import java.awt.Desktop.Action;
import java.util.List;

import javax.swing.ActionMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Administrator.NotificationsPage;

	public class WhenAccord extends NotificationsPage{

		public WhenAccord(WebDriver driver) {
			super (driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//h4[contains(text(),'Check For Notifications')]")
		public WebElement CheckForNotificationsTitle;
		
		@FindBy(xpath="//label[@for='when-frequency']")
		public WebElement FrequencyTitle;
		
		@FindBy(xpath="//input[@id='when-frequency']")
		public WebElement NotifyInTextBox;
		
		@FindBy(xpath="//label[@for='when-frequency-format']")
		public WebElement FormatTitle;
		
		@FindBy(xpath="//select[@id='when-frequency-format']")
		public WebElement FormatSelectBox;
		
		@FindBy(xpath="//h4[contains(text(),'Expiration of Notifications')]")
		public WebElement ExpirationOfNotificationsTitle;
		
		@FindBy(xpath="//label[@for='when-expiration-frequency']")
		public WebElement DaysTillExpirationTitle;
		
		@FindBy(xpath="//input[@id='when-expiration-frequency']")
		public WebElement DaysTillExpirationTextBox;
		
		@FindBy(xpath="//h4[contains(text(),'Occurance of Notifications')]")
		public WebElement OccuranceOfNotificationsTitle;
		
		@FindBy(xpath="//label[@for='when-occurance-format']")
		public WebElement OccuranceTitle;
		
		@FindBy(xpath="//select[@id='when-occurance-format']")
		public WebElement OccuranceSelectBox;
		
		@FindBy(xpath="//label[contains(text(),'Days After Occurance')]")
		public WebElement DaysAfterOccuranceTitle;
		
		@FindBy(xpath="//input[@id='when-occurance']")
		public WebElement DaysAfterOccuranceTextBox;
		
		public String readCheckForNotificationsTitle() {
			return Source.SeleniumHelper().readElement(CheckForNotificationsTitle);
		}
		
		public String readFrequencyTitle() {
			return Source.SeleniumHelper().readElement(FrequencyTitle);
		}
		
		public WhenAccord setNotifyIn(String min, String... Clear) {
			Source.SeleniumHelper().setText(NotifyInTextBox, Keys.BACK_SPACE + min, Clear);
			return this;
		}
		
		public WhenAccord setNotifyIn(String min, boolean tab, String... Clear) {
			Source.SeleniumHelper().setText(NotifyInTextBox, Keys.BACK_SPACE + min, tab, Clear);
			return this;
		}
		
		public String readFormatTitle() {
			return Source.SeleniumHelper().readElement(FormatTitle);
		}
		
		public WhenAccord selectWhenFormat(int index) {
			Source.SeleniumHelper().select(FormatSelectBox, index);
			return this;
		}
		
		public String readExpirationOfNotificationsTitle() {
			return Source.SeleniumHelper().readElement(ExpirationOfNotificationsTitle);
		}
		
		public String readDaysTillExpirationTitle() {
			return Source.SeleniumHelper().readElement(DaysTillExpirationTitle);
		}

		public WhenAccord setWhenDaysTillExpiration(String value, String... Clear) {
			Source.SeleniumHelper().setText(DaysTillExpirationTextBox, value, Clear);
			return this;
		}
			
		public String readOccuranceOfNotificationsTitle() {
			return Source.SeleniumHelper().readElement(OccuranceOfNotificationsTitle);
		}
		
		public String readOccuranceTitle() {
			return Source.SeleniumHelper().readElement(OccuranceTitle);
		}
		
		public WebElement readOccurance() {
			return Source.SeleniumHelper().getWebElement(OccuranceSelectBox);
		}

		public WhenAccord selectWhenOccurance(int index) {
			Source.SeleniumHelper().select(OccuranceSelectBox, index);
			return this;
		}
		
		public String readDaysAfterOccuranceTitle() {
			return Source.SeleniumHelper().readElement(DaysAfterOccuranceTitle);
		}
		
		public WhenAccord setDaysAfterOccurance(String value, String... Clear) {
			Source.SeleniumHelper().setText(DaysAfterOccuranceTextBox, value, Clear);
			return this;
		}
		
		public WhenAccord confirmFrequencyValue(String comp) throws Exception {
			String freqValue = Source.SeleniumHelper().getWebElement(this.NotifyInTextBox).getAttribute("value");
			if(freqValue.equals(comp)) {
				return this;
			}
			throw new Exception("Value in frequency field was not set to " + comp);
			
		}
		
		public WhenAccord confirmWhenFrequencyOccurence(String whenOccurence) throws Exception {
			List<WebElement> occurenceOptions = Source.SeleniumHelper().getWebElement(this.FormatSelectBox).findElements(By.xpath(".//option[text()='" + whenOccurence + "']"));
			boolean isExist=false;
			for(WebElement option : occurenceOptions) {
				if(option.getAttribute("innerHTML").equals(whenOccurence) && option.isSelected()) {
					isExist=true;

					break;
				}
			}
			if(!isExist)
			{
				throw new Exception("Value in Format field was not set to " + whenOccurence);
			}
			return this;
		}

}
