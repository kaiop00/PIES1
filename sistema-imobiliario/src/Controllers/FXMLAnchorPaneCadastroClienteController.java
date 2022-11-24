package Controllers;


import java.net.URL;
import java.util.ResourceBundle;

import Models.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLAnchorPaneCadastroClienteController implements Initializable {

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
	private TextField textFieldClienteNome;
	@FXML
	private TextField textFieldClienteCpf;
	@FXML
	private TextField textFieldClienteEmail;
	@FXML
	private TextField textFieldClienteEndereco;
	@FXML
	private TextField textFieldClienteTelefone;
	@FXML
	private Button buttonClienteConfirmar;
	@FXML
	private Button buttonClienteCancelar;
	
	private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
	private Client client;
	
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
		textFieldClienteNome.setText(client.getName());
		textFieldClienteCpf.setText(client.getCpf());
		textFieldClienteEmail.setText(client.getEmail());
		textFieldClienteEndereco.setText(client.getAddress());
		textFieldClienteTelefone.setText(client.getPhone());		
	}
	
	@FXML
	public void handleButtonConfirmar() {
		if(validarEntradaDeDados()) {
			client.setName(textFieldClienteNome.getText());
			client.setCpf(textFieldClienteCpf.getText());
			client.setEmail(textFieldClienteEmail.getText());
			client.setAdress(textFieldClienteEndereco.getText());
			client.setPhone(textFieldClienteTelefone.getText());
			
			buttonConfirmarClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	public void handleButtonCancelar() {
		dialogStage.close();
	}
	
	private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldClienteNome.getText() == null || textFieldClienteNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldClienteCpf.getText() == null || textFieldClienteCpf.getText().length() == 0) {
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldClienteEmail.getText() == null || textFieldClienteEmail.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }
        if (textFieldClienteEndereco.getText() == null || textFieldClienteEndereco.getText().length() == 0) {
            errorMessage += "Endereço inválido!\n";
        }
        if (textFieldClienteTelefone.getText() == null || textFieldClienteTelefone.getText().length() == 0) {
            errorMessage += "Telefone inválido!\n";
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
