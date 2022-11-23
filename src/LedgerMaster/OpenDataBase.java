package LedgerMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
public class OpenDataBase
{
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
	
	
	public Connection con;
public 	OpenDataBase() {
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "deepanshu",
				"Anshu123$");
	} catch (SQLException exception) {
		// TODO Auto-generated catch-block stub.
		exception.printStackTrace();
	}
}
public void ConClosed()
{
	try {
		con.close();
		System.out.println("Connection closed");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public Connection getDataBaseConnection()
{
	return con;
}
public DefaultTableModel getDataBaseModel(String columnNames[],String tableName) {
	//CREATE QUERY
	DefaultTableModel dtm=new DefaultTableModel();
	try {
		Statement pstmt = con.createStatement();
		ResultSet rs = pstmt.executeQuery("SELECT NAME,ALIAS from "+tableName);
		
		dtm = new DefaultTableModel(columnNames,0);
		while(rs.next())
		{
			String alias = rs.getString("ALIAS");
			String name = rs.getString("Name");
			Vector<String>v=new Vector<String>();
			v.add(alias);
			v.add(name);
			dtm.addRow(v);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//GET RESULT SET
	//CONVERT RESULTSET TO DATABASEMODEL
	//RETURN DATABASE MODEL
	return dtm;
}
}