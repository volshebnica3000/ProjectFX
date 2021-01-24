package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class AuthorizationController {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    void initialize() {
        signInButton.setOnAction(event -> {
        	
        	try {
        		Boolean isUserExists = false;
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection con = DriverManager.getConnection (url,user,password);
        		try (PreparedStatement ps = con.prepareStatement("select 1 from `Manage_users` where `Login` = ? and `Password` = ?")) {
                    ps.setString(1, loginField.getText());
                    ps.setString(2, passwordField.getText());
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            isUserExists = true;
                        }
                    }
                }
                
                if (isUserExists) {
                	Stage stage1 = (Stage) signInButton.getScene().getWindow();
                	stage1.close();
                	FXMLLoader loader = new FXMLLoader();
                	loader.setLocation(getClass().getResource("/Menu.fxml"));
                	try {
        				loader.load();
        			} catch (IOException e) {
        				
        				e.printStackTrace();
        			}
                    Parent root = loader.getRoot(); 
                	Stage stage = new Stage();
                	stage.setScene(new Scene(root));
                	stage.showAndWait();                	
                } else {
                	Alert errorAlert = new Alert(AlertType.ERROR);
                	errorAlert.setHeaderText("Ошибка!");
                	errorAlert.setContentText("Неверный логин или пароль");
                	errorAlert.showAndWait();
                };
//        		PreparedStatement ps = con.prepareStatement("insert into manage_users (login,password) values (?,?)");
//        		ps.setString(1, loginField.getText());
//        		ps.setString(2, passwordField.getText());
//        		try (ResultSet rs = ps.executeQuery()) {
//                    if (rs.next()) {
//                        isUserExists = true;
//                    } catch(Exception e1) {
//                		System.out.println(e1);
//                	}
////        		int x = ps.executeUpdate();
////        		if (x>0) {
////        			System.out.println("Authorisation done sucessfully");
////        		}else {
////        			System.out.println("Authorization failed");
////        		}
        	}catch(Exception e) {
        		System.out.println(e);
        	}
        });
    }
    
        }
    
