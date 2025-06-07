package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Professor;
import util.ConexaoBD;

public class ProfessorDAO {

	public static void inserirProfessor(Professor p)
	{
		String sql = "INSERT INTO professor(nm_professor,email_professor,senha_professor)VALUES(?,?,?)";
		
		try(Connection con = ConexaoBD.conectar();
				PreparedStatement ps = con.prepareStatement(sql)){
			
				ps.setString(1, p.getNome());
				ps.setString(2, p.getEmail());
				ps.setString(3, p.getSenha());
				
				ps.execute();
		}catch(SQLException erro) {
			System.out.println("Erro ao cadastrar professor");
		}
		
	}
    public boolean validarLogin(String email, String senha) {
        String sql = "SELECT * FROM professor WHERE email_professor = ? AND senha_professor = ?";

        try (Connection con = ConexaoBD.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            

            return rs.next(); // retorna true se encontrou usuário
        } catch (Exception e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
            return false;
        }
        
	
	
}
    public static Professor buscarPorEmailSenha(String email, String senha) {
        String sql = "SELECT * FROM professor WHERE email = ? AND senha = ?";

        try (Connection con = ConexaoBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Professor p = new Professor();
                p.setIdProfessor(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("senha"));
                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // se não encontrar
    }

}
