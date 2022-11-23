package Views;

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
    JTable table = new JTable();
    table.setModel(new DefaultTableModel(2, 3));
    TableColumn col = table.getColumnModel().getColumn(0);
    col.setCellEditor(new MyTableCellEditor());
    JFrame frame = new JFrame();
    frame.add(table);
    frame.setVisible(true);
  }
}

class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {

  
}
