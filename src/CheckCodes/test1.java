package CheckCodes;
import java.awt.Component;

import javax.swing.*;

import Views.ItemMaster;
public class test1 {
    public static void main(String[] args)
{
    ItemMaster ip = new ItemMaster();
    JFrame frame = new JFrame();
    int i=0;
    for(Component c : ip.getComponents())
    {    
        if(c.getClass().equals(javax.swing.JTextField.class) || c.getClass().equals(javax.swing.JComboBox.class))
        {    
        System.out.println(i+1+"=====>"+c.getClass());
            i++;
        }
        }
    frame.getContentPane().add(ip);
    frame.pack();
    frame.setVisible(true);
}
}

