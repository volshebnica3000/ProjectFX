package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pay {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";
    
    public static int addPay(String addPayNameField, String addPayPaymentField, String addPayChargePayField, String addPayHoldPayField, String addPayPayOffField) {
    	int i = 0;
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("insert into pay (worker1, payment, charge_pay, hold_pay, pay_off) values ( ?, ?, ?, ?, ?)");
			ps.setString(1, addPayNameField);
			ps.setString(2, addPayPaymentField);
			ps.setString(3, addPayChargePayField);
			ps.setString(4, addPayHoldPayField);
			ps.setString(5, addPayPayOffField);
			i = ps.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return i;
    }
    
    public static int deletePay(String deletePayNameField, String deletePayPaymentField) {
    	int i = 0;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("delete from pay where worker1=? and payment=?");
			ps.setString(1, deletePayNameField);
			ps.setString(2, deletePayPaymentField);
            i = ps.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return i;
    }
    
    public static String aboutPay(String aboutPayNameField) {
    	String get = "";
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection (url,user,password);
		PreparedStatement ps = null;
		ps = con.prepareStatement("SELECT * FROM pay where worker1=?");
		ps.setString(1, aboutPayNameField);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			get = "ФИО: " + res.getString("worker1") + 
					"\nЗаработная плата: " + res.getString("payment") +
					"\nНачислено: " + res.getString("charge_pay") +
					"\nУдержано: " + res.getString("hold_pay") + 
					"\nВсего выплачено: " + res.getString("pay_off");
	        }
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return get;
    }
    
    public static int updatePay (String updatePayPaymentField, String updatePayChargePayField, String updatePayHoldPayField, String updatePayPayOffField, String updatePayNameField) {{
    	int i = 0;
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		PreparedStatement ps = con.prepareStatement("update pay set  payment=?, charge_pay=?, hold_pay=?, pay_off=? where worker1=?");
			ps.setString(1, updatePayPaymentField);
			ps.setString(2, updatePayChargePayField);
			ps.setString(3, updatePayHoldPayField);
			ps.setString(4, updatePayPayOffField);
			ps.setString(5, updatePayNameField);
            i = ps.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return i;    	
    	}
    }
}
