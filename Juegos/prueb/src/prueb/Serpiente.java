package prueb;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Serpiente implements KeyListener{

	private static int snakesize=15;
	private int x;
	private int y;
	private boolean indicadory=false,indicadorx=true,crecer=false;
	private static int dy=1;
	private static int dx=1;
	private ArrayList<Punto> body=new ArrayList <Punto>();		
	
		public Serpiente()	{
			x=0;y=Juego2.height/2;
			body.add(new Punto(x,y));
			System.out.print("serp creada");
		}
		public Punto getPunto() {
			return new Punto(x,y);
		}
		public ArrayList<Punto> getbody(){
			return body;
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
			if(indicadorx) {
			x+=dx;
			serpenteo(body,new Punto(x,y));
			}
			if(indicadory) {
			y+=dy;
			serpenteo(body,new Punto(x,y));
			}			
			body.add(new Punto(x,y));
			body.remove(body.size()-1);
			
		}
		public void moverdown() {
			if(indicadorx){
			indicadorx=false;
			indicadory=true;
				dy*=dy>0?1:-1;
			}
			for(int x=0;x<14;x++)
			body.add(1,new Punto(-15,-15));
			
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
		public ArrayList<Punto> serpenteo(ArrayList <Punto> lista,Punto elemento){
			ArrayList <Punto>cambio=lista;
			for(int w=lista.size()-1;w>0;w--) {
				cambio.set(w,lista.get(w-1));
			}
				cambio.set(0, elemento);
				return cambio;
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
