package CheckCodes;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 * TODO Put here a description of what this class does.
 *
 * @author deepa.
 *         Created May 20, 2021.
 */
public class LockingKey {
public static void main(String[] args)
{
Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);	
}
}
