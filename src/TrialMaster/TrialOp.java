package TrialMaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableModel;

//import org.w3c.dom.views.AbstractView;

import LedgerMaster.OpenDataBase;
//import TransactionsMaster.DataEntry;

class RowData {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	private String name;
	private String aliasName;
	private double totalAmount;
	private String side;
	private double debitAmount;
	private double creditAmount;
	private String master;

	public double getDebitAmount() {
		return this.debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return this.creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getMaster() {

		return this.master;
	}

	public String setMaster(String master) {

		return this.master = master;
	}
}

public class TrialOp {
	private double totalDebitAccount;
	private double totalCreditAccount;
	private double totalCreditSub;
	private double totalDebitSub;
	private double totalDebitGroup;
	private double totalCreditGroup;
	private ArrayList<RowData> ForAccountMaster;
	private ArrayList<RowData> ForSubGroupMaster;
	private ArrayList<RowData> ForGroupMaster;

	public ArrayList<RowData> getForAccountMaster() {
		return ForAccountMaster;
	}

	public void setForAccountMaster(ArrayList<RowData> forAccountMaster) {
		ForAccountMaster = forAccountMaster;
	}

//public AccountTableModel getGroupModel(Date StartDate,Date EndDate)
//{
//	
//}
//public AccountTableModel getSubGroupModel(Date StartDate,Date EndDate)
//{
//	
//}
	private AccountTableModel SubGroupModel;
	private AccountTableModel accountTableModel;
	private AccountTableModel GroupModel;

	public AccountTableModel getGroupModel() {
		return GroupModel;
	}

	public void setGroupModel(AccountTableModel groupModel) {
		GroupModel = groupModel;
	}

	public ArrayList<RowData> getForSubGroupMaster() {
		return ForSubGroupMaster;
	}

	public void setForSubGroupMaster(ArrayList<RowData> forSubGroupMaster) {
		ForSubGroupMaster = forSubGroupMaster;
	}

	public ArrayList<RowData> getForGroupMaster() {
		return ForGroupMaster;
	}

	public void setForGroupMaster(ArrayList<RowData> forGroupMaster) {
		ForGroupMaster = forGroupMaster;
	}

	public AccountTableModel getSubGroupModel() {
		return SubGroupModel;
	}

	public void setSubGroupModel(AccountTableModel subGroupModel) {
		SubGroupModel = subGroupModel;
	}

	public AccountTableModel getAccountTableModel() {
		return accountTableModel;
	}

	public void setAccountTableModel(AccountTableModel accountTableModel) {
		this.accountTableModel = accountTableModel;
	}

	public AccountTableModel getAccountModel(Date StartDate, Date EndDate) {
		ArrayList<TrialOps> AccountMasterList;

		RowData subGroupData;

		ForAccountMaster = new ArrayList<RowData>();
		ForSubGroupMaster = new ArrayList<RowData>();
		ForGroupMaster = new ArrayList<RowData>();
		DataBaseModelForTrial dtm = new DataBaseModelForTrial();
		try {
			dtm.DatabaseQueries(StartDate, EndDate);
			Set<String> keys = dtm.getSubGroupList().keySet();
			keys = dtm.getGroupTable().keySet();
			for (String keyx : keys) {
				TrialOps GroupObject = dtm.getGroupTable().get(keyx);
				RowData data = new RowData();
				data.setName(GroupObject.getName());
				data.setMaster("GROUPMASTER");
				double groupCreditSum = 0;
				double groupDebitSum = 0;
				ForAccountMaster.add(data);
				ForSubGroupMaster.add(data);
				ArrayList<TrialOps> SubGroupList = GroupObject.getInList();
				for (TrialOps SubGroupObject : SubGroupList) {
					subGroupData = new RowData();
					subGroupData.setName(SubGroupObject.getName());
					subGroupData.setMaster("SUBGROUPMASTER");
					ForAccountMaster.add(subGroupData);
					AccountMasterList = SubGroupObject.getInList();
					double subGroupDebitSum = 0;
					double subGroupCreditSum = 0;
					for (TrialOps AccountMasterObject : AccountMasterList) {
						RowData accountData = new RowData();
						accountData.setMaster("ACCOUNTMASTER");
						accountData.setName(AccountMasterObject.getName());
						accountData.setAliasName(AccountMasterObject.getAliasName());
						accountData.setSide(AccountMasterObject.getSide());
//					accountData.setTotalAmount(AccountMasterObject.getTotalAmount());
						if (accountData.getSide().equals("D")) {

							accountData.setDebitAmount(AccountMasterObject.getTotalAmount());
							subGroupDebitSum = subGroupDebitSum + AccountMasterObject.getTotalAmount();
							totalDebitAccount = totalDebitAccount + AccountMasterObject.getTotalAmount();
						} else {
							accountData.setCreditAmount(AccountMasterObject.getTotalAmount());
							subGroupCreditSum = subGroupCreditSum + AccountMasterObject.getTotalAmount();
							totalCreditAccount = totalCreditAccount + AccountMasterObject.getTotalAmount();
						}
						ForAccountMaster.add(accountData);
					}
					groupDebitSum = groupDebitSum + subGroupDebitSum;
					groupCreditSum = groupCreditSum + subGroupCreditSum;
					if (subGroupDebitSum > subGroupCreditSum) {
						subGroupData.setDebitAmount(subGroupDebitSum - subGroupCreditSum);
						totalDebitSub = totalDebitSub + (subGroupDebitSum - subGroupCreditSum);
					} else {
						subGroupData.setCreditAmount(subGroupCreditSum - subGroupDebitSum);
						totalCreditSub = totalCreditSub + (subGroupCreditSum - subGroupDebitSum);
					}
					ForSubGroupMaster.add(subGroupData);
				}
				if (groupDebitSum > groupCreditSum) {
					data.setDebitAmount(groupDebitSum - groupCreditSum);
					totalDebitGroup = totalDebitGroup + (groupDebitSum - groupCreditSum);
				}

				else {
					data.setCreditAmount(groupCreditSum - groupDebitSum);
					totalCreditGroup = totalCreditGroup + (groupCreditSum - groupDebitSum);
				}
				ForGroupMaster.add(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		GroupModel = new AccountTableModel(ForGroupMaster);
		SubGroupModel = new AccountTableModel(ForSubGroupMaster);
		return new AccountTableModel(ForAccountMaster);
	}

	public double getTotalDebitAccount() {
		return totalDebitAccount;
	}

	public void setTotalDebitAccount(double totalDebitBalance) {
		this.totalDebitAccount = totalDebitBalance;
	}
	public double getTotalCreditAccount() {
		return totalCreditAccount;
	}

	public double getTotalCreditGroup() {
		return totalCreditGroup;
	}
	public double getTotalDebitGroup() {
		return totalDebitGroup;
	}

	public void setTotalCreditGroup(double totalCreditGroup) {
		this.totalCreditGroup = totalCreditGroup;
	}

	public double getTotalDebitSub() {
		return this.totalCreditSub;
	}

	public double getTotalCreditSub() {
		return this.totalCreditSub;
	}
}

class TrialOps {
	private String Name;
	private String AliasName;
	private double TotalAmount;
	private String parentAliasName;
	private String parentName;
	private String side;
	private int priority;
	private ArrayList<TrialOps> list;

	public void setList(ArrayList<TrialOps> list) {
		this.list = list;
	}

	public void insertInList(TrialOps tbl) {
		list.add(tbl);
	}

	public ArrayList<TrialOps> getInList() {
		return list;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAliasName() {
		return AliasName;
	}

	public void setAliasName(String aliasName) {
		AliasName = aliasName;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getParentAliasName() {
		return parentAliasName;
	}

	public void setParentAliasName(String parentAliasName) {
		this.parentAliasName = parentAliasName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

}

class DataBaseModelForTrial {
	private HashMap<String, TrialOps> GroupTable;
	private HashMap<String, TrialOps> SubGroupTable;
	private ArrayList<TrialOps> AccountTable;

	void DatabaseQueries(Date StartDate, Date EndDate) throws SQLException {
		AccountTable = new ArrayList<TrialOps>();
		SubGroupTable = new HashMap<>();
		GroupTable = new HashMap<String, TrialOps>();
		String GroupMasterQuery = "SELECT * FROM GROUPMASTER";
		String SubGroupMasterQuery = "SELECT * FROM SUBGROUPMASTER;";
		String AccountMasterQuery = "SELECT DISTINCT(ALIAS),NAME,DEBIT_TABLE.TOTAL_DEBIT,SUBGROUP,CREDIT_TABLE.TOTAL_CREDIT,ABS(IFNULL(TOTAL_DEBIT,0)-IFNULL(TOTAL_CREDIT,0)) AS TOTAL_AMOUNT,IF(IFNULL(TOTAL_DEBIT,0)>IFNULL(TOTAL_CREDIT,0),'D','C') AS SIDE FROM ACCOUNTMASTER LEFT JOIN (SELECT SUM(TAMT) AS TOTAL_DEBIT, TCODE FROM TRANSACTIONMASTER WHERE TDBCR=\"D\" AND TDATE>=? AND TDATE<=? GROUP BY TCODE)\n"
				+ "AS DEBIT_TABLE ON DEBIT_TABLE.TCODE = ACCOUNTMASTER.ALIAS LEFT JOIN (SELECT SUM(TAMT) AS TOTAL_CREDIT, TCODE FROM TRANSACTIONMASTER WHERE TDBCR=\"C\" AND TDATE>=? AND TDATE<=? GROUP BY TCODE) AS CREDIT_TABLE ON ACCOUNTMASTER.ALIAS=CREDIT_TABLE.TCODE GROUP BY ACCOUNTMASTER.ALIAS;";
		OpenDataBase db = new OpenDataBase();
		Connection con = db.getDataBaseConnection();
		Statement stmt = con.createStatement();
		stmt.execute("SET GLOBAL sql_mode=''");
		PreparedStatement pstmt = con.prepareStatement(GroupMasterQuery);
		ResultSet rs = pstmt.executeQuery();
		TrialOps objectForSubGroup;
		while (rs.next()) {
			objectForSubGroup = new TrialOps();
			objectForSubGroup.setName(rs.getString("NAME"));
			objectForSubGroup.setAliasName(rs.getString("ALIAS"));
			objectForSubGroup.setParentAliasName(rs.getString("HEAD_ALIAS"));
			objectForSubGroup.setPriority(rs.getInt("PRIORITY"));
			objectForSubGroup.setTotalAmount(0.00);
			objectForSubGroup.setSide("D");
			objectForSubGroup.setList(new ArrayList<TrialOps>());
			GroupTable.put(rs.getString("ALIAS"), objectForSubGroup);

		}

		pstmt = con.prepareStatement(SubGroupMasterQuery);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String KeyValue = rs.getString("ALIAS");
			objectForSubGroup = new TrialOps();
			objectForSubGroup.setName(rs.getString("NAME"));
			objectForSubGroup.setAliasName(rs.getString("ALIAS"));
			objectForSubGroup.setParentAliasName(rs.getString("GROUP_ALIAS"));
			objectForSubGroup.setTotalAmount(0.00);
			objectForSubGroup.setSide("D");
			objectForSubGroup.setList(new ArrayList<TrialOps>());
			SubGroupTable.put(KeyValue, objectForSubGroup);
		}

		pstmt = con.prepareStatement(AccountMasterQuery);
		pstmt.setDate(1, new java.sql.Date(StartDate.getTime()));
		pstmt.setDate(2, new java.sql.Date(EndDate.getTime()));
		pstmt.setDate(3, new java.sql.Date(StartDate.getTime()));
		pstmt.setDate(4, new java.sql.Date(EndDate.getTime()));
		rs = pstmt.executeQuery();
		TrialOps objectForAccount;
		while (rs.next()) {
			objectForAccount = new TrialOps();
			objectForAccount.setAliasName(rs.getString("ALIAS"));
			objectForAccount.setName(rs.getString("NAME"));
			objectForAccount.setParentAliasName(rs.getString("SUBGROUP"));
			objectForAccount.setSide(rs.getString("SIDE"));
			objectForAccount.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));
			AccountTable.add(objectForAccount);
		}
		for (TrialOps objects : AccountTable) {
			TrialOps node = SubGroupTable.get(objects.getParentAliasName());
			Object obj[] = computeTotalBalance(node.getTotalAmount(), node.getSide(), objects.getTotalAmount(),
					objects.getSide());
			node.setTotalAmount((Double) obj[0]);
			node.setSide((String) obj[1]);
			node.getInList().add(objects);
		}
		Set<String> keys = SubGroupTable.keySet();
		for (String key : keys) {
			TrialOps object = SubGroupTable.get(key);
			TrialOps parentObject = GroupTable.get(object.getParentAliasName());
			System.out.println(object.getName());
			System.out.println("----" + parentObject.getName());
			Double newBalance = object.getTotalAmount();
			String newSide = object.getSide();
			Double previousBalance = parentObject.getTotalAmount();
			String previousSide = parentObject.getSide();
			Object[] obj = computeTotalBalance(previousBalance, previousSide, newBalance, newSide);
			parentObject.setTotalAmount((Double) obj[0]);
			parentObject.setSide((String) obj[1]);
			parentObject.insertInList(object);
		}
	}

	private Object[] computeTotalBalance(Double previousAmount, String previousSide, Double newAmount, String newSide) {
		double Amount;
		String Side;
		if (previousSide == newSide) {
			Amount = previousAmount + newAmount;
			Side = previousSide;
		} else {
			Amount = Math.abs(previousAmount - newAmount);
			Side = (previousAmount > newAmount) ? previousSide : newSide;
		}
		return new Object[] { Amount, Side };
	}

//	public ArrayList<TrialOps> getAccountList() {
//		return accountList;
//	}
//	public void setAccountList(ArrayList<TrialOps> accountList) {
//		this.accountList = accountList;
//	}
	public HashMap<String, TrialOps> getSubGroupList() {
		return SubGroupTable;
	}
//	public void setSubGroupList(ArrayList<TrialOps> subGroupList) {
//		this.subGroupList = subGroupList;			System.out.println(.getTotalAmount());

//	}
	public HashMap<String, TrialOps> getGroupTable() {
		return GroupTable;
	}
//	public void setGroupList(ArrayList<TrialOps> groupList) {
//		this.groupList = groupList;
//	}
}

class GroupTableModel extends AbstractTableModel {

	@Override
	public int getRowCount() {

		return 0;
	}

	@Override
	public int getColumnCount() {

		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}

class SubGroupTableModel extends AbstractTableModel {

	@Override
	public int getRowCount() {

		return 0;
	}

	@Override
	public int getColumnCount() {

		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}

class AccountTableModel extends AbstractTableModel {

	private ArrayList<RowData> DataEntryList;
	protected Double TempValue;
//	private Object bValue;

	public AccountTableModel(ArrayList<RowData> employeeList) {

		this.DataEntryList = employeeList;
//	    	ArrayList<DataEntry> data = new ArrayList<DataEntry>();
//	      	 data.add(new DataEntry());
//	      	 this.DataEntryList = data;
	}

	public Double getTempValue() {
		return this.TempValue;
	}

	/**
	 * Returns the value of the field called 'dataEntryList'.
	 * 
	 * @return Returns the dataEntryList.
	 */
	public ArrayList<RowData> getDataEntryList() {
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

	private final Class[] columnClass = new Class[] { String.class, String.class, String.class };

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
		RowData row = DataEntryList.get(rowIndex);
		if(row.getMaster().equals("GROUPMASTER")){
		if (0 == columnIndex) {
			return "▶ "+row.getName();
		} else if (1 == columnIndex) {
			return (row.getDebitAmount() == 0 ? "" : row.getDebitAmount());
		} else if (2 == columnIndex) {
			return (row.getCreditAmount() == 0 ? "" : row.getCreditAmount());
		} 		}
		if(row.getMaster().equals("SUBGROUPMASTER"))
		{
			if (0 == columnIndex) {
				return "      ● "+row.getName();
			} else if (1 == columnIndex) {
				return (row.getDebitAmount() == 0 ? "" : row.getDebitAmount());
			} else if (2 == columnIndex) {
				return (row.getCreditAmount() == 0 ? "" : row.getCreditAmount());
			} 	
		}
		if(row.getMaster().equals("ACCOUNTMASTER"))
		{
			if (0 == columnIndex) {
				return "            ▢ "+row.getName();
			} else if (1 == columnIndex) {
				return (row.getDebitAmount() == 0 ? "" : row.getDebitAmount());
			} else if (2 == columnIndex) {
				return (row.getCreditAmount() == 0 ? "" : row.getCreditAmount());
			} 
		}		
		return row;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

//	public void setAliasValue(Object bValue) {
////		this.bValue = bValue;
//	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		TrialOps row = DataEntryList.get(rowIndex);
//
//		if (1 == columnIndex) {
//			row.setDebitValue(Double.parseDouble(aValue.toString()));
//			row.setSide('D');
//			setTotalDebit(getTotalDebit() - TempValue + Double.valueOf(aValue.toString()));
//		}
//		if (2 == columnIndex) {
//			row.setCreditValue(Double.parseDouble(aValue.toString()));
//			row.setSide('C');
//			setTotalCredit(getTotalCredit() - TempValue + Double.valueOf(aValue.toString()));
//		}
		
	        @SuppressWarnings("unchecked")
	        RowData rowVector = DataEntryList.get(rowIndex);
	        rowVector.setDebitAmount(0);
	        rowVector.setCreditAmount(0);
	        fireTableCellUpdated(rowIndex, columnIndex);
	    

		
	}

//	public void nextSetValueAt(Object aValue, int rowIndex, int columnIndex) {
//
////		DataEntry row = DataEntryList.get(rowIndex);
////		if (0 == columnIndex) {
////			Vector<Object> obj = (Vector<Object>) aValue;
////			row.setAccountName(obj.get(1).toString());
////			row.setAliasName(obj.get(0).toString());
////		}
////		fireTableRowsUpdated(rowIndex, columnIndex);
//	}

	public void removeRow(int row) {
//		RowData deleteRow = DataEntryList.get(row);
//		Double debitValue, creditValue;
////		debitValue = Double.valueOf(deleteRow.getDebitValue());
////		creditValue = Double.valueOf(deleteRow.getCreditValue());
//		totalDebit = totalDebit - debitValue;
//		totalCredit = totalCredit - creditValue;
		DataEntryList.remove(row);
		fireTableRowsDeleted(row, row);
	}

	public void addRow(RowData al) {
		DataEntryList.add(al);
//		int i = 0;

//		System.out.println("-->>" + al.getTotalValue());
//		this.totalDebit = this.totalDebit + al.getDebitValue();
//		this.totalCredit = this.totalCredit + al.getCreditValue();
		fireTableDataChanged();
	}

}
