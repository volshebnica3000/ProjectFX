package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageUsers {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";
    
    public static int addUser(String addUserLoginField, String addUserPasswordField) {   
	int i=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection (url,user,password);
		PreparedStatement ps = con.prepareStatement("insert into manage_users (login,password) values (?,?)");
		ps.setString(1, addUserLoginField);
        ps.setString(2, addUserPasswordField);
        i = ps.executeUpdate();
            
        
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return i;
    }
    
    
    public static int deleteUser(String deleteUserLoginField) {   
    	int i=0;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("delete from manage_users where login=?");
			ps.setString(1, deleteUserLoginField);
             i = ps.executeUpdate();              
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return i;
        }
    
    public static String aboutUser(String aboutUserLoginField) {
    	String get = "";
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection (url,user,password);
		PreparedStatement ps = null;
		ps = con.prepareStatement("SELECT * FROM manage_users where login=?");
		ps.setString(1, aboutUserLoginField);
		ResultSet res = ps.executeQuery();
		
		if (res.next())
	       {
			get = "Логин пользователя: " + res.getString("login") + "\nПароль пользователя: " +res.getString("password");
	        }
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return get;
    }
    
    public static String searchUser(String searchUserLoginField) {
    	String get = "";
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM manage_users where login=?");
			ps.setString(1, searchUserLoginField);
			ResultSet res = ps.executeQuery();
			if (res.next())
		       {
				get = "Логин пользователя: " + res.getString("login") + "\nПароль пользователя: " +res.getString("password");
		        }
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return get;
    }
    public static int updateUser (String updateUserPasswordField, String updateUserLoginField) {
    	int i=0;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("UPDATE manage_users SET password=? WHERE login=?");
			ps.setString(1, updateUserPasswordField);
			ps.setString(2, updateUserLoginField);
             i = ps.executeUpdate(); 
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return i;
        }
    
    
    
  }
