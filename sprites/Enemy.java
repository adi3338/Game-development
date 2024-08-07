package com.own.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends sprite{
	
	public Enemy(int x,int speed) {
		w=100;
		h=190;
		this.x=x;
		this.speed=speed;
		y=50;
		image=new ImageIcon(Players.class.getResource("airian-cong-spider-animation-2.gif"));
	}
	public void move() {
		if(y>800) {
			y=0;
		}
		y=y+speed;
	}
}
