
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AuthorizationController {

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
        	Boolean isUserExists = Authorization.SignInn(loginField.getText(), passwordField.getText());
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
        });
    }
    
        }
    
