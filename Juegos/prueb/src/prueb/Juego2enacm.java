package prueb;
import acm.program.*;
import acm.graphics.*;
public class Juego2enacm extends GraphicsProgram{
	private static final long serialVersionUID = 1L;
	Serpiente jugador= new Serpiente();
	GRect serp=new GRect(jugador.getX(),jugador.getY(),jugador.snakesize(),jugador.snakesize());
	public void init() {
		addKeyListeners(jugador);
		add(serp);
	}
	public void run(){
		while(jugador.perder()) {
			if(jugador.getcrecer()) {
			for(int x=1;x<=1;x++) {
			add(new GRect(jugador.getX()*2,jugador.getY(),jugador.snakesize(),jugador.snakesize()));}
			jugador.setcrecer(false);
			}
			serp.setLocation(jugador.getX(),jugador.getY());
			jugador.mover();
				pause(15);
		}
	}
}
