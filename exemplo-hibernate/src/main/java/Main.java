import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.pies.model.Client;
import br.ufc.pies.model.Property;
import br.ufc.pies.model.User;
import br.ufc.pies.repositories.ClientRepository;
import br.ufc.pies.repositories.PropertyRepository;

public class Main {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExampleDatabase");
	private static EntityManager manager = emf.createEntityManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientRepository repo = new ClientRepository(manager);
		PropertyRepository propRepo = new PropertyRepository(manager);
		//propRepo.insert(new Property(4f, 4, "rua rua", false, 2000f, false));

//		repo.insert(new Client("Client A", "000.000.000-01", "cli_a@email.com", "Str 1", "88993239301"));
//		repo.insert(new Client("Client B", "000.000.000-02", "cli_b@email.com", "Str 2", "88993239302"));

		Client targetClient = repo.findByEmail("cli_a@email.com");	
		Property target = propRepo.findById(1);
//	 
//		
		
		 propRepo.setPropertyClient(target.getId(), targetClient);
				
//		List<Property> props = propRepo.getAll();
//		for(Property prop : props) {
//			System.out.println("PROP AREA: " + prop.getArea());
//		}
//		
//		Client currentPropertyClient = propRepo.getCurrentPropertyClient(1);
//		System.out.println("O CLIENTE �: " + currentPropertyClient.getName());
//		
////		propRepo.remove(2);
////		props = propRepo.getAll();
////		for(Property prop : props) {
////			System.out.println("PROP AREA: " + prop.getArea());
////		}
//		
////		target.setRooms(3);
////		target.setHasGarage(false);
////		propRepo.update(target.getId(), target);

		
		manager.close();
	}

	public static void insert() {
//		User user = new User();
//		user.setEmail("email@email.com");
//		user.setAdmin(true);
//		user.setPassword("123456");
//		
//		manager.getTransaction().begin();
//		
//		manager.persist(user);
//		
//		manager.getTransaction().commit();
//		
//		System.out.println("ID criado do Usu�rio: "	+	user.getId());
	}
	
	public static void findUser(Long id) {
		User user = manager.find(User.class, id);
		System.out.println("Usuario encontrado: " + user.getEmail() + " " + user.getId());
	}
	
	public static void findUserByIdAndDelete(Long id) {
		User user = manager.find(User.class, id);
		manager.getTransaction().begin();
		manager.remove(user);
		manager.getTransaction().commit();
		System.out.println("Usuario removido com sucesso!");
	}
	
	public static void findUserByIdAndUpdate(Long id, User newUserData) {
		User user = manager.find(User.class, id);
		user.setEmail(newUserData.getEmail());
		user.setPassword(newUserData.getPassword());
		
		manager.getTransaction().begin();
		
		manager.merge(user);
		
		manager.getTransaction().commit();
		System.out.println("Usuario atualizado com sucesso!");

	}

}
