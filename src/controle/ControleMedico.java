package controle;
import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import agenda.Medico;

public class ControleMedico {
	ModuloConexao conexao = new ModuloConexao();
	Medico medico = new Medico();
	
	public void Salvar (Medico medico) {
		conexao.conexao();
		try {
			//apagar comentario
			// video 7 8:56 um pouco diferente
			PreparedStatement pst = (PreparedStatement) conexao.con.prepareStatement("Insert into tbmedico (nome, crm, especialidade, fone, login, senha) values(?,?,?,?,?,?)");
			pst.setString(1, medico.getNome());
			pst.setInt(2, medico.getCrm());
			pst.setString(3, medico.getEspecialidade());
			pst.setString(3, medico.getFone());
			pst.setString(5, medico.getLogin());
			pst.setString(6, medico.getSenha());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Médico Cadastrado");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Médico "+ex);
		}
		
		conexao.desconecta();
		
		
	}
	
	
	
	
}
