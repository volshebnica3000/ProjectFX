package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class TariffController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addTariffButton;

    @FXML
    private Button deleteTariffButton;

    @FXML
    private Button aboutTariffButton;

    @FXML
    private Button updateTariffButton;

    @FXML
    private Pane addTariffPane;

    @FXML
    private TextField addTariffCoefField;

    @FXML
    private TextField addTariffLvlField;

    @FXML
    private Label addTariffLvlLabel;

    @FXML
    private Label addTariffCoefLabel;

    @FXML
    private Label addTariffLabel;

    @FXML
    private Button addTariffOKButton;

    @FXML
    private Pane deleteTariffPane;

    @FXML
    private TextField deleteTariffCoefField;

    @FXML
    private TextField deleteTariffLvlField;

    @FXML
    private Label deleteTariffLvlLabel;

    @FXML
    private Label deleteTariffCoefLabel;

    @FXML
    private Label deleteTariffLabel;

    @FXML
    private Button deleteTariffOKButton;

    @FXML
    private Pane aboutTariffPane;

    @FXML
    private TextField aboutTariffLvlField;

    @FXML
    private Label aboutTariffLvlLabel;

    @FXML
    private Button aboutTariffOKButton;

    @FXML
    private Label aboutTariffLabel;

    @FXML
    private Pane updateTariffPane;

    @FXML
    private TextField updateTariffCoefField;

    @FXML
    private TextField updateTariffLvlField;

    @FXML
    private Label updateTariffLvlLabel;

    @FXML
    private Label updateTariffCoefLabel;

    @FXML
    private Label updateTariffLabel;

    @FXML
    private Button updateTariffOKButton;

    @FXML
    void initialize() {
    	try {
    		
    			addTariffButton.setOnAction(event ->{
	    	    	addTariffPane.setVisible(true);
	    	    	deleteTariffPane.setVisible(false);
	    	    	aboutTariffPane.setVisible(false);
	    	    	updateTariffPane.setVisible(false);
    	    	});
    			
    			deleteTariffButton.setOnAction(event ->{
	        	    addTariffPane.setVisible(false);
	        	    deleteTariffPane.setVisible(true);
	        	    aboutTariffPane.setVisible(false);
	        	    updateTariffPane.setVisible(false);
        	    });
    		
    			aboutTariffButton.setOnAction(event ->{
        	    	addTariffPane.setVisible(false);
        	    	deleteTariffPane.setVisible(false);
        	    	aboutTariffPane.setVisible(true);
        	    	updateTariffPane.setVisible(false);
        	    });
    			
    			updateTariffButton.setOnAction(event ->{
        	    	addTariffPane.setVisible(false);
        	    	deleteTariffPane.setVisible(false);
        	    	aboutTariffPane.setVisible(false);
        	    	updateTariffPane.setVisible(true);
        	    });
    		
    		addTariffOKButton.setOnAction(event-> {
					int i = Tariff.addTariff(addTariffLvlField.getText(), addTariffCoefField.getText());
	                    if (i != 0) {
	                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
	                    	errorAlert.setHeaderText("Sucessfully!");
	                    	errorAlert.setContentText("Коэффициент добавлен");
	                    	errorAlert.showAndWait();
	                    } else {
	                    	Alert errorAlert = new Alert(AlertType.ERROR);
	                    	errorAlert.setHeaderText("Error!");
	                    	errorAlert.setContentText("Коэффициент не добавлен");
	                    	errorAlert.showAndWait();
	                    }
	    		addTariffCoefField.setText("");
	    		addTariffLvlField.setText("");   		
	    	});
    		
    		deleteTariffOKButton.setOnAction(event-> {
    				int i = Tariff.deleteTariff(deleteTariffLvlField.getText(), deleteTariffCoefField.getText());
                        if (i != 0) {
                        	Alert errorAlert = new Alert(AlertType.INFORMATION);
                        	errorAlert.setHeaderText("Sucessfully!");
                        	errorAlert.setContentText("Коэффициент удален");
                        	errorAlert.showAndWait();
                        } else {
                        	Alert errorAlert = new Alert(AlertType.ERROR);
                        	errorAlert.setHeaderText("Error!");
                        	errorAlert.setContentText("Коэффициент не удален");
                        	errorAlert.showAndWait();
                        }
        		deleteTariffLvlField.setText("");
        		deleteTariffCoefField.setText("");

        	});
    		
    		aboutTariffOKButton.setOnAction(event-> {
	    			String get = Tariff.aboutTariff(aboutTariffLvlField.getText());
	    			Alert infAlert = new Alert(AlertType.INFORMATION);
	            	infAlert.setHeaderText("Полученная информация");
	            	infAlert.setContentText(get);
	            	infAlert.showAndWait();
	    		aboutTariffLvlField.setText("");
	    	});
    		
    		updateTariffOKButton.setOnAction(event-> {
					int i = Tariff.updateTariff(updateTariffCoefField.getText(), updateTariffLvlField.getText());
	                    if (i != 0) {
	                    	Alert errorAlert = new Alert(AlertType.INFORMATION);
	                    	errorAlert.setHeaderText("Sucessfully!");
	                    	errorAlert.setContentText("Коэффициент изменен");
	                    	errorAlert.showAndWait();
	                    } else {
	                    	Alert errorAlert = new Alert(AlertType.ERROR);
	                    	errorAlert.setHeaderText("Error!");
	                    	errorAlert.setContentText("Коэффициент не изменен");
	                    	errorAlert.showAndWait();
	                    }
	    		updateTariffCoefField.setText("");
	    		updateTariffLvlField.setText("");
	    	});
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
