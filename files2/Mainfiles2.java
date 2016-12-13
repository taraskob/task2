package files2;

import javax.swing.SwingUtilities;

public class Mainfiles2 implements ChangeHandler{
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			 new Files2();
		}
		});

	}
	public void onChange(){
		
	}
}
