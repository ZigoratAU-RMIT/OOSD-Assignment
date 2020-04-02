import Controller.Controller;
import Model.Model;
import View.View;

public class App {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Model m = new Model();
		View v = new View();
		Controller c = new Controller(v ,m);
		c.initController();
	}
}
