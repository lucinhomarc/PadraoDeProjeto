package agenda;
import java.sql.*; 


public class Logar  {
	
	Connection conexao = null; //usando a variavel criada no modulo de conexão
    PreparedStatement pst = null; //conjunto de biblioteca sql
    ResultSet rs = null;
    
    public Logar() {
    	conexao = ModuloConexao.conector();
    	
    }
    
    public void Con (String nome, String senha){
        String sql = "select * from tbcliente where login=? and senha =?"; // o ? é substituido pelo conteúdo das variaveis
        try{
            //as linhas abaixo preparam a consulta ao banco de dados em função do que foi digitado nas caixas de textos
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            
            //a linha abaixo executa a query
            rs = pst.executeQuery();
            
            //se existir usuário e senha correspondente
            if(rs.next()){
            	System.out.println("conectado ao banco ");
                
            }else{
                
                System.out.println("usuário e/ou senha invalido(s)");
            }
        } catch (Exception e){
            System.out.println("erro nao sei");
            
        }
        
    }
    

}
