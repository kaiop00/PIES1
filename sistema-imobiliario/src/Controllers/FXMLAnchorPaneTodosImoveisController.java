package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import DAO.PropertyDAO;
import Models.Property;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLAnchorPaneTodosImoveisController implements Initializable{

		@FXML
		private TableView<Property> tableViewImoveis = new TableView<>();
		@FXML
		private TableColumn<Property, String> tableColumnImovelId = new TableColumn<>();
		@FXML
		private TableColumn<Property, String> tableColumnImovelAddress = new TableColumn<>();
		@FXML
		private Button buttonImovelInserir;
		@FXML
		private Button buttonImovelAlterar;
		@FXML
		private Button buttonImovelRemover;
		@FXML
		private Label labelImovelId = new Label();
		@FXML
		private Label labelImovelEndereco = new Label();
		@FXML 
		private Label labelImovelArea = new Label();
		@FXML	
		private Label labelImovelQuartos = new Label();
		@FXML
		private Label labelImovelGaragem = new Label();
		@FXML
		private Label labelImovelValor = new Label();
		@FXML
		private Label labelImovelAlugado = new Label();
		
		private List<Property> listImoveis;
		private ObservableList<Property> observableListImoveis;
			
		
		
		@Override
		public void initialize(URL url, ResourceBundle rb) {
			carregarTableViewImovel();
			
			tableViewImoveis.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> selecionarItemTableViewImoveis(newValue));
			
		}
		
		public void carregarTableViewImovel() {
			tableColumnImovelId.setCellValueFactory(new PropertyValueFactory<>("id"));
	        tableColumnImovelAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

	        listImoveis = PropertyDAO.getAll();

	        observableListImoveis = FXCollections.observableArrayList(listImoveis);
	        tableViewImoveis.setItems(observableListImoveis);

		}
		
	    public void selecionarItemTableViewImoveis(Property imovel){
	        if (imovel != null) {
	            labelImovelId.setText(imovel.getId());
	            labelImovelEndereco.setText(imovel.getAddress());
	            labelImovelArea.setText(imovel.getArea());
	            labelImovelQuartos.setText(imovel.getRoom());
	            labelImovelGaragem.setText(imovel.getGarage());
	            labelImovelValor.setText(imovel.getValue());
	            labelImovelAlugado.setText(imovel.getIsLocate());
	            
	        } else {
	        	labelImovelId.setText("");
	            labelImovelEndereco.setText("");
	            labelImovelArea.setText("");
	            labelImovelQuartos.setText("");
	            labelImovelGaragem.setText("");
	            labelImovelValor.setText("");
	            labelImovelAlugado.setText("");
	        }

	    }
	    
	    @FXML
	    public void handleButtonImoveisIncluir() throws IOException {
	    	Property imovel = new Property();
	    	boolean buttonConfirmarCliked = showFXMLAnchorPaneCadastroImoveis(imovel);
	    	if(buttonConfirmarCliked) {
	    		PropertyDAO.setProperty(imovel);
	    		carregarTableViewImovel();
	    	}
	    }

	    @FXML
	    public void handleButtonImoveisAlterar() throws IOException {
	    	Property imovel = tableViewImoveis.getSelectionModel().getSelectedItem();
	    	if(imovel != null) {
	    		boolean buttonConfirmarCliked = showFXMLAnchorPaneCadastroImoveis(imovel);
	    		if(buttonConfirmarCliked) {
	    			PropertyDAO.updateProperty(imovel);
	        		carregarTableViewImovel();
	    		}
	    	}else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setContentText("Por favor, escolha um imovel na Tabela!");
	    		alert.show();
	    	}
	    	
	    }
	    
	    @FXML
	    public void handleButtonImoveisRemover() throws IOException {
	    	Property imovel = tableViewImoveis.getSelectionModel().getSelectedItem();
	    	if(imovel != null) {
	    		PropertyDAO.deleteProperty(imovel);
	    		carregarTableViewImovel();
	    	}else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setContentText("Por favor, escolha um imovel na Tabela!");
	    		alert.show();
	    	}
	    }
	    
	    public boolean showFXMLAnchorPaneCadastroImoveis(Property imovel) throws IOException {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(FXMLAnchorPaneCadastroImoveisController.class.getResource("/ViewSystem/FXMLAnchorPaneCadastroImoveis.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Cadastro de Imóveis");
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        FXMLAnchorPaneCadastroImoveisController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setProperty(imovel);

	        dialogStage.showAndWait();

	        return controller.isButtonConfirmarClicked();
	    }
	    
	}
