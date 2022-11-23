package Views;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LedgerMaster.OpenDataBase;
import TransactionsMaster.DataBaseModel;
import accountingproject.DataModelTools;
import accountingproject.DeleteFrame;
import accountingproject.MasterPresistables;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
public class GstMaster extends JInternalFrame  implements MasterPresistables{
	private JPanel contentPane;
	private DTextField NameField;
	private DTextField IgstInField;
	private DTextField TaxField;
	private DTextField CessField;
	private DTextField CgstField;
	private DTextField SgstField;
	private DTextField IgstField;
	private DTextField PurcharLclField;
	private DTextField SalesLclField;
	private DTextField PurchaseIntField;
	private DTextField SalesIntField;
	private DTextField IgstOutField;
	private DTextField CgstInField;
	private DTextField CgstOutField;
	private DTextField SgstInField;
	private DTextField SgstOutField;
	private DTextField CessACField;
	private JButton SaveButton;
	
	public GstMaster(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 990, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{270, 225, 206, 216, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("GST Master");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setOpaque(true); 
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		NameField = new DTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.insets = new Insets(0, 0, 5, 5);
		gbc_NameField.gridx = 1;
		gbc_NameField.gridy = 1;
		contentPane.add(NameField, gbc_NameField);
		NameField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("IGST INPUT A/C");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 2;
		gbc_lblNewLabel_1_1.gridy = 1;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		IgstInField = new DTextField();
		IgstInField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		IgstInField.setColumns(10);
		GridBagConstraints gbc_IgstInField = new GridBagConstraints();
		gbc_IgstInField.insets = new Insets(0, 0, 5, 0);
		gbc_IgstInField.fill = GridBagConstraints.HORIZONTAL;
		gbc_IgstInField.gridx = 3;
		gbc_IgstInField.gridy = 1;
		contentPane.add(IgstInField, gbc_IgstInField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tax % age\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 2;
		contentPane.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		TaxField = new DTextField();
		TaxField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TaxField.setColumns(10);
		GridBagConstraints gbc_TaxField = new GridBagConstraints();
		gbc_TaxField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TaxField.insets = new Insets(0, 0, 5, 5);
		gbc_TaxField.gridx = 1;
		gbc_TaxField.gridy = 2;
		contentPane.add(TaxField, gbc_TaxField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("IGST OUTPUT A/C");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		IgstOutField = new DTextField();
		IgstOutField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		IgstOutField.setColumns(10);
		GridBagConstraints gbc_IgstOutField = new GridBagConstraints();
		gbc_IgstOutField.insets = new Insets(0, 0, 5, 0);
		gbc_IgstOutField.fill = GridBagConstraints.HORIZONTAL;
		gbc_IgstOutField.gridx = 3;
		gbc_IgstOutField.gridy = 2;
		contentPane.add(IgstOutField, gbc_IgstOutField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CESS%\r\n");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_2_1.gridy = 3;
		contentPane.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);
		
		CessField = new DTextField();
		CessField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CessField.setColumns(10);
		GridBagConstraints gbc_CessField = new GridBagConstraints();
		gbc_CessField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CessField.insets = new Insets(0, 0, 5, 5);
		gbc_CessField.gridx = 1;
		gbc_CessField.gridy = 3;
		contentPane.add(CessField, gbc_CessField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("CGST INPUT A/C");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		CgstInField = new DTextField();
		CgstInField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CgstInField.setColumns(10);
		GridBagConstraints gbc_CgstInField = new GridBagConstraints();
		gbc_CgstInField.insets = new Insets(0, 0, 5, 0);
		gbc_CgstInField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CgstInField.gridx = 3;
		gbc_CgstInField.gridy = 3;
		contentPane.add(CgstInField, gbc_CgstInField);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("CGST");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1.gridy = 4;
		contentPane.add(lblNewLabel_1_2_1_1, gbc_lblNewLabel_1_2_1_1);
		
		CgstField = new DTextField();
		CgstField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CgstField.setColumns(10);
		GridBagConstraints gbc_CgstField = new GridBagConstraints();
		gbc_CgstField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CgstField.insets = new Insets(0, 0, 5, 5);
		gbc_CgstField.gridx = 1;
		gbc_CgstField.gridy = 4;
		contentPane.add(CgstField, gbc_CgstField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("CGST OUTPUT A/C");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridy = 4;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1);
		
		CgstOutField = new DTextField();
		CgstOutField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CgstOutField.setColumns(10);
		GridBagConstraints gbc_CgstOutField = new GridBagConstraints();
		gbc_CgstOutField.insets = new Insets(0, 0, 5, 0);
		gbc_CgstOutField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CgstOutField.gridx = 3;
		gbc_CgstOutField.gridy = 4;
		contentPane.add(CgstOutField, gbc_CgstOutField);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("SGST\r\n");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1.gridy = 5;
		contentPane.add(lblNewLabel_1_2_1_1_1, gbc_lblNewLabel_1_2_1_1_1);
		
		SgstField = new DTextField();
		SgstField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SgstField.setColumns(10);
		GridBagConstraints gbc_SgstField = new GridBagConstraints();
		gbc_SgstField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SgstField.insets = new Insets(0, 0, 5, 5);
		gbc_SgstField.gridx = 1;
		gbc_SgstField.gridy = 5;
		contentPane.add(SgstField, gbc_SgstField);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("SGST INPUT A/C");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 5;
		contentPane.add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);
		
		SgstInField = new DTextField();
		SgstInField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SgstInField.setColumns(10);
		GridBagConstraints gbc_SgstInField = new GridBagConstraints();
		gbc_SgstInField.insets = new Insets(0, 0, 5, 0);
		gbc_SgstInField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SgstInField.gridx = 3;
		gbc_SgstInField.gridy = 5;
		contentPane.add(SgstInField, gbc_SgstInField);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("IGST");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1.gridy = 6;
		contentPane.add(lblNewLabel_1_2_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1);
		
		IgstField = new DTextField();
		IgstField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		IgstField.setColumns(10);
		GridBagConstraints gbc_IgstField = new GridBagConstraints();
		gbc_IgstField.fill = GridBagConstraints.HORIZONTAL;
		gbc_IgstField.insets = new Insets(0, 0, 5, 5);
		gbc_IgstField.gridx = 1;
		gbc_IgstField.gridy = 6;
		contentPane.add(IgstField, gbc_IgstField);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("SGST OUTPUT A/C");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 6;
		contentPane.add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);
		
		SgstOutField = new DTextField();
		SgstOutField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SgstOutField.setColumns(10);
		GridBagConstraints gbc_SgstOutField = new GridBagConstraints();
		gbc_SgstOutField.insets = new Insets(0, 0, 5, 0);
		gbc_SgstOutField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SgstOutField.gridx = 3;
		gbc_SgstOutField.gridy = 6;
		contentPane.add(SgstOutField, gbc_SgstOutField);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Purchase Account(LOCAL)");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_2_1_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1_1);
		
		PurcharLclField = new DTextField();
		PurcharLclField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		PurcharLclField.setColumns(10);
		GridBagConstraints gbc_PurcharLclField = new GridBagConstraints();
		gbc_PurcharLclField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PurcharLclField.insets = new Insets(0, 0, 5, 5);
		gbc_PurcharLclField.gridx = 1;
		gbc_PurcharLclField.gridy = 7;
		contentPane.add(PurcharLclField, gbc_PurcharLclField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("CESS A/C");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1);
		
		CessACField = new DTextField();
		CessACField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CessACField.setColumns(10);
		GridBagConstraints gbc_CessACField = new GridBagConstraints();
		gbc_CessACField.insets = new Insets(0, 0, 5, 0);
		gbc_CessACField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CessACField.gridx = 3;
		gbc_CessACField.gridy = 7;
		contentPane.add(CessACField, gbc_CessACField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sales Account(LOCAL)");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 8;
		contentPane.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		SalesLclField = new DTextField();
		SalesLclField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SalesLclField.setColumns(10);
		GridBagConstraints gbc_SalesLclField = new GridBagConstraints();
		gbc_SalesLclField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SalesLclField.insets = new Insets(0, 0, 5, 5);
		gbc_SalesLclField.gridx = 1;
		gbc_SalesLclField.gridy = 8;
		contentPane.add(SalesLclField, gbc_SalesLclField);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Purchase Account(INTER STATE)");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_1.gridx = 0;
		gbc_lblNewLabel_1_3_1.gridy = 9;
		contentPane.add(lblNewLabel_1_3_1, gbc_lblNewLabel_1_3_1);
		
		PurchaseIntField = new DTextField();
		PurchaseIntField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		PurchaseIntField.setColumns(10);
		GridBagConstraints gbc_PurchaseIntField = new GridBagConstraints();
		gbc_PurchaseIntField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PurchaseIntField.insets = new Insets(0, 0, 5, 5);
		gbc_PurchaseIntField.gridx = 1;
		gbc_PurchaseIntField.gridy = 9;
		contentPane.add(PurchaseIntField, gbc_PurchaseIntField);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Sales Account(INTER STATE)");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_1_1.gridx = 0;
		gbc_lblNewLabel_1_3_1_1.gridy = 10;
		contentPane.add(lblNewLabel_1_3_1_1, gbc_lblNewLabel_1_3_1_1);
		
		SalesIntField = new DTextField();
		SalesIntField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SalesIntField.setColumns(10);
		GridBagConstraints gbc_SalesIntField = new GridBagConstraints();
		gbc_SalesIntField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SalesIntField.insets = new Insets(0, 0, 5, 5);
		gbc_SalesIntField.gridx = 1;
		gbc_SalesIntField.gridy = 10;
		contentPane.add(SalesIntField, gbc_SalesIntField);
		
		SaveButton = new JButton("SAVE");
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_SaveButton = new GridBagConstraints();
		gbc_SaveButton.fill = GridBagConstraints.BOTH;
		gbc_SaveButton.insets = new Insets(0, 0, 0, 5);
		gbc_SaveButton.gridx = 1;
		gbc_SaveButton.gridy = 11;
		contentPane.add(SaveButton, gbc_SaveButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		dispose();
				
			}
		});
		CancelButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.fill = GridBagConstraints.BOTH;
		gbc_CancelButton.gridx = 2;
		gbc_CancelButton.gridy = 11;
		contentPane.add(CancelButton, gbc_CancelButton);
	}
	@Override
	public void insertRecord(DefaultTableModel dtm) {
		OpenDataBase db = new OpenDataBase();
		Connection con = db.getDataBaseConnection();
		try {			
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO GSTMASTER (NAME,TAX,CESS,IGST,CGST,SGST,PURCHASEACCOUNTIS,SALESACCOUNTIS,IGSTINPUTAC,IGSTOUTPUTAC,SGSTINPUTAC,SGSTOUTPUTAC,CESSAC,CGSTOUTPUTAC,PURCHASEACCOUNTLCL,ALIAS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			setVisible(true);
			SaveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if (NameField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
							NameField.requestFocus();
						} else {
							Vector<String> rowData = new Vector<String>();
							rowData.add(TaxField.getText());
							rowData.add(NameField.getText());
							dtm.addRow(rowData);
						 stmt.setString(1, NameField.getText());
						 stmt.setString(2, TaxField.getText());
						 stmt.setString(3, CessField.getText());
						 stmt.setString(4, IgstField.getText());
						 stmt.setString(5, CgstField.getText());
						 stmt.setString(6, SgstField.getText());
						 stmt.setString(7, PurchaseIntField.getText());
						 stmt.setString(8, SalesIntField.getText());
						 stmt.setString(9, IgstInField.getText());
						 stmt.setString(10, IgstOutField.getText());
						 stmt.setString(11, SgstInField.getText());
						 stmt.setString(12,SgstOutField.getText());
						 stmt.setString(13, CessACField.getText());
						 stmt.setString(14, CgstOutField.getText());
						 stmt.setString(15, PurcharLclField.getText());
						 stmt.setString(16, TaxField.getText());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
								NameField.requestFocus();
								NameField.setText("");           
								IgstInField.setText("");         
								TaxField.setText("");            
								CessField.setText("");           
								CgstField.setText("");           
								SgstField.setText("");           
								IgstField.setText("");           
								PurcharLclField.setText("");     
								SalesLclField.setText("");       
								PurchaseIntField.setText("");    
								SalesIntField.setText("");       
								IgstOutField.setText("");        
								CgstInField.setText("");         
								CgstOutField.setText("");        
								SgstInField.setText("");         
								SgstOutField.setText("");        
								CessACField.setText("");         
							con.close();
							System.out.print("connection closed for GST");
							} else {
								JOptionPane.showMessageDialog(null, "Something went wrong");
								NameField.requestFocus();
							}
						}
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, exception.toString());
					}
				}
			});
		} catch (SQLException exp) {
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG DATABASE NOT CONNECTED");
		}

	}
	@Override
	public void deleteRecord() {
		JFrame frame = new JFrame("DELETE GST");
		frame.setSize(400,400);
		JLabel label = new JLabel("ENTER THE NAME OF GST");
		DTextField field = new DTextField();
		field.setColumns(15);
		JButton deleteButton = new JButton("DELETE");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(field.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "NAME FIELD SHOULD NOT BE EMPTY");
					}
					else {
						if(JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELET THIS RECORD")==JOptionPane.YES_OPTION){
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
						Statement stmt = con.createStatement();
						stmt.executeUpdate("DELETE FROM GSTMASTER WHERE NAME='"+field.getText()+"'");
						con.close();
						}
					}
				} catch (SQLException exception) {
					System.out.println(exception);
					exception.printStackTrace();
				}	
			}
		});
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(label);
		frame.add(field);
		frame.add(deleteButton);
		frame.setVisible(true);
	} 
	@Override
	public void editRecord(DefaultTableModel dtm) {
		SearchFrame sf;
		NameField.setEditable(false);
		
		try {
			OpenDataBase db = new OpenDataBase();
			Connection con = db.getDataBaseConnection();
			sf = new SearchFrame("ALIAS,NAME", "GSTMASTER");sf.setNameRadioButton();
			sf.setVisible(true);
			sf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent evt) {
					NameField.setText(sf.get("NAME"));           
					IgstInField.setText(sf.get("IGSTINPUTAC"));         
					TaxField.setText(sf.get("TAX"));            
					CessField.setText(sf.get("CESS"));           
					CgstField.setText(sf.get("CGST"));           
					SgstField.setText(sf.get("SGST"));           
					IgstField.setText(sf.get("IGST"));           
					PurcharLclField.setText(sf.get("PURCHASEACCOUNTLCL"));     
					SalesLclField.setText(sf.get("SALESACCOUNTLCL"));       
					PurchaseIntField.setText(sf.get("PURCHASEACCOUNTIS"));    
					SalesIntField.setText(sf.get("SALESACCOUNTIS"));       
					IgstOutField.setText(sf.get("IGSTOUTPUTAC"));        
					CgstInField.setText(sf.get("CGSTINPUTAC"));         
					CgstOutField.setText(sf.get("CGSTOUTPUTAC"));        
					SgstInField.setText(sf.get("SGSTINPUTAC"));         
					SgstOutField.setText(sf.get("SGSTOUTPUTAC"));        
					CessACField.setText(sf.get("CESSAC"));    
					setVisible(true);
				}
			});
			
			PreparedStatement stmt = con.prepareStatement(
					
					"UPDATE GSTMASTER SET TAX=?,CESS=?,IGST=?,CGST=?,SGST=?,PURCHASEACCOUNTIS=?,SALESACCOUNTIS=?,IGSTINPUTAC=?,IGSTOUTPUTAC=?,SGSTINPUTAC=?,SGSTOUTPUTAC=?,CESSAC=?,CGSTOUTPUTAC=?,PURCHASEACCOUNTLCL=?,SALESACCOUNTLCL=?,CGSTINPUTAC=? WHERE NAME=?");
			SaveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						if (NameField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
							NameField.requestFocus();
						} else {
							stmt.setString(17, NameField.getText());
							 stmt.setString(1, TaxField.getText());
							 stmt.setString(2, CessField.getText());
							 stmt.setString(3, IgstField.getText());
							 stmt.setString(4, CgstField.getText());
							 stmt.setString(5, SgstField.getText());
							 stmt.setString(6, PurchaseIntField.getText());
							 stmt.setString(7, SalesIntField.getText());
							 stmt.setString(8, IgstInField.getText());
							 stmt.setString(9, IgstOutField.getText());
							 stmt.setString(10, SgstInField.getText());
							 stmt.setString(11,SgstOutField.getText());
							 stmt.setString(12, CessACField.getText());
							 stmt.setString(13, CgstOutField.getText());
							 stmt.setString(14, PurcharLclField.getText());
							 stmt.setString(15, SalesLclField.getText());
							 stmt.setString(16, CgstInField.getText());
							 if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records UPDATED Successfully");
								dtm.setValueAt(TaxField.getText(),sf.getSelectedRow(),0);
								dtm.setValueAt(NameField.getText(),sf.getSelectedRow(),0);
								NameField.requestFocus();
								NameField.setText("");           
								IgstInField.setText("");         
								TaxField.setText("");            
								CessField.setText("");           
								CgstField.setText("");           
								SgstField.setText("");           
								IgstField.setText("");           
								PurcharLclField.setText("");     
								SalesLclField.setText("");       
								PurchaseIntField.setText("");    
								SalesIntField.setText("");       
								IgstOutField.setText("");        
								CgstInField.setText("");         
								CgstOutField.setText("");        
								SgstInField.setText("");         
								SgstOutField.setText("");        
								CessACField.setText("");   
							} else {
								JOptionPane.showMessageDialog(null, "Something went wrong");
								NameField.requestFocus();
							}
						}
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, exception.toString());
					}
				}
			});
			con.close();
		} catch (SQLException exp) {
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG DATABASE NOT CONNECTED");
		}
		
	}
	@Override
	public void viewRecord() {
		SaveButton.setEnabled(false);
		SearchFrame sf;
		sf = new SearchFrame("ALIAS,NAME", "GSTMASTER");
		sf.setVisible(true);
		sf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent evt) {
				NameField.setText(sf.get("NAME"));           
				IgstInField.setText(sf.get("IGSTINPUTAC"));         
				TaxField.setText(sf.get("TAX"));            
				CessField.setText(sf.get("CESS"));           
				CgstField.setText(sf.get("CGST"));           
				SgstField.setText(sf.get("SGST"));           
				IgstField.setText(sf.get("IGST"));           
				PurcharLclField.setText(sf.get("PURCHASEACCOUNTLCL"));     
				SalesLclField.setText(sf.get("SALESACCOUNTLCL"));       
				PurchaseIntField.setText(sf.get("PURCHASEACCOUNTIS"));    
				SalesIntField.setText(sf.get("SALESACCOUNTIS"));       
				IgstOutField.setText(sf.get("IGSTOUTPUTAC"));        
				CgstInField.setText(sf.get("CGSTINPUTAC"));         
				CgstOutField.setText(sf.get("CGSTOUTPUTAC"));        
				SgstInField.setText(sf.get("SGSTINPUTAC"));         
				SgstOutField.setText(sf.get("SGSTOUTPUTAC"));        
				CessACField.setText(sf.get("CESSAC"));    
				setVisible(true);
			}
		});
	}
	
	

}
