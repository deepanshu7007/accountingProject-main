package TrialMaster;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.ListSelectionModel;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
//import javax.swing.table.TableColumnModel;
import javax.swing.table.TableColumnModel;

import LedgerMaster.LedgerController;
import LedgerMaster.LedgerFrame;
import Views.TrialFrameDupli;
//import TransactionsMaster.DataBaseModel;
//import TransactionsMaster.DataEntry;
//import TransactionsMaster.VoucherController;

public class TrialFrameController {
	private double totalDebit=0;
	private double totalCredit=0;
	private double totalDifference=0;
	public JInternalFrame getTrialFrame() {
		return this.frame;
	}

	public void setVisibleFrame() {
		frame.setVisible(true);
	}

	TrialFrameDupli frame;
	TrialOp model;
	JTable accountTable,groupTable,subGroupTable;
	public TrialFrameController() {
		frame = new TrialFrameDupli();
		model = new TrialOp();
		JTabbedPane tabbedPane = frame.getjTabbedPane1();
		tabbedPane.setEnabledAt(0, false);
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int index = tabbedPane.getSelectedIndex();
				switch (index) {
				case 0: {
					totalDebit = model.getTotalDebitGroup();
					totalCredit = model.getTotalCreditGroup();
					frame.getDebitField().setText(String.valueOf(totalDebit));
					frame.getCreditField().setText(String.valueOf(totalCredit));
					frame.getDifferenceField().setText(String.valueOf(Math.abs(totalDebit-totalCredit)));
					break;
				}
				case 1: {
					totalDebit = model.getTotalDebitSub();
					totalCredit = model.getTotalCreditSub();
					frame.getDebitField().setText(String.valueOf(totalDebit));
					frame.getCreditField().setText(String.valueOf(totalCredit));
					frame.getDifferenceField().setText(String.valueOf(Math.abs(totalDebit-totalCredit)));
					break;
				}
				case 2: {
					totalDebit = model.getTotalDebitAccount();
					totalCredit = model.getTotalCreditAccount();
					frame.getDebitField().setText(String.valueOf(totalDebit));
					frame.getCreditField().setText(String.valueOf(totalCredit));
					frame.getDifferenceField().setText(String.valueOf(Math.abs(totalDebit-totalCredit)));
					break;
				}
				}
			}
		});
		try {
			frame.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		frame.getAccountTable().getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "explore");
		frame.getAccountTable().getActionMap().put("explore", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = frame.getAccountTable().getSelectedRow();
				String accountName = model.getForAccountMaster().get(row).getName();
				String aliasName = model.getForAccountMaster().get(row).getAliasName();
				LedgerFrame lf = new LedgerFrame();
				Date StartDate = frame.getStartDate();
				Date EndDate = frame.getEndDate();
				System.out.println("ALias name" + aliasName);
				LedgerController lc = lf.getLc();
				frame.getParent().add(lf);
				lc.setAliasName(aliasName);
				lc.viewLedger( StartDate, EndDate, accountName);
				lf.setVisible(true);
			}
		});

		JTableHeader header = frame.getAccountTable().getTableHeader();
		header.setFont(new Font("Ariel", Font.BOLD, 22));
		frame.getShowButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model = new TrialOp();
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	frame.getjTabbedPane1().setSelectedIndex(2);
						frame.getAccountTable().setModel(model.getAccountModel(frame.getStartDate(), frame.getEndDate()));
						frame.getSubgroupTable().setModel(model.getSubGroupModel());
						frame.getGroupTable().setModel(model.getGroupModel());
						/*frame.getAccountTable().setDefaultRenderer(String.class, (new DefaultTableCellRenderer()
						{
						    @Override
						    public JComponent getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
						    {
						        JComponent c = (JComponent)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
						        if(value.equals("GROUPMASTER"))
						        {
						        	c.setBackground(Color.DARK_GRAY);
						        }
						        else if(value.equals("SUBGROUPMASTER"))
						        {
						        	c.setBackground(Color.LIGHT_GRAY);
						        }
						        else if(value.equals("ACCOUNTMASTER"))
						        {
						        	c.setBackground(Color.WHITE);
						        	c.setForeground(Color.black);
						        }
						        return c;
						    }
						}));*/
//						frame.getAccountTable().removeColumn(frame.getAccountTable().getColumnModel().getColumn(3));
//						frame.getSubgroupTable().removeColumn(frame.getSubgroupTable().getColumnModel().getColumn(3));
//						frame.getGroupTable().removeColumn(frame.getGroupTable().getColumnModel().getColumn(3));
//						
						frame.getDebitField().setText(String.valueOf(model.getTotalDebitAccount()));
						frame.getCreditField().setText(String.valueOf(model.getTotalCreditAccount()));
						frame.getDifferenceField().setText(String.valueOf(Math.abs(model.getTotalDebitAccount()-model.getTotalCreditAccount())));
						tabbedPane.setEnabledAt(0, true);
						tabbedPane.setEnabledAt(1, true);
						tabbedPane.setEnabledAt(2, true);
		            }
		          });
				
			}
		});
		frame.getGroupTable().setRowSelectionAllowed(true);
		frame.getSubgroupTable().setRowSelectionAllowed(true);
		frame.getAccountTable().setRowSelectionAllowed(true);
		frame.setVisible(true);
	}

	public static void main(String... args) {
		new TrialFrameController();
	}
}
class GradeRenderer  implements TableCellRenderer
{
 
     
    @Override
    public JComponent getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column)
    {
    	JComponent jc = (JComponent)table.getComponentAt(row, column);
        if(value.equals("GROUPMASTER")) {
        	value = "     "+value;
            jc.setBackground(Color.GREEN);
        }
        else if(value == "SUBGROUPMASTER") {
        	value = "  "+value;
        	jc.setBackground(Color.BLUE);
        }
        else if(value == "ACCOUNTMASTER") {
        	jc.setBackground(Color.RED);
        }
         
        return jc;
    }
     
}
