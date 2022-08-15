package models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	public static HashMap<String,BufferedImage> tileset=new HashMap<String,BufferedImage>();
	public static HashMap<String,BufferedImage[]> moveset=new HashMap<String,BufferedImage[]>();
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
			configureBackground();
			configureMoveset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void configureBackground() {
		tileset.put("ground",spritesheet.getSubimage(284,222,64,64));
		tileset.put("purple_grass", spritesheet.getSubimage(125,223,16,16));
		tileset.put("sword", spritesheet.getSubimage(77,67,8,8));
	}
	public void configureMoveset() {
		setMovesSprites();
		setAtackSprites();
	}
	public void setMovesSprites() {
		BufferedImage[] pF = new BufferedImage[2];
		BufferedImage[] pB = new BufferedImage[2];
		BufferedImage[] pR = new BufferedImage[2];
		BufferedImage[] pL = new BufferedImage[2];
		BufferedImage[] pS = new BufferedImage[2];
		setSpriteArray(pF,spritesheet.getSubimage(0,11,16,16),spritesheet.getSubimage(18,11,16,16),"player_front");
		setSpriteArray(pR,spritesheet.getSubimage(34,11,16,16),spritesheet.getSubimage(52,12,16,16),"player_right");
		setSpriteArray(pL,spritesheet.getSubimage(162,11,16,16),spritesheet.getSubimage(182,12,16,16),"player_left");
		setSpriteArray(pB,spritesheet.getSubimage(70,11,16,16),spritesheet.getSubimage(87,11,16,16),"player_back");
		setSpriteArray(pS,spritesheet.getSubimage(0,11,16,16),spritesheet.getSubimage(0,11,16,16),"player_stop");
	}
	public void setSpriteArray(BufferedImage[] p,BufferedImage img1,BufferedImage img2, String sprite) {
		p[0] = img1;
		p[1] = img2;
		moveset.put(sprite,p);
	}
	public void setAtackSprites() {
		BufferedImage[] pfA = new BufferedImage[2];
//		BufferedImage[] pbA = new BufferedImage[4];
//		BufferedImage[] prA= new BufferedImage[4];
//		BufferedImage[] plA = new BufferedImage[4];
		setSpriteArray(pfA,spritesheet.getSubimage(110,78,16,16),spritesheet.getSubimage(163,76,16,16),"pf_atack");
	}
}
