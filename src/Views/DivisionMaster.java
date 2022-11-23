package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accountingproject.DataModelTools;
import accountingproject.DeleteFrame;
import accountingproject.MasterPresistables;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;

/**
 * TODO Put here a description of what this class does.
 *
 * @author LazyDrago
 *         Created Apr 11, 2021.
 */
public class DivisionMaster extends JFrame implements MasterPresistables{
	private JButton SaveButton;
	private JPanel contentPane;
	private DTextField NameField;
	private DTextField AliasField;
	private DTextField DaysField;
	private DComboBox InventoryBox; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivisionMaster frame = new DivisionMaster();
					frame.insertRecord();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DivisionMaster() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 545);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{387, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 75, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Division Master");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		NameField = new DTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.insets = new Insets(0, 0, 5, 0);
		gbc_NameField.fill = GridBagConstraints.BOTH;
		gbc_NameField.gridx = 1;
		gbc_NameField.gridy = 1;
		contentPane.add(NameField, gbc_NameField);
		NameField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alias");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		AliasField = new DTextField();
		AliasField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AliasField.setColumns(10);
		GridBagConstraints gbc_AliasField = new GridBagConstraints();
		gbc_AliasField.insets = new Insets(0, 0, 5, 0);
		gbc_AliasField.fill = GridBagConstraints.BOTH;
		gbc_AliasField.gridx = 1;
		gbc_AliasField.gridy = 3;
		contentPane.add(AliasField, gbc_AliasField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("No. of Days");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 5;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		DaysField = new DTextField();
		DaysField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DaysField.setColumns(10);
		GridBagConstraints gbc_DaysField = new GridBagConstraints();
		gbc_DaysField.insets = new Insets(0, 0, 5, 0);
		gbc_DaysField.fill = GridBagConstraints.BOTH;
		gbc_DaysField.gridx = 1;
		gbc_DaysField.gridy = 5;
		contentPane.add(DaysField, gbc_DaysField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Inventory");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		InventoryBox = new DComboBox();
		InventoryBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		InventoryBox.setModel(new DefaultComboBoxModel(new String[] {"YES", "NO"}));
		GridBagConstraints gbc_InventoryBox = new GridBagConstraints();
		gbc_InventoryBox.insets = new Insets(0, 0, 5, 0);
		gbc_InventoryBox.fill = GridBagConstraints.BOTH;
		gbc_InventoryBox.gridx = 1;
		gbc_InventoryBox.gridy = 7;
		contentPane.add(InventoryBox, gbc_InventoryBox);
		
		SaveButton = new JButton("Save");
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_SaveButton = new GridBagConstraints();
		gbc_SaveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SaveButton.insets = new Insets(0, 0, 0, 5);
		gbc_SaveButton.gridx = 0;
		gbc_SaveButton.gridy = 10;
		contentPane.add(SaveButton, gbc_SaveButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 10;
		contentPane.add(btnCancel, gbc_btnCancel);
	}

	@Override
	public void insertRecord(DefaultTableModel dtm) {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO DIVISIONMASTER (NAME,ALIAS,NO_DAYS,INVENTORY) VALUES (?,?,?,?)");
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
					if(evt.getKeyCode()==KeyEvent.VK_ENTER)
					{
						try {
							if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
								NameField.requestFocus();
							} else {
								stmt.setString(1, NameField.getText());
								stmt.setString(2, AliasField.getText());
								stmt.setString(3, DaysField.getText());
								stmt.setString(4, InventoryBox.getSelectedItem().toString());
								if (stmt.executeUpdate() > 0) {
									JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
									NameField.setText("");
									AliasField.setText("");
									DaysField.setText("");
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
							stmt.setString(3, DaysField.getText());
							stmt.setString(4, InventoryBox.getSelectedItem().toString());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
								NameField.setText("");
								AliasField.setText("");
								DaysField.setText("");
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
					System.out.print("Connection status:");
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
		new DeleteFrame("DivisionMaster",);
	}

	@Override
	public void editRecord() {
		try {
			Connection con;
			AliasField.setEditable(false);
			SearchFrame sf = new SearchFrame("ALIAS,NAME", "DIVISIONMASTER");
			sf.setVisible(true);
			sf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent evt) {
					NameField.setText(sf.get("NAME"));
					AliasField.setText(sf.get("ALIAS"));
					DaysField.setText(sf.get("NO_DAYS"));
					InventoryBox.setSelectedItem(sf.get("INVENTORY"));
					setVisible(true);
				}
			});
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			PreparedStatement stmt = con.prepareStatement("UPDATE DIVISIONMASTER SET NAME=?,NO_DAYS=?,INVENTORY=? WHERE ALIAS=?");
			SaveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
							NameField.requestFocus();
						} else {
							stmt.setString(1, NameField.getText());
							stmt.setString(2, DaysField.getText());
							stmt.setString(3, InventoryBox.getSelectedItem().toString());
							stmt.setString(4,AliasField.getText());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records UPDATED Successfully");
								NameField.setText("");
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

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public void viewRecord() {
		SaveButton.setEnabled(false);
		SearchFrame sf;
		sf = new SearchFrame("ALIAS,NAME", "DIVISIONMASTER");
		sf.setVisible(true);
		sf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent evt) {
				NameField.setText(sf.get("NAME"));
				AliasField.setText(sf.get("ALIAS"));
				DaysField.setText(sf.get("NO_DAYS"));
				InventoryBox.setSelectedItem(sf.get("INVENTORY"));
				setVisible(true);
			}
		});

		
	}

}
