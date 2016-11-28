import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {

	private double x;
	private double y;
	
	private int r;
	private int speed;
	
	private Color color1;
	
	private double dx;
	private double dy;
	
    private int type;
    private int rank;
    
    public Enemy(int type, int rank){
    	this.type = type;
    	this.rank = rank;
    	
    	if(type ==1){
    	r = 7;
    	speed = 6;
    	color1 = Color.RED;
    	
    	double rad = Math.toRadians(Math.random() * 360);
    	
    	dx = Math.sin(rad) * speed;
    	dy = Math.sin(rad) * speed;
        }
    }
    	
    public void update(){
    	
    	x += dx;
    	y  += dy;
    	
    	if(x < 0 && dx < 0) dx = -dx;
		if(x > GamePanel.WIDTH && dx > 0)dx = -dx;
		
		if(y < 0 && dy < 0) dy = -dy;
		if(y > GamePanel.HEIGHT && dy > 0)dy = -dy;
    }
    
    public void render(Graphics2D g){
    	g.setColor(color1);
    	g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
    	g.setStroke(new BasicStroke(3));
    }
    
}