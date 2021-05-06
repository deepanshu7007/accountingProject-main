package CheckCodes;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class SwingDemo {
   public static void Main(String[] argv) throws Exception {
       JPanel panel = new JPanel();
       panel.setBounds(400, 0, 200, 200);
       panel.setBackground(Color.red);
       Button b = new Button();  
       b.setSize(200,200);
       panel.add(b);
      DefaultTableModel tableModel = new DefaultTableModel();
      JTable table = new JTable(tableModel);
      tableModel.addColumn("Language/ Technology");
      tableModel.addColumn("Text Tutorial");
      tableModel.addColumn("Video Tutorial");
      tableModel.addColumn("Views");
      tableModel.addRow(new Object[] { "NodeJS", "No", "Yes", "2350"});
      tableModel.addRow(new Object[] { "MVC", "Yes", "No", "1500"});
      tableModel.addRow(new Object[] { "ASP.NET", "Yes", "Yes", "3400"});
      tableModel.addRow(new Object[] { "F#", "Yes", "No", "7890"});
      tableModel.addRow(new Object[] { "Blockchain", "Yes", "No", "10600"});
      tableModel.addRow(new Object[] { "SharePoint", "Yes", "Yes", "4900"});
      tableModel.addRow(new Object[] { "AWS", "No", "Yes", "8900"});
      tableModel.addRow(new Object[] { "C#", "Yes", "Yes", "1300"});
      tableModel.addRow(new Object[] { "Java", "Yes", "No", "9686"});
      tableModel.addRow(new Object[] { "jQuery", "Yes", "Yes", "4500"});
      tableModel.addRow(new Object[] { "Python", "Yes", "No", "6789"});
      tableModel.addRow(new Object[] { "Scala", "Yes", "No", "3400"});
      tableModel.addRow(new Object[] { "Swift", "No", "Yes", "9676"});
      table.addRowSelectionInterval(6, 6);
      System.out.println(table.getSelectedRow());
      table.setBackground(Color.white);
      table.setForeground(Color.BLUE);
      Font font = new Font("Verdana", Font.CENTER_BASELINE, 12);
      table.setFont(font);
      table.setEnabled(false);

      JFrame frame = new JFrame();
      frame.setSize(600, 400);
      frame.add(panel);
      frame.add(new JScrollPane(table));
      frame.setVisible(true);
            b.addActionListener((ActionEvent e) -> {
                frame.remove(panel);
                frame.repaint();
                table.setEnabled(true);
       });
   }
   public static void main(String[] args)
   {
       new SwingDemo();
   }
}
