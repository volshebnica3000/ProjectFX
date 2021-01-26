package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageWorkers {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";
    
    public static int addWorker (String addWorkerNameField, String addWorkerPosField, String addWorkerLvlField, String uni, String addWorkerLoginField) {
    	int i = 0;
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("insert into manage_workers (w_name, w_position, w_level, if_trade_union, Manage_users_login) values (?, ?, ?, ?, ?)");
    		ps.setString(1, addWorkerNameField);
			ps.setString(2, addWorkerPosField);
			ps.setInt(3, Integer.parseInt(addWorkerLvlField));
			ps.setString(4, uni);
			ps.setString(5, addWorkerLoginField);
            i = ps.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return i;
    }
    
    public static int deleteWorker(String deleteWorkerNameField, String deleteWorkerPosField ) {
    	int i = 0;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("delete from manage_workers where w_name = ? and w_position = ?");
			ps.setString(1, deleteWorkerNameField);
			ps.setString(2, deleteWorkerPosField);
            i = ps.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return i;
    }
    
    public static String aboutWorker(String aboutWorkerNameField ) {
    	String get = "";
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
			PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM manage_workers where w_name=?");
			ps.setString(1, aboutWorkerNameField);
			ResultSet res = ps.executeQuery();
			
			String uni = "не состоит в профсоюзе";
			if (res.next())
		       {
				if (Integer.parseInt(res.getString("if_trade_union"))==2) uni="состоит в профсоюзе";
				get = "ФИО: " + res.getString("w_name") + 
						"\nДолжность: " + res.getString("w_position") +
						"\nРазряд: " + res.getString("w_level") +
						"\nУчастие в профсоюзе: " + uni + 
						"\nЛогин: " + res.getString("Manage_users_login");
		        }
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return get;
    }
    
    public static int updateWorker (String updateWorkerNameField, String updateWorkerPosField, String updateWorkerLvlField, String uni, String updateWorkerLoginField) {
    	int i = 0;
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("UPDATE manage_workers SET w_name=?, w_position=?, w_level=? , if_trade_union =? WHERE Manage_users_login=?");
			ps.setString(1, updateWorkerNameField);
			ps.setString(2, updateWorkerPosField);
			ps.setInt(3, Integer.parseInt(updateWorkerLvlField));
			ps.setString(4, uni);
			ps.setString(5, updateWorkerLoginField);
            i = ps.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return i;
    }
}
