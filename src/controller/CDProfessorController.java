package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import DAO.ProfessorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Professor;

public class CDProfessorController {
	
	@FXML
	private TextField txtNome;
	@FXML
	private  TextField txtEmail;
	@FXML
	private TextField txtSenha;
	 @FXML
	private Button cadastrar;
	

	@FXML
	private void cadastrarProfessor(ActionEvent event) {
	    Professor p = new Professor(txtNome.getText(), txtEmail.getText(), txtSenha.getText());
	    ProfessorDAO.inserirProfessor(p);
	    System.out.println("Professor cadastrado com sucesso!");
	    limparCampos();
	}

	
    private void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtSenha.clear();
    }
	
	
	
}
