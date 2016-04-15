package dataComs;

import javax.swing.JTextArea;

import reference.ReferenceValues;

public class MainConsoleControl {
	//Variable to hold input
	private String inBuffer;
	//Variable to hold the Output text console reference
	private JTextArea OutPutConsole;

	
	//Set the Input
	public void addToInBuffer(String dataIn){
		inBuffer = dataIn;
	}
	
	//Retrieve data
	public String getInput(){
		String tempBuffer = inBuffer;
		inBuffer = null;
		return tempBuffer;
	}
	
	//Check if data is Available
	public boolean isInAvailable(){
		return inBuffer!=null;
	}
	
	//Clear the buffer
	public void clearInBuffer(){
		inBuffer = null;
	}
	
	//Set Console
	public void setConsole(JTextArea console){
		if(OutPutConsole == null){
			OutPutConsole = console;
		}
	}
	
	//Print to console
	public void cPrintLn(String str){
		if(OutPutConsole != null){
			if(OutPutConsole.getLineCount() > OutPutConsole.getRows() - ReferenceValues.LINEBUFFERMAINCONSOLE){
				//Clear the output text
				OutPutConsole.setText("");
			}
			OutPutConsole.append(str + "\n");
		}
	}
}
