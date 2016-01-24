import javax.swing.JFrame;
import javax.swing.JPanel;

import LayOut.MainPanel;

public class LadyBugTracker {

	public static void main(String[] args) {
		
		JFrame master = new JFrame();
		JPanel mainPanel = new MainPanel();
		master.add(mainPanel);
		
		master.setSize(600, 400);
		master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		master.setVisible(true);

	}
}
