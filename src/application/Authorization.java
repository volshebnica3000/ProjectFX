package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authorization {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";
    
    public static Boolean SignInn(String loginField, String passwordField) {
    	Boolean isUserExists = false;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		try (PreparedStatement ps = con.prepareStatement("select 1 from `Manage_users` where `Login` = ? and `Password` = ?")) {
                ps.setString(1, loginField);
                ps.setString(2, passwordField);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        isUserExists = true;
                    }
                }
            }
            
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    return isUserExists;
    }
}
