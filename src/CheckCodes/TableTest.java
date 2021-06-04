package CheckCodes;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
public class TableTest extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	public static JTextField field;

	public TableTest() {
		JTextField field = new JTextField(20);
		field.setPreferredSize(new Dimension(20, 20));
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		KeyStroke alphanum = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0);

		KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);

		JTextField TransactionField = new JTextField();
		TransactionField.setName("NAME");
		TransactionField.setFont(new Font("CALIBRE", Font.PLAIN, 18));
		CustomTableModel dtm = new CustomTableModel(new Object[][] {{"",new Integer(0),new Integer(0)},{"",new Integer(0),new Integer(0)},{"",new Integer(0),new Integer(0)}}, new Object[] {"A","B","C"});
		dtm.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					Integer NewTotal = dtm.getTotalDebit() - dtm.getTempValue() +Integer.parseInt( dtm.getValueAt(e.getFirstRow(),e.getColumn()).toString());
					field.setText(NewTotal.toString());
					dtm.setTotalDebit(NewTotal);
				}
			}
		});

		table = new JTable(dtm);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane = new JScrollPane(table);
//		TableCellEditor dce = new DefaultCellEditor(new JTextField()) {
//
//				public boolean stopCellEditing() {
//					
//		            fireEditingStopped();
//		            return true;
//		        }
//		};
		JTextField field1 = new  JTextField();
		field1.setFont(new Font("CALIBRE",Font.BOLD,25));
		DefaultCellEditor editor = new DefaultCellEditor(field1);
		editor.addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent e) {
				editor.get
				
			}
			
			@Override
			public void editingCanceled(ChangeEvent e) {
				// TODO Auto-generated method stub.
				
			}
		});
				table.getColumnModel().getColumn(1).setCellEditor(editor);
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(tab, "Tarverse");
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "Tarverse");
		table.setRowHeight(25);
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(delete, "Delete");
		table.getActionMap().put("Delete", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				JTable tab = (JTable) e.getSource();
				if (tab.isEditing())
					return;
				else {
					int row = tab.getSelectedRow();
					int col = tab.getSelectedColumn();
					DefaultTableModel dm = (DefaultTableModel) tab.getModel();

					if (row == 0) {
						dm.removeRow(row);
						tab.changeSelection(row + 1, col, false, false);
					} else {
						dm.removeRow(row);
						tab.changeSelection(row - 1, col, false, false);
					}
				}
			}
		});
		
		
		table.getActionMap().put("Tarverse", new EnterAction());
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(scrollPane);
		getContentPane().add(field);
	}

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

		int row = tab.getSelectedRow();
		int col = tab.getSelectedColumn();

		tab.changeSelection(row, col + 1, false, false);

	}
}

class CustomTableModel extends AbstractTableModel implements Serializable {

//
// Instance Variables
//
	protected Integer TempValue;
	/**
	 * Returns the value of the field called 'tempValue'.
	 * @return Returns the tempValue.
	 */
	public Integer getTempValue() {
		return this.TempValue;
	}

	protected Integer totalDebit=0, totalCredit=0;

	/**
	 * Returns the value of the field called 'totalDebit'.
	 * 
	 * @return Returns the totalDebit.
	 */
	public Integer getTotalDebit() {
		return this.totalDebit;
	}
	
	public Integer setTotalDebit(Integer totalDebit) {
		return this.totalDebit = totalDebit;
	}

	/**
	 * Returns the value of the field called 'totalCredit'.
	 * 
	 * @return Returns the totalCredit.
	 */
	public Integer getTotalCredit() {
		return this.totalCredit;
	}

	/**
	 * The <code>Vector</code> of <code>Vectors</code> of <code>Object</code>
	 * values.
	 */
	protected Vector dataVector;

	/** The <code>Vector</code> of column identifiers. */
	protected Vector columnIdentifiers;

//
// Constructors
//

	/**
	 * Constructs a default <code>DefaultTableModel</code> which is a table of zero
	 * columns and zero rows.
	 */
	public CustomTableModel() {
		this(0, 0);
	}

	private static Vector newVector(int size) {
		Vector v = new Vector(size);
		v.setSize(size);
		return v;
	}

	/**
	 * Constructs a <code>DefaultTableModel</code> with <code>rowCount</code> and
	 * <code>columnCount</code> of <code>null</code> object values.
	 *
	 * @param rowCount    the Integer of rows the table holds
	 * @param columnCount the Integer of columns the table holds
	 *
	 * @see #setValueAt
	 */
	public CustomTableModel(int rowCount, int columnCount) {
		this(newVector(columnCount), rowCount);
	}

	/**
	 * Constructs a <code>DefaultTableModel</code> with as many columns as there are
	 * elements in <code>columnNames</code> and <code>rowCount</code> of
	 * <code>null</code> object values. Each column's name will be taken from the
	 * <code>columnNames</code> vector.
	 *
	 * @param columnNames <code>vector</code> containing the names of the new
	 *                    columns; if this is <code>null</code> then the model has
	 *                    no columns
	 * @param rowCount    the Integer of rows the table holds
	 * @see #setDataVector
	 * @see #setValueAt
	 */
	public CustomTableModel(Vector columnNames, int rowCount) {
		setDataVector(newVector(rowCount), columnNames);
	}

	/**
	 * Constructs a <code>DefaultTableModel</code> with as many columns as there are
	 * elements in <code>columnNames</code> and <code>rowCount</code> of
	 * <code>null</code> object values. Each column's name will be taken from the
	 * <code>columnNames</code> array.
	 *
	 * @param columnNames <code>array</code> containing the names of the new
	 *                    columns; if this is <code>null</code> then the model has
	 *                    no columns
	 * @param rowCount    the Integer of rows the table holds
	 * @see #setDataVector
	 * @see #setValueAt
	 */
	public CustomTableModel(Object[] columnNames, int rowCount) {
		this(convertToVector(columnNames), rowCount);
	}

	/**
	 * Constructs a <code>DefaultTableModel</code> and initializes the table by
	 * passing <code>data</code> and <code>columnNames</code> to the
	 * <code>setDataVector</code> method.
	 *
	 * @param data        the data of the table, a <code>Vector</code> of
	 *                    <code>Vector</code>s of <code>Object</code> values
	 * @param columnNames <code>vector</code> containing the names of the new
	 *                    columns
	 * @see #getDataVector
	 * @see #setDataVector
	 */
	public CustomTableModel(Vector data, Vector columnNames) {
		setDataVector(data, columnNames);
	}

	/**
	 * Constructs a <code>DefaultTableModel</code> and initializes the table by
	 * passing <code>data</code> and <code>columnNames</code> to the
	 * <code>setDataVector</code> method. The first index in the
	 * <code>Object[][]</code> array is the row index and the second is the column
	 * index.
	 *
	 * @param data        the data of the table
	 * @param columnNames the names of the columns
	 * @see #getDataVector
	 * @see #setDataVector
	 */
	public CustomTableModel(Object[][] data, Object[] columnNames) {
		setDataVector(data, columnNames);
	}

	/**
	 * Returns the <code>Vector</code> of <code>Vectors</code> that contains the
	 * table's data values. The vectors contained in the outer vector are each a
	 * single row of values. In other words, to get to the cell at row 1, column 5:
	 * <p>
	 *
	 * <code>((Vector)getDataVector().elementAt(1)).elementAt(5);</code>
	 *
	 * @return the vector of vectors containing the tables data values
	 *
	 * @see #newDataAvailable
	 * @see #newRowsAdded
	 * @see #setDataVector
	 */
	public Vector getDataVector() {
		return dataVector;
	}

	private static Vector nonNullVector(Vector v) {
		return (v != null) ? v : new Vector();
	}

	/**
	 * Replaces the current <code>dataVector</code> instance variable with the new
	 * <code>Vector</code> of rows, <code>dataVector</code>. Each row is represented
	 * in <code>dataVector</code> as a <code>Vector</code> of <code>Object</code>
	 * values. <code>columnIdentifiers</code> are the names of the new columns. The
	 * first name in <code>columnIdentifiers</code> is mapped to column 0 in
	 * <code>dataVector</code>. Each row in <code>dataVector</code> is adjusted to
	 * match the Integer of columns in <code>columnIdentifiers</code> either by
	 * truncating the <code>Vector</code> if it is too long, or adding
	 * <code>null</code> values if it is too short.
	 * <p>
	 * Note that passing in a <code>null</code> value for <code>dataVector</code>
	 * results in unspecified behavior, an possibly an exception.
	 *
	 * @param dataVector        the new data vector
	 * @param columnIdentifiers the names of the columns
	 * @see #getDataVector
	 */
	public void setDataVector(Vector dataVector, Vector columnIdentifiers) {
		this.dataVector = nonNullVector(dataVector);
		this.columnIdentifiers = nonNullVector(columnIdentifiers);
		justifyRows(0, getRowCount());
		fireTableStructureChanged();
	}

	/**
	 * Replaces the value in the <code>dataVector</code> instance variable with the
	 * values in the array <code>dataVector</code>. The first index in the
	 * <code>Object[][]</code> array is the row index and the second is the column
	 * index. <code>columnIdentifiers</code> are the names of the new columns.
	 *
	 * @param dataVector        the new data vector
	 * @param columnIdentifiers the names of the columns
	 * @see #setDataVector(Vector, Vector)
	 */
	public void setDataVector(Object[][] dataVector, Object[] columnIdentifiers) {
		setDataVector(convertToVector(dataVector), convertToVector(columnIdentifiers));
	}

	/**
	 * Equivalent to <code>fireTableChanged</code>.
	 *
	 * @param event the change event
	 *
	 */
	public void newDataAvailable(TableModelEvent event) {
		
		fireTableChanged(event);
	}

//
// Manipulating rows
//

	private void justifyRows(int from, int to) {
		// Sometimes the DefaultTableModel is subclassed
		// instead of the AbstractTableModel by mistake.
		// Set the Integer of rows for the case when getRowCount
		// is overridden.
		dataVector.setSize(getRowCount());

		for (int i = from; i < to; i++) {
			if (dataVector.elementAt(i) == null) {
				dataVector.setElementAt(new Vector(), i);
			}
			((Vector) dataVector.elementAt(i)).setSize(getColumnCount());
		}
	}

	/**
	 * Ensures that the new rows have the correct Integer of columns. This is
	 * accomplished by using the <code>setSize</code> method in <code>Vector</code>
	 * which truncates vectors which are too long, and appends <code>null</code>s if
	 * they are too short. This method also sends out a <code>tableChanged</code>
	 * notification message to all the listeners.
	 *
	 * @param e this <code>TableModelEvent</code> describes where the rows were
	 *          added. If <code>null</code> it assumes all the rows were newly added
	 * @see #getDataVector
	 */
	public void newRowsAdded(TableModelEvent e) {
		justifyRows(e.getFirstRow(), e.getLastRow() + 1);
		fireTableChanged(e);
	}

	/**
	 * Equivalent to <code>fireTableChanged</code>.
	 *
	 * @param event the change event
	 *
	 */
	public void rowsRemoved(TableModelEvent event) {
		fireTableChanged(event);
	}

	/**
	 * Obsolete as of Java 2 platform v1.3. Please use <code>setRowCount</code>
	 * instead.
	 */
	/*
	 * Sets the Integer of rows in the model. If the new size is greater than the
	 * current size, new rows are added to the end of the model If the new size is
	 * less than the current size, all rows at index <code>rowCount</code> and
	 * greater are discarded.
	 *
	 * @param rowCount the new Integer of rows
	 * 
	 * @see #setRowCount
	 */
	public void setNumRows(int rowCount) {
		int old = getRowCount();
		if (old == rowCount) {
			return;
		}
		dataVector.setSize(rowCount);
		if (rowCount <= old) {
			fireTableRowsDeleted(rowCount, old - 1);
		} else {
			justifyRows(old, rowCount);
			fireTableRowsInserted(old, rowCount - 1);
		}
	}

	/**
	 * Sets the Integer of rows in the model. If the new size is greater than the
	 * current size, new rows are added to the end of the model If the new size is
	 * less than the current size, all rows at index <code>rowCount</code> and
	 * greater are discarded.
	 *
	 * @see #setColumnCount
	 * @since 1.3
	 */
	public void setRowCount(int rowCount) {
		setNumRows(rowCount);
	}

	/**
	 * Adds a row to the end of the model. The new row will contain
	 * <code>null</code> values unless <code>rowData</code> is specified.
	 * Notification of the row being added will be generated.
	 *
	 * @param rowData optional data of the row being added
	 */
	public void addRow(Vector rowData) {
		insertRow(getRowCount(), rowData);
	}

	/**
	 * Adds a row to the end of the model. The new row will contain
	 * <code>null</code> values unless <code>rowData</code> is specified.
	 * Notification of the row being added will be generated.
	 *
	 * @param rowData optional data of the row being added
	 */
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	public void addRow(Object[] rowData) {
		addRow(convertToVector(rowData));
	}

	/**
	 * Inserts a row at <code>row</code> in the model. The new row will contain
	 * <code>null</code> values unless <code>rowData</code> is specified.
	 * Notification of the row being added will be generated.
	 *
	 * @param row     the row index of the row to be inserted
	 * @param rowData optional data of the row being added
	 * @exception ArrayIndexOutOfBoundsException if the row was invalid
	 */
	public void insertRow(int row, Vector rowData) {
		dataVector.insertElementAt(rowData, row);
		justifyRows(row, row + 1);
		fireTableRowsInserted(row, row);
	}

	/**
	 * Inserts a row at <code>row</code> in the model. The new row will contain
	 * <code>null</code> values unless <code>rowData</code> is specified.
	 * Notification of the row being added will be generated.
	 *
	 * @param row     the row index of the row to be inserted
	 * @param rowData optional data of the row being added
	 * @exception ArrayIndexOutOfBoundsException if the row was invalid
	 */
	public void insertRow(int row, Object[] rowData) {
		insertRow(row, convertToVector(rowData));
	}

	private static int gcd(int i, int j) {
		return (j == 0) ? i : gcd(j, i % j);
	}

	private static void rotate(Vector v, int a, int b, int shift) {
		int size = b - a;
		int r = size - shift;
		int g = gcd(size, r);
		for (int i = 0; i < g; i++) {
			int to = i;
			Object tmp = v.elementAt(a + to);
			for (int from = (to + r) % size; from != i; from = (to + r) % size) {
				v.setElementAt(v.elementAt(a + from), a + to);
				to = from;
			}
			v.setElementAt(tmp, a + to);
		}
	}

	/**
	 * Moves one or more rows from the inclusive range <code>start</code> to
	 * <code>end</code> to the <code>to</code> position in the model. After the
	 * move, the row that was at index <code>start</code> will be at index
	 * <code>to</code>. This method will send a <code>tableChanged</code>
	 * notification message to all the listeners.
	 *
	 * <pre>
	 *  Examples of moves:
	 *
	 *  1. moveRow(1,3,5);
	 *          a|B|C|D|e|f|g|h|i|j|k   - before
	 *          a|e|f|g|h|B|C|D|i|j|k   - after
	 *
	 *  2. moveRow(6,7,1);
	 *          a|b|c|d|e|f|G|H|i|j|k   - before
	 *          a|G|H|b|c|d|e|f|i|j|k   - after
	 * </pre>
	 *
	 * @param start the starting row index to be moved
	 * @param end   the ending row index to be moved
	 * @param to    the destination of the rows to be moved
	 * @exception ArrayIndexOutOfBoundsException if any of the elements would be
	 *                                           moved out of the table's range
	 *
	 */
	public void moveRow(int start, int end, int to) {
		int shift = to - start;
		int first, last;
		if (shift < 0) {
			first = to;
			last = end;
		} else {
			first = start;
			last = to + end - start;
		}
		rotate(dataVector, first, last + 1, shift);

		fireTableRowsUpdated(first, last);
	}

	/**
	 * Removes the row at <code>row</code> from the model. Notification of the row
	 * being removed will be sent to all the listeners.
	 *
	 * @param row the row index of the row to be removed
	 * @exception ArrayIndexOutOfBoundsException if the row was invalid
	 */
	public void removeRow(int row) {
		dataVector.removeElementAt(row);
		fireTableRowsDeleted(row, row);
	}

//
// Manipulating columns
//

	/**
	 * Replaces the column identifiers in the model. If the Integer of
	 * <code>newIdentifier</code>s is greater than the current Integer of columns,
	 * new columns are added to the end of each row in the model. If the Integer of
	 * <code>newIdentifier</code>s is less than the current Integer of columns, all
	 * the extra columns at the end of a row are discarded.
	 *
	 * @param columnIdentifiers vector of column identifiers. If <code>null</code>,
	 *                          set the model to zero columns
	 * @see #setNumRows
	 */
	public void setColumnIdentifiers(Vector columnIdentifiers) {
		setDataVector(dataVector, columnIdentifiers);
	}

	/**
	 * Replaces the column identifiers in the model. If the Integer of
	 * <code>newIdentifier</code>s is greater than the current Integer of columns,
	 * new columns are added to the end of each row in the model. If the Integer of
	 * <code>newIdentifier</code>s is less than the current Integer of columns, all
	 * the extra columns at the end of a row are discarded.
	 *
	 * @param newIdentifiers array of column identifiers. If <code>null</code>, set
	 *                       the model to zero columns
	 * @see #setNumRows
	 */
	public void setColumnIdentifiers(Object[] newIdentifiers) {
		setColumnIdentifiers(convertToVector(newIdentifiers));
	}

	/**
	 * Sets the Integer of columns in the model. If the new size is greater than the
	 * current size, new columns are added to the end of the model with
	 * <code>null</code> cell values. If the new size is less than the current size,
	 * all columns at index <code>columnCount</code> and greater are discarded.
	 *
	 * @param columnCount the new Integer of columns in the model
	 *
	 * @see #setColumnCount
	 * @since 1.3
	 */
	public void setColumnCount(int columnCount) {
		columnIdentifiers.setSize(columnCount);
		justifyRows(0, getRowCount());
		fireTableStructureChanged();
	}

	/**
	 * Adds a column to the model. The new column will have the identifier
	 * <code>columnName</code>, which may be null. This method will send a
	 * <code>tableChanged</code> notification message to all the listeners. This
	 * method is a cover for <code>addColumn(Object, Vector)</code> which uses
	 * <code>null</code> as the data vector.
	 *
	 * @param columnName the identifier of the column being added
	 */
	public void addColumn(Object columnName) {
		addColumn(columnName, (Vector) null);
	}

	/**
	 * Adds a column to the model. The new column will have the identifier
	 * <code>columnName</code>, which may be null. <code>columnData</code> is the
	 * optional vector of data for the column. If it is <code>null</code> the column
	 * is filled with <code>null</code> values. Otherwise, the new data will be
	 * added to model starting with the first element going to row 0, etc. This
	 * method will send a <code>tableChanged</code> notification message to all the
	 * listeners.
	 *
	 * @param columnName the identifier of the column being added
	 * @param columnData optional data of the column being added
	 */
	public void addColumn(Object columnName, Vector columnData) {
		columnIdentifiers.addElement(columnName);
		if (columnData != null) {
			int columnSize = columnData.size();
			if (columnSize > getRowCount()) {
				dataVector.setSize(columnSize);
			}
			justifyRows(0, getRowCount());
			int newColumn = getColumnCount() - 1;
			for (int i = 0; i < columnSize; i++) {
				Vector row = (Vector) dataVector.elementAt(i);
				row.setElementAt(columnData.elementAt(i), newColumn);
			}
		} else {
			justifyRows(0, getRowCount());
		}

		fireTableStructureChanged();
	}

	/**
	 * Adds a column to the model. The new column will have the identifier
	 * <code>columnName</code>. <code>columnData</code> is the optional array of
	 * data for the column. If it is <code>null</code> the column is filled with
	 * <code>null</code> values. Otherwise, the new data will be added to model
	 * starting with the first element going to row 0, etc. This method will send a
	 * <code>tableChanged</code> notification message to all the listeners.
	 *
	 * @see #addColumn(Object, Vector)
	 */
	public void addColumn(Object columnName, Object[] columnData) {
		addColumn(columnName, convertToVector(columnData));
	}

//
// Implementing the TableModel interface
//

	/**
	 * Returns the Integer of rows in this data table.
	 * 
	 * @return the Integer of rows in the model
	 */
	public int getRowCount() {
		return dataVector.size();
	}

	/**
	 * Returns the Integer of columns in this data table.
	 * 
	 * @return the Integer of columns in the model
	 */
	public int getColumnCount() {
		return columnIdentifiers.size();
	}

	/**
	 * Returns the column name.
	 *
	 * @return a name for this column using the string value of the appropriate
	 *         member in <code>columnIdentifiers</code>. If
	 *         <code>columnIdentifiers</code> does not have an entry for this index,
	 *         returns the default name provided by the superclass.
	 */
	public String getColumnName(int column) {
		Object id = null;
		// This test is to cover the case when
		// getColumnCount has been subclassed by mistake ...
		if (column < columnIdentifiers.size() && (column >= 0)) {
			id = columnIdentifiers.elementAt(column);
		}
		return (id == null) ? super.getColumnName(column) : id.toString();
	}

	/**
	 * Returns true regardless of parameter values.
	 *
	 * @param row    the row whose value is to be queried
	 * @param column the column whose value is to be queried
	 * @return true
	 * @see #setValueAt
	 */
	public boolean isCellEditable(int row, int column) {
		if (column == 1 || column == 2)
		{
			
			TempValue = Integer.parseInt(getValueAt(row, column).toString());
			
			System.out.println(TempValue);
		}
			return true;
	}

	/**
	 * Returns an attribute value for the cell at <code>row</code> and
	 * <code>column</code>.
	 *
	 * @param row    the row whose value is to be queried
	 * @param column the column whose value is to be queried
	 * @return the value Object at the specified cell
	 * @exception ArrayIndexOutOfBoundsException if an invalid row or column was
	 *                                           given
	 */
	public Object getValueAt(int row, int column) {
		Vector rowVector = (Vector) dataVector.elementAt(row);
		return rowVector.elementAt(column);
	}

	/**
	 * Sets the object value for the cell at <code>column</code> and
	 * <code>row</code>. <code>aValue</code> is the new value. This method will
	 * generate a <code>tableChanged</code> notification.
	 *
	 * @param aValue the new value; this can be null
	 * @param row    the row whose value is to be changed
	 * @param column the column whose value is to be changed
	 * @exception ArrayIndexOutOfBoundsException if an invalid row or column was
	 *                                           given
	 */
	public void setValueAt(Object aValue, int row, int column) {
		Vector rowVector = (Vector) dataVector.elementAt(row);
		rowVector.setElementAt(aValue, column);
		fireTableCellUpdated(row, column);
	}

//
// Protected Methods
//

	/**
	 * Returns a vector that contains the same objects as the array.
	 * 
	 * @param anArray the array to be converted
	 * @return the new vector; if <code>anArray</code> is <code>null</code>, returns
	 *         <code>null</code>
	 */
	protected static Vector convertToVector(Object[] anArray) {
		if (anArray == null) {
			return null;
		}
		Vector<Object> v = new Vector<Object>(anArray.length);
		for (Object o : anArray) {
			v.addElement(o);
		}
		return v;
	}

	/**
	 * Returns a vector of vectors that contains the same objects as the array.
	 * 
	 * @param anArray the Integer array to be converted
	 * @return the new vector of vectors; if <code>anArray</code> is
	 *         <code>null</code>, returns <code>null</code>
	 */
	protected static Vector convertToVector(Object[][] anArray) {
		if (anArray == null) {
			return null;
		}
		Vector<Vector> v = new Vector<Vector>(anArray.length);
		for (Object[] o : anArray) {
			v.addElement(convertToVector(o));
		}
		return v;
	}

} // End of class DefaultTableModel
