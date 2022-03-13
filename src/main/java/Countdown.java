// Author: Team 15
// Date: Spring 2022
// Purpose: Countdown component of Software Engineering project

import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JLabel;

public class Countdown {
	Timer timer = new Timer();
	public Countdown(){
		
	}
	
	public void time(int N, JLabel J){ // N seconds, J for JLabel that's modified
		timer.scheduleAtFixedRate(new TimerTask(){
			int i = N; // set time
			public void run() {
				if(i > 360)
					J.setText("GAME STARTS IN " + (i - 360) + " SECONDS!");
				else
					J.setText("Seconds Remaining: "+ i);
				//System.out.println(i);
				i--;

				if(i < 0) {
					timer.cancel(); // stops timer
					J.setText("Timer: 0"); // Set message to something else after
					//jlabel.setVisible(false); // option to remove timer as well
				}
			}	
				
		}, 0, 1000); 
		
	}
	
	
	
}