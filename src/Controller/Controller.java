package Controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.Model;
import View.View;

public class Controller {

	private View view;	
	private Model model;
	
	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
	public Controller(View v, Model m) {
		view = v;
		model = m;
		initView();
	}
	
	public void initView() {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				view.getFrame().setVisible(true);
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
	
	public void initController() {
		view.getMnuStart().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			startClick();
			}	
		});		
		
		view.getMnuPause().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
				pauseClick();
			}	
		});

		view.getMnuExit().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
			if(result == 0)
				System.exit(0);
			}	
		});
		
		view.getBtnNewButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append("Big Fight Game was created");
				sb.append("\nEgale name is: " + model.getBigFightGame().getEgale().getName());
				sb.append("\nShark name is: " + model.getBigFightGame().getShark().getName());
				sb.append("\nNumber of Pices are: " + model.getBigFightGame().getPices().length);
				sb.append("\nPices name is: " + model.getBigFightGame().getPices()[0].getName());
				JOptionPane.showMessageDialog(null, sb.toString());
				}	
			});
	}
	
	private void startClick() {
		JOptionPane.showMessageDialog(null,"Game started."); 
	}

	private void pauseClick() {
		if(view.getMnuPause().getText().equalsIgnoreCase("pause"))
			view.getMnuPause().setText("Start");
		else
			view.getMnuPause().setText("Pause");
	}
	
}
