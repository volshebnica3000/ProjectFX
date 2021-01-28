package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tariff {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";
    
    public static int addTariff (String addTariffLvlField, String addTariffCoefField) {
    	int i = 0;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (url,user,password);
			PreparedStatement ps = con.prepareStatement("insert into tariff (level,coef) values ( ?, ?)");
			ps.setInt(1, Integer.parseInt(addTariffLvlField));
			ps.setString(2, addTariffCoefField);				
			i = ps.executeUpdate();
    	} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
    }
    
    public static int deleteTariff (String deleteTariffLvlField, String deleteTariffCoefField) {
    	int i = 0;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (url,user,password);
			PreparedStatement ps = con.prepareStatement("delete from tariff where level = ? and coef = ?");
			ps.setInt(1, Integer.parseInt(deleteTariffLvlField));
			ps.setString(2, deleteTariffCoefField);
            i = ps.executeUpdate();
    	} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
    }
    
    public static String aboutTariff (String aboutTariffLvlField) {
    	String get ="";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (url,user,password);
			PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM tariff where level=?");
			ps.setInt(1, Integer.parseInt(aboutTariffLvlField));
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				get = "Разряд: " + res.getInt("level") + 
						"\nКоэффициент: " + res.getString("coef");
		    }
    	} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return get;
    }
    
    public static int updateTariff (String updateTariffCoefField, String updateTariffLvlField) {
    	int i = 0;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (url,user,password);
			PreparedStatement ps = con.prepareStatement("update tariff set coef=? where level=?");
			ps.setString(1, updateTariffCoefField);
			ps.setInt(2, Integer.parseInt(updateTariffLvlField));
            i = ps.executeUpdate();
    	} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
    }
}
