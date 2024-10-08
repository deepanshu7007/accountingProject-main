package SearchModule;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;

public class SearchFrameTest extends JFrame {
	private String alias;
	private String Name;
	private Vector<Object> SelectedRow;
	/**
	 * Returns the value of the field called 'selectedRow'.
	 * @return Returns the selectedRow.
	 */
	public Vector<Object> getSelectedRow() {
		return this.SelectedRow;
	}

	private JTable table;
	private JTextField FilterText;
	/**
	 * Sets the field called 'filterText' to the given value.
	 * @param filterText The filterText to set.
	 */
	public void setFilterText(String filterText) {
		this.FilterText.setText(filterText);
	}

	private TableRowSorter<TableModel> sorter;
	
	JTable getTable() {
		return table;
	}

	public SearchFrameTest(SearchTableModel dtm) {
		alias="";
		SelectedRow = new Vector<Object>();
		table = new JTable(dtm) {
			@Override
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "Enter");
		table.getActionMap().put("Enter", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				Name = (table.getValueAt(table.getSelectedRow(), 1).toString());
				alias = (table.getValueAt(table.getSelectedRow(), 0).toString());
				SelectedRow.add(alias);
				SelectedRow.add(Name);
				dispose();
				}
				catch(ArrayIndexOutOfBoundsException exp)
				{
					JOptionPane.showMessageDialog(null, "NO RECORD FOUND");
					FilterText.setText("");
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent evt)
		{
			alias = (table.getValueAt(table.getSelectedRow(), 0).toString());
			Name = (table.getValueAt(table.getSelectedRow(), 1).toString());
			SelectedRow.add(alias);
			SelectedRow.add(Name);
			dispose();
		}
		});
		
		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		getContentPane().add(pane, BorderLayout.CENTER);
		sorter = new TableRowSorter<TableModel>();
		table.setRowSorter(sorter);
		sorter.setModel(dtm);
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 548, 0, 0 };
		gbl_panel.rowHeights = new int[] { 33, 0, 37, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel rdbtnNewRadioButton = new JLabel("Search");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		FilterText = new JTextField();
		FilterText.setFont(new Font("Tahoma", Font.PLAIN, 25));
		FilterText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER && FilterText.getText().isEmpty()) {
					table.requestFocus();
				}
				if (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyChar() == KeyEvent.VK_DOWN) {
					table.requestFocus();
					try {
					table.setRowSelectionInterval(0, 0);
					}catch(IllegalArgumentException exp)
					{
						System.out.println("Something went wrong");
						JOptionPane.showMessageDialog(null, "RECORD NOT FOUND");
						FilterText.setText("");
						FilterText.requestFocus();
					}
					}
				String text = FilterText.getText();
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("^" + text));
				}
			}
		});
		FilterText.getDocument().addDocumentListener(new DocumentListener() {
	         @Override
	         public void insertUpdate(DocumentEvent e) {
	            search(FilterText.getText());
	         }
	         @Override
	         public void removeUpdate(DocumentEvent e) {
	            search(FilterText.getText());
	         }
	         @Override
	         public void changedUpdate(DocumentEvent e) {
	            search(FilterText.getText());
	         }
	         public void search(String str) {
	            if (str.length() == 0) {
	               sorter.setRowFilter(null);
	            } else {
	               sorter.setRowFilter(RowFilter.regexFilter(str));
	            }
	         }
	      });
		GridBagConstraints gbc_FilterText = new GridBagConstraints();
		gbc_FilterText.gridwidth = 2;
		gbc_FilterText.insets = new Insets(0, 0, 0, 5);
		gbc_FilterText.anchor = GridBagConstraints.NORTH;
		gbc_FilterText.fill = GridBagConstraints.HORIZONTAL;
		gbc_FilterText.gridx = 0;
		gbc_FilterText.gridy = 2;
		panel.add(FilterText, gbc_FilterText);
		FilterText.requestFocus();
		setSize(1163, 882);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public String getAliasName() {
		return table.getValueAt(table.getSelectedRow(), 0).toString();
		
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public String getAccountName() {
		return table.getValueAt(table.getSelectedRow(), 1).toString();
	}
}