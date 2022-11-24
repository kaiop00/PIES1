package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.ConnectionDb;
import Models.Client;
import javafxmvc.model.dao.ClienteDAO;

public class ClientDAO {	
	static ConnectionDb db;
	
	public static List<Client> getAll() {
		String sql = "select * from \"Client\";";
		List<Client> retorno = new ArrayList<>();
		
		try {
			db = new ConnectionDb();
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			
			while(resultSet.next()) {
				Client client = new Client() ;
				client.setName(resultSet.getString("name"));
				client.setCpf(resultSet.getString("cpf"));
				client.setEmail(resultSet.getString("email"));
				client.setAdress(resultSet.getString("address"));
				client.setPhone(resultSet.getString("phone"));
				retorno.add(client);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
 	}
	
	public static boolean setClient(Client client) {
		try {
			db = new ConnectionDb();
			String sql = "insert into \"Client\" values ('" +
							 client.getName() + "','" + 
							 client.getCpf() +  "','" +
							 client.getEmail() +"','" +
							 client.getAddress()+"','" +
							 client.getPhone() +"');";
						 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateClient(Client client) {
		try {
			db = new ConnectionDb();
			String sql = "UPDATE \"Client\" SET name=?, cpf=?, email=?, Address=?, phone=? WHERE cpf=?";
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.setString(1, client.getName());
            st.setString(2, client.getCpf());
            st.setString(3, client.getEmail());
            st.setString(4, client.getAddress());
			st.setString(5, client.getPhone());
			st.setString(6, client.getCpf());
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public static void getClient(String cpf) {
		try {
			db = new ConnectionDb();
			String sql = "select * from \"Client\" where cpf='" + cpf + "';";
						 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 	public static boolean deleteClient(Client client) {
		try {
			db = new ConnectionDb();
			String sql = "delete from \"Client\" where cpf = '"+ client.getCpf() +"';";			 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}