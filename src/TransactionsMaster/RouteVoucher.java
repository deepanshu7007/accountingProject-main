package TransactionsMaster;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import LedgerMaster.OpenDataBase;
public class RouteVoucher {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		VoucherController vc = new VoucherController();
		vc.insert();
	}
}