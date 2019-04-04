package controle;

import java.sql.*;

import javax.swing.JOptionPane;

public class ModuloConexao {
	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://localhost:3306/dbclinica";
	private String user = "root";
	private String password = "";
	public Connection con;
	
	public void conexao() {
		try {
			System.setProperty("jdbc.Drivers", driver);
			con = DriverManager.getConnection(url, user, password);
			JOptionPane.showMessageDialog(null, "Conectado");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Não Conectado" + ex.getMessage());
			
		}
	}
		
		public void desconecta() {
			try {
				con.close();
				JOptionPane.showMessageDialog(null, "Desconectado do Banco de Dados");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Banco de Dados não desconectado" + ex.getMessage());;
			}
		
		
		
		
	}

}
