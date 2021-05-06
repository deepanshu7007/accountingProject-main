package CheckCodes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TableTest extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;

	//
	// Constructor
	//
	public TableTest() {
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(new DefaultTableModel(10, 4));
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane = new JScrollPane(table);

		KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(tab, "Tarverse");
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "Tarverse");
		table.getActionMap().put("Tarverse", new EnterAction());

		KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(delete, "Delete");
		table.getActionMap().put("Delete", new DeleteAction());

		add(scrollPane, BorderLayout.CENTER);
	}

	//
	// Main method.
	//
	public static void main(String[] args) {
		TableTest tt = new TableTest();
		tt.setVisible(true);

	}
}

class EnterAction extends AbstractAction {
	static int row;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed");
		JTable tab = (JTable) e.getSource();
		if (tab.isEditing())
			tab.getCellEditor().stopCellEditing();

		row = tab.getSelectedRow();
		if (row == tab.getRowCount() - 1) {
			DefaultTableModel dm = (DefaultTableModel)tab.getModel();
			dm.addRow(new Object[] {"","",""});
			tab.changeSelection(row+1,0,false,false);
		} else {
			int col = tab.getSelectedColumn();
			tab.changeSelection(row, col + 1, false, false);
		}
	}
}

class DeleteAction extends AbstractAction {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("DeleteAction");
		JTable tab = (JTable) e.getSource();
		if (tab.isEditing())
			return;
		else {
			int row = tab.getSelectedRow();
			int col = tab.getSelectedColumn();
			DefaultTableModel dm = (DefaultTableModel) tab.getModel();
			dm.removeRow(row);

		}
	}
}