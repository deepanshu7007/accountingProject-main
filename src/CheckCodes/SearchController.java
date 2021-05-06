package CheckCodes;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;

class SearchFrameTest extends JFrame {

	private JTable table;
	private JTextField FilterText;
	private JRadioButton NameRadioButton, AliasRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private TableRowSorter<TableModel> sorter;
	public  TableRowSorter<TableModel> getSorter()
	{
		return sorter;
	}
	JTable getTable() {
		return table;
	}

	public SearchFrameTest(SearchController sc) {
		table = new JTable() {
			@Override
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		table.addMouseListener(sc);
		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		getContentPane().add(pane, BorderLayout.CENTER);
		sorter = new TableRowSorter<TableModel>();
		table.addKeyListener(sc);
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

		NameRadioButton = new JRadioButton("NAME");
		buttonGroup.add(NameRadioButton);
		GridBagConstraints gbc_NameRadioButton = new GridBagConstraints();
		gbc_NameRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_NameRadioButton.gridx = 0;
		gbc_NameRadioButton.gridy = 1;
		panel.add(NameRadioButton, gbc_NameRadioButton);

		AliasRadioButton = new JRadioButton("ALIAS");
		AliasRadioButton.setSelected(true);
		buttonGroup.add(AliasRadioButton);
		GridBagConstraints gbc_AliasRadioButton = new GridBagConstraints();
		gbc_AliasRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_AliasRadioButton.gridx = 1;
		gbc_AliasRadioButton.gridy = 1;
		panel.add(AliasRadioButton, gbc_AliasRadioButton);
		FilterText = new JTextField();
		FilterText.setFont(new Font("Tahoma", Font.PLAIN, 25));
		FilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER && FilterText.getText().isEmpty()) {
					table.requestFocus();
				}
				if (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyChar() == KeyEvent.VK_DOWN) {
					table.requestFocus();
					table.setRowSelectionInterval(0, 0);
				}
				String text = FilterText.getText();
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("^" + text));
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
		FilterText.requestFocusInWindow();
		setSize(1163, 882);
		FilterText.requestFocus();
		
	}
}

/*
 * Here we are creating two constructors [SearchFrameTest()]one is for which we
 * are creating an object for SearchFrame [SearchFrameTest(ResultSet rs)]And One
 * is for All the Other Classes who are going to pass their result set in
 * it{Later on we can also convert it into another object but currently we are
 * focusing on constructor} The second Constructor will call the first
 * constructor in order to create the SearchFrameTest object
 */
public class SearchController implements MouseListener ,KeyListener{
	private SearchFrameTest sf;
	private String AliasName;
	private JTextComponent[] fields;
	private MainInintials mi;
	public SearchController(DefaultTableModel  mi) {
					sf=new SearchFrameTest(this);
					DefaultTableModel dm = mi;
					sf.getTable().setModel(dm);
					TableRowSorter<TableModel> sorter=sf.getSorter();
					sorter.setModel(dm);
					sf.getTable().setRowSorter(sorter);
					sf.setVisible(true);
					sf.getTable().setRowSelectionInterval(0,0);
			
	}

//	public static void main(String[] args) {
//		new SearchController();
//	}
public void setMainInintials(MainInintials mi)
{
	this.mi = mi;
}
	public void assignFields(JTextComponent ... fields) {
		this.fields = fields;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table = sf.getTable();
		AliasName = table.getValueAt(table.getSelectedRow(), 1).toString();
		assignValuesToField();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void assignValuesToField() {
		Map<String, Object> ResultMap = mi.getValuesByAlias(AliasName);
		for (JTextComponent field : this.fields) {
			field.setText(ResultMap.get(field.getName()).toString());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			JTable table = sf.getTable();
			AliasName = table.getValueAt(table.getSelectedRow(), 1).toString();
			assignValuesToField();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {	}
}
