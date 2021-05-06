package accountingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends JFrame {
    JDesktopPane desktopPane;
    BasePanels bp;

    MainFrame(String s) {
        JMenu masters, inventory;
        JMenuItem groupMaster, subGroupMaster, accountMaster, divisionMaster, catagoryMaster, unitMaster, itemMaster, gstMaster;
        JMenuBar mb = new JMenuBar();
        mb.add(Box.createRigidArea(new Dimension(10, 50)));
        masters = new JMenu("Masters");
        masters.setSize(10, 50);
        masters.setFont(new Font("Calibri", Font.BOLD, 25));
        inventory = new JMenu("Inventory");
        inventory.setFont(new Font("Calibri", Font.BOLD, 25));
        groupMaster = new JMenuItem("GROUPMASTER");
        groupMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        subGroupMaster = new JMenuItem("SUBGROUPMASTER");
        subGroupMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        accountMaster = new JMenuItem("ACCOUNTMASTER");
        accountMaster.setFont(new Font("Calibri", Font.BOLD, 25));

        divisionMaster = new JMenuItem("DIVISIONMASTER");
        divisionMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        gstMaster = new JMenuItem("GSTMASTER");
        gstMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        catagoryMaster = new JMenuItem("CATAGORYMASTER");
        catagoryMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        unitMaster = new JMenuItem("UNITMASTER");
        unitMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        itemMaster = new JMenuItem("ITEMMASTER");
        itemMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        desktopPane = new JDesktopPane();
        desktopPane.setSize(rootPane.getPreferredSize());
        masters.add(groupMaster);
        masters.add(subGroupMaster);
        masters.add(accountMaster);
        masters.add(gstMaster);
        inventory.add(divisionMaster);
        inventory.add(catagoryMaster);
        inventory.add(unitMaster);
        inventory.add(itemMaster);
        mb.add(masters);
        mb.add(inventory);
        setJMenuBar(mb);
        setTitle(s);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(400, 200, 600, 400);
        add(desktopPane);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        divisionMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("DIVISIONMASTER");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        catagoryMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("CATAGORYMASTER");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        unitMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("UNITMASTER");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        itemMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("ITEMMASTER");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        groupMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("GroupMaster");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        subGroupMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("SubgroupMaster");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        accountMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("AccountMaster");
                bp.setResizable(true);
                desktopPane.add(bp);
            }
        });
        gstMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("GstMaster");
                bp.setResizable(true);
                desktopPane.add(bp);
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//            setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,12));	 never remove this code
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        new mainInintials();
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    MainFrame mf = new MainFrame("ACCOUNTING SOFTWARE");
                }
            });
        } catch (InvocationTargetException exception) {
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }
}
