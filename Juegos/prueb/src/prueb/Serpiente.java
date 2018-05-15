package prueb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
public class Serpiente extends GraphicsProgram implements KeyListener{
	private static int snakesize=15;
	private int x;
	private int y;
	private boolean indicadory=false,indicadorx=true,crecer=false;
	private static int dy=1;
	private static int dx=1;
	GRect serp=new GRect(10,10,50,50);
		
		public Serpiente()	{
			x=0;y=Juego2.height/2;
			System.out.print("serp creada");
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
		public int snakesize() {
			return snakesize;
		}
		public void mover() {
			if(indicadorx)
			x+=dx;
			if(indicadory)
			y+=dy;
		}
		public void moverdown() {
			if(indicadorx){
			indicadorx=false;
			indicadory=true;
				dy*=dy>0?1:-1;
			}
		}
		public void moverup() {
				if(indicadorx) {
				indicadorx=false;
				indicadory=true;
				dy*=dy>0?-1:1;
				}
		}
		public void moverleft() {
			if(indicadory){
			indicadory=false;
			indicadorx=true;
				dx*=dx<0?1:-1;
			}
		
		}
		public void moverright() {
			if(indicadory) {
			indicadory=false;
			indicadorx=true;
				dx*=dx<0?-1:1;
			}
		 
		}
		public boolean perder() {
			if(x>=0 && x<Juego2.width-snakesize && y>0 && y<Juego2.height-snakesize)return true;
			else return false;
		}
		public boolean getcrecer() {
			return crecer;
		}
		public void setcrecer(boolean nota) {
			crecer=nota;
		}
		public void keyPressed(KeyEvent e) {
			int key=e.getKeyCode();		
			if (key== KeyEvent.VK_DOWN) moverdown();
			if (key== KeyEvent.VK_UP) moverup();
			if (key== KeyEvent.VK_LEFT) moverleft();
			if (key== KeyEvent.VK_RIGHT) moverright();
			if (key== KeyEvent.VK_SPACE) crecer=true;
		}
		 public void keyReleased(KeyEvent arg0) {
		 }
		 public void keyTyped(KeyEvent arg0) {
		 }
	}
