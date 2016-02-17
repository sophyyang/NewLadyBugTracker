package LayOut;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

// MARY LARSEN //
public class BugTicketPanel extends JPanel {

	Container c = getRootPane();
	Tables.LadyBugData lbdata = new Tables.LadyBugData();	 
	
 	//* UNABLE TO GET TABLE DATA INTO DROPDOWNS; HARD CODED BELOW FOR NOW
	String[] PriorityID = { "High", "Middle", "Low" };
	String[] UserID = { "MLarsen3@dmacc.edu", "Test@dmacc.edu" };
	String TicketNo = "1";
	String[] StatusID = { "New", "In Progress", "Reassign", "Closed" };

	JLabel ticketNoLabel = new JLabel("Ticket No.");
	JLabel ticketNo = new JLabel(TicketNo);
	JLabel userIdLabel = new JLabel("User ID");
	JComboBox userId = new JComboBox(UserID);
	JLabel priorityLabel = new JLabel("Priority");
	JComboBox priority = new JComboBox(PriorityID);
	JLabel statusLabel = new JLabel("Status");
	JComboBox status = new JComboBox(StatusID);
	JLabel titleLabel = new JLabel("Title");
	JTextField title = new JTextField(45);
	JLabel descLabel = new JLabel("Description");
	JTextField desc = new JTextField(50);

	JButton admin = new JButton("Admin");
	JButton report = new JButton("Report");
	JButton submit = new JButton("Submit");
	JButton logout = new JButton("Logout");

	
	public BugTicketPanel() {

		ButtonListener b = new ButtonListener();
		admin.addActionListener(b);
		report.addActionListener(b);
		submit.addActionListener(b);
		logout.addActionListener(b);
		
		//* ADD TITLES & TEXT BOXES TO THE SCREEN
		setLayout(new BorderLayout());

		JPanel buttonLabels = new JPanel(new GridLayout(15, 0));
		JPanel textBoxes = new JPanel(new GridLayout(15, 0));

		buttonLabels.add(ticketNoLabel);
		textBoxes.add(ticketNo);
		buttonLabels.add(userIdLabel);
		textBoxes.add(userId);
		buttonLabels.add(priorityLabel);
		textBoxes.add(priority);
		buttonLabels.add(statusLabel);
		textBoxes.add(status);
		buttonLabels.add(titleLabel);
		textBoxes.add(title);
		buttonLabels.add(descLabel);
		textBoxes.add(desc);

		add(buttonLabels, BorderLayout.WEST);
		add(textBoxes, BorderLayout.CENTER);

		//* ADD BUTTONS TO BOTTOM OF SCREEN
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		buttonPanel.add(admin);
		buttonPanel.add(report);
		buttonPanel.add(submit);
		buttonPanel.add(logout);

		add(buttonPanel, BorderLayout.SOUTH);

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == admin) {
				removeAll();
				JPanel newPanel = new MainPanel(); 	//* CHANGES TO ADMIN PANEL
				add(newPanel);
				revalidate();
				newPanel.repaint();
				System.out.println("Admin button selected");
			}

			if (e.getSource() == report) {
				removeAll();
				JPanel newPanel = new MainPanel(); 	//* CHANGE TO REPORT PANEL
				add(newPanel);
				revalidate();
				newPanel.repaint();
				System.out.println("Report button selected");
			}

			if (e.getSource() == submit) {

				System.out.println("Submit button selected.  Add new ticket to database");
			}

			if (e.getSource() == logout) {
				removeAll();
				JPanel newPanel = new MainPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
				System.out.println("Logout button selected");
			}

		}

	}

}
