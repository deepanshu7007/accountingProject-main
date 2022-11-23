package accountingproject;

import javax.swing.table.DefaultTableModel;

public interface MasterPresistables {
	public void insertRecord(DefaultTableModel dtm);
	public void deleteRecord();
	public void editRecord(DefaultTableModel dtm);
	public void viewRecord();
}
