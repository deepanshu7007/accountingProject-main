package CheckCodes;

import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

public class MainInintials {
	private Map<String,Object> DataValues; 
	private static Map<Object, Object> NameAlias;
	 private Vector<String> ColumnNames;
	 private Vector<Vector<Object>> data;
	 private DefaultTableModel dm;
	 private int RowCount;
	 public MainInintials(ResultSet rs) throws SQLException {
		 NameAlias = new HashMap<Object, Object>();
		 ResultSetMetaData metaData = rs.getMetaData();
		 ColumnNames = new Vector<String>();
		 int columnCount = metaData.getColumnCount();
		 for (int column = 1; column <= columnCount; column++) {
			 ColumnNames.add(metaData.getColumnName(column));
		 }
		 this.RowCount = 1;
		 data = new Vector<Vector<Object>>();
		 while (rs.next()) {
			 Vector<Object> vector = new Vector<Object>();
			 for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				 vector.add(rs.getObject(columnIndex));
				 NameAlias.put(rs.getObject(2), rs.getObject(1));
			 }
			 data.add(vector);
			 RowCount++;
		 }
		 dm = new DefaultTableModel(data, ColumnNames);
	 }
	 
	 
	 
	 public DefaultTableModel getDataModel()
	 {
		 return dm;
	 }
	 
	 //declare here get data model
	public static void main(String[] args) {
//

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root",
					"Anshu12345$");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTMASTER");
			MainInintials mn = new MainInintials(rs);
			mn.getValuesByAlias("RK");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	public static Object getNameByAlias(String AliasName) //we need to set the assessed name from alias in the textfild which is going to be the one of the argument of this method
	{
		return NameAlias.get(AliasName);
	}
	public static boolean checkAlias(String AliasName) {
		Set s=NameAlias.keySet();
		return s.contains(AliasName);
	}

	
	
	
	
	public Map<String,Object> getValuesByAlias(String alias)
	{
		DataValues = new HashMap<String,Object>();
		ArrayList<String>listOfAlias=new ArrayList<String>();
		Set<Object> s = NameAlias.keySet();
		for(Object str:s)
		{
			listOfAlias.add(str.toString());
		}
		Collections.sort(listOfAlias);
		int pos = Collections.binarySearch(listOfAlias,alias);
		int i=0;	
		for(String str:ColumnNames)
		{
			DataValues.put(str, dm.getValueAt(pos, i));
			i++;
		}
		System.out.println(DataValues);
		return DataValues;
	}

	
	
	
	
	
	
	public DefaultTableModel tableModelByColumns(String... ColumnNames)
	{
		this.data = new Vector<Vector<Object>>();
		int size = ColumnNames.length;
		for (int i = 0; i < this.RowCount - 1; i++) {
			Vector<Object> vector = new Vector<Object>();
			for (int j = 0; j < size; j++) {
				vector.add(dm.getValueAt(i, this.ColumnNames.indexOf(ColumnNames[j])));
			}
			this.data.add(vector);
		}
		List l = Arrays.asList(ColumnNames);
		return new DefaultTableModel(this.data, new Vector(l));
	}
	
	
	
	
	
public DefaultTableModel BuiltTableModel(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		ColumnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			ColumnNames.add(metaData.getColumnName(column));
		}
		this.RowCount = 1;
		data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
			RowCount++;
		}
		return new DefaultTableModel(data, ColumnNames);
	}





public Object get(String KeyName)
{
	return DataValues.get(KeyName);
}





	/*
	 * In This we first took the field and store it in aliasText(LocalVarriable) Now
	 * we assess the list of alias in the listOfAlias Varriable In the do while loop
	 * we are : 1>Assessing the alias name 
	 * 2>And also checking that whether that
	 * alias exists in the AliasList or not
	 * At the end we are returning the nameTemp varriable which is basically storing the (ASSESSED) aliasName
	 */







	public static String getAliasByName(String Name) // In this field you we get the Alias by entering the name into it
	{
		int i = 0;
		String aliasText = Name;
		Set listOfAlias = NameAlias.keySet();
		String nameTemp = "";
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
	
	
	
	
}
