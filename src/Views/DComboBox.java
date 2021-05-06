package Views;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
public class DComboBox extends JComboBox implements KeyListener{
	public DComboBox() {
		addKeyListener(this);
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
			JComboBox<?> box= (JComboBox<?>)e.getSource();
			JFrame frame = (JFrame)box.getRootPane().getParent();
			frame.dispose();
		}
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			JComboBox<?> field = (JComboBox<?>)e.getSource();
			field.transferFocus();
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
