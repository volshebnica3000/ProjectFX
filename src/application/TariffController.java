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

public class TariffController {
	
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";

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
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    		
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
	    		try {
					PreparedStatement ps = con.prepareStatement("insert into tariff (level,coef) values ( ?, ?)");
					ps.setInt(1, Integer.parseInt(addTariffLvlField.getText()));
					ps.setString(2, addTariffCoefField.getText());				

					int i = ps.executeUpdate();
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
	                
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		addTariffCoefField.setText("");
	    		addTariffLvlField.setText("");   		
	    	});
    		
    		deleteTariffOKButton.setOnAction(event-> {
        		try {
    				PreparedStatement ps = con.prepareStatement("delete from tariff where level = ? and coef = ?");
    				ps.setInt(1, Integer.parseInt(deleteTariffLvlField.getText()));
    				ps.setString(2, deleteTariffCoefField.getText());
                    int i = ps.executeUpdate();
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
                    
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
        		deleteTariffLvlField.setText("");
        		deleteTariffCoefField.setText("");

        	});
    		
    		aboutTariffOKButton.setOnAction(event-> {
	    		try {
	    			PreparedStatement ps = null;
	    			ps = con.prepareStatement("SELECT * FROM tariff where level=?");
	    			ps.setInt(1, Integer.parseInt(aboutTariffLvlField.getText()));
	    			ResultSet res = ps.executeQuery();
	    			String get = "";
	    			if (res.next()) {
	    				get = "Разряд: " + res.getInt("level") + 
	    						"\nКоэффициент: " + res.getString("coef");
	    		        }
	    			Alert infAlert = new Alert(AlertType.INFORMATION);
	            	infAlert.setHeaderText("Полученная информация");
	            	infAlert.setContentText(get);
	            	infAlert.showAndWait();
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    		aboutTariffLvlField.setText("");
	    	});
    		
    		updateTariffOKButton.setOnAction(event-> {
	    		try {
					PreparedStatement ps = con.prepareStatement("update tariff set coef=? where level=?");
					ps.setString(1, updateTariffCoefField.getText());
					ps.setInt(2, Integer.parseInt(updateTariffLvlField.getText()));

	                int i = ps.executeUpdate();
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
	                
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		updateTariffCoefField.setText("");
	    		updateTariffLvlField.setText("");
	    	});
    		
    	} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}
