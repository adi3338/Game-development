package com.own.gaming;


import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame() {
		Board board= new Board();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Game Dev in java");
		this.setResizable(false);
		this.setSize(1500,830);
		this.setLocationRelativeTo(null);
		add(board);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame();
		
	} 

}

