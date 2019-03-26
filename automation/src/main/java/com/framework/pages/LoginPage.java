/**
 * 
 */
package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author deepak
 *
 */
public class LoginPage {

	private WebDriver driver;
	By username = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By loginBtn = By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement loginBtn() {
		return driver.findElement(loginBtn);
	}
}
