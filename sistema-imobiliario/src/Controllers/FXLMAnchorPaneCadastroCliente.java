package Controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import Models.Client;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FXLMAnchorPaneCadastroCliente implements Initializable {

	@FXML
	private TableView<Client> tableViewCliente;
	@FXML
	private TableColumn<Client, String> tableColumnClienteNome;
	@FXML
	private TableColumn<Client, String> tableColumnClienteCpf;
	@FXML
	private Button buttonInserir;
	@FXML
	private Button buttonAlterar;
	@FXML
	private Button buttonRemover;
	@FXML
	private Label labelNome;
	@FXML
	private Label labelCpf;
	@FXML 
	private Label labelemail;
	@FXML	
	private Label labelendereco;
	@FXML
	private Label labelTelefone;
	
//	private List<Client> listClientes;
//	private ObservableList<Client> observableListClientes;
		
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
	}
	
	public void carregaTableViewCliente() {
		
	}
	
}
