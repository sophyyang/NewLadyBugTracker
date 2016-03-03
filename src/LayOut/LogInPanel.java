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

import Tables.LadyBugData;

public class LogInPanel extends JPanel {

	private JLabel eMailL;
	private JTextField eMailT;
//	private JLabel passwordL;
//	private JTextField passwordT;
	private JButton signInB;
	private JButton signUpB;
	LadyBugData rsList = new LadyBugData();

	public LogInPanel() {
		JPanel panel = new JPanel(new GridLayout(6, 0));

		eMailL = new JLabel("Email Address: ");
		panel.add(eMailL);

		eMailT = new JTextField(50);
		panel.add(eMailT);

//		passwordL = new JLabel("Password: ");
//		panel.add(passwordL);

//		passwordT = new JTextField(50);
//		panel.add(passwordT);

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

			String tempItem = " WHERE eMailAdd = '" + eMailT.getText().trim() + "' ";
			String userName = " ";
			int requestID = 1;
			String[] dataValues = new String[rsList.getUserList(tempItem).size()];
			if (dataValues.length == 1 ) {
				userName =  (rsList.getUserList(tempItem).get(0).getFirstName() + " " + rsList.getUserList(tempItem).get(0).getLastName());
				requestID = (rsList.getUserList(tempItem).get(0).getUserID());
				//System.out.println("userid=" + userID);
			}
			removeAll();
			JPanel newPanel = new BugTicketPanel(userName, requestID);
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
			JPanel newPanel = new DetailPanel("USER", "ADDB", "0");
			newPanel.setSize(700, 500);
			//JPanel newPanel = new JTablePanel(0);
			//JPanel newPanel = new JTabbedPanel();
			add(newPanel);
			revalidate();
			// newPanel.repaint();
		}
	}

}
