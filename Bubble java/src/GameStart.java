import javax.swing.JFrame;

public class GameStart {

	public static void main(String [] args){
		
		GamePanel panel = new GamePanel();
		
		JFrame frame = new JFrame("Buble");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setContentPane(panel);
	    frame.pack();
	 
	    
	    frame.setLocationRelativeTo(null);
	    panel.start();
	    frame.setVisible(true);
	}
	
}
