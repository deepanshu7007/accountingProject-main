package accountingproject;
import javax.swing.*;
import LedgerMaster.LedgerFrame;
import TransactionsMaster.VoucherController;
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
    	JMenu masters, inventory,transactions,reports;
        JMenuItem groupMaster, subGroupMaster, accountMaster, divisionMaster, catagoryMaster, unitMaster, itemMaster, gstMaster,voucherMaster,ledgerMaster,cashBook,trialBalance,balanceSheet,profitAndLoss;
        JMenuBar mb = new JMenuBar();
        mb.add(Box.createRigidArea(new Dimension(10, 50)));
        transactions = new JMenu("Transactions");
        transactions.setFont(new Font("Calibri", Font.BOLD, 25));
        reports= new JMenu("Reports");
        reports.setFont(new Font("Calibri", Font.BOLD, 25));
        cashBook= new JMenuItem("CASHBOOK");
        cashBook.setFont(new Font("Calibri", Font.BOLD, 25));
        profitAndLoss= new JMenuItem("PROFITANDLOSS");
        profitAndLoss.setFont(new Font("Calibri", Font.BOLD, 25));
        balanceSheet = new JMenuItem("BALANCESHEET");
        balanceSheet.setFont(new Font("Calibri", Font.BOLD, 25));
        trialBalance= new JMenuItem("TRIALBALANCE");
        trialBalance.setFont(new Font("Calibri", Font.BOLD, 25));
        voucherMaster = new JMenuItem("VOUCHERMASTER");
        voucherMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        ledgerMaster = new JMenuItem("LEDGERMASTER");
        ledgerMaster.setFont(new Font("Calibri", Font.BOLD, 25));
        transactions.add(voucherMaster);
        transactions.add(ledgerMaster);
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
        reports.add(trialBalance);
        reports.add(balanceSheet);
        reports.add(profitAndLoss);
        reports.add(cashBook);
        mb.add(masters);
        mb.add(inventory);
        mb.add(transactions);
        mb.add(reports);
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
                bp = new BasePanels("GROUPMASTER");
	            desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        subGroupMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("SUBGROUPMASTER");
                desktopPane.add(bp);
                bp.setResizable(true);
            }
        });
        accountMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("ACCOUNTMASTER");
                bp.setResizable(true);
                desktopPane.add(bp);
            }
        });
        gstMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bp = new BasePanels("GSTMASTER");
                bp.setResizable(true);
                desktopPane.add(bp);
            }
        });
        voucherMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VoucherController vc = new VoucherController();
                vc.insert();
            }
        });
        ledgerMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               LedgerFrame lf = new LedgerFrame();
               lf.setVisible(true);
               lf.setAlwaysOnTop(true);
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
//        new OpenDataBase();
        
        
           
                    MainFrame mf = new MainFrame("ACCOUNTING SOFTWARE");
        
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
