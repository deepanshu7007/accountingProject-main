package LedgerMaster;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import SearchModule.SearchFrameTest;
import SearchModule.SearchTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.JButton;
import org.jdesktop.swingx.JXDatePicker;

public class LedgerFrame extends JFrame {
	private JPanel contentPane;
	private JTextField AccountName;
	private JTable table;
	
	public JTable getTable() {
		return this.table;
	}

	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JFormattedTextField DebitTotalField;
	private JFormattedTextField CreditTotalField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JFormattedTextField formattedStartDate_1;
	private JLabel lblNewLabel_5;
	private JXDatePicker EndDate;
	private JXDatePicker StartDate;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
/**
	 * Returns the value of the field called 'endDate'.
	 * @return Returns the endDate.
	 */
	public JXDatePicker getEndDate() {
		return this.EndDate;
	}
	/**
	 * Returns the value of the field called 'startDate'.
	 * @return Returns the startDate.
	 */
	public JXDatePicker getStartDate() {
		return this.StartDate;
	}
public String getAccountField()
{
return AccountName.getText();	
}
public void setAccountField(String NameField)
{
 AccountName.setText(NameField);	
}
	public void setLedgerTableModel(LedgerTableModel ltm) {
		table.setModel(ltm);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	}

	public LedgerFrame() {
		LedgerController lc = new LedgerController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1500, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 204, 137, 227, 118, 260, 138, 260, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 19, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel_5 = new JLabel("LEDGER");
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridwidth = 8;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("Account Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		AccountName = new JTextField();
		AccountName.setActionCommand("CHECK");
		AccountName.addActionListener(lc);
		AccountName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(AccountName, gbc_textField);
		AccountName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		StartDate = new JXDatePicker();
		StartDate.setFont(new Font("CALIBRE",Font.BOLD,22));
		GridBagConstraints gbc_StartDate = new GridBagConstraints();
		gbc_StartDate.fill = GridBagConstraints.BOTH;
		gbc_StartDate.insets = new Insets(0, 0, 5, 5);
		gbc_StartDate.gridx = 4;
		gbc_StartDate.gridy = 1;
		panel.add(StartDate, gbc_StartDate);

		JLabel lblNewLabel_1_1 = new JLabel("End Date");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 5;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		EndDate = new JXDatePicker();
		EndDate.setFont(new Font("CALIBRE",Font.BOLD,22));
		GridBagConstraints gbc_EndDate = new GridBagConstraints();
		gbc_EndDate.fill = GridBagConstraints.BOTH;
		gbc_EndDate.insets = new Insets(0, 0, 5, 5);
		gbc_EndDate.gridx = 6;
		gbc_EndDate.gridy = 1;
		panel.add(EndDate, gbc_EndDate);

		btnNewButton = new JButton("Submit");
		btnNewButton.setActionCommand("SUBMIT");
		btnNewButton.addActionListener(lc);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("MODIFY");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1 .addActionListener(lc);
		btnNewButton_1.setActionCommand("UPDATE");
		
		btnNewButton_2 = new JButton("DELETE");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 2;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("CALIBRE", Font.PLAIN, 25));
		
		scrollPane.setViewportView(table);
		
		
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{224, 98, 227, 103, 227, 120, 227, 0, 0};
		gbl_panel_1.rowHeights = new int[]{31, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
						
								lblNewLabel_2 = new JLabel("Total Debit");
								lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
								GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
								gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
								gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
								gbc_lblNewLabel_2.gridx = 1;
								gbc_lblNewLabel_2.gridy = 0;
								panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
						DebitTotalField = new JFormattedTextField();
						DebitTotalField.setEditable(false);
						DebitTotalField.setHorizontalAlignment(SwingConstants.RIGHT);
						DebitTotalField.setColumns(13);
						DebitTotalField.setFont(new Font("Tahoma", Font.PLAIN, 20));
						GridBagConstraints gbc_DebitTotalField = new GridBagConstraints();
						gbc_DebitTotalField.anchor = GridBagConstraints.NORTHWEST;
						gbc_DebitTotalField.insets = new Insets(0, 0, 0, 5);
						gbc_DebitTotalField.gridx = 2;
						gbc_DebitTotalField.gridy = 0;
						panel_1.add(DebitTotalField, gbc_DebitTotalField);
				
						lblNewLabel_3 = new JLabel("Total Credit");
						lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
						GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
						gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
						gbc_lblNewLabel_3.gridx = 3;
						gbc_lblNewLabel_3.gridy = 0;
						panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
				CreditTotalField = new JFormattedTextField();
				CreditTotalField.setEditable(false);
				CreditTotalField.setHorizontalAlignment(SwingConstants.RIGHT);
				CreditTotalField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				CreditTotalField.setColumns(13);
				GridBagConstraints gbc_CreditTotalField = new GridBagConstraints();
				gbc_CreditTotalField.anchor = GridBagConstraints.NORTHWEST;
				gbc_CreditTotalField.insets = new Insets(0, 0, 0, 5);
				gbc_CreditTotalField.gridx = 4;
				gbc_CreditTotalField.gridy = 0;
				panel_1.add(CreditTotalField, gbc_CreditTotalField);
		
				lblNewLabel_4 = new JLabel("Total Balance");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_4.gridx = 5;
				gbc_lblNewLabel_4.gridy = 0;
				panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				formattedStartDate_1 = new JFormattedTextField();
				formattedStartDate_1.setHorizontalAlignment(SwingConstants.RIGHT);
				formattedStartDate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				formattedStartDate_1.setEditable(false);
				formattedStartDate_1.setColumns(13);
				GridBagConstraints gbc_formattedStartDate_1 = new GridBagConstraints();
				gbc_formattedStartDate_1.insets = new Insets(0, 0, 0, 5);
				gbc_formattedStartDate_1.anchor = GridBagConstraints.NORTHWEST;
				gbc_formattedStartDate_1.gridx = 6;
				gbc_formattedStartDate_1.gridy = 0;
				panel_1.add(formattedStartDate_1, gbc_formattedStartDate_1);
	}
	/**
	 * Returns the value of the field called 'debitTotalField'.
	 * @return Returns the debitTotalField.
	 */
	public JFormattedTextField getDebitTotalField() {
		return this.DebitTotalField;
	}
	/**
	 * Sets the field called 'debitTotalField' to the given value.
	 * @param debitTotalField The debitTotalField to set.
	 */
	public void setDebitTotalField(String debitTotalField) {
		this.DebitTotalField.setText(debitTotalField);
	}
	/**
	 * Returns the value of the field called 'creditTotalField'.
	 * @return Returns the creditTotalField.
	 */
	public JFormattedTextField getCreditTotalField() {
		return this.CreditTotalField;
	}
	/**
	 * Sets the field called 'creditTotalField' to the given value.
	 * @param creditTotalField The creditTotalField to set.
	 */
	public void setCreditTotalField(String creditTotalField) {
		this.CreditTotalField.setText(creditTotalField);
	}
}
