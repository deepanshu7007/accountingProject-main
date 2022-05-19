package accountingproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DataModelTools {
	private Connection con;
	private ResultSet rs;
	private HashMap<String,String> aliasNameMap;
	private String CallingName;
private ArrayList<String> listOfAlias = new ArrayList<String>();
	public DataModelTools(Connection con)
	{
		this.con=con;
	}
	public DataModelTools() {
	}
	ArrayList<String> getAliasList() // to get a list of alias
	{
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT ALIAS FROM GROUPMASTER UNION SELECT ALIAS FROM ACCOUNTMASTER UNION SELECT ALIAS FROM SUBGROUPMASTER UNION SELECT ALIAS FROM DIVISIONMASTER UNION SELECT ALIAS FROM ITEMMASTER UNION SELECT ALIAS FROM UNITMASTER UNION SELECT ALIAS FROM CATAGORYMASTER");
			while (rs.next()) {
				listOfAlias.add(rs.getString(1));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return listOfAlias;
	}
	public String getNameByAlias(String AliasName,String NameOfTable)
	{
		CallingName=NameOfTable;
		try {
			Statement stmt = con.createStatement();
                        
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM "+NameOfTable+" WHERE ALIAS='"+AliasName+"'");
			rs.next();
			AliasName=rs.getString("NAME");
		} catch (SQLException exception) {
			System.out.println("NO NAME EXISTS FOR THIS ALIAS NAME");
			AliasName="";
		}
		return AliasName;
	}
	public String getAliasName(String aliasText) // to get an alias name from the entered text from the textfield
	{
		getAliasList();
		int i=0;
		String nameTemp="";
		StringTokenizer st ;
		do
		{
			i++;
			nameTemp="";
			st= new StringTokenizer(aliasText," ");
		while(st.hasMoreElements())
			{
				nameTemp=nameTemp+st.nextToken().substring(0,i);
			}
		}while(listOfAlias.contains(nameTemp));
		return nameTemp;
	}
	public DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {
		Vector<Vector<Object>> data;
		 Vector<String> columnNames;
		
		if(!rs.next())
		{
			String data1[][]={ {},    
                    {},    
                    {}};    
String column[]={"ALIAS","NAME"};     
			return new DefaultTableModel(data1,column);
		}
		else {
	    ResultSetMetaData metaData = rs.getMetaData();
	    columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }
	data = new Vector<Vector<Object>>();
	    do {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }while(rs.next());
	}
		return new DefaultTableModel(data, columnNames);
	}
}
