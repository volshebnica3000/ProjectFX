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

public class PayController {
	

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
					int i = Pay.addPay(addPayNameField.getText(), addPayPaymentField.getText(), addPayChargePayField.getText(), addPayHoldPayField.getText(), addPayPayOffField.getText());
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
	    		addPayNameField.setText("");
				addPayPaymentField.setText("");
				addPayChargePayField.setText("");
				addPayHoldPayField.setText("");
				addPayPayOffField.setText("");	    		
	    	});

	    	deletePayOKButton.setOnAction(event-> {
	    			int i = Pay.deletePay(deletePayNameField.getText(), deletePayPaymentField.getText());
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
	    		deletePayNameField.setText("");
	    		deletePayPaymentField.setText("");

	    	});
	    	
	    	aboutPayOKButton.setOnAction(event-> {
	    			String get = Pay.aboutPay(aboutPayNameField.getText());
	    			Alert infAlert = new Alert(AlertType.INFORMATION);
	            	infAlert.setHeaderText("Полученная информация");
	            	infAlert.setContentText(get);
	            	infAlert.showAndWait();
	    		aboutPayNameField.setText("");
	    	});
	    	
	    	updatePayOKButton.setOnAction(event-> {
	    		int i = Pay.updatePay(updatePayPaymentField.getText(), updatePayChargePayField.getText(), updatePayHoldPayField.getText(), updatePayPayOffField.getText(), updatePayNameField.getText());
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
