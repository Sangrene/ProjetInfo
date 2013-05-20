package com.hlb.darkarena;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.hlb.darkarena.entity.Entity;
import com.hlb.darkarena.entity.mob.DarkArcher;
import com.hlb.darkarena.entity.mob.Mob;
import com.hlb.darkarena.entity.mob.Player;
import com.hlb.darkarena.entity.mob.Zombie;
import com.hlb.darkarena.graphics.Screen;
import com.hlb.darkarena.input.Keyboard;
import com.hlb.darkarena.input.Mouse;
import com.hlb.darkarena.items.gui.GuiItems;
import com.hlb.darkarena.level.Level;
import com.hlb.darkarena.level.SpawnLevel;

//Test de push.

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width/16*9;
	public static int scale = 3;
	public static String title = "Dark Arena";
	
	private Thread thread;
	public JFrame frame;
	private Keyboard key;
	private Mouse mouse;
	private Level level;
	private Player player;
	private boolean running = false;
	private int numberZombies = 1;
	private int numberDArchers = 0;
	public static ArrayList<Mob> mobs = new ArrayList<Mob>();
	public ArrayList<Integer> mobsX = new ArrayList<Integer>();
	public ArrayList<Integer> mobsY = new ArrayList<Integer>();
	public static ArrayList<Entity> otherEntities = new ArrayList<Entity>();
	
	public static int xMouse, yMouse;
	public static int xPlayer, yPlayer;
	
	private Screen screen;
	
	/** Création du buffer image pour récuperer l'image sous forme de tableau */
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	/** Constructeur de la classe Game */
	
	public Game()
	{
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		mouse = new Mouse();
		level = new SpawnLevel("/textures/levels/level.png");
		
		player = new Player(30, 30, key, mouse);
		player.newEntity(this, level, 0);
		mobs.add(player);

		for(int i = 0; i < numberZombies; i++)
		{
			Zombie zombie = new Zombie(32 * i + 60, 32 * i + 60);
			zombie.newEntity(this, level, i + mobs.size());
			mobs.add(zombie);
		}
		for(int i = 0; i < numberDArchers; i++)
		{
			DarkArcher dArcher = new DarkArcher(32 * i + 50, 32 * i);
			dArcher.newEntity(this, level, i + mobs.size());
			mobs.add(dArcher);
		}
		
		
		
		
		addMouseListener(mouse);
		addKeyListener(key);
		addMouseMotionListener(mouse);
	}
	
	/** Fonction de démarrage des thread et de la boucle principale */
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	
	/** Fonction d'arret */
	
	public synchronized void stop()
	{
		running = false;
		try
		{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	/** Boucle principale et timer */
	
	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		requestFocus();
		while(running)
		{

			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;

			while(delta >= 1)
			{
				update();
				delta--;
			}


			render();
			frames++;
			

			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				frame.setTitle(title + "  |  " + frames + " fps");
				frames = 0;
			}
		}
	}
	
	/** Fonction de mise à jour */
	
	public void update()
	{
		key.update();
		mouse.update();
		if(!key.escape)
		{
			for(int i = 0; i < mobs.size(); i++)
			{
				mobs.get(i).update();
			}

			for(int i = 0; i < otherEntities.size(); i++)
			{
				otherEntities.get(i).update();
			}
		
		xMouse = -450 / 3 + mouse.getMouseX() / 3 + player.x;
		yMouse = -240 / 3 + mouse.getMouseY() / 3 + player.y;
		}
	}
	
	/** Affichage à l'écran */
	
	public void render()
	{
		xPlayer = player.x;
		yPlayer = player.y;
		mobsX.clear();
		mobsY.clear();

		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		screen.clear();

		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;

		level.render(xScroll, yScroll, screen);
		
		for(int i = 0; i < otherEntities.size(); i++)
		{
			otherEntities.get(i).render(screen);
		}
		for(int i = 1; i < mobs.size(); i++)
		{
			mobs.get(i).render(screen);
			mobsX.add(3*(mobs.get(i).x + (450 / 3) - player.x));
			mobsY.add(3*(mobs.get(i).y + (450 / 3) - player.y) - 200);
		}
		player.render(screen);
		
		if(key.escape)
		{
			GuiItems guiItems = new GuiItems(this, player, screen);
		}
		for(int i = 0; i<pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}



		Graphics g = bs.getDrawGraphics();
	
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.setFont(new Font("French Script MT", Font.PLAIN, 32));
		g.drawString("X: " + player.x + "/ Y : " + player.y , 20, 25);
		g.drawString("Health : " + player.getHealth() + " / " + player.getMaxHealth(), 700, 25);
		g.setFont(new Font("French Script MT", Font.PLAIN, 28));
		for(int i = 0; i < mobsX.size() ; i++)
		{
			g.drawString("" + mobs.get(i + 1).getHealth() + "/" + mobs.get(i + 1).getMaxHealth(), mobsX.get(i) - 20, mobsY.get(i));
		}
		

		g.dispose();
		bs.show();
	}
	
	/** Le main */
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
