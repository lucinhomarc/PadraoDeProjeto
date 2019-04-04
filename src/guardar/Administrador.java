package guardar;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import agenda.ModuloConexao;


public class Administrador {
	
	Connection conexao = null; //usando a variavel criada no modulo de conexão
    PreparedStatement pst = null; //conjunto de biblioteca sql
    ResultSet rs = null;
    
    public void Logar() {
    	conexao = ModuloConexao.conector();
    	
    }
    
    public void Con (String nome, String crm, String especialidade, String fone, String login, String senha){
        String sql = "Insert into tbmedico (nome, crm, especialidade, fone, login, senha) values(?,?,?,?,?,?)";
        try{
            //as linhas abaixo preparam a consulta ao banco de dados em função do que foi digitado nas caixas de textos
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, crm);
            pst.setString(3, especialidade);
            pst.setString(4, fone);
            pst.setString(5, login);
            pst.setString(6, senha);
            
            
            //a linha abaixo executa a query
            pst.executeUpdate();
            
            //se existir usuário e senha correspondente
            if(rs.next()){
            	System.out.println("Medico Cadastrado com Sucesso ");
                
            }else{
                
                System.out.println("Médico Não cadastrado");
            }
        } catch (Exception e){
            System.out.println(e);
            
        }
        
    }
    

}


	
	/*Medico medico = new Medico();
	ControleMedico control = new ControleMedico();
	ModuloConexao conex = new ModuloConexao();
	
	public void cadMedico() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o nome do médico");
		String nome = in.nextLine();
		System.out.println("Digite a especialidade");
		String especialidade = in.nextLine();
		System.out.println("Digite o telefone");
		String telefone = in.nextLine();
		System.out.println("Digite o login");
		String login = in.nextLine();
		System.out.println("Digite a senha");
		String senha = in.nextLine();
		System.out.println("Digite o CRM");
		int crm = in.nextInt();
	
		
			medico.setNome(nome);
			medico.setEspecialidade(especialidade);
			medico.setFone(telefone);
			medico.setLogin(login);
			medico.setSenha(senha);
			medico.setCrm(crm);
		
			control.Salvar(medico);
		}
		
	}*/
	


