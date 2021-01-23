package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManageWorkers {

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
    void initialize() {
        assert addWorkerButton != null : "fx:id=\"addWorkerButton\" was not injected: check your FXML file 'ManageWorkers.fxml'.";
        assert deleteWorkerButton != null : "fx:id=\"deleteWorkerButton\" was not injected: check your FXML file 'ManageWorkers.fxml'.";
        assert aboutWorkerButton != null : "fx:id=\"aboutWorkerButton\" was not injected: check your FXML file 'ManageWorkers.fxml'.";
        assert updateWorkerButton != null : "fx:id=\"updateWorkerButton\" was not injected: check your FXML file 'ManageWorkers.fxml'.";

    }
}
