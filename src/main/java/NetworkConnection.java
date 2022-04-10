// Author: Team 15
// Date: Spring 2022
// Purpose: Network connection component of Software Engineering project

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkConnection
{
	DatagramSocket ds;
	InetAddress ip;
	public NetworkConnection() throws SocketException, UnknownHostException
	{
		// Create a socket to listen for traffic
		ds = new DatagramSocket();
		ip = InetAddress.getLocalHost();
		
		byte[] receive = new byte[65535];
		DatagramPacket DpReceive = null;
		
	}
	
	// Call this method in the LaserTagSystem run method to listen for traffic.
	//		* It's possible the "go to sleep component" of the run loop might interfere with the reception of 
	//		traffic. If that happens, we might either remove that component or add a new method with a while 
	// 		loop to call the method. 
	public void receiveTraffic()	// might need to throw IOException
	{
		// Create a DatagramPacket to receive data
		DpReceive = new DatagramPacket(receive, receive.length);
		
		ds.receive(DpReceive);
		System.out.println("Client:-"+data(receive));
		// Receive DatagramPacket in socket
		//		This is where we will probably DO something with the transmission.
		//		The data method below can be used to convert the packet into string format.
		//		Depending on what the traffic generator does, this could be used to either
		//			print messages to the screen/console, or something more advanced, like altering
		// 			player statistics. The second possibility seems more difficult and would likely 
		//			require the string to be parsed into elements which would then be fed to the 
		//			list of players ~ probably with more Heroku shenanigans. OR, we could just send
		//			the information straight to some new JLabels next to the relevant player name.
		
		// Exit server if client sends "bye" message
		if (data(receive.toString().equals("bye"))
		{
	        	System.out.println("Client sent bye...exiting");
			// insert break?
		}
		// Clear the buffer
		receive = new byte[65535];
	}
	
	// Convert byte array data into string format
	public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		
		StringBuilder builder = new StringBuilder();
		
		// Read over array with while loop and add characters to builder
		int i = 0;
		while (a[i] != 0)
		{
			builder.append((char) a[i]);
			i++;
		}
		return builder;
	}
}
