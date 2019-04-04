package agenda;

import java.sql.*;

public class ModuloConexao {
	
	public static Connection conector() { // Connection é uma funcionalidade do pacote java.sql e conector é o nome do meu método
		java.sql.Connection conexao = null;// criando a variavel conexao que vai receber a string de conexao
		
		// a linha abaixo chama o driver importado para a biblioteca
		String driver = "com.mysql.jdbc.Driver";
		
		//armazenando informações referente ao banco
		String url ="jdbc:mysql://localhost:3306/dbclinica";
		String user = "root";
		String password = "";
		
		//estabelecendo a conexão do banco
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
			
		} catch  (Exception e) {
			System.out.println(e);//mensagem de erro de conexão
			return null;
			// TODO: handle exception
		}
	}
    
}

