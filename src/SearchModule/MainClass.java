package SearchModule;

import java.sql.*;
import java.util.Vector;

public class MainClass {
	public static void main(String[] args) {
		MainClass cm = new MainClass();
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "deepanshu", "Anshu123$");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ALIAS,NAME FROM ACCOUNTMASTER");
			SearchTableModel ctm = new SearchTableModel(rs);
			SearchFrameTest sft = new SearchFrameTest(ctm);
			sft.setVisible(true);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	Vector<String> ColumnNames;
	Vector<Vector<Object>> DataList;
	public SearchTableModel BuildTableModel(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		ColumnNames = new Vector<String>();
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
		return new SearchTableModel(rs);
	}
}
