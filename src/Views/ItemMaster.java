package Views;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import accountingproject.DataModelTools;
import accountingproject.DeleteFrame;
import accountingproject.MasterPresistables;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ItemMaster extends JFrame implements MasterPresistables {
	private JPanel contentPane;
	private DTextField GstField, MarginField, CodeBelField, SalesFactField, TaxField, DivisionField, CatagoryField,
			NameField, AliasField, HsnField, PurchaseField, SalesField, MrpField, Unit1Field, Unit2Field, ConvFactField;
	private JButton SaveButton;
	private JTextArea DescArea;
	private DComboBox TypeField, InventoryField;
	private ArrayList<DTextField> ItemFields = new ArrayList<DTextField>();

	public ItemMaster() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1276, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 25));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 505, 0, 199, 139, 123, 131, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		getContentPane().add(lblName, gbc_lblName);

		JLabel lblNewLabel = new JLabel("GST\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblTax = new JLabel("TAX");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblTax = new GridBagConstraints();
		gbc_lblTax.anchor = GridBagConstraints.WEST;
		gbc_lblTax.insets = new Insets(0, 0, 5, 0);
		gbc_lblTax.gridx = 5;
		gbc_lblTax.gridy = 0;
		getContentPane().add(lblTax, gbc_lblTax);

		NameField = new DTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NameField.setColumns(10);
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.gridwidth = 3;
		gbc_NameField.insets = new Insets(0, 0, 5, 5);
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.gridx = 0;
		gbc_NameField.gridy = 1;
		getContentPane().add(NameField, gbc_NameField);
		ItemFields.add(NameField);
		GstField = new DTextField();
		GstField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_GstField_1 = new GridBagConstraints();
		gbc_GstField_1.gridwidth = 2;
		gbc_GstField_1.insets = new Insets(0, 0, 5, 5);
		gbc_GstField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_GstField_1.gridx = 3;
		gbc_GstField_1.gridy = 1;
		getContentPane().add(GstField, gbc_GstField_1);
		GstField.setColumns(10);
		ItemFields.add(GstField);
		TaxField = new DTextField();
		TaxField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TaxField.setColumns(10);
		GridBagConstraints gbc_TaxField_1 = new GridBagConstraints();
		gbc_TaxField_1.insets = new Insets(0, 0, 5, 0);
		gbc_TaxField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_TaxField_1.gridx = 5;
		gbc_TaxField_1.gridy = 1;
		getContentPane().add(TaxField, gbc_TaxField_1);
		ItemFields.add(TaxField);
		JLabel lblAlias_1 = new JLabel("ALIAS");
		lblAlias_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblAlias_1 = new GridBagConstraints();
		gbc_lblAlias_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAlias_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlias_1.gridx = 0;
		gbc_lblAlias_1.gridy = 2;
		getContentPane().add(lblAlias_1, gbc_lblAlias_1);

		JLabel lblHsnCode_2 = new JLabel("HSN CODE");
		lblHsnCode_2.setFont(new Font("Dialog", Font.PLAIN, 25));
		GridBagConstraints gbc_lblHsnCode_2 = new GridBagConstraints();
		gbc_lblHsnCode_2.anchor = GridBagConstraints.WEST;
		gbc_lblHsnCode_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHsnCode_2.gridx = 2;
		gbc_lblHsnCode_2.gridy = 2;
		getContentPane().add(lblHsnCode_2, gbc_lblHsnCode_2);

		JLabel lblAlias = new JLabel("TYPE");
		lblAlias.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblAlias = new GridBagConstraints();
		gbc_lblAlias.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAlias.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlias.gridx = 3;
		gbc_lblAlias.gridy = 2;
		getContentPane().add(lblAlias, gbc_lblAlias);

		JLabel lblHsnCode = new JLabel("Inventory\r\n");
		lblHsnCode.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblHsnCode = new GridBagConstraints();
		gbc_lblHsnCode.fill = GridBagConstraints.BOTH;
		gbc_lblHsnCode.insets = new Insets(0, 0, 5, 0);
		gbc_lblHsnCode.gridx = 5;
		gbc_lblHsnCode.gridy = 2;
		getContentPane().add(lblHsnCode, gbc_lblHsnCode);

		AliasField = new DTextField();
		AliasField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AliasField.setColumns(10);
		GridBagConstraints gbc_AliasField = new GridBagConstraints();
		gbc_AliasField.insets = new Insets(0, 0, 5, 5);
		gbc_AliasField.fill = GridBagConstraints.HORIZONTAL;
		gbc_AliasField.gridx = 0;
		gbc_AliasField.gridy = 3;
		getContentPane().add(AliasField, gbc_AliasField);
		ItemFields.add(AliasField);
		HsnField = new DTextField();
		HsnField.setFont(new Font("Dialog", Font.PLAIN, 25));
		HsnField.setColumns(10);
		GridBagConstraints gbc_HsnField = new GridBagConstraints();
		gbc_HsnField.insets = new Insets(0, 0, 5, 5);
		gbc_HsnField.fill = GridBagConstraints.HORIZONTAL;
		gbc_HsnField.gridx = 2;
		gbc_HsnField.gridy = 3;
		getContentPane().add(HsnField, gbc_HsnField);
		ItemFields.add(HsnField);
		TypeField = new DComboBox();
		TypeField.setFont(new Font("Tahoma", Font.PLAIN, 25));

		TypeField.setModel(new DefaultComboBoxModel(new String[] { "GOODS", "SERVICES" }));
		GridBagConstraints gbc_TypeField = new GridBagConstraints();
		gbc_TypeField.insets = new Insets(0, 0, 5, 5);
		gbc_TypeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TypeField.gridx = 3;
		gbc_TypeField.gridy = 3;
		getContentPane().add(TypeField, gbc_TypeField);

		InventoryField = new DComboBox();
		InventoryField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		InventoryField.setModel(new DefaultComboBoxModel(new String[] { "YES", "NO" }));
		GridBagConstraints gbc_InventoryField = new GridBagConstraints();
		gbc_InventoryField.insets = new Insets(0, 0, 5, 0);
		gbc_InventoryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_InventoryField.gridx = 5;
		gbc_InventoryField.gridy = 3;
		getContentPane().add(InventoryField, gbc_InventoryField);

		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescription.gridwidth = 3;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 4;
		getContentPane().add(lblDescription, gbc_lblDescription);

		JLabel lblHsnCode_1 = new JLabel("DIVISION\r\n");
		lblHsnCode_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblHsnCode_1 = new GridBagConstraints();
		gbc_lblHsnCode_1.anchor = GridBagConstraints.WEST;
		gbc_lblHsnCode_1.gridwidth = 3;
		gbc_lblHsnCode_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblHsnCode_1.gridx = 3;
		gbc_lblHsnCode_1.gridy = 4;
		getContentPane().add(lblHsnCode_1, gbc_lblHsnCode_1);

		DescArea = new JTextArea();
		DescArea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					DivisionField.requestFocus();
				}
			}
		});
		GridBagConstraints gbc_DescArea = new GridBagConstraints();
		gbc_DescArea.gridheight = 3;
		gbc_DescArea.gridwidth = 3;
		gbc_DescArea.insets = new Insets(0, 0, 5, 5);
		gbc_DescArea.fill = GridBagConstraints.BOTH;
		gbc_DescArea.gridx = 0;
		gbc_DescArea.gridy = 5;
		getContentPane().add(DescArea, gbc_DescArea);
		DivisionField = new DTextField();
		DivisionField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_DivisionField = new GridBagConstraints();
		gbc_DivisionField.gridwidth = 3;
		gbc_DivisionField.insets = new Insets(0, 0, 5, 0);
		gbc_DivisionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_DivisionField.gridx = 3;
		gbc_DivisionField.gridy = 5;
		getContentPane().add(DivisionField, gbc_DivisionField);
		DivisionField.setColumns(10);

		ItemFields.add(DivisionField);
		JLabel lblCatagory = new JLabel("CATAGORY\r\n");
		lblCatagory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblCatagory = new GridBagConstraints();
		gbc_lblCatagory.anchor = GridBagConstraints.WEST;
		gbc_lblCatagory.gridwidth = 3;
		gbc_lblCatagory.insets = new Insets(0, 0, 5, 0);
		gbc_lblCatagory.gridx = 3;
		gbc_lblCatagory.gridy = 6;
		getContentPane().add(lblCatagory, gbc_lblCatagory);

		CatagoryField = new DTextField();
		CatagoryField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		CatagoryField.setColumns(10);
		GridBagConstraints gbc_CatagoryField = new GridBagConstraints();
		gbc_CatagoryField.gridwidth = 3;
		gbc_CatagoryField.insets = new Insets(0, 0, 5, 0);
		gbc_CatagoryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CatagoryField.gridx = 3;
		gbc_CatagoryField.gridy = 7;
		getContentPane().add(CatagoryField, gbc_CatagoryField);
		ItemFields.add(CatagoryField);
		JLabel lblPurchaseRate = new JLabel("PURCHASE RATE\r\n");
		lblPurchaseRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPurchaseRate = new GridBagConstraints();
		gbc_lblPurchaseRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPurchaseRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPurchaseRate.gridx = 0;
		gbc_lblPurchaseRate.gridy = 8;
		getContentPane().add(lblPurchaseRate, gbc_lblPurchaseRate);

		JLabel lblSalesRate = new JLabel("SALES RATE\r\n");
		lblSalesRate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblSalesRate = new GridBagConstraints();
		gbc_lblSalesRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSalesRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalesRate.gridx = 1;
		gbc_lblSalesRate.gridy = 8;
		getContentPane().add(lblSalesRate, gbc_lblSalesRate);

		JLabel lblMrp = new JLabel("MRP\r\n");
		lblMrp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblMrp = new GridBagConstraints();
		gbc_lblMrp.insets = new Insets(0, 0, 5, 5);
		gbc_lblMrp.gridx = 2;
		gbc_lblMrp.gridy = 8;
		getContentPane().add(lblMrp, gbc_lblMrp);

		JLabel lblUnit = new JLabel("MARGIN%");
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblUnit = new GridBagConstraints();
		gbc_lblUnit.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUnit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit.gridx = 3;
		gbc_lblUnit.gridy = 8;
		getContentPane().add(lblUnit, gbc_lblUnit);

		JLabel lblUnit_1 = new JLabel("CODE BELONGS");
		lblUnit_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblUnit_1 = new GridBagConstraints();
		gbc_lblUnit_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUnit_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit_1.gridx = 4;
		gbc_lblUnit_1.gridy = 8;
		getContentPane().add(lblUnit_1, gbc_lblUnit_1);

		JLabel lblUnit_2 = new JLabel("SALES FACTOR");
		lblUnit_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblUnit_2 = new GridBagConstraints();
		gbc_lblUnit_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUnit_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblUnit_2.gridx = 5;
		gbc_lblUnit_2.gridy = 8;
		getContentPane().add(lblUnit_2, gbc_lblUnit_2);

		PurchaseField = new DTextField();
		PurchaseField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PurchaseField.setColumns(10);
		GridBagConstraints gbc_PurchaseField = new GridBagConstraints();
		gbc_PurchaseField.insets = new Insets(0, 0, 5, 5);
		gbc_PurchaseField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PurchaseField.gridx = 0;
		gbc_PurchaseField.gridy = 9;
		getContentPane().add(PurchaseField, gbc_PurchaseField);
		ItemFields.add(PurchaseField);
		SalesField = new DTextField();
		SalesField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		SalesField.setColumns(10);
		GridBagConstraints gbc_SalesField = new GridBagConstraints();
		gbc_SalesField.insets = new Insets(0, 0, 5, 5);
		gbc_SalesField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SalesField.gridx = 1;
		gbc_SalesField.gridy = 9;
		getContentPane().add(SalesField, gbc_SalesField);
		ItemFields.add(SalesField);
		MrpField = new DTextField();
		MrpField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MrpField.setColumns(10);
		GridBagConstraints gbc_MrpField = new GridBagConstraints();
		gbc_MrpField.insets = new Insets(0, 0, 5, 5);
		gbc_MrpField.fill = GridBagConstraints.HORIZONTAL;
		gbc_MrpField.gridx = 2;
		gbc_MrpField.gridy = 9;
		getContentPane().add(MrpField, gbc_MrpField);
		ItemFields.add(MrpField);
		MarginField = new DTextField();
		MarginField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MarginField.setColumns(10);
		GridBagConstraints gbc_MarginField = new GridBagConstraints();
		gbc_MarginField.insets = new Insets(0, 0, 5, 5);
		gbc_MarginField.fill = GridBagConstraints.HORIZONTAL;
		gbc_MarginField.gridx = 3;
		gbc_MarginField.gridy = 9;
		getContentPane().add(MarginField, gbc_MarginField);
		ItemFields.add(MarginField);
		CodeBelField = new DTextField();
		CodeBelField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		CodeBelField.setColumns(10);
		GridBagConstraints gbc_CodeBelField = new GridBagConstraints();
		gbc_CodeBelField.insets = new Insets(0, 0, 5, 5);
		gbc_CodeBelField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CodeBelField.gridx = 4;
		gbc_CodeBelField.gridy = 9;
		getContentPane().add(CodeBelField, gbc_CodeBelField);
		ItemFields.add(CodeBelField);
		SalesFactField = new DTextField();
		SalesFactField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		SalesFactField.setColumns(10);
		GridBagConstraints gbc_SalesFactField = new GridBagConstraints();
		gbc_SalesFactField.insets = new Insets(0, 0, 5, 0);
		gbc_SalesFactField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SalesFactField.gridx = 5;
		gbc_SalesFactField.gridy = 9;
		getContentPane().add(SalesFactField, gbc_SalesFactField);
		ItemFields.add(SalesFactField);
		JLabel lblUnit_3 = new JLabel("UNIT 1\r\n");
		lblUnit_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblUnit_3 = new GridBagConstraints();
		gbc_lblUnit_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit_3.gridx = 0;
		gbc_lblUnit_3.gridy = 10;
		getContentPane().add(lblUnit_3, gbc_lblUnit_3);

		JLabel lblUnit_4 = new JLabel("UNIT 2 ");
		lblUnit_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblUnit_4 = new GridBagConstraints();
		gbc_lblUnit_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit_4.gridx = 1;
		gbc_lblUnit_4.gridy = 10;
		getContentPane().add(lblUnit_4, gbc_lblUnit_4);

		JLabel lblConversionFactor = new JLabel("CONVERSION FACTOR\r\n");
		lblConversionFactor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblConversionFactor = new GridBagConstraints();
		gbc_lblConversionFactor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConversionFactor.insets = new Insets(0, 0, 5, 5);
		gbc_lblConversionFactor.gridx = 2;
		gbc_lblConversionFactor.gridy = 10;
		getContentPane().add(lblConversionFactor, gbc_lblConversionFactor);

		Unit1Field = new DTextField();
		Unit1Field.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Unit1Field.setColumns(10);
		GridBagConstraints gbc_Unit1Field = new GridBagConstraints();
		gbc_Unit1Field.insets = new Insets(0, 0, 5, 5);
		gbc_Unit1Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_Unit1Field.gridx = 0;
		gbc_Unit1Field.gridy = 11;
		getContentPane().add(Unit1Field, gbc_Unit1Field);
		ItemFields.add(Unit1Field);
		Unit2Field = new DTextField();
		Unit2Field.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Unit2Field.setColumns(10);
		GridBagConstraints gbc_Unit2Field = new GridBagConstraints();
		gbc_Unit2Field.insets = new Insets(0, 0, 5, 5);
		gbc_Unit2Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_Unit2Field.gridx = 1;
		gbc_Unit2Field.gridy = 11;
		getContentPane().add(Unit2Field, gbc_Unit2Field);
		ItemFields.add(Unit2Field);
		ConvFactField = new DTextField();
		ConvFactField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ConvFactField.setColumns(10);
		GridBagConstraints gbc_ConvFactField = new GridBagConstraints();
		gbc_ConvFactField.insets = new Insets(0, 0, 5, 5);
		gbc_ConvFactField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ConvFactField.gridx = 2;
		gbc_ConvFactField.gridy = 11;
		getContentPane().add(ConvFactField, gbc_ConvFactField);
		ItemFields.add(ConvFactField);
		SaveButton = new JButton("Save");
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_SaveButton = new GridBagConstraints();
		gbc_SaveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SaveButton.gridwidth = 3;
		gbc_SaveButton.insets = new Insets(0, 0, 0, 5);
		gbc_SaveButton.gridx = 0;
		gbc_SaveButton.gridy = 12;
		getContentPane().add(SaveButton, gbc_SaveButton);
		JButton CancelButton = new JButton("Cancel");
		CancelButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_CancelButton.gridwidth = 3;
		gbc_CancelButton.gridx = 3;
		gbc_CancelButton.gridy = 12;
		getContentPane().add(CancelButton, gbc_CancelButton);
	}

	public static void main(String[] args) {

		ItemMaster ip = new ItemMaster();
		ip.deleteRecord();
	}

	@Override
	public void insertRecord() {
		Connection con;
		GstField.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent evt)
		{
			SearchFrame sf = new SearchFrame("ALIAS,NAME","GSTMASTER");
			sf.setVisible(true);
			sf.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt)
				{
					GstField.setText(sf.get("NAME"));
				}
			});
		}
		});
		DivisionField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt)
			{
				SearchFrame sf = new SearchFrame("ALIAS,NAME","DIVISIONMASTER");
				sf.setVisible(true);
				sf.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt)
					{
						DivisionField.setText(sf.get("NAME"));
					}
				});
			}
			});
		CatagoryField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt)
			{
				SearchFrame sf = new SearchFrame("ALIAS,NAME","CATAGORYMASTER");
				sf.setVisible(true);
				sf.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt)
					{
						CatagoryField.setText(sf.get("NAME"));
					}
				});
			}
			});
		Unit1Field.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt)
			{
				SearchFrame sf = new SearchFrame("ALIAS,NAME","UNITMASTER");
				sf.setVisible(true);
				sf.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt)
					{
						Unit1Field.setText(sf.get("NAME"));
					}
				});
			}
			});
		Unit2Field.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt)
			{
				SearchFrame sf = new SearchFrame("ALIAS,NAME","UNITMASTER");
				sf.setVisible(true);
				sf.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt)
					{
						Unit2Field.setText(sf.get("NAME"));
					}
				});
			}
			});
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO ITEMMASTER (NAME,ALIAS,GST,TAXPERC,HSNCODE,DESCRIPTION,DIVISION,CATAGORY,P_RATE,S_RATE,MRP,MARGIN,CODEBELONGS,SALESFACTOR,UNIT_1,UNIT_2,CONVERSIONFACT,TYPE,INVENTORY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			DataModelTools mn = new DataModelTools(con);
			NameField.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AliasField.setText(mn.getAliasName(NameField.getText()));
				}
			});
			setVisible(true);
			SaveButton.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt)
			{
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
				try {
					if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
						NameField.requestFocus();
					} else {
						stmt.setString(1, NameField.getText());
						stmt.setString(2, AliasField.getText());
						stmt.setString(3, GstField.getText());
						stmt.setString(4, TaxField.getText());
						stmt.setString(5, HsnField.getText());
						stmt.setString(6, DescArea.getText());
						stmt.setString(7, DivisionField.getText());
						stmt.setString(8, CatagoryField.getText());
						stmt.setString(9, PurchaseField.getText());
						stmt.setString(10, SalesField.getText());
						stmt.setString(11, MrpField.getText());
						stmt.setString(12, MarginField.getText());
						stmt.setString(13, CodeBelField.getText());
						stmt.setString(14, SalesFactField.getText());
						stmt.setString(15, Unit1Field.getText());
						stmt.setString(16, Unit2Field.getText());
						stmt.setString(17, ConvFactField.getText());
						stmt.setString(18, TypeField.getSelectedItem().toString());
						stmt.setString(19, InventoryField.getSelectedItem().toString());
						if (stmt.executeUpdate() > 0) {
							JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
							NameField.setText("");
							GstField.setText("");
							TaxField.setText("");
							HsnField.setText("");
							DescArea.setText("");
							DivisionField.setText("");
							CatagoryField.setText("");
							PurchaseField.setText("");
							SalesField.setText("");
							MrpField.setText("");
							MarginField.setText("");
							CodeBelField.setText("");
							SalesFactField.setText("");
							Unit1Field.setText("");
							Unit2Field.setText("");
							ConvFactField.setText("");
							AliasField.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Something went wrong");
							NameField.requestFocus();
						}
					}
				} catch (SQLException exception) {
					JOptionPane.showMessageDialog(null, exception.toString());
				}
			}
			}
			});
			SaveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
							NameField.requestFocus();
						} else {
							stmt.setString(1, NameField.getText());
							stmt.setString(2, AliasField.getText());
							stmt.setString(3, GstField.getText());
							stmt.setString(4, TaxField.getText());
							stmt.setString(5, HsnField.getText());
							stmt.setString(6, DescArea.getText());
							stmt.setString(7, DivisionField.getText());
							stmt.setString(8, CatagoryField.getText());
							stmt.setString(9, PurchaseField.getText());
							stmt.setString(10, SalesField.getText());
							stmt.setString(11, MrpField.getText());
							stmt.setString(12, MarginField.getText());
							stmt.setString(13, CodeBelField.getText());
							stmt.setString(14, SalesFactField.getText());
							stmt.setString(15, Unit1Field.getText());
							stmt.setString(16, Unit2Field.getText());
							stmt.setString(17, ConvFactField.getText());
							stmt.setString(18, TypeField.getSelectedItem().toString());
							stmt.setString(19, InventoryField.getSelectedItem().toString());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
								NameField.setText("");
								GstField.setText("");
								TaxField.setText("");
								HsnField.setText("");
								DescArea.setText("");
								DivisionField.setText("");
								CatagoryField.setText("");
								PurchaseField.setText("");
								SalesField.setText("");
								MrpField.setText("");
								MarginField.setText("");
								CodeBelField.setText("");
								SalesFactField.setText("");
								Unit1Field.setText("");
								Unit2Field.setText("");
								ConvFactField.setText("");
								AliasField.setText("");
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
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent evt) {
					try {
						System.out.print("Connection status:");
						con.close();
						System.out.println(con.isClosed());
					} catch (SQLException exception) {
						exception.printStackTrace();
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
		new DeleteFrame("ITEMMASTER");
	}

	@Override
	public void editRecord() {
		SearchFrame sf;
		Connection con;
		try {

			sf = new SearchFrame("ALIAS,NAME", "ITEMMASTER");
			sf.setVisible(true);
			sf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent evt) {
					NameField.setText(sf.get("NAME"));
					GstField.setText(sf.get("GST"));
					TaxField.setText(sf.get("TAXPERC"));
					HsnField.setText(sf.get("HSNCODE"));
					DescArea.setText(sf.get("DESCRIPTION"));
					DivisionField.setText(sf.get("DIVISION"));
					CatagoryField.setText(sf.get("CATAGORY"));
					PurchaseField.setText(sf.get("P_RATE"));
					SalesField.setText(sf.get("S_RATE"));
					MrpField.setText(sf.get("MRP"));
					MarginField.setText(sf.get("MARGIN"));
					CodeBelField.setText(sf.get("CODEBELONG"));
					SalesFactField.setText(sf.get("SALESFACTOR"));
					Unit1Field.setText(sf.get("UNIT_1"));
					Unit2Field.setText(sf.get("UNIT_2"));
					ConvFactField.setText(sf.get("CONVERSIONFACT"));
					AliasField.setText(sf.get(""));
					TypeField.setSelectedItem(sf.get("TYPE"));
					InventoryField.setSelectedItem(sf.get("INVENTORY"));
					setVisible(true);
				}
			});
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE ITEMMASTER SET NAME=?,GST=?,TAXPERC=?,HSNCODE=?,DESCRIPTION=?,DIVISION=?,CATAGORY=?,P_RATE=?,S_RATE=?,MRP=?,MARGIN=?,CODEBELONGS=?,SALESFACTOR=?,UNIT_1=?,UNIT_2=?,CONVERSIONFACT=?,TYPE=?,INVENTORY=? WHERE ALIAS=?");
			DataModelTools mn = new DataModelTools(con);
			AliasField.setEditable(false);
			SaveButton.addKeyListener(new KeyAdapter() {
			public void KeyPressed(KeyEvent evt)
			{
				if(evt.getKeyCode()==evt.VK_ENTER)
				{
					try {
						if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
							NameField.requestFocus();
						} else {
							stmt.setString(1, NameField.getText());
							stmt.setString(2, GstField.getText());
							stmt.setString(3, TaxField.getText());
							stmt.setString(4, HsnField.getText());
							stmt.setString(5, DescArea.getText());
							stmt.setString(6, DivisionField.getText());
							stmt.setString(7, CatagoryField.getText());
							stmt.setString(8, PurchaseField.getText());
							stmt.setString(9, SalesField.getText());
							stmt.setString(10, MrpField.getText());
							stmt.setString(11, MarginField.getText());
							stmt.setString(12, CodeBelField.getText());
							stmt.setString(13, SalesFactField.getText());
							stmt.setString(14, Unit1Field.getText());
							stmt.setString(15, Unit2Field.getText());
							stmt.setString(16, ConvFactField.getText());
							stmt.setString(17, TypeField.getSelectedItem().toString());
							stmt.setString(18, InventoryField.getSelectedItem().toString());
							stmt.setString(19, AliasField.getText());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records UPDATED Successfully");
								NameField.setText("");
								GstField.setText("");
								TaxField.setText("");
								HsnField.setText("");
								DescArea.setText("");
								DivisionField.setText("");
								CatagoryField.setText("");
								PurchaseField.setText("");
								SalesField.setText("");
								MrpField.setText("");
								MarginField.setText("");
								CodeBelField.setText("");
								SalesFactField.setText("");
								Unit1Field.setText("");
								Unit2Field.setText("");
								ConvFactField.setText("");
								AliasField.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "Something went wrong");
								NameField.requestFocus();
							}
						}
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, exception.toString());
					}
				}
			}
			});
			SaveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
							NameField.requestFocus();
						} else {
							stmt.setString(1, NameField.getText());
							stmt.setString(2, GstField.getText());
							stmt.setString(3, TaxField.getText());
							stmt.setString(4, HsnField.getText());
							stmt.setString(5, DescArea.getText());
							stmt.setString(6, DivisionField.getText());
							stmt.setString(7, CatagoryField.getText());
							stmt.setString(8, PurchaseField.getText());
							stmt.setString(9, SalesField.getText());
							stmt.setString(10, MrpField.getText());
							stmt.setString(11, MarginField.getText());
							stmt.setString(12, CodeBelField.getText());
							stmt.setString(13, SalesFactField.getText());
							stmt.setString(14, Unit1Field.getText());
							stmt.setString(15, Unit2Field.getText());
							stmt.setString(16, ConvFactField.getText());
							stmt.setString(17, TypeField.getSelectedItem().toString());
							stmt.setString(18, InventoryField.getSelectedItem().toString());
							stmt.setString(19, AliasField.getText());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records UPDATED Successfully");
								NameField.setText("");
								GstField.setText("");
								TaxField.setText("");
								HsnField.setText("");
								DescArea.setText("");
								DivisionField.setText("");
								CatagoryField.setText("");
								PurchaseField.setText("");
								SalesField.setText("");
								MrpField.setText("");
								MarginField.setText("");
								CodeBelField.setText("");
								SalesFactField.setText("");
								Unit1Field.setText("");
								Unit2Field.setText("");
								ConvFactField.setText("");
								AliasField.setText("");
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
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent evt) {
					try {
						System.out.print("Connection status:");
						con.close();
						System.out.println(con.isClosed());
					} catch (SQLException exception) {
						exception.printStackTrace();
					}
				}
			});
		} catch (SQLException exp) {
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG DATABASE NOT CONNECTED");
		}

	}

	@Override
	public void viewRecord() {
		SaveButton.setEnabled(false);
		SearchFrame sf;
		sf = new SearchFrame("ALIAS,NAME", "ITEMMASTER");
		sf.setVisible(true);
		sf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent evt) {
				NameField.setText(sf.get("NAME"));
				GstField.setText(sf.get("GST"));
				TaxField.setText(sf.get("TAXPERC"));
				HsnField.setText(sf.get("HSNCODE"));
				DescArea.setText(sf.get("DESCRIPTION"));
				DivisionField.setText(sf.get("DIVISION"));
				CatagoryField.setText(sf.get("CATAGORY"));
				PurchaseField.setText(sf.get("P_RATE"));
				SalesField.setText(sf.get("S_RATE"));
				MrpField.setText(sf.get("MRP"));
				MarginField.setText(sf.get("MARGIN"));
				CodeBelField.setText(sf.get("CODEBELONG"));
				SalesFactField.setText(sf.get("SALESFACTOR"));
				Unit1Field.setText(sf.get("UNIT_1"));
				Unit2Field.setText(sf.get("UNIT_2"));
				ConvFactField.setText(sf.get("CONVERSIONFACT"));
				AliasField.setText(sf.get("ALIAS"));
				TypeField.setSelectedItem(sf.get("TYPE"));
				InventoryField.setSelectedItem(sf.get("INVENTORY"));
				setVisible(true);
			}
		});
	}

}
