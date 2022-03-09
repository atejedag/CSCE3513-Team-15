// Author: Team 15
// Date: Spring 2022
// Purpose: Model component of Software Engineering project
// Notes:	Contains information about the laser tag system

import java.util.ArrayList;
import java.sql.Connection;

class Model
{
	// Class members
	ArrayList<Player> players;
	DatabaseConnection dbc;
	Connection conn;
	
	// Constructor
	Model(DatabaseConnection DBC)
	{
		players = new ArrayList<Player>();
		dbc = DBC;
	}
	
	// Method to add player object to list
	public void addPlayer(int id, String firstname, String lastname, String codename)
	{
		Player p = new Player(id, firstname, lastname, codename);
		players.add(p);
		
		// Testing contents
		//for(int i = 0; i < players.size(); i++)
		//{
		//	Player n = players.get(i);
		//	System.out.println(n.first_name);
		//}
	}
	
	// Set database connection
	public void setConnection(Connection CONN)
	{
		conn = CONN;
	}
	
	// Call DatabaseConnection method to insert players into database
	public void modelPlayersInsert()
	{
		dbc.insertPlayers(players, conn);
		//players.clear();
	}
	
	// Method to update model 
	public void update()
	{
		
	}
}
