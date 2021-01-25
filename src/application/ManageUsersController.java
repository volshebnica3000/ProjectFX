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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class ManageUsersController {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Button aboutUserButton;

    @FXML
    private Button searchUserButton;

    @FXML
    private Button updateUserButton;

    @FXML
    private Pane addUserPane;

    @FXML
    private TextField addUserLoginField;

    @FXML
    private TextField addUserPasswordField;

    @FXML
    private Label addUserLable;

    @FXML
    private Label addUserPasswordLabel;

    @FXML
    private Label addUserLoginLabel;

    @FXML
    private Button addUserOKButton;

    @FXML
    private Pane deleteUserPane;

    @FXML
    private TextField deleteUserLoginField;

    @FXML
    private Label deleteUserLable;

    @FXML
    private Label deleteUserPasswordLabel;

    @FXML
    private Label deleteUserLoginLabel;

    @FXML
    private Button deleteUserOKButton;

    @FXML
    private Pane aboutUserPane;

    @FXML
    private TextField aboutUserLoginField;

    @FXML
    private Label aboutUserLable;

    @FXML
    private Label aboutUserLoginLabel;

    @FXML
    private Button aboutUserOKButton;

    @FXML
    private Pane searchUserPane;

    @FXML
    private TextField searchUserLoginField;

    @FXML
    private Label searchUserLable;

    @FXML
    private Label searchUserLoginLabel;

    @FXML
    private Button searchUserOKButton;

    @FXML
    private Pane updateUserPane;

    @FXML
    private TextField updateUserLoginField;

    @FXML
    private Label updateUserLable;

    @FXML
    private Label updateUserLoginLabel;

    @FXML
    private Button updateUserOKButton;

    @FXML
    private TextArea aboutUserTArea11;

    @FXML
    private Label updateUserPasswordLabel;

    @FXML
    private TextField updateUserPasswordField;

    @FXML
    void initialize() {    	
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection (url,user,password);
		
    	addUserButton.setOnAction(event -> {
    		deleteUserPane.setVisible(false);
    		updateUserPane.setVisible(false);
    		aboutUserPane.setVisible(false);
    		searchUserPane.setVisible(false);
    		addUserPane.setVisible(true);
    	});
    		
    	deleteUserButton.setOnAction(event -> {
    		updateUserPane.setVisible(false);
    		aboutUserPane.setVisible(false);
    		searchUserPane.setVisible(false);
    		addUserPane.setVisible(false);
    		deleteUserPane.setVisible(true);
    	});
    	
    	updateUserButton.setOnAction(event -> {
    		updateUserPane.setVisible(true);
    		aboutUserPane.setVisible(false);
    		searchUserPane.setVisible(false);
    		addUserPane.setVisible(false);
    		deleteUserPane.setVisible(false);
    	});
    	
    	aboutUserButton.setOnAction(event -> {
    		updateUserPane.setVisible(false);
    		aboutUserPane.setVisible(true);
    		searchUserPane.setVisible(false);
    		addUserPane.setVisible(false);
    		deleteUserPane.setVisible(false);
    	});
    	
    	searchUserButton.setOnAction(event -> {
    		updateUserPane.setVisible(false);
    		aboutUserPane.setVisible(false);
    		searchUserPane.setVisible(true);
    		addUserPane.setVisible(false);
    		deleteUserPane.setVisible(false);
    	});
    	
    	
    	addUserOKButton.setOnAction(event-> {
    		try {
				PreparedStatement ps = con.prepareStatement("insert into manage_users (login,password) values (?,?)");
				ps.setString(1, addUserLoginField.getText());
                ps.setString(2, addUserPasswordField.getText());
                int i = ps.executeUpdate();
                    if (i != 0) {
                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
                    	errorAlert.setHeaderText("Sucessfully!");
                    	errorAlert.setContentText("Пользователь добавлен");
                    	errorAlert.showAndWait();
                    } else {
                    	Alert errorAlert = new Alert(AlertType.ERROR);
                    	errorAlert.setHeaderText("Error!");
                    	errorAlert.setContentText("Пользователь не добавлен");
                    	errorAlert.showAndWait();
                    }
                
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		addUserLoginField.setText("");
    		addUserPasswordField.setText("");
    	});
	
    	deleteUserOKButton.setOnAction(event-> {
    		try {
				PreparedStatement ps = con.prepareStatement("delete from manage_users where login=?");
				ps.setString(1, deleteUserLoginField.getText());
                int i = ps.executeUpdate();
                    if (i != 0) {
                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
                    	errorAlert.setHeaderText("Sucessfully!");
                    	errorAlert.setContentText("Пользователь удален");
                    	errorAlert.showAndWait();
                    } else {
                    	Alert errorAlert = new Alert(AlertType.ERROR);
                    	errorAlert.setHeaderText("Error!");
                    	errorAlert.setContentText("Пользователь не удален");
                    	errorAlert.showAndWait();
                    }
                
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		deleteUserLoginField.setText("");
    	});
	
    	aboutUserOKButton.setOnAction(event-> {
    		try {
			PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM manage_users where login=?");
			ps.setString(1, aboutUserLoginField.getText());
			ResultSet res = ps.executeQuery();
			String get = "";
			if (res.next())
		       {
				get = "Логин пользователя: " + res.getString("login") + "\nПароль пользователя: " +res.getString("password");
		        }
			Alert infAlert = new Alert(AlertType.INFORMATION);
        	infAlert.setHeaderText("Полученная информация");
        	infAlert.setContentText(get);
        	infAlert.showAndWait();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		aboutUserLoginField.setText("");
	});
    	
    	searchUserOKButton.setOnAction(event-> {
    		try {
			PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM manage_users where login=?");
			ps.setString(1, searchUserLoginField.getText());
			ResultSet res = ps.executeQuery();
			String get = "";
			if (res.next())
		       {
				get = "Логин пользователя: " + res.getString("login") + "\nПароль пользователя: " +res.getString("password");
		        }
			if (get=="") {
				Alert infAlert = new Alert(AlertType.INFORMATION);
	        	infAlert.setHeaderText("Пользователь не найден!");
	        	infAlert.setContentText("Пользователя с введенным логином не существует");
	        	infAlert.showAndWait();
			}else {
			Alert infAlert = new Alert(AlertType.INFORMATION);
        	infAlert.setHeaderText("Пользователь найден!");
        	infAlert.setContentText(get);
        	infAlert.showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		searchUserLoginField.setText("");		
	});
    	
    	updateUserOKButton.setOnAction(event-> {
    		try {
				PreparedStatement ps = con.prepareStatement("UPDATE manage_users SET password=? WHERE login=?");
				ps.setString(1, updateUserPasswordField.getText());
				ps.setString(2, updateUserLoginField.getText());
                int i = ps.executeUpdate();
                    if (i != 0) {
                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
                    	errorAlert.setHeaderText("Sucessfully!");
                    	errorAlert.setContentText("Пароль изменен");
                    	errorAlert.showAndWait();
                    } else {
                    	Alert errorAlert = new Alert(AlertType.ERROR);
                    	errorAlert.setHeaderText("Error!");
                    	errorAlert.setContentText("Пароль не изменен");
                    	errorAlert.showAndWait();
                    }
                
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		updateUserLoginField.setText("");
    		updateUserPasswordField.setText("");
    	});
    	
    	
    	
    	
    	
    	} catch (Exception e) {
    		System.out.println(e);
    	};
    }
}
