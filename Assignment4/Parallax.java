
/*
Homework 4

Due Date: 3/25/2019
Names: Ryan Schoenlein, Ben McDonald
*/
	
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

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
	
	//objects in the scene
	Tree t;
	Grass grass;
	Moon moon;
	Bird bird;
	Timer timer;
	
	
	private JPanel panel;

	public Parallax() {
		setSize(500, 500);

		//create panel and add listeners
		panel = new JPanel();
		panel.addMouseListener(new MyMouseListener());
		panel.addMouseMotionListener(new MyMouseListener());

		//create objects for scene
		t = new Tree(141, 230, 150, 260, 3);
		grass = new Grass(250, 3);
		moon = new Moon(50, 50, 1);
		bird = new Bird(100,100);

        timer = new Timer(10,this);
        timer.start();

		
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Parallax();
	}

	// GRAPHICS
	public void paint(Graphics g) {
		super.paint(g);
		
		//sky
		Color c = new Color(0, 0, 150);
		g.setColor(c);
		g.fillRect(0, 0, 500, 300);

		
		// Grass
		g.setColor(Color.GREEN);
		g.fillRect(0, grass.y, 500, 300);
		g.setColor(Color.BLACK);
		g.drawLine(0, grass.y, 500, grass.y);

		// tree
		g.setColor(t.BROWN);
		g.fillRect(t.trunkX, t.trunkY, 20, 70);
		g.setColor(t.TREE_GREEN);
		g.fillOval(t.leavesX, t.leavesY, 40, 40);

		
		//Moon	
		g.setColor(Color.YELLOW);
		g.fillArc(moon.x, moon.y, 30, 30, 30, 230);
		
		 //bird
        g.setColor(Color.BLACK);
        g.fillArc(bird.birdX,bird.birdY,50,50,0,180);
        g.fillArc(bird.birdX + 45,bird.birdY,50,50,0,180);
        g.setColor(c);
        g.fillArc(bird.birdX + 5,bird.birdY + 5,40,40,0,180);
        g.fillArc(bird.birdX + 50,bird.birdY + 5,40,40,0,180);
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
			//get mouse position
			mouseX = e.getX();
			mouseY = e.getY();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
			//determine which way the mouse is moving and apply parallax to objects
	        if(oldX > e.getX())
	        {	          
	    		//if mouse moving, update coordinates of objects in scene 
	            //at speed and limit of movement according to zIndex
	            if(t.trunkX > t.originalX - (t.zIndex * 10)) {
	            	t.trunkX -= 3;
	    			t.leavesX -= 3;
	            } 
	            
	            if( moon.x > moon.originalX - (moon.zIndex * 10)) {
	            	moon.x -= 2;
	            } 
	    		repaint();
	        }
	     

	        if(oldX < e.getX())
	        {
	    		//if mouse moving, update coordinates of objects in scene 
	            //at speed and limit of movement according to zIndex
	            if(t.trunkX < t.originalX + (t.zIndex * 10)) {
	            	t.trunkX += 3;
	    			t.leavesX += 3;
	            }
	            
	            if(moon.x < moon.originalX + (moon.zIndex * 10)) {
	            	moon.x += 2;
	            }
	            	
	    		repaint();
	        } 
	  
	        oldX = e.getX();
	        

	        if(oldY > e.getY())
	        {
	            System.out.println("Mouse moved down");
	            
	    		//if mouse moving, update coordinates of objects in scene 
	            //at speed and limit of movement according to zIndex
	            if(t.trunkY > t.originalY - (t.zIndex * 10)) {
	            	t.trunkY -= 3;
	            	t.leavesY -= 3;
	            }
	            
	            if(grass.y > grass.originalY - (grass.zIndex * 10)) {
	            	grass.y -= 3;
	            }
	            
	            if(moon.y > moon.originalY + (moon.zIndex * 10)) {
	            	moon.y -= 2;
	            }
	            	
	    		repaint();
	        }
	 

	        if(oldY < e.getY())
	        {
	            
	    		//if mouse moving, update coordinates of objects in scene 
	            //at speed and limit of movement according to zIndex
	            if(t.trunkY < t.originalY + (t.zIndex * 10)) {
	            	t.trunkY += 3;
	    			t.leavesY += 3;
	            }
	            
	            if(grass.y < grass.originalY + (grass.zIndex * 10)) {
	            	grass.y += 3;
	            }
	            
	            if(moon.y < moon.originalY + (moon.zIndex * 10)) {
	            	moon.y += 2;
	            }
	            	
	    		repaint();
	        }
	       
	        oldY = e.getY();
		}
	}

	@Override
	//update bird x and y on every timer interval
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        bird.birdX = (bird.birdX + 1)%500;	
		repaint();
	}

}

//Objecs in scene class definitions
class Tree {
	int trunkX;
	int trunkY;

	int leavesX;
	int leavesY;
	
	int originalX;
	int originalY;
	
	int zIndex;

	Color BROWN;
	Color TREE_GREEN;

	
	public Tree(int lX, int lY, int tX, int tY, int z) {
		this.leavesX = lX;
		this.leavesY = lY;
		this.trunkX = tX;
		this.trunkY = tY;
		this.zIndex = z;
		this.originalX = this.trunkX;
		this.originalY = this.trunkY;
		this.TREE_GREEN = new Color(0, 204, 0);
		this.BROWN = new Color(102, 51, 0);
	}
}

class Moon {
	int x;
	int y;
	
	int originalX;
	int originalY;

	int zIndex;
	
	public Moon(int x, int y,int z) {
		this.x = x;
		this.y = y;
		
		this.originalX = this.x;
		this.originalY = this.y;
		
		this.zIndex = z;
	}
}

class Grass {
	int y;

	int zIndex;
	int originalY;
	
	public Grass(int y,int z) {
		this.y = y;
		this.zIndex = z;
		this.originalY = this.y;

	}
}


class Bird {
	int birdX;
        int birdY;

	int originalX;
	int originalY;
	
	public Bird(int x,int y) {
            this.originalX = birdX;
            this.originalY = birdY;
            this.birdX = x;
            this.birdY = y;

	}
}
