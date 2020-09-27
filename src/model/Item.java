package model;

public class Item implements IItem {
	
	private String title;
	private String description;
	private double value;

	public Item(String title, String description, double value) {
		this.title = title;
		this.description = description;
		this.value = value;
	}

	@Override
	public String getItemTitle() {
		return this.title;
	}

	@Override
	public void setItemTitle(String title) {
		this.title = title;

	}

	@Override
	public String getItemDescription() {
		return description;
	}

	@Override
	public void setItemDescription(String description) {
		this.description = description;
	}

	@Override
	public double getItemValue() {
		return this.value;
	}

	@Override
	public void setItemValue(double value) {
		this.value = value;
	}

}
