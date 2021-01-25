package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class PayController {
	
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPayButton;

    @FXML
    private Button deletePayButton;

    @FXML
    private Button aboutPayButton;

    @FXML
    private Button updatePayButton;

    @FXML
    private Pane addPayPane;

    @FXML
    private TextField addPayNameField;

    @FXML
    private TextField addPayPaymentField;

    @FXML
    private TextField addPayHoldPayField;

    @FXML
    private TextField addPayChargePayField;

    @FXML
    private Button addPayOKButton;

    @FXML
    private TextField addPayPayOffField;

    @FXML
    private Label addPayPaymentLabel;

    @FXML
    private Label addPayNameLabel;

    @FXML
    private Label addPayChargePayLabel;

    @FXML
    private Label addPayHoldPayLabel;

    @FXML
    private Label addPayPayOffLabel;

    @FXML
    private Label addPayLabel;

    @FXML
    private Pane deletePayPane;

    @FXML
    private TextField deletePayNameField;

    @FXML
    private TextField deletePayPaymentField;

    @FXML
    private Button deletePayOKButton;

    @FXML
    private Label deletePayPaymentLabel;

    @FXML
    private Label deletePayNameLabel;

    @FXML
    private Label deletePayLabel;

    @FXML
    private Pane aboutPayPane;

    @FXML
    private TextField aboutPayNameField;

    @FXML
    private Button aboutPayOKButton;

    @FXML
    private Label aboutPayNameLabel;

    @FXML
    private Label aboutPayLabel;

    @FXML
    private Pane updatePayPane;

    @FXML
    private TextField updatePayNameField;

    @FXML
    private TextField updatePayPaymentField;

    @FXML
    private TextField updatePayHoldPayField;

    @FXML
    private TextField updatePayChargePayField;

    @FXML
    private Button updatePayOKButton;

    @FXML
    private TextField updatePayPayOffField;

    @FXML
    private Label updatePayPaymentLabel;

    @FXML
    private Label updatePayNameLabel;

    @FXML
    private Label updatePayChargePayLabel;

    @FXML
    private Label updatePayHoldPayLabel;

    @FXML
    private Label updatePayPayOffLabel;

    @FXML
    private Label updatePayLabel;

    @FXML
    void initialize() {
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    	
	    	addPayButton.setOnAction(event ->{
	    	addPayPane.setVisible(true);
	    	deletePayPane.setVisible(false);
	    	aboutPayPane.setVisible(false);
	    	updatePayPane.setVisible(false);
	    	});
	    	
	    	deletePayButton.setOnAction(event ->{
	    	addPayPane.setVisible(false);
	    	deletePayPane.setVisible(true);
	    	aboutPayPane.setVisible(false);
	    	updatePayPane.setVisible(false);
	    	});
	    	
	    	aboutPayButton.setOnAction(event ->{
	    	addPayPane.setVisible(false);
	    	deletePayPane.setVisible(false);
	    	aboutPayPane.setVisible(true);
	    	updatePayPane.setVisible(false);
	    	});
	    	
	    	updatePayButton.setOnAction(event ->{
	    	addPayPane.setVisible(false);
	    	deletePayPane.setVisible(false);
	    	aboutPayPane.setVisible(false);
	    	updatePayPane.setVisible(true);
	    	});
	    	
	    	addPayOKButton.setOnAction(event-> {
	    		try {
					PreparedStatement ps = con.prepareStatement("insert into pay (worker1, payment, charge_pay, hold_pay, pay_off) values ( ?, ?, ?, ?, ?)");
					ps.setString(1, addPayNameField.getText());
					ps.setString(2, addPayPaymentField.getText());
					ps.setString(3, addPayChargePayField.getText());
					ps.setString(4, addPayHoldPayField.getText());
					ps.setString(5, addPayPayOffField.getText());

					int i = ps.executeUpdate();
	                    if (i != 0) {
	                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
	                    	errorAlert.setHeaderText("Sucessfully!");
	                    	errorAlert.setContentText("Заработная плата добавлена");
	                    	errorAlert.showAndWait();
	                    } else {
	                    	Alert errorAlert = new Alert(AlertType.ERROR);
	                    	errorAlert.setHeaderText("Error!");
	                    	errorAlert.setContentText("Заработная плата не добавлена");
	                    	errorAlert.showAndWait();
	                    }
	                
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		addPayNameField.setText("");
				addPayPaymentField.setText("");
				addPayChargePayField.setText("");
				addPayHoldPayField.setText("");
				addPayPayOffField.setText("");	    		
	    	});

	    	deletePayOKButton.setOnAction(event-> {
	    		try {
					PreparedStatement ps = con.prepareStatement("delete from pay where worker1=? and payment=?");
					ps.setString(1, deletePayNameField.getText());
					ps.setString(2, deletePayPaymentField.getText());
	                int i = ps.executeUpdate();
	                    if (i != 0) {
	                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
	                    	errorAlert.setHeaderText("Sucessfully!");
	                    	errorAlert.setContentText("Заработная плата удалена");
	                    	errorAlert.showAndWait();
	                    } else {
	                    	Alert errorAlert = new Alert(AlertType.ERROR);
	                    	errorAlert.setHeaderText("Error!");
	                    	errorAlert.setContentText("Заработная плата не удалена");
	                    	errorAlert.showAndWait();
	                    }
	                
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		deletePayNameField.setText("");
	    		deletePayPaymentField.setText("");

	    	});
	    	
	    	aboutPayOKButton.setOnAction(event-> {
	    		try {
	    			PreparedStatement ps = null;
	    			ps = con.prepareStatement("SELECT * FROM pay where worker1=?");
	    			ps.setString(1, aboutPayNameField.getText());
	    			ResultSet res = ps.executeQuery();
	    			String get = "";
	    			if (res.next()) {
	    				get = "ФИО: " + res.getString("worker1") + 
	    						"\nЗаработная плата: " + res.getString("payment") +
	    						"\nНачислено: " + res.getString("charge_pay") +
	    						"\nУдержано: " + res.getString("hold_pay") + 
	    						"\nВсего выплачено: " + res.getString("pay_off");
	    		        }
	    			Alert infAlert = new Alert(AlertType.INFORMATION);
	            	infAlert.setHeaderText("Полученная информация");
	            	infAlert.setContentText(get);
	            	infAlert.showAndWait();
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    		aboutPayNameField.setText("");
	    	});
	    	
	    	updatePayOKButton.setOnAction(event-> {
	    		try {
					PreparedStatement ps = con.prepareStatement("update pay set  payment=?, charge_pay=?, hold_pay=?, pay_off=? where worker1=?");
					ps.setString(1, updatePayPaymentField.getText());
					ps.setString(2, updatePayChargePayField.getText());
					ps.setString(3, updatePayHoldPayField.getText());
					ps.setString(4, updatePayPayOffField.getText());
					ps.setString(5, updatePayNameField.getText());

	                int i = ps.executeUpdate();
	                    if (i != 0) {
	                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
	                    	errorAlert.setHeaderText("Sucessfully!");
	                    	errorAlert.setContentText("Данные изменены");
	                    	errorAlert.showAndWait();
	                    } else {
	                    	Alert errorAlert = new Alert(AlertType.ERROR);
	                    	errorAlert.setHeaderText("Error!");
	                    	errorAlert.setContentText("Данные не изменены");
	                    	errorAlert.showAndWait();
	                    }
	                
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		updatePayPaymentField.setText("");
	    		updatePayChargePayField.setText("");
	    		updatePayHoldPayField.setText("");
	    		updatePayPayOffField.setText("");
	    		updatePayNameField.setText("");
	    	});
	    	
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }
}
