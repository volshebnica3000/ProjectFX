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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class ManageWorkersController {
	private static final String url = "jdbc:mysql://localhost:3306/my";
    private static final String user = "root";
    private static final String password = "1234";

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
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection (url,user,password);
    	
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
    		try {
				PreparedStatement ps = con.prepareStatement("insert into manage_workers (w_name, w_position, w_level, if_trade_union, Manage_users_login, Tariff_Tar_id) values (?, ?, ?, ?, ?, ?)");
    			String uni = "1";
    			if ((addWorkerUnionCheckBox.isSelected())==true) uni="2";     			
				ps.setString(1, addWorkerNameField.getText());
				ps.setString(2, addWorkerPosField.getText());
				ps.setInt(3, Integer.parseInt(addWorkerLvlField.getText()));
				ps.setString(4, uni);
				ps.setString(5, addWorkerLoginField.getText());
				ps.setInt(6, Integer.parseInt(addWorkerLvlField.getText()));
                int i = ps.executeUpdate();
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
                
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		addWorkerLoginField.setText("");
    		addWorkerNameField.setText("");
    		addWorkerLvlField.setText("");
    		addWorkerPosField.setText("");
    		addWorkerUnionCheckBox.setSelected(false);
    		
    	});
    	
    	
    	deleteWorkerOKButton.setOnAction(event-> {
    		try {
				PreparedStatement ps = con.prepareStatement("delete from manage_workers where w_name = ? and w_position = ?");
				ps.setString(1, deleteWorkerNameField.getText());
				ps.setString(2, deleteWorkerPosField.getText());
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
    		deleteWorkerNameField.setText("");
    		deleteWorkerPosField.setText("");

    	});
    	
    	aboutWorkerOKButton.setOnAction(event-> {
    		try {
			PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM manage_workers where w_name=?");
			ps.setString(1, aboutWorkerNameField.getText());
			ResultSet res = ps.executeQuery();
			String get = "";
			String uni = "не состоит в профсоюзе";
			if (res.next())
		       {
				if (Integer.parseInt(res.getString("if_trade_union"))==2) uni="состоит в профсоюзе";
				get = "ФИО: " + res.getString("w_name") + 
						"\nДолжность: " + res.getString("w_position") +
						"\nРазряд: " + res.getString("w_level") +
						"\nУчастие в профсоюзе: " + uni + 
						"\nЛогин: " + res.getString("Manage_users_login");
		        }
			Alert infAlert = new Alert(AlertType.INFORMATION);
        	infAlert.setHeaderText("Полученная информация");
        	infAlert.setContentText(get);
        	infAlert.showAndWait();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		aboutWorkerNameField.setText("");
	});
    	
    	updateWorkerOKButton.setOnAction(event-> {
    		try {
    			String uni = "1";
    			if ((updateWorkerUnionCheckBox.isSelected())==true) uni="2";  
				PreparedStatement ps = con.prepareStatement("UPDATE manage_workers SET w_name=?, w_position=?, w_level=? , if_trade_union =? WHERE Manage_users_login=?");
				ps.setString(1, updateWorkerNameField.getText());
				ps.setString(2, updateWorkerPosField.getText());
				ps.setInt(3, Integer.parseInt(updateWorkerLvlField.getText()));
				ps.setString(4, uni);
				ps.setString(5, updateWorkerLoginField.getText());

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