package eventHandlingPackage;

import javax.swing.JFrame;

public class MainActivity {

	public static void main(String[] args) {
		
		EventHandler window = new EventHandler();				// creates an EventHandler object window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// makes the program exit when clicking [x]
		window.setSize(300, 400);								// sets window size
		window.setVisible(true);								// makes window visible on screen

	}

}
