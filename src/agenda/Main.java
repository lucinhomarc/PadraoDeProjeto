package agenda;
import java.util.Scanner;

public class Main {
	
		
	

	public static void main(String[] args) {
		Logar conectar = new Logar();
		conectar.Con("lucinho", "12345");
		
		/*Scanner in = new Scanner(System.in);

		System.out.println("Digite o nome do médico ");
		String nome = in.nextLine();
		System.out.println("Digite o CRM");
		String crm = in.nextLine();
		System.out.println("Digite a especialidade ");
		String especialidade = in.nextLine();
		System.out.println("Digite o telefone ");
		String fone = in.nextLine();
		System.out.println("Digite o login ");
		String login = in.nextLine();
		System.out.println("Digite a senha ");
		String senha = in.nextLine();
		System.out.println("Digite o id do médico ");
		int idmedico = in.nextInt();
		*/
		
		Medico med = new Medico();
		/*med.setIdmedico(idmedico);
		med.setNome(nome);
		med.setCrm(crm);
		med.setEspecialidade(especialidade);
		med.setFone(fone);
		med.setLogin(login);
		med.setSenha(senha);*/
		Administrador admin = new Administrador();
		// admin.Inserirmedico(med);
		
		admin.Removermedico(4); //para remover
		
		
		
		
		

	}

}
