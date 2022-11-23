package accountingproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import LedgerMaster.OpenDataBase;
import TransactionsMaster.DataBaseModel;
import Views.SearchFrame;

public class DeleteFrame {
	public DeleteFrame(String NAME_OF_TABLE,DefaultTableModel model) {
		
		SearchFrame sp;
		OpenDataBase db = new OpenDataBase();
		sp = new SearchFrame("ALIAS,NAME",NAME_OF_TABLE);
		sp.setVisible(true);
		sp.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				model.removeRow(sp.getSelectedRow());
				String str = "DELETE FROM " + NAME_OF_TABLE + " WHERE ALIAS='" + sp.get("ALIAS") + "'";
				if ((JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THIS RECORD") == 0)) {
					try {
						Statement stmt = db.getDataBaseConnection().createStatement();
						stmt.executeUpdate(str);
						JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					} catch (SQLException exception) {
						// TODO Auto-generated catch-block stub.
						exception.printStackTrace();
					}
					finally {
						db.ConClosed();
						System.out.println("DATABASE CONNECTION CLOSED FOR DELETE FRAME");
					}
				}
			}
		});

	}
}
