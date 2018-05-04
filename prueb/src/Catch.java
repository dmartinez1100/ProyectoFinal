import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Catch extends JFrame {

public void paint(Graphics g) {
super.paint(g);

g.drawRect(30, 200, 30, 30);

g.drawLine(0,0,50,50);

g.drawOval(20,20,20,20);
g.drawRect(15, 15, 20,20);
}



public static void main(String args[]) {
Catch f = new Catch();
f.setSize(500, 200);
f.setVisible(true);

}
}