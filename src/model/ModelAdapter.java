package model;

import java.util.List;
import java.util.Observable;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ModelAdapter extends Observable implements IModelAdapter, TableModel {
	
	private ICamembertModel model;

	public ModelAdapter(ICamembertModel model) {
		this.model = model;
	}

	private void notifyChangesToObservers() {
		this.setChanged();
		this.notifyObservers();		
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
		notifyChangesToObservers();
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
		notifyChangesToObservers();
	}

	@Override
	public void setItem(IItem item) {
		this.model.setItem(item);
		notifyChangesToObservers();		
	}

	@Override
	public void deleteItem(int itemIndex) {
		this.model.deleteItem(itemIndex);
		notifyChangesToObservers();
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

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int column) {
		// Allow editing in the value cell (cause primitive double);
		return String.class;
//		return this.model.getItem(0).getClass().getDeclaredFields()[column].getType();
	}

	@Override
	public int getColumnCount() {
		return this.model.getItem(0).getClass().getDeclaredFields().length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnIndex == 0 ? "Titre" :
			   columnIndex == 1 ? "Description" : "Valeur";
	}

	@Override
	public int getRowCount() {
		return this.model.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		IItem item = this.model.getItem(rowIndex);
		return columnIndex == 0 ? item.getItemTitle() :
			   columnIndex == 1 ? item.getItemDescription() : item.getItemValue();
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		if (columnIndex == 0 ) {
			this.model.getItem(rowIndex).setItemTitle((String) value);
		}
		
		if (columnIndex == 1 ) {
			this.model.getItem(rowIndex).setItemDescription((String) value);
		}
		
		if (columnIndex == 2 ) {
			
			// allow only double values in the editing mode
			try {
				this.model.getItem(rowIndex).setItemValue(Double.parseDouble((String) value));

			} catch(NumberFormatException e) {}
			
		}
		notifyChangesToObservers();

	}

}
