/**
 * 
 */
package com.framework.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.framework.pages.HomePage;
import com.framework.utils.BaseTest;

/**
 * @author deepak
 *
 */
public class TopNavigationBarTest extends BaseTest {

	@BeforeTest
	public void init() {
		setUp();
	}
	
	@Test
	public void validateTopNavBar() {
		HomePage homePage = new HomePage(driver);
		WebElement navBar = homePage.getNavBar();
		//Test if top nav bar is present on the page or not
		AssertJUnit.assertTrue(navBar.isDisplayed());
	}
	
	@AfterTest
	public void destroy() {
		tearDown();
	}

}
