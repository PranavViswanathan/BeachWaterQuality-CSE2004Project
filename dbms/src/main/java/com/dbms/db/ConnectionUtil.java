package com.dbms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	//private static String url =  "jdbc:postgresql://localhost/beach?user=postgres&password=ganesh99&ssl=false";
	//private static String url =  "jdbc:postgresql://localhost/postgres?user=postgres&password=ganesh99&ssl=false";
	private static String url =  System.getenv("JDBC_DATABASE_URL");
	private static Connection connection = null;
	public static Connection openConnection() {	
		if (connection != null)
            return connection;
        else {
            try {
            	System.out.println("\nUrl : " + url);
            	Class.forName("org.postgresql.Driver");
            	connection = DriverManager.getConnection(url);
            	return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } 
            return connection;
        }
	}
}
