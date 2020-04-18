import Controller.Controller;
import Model.BigFightGame;
import Model.Egale;
import Model.Model;
import Model.Pieces;
import Model.Shark;
import View.View;

public class App {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Pieces[] pieces = new Pieces[1];
//		pices[0] = new Pieces("Stone");
		Model m = new Model(new BigFightGame(
				new Egale("Egale"),new Shark("shark"),pieces));
		View v = new View();
		Controller c = new Controller(v ,m);
		c.initController();
	}
}
