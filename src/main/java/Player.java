// Author: Team 15
// Date: Spring 2022
// Purpose: Player object component of Software Engineering project

class Player
{
	// Class members
	int id;
	String first_name;
	String last_name;
	String code_name;
	
	// Constructor
	Player(int ID, String first, String last, String code)
	{
		id = ID;
		first_name = first;
		last_name = last;
		code_name = code;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getFirst()
	{
		return first_name;
	}
	
	public String getLast()
	{
		return last_name;
	}
	
	public String getCode()
	{
		return code_name;
	}
}
