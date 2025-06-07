package controller;



import DAO.ProfessorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Professor;
import util.Sessao;

public class LoginController {
	
	@FXML
	private  TextField txtEmail;
	@FXML
	private TextField txtSenha;
	
	
	
	@FXML 
	public void fazerLogin(ActionEvent event) {
		ProfessorDAO p = new ProfessorDAO();
		boolean loginValido = p.validarLogin(txtEmail.getText(), txtSenha.getText());
		Professor professor = ProfessorDAO.buscarPorEmailSenha(txtEmail.getText(), txtSenha.getText());

		if (professor != null) {
		    Sessao.professorLogado = professor;
		} else {
			Sessao.professorLogado = professor;
		}


	    if (loginValido) {
            try {
                // Carrega nova tela
                Parent root = FXMLLoader.load(getClass().getResource("/view/principal.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login inválido.");
        }
    	
	}
	
	@FXML
	public void abrirCadastro(ActionEvent event) {
		  try {
              // Carrega nova tela
              Parent root = FXMLLoader.load(getClass().getResource("/view/cadastroprofessor.fxml"));
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.show();

          } catch (Exception e) {
              e.printStackTrace();
	}
	

	}
}
