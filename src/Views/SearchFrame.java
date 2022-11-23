package Views;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import LedgerMaster.OpenDataBase;
import accountingproject.DataModelTools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
public class SearchFrame extends JFrame {
	private JTable table;
	private String value;
	private Connection con;
	private JTextField filterText;
	private String tableName;
	private String operationColumn;
	private Map<String,String> ColumnValues;
	 private JRadioButton NameRadioButton,AliasRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public void setNameRadioButton()
	{
		NameRadioButton.setSelected(true);
	}
	public void setOperationColumn(String operationColumn)
	{
		this.operationColumn=operationColumn;
	}
	public String get(String values)
	{
		return ColumnValues.get(values);
	}
	public SearchFrame(String ColumnNames,String tableName)  {
		this.tableName = tableName;
		OpenDataBase db = new OpenDataBase();
		ColumnValues = new HashMap<String,String>();
		 setTitle("Search "+tableName);
		 con = db.getDataBaseConnection();
		 Statement stmt;
		 DefaultTableModel model=null;
		 ResultSet rs;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select "+ColumnNames+" from "+tableName);
			model = new DataModelTools().buildTableModel(rs);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
			System.out.println("DATABASE CONNECTION CLOSED FROM SEARCH FRAME OF :"+tableName);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		table= new JTable(model) {
	    	@Override
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
	    };
	    addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosed(WindowEvent evt)
		{
			
		}
		public void windowOpened(WindowEvent evt)
		{
			filterText.requestFocus();
		}
	    });
		
	    table.setRowHeight(25);
	    table.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	    table.setRowSorter(sorter);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    JScrollPane pane = new JScrollPane(table);
	     getContentPane().add(pane, BorderLayout.CENTER);
	   
	    JPanel panel = new JPanel();
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[]{548, 0, 0};
	    gbl_panel.rowHeights = new int[]{33, 0, 37, 0};
	    gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
	 filterText = new JTextField();
	   filterText.setFont(new Font("Tahoma", Font.PLAIN, 25));
	   GridBagConstraints gbc_filterText = new GridBagConstraints();
	   gbc_filterText.gridwidth = 2;
	   gbc_filterText.insets = new Insets(0, 0, 0, 5);
	   gbc_filterText.anchor = GridBagConstraints.NORTH;
	   gbc_filterText.fill = GridBagConstraints.HORIZONTAL;
	   gbc_filterText.gridx = 0;
	   gbc_filterText.gridy = 2;
	   panel.add(filterText, gbc_filterText);
	   filterText.requestFocusInWindow();
	   filterText.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER &&  filterText.getText().isEmpty())
			{
				table.requestFocus();
			}
			if(e.getKeyChar() == KeyEvent.VK_ENTER|| e.getKeyChar() == KeyEvent.VK_DOWN)
			{
				table.requestFocus();
				table.setRowSelectionInterval(0, 0);
			}	
			String text = filterText.getText();
	       if (text.length() == 0) {
	         sorter.setRowFilter(null);
	       } else {
	         sorter.setRowFilter(RowFilter.regexFilter("^"+text));
	       }
		}
	   	
	   });
	    table.addKeyListener(new KeyAdapter() {
	    	@Override
			public void keyPressed(KeyEvent e)
	    	{
	    		
	    		if(e.getKeyChar()== KeyEvent.VK_ENTER)
	    		{
	    			assigningForm();
	    		}
	    	}
	    });   
	    table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				assigningForm();
			}
		});
	    table.setRowSelectionInterval(0, 0);
	     setSize(1163, 882);
	     filterText.requestFocus();
	}
	public int getSelectedRow()
	{
		return table.getSelectedRow();
	}
	private void assigningForm()
	{
		String type="";
		if(NameRadioButton.isSelected())
		{
type="NAME";
value = table.getValueAt(table.getSelectedRow(),1).toString();
		}
		if(AliasRadioButton.isSelected())
		{
type="ALIAS";
value = table.getValueAt(table.getSelectedRow(),0).toString();
		}
		OpenDataBase db;
		try {
			db = new OpenDataBase();
			
			Statement stmt=db.getDataBaseConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE "+type+"='"+value+"'");
			ResultSetMetaData meta = rs.getMetaData();
			while(rs.next())
			{
				for(int i=1;i<=meta.getColumnCount();i++)
				{
					String key = meta.getColumnName(i);
					String value = rs.getString(key);
					ColumnValues.put(key,value);
				}
			}
			System.out.println(ColumnValues);
			db.ConClosed();
			dispose();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		 
	}
}
