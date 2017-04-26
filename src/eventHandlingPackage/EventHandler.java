package eventHandlingPackage;

import java.awt.FlowLayout;				// imports layout
import java.awt.event.ActionListener;	// imports action listener
import java.awt.event.ActionEvent;		// imports types of events (clicks, hovers, enter, etc)

import javax.swing.JFrame;				// imports a customizable window
import javax.swing.JTextField;			// a generic text field
import javax.swing.JPasswordField;		// text field representing characters as asterisks
import javax.swing.JOptionPane;			// imports display window
import javax.swing.JButton;				// imports a customizable button
import javax.swing.Icon;				// imports an icon
import javax.swing.ImageIcon;			// imports an image



public class EventHandler extends JFrame{
	
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordField;
	
	private JButton button1;
	private JButton imageButton;
	
// CONSTRUCTOR =======================================
	
	public EventHandler(){
		super("Window Title");						// create window title
		setLayout(new FlowLayout());				// creates layout
		
		item1 = new JTextField(10);					// length of JTextField is 10
		add(item1);									// adds item to window
	
		item2 = new JTextField("Enter text here");	// placeholder default text
		add(item2);
		
		item3 = new JTextField("Cannot edit", 20);	// placeholder text with length 20
		item3.setEditable(false);					// users cannot edit this field
		add(item3);
		
		passwordField = new JPasswordField("password");	// "password" appears in asterisks
		add(passwordField);
		
		button1 = new JButton("Normal Button");			// create a simple button with text
		add(button1);
		
		
		String path1 = "C:\\Users\\gnguy\\Desktop\\Java\\EventHandling\\src\\eventHandlingPackage\\icon1.png";
		String path2 = "C:\\Users\\gnguy\\Desktop\\Java\\EventHandling\\src\\eventHandlingPackage\\icon2.png";
		
		Icon icon1 = new ImageIcon(path1);			// import icon1
		Icon icon2 = new ImageIcon(path2);			// import icon2
		imageButton = new JButton("Image Button", icon1);			// create button with icon1 as image
		
		imageButton.setRolloverIcon(icon2);			// set icon2 to appear on hover
		add(imageButton);
		
		// Declare myHandler object before creating the myHandler class
		myHandler eventHandler = new myHandler();
		item1.addActionListener(eventHandler);
		item2.addActionListener(eventHandler);
		item3.addActionListener(eventHandler);
		passwordField.addActionListener(eventHandler);	
		
		button1.addActionListener(eventHandler);
		imageButton.addActionListener(eventHandler);
		
	} // End of EventHandler Constructor
	
	
// EVENT HANDLING CLASS WITHIN CLASS ============================================
	// class inherits from outside class
	
	private class myHandler implements ActionListener{
		
		/**
		 *  Standard built-in method actionPerformed MUST BE INCLUDED.
		 *	 	- this IS the event handler.
		 *		- is automatically executed whenever an event occurs
		 *
		 *  fieldString is an empty string used to output what the user inputs.
		 *  
		 *  if(event.getSource()==item1) tells the program to listen for input entered into item1.
		 *  fieldString = String.format... change fieldString to whatever was inputted.
		 *  
		 *  JOptionPane.showMessageDialog(null, fieldString);
		 *  	- null centers the window on the screen
		 *  	- displays fieldString
		 */
		public void actionPerformed(ActionEvent event){		
			
			String fieldString = "";						
			
			if(event.getSource()==item1){
				fieldString = String.format("field 1: %s", event.getActionCommand());
			} 
			else if (event.getSource()==item2){
				fieldString = String.format("field 2: %s", event.getActionCommand());
			}
			else if (event.getSource()==item3){
				fieldString = String.format("field 3: %s", event.getActionCommand());
			}
			else if (event.getSource()==passwordField){
				fieldString = String.format("password field is : %s", event.getActionCommand());
			}
			
			else if (event.getSource()==button1){
				fieldString = String.format("You clicked %s!", event.getActionCommand());
			}
			else if (event.getSource()==imageButton){
				fieldString = String.format("You clicked %s!", event.getActionCommand());
			}
			JOptionPane.showMessageDialog(null, fieldString);
		}
	}
}










