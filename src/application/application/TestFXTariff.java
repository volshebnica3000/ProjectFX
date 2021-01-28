package application;
import java.io.IOException;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestFXTariff extends ApplicationTest{
	@Override
	public void start(Stage primaryStage) throws IOException{
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Tariff.fxml"));
		Scene scene = new Scene(root,700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application");
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	@Test
	public void testAddTariff() {
		clickOn ("#addTariffButton",MouseButton.PRIMARY);
		clickOn ("#addTariffCoefField");
		write ("8");
		clickOn ("#addTariffLvlField"); 
		write("13");
		clickOn ("#addTariffOKButton");;
	}
	@Test
	public void testUpdateTariff() {
		clickOn ("#updateTariffButton",MouseButton.PRIMARY);
		clickOn ("#updateTariffCoefField");
		write ("3.3");
		clickOn ("#updateTariffLvlField");
		write("13");
		clickOn ("#updateTariffOKButton");
	}
	@Test
	public void testAboutTariff() {
		clickOn ("#aboutTariffButton",MouseButton.PRIMARY);
		clickOn ("#aboutTariffLvlLabel");
		write ("13");
		clickOn ("#aboutTariffOKButton");
	}

	@Test
	public void testDeleteTariff() {
		clickOn ("#deleteTariffButton",MouseButton.PRIMARY);
		clickOn ("#deleteTariffCoefField");
		write ("3.3");
		clickOn ("#deleteTariffLvlField");
		write ("13");
		clickOn ("#deleteTariffOKButton");
	}
	
	
	
}