package LedgerMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import SearchModule.SearchFrameTest;
import SearchModule.SearchTableModel;
import TransactionsMaster.DataEntry;

class LedgerController implements ActionListener {
	LedgerFrame lf;
	LedgerModel lm;
	String aliasName;
	String name;
	LedgerTableModel ltm;

	LedgerController(LedgerFrame lf) {
		this.lf = lf;
		try {
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
			java.sql.Date StartDate = new java.sql.Date(lf.getStartDate().getDate().getTime());
			java.sql.Date EndDate = new java.sql.Date(lf.getEndDate().getDate().getTime());
			try {
				ltm = lm.getLedgerTableModel(aliasName, StartDate, EndDate);
				lf.setDebitTotalField(String.valueOf(ltm.getTotalDebit()));
				lf.setCreditTotalField(String.valueOf(ltm.getTotalCredit()));
				lf.getTable().setModel(ltm);

			} catch (SQLException exception) {
				exception.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("UPDATE")) {
			int row = lf.getTable().getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(lf, "NO ROW IS SELECTED TO UPDATE");
			} else {
				ArrayList<DataEntry> data = ltm.getData();
				DataEntry de = data.get(row);
				try {
					lm.getVoucherDetails(de.getTransID(), de.getNarration(), de.getTransactionDate(), de.getType(),
							de.getTotalValue());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
