package Views;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import LedgerMaster.OpenDataBase;
import accountingproject.mainInintials;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AccountPanel extends JFrame {
	protected JTextPane AddressField;
	protected SearchFrame sf;
	protected DTextField NameField;
	protected DTextField SubGroupField;
	protected DTextField PriorityField;
	protected DTextField AliasField;
	protected DTextField UserField;
	protected DTextField GstField;
	protected DTextField StateField;
	protected DTextField CityField;
	protected DTextField PinCodeField;
	protected DTextField EmailField;
	protected DTextField PhoneField;
	protected JTextPane CommentBox;
	protected DTextField PanField, OverdraftField, TinField;
	protected mainInintials.MainTools mi;
	public AccountPanel(String title) {
		
		
		setBounds(100, 100, 859, 725);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 355, 198, 0 };
		gridBagLayout.rowHeights = new int[] { 56, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 37, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel_4 = new JLabel("ACCOUNT MASTER");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SUBGROUP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		NameField = new DTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.insets = new Insets(0, 0, 5, 5);
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.gridx = 0;
		gbc_NameField.gridy = 2;
		getContentPane().add(NameField, gbc_NameField);
		NameField.setColumns(10);

		SubGroupField = new DTextField();
		SubGroupField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_SubGroupField = new GridBagConstraints();
		gbc_SubGroupField.insets = new Insets(0, 0, 5, 0);
		gbc_SubGroupField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SubGroupField.gridx = 1;
		gbc_SubGroupField.gridy = 2;
		getContentPane().add(SubGroupField, gbc_SubGroupField);
		SubGroupField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Priority");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Pan-number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		PriorityField = new DTextField();
		PriorityField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PriorityField.setColumns(10);
		GridBagConstraints gbc_PriorityField = new GridBagConstraints();
		gbc_PriorityField.insets = new Insets(0, 0, 5, 5);
		gbc_PriorityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PriorityField.gridx = 0;
		gbc_PriorityField.gridy = 4;
		getContentPane().add(PriorityField, gbc_PriorityField);

		PanField = new DTextField();
		PanField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PanField.setColumns(10);
		GridBagConstraints gbc_PanField = new GridBagConstraints();
		gbc_PanField.insets = new Insets(0, 0, 5, 0);
		gbc_PanField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PanField.gridx = 1;
		gbc_PanField.gridy = 4;
		getContentPane().add(PanField, gbc_PanField);

		JLabel lblNewLabel_2_1 = new JLabel("Alias");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 5;
		getContentPane().add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("GST-IN\r\n");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1_2.gridx = 1;
		gbc_lblNewLabel_2_1_2.gridy = 5;
		getContentPane().add(lblNewLabel_2_1_2, gbc_lblNewLabel_2_1_2);

		AliasField = new DTextField();
		AliasField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AliasField.setColumns(10);
		GridBagConstraints gbc_AliasField = new GridBagConstraints();
		gbc_AliasField.insets = new Insets(0, 0, 5, 5);
		gbc_AliasField.fill = GridBagConstraints.HORIZONTAL;
		gbc_AliasField.gridx = 0;
		gbc_AliasField.gridy = 6;
		getContentPane().add(AliasField, gbc_AliasField);

		GstField = new DTextField();
		GstField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GstField.setColumns(10);
		GridBagConstraints gbc_GstField = new GridBagConstraints();
		gbc_GstField.insets = new Insets(0, 0, 5, 0);
		gbc_GstField.fill = GridBagConstraints.HORIZONTAL;
		gbc_GstField.gridx = 1;
		gbc_GstField.gridy = 6;
		getContentPane().add(GstField, gbc_GstField);

		JLabel lblNewLabel_2_1_1 = new JLabel("User-Name");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1.gridx = 0;
		gbc_lblNewLabel_2_1_1.gridy = 7;
		getContentPane().add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("STATE");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_1.gridy = 7;
		getContentPane().add(lblNewLabel_2_1_1_1, gbc_lblNewLabel_2_1_1_1);

		UserField = new DTextField();
		UserField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		UserField.setColumns(10);
		GridBagConstraints gbc_UserField = new GridBagConstraints();
		gbc_UserField.insets = new Insets(0, 0, 5, 5);
		gbc_UserField.fill = GridBagConstraints.HORIZONTAL;
		gbc_UserField.gridx = 0;
		gbc_UserField.gridy = 8;
		getContentPane().add(UserField, gbc_UserField);

		StateField = new DTextField();
		StateField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		StateField.setColumns(10);
		GridBagConstraints gbc_StateField = new GridBagConstraints();
		gbc_StateField.insets = new Insets(0, 0, 5, 0);
		gbc_StateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_StateField.gridx = 1;
		gbc_StateField.gridy = 8;
		getContentPane().add(StateField, gbc_StateField);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("CITY\r\n");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1_2.gridx = 0;
		gbc_lblNewLabel_2_1_1_2.gridy = 9;
		getContentPane().add(lblNewLabel_2_1_1_2, gbc_lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("PINCODE");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_1_1.gridy = 9;
		getContentPane().add(lblNewLabel_2_1_1_1_1, gbc_lblNewLabel_2_1_1_1_1);

		CityField = new DTextField();
		CityField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		CityField.setColumns(10);
		GridBagConstraints gbc_CityField = new GridBagConstraints();
		gbc_CityField.insets = new Insets(0, 0, 5, 5);
		gbc_CityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CityField.gridx = 0;
		gbc_CityField.gridy = 10;
		getContentPane().add(CityField, gbc_CityField);

		PinCodeField = new DTextField();
		PinCodeField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PinCodeField.setColumns(10);
		GridBagConstraints gbc_PinCodeField = new GridBagConstraints();
		gbc_PinCodeField.insets = new Insets(0, 0, 5, 0);
		gbc_PinCodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PinCodeField.gridx = 1;
		gbc_PinCodeField.gridy = 10;
		getContentPane().add(PinCodeField, gbc_PinCodeField);

		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Overdraft");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1_2_1.gridx = 0;
		gbc_lblNewLabel_2_1_1_2_1.gridy = 11;
		getContentPane().add(lblNewLabel_2_1_1_2_1, gbc_lblNewLabel_2_1_1_2_1);

		JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Tin Number");
		lblNewLabel_2_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1_1_2_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1_1_2_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_2_1_1.gridy = 11;
		getContentPane().add(lblNewLabel_2_1_1_2_1_1, gbc_lblNewLabel_2_1_1_2_1_1);

		OverdraftField = new DTextField();
		GridBagConstraints gbc_OverdraftField = new GridBagConstraints();
		gbc_OverdraftField.insets = new Insets(0, 0, 5, 5);
		gbc_OverdraftField.fill = GridBagConstraints.HORIZONTAL;
		gbc_OverdraftField.gridx = 0;
		gbc_OverdraftField.gridy = 12;
		getContentPane().add(OverdraftField, gbc_OverdraftField);

		TinField = new DTextField();
		GridBagConstraints gbc_TinField = new GridBagConstraints();
		gbc_TinField.insets = new Insets(0, 0, 5, 0);
		gbc_TinField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TinField.gridx = 1;
		gbc_TinField.gridy = 12;
		getContentPane().add(TinField, gbc_TinField);

		JLabel lblNewLabel_2_1_1_2_1_2 = new JLabel("EMAIL\r\n");
		lblNewLabel_2_1_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_1_2_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1_2_1_2.gridx = 0;
		gbc_lblNewLabel_2_1_1_2_1_2.gridy = 13;
		getContentPane().add(lblNewLabel_2_1_1_2_1_2, gbc_lblNewLabel_2_1_1_2_1_2);

		JLabel lblNewLabel_2_1_1_2_1_1_1 = new JLabel("PHONE-NUMBER\r\n");
		lblNewLabel_2_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2_1_1_2_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1_1_2_1_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_2_1_1_1.gridy = 13;
		getContentPane().add(lblNewLabel_2_1_1_2_1_1_1, gbc_lblNewLabel_2_1_1_2_1_1_1);

		EmailField = new DTextField();
		EmailField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		EmailField.setColumns(10);
		GridBagConstraints gbc_EmailField = new GridBagConstraints();
		gbc_EmailField.insets = new Insets(0, 0, 5, 5);
		gbc_EmailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_EmailField.gridx = 0;
		gbc_EmailField.gridy = 14;
		getContentPane().add(EmailField, gbc_EmailField);

		PhoneField = new DTextField();
		PhoneField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PhoneField.setColumns(10);
		GridBagConstraints gbc_PhoneField = new GridBagConstraints();
		gbc_PhoneField.insets = new Insets(0, 0, 5, 0);
		gbc_PhoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PhoneField.gridx = 1;
		gbc_PhoneField.gridy = 14;
		getContentPane().add(PhoneField, gbc_PhoneField);

		JLabel lblNewLabel_2_1_1_2_1_2_1 = new JLabel("ADDRESS\r\n");
		lblNewLabel_2_1_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2_1_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1_1_2_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1_2_1_2_1.gridx = 0;
		gbc_lblNewLabel_2_1_1_2_1_2_1.gridy = 15;
		getContentPane().add(lblNewLabel_2_1_1_2_1_2_1, gbc_lblNewLabel_2_1_1_2_1_2_1);

		JLabel lblNewLabel_2_1_1_2_1_2_1_1 = new JLabel("COMENT\r\n");
		lblNewLabel_2_1_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_2_1_1_2_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_2_1_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2_1_1_2_1_2_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1_1_2_1_2_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_2_1_2_1_1.gridy = 15;
		getContentPane().add(lblNewLabel_2_1_1_2_1_2_1_1, gbc_lblNewLabel_2_1_1_2_1_2_1_1);

		AddressField = new JTextPane();
		GridBagConstraints gbc_AddressField = new GridBagConstraints();
		gbc_AddressField.insets = new Insets(0, 0, 5, 5);
		gbc_AddressField.fill = GridBagConstraints.BOTH;
		gbc_AddressField.gridx = 0;
		gbc_AddressField.gridy = 16;
		getContentPane().add(AddressField, gbc_AddressField);

		CommentBox = new JTextPane();
		GridBagConstraints gbc_CommentBox = new GridBagConstraints();
		gbc_CommentBox.insets = new Insets(0, 0, 5, 0);
		gbc_CommentBox.fill = GridBagConstraints.BOTH;
		gbc_CommentBox.gridx = 1;
		gbc_CommentBox.gridy = 16;
		getContentPane().add(CommentBox, gbc_CommentBox);

		JButton SaveButton = new JButton("SAVE");
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_SaveButton = new GridBagConstraints();
		gbc_SaveButton.fill = GridBagConstraints.BOTH;
		gbc_SaveButton.insets = new Insets(0, 0, 0, 5);
		gbc_SaveButton.gridx = 0;
		gbc_SaveButton.gridy = 17;
		getContentPane().add(SaveButton, gbc_SaveButton);

		JButton CancelButton = new JButton("CANCEL\r\n");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CancelButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.fill = GridBagConstraints.BOTH;
		gbc_CancelButton.gridx = 1;
		gbc_CancelButton.gridy = 17;
		getContentPane().add(CancelButton, gbc_CancelButton);
		if(title.equals("INSERT"))
		{
			NameField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == e.VK_ENTER) {
						if (NameField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "This Field should not be empty");
							NameField.requestFocus();
						} else {
							OpenDataBase db = new OpenDataBase();
							AliasField.setText(db.getAliasName(NameField.getText()));
							SubGroupField.requestFocus();
						}
					}
				}
			});
			SubGroupField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == e.VK_ENTER) {
						if (e.getKeyChar() == e.VK_ENTER) {
								PriorityField.requestFocus();
								sf = new SearchFrame("ALIAS,NAME","SUBGROUPMASTER");
								sf.setVisible(true);
								sf.addWindowListener(new WindowAdapter() {
									public void windowClosed(WindowEvent e) {
										SubGroupField.setText(sf.get("NAME"));
									}
								});
							}
					}
				}
			});
			SaveButton.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == e.VK_ENTER) {
						if(NameField.getText().isEmpty()||AliasField.getText().isEmpty()||PriorityField.getText().isEmpty()||SubGroupField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
						}else
						InsertTable();
					}
				}
			});
			SaveButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
						if(NameField.getText().isEmpty()||AliasField.getText().isEmpty()||PriorityField.getText().isEmpty()||SubGroupField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
						}else
						InsertTable();
					
				}
			});
		}
		if(title.equals("UPDATE"))
		{
			AliasField.setEditable(false);
			setVisible(true);
			sf = new SearchFrame("ALIAS,NAME","ACCOUNTMASTER");
			sf.setVisible(true);
			
			sf.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e)
				{
					NameField.requestFocus();
					NameField.setText(sf.get("NAME"));
					 AliasField.setText(sf.get("ALIAS"));
					SubGroupField.setText(sf.get("SUBGROUP"));
					AddressField.setText(sf.get("ADDRESS"));
					CityField.setText(sf.get("CITY"));
					StateField.setText(sf.get("STATE"));
					PinCodeField.setText(sf.get("PINCODE"));
					PhoneField.setText(sf.get("PHONE"));
					EmailField.setText(sf.get("E_MAIL"));
					 PanField.setText(sf.get("PANNUM"));
					 TinField.setText(sf.get("TANNUM"));
					 GstField.setText(sf.get("GSTNUM"));
					 UserField.setText(sf.get("USER_IN"));
					 OverdraftField.setText(sf.get("OP_BAL"));
					 CommentBox.setText(sf.get("COMMENT"));
					 PriorityField.setText(sf.get("PRIORITY"));
				}
			});
			SaveButton.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == e.VK_ENTER) {
						if(NameField.getText().isEmpty()||AliasField.getText().isEmpty()||PriorityField.getText().isEmpty()||SubGroupField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
						}else
						UpdateTable();
					}
				}
			});
			SaveButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						if(NameField.getText().isEmpty()||AliasField.getText().isEmpty()||PriorityField.getText().isEmpty()||SubGroupField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
						}else
						UpdateTable();
					
					
				}
			});
			
			NameField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == e.VK_ENTER) {
						if (NameField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "This Field should not be empty");
							NameField.requestFocus();
						} else {
							SubGroupField.requestFocus();
						}
					}
				}
			});
			SubGroupField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == e.VK_ENTER) {
						if (e.getKeyChar() == e.VK_ENTER) {
							
								PriorityField.requestFocus();
								sf = new SearchFrame("ALIAS,NAME","SubGroupMaster");
								sf.setVisible(true);
								sf.addWindowListener(new WindowAdapter() {
									public void windowClosed(WindowEvent e) {
										SubGroupField.setText(sf.get("NAME"));
									}
								});
							}
					}
				}
			});
		}
		if(title.equals("VIEW"))
		{
			NameField.setEditable(false);
			 AliasField.setEditable(false);
			SubGroupField.setEditable(false);
			AddressField.setEditable(false);
			CityField.setEditable(false);
			StateField.setEditable(false);
			PinCodeField.setEditable(false);
			PhoneField.setEditable(false);
			EmailField.setEditable(false);
			 PanField.setEditable(false);
			 TinField.setEditable(false);
			 GstField.setEditable(false);
			 UserField.setEditable(false);
			 OverdraftField.setEditable(false);
			 CommentBox.setEditable(false);
			AliasField.setEditable(false);
			PriorityField.setEditable(false);
			setVisible(true);
			sf = new SearchFrame("ALIAS,NAME","ACCOUNTMASTER");
			sf.setVisible(true);
			
			sf.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e)
				{
					NameField.setText(sf.get("NAME"));
					 AliasField.setText(sf.get("ALIAS"));
					SubGroupField.setText(sf.get("SUBGROUP"));
					AddressField.setText(sf.get("ADDRESS"));
					CityField.setText(sf.get("CITY"));
					StateField.setText(sf.get("STATE"));
					PinCodeField.setText(sf.get("PINCODE"));
					PhoneField.setText(sf.get("PHONE"));
					EmailField.setText(sf.get("E_MAIL"));
					 PanField.setText(sf.get("PANNUM"));
					TinField.setText(sf.get("TANNUM"));
					 GstField.setText(sf.get("GSTNUM"));
					 UserField.setText(sf.get("USER_IN"));
					 OverdraftField.setText(sf.get("OP_BAL"));
					 CommentBox.setText(sf.get("COMMENT"));
					 PriorityField.setText(sf.get("PRIORITY"));
				}
			});
		}
}
void UpdateTable()
{
	try {
		OpenDataBase db = new OpenDataBase();
		PreparedStatement stmt = db.getDataBaseConnection().prepareStatement(
				"UPDATE ACCOUNTMASTER SET NAME=?,SUBGROUP=?,ADDRESS=?,CITY=?,STATE=?,PINCODE=?,PHONE=?,E_MAIL=?,PANNUM=?,TANNUM=?,GSTNUM=?,USER_IN=?,OP_BAL=?,COMMENT=?,PRIORITY=? WHERE ALIAS=?");
		stmt.setString(1, NameField.getText());
		stmt.setString(16, AliasField.getText());
		stmt.setString(2, SubGroupField.getText());
		stmt.setString(3, AddressField.getText());
		stmt.setString(4, CityField.getText());
		stmt.setString(5, StateField.getText());
		stmt.setString(6, PinCodeField.getText());
		stmt.setString(7, PhoneField.getText());
		stmt.setString(8, EmailField.getText());
		stmt.setString(9, PanField.getText());
		stmt.setString(10, TinField.getText());
		stmt.setString(11, GstField.getText());
		stmt.setString(12, UserField.getText());
		stmt.setString(13, OverdraftField.getText());
		stmt.setString(14, CommentBox.getText());
		stmt.setString(15, PriorityField.getText());
		if (stmt.executeUpdate() > 0) {
			
			NameField.requestFocus();
			JOptionPane.showMessageDialog(null, "Record UPDATED successfully");
			NameField.setText("");
			AliasField.setText("");
			SubGroupField.setText("");
			AddressField.setText("");
			CityField.setText("");
			StateField.setText("");
			PinCodeField.setText("");
			PhoneField.setText("");
			EmailField.setText("");
			 PanField.setText("");
			 TinField.setText("");
			 GstField.setText("");
			 UserField.setText("");
			 OverdraftField.setText("");
			 CommentBox.setText("");
			 PriorityField.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Something Went Wrong");
		}
		db.ConClosed();
	} catch (SQLException exception) {
		if (exception.getErrorCode() == 1062) {
			JOptionPane jp = new JOptionPane();
			addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					e.consume();
					NameField.requestFocusInWindow();
				}
			});
			jp.showMessageDialog(null, "Alias Name ' " + AliasField.getText() + " ' already exists");
		}
		exception.printStackTrace();
	}
}
	void InsertTable() {
		try {
			OpenDataBase db = new OpenDataBase();
			PreparedStatement stmt = db.getDataBaseConnection().prepareStatement(
					"INSERT INTO ACCOUNTMASTER(NAME,ALIAS,SUBGROUP,ADDRESS,CITY,STATE,PINCODE,PHONE,E_MAIL,PANNUM,TANNUM,GSTNUM,USER_IN,OP_BAL,COMMENT,PRIORITY) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, NameField.getText());
			stmt.setString(2, AliasField.getText());
			stmt.setString(3, SubGroupField.getText());
			stmt.setString(4, AddressField.getText());
			stmt.setString(5, CityField.getText());
			stmt.setString(6, StateField.getText());
			stmt.setString(7, PinCodeField.getText());
			stmt.setString(8, PhoneField.getText());
			stmt.setString(9, EmailField.getText());
			stmt.setString(10, PanField.getText());
			stmt.setString(11, TinField.getText());
			stmt.setString(12, GstField.getText());
			stmt.setString(13, UserField.getText());
			stmt.setString(14, OverdraftField.getText());
			stmt.setString(15, CommentBox.getText());
			stmt.setString(16,PriorityField.getText());
			if (stmt.executeUpdate() > 0) {
				NameField.requestFocus();
				JOptionPane.showMessageDialog(null, "Record Inserted successfully");
				NameField.setText("");
				AliasField.setText("");
				SubGroupField.setText("");
				AddressField.setText("");
				CityField.setText("");
				StateField.setText("");
				PinCodeField.setText("");
				PhoneField.setText("");
				EmailField.setText("");
				 PanField.setText("");
				 TinField.setText("");
				 GstField.setText("");
				 UserField.setText("");
				 OverdraftField.setText("");
				 CommentBox.setText("");
				 PriorityField.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong");
			}
			db.ConClosed();
			System.out.println("CONNECTION CLOSED FOR ACCOUNT MASTER INSERT");
		} catch (SQLException exception) {
			if (exception.getErrorCode() == 1062) {
				JOptionPane jp = new JOptionPane();
				addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						e.consume();
						NameField.requestFocusInWindow();
					}
				});
				jp.showMessageDialog(null, "Alias Name ' " + AliasField.getText() + " ' already exists");
			}
			exception.printStackTrace();
		}
	}
}
