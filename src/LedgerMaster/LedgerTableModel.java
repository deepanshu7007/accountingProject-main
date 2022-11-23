package LedgerMaster;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import TransactionsMaster.DataEntry;

public class LedgerTableModel extends AbstractTableModel {
	private double totalDebit, totalCredit;

	/**
	 * Returns the value of the field called 'totalDebit'.
	 * 
	 * @return Returns the totalDebit.
	 */
	public double getTotalDebit() {
		return this.totalDebit;
	}

	/**
	 * Returns the value of the field called 'totalCredit'.
	 * 
	 * @return Returns the totalCredit.
	 */
	public double getTotalCredit() {
		return this.totalCredit;
	}

	public static double totalBalance;
	private String[] ColumnNames;
	private ArrayList<DataEntry> Data;


	/**
	 * Returns the value of the field called 'data'.
	 * @return Returns the data.
	 */
	public ArrayList<DataEntry> getData() {
		return this.Data;
	}

	private DataEntry DataObject;

	public LedgerTableModel(ResultSet rs) throws SQLException {
		totalBalance=0;
		ColumnNames = new String[] { "DATE", "NARRATION", "TYPE", "DEBIT", "CREDIT", "TOTALBALANCE", "DB/CR" };
		Data = new ArrayList<DataEntry>();
		DataObject = new DataEntry();
		BuiltTableModel(rs);
	}

	public void BuiltTableModel(ResultSet rs) throws SQLException {
		String side;
		double amount;
		while (rs.next()) {
			DataObject = new DataEntry();
			DataObject.setTransactionDate(rs.getDate("TDATE"));
			DataObject.setNarration(rs.getString("TNAR1"));
			DataObject.setType(rs.getString("TTYPE"));
			DataObject.setTransID(rs.getInt("TDOC"));
			side = rs.getString("TDBCR");
			amount = rs.getDouble("TAMT");
			if(side.charAt(0)=='D')
			{
				totalDebit  = totalDebit + amount;
			}
			else
			{
				totalCredit = totalCredit + amount;
			}
			DataObject.setTotalValue(side, amount);
			DataObject.setBalance(calculateBalance(side, amount));
			
			Data.add(DataObject);
		}
	}

	private final Class[] columnClass = new Class[] { Date.class, String.class, String.class, Double.class,
			Double.class, Double.class, String.class };

	@Override
	public String getColumnName(int column) {
		return ColumnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return ColumnNames.length;
	}

	@Override
	public int getRowCount() {
		return Data.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		DataEntry DataObject = Data.get(row);
		if (column == 0)
			return DataObject.getTransactionDate();
		else if (column == 1)
			return DataObject.getNarration();
		else if (column == 2)
			return DataObject.getType();
		else if (column == 3)
			return DataObject.getDebitValue();
		else if (column == 4)
			return DataObject.getCreditValue();
		else if (column == 5)
			return Math.abs(DataObject.getTotalBalance());
		else if (column == 6)
			return DataObject.getSideDBCR();
		else
			return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void addRow(DataEntry al) {
		Data.add(al);
		fireTableDataChanged();
	}
	public void setValueAt(DataEntry al,int row)
	{
		DataEntry rowData = Data.get(row);
		rowData.setDebitValue(10);
		fireTableDataChanged();
	}
	private double calculateBalance(String side, double balance) {
		if (side.charAt(0) == 'D') {
			totalBalance = totalBalance + balance;
		}
		if (side.charAt(0) == 'C') {
			totalBalance = totalBalance - balance;
		}
		return totalBalance;
	}
}
