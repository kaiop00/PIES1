
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JFXMain extends Application {

	@Override
	public void start(Stage Stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewSystem/FXMLVBoxMain.fxml"));
	
		Scene scene = new Scene(root);
		
		Stage.setScene(scene);
		Stage.setTitle("Sistema Imobiliária");
		Stage.setResizable(false);
		Stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
