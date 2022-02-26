import javax.swing.*;
import java.awt.*;

// Draws image on screen using JWindow in seperate window
// Can just be called before main loop and just set the thread.sleep to how ever long you want
// Example test run at bottom           

public class splash extends JWindow {
	Image splash;
	ImageIcon imageIcon;
	public splash(){
		splash = Toolkit.getDefaultToolkit().getImage("splashScreen.jpg"); // gets image
		
		// calls imageIcon class to easily get it's width/height
		imageIcon = new ImageIcon(splash); 
		
		// set size of the window to match image size
		setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());

		// get screensize to get x and y coordinates so that it centers on screen correctly
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width-getSize().width)/2;
		int y = (screenSize.height-getSize().height)/2;

		// set the location and 
		setLocation(x,y);
		setVisible(true);

	}
	
	// draw image
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(splash, 0, 0, this);
	}

	// test run/example of how it should be coded into main i guess
	/*
	public static void main(String[] args) {
		splash splashScreen = new splash();
		try {
			Thread.sleep(5000); // wait 5 seconds
			splashScreen.dispose(); // releases all resources and stops displaying
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
