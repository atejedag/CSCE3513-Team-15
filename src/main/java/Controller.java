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
	boolean f5 = false;
	
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
	public void keyPressed(KeyEvent e) {
		String s = e.toString();//Because VK_F5 just doesn't want to work. All F1-12 print out as 0 if trying to use e.getKeyCode() and e.getCode() doesn't seem to exist, so this was the only way I found to get it to read F5 correctly.
		s = s.substring(s.indexOf("rawCode="));
		s = s.substring(8, s.indexOf(","));
		//System.out.println(s);
		if(s.equals("179"))
		{
//			System.out.println("f5 is pressed.");
			view.actionDisplayGUI();
		}
		
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	// Method to update controller (for handling input)
	void update()
	{
	}
}
