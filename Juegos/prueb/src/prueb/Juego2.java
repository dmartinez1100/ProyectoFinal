package prueb;

import java.applet.Applet;
import acm.util.RandomGenerator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Juego2 extends Applet implements Runnable{	
	private static final long serialVersionUID = 1L;
	RandomGenerator rdm= new RandomGenerator();
	Thread animacion,updt,moverserpiente;
	Graphics parpadeo;Image fondo;
	Serpiente jugador= new Serpiente();
	private	int dx=rdm.nextBoolean()?-5:5,dy=4,y=rdm.nextInt(15,width-tamano-25),x=height/2;
	public static int height=300,width=800,mitadx=width/2,mitady=height/2,tamano=25,winpoints=5;
	public int marcadorj1=0,marcadorj2=0;
	public static Color COLORJUG = Color.RED;
	public String Game="",mj1=""+marcadorj1,mj2=""+marcadorj2,marc1="",marc2="";
	
	public void update(Graphics y) {
		fondo=createImage(width,height);
		parpadeo=fondo.getGraphics();
		parpadeo.setColor(Color.WHITE);
		parpadeo.fillRect(0, 0, width,height);
		parpadeo.setColor(Color.BLACK);
		parpadeo.fillRect(jugador.getX() ,jugador.getY(),jugador.snakesize(),jugador.snakesize());
		y.drawImage(fondo,0,0,null);
		
	}
	public void perder(){
		try {
			if (x<0) marc2="BIEN J2"; else marc1="BIEN J1";
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mj1=""+marcadorj1;mj2=""+marcadorj2;
	}
	public void start() {
		Recargador j= new Recargador();
		movimientonaranja y= new movimientonaranja();
		animacion=new Thread(this);
		updt=new Thread(j);
		moverserpiente= new Thread(y);
		animacion.start();
		updt.start();
		moverserpiente.start(); 
	}
	
	public void init() { 
		setFont(new Font("BOLD",2,40));
		resize(width,height);
		addKeyListener(jugador);
	}
	public void juego() {
//		try {
//			while(marc1 =="" && marc2=="") {
//				moverpelota();
//			Thread.sleep(20);}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void run() { 
		try {
			Thread.sleep(3000);
			while(marcadorj1 != winpoints && marcadorj2!=winpoints) {
				dx=rdm.nextBoolean()?-5:5;
				y=rdm.nextInt(15,width-tamano-25);x=height/2;
			for (int x=3;x>=0;x--) {
				Game=""+x;
				Thread.sleep(1000);}
			marc1="";marc2="";
			juego();
			}
			marc1="";marc2="";
			if (marcadorj1==winpoints)Game="GANASTE J1!"; else Game="GANASTE J2";
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public class Recargador implements Runnable{
		public void run() {
			while(true)repaint();
		}
	}
	public class movimientonaranja implements Runnable{
		public void run() {
			while(jugador.perder()) {
				jugador.mover();
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
