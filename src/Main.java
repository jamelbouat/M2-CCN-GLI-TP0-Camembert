import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;

import controller.*;
import model.*;
import view.*;

public class Main {
	
	public static void main(String[] a) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 400, 400);
		
		// Instantiation
		ICamembertModel model = new CamembertModel("Budget", "euros");
		ModelAdapter adapter = new ModelAdapter(model);

		adapter.addItem("loyer", "il faut payer", 100);
		adapter.addItem("assurance", "il faut s'assurer", 1000);
		adapter.addItem("voyage", "il faut voyager", 50);
		adapter.addItem("voiture", "il faut avoir une voiture", 1000);
		
		ICamembertView view = new CamembertView(adapter);
		IController controller = new Controller(view, adapter);
		view.setController(controller);
				
		// display layout
		GridLayout layout = new GridLayout(1, 2);

		window.getContentPane().add((Component) controller.getView());
		window.setLayout(layout);
		window.pack();
		window.setVisible(true);
		window.setSize(800, 800);
//		window.pack();
	}
	
}
