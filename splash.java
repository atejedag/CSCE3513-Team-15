// Author: Team 15
// Date: Spring 2022
// Purpose: SplashScreen component of Software Engineering project
// Notes:	Draws image on screen using JWindow in seperate window
//			Can just be called before main loop and just set the thread.sleep to how ever long you want 

import javax.swing.*;
import java.awt.*;

public class Splash extends JWindow 
{
	Image splashImage;
	ImageIcon imageIcon;
	
	public Splash()
	{
		splashImage = Toolkit.getDefaultToolkit().getImage("splashScreen.jpg"); // get image
		
		// Call imageIcon class to easily get width/height
		imageIcon = new ImageIcon(splashImage); 
		
		// Set size of the window to match image size
		setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());

		// Get screen size to get x and y coordinates so that it centers on screen correctly
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width-getSize().width)/2;
		int y = (screenSize.height-getSize().height)/2;

		// Set screen location 
		setLocation(x,y);
		setVisible(true);
	}
	
	// Draw image
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.drawImage(splashImage, 0, 0, this);
	}
}