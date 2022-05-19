package LedgerMaster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import SearchModule.SearchTableModel;
import TransactionsMaster.DataBaseModel;
import TransactionsMaster.DataEntry;
import TransactionsMaster.VoucherController;

public class LedgerModel {
	private Statement stmt;
	private SearchTableModel stm;
	private Connection con;

	public LedgerModel() throws SQLException {
		OpenDataBase db = new OpenDataBase();
		con = db.getDataBaseConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ALIAS,NAME FROM ACCOUNTMASTER");
		stm = new SearchTableModel(rs);
		con.close();
	}

	public SearchTableModel getSearchTableModel() {
		return stm;
	}

	public LedgerTableModel getLedgerTableModel(String AliasName, Date StartDate, Date EndDate) throws SQLException {
		OpenDataBase db = new OpenDataBase();
		con = db.getDataBaseConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"SELECT TDATE,TDOC,TTYPE,TNAR1,TAMT,TDBCR FROM TRANSACTIONMASTER WHERE TCODE=? AND TDATE BETWEEN ? AND ? ORDER BY TDATE");
		pstmt.setString(1, AliasName);
		pstmt.setDate(2, StartDate);
		pstmt.setDate(3, EndDate);
		ResultSet rs = pstmt.executeQuery();
		LedgerTableModel ltm = new LedgerTableModel(rs);
		con.close();
		return ltm;
	}

	public void getVoucherDetails(int TransId, String Narration, Date date, String type, double amount) throws SQLException {
		try {
			OpenDataBase db = new OpenDataBase();
			con = db.getDataBaseConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT TCODE,NAME,TDBCR,TAMT from TRANSACTIONMASTER WHERE TDOC=?");
			pstmt.setInt(1, TransId);
			ResultSet rs = pstmt.executeQuery();
			DataBaseModel ctm = new DataBaseModel();
			while (rs.next()) {
				DataEntry de = new DataEntry();
				de.setAccountName(rs.getString("NAME"));
				de.setAliasName(rs.getString("TCODE"));
				de.setTotalValue(rs.getString("TDBCR"), rs.getDouble("TAMT"));
				ctm.addRow(de);
			}
			VoucherController vc = new VoucherController();
			vc.update(ctm, Narration, date, type, amount, TransId);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}finally
		{
			con.close();
		}
	}
}
