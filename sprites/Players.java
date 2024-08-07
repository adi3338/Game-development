package com.own.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Players extends sprite{
	
	public Players() {
		w=100;
		h=190;
		x=100;
		y=543;
		image=new ImageIcon(Players.class.getResource("tes.gif.feb8f92b2677c07193f9fee285eaa788.gif"));
	}
	public void move()
	{
		x=x+speed;
	}
	public boolean outOfScreen() {
		return (x>1500);
	}
}
