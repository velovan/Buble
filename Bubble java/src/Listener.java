
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == e.VK_UP){
			GamePlayer.up = true;
		}
		if(key == e.VK_DOWN){
			GamePlayer.down = true;
		}
		if(key == e.VK_LEFT){
			GamePlayer.left = true;
		}
		if(key == e.VK_RIGHT){
			GamePlayer.right = true;
		}
		
		 
		if(key == e.VK_SPACE){
			GamePlayer.isFiring = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == e.VK_UP){
			GamePlayer.up = false;
		}
		if(key == e.VK_DOWN){
			GamePlayer.down = false;
		}
		if(key == e.VK_LEFT){
			GamePlayer.left = false;
		}
		if(key == e.VK_RIGHT){
			GamePlayer.right = false;
		}
				 
		if(key == e.VK_SPACE){
		   GamePlayer.isFiring = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {
			
	}
}
