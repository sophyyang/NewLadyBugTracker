package LayOut;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tables.LadyBugData;

// MARY LARSEN 
public class BugTicketPanel extends JPanel {
	
	private final int statusNo = 1;
	//private final int roleNo = 2;
	private final int priorityNo = 3;
	private LadyBugData rsList = new LadyBugData();
	//private Tables.bugticket bt = new Tables.bugticket();

	String TicketNo = "1";

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

		// itemsDropDown = new JComboBox(rsList.buildUserDropDownArray(roleNo));
		userId = new JComboBox(rsList.buildUserDropDownArray());
		status = new JComboBox(rsList.buildDropDownArray(statusNo));
		priority = new JComboBox(rsList.buildDropDownArray(priorityNo));

		ButtonListener b = new ButtonListener();
		admin.addActionListener(b);
		report.addActionListener(b);
		submit.addActionListener(b);
		logout.addActionListener(b);

		// * ADD TITLES & TEXT BOXES TO THE SCREEN
		
		//* ADD TITLES & TEXT BOXES TO THE SCREEN
		RunReportListener r = new RunReportListener();
		reportB.addActionListener(r);
		
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
				JPanel newPanel = new ReportPanel();
				// JPanel newPanel = new LogInPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
				System.out.println("Report button selected");
			}

			if (e.getSource() == submit) {
				String user = userId.getSelectedItem().toString();
				int startSpace = user.indexOf("-");
				int endSpace = user.lastIndexOf(" ");
				String first = "";
				String last = "";
				if (startSpace > 0) {
					first = user.substring(startSpace + 2, endSpace);
					if (endSpace > startSpace) {
						last = user.substring(endSpace + 1, user.length());
					}
				}
				int u = rsList.selectUser(first, last);
				//int tempU = bt.getUserID();
				//System.out.println("getUserID tempU value is  " + tempU);
				
				String p = priority.getSelectedItem().toString();
				int priorityId = rsList.selectPriority(p);
				
				String s = status.getSelectedItem().toString();
				int statusId = rsList.selectStatus(s);
				
				String t = title.getText();
				String d = desc.getText();
				
				//* UPDATE TABLES  
				int key = rsList.insertNewTicket(u, t, d);
				rsList.insertNewHistory(key, u, statusId, priorityId, d);
				
				//* CLEAR TEXT FIELDS
				title.setText("");
				desc.setText("");
				
				System.out.println("Submit button selected.  Add new ticket to database");
			}

			if (e.getSource() == logout) {
				//close window after click on logout button
				System.exit(0);
//				removeAll();
//				JPanel newPanel = new LogInPanel();
//				add(newPanel);
//				revalidate();
//				newPanel.repaint();
//				System.out.println("Logout button selected");
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
