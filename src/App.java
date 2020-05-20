import Controller.Controller;
import Model.Model;
import View.View;

public class App {
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(view ,model);
		controller.initController();
	}
}
