package TransactionsMaster;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Date;

public class DataBaseModel {
	
	Connection con;
	Integer totalTransactions = new Integer(0);
	public DataBaseModel(Connection con, ArrayList<DataEntry> arr,java.util.Date transactionDate, String narration, String type) {
		try {
//			
			this.con = con;
			System.out.println(con.isClosed());
			totalTransactions = getTotalTransactions(con);
			System.out.println("TOtalTransactions"+totalTransactions);
			long millis=System.currentTimeMillis();
			Date transDate = new Date(transactionDate.getTime());
			Date currentDate=new Date(millis);
			PreparedStatement stmt = con.prepareStatement("INSERT INTO TRANSACTIONMASTER (TTYPE,TDOC,TDATE,TCODE,NAME,TDBCR,TNAR1,TAMT,C_DATE) VALUES (?,?,?,?,?,?,?,?,?)");
			con.setAutoCommit(false);
			for (DataEntry de : arr) {
				stmt.setString(5, de.getAccountName());
				stmt.setDate(3, transDate);
				stmt.setString(4, de.getAliasName());
				stmt.setDate(9, currentDate);
				stmt.setInt(2, totalTransactions);
				stmt.setString(1, type);
				stmt.setString(7, narration);
				stmt.setDouble(8, de.getTotalValue());
				stmt.setString(6, String.valueOf(de.getSide()));
				stmt.addBatch();
			}
			stmt.executeBatch();
			con.commit();
			int val = increaseTotalTransactions(con);
			System.out.println("TRANSACTION SUCCESSFULLY ADDED"+val);
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	private int getTotalTransactions(Connection con) throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT TOTALTRANSACTIONS FROM BASICDETAILS");
		
		while(rs.next()) {
			System.out.println(totalTransactions);
			totalTransactions = rs.getInt(1);
		}
			return totalTransactions;
	}
	private int increaseTotalTransactions(Connection con) throws SQLException
	{
		con.setAutoCommit(true);
		PreparedStatement stmt = con.prepareStatement("UPDATE BASICDETAILS SET TOTALTRANSACTIONS=? WHERE ID=1");
		stmt.setInt(1,totalTransactions+1);
		return stmt.executeUpdate();
}
	
}
