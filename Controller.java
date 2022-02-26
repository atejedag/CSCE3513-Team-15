// Author: Team 15
// Date: Spring 2022
// Purpose: Controller component of Software Engineering project

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements MouseListener, KeyListener
{
	// Class members
	View view;
	Model model; 
	
	// Constructor
	Controller(Model m)
	{
		model = m;
	}
	
	// Method to set view
	void setView(View v)
	{
		view = v;
	}
	
	// Methods for mouse and key events
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	// Method to update controller (for handling input)
	void update()
	{
		
	}
}