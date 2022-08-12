

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import models.Player;
import models.World;

public class Game extends Canvas implements Runnable, KeyListener {
	
	public static int WIDTH=640,HEIGHT = 640; // CONSTANTES GLOBAIS DE TAMANHO
	public Player player;
	public World world;
	
	public Game() {
		this.addKeyListener(this); // LE AS TECLAS
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); // TAMANHO JANELA
		/* INSTANCIAS PRINCIPAIS */
		player = new Player(32,32);
		world = new World(WIDTH,HEIGHT,32);
	}
	
	public static void configureFrame(Game game) {
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle("Zelda Mini Clone");
		frame.pack(); // JUNTA TITULO E CONTEÚDO NA JANELA
		frame.setLocationRelativeTo(null); // CENTRALIZA JANELA
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		new Thread(game).start();// PROCURA O RUN DA GAME
	}
	public static void main(String[] args) {
		Game game = new Game();		
		configureFrame(game);
	}
	
	public void tick() {
		player.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		/* background */
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		/*end background */
		
		player.render(g);
		world.render(g);
		bs.show();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_D:
				player.move = "right";
				break;
			case KeyEvent.VK_A:
				player.move = "left";
				break;
			case KeyEvent.VK_W:
				player.move = "up";
				break;
			case KeyEvent.VK_S:
				player.move = "down";
				break;
			default:
				player.move = "stop";
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.move = "stop";
	}
	
	
	@Override
	public void run() {
		while(true) {
			tick();
			render();
			try {
				// TENTA RODAR A 60FPS
				Thread.sleep(1000/60);
			} catch (InterruptedException f) {
				f.printStackTrace();
			}
		}
	}
}
