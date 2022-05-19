package LedgerMaster;

import javax.swing.SwingUtilities;

public class MainClass {
public static void main(String[] args)
{
	
	SwingUtilities.invokeLater(new Runnable() {
		public void run()
		{
			LedgerFrame lf =new LedgerFrame();
			lf.setVisible(true);
		}
	});
}
}
