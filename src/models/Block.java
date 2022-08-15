package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {
	public String sprite;
	public int sizeX, sizeY;
	public Block(int x, int y, String sprite, int sizeX, int sizeY) {
		super(x,y,32,32);
		this.sprite = sprite;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	public void render(Graphics g) {
		if (sprite != "magenta") {			
			g.setColor(Color.darkGray);
			g.drawRect(x, y, width, height);
			g.drawImage(Spritesheet.tileset.get(sprite),x,y,sizeX,sizeY, null);
		} else if(sprite == "sword") {
			g.drawImage(Spritesheet.tileset.get(sprite),x,y,sizeX,sizeY, null);
		} else {
			g.setColor(Color.magenta);
			g.fillRect(x, y, width, height);
			g.setColor(Color.black);
			g.drawRect(x, y, width, height);
		}
		
	}
	public void tick() {
		
	}

}
