package LedgerMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import SearchModule.SearchFrameTest;
import SearchModule.SearchTableModel;
import TransactionsMaster.DataEntry;
import TransactionsMaster.VoucherController;

public class LedgerController implements ActionListener {
	LedgerFrame lf;
	LedgerModel lm;
	private String aliasName;
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	String name;
	LedgerTableModel ltm;
	JButton SubmitButton;
	java.sql.Date StartDate;
	java.sql.Date EndDate;
	public void updateLedger()
	{
		try {
			System.out.println(aliasName);
			System.out.println(StartDate.getDate());
			System.out.println(EndDate.getDate());
			this.ltm = this.lm.getLedgerTableModel(aliasName, StartDate, EndDate);
			lf.getTable().setModel(this.ltm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		footerInit();
	}
	private void footerInit()
	{

		lf.setDebitTotalField(String.valueOf(ltm.getTotalDebit()));
		lf.setCreditTotalField(String.valueOf(ltm.getTotalCredit()));
		lf.getTable().getColumnModel().getColumn(3).setPreferredWidth(280);
		lf.getTable().getColumnModel().getColumn(3).setMinWidth(100);
		lf.getTable().getColumnModel().getColumn(4).setPreferredWidth(104);
		lf.getTable().getColumnModel().getColumn(5).setPreferredWidth(110);
	}
	public void viewLedger(Date StartDate,Date EndDate,String accountName)
	{
		try {
			lf.setAccountField(accountName);
			
			System.out.println("ALIAS NAME:"+this.aliasName);
			lf.setStartDate(StartDate);
			lf.setEndDate(EndDate);
			this.StartDate = new java.sql.Date(StartDate.getTime());
			this.EndDate = new java.sql.Date(EndDate.getTime());
			this.ltm = this.lm.getLedgerTableModel(this.aliasName, this.StartDate, this.EndDate);
			lf.getTable().setModel(this.ltm);
			footerInit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public LedgerController(LedgerFrame lf) {
		this.lf = lf;
		try {
			aliasName="Here is null value";
			lm = new LedgerModel();
			
		} catch (SQLException exception) {

			exception.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CHECK")) {
			SearchFrameTest sf;
			SearchTableModel sm = lm.getSearchTableModel();
			if (sm.checkAlias(lf.getAccountField())) {
				aliasName = lf.getAccountField();
				lf.setAccountField(sm.getNameByAlias(lf.getAccountField()));
			} else {
				sf = new SearchFrameTest(sm);
				sf.setVisible(true);
				sf.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt) {
						name = sf.getAccountName();
						aliasName = sf.getAliasName();
						lf.setAccountField(name);
					}
				});
			}
		}
		
		if (e.getActionCommand().equals("SUBMIT")) {
			this.StartDate = new java.sql.Date(lf.getStartDate().getDate().getTime());
			this.EndDate = new java.sql.Date(lf.getEndDate().getDate().getTime());
			try {
				this.ltm = lm.getLedgerTableModel(aliasName, StartDate, EndDate);
				lf.setDebitTotalField(String.valueOf(ltm.getTotalDebit()));
				lf.setCreditTotalField(String.valueOf(ltm.getTotalCredit()));
				lf.getTable().setModel(ltm);
				
footerInit();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}

		}
		
		if (e.getActionCommand().equals("UPDATE")) {
			this.StartDate = new java.sql.Date(lf.getStartDate().getDate().getTime());
			this.EndDate = new java.sql.Date(lf.getEndDate().getDate().getTime());
			int row = lf.getTable().getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(lf, "NO ROW IS SELECTED TO UPDATE");
			} else {
			
				ArrayList<DataEntry> data = ((LedgerTableModel)(lf.getTable().getModel())).getData();
				DataEntry de = data.get(row);
				try {
					lm.getVoucherDetails(de.getTransID(), de.getNarration(), de.getTransactionDate(), de.getType(),
							de.getTotalValue(),lf.getParent(),this);
					System.out.println("INSIDE UPDATE"+this.getAliasName());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		if (e.getActionCommand().equals("DELETE")) {
			int row = lf.getTable().getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(lf, "NO ROW IS SELECTED TO UPDATE");
			} else {
			
				ArrayList<DataEntry> data = ((LedgerTableModel)(lf.getTable().getModel())).getData();
				DataEntry de = data.get(row);
				try {
						ltm.setValueAt(de, row);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
}
