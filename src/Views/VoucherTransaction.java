package Views;
//FOR THE MODIFICATION FOR THE DEBIT AND CREDIT SIDE OF THE TABLE EDIT THE IS CELL EDITABLE AND ALSO USE JTEXTFIELD TO MODIFY THE TEXT OF THE DEBIT AND CREIDT SIDES

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JDateChooser;
import CheckCodes.MainInintials;
import SearchModule.SearchFrameTest;
public class VoucherTransaction extends JFrame {
	private JPanel contentPane;
	private JTextField NarrationField;
	private JDateChooser textField_1;
	private JFormattedTextField DebitTotalField, CreditTotalField;
	private static ResultSet rs;
	private int row;
	private JTable table;

	public VoucherTransaction(MainInintials mi) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1549, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		CustomTableModel dtm = new CustomTableModel(new Object[][] { { "", new Double(0), new Double(0) } },
				new Object[] { "TRANSACTIONS", "DEBIT", "CREDIT" });
		dtm.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 1) {

					DebitTotalField.setText(String.valueOf(dtm.getTotalDebit()));
				}
				if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {

					CreditTotalField.setText(String.valueOf(dtm.getTotalCredit()));
				}
				if (e.getType() == TableModelEvent.DELETE) {

					DebitTotalField.setText(String.valueOf(dtm.getTotalDebit()));
					CreditTotalField.setText(String.valueOf(dtm.getTotalCredit()));
				}
			}
		});
		JPanel LeftPanel = new JPanel();
		LeftPanel.setBackground(Color.CYAN);
		contentPane.add(LeftPanel, BorderLayout.WEST);
		GridBagLayout gbl_LeftPanel = new GridBagLayout();
		gbl_LeftPanel.columnWidths = new int[] { 190, -11, 0 };
		gbl_LeftPanel.rowHeights = new int[] { 31, 0, 0, 0, 0 };
		gbl_LeftPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_LeftPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		LeftPanel.setLayout(gbl_LeftPanel);

		JLabel lblNewLabel_1_1 = new JLabel("Date");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 0;
		LeftPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textField_1 = new JDateChooser();
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/d");

		textField_1.setDate(dNow);
		textField_1.setFont(new Font("Calibre", Font.PLAIN, 20));
		textField_1.setDateFormatString("yyyy/MM/d");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 1;
		LeftPanel.add(textField_1, gbc_textField_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("TYPE");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 2;
		LeftPanel.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("MODE");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1.gridy = 2;
		LeftPanel.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CV", "JV" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		LeftPanel.add(comboBox, gbc_comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "STANDARD" }));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		LeftPanel.add(comboBox_1, gbc_comboBox_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 287, 229, 0, 189, 0 };
		gbl_panel.rowHeights = new int[] { 37, 37, 37, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_2 = new JLabel("Narrations");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setBackground(Color.GREEN);

		JLabel lblNewLabel = new JLabel("Total Debit");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("(\u20B9)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);

		DebitTotalField = new JFormattedTextField();
		DebitTotalField.setHorizontalAlignment(SwingConstants.RIGHT);
		DebitTotalField.setText("0.00");
		DebitTotalField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DebitTotalField.setEditable(false);
		DebitTotalField.setColumns(10);
		panel_1.add(DebitTotalField);

		JLabel lblNewLabel_1_2 = new JLabel("Total Credit\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("(\u20B9)");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1_3);

		CreditTotalField = new JFormattedTextField();
		CreditTotalField.setHorizontalAlignment(SwingConstants.RIGHT);
		CreditTotalField.setText("0.00");
		CreditTotalField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CreditTotalField.setEditable(false);
		CreditTotalField.setColumns(10);
		panel_1.add(CreditTotalField);

		NarrationField = new JTextField();
		NarrationField.setForeground(Color.WHITE);
		NarrationField.setBackground(Color.BLACK);
		NarrationField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NarrationField.setColumns(10);

		GridBagConstraints gbc_NarrationField = new GridBagConstraints();
		gbc_NarrationField.gridwidth = 4;
		gbc_NarrationField.anchor = GridBagConstraints.NORTH;
		gbc_NarrationField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NarrationField.insets = new Insets(0, 0, 5, 0);
		gbc_NarrationField.gridx = 0;
		gbc_NarrationField.gridy = 1;
		panel.add(NarrationField, gbc_NarrationField);

		JButton btnNewButton = new JButton("EXIT");
		Image img = new ImageIcon(this.getClass().getResource("/previous.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("PRINT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException exception) {
					exception.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_1_1_1 = new JButton("SAVE");
		img = new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		btnNewButton_1_1_1.setIcon(new ImageIcon(img));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DebitTotalField.getText().equals(CreditTotalField.getText())) {
					int row = 0;
					while (row < table.getRowCount()) {
						if (table.getValueAt(row, 0).equals("")) {
							JOptionPane.showMessageDialog(null, "ONE OR MORE TRANSACTION FIELDS ARE EMPTY");
							break;
						}
						row++;
					}

					JOptionPane.showMessageDialog(null, "SUCCESSFULLY SUBMITTED");
				} else {
					JOptionPane.showMessageDialog(null, "Debit and Credit values are not equal");
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1_1_1.gridx = 3;
		gbc_btnNewButton_1_1_1.gridy = 2;
		panel.add(btnNewButton_1_1_1, gbc_btnNewButton_1_1_1);
		JLabel lblNewLabel_3 = new JLabel("VOUCHER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_3, BorderLayout.NORTH);

		table = new JTable();
		table.setShowGrid(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setRowHeight(38);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(dtm);
		table.getTableHeader().setFont(new Font("CALIBRE", Font.BOLD, 29));
		contentPane.add(table, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane(table);

		contentPane.add(scrollPane, BorderLayout.CENTER);

		KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(tab, "Tarverse");
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "Tarverse");
		table.getActionMap().put("Tarverse", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable tab = (JTable) e.getSource();
				if (tab.getRowCount() <= 0) {
					DefaultTableModel dm = (DefaultTableModel) tab.getModel();
					dm.addRow(new Object[] { "", new Double(0), new Double(0) });
				}
				if (tab.isEditing()) {
					tab.getCellEditor().stopCellEditing();
				}
				row = tab.getSelectedRow();
				int col = tab.getSelectedColumn();
				if (col == tab.getColumnCount() - 1 && row == tab.getRowCount() - 1) {
					CustomTableModel dm = (CustomTableModel) tab.getModel();
					dm.addRow(new Object[] { "", new Double(0), new Double(0) });
					tab.changeSelection(row + 1, 0, false, false);

				} else if (col == tab.getColumnCount() - 1) {

					tab.changeSelection(row + 1, 0, false, false);
				} else {
					if (col == 0 && tab.getValueAt(row, 0).equals("")) {
						tab.changeSelection(row, 0, false, false);
					} else
						tab.changeSelection(row, col + 1, false, false);
				}
			}
		});
		Font font = new Font("CALIBRE", Font.PLAIN, 25);
		JTextField TransactionField = new JTextField();
		TransactionField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = mi.getNameByAlias(TransactionField.getText());
				table.setValueAt(obj, table.getSelectedRow(), table.getSelectedColumn());
				if (obj == null) {
					SearchFrameTest sf = new SearchFrameTest(mi.getDataModel());
					sf.setVisible(true);
					sf.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent evt) {
							table.setValueAt(sf.getAliasValue(), table.getSelectedRow(), table.getSelectedColumn());
						}
					});
				}
			}
		});
		TransactionField.setFont(font);
		DefaultCellEditor TransEditor = new DefaultCellEditor(TransactionField);
		table.getColumnModel().getColumn(0).setCellEditor(TransEditor);
		GenericEditor ge = new GenericEditor(table);
		table.getColumnModel().getColumn(1).setCellEditor(new GenericEditor(table));
		table.getColumnModel().getColumn(2).setCellEditor(new GenericEditor(table));
		table.getColumnModel().getColumn(1).setCellRenderer(new DoubleRenderer());
		KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(delete, "Delete");
		table.getActionMap().put("Delete", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable tab = (JTable) e.getSource();
				if (tab.isEditing())
					return;
				else {
					int row = tab.getSelectedRow();
					int col = tab.getSelectedColumn();
					CustomTableModel dm = (CustomTableModel) tab.getModel();
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
	}

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "deepanshu",
					"Anshu123$");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT NAME,ALIAS FROM ACCOUNTMASTER");
//			Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainInintials mi = new MainInintials(rs);
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VoucherTransaction frame = new VoucherTransaction(mi);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class CustomTableModel extends AbstractTableModel implements Serializable {

//
// Instance Variables
//
	protected Double TempValue;

	/**
	 * Returns the value of the field called 'tempValue'.
	 * 
	 * @return Returns the tempValue.
	 */
	public Double getTempValue() {
		return this.TempValue;
	}

	protected double totalDebit = 0.00, totalCredit = 0.00;

	/**
	 * Sets the field called 'totalCredit' to the given value.
	 * 
	 * @param totalCredit The totalCredit to set.
	 */
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}

	/**
	 * Returns the value of the field called 'totalDebit'.
	 * 
	 * @return Returns the totalDebit.
	 */
	public double getTotalDebit() {
		return this.totalDebit;
	}

	public double setTotalDebit(Double totalDebit) {
		return this.totalDebit = totalDebit;
	}

	/**
	 * Returns the value of the field called 'totalCredit'.
	 * 
	 * @return Returns the totalCredit.
	 */
	public double getTotalCredit() {
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
	 * @param rowCount    the number of rows the table holds
	 * @param columnCount the number of columns the table holds
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
	 * @param rowCount    the number of rows the table holds
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
	 * @param rowCount    the number of rows the table holds
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
	public Vector<Vector> getDataVector() {
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
	 * match the number of columns in <code>columnIdentifiers</code> either by
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
		// Set the number of rows for the case when getRowCount
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
	 * Ensures that the new rows have the correct number of columns. This is
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
	 * Sets the number of rows in the model. If the new size is greater than the
	 * current size, new rows are added to the end of the model If the new size is
	 * less than the current size, all rows at index <code>rowCount</code> and
	 * greater are discarded.
	 *
	 * @param rowCount the new number of rows
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
	 * Sets the number of rows in the model. If the new size is greater than the
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
		if (c > 0)
			return getValueAt(0, c).getClass();
		else
			return "".getClass();
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
		Vector deleteRow = (Vector) dataVector.get(row);
		Double debitValue = Double.valueOf(deleteRow.get(1).toString());
		Double creditValue = Double.valueOf(deleteRow.get(2).toString());
		totalDebit = totalDebit - debitValue;
		totalCredit = totalCredit - creditValue;
		dataVector.removeElementAt(row);
		fireTableRowsDeleted(row, row);
	}

//
// Manipulating columns
//

	/**
	 * Replaces the column identifiers in the model. If the number of
	 * <code>newIdentifier</code>s is greater than the current number of columns,
	 * new columns are added to the end of each row in the model. If the number of
	 * <code>newIdentifier</code>s is less than the current number of columns, all
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
	 * Replaces the column identifiers in the model. If the number of
	 * <code>newIdentifier</code>s is greater than the current number of columns,
	 * new columns are added to the end of each row in the model. If the number of
	 * <code>newIdentifier</code>s is less than the current number of columns, all
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
	 * Sets the number of columns in the model. If the new size is greater than the
	 * current size, new columns are added to the end of the model with
	 * <code>null</code> cell values. If the new size is less than the current size,
	 * all columns at index <code>columnCount</code> and greater are discarded.
	 *
	 * @param columnCount the new number of columns in the model
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
	 * Returns the number of rows in this data table.
	 * 
	 * @return the number of rows in the model
	 */
	public int getRowCount() {
		return dataVector.size();
	}

	/**
	 * Returns the number of columns in this data table.
	 * 
	 * @return the number of columns in the model
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
		if (column == 1 || column == 2) {
			TempValue = Double.valueOf(getValueAt(row, column).toString());
//			setValueAt("0",row,column);
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
		if (column == 1)
			setTotalDebit(getTotalDebit() - TempValue + Double.valueOf(aValue.toString()));
		if (column == 2)
			setTotalCredit(getTotalCredit() - TempValue + Double.valueOf(aValue.toString()));
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
	 * @param anArray the double array to be converted
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

class GenericEditor extends DefaultCellEditor {

	Class[] argTypes = new Class[] { String.class };
	java.lang.reflect.Constructor constructor;
	Object value;
	JTable table;

	public GenericEditor(JTable table) {
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
		System.out.println(s);
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
				SwingUtilities2.checkAccess(constructor.getModifiers());
				value = constructor.newInstance(new Object[] { s });
			} else {
				JOptionPane.showMessageDialog(null, "Something went wrong");
				SwingUtilities2.checkAccess(constructor.getModifiers());
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
			ReflectUtil.checkPackageAccess(type);
			SwingUtilities2.checkAccess(type.getModifiers());
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

class NumberRenderer extends DefaultTableCellRenderer.UIResource {
	public NumberRenderer() {
		super();
		setHorizontalAlignment(JLabel.RIGHT);
	}
}

class DoubleRenderer extends NumberRenderer {
	DecimalFormat formatter = new DecimalFormat("");

	public DoubleRenderer() {
		super();
	}

	public void setValue(Object value) {
		if (formatter == null) {
			formatter = new DecimalFormat("");
		}
		setText((value == null || value.equals(0)) ? "" : formatter.format(value));
	}
}
