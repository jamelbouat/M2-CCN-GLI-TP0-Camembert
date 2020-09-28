package controller;

import model.ModelAdapter;
import view.ICamembertView;

public class Controller implements IController {
	
	private ICamembertView view;
	private ModelAdapter adapter;
	private boolean selection;
	private int itemIndex;

	public Controller(ICamembertView view, ModelAdapter adapter) {
		this.view = view;
		this.adapter = adapter;
	}

	@Override
	public void setSelected(boolean b) {
		this.selection = b;
	}

	@Override
	public int getSelectedPie() {
		return this.itemIndex;
	}

	@Override
	public void setSelectedPie(int i) {
		this.itemIndex = i;
	}

	@Override
	public boolean isSelected() {
		return this.selection;
	}

	@Override
	public void deSelect() {
		this.view.deSelect();
	}

	@Override
	public void selectPie(int i) {
		this.view.selectPie(i);
	}

	@Override
	public void nextPie() {
		this.view.nextPie();
	}

	@Override
	public void previousPie() {
		this.view.previousPie();
	}

	@Override
	public ICamembertView getView() {
		return this.view;
	}

	@Override
	public void addItem(String title, String description, double value) {
		this.adapter.addItem(title, description, value);	
	}

	@Override
	public void deleteItem(int itemIndex) {
		this.adapter.deleteItem(itemIndex);
	}

}
