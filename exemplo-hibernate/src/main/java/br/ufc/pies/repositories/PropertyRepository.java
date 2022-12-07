package br.ufc.pies.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufc.pies.model.Client;
import br.ufc.pies.model.Property;

public class PropertyRepository {

	private EntityManager manager;
	
	public PropertyRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void insert(Property property) {
		this.manager.getTransaction().begin();
		
		manager.persist(property);
		
		manager.getTransaction().commit();
		
		System.out.println("Property ID: "	+	property.getId());
	}

	public Property findById(int id) {
		// TODO Auto-generated method stub
		Query query = this.manager.createQuery("from Property p where p.id = :id ");
		query.setParameter("id", id);
		Property property = (Property) query.getSingleResult();
		
		return property;
	}
		
	public List<Property> getAll() {
		List<Property> properties = this.manager.createQuery("SELECT p FROM Property p", Property.class).getResultList();
		return properties;
	}
	
	
	public boolean remove(int id) {
		this.manager.getTransaction().begin();
				
		Query query = this.manager.createQuery("delete Property where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		
		this.manager.getTransaction().commit();

		return result > 0;
	}
	
	public void update(int id, Property prop) {
		this.manager.getTransaction().begin();
		
		Query query = this.manager.createQuery("from Property p where p.id = :id ");
		query.setParameter("id", id);
		
		Property property = (Property) query.getResultList().get(0);
		
		property.setAddress(prop.getAddress());
		property.setArea(prop.getArea());
		property.setHasGarage(prop.hasGarage());
		property.setIsLocate(prop.isLocate());
		property.setValue(prop.getValue());
		property.setRooms(prop.getRooms());
		
		this.manager.merge(property);
		
		this.manager.getTransaction().commit();
		
	}
	
	public void setPropertyClient(int id, Client client) {
		this.manager.getTransaction().begin();
		
		Query query = this.manager.createQuery("from Property p where p.id = :id ");
		query.setParameter("id", id);
		
		Property property = (Property) query.getResultList().get(0);
		property.setIsLocate(true);
		property.setClient(client);
		
		this.manager.merge(property);
		
		manager.getTransaction().commit();
	}
	
	public Client getCurrentPropertyClient(int id) {
		Query query = this.manager.createQuery("select c from Client c left join Property p on c.id = p.client and p.id = :id");
		query.setParameter("id", id);
		System.out.println(query.getResultList());
		Client client = (Client) query.getResultList().get(0);
		return client;
	}
	
}
