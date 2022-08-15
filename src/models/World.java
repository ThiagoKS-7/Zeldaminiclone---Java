package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	public static List<Block> blocks = new ArrayList<Block>();
	public String  wall = "purple_grass";
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocks.size(); i++) {
			Block blocoAtual = blocks.get(i);
			if (blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	public void renderWalls(int width, int height,int blockSize) {
		for(int xx = 0; xx < 30; xx++) {
			blocks.add(new Block(xx*blockSize,0,wall,blockSize,blockSize));
		}
		for(int xx = 0; xx < 28; xx++) {
			blocks.add(new Block(0,xx*blockSize,wall,blockSize,blockSize));
		}
		for(int xx = 0; xx < 29; xx++) {
			blocks.add(new Block(xx*blockSize,height-blockSize,wall,blockSize,blockSize));
		}
		for(int xx = 0; xx < 30; xx++) {
			blocks.add(new Block(width-32,xx*blockSize,wall,blockSize,blockSize));
		}
	}
	
	public void renderBackground(Graphics g, int width, int height, int ratioX,int ratioY) {
		g.setColor(Color.black);
		for (int i=0; i < width; i+=107) {
			for (int j=0; j < height; j+=100) {
				g.drawImage(Spritesheet.tileset.get("ground"),i,j,(width/ratioX),(height/ratioY), null);
			}
		}
	}
	public World(int width, int height, int blockSize) {
		renderWalls(width,height,blockSize);
	}
	public void render(Graphics g) {	
		for(int i = 0; i < blocks.size(); i ++) {
			blocks.get(i).render(g);
		}
	}
}
