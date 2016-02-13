package LayOut;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Mary Larsen
public class BugTicketPanel extends JPanel {
	//test push
	String[] PriorityID = { "High", "Medium", "Low" };
	String[] UserID = { "MLarsen3@dmacc.edu" };
	String TicketNo = "1";
	String[] StatusID = { "New", "Assigned", "Closed" };

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
	JTextField desc = new JTextField(500);

	JButton admin = new JButton("Admin");
	JButton report = new JButton("Report");
	JButton submit = new JButton("Submit");
	JButton logout = new JButton("Logout");

	// Still need to add the connection ?
	// LadyBugData ladybugdata = new LadyBugData();

	public BugTicketPanel() {

		ButtonListener b = new ButtonListener();
		admin.addActionListener(b);
		report.addActionListener(b);
		submit.addActionListener(b);
		logout.addActionListener(b);

		setLayout(new BorderLayout());

		title.setFont(new Font("Serif", Font.PLAIN, 16));
		add(title, BorderLayout.NORTH);

		JPanel buttonLabels = new JPanel(new GridLayout(2, 0));
		JPanel textBoxes = new JPanel(new GridLayout(2, 0));

		buttonLabels.add(ticketNoLabel);
		textBoxes.add(ticketNo);
		buttonLabels.add(userIdLabel);
		textBoxes.add(userId);
		buttonLabels.add(priorityLabel);
		textBoxes.add(priority);
		buttonLabels.add(statusLabel);
		buttonLabels.add(status);
		buttonLabels.add(titleLabel);
		textBoxes.add(title);
		buttonLabels.add(descLabel);
		textBoxes.add(desc);

		add(buttonLabels, BorderLayout.WEST);
		add(textBoxes, BorderLayout.CENTER);

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

			}

			if (e.getSource() == report) {

			}

			if (e.getSource() == submit) {

				System.out.println("Add new defect ticket to database");
			}

			if (e.getSource() == logout) {

			}

		}

	}

}
