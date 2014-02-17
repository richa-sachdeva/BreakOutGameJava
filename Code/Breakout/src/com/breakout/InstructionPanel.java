package com.breakout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InstructionPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblTimeElapsed;
	private JLabel lblScore;
	private JLabel lblFps;
	private JButton pause, start, restart;
	private boolean isRunning;
	
	public InstructionPanel(){
		
//		JPanel panel = new JPanel();
		this.setBackground(Color.pink);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{141, 40, 110, 53, 31, 32, 29, 0};
		gbl_panel.rowHeights = new int[]{24, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JLabel heading = new JLabel("Instructions for BreakOut Game\r\n");
		heading.setPreferredSize(new Dimension(400, 80));
		heading.setBackground(Color.WHITE);
		heading.setToolTipText("");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setFont(new Font("Snap ITC", Font.ITALIC, 18));
		GridBagConstraints gbc_heading = new GridBagConstraints();
		gbc_heading.gridheight = 2;
		gbc_heading.fill = GridBagConstraints.VERTICAL;
		gbc_heading.insets = new Insets(0, 0, 5, 0);
		gbc_heading.gridwidth = 7;
		gbc_heading.gridx = 0;
		gbc_heading.gridy = 0;
		this.add(heading, gbc_heading);
		
		JLabel time = new JLabel("Time Elapsed(sec)\r\n");
		time.setPreferredSize(new Dimension(49, 20));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setToolTipText("");
		time.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_time = new GridBagConstraints();
		gbc_time.fill = GridBagConstraints.HORIZONTAL;
		gbc_time.anchor = GridBagConstraints.SOUTH;
		gbc_time.insets = new Insets(0, 0, 5, 5);
		gbc_time.gridx = 0;
		gbc_time.gridy = 2;
		this.add(time, gbc_time);
		
		lblTimeElapsed = new JLabel("time elapsed");
		lblTimeElapsed.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblTimeElapsed = new GridBagConstraints();
		gbc_lblTimeElapsed.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeElapsed.gridx = 2;
		gbc_lblTimeElapsed.gridy = 2;
		this.add(lblTimeElapsed, gbc_lblTimeElapsed);
		
		JLabel score = new JLabel("Score");
		score.setPreferredSize(new Dimension(40, 20));
		score.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_score = new GridBagConstraints();
		gbc_score.insets = new Insets(0, 0, 5, 5);
		gbc_score.gridx = 0;
		gbc_score.gridy = 3;
		this.add(score, gbc_score);
		
		lblScore = new JLabel("score");
		lblScore.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblScore.gridx = 2;
		gbc_lblScore.gridy = 3;
		this.add(lblScore, gbc_lblScore);
		
		JLabel lblFramePerSecond = new JLabel("Frame Per Second (FPS)");
		lblFramePerSecond.setPreferredSize(new Dimension(160, 20));
		lblFramePerSecond.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblFramePerSecond = new GridBagConstraints();
		gbc_lblFramePerSecond.gridwidth = 2;
		gbc_lblFramePerSecond.insets = new Insets(0, 0, 5, 5);
		gbc_lblFramePerSecond.gridx = 0;
		gbc_lblFramePerSecond.gridy = 4;
		this.add(lblFramePerSecond, gbc_lblFramePerSecond);
		
		lblFps = new JLabel("fps");
		lblFps.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblFps = new GridBagConstraints();
		gbc_lblFps.insets = new Insets(0, 0, 5, 5);
		gbc_lblFps.gridx = 2;
		gbc_lblFps.gridy = 4;
		this.add(lblFps, gbc_lblFps);
		
		JLabel label = new JLabel("-------------------------------------------------------------");
		label.setPreferredSize(new Dimension(300, 40));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 7;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		this.add(label, gbc_label);
		
		JLabel lblControlsForThe = new JLabel("Controls for the Game");
		lblControlsForThe.setPreferredSize(new Dimension(140, 60));
		lblControlsForThe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_lblControlsForThe = new GridBagConstraints();
		gbc_lblControlsForThe.gridwidth = 3;
		gbc_lblControlsForThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblControlsForThe.gridx = 0;
		gbc_lblControlsForThe.gridy = 7;
		this.add(lblControlsForThe, gbc_lblControlsForThe);
		
		pause = new JButton("Pause");
		pause.setMaximumSize(new Dimension(90, 25));
		pause.setMinimumSize(new Dimension(80, 25));
		pause.setPreferredSize(new Dimension(80, 25));
		GridBagConstraints gbc_pause = new GridBagConstraints();
		gbc_pause.gridwidth = 2;
		gbc_pause.anchor = GridBagConstraints.NORTHEAST;
		gbc_pause.insets = new Insets(0, 0, 5, 5);
		gbc_pause.gridx = 0;
		gbc_pause.gridy = 8;
		this.add(pause, gbc_pause);
	/*	 pause.addActionListener(new ActionListener(){ 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// Create a canvas (BouncePanel) and add it to the window
	   //         	isRunning = false;
	  //          	System.out.println("hello inside pause button click event");
	            }
	        });*/
		
		
		start = new JButton("Start");
		start.setPreferredSize(new Dimension(80, 25));
		start.setAlignmentX(Component.RIGHT_ALIGNMENT);
		start.setMinimumSize(new Dimension(80, 25));
		start.setMaximumSize(new Dimension(90, 25));
		GridBagConstraints gbc_start = new GridBagConstraints();
		gbc_start.gridwidth = 2;
		gbc_start.anchor = GridBagConstraints.NORTHEAST;
		gbc_start.insets = new Insets(0, 0, 5, 5);
		gbc_start.gridx = 0;
		gbc_start.gridy = 9;
		this.add(start, gbc_start);
	/*	  start.addActionListener(new ActionListener(){ 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// Create a canvas (BouncePanel) and add it to the window
	    //        	isRunning = true;
	    //			System.out.println("hello inside start button click event");
	            }
	        });*/
		
		restart = new JButton("Restart");
		restart.setMinimumSize(new Dimension(80, 25));
		restart.setMaximumSize(new Dimension(90, 25));
		restart.setPreferredSize(new Dimension(80, 25));
		GridBagConstraints gbc_restart = new GridBagConstraints();
		gbc_restart.gridwidth = 2;
		gbc_restart.insets = new Insets(0, 0, 0, 5);
		gbc_restart.anchor = GridBagConstraints.SOUTHEAST;
		gbc_restart.gridx = 0;
		gbc_restart.gridy = 10;
		this.add(restart, gbc_restart);
	//	restart.addAncestorListener(restart);
	//	 restart.addActionListener(new ActionListener(){};
	/*            public void actionPerformed(ActionEvent e)
	            {
	            	// Create a canvas (BouncePanel) and add it to the window
	    //        	isRunning = true;
	   //         	Breakout.restartGame();
	  //  			System.out.println("hello inside restart button click event");
	            }
	        });
		*/
		pause.addActionListener(this);
		start.addActionListener(this);
		restart.addActionListener(this);
	}
	
	public JLabel getLblTimeElapsed() {
		return lblTimeElapsed;
	}

	public void setLblTimeElapsed(double elaspedTime) {
		DecimalFormat df = new DecimalFormat("#.####");
		String label = ""+df.format(elaspedTime);//LongToString(lblTimeElapsed);
		this.lblTimeElapsed.setText(label);// = label;
	}

	public JLabel getLblScore() {
		return lblScore;
	}

	public void setLblScore(long lblScore) {
		this.lblScore.setText(""+lblScore);
	}

	public JLabel getLblFps() {
		return lblFps;
	}

	public void setLblFps(double lblFps) {
		this.lblFps.setText(""+lblFps);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		String label = button.getText();
        if(label == "Pause"){Breakout.pauseGame();}
        else if(label == "Start"){Breakout.startGame();}
        else if(label == "Restart"){Breakout.restartGame();}
		
	}

	public boolean getGameStat() {
		return isRunning;
	}

	public void setGameStat(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
