package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button toManageUsersButton;

    @FXML
    private Button toManageWorkersButton;

    @FXML
    private Button toPayButton;

    @FXML
    private Button toTariffButton;

    @FXML
    void initialize() {
        toManageUsersButton.setOnAction(event -> {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/ManageUsers.fxml"));
        	try {
				loader.load();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
        	Parent root = loader.getRoot(); 
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root));
        	stage.showAndWait();
        });
        
        toManageWorkersButton.setOnAction(event -> {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/ManageWorkers.fxml"));
        	try {
				loader.load();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
        	Parent root = loader.getRoot(); 
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root));
        	stage.showAndWait();
        });
        
        toPayButton.setOnAction(event -> {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/Pay.fxml"));
        	try {
				loader.load();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
        	Parent root = loader.getRoot(); 
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root));
        	stage.showAndWait();
        });
        toTariffButton.setOnAction(event -> {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/Tariff.fxml"));
        	try {
				loader.load();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
        	Parent root = loader.getRoot(); 
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root));
        	stage.showAndWait();
        });
    }
}
