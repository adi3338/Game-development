package com.own.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.own.gaming.sprites.Enemy;
import com.own.gaming.sprites.Players;

public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	Players players;
	Enemy enemies[]=new Enemy[3];
	public Board() {
		setSize(1500,830);
		loadBackgroundImage();
		players=new Players();
		loadEnemies();
		gameLoop();
		setFocusable(true);
		bindEvents();
	}
	private void gameOver(Graphics pen) {
		if(players.outOfScreen()) {
			pen.setFont(new Font("times",Font.BOLD,30));
			pen.setColor(Color.RED);
			pen.drawString("GAME WIN",1350/2,830/2);
			timer.stop();
		}
		for(Enemy enemy:enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("times",Font.BOLD,30));
				pen.setColor(Color.RED);
				pen.drawString("GAME OVER",1350/2,830/2);
				timer.stop();
			}
		}
	}
	private boolean isCollide(Enemy enemy) {
		int xDistance =Math.abs(players.x-enemy.x);
		int yDistance=Math.abs(players.y-enemy.y);
		int maxH=Math.max(players.h,enemy.h);
		int maxW=Math.max(players.w, enemy.w);
		return xDistance<=maxW-45 && yDistance <=maxH-55;
	}
	private void bindEvents()
	{
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
				players.speed=0;

			}

			@Override
			public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					players.speed=5;					
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					players.speed=-5;					
				}
			}
			
		});
	}
	private void loadEnemies() {
		int x=400;
		int speed =5;
		for(int i=0;i<enemies.length;i++) {
			enemies[i]=new Enemy(x,speed);
			x=x+300;
			speed=speed+5;
		}
	}
	private void gameLoop()
	{
		timer=new Timer(50,(e)->repaint());
		timer.start();
		
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage=ImageIO.read(Board.class.getResource("game-bg.jpg"));
			} catch (IOException e) {
			System.out.println("Background Image Not Found .... ");
			System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	private void printEnemies(Graphics pen) {
		for(Enemy enemy :enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
	public void paintComponent(Graphics pen) {
		// all printing logic will be here
		super.paintComponent(pen);
		pen.drawImage(backgroundImage,0,0,1500,920,null);
		players.draw(pen);
		players.move();
		printEnemies(pen);
		gameOver(pen);
	}

}
