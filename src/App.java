import Controller.Controller;
import Model.BigFightGame;
import Model.Egale;
import Model.Model;
import Model.Pices;
import Model.Shark;
import View.View;
import View.View;

public class App {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Pices[] pices = new Pices[1];
		pices[0] = new Pices("Stone");
		Model m = new Model(new BigFightGame(
				new Egale("Egale"),new Shark("shark"),pices));
		View v = new View();
		Controller c = new Controller(v ,m);
		c.initController();
	}
}
