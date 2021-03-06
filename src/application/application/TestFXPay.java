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

public class TestFXPay extends ApplicationTest{
	@Override
	public void start(Stage primaryStage) throws IOException{
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Pay.fxml"));
		Scene scene = new Scene(root,700,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application");
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	@Test
	public void testAddPay() {
		clickOn ("#addPayButton",MouseButton.PRIMARY);
		clickOn ("#addPayNameField");
		write ("Tatyana");
		clickOn ("#addPayPaymentField"); 
		write("11111");
		clickOn ("#addPayHoldPayField");
		write("2222");
		clickOn ("#addPayChargePayField");
		write("33333");
		verifyThat("#addPayNameField", hasText("Tatyana"));
		verifyThat("#addPayPaymentField", hasText("11111"));
		verifyThat("#addPayHoldPayField", hasText("2222"));
		verifyThat("#addPayChargePayField", hasText("33333"));
		clickOn ("#addPayOKButton");
	}
	@Test
	public void testUpdatePay() {
		clickOn ("#updatePayButton",MouseButton.PRIMARY);
		clickOn ("#updatePayNameField");
		write ("Tatyana P");
		clickOn ("#updatePayPaymentField");
		write("232323");
		clickOn ("#updatePayHoldPayField");
		write("3333");
		clickOn ("#updatePayChargePayField");
		write("323232");
		verifyThat("#updatePayNameField", hasText("Tatyana P"));
		verifyThat("#updatePayPaymentField", hasText("232323"));
		verifyThat("#updatePayHoldPayField", hasText("3333"));
		verifyThat("#updatePayChargePayField", hasText("323232"));
		clickOn ("#updatePayOKButton");
	}
	@Test
	public void testAboutPay() {
		clickOn ("#aboutPayButton",MouseButton.PRIMARY);
		clickOn ("#aboutPayNameField");
		write ("Tatyana");
		verifyThat("#aboutPayNameField", hasText("Tatyana"));
		clickOn ("#aboutPayOKButton");
	}

	@Test
	public void testDeletePay() {
		clickOn ("#deletePayButton",MouseButton.PRIMARY);
		clickOn ("#deletePayNameField");
		write ("Tatyana");
		clickOn ("#deletePayPaymentField");
		write ("232323");
		verifyThat("#deletePayNameField", hasText("Tatyana"));
		verifyThat("#deletePayPaymentField", hasText("232323"));
		clickOn ("#deletePayOKButton");
	}
	
	
	
}