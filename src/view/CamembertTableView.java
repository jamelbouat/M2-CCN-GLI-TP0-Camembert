package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.*;
import model.*;

public class CamembertTableView extends JComponent implements ICamembertTableView, Observer {

	private ModelAdapter model;
	private IController controller;
	private JTable table;
	private JTextField titleField, descriptionField, valueField;
	private JButton addItemButton, removeItemButton;
	
	public CamembertTableView(ModelAdapter modelAdapter) {
		this.model = modelAdapter;
		model.addObserver(this);
			
		drawFieldsAndButtonsAndTable();
		
		// Add listeners to the buttons
		addListenersToButtons();
	}
	
	private void addListenersToButtons() {
		this.addItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String title = titleField.getText();
				String description = descriptionField.getText();			
				double value = -1;
				
				try {
					value = Double.parseDouble(valueField.getText());
				} catch(NumberFormatException e) {}
				
				controller.addItem(title, description, value);
			}
		});
		
		this.removeItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				controller.deleteItem(table.getSelectedRow());
			}
		});
		
	}

	public void drawFieldsAndButtonsAndTable() {
		this.table = new JTable(model);
		
		// Fields
		this.titleField = new JTextField(10);
		this.descriptionField = new JTextField(10);
		this.valueField = new JTextField(10);
		
		// Buttons
		this.addItemButton = new JButton("ajout");
		this.removeItemButton = new JButton("Suppr");
		// table
		JScrollPane scrollPane = new JScrollPane(table);
			
		// Panel
		JPanel panel = new JPanel();
		panel.add(titleField);
		panel.add(descriptionField);
		panel.add(valueField);
		panel.add(addItemButton);
		panel.add(removeItemButton);
		
		// Layout
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);
		this.add(scrollPane);
		this.add(panel);
	}

	@Override
	public void setController(IController c) {
		this.controller = c;		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				table.updateUI();
			}
	    });
	}
	
}