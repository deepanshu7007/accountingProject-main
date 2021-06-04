package TransactionsMaster;
//FOR THE MODIFICATION FOR THE DEBIT AND CREDIT SIDE OF THE TABLE EDIT THE IS CELL EDITABLE AND ALSO USE JTEXTFIELD TO MODIFY THE TEXT OF THE DEBIT AND CREIDT SIDES

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import com.toedter.calendar.*;

import SearchModule.SearchFrameTest;
import SearchModule.SearchTableModel;
import Views.DTextField;
import sun.reflect.misc.ReflectUtil;
import sun.swing.SwingUtilities2;

public class VoucherTransaction extends JFrame {
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private Connection con;
	/**
	 * Returns the value of the field called 'con'.
	 * @return Returns the con.
	 */
	public Connection getCon() {
		return this.con;
	}

	private JTextField NarrationField;
	
	public JTextField getNarrationField() {
		return this.NarrationField;
	}

	private JDateChooser textField_1;
	/**
	 * Returns the value of the field called 'textField_1'.
	 * @return Returns the textField_1.
	 */
	public Date getDate() {
		return this.textField_1.getDate();
	}

	private JFormattedTextField DebitTotalField, CreditTotalField;
	private int row;
	private JTable table;
	
	private SearchTableModel SearchModel;
private JComboBox<String> comboBox_1;
private CustomTableModel dtm;
	public void setSearchModel(SearchTableModel SearchModel) {
		this.SearchModel = SearchModel;
	}

	public VoucherTransaction(Connection con) {
		this.con=con;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1549, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		DataEntry de = new DataEntry("", 0.0, 0.0);
		ArrayList<DataEntry> arr = new ArrayList<DataEntry>();
		arr.add(de);
		 dtm = new CustomTableModel(arr);
		dtm.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {

				if (e.getType() == TableModelEvent.UPDATE) {
					DebitTotalField.setText(String.valueOf(dtm.getTotalDebit()));
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
		textField_1.setDate(dNow);
		textField_1.setFont(new Font("Calibre", Font.PLAIN, 20));
		textField_1.setDateFormatString("d/MM/yyyy");
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

		 comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CV", "JV" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		LeftPanel.add(comboBox, gbc_comboBox);

		comboBox_1 = new JComboBox<>();
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException exception) {
					// TODO Auto-generated catch-block stub.
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
				try {
					int row = 0;
					while (row < table.getRowCount()) {
						if (table.getValueAt(row, 0).equals("")) {
							throw new Exception("One or More Transaction Fields are empty");
						}
						row++;
					}
					if (DebitTotalField.getText().equals(CreditTotalField.getText())) {
						CommitTheVoucher();
						JOptionPane.showMessageDialog(null, "SUCCESSFULLY SUBMITTED");
					}
					else
					{
						throw new Exception("Debit and Credit Values are not Equal");
					}
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
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
					DataEntry de = new DataEntry("", 0.0, 0.0);
					dm.addRow(de);
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
		TransactionField.setFont(font);
		DefaultCellEditor TransEditor = new DefaultCellEditor(TransactionField);
		TransEditor.addCellEditorListener(new CellEditorListener() {

			@Override
			public void editingStopped(ChangeEvent e) {
				SearchFrameTest ft;
				ft = new SearchFrameTest(SearchModel);
				if (!SearchModel.checkAlias(TransactionField.getText())) {
					ft.setFilterText(TransactionField.getText());
					ft.setVisible(true);
					ft.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt)
					{
						dtm.nextSetValueAt(ft.getSelectedRow(), table.getSelectedRow(), table.getSelectedColumn());
					}
					});
				} else {
					Object AliasName = TransactionField.getText();
					Object Name = SearchModel.getNameByAlias(AliasName.toString());
					Vector<Object> row = new Vector<Object>();
					row.add(AliasName);
					row.add(Name);
					dtm.nextSetValueAt(row, table.getSelectedRow(), table.getSelectedColumn());
				}
			}
			@Override
			public void editingCanceled(ChangeEvent e) {}
		});
		table.getColumnModel().getColumn(0).setCellEditor(TransEditor);
		GenericEditorForFields ge = new GenericEditorForFields(table);
		table.getColumnModel().getColumn(1).setCellEditor(new GenericEditorForFields(table));
		table.getColumnModel().getColumn(2).setCellEditor(new GenericEditorForFields(table));
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
	public void CommitTheVoucher() {
		Connection Con = getCon();
		String Nar = getNarrationField().getText();
		Date date = getDate();
		ArrayList<DataEntry> arr = dtm.getDataEntryList();
		String SelectedItem = comboBox.getSelectedItem().toString();
		try {
			System.out.println(Con.isClosed());
		} catch (SQLException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		DataBaseModel dbm = new DataBaseModel(Con, arr,  date,  Nar,SelectedItem ); 
		}
}


