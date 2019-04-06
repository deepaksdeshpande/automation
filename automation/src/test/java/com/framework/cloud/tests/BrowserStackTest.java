/**
 * 
 */
package com.framework.cloud.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author deepak
 *
 */
public class BrowserStackTest {

	private static final String USERNAME = "deepakdeshpande2";
	private static final String AUTOMATE_KEY = "je9pYZGxDwuaKtsHbbgR";
	private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public DesiredCapabilities setWebDriverRemoteConfig() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8 Plus");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11");
		return caps;
	}
	
	public WebDriver initializeDriver(DesiredCapabilities caps) throws MalformedURLException {
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		return driver;
	}

	public void navigateToHomePage(DesiredCapabilities caps) {
		try {
			WebDriver driver = initializeDriver(caps);
			driver.get("http://www.google.com");
			WebElement element = driver.findElement(By.name("q"));

			element.sendKeys("BrowserStack");
			element.submit();

			System.out.println(driver.getTitle());
			driver.quit();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserStackTest browserStackTest = new BrowserStackTest();
		DesiredCapabilities caps = browserStackTest.setWebDriverRemoteConfig();
		browserStackTest.navigateToHomePage(caps);
		
	}
}
