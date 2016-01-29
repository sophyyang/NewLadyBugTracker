package LayOut;

 import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 

public class LogInPanel extends JPanel {
	
	 JLabel eMailL = new JLabel("email address:");
	 JTextField eMailT = new JTextField(50);
	 JButton signInB = new JButton("Sign In");
	 JLabel signUpL = new JLabel("New to LayBug?");
	 JButton signUpB = new JButton("Create an account?");
	 
	 
	public LogInPanel() {
		ButtonListener b = new ButtonListener();
		signInB.addActionListener(b);
		signUpB.addActionListener(b);
		
		JPanel buttonPanel = new JPanel(new GridLayout(5,0));
		
		buttonPanel.add(eMailL);
		buttonPanel.add(eMailT);
		buttonPanel.add(signInB);
		buttonPanel.add(signUpL);
		buttonPanel.add(signUpB);
		add(buttonPanel);
		

	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == signUpB) {
				String tempItem = eMailT.getText();
				removeAll();
				JPanel newPanel = new JTabbedPanel();
				add(newPanel);
				revalidate();
				//newPanel.repaint();
			}

			if (e.getSource() == signInB) {
				String tempItem = eMailT.getText();
				removeAll();
				JPanel newPanel = new JTablePanel(1);
				add(newPanel);
				revalidate();
				//newPanel.repaint();
			}



	}

	}
}

