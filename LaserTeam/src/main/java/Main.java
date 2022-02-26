import javax.swing.JFrame;
import java.awt.Toolkit;

public class Main extends JFrame
{
	//Controller controller;
	
	public Main()
	{		
		//controller = new Controller();
		this.setTitle("Team 15 project");
		
		this.setSize(500, 500);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.addKeyListener(controller);
	}

	
	
	public void run()
{
	
	while(true)
	{
		//controller.update();		
		Toolkit.getDefaultToolkit().sync(); // Updates screen

		// Go to sleep for 50 miliseconds
		try
		{
			Thread.sleep(50);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	
	}
}

public static void main(String[] args)
	{
		Main m = new Main();
		m.run();
	}
}
