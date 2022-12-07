package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import DAO.ClientDAO;
import Models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLAnchorPaneTodosClientesController implements Initializable {

	@FXML
	private TableView<Client> tableViewClientes = new TableView<>();;
	@FXML
	private TableColumn<Client, String> tableColumnClienteNome = new TableColumn<>();
	@FXML
	private TableColumn<Client, String> tableColumnClienteCpf = new TableColumn<>();
	@FXML
	private Button buttonClienteInserir;
	@FXML
	private Button buttonClienteAlterar;
	@FXML
	private Button buttonClienteRemover;
	@FXML
	private Label labelClienteNome;
	@FXML
	private Label labelClienteCpf;
	@FXML 
	private Label labelClienteEmail;
	@FXML	
	private Label labelClienteEndereco;
	@FXML
	private Label labelClienteTelefone;
	@FXML
	private ImageView imageViewTodosClientes;
	
	private List<Client> listClientes;
	private ObservableList<Client> observableListClientes;
		
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		carregarTableViewCliente();
		
		tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
		
	}
	
	public void carregarTableViewCliente() {
		tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnClienteCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        listClientes = ClientDAO.getAll();

        observableListClientes = FXCollections.observableArrayList(listClientes);
        tableViewClientes.setItems(observableListClientes);

	}
	
    public void selecionarItemTableViewClientes(Client cliente){
        if (cliente != null) {
            labelClienteNome.setText(cliente.getName());
            labelClienteCpf.setText(cliente.getCpf());
            labelClienteEmail.setText(cliente.getEmail());
            labelClienteEndereco.setText(cliente.getAddress());
            labelClienteTelefone.setText(cliente.getPhone());
        } else {
            labelClienteNome.setText("");
            labelClienteCpf.setText("");
            labelClienteEmail.setText("");
            labelClienteEndereco.setText("");
            labelClienteTelefone.setText("");
        }

    }
    
    @FXML
    public void handleButtonIncluir() throws IOException {
    	Client client = new Client();
    	boolean buttonConfirmarCliked = showFXMLAnchorPaneCadastroCliente(client);
    	if(buttonConfirmarCliked) {
    		ClientDAO.setClient(client);
    		carregarTableViewCliente();
    	}
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
    	Client client = tableViewClientes.getSelectionModel().getSelectedItem();
    	if(client != null) {
    		boolean buttonConfirmarCliked = showFXMLAnchorPaneCadastroCliente(client);
    		if(buttonConfirmarCliked) {
    			ClientDAO.updateClient(client);
        		carregarTableViewCliente();
    		}
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Por favor, escolha um cliente na Tabela!");
    		alert.show();
    	}
    	
    }
    
    @FXML
    public void handleButtonRemover() throws IOException {
    	Client client = tableViewClientes.getSelectionModel().getSelectedItem();
    	if(client != null) {
    		ClientDAO.deleteClient(client);
    		carregarTableViewCliente();
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Por favor, escolha um cliente na Tabela!");
    		alert.show();
    	}
    }
    
    public boolean showFXMLAnchorPaneCadastroCliente(Client client) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastroClienteController.class.getResource("/ViewSystem/FXMLAnchorPaneCadastroCliente.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Clientes");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        FXMLAnchorPaneCadastroClienteController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setClient(client);

        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }
    
}
