package TransactionsMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SearchModule.SearchTableModel;

public class MainClass {
	public static void main(String[] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root",
				"Anshu12345$");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ALIAS,NAME FROM ACCOUNTMASTER");
		SearchTableModel stm = new SearchTableModel();
		VoucherTransaction vt = new VoucherTransaction(con);
		vt.setSearchModel(stm.BuildTableModel(rs));
		vt.setVisible(true);
	}
}

