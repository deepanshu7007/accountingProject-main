package TransactionsMaster;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXSearchPanel;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.JXTitledSeparator;
import org.jdesktop.swingx.JXBusyLabel;
import org.jdesktop.swingx.JXHyperlink;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXStatusBar;
import org.jdesktop.swingx.JXGraph;
import org.jdesktop.swingx.painter.ImagePainter;
import org.jdesktop.swingx.JXEditorPane;
import org.jdesktop.swingx.JXRadioGroup;
import org.jdesktop.swingx.JXTaskPane;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created Jun 11, 2021.
 */
public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					JXTable table = new JXTable();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JXTitledSeparator titledSeparator = new JXTitledSeparator();
		contentPane.add(titledSeparator, BorderLayout.NORTH);
		
		JXTaskPane taskPane = new JXTaskPane();
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.add(new JXLabel("Hello"));
		taskPane.setAnimated(true);
		taskPane.setAutoscrolls(true);
		taskPane.setCollapsed(true);
		contentPane.add(taskPane, BorderLayout.CENTER);
		
		JXTable table = new JXTable();
		table.setModel(new DefaultTableModel(3,3));
	}

}
