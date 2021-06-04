package CheckCodes;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CheckClass {
  public static void main(String[] argv) {
    DefaultTableModel model = new DefaultTableModel() {
      public Class getColumnClass(int columnIndex) {
        Object o = getValueAt(0, columnIndex);
        if (o == null) {
          return Object.class;
        } else {
          return o.getClass();
        }
      }
    };
    JTable table = new JTable(model);

    model.addColumn("Boolean", new Object[] { Boolean.TRUE });
    model.addColumn("Date", new Object[] { new Date() });
    model.addColumn("Double", new Object[] { new Double(Math.PI) });
    model.addColumn("Float", new Object[] { new Float(1.2) });
    model.addColumn("Icon", new Object[] { new ImageIcon("icon.gif") });
    model.addColumn("Number", new Object[] { new Integer(1) });
    model.addColumn("Object", new Object[] { "object" });
    
    Enumeration e = table.getColumnModel().getColumns();
    TableColumn col = (TableColumn) e.nextElement();

    col.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    col.setCellEditor(table.getDefaultEditor(Boolean.class));
    
    JFrame f = new JFrame();
    f.setSize(300,300);
    f.add(new JScrollPane(table));
    f.setVisible(true);
  }
}