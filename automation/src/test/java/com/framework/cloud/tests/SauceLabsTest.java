/**
 * 
 */
package com.framework.cloud.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author deepak
 *
 */
public class SauceLabsTest {

	private static final String USERNAME = "deepaksdeshpande";
	private static final String ACCESS_KEY = "15ac6a59-7986-43af-ba59-baeaf4da7111";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public void setWebDriverRemoteConfig(DesiredCapabilities caps) {
		caps.setCapability("platform", "macOS 10.14");
		caps.setCapability("version", "12.0");
		caps.setCapability("screenResolution", "1920x1440");
	}
	
	public WebDriver initializeDriver(DesiredCapabilities caps) throws MalformedURLException {
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		return driver;
	}
	
	public void navigateToHomePage(DesiredCapabilities caps) {
		try {
			WebDriver driver = initializeDriver(caps);
			driver.get("http:www.google.com");
			System.out.println(driver.getTitle());
			driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SauceLabsTest sauceLabsTest = new SauceLabsTest();
		DesiredCapabilities caps = DesiredCapabilities.safari();
		sauceLabsTest.setWebDriverRemoteConfig(caps);
		sauceLabsTest.navigateToHomePage(caps);
	}

}
