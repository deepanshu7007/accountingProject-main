package CheckCodes;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class OrderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMobileNo;
	private JTable table;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					OrderFrame frame = new OrderFrame();
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
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setForeground(Color.WHITE);
		lblCompanyName.setOpaque(true);
		lblCompanyName.setBackground(Color.BLUE);
		lblCompanyName.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(lblCompanyName, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{106, 96, 161, 30, 316, 0};
		gbl_panel.rowHeights = new int[]{34, 34, 44, 323, 258, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Shop"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Take Away"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 0;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		txtMobileNo = new JTextField();
		txtMobileNo.addMouseListener(new MouseAdapter() {
			  
			  public void mouseClicked(MouseEvent e) {
			    txtMobileNo.setText("");
			  }
			});
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMobileNo = new GridBagConstraints();
		gbc_lblMobileNo.anchor = GridBagConstraints.WEST;
		gbc_lblMobileNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNo.gridx = 0;
		gbc_lblMobileNo.gridy = 1;
		panel.add(lblMobileNo, gbc_lblMobileNo);
		txtMobileNo.setFont(new Font("Dialog", Font.PLAIN, 25));
		GridBagConstraints gbc_txtMobileNo = new GridBagConstraints();
		gbc_txtMobileNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtMobileNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtMobileNo.gridwidth = 2;
		gbc_txtMobileNo.gridx = 1;
		gbc_txtMobileNo.gridy = 1;
		panel.add(txtMobileNo, gbc_txtMobileNo);
		txtMobileNo.setColumns(10);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.gridwidth = 2;
		gbc_lblCode.insets = new Insets(0, 0, 5, 0);
		gbc_lblCode.gridx = 3;
		gbc_lblCode.gridy = 1;
		panel.add(lblCode, gbc_lblCode);
		
		JLabel lblCustname = new JLabel("Cust-Name");
		lblCustname.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCustname = new GridBagConstraints();
		gbc_lblCustname.anchor = GridBagConstraints.WEST;
		gbc_lblCustname.fill = GridBagConstraints.VERTICAL;
		gbc_lblCustname.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustname.gridx = 0;
		gbc_lblCustname.gridy = 2;
		panel.add(lblCustname, gbc_lblCustname);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.VERTICAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		
		JLabel lblSearchByName = new JLabel("Search by name");
		lblSearchByName.setFont(new Font("Dialog", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSearchByName = new GridBagConstraints();
		gbc_lblSearchByName.anchor = GridBagConstraints.WEST;
		gbc_lblSearchByName.fill = GridBagConstraints.VERTICAL;
		gbc_lblSearchByName.insets = new Insets(0, 0, 5, 0);
		gbc_lblSearchByName.gridwidth = 2;
		gbc_lblSearchByName.gridx = 3;
		gbc_lblSearchByName.gridy = 2;
		panel.add(lblSearchByName, gbc_lblSearchByName);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.WEST;
		gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);
		
		 table = new JTable(new ExampleTableModel());
		 
		 	        table.getColumn("action").setCellRenderer(new ButtonCellRenderer());
		 	        table.getColumn("action").setCellEditor(new ButtonCellEditor());
		 	        table.getColumn("Qty").setCellEditor(new SpinnerEditor());
		 	        table.getColumn("Qty").setCellRenderer(new SpinnerRenderer());
		 	        
		 	        	        
		 	        		table.setFont(new Font("Dialog", Font.PLAIN, 23));
		 	        		JTableHeader header = table.getTableHeader();
		 	        		
		 	        		table.setRowHeight(25);
		 	        		scrollPane.setViewportView(table);
		 	        		table.getColumnModel().getColumn(0).setPreferredWidth(26);
		 	        		table.getColumnModel().getColumn(1).setPreferredWidth(26);
		 	        		table.getColumnModel().getColumn(2).setPreferredWidth(26);
		 	        		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		 	        		table.getColumnModel().getColumn(4).setPreferredWidth(25);	
		
		table = new JTable();
		header.setFont(new Font("Dialog", Font.PLAIN, 25));
		header.setPreferredSize(new Dimension(100, 50));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{101, 26, 66, 3, 80, 62, 45, 0};
		gbl_panel_1.rowHeights = new int[]{24, 19, 10, 19, 2, 53, 53, 53, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Remarks:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 0;
		panel_1.add(textField_3, gbc_textField_3);
		
		JLabel label = new JLabel("2");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 6;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel lblLastBill = new JLabel("Last Bill:");
		lblLastBill.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblLastBill = new GridBagConstraints();
		gbc_lblLastBill.anchor = GridBagConstraints.NORTH;
		gbc_lblLastBill.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLastBill.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastBill.gridwidth = 2;
		gbc_lblLastBill.gridx = 0;
		gbc_lblLastBill.gridy = 1;
		panel_1.add(lblLastBill, gbc_lblLastBill);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.anchor = GridBagConstraints.NORTH;
		gbc_lblAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridwidth = 3;
		gbc_lblAmount.gridx = 2;
		gbc_lblAmount.gridy = 1;
		panel_1.add(lblAmount, gbc_lblAmount);
		
		JLabel lblAmount_1 = new JLabel("0.00");
		lblAmount_1.setForeground(Color.RED);
		lblAmount_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAmount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_1 = new GridBagConstraints();
		gbc_lblAmount_1.anchor = GridBagConstraints.NORTH;
		gbc_lblAmount_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAmount_1.gridwidth = 2;
		gbc_lblAmount_1.gridx = 5;
		gbc_lblAmount_1.gridy = 1;
		panel_1.add(lblAmount_1, gbc_lblAmount_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 7;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panel_1.add(separator, gbc_separator);
		
		JLabel lblNewLabel_1 = new JLabel("Date and Time:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridwidth = 7;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.anchor = GridBagConstraints.NORTH;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridwidth = 7;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 4;
		panel_1.add(separator_1, gbc_separator_1);
		
		JButton btnNewButton = new JButton("-250");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("+250");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 5;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("-500");
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1.gridwidth = 2;
		gbc_btnNewButton_1_1.gridx = 3;
		gbc_btnNewButton_1_1.gridy = 5;
		panel_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("+500");
		btnNewButton_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1_1.gridwidth = 2;
		gbc_btnNewButton_1_1_1.gridx = 5;
		gbc_btnNewButton_1_1_1.gridy = 5;
		panel_1.add(btnNewButton_1_1_1, gbc_btnNewButton_1_1_1);
		
		JButton btnNewButton_2 = new JButton("HOLD");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridwidth = 4;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 6;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2_1.gridwidth = 3;
		gbc_btnNewButton_2_1.gridx = 4;
		gbc_btnNewButton_2_1.gridy = 6;
		panel_1.add(btnNewButton_2_1, gbc_btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("New button");
		btnNewButton_2_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2_2 = new GridBagConstraints();
		gbc_btnNewButton_2_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2_2.gridwidth = 4;
		gbc_btnNewButton_2_2.gridx = 0;
		gbc_btnNewButton_2_2.gridy = 7;
		panel_1.add(btnNewButton_2_2, gbc_btnNewButton_2_2);
		
		JButton btnNewButton_2_2_1 = new JButton("New button");
		btnNewButton_2_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_2_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_2_1.gridwidth = 3;
		gbc_btnNewButton_2_2_1.gridx = 4;
		gbc_btnNewButton_2_2_1.gridy = 7;
		panel_1.add(btnNewButton_2_2_1, gbc_btnNewButton_2_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.RED, 2, true));
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1_1.gridx = 4;
		gbc_panel_1_1.gridy = 4;
		panel.add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{73, 116, 0, 140, 0};
		gbl_panel_1_1.rowHeights = new int[]{40, 40, 39, 40, 40, 40, 0, 0};
		gbl_panel_1_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JLabel lblAmount_2 = new JLabel("Amount");
		lblAmount_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2 = new GridBagConstraints();
		gbc_lblAmount_2.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2.gridx = 0;
		gbc_lblAmount_2.gridy = 0;
		panel_1_1.add(lblAmount_2, gbc_lblAmount_2);
		
		JLabel lblNewLabel_2 = new JLabel("200");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblAmount_2_1 = new JLabel("Discount");
		lblAmount_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1 = new GridBagConstraints();
		gbc_lblAmount_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1.gridx = 0;
		gbc_lblAmount_2_1.gridy = 1;
		panel_1_1.add(lblAmount_2_1, gbc_lblAmount_2_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel_1_1.add(textField_4, gbc_textField_4);
		
		JLabel label_1 = new JLabel("%");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 1;
		panel_1_1.add(label_1, gbc_label_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 1;
		panel_1_1.add(textField_5, gbc_textField_5);
		
		JLabel lblAmount_2_1_1 = new JLabel("GST Amount");
		lblAmount_2_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1.gridx = 0;
		gbc_lblAmount_2_1_1.gridy = 2;
		panel_1_1.add(lblAmount_2_1_1, gbc_lblAmount_2_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("0.00");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1.gridx = 3;
		gbc_lblNewLabel_2_1.gridy = 2;
		panel_1_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		JLabel lblAmount_2_1_1_1 = new JLabel("Delivery Charges");
		lblAmount_2_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1_1.gridx = 0;
		gbc_lblAmount_2_1_1_1.gridy = 3;
		panel_1_1.add(lblAmount_2_1_1_1, gbc_lblAmount_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 3;
		panel_1_1.add(textField_6, gbc_textField_6);
		
		JLabel lblAmount_2_1_1_1_1 = new JLabel("Coupon");
		lblAmount_2_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1_1_1.gridx = 0;
		gbc_lblAmount_2_1_1_1_1.gridy = 4;
		panel_1_1.add(lblAmount_2_1_1_1_1, gbc_lblAmount_2_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.VERTICAL;
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 4;
		panel_1_1.add(textField_7, gbc_textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Dialog", Font.PLAIN, 17));
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.gridx = 3;
		gbc_textField_8.gridy = 4;
		panel_1_1.add(textField_8, gbc_textField_8);
		
		JLabel lblAmount_2_1_1_1_1_1 = new JLabel("Net Amount");
		lblAmount_2_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAmount_2_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblAmount_2_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount_2_1_1_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblAmount_2_1_1_1_1_1.gridx = 0;
		gbc_lblAmount_2_1_1_1_1_1.gridy = 5;
		panel_1_1.add(lblAmount_2_1_1_1_1_1, gbc_lblAmount_2_1_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("200");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 5;
		panel_1_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("200");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.gridx = 3;
		gbc_lblNewLabel_3_1.gridy = 6;
		panel_1_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
	}
	public static class ExampleTableModel extends DefaultTableModel {

        public ExampleTableModel() {
            super(new Object[]{"Name", "Qty","Price" ,"Amount", "action"}, 0);
            for (int index = 0; index < 10; index++) {
                addRow(new Object[]{"Item " + index, 0.00,0.00, index});
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 4 || columnIndex == 1||columnIndex == 2 || columnIndex == 3;
        }

    }

    public static class ButtonCellRenderer extends JButton implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        	Icon icon;
        	if (value != null) {
            	icon = new ImageIcon("/home/deepanshu/Desktop/trash.png");
                
                setIcon(icon);
            } else {
            	icon = new ImageIcon("/home/deepanshu/Desktop/trash.png");

            	setIcon(icon);
            }
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            return this;
        }
    }
    public static class SpinnerRenderer extends JSpinner implements TableCellRenderer
    {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value != null) {
                setValue(value);
                setFont(new Font("Dialog", Font.BOLD, 20));
            } else {
                setValue(value);
                setFont(new Font("Dialog", Font.BOLD, 20));
            }
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
			return this;
		}
    	
    }
   public static class SpinnerEditor extends DefaultCellEditor
    {
        private JSpinner spinner;

        public SpinnerEditor()
        {
            super( new JTextField() );
            spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 5));
            spinner.setBorder( null );
            spinner.setFont(new Font("Dialog", Font.BOLD, 20));
        }

        public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            spinner.setValue( value );
            return spinner;
        }

        public Object getCellEditorValue()
        {
            return spinner.getValue();
        }
    }
    public static class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

        private JButton editor;
        private Object value;
        private int row;
        private JTable table;

        public ButtonCellEditor() {
            editor = new JButton();
            editor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (table != null) {
                        fireEditingStopped();
                        TableModel model = table.getModel();
                        if (model instanceof DefaultTableModel) {
                            ((DefaultTableModel) model).removeRow(row);
                        }
                    }
                }
            });
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

        @Override
        public Object getCellEditorValue() {
            return value;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;
            this.value = value;
            if (value != null) {
                editor.setText("Delete row " + value.toString());
            } else {
                editor.setText("Delete Me");
            }
            if (isSelected) {
                editor.setForeground(table.getSelectionForeground());
                editor.setBackground(table.getSelectionBackground());
            } else {
                editor.setForeground(table.getForeground());
                editor.setBackground(UIManager.getColor("Button.background"));
            }
            return editor;
        }
    }
}




