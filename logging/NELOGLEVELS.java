package logging;

public enum NELOGLEVELS {
	disabled,
	warning,//When something shouldn't happen
	info, //General information about things happening in the game/ Not debug info per say, just details
	debug, //Information useful for debugging like facts normally abstracted by the game output
	verbose; //Used for updating GUIs/ stuff that even developers don't need to see
	
	public int getIntValue(NELOGLEVELS level){
		int returned = 0;
		switch(level){
		case disabled: returned = 0; break;
		case warning:  returned = 1; break;
		case debug: returned =  2; break;
		case info: returned = 3; break;
		case verbose: returned =  4; break;
		
		}
		return returned;
	}
	
	public static NELOGLEVELS getLevelValue(int level){
		NELOGLEVELS returned = disabled;
		switch(level){
		case 0: returned = disabled; break;
		case 1:  returned = warning; break;
		case 2: returned = debug; break;
		case 3: returned =  info; break;
		case 4: returned =  verbose; break;
		
		}
		return returned;
	}
	
	public String getName(NELOGLEVELS level){
		String returned = "";
		switch(level){
		case disabled: returned = ""; break;
		case warning:  returned = "Warning"; break;
		case info: returned = "Info"; break;
		case debug: returned =  "Debug"; break;
		case verbose: returned =  "Verbose"; break;
		
		}
		return returned;
	}

}
