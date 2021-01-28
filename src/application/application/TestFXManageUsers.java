package application;
import java.io.IOException;
import org.junit.Test;
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
		clickOn ("#addUserOKButton");
	}
	@Test
	public void testUpdateUser() {
		clickOn ("#updateUserButton",MouseButton.PRIMARY);
		clickOn ("#updateUserLoginField");
		write ("Tatyana");
		clickOn ("#updateUserPasswordField");
		write("4444");
		clickOn ("#updateUserOKButton");
	}
	@Test
	public void testAboutUser() {
		clickOn ("#aboutUserButton",MouseButton.PRIMARY);
		clickOn ("#aboutUserLoginField");
		write ("Tatyana");
		clickOn ("#aboutUserOKButton");
	}
	@Test
	public void testSearchUser() {
		clickOn ("#searchUserButton",MouseButton.PRIMARY);
		clickOn ("#searchsearchUserLoginField");
		write ("Tatyana");
		clickOn ("#searchUserOKButton");
	}
	@Test
	public void testDeleteUser() {
		clickOn ("#deleteUserButton",MouseButton.PRIMARY);
		clickOn ("#deleteUserLoginField");
		write ("Tatyana");
		clickOn ("#deleteUserOKButton");
	}
	
}