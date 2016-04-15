package logging;

import dataComs.MainConsoleControl;

public class NELOG {
	//The level of detail to log
	private final int loglevel;
	//The current On/Off State of the log
	private final boolean logState;
	//Whether to print in the Eclipse/IDE/CMD console
	private final boolean enableCMDLogging;
	//Reference to the mCC
	private final MainConsoleControl mCC;
	
	public NELOG(int level, boolean toggle, boolean useCMDAlso, MainConsoleControl mCC){
		loglevel = level;
		logState = toggle;
		enableCMDLogging = useCMDAlso;
		this.mCC = mCC;
	}
	
	public NELOG(NELOGLEVELS level, boolean toggle, boolean useCMDAlso, MainConsoleControl mCC){
		this(level.getIntValue(level), toggle, useCMDAlso, mCC);
	}
	//Print the log
	public void log(int level, String str){
		if(logState){
			//If the log level is of greater importance than the limit
			if(level <= loglevel){
				if(enableCMDLogging){
					//Print out the log info in the Dev Console
					System.out.println("[NELOG/" + NELOGLEVELS.getLevelValue(level) + "]: " +str);
				}
				
					//Print out the log info in the GUI Console
					mCC.cPrintLn("[NELOG/" + NELOGLEVELS.getLevelValue(level) + "]: " +str);
				
			}
		}
	}
	//Allows the use of NELOGLEVELS Enum to choose named levels
	public void log(NELOGLEVELS level, String str){
		this.log(level.getIntValue(level), str);
	}
	
	
	
}
