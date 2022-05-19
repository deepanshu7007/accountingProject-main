package accountingproject;
import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
	gridBagLayout.columnWidths = new int[]{177, 171, 152, 177, 365, 0};
	gridBagLayout.rowHeights = new int[]{37, 0, 0, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
	Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
	InsertButton.setIcon(new ImageIcon(img));
	InsertButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				GroupPanel gp = new GroupPanel("INSERT");
				gp.setVisible(true);
				break;
			}
			case "SUBGROUPMASTER":
			{
				SubGroupPanel sp = new SubGroupPanel("INSERT");
				
				sp.setVisible(true);
				break;
			}
			case "ACCOUNTMASTER":
			{
				AccountPanel ap = new AccountPanel("INSERT");
				
				ap.setVisible(true);
				break;
			}
			case "DIVISIONMASTER":
			{
				DivisionMaster dm = new DivisionMaster();
						dm.insertRecord();
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
				gm.insertRecord();
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
	 img = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		DeleteButton.setIcon(new ImageIcon(img));
	DeleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				DeleteFrame df = new DeleteFrame("GROUPMASTER");
				break;
			}
			case "SUBGROUPMASTER":
			{
				DeleteFrame df = new DeleteFrame("SUBGROUPMASTER");
				break;
			}
			case "ACCOUNTMASTER":
			{
				DeleteFrame df = new DeleteFrame("ACCOUNTMASTER");
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
	 img = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		ViewButton.setIcon(new ImageIcon(img));
	ViewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				GroupPanel gm = new GroupPanel("VIEW");
				break;
			}
			case "SUBGROUPMASTER":
			{
				SubGroupPanel gp = new SubGroupPanel("VIEW");
				break;
			}
			case "ACCOUNTMASTER":
			{
				AccountPanel ap = new AccountPanel("VIEW");
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
	 img = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		ModifyButton.setIcon(new ImageIcon(img));
	ModifyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(title.toUpperCase())
			{
			case "GROUPMASTER":
			{
				GroupPanel gp = new GroupPanel("UPDATE");
				gp.setVisible(true);
				break;
			}
			case "SUBGROUPMASTER":
			{
				SubGroupPanel sp = new SubGroupPanel("MODIFY");
				sp.setVisible(true);
				break;
			}
			case "ACCOUNTMASTER":
			{
				AccountPanel ap = new AccountPanel("UPDATE");
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
				gm.editRecord();
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
	setVisible(true);
}
}