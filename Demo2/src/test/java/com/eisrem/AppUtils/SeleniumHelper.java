package com.eisrem.AppUtils;

import static org.testng.Assert.assertTrue;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration.Enviornment;
import com.eisrem.AppUtils.Exceptions.SeleniumExceptions;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.google.common.io.Files;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Collections;

public class SeleniumHelper extends Data{

	WebDriver driver = DriverFactory.getDriver();
	public static Logger log = Logger.getLogger("Selenium");
	WebDriverWait wait;
	Select select;
	Alert alert;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	SoftAssert softAssert;
	int waitSec = 10;
	int sleepSec = 1;
	int maxAttempts = 5;

	public ObjectSource GetSource() {
		return new ObjectSource();
	}

	public DataTable DataTable() {
		return new DataTable(DriverFactory.getDriver());
	}

	public SeleniumHelper log(String Message) {
		log.info(Message);
		return this;
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	//Get title of current page
	public String getTitle() {
		return driver.getTitle();
	}

	//Close current Browser - Does not close driver instance
	public SeleniumHelper closeBrowser() {
		driver.close();
		return this;
	}

	//Close driver instance and all Browser associted
	public SeleniumHelper quitBrowser() {
		driver.quit();
		return this;
	}

	//Go to Url with given destination
	public SeleniumHelper goToUrl(String url) {
		driver.get(url);
		return this;
	}

	//Navigate to Url with given destination
	public SeleniumHelper navigateToUrl(String url) {
		driver.navigate().to(url);
		return this;
	}

	//Navigate to previous page 
	public SeleniumHelper navigateBack() {
		driver.navigate().back();
		return this;
	}

	//Navigate forward
	public SeleniumHelper navigateForward(String url) {
		driver.navigate().forward();
		return this;
	}

	//Refresh current Browser
	public SeleniumHelper refreshPage() {
		driver.navigate().refresh();
		return this;
	}

	//Get handle ID of current window
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	//Get handle ID of all windows
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	//Switch to second window
	public SeleniumHelper switchWindow() {
		String parent = getWindowHandle();
		Set<String> allHandles = getWindowHandles();
		for (String handle : allHandles) {
			if(!handle.equals(parent)) {
				driver.switchTo().window(handle);
			}
		}
		return this;
	}

	//Switch to IFrame using webElement
	public SeleniumHelper switchToIFrame(WebElement iFrame) {
		driver.switchTo().frame(iFrame);
		return this;
	}

	//Switch to IFrame using String
	public SeleniumHelper switchToIFrame(String iFrameNameOrID) {
		driver.switchTo().frame(iFrameNameOrID);
		return this;
	}

	//Switch to IFrame using index
	public SeleniumHelper switchToIFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
		return this;
	}

	//Switch to parent frame
	public SeleniumHelper switchToParentFrame() {
		driver.switchTo().parentFrame();
		return this;
	}	

	//Hard sleep with given amount in SleepSec
	public SeleniumHelper sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SeleniumHelper();
	}

	//Hard sleep with given amount in SleepSec
	public SeleniumHelper sleepMiliSec(int sec) {
		try {
			Thread.sleep(sec * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;

	}

	//Returns Today in MM-dd-yyy format 
	public Date date() {	
		Date date = new Date();
		return date;
	}

	//Returns Today in MM-dd-yyy format 
	public static String dateOnly(String dash) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}

	//Returns Today in MM/dd/yyy format 
	public static String dateOnly() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}

	//Returns Today in custom format
	public static String dateCustom(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}
	
	//Returns Date in custom format
	public static String dateCustom(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		String date1 = dateFormat.format(date);
		return date1;
	}

	//Returns Today in MM/dd/yyyy format 
	public static String dateOnlyFuture(String format, int num) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, num);
		Date newDate = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat(format);
		String date1 = dateFormat.format(newDate);
		return date1;
	}

	//Returns future Today with given time 
	public static String dateOnlyFuture(int num) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, num);
		Date newDate = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date1 = dateFormat.format(newDate);
		return date1;
	}

	//Returns Today in MM/dd/yyyy format 
	public static String dateOnlyPast(String format, int num) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -num);
		Date newDate = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat(format);
		String date1 = dateFormat.format(newDate);
		return date1;
	}

	//Returns future Today with given time 
	public static String dateOnlyPast(int num) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -num);
		Date newDate = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date1 = dateFormat.format(newDate);
		return date1;
	}

	//Returns Today and time in MM-dd-yyyy  HH:mm:ss format 
	public static String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}

	//Returns Today and time in MM-dd-yyy  HH:mm:ss format 
	public static String dateTimeFileNameFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}

	//Returns current Today and time for a given country & City ex. "America/New_York"
	public static String dateTime_location(String location) {
		String currentTime = null;
		ZoneId zd = ZoneId.of(location);
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone(zd));
		DateFormat dateFormatLocal = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

		try{
			currentTime = dateFormatLocal.format(dateFormatLocal.parse(dateFormat.format(new Date())));
		} catch (java.text.ParseException e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace();
			log.info(sw.toString());
		}
		return currentTime;
	}

	//Returns current Today and time for a given country & City ex. "America/New_York"
	public static String dateTime_zone(String timeZone) {
		String currentTime = null;
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		DateFormat dateFormatLocal = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

		try{
			currentTime = dateFormatLocal.format(dateFormatLocal.parse(dateFormat.format(new Date())));
		} catch (java.text.ParseException e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace();
			log.info(sw.toString());
		}
		return currentTime;
	}

	//Will get value of the attribute of the given WebElement
	public String getAttribute(WebElement element, String attribute) {
		return getWebElement(element).getAttribute(attribute);
	}

	//Will generate a random alpha with given max char
	public static String generateRandomAlpha(int max) {
		return RandomStringUtils.randomAlphabetic(max);
	}

	//Will generate a random alphanumeric with given max char
	public String generateRandomAlphaNumeric(int max) {
		return RandomStringUtils.randomAlphanumeric(max);
	}

	//Will return Random String Utils object for customized random function
	public RandomStringUtils random() {
		return new RandomStringUtils();
	}

	//Will generate a random number between given 1000000 to 10000000
	public static int generateRandomNumber() {
		int min = 1000000;
		int max = 10000000; 

		return (int) (Math.random() * (max - min + 1) + min) ;
	}

	//Generate random number with given min and max
	public static int generateRandomNumber(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min) ;
	}

	//Generate random social
	public String generateRandomSocial() {

		return String.valueOf((long) Math.floor(Math.random() * 900000000L) + 100000000L);
	}

	//Generate random number with given digits
	public static int generateRandomNumber(int digits) {
		//		Random random = new Random();
		//		return random.nextInt(max) ;
		if (digits==1) {
			return (int) (Math.random() * (9 - 1 + 1) + 1) ;
		}
		else if(digits==2) {
			return (int) (Math.random() * (99 - 10 + 1) + 10) ;
		}
		else if(digits==3) {
			return (int) (Math.random() * (999 - 100 + 1) + 100) ;
		}
		else if(digits==4) {
			return (int) (Math.random() * (9999 - 1000 + 1) + 1000) ;
		}
		else if(digits==5) {
			return (int) (Math.random() * (99999 - 10000 + 1) + 10000) ;
		}
		else if(digits==6) {
			return (int) (Math.random() * (999999 - 100000 + 1) + 100000) ;
		}
		else if(digits==7) {
			return (int) (Math.random() * (9999999 - 1000000 + 1) + 1000000) ;
		}
		else if(digits==8) {
			return (int) (Math.random() * (99999999 - 10000000 + 1) + 10000000) ;
		}
		else if(digits==9) {
			return (int) (Math.random() * (999999999 - 100000000 + 1) + 100000000) ;
		}
		else if(digits==10) {
			return (int) (Math.random() * (9999999999L - 1000000000 + 1) + 1000000000) ;
		}
		else {
			throw new IndexOutOfBoundsException("The given amount of digits is not currently supported");
		}
	}

	//Generate random identifier
	public static String generateRandomMedicaidIdentifier() {

		return SeleniumHelper.generateRandomNumber(8) + SeleniumHelper.generateRandomAlpha(1).toUpperCase();
	}

	//Returns a single element using any locator
	public WebElement findWebElement(By by) {
		Wait();

		WebElement element = null;	
		try {

			element = driver.findElement(by);

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Element does not exist");

		}catch (Exception e) {
			e.printStackTrace();
			throw new NoSuchElementException("Element does not exist");
		}

		return element;
	}

	//Returns a list of elements using any locator
	public List<WebElement> getWebElementList(By by){
		Wait();
		try {
			return driver.findElements(by);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Element does not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw new NoSuchElementException("Element does not exist");
		}

	}

	//Returns a list of elements using xpath
	public List<WebElement> getWebElementList(String xpath) {
		Wait();
		try {
			List<WebElement> listOfElements = driver.findElements(By.xpath(xpath));
			return listOfElements;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Element does not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw new NoSuchElementException("Element does not exist");
		}

	}

	//Find an web element with 3 attempts and page load included 
	public WebElement getWebElement(WebElement element) {
		Wait();

		if (ifWebElementExists(element, true)==true) {
			highLightElement(element);
			unhighLightElement(element);
			return element;
		}
		else {
			return null;
		}

	}

	//Find an web element with 3 attempts and page load included 
	public WebElement getWebElement(By by) {
		Wait();

		if (ifWebElementExists(by, true)==true) {
			WebElement element= findWebElement(by);
			highLightElement(element);
			unhighLightElement(element);
			return element;
		}
		else {
			return null;
		}
	}

	//Will wait for element to be present for given time checking every 5 SleepSec - Fluent Wait (By locator)
	public boolean checkWebElementExists(By element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).
					pollingEvery(Duration.ofSeconds(5)).
					ignoring(NoSuchElementException.class);
			return wait.until(ExpectedConditions.presenceOfElementLocated(element)) instanceof WebElement;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkWebElementExists(By element, int sec) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).
					pollingEvery(Duration.ofSeconds(sec)).
					ignoring(NoSuchElementException.class);
			return wait.until(ExpectedConditions.presenceOfElementLocated(element)) instanceof WebElement;
		} catch (Exception e) {
			return false;
		}
	}

	//Will wait for element to be present for given time checking every 5 SleepSec - Fluent Wait (Web Element)
	public boolean checkWebElementExists(WebElement element, int sec) {
		boolean isPresent;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).
					pollingEvery(Duration.ofSeconds(sec)).
					ignoring(NoSuchElementException.class);
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			return isPresent;
		} catch (Exception e) {
			return false;
		}
	}

	//Will wait for element to be present for 15 checking every 5 SleepSec - Fluent Wait
	public boolean checkWebElementExists(WebElement element) {
		boolean isPresent;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).
					pollingEvery(Duration.ofSeconds(5)).
					ignoring(NoSuchElementException.class);
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			return isPresent;
		} catch (Exception e) {
			return false;
		}
	}

	//Will wait for element to be present - Explicit Wait
	public boolean ifWebElementExists(WebElement element) {
		int attempts = 0;

		while (attempts < maxAttempts) {	
			try {

				wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));
				if(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()) {
					return true;
				}
				else {
					return false;
				}
			} catch (NoSuchElementException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return false;
				}

			}catch (TimeoutException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return false;
				}

			}catch (Exception e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return false;
				}

			}

		}
		return false;

	}

	//Will wait for element to be present - Explicit Wait
	public boolean ifWebElementExists(WebElement element, Boolean ExceptionCatch) {
		int attempts = 0;

		while (attempts <maxAttempts) {
			try {

				wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));
				if(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()) {
					return true;
				}
				else {
					return false;
				}
			} catch (NoSuchElementException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					log.info("WebDriver failed to locate element on page after  " + maxAttempts + " attempts. "
							+ "Please Recheck locator & try again.");
					throw SeleniumExceptions.NoSuchElementException(element);
				}

			}catch (TimeoutException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					log.info("WebDriver failed to locate element on page after  " + maxAttempts + " attempts. "
							+ "Please Recheck locator & try again.");
					throw SeleniumExceptions.TimeoutException(element);
				}

			}catch (Exception e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					log.info("Unchecked Exception");
					e.printStackTrace();
					throw SeleniumExceptions.NoSuchElementException(element);
				}

			}

		}
		return false;
	}

	//Will wait for element to be present - Explicit Wait - Will return true or false only
	public boolean ifWebElementExists(By by) {

		int attempts = 0;

		while (attempts < maxAttempts) {	
			try {

				wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));

				if(wait.until(ExpectedConditions.visibilityOf(findWebElement(by))).isDisplayed()) {
					return true;
				}
				else {
					return false;
				}
			} catch (NoSuchElementException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return false;
				}

			}catch (TimeoutException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return false;
				}

			}catch (Exception e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return false;
				}

			}

		}
		return false;

	}

	//Will wait for element to be present - Explicit Wait - Will throw exception only
	public boolean ifWebElementExists(By by, Boolean ExceptionCatch) {
		int attempts = 0;

		while (attempts <maxAttempts) {
			try {

				wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));
				if(wait.until(ExpectedConditions.visibilityOf(findWebElement(by))).isDisplayed()) {
					return true;
				}
				else {
					return false;
				}
			} catch (NoSuchElementException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					log.info("WebDriver failed to locate element on page after  " + maxAttempts + " attempts. "
							+ "Please Recheck locator & try again.");
					throw SeleniumExceptions.NoSuchElementException(by);
				}

			}catch (TimeoutException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					log.info("WebDriver failed to locate element on page after  " + maxAttempts + " attempts. "
							+ "Please Recheck locator & try again.");
					throw SeleniumExceptions.TimeoutException(by);
				}

			}catch (Exception e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					log.info("Unchecked Exception");
					e.printStackTrace();
					throw SeleniumExceptions.NoSuchElementException(by);
				}

			}

		}
		return false;
	}

	//Will wait for element to be present - Explicit Wait
	public String ifWebElementExistsBooleanString(By by) {
		int attempts = 0;

		while (attempts < maxAttempts) {	
			try {

				wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));

				if(wait.until(ExpectedConditions.visibilityOf(findWebElement(by))).isDisplayed()) {
					return Boolean.toString(true);
				}
				else {
					return Boolean.toString(false);
				}
			} catch (NoSuchElementException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return Boolean.toString(false);
				}

			}catch (TimeoutException e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return Boolean.toString(false);
				}

			}catch (Exception e) {
				Wait();
				attempts++;

				if(attempts>=maxAttempts) {
					return Boolean.toString(false);
				}

			}

		}
		return Boolean.toString(false);
	}

	//Will wait for element to be present - Explicit Wait
	public boolean ifWebElementExists(WebElement element, int sec) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			if(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	//Will wait for element to be present - Explicit Wait
	public boolean ifWebElementExists(By path, int sec) {
		try {
			WebElement element = driver.findElement(path);
			wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			if(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	//Explicit wait for given WebElement to be clickable for given time
	public WebElement waitUntilElementToBeClickable (WebElement element, int sec) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch(Exception e) {
			log.debug("Element was not clickable within given time period");
			return element;
		}
	}

	//Explicit wait for given WebElement to be visible for given time
	public WebElement waitUntilElementToBeVisible (WebElement element, int sec) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch(Exception e) {
			log.debug("Element was not visible within given time period");
			return element;
		}
	}

	//Explicit wait for given WebElement to be visible or clickable for given time
	public SeleniumHelper waitForElement(WebElement element, int sec) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOf(element));
			return this;
		} catch(Exception e) {
			try {
				wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return this;
			} catch(Exception e1) {
				log.debug("Element was not avaible within given time period");
				return this;
			}
		}
	}

	//Explicit wait for given WebElement to be clickable for 2 SleepSec
	public WebElement waitUntilElementToBeClickable (WebElement element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch(Exception e) {
			log.debug("Element was not clickable within given time period");
			return element;
		}
	}

	//Explicit wait for given WebElement to be visible 2 SleepSec
	public WebElement waitUntilElementToBeVisible (WebElement element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch(Exception e) {
			log.debug("Element was not visible within given time period");
			return element;
		}
	}

	//Explicit wait for given WebElement to be visible or clickable for 2 SleepSec
	public SeleniumHelper waitForElement(WebElement element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOf(element));
			return this;
		} catch(Exception e) {
			try {
				wait = new WebDriverWait(driver, Duration.ofSeconds(2));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return this;
			} catch(Exception e1) {
				log.debug("Element was not avaible within given time period");
				return this;
			}
		}
	}

	//Will execute Javascript
	public SeleniumHelper runJavascript(String script) {
		try {
			JavascriptExecutor JS = (JavascriptExecutor) driver;
			JS.executeScript(script);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	//Will execute Javascript and return object
	public Object runJavascriptWithReturn(String javascript) {
		try {
			JavascriptExecutor JS = (JavascriptExecutor) driver;
			return JS.executeScript(javascript);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//Wait function to wait until page or dom loads
	public SeleniumHelper waitForLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {

				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			sleep(sleepSec);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));
			wait.until(expectation);
		}catch(Throwable error) {
			assertFail("Timeout waiting for Page Load Request to complete");
		}
		return this;
	}

	//Wait function to wait until page or dom loads
	public SeleniumHelper waitForLoad(int sec) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {

				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}

		};
		try {
			sleep(sec);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSec));
			wait.until(expectation);
		}catch(Throwable error) {
			assertFail("Timeout waiting for Page Load Request to complete");
		}
		return this;
	}

	//Wait function to wait until all AJAX calls are completed
	public SeleniumHelper waitForPageAJAX() {
		try {
			synchronized (DriverFactory.getDriver()) {
				WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(waitSec));
				ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver)
								.executeScript("return Object.keys((eis?eis.custom.running_ajax:{})).length == 0")
								.equals(true);
					}
				};

				wait.until(jsLoad);
			}
		} catch (UnhandledAlertException e) {
			e.printStackTrace();
			Alert alert = DriverFactory.getDriver().switchTo().alert();
			try {
				alert.dismiss();
			} catch (Exception ee) {
				alert.accept();
			}
		} catch (JavascriptException je) {

		}
		return this;

	}

	//Includes wait for load & page ajax
	public SeleniumHelper Wait() {
		waitForLoad();
		waitForPageAJAX();
		return this;
	}

	//Includes wait for load & page ajax
	public SeleniumHelper Wait(int Sleep) {
		waitForLoad(Sleep);
		waitForPageAJAX();
		return this;
	}

	//Highlight element with given WebElement: Yellow background and Blue border
	public WebElement highLightElement(WebElement element) {
		if(Configuration.Config.highLight.equalsIgnoreCase("yes")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			sleep(1);
		}
		return element;
	}

	//Highlight element with given WebElement: Yellow background and Blue border
	public WebElement unhighLightElement(WebElement element) {
		if(Configuration.Config.unHighLight.equalsIgnoreCase("yes")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='0px solid white'", element);
		}
		return element;
	}

	//Clear element
	public SeleniumHelper clearElement(WebElement element) {
		try{
			getWebElement(element).clear();
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		} 
		return this;
	}

	//Clear element
	public SeleniumHelper clearElement(By element) {
		WebElement Element = null;

		try{
			Element = getWebElement(element);
			Element.clear();
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(Element);
		} 
		return this;
	}

	//Send keys 
	public SeleniumHelper setText(WebElement element, String text, String... Clear) {
		try{
			if (Clear.length>0) {
				clearElement(element);
			}
			getWebElement(element).sendKeys(text);

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}

		return this;
	}

	public SeleniumHelper setText(WebElement iFrame, WebElement element, String text, String... Clear) {
		try{
			switchToIFrame(iFrame);

			if (Clear.length>0) {
				clearElement(element);
				element.sendKeys(text);
			}else {
				getWebElement(element).sendKeys(text);
			}
			
			switchToParentFrame();

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}

		return this;
	}

	//Send keys with tab - boolean must = true
	public SeleniumHelper setText(WebElement element, String text, boolean tab, String... clear) {
		try{
			if (clear.length>0) {
				clearElement(element);
			}

			getWebElement(element).sendKeys(text);

			if(tab) {
				sleep(1)
				.pressTab();
			}

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}

		return this;
	}

	//Send keys 
	public SeleniumHelper setText(WebElement element, int text, String... clear) {
		try{
			if (clear.length>0) {
				clearElement(element);
			}
			getWebElement(element).sendKeys(String.valueOf(text));

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}
		return this;
	}

	//Send keys with tab - boolean must = true
	public SeleniumHelper setText(WebElement element, int text, boolean tab, String... clear) {
		try{
			if (clear.length>0) {
				clearElement(element);
			}

			getWebElement(element).sendKeys(String.valueOf(text));

			if(tab) {
				sleep(1)
				.pressTab();
			}

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}

		return this;
	}

	//Send keys 
	public SeleniumHelper setText(By element, String text, String... clear) {
		WebElement Element = null;

		try{
			if (clear.length>0) {
				clearElement(element);
			}
			Element = getWebElement(element);
			Element.sendKeys(text);

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(Element);
		}
		return this;
	}

	//Send keys with tab - boolean must = true
	public SeleniumHelper setText(By element, String text, boolean tab, String... clear) {
		try{
			if (clear.length>0) {
				clearElement(element);
			}

			getWebElement(element).sendKeys(text);

			if(tab) {
				sleep(1)
				.pressTab();
			}

		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}

		return this;
	}

	//Clear text and enter new text
	public SeleniumHelper resetText(WebElement element, String text) {
		try{
			clearElement(element);
			setText(element, text);
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}
		return this;
	}

	//Click an element
	public SeleniumHelper clickElement(WebElement element) {
		try{
			getWebElement(element).click();
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element. Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}
		return this;
	}

	//Click an element
	public SeleniumHelper clickElement(By element) {
		WebElement Element = null;

		try{
			Element = getWebElement(element);
			Element.click();
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(Element);
		}
		return this;
	}

	//Read an element
	public String readElement(By element) {
		WebElement Element = null;

		try{
			Element = getWebElement(element);
			return Element.getText();
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(Element);
		}
	}

	//Read an element
	public String readElement(WebElement element) {
		String text = null;
		try{
			text = getWebElement(element).getText();
			return text;
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}
	}

	public String readActiveElement() {
		String text = null;
		try{
			text = DriverFactory	
					.getDriver()
					.switchTo()
					.activeElement()
					.getText();
			return text;
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(DriverFactory.getDriver().switchTo().activeElement());
		}
	}

	public SeleniumHelper clickActiveElement() {

		try{
			DriverFactory	
			.getDriver()
			.switchTo()
			.activeElement()
			.sendKeys("AAA");
			return this;
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(DriverFactory.getDriver().switchTo().activeElement());
		}
	}

	//Read an element
	public String readAttribute(By element, String attribute) {
		WebElement Element = null;

		try{
			Element = getWebElement(element);
			return Element.getAttribute(attribute);
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(Element);
		}
	}

	//Read an element
	public String readAttribute(WebElement element, String attribute) {
		String text = null;
		try{
			text = getWebElement(element).getAttribute(attribute);
			return text;
		}catch (ElementNotInteractableException e) {
			log.info("Error occured when trying to interact with element.  Please check the function & try again.");
			throw SeleniumExceptions.ElementNotInteractableException(element);
		}
	}

	//Clear All Cookies
	public SeleniumHelper clearAllCookies() {
		driver.manage().deleteAllCookies();
		return this;
	}

	//Read Config file from given file name
	public String readConfig(String configFileName, String key) {
		Properties prop = new Properties();
		String fileName= "src/test/resources/ConfigFiles/"+configFileName;
		InputStream is = null;

		try {
			is = new FileInputStream(fileName);
			prop.load(is);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

		return prop.getProperty(key);
	}

	//Read Config file from Config.properties
	public String readConfig(String key) {
		Properties prop = new Properties();
		String fileName= "src/test/resources/ConfigFiles/Config.properties";
		InputStream is = null;

		try {
			is = new FileInputStream(fileName);
			prop.load(is);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

		return prop.getProperty(key);
	}

	//Take Screen Shot
	public String takeScreenShot(String testStep) {
		if(Configuration.Config.takeScreenShot.equalsIgnoreCase("Yes")) {
			String name = testStep+ " " + dateOnly("-") + ".png";
			File SourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				File localScreenshots = new File(new File("build"), "Screenshots");
				if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
					localScreenshots.mkdirs();
				}
				File screenshot = new File(localScreenshots, name);
				Files.copy(SourceFile,  screenshot);
			}catch(IOException e) {
				log.info("Screenshot capture failed");
			}
			return name;
		}
		else {
			return null;
		}

	}

	//Will clear out directory for given location
	public SeleniumHelper cleanDirectory(String fileLocation) {
		try {
			FileUtils.cleanDirectory(new File(fileLocation));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	//Will clear out screen shot directory if the flag is placed yes
	public SeleniumHelper cleanScreenShotDirectory() {
		if(Configuration.Config.cleanScreenShotDirectory.equalsIgnoreCase("Yes")) {
			cleanDirectory(Configuration.fileLocation.screentShot);
		}
		return this;
	}

	//Will clear out reports directory if the flag is placed yes
	public SeleniumHelper cleanReportsDirectory() {
		if(Configuration.Config.cleanReportsDirectory.equalsIgnoreCase("Yes")) {
			cleanDirectory(Configuration.fileLocation.reports);
		}
		return this;
	}

	//Will clear out download directory if the flag is placed yes
	public SeleniumHelper cleanDownloadDirectory() {
		if(Configuration.Config.cleanDownloadDirectory.equalsIgnoreCase("Yes")) {
			cleanDirectory(Configuration.fileLocation.download);
		}
		return new SeleniumHelper();
	}

	//Read Excel File & Get Workbook
	public XSSFWorkbook getWorkbook(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
		}catch(IOException e) {
			//			throw new InvalidPathForExcelException("Excel File you are trying to read is not found");
		}
		return workbook;
	}

	//Get sheet
	public XSSFSheet getWorkSheet(String filePath, String sheetName) {
		sheet = getWorkbook(filePath).getSheet(sheetName);
		return sheet;
	}

	//Close Excel workbook
	public SeleniumHelper closeWorkBook(String filePath) {
		try {
			getWorkbook(filePath).close();
		} catch (IOException e) {
			log.error("Unable to close workbook");
			e.printStackTrace();
		}
		return this;
	}

	//Get total number of rows from Excel sheet
	public int getRowCount(String filePath, String sheetName) {
		int rows = getWorkSheet(filePath, sheetName).getLastRowNum();
		rows = rows + 1;
		closeWorkBook(filePath);
		return rows;
	}

	//Get total number of cells from Excel sheet
	public int getRowCount(String filePath, String sheetName, int rowNum) {
		int rows = getWorkSheet(filePath, sheetName).getRow(rowNum).getLastCellNum();
		rows = rows + 1;
		closeWorkBook(filePath);
		return rows;
	}

	//Get Data from Excel File 
	public String readExcelData(String filePath, String sheetName, int column, int row) {
		String data = getWorkSheet(filePath, sheetName).getRow(row).getCell(column).getRawValue();
		closeWorkBook(filePath);
		return data;
	}

	//Will return select object
	public Select select(WebElement element) {
		try {
			WebElement e = getWebElement(element);
			return new Select(e);
		}catch (ElementNotSelectableException e) {
			log.info("Error occured when trying to interact with element.  Element was not interactable.");
			Wait();
			throw SeleniumExceptions.ElementNotSelectableException(element);

		} catch (Exception e) {
			Wait();
			e.printStackTrace();
			throw SeleniumExceptions.ElementNotSelectableException(element);
		}

	}

	//Will select element with given string value
	public SeleniumHelper select(WebElement element, String value) {
		try {
			select = select(element);
			select.selectByVisibleText(value);
		}catch (ElementNotSelectableException e) {
			log.info("Error occured when trying to interact with element.  Element was not interactable.");
			Wait();
			throw SeleniumExceptions.ElementNotSelectableException(element);

		} catch (Exception e) {
			Wait();
			e.printStackTrace();
			throw SeleniumExceptions.ElementNotSelectableException(element);
		}
		return this;

	}

	//Will select element with given index position
	public SeleniumHelper select(WebElement element, int value) {
		try {
			select = select(element);
			select.selectByIndex(value);
		}catch (ElementNotSelectableException e) {
			log.info("Error occured when trying to interact with element.  Element was not interactable.");
			Wait();
			throw SeleniumExceptions.ElementNotSelectableException(element);

		} catch (Exception e) {
			Wait();
			e.printStackTrace();
			throw SeleniumExceptions.ElementNotSelectableException(element);
		}
		return this;
	}

	//Will select element with given string value
	public SeleniumHelper select(By element, String value) {
		try {
			WebElement e = getWebElement(element);
			select = new Select(e);
			select.selectByVisibleText(value);
		}catch (ElementNotSelectableException e) {
			log.info("Error occured when trying to interact with element.  Element was not interactable.");
			Wait();
			throw SeleniumExceptions.ElementNotSelectableException(element);

		} catch (Exception e) {
			Wait();
			e.printStackTrace();
			throw SeleniumExceptions.ElementNotSelectableException(element);
		}
		return this;
	}

	//Will select element with given index position
	public SeleniumHelper select(By element, int value) {
		try {
			WebElement e = getWebElement(element);
			select = new Select(e);
			select.selectByIndex(value);
		}catch (ElementNotSelectableException e) {
			log.info("Error occured when trying to interact with element.  Element was not interactable.");
			Wait();
			throw SeleniumExceptions.ElementNotSelectableException(element);

		} catch (Exception e) {
			Wait();
			e.printStackTrace();
			throw SeleniumExceptions.ElementNotSelectableException(element);
		}
		return this;
	}

	//Return size of select list
	public int getSelectSize(WebElement element)
	{
		Select sel = new Select(getWebElement(element));
		List<WebElement> list = sel.getOptions();
		return list.size();
	}

	//Will click and verify all values from given drop down WebElement
	public SeleniumHelper verifyAndClickAllDropDown(WebElement element, List<String> values) {
		softAssert = new SoftAssert();
		int actualDropDownSize = 0;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			actualDropDownSize = actualValues.size();
			int x = 0;
			for(WebElement i: actualValues) {
				i.click();
				softAssert.assertEquals(i.getText(), values.get(x));
				x++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Missing Expected dropdown values");
			log.debug("Expected number of values: " + values.size());
			log.debug("Actual number of values: " + actualDropDownSize);
		}
		finally {
			softAssert.assertAll();
		}
		return this;

	}

	//Will click and verify all values from given drop down WebElement optionally ignoring select and regardless of order
	public SeleniumHelper verifyAndClickAllDropDown(WebElement element, List<String> values, Boolean ignoreSelect) {
		softAssert = new SoftAssert();
		int minusValues = ignoreSelect?1:0;
		int actualDropDownSize = 0 - minusValues;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			actualDropDownSize = actualValues.size();

			for(WebElement i: actualValues) {
				if ((ignoreSelect && !i.getText().toUpperCase().equals("SELECT")) || !ignoreSelect)
				{
					i.click();
					softAssert.assertEquals(true, values.contains(i.getText()));
					SeleniumHelper.log.info("Text: " + i.getText() + "  ||   In Values? " + values.contains(i.getText()));
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Missing Expected dropdown values");
			log.debug("Expected number of values: " + (values.size() - minusValues));
			log.debug("Actual number of values: " + actualDropDownSize);
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Will verify all values from given drop down WebElement
	public SeleniumHelper verifyAllDropDown(WebElement element, List<String> values) {
		softAssert = new SoftAssert();
		int actualDropDownSize = 0;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			actualDropDownSize = actualValues.size();
			int x = 0;
			for(WebElement i: actualValues) {
				highLightElement(i);
				softAssert.assertEquals(i.getText(), values.get(x));
				unhighLightElement(i);
				x++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Missing Expected dropdown values");
			log.debug("Expected number of values: " + values.size());
			log.debug("Actual number of values: " + actualDropDownSize);
		}
		finally {
			softAssert.assertAll();
		}
		return this;

	}

	//Will verify all values from given drop down is in alphabetical order
	public SeleniumHelper verifyDropDownIsInOrderAlpha(WebElement element) {
		softAssert = new SoftAssert();
		int actualDropDownSize = 0;
		List<String> orderedValues = null;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			if(actualValues.get(0).getText().equals("Select"))
				actualValues.remove(0);
			orderedValues = sortStringElements(actualValues);
			actualDropDownSize = actualValues.size();
			int x = 0;
			for(WebElement i: actualValues) {
				softAssert.assertEquals(i.getText(), orderedValues.get(x));
				x++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Missing Expected dropdown values");
			log.debug("Expected number of values: " + orderedValues.size());
			log.debug("Actual number of values: " + actualDropDownSize);
		}
		finally {
			softAssert.assertAll();
		}
		return this;

	}

	//Will verify all values from given drop down is in alphabetical order
	public SeleniumHelper verifyDropDownIsInOrderNumericAsc(WebElement element) {
		softAssert = new SoftAssert();
		int actualDropDownSize = 0;
		List<String> orderedValues = null;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			if(actualValues.get(0).getText().equals("Select")) {
				actualValues.remove(0);
			}

			orderedValues = sortStringElements(actualValues);
			actualDropDownSize = actualValues.size();
			int x = 0;
			for(WebElement i: actualValues) {
				softAssert.assertEquals(i.getText(), orderedValues.get(x));
				x++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Missing Expected dropdown values");
			log.debug("Expected number of values: " + orderedValues.size());
			log.debug("Actual number of values: " + actualDropDownSize);
		}
		finally {
			softAssert.assertAll();
		}
		return this;

	}

	//Will verify given values in drop down WebElement
	public SeleniumHelper verifyGivenValueDropDown(WebElement element, String[] value1) {
		@SuppressWarnings("unchecked")
		List<String> values = Arrays.asList(value1);
		softAssert = new SoftAssert();
		String values1 = null;
		String actual = null;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			int x = 0;
			boolean result = false;
			for(int a=0; a<values.size(); a++) {
				values1 = values.get(x);
				for(WebElement i: actualValues) {
					actual = i.getText();
					if(actual.contains(values1)) {
						softAssert.assertEquals(i.getText(), values1);
						result = true;
						break;
					}
				}

				if (result == false) {
					log.error("DropDown does not contain Expected value");
					log.error("Expected: " + values1);
					softAssert.assertFalse(true);
				}
				x++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Will verify given values in drop down do not exist
	public SeleniumHelper verifyGivenValueDoNotExistDropDown(WebElement element, String[] value1) {
		@SuppressWarnings("unchecked")
		List<String> values = Arrays.asList(value1);
		softAssert = new SoftAssert();
		String values1 = null;
		String actual = null;
		try {
			List<WebElement> actualValues = select(element).getOptions();
			int x = 0;
			for(int a=0; a<values.size(); a++) {
				values1 = values.get(x);
				for(WebElement i: actualValues) {
					actual = i.getText();
					if(actual.contains(values1)) {
						log.error("DropDown does contain Expected value");
						log.error("Expected: " + values1);
						softAssert.assertFalse(true);
						break;
					}
				}

				x++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Will verify list of data contains given value (Value is case sensitive)
	public SeleniumHelper verifyAllText(List<WebElement> element, String value) {
		softAssert = new SoftAssert();
		sleep(2);
		try {
			List<WebElement> actualValues = element;
			for(WebElement i: actualValues) {
				String actual = getWebElement(i).getText();
				if(actual.contains(value)) {
					softAssert.assertTrue(actual.contains(value));
				}
				else {
					log.info("Actual text does not contain Expected text" );
					log.info("Found: " + actual);
					log.info("Expected: " + value);
					softAssert.assertTrue(actual.contains(value));
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Data result does not contain: " + value);
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Will verify list of data contains given value (Value is case sensitive)
	public SeleniumHelper verifyAllText(List<WebElement> element, String value, String value2) {
		softAssert = new SoftAssert();
		sleep(1);
		try {
			List<WebElement> actualValues = element;
			for(WebElement i: actualValues) {	
				String actual = getWebElement(i).getText();
				if(actual.contains(value) || actual.contains(value2)) {
					softAssert.assertTrue(actual.contains(value) || actual.contains(value2));
				}
				else {
					log.info("Actual text does not contain Expected text" );
					log.info("Found: " + actual);
					log.info("Expected: " + value);
					softAssert.assertTrue(actual.contains(value) || actual.contains(value2));
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Data result does not contain: " + value2);
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Will verify list of data contains given value (Value is case sensitive)
	public SeleniumHelper verifyAllText(List<WebElement> element, String value, String value2, String value3) {
		softAssert = new SoftAssert();
		sleep(1);
		try {
			List<WebElement> actualValues = element;
			for(WebElement i: actualValues) {	
				String actual = getWebElement(i).getText();
				if(actual.contains(value) || actual.contains(value2) || actual.contains(value3)) {
					softAssert.assertTrue(actual.contains(value) || actual.contains(value2) || actual.contains(value3));
				}
				else {
					log.info("Actual text does not contain Expected text" );
					log.info("Found: " + actual);
					log.info("Expected: " + value);
					softAssert.assertTrue(actual.contains(value) || actual.contains(value2) || actual.contains(value3));
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Data result does not contain: " + value2);
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Will verify headers in excel with given header String
	public SeleniumHelper verifyExcelHeader(String actual, String filePath, String sheetName, int column) {
		softAssert = new SoftAssert();
		sleep(5);
		String actualValues = actual;
		String excelData = EmptyString;
		try {
			column = 3;

			for(int i = 0; i<column; i++) {
				excelData = excelData + readExcelData(filePath, sheetName, i, 0) + " ";
			}

			softAssert.assertTrue(actualValues.contains(excelData));
			if(!actualValues.contains(excelData)) {
				System.out.println("Expected: " + actualValues);
				System.out.println("Actual: " + excelData);
			}

		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Data result does not contain: " + readExcelData(filePath, sheetName, 0, 0));
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}	

	//Will verify list of data in excel with given list of String
	public SeleniumHelper verifyExcelText(List<String> actual, String filePath, String sheetName) {
		softAssert = new SoftAssert();
		int row = 1;
		sleep(5);
		List<String> actualValues = actual;
		try {
			for(String i: actualValues) {
				String excelData = readExcelData(filePath, sheetName, 0, row) + " Select " + readExcelData(filePath, sheetName, 1, row) + " " + readExcelData(filePath, sheetName, 2, row);
				softAssert.assertTrue(i.contains(excelData));
				if(!i.contains(excelData)) {
					System.out.println(i);
					System.out.println(excelData);
				}
				row++;
			}
		} catch(ArrayIndexOutOfBoundsException e){
			log.error("Data result does not contain: " + readExcelData(filePath, sheetName, 0, row));
		}
		finally {
			softAssert.assertAll();
		}
		return this;
	}

	//Get Texts from multiple WebElements and returns list of String
	public List<String> getTextFromWebElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for(WebElement i: elements) {
			data.add(getWebElement(i).getText());
		}
		return data;
	}

	//Get Texts from multiple WebElements and returns list of String
	public List<String> getTextFromInputWebElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for(WebElement i: elements) {
			data.add(getWebElement(i).getAttribute("last-val").replace("\"", ""));
		}
		return data;
	}

	//Will check if Actual contains Expected and return true or false
	public boolean containsText(String Actual, String Expected) {
		boolean result = Actual.contains(Expected);
		if(!Actual.contains(Expected)) {
			log.info("Actual text does not contain Expected text" );
			log.info("Found: " + Actual);
			log.info("Expected: " + Expected);
			softAssert.assertTrue(false, "Actual text did not match Expected text!");
		}
		return result;
	}

	//Will check if Actual contains Expected and return true or false
	public boolean containsText(String actual, String expected, String expected2) {

		if(actual.contains(expected) || actual.contains(expected2)) {
			return true;
		}
		else if(!actual.contains(expected) || !actual.contains(expected2)) {
			log.info("Actual text does not contain Expected text" );
			log.info("Found: " + actual);
			log.info("Expected: " + expected + " Or " + expected2);
			softAssert.assertTrue(false, "Actual text did not match Expected text!");
			return false;
		}else {
			return false;
		}

	}

	//Hard Assert: Will fail test case with "Unable to Complete all steps message"
	public SeleniumHelper assertFail() {
		assertTrue(false, "Test Failed. Error occured while trying to complete all steps: ");
		return new SeleniumHelper();
	}

	//Hard Assert: Will fail test case with "Unable to Complete all steps message"
	public SeleniumHelper assertFail(Exception e) {
		e.printStackTrace();
		assertTrue(false, "Test Failed. Error occured while trying to complete all steps: ");
		return new SeleniumHelper();
	}



	//Hard Assert: Will fail test case with given message
	public SeleniumHelper assertFail(String message) {
		assertTrue(false, message);
		return new SeleniumHelper();
	}

	public boolean areRequiredFieldsFilled() {

		Object returnedValue = runJavascriptWithReturn("return checkRequiredPages()");
		if (returnedValue	.toString()
				.equalsIgnoreCase("TRUE")) {
			return true;
		} else {
			return false;
		}

	}

	//Will end current User session with default idle time of 11 SleepSec
	public SeleniumHelper endCurrentUserSession() {
		try {
			JavascriptExecutor JS = (JavascriptExecutor) driver;
			JS.executeScript("idleTime = 11; timerIncrement()");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	//Will end current User session with given idle time
	public SeleniumHelper endCurrentUserSession(int idleTime) {
		try {
			JavascriptExecutor JS = (JavascriptExecutor) driver;
			JS.executeScript("idleTime = " + idleTime + "; timerIncrement()");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	//Will sort list of data
	public List<String> sortData(List<String> data) {
		Collections.sort(data);
		return data;
	}

	//Will sort list of data desc
	public List<String> sortDataDesc(List<String> data) {
		Collections.sort(data, Collections.reverseOrder());
		return data;
	}

	//Will sort list of data
	public List<Date> sortDate(List<Date> data) {
		Collections.sort(data);
		return data;
	}

	//Will sort list of date Desc
	public List<Date> sortDateDesc(List<Date> date) {
		Collections.sort(date, Collections.reverseOrder());
		return date;
	}

	//Will get text for list of string elements and return sorted list
	public List<String> sortStringElements(List<WebElement> elements) {
		List<String> data = getTextFromWebElements(elements);
		sortData(data);
		return data;
	}

	//Will get text for list of string elements and return sorted list in descending order
	public List<String> sortStringElementsDesc(List<WebElement> elements) {
		List<String> data = getTextFromWebElements(elements);
		sortDataDesc(data);
		return data;
	}


	//Will get text for list of string elements and return sorted list
	public List<String> sortIntElements(List<WebElement> elements) {
		List<String> data = getTextFromWebElements(elements);
		sortData(data);
		return data;
	}

	//Will get text for list of Today elements and return sorted list from most recent
	public List<String> sortDateElementsDesc(List<WebElement> elements) {
		ArrayList<Date> data = new ArrayList<Date>();
		ArrayList<String> date = new ArrayList<String>();

		for(WebElement element: elements) {
			String date3 = getWebElement(element).getText();
			Date date1 = null;
			try {
				if (date3.equalsIgnoreCase(Data.EmptyString)) {

				}
				else {
					date1 = new SimpleDateFormat("MM/dd/yyyy").parse(date3);
					data.add(date1);
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		sortDateDesc(data);

		int i = 0;
		for(WebElement element: elements) {
			String data1 = getWebElement(element).getText();
			if(data1.equalsIgnoreCase(Data.EmptyString)) {
				date.add(data1);
			}else {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String date1 = dateFormat.format(data.get(i));
				date.add(date1);
				i++;
			}
		}

		return date;
	}

	//Will get text for list of Today elements and return sorted list from most recent
	public List<String> sortDateElements(List<WebElement> elements) {
		ArrayList<Date> data = new ArrayList<Date>();
		ArrayList<String> date = new ArrayList<String>();

		for(WebElement element: elements) {
			String date3 = getWebElement(element).getText();
			Date date1 = null;
			try {
				if (date3.equalsIgnoreCase(Data.EmptyString)) {

				}
				else {
					date1 = new SimpleDateFormat("MM/dd/yyyy").parse(date3);
					data.add(date1);
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		sortDateDesc(data);

		int i = 0;
		for(WebElement element: elements) {
			String data1 = getWebElement(element).getText();
			if(data1.equalsIgnoreCase(Data.EmptyString)) {
				date.add(data1);
			}else {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String date1 = dateFormat.format(data.get(i));
				date.add(date1);
				i++;
			}
		}

		return date;
	}

	//Will return action function
	public Actions Actions() {
		Actions action = new Actions(driver);
		return action;
	}

	//checks if web element has hidden attribute
	public boolean isWebElementHidden(WebElement e) {
		String visible = e.getAttribute("style");
		return visible.contains("visibility: hidden;");
	}

	//Confirms Alpha sort of web elements text values
	public Boolean isSortedAlpha(List<WebElement> elements) {
		String [] options;
		elements.remove(0);
		options = new String[elements.size()];
		for(int i=0; i<= elements.size()-1; i++ ) {
			options[i] = elements.get(i).getText();
		}
		@SuppressWarnings("unchecked")
		List<String> copyOf = new ArrayList<String>(Arrays.asList(options));
		Collections.sort(copyOf);
		return Arrays.asList(options).equals(copyOf);
	}

	//No highlight checks if select option value is disabled
	public SeleniumHelper optionDisabled(WebElement element, String option) {
		SoftAssert softAssert = new SoftAssert();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement selOption : options) {
			if (selOption.getText().equals(option))
			{
				if (selOption.getText().equals(option) && selOption.isEnabled())
					softAssert.assertTrue(false);
			}
		}
		softAssert.assertAll();
		return this;
	}

	//No highlight checks if select option value is enabled
	public SeleniumHelper optionEnabled(WebElement element, String option) {
		SoftAssert softAssert = new SoftAssert();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement selOption : options) {
			if (selOption.getText().equals(option))
			{
				if (selOption.getText().equals(option) && !selOption.isEnabled())
					softAssert.assertTrue(false);
			}
		}
		softAssert.assertAll();
		return this;
	}

	//Highlight checks if select option value is disabled
	public SeleniumHelper optionDisabled(WebElement element, String option, String id) {
		SoftAssert softAssert = new SoftAssert();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement selOption : options) {
			if (selOption.getText().equals(option))
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("$(\"[value='" + id + "']\").attr('style', 'color:rgb(255, 255, 255); background: rgb(200, 0, 0)');");
				if (selOption.getText().equals(option) && selOption.isEnabled())
					softAssert.assertTrue(false);
				sleep(1);
				js.executeScript("$(\"[value='" + id + "']\").attr('style', 'color:rgb(0, 0, 0);');");
			}
		}
		softAssert.assertAll();
		return this;
	}

	//Highlight checks if select option value is disabled
	public SeleniumHelper optionEnabled(WebElement element, String option, String id) {
		SoftAssert softAssert = new SoftAssert();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement selOption : options) {
			if (selOption.getText().equals(option))
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("$(\"[value='" + id + "']\").attr('style', 'color:rgb(255, 255, 255); background: rgb(200, 0, 0);');");
				if (selOption.getText().equals(option) && !selOption.isEnabled())
					softAssert.assertTrue(false);
				sleep(1);
				js.executeScript("$(\"[value='" + id + "']\").attr('style', 'color:rgb(0, 0, 0);');");
			}
		}
		softAssert.assertAll();
		return this;
	}

	public String getFirstSelectedValue(WebElement triggeredByPageDropDown) {
		Select sel = new Select(triggeredByPageDropDown);

		List<WebElement> list = sel.getOptions();

		for(int i=0;i<list.size();i++){
			if(list.get(i).getText().equals(sel.getFirstSelectedOption().getText())){
				return sel.getFirstSelectedOption().getText();
			}
		}
		return Data.EmptyString;
	}

	public String valueWithWhitespace(String value)
	{
		return " " + value + " ";
	}

	public boolean isInComboboxBySimilarText(WebElement combobox, List<WebElement> comboboxList, String comparisonText, String searchTerm){
		try 
		{
			setText(combobox, searchTerm, Data.EmptyString);
			sleep(5);
			if(comboboxList != null && comboboxList.size()>0)
			{
				for(WebElement option : comboboxList)
					if(option.getAttribute("innerText").indexOf(comparisonText.toUpperCase()) > -1)
						return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}

	public SeleniumHelper moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();
		return this;
	}

	public boolean isDev() {
		return (Enviornment.baseEnviornment.equals(Enviornment.devEnviornment)
				|| Enviornment.baseEnviornment.equals(Enviornment.localEnviornment));
	}

	public SeleniumHelper printResultIfFailed(String Actual, String Expected) {
		if(!Actual.equals(Expected)) {
			log.info("Actual: " + Actual + "   Expected: " + Expected);
		}
		return new SeleniumHelper();
	}

	public SeleniumHelper printResultIfFailed(boolean ActualB, boolean ExpectedB) {
		if(!ActualB==ExpectedB) {
			log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
		}
		return new SeleniumHelper();
	}

	public SeleniumHelper continueIfErrors() throws Exception {
		if(!checkWebElementExists(By.xpath("//*[@class='list-group-item list-group-item-danger']"),3)) {
			log.info("Error messages are not present when should be.");
			throw new Exception("Error messages are not present when should be.");
		}
		return this;
	}

	public SeleniumHelper continueIfErrors(WebElement errorBanner) throws Exception {
		if(!checkWebElementExists(errorBanner,1)) {
			log.info("Error messages are not present when should be.");
			throw new Exception("Error messages are not present when should be.");
		}
		return this;
	}

	public SeleniumHelper selectMultiSelectOptions(String[] options, WebElement element) {
		clickElement(element);
		for(String option : options)
		{
			By value = By.xpath("//label[contains(text(), '" + option + "')]//input");
			getWebElement(value).click();
		}
		return this;
	} 

	public SeleniumHelper selectMultiSelectOptions(Integer[] indexes, WebElement element) {
		clickElement(element);
		for(Integer index : indexes)
		{
			By value = By.xpath("//ul[@class='multiselect-container dropdown-menu']//li[" + String.valueOf(index) + "]//input");
			getWebElement(value).click();
		}
		return this;
	}

	public SeleniumHelper uploadFile(WebElement documentChooseFileBtn, String documentPath, String documentFile, String... clear) {
		setText(documentChooseFileBtn, System.getProperty("user.dir") + documentPath + documentFile, clear);
		//		getWebElement(documentChooseFileBtn).sendKeys(System.getProperty("user.dir") + documentPath + documentFile);
		return this;
	} 

	//Scrolls to a specific web element
	public SeleniumHelper scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		return this;
	} 

	//Scrolls to the bottom of the page
	public SeleniumHelper scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		return this;
	} 
	//Scrolls to a specific point of the page ex.(0, 500)
	public SeleniumHelper scrollToSpecificPoint(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "window.scrollBy(" + x + "," + y + ")";
		js.executeScript(script, "" );
		return this;
	} 

	//Keyboard Functions 

	//CTRL + A
	public SeleniumHelper selectAll() {
		Actions().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		return this;
	} 

	//Tabs once
	public SeleniumHelper pressTab() {
		Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	} 

	//Tabs based on given count
	public SeleniumHelper pressTab(int TabCount) {
		for(int i=0; i<TabCount; i++) {
			Actions().sendKeys(Keys.TAB).build().perform();
		}
		return this;
	} 

	//Will be able to perform keyboard functions up to 5
	public SeleniumHelper PressKeys(Keys Key) {
		Actions().sendKeys(Key).build().perform();
		return this;
	} 

	public SeleniumHelper PressKeys(Keys Key1, Keys Key2) {
		Actions().sendKeys(Key1, Key2).build().perform();
		return this;
	} 

	public SeleniumHelper PressKeys(Keys Key1, Keys Key2, Keys Key3) {
		Actions().sendKeys(Key1, Key2, Key3).build().perform();
		return this;
	} 

	public SeleniumHelper PressKeys(Keys Key1, Keys Key2, Keys Key3, Keys Key4) {
		Actions().sendKeys(Key1, Key2, Key3, Key4).build().perform();
		return this;
	} 

	public SeleniumHelper PressKeys(Keys Key1, Keys Key2, Keys Key3, Keys Key4, Keys Key5) {
		Actions().sendKeys(Key1, Key2, Key3, Key4, Key5).build().perform();
		return this;
	} 

	public SeleniumHelper ToggleCapsLock(boolean toggle) {
		Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, toggle);
		return this;
	}

}
