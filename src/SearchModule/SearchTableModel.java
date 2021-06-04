package SearchModule;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class SearchTableModel extends AbstractTableModel {
	
	private Map<Object, Object> AliasNameMap;
	private Vector<Vector<Object>> DataList;
	private Vector<String> columnNames;

	public Vector<Object> getRow(int pos) {
		return DataList.elementAt(pos);
	}
	public SearchTableModel()
	{
		
	}
	public SearchTableModel BuildTableModel(ResultSet rs) throws SQLException
	{
		ResultSetMetaData metaData = rs.getMetaData();
		Vector<String> ColumnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			ColumnNames.add(metaData.getColumnName(column));
		}
		DataList = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			DataList.add(vector);
		}
		return new SearchTableModel(ColumnNames, DataList);
	}
	public SearchTableModel(Vector<String> v, Vector<Vector<Object>> DataList) {
		AliasNameMap = new HashMap<Object, Object>();
		columnNames = v;
		this.DataList = DataList;
		setAliasNameMap(DataList);
	}

	private void setAliasNameMap(Vector<Vector<Object>> DataList) {
		for (Vector<Object> RowData : DataList)
			AliasNameMap.put(RowData.elementAt(0), RowData.elementAt(1));
	}

	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return DataList.size();
	}

	public String getNameByAlias(String AliasName) {
		return AliasNameMap.get(AliasName).toString();
	}

	public String getAliasName(String Name) {
		int i = 0;
		String aliasText = Name;
		Set<Object> listOfAlias = AliasNameMap.keySet();
		System.out.println(listOfAlias);
		String nameTemp = "";
		System.out.println(Name);
		StringTokenizer st;
		do {
			i++;
			nameTemp = "";
			st = new StringTokenizer(aliasText, " ");
			while (st.hasMoreElements()) {
				nameTemp = nameTemp + st.nextToken().substring(0, i);
			}
			
		} while (listOfAlias.contains(nameTemp));
		return nameTemp;
	}

	public boolean checkAlias(String Alias) {
		System.out.println(AliasNameMap.keySet());
		return AliasNameMap.keySet().contains(Alias);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vector<Object> DataVector = DataList.elementAt(rowIndex);
		int i = 0;
		while (i < getColumnCount()) {
			if (columnIndex == i) {
				return DataVector.elementAt(columnIndex);
			}
			i++;
		}
		return null;
	}
}
