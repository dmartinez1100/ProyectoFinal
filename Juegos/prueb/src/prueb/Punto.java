package prueb;

public class Punto {
	private int x,y;
	
	public Punto() {
		x=0;
		y=0;
	}
	public Punto(int j,int k) {
		x=j;
		y=k;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public void sety(int t) {
		y=t;
	}
	public void setx(int t) {
		x=t;
	}
}
