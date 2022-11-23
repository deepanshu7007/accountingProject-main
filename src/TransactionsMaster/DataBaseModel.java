package TransactionsMaster;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;

import LedgerMaster.OpenDataBase;

import java.sql.Statement;
import java.sql.Date;

public class DataBaseModel extends AbstractTableModel {
	private ArrayList<DataEntry> DataEntryList;
	protected Double TempValue;
//	private Object bValue;
	
	public Double getTempValue() {
		return this.TempValue;
	}

	/**
	 * Returns the value of the field called 'dataEntryList'.
	 * 
	 * @return Returns the dataEntryList.
	 */
	public ArrayList<DataEntry> getDataEntryList() {
		return this.DataEntryList;
	}

	protected double totalDebit = 0.00, totalCredit = 0.00;

	/**
	 * Returns the value of the field called 'totalDebit'.
	 * 
	 * @return Returns the totalDebit.
	 */
	public double getTotalDebit() {
		return this.totalDebit;
	}

	/**
	 * Sets the field called 'totalDebit' to the given value.
	 * 
	 * @param totalDebit The totalDebit to set.
	 */
	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;

	}

	/**
	 * Returns the value of the field called 'totalCredit'.
	 * 
	 * @return Returns the totalCredit.
	 */
	public double getTotalCredit() {
		return this.totalCredit;
	}

	/**
	 * Sets the field called 'totalCredit' to the given value.
	 * 
	 * @param totalCredit The totalCredit to set.
	 */
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}

	private final String[] columnNames = new String[] { "Account", "Debit", "Credit" };

	private final Class[] columnClass = new Class[] { String.class,Double.class, Double.class };

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return DataEntryList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DataEntry row = DataEntryList.get(rowIndex);
		if (0 == columnIndex) {
			return row.getAccountName();
		} else if (1 == columnIndex) {
			return row.getDebitValue();
		} else if (2 == columnIndex) {
			return row.getCreditValue();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 1 || columnIndex == 2) {
			TempValue = Double.valueOf(getValueAt(rowIndex, columnIndex).toString());
		}
		return true;
	}

//	public void setAliasValue(Object bValue) {
////		this.bValue = bValue;
//	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		DataEntry row = DataEntryList.get(rowIndex);

		if (1 == columnIndex) {
			row.setDebitValue(Double.parseDouble(aValue.toString()));
			row.setSide('D');
			setTotalDebit(getTotalDebit() - TempValue + Double.valueOf(aValue.toString()));
		}
		if (2 == columnIndex) {
			row.setCreditValue(Double.parseDouble(aValue.toString()));
			row.setSide('C');
			setTotalCredit(getTotalCredit() - TempValue + Double.valueOf(aValue.toString()));
		}
		fireTableRowsUpdated(rowIndex, columnIndex);
	}

	public void nextSetValueAt(Object aValue, int rowIndex, int columnIndex) {

		DataEntry row = DataEntryList.get(rowIndex);
		if (0 == columnIndex) {
			Vector<Object> obj = (Vector<Object>) aValue;
			row.setAccountName(obj.get(1).toString());
			row.setAliasName(obj.get(0).toString());
		}
		fireTableRowsUpdated(rowIndex, columnIndex);
	}

	public void removeRow(int row) {
		DataEntry deleteRow = DataEntryList.get(row);
		Double debitValue, creditValue;
		debitValue = Double.valueOf(deleteRow.getDebitValue());
		creditValue = Double.valueOf(deleteRow.getCreditValue());
		totalDebit = totalDebit - debitValue;
		totalCredit = totalCredit - creditValue;
		DataEntryList.remove(row);
		fireTableRowsDeleted(row, row);
	}

	public void addRow(DataEntry al) {
		DataEntryList.add(al);
		System.out.println("-->>" + al.getTotalValue());
		this.totalDebit = this.totalDebit + al.getDebitValue();
		this.totalCredit = this.totalCredit + al.getCreditValue();
		fireTableDataChanged();
	}

	public void UpdateRecord(int TransactionId, java.util.Date transactionDate, String narration, String type)
			throws SQLException {
		DeleteRecord(TransactionId);
		
		int totalTransactions = TransactionId;
		OpenDataBase db = new OpenDataBase();
		con = db.getDataBaseConnection();
		Date transDate = new Date(transactionDate.getTime());
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO TRANSACTIONMASTER (TTYPE,TDOC,TDATE,TCODE,NAME,TDBCR,TNAR1,TAMT) VALUES (?,?,?,?,?,?,?,?)");
		con.setAutoCommit(false);
		for (DataEntry de : DataEntryList) {
			stmt.setString(5, de.getAccountName());
			stmt.setDate(3, transDate);
			stmt.setString(4, de.getAliasName());
			stmt.setInt(2, totalTransactions);
			stmt.setString(1, type);
			stmt.setString(7, narration);
			stmt.setDouble(8, de.getTotalValue());
			stmt.setString(6, String.valueOf(de.getSide()));
			stmt.addBatch();
		}
		stmt.executeBatch();
		con.commit();
		System.out.println("TRANSACTION SUCCESSFULLY UPDATED");
	}

	public void InsertRecord(java.util.Date transactionDate, String narration, String type) throws SQLException {
		OpenDataBase db =new OpenDataBase();
		con = db.getDataBaseConnection();
		Date transDate = new Date(transactionDate.getTime());
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO TRANSACTIONMASTER (TTYPE,TDOC,TDATE,TCODE,NAME,TDBCR,TNAR1,TAMT) VALUES (?,?,?,?,?,?,?,?)");
		CallableStatement cstmt = con.prepareCall("{call get_account(?,?,?)}");
		con.setAutoCommit(false);
		for (DataEntry de : DataEntryList) {
			stmt.setString(5, de.getAccountName());
			stmt.setDate(3, transDate);
			stmt.setString(4, de.getAliasName());
			stmt.setInt(2, getTotalTransactions());
			stmt.setString(1, type);
			stmt.setString(7, narration);
			stmt.setDouble(8, de.getTotalValue());
			stmt.setString(6, String.valueOf(de.getSide()));
			cstmt.setString(1, de.getAliasName());
			cstmt.setDouble(2,de.getTotalValue());
			cstmt.setString(3,String.valueOf(de.getSide()));
			
			cstmt.addBatch();
			stmt.addBatch();
		}
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			   @Override
			   protected Void doInBackground() throws Exception {
				   stmt.executeBatch();
				   cstmt.executeBatch();
					con.commit();
					con.close();
			    return null;
			   }
			  };
			  
			  worker.execute();
		
	}

	private int getTotalTransactions() {
		int val=0;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM TRANSACTIONMASTER");
			while(rs.next())
			{
				val = rs.getInt("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}

	public void DeleteRecord(int TransactionId) throws SQLException {
		OpenDataBase db = new OpenDataBase();
		con = db.getDataBaseConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM TRANSACTIONMASTER WHERE TDOC=" + TransactionId);
		System.out.println("Record successfully deleted");
		con.close();
	}

	Connection con;

	public DataBaseModel(ArrayList<DataEntry> employeeList) {

		this.DataEntryList = employeeList;
//	    	ArrayList<DataEntry> data = new ArrayList<DataEntry>();
//	      	 data.add(new DataEntry());
//	      	 this.DataEntryList = data;
	}
	public DataBaseModel() {
		this.DataEntryList = new ArrayList<DataEntry>();
	}
	

	
}
