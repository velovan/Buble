import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bullets {

	private double x;
	private double y;
	
	private int r;
	private int speed;
	private Color color1;
	
	private double dx;
	private double dy;
	
	
	public Bullets(double angle, int x, int y){
		this.x = x;
		this.y = y;
		
		r = 2;
		speed = 7;
		color1 = Color.WHITE;
		
		double rad = Math.toRadians(angle);
		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;	
	}
	
	public boolean remove(){
		
		if( y < 0){
			return true;
		}
		return false;
	}
	
	public void update(){
		x += dx;
		y += dy;
		
	}
	
	public void draw(Graphics2D g){
		
		g.setColor(color1);
		g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
		g.setStroke(new BasicStroke(3));
	}
}
