package com.breakout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;

public class Breakout{
	
	private static GamePanel west;
	private static InstructionPanel east;
	private static double currTime, time, startTime, now;
	private static boolean isPaused = false;
	private static int score;
	private static int fps;

	public static void main(String[] args) throws InterruptedException {
	
	/*	int framesCountAvg=0; 
		long framesTimer=0;
		DateFormat date;// = new Date(currentmilliseconds);	
		FrameRateCounter frc = new FrameRateCounter();*/
		
		final JFrame frame = new JFrame("Breakout Game");
		frame.getContentPane().setLayout(new GridLayout());
		frame.setSize(1000, 500);
		
		// Game Panel
		west = new GamePanel();
		frame.getContentPane().add(west);
		
		// Instruction Panel
		east = new InstructionPanel(); //addInstructionPanel();
		frame.getContentPane().add(east);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		
		startTime = System.nanoTime();
		now = System.currentTimeMillis();
		long framesCount = 1;
		double elaspedTime;
		
	//	west.initialise();
		while(true){
			gameLoop();
		}
		
	
		/*	now = System.currentTimeMillis();
			elaspedTime += elaspedTime;
			System.out.println("fps : "+ fps + " cn:"+ framesCount + " time:" + elaspedTime);
			startTime = now - startTime;
			startTime = startTime/1000;
			east.setLblTimeElapsed(startTime);*/
	}

	private static void gameLoop() {
		// TODO Auto-generated method stub
		while (!isPaused)
		{
			
		/*	framesCount = 1;
			elaspedTime = startTime - now;
			elaspedTime /= 1000000000000000.0;
			framesCount++;
			double fps = framesCount / elaspedTime  * 100000.0;*/
	
			fps = calculateFPS();
			time = calculateTimeElapsed();
			score = calculateScore();
			
						
			
//				east.setLblFps(fps);
			try{
				Thread.sleep(10);
		//		isPaused = isGamePaused();
				updateGame();
//				System.out.println(" game: " +isPaused);
			}
			catch(InterruptedException e) {}
		//	time += 10;
		}
	}

	private static int calculateScore() {
		// TODO Auto-generated method stub
		return west.getScore();
	}

	private static double calculateTimeElapsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int calculateFPS() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void updateGame() {
		// TODO Auto-generated method stub
		west.move();
		west.repaint();
		
		/// update variables
		east.setLblScore(score);
		east.setLblTimeElapsed(time);
		east.setLblFps(fps);
	}

	public static void pauseGame(){
		isPaused = true;
		
	}
	
	public static void startGame(){
		isPaused = false;	
		west.setFocusable(true);
		west.addKeys();
		
		west.move();
//		west.initialise();
//		updateGame();
//		gameLoop();
	}
	
	public static void restartGame(){
		west.initialise();
		east.setLblScore(west.getScore());
		east.setLblTimeElapsed(0);
		west.move();
		isPaused = false;
//		startGame();
	}

}
