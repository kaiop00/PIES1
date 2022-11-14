package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private final String url = "jdbc:postgresql://localhost:5433/imobiliariaDb";
	private final String user = "postgres";
	private final String password = "1010";
	
	private void connect() {
		try (
				Connection connection = DriverManager.getConnection(url,user,password);
		){
			if(connection != null) {
				System.out.println("Connected to PostegreSQL server successfuly!");
			}else {
				System.out.println("Failed to connect PostgreSQL server");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConnectionDB sqlConnection = new ConnectionDB();
		sqlConnection.connect();
	}
}