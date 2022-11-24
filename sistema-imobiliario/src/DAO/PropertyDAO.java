package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Database.ConnectionDb;
import Models.Property;


public class PropertyDAO {
	
	static ConnectionDb db;
		
	public static List<Property> getAll() {
		String sql = "select * from \"Property\";";
		List<Property> retorno = new ArrayList<>();
		
		try {
			db = new ConnectionDb();
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			
			while(resultSet.next()) {
				Property imovel = new Property() ;
				imovel.setId(resultSet.getString("id"));
				imovel.setAddress(resultSet.getString("address"));
				imovel.setArea(resultSet.getString("area"));
				imovel.setRoom(resultSet.getString("room"));
				imovel.setGarage(resultSet.getString("garage"));
				imovel.setValue(resultSet.getString("value"));
				imovel.setIsLocate(resultSet.getString("islocate"));
				retorno.add(imovel);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
 	}
	
	public static boolean setProperty(Property imovel) {
		try {
			db = new ConnectionDb();
			String sql = "insert into \"Property\" (id,address,area,room,garage,value,islocate) values (?,?,?,?,?,?,?);";
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.setString(1, imovel.getId());
			st.setString(2, imovel.getAddress());
			st.setString(3, imovel.getArea());
			st.setString(4,imovel.getRoom());
			st.setString(5, imovel.getGarage());
			st.setString(6, imovel.getValue());
			st.setString(7, imovel.getIsLocate());						 
			st.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		
	public static boolean updateProperty(Property imovel) {
		try {
			db = new ConnectionDb();
			String sql = "UPDATE \"Property\" SET id=?, address=?, area=?, room=?, garage=?, value=?, islocate=? WHERE id=?";
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.setString(1, imovel.getId());
			st.setString(2, imovel.getAddress());
			st.setString(3, imovel.getArea());
			st.setString(4, imovel.getRoom());
			st.setString(5, imovel.getGarage());
			st.setString(6, imovel.getValue());
			st.setString(7, imovel.getIsLocate());
			st.setString(8, imovel.getId());
			
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		}
		
	public static void getProperty(String id) {
		try {
			db = new ConnectionDb();
			String sql = "select * from \"Property\" where id=?;";
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.setString(1, id);
			st.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
 	public static boolean deleteProperty(Property imovel) {
		try {
			db = new ConnectionDb();
			String sql = "delete from \"Property\" where id =? ;";			 
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			st.setString(1, imovel.getId());
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
