package central;

import javax.swing.JTextArea;

import logging.NELOG;
import logging.NELOGLEVELS;
import dataComs.MainConsoleControl;
import dataComs.StatsManager;
import graphical.WindowInit;

public class Main {
	//Metadata
	private final static String title = "TXTRPG";
	private final static String version = "0.0.1-A";
	
	//Start Main Console Data Controller
	public static MainConsoleControl mCC = new MainConsoleControl();
	//Create reference to the console Output stream
	private static JTextArea outStream;
	//Create reference to the map output box
	private static JTextArea map;
	//Logger
	public static NELOG log;
	static  NELOGLEVELS loggerLimit = NELOGLEVELS.verbose;
	static  boolean activeLogger = true;
	static  boolean loggerUseCMD = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(title +"! Version: " + version + " -NCD1998");
		//Start GUI and GUI threads
		WindowInit.initWin();
		//Delay for GUI initialization catching up
		Thread.sleep(700);
		//Create Logger
		log = new NELOG(loggerLimit, activeLogger, loggerUseCMD, mCC);
		//Send Logger Initiation Message
		log.log(NELOGLEVELS.debug, "Logger Activated: Level- " + loggerLimit.getName(loggerLimit) + " Using CMD: " + activeLogger);
		//Start the help menu
		StatsManager.setOption("Help Menu");

				
		
	}
	//Method sets the output stream once then refuses too
	public static void setMainConGUIRef(JTextArea Obj){
		if(outStream == null){
			outStream = Obj;
			mCC.setConsole(Obj);
		}
	}
	
	//Method sets the map once then refuses too
		public static void setMapRef(JTextArea Obj){
			if(map == null){
				map = Obj;
			}
		}
	
	

}
