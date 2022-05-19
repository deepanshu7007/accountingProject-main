package accountingproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import java.sql.Statement;
public class mainInintials
{
	public static Connection con;	
	public mainInintials()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "deepanshu", "Anshu123$");
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static class MainTools {
		private ResultSet rs;
	private ArrayList<String> listOfAlias = new ArrayList<String>();
	ArrayList<String> getAliasList() // to get a list of alias
	{
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT ALIAS FROM GROUPMASTER UNION SELECT ALIAS FROM ACCOUNTMASTER UNION SELECT ALIAS FROM SUBGROUPMASTER UNION SELECT ALIAS FROM ITEMMASTER");
			while (rs.next()) {
				listOfAlias.add(rs.getString(1));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return listOfAlias;
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
	public ResultSet selectDataTable(String ColumnNames,String TableName) throws SQLException
	{
		Statement stmt =con.createStatement();
		 rs= stmt.executeQuery("SELECT "+ColumnNames+" FROM "+TableName);
		 return rs;
	}
	public DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {
		Vector<Vector<Object>> data;
		 Vector<String> columnNames;
		if(!rs.next())
		{
			String data1[][]={};    
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
	    rs.first();
	    while(rs.next()){
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    
	}
		System.out.println(data);
		return new DefaultTableModel(data, columnNames);
	}
	}


}
