import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import LayOut.MainPanel;
/*
 * GitHut URI
 * https://github.com/sophyyang/NewLadyBugTracker.git
 */
public class LadyBugTracker {

	public static void main(String[] args) throws IOException {
		  int iWidth =600;
		  int iHight = 500;
		
		JFrame master = new JFrame();
		JPanel mainPanel = new MainPanel();
		master.setTitle("Welecom to Lady Bug Tracker");
		master.add(mainPanel);
 		master.setSize((iWidth +200) , (iHight + 300));
		master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		master.setVisible(true);

	}
} 
