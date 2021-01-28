package application;
import java.io.IOException;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane; 
import javafx.stage.Stage;

public class TestFXManageUsers extends ApplicationTest{
	@Override
	public void start(Stage primaryStage) throws IOException{
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/ManageUsers.fxml"));
		Scene scene = new Scene(root,700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application");
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	@Test
	public void testAddUser() {
		clickOn ("#addUserButton",MouseButton.PRIMARY);
		clickOn ("#addUserLoginField");
		write ("Tatyana");
		clickOn ("#addUserPasswordField");
		write("4545");
		verifyThat("#addUserLoginField", hasText("Tatyana"));
		verifyThat("#addUserPasswordField", hasText("4545"));
		clickOn ("#addUserOKButton");
	}
	@Test
	public void testUpdateUser() {
		clickOn ("#updateUserButton",MouseButton.PRIMARY);
		clickOn ("#updateUserLoginField");
		write ("Tatyana");
		clickOn ("#updateUserPasswordField");
		write("4444");
		verifyThat("#updateUserLoginField", hasText("Tatyana"));
		verifyThat("#updateUserPasswordField", hasText("4444"));
		clickOn ("#updateUserOKButton");
	}
	@Test
	public void testAboutUser() {
		clickOn ("#aboutUserButton",MouseButton.PRIMARY);
		clickOn ("#aboutUserLoginField");
		write ("Tatyana");
		verifyThat("#aboutUserLoginField", hasText("Tatyana"));
		clickOn ("#aboutUserOKButton");
	}
	@Test
	public void testSearchUser() {
		clickOn ("#searchUserButton",MouseButton.PRIMARY);
		clickOn ("#searchUserLoginField");
		write ("Tatyana");
		verifyThat("#searchUserLoginField", hasText("Tatyana"));
		clickOn ("#searchUserOKButton");
	}
	@Test
	public void testDeleteUser() {
		clickOn ("#deleteUserButton",MouseButton.PRIMARY);
		clickOn ("#deleteUserLoginField");
		write ("Tatyana");
		verifyThat("#deleteUserLoginField", hasText("Tatyana"));
		clickOn ("#deleteUserOKButton");
	}
	
}