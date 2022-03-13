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
				J.setText("Time: "+ i);
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