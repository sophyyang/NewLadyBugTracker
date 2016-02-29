package LayOut;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LayOut.DetailPanel.ButtonListener;
import Tables.LadyBugData;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class ReportPanel extends JPanel {

	private JLabel infoL = new JLabel();
	// private JLabel statusL = new JLabel("Status: ", SwingConstants.RIGHT);
	// private JLabel assigneeL = new JLabel(" Assignee: ",
	// SwingConstants.RIGHT);
	private JLabel statusL = new JLabel("    Status: ", SwingConstants.RIGHT);
	private JLabel assigneeL = new JLabel("  Assignee: ", SwingConstants.RIGHT);
	private JLabel roleL = new JLabel("      Role: ", SwingConstants.RIGHT);
	// private JLabel titleL = new JLabel (" Title: ", SwingConstants.RIGHT);
	private JComboBox statusDrop;
	private JComboBox assigneeDrop;
	private JComboBox roleDrop;
	// private JTextField titleT = new JTextField (45);
	private JButton submitB = new JButton(" == Run == ");
	// private JButton backB = new JButton("Back");
	LadyBugData rsList = new LadyBugData();
	ArrayList<Tables.user> arrayList = new ArrayList<Tables.user>(rsList.LadyBugUser());
	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;
	private String sqlStr;

	private static final Insets insets = new Insets(0, 0, 0, 0);

	public ReportPanel() {
		this("List All");
	}

	public ReportPanel(String sqlStr) {
		setLayout(new BorderLayout());
		statusDrop = new JComboBox(rsList.buildDropDownArray1(statusNo, 1));
		roleDrop = new JComboBox(rsList.buildDropDownArray1(roleNo, 1));
		assigneeDrop = new JComboBox(rsList.buildUserDropDownArray1(1));
		ButtonListener b = new ButtonListener();
		statusDrop.addActionListener(b);
		roleDrop.addActionListener(b);
		assigneeDrop.addActionListener(b);
		reportListener r = new reportListener();
		submitB.addActionListener(r);

		JPanel topP = new JPanel();
		infoL.setText("Filter to Run Report");
		infoL.setFont(new Font("Serif", Font.PLAIN, 32));

		topP.add(infoL);
		add(topP, BorderLayout.NORTH);
		JPanel centerP = new JPanel();
		centerP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		centerP.add(assigneeL, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		centerP.add(assigneeDrop, c);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		centerP.add(statusL, c);
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 2;
		centerP.add(statusDrop, c);
		c.gridx = 6;
		c.gridy = 0;
		c.gridwidth = 1;
		centerP.add(roleL, c);
		c.gridx = 7;
		c.gridy = 0;
		c.gridwidth = 2;
		centerP.add(roleDrop, c);
		c.gridx = 9;
		c.gridy = 0;
		c.gridwidth = 2;
		centerP.add(submitB, c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(centerP, BorderLayout.CENTER);
		JPanel bottomP = new JTablePanel(4, sqlStr);
		add(bottomP, BorderLayout.SOUTH);
		setSize(800, 800);
		setVisible(true);

	}

	public static void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth,
			int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0, anchor, fill,
				insets, 0, 0);
		container.add(component, gbc);
	}

	class reportListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			removeAll();
			if (sqlStr != null) {
				if (sqlStr.trim().length() > 0) {
					sqlStr = " WHERE " + sqlStr;					 
				}
			} else {
				sqlStr = " ";
			}
			JPanel newPanel = new ReportPanel(sqlStr);				
			add(newPanel);
			// newPanel.setSize(iWidth, iHight);
			newPanel.revalidate();
			newPanel.repaint();

		}

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			sqlStr = " ";

			if (!statusDrop.getSelectedItem().equals("List All")) {
				sqlStr += " Status = '" + statusDrop.getSelectedItem().toString().trim() + "' ";
			}

			if (!roleDrop.getSelectedItem().equals("List All")) {
				if (sqlStr.trim().length() > 0) {
					sqlStr += " AND ";
				}
				sqlStr += " Role = '" + roleDrop.getSelectedItem().toString().trim() + "' ";
			}

			if (!assigneeDrop.getSelectedItem().equals("List All")) {
				if (sqlStr.trim().length() > 0) {
					sqlStr += " AND ";
				}

				String inputT = assigneeDrop.getSelectedItem().toString().trim();
				String[] tempT;
				tempT = inputT.split(" ", 2);
				sqlStr += " Requester_First_Name = '" + tempT[0];
				sqlStr += "' AND Requester_Last_Name = '" + tempT[1] + "' ";


			}

		}
	}

}
