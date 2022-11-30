package main;
import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import gameObjects.Turno;
import graphics.Assets;
import input.KeyBoardInput;
import input.MouseInput;
import states.GameState;
import states.MenuState;
import states.State;
import states.TirarState;
import ui.Action;
import ui.Button;

public class Window extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1280, HEIGHT = 850;
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	private int AVERAGEFPS = FPS;
	
	
	private String pos="";
	

	
	private MouseInput mouseInput;
	private KeyBoardInput keyInput;
	private Button button;
	
	Turno turno=new Turno();
	public Window()
	{
		setTitle("Juego Patolli");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		canvas = new Canvas();
		mouseInput=new MouseInput();
		keyInput=new KeyBoardInput();
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		
		add(canvas);
		canvas.addMouseListener(mouseInput);
		canvas.addMouseMotionListener(mouseInput);
		canvas.addKeyListener(keyInput);
		
		setVisible(true);
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				turno.setTurno(true);
			}
		});
		
		
	}
	
	

	public static void main(String[] args) {
		new Window().start();
	}
	
	
	private void update(){
		mouseInput.maouseUpdate();
		
		State.getCurrentState().update();
		mouseInput.mouseLeftButton=false;
		//tirar.update();
		
	}

	private void draw(){
		bs = canvas.getBufferStrategy();
		
		if(bs == null)
		{
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//-----------------------
		
		g.setColor(Color.white);		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		
		State.getCurrentState().draw(g);
		
		//tirar.draw(g);
		
		
		g.drawString(pos, 0, 0);
		
		//---------------------
		g.dispose();
		bs.show();
	}
	
	private void init()
	{
		Assets.init();
		State.changeState(new MenuState());
		
		
		
		
	}
	
	
	@Override
	public void run() {
		
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;
		
		init();
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime)/TARGETTIME;
			time += (now - lastTime);
			lastTime = now;
			
			
			
			if(delta >= 1)
			{		
				update();
				draw();
				delta --;
				frames ++;
			}
			if(time >= 1000000000)
			{
				AVERAGEFPS = frames;
				frames = 0;
				time = 0;
				
			}
			
			
		}
		
		stop();
	}
	
	private void start(){
		
		thread = new Thread(this);
		thread.start();
		running = true;
		
		
	}
	private void stop(){
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}