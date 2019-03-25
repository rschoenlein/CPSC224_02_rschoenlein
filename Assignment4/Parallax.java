/*
Homework 4
Due Date: 3/25/2019
Names: Ryan Schoenlein, Ben McDonald
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.math.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Parallax extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double oldX;
	private double oldY;
	private JPanel panel;
        private double offsetX = -100;
        private double offsetY = -100;
        private String imageName;

	public Parallax() {
		// set background Color
		setSize(500, 500);
		setBackground(Color.CYAN);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 setResizable(false);
                 
                 imageName = "parallax.png";

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
            Image image = Toolkit.getDefaultToolkit().getImage(imageName);
            g.drawImage(image,(int)offsetX,(int)offsetY,this);
	}


	private class MyMouseListener implements MouseListener, MouseMotionListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(imageName == "parallax.png")
                            imageName = "parallax2.png";
                        else
                            imageName = "parallax.png";
		}

		@Override
		public void mousePressed(MouseEvent e) {
                    oldX = offsetX;
                    oldY = offsetY;
                        offsetX = e.getX();
                        offsetY = e.getY();
                        repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
                        offsetX = oldX;
                        offsetY = oldY;
                        repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
                        if(imageName == "parallax.png")
                            imageName = "parallax2.png";
                        else
                            imageName = "parallax.png";
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
                        if(imageName == "parallax.png")
                            imageName = "parallax2.png";
                        else
                            imageName = "parallax.png";
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
                    double numX = e.getX();
                    numX *= .5;
                    if(e.getX() < 250)
                    {
                        offsetX = numX - 150;
                        repaint();
                    }

                    if(e.getX() > 250)
                    {
                        offsetX = -numX + 100;
                        repaint();
                    }


                    if(e.getY() > 425)
                    {
                        offsetY = -e.getY() + 350;
                        repaint();
                    }

                    if(e.getY() < 75)
                    {
                        offsetY = -e.getY();
                        repaint();
                    }
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
