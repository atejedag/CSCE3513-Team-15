// Author: Team 15
// Date: Spring 2022
// Purpose: Model component of Software Engineering project
// Notes:	Contains information about the laser tag system

import java.util.ArrayList;

class Model
{
	// Class members
	ArrayList<Player> players;
	
	// Constructor
	Model()
	{
		players = new ArrayList<Player>();
// Test Players
		/*
		Player p1 = new Player(1, "John", "Doe", "1");
		players.add(p1);
		Player p2 = new Player(2, "John", "Doe", "2");
		players.add(p2);
		Player p3 = new Player(3, "John", "Doe", "3");
		players.add(p3);
		Player p4 = new Player(4, "John", "Doe", "4");
		players.add(p4);
		Player p5 = new Player(5, "John", "Doe", "5");
		players.add(p5);
		Player p6 = new Player(6, "John", "Doe", "6");
		players.add(p6);
		Player p7 = new Player(7, "John", "Doe", "7");
		players.add(p7);
		Player p8 = new Player(8, "John", "Doe", "8");
		players.add(p8);
		Player p9 = new Player(9, "John", "Doe", "9");
		players.add(p9);
		Player p10 = new Player(10, "John", "Doe", "10");
		players.add(p10);
		Player p11 = new Player(11, "John", "Doe", "11");
		players.add(p11);
		Player p12 = new Player(12, "John", "Doe", "12");
		players.add(p12);
		Player p13 = new Player(13, "John", "Doe", "13");
		players.add(p13);
		Player p14 = new Player(14, "John", "Doe", "14");
		players.add(p14);
		Player p15 = new Player(15, "John", "Doe", "15");
		players.add(p15);
		Player p16 = new Player(16, "John", "Doe", "16");
		players.add(p16);
		*/
	}
	
	// Method to add player object to list
	public void addPlayer(int id, String firstname, String lastname, String codename)
	{
		Player p = new Player(id, firstname, lastname, codename);
		players.add(p);
		
		// Testing contents
		/*
		for(int i = 0; i < players.size(); i++)
		{
			Player n = players.get(i);
			System.out.println(n.first_name);
		}
		*/
	}
	
	// Method to update model 
	public void update()
	{
		
	}
}
