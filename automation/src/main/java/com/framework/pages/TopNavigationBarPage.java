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
public class TopNavigationBarPage {
	
	private By navHomeLink = By.xpath("//a[contains(text(),'Home')]");
	private By navCoursesLink = By.xpath("//a[contains(text(),'Courses')]");
	private By navVideosLink = By.xpath("//a[contains(text(),'Videos')]");
	private By navInterviewGuideLink = By.xpath("//ul[@class='nav navbar-nav navbar-right']//li//a[@href='interview.php'][contains(text(),'Interview Guide')]");
	private By navPracticeLink = By.xpath("//a[contains(text(),'Practice')]");
	private By navBlogLink = By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Blog')]");
	private By navAboutLink = By.xpath("//ul[@class='nav navbar-nav navbar-right']//li//a[@href='about.php'][contains(text(),'About')]");
	private By navContactLink = By.xpath("//a[contains(text(),'Contact')]");
	
	private WebDriver driver;
	
	public TopNavigationBarPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getNavHomeLink() {
		return driver.findElement(navHomeLink);
	}
	
	public WebElement getNavCoursesLink() {
		return driver.findElement(navCoursesLink);
	}
	
	public WebElement getNavVideosLink() {
		return driver.findElement(navVideosLink);
	}
	
	public WebElement getNavInterviewGuideLink() {
		return driver.findElement(navInterviewGuideLink);
	}
	
	public WebElement getNavPracticeLink() {
		return driver.findElement(navPracticeLink);
	}
	
	public WebElement getNavBlogLink() {
		return driver.findElement(navBlogLink);
	}
	
	public WebElement getNavAboutLink() {
		return driver.findElement(navAboutLink);
	}
	
	public WebElement getNavContactLink() {
		return driver.findElement(navContactLink);
	}
	

}
