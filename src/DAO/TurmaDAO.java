package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Professor;
import model.Turma;
import util.ConexaoBD;

public class TurmaDAO {


	
	public static void inserirTurma(Turma t) {
	    String sql = "INSERT INTO turma (nm_turma, ds_turma, Professor_idProfessor) VALUES (?, ?, ?)";

	    try (Connection con = ConexaoBD.conectar();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, t.getNome());
	        ps.setString(2, t.getDescricao());

	        // Pega o ID do professor associado à turma
	        ps.setInt(3, t.getProfessor().getIdProfessor());

	        ps.execute();

	    } catch (SQLException erro) {
	        System.out.println("Erro ao cadastrar turma: " + erro.getMessage());
	    }
	}
	
	
	
	
	
	public static List<Turma> listarTurma() {
	    List<Turma> lista = new ArrayList<>();

	    try (Connection con = ConexaoBD.conectar()) {
	        String sql = "SELECT idTurma, nm_turma FROM turma"; // ajustar nomes conforme o seu BD
	        PreparedStatement stmt = con.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("idTurma");
	            String nome = rs.getString("nm_turma");
	            System.out.println("Id: " + id + ", Nome: " + nome); // Debug
	            lista.add(new Turma(id, nome));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	}

