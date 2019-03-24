
/*
Homework 4

Due Date: 3/25/2019
Names: Ryan Schoenlein, Ben McDonald
*/
package Assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Parallax extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mouseX;
	private int mouseY;
	//to keep track of if mouse is moving up or down, left or right 
	private int oldX = 0;
	private int oldY = 0;
	private JPanel panel;

	public Parallax() {
		// set background Color
		setSize(500, 500);
		setBackground(Color.CYAN);

		panel = new JPanel();
		panel.addMouseListener(new MyMouseListener());
		panel.addMouseMotionListener(new MyMouseListener());

		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Parallax();
	}

	// GRAPHICS
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("Motion Parallax Scene", 50, 50);

		// Grass
		g.setColor(Color.GREEN);
		g.fillRect(0, 250, 500, 300);
		g.setColor(Color.BLACK);
		g.drawLine(0, 250, 500, 250);

		// tree
		Tree t = new Tree(141, 230, 150, 260, 1);
		g.setColor(t.BROWN);
		g.fillRect(t.trunkX, t.trunkY, 20, 70);
		g.setColor(t.TREE_GREEN);
		g.fillOval(t.leavesX, t.leavesY, 40, 40);

		g.setColor(Color.pink);
		g.fillOval(mouseX, mouseY, 30, 30);
		g.drawArc(90, 150, 30, 30, 30, 270);
		g.fillArc(270, 150, 30, 30, 0, 180);

		// As the mouse moves across the scene
		// closer objects move faster, further objects move slower
		// ex:
		// if mouse moves left, objects move left, etc...
	}


	private class MyMouseListener implements MouseListener, MouseMotionListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

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

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			mouseX = e.getX();
			mouseY = e.getY();
			System.out.println(mouseX + " " + mouseY);
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			

	        if(oldX > e.getX())
	        {
	            System.out.println("Mouse moved left");
	        }

	        if(oldX < e.getX())
	        {
	            System.out.println("Mouse moved right");
	        }
	        oldX = e.getX();
	        

	        if(oldY > e.getY())
	        {
	            System.out.println("Mouse moved down");
	        }

	        if(oldY < e.getY())
	        {
	            System.out.println("Mouse moved up");
	        }
	        oldY = e.getY();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
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
		BROWN = new Color(102, 51, 0);
	}
}
