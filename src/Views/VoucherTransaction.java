package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import CheckCodes.MainInintials;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.Component;

public class VoucherTransaction extends JFrame {
	private JPanel contentPane;
	private JTextField NarrationField;
	private JDateChooser textField_1;
	private JTable table;
	private DefaultTableModel dm;
	private static ResultSet rs;

	public VoucherTransaction(MainInintials mi) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		dm = new DefaultTableModel(new Object[][] { { null, null, null } },
				new String[] { "TRANSACTIONS", "DEBIT", "CREDIT" });
		JPanel LeftPanel = new JPanel();
		LeftPanel.setBackground(Color.CYAN);
		contentPane.add(LeftPanel, BorderLayout.WEST);
		GridBagLayout gbl_LeftPanel = new GridBagLayout();
		gbl_LeftPanel.columnWidths = new int[] { 190, -11, 0 };
		gbl_LeftPanel.rowHeights = new int[] { 31, 0, 0, 0, 0 };
		gbl_LeftPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_LeftPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		LeftPanel.setLayout(gbl_LeftPanel);

		JLabel lblNewLabel_1_1 = new JLabel("Date");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 0;
		LeftPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textField_1 = new JDateChooser();
		textField_1.setFont(new Font("Calibre", Font.PLAIN, 20));
		textField_1.setDateFormatString("yyyy/MM/d");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 1;
		LeftPanel.add(textField_1, gbc_textField_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("TYPE");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 2;
		LeftPanel.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("MODE");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1.gridy = 2;
		LeftPanel.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "CV", "JV" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		LeftPanel.add(comboBox, gbc_comboBox);

		JComboBox <String>comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "STANDARD" }));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		LeftPanel.add(comboBox_1, gbc_comboBox_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 287, 229, 0, 189, 0 };
		gbl_panel.rowHeights = new int[] { 37, 37, 37, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_2 = new JLabel("Narrations");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setBackground(Color.GREEN);

		JLabel lblNewLabel = new JLabel("Total Debit");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("(\u20B9)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("0.00");
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField.setEditable(false);
		formattedTextField.setColumns(5);
		panel_1.add(formattedTextField);

		JLabel lblNewLabel_1_2 = new JLabel("Total Credit\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("(\u20B9)");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1_3);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("0.00");
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formattedTextField_1.setEditable(false);
		formattedTextField_1.setColumns(5);
		panel_1.add(formattedTextField_1);

		
		NarrationField = new JTextField();
		NarrationField.setForeground(Color.WHITE);
		NarrationField.setBackground(Color.BLACK);
		NarrationField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NarrationField.setColumns(10);

		GridBagConstraints gbc_NarrationField = new GridBagConstraints();
		gbc_NarrationField.gridwidth = 4;
		gbc_NarrationField.anchor = GridBagConstraints.NORTH;
		gbc_NarrationField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NarrationField.insets = new Insets(0, 0, 5, 0);
		gbc_NarrationField.gridx = 0;
		gbc_NarrationField.gridy = 1;
		panel.add(NarrationField, gbc_NarrationField);

		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("PRINT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_1_1_1 = new JButton("SAVE");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1_1_1.gridx = 3;
		gbc_btnNewButton_1_1_1.gridy = 2;
		panel.add(btnNewButton_1_1_1, gbc_btnNewButton_1_1_1);
		JLabel lblNewLabel_3 = new JLabel("VOUCHER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_3, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane((Component) null);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		table.getTableHeader().setFont(new Font("Lucida Console", Font.PLAIN, 38));
		table.setRowHeight(35);
		table.setModel(dm);
		table.setFont(new Font("Calibri", Font.BOLD, 25));
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(555);
		scrollPane.setViewportView(table);

		JTextField TransactionField = new JTextField();
		TransactionField.setFont(new Font("CALIBRE", Font.BOLD, 22));	
		DefaultCellEditor TransactionCellEditor = new DefaultCellEditor(TransactionField);
		table.getColumnModel().getColumn(0).setCellEditor(TransactionCellEditor);
		JTextField DebitField = new JTextField();
		DebitField.setFont(new Font("CALIBRE",Font.BOLD,22));
		JTextField CreditField = DebitField;
		
	}

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root",
					"Anshu12345$");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT NAME,ALIAS FROM ACCOUNTMASTER");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainInintials mi = new MainInintials(rs);
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VoucherTransaction frame = new VoucherTransaction(mi);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
