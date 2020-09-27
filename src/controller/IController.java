package controller;

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

	ICamembertView getView();
}
