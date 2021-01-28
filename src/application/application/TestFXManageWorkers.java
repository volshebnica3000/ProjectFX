package application;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

import java.io.IOException;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestFXManageWorkers extends ApplicationTest{ 
	@Override
	public void start(Stage primaryStage) throws IOException{
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/ManageWorkers.fxml"));
		Scene scene = new Scene(root,700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application");
		primaryStage.show(); 
		primaryStage.setResizable(false);
	}
	
	@Test
	public void testAddWorker() {
		clickOn ("#addWorkerButton",MouseButton.PRIMARY);
		clickOn ("#addWorkerNameField");
		write ("Tatyana");
		clickOn ("#addWorkerPosField");
		write("turner");
		clickOn ("#addWorkerLvlField");
		write("2");
		clickOn ("#addWorkerLoginField");
		write("user02");
		verifyThat("#addWorkerNameField", hasText("Tatyana"));
		verifyThat("#addWorkerPosField", hasText("turner"));
		verifyThat("#addWorkerLvlField", hasText("2"));
		verifyThat("#addWorkerLoginField", hasText("user02"));
		clickOn ("#addWorkerOKButton");
	}
	@Test
	public void testUpdateWorker() {
		clickOn ("#updateWorkerButton",MouseButton.PRIMARY);
		clickOn ("#updateWorkerNameField");
		write ("Tatyana P");
		clickOn ("#updateWorkerPosField");
		write("trainer");
		clickOn ("#updateorkerLvlField");
		write("3");
		clickOn ("#updateWorkerLoginField");
		write("user02");
		verifyThat("#updateWorkerNameField", hasText("Tatyana P"));
		verifyThat("#updateWorkerPosField", hasText("trainer"));
		verifyThat("#updateorkerLvlField", hasText("3"));
		verifyThat("#updateWorkerLoginField", hasText("user02"));
		clickOn ("#updateWorkerOKButton");
	}
	@Test
	public void testAboutWorker() {
		clickOn ("#aboutWorkerButton",MouseButton.PRIMARY);
		clickOn ("#aboutWorkerNameField");
		write ("Tatyana P");
		verifyThat("#aboutWorkerNameField", hasText("Tatyana P"));
		clickOn ("#aboutWorkerOKButton");
	}

	@Test
	public void testDeleteWorker() {
		clickOn ("#deleteWorkerButton",MouseButton.PRIMARY);
		clickOn ("#deleteWorkerNameField");
		write ("Tatyana");
		clickOn ("#deleteWorkerPosField");
		write ("trainer");
		verifyThat("#deleteWorkerNameField", hasText("Tatyana"));
		verifyThat("#deleteWorkerPosField", hasText("trainer"));
		clickOn ("#deleteWorkerOKButton");
	}
	
	
	
}