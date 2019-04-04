package agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
	
	Connection conexao = null; //usando a variavel criada no modulo de conexão
    PreparedStatement pst = null; //conjunto de biblioteca sql
    ResultSet rs = null;
    
    public void Inserirmedico (Medico medico) {
    	try {
		conexao = ModuloConexao.conector();
		
		String sql = "Insert into tbmedico (idmedico,nome, crm, especialidade, fone, login, senha) values(?,?,?,?,?,?,?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setInt(1, medico.getIdmedico());
		statement.setString(2, medico.getNome());
		statement.setString(3, medico.getCrm());
		statement.setString(4, medico.getEspecialidade());
		statement.setString(5, medico.getFone());
		statement.setString(6, medico.getLogin());
		statement.setString(7, medico.getSenha());
		
		statement.execute();
		conexao.close();
		System.out.println("inserido");
		
	}catch (Exception e) {
		e.printStackTrace();
	}
 }
    
    public void Removermedico (int idmedico) {
    	try {
    		conexao = ModuloConexao.conector();
    		
    		String sql = "delete from tbmedico  where idmedico = ?";
    		PreparedStatement statement = conexao.prepareStatement(sql);
    		statement.setInt(1, idmedico);
    		
    		statement.execute();
    		statement.close();
    	}catch (Exception e) {
    		e.printStackTrace();
    		
    	}
    }
    
    public List<Medico> Listarmedicos(){
    	List<Medico> listamedicos = new ArrayList<Medico>();
    	try {
    		conexao = ModuloConexao.conector();
    		
    		String sql = "select * from tbmedico";
    		PreparedStatement statement = conexao.prepareStatement(sql);
    		
    		rs = statement.executeQuery();
    		
    		while(rs.next()) {
    			Medico medico = new Medico();
    			medico.setIdmedico(rs.getInt("idmedico"));
    			medico.setNome(rs.getString("nome"));
    			medico.setCrm(rs.getString("crm"));
    			medico.setEspecialidade(rs.getString("especialidade"));
    			
    			listamedicos.add(medico);
    			   			
    		}
    		conexao.close();
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
		return listamedicos;
    	
    }
    
    public void Inserircliente (Cliente cliente) {
    	try {
		conexao = ModuloConexao.conector();
		
		String sql = "Insert into tbcliente (idcliente,nome, endereco, email, fone, login, senha) values(?,?,?,?,?,?,?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setInt(1, cliente.getIdcliente());
		statement.setString(2, cliente.getNome());
		statement.setString(3, cliente.getEndereco());
		statement.setString(4, cliente.getEmail());
		statement.setString(5, cliente.getFone());
		statement.setString(6, cliente.getLogin());
		statement.setString(7, cliente.getSenha());
		
		statement.execute();
		conexao.close();
		System.out.println("Cliente cadastrado com sucesso");
		
	}catch (Exception e) {
		e.printStackTrace();
	}
 }
    
    public void Removercliente (int idcliente) {
    	try {
    		conexao = ModuloConexao.conector();
    		
    		String sql = "delete from tbcliente  where idcliente = ?";
    		PreparedStatement statement = conexao.prepareStatement(sql);
    		statement.setInt(1, idcliente);
    		
    		statement.execute();
    		statement.close();
    		System.out.println("Cliente removido com sucesso");
    	}catch (Exception e) {
    		e.printStackTrace();
    		
    	}
    }
    
    public List<Cliente> Listarclientes(){
    	List<Cliente> listaclientes = new ArrayList<Cliente>();
    	try {
    		conexao = ModuloConexao.conector();
    		
    		String sql = "select * from tbcliente";
    		PreparedStatement statement = conexao.prepareStatement(sql);
    		
    		rs = statement.executeQuery();
    		
    		while(rs.next()) {
    			Cliente cliente = new Cliente();
    			cliente.setIdcliente(rs.getInt("idcliente"));
    			cliente.setNome(rs.getString("nome"));
    			cliente.setFone(rs.getString("fone"));
    			cliente.setEmail(rs.getString("email"));
    			    			   			
    			listaclientes.add(cliente);
    			   			
    		}
    		conexao.close();
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
		return listaclientes;
    	
    }



public void Agendarconsulta (Agenda agendamento) {
	try {
	conexao = ModuloConexao.conector();
	
	String sql = "Insert into tbagenda (idagenda, idcliente,idmedico, data, turnoa) values(?,?,?,?,?)";
	
	PreparedStatement statement = conexao.prepareStatement(sql);
	
	statement.setInt(1, agendamento.getIdagenda());
	statement.setInt(2,agendamento.getIdcliente());
	statement.setInt(3, agendamento.getIdmedico());
	statement.setDate(4,(Date) agendamento.getData());
	statement.setString(5, agendamento.getTurno());
	
	
	statement.execute();
	conexao.close();
	System.out.println("Cliente cadastrado com sucesso");
	
}catch (Exception e) {
	e.printStackTrace();
}
}

public void Removerconsulta (int idagenda) {
	try {
		conexao = ModuloConexao.conector();
		
		String sql = "delete from tbagenda  where idagenda = ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idagenda);
		
		statement.execute();
		statement.close();
		System.out.println("Consulta removida com sucesso");
	}catch (Exception e) {
		e.printStackTrace();
		
	}
}

public List<Agenda> Listarconsulta(){
	List<Agenda> listaconsulta = new ArrayList<Agenda>();
	try {
		conexao = ModuloConexao.conector();
		
		String sql = "select * from tbagenda";
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		rs = statement.executeQuery();
		
		while(rs.next()) {
			Agenda consulta = new Agenda();
			consulta.setIdagenda(rs.getInt("idagenda"));
			consulta.setIdcliente(rs.getInt("idcliente"));
			consulta.setIdmedico(rs.getInt("idmedico"));
			consulta.setData(rs.getDate("data"));
			consulta.setTurno(rs.getString("turno"));
			
			
			listaconsulta.add(consulta);
			   			
		}
		conexao.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return listaconsulta;

}
}
