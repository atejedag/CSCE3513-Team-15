// Author: Team 15
// Date: Spring 2022
// Purpose: Database connection component of Software Engineering project

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConnection
{	
	// Establish connection to Heroku database
	public static Connection getConnection() throws URISyntaxException, SQLException
	{
		String connectionURL = "jdbc:postgresql://ec2-34-233-157-189.compute-1.amazonaws.com:5432/dbp116s5ic1ca2?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require";
		String user = "retgdwrxmvayin";
		String password = "fdf97256207ac653da12e8075789c85ecefbae45d6dca81cfe2af8029665cfff";
		
		return DriverManager.getConnection(connectionURL, user, password);
	}
	
	// Insert players into database
	public void insertPlayers(ArrayList<Player> players, Connection conn)
	{
		String SQL = "INSERT INTO player(id, first_name, last_name, codename) VALUES(?,?,?,?)";
		String createTable = "CREATE TABLE player (id INT, first_name VARCHAR(30), last_name VARCHAR(30), codename VARCHAR(30))";
		String dropIfExists = "DROP TABLE IF EXISTS player";
		
		// Create table
		try{
			Statement statement = conn.createStatement();
			statement.executeUpdate(dropIfExists);
			statement.executeUpdate(createTable);
			statement.close();
		}
		catch(SQLException ex){
			System.out.println("Failed to create table in database");
			System.out.println(ex.getMessage());
		}
		
		// Insert players
		try{
			PreparedStatement statement = conn.prepareStatement(SQL);
			for(int i = 0; i < players.size(); i++)
			{
				Player n = players.get(i);
				statement.setInt(1, n.getID());
				statement.setString(2, n.getFirst());
				statement.setString(3, n.getLast());
				statement.setString(4, n.getCode());
				statement.addBatch();
			}
		
			statement.executeBatch();
			System.out.println("Successfully inserted players into database");
		}
		catch(SQLException ex) {
			System.out.println("Failed to insert players into database");
			System.out.println(ex.getMessage());
		}
	}
}