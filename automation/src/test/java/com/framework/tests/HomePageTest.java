/**
 * 
 */
package com.framework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.pages.HomePage;
import com.framework.utils.BaseTest;

/**
 * @author deepak
 *
 */
public class HomePageTest extends BaseTest {

	private static final Logger LOG = LogManager.getLogger(HomePageTest.class);

	@BeforeTest
	public void init() {
		setUp();
	}

	@Test
	public void appBasePageNavTest() {
		LOG.info("::::: Invoking base test ::::::");
		String title = new String(
				"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		AssertJUnit.assertEquals(driver.getTitle(), title);
		HomePage homePage = new HomePage(driver);
		AssertJUnit.assertEquals(homePage.featuredCoursesTitle().getText(), "FEATURED COURSES");
		
	}

	@AfterTest
	public void destroy() {
		tearDown();
	}

}
