package com.eisrem.AppUtils;

import java.io.File;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	private static DriverFactory driverFactoryInstance = null;
	private static WebDriver driver = null;
	long seconds = 10;
	int num = 5;

	private DriverFactory(WebDriver driver) {
		DriverFactory.driver = driver;
	}


	public static DriverFactory driverFactoryInstance() {
		if(driverFactoryInstance==null)
			driverFactoryInstance = new DriverFactory(driver);
		return driverFactoryInstance;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver openBrowser(String browser){

		//		int retryCount = Configuration.Config.browserRetry;
		//		int retryAttempt = 0;

		try {

			if(browser.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();
//				System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

				File downloadFolder = new File("download");
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", downloadFolder.getAbsolutePath());
				options.setExperimentalOption("prefs", prefs);
				options.setCapability("acceptSslcerts", "false");
				options.setCapability("useAutomationExtension", false);
				options.addArguments("--disable-notifications");
				//				System.setProperty("webdriver.chrome.silentOutput", "true");
				
				//Original Jenkins
				if(InetAddress.getLocalHost().getHostAddress().equalsIgnoreCase("10.41.52.15")) {	
					options.addArguments("disable-gpu");
					options.addArguments("headless");
//					options.addArguments("no-sandbox");
					options.addArguments("window-size=1920x1080");
				}
				//New Jenkins
				if(InetAddress.getLocalHost().getHostAddress().equalsIgnoreCase("10.41.52.192")) {	
					options.addArguments("disable-gpu");
					options.addArguments("headless");
//					options.addArguments("no-sandbox");
					options.addArguments("window-size=1920x1080");
				}

//				@SuppressWarnings("rawtypes")
				DriverService.Builder serviceBuilder = new ChromeDriverService.Builder().withSilent(true);
				ChromeDriverService chromeDriverService = (ChromeDriverService)serviceBuilder.build(); 
				chromeDriverService.sendOutputTo(new OutputStream(){@Override public void write(int b){}});
				java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

				SeleniumHelper.log.info("***********************************************Opening Up Chrome Browser***********************************************" + num);	
				driver = new ChromeDriver(chromeDriverService, options);
				//				driver = new ChromeDriver(options);
				//				driver = new ChromeDriver();


			}
			else if(browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				SeleniumHelper.log.info("***********************************************Opening Up FireFox Browser***********************************************");
				driver = new FirefoxDriver();

			}
			else if(browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
				File downloadFolder = new File("download");
				EdgeOptions options = new EdgeOptions();

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", downloadFolder.getAbsolutePath());
				options.setExperimentalOption("prefs", prefs);
				options.setCapability("acceptSslcerts", "false");
//				options.setCapability("version", Configuration.BrowserVersion.edgeVersion);
				options.setCapability("useAutomationExtension", false);
				options.setCapability("--disable-notifications", true);
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				System.setProperty("webdriver.edge.silentOutput", "true");
//				@SuppressWarnings("rawtypes")
				DriverService.Builder serviceBuilder = new EdgeDriverService.Builder();
				EdgeDriverService edgeDriverService = (EdgeDriverService)serviceBuilder.build(); 
				edgeDriverService.sendOutputTo(new OutputStream(){@Override public void write(int b){}});
				java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
				SeleniumHelper.log.info("***********************************************Opening Up Edge Browser***********************************************" + num);
				driver = new EdgeDriver(edgeDriverService, options);
//				driver = new EdgeDriver(options);
//				driver = new EdgeDriver();

			}

			else if(browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				SeleniumHelper.log.info("***********************************************Opening Up Internet Explorer Browser***********************************************");
				driver = new InternetExplorerDriver();

			}

			else {
				SeleniumHelper.log.error("Incorrect Browser. Please choose a correct Browser");
			}

			if(driver != null) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public WebDriver getSingletonBrowser(String browser) {
		if(driver==null) {
			if(browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", "download");
				options.setExperimentalOption("prefs", prefs);
				DesiredCapabilities cap =  new DesiredCapabilities();
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				SeleniumHelper.log.info("***********************************************Opening Up Chrome Browser***********************************************");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				SeleniumHelper.log.info("***********************************************Opening Up FireFox Browser***********************************************");
				driver = new FirefoxDriver();

			}
			else if(browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				SeleniumHelper.log.info("***********************************************Opening Up Edge Browser***********************************************");
				driver = new EdgeDriver();
			}
			else {
				SeleniumHelper.log.error("Incorrect Browser. Please choose a correct Browser");
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		return driver;
	}
}
