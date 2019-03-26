/**
 * 
 */
package com.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.utils.BaseTest;

/**
 * @author deepak
 *
 */
public class BasePageNavTest extends BaseTest {

	private static final Logger LOG = LogManager.getLogger(BasePageNavTest.class);

	@BeforeTest
	public void init() {
		setUp();
	}
	
	@Test
	public void appBaseHomePageNavTest() {
		LOG.info("::::: Invoking base test ::::::");
		String title = new String(
				"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		AssertJUnit.assertEquals(driver.getTitle(), title);
	}
	
	@AfterTest
	public void destroy() {
		tearDown();
	}
}
