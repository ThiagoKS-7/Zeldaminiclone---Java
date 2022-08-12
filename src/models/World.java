package models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	public static List<Block> blocks = new ArrayList<Block>();
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocks.size(); i++) {
			Block blocoAtual = blocks.get(i);
			if (blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	public void renderHorizontalWall(int wallLength, int width, int blockPos) {
		for(int xx = 0; xx < wallLength; xx++) {
			blocks.add(new Block(xx*width,blockPos));
		}
	}
	public void renderVerticalWall(int wallLength, int blockPos, int height) {
		for(int xx = 0; xx < wallLength; xx++) {
			blocks.add(new Block(blockPos,xx*height));
		}
	}
	public World(int width, int height, int blockSize) {
		renderHorizontalWall((width/blockSize), blockSize, 0);
		renderHorizontalWall((width/blockSize), blockSize, width - blockSize);
		renderVerticalWall((height/blockSize), 0, blockSize);
		renderVerticalWall((height/blockSize), height - blockSize, blockSize);
	}
	public void render(Graphics g) {	
		for(int i = 0; i < blocks.size(); i ++) {
			blocks.get(i).render(g);
		}
	}
}
