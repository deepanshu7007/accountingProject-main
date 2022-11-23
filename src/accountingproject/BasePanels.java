package accountingproject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import LedgerMaster.OpenDataBase;
import Views.AccountPanel;
import Views.CatagoryMaster;
import Views.DivisionMaster;
import Views.GroupPanel;
import Views.ItemMaster;
import Views.SubGroupPanel;
import Views.UnitMaster;
import Views.GstMaster;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
public class BasePanels extends JInternalFrame {
	private DefaultTableModel TableModel;
	private JTable table;
BasePanels(String title)
{
	setLocation(470, 100);
	getContentPane().setBackground(Color.DARK_GRAY);
	setIconifiable(true);
	setClosable(true);
	setTitle("Base Panel");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setSize(871,638);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{177, 171, 152, 177, 199, 0};
	gridBagLayout.rowHeights = new int[]{37, 0, 0, 0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	getContentPane().setLayout(gridBagLayout);
	
	JLabel titleLabel = new JLabel(title);
	titleLabel.setOpaque(true);
	titleLabel.setForeground(Color.WHITE);
	titleLabel.setBackground(Color.DARK_GRAY);
	titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	GridBagConstraints gbc_titleLabel = new GridBagConstraints();
	gbc_titleLabel.gridwidth = 4;
	gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
	gbc_titleLabel.anchor = GridBagConstraints.NORTH;
	gbc_titleLabel.fill = GridBagConstraints.HORIZONTAL;
	gbc_titleLabel.gridx = 0;
	gbc_titleLabel.gridy = 0;
	getContentPane().add(titleLabel, gbc_titleLabel);
	
	JButton InsertButton = new JButton("INSERT");
	
	InsertButton.setMnemonic('I');
	Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
	InsertButton.setIcon(new ImageIcon(img));
	InsertButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				GroupPanel gp = new GroupPanel();
				gp.insertRecord(TableModel);
				getParent().add(gp);
				gp.setVisible(true);
				break;
			}
			case "SUBGROUPMASTER":
			{
				SubGroupPanel sp = new SubGroupPanel();
				sp.insertRecord(TableModel);
				getParent().add(sp);
				sp.setVisible(true);
				break;
			}
			case "ACCOUNTMASTER":
			{
				AccountPanel ap = new AccountPanel();
				ap.insertRecord(TableModel);
				getParent().add(ap);
				ap.setVisible(true);
				break;
			}
			case "DIVISIONMASTER":
			{
				DivisionMaster dm = new DivisionMaster();
						dm.insertRecord(TableModel);
				break;
			}
			case "CATAGORYMASTER":
			{
				CatagoryMaster cm = new CatagoryMaster();
				cm.insertRecord();
				break;
			}
			case "UNITMASTER":
			{
				UnitMaster um = new UnitMaster();
				um.insertRecord();
				break;
			}
			case "ITEMMASTER":
			{
				ItemMaster im = new ItemMaster();
				im.insertRecord();
				break;
			}
			case "GSTMASTER":
			{
				GstMaster gm = new GstMaster();
				
				
				getParent().add(gm);
				gm.insertRecord(TableModel);
				gm.setVisible(true);
				break;
			}
			}
		}
	});
	
	GridBagConstraints gbc_RefreshButton = new GridBagConstraints();
	gbc_RefreshButton.fill = GridBagConstraints.BOTH;
	gbc_RefreshButton.insets = new Insets(0, 0, 5, 0);
	gbc_RefreshButton.gridx = 4;
	gbc_RefreshButton.gridy = 0;
	InsertButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	GridBagConstraints gbc_InsertButton = new GridBagConstraints();
	gbc_InsertButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_InsertButton.insets = new Insets(0, 0, 5, 5);
	gbc_InsertButton.gridx = 0;
	gbc_InsertButton.gridy = 1;
	getContentPane().add(InsertButton, gbc_InsertButton);
	
	JButton DeleteButton = new JButton("DELETE");
	DeleteButton.setMnemonic('D');
	 img = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		DeleteButton.setIcon(new ImageIcon(img));
	DeleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				DeleteFrame df = new DeleteFrame("GROUPMASTER",TableModel);
				break;
			}
			case "SUBGROUPMASTER":
			{
				DeleteFrame df = new DeleteFrame("SUBGROUPMASTER",TableModel);
				break;
			}
			case "ACCOUNTMASTER":
			{
				DeleteFrame df = new DeleteFrame("ACCOUNTMASTER",TableModel);
				break;
			}
			case "DIVISIONMASTER":
			{
				DivisionMaster dm = new DivisionMaster();
				dm.deleteRecord();
				break;
			}
			case "CATAGORYMASTER":
			{
				CatagoryMaster cm = new CatagoryMaster();
				cm.deleteRecord();
				break;
			}
			case "UNITMASTER":
			{
				UnitMaster um = new UnitMaster();
				um.deleteRecord();
				break;
			}
			case "ITEMMASTER":
			{
				ItemMaster im = new ItemMaster();
				im.deleteRecord();
				break;
			}
			case "GSTMASTER":
			{
				GstMaster gm = new GstMaster();
				gm.deleteRecord();
			}
			}
		}
	});
	DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	GridBagConstraints gbc_DeleteButton = new GridBagConstraints();
	gbc_DeleteButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_DeleteButton.insets = new Insets(0, 0, 5, 5);
	gbc_DeleteButton.gridx = 1;
	gbc_DeleteButton.gridy = 1;
	getContentPane().add(DeleteButton, gbc_DeleteButton);
	
	JButton ViewButton = new JButton("VIEW");
	ViewButton.setMnemonic('V');
	 img = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		ViewButton.setIcon(new ImageIcon(img));
	ViewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				GroupPanel gm = new GroupPanel();
				getParent().add(gm);
				gm.viewRecord();
				break;
			}
			case "SUBGROUPMASTER":
			{
				SubGroupPanel gp = new SubGroupPanel();
				gp.viewRecord();
				getParent().add(gp);
				break;
			}
			case "ACCOUNTMASTER":
			{
				AccountPanel ap = new AccountPanel();
				ap.viewRecord();
				getParent().add(ap);
				break;
			}
			case "DIVISIONMASTER":
			{
				DivisionMaster dm= new DivisionMaster();
				dm.viewRecord();
				break;
			}
			case "CATAGORYMASTER":
			{
				CatagoryMaster cm = new CatagoryMaster();
				cm.viewRecord();
				break;
			}
			case "UNITMASTER":
			{
				UnitMaster um = new UnitMaster();
				um.viewRecord();
				break;
			}
			case "ITEMMASTER":
			{
				ItemMaster im = new ItemMaster();
				im.viewRecord();
				break;
			}
			case "GSTMASTER":
			{
				GstMaster gm = new GstMaster();
				gm.viewRecord();
			}
			}
		}
	});
	ViewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	GridBagConstraints gbc_ViewButton = new GridBagConstraints();
	gbc_ViewButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_ViewButton.insets = new Insets(0, 0, 5, 5);
	gbc_ViewButton.gridx = 2;
	gbc_ViewButton.gridy = 1;
	getContentPane().add(ViewButton, gbc_ViewButton);
	
	JButton ModifyButton = new JButton("MODIFY");
	ModifyButton.setMnemonic('M');
	 img = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		ModifyButton.setIcon(new ImageIcon(img));
	ModifyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				GroupPanel gp = new GroupPanel();
				getParent().add(gp);
				gp.editRecord(TableModel);
				gp.setVisible(true);
				break;
			}
			case "SUBGROUPMASTER":
			{
				SubGroupPanel sp = new SubGroupPanel();
				sp.editRecord(TableModel);
				getParent().add(sp);
				sp.setVisible(true);
				break;
			}
			case "ACCOUNTMASTER":
			{
				AccountPanel ap = new AccountPanel();
				getParent().add(ap);
				ap.editRecord(TableModel);
				break;
			}
			case "DIVISIONMASTER":
			{
				DivisionMaster dm = new DivisionMaster();
				dm.editRecord();
				break;
			}
			case "CATAGORYMASTER":
			{
				CatagoryMaster cm = new CatagoryMaster();
				cm.editRecord();
				break;
			}
			case "UNITMASTER":
			{
				UnitMaster um = new UnitMaster();
				um.editRecord();
				break;
			}
			case "ITEMMASTER":
			{
				ItemMaster im = new ItemMaster();
				im.editRecord();
				break;
			}
			case "GSTMASTER":
			{
				GstMaster gm = new GstMaster();
				gm.editRecord(TableModel);
				break;
			}
			}
		}
	});
	ModifyButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	GridBagConstraints gbc_ModifyButton = new GridBagConstraints();
	gbc_ModifyButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_ModifyButton.insets = new Insets(0, 0, 5, 5);
	gbc_ModifyButton.gridx = 3;
	gbc_ModifyButton.gridy = 1;
	getContentPane().add(ModifyButton, gbc_ModifyButton);
	
	JButton BackButton = new JButton("BACK");
	BackButton.setMnemonic('B');
	 img = new ImageIcon(this.getClass().getResource("/previous.png")).getImage();
		BackButton.setIcon(new ImageIcon(img));
	BackButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	BackButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	GridBagConstraints gbc_BackButton = new GridBagConstraints();
	gbc_BackButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_BackButton.insets = new Insets(0, 0, 5, 0);
	gbc_BackButton.gridx = 4;
	gbc_BackButton.gridy = 1;
	getContentPane().add(BackButton, gbc_BackButton);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBackground(Color.GRAY);
	GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	gbc_scrollPane.gridwidth = 5;
	gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
	gbc_scrollPane.fill = GridBagConstraints.BOTH;
	gbc_scrollPane.gridx = 0;
	gbc_scrollPane.gridy = 3;
	getContentPane().add(scrollPane, gbc_scrollPane);
	
	table = new JTable();
	
	table.setForeground(Color.WHITE);
	table.setShowVerticalLines(true);
	table.setShowHorizontalLines(true);
	table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
	table.setRowHeight(35);
	table.setFont(new Font("Garuda", Font.BOLD, 30));
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(true);
	table.setBackground(Color.DARK_GRAY);
	
	scrollPane.setViewportView(table);
	initTableRecord(title);
//	setVisible(true);
	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	          KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
	          getRootPane().getActionMap().put("Cancel", new AbstractAction()
	          { 
	              public void actionPerformed(ActionEvent e)
	              {
	                  dispose();
	              }
	       });
}
private void initTableRecord(String TableName)
{
	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		   @Override
		   protected Void doInBackground() throws Exception {
		    OpenDataBase db = new OpenDataBase();
		    String columnNames[]= {"ALIAS","NAME"};
		    table.setModel(db.getDataBaseModel(columnNames, TableName));
		    table.setShowGrid(true);
		    TableModel = (DefaultTableModel)table.getModel();
		    db.ConClosed();
		    return null;
		   }
		  };
		  
		  worker.execute();
}
}