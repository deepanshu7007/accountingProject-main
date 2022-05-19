package TransactionsMaster;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Views.DTextField;


/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created Jun 2, 2021.
 */
public class GenericEditorForFields extends DefaultCellEditor {

	Class[] argTypes = new Class[] { String.class };
	java.lang.reflect.Constructor constructor;
	Object value;
	JTable table;

	public GenericEditorForFields(JTable table) {
		super(new DTextField());
		this.table = table;
		getComponent().setName("Table.editor");
	}

	public boolean stopCellEditing() {
		String s = (String) super.getCellEditorValue();
		// Here we are dealing with the case where a user
		// has deleted the string value in a cell, possibly
		// after a failed validation. Return null, so that
		// they have the option to replace the value with
		// null or use escape to restore the original.
		// For Strings, return "" for backward compatibility.

		try {
			if ("".equals(s)) {
				if (constructor.getDeclaringClass() == String.class) {
					value = s;
				}
				return super.stopCellEditing();
			}
			int col = 0;
			if (table.getSelectedColumn() == 1)
				col = 2;
			if (table.getSelectedColumn() == 2)
				col = 1;
			if (table.getValueAt(table.getSelectedRow(), col).equals(0.0)) {
//				SwingUtilities2.checkAccess(constructor.getModifiers());
				value = constructor.newInstance(new Object[] { s });
			} else {
				JOptionPane.showMessageDialog(null, "Something went wrong");
//				SwingUtilities2.checkAccess(constructor.getModifiers());
				value = 0.0;
				return super.stopCellEditing();
			}
		} catch (Exception e) {
			((JComponent) getComponent()).setBorder(new LineBorder(Color.red));
			return false;
		}
		return super.stopCellEditing();
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.value = null;
		((JComponent) getComponent()).setBorder(new LineBorder(Color.black));

		((JTextField) getComponent()).setHorizontalAlignment(JTextField.RIGHT);

		try {
			Class<?> type = table.getColumnClass(column);
			// Since our obligation is to produce a value which is
			// assignable for the required type it is OK to use the
			// String constructor for columns which are declared
			// to contain Objects. A String is an Object.
			if (type == Object.class) {
				type = String.class;
			}
//			ReflectUtil.checkPackageAccess(type);
//			SwingUtilities2.checkAccess(type.getModifiers());
			constructor = type.getConstructor(argTypes);
		} catch (Exception e) {
			return null;
		}
		return super.getTableCellEditorComponent(table, value, isSelected, row, column);
	}

	public Object getCellEditorValue() {
		return value;
	}
}
