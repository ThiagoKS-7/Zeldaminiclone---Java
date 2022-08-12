package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	
	public  int spd = 4;
	public String move = "stop";
	
	public Player(int x, int y) {
		super(x,y,32,32);
	}
	public void checkMove() {
		switch(move) {
		case "right":
			if (World.isFree(x += spd,y)) {				
				x += spd;
			}
			else {
				x -= spd;
			}
			break;
		case "left":
			if (World.isFree(x -= spd,y)) {				
				x -= spd;
			} else {
				x += spd;
			}
			break;
		case "up":
			if (World.isFree(x,y -= spd)) {		
				y -= spd;
			} else {
				y += spd;
			}
			break;
		case "down":
			if (World.isFree(x,y +=  spd)) {				
				y += spd;
			} else {
				y -= spd;
			}
			break;
		case "stop":
			x += 0;
			y += 0;
			break;
		}
	}
	public void tick() {
		checkMove();
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

}
