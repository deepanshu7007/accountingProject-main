package CheckCodes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TrackArrows
{
    protected static InputMap inputMap;

    public static void main(String[] arg){
        JPanel panel = new JPanel();

        inputMap = panel.getInputMap();

        panel.getActionMap().put("keys", new AbstractAction() {
            public void actionPerformed(ActionEvent e){
                if(inputMap.get(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), true)){//My problem lies here
                    System.out.println("Key pressed up");
                }
                if(inputMap.get(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), true)){//And here
                    System.out.println("Key pressed down");
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "keys");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "keys");

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(20,20);
        frame.setVisible(true);
    }
}
