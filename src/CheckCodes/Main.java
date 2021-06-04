package CheckCodes;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class Main {
  public static void main(String[] argv) throws Exception {
    JTable table = new JTable(new DefaultTableModel(3,3));
    table.setRowHeight(25);
    table.setSurrendersFocusOnKeystroke(true);
    TableColumn col = table.getColumnModel().getColumn(0);
    col.setCellEditor(new MyTableCellEditor());
    JFrame frame = new JFrame();
    frame.add(table);
    frame.setVisible(true);
  }
}

class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {

  JComponent component = new JTextField();

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
      int rowIndex, int vColIndex) {

    ((JTextField) component).setText((String) value);
    return component;
  }

  public Object getCellEditorValue() {
    return ((JTextField) component).getText();
  }
}
