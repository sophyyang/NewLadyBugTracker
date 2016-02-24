//Katie Sullivan

package LayOut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LogInPanel extends JPanel {

	private JLabel eMailL;
	private JTextField eMailT;
	private JLabel passwordL;
	private JTextField passwordT;
	private JButton signInB;
	private JButton signUpB;

	public LogInPanel() {
		JPanel panel = new JPanel(new GridLayout(6, 0));

		eMailL = new JLabel("Email Address: ");
		panel.add(eMailL);

		eMailT = new JTextField(50);
		panel.add(eMailT);

		passwordL = new JLabel("Password: ");
		panel.add(passwordL);

		passwordT = new JTextField(50);
		panel.add(passwordT);

		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));

		signInB = new JButton("Sign In");
		SignInButtonListener a = new SignInButtonListener();
		signInB.addActionListener(a);

		signUpB = new JButton("Create an account?");
		SignUpButtonListener b = new SignUpButtonListener();
		signUpB.addActionListener(b);

		JPanel bp = new JPanel();
		bp.add(signInB);
		bp.add(signUpB);

		add(panel);
		add(bp);

	}

	class SignInButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {

			String tempItem = eMailT.getText();
			removeAll();
			JPanel newPanel = new BugTicketPanel();
			add(newPanel);
			revalidate();
			// newPanel.repaint();
		}
	}

	class SignUpButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent b) {

			String tempItem = eMailT.getText();
			removeAll();
			// JPanel newPanel = new JTablePanel(1);
			JPanel newPanel = new JTabbedPanel();
			add(newPanel);
			revalidate();
			// newPanel.repaint();
		}
	}

}
