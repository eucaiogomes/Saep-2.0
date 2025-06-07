	package controller;
	
	import java.net.URL;
	import java.util.List;
	import java.util.ResourceBundle;
	
	import DAO.TurmaDAO;
	import javafx.collections.FXCollections;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Turma;
import util.Sessao;
	
	public class PrincipalController implements Initializable{
	
		@FXML private Label labelNome;
	    @FXML private TableView<Turma> tabelaTurmas = new TableView<Turma>();
	    @FXML private TableColumn<Turma, Integer> colId = new TableColumn<Turma, Integer>();
	    @FXML private TableColumn<Turma, String> colNome = new TableColumn<Turma, String>();
	    @FXML private TableColumn<Turma, Void> colAcao = new TableColumn<Turma, Void>();
	
	  
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	labelNome.setText(Sessao.professorLogado.getNome());	
	        System.out.println("Initialize chamado!");
	        colId.setCellValueFactory(new PropertyValueFactory<Turma, Integer>("idTurma"));
	        colNome.setCellValueFactory(new PropertyValueFactory<Turma, String>("nome"));

	
	        carregarTurmasNaTabela();
	        
	
	    }
	
	
	    private void carregarTurmasNaTabela() {
	        List<Turma> lista = TurmaDAO.listarTurma();
	        tabelaTurmas.setItems(FXCollections.observableArrayList(lista));
	    }
	
	
	    @FXML
	    private void cadastrarTurma(ActionEvent event) {
	    	try {
                // Carrega nova tela
                Parent root = FXMLLoader.load(getClass().getResource("/view/cadastroturma.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
	    }
	    
	}
