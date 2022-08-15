package models;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Sword extends Rectangle{
	public int dir = 1;
	public int frames = 0;
	public int x;
	public int y;
	public Sword(int x, int y, int dir) {
		super(x,y);
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		frames ++;
		if (frames == 8) {
			Player.swords.remove(this);
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.tileset.get("sword"),this.x+25,this.y+16,32,13, null);
	}
}
