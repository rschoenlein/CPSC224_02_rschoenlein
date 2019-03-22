package Assignment4;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

public class Parallax extends Applet implements ActionListener, MouseListener {

	public void Parrallax() {
		// set background Color
		setBackground(Color.CYAN);

		// timer which sets interval to update screen
		Timer t = new Timer(25, this);
		t.setInitialDelay(0);
		t.start();
		// make applet listen to mouse and actions
		addMouseListener(this);

	}

	public static void main(String[] args) {
		new Parallax();
	}

	// GRAPHICS
	// graphics methods, double buffers by painting everything onto image then
	// drawing it to screen
	public void paint(Graphics g) {
		g.drawString("Motion Parallax Scene", 500, 500);
		g.setColor(Color.red);  
		g.drawString("Welcome",50, 50);  
		g.drawLine(20,30,20,300);  
		g.drawRect(70,100,30,30);  
		g.fillRect(170,100,30,30);  
		g.drawOval(70,200,30,30);  
		  
		g.setColor(Color.pink);  
		g.fillOval(170,200,30,30);  
		g.drawArc(90,150,30,30,30,270);  
		g.fillArc(270,150,30,30,0,180);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
