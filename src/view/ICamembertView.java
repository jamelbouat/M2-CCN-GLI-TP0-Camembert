package view;

import java.awt.event.MouseEvent;
import java.util.Observable;

import controller.IController;

public interface ICamembertView {
	void mouseClicked(MouseEvent arg0);
	
	void mouseEntered(MouseEvent arg0);
	
	void mouseExited(MouseEvent arg0);
	
	void mousePressed(MouseEvent arg0);
	
	void mouseReleased(MouseEvent arg0);
	
	void mouseDragged(MouseEvent e);
	
	void mouseMoved(MouseEvent e);
	
	void update(Observable arg0, Object arg1);
	
	void setController(IController c);
	
	void nextPie();
	
	void previousPie();
	
	void selectPie(int i);
	
	void deSelect();
	
}
