/**
 * 
 */
package com.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author deepak
 *
 */
public class AppLandingPage {

	public WebDriver driver;

	private By loginLink = By.xpath("//span[contains(text(),'Login')]");
	private By registerLink = By.xpath("//span[contains(text(),'Register')]");
	private By featuredCourses = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By popupNoThanksBtn = By.xpath("//button[text() = 'NO THANKS']");
	
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public AppLandingPage(WebDriver driver) { 
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement loginLink() {
		return driver.findElement(loginLink);
	}

	public WebElement registerLink() {
		return driver.findElement(registerLink);
	}
	
	public WebElement featuredCoursesTitle() {
		return driver.findElement(featuredCourses);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public List<WebElement> getCountPopupNoThanksBtn() {
		return driver.findElements(popupNoThanksBtn);
	}
	
	public WebElement getNoThanksBtnOnPopup() {
		return driver.findElement(popupNoThanksBtn);
	}
}
