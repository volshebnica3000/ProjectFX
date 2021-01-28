package application;

import java.net.URL;
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
    		int i = ManageUsers.addUser(addUserLoginField.getText(), addUserPasswordField.getText());
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
    		addUserLoginField.setText("");
    		addUserPasswordField.setText("");
    	});
	
    	deleteUserOKButton.setOnAction(event-> {
    		int i = ManageUsers.deleteUser(deleteUserLoginField.getText());  		
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
    		deleteUserLoginField.setText("");
    	});
	
    	aboutUserOKButton.setOnAction(event-> {
    		String get = ManageUsers.aboutUser(aboutUserLoginField.getText());
			Alert infAlert = new Alert(AlertType.INFORMATION);
        	infAlert.setHeaderText("Полученная информация");
        	infAlert.setContentText(get);
        	infAlert.showAndWait();
		aboutUserLoginField.setText("");
	});
    	
    	searchUserOKButton.setOnAction(event-> {
			String get = ManageUsers.searchUser(searchUserLoginField.getText());
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
		searchUserLoginField.setText("");		
	});
    	
    	updateUserOKButton.setOnAction(event-> {
				int i = ManageUsers.updateUser(updateUserPasswordField.getText(), updateUserLoginField.getText());
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
    		updateUserLoginField.setText("");
    		updateUserPasswordField.setText("");
    	});
    	
    	
    	} catch (Exception e) {
    		System.out.println(e);
    	};
    }
}
