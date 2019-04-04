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
public class HomePage {

	private WebDriver driver;
	
	By searchBox = By.name("query");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement searchBox() {
		return driver.findElement(searchBox);
	}
	
}
