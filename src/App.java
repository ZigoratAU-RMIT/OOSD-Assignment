import Controller.Controller;
import Model.Model;
import Patterns.FactoryMethod;
import View.View;

public class App {
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		
		FactoryMethod fm = new FactoryMethod(
				new Model(), new View(), new Controller());
		fm.getController().initController();
		
//		Model model = new Model();
//		View view = new View();
//		Controller controller = new Controller(view ,model);
//		controller.initController();
	}
}
