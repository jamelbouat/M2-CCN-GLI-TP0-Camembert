package model;

import java.util.ArrayList;
import java.util.List;

public class CamembertModel implements ICamembertModel {
	
	private String title;
	private String unit;
	private List<IItem> items;

	public CamembertModel(String title, String unit) {
		this.title = title;
		this.unit = unit;
		this.items = new ArrayList<IItem>();
	}

	@Override
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public String getTitle(int i) {
		return this.getItem(i).getItemTitle();
	}

	@Override
	public void setTitle(String title) {
		this.title = title;		
	}

	@Override
	public double total() {
		double total = 0.0;
		for (IItem item : this.items) {
			total += item.getItemValue();
		}
		
		return total;
	}
	
	@Override
	public double getValues(int i) {
		return this.getItem(i).getItemValue();
	}

	@Override
	public List<IItem> getAllItems() {
		return this.items;
	}

	@Override
	public void addItem(String title, String description, double value) {
		if (title == null || title.equals("") || description == null || description.equals("") || value < 0) {
			return;
		}
		
		items.add(new Item(title, description, value));
	}

	@Override
	public void setItem(IItem item) {
	}

	@Override
	public void deleteItem(int itemIndex) {
		if (itemIndex < 0 || itemIndex >= this.items.size()) {
			return;
		}
		this.items.remove(itemIndex);
	}

	@Override
	public int size() {
		return this.items.size();
	}

	@Override
	public String getUnit() {
		return this.unit;
	}

	@Override
	public String getDescription(int i) {
		return this.getItem(i).getItemDescription();
	}

	@Override
	public IItem getItem(int i) {
		return this.items.get(i);
	}

}
