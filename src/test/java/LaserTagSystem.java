// Author: Team 15
// Date: Spring 2022
// Purpose: Main file of Software Engineering project

import javax.swing.JFrame;
import java.awt.Toolkit;

public class LaserTagSystem extends JFrame
{
	// Class members
	Model model = new Model();
	Controller controller = new Controller(model);
	View view = new View(controller, model);
	
	// Constructor
	public LaserTagSystem()
	{		
		this.setTitle("Team 15 Project");
		this.setSize(700, 700);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // center frame on screen
		this.addKeyListener(controller);
	}
	
	// Method to run and update laser tag system
	public void run()
	{
		while(true)
		{
			controller.update();	
			model.update();
			view.repaint();
			Toolkit.getDefaultToolkit().sync(); // update screen

			// Go to sleep for 50 milliseconds
			try
			{
				Thread.sleep(50);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	// Main function
	public static void main(String[] args)
	{
		// Display splash screen 
		Splash splashScreen = new Splash();
		try {
			Thread.sleep(3000); // wait 3 seconds
			splashScreen.dispose(); // release all resources and stop displaying
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Run program
		LaserTagSystem s = new LaserTagSystem();
		s.run();
	}
}
