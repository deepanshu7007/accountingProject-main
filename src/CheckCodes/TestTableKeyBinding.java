package CheckCodes;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;

public class TestTableKeyBinding {

    private final String name = "selectNextColumnCell";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new TestTableKeyBinding();
        });
    }

    TestTableKeyBinding() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] headers = new String[]{"apples", "bananas","Kela"};
        String[][] data = new String[][]{{"1", "2","6"}, {"3", "4","7"}, {"5", "6","5"}}; 
        JTable table = new JTable(data, headers) {
            @Override
            public void editingStopped(ChangeEvent e) {
                super.editingStopped(e);
                

            }
        };
//        table.edit
        table.getInputMap(JTable.WHEN_FOCUSED)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), name);
        table.setCellSelectionEnabled(true);
        table.setRowHeight(25);
       
        f.add(new JScrollPane(table));
        f.pack();
        f.setSize(new Dimension(320, 240));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}