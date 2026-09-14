import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{

	private static final String URL = "jdbc:postgresql://localhost:5432/internship_management";
	private static final String USER = "ashfaq";
	private static final String PASSWORD = "ashfaq123";
	
	public static Connection getConnection() throws SQLException{
	 return DriverManager.getConnection(URL,USER,PASSWORD);
	}

public static void main(String [] args){
	
	try{
		Connection connection = getConnection();
		System.out.println("Database connected successfully!");
		connection.close();


	}catch(SQLException e){
		System.out.println("Database connection failed!");
		e.printStackTrace();

		}

}

}
