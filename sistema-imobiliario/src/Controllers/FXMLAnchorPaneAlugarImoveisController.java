package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import Models.Property;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class FXMLAnchorPaneAlugarImoveisController implements Initializable{

		@FXML
		private Label labelImovelId;
		@FXML
		private Label labelImovelEndereco;
		@FXML
		private Label labelImovelValor;
		@FXML
		private Label labelImovelAlugado;
		@FXML
		private Label labelImovelLocatario;
		@FXML
		private TextField textFieldImovelId;
		@FXML
		private TextField textFieldImovelEndereco;
		@FXML
		private TextField textFieldImovelValor;
		@FXML
		private TextField textFieldImovelAlugado;
		@FXML
		private TextField textFieldImovelCpfLocatario;
		@FXML
		private Button buttonImovelConfirmar;
		@FXML
		private Button buttonImovelCancelar;
		@FXML
		private ImageView imageViewAlugarImoveis;
		
		private Stage dialogStage;
		private boolean buttonConfirmarClicked = false;
		private Property imovel;
		
		@Override
		public void initialize(URL url, ResourceBundle rb) {
		}
		
		public Stage getDialogStage() {
			return dialogStage;
		}

		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}

		public boolean isButtonConfirmarClicked() {
			return buttonConfirmarClicked;
		}

		public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
			this.buttonConfirmarClicked = buttonConfirmarClicked;
		}

		public Property getProperty() {
			return imovel;
		}

		public void setProperty(Property imovel) {
			this.imovel = imovel;
			textFieldImovelId.setText(imovel.getId());
			textFieldImovelEndereco.setText(imovel.getAddress());
			textFieldImovelValor.setText(imovel.getValue());
			textFieldImovelAlugado.setText(imovel.getIsLocate());
		}
		
		@FXML
		public void handleButtonImovelConfirmar() {
			if(validarEntradaDeDados()) {
				imovel.setId(textFieldImovelId.getText());
				imovel.setAddress(textFieldImovelEndereco.getText());
				imovel.setValue(textFieldImovelValor.getText());
				imovel.setIsLocate(textFieldImovelAlugado.getText());
				buttonConfirmarClicked = true;
				dialogStage.close();
			}
		}
		
		@FXML
		public void handleButtonImovelCancelar() {
			dialogStage.close();
		}
		
		private boolean validarEntradaDeDados() {
	        String errorMessage = "";

	        if (textFieldImovelId.getText() == null || textFieldImovelId.getText().length() == 0) {
	            errorMessage += "ID inválido!\n";
	        }
	        if (textFieldImovelEndereco.getText() == null || textFieldImovelEndereco.getText().length() == 0) {
	            errorMessage += "Endereço inválido!\n";
	        }
	        if (textFieldImovelValor.getText() == null || textFieldImovelValor.getText().length() == 0) {
	            errorMessage += "Valor inválido!\n";
	        }
	        if (textFieldImovelAlugado.getText() == null || textFieldImovelAlugado.getText().length() == 0) {
	            errorMessage += "Alugado inválido!\n";
	        }
	        if (textFieldImovelCpfLocatario.getText() == null || textFieldImovelCpfLocatario.getText().length() == 0) {
	            errorMessage += "Locatario inválido!\n";
	        }

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Erro no cadastro");
	            alert.setHeaderText("Campos inválidos, por favor, corrija...");
	            alert.setContentText(errorMessage);
	            alert.show();
	            return false;
	        }
	    }
			
	}

