package TransactionsMaster;

import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created Jun 2, 2021.
 */
class NumberRenderer extends DefaultTableCellRenderer.UIResource {
	public NumberRenderer() {
		super();
		setHorizontalAlignment(JLabel.RIGHT);
	}
}

public class DoubleRenderer extends NumberRenderer {
	DecimalFormat formatter = new DecimalFormat("");

	public DoubleRenderer() {
		super();
	}

	public void setValue(Object value) {
		if (formatter == null) {
			formatter = new DecimalFormat("");
		}
		setText((value == null || value.equals(0)) ? "" : formatter.format(value));
	}
}