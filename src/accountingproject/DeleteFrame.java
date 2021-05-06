package accountingproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import Views.SearchFrame;

public class DeleteFrame {
	public DeleteFrame(String NAME_OF_TABLE) {
		SearchFrame sp;
		try {
			sp = new SearchFrame("ALIAS,NAME",NAME_OF_TABLE);
			sp.setVisible(true);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountingdatabase", "root", "Anshu12345$");
			sp.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {

					String str = "DELETE FROM " + NAME_OF_TABLE + " WHERE ALIAS='" + sp.get("ALIAS") + "'";
					if ((JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THIS RECORD") == 0)) {
						try {
							Statement stmt = con.createStatement();
							stmt.executeUpdate(str);
							JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
							con.close();
							System.out.println("DATABASE CONNECTION CLOSED FOR DELETEFRAME OF:"+NAME_OF_TABLE);
						} catch (SQLException exception) {
							// TODO Auto-generated catch-block stub.
							exception.printStackTrace();
						}
					}
				}
			});
		} catch (SQLException exception1) {
			exception1.printStackTrace();
		}

	}
}
