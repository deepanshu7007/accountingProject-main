package CheckCodes;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import javax.swing.table.DefaultTableModel;


public class SelectionModelTable {
  public static void main(String args[]) {

    final Object rowData[][] = { { "1", "one", "I" }, { "2", "two", "II" }, { "3", "three", "III" } };
    final String columnNames[] = { "#", "English", "Roman" };
    DefaultTableModel dm = new DefaultTableModel(rowData,columnNames);

    JFrame frame = new JFrame("Resizing Table");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 550);
    frame.setVisible(true);

  }
}