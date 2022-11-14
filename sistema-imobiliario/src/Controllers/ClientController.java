package Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.ConnectionDB1;

public class ClientController {
	
	static ConnectionDB1 db;
	
	public static void getAll() {
		try {
			db = new ConnectionDB1();
			String sql = "select * from \"Client\";";
			PreparedStatement st = db.getConnection().prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			System.out.println(resultSet);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "
						+resultSet.getString(3)+" "+resultSet.getString(4)+" "
						+resultSet.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
