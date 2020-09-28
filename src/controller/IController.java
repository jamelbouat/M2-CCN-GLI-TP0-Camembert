package controller;

import model.IItem;
import view.ICamembertView;

public interface IController {

	void setSelected(boolean b);

	int getSelectedPie();

	void setSelectedPie(int i);

	boolean isSelected();

	void deSelect();

	void selectPie(int i);

	void nextPie();

	void previousPie();
	
	void addItem(String title, String description, double value);
	
	void deleteItem(int itemIndex);

	ICamembertView getView();

}
