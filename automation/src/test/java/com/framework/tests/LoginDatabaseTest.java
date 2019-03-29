/**
 * 
 */
package com.framework.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.utils.BaseTest;

/**
 * @author deepak
 *
 */
public class LoginDatabaseTest extends BaseTest {
	
	private static final Logger LOG = LogManager.getLogger(LoginDatabaseTest.class);

	@BeforeTest
	public void init() {
		setUp();
	}
	
	public Connection getDatabaseConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/selenium";
		String userName = "deepak";
		String password = "deepak";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			LOG.info(":::::: Connected to database successfully ::::::");
			return con;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void validateLogin() {
		ResultSet rs;
		Connection con = getDatabaseConnection();
		String query = "select * from credentials where accounttype='zerobalancecard'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			HomePage homePage = new HomePage(driver);
			homePage.loginLink().click();
			LoginPage loginPage = new LoginPage(driver);
			while(rs.next()) {
				loginPage.username().clear();
				loginPage.password().clear();
				loginPage.username().sendKeys(rs.getString("username"));
				loginPage.password().sendKeys(rs.getString("password"));
				loginPage.loginBtn().click();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void destroy() {
		tearDown();
	}
}
