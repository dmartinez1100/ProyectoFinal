import java.applet.Applet;
import acm.util.RandomGenerator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Hilo1 extends Applet implements Runnable{	
	private static final long serialVersionUID = 1L;
	RandomGenerator rdm= new RandomGenerator();
	Thread animacion;
	Thread updt;
	Graphics parpadeo;Image fondo;
	private	int dx=rdm.nextBoolean()?-5:5,dy=4,y=rdm.nextInt(15,width-20),x=height/2,tamano=25;
	public static int height=800,width=300,mitadx=height/2,mitady=width/2;
	public int marcadorj1=0,marcadorj2=0;
	public J1 j1=new J1(0);
	public J2 j2=new J2(height);
	public static Color COLORJUG = Color.RED;
	public String Game="",mj1=""+marcadorj1,mj2=""+marcadorj2;
	public void moverpelota() {
		x+=dx;y+=dy;
		if(x<0){marcadorj2++;perder();}
		if(x>height-tamano){marcadorj1++;perder();}
		if(x>j2.getX()-j2.getJwidth()-tamano && x<height) {
			if(y>=j2.getY()-tamano && y<=j2.getY()+j2.getJheight())dx*=-1;
		}
		if(x>0 && x<=j1.getX()+j1.getJwidth()) {
			if(y>j1.getY()-tamano && y<=j1.getY()+j1.getJheight())dx*=-1;
		}
		if(y<0 || y>width-tamano)dy*=-1;
		}
	
	public void update(Graphics y) {
		fondo=createImage(height,width);
		parpadeo=fondo.getGraphics();
		parpadeo.setColor(Color.BLACK);
		parpadeo.fillRect(0, 0, height/2, width);
		parpadeo.setColor(Color.GREEN);
		parpadeo.fillOval(x,this.y,tamano, tamano);
		parpadeo.setColor(COLORJUG);
		parpadeo.fillRect(j1.getX(),j1.getY(),j1.getJwidth(),j1.getJheight());
		parpadeo.fillRect(j2.getX()-j2.getJwidth(),j2.getY(),j1.getJwidth(),j1.getJheight());
		parpadeo.setColor(Color.RED);
		parpadeo.drawString(Game,mitadx,mitady);
		parpadeo.setColor(Color.WHITE);
		parpadeo.drawString(mj1,(height/2)/2,40);
		parpadeo.setColor(Color.BLACK);
		parpadeo.drawString(mj2,height/2+(height/2)/2,40);
		y.drawImage(fondo,0,0,null);
	}
	public void perder(){
		
		mj1=""+marcadorj1;mj2=""+marcadorj2;
		Game="Game Over";
	}
	public void start() {
		animacion=new Thread(this);
		Recargador j= new Recargador();
		updt=new Thread(j);
		animacion.start();
		updt.start();
	}
	
	public void init() { 
		resize(height,width);
		addKeyListener(j1);
		addKeyListener(j2);
	}
	public void juego() {
		try {
			while(Game =="") {
				moverpelota();
			Thread.sleep(20);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() { 
		try {
			while(true) {
				y=rdm.nextInt(15,width-20);x=height/2;
			for (int x=3;x>=0;x--) {
				Game=""+x;
				Thread.sleep(1000);}
			Game="";
			juego();
			}
			
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
}
