package scotlandYard;

/*
 * Pierce Pokorny, Wilfred Zheng, Anson Lau, Aarib Abbas(needs %s)
 * 05-08-2022
 * ICS4U1-03
 * Mr.Fernandes
 * ScotlandYard BoardGame
 * 
 * Description:
 * A java program that creates a virtual simulation of the board game called 
 * ScotlandYard. It uses multiple java files, classes, images, GIFs, and 
 * sound effects to create a satisfying game experience. 
 * 
 * Features:
 * Used multiple GIFs and images to create a visually enriched user interface.
 * Created a visually minimal and effective user interface.
 * Has various game mechanics in place which simulate the rules of the game. such as:
 *     Limited turns
 *     Blurring effects
 *     Special cards
 *     Revealing/hiding Mr.X
 *     And a few others
 * 
 * 
 * Major Skills:
 * Taking inputs from an external text file
 * Hierarchies/superclass's/implementations
 * Using image files, and the java swing GUI
 * Team-work as a group of programmers
 * Polymorphism
 * Pretty much all Object Oriented programming topics
 *  
 * 
 * Areas of Concern:
 * AI has not been implemented in time
 * special tickets may not correctly be used
 * Small bugs that we were unable to fix
 * Mr X log does not show mrX's previous moves
 */

public class StartGame {

	//starts the game
	public static void main(String[] args) {
		new ScotlandYardControler();
	}
}
