
public class JUG{

private static int rectheight=75;
private static int rectwidth=15;
private int x;
private int y=0;
private static int dy=20;

	public JUG(int x)	{
		this.x=x;y=0;
	}
	public void setY(int y) {
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getJwidth() {
		return rectwidth;
	}
	public int getJheight() {
		return rectheight;
	}	
	public void moverdown() {
		if(y+rectheight<Hilo1.width)y+=dy;
	}
	public void moverup() {
		if(y>0)y-=dy;
	}	
	
	/**public void keyPressed(KeyEvent e) {
		//int key=e.getKeyCode();		
		//if (key== KeyEvent.VK_DOWN & x>0) moverdown();
		//if (key== KeyEvent.VK_UP & x>0) moverup();
	}
	 public void keyReleased(KeyEvent arg0) {
	 }
	 public void keyTyped(KeyEvent arg0) {
	 }**/
}
