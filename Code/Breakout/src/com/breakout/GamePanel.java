package com.breakout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyEventDispatcher  {
	
	private static final long serialVersionUID = 1L;
	private TennisBall ball;
	private TennisBat bat;
	private int width = 412, height = 500;
	private int score = 0;
	private Rectangle box;
	private Color color;

	public GamePanel(){
		color = Color.orange;
		this.initialise();
		this.addKeys();	
	}
	
	public void addKeys() {
		// TODO Auto-generated method stub
			
		addKeyListener(new KeyListener() {
				@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
							bat.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				bat.keyPressed(e);
			}
		});
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.paint(g);
		bat.paint(g);
	}
	
	public void move(){
		ball.move();
		this.score += ball.collision(bat);
		bat.move();
	}
	
	public void gameOver() {
		System.out.println("Game over");
	//	JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
	//	System.exit(ABORT);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void initialise() {
		// TODO Auto-generated method stub
		box = new Rectangle(width, height);
		
		ball = new TennisBall(250.0, 10.0, color, 20.0, this);
		bat = new TennisBat(250, 400, color, 80.0, 20.0, this);		
		
		bat.setBoundingBox(box);
		box = new Rectangle(480, height);
		ball.setBoundingBox(box);
		
		ball.setVelocity(1, 1);
		this.setBackground(Color.black);
		
		this.score = 0;
		this.setFocusable(true);
		this.addKeys();
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(this);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		 if (e.getID() == KeyEvent.KEY_PRESSED) {
             System.out.println("key pressed");
             bat.keyPressed(e);
         } else if (e.getID() == KeyEvent.KEY_RELEASED) {
             System.out.println("key released");
             bat.keyReleased(e);
         }
		return false;
	}

}
