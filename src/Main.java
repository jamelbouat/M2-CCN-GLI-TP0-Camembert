
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.*;
import model.*;
import view.*;

public class Main {
	static String[] columns = {"Titre", "Description", "Valeur"};	
	
	public static void main(String[] a) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 400, 400);
		
		// Instantiation of model
		ICamembertModel model = new CamembertModel("Budget", "euros");
		ModelAdapter adapter = new ModelAdapter(model);
		
		adapter.addItem("loyer", "il faut payer", 100);
		adapter.addItem("assurance", "il faut s'assurer", 1000);
		adapter.addItem("voyage", "il faut voyager", 50);
		adapter.addItem("voiture", "il faut avoir une voiture", 1000);
		
		// Camembert view
		ICamembertView view = new CamembertView(adapter);
		IController controller = new Controller(view, adapter);
		view.setController(controller);
		window.getContentPane().add((Component) controller.getView());
		
		// Table view
		ICamembertTableView tableView = new CamembertTableView(adapter);
		tableView.setController(controller);
		JPanel tabelPanel = new JPanel();
		tabelPanel.add((Component) tableView);
		window.add(tabelPanel);
		
		GridLayout layout = new GridLayout(1, 2);
		window.setLayout(layout);
		window.pack();		
		window.setSize(1200, 600);		
		window.setVisible(true);		
	
	}	
	
}
