package com.eisrem.AppUtils;

public class Configuration {
	
	public static class Enviornment {
		public static String devEnviornment = "dev";
		public static String uatEnviornment = "uat";
		public static String localEnviornment = "local";
		public static String baseEnviornment = uatEnviornment;
		public static String screenshotEnv = "local";
	}

	public static class Browser {
		public static String chromeBrowser = "Chrome";
		public static String firefoxBrowser = "Firefox";
		public static String edgeBrowser = "Edge";
		public static String ieBrowser = "IE";
		public static String baseBrowser = chromeBrowser;
	}
	
	public static class OS {
		public static String w10 = "Windows 10";

	}
	
	public static class BrowserVersion {
		public static String chromeVersion = "93";
		public static String firefoxVersion = "";
		public static String edgeVersion = "";
		public static String ieVersion = "";
	}

	public static class Url {
		public static String devPortal = "https://portal.devlb.state.me.us/eisrem/";
		public static String testPortal = "https://portal.testlb.state.me.us/eisrem/";
		public static String testPortalHome = "https://portal.testlb.state.me.us/eisrem/home";
		public static String localPortal = "http://localhost:7001/eisdev/welcome";
		public static String basePortal = testPortal;
	}
	
	public static class Database {
		public static String devDB = "phnxdev";
		public static String uatDB = "phnxtest";
	}

	public static class User {
		public static String devUser = "SELENIUMUSER";
		public static String testUser = "SELENIUMUSER";		
		public static String dbUser = "SELENIUMUSER";
		public static String baseUser = testUser;
		public static String BusinessUser = "GEORGEB_SELENIUM";
		public static String baseUserEmail = "roy.sawyer@MAINE.GOV";
		
	}

	public static class Password {
		public static String devPassword = "Spring23!";
		public static String testPassword = "Summer22!";
		public static String dbPassword = "Statofmaine2020!";
		public static String basePassword = testPassword;
		public static String BusinessPass = "Summer12#";
	}
	
	public static class Config {
		public static int browserRetry =3;
		public static int implicitWait =10;
		public static String highLight ="yes";
		public static String unHighLight ="yes";
		public static String takeScreenShot = "yes";
		public static String cleanScreenShotDirectory = "Yes";
		public static String cleanReportsDirectory = "Yes";
		public static String cleanDownloadDirectory = "Yes";
		public static boolean iFrame = false;
	}
	
	public static class fileLocation {
		public static String screentShot = "build/Screenshots";
		public static String reports = "reports";
		public static String download = "src/test/resources/DownloadedDocuments";
	}

}
