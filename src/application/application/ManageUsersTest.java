package application;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import java.io.IOException;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManageUsersTest extends ApplicationTest {

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("application/ManageUsersController.fxml"));
		Scene scene = new Scene(root,700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application");
		primaryStage.show();
		primaryStage.setResizable(false);		
	}
	@Test
	public void test() {
		clickOn("addUserButton");
	}
	
}
