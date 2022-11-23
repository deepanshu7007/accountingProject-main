package Views;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LedgerMaster.OpenDataBase;
import accountingproject.DataModelTools;
import accountingproject.MasterPresistables;
import accountingproject.mainInintials;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
public class SubGroupPanel extends JInternalFrame implements MasterPresistables{
	protected DTextField nameField;
	protected DTextField aliasField;
	protected DTextField priorityField;
	protected JPanel contentPane;
	protected DTextField groupField;
	protected JButton saveButton;
	protected SearchFrame sf;
	private String aliasName;
	
	public SubGroupPanel() {
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 905, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{166, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		
		JLabel lblNewLabel = new JLabel("SUB GROUP MASTER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setOpaque(true);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);
		
		nameField = new DTextField();

		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.BOTH;
		gbc_nameField.gridx = 0;
		gbc_nameField.gridy = 2;
		contentPane.add(nameField, gbc_nameField);
		
		JLabel lblAlias = new JLabel("Alias\r\n");
		lblAlias.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAlias = new GridBagConstraints();
		gbc_lblAlias.anchor = GridBagConstraints.WEST;
		gbc_lblAlias.insets = new Insets(0, 0, 5, 0);
		gbc_lblAlias.gridx = 0;
		gbc_lblAlias.gridy = 3;
		contentPane.add(lblAlias, gbc_lblAlias);
		
		 aliasField= new DTextField();
		GridBagConstraints gbc_aliasField = new GridBagConstraints();
		gbc_aliasField.insets = new Insets(0, 0, 5, 0);
		gbc_aliasField.fill = GridBagConstraints.BOTH;
		gbc_aliasField.gridx = 0;
		gbc_aliasField.gridy = 4;
		contentPane.add(aliasField, gbc_aliasField);

		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.anchor = GridBagConstraints.WEST;
		gbc_lblPriority.insets = new Insets(0, 0, 5, 0);
		gbc_lblPriority.gridx = 0;
		gbc_lblPriority.gridy = 5;
		contentPane.add(lblPriority, gbc_lblPriority);
		
		 priorityField= new DTextField();
		GridBagConstraints gbc_priorityField = new GridBagConstraints();
		gbc_priorityField.insets = new Insets(0, 0, 5, 0);
		gbc_priorityField.fill = GridBagConstraints.BOTH;
		gbc_priorityField.gridx = 0;
		gbc_priorityField.gridy = 6;
		contentPane.add(priorityField, gbc_priorityField);

		JLabel lblGroupName = new JLabel("Group Name");
		lblGroupName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblGroupName = new GridBagConstraints();
		gbc_lblGroupName.anchor = GridBagConstraints.WEST;
		gbc_lblGroupName.insets = new Insets(0, 0, 5, 0);
		gbc_lblGroupName.gridx = 0;
		gbc_lblGroupName.gridy = 7;
		contentPane.add(lblGroupName, gbc_lblGroupName);
		groupField = new DTextField();

		GridBagConstraints gbc_groupField = new GridBagConstraints();
		gbc_groupField.insets = new Insets(0, 0, 5, 0);
		gbc_groupField.fill = GridBagConstraints.BOTH;
		gbc_groupField.gridx = 0;
		gbc_groupField.gridy = 8;
		contentPane.add(groupField, gbc_groupField);
		saveButton = new JButton("SAVE");

		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 5, 0);
		gbc_saveButton.fill = GridBagConstraints.BOTH;
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 10;
		contentPane.add(saveButton, gbc_saveButton);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancelButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.fill = GridBagConstraints.BOTH;
		gbc_cancelButton.gridx = 0;
		gbc_cancelButton.gridy = 11;
		contentPane.add(cancelButton, gbc_cancelButton);
		
	}
	
	
	void InsertTable(DefaultTableModel dtm)
	{
		try {
			OpenDataBase db=new OpenDataBase();
			PreparedStatement stmt=db.getDataBaseConnection().prepareStatement("INSERT INTO SUBGROUPMASTER(NAME,ALIAS,PRIORITY,GROUP_ALIAS) VALUES (?,?,?,?)");
			stmt.setString(1, nameField.getText());
			stmt.setString(2,aliasField.getText());
			stmt.setString(3, priorityField.getText());
			stmt.setString(4, aliasName);
			if (stmt.executeUpdate()>0) {
				nameField.requestFocus();
				Vector<String> rowData = new Vector<>();
				rowData.add(aliasField.getText());
				rowData.add(nameField.getText());
				dtm.addRow(rowData);
				JOptionPane.showMessageDialog(null, "Record Inserted successfully");
				nameField.setText("");
				aliasField.setText("");
				priorityField.setText("");	
				groupField.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong");
			}
			db.ConClosed();
			System.out.println("CONNECTION CLOSED FOR INSERT TABLE SUBGROUP");
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
	}
	void UpdateTable(DefaultTableModel dtm,int row)
	{
		try {
			OpenDataBase db = new OpenDataBase();
			PreparedStatement stmt=db.getDataBaseConnection().prepareStatement("UPDATE SUBGROUPMASTER SET NAME=?,PRIORITY=?,GROUP_ALIAS=?  WHERE ALIAS=?");
			stmt.setString(1, nameField.getText());
			stmt.setString(4,aliasField.getText());
			stmt.setString(2, priorityField.getText());
			stmt.setString(3, groupField.getText());
			if (stmt.executeUpdate()>0) {
				nameField.requestFocus();
				JOptionPane.showMessageDialog(null, "Record UPDATED successfully");
				dtm.setValueAt(aliasField.getText(), row, 0);
				dtm.setValueAt(nameField.getText(), row, 1);
				nameField.setText("");
				aliasField.setText("");
				priorityField.setText("");	
				groupField.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong");
			}
			db.ConClosed();
			System.out.println("CONNECTION CLOSED FOR UPDATE SUBGROUP");
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
	}

	@Override
	public void insertRecord(DefaultTableModel dtm) {
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "This field should not be empty");
						nameField.requestFocus();
					}
					else
					{
						OpenDataBase db = new OpenDataBase();
						aliasField.setText(db.getAliasName(nameField.getText()));
					aliasField.requestFocus();
					}
					}
			}
		});
			priorityField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "This field should not be empty");
						groupField.requestFocus();
					}else
				groupField.requestFocus();
				}
			}
		});
			aliasField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "This field should not be empty");
						aliasField.requestFocus();
					}
					else
					priorityField.requestFocus();
				}
			}
		});
			
			groupField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt)
			{
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "deepanshu", "Anshu123$");
					DataModelTools dm = new DataModelTools(con);
					if(dm.getNameByAlias(groupField.getText(), "GROUPMASTER").isEmpty())
					{
						SearchFrame sf = new SearchFrame("ALIAS,NAME","GROUPMASTER");
						sf.setVisible(true);
						sf.addWindowListener(new WindowAdapter() {
							public void windowClosed(WindowEvent evt)
							{
								groupField.setText(sf.get("NAME"));
								aliasName = sf.get("ALIAS");
							}
						});
						
					}
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
			}
			}
			});
			
			saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameField.getText().isEmpty()||aliasField.getText().isEmpty()||priorityField.getText().isEmpty()||groupField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
				}else
				InsertTable(dtm);
			}
		});
		saveButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty()||aliasField.getText().isEmpty()||priorityField.getText().isEmpty()||groupField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
					}
					else
						InsertTable(dtm);
				}
			}
		});
		
	}

	@Override
	public void deleteRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editRecord(DefaultTableModel dtm) {
		sf = new SearchFrame("ALIAS,NAME","SUBGROUPMASTER");
		sf.setVisible(true);
		sf.setAlwaysOnTop(true);
		 sf.addWindowListener(new WindowAdapter(){  
	            public void windowClosed(WindowEvent e) {  
	            	nameField.setText(sf.get("NAME"));
	            	aliasField.setText(sf.get("ALIAS"));
	            	priorityField.setText(sf.get("PRIORITY"));
	            	groupField.setText(sf.get("GROUP_ALIAS"));
	            }  
	        });  
		aliasField.setEnabled(false);
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "This field should not be empty");
						nameField.requestFocus();
					}
					else
					{
						priorityField.requestFocus();
					}
					}
			}
		});
			priorityField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "This field should not be empty");
						groupField.requestFocus();
					}else
				groupField.requestFocus();
				}
			}
		});
			
			groupField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
						if(e.getKeyChar() == e.VK_ENTER)
						{
								
									sf = new SearchFrame("ALIAS,NAME","GROUPMASTER");
									sf.setVisible(true);
									 sf.addWindowListener(new WindowAdapter(){  
								            public void windowClosed(WindowEvent e) {  
								            	groupField.setText(sf.get("NAME"));
								            	aliasName = sf.get("ALIAS");
								            }  
								        });  
							}
					}
		});
			saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameField.getText().isEmpty()||aliasField.getText().isEmpty()||priorityField.getText().isEmpty()||groupField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
				}else
				UpdateTable(dtm,sf.getSelectedRow());
			}
		});
		saveButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					if(nameField.getText().isEmpty()||aliasField.getText().isEmpty()||priorityField.getText().isEmpty()||groupField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Some of the major fields are Empty");
					}
					else
						UpdateTable(dtm,sf.getSelectedRow());
				}
			}
		});
		
	}

	@Override
	public void viewRecord() {
		saveButton.setEnabled(false);
		setVisible(true);
		sf = new SearchFrame("ALIAS,NAME","SUBGROUPMASTER");
		sf.setVisible(true);
		sf.addWindowListener(new WindowAdapter() {
		public void windowClosed(WindowEvent e)
		{
			nameField.setText(sf.get("NAME"));
			aliasField.setText(sf.get("ALIAS"));
			priorityField.setText(sf.get("PRIORITY"));
			groupField.setText(sf.get("GROUP_ALIAS"));
		}
		});
		nameField.setEditable(false);
		aliasField.setEditable(false);
		priorityField.setEnabled(false);
		groupField.setEditable(false);
		
	}
}
