package CheckCodes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MultiKeyCombo {
  public static void main(String args[]) {
    String labels[] = { "DEEPANSHU", "CHOUDHARY", "MANISH", "KAMLESH", "oneself",
        "onlooker", "Onslaught", "Onyx", "onus", "onward" };
    JFrame f = new JFrame("Example JList");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JComboBox jc = new JComboBox(labels);
jc.setKeySelectionManager(new KeySelectionManager() {
	
	@Override
	public int selectionForKey(char aKey, ComboBoxModel aModel) {
		
		return 5;
	}
});
//    MultiKeySelectionManager mk = new MultiKeySelectionManager();
//    jc.setKeySelectionManager(mk);
    //    jc.setKeySelectionManager (new JComboBox.KeySelectionManager() {
    //      public int selectionForKey (char aKey, ComboBoxModel aModel) {
    //        return -1;
    //      }
    //    });
    Container c = f.getContentPane();
    c.add(jc, BorderLayout.NORTH);
    f.setSize(200, 200);
    f.setVisible(true);
  }
}

class MultiKeySelectionManager implements JComboBox.KeySelectionManager {
  private StringBuffer currentSearch = new StringBuffer();

  private Timer resetTimer;

  private final static int RESET_DELAY = 1000;

  public MultiKeySelectionManager() {
    resetTimer = new Timer(RESET_DELAY, new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        currentSearch.setLength(0);
      }
    });
  }

  public int selectionForKey(char aKey, ComboBoxModel aModel) {
    // Reset if invalid character
    if (aKey == KeyEvent.CHAR_UNDEFINED) {
      currentSearch.setLength(0);
      return -1;
    }
    // Since search, don't reset search
    resetTimer.stop();
    // Convert input to uppercase
    char key = Character.toUpperCase(aKey);
    // Build up search string
    currentSearch.append(key);
    // Find selected position within model to starting searching from
    Object selectedElement = aModel.getSelectedItem();
    int selectedIndex = -1;
    if (selectedElement != null) {
      for (int i = 0, n = aModel.getSize(); i < n; i++) {
        if (aModel.getElementAt(i) == selectedElement) {
          selectedIndex = i;
          break;
        }
      }
    }
    boolean found = false;
    String search = currentSearch.toString();
    // Search from selected forward, wrap back to beginning if not found
    for (int i = 0, n = aModel.getSize(); i < n; i++) {
      String element = aModel.getElementAt(selectedIndex).toString()
          .toUpperCase();
      if (element.startsWith(search)) {
        found = true;
        break;
      }
      selectedIndex++;
      if (selectedIndex == n) {
        selectedIndex = 0; // wrap
      }
    }
    // Restart timer
    resetTimer.start();
    return (found ? selectedIndex : -1);
  }
}

     