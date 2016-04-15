package graphical;

public class WindowInit {
	public static void initWin(){
		//Create GUI Thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//Create all the GUIs
            	MainConsoleGen.createConsoleWindowGUI();
            	MapDisplay.createMapGUI();
            	StatsMenu.createStatsWindowGUI();
            }
        });
	}
}
