package model;

import java.util.List;
import java.util.Observable;

import view.ICamembertView;

public class ModelAdapter extends Observable implements IModelAdapter {
	
	private ICamembertModel model;

	public ModelAdapter(ICamembertModel model) {
		this.model = model;
	}

	@Override
	public String getTitle() {
		return this.model.getTitle();
	}

	@Override
	public String getTitle(int i) {
		return this.model.getTitle(i);
	}
	
	@Override
	public void setTitle(String title) {
		this.model.setTitle(title);
		this.notifyObservers();
	}

	@Override
	public double total() {
		return this.model.total();
	}

	@Override
	public double getValues(int i) {
		return this.model.getValues(i);
	}
	
	@Override
	public List<IItem> getAllItems() {
		return this.model.getAllItems();
	}

	@Override
	public void addItem(String title, String description, double value) {
		this.model.addItem(title, description, value);
		this.notifyObservers();
	}

	@Override
	public void setItem(IItem item) {
		this.model.setItem(item);
		this.notifyObservers();		
	}

	@Override
	public void deleteItem(IItem item) {
		this.model.deleteItem(item);
		this.notifyObservers();
	}

	@Override
	public int size() {
		return this.model.size();
	}

	@Override
	public String getUnit() {
		return this.model.getUnit();
	}
	
	@Override
	public String getDescription(int i) {
		return this.model.getDescription(i);
	}

	@Override
	public IItem getItem(int i) {
		return this.model.getItem(i);
	}

}
