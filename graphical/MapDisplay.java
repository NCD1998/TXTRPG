package graphical;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import central.Main;
import reference.ReferenceValues;

public class MapDisplay extends JPanel{
	
	//Number of Lines
	int sizeOfField = ReferenceValues.LINESMAP;
	//Width of Fields
	int widthOfField = ReferenceValues.WIDTHOFMAP;
	//Text Output
	protected JTextArea map;
	
	public MapDisplay(){
		super(new GridBagLayout());
		map = new JTextArea(sizeOfField, widthOfField);
		//Make the Text Output Not editable by the user
		map.setEditable(false);
		GridBagConstraints constrain = new GridBagConstraints();
		constrain.gridwidth = GridBagConstraints.REMAINDER;
		constrain.fill= GridBagConstraints.BOTH;
		add(map, constrain);
	}
	static void createMapGUI(){
		//Create the main text display window
		JFrame textConsoleWin = new JFrame("TXTRPG-MAP");
		//We dont want the window to be resized because I suck at layouts
		textConsoleWin.setResizable(false);
		//When this panel is closed, shut down the game
		textConsoleWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add componants
		JPanel stuff = new MapDisplay();
		textConsoleWin.add(stuff);
		textConsoleWin.setLocation(500, 50);
		//Put everything in its rightful place
		textConsoleWin.pack();
		//Make it visible
		textConsoleWin.setVisible(true);
		//Set the reference to the map output field
		Main.setMapRef((JTextArea) stuff.getComponent(0));
	}
}
