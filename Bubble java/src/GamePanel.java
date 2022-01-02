
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JPanel;

public class GamePanel extends JPanel  implements Runnable {
	
	//Fields
	public static int WIDTH = 400; 
	public static int HEIGHT = 400;
	
	private Thread thread;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private int FPS;
	private double milisToFPS;
	private long timerFPS;
	private int sleepTime;
	
	public static GameBack background;
	public static GamePlayer player;
	
	public static ArrayList<Bullets> bullets;
	public static ArrayList<Enemy> enemy;
	
	//Consturctor
	public GamePanel (){
		super();
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		
		addKeyListener(new Listener());
	}

	// Functions
	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		
		FPS = 30;
		milisToFPS = 1000 / FPS;
		sleepTime = 0;
		
		image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		background = new GameBack();
		player = new GamePlayer();
		
		bullets = new ArrayList<Bullets>();
		enemy = new ArrayList<Enemy>();
	 
		//enemies.add(new Enemy(1,1));
		//enemies.add(new Enemy(1,1));
		enemy.add(new Enemy(1, 1));
		
		while(true){	// TODO States
			
			timerFPS = System.nanoTime();
			
			gameUpdate();
			gameRender();
			gameDraw();
			
			timerFPS = ( System.nanoTime() - timerFPS) / 1000000;
			if(milisToFPS > timerFPS){
				sleepTime = (int) (milisToFPS - timerFPS);
			}else sleepTime = 1;
			
			try {
				thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(sleepTime);
				e.printStackTrace();
			}
		//	timerFPS = 0;
			//sleepTime = 1;
		}
	}
	
	public void gameUpdate(){  
		// BackGround update
		background.update();
		
		// Player update
		player.update();
		
		// Bullets Update
	for(int i = 0; i < bullets.size(); i++){
		 bullets.get(i).update();
	     }
	
	// Enemy Update
    for(int i = 0; i < enemy.size(); i++){
    	enemy.get(i).update();
       }
	}
	
	public void gameRender(){  
		// BackGround draw
		background.draw(g);	
		
		// Player draw
		player.draw(g);
		
		// Bullets Draw
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).draw(g);
			boolean remove = bullets.get(i).remove();
			if(remove){
			bullets.remove(i);
			}
		    System.out.println(bullets.size());
		}
		
		// Enemy Draw
		for(int i = 0; i < enemy.size(); i++){
			enemy.get(i).render(g);
		}
	}
	
	private void gameDraw(){
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0, 0, null);
		g2.dispose();	
	}
}
