package controller;

import DAO.TurmaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Turma;
import util.Sessao;

public class CDTurmaController {
	
	@FXML private TextField txtNomeTurma;
	@FXML private TextField txtDsTurma;
	@FXML private Button btnAdcionarTurma;
	
	@FXML
	private void adicionarTurma(ActionEvent event) {
	   
		Turma turma = new Turma();
		turma.setNome(txtNomeTurma.getText());
		turma.setDescricao(txtDsTurma.getText()); // se tiver campo para descrição

		// associa o professor logado na sessão
		turma.setProfessor(Sessao.professorLogado);

		TurmaDAO.inserirTurma(turma);

	}

}
