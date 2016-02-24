package LayOut;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tables.LadyBugData;

// MARY LARSEN 
public class BugTicketPanel extends JPanel {

	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;
	private LadyBugData rsList = new LadyBugData();

	// * STILL NEED TO GET TABLE DATA INTO DROPDOWNS; HARD CODED BELOW FOR NOW
	String TicketNo = "1";
	// String[] UserID = { "MLarsen3@dmacc.edu", "Test@dmacc.edu" };
	// String[] priorityNo = { "High", "Middle", "Low" };
	// String[] statusNo = { "New", "In Progress", "Reassign", "Closed" };

	JLabel ticketNoLabel = new JLabel("Ticket No.");
	JLabel ticketNo = new JLabel(TicketNo);

	JLabel userIdLabel = new JLabel("User ID");
	JComboBox userId = new JComboBox();

	JLabel priorityLabel = new JLabel("Priority");
	JComboBox priority = new JComboBox();

	JLabel statusLabel = new JLabel("Status");
	JComboBox status = new JComboBox();

	JLabel titleLabel = new JLabel("Title");
	JTextField title = new JTextField(45);

	JLabel descLabel = new JLabel("Description");
	JTextField desc = new JTextField(50);

	JButton admin = new JButton("Admin");
	JButton report = new JButton("Report");
	JButton submit = new JButton("Submit");
	JButton logout = new JButton("Logout");
	JButton reportB = new JButton("Run Report");

	public BugTicketPanel() {
		// change this one later to userid and user after Sophys changes are in
		userId = new JComboBox(rsList.buildDropDownArray(statusNo));
		// itemsDropDown = new JComboBox(rsList.buildUserDropDownArray(roleNo));
		status = new JComboBox(rsList.buildDropDownArray(statusNo));
		priority = new JComboBox(rsList.buildDropDownArray(priorityNo));

		ButtonListener b = new ButtonListener();
		admin.addActionListener(b);
		report.addActionListener(b);
		submit.addActionListener(b);
		logout.addActionListener(b);

		RunReportListener r = new RunReportListener();
		reportB.addActionListener(r);

		// * ADD TITLES & TEXT BOXES TO THE SCREEN
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

		// * ADD BUTTONS TO BOTTOM OF SCREEN
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		buttonPanel.add(admin);
		buttonPanel.add(report);
		buttonPanel.add(submit);
		buttonPanel.add(logout);
		buttonPanel.add(reportB);

		add(buttonPanel, BorderLayout.SOUTH);

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == admin) {
				removeAll();
				JPanel newPanel = new JTabbedPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
				System.out.println("Admin button selected");
			}

			if (e.getSource() == report) {
				removeAll();
				JPanel newPanel = new MainPanel(); // * CHANGE TO REPORT PANEL
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
				JPanel newPanel = new LogInPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
				System.out.println("Logout button selected");
			}

		}

	}


	class RunReportListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// String tempItem = eMailT.getText();
			removeAll();
			JPanel newPanel = new JTabbedPanel();
			add(newPanel);
			revalidate();
		}
	}
}
