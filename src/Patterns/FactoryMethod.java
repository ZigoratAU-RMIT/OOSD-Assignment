package Patterns;

import Controller.Controller;
import Model.Model;
import View.View;

public class FactoryMethod {
	Model model;
	View view;
	Controller controller;
	
	public FactoryMethod(Model model,View view,Controller controller) {
		this.model = model;
		this.view = view;
		this.controller = controller;
		controller.setModel(model);
		controller.setView(view);
	}
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
