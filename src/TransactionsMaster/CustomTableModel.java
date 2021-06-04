package TransactionsMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
 
public class CustomTableModel extends AbstractTableModel
{
    private ArrayList<DataEntry> DataEntryList;
	protected Double TempValue;
	private Object bValue;
	public Double getTempValue() {
		return this.TempValue;
	}

	/**
	 * Returns the value of the field called 'dataEntryList'.
	 * @return Returns the dataEntryList.
	 */
	public ArrayList<DataEntry> getDataEntryList() {
		return this.DataEntryList;
	}

	protected double totalDebit = 0.00, totalCredit = 0.00;

    /**
	 * Returns the value of the field called 'totalDebit'.
	 * @return Returns the totalDebit.
	 */
	public double getTotalDebit() {
		return this.totalDebit;
	}

	/**
	 * Sets the field called 'totalDebit' to the given value.
	 * @param totalDebit The totalDebit to set.
	 */
	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}

	/**
	 * Returns the value of the field called 'totalCredit'.
	 * @return Returns the totalCredit.
	 */
	public double getTotalCredit() {
		return this.totalCredit;
	}

	/**
	 * Sets the field called 'totalCredit' to the given value.
	 * @param totalCredit The totalCredit to set.
	 */
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}

	private final String[] columnNames = new String[] {
            "Account", "Debit", "Credit"
    };
	
    private final Class[] columnClass = new Class[] {
         String.class, Double.class, Double.class
    };
 
    public CustomTableModel(ArrayList<DataEntry> employeeList)
    {
        this.DataEntryList = employeeList;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return DataEntryList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        DataEntry row = DataEntryList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getAccountName();
        }
        else if(1 == columnIndex) {
            return row.getDebitValue();
        }
        else if(2 == columnIndex) {
            return row.getCreditValue();
        }
        return null;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
    	if (columnIndex == 1 || columnIndex == 2) {
			TempValue = Double.valueOf(getValueAt(rowIndex, columnIndex).toString());
		}
        return true;
    }
 
    public void setAliasValue(Object bValue) {
    	this.bValue=bValue;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        DataEntry row = DataEntryList.get(rowIndex);
//        if(0 == columnIndex) {
//        	System.out.println(aValue.getClass()+"-->"+aValue.toString());
//            row.setAccountName(aValue.toString());
//        }
        if(1 == columnIndex) {
            row.setDebitValue((Double) aValue);
            row.setSide('D');
            setTotalDebit(getTotalDebit() - TempValue + Double.valueOf(aValue.toString()));
        }
        if(2 == columnIndex) {
        	row.setCreditValue((Double) aValue);
            row.setSide('C');
            setTotalCredit(getTotalCredit() - TempValue + Double.valueOf(aValue.toString()));
        }
        fireTableRowsUpdated(rowIndex, columnIndex);
    }
    public void nextSetValueAt(Object aValue,int rowIndex,int columnIndex)
    {
    	
           DataEntry row = DataEntryList.get(rowIndex);
           if(0 == columnIndex) {
        	   Vector<Object>obj = (Vector<Object>)aValue;
        	   row.setAccountName(obj.get(1).toString());
        	   row.setAliasName(obj.get(0).toString());
           }
           fireTableRowsUpdated(rowIndex, columnIndex);
    }
    public void removeRow(int row) {
		DataEntry deleteRow = DataEntryList.get(row);
		Double debitValue,creditValue;
		 debitValue = Double.valueOf(deleteRow.getDebitValue());
		creditValue = Double.valueOf(deleteRow.getCreditValue());
		totalDebit = totalDebit - debitValue;
		totalCredit = totalCredit - creditValue;
		DataEntryList.remove(row);
		fireTableRowsDeleted(row, row);
	}

	
	public void addRow(DataEntry al) {
		DataEntryList.add(al);
		fireTableDataChanged();
	}
}