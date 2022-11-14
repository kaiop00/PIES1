package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.ConnectionDb;

public class ClientDAO {	
	static ConnectionDb db;
	
	public static void getAll() {
		try {
			db = new ConnectionDb();
			String sql = "select * from \"Client\";";
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			System.out.println(resultSet);
			
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				String cpf = resultSet.getString("cpf");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				String phone = resultSet.getString("phone");
				System.out.println(name+ " | " + cpf + " | " + email + " | " + address + " | " + phone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setClient(String name, String cpf, String email, String address, String phone) {
		try {
			db = new ConnectionDb();
			String sql = "insert into \"Client\" values ('" +
							 name + "','" + 
							 cpf +  "','" +
							 email +"','" +
							 address+"','" +
							 phone +"');";
						 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateClient(String cpf, String field, String value) {
		try {
			db = new ConnectionDb();
			String sql = "Update \"Client\" set " + field  + " = '" + value + "' where cpf='"+ cpf + "';";
						 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getClient(String cpf) {
		try {
			db = new ConnectionDb();
			String sql = "select from \"Client\" where cpf='" + cpf + "';";
						 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 	public static void deleteClient(String cpf) {
		try {
			db = new ConnectionDb();
			String sql = "delete from \"Client\" where cpf = '"+cpf +"';";
						 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}