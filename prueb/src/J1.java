import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class J1 extends JUG implements KeyListener{

	public J1(int x) {
		super(x);
	}
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if (key== KeyEvent.VK_S) moverdown();
		if (key== KeyEvent.VK_W) moverup();
		
	}
	 public void keyReleased(KeyEvent arg0) {
	 }
	 public void keyTyped(KeyEvent arg0) {
	 }
}