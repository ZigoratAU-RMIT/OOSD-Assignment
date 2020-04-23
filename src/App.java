import Controller.Controller;
import Model.Model;
import View.View;

public class App {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		model.initModel(view.getBoard().getRow(),view.getBoard().getColumn());
		Controller controller = new Controller(view ,model);
		controller.initController();
	}
}
