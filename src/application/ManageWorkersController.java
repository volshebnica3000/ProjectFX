package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class ManageWorkersController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addWorkerButton;

    @FXML
    private Button deleteWorkerButton;

    @FXML
    private Button aboutWorkerButton;

    @FXML
    private Button updateWorkerButton;

    @FXML
    private Pane addWorkerPane;

    @FXML
    private Label addWorkerLable;

    @FXML
    private Label addWorkerNameLabel;

    @FXML
    private TextField addWorkerNameField;

    @FXML
    private TextField addWorkerPosField;

    @FXML
    private TextField addWorkerLvlField;

    @FXML
    private Label addWorkerPosLabel;

    @FXML
    private Label addWorkerLvlLabel;

    @FXML
    private Label addWorkerUnionLabel;

    @FXML
    private Button addWorkerOKButton;

    @FXML
    private TextField addWorkerLoginField;

    @FXML
    private Label addWorkerLoginLabel;

    @FXML
    private CheckBox addWorkerUnionCheckBox;

    @FXML
    private Pane deleteWorkerPane;

    @FXML
    private Label deleteWorkerLabel;

    @FXML
    private Label deleteWorkerNameLabel;

    @FXML
    private TextField deleteWorkerNameField;

    @FXML
    private TextField deleteWorkerPosField;

    @FXML
    private Label deleteWorkerPosLabel;

    @FXML
    private Button deleteWorkerOKButton;

    @FXML
    private Pane aboutWorkerPane;

    @FXML
    private Label aboutWorkerLabel;

    @FXML
    private Label aboutWorkerNameLabel;

    @FXML
    private TextField aboutWorkerNameField;

    @FXML
    private Button aboutWorkerOKButton;

    @FXML
    private Pane updateWorkerPane;

    @FXML
    private Label updateWorkerLable;

    @FXML
    private Label updateWorkerNameLabel;

    @FXML
    private TextField updateWorkerNameField;

    @FXML
    private TextField updateWorkerPosField;

    @FXML
    private TextField updateWorkerLvlField;

    @FXML
    private Label updateWorkerPosLabel;

    @FXML
    private Label updateWorkerLvlLabel;

    @FXML
    private Label updateWorkerUnionLabel;

    @FXML
    private Button updateWorkerOKButton;

    @FXML
    private TextField updateWorkerLoginField;

    @FXML
    private Label updateWorkerLoginLabel;

    @FXML
    private CheckBox updateWorkerUnionCheckBox;

    @FXML
    void initialize() {
    	try {
    	
    	addWorkerButton.setOnAction(event -> {
    		deleteWorkerPane.setVisible(false);
    		updateWorkerPane.setVisible(false);
    		aboutWorkerPane.setVisible(false);
    		addWorkerPane.setVisible(true);
    	});
    	
    	deleteWorkerButton.setOnAction(event -> {
    		deleteWorkerPane.setVisible(true);
    		updateWorkerPane.setVisible(false);
    		aboutWorkerPane.setVisible(false);
    		addWorkerPane.setVisible(false);
    	});
    	
    	updateWorkerButton.setOnAction(event -> {
    		deleteWorkerPane.setVisible(false);
    		updateWorkerPane.setVisible(true);
    		aboutWorkerPane.setVisible(false);
    		addWorkerPane.setVisible(false);
    	});
    	
    	aboutWorkerButton.setOnAction(event -> {
    		deleteWorkerPane.setVisible(false);
    		updateWorkerPane.setVisible(false);
    		aboutWorkerPane.setVisible(true);
    		addWorkerPane.setVisible(false);
    	});
    	
    	
    	addWorkerOKButton.setOnAction(event-> {
    			String uni = "1";
    			if ((addWorkerUnionCheckBox.isSelected())==true) uni="2";     			
				int i = ManageWorkers.addWorker(addWorkerNameField.getText(), addWorkerPosField.getText(), addWorkerLvlField.getText(), uni, addWorkerLoginField.getText());
                    if (i != 0) {
                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
                    	errorAlert.setHeaderText("Sucessfully!");
                    	errorAlert.setContentText("Сотрудник добавлен");
                    	errorAlert.showAndWait();
                    } else {
                    	Alert errorAlert = new Alert(AlertType.ERROR);
                    	errorAlert.setHeaderText("Error!");
                    	errorAlert.setContentText("Сотрудник не добавлен");
                    	errorAlert.showAndWait();
                    }
    		addWorkerLoginField.setText("");
    		addWorkerNameField.setText("");
    		addWorkerLvlField.setText("");
    		addWorkerPosField.setText("");
    		addWorkerUnionCheckBox.setSelected(false);
    		
    	});
    	
    	
    	deleteWorkerOKButton.setOnAction(event-> {
				int i = ManageWorkers.deleteWorker(deleteWorkerNameField.getText(), deleteWorkerPosField.getText());
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
    		deleteWorkerNameField.setText("");
    		deleteWorkerPosField.setText("");

    	});
    	
    	aboutWorkerOKButton.setOnAction(event-> {
			String get = ManageWorkers.aboutWorker(aboutWorkerNameField.getText());
			Alert infAlert = new Alert(AlertType.INFORMATION);
        	infAlert.setHeaderText("Полученная информация");
        	infAlert.setContentText(get);
        	infAlert.showAndWait();
		aboutWorkerNameField.setText("");
	});
    	
    	updateWorkerOKButton.setOnAction(event-> {
    			String uni = "1";
    			if ((updateWorkerUnionCheckBox.isSelected())==true) uni="2";  
				int i = ManageWorkers.updateWorker(updateWorkerNameField.getText(), updateWorkerPosField.getText(), updateWorkerLvlField.getText(), uni, updateWorkerLoginField.getText());
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
                
    		updateWorkerLoginField.setText("");
    		updateWorkerNameField.setText("");
    		updateWorkerLvlField.setText("");
    		updateWorkerPosField.setText("");
    		updateWorkerUnionCheckBox.setSelected(false);
    	});
    	
    }catch (Exception e) {
		System.out.println(e);
	};
 }
}