package TrialMaster;

import java.util.Date;

import javax.swing.JButton;
//import javax.swing.JTable;


import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class TrialFrame extends javax.swing.JInternalFrame {
    public TrialFrame() {
    	setResizable(true);
    	setMaximizable(true);
    	setIconifiable(true);
    	setClosable(true);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EndDate = new org.jdesktop.swingx.JXDatePicker();
        EndDate.setDate(new Date());
        StartDate = new org.jdesktop.swingx.JXDatePicker();
        StartDate.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        StartDate.setDate(new Date());
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ShowButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane1.setFont(new Font("Dialog", Font.BOLD, 16));

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
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(StartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel1))
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addComponent(EndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(ShowButton)
        				.addComponent(jLabel2))
        			.addGap(12))
        );
        jPanel1.setLayout(jPanel1Layout);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        
        panel = new JPanel();
        jTabbedPane1.addTab("New tab", null, panel, null);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        lblTotalDebit = new JLabel("TOTAL DEBIT");
        panel.add(lblTotalDebit);
        
        DebitField = new JTextField();
        panel.add(DebitField);
        DebitField.setColumns(10);
        
        lblTotalCredit = new JLabel("TOTAL CREDIT");
        panel.add(lblTotalCredit);
        
        CreditField = new JTextField();
        CreditField.setColumns(10);
        panel.add(CreditField);
        
        lblTotalDifference = new JLabel("TOTAL DIFFERENCE");
        panel.add(lblTotalDifference);
        
        DifferenceField = new JTextField();
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
    private javax.swing.JTabbedPane jTabbedPane1;
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
    // End of variables declaration//GEN-END:variables    // End of variables declaration//GEN-END:variables