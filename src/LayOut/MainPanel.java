package LayOut;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	
	public MainPanel() {

		JPanel topP = new TopPanel();
		JPanel logInP = new LogInPanel();
		
		setLayout(new BorderLayout());
		
		add(topP, BorderLayout.NORTH);
		add(logInP, BorderLayout.CENTER);
		 		
	}
	

}
