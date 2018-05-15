package Ahorcado;
import acm.graphics.*;
import acm.program.*;
public class Juego3 extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
public final double mitad = getHeight()/(double)2;
int contador_lineas=0;
int contador_letras=0;
int contador_errores=0;
	public void muñeco(int partedelmuñeco,int moverx, int movery) {
		switch (partedelmuñeco) {
		case 0:{
		add(new GOval(moverx+mitad,movery+0,50,50));
		break;}
		case 1:{
		add(new GLine(moverx+mitad+25,movery+50,moverx+mitad+25,movery+125));
		break;}
		case 2:{
		add(new GLine(moverx+mitad+25,movery+57,moverx+mitad+10,movery+115));
		break;}
		case 3:{
		add(new GLine(moverx+mitad+25,movery+57,moverx+mitad+35,movery+115));
		break;}
		case 4:{
		add(new GLine(moverx+mitad+25,movery+125,moverx+mitad+10,movery+173));
		break;}
		case 5:{
		add(new GLine(moverx+mitad+25,movery+125,moverx+mitad+35,movery+173));
		break;}
		default:{ 
			add(new GLabel("Game Over",120,150));
			break;}
		}
	}
	public void lineas_de_la_palabra (String palabra,double x,double y) {
		for(int j=0; j< palabra.length();j++) {
			if(palabra.charAt(j)!=' '){add(new GLine(x+4,y,x+10,y));
			contador_lineas++;}x+=10;
		}		
	}
	public void palabra(String palabra,char letra,double x,double y) {
		int tempor = palabra.length();
		for(int j=0; j< palabra.length();j++) {
		GLabel k=new GLabel(Character.toString(palabra.charAt(j)),x+4,y-4);
			x+=10;
			if(letra == palabra.charAt(j)) {
				add(k);
				contador_letras++;tempor--;}
					}
		if(tempor == palabra.length()) {
			muñeco(contador_errores,20,50);contador_errores++;
		}
			}
	public void run() {
		String h= readLine("diga su palabra");		
		lineas_de_la_palabra(h,10,25);		
		while (contador_lineas != contador_letras && contador_errores <= 6) {
			char y=(readLine("diga su letra").charAt(0));
			palabra(h,y,10,25);}
		if(contador_errores < 6)
		add(new GLabel("You Have Won!",120,150));
	}
	
	}