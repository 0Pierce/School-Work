package scotlandYard;

import javax.swing.JFrame;

import gui.GameBoard;
import gui.MapPanel;
import gui.GUIController;
import gui.SurfaceGUI;


//Author: Aarib

//where the AI implementation was intended to be added
@SuppressWarnings("serial")
public class TurnSetup extends JFrame{
	
	//vs CPU (illusion of choice)
	public TurnSetup (int players, String playerChar, int difficulty) {
		GUIController.main(null);
		//easy mode
		if(difficulty == 0) {
			if(playerChar.equals("MrX")){
				difficulty = 0;
				
			} if(playerChar .equals("Detective")){
				difficulty = 0;
				
			}
			
		//hard mode
		}else {
			if(playerChar.equals("MrX")){
				difficulty = 0;
				
			} if(playerChar .equals("Detective")){
				difficulty = 0;
				
			}
		}
	}

	//vs Player
	public TurnSetup(int playerNumbers) {
		GUIController.main(null);
		
	}
}
