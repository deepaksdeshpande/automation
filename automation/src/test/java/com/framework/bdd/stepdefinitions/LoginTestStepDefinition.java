/**
 * 
 */
package com.framework.bdd.stepdefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.pages.AppLandingPage;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.utils.BaseTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/**
 * @author deepak
 *
 */
@RunWith(Cucumber.class)
public class LoginTestStepDefinition extends BaseTest {

	@Given("Initialize driver with chrome browser")
	public void initialize_driver_with_chrome_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("Navigate to {string} site")
	public void navigate_to_site(String url) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);
	}

	@Given("click on login link on home page to land on secure sign in page")
	public void click_on_login_link_on_home_page_to_land_on_secure_sign_in_page() {
		// Write code here that turns the phrase above into concrete actions
		AppLandingPage landingPage = new AppLandingPage(driver);
		WebDriverWait waitDriver = new WebDriverWait(driver, 45);
		waitDriver.until(ExpectedConditions.elementToBeClickable(landingPage.getNoThanksBtnOnPopup()));
		if (landingPage.getCountPopupNoThanksBtn().size() > 0 && landingPage.getNoThanksBtnOnPopup().isDisplayed()) {
			landingPage.getNoThanksBtnOnPopup().click();
			landingPage.loginLink().click();
		} else {
			landingPage.loginLink().click();
		}
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage(driver);
		loginPage.username().clear();
		loginPage.password().clear();
		loginPage.username().sendKeys(username);
		loginPage.password().sendKeys(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginBtn().click();
	}

	@Then("verify user is successfully logged in")
	public void verify_user_is_successfully_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.searchBox().isDisplayed());
	}
}
