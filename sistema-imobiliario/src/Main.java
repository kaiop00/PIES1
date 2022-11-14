
//import java.lang.reflect.Array;
import java.util.Scanner;

import DAO.ClientDAO;
//import Database.ConnectionDb;
//import Models.Client;

public class Main {

//		Client cliente = new Client("Joao","0000000000","email@email.com","rua rua,123,centro,quixadá","(88)9555555");
//	
//		System.out.println(cliente);		
//		ClientDAO.setClient("Arya Stark","21111111111","arya@email.com","Rua rua, 323, Centro, Quixadá","55 55555-4444");
//		ClientDAO.getAll();
// 		ClientDAO.deleteClient("21111111111");
		
		public static void main(){
	        System.out.println("\n\tCadastro de clientes");
	        System.out.println("0. Sair");
	        System.out.println("1. Inclui");
	        System.out.println("2. Altera");
	        System.out.println("3. Exclui");
	        System.out.println("4. Consulta");
	        System.out.println("Opcao:");
	    }

	    public static void incluir(Scanner scan) {
	    	System.out.println("Digite os dados do cliente que deseja incluir\n( Na sequência: nome, cpf, email, endereço, telefone ): ");
        	String array[] = new String[5];

        	for(int i = 0; i < 5; i++) {
        		array[i] = scan.next();
        	}
        	for (String s : array) {
				System.out.printf(s + " | ");
			}
        	System.out.println("\n");
        	ClientDAO.setClient(array[0], array[1], array[2], array[3], array[4]);
            System.out.println("Cliente Inserido");
	    }
		
	    public static void alterar(Scanner scan) {
	    	System.out.println("Digite na sequencia o cpf, o campo e novo dado do campo que deseja alterar:");
        	String array[] = new String[5];
        	for(int i = 0; i < 3; i++) {
        		array[i] = scan.next();
        	}
        	for (String s : array) {
				System.out.printf(s + " | ");
			}
        	ClientDAO.updateClient(array[0],array[1],array[2]);
        	
        	System.out.println("Cliente alterado!");
	    }
	    
	    public static void deletar(Scanner scan) {
	      	System.out.println("Digite o CPF do cliente que deseja deletar: ");
        	String cpf = scan.next();
        	ClientDAO.deleteClient(cpf);	            	
            System.out.println("Cliente deletado!");
	    }

	    public static void consultar() {
	    	ClientDAO.getAll();
	    }
	    
	    public static void main(String[] args) {
	    	
	        int opcao;
	        Scanner entrada = new Scanner(System.in);
	        
	        do{
	            main();
	            opcao = entrada.nextInt();
	            
	            switch(opcao){
	            case 1:
	            	incluir(entrada);
	            	break;
	                
	            case 2:
	            	alterar(entrada);
	                break;
	                
	            case 3:
	            	deletar(entrada);
	                break;
	                
	            case 4:
	                consultar();
	                break;
	            
	            default:
	                System.out.println("Opção inválida.");
	            }
	        } while(opcao != 0);
	        entrada.close();
    }	
}
