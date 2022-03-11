package com.eisrem.AppUtils.Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.eisrem.AppUtils.SeleniumHelper;

public class SeleniumExceptions {

	//Will give element not visible exception with proper message of the error location 
	public static NoSuchElementException NoSuchElementException(WebElement element) {
		int position = element.toString().indexOf("//");
		String xpath = element.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to locate following xpath: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
		SeleniumHelper.log.info(s[0]);
		SeleniumHelper.log.info(s[1]);
		SeleniumHelper.log.info(s[2]);
		SeleniumHelper.log.info(s[3]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new NoSuchElementException("Element not visible");
	}
	
	//Will give element not visible exception with proper message of the error location 
		public static NoSuchElementException NoSuchElementException(By by) {
			int position = by.toString().indexOf("//");
			String xpath = by.toString().substring(position);
			ElementNotVisibleException e = new ElementNotVisibleException("Unable to locate following xpath: " + xpath);
			StackTraceElement[] s = e.getStackTrace();
			int num = e.getMessage().indexOf("Build info:");
			System.out.println();
			SeleniumHelper.log.info(s[0]);
			SeleniumHelper.log.info(s[1]);
			SeleniumHelper.log.info(s[2]);
			SeleniumHelper.log.info(s[3]);
			SeleniumHelper.log.info(e.getMessage().substring(0, num));
			return new NoSuchElementException("Element not visible");
		}
	
	public static ElementNotInteractableException ElementNotInteractableException (WebElement element) {
		int position = element.toString().indexOf("//");
		String xpath = element.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to interact with following xpath: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
		SeleniumHelper.log.info(s[1]);
		SeleniumHelper.log.info(s[2]);
		SeleniumHelper.log.info(s[3]);
		SeleniumHelper.log.info(s[4]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new ElementNotInteractableException("Element not interactable");
	}
	
	public static ElementNotInteractableException ElementNotInteractableException (By by) {
		int position = by.toString().indexOf("//");
		String xpath = by.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to interact with following xpath: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
		SeleniumHelper.log.info(s[1]);
		SeleniumHelper.log.info(s[2]);
//		SeleniumHelper.log.info(s[3]);
//		SeleniumHelper.log.info(s[4]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new ElementNotInteractableException("Element not interactable");
	}
	
	public static ElementNotSelectableException ElementNotSelectableException (WebElement element) {
		int position = element.toString().indexOf("//");
		String xpath = element.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to select following xpath: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
		SeleniumHelper.log.info(s[1]);
		SeleniumHelper.log.info(s[2]);
		SeleniumHelper.log.info(s[3]);
		SeleniumHelper.log.info(s[4]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new ElementNotSelectableException("Element is not selectable");
	}
	
	public static ElementNotSelectableException ElementNotSelectableException (By by) {
		int position = by.toString().indexOf("//");
		String xpath = by.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to select following xpath: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
		SeleniumHelper.log.info(s[1]);
		SeleniumHelper.log.info(s[2]);
//		SeleniumHelper.log.info(s[3]);
//		SeleniumHelper.log.info(s[4]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new ElementNotSelectableException("Element is not selectable");
	}
	
	public static TimeoutException TimeoutException (WebElement element) {
		int position = element.toString().indexOf("//");
		String xpath = element.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to locate following xpath with in given time: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
//		SeleniumHelper.log.info(s[2]);
		SeleniumHelper.log.info(s[3]);
		SeleniumHelper.log.info(s[4]);
		SeleniumHelper.log.info(s[5]);
		SeleniumHelper.log.info(s[6]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new TimeoutException("Element is not selectable");
	}
	
	public static TimeoutException TimeoutException (By by) {
		int position = by.toString().indexOf("//");
		String xpath = by.toString().substring(position);
		ElementNotVisibleException e = new ElementNotVisibleException("Unable to locate following xpath with in given time: " + xpath);
		StackTraceElement[] s = e.getStackTrace();
		int num = e.getMessage().indexOf("Build info:");
		System.out.println();
		SeleniumHelper.log.info(s[2]);
		SeleniumHelper.log.info(s[3]);
//		SeleniumHelper.log.info(s[4]);
//		SeleniumHelper.log.info(s[5]);
		SeleniumHelper.log.info(e.getMessage().substring(0, num));
		return new TimeoutException("Element is not selectable");
	}


}
