package Typing_game.Controller;

public class Control {

	private static Control control = new Control();
	private Control() {}
	
	public static Control getInstance() {return control;}
	
}
