package company;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created May 20, 2021.
 */
public class CompanyCreation extends JFrame {

	private JPanel contentPane;
	private JTextField DirField;
	private JTextField NameField;
	private JTextField MailingName;
	private JTextField AddressField;
	private JTextField CountryField;
	private JTextField StateField;
	private JTextField Pincode;
	private JTextField PhoneField;
	private JTextField MobileField;
	private JTextField FaxField;
	private JTextField EmailField;
	private JTextField WebField;
	private JDateChooser StartField;
	private JDateChooser EndYear;
	private JPasswordField PasswordField;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyCreation frame = new CompanyCreation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CompanyCreation() {
		setTitle("AccountingProject");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 189, 284, 196, 0};
		gbl_contentPane.rowHeights = new int[]{73, 0, 0, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Company Creations");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Directory");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		DirField = new JTextField();
		DirField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_DirField = new GridBagConstraints();
		gbc_DirField.insets = new Insets(0, 0, 5, 5);
		gbc_DirField.fill = GridBagConstraints.HORIZONTAL;
		gbc_DirField.gridx = 1;
		gbc_DirField.gridy = 1;
		contentPane.add(DirField, gbc_DirField);
		DirField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Financial year begins");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		StartField = new JDateChooser();
		StartField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_StartField = new GridBagConstraints();
		gbc_StartField.insets = new Insets(0, 0, 5, 0);
		gbc_StartField.fill = GridBagConstraints.HORIZONTAL;
		gbc_StartField.gridx = 3;
		gbc_StartField.gridy = 1;
		contentPane.add(StartField, gbc_StartField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		NameField = new JTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NameField.setColumns(10);
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.insets = new Insets(0, 0, 5, 5);
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.gridx = 1;
		gbc_NameField.gridy = 2;
		contentPane.add(NameField, gbc_NameField);
		
		JLabel lblNewLabel_3 = new JLabel("Financial year ends");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		EndYear = new JDateChooser();
		EndYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_EndYear = new GridBagConstraints();
		gbc_EndYear.insets = new Insets(0, 0, 5, 0);
		gbc_EndYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_EndYear.gridx = 3;
		gbc_EndYear.gridy = 2;
		contentPane.add(EndYear, gbc_EndYear);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Details");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("mailing name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 4;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		MailingName = new JTextField();
		MailingName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MailingName.setColumns(10);
		GridBagConstraints gbc_MailingName = new GridBagConstraints();
		gbc_MailingName.insets = new Insets(0, 0, 5, 5);
		gbc_MailingName.fill = GridBagConstraints.HORIZONTAL;
		gbc_MailingName.gridx = 1;
		gbc_MailingName.gridy = 4;
		contentPane.add(MailingName, gbc_MailingName);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 2;
		gbc_lblNewLabel_3_1.gridy = 4;
		contentPane.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordField.setColumns(10);
		GridBagConstraints gbc_PasswordField = new GridBagConstraints();
		gbc_PasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_PasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PasswordField.gridx = 3;
		gbc_PasswordField.gridy = 4;
		contentPane.add(PasswordField, gbc_PasswordField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("address");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 5;
		contentPane.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		AddressField = new JTextField();
		AddressField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AddressField.setColumns(10);
		GridBagConstraints gbc_AddressField = new GridBagConstraints();
		gbc_AddressField.insets = new Insets(0, 0, 5, 5);
		gbc_AddressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_AddressField.gridx = 1;
		gbc_AddressField.gridy = 5;
		contentPane.add(AddressField, gbc_AddressField);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1.setEnabled(false);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1.gridx = 2;
		gbc_lblNewLabel_3_1_1.gridy = 5;
		contentPane.add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);
		
		textField_15 = new JTextField();
		textField_15.setEnabled(false);
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_15.setColumns(10);
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.insets = new Insets(0, 0, 5, 0);
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.gridx = 3;
		gbc_textField_15.gridy = 5;
		contentPane.add(textField_15, gbc_textField_15);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("country");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);
		
		CountryField = new JTextField();
		CountryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CountryField.setColumns(10);
		GridBagConstraints gbc_CountryField = new GridBagConstraints();
		gbc_CountryField.insets = new Insets(0, 0, 5, 5);
		gbc_CountryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CountryField.gridx = 1;
		gbc_CountryField.gridy = 7;
		contentPane.add(CountryField, gbc_CountryField);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1_1.setEnabled(false);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1_1.gridx = 2;
		gbc_lblNewLabel_3_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_3_1_1_1, gbc_lblNewLabel_3_1_1_1);
		
		textField_16 = new JTextField();
		textField_16.setEnabled(false);
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_16.setColumns(10);
		GridBagConstraints gbc_textField_16 = new GridBagConstraints();
		gbc_textField_16.insets = new Insets(0, 0, 5, 0);
		gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_16.gridx = 3;
		gbc_textField_16.gridy = 7;
		contentPane.add(textField_16, gbc_textField_16);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("state");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 8;
		contentPane.add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);
		
		StateField = new JTextField();
		StateField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StateField.setColumns(10);
		GridBagConstraints gbc_StateField = new GridBagConstraints();
		gbc_StateField.insets = new Insets(0, 0, 5, 5);
		gbc_StateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_StateField.gridx = 1;
		gbc_StateField.gridy = 8;
		contentPane.add(StateField, gbc_StateField);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1_1_1.setEnabled(false);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_3_1_1_1_1.gridy = 8;
		contentPane.add(lblNewLabel_3_1_1_1_1, gbc_lblNewLabel_3_1_1_1_1);
		
		textField_17 = new JTextField();
		textField_17.setEnabled(false);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_17.setColumns(10);
		GridBagConstraints gbc_textField_17 = new GridBagConstraints();
		gbc_textField_17.insets = new Insets(0, 0, 5, 0);
		gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_17.gridx = 3;
		gbc_textField_17.gridy = 8;
		contentPane.add(textField_17, gbc_textField_17);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("pin code");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridy = 9;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1);
		
		Pincode = new JTextField();
		Pincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Pincode.setColumns(10);
		GridBagConstraints gbc_Pincode = new GridBagConstraints();
		gbc_Pincode.insets = new Insets(0, 0, 5, 5);
		gbc_Pincode.fill = GridBagConstraints.HORIZONTAL;
		gbc_Pincode.gridx = 1;
		gbc_Pincode.gridy = 9;
		contentPane.add(Pincode, gbc_Pincode);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 10;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("phone no.");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridy = 11;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1);
		
		PhoneField = new JTextField();
		PhoneField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PhoneField.setColumns(10);
		GridBagConstraints gbc_PhoneField = new GridBagConstraints();
		gbc_PhoneField.insets = new Insets(0, 0, 5, 5);
		gbc_PhoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PhoneField.gridx = 1;
		gbc_PhoneField.gridy = 11;
		contentPane.add(PhoneField, gbc_PhoneField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("mobile no.");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1.gridy = 12;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		MobileField = new JTextField();
		MobileField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MobileField.setColumns(10);
		GridBagConstraints gbc_MobileField = new GridBagConstraints();
		gbc_MobileField.insets = new Insets(0, 0, 5, 5);
		gbc_MobileField.fill = GridBagConstraints.HORIZONTAL;
		gbc_MobileField.gridx = 1;
		gbc_MobileField.gridy = 12;
		contentPane.add(MobileField, gbc_MobileField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new JLabel("fax no");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1.gridy = 13;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1);
		
		FaxField = new JTextField();
		FaxField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FaxField.setColumns(10);
		GridBagConstraints gbc_FaxField = new GridBagConstraints();
		gbc_FaxField.insets = new Insets(0, 0, 5, 5);
		gbc_FaxField.fill = GridBagConstraints.HORIZONTAL;
		gbc_FaxField.gridx = 1;
		gbc_FaxField.gridy = 13;
		contentPane.add(FaxField, gbc_FaxField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("e-mail");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.gridy = 14;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1);
		
		EmailField = new JTextField();
		EmailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailField.setColumns(10);
		GridBagConstraints gbc_EmailField = new GridBagConstraints();
		gbc_EmailField.insets = new Insets(0, 0, 5, 5);
		gbc_EmailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_EmailField.gridx = 1;
		gbc_EmailField.gridy = 14;
		contentPane.add(EmailField, gbc_EmailField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("website");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.gridy = 15;
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1);
		
		WebField = new JTextField();
		WebField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		WebField.setColumns(10);
		GridBagConstraints gbc_WebField = new GridBagConstraints();
		gbc_WebField.insets = new Insets(0, 0, 5, 5);
		gbc_WebField.fill = GridBagConstraints.HORIZONTAL;
		gbc_WebField.gridx = 1;
		gbc_WebField.gridy = 15;
		contentPane.add(WebField, gbc_WebField);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue.gridwidth = 2;
		gbc_horizontalGlue.gridx = 0;
		gbc_horizontalGlue.gridy = 16;
		contentPane.add(horizontalGlue, gbc_horizontalGlue);
		
		JButton btnNewButton = new JButton("Sign-up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 18;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 18;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
