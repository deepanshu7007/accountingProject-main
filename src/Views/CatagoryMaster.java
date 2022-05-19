package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created Apr 11, 2021.
 */
public class CatagoryMaster extends JFrame implements MasterPresistables{

	private JPanel contentPane;
	private DTextField NameField;
	private DTextField AliasField;
	private DTextField GstField;
	private JButton SaveButton;
	private DComboBox IdBox;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatagoryMaster frame = new CatagoryMaster();
					frame.editRecord();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CatagoryMaster() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 794, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{402, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("CatagroyMaster");
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
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		NameField = new DTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.insets = new Insets(0, 0, 5, 0);
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.gridx = 1;
		gbc_NameField.gridy = 1;
		contentPane.add(NameField, gbc_NameField);
		NameField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alias");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		AliasField = new DTextField();
		AliasField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AliasField.setColumns(10);
		GridBagConstraints gbc_AliasField = new GridBagConstraints();
		gbc_AliasField.insets = new Insets(0, 0, 5, 0);
		gbc_AliasField.fill = GridBagConstraints.HORIZONTAL;
		gbc_AliasField.gridx = 1;
		gbc_AliasField.gridy = 3;
		contentPane.add(AliasField, gbc_AliasField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gst Type");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 5;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		GstField = new DTextField();
		GstField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GstField.setColumns(10);
		GridBagConstraints gbc_GstField = new GridBagConstraints();
		gbc_GstField.insets = new Insets(0, 0, 5, 0);
		gbc_GstField.fill = GridBagConstraints.HORIZONTAL;
		gbc_GstField.gridx = 1;
		gbc_GstField.gridy = 5;
		contentPane.add(GstField, gbc_GstField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Unique ID");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		IdBox = new DComboBox();
		IdBox.setModel(new DefaultComboBoxModel(new String[] {"YES", "NO"}));
		IdBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_IdBox = new GridBagConstraints();
		gbc_IdBox.insets = new Insets(0, 0, 5, 0);
		gbc_IdBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_IdBox.gridx = 1;
		gbc_IdBox.gridy = 7;
		contentPane.add(IdBox, gbc_IdBox);
		
		SaveButton = new JButton("SAVE\r\n");
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_SaveButton = new GridBagConstraints();
		gbc_SaveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SaveButton.insets = new Insets(0, 0, 0, 5);
		gbc_SaveButton.gridx = 0;
		gbc_SaveButton.gridy = 9;
		contentPane.add(SaveButton, gbc_SaveButton);
		
		JButton CancelButton = new JButton("CANCEL");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CancelButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_CancelButton.gridx = 1;
		gbc_CancelButton.gridy = 9;
		contentPane.add(CancelButton, gbc_CancelButton);
	}

	@Override
	public void insertRecord() {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO CATAGORYMASTER (NAME,ALIAS,GST,ID) VALUES (?,?,?,?)");
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
	try {
		if (NameField.getText().isEmpty() || AliasField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Some of the major fields are empty");
			NameField.requestFocus();
		} else {
			stmt.setString(1, NameField.getText());
			stmt.setString(2, AliasField.getText());
			stmt.setString(3, GstField.getText());							
			stmt.setString(4, IdBox.getSelectedItem().toString());
			if (stmt.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
				NameField.setText("");
				AliasField.setText("");
				GstField.setText("");
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
							stmt.setString(4, IdBox.getSelectedItem().toString());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records Inserted Successfully");
								NameField.setText("");
								AliasField.setText("");
								GstField.setText("");
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
		new DeleteFrame("CATAGORYMASTER");
		
	}

	@Override
	public void editRecord() {
		try {
			Connection con;
			AliasField.setEditable(false);
			SearchFrame sf = new SearchFrame("ALIAS,NAME", "CATAGORYMASTER");
			sf.setVisible(true);
			sf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent evt) {
					NameField.setText(sf.get("NAME"));
					AliasField.setText(sf.get("ALIAS"));
					GstField.setText(sf.get("GST"));
					IdBox.setSelectedItem(sf.get("ID"));

					setVisible(true);
				}
			});
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			PreparedStatement stmt = con.prepareStatement("UPDATE CATAGORYMASTER SET NAME=?,GST=?,ID=? WHERE ALIAS=?");
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
							stmt.setString(4, AliasField.getText());
							stmt.setString(2,GstField.getText());
							stmt.setString(3, IdBox.getSelectedItem().toString());
							IdBox.setSelectedItem(sf.get("ID").toString());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records UPDATED Successfully");
								NameField.setText("");
								AliasField.setText("");
								GstField.setText("");
								
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
							stmt.setString(4, AliasField.getText());
							stmt.setString(2,GstField.getText());
							stmt.setString(3, IdBox.getSelectedItem().toString());
							IdBox.setSelectedItem(sf.get("ID").toString());
							if (stmt.executeUpdate() > 0) {
								JOptionPane.showMessageDialog(null, "Records UPDATED Successfully");
								NameField.setText("");
								AliasField.setText("");
								GstField.setText("");
								
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
		sf = new SearchFrame("ALIAS,NAME", "CATAGORYMASTER");
		sf.setVisible(true);
		sf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent evt) {
				NameField.setText(sf.get("NAME"));
				AliasField.setText(sf.get("ALIAS"));
				GstField.setText(sf.get("GST"));
				IdBox.setSelectedItem(sf.get("ID").toString());
				setVisible(true);
			}
		});
		
	}

}
