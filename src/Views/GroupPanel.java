package Views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import LedgerMaster.OpenDataBase;
import accountingproject.MasterPresistables;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class GroupPanel extends JFrame implements MasterPresistables{
	protected DTextField nameField;
	protected DTextField aliasField;
	protected DTextField priorityField;
	protected JComboBox typeBox;
	protected JButton saveButton;
	protected SearchFrame  sp ;
	
	private JFrame frame;
	public GroupPanel(String name) {
		
		setSize(860,735);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		setBackground(SystemColor.menu);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 323, 269, 0 };
		gridBagLayout.rowHeights = new int[] { 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Group Master");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(10, 10, 15,10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 15, 10);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
				nameField = new DTextField();
				nameField.setName("NAME");

				
				GridBagConstraints gbc_nameField = new GridBagConstraints();
				gbc_nameField.gridwidth = 2;
				gbc_nameField.gridheight = 2;
				gbc_nameField.insets = new Insets(10, 10, 15, 10);
				gbc_nameField.fill = GridBagConstraints.BOTH;
				gbc_nameField.gridx = 0;
				gbc_nameField.gridy = 2;
				getContentPane().add(nameField, gbc_nameField);
				nameField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Alias\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 15, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
				aliasField = new DTextField();
				aliasField.setName("ALIAS");

				aliasField.setFont(new Font("Tahoma", Font.BOLD, 18));
				GridBagConstraints gbc_aliasField = new GridBagConstraints();
				gbc_aliasField.gridwidth = 2;
				gbc_aliasField.gridheight = 2;
				gbc_aliasField.insets = new Insets(10, 10, 15, 10);
				gbc_aliasField.fill = GridBagConstraints.BOTH;
				gbc_aliasField.gridx = 0;
				gbc_aliasField.gridy = 5;
				getContentPane().add(aliasField, gbc_aliasField);
				aliasField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Priority");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 15, 10);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
				priorityField = new DTextField();
				priorityField.setName("PRIORITY");

				priorityField.setFont(new Font("Tahoma", Font.BOLD, 18));
				GridBagConstraints gbc_priorityField = new GridBagConstraints();
				gbc_priorityField.gridwidth = 2;
				gbc_priorityField.gridheight = 2;
				gbc_priorityField.insets = new Insets(10, 10, 15, 10);
				gbc_priorityField.fill = GridBagConstraints.BOTH;
				gbc_priorityField.gridx = 0;
				gbc_priorityField.gridy = 8;
				getContentPane().add(priorityField, gbc_priorityField);
				priorityField.setColumns(10);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 21));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.gridwidth = 2;
		gbc_lblType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblType.insets = new Insets(10, 10, 15, 10);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 10;
		getContentPane().add(lblType, gbc_lblType);
		saveButton = new JButton("SAVE");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				typeBox = new JComboBox();
				typeBox.setName("HEAD_ALIAS");
				typeBox.setFont(new Font("Tahoma", Font.BOLD, 21));
				typeBox.setModel(new DefaultComboBoxModel(new String[] { "ASSETS", "LIABILITY", "INCOME", "EXPENDITURE" }));
				GridBagConstraints gbc_typeBox = new GridBagConstraints();
				gbc_typeBox.gridwidth = 2;
				gbc_typeBox.gridheight = 2;
				gbc_typeBox.insets = new Insets(10, 10, 15,10);
				gbc_typeBox.fill = GridBagConstraints.BOTH;
				gbc_typeBox.gridx = 0;
				gbc_typeBox.gridy = 11;
				getContentPane().add(typeBox, gbc_typeBox);
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 5, 0);
		gbc_saveButton.fill = GridBagConstraints.BOTH;
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 13;
		getContentPane().add(saveButton, gbc_saveButton);
		
				JButton cancelButton = new JButton("CANCEL");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.insets = new Insets(0, 0, 5, 0);
				gbc_cancelButton.fill = GridBagConstraints.BOTH;
				gbc_cancelButton.gridx = 1;
				gbc_cancelButton.gridy = 13;
				getContentPane().add(cancelButton, gbc_cancelButton);
				if(name.equals("VIEW"))
				{
					setVisible(true);
					SearchFrame sf=new SearchFrame("ALIAS,NAME","GROUPMASTER");
					sf.setVisible(true);
					sf.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e)
					{
						nameField.setText(sf.get("NAME"));
						aliasField.setText(sf.get("ALIAS"));
						priorityField.setText(sf.get("PRIORITY"));
						typeBox.setSelectedItem(sf.get("HEAD_ALIAS"));
					}
					});
					nameField.setEditable(false);
					aliasField.setEditable(false);
					priorityField.setEditable(false);
					typeBox.setEditable(false);
					saveButton.setEnabled(false);
				}
				if(name.equals("INSERT"))
				{
					setTitle("Insert Group Item");
					
					nameField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						
						if (e.getKeyChar() == KeyEvent.VK_ENTER) {
							
							if (nameField.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please enter some values to the field");
								nameField.requestFocus();
							} else {
								OpenDataBase db = new OpenDataBase();
								    	aliasField.setText(db.getAliasName(nameField.getText()));
										db.ConClosed();
								    	aliasField.requestFocus();
							}
						}
					}
				});
					aliasField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyChar() == KeyEvent.VK_ENTER) {
							if (aliasField.getText().isEmpty() || aliasField.getText().contains(" ")) {
								JOptionPane.showMessageDialog(null, "This field should not be empty");
								aliasField.requestFocus();
							} else {
								priorityField.requestFocus();
							}
						}
					}
				});
					priorityField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyChar()==e.VK_ENTER)
						{
						if(priorityField.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null,"This Field should not be empty");
							priorityField.requestFocus();
						}
						typeBox.requestFocus();
					}
			}
				});
					typeBox.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyChar() == KeyEvent.VK_ENTER)
							{saveButton.requestFocus();}
					}
				});
					saveButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						if (e.getKeyChar() == KeyEvent.VK_ENTER) {
							if(nameField.getText().isEmpty() || aliasField.getText().isEmpty() || priorityField.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null,"Some of the major fields are empty");
								nameField.requestFocus();
							}
							else
			InsertTable();
							repaint();
							revalidate();
						}
					}
				});
					saveButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(nameField.getText().isEmpty() || aliasField.getText().isEmpty() || priorityField.getText().isEmpty())
								{
									JOptionPane.showMessageDialog(null,"Some of the major fields are empty");
									nameField.requestFocus();
								}
								else
									InsertTable();
						}
					});
				}if(name.equals("UPDATE"))
				{
					
					sp = new SearchFrame("ALIAS,NAME","GROUPMASTER");
					sp.setVisible(true);
					sp.setVisible(true);
					nameField.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							
							if (e.getKeyChar() == KeyEvent.VK_ENTER) {
								
								if (nameField.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "Please enter some values to the field");
									nameField.requestFocus();
								} else {
									
									priorityField.requestFocus();
								}
							}
						}
					});
						
						priorityField.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyChar()==e.VK_ENTER)
							{
							if(priorityField.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null,"This Field should not be empty");
								priorityField.requestFocus();
							}
							typeBox.requestFocus();
						}
				}
					});
						typeBox.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyChar() == KeyEvent.VK_ENTER)
								{saveButton.requestFocus();}
						}
					});
					setTitle("Update Group Panel");
					saveButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyChar() == KeyEvent.VK_ENTER) {
							if(nameField.getText().isEmpty() || aliasField.getText().isEmpty() || priorityField.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null,"Some of the major fields are empty");
								nameField.requestFocus();
							}
							else
			UpdateTable();
						}
					}
				});
					nameField.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent e)
					{
						nameField.setText(sp.get("NAME"));
						aliasField.setText(sp.get("ALIAS"));
						priorityField.setText(sp.get("PRIORITY"));
						aliasField.setEnabled(false);
					}
					});
			saveButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(nameField.getText().isEmpty() || aliasField.getText().isEmpty() || priorityField.getText().isEmpty())
								{
									JOptionPane.showMessageDialog(null,"Some of the major fields are empty");
									nameField.requestFocus();
								}
								else
									UpdateTable();
						}
					});
					setTitle("Update Group Panel");
				}
				if(name.equals("VIEW"))
				{
					
				}
	}
	void InsertTable()
	{
		OpenDataBase db = new OpenDataBase();
		PreparedStatement stmt;
		try {
			stmt=db.getDataBaseConnection().prepareStatement("INSERT INTO GROUPMASTER(NAME,ALIAS,PRIORITY,HEAD_ALIAS) VALUES (?,?,?,?)");
			stmt.setString(1, nameField.getText());
			stmt.setString(2,aliasField.getText());
			stmt.setString(3, priorityField.getText());
			stmt.setString(4, typeBox.getSelectedItem().toString());
			if (stmt.executeUpdate()>0) {
				nameField.requestFocus();
				JOptionPane.showMessageDialog(null, "Record Inserted successfully");
				nameField.setText("");
				aliasField.setText("");
				priorityField.setText("");		
			} else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong");
			}
		} catch (SQLException exception) {
			if(exception.getErrorCode()==1062)
			{
				JOptionPane jp = new JOptionPane();
				addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						e.consume();
						nameField.requestFocusInWindow();
					}});
				jp.showMessageDialog(null,"Alias Name ' "+aliasField.getText()+" ' already exists");	
			}
			exception.printStackTrace();
		}
		finally {
			db.ConClosed();
			System.out.println("DATABASE CONNECTION CLOSED FOR INSERT TABLE OF GROUPMASTER");
			repaint();
			revalidate();
		}
	}
	void UpdateTable()
	{
		
		OpenDataBase db = new OpenDataBase();
		try {
			PreparedStatement stmt=db.getDataBaseConnection().prepareStatement("UPDATE GROUPMASTER SET NAME=?,PRIORITY=?,HEAD_ALIAS=? WHERE ALIAS=?");
			stmt.setString(1, nameField.getText());
			stmt.setString(4,aliasField.getText());
			stmt.setString(2, priorityField.getText());
			stmt.setString(3, typeBox.getSelectedItem().toString());
			if (stmt.executeUpdate()>0) {
				nameField.requestFocus();
				JOptionPane.showMessageDialog(null, "Record updated successfully");
				nameField.setText("");
				aliasField.setText("");
				priorityField.setText("");		
			} else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong");
			}
		} catch (SQLException exception) {
			if(exception.getErrorCode()==1062)
			{
				JOptionPane jp = new JOptionPane();
				addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						e.consume();
						nameField.requestFocusInWindow();
					}});
				jp.showMessageDialog(null,"Alias Name ' "+aliasField.getText()+" ' already exists");	
			}
			exception.printStackTrace();
		}
		finally {
			db.ConClosed();
			System.out.println("DATABASE CONNECTION CLOSED FOR UPDATE TABLE FOR GROUPMASTER");
		}
	}
	@Override
	public void insertRecord() {
		
	}
	@Override
	public void deleteRecord() {
		
		
	}
	@Override
	public void editRecord() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void viewRecord() {
		// TODO Auto-generated method stub
		
	}
}
