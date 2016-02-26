package LayOut;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private JPanel logInP = new LogInPanel();
	private JPanel topP;
	
	public MainPanel() {

		topP = new TopPanel(this);
		
		setLayout(new BorderLayout());
		
		add(topP, BorderLayout.NORTH);
		add(logInP, BorderLayout.CENTER);
		 		
	}
	
	public void HomeButton (){
		remove(logInP);
		logInP = new LogInPanel();
		add(logInP, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

}
