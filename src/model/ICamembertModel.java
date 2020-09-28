package model;

import java.util.List;

public interface ICamembertModel {
	
	String getTitle();
	
	String getTitle(int i);
	
	void setTitle(String title);
	
	double total();
	
	double getValues(int i);
		
	List<IItem> getAllItems();
	
	void addItem(String title, String description, double value);
	
	void setItem(IItem item);
	
	void deleteItem(int itemIndex);
	
	int size();
	
	String getUnit();
	
	String getDescription(int i);

	IItem getItem(int i);
		
}