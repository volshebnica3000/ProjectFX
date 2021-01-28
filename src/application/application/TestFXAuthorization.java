package application;
import java.io.IOException;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestFXAuthorization extends ApplicationTest{
	@Override
	public void start(Stage primaryStage) throws IOException{
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Authorization.fxml"));
		Scene scene = new Scene(root,700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application");
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	@Test
	public void inputName() {
		clickOn ("#loginField", MouseButton.PRIMARY);
		write ("uru");
		clickOn ("#passwordField");
		write("1212");
		clickOn ("#signInButton");
	}
}