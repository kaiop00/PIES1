package br.ufc.pies.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufc.pies.model.Client;

public class ClientRepository {

	private EntityManager manager;
	
	public ClientRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void insert(Client client) {
		this.manager.getTransaction().begin();
		
		manager.persist(client);
		
		manager.getTransaction().commit();
		
		System.out.println("Client ID: "	+	client.getId());
	}

	public Client findByEmail(String email) {
		// TODO Auto-generated method stub
		Query query = this.manager.createQuery("from Client c where c.email = :email ");
		query.setParameter("email", email);
		Client client = (Client) query.getSingleResult();
		
		return client;
	}
	
	public Client findByCpf(String cpf) {
		// TODO Auto-generated method stub
		Query query = this.manager.createQuery("from Client c where c.cpf = :cpf ");
		query.setParameter("cpf", cpf);
		Client client = (Client) query.getSingleResult();

		return client;
	}
	
	public List<Client> getAll() {
		List<Client> clients = this.manager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
		this.manager.close();
		return clients;
	}
	
	public boolean remove(String cpf) {
		this.manager.getTransaction().begin();
				
		Query query = this.manager.createQuery("delete Client where cpf = :cpf");
		query.setParameter("cpf", cpf);
		int result = query.executeUpdate();
		
		manager.getTransaction().commit();

		return result > 0;
	}
	
	public void update(String cpf, Client newClient) {
		this.manager.getTransaction().begin();
		
		Query query = this.manager.createQuery("from Client c where c.cpf = :cpf ");
		query.setParameter("cpf", cpf);
		
		Client client = (Client) query.getResultList().get(0);
		
		client.setName(newClient.getName());
		client.setEmail(newClient.getEmail());
		client.setAddress(newClient.getAddress());
		client.setCpf(newClient.getCpf());
		
		this.manager.merge(client);
		
		this.manager.getTransaction().commit();
		
	}
	
}
