package Views;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTable;


import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
public class TrialFrameDupli extends javax.swing.JInternalFrame {
    public TrialFrameDupli() {
    	setResizable(true);
    	setMaximizable(true);
    	setIconifiable(true);
    	setClosable(true);
        initComponents();
    }
    public javax.swing.JTabbedPane getjTabbedPane1() {
		return TabbedPane;
	}
	public void setjTabbedPane1(javax.swing.JTabbedPane jTabbedPane1) {
		this.TabbedPane = jTabbedPane1;
	}
	public JTextField getDebitField() {
		return DebitField;
	}
	public void setDebitField(JTextField debitField) {
		DebitField = debitField;
	}
	public JTextField getCreditField() {
		return CreditField;
	}
	public void setCreditField(JTextField creditField) {
		CreditField = creditField;
	}
	public JTextField getDifferenceField() {
		return DifferenceField;
	}
	public void setDifferenceField(JTextField differenceField) {
		DifferenceField = differenceField;
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EndDate = new org.jdesktop.swingx.JXDatePicker();
        EndDate.setDate(new Date());
        StartDate = new org.jdesktop.swingx.JXDatePicker();
        GroupTable = new JTable(3,3);
        SubgroupTable = new JTable(3,3);
        AccountTable = new JTable(3,3);
        StartDate.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        StartDate.setDate(new Date());
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ShowButton = new javax.swing.JButton();
        TabbedPane = new javax.swing.JTabbedPane();
        TabbedPane.setFont(new Font("Dialog", Font.BOLD, 16));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRIAL BALANCE");
       
        setName("TrialBalance"); // NOI18N

        EndDate.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        StartDate.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("TRIAL BALANCE");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TO");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FROM");

        ShowButton.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        ShowButton.setText("SHOW");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(StartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(50)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(EndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(ShowButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(StartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel1))
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(EndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel2))
        				.addComponent(ShowButton))
        			.addGap(12))
        );
        jPanel1.setLayout(jPanel1Layout);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(TabbedPane, java.awt.BorderLayout.CENTER);
        
        scrollPane = new JScrollPane();
        TabbedPane.addTab("GROUPMASTER", null, scrollPane, null);
        
        GroupTable = new JTable();
        GroupTable.setShowGrid(true);
        scrollPane.setViewportView(GroupTable);
        GroupTable.setFont(new Font("Calibre",Font.BOLD,25));
        GroupTable.setRowHeight(28);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        TabbedPane.addTab("SUBGROUPMASTER", null, scrollPane_1, null);
        
        SubgroupTable = new JTable();
        SubgroupTable.setShowGrid(true);
        SubgroupTable.setFont(new Font("Calibre",Font.BOLD,25));
        SubgroupTable.setRowHeight(28);
        SubgroupTable.setRowSelectionAllowed(true);
        scrollPane_1.setViewportView(SubgroupTable);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        TabbedPane.addTab("ACCOUNTMASTER", null, scrollPane_2, null);
        
        AccountTable = new JTable();
        AccountTable.setRowSelectionAllowed(true);
        AccountTable.setShowGrid(true);
        AccountTable.setFont(new Font("Calibre",Font.BOLD,25));
        AccountTable.setRowHeight(28);
        scrollPane_2.setViewportView(AccountTable);
        
        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        lblTotalDebit = new JLabel("TOTAL DEBIT");
        lblTotalDebit.setFont(new Font("Dialog", Font.BOLD, 25));
        panel.add(lblTotalDebit);
        
        DebitField = new JTextField();
        DebitField.setFont(new Font("Carlito", Font.BOLD, 25));
        panel.add(DebitField);
        DebitField.setColumns(10);
        
        lblTotalCredit = new JLabel("TOTAL CREDIT");
        lblTotalCredit.setFont(new Font("Dialog", Font.BOLD, 25));
        panel.add(lblTotalCredit);
        
        CreditField = new JTextField();
        CreditField.setFont(new Font("Dialog", Font.PLAIN, 25));
        CreditField.setColumns(10);
        panel.add(CreditField);
        
        lblTotalDifference = new JLabel("TOTAL DIFFERENCE");
        lblTotalDifference.setFont(new Font("Dialog", Font.BOLD, 25));
        panel.add(lblTotalDifference);
        
        DifferenceField = new JTextField();
        DifferenceField.setFont(new Font("Dialog", Font.PLAIN, 25));
        DifferenceField.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(DifferenceField);
        DifferenceField.setColumns(10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ShowButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane TabbedPane;
    private org.jdesktop.swingx.JXDatePicker EndDate;
    private org.jdesktop.swingx.JXDatePicker StartDate;
    private java.awt.Label label1;
    private JPanel panel;
    private JLabel lblTotalDebit;
    private JTextField DebitField;
    private JLabel lblTotalCredit;
    private JTextField CreditField;
    private JLabel lblTotalDifference;
    private JTextField DifferenceField;
    private JScrollPane scrollPane;
    private JTable GroupTable;
    public JTable getGroupTable() {
		return GroupTable;
	}
	public JTable getSubgroupTable() {
		return SubgroupTable;
	}
	public JTable getAccountTable() {
		return AccountTable;
	}

	private JTable SubgroupTable;
    private JTable AccountTable;
	
	public JButton getShowButton() {
		return this.ShowButton;
	}
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return this.EndDate.getDate();
	}
	public Date getStartDate() {
		return this.StartDate.getDate();
	}
	
	}
    // End of variables declaration//GEN-END:variables