
/*
Homework 4
Due Date: 3/25/2019
Names: Ryan Schoenlein, Ben McDonald
*/
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
		
		setSize(500, 500);

	}

	public static void main(String[] args) {
		new Parallax();
	}

	// GRAPHICS
	// graphics methods, double buffers by painting everything onto image then
	// drawing it to screen
	public void paint(Graphics g) {
		setSize(500, 500);

		g.drawString("Motion Parallax Scene", 50, 50);
		
		//Grass
		g.setColor(Color.GREEN);  
		g.fillRect(0,250,500,300);
		g.setColor(Color.BLACK);  
		g.drawLine(0, 250, 500, 250);
		
		//tree
		Tree t = new Tree(141, 230, 150, 260, 1);
		g.setColor(t.BROWN);
		g.fillRect(t.trunkX, t.trunkY, 20, 70);
		g.setColor(t.TREE_GREEN);
		g.fillOval(t.leavesX, t.leavesY ,40,40);  
		  
		
		g.setColor(Color.pink);  
		g.fillOval(170,200,30,30);  
		g.drawArc(90,150,30,30,30,270);  
		g.fillArc(270,150,30,30,0,180);  
		
		//As the mouse moves across the scene
		//closer objects move faster, further objects move slower
		//ex:
		//if mouse moves left, objects move left, etc...
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

class Tree {
	int trunkX;
	int trunkY;
	
	int leavesX;
	int leavesY;
	
	int zIndex;
	
	Color BROWN;
	Color TREE_GREEN; 
	
	
	public Tree(int lX, int lY, int tX, int tY, int z) {
		leavesX = lX;
		leavesY = lY;
		trunkX = tX;
		trunkY = tY;
		zIndex = z; 
		TREE_GREEN = new Color(0, 204, 0);
		BROWN = new Color(102,51,0);
	}
}
