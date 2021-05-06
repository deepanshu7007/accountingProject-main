package CheckCodes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class FocusKeyEvents
{
    static JTextField[] fields;
  
    public static void main(String[] args)
    {
        fields = new JTextField[5];
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1.0;
        gbc.gridwidth = gbc.REMAINDER;
        for(int i = 0; i < fields.length; i++)
        {
            fields[i] = new JTextField(8);
            fields[i].getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "ENTER");
            fields[i].getActionMap().put("ENTER", enter);
            panel.add(fields[i], gbc);
        };
        panel.add(new JButton("Button"), gbc);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(panel);
        f.setSize(300,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
  
    private static Action enter = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            JTextField field = (JTextField)e.getSource();
            int index = 0;
            for(int i = 0; i < fields.length; i++)
                if(field == fields[i])
                {
                    index = i;
                    break;
                }
            fields[++index % fields.length].requestFocusInWindow();
        }
    };
}