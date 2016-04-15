package graphical;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import reference.ReferenceValues;
import central.Main;

/*
 * What this does: It creates a simple text box which can be printed to.
 * If its broken future self.... Just rewrite it.... There is probably no hope in fixing it.
 */
public class MainConsoleGen extends JPanel implements ActionListener {
	
	//Number of Lines
	int sizeOfField = ReferenceValues.LINESINMAINCONSOLE;
	//Width of Fields
	int widthOfField = ReferenceValues.WIDTHOFMAINCONSOLE;
	//Text Output
	protected JTextArea textOut;
	//Text Input
	protected JTextField textIn;
	

	
	
	public MainConsoleGen() {
		super(new GridBagLayout());
		
		textIn = new JTextField(sizeOfField);
		textOut = new JTextArea(sizeOfField, widthOfField);
		//Make the Text Output Not editable by the user
		textOut.setEditable(false);
		//This is good right?
		textOut.setAutoscrolls(true);
		//I think this is important maybe
		textOut.setWrapStyleWord(true);
		//Make the text Input listen for when the person presses enter
		textIn.addActionListener(this);
		//Set the constraints
		GridBagConstraints constrain = new GridBagConstraints();
		constrain.gridwidth = GridBagConstraints.REMAINDER;
		constrain.fill= GridBagConstraints.BOTH;
		add(textOut, constrain);
		
		constrain.fill = GridBagConstraints.HORIZONTAL;
		add(textIn, constrain);

	}
	//When the person presses enter on the input
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(textIn)){
			//Make a string containing the Input text
		String text = textIn.getText();
		//If the Output field isn't Full (save some lines Just in case)
		if(textOut.getLineCount() > sizeOfField - ReferenceValues.LINEBUFFERMAINCONSOLE){
			//Clear the output text
			textOut.setText("");
		}
		//Add the input text to the output
		if(!text.equals("")){
			textOut.append("[Input]: " + text + "\n");
			Main.mCC.addToInBuffer(text);
		}
		
		//Clear the input text
		textIn.setText("");
		}
		
	}
	
	static void createConsoleWindowGUI(){
		//Create the main text display window
		JFrame textConsoleWin = new JFrame("TXTRPG-Console");
		//We dont want the window to be resized because I suck at layouts
		textConsoleWin.setResizable(false);
		//When this panel is closed, shut down the game
		textConsoleWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add componants
		JPanel stuff = new MainConsoleGen();
		textConsoleWin.add(stuff);
		textConsoleWin.setLocation(500, 575);
		//Put everything in its rightful place
		textConsoleWin.pack();
		//Make it visible
		textConsoleWin.setVisible(true);
		//Set the reference to the Console output field
		Main.setMainConGUIRef((JTextArea) stuff.getComponent(0));
		
	}
		public void printOut(String str){
			if(textOut.getLineCount() > sizeOfField - ReferenceValues.LINEBUFFERMAINCONSOLE){
				//Clear the output text
				textOut.setText("");
			}
			textOut.append(str + "\n");
		}
}
