package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FXMLVBoxMainController implements Initializable{
	
	@FXML
	private MenuItem menuItemConsultarTodos;
	@FXML
	private MenuItem menuItemConsultarCliente;
	@FXML
	private MenuItem menuItemIncluirCliente;
	@FXML
	private MenuItem menuItemAlterarCliente;
	@FXML
	private MenuItem menuItemDeletarCliente;
	@FXML
	private MenuItem menuItemImoveisConsultarTodos;
	@FXML
	private MenuItem menuItemImoveisConsultar;
	@FXML
	private MenuItem menuItemImoveisIncluir;
	@FXML
	private MenuItem menuItemImoveisAlterar;
	@FXML
	private MenuItem menuItemImoveisRemover;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private ImageView imageView;
	
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void handleMenuItemTodosClientes() throws IOException {
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/ViewSystem/FXMLAnchorPaneTodosClientes.fxml"));
		anchorPane.getChildren().setAll(a);
	}
	
	@FXML
	public void handleMenuItemCadastroClientes() throws IOException {
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/ViewSystem/FXMLAnchorPaneCadastroCliente.fxml"));
		anchorPane.getChildren().setAll(a);
	}
	
	@FXML
	public void handleMenuItemTodosImoveis() throws IOException {
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/ViewSystem/FXMLAnchorPaneTodosImoveis.fxml"));
		anchorPane.getChildren().setAll(a);
	}
	
	@FXML
	public void handleMenuItemCadastroImoveis() throws IOException {
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/ViewSystem/FXMLAnchorPaneCadastroImoveis.fxml"));
		anchorPane.getChildren().setAll(a);
	}
}
