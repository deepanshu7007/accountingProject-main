package Views;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class DTextField extends JTextField implements KeyListener{
	public DTextField() {
		setFont(new Font("Times New Roman", Font.BOLD, 30));
		addKeyListener(this);
	}
	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
	if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
		JTextField field = (JTextField)e.getSource();
		JFrame frame = (JFrame)field.getRootPane().getParent();
		frame.dispose();
	}	
	if(e.getKeyChar() == KeyEvent.VK_ENTER) {
		JTextField field = (JTextField)e.getSource();
		field.transferFocus();
	}
	}
	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.getContentPane().add(new DTextField());
		frame.setVisible(true);
	}
}
