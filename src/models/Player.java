package models;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle {
	
	public  double spd = 2;
	public String move = "stop";
	public String sprite = "player_front";
	public int curAnimation = 0;
	private Graphics g;
	public int curFrames = 0;
	public int targetFrames = 10;
	public static List<Sword> swords = new ArrayList<Sword>();
	public Player(int x, int y) {
		super(x,y,32,32);
	}
	public void checkMove() {
		switch(move) {
		case "right":
			if (World.isFree(x += spd,y)) {				
				x += spd;
				sprite = "player_right";
			}
			else {
				x -= spd;
				sprite = "player_right";
			}
			break;
		case "left":
			if (World.isFree(x -= spd,y)) {				
				x -= spd;
				sprite = "player_left";
			} else {
				x += spd;
				sprite = "player_left";
			}
			break;
		case "up":
			if (World.isFree(x,y -= spd)) {		
				y -= spd;
				sprite = "player_back";
			} else {
				y += spd;
				sprite = "player_front";
			}
			break;
		case "down":
			if (World.isFree(x,y +=  spd)) {				
				y += spd;
				sprite = "player_front";
			} else {
				y -= spd;
			}
			break;
		case "f_atack":
			sprite = "pf_atack";
			swords.add(new Sword(x,y,1));
			break;
		case "stop":
			x += 0;
			y += 0;
			sprite = "player_stop";
			break;
		}
	}
	public void tick() {
		checkMove();
		curFrames ++;
		if (curFrames == targetFrames) {
			curAnimation++;
			curFrames = 0;
			if (curAnimation == Spritesheet.moveset.get(sprite).length) {				
				curAnimation = 0;
				sprite = "player_stop";
			}
		}
		for (int i = 0; i < swords.size(); i++) {
			swords.get(i).tick();
		}
	}
	public void render(Graphics g) {
		g.drawImage(Spritesheet.moveset.get(sprite)[curAnimation],x,y,32,32, null);
		for (int i = 0; i < swords.size(); i++) {
			swords.get(i).render(g);
		}
	}	

}
