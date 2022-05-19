package TransactionsMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import LedgerMaster.OpenDataBase;
import SearchModule.SearchTableModel;

public class VoucherController implements ActionListener {
	private DataBaseModel ctm;
	private VoucherTransaction view;
	private JButton button;
	OpenDataBase db;
private int transId;
	public VoucherController() {
		DataEntry de = new DataEntry("", 0.0, 0.0);
		ArrayList<DataEntry> arr = new ArrayList<DataEntry>();
		arr.add(de);
		ctm = new DataBaseModel(arr);
		 db = new OpenDataBase();
	}

	public void insert() {
		
		try {
			view = new VoucherTransaction(ctm);
                        
			view.setAlwaysOnTop(true);
			Statement stmt = db.getDataBaseConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ALIAS,NAME FROM ACCOUNTMASTER");
			SearchTableModel sm = new SearchTableModel(rs);
			view.setSearchModel(sm);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		finally {
			db.ConClosed();
			System.out.println("Connection closed");
		}
		view.setVisible(true);
		button = view.getButton();
		button.setText("SUBMIT");
		button.addActionListener(this);
		button.setActionCommand("INSERT");
	}

	public void update(DataBaseModel ctm, String narrations, Date date,String type,double tamt,int transId) {
		this.ctm = ctm;
		view = new VoucherTransaction(ctm);
		this.transId=transId;
		OpenDataBase db = new OpenDataBase();
		Statement stmt;
		try {
			stmt = db.getDataBaseConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ALIAS,NAME FROM ACCOUNTMASTER");
			SearchTableModel sm = new SearchTableModel(rs);
			view.setSearchModel(sm);
		} catch (SQLException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		finally {
			db.ConClosed();
		}
		
		view.setVisible(true);		
		view.setDebitTotalField(ctm.getTotalDebit());
		view.setCreditTotalField(ctm.getTotalCredit());
		view.setNarrationField(narrations);
		view.setDate(date);
		button = view.getButton();
		button.setText("UPDATE");
		button.addActionListener(this);
		button.setActionCommand("UPDATE");
	}

	public void delete(DataBaseModel ctm) {
		view.setTableModel(ctm);
		view.setVisible(true);
		button = view.getButton();
		button.setText("DELETE");
		button.addActionListener(this);
		button.setActionCommand("DELETE");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "INSERT": {
			try {
				if (JOptionPane.showConfirmDialog(view, "Save it") == (JOptionPane.YES_OPTION)) {
					if (view.getDebitTotalField().getText().equals(view.getCreditTotalField().getText())) {
						ctm.InsertRecord(view.getDate(), view.getNarrationField(), view.getComboBox());
                                                view.clearVoucher();
                                        }else {
					JOptionPane.showMessageDialog(view, "DEBIT AND CREDIT VALUES ARE NOT EQUAL");
				}

				} 
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
			break;
		}
		case "DELETE": {
			try {
				if (JOptionPane.showConfirmDialog(view, "Delete it") == (JOptionPane.YES_OPTION)) {
					if (view.getDebitTotalField().getText().equals(view.getCreditTotalField().getText())) {
						ctm.DeleteRecord(this.transId);
						ArrayList<DataEntry> de = ctm.getDataEntryList();
						for (DataEntry val : de) {
							if (val.getAccountName().equals("")) {
								JOptionPane.showMessageDialog(view, "SOME OF THE MAJOR FIELDS ARE EMPTY");
							}
						}
					}
					view.clearVoucher();
				} else {
					JOptionPane.showMessageDialog(view, "DEBIT AND CREDIT VALUES ARE NOT EQUAL");
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
break;
		}
		case "UPDATE": {
			try {
				if (JOptionPane.showConfirmDialog(view, "Save it") == (JOptionPane.YES_OPTION)) {
					if (view.getDebitTotalField().getText().equals(view.getCreditTotalField().getText())) {
						ctm.UpdateRecord(this.transId,view.getDate(), view.getNarrationField(), view.getComboBox());
						ArrayList<DataEntry> de = ctm.getDataEntryList();
						for (DataEntry val : de) {
							if (val.getAccountName().equals("")) {
								JOptionPane.showMessageDialog(view, "SOME OF THE MAJOR FIELDS ARE EMPTY");
							}
						}
					}
					view.clearVoucher();
				} else {
					JOptionPane.showMessageDialog(view, "DEBIT AND CREDIT VALUES ARE NOT EQUAL");
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		break;
		}
		}
	}

}
