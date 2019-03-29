/**
 * 
 */
package com.framework.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author deepak
 *
 */
public class DataBaseConnection {
	
	private static final Logger LOG = LogManager.getLogger(DataBaseConnection.class);

	public Connection getDatabaseConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/selenium";
		String userName = "deepak";
		String password = "deepak";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			LOG.info("::::::: Created Database connection ::::::");
			return con;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		LOG.error("******* Database connection failed ******");
		return null;
	}

	

}
