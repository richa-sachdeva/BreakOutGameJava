package com.breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class TennisBat extends FillableShape implements KeyListener {
	
	private double length;
	private double breadth;
	private GamePanel gameP;
	
	public TennisBat(double x, double y, Color color, double length, double breadth, GamePanel game){
		super(x, y, color);
		this.length = length;
		this.breadth = breadth;
		this.gameP = game;
		
	}
	
	public double getLength(){
		return this.length;
	}
 
	public void paint(Graphics g){		
		g.setColor(Color.orange);
		g.fillRect((int)getX(), (int)getY(), (int)length, (int)breadth);
	}

	public double getBreadth() {
		// TODO Auto-generated method stub
		return this.breadth;
	}
	
	public void keyReleased(KeyEvent e) {
		this.setVelocity(0, 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if(this.getDX() != -1)
				this.setVelocity(-1, 0);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(this.getDX() != 1)
				this.setVelocity(1, 0);
	//		System.out.println("x : "+ this.getX());
		//	if(this.getX() == 400)
		//		this.setVelocity(-1, 0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
