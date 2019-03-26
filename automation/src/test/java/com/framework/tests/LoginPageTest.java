/**
 * 
 */
package com.framework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.utils.BaseTest;

/**
 * @author deepak
 *
 */
public class LoginPageTest extends BaseTest {
	
	private static final Logger LOG = LogManager.getLogger(LoginPageTest.class);
	
	@BeforeTest
	public void init() {
		setUp();
	}
	
	@Test(dataProvider = "getData")
	public void openLoginPage(String username, String password) {
		LOG.info(":::: Starting openLoginPage Test case ::::::");
		HomePage homePage = new HomePage(driver);
		driver.get(props.getProperty("url"));
		homePage.loginLink().click();
		AssertJUnit.assertEquals(driver.getTitle(), "QaClickAcademy");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.username().clear();
		loginPage.password().clear();
		loginPage.username().sendKeys(username);
		loginPage.password().sendKeys(password);
		loginPage.loginBtn().click();
		LOG.info("::::: Executing Login script :::::");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "abc@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "defc@yaho.com";
		data[1][1] = "4312";

		return data;
	}

	@AfterTest
	public void destroy() {
		tearDown();
	}
}
