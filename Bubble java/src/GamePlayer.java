

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class GamePlayer {
	
	private double x;
	private double y;
	
	private int r;
	private int speed;
	private Color color1;
	
	private double dx;
	private double dy;
	
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	public static boolean isFiring;

	public GamePlayer(){
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		
		r = 7;
		speed = 6;
		
		dx = 0;
		dy = 0;
		
		color1 = Color.BLUE;
	
		up    = false;
		down  = false;
		left  = false;
		right = false;
		isFiring = false;
	}
	
	public void update(){
	if(up && y > r){
		dy -= speed;
	}
	if(down && y < GamePanel.WIDTH - r){
		dy = speed;
	 }
	if(left && x > r){
		dx -= speed;
	}
	if(right && x < GamePanel.WIDTH - r){
		dx = speed;
	 }
	if(up &&  left || up && right || down && left || down && right){
	  double angle = Math.toRadians(45);
	
	  dx = dx * Math.cos(angle);
	  dy = dy * Math.sin(angle);
	}
	x += dx;
	y += dy;
	
	dx = 0;
	dy = 0;
	
	if(isFiring){
		GamePanel.bullets.add(new Bullets(268,(int) x + 1 ,(int)  y));
		GamePanel.bullets.add(new Bullets(272,(int) x + 1,(int)  y)); 
     	  }
	}
	
	public void draw(Graphics2D g){
		g.setColor(color1);
		g.fillRect((int) x - r, (int) y - r, 2 * r, 2 * r);
		g.setStroke(new BasicStroke(3));
	}

}
