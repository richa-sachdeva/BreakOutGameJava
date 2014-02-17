package com.breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class TennisBall extends FillableShape {
	
	private double diameter;
	private GamePanel gameP;
	 
	public TennisBall (double x, double y, Color color, double diameter, GamePanel game){
		super(x, y, color);
		this.diameter = diameter;
		this.gameP = game;
	}
 
	public double getDiameter(){
		return diameter;
	}
 
	public void paint(Graphics g){
		g.setColor(Color.orange);
		g.fillOval((int)getX(), (int)getY(), (int)diameter, (int)diameter);
	//	g.setColor(Color.white);
	//	g.drawOval((int)getX(), (int)getY(), (int)diameter, (int)diameter);
	}
	
/*	public void move(TennisBat bat) {
		double x = this.getX();
		double y = this.getY();
		double dx = this.getDX();
		double dy = this.getDY();
		double width = this.getBoundingBox().getWidth();
		double height = this.getBoundingBox().getHeight();
		double diam = this.getDiameter();
		
		if (( x + dx ) < 0)
			this.setVelocity(1, 0);
		if ( (x + dx) > (width - diam))
			this.setVelocity(-1, 0);
		if ((y + dy) < 0)
			this.setVelocity(0, 1);
		if ((y + dy) > (height - diam))
			gameP.gameOver();
		if (collision(bat)){
			dy = -dy;
			this.setVelocity(0, dy);
			y = bat.getBoundingBox().getY() - diam;
		}
		x = x + dx;
		y = y + dy;
	//	this.setPosition(x, y);
	}*/
	
	public int collision(TennisBat bat) {
		Rectangle tbat = getRectangle(bat.getX(), bat.getY(), bat.getLength(), bat.getBreadth());
		Rectangle tball = getRectangle(this.getX(), this.getY(), this.getDiameter(), this.getDiameter());
		if(this.getY() > (bat.getY() + bat.getLength()))
			gameP.gameOver();
		if(tbat.intersects(tball)){
			this.setVelocity(this.getDX(), -this.getDY());
			return 1;
		}
		return 0;
//				.bat.getBounds().intersects(getBounds());
	}
	
	private static Rectangle getRectangle(double snakeX, double snakeY, double snakeLen, double snakeLen2) {
		return new Rectangle((int)snakeX, (int)snakeY, (int)snakeLen, (int)snakeLen2);
	}

}
