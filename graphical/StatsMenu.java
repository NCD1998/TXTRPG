package graphical;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dataComs.StatsManager;
import reference.ReferenceValues;

public class StatsMenu extends JPanel implements ActionListener{
	//Number of Lines
		int sizeOfField = ReferenceValues.LINESSTATS;
		//Width of Fields
		int widthOfField = ReferenceValues.WIDTHOFSTATS;
		//Text Output
		protected JTextArea stats;
		//Selection Menu
		String[] options = {"Help Menu", "Inventory", "Spells", "Equipment/stats"};
		//The drop box object
		JComboBox<String> selector;
		public StatsMenu(){
			super(new GridBagLayout());
			selector = new JComboBox<String>(options);
			stats = new JTextArea(sizeOfField, widthOfField);
			//Make the Text Output Not editable by the user
			stats.setEditable(false);
			//So we can listen for changing options
			selector.addActionListener(this);
			GridBagConstraints constrain = new GridBagConstraints();
			constrain.gridwidth = GridBagConstraints.REMAINDER;
			constrain.fill = GridBagConstraints.HORIZONTAL;
			add(selector, constrain);
		
			constrain.fill= GridBagConstraints.BOTH;
			add(stats, constrain);
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource().equals(selector)){
				//Pass changes to the stats manager
				StatsManager.setOption(selector.getSelectedItem().toString());
			}
			
		}
		static void createStatsWindowGUI(){
			//Create the main text display window
			JFrame textConsoleWin = new JFrame("TXTRPG-Stats");
			//We dont want the window to be resized because I suck at layouts
			textConsoleWin.setResizable(false);
			//When this panel is closed, shut down the game
			textConsoleWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Add componants
			JPanel stuff = new StatsMenu();
			textConsoleWin.add(stuff);
			textConsoleWin.setLocation(1070, 50);
			//Put everything in its rightful place
			textConsoleWin.pack();
			//Make it visible
			textConsoleWin.setVisible(true);
			//Pass a reference to the stats output field to the Stats manager
			StatsManager.setStatBox((JTextArea) stuff.getComponent(1));
			
		}
		
}
