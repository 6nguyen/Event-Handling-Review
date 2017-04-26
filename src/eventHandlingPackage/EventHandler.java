package eventHandlingPackage;

import java.awt.FlowLayout;				// imports layout
import java.awt.Font;					// imports text fonts
import java.awt.event.ActionListener;	// imports action listener
import java.awt.event.ActionEvent;		// imports types of events (clicks, hovers, enter, etc)
import java.awt.event.ItemEvent;		// imports item type events
import java.awt.event.ItemListener;		// imports item listener
import java.awt.Insets;					// imports button margins

import javax.swing.JFrame;				// imports a customizable window
import javax.swing.JTextField;			// a generic text field
import javax.swing.JPasswordField;		// text field representing characters as asterisks
import javax.swing.JOptionPane;			// imports display window
import javax.swing.JButton;				// imports a customizable button
import javax.swing.Icon;				// imports an icon
import javax.swing.ImageIcon;			// imports an image
import javax.swing.JCheckBox;			// imports a check box



public class EventHandler extends JFrame{
	
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordField;
	
	private JButton button1;
	private JButton imageButton;
	
	private JTextField checkBoxText;
	private JCheckBox boldBox;
	private JCheckBox italicBox;
	
// CONSTRUCTOR =======================================
	
	public EventHandler(){
		
		super("Window Title");						// create window title
		setLayout(new FlowLayout());				// creates layout
		
		// TEXT FIELDS ==============================
		item1 = new JTextField(10);					// length of JTextField is 10
		add(item1);									// adds item to window
	
		item2 = new JTextField("Enter text here");	// placeholder default text
		add(item2);
		
		item3 = new JTextField("Cannot edit", 20);	// placeholder text with length 20
		item3.setEditable(false);					// users cannot edit this field
		add(item3);
		
		passwordField = new JPasswordField("password");	// "password" appears in asterisks
		add(passwordField);
		
		// BUTTONS ==================================
		
		button1 = new JButton("Normal Button");			// create a simple button with text
		add(button1);
		
		String path1 = "C:\\Users\\gnguy\\Desktop\\Java\\EventHandling\\src\\eventHandlingPackage\\icon1.png";
		String path2 = "C:\\Users\\gnguy\\Desktop\\Java\\EventHandling\\src\\eventHandlingPackage\\icon2.png";
		
		Icon icon1 = new ImageIcon(path1);					// import icon1
		Icon icon2 = new ImageIcon(path2);					// import icon2
		imageButton = new JButton(icon1);	// create button with icon1 as image
		
		imageButton.setMargin(new Insets(0,0,0,0));			// removes margins between image and button border
		imageButton.setBorder(null);						// removes button borders
		imageButton.setRolloverIcon(icon2);					// set icon2 to appear on hover
		add(imageButton);
		
		// CHECKBOX ==============================
		
		checkBoxText = new JTextField
				("Check the boxes below for a surprise!", 25);
		checkBoxText.setFont(new Font("Serif", Font.PLAIN, 14));
		add(checkBoxText);
		
		boldBox = new JCheckBox("Bold");
		add(boldBox);
		italicBox = new JCheckBox("Italic");
		add(italicBox);
		
		// EVENT HANDLER OBJECTS ==========================
		// Declare myHandler object before creating the myHandler class
		
		//  Action Listener Handler ===============
		myHandler eventHandler = new myHandler();
		item1.addActionListener(eventHandler);
		item2.addActionListener(eventHandler);
		item3.addActionListener(eventHandler);
		passwordField.addActionListener(eventHandler);	
		
		button1.addActionListener(eventHandler);
		imageButton.addActionListener(eventHandler);
		
		// Item Listener Handler ===============
		itemHandler handler = new itemHandler();
		boldBox.addItemListener(handler);
		italicBox.addItemListener(handler);
			
		
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
			// Text fields ==========================
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
			// Buttons ============================
			else if (event.getSource()==button1){
				fieldString = String.format("You clicked %s!", event.getActionCommand());
			}
			else if (event.getSource()==imageButton){
				fieldString = String.format("You clicked Image Button!");
			}
			// Check Boxes ========================
			
			JOptionPane.showMessageDialog(null, fieldString);
		}
	}
	
	private class itemHandler implements ItemListener{
		
		public void itemStateChanged(ItemEvent event){
			
			Font font = null;		// stores the font of the text field we will modify
			
			if(boldBox.isSelected() && italicBox.isSelected()){
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			}
			else if (boldBox.isSelected()){
				font = new Font("Serif", Font.BOLD, 14);
			}
			else if (italicBox.isSelected()){
				font = new Font("Serif", Font.ITALIC, 14);
			}
			else {
				font = new Font("Serif", Font.PLAIN, 14);
			}
			
			checkBoxText.setFont(font);
		}
	}
}










