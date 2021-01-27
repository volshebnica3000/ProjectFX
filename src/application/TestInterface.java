package application;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestInterface extends ApplicationTest{

	@Override
	public void start(Stage arg0) throws Exception {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Authorization.fxml"));
		Scene scene = new Scene(root,700,400);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();		
	}
	
	@Test
	public void inputLogin() {
		clickOn("loginField");
		write("user01");
		verifyThat("loginField", hasText("user01"));
	}
	
	@Test
	public void inputPassword() {
		clickOn("passwordField");
		write("1111");
		verifyThat("passwordField", hasText("1111"));
	}
	
}
