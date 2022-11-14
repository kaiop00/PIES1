package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB1 {

	private static Connection con = null;

	static
	{
		String url = "jdbc:postgresql://localhost:5433/imobiliariaDb";
		String user = "postgres";
		String pass = "1010";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			if(con != null) {
				System.out.println("Connected to PostegreSQL server successfuly!");
			}else {
				System.out.println("Failed to connect PostgreSQL server");
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}

