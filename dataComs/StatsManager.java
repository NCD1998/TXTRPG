package dataComs;

import javax.swing.JTextArea;

import logging.NELOGLEVELS;
import central.Main;

public class StatsManager {
	//The current selected option in the drop down menu
	private static String currentOption;
	//Reference to the statbox text area
	private static JTextArea statbox;
	
	//Updates the current selected option and updates its display
	public static void setOption(String option){
		//Update variable
		currentOption = option;
		
		Main.log.log(NELOGLEVELS.verbose, "[StatsManager]: Set current option to " + option);
		//If the option is set to Help Menu
		if(option.equalsIgnoreCase("Help menu")){
			//Format the display
			String[] strArray = new String[10];
			strArray[0] = addLine("Commands");
			strArray[1] = addLine("------------------");
			strArray[2] = addLine("No commands yet");
			//Update the Display
			updateStatbox(strArray);
			Main.log.log(NELOGLEVELS.verbose, "[StatsManager]: Updated menu");
		}else{
			//If nothing matched for some odd reason, empty the display
			Main.log.log(NELOGLEVELS.warning, "[StatsManager]: The selected menu option is nonexistant");
			updateStatbox(null);
		}
		
	}
	//Sets the stat box reference one time
	public static void setStatBox(JTextArea setstatbox){
		if(statbox == null){
			statbox = setstatbox;
		}
	}
	
	//Get the currently selected option
	public static String getOption(){
		return currentOption;
	}
	//Updates the stat box display
	private static void updateStatbox(String[] strArray){
		//Clear the display
		statbox.setText("");
		//Append all lines
		if(strArray != null){
			for(int x = 0; x < strArray.length; x++){
				if(strArray[x] != null){
					statbox.append(strArray[x]);
				}
			}
		}
		
	}
	
	private static String addLine(String str){
		return str + "\n";
	}
}
