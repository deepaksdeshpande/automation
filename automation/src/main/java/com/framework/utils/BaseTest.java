/**
 * 
 */
package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author deepak
 *
 */
public class BaseTest {

	private static final Logger LOG = LogManager.getLogger(BaseTest.class);

	public static WebDriver driver;
	public static Properties props;

	public WebDriver initializeDriver() {
		props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/resources/test-env.properties");
			props.load(fis);
			String browserName = props.getProperty("browser.name");
			if (browserName.equals("chrome")) {
				System.setProperty(props.getProperty("chrome.driver"), props.getProperty("chrome.driver.path"));
				driver = new ChromeDriver();
				LOG.info(":::: Using chrome browser ::::::");
			} else if (browserName.equals("firefox")) {
				System.setProperty(props.getProperty("firefox.driver"), props.getProperty("firefox.driver.path"));
				LOG.info(":::: Using firefox browser ::::::");
				driver = new FirefoxDriver();
			} else if (browserName.equals("IE")) {
				System.setProperty(props.getProperty("ie.driver"), props.getProperty("ie.driver.path"));
				LOG.info(":::: Using internet explorer browser ::::::");
				driver = new InternetExplorerDriver();
			} else if (browserName.equals("Edge")) {
				System.setProperty(props.getProperty("edge.driver"), props.getProperty("edge.driver.path"));
				driver = new EdgeDriver();
				LOG.info(":::: Using edge browser ::::::");
			} else if (browserName.equals("safari")) {
				System.setProperty(props.getProperty("safari.driver"), props.getProperty("safari.driver.path"));
				driver = new SafariDriver();
				LOG.info(":::: Using safari browser ::::::");
			} else if (browserName.equals("opera")) {
				System.setProperty(props.getProperty("opera.driver"), props.getProperty("opera.driver.path"));
				driver = new OperaDriver();
				LOG.info(":::: Using opera browser ::::::");
			} else {
				LOG.error("::::: BROWSER NOT RECOGNIZED :::::");
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} else {
			return null;
		}
	}
	
	public void setUp() {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
	}
	
	public void tearDown() {
		driver.close();
		driver = null;
	}
	
	public void getFailedTestScreenShots(String testCaseName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss_aa");
			String dateTimeStamp = sdf.format(date);
			FileUtils.copyFile(srcFile, new File("./screenshots/"+testCaseName+"_Screenshot_"+dateTimeStamp+".png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
