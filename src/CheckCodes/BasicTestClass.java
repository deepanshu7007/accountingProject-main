package CheckCodes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class BasicTestClass extends JFrame {
	public BasicTestClass()
	{
		
		DefaultTableModel dm = new DefaultTableModel(3,3);
		JTable table = new JTable(dm);
		table.setCellSelectionEnabled(true);
		DefaultCellEditor
		setSize(500,500);
		add(table);
		setVisible(true);
	}

public  static void main(String[] args)
{
	BasicTestClass bs = new BasicTestClass();
}
}
class MyTableModel extends AbstractTableModel
{

	protected Object ColumnNames[];
	protected Object Data[][];
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub.
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub.
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub.
		return null;
	}
	
}