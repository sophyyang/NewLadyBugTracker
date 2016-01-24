package LayOut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Tables.ItemList;
import Tables.LadyBugData;
import Tables.user;

public class JTablePanel extends JPanel {
	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;
	private final int fondSize =15;

	// Constructor
	public JTablePanel() {

		setSize(1000, 600);
		setBackground(Color.lightGray);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		add(topPanel);

		LadyBugData rsList = new LadyBugData();
		Tables.user u = new Tables.user();
		ArrayList<user> arrayList = new ArrayList<user>(rsList.LadyBugUser());

		String columnNames[] = u.getColumnNames();
		String[][] dataValues = new String[arrayList.size()][7];
		for (int r = 0; r < arrayList.size(); r++) {
			dataValues[r][0] = Integer.toString(arrayList.get(r).getUserID());
			dataValues[r][1] = arrayList.get(r).getFirstName();
			dataValues[r][2] = arrayList.get(r).getLastName();
			dataValues[r][3] = arrayList.get(r).geteMailAdd();
			dataValues[r][4] = arrayList.get(r).getRoleDescription();
			dataValues[r][5] = rsList.DateToString(arrayList.get(r).getCreatedDate());
			dataValues[r][6] = rsList.DateToString(arrayList.get(r).getLastModified());
		}

		table = new JTable(dataValues, columnNames);
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		topPanel.add(scrollPane, BorderLayout.CENTER);

	}

	public JTablePanel(String input) {
		switch (input.toUpperCase()) {
		case "USER":
			userJTablePanel();
			break;
		case "ROLE":
			roleJTablePanel();
			break;
		}
	}

	public void userJTablePanel() {
		setSize(1000, 600);
		setBackground(Color.lightGray);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		add(topPanel);
		LadyBugData rsList = new LadyBugData();
		Tables.user u = new Tables.user();
		ArrayList<user> arrayList = new ArrayList<user>(rsList.LadyBugUser());

		String columnNames[] = u.getColumnNames();
		String[][] dataValues = new String[arrayList.size()][7];
		for (int r = 0; r < arrayList.size(); r++) {
			dataValues[r][0] = Integer.toString(arrayList.get(r).getUserID());
			dataValues[r][1] = arrayList.get(r).getFirstName();
			dataValues[r][2] = arrayList.get(r).getLastName();
			dataValues[r][3] = arrayList.get(r).geteMailAdd();
			dataValues[r][4] = arrayList.get(r).getRoleDescription();
			dataValues[r][5] = rsList.DateToString(arrayList.get(r).getCreatedDate());
			dataValues[r][6] = rsList.DateToString(arrayList.get(r).getLastModified());
		}

		table = new JTable(dataValues, columnNames);
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFont(new Font("Times New Roman", Font.PLAIN,fondSize ));
		table.setPreferredScrollableViewportSize(new Dimension(450, 63));
		table.setFillsViewportHeight(true);

		topPanel.add(scrollPane, BorderLayout.CENTER);

	}

	public void roleJTablePanel() {
		setSize(1000, 600);
		setBackground(Color.lightGray);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		add(topPanel);

		try {
			LadyBugData rsList = new LadyBugData();
			Tables.ItemList u = new Tables.ItemList();
			ArrayList<ItemList> arrayList = new ArrayList<ItemList>(rsList.LadyBugItems(roleNo));

			DefaultTableModel tableModel = new DefaultTableModel(u.getColumnNames(), 0);
			JTable table = new JTable(tableModel);

			for (int r = 0; r < arrayList.size(); r++) {
				String ID = Integer.toString(arrayList.get(r).getID());
				String description = arrayList.get(r).getDescription();
				String iClass = arrayList.get(r).getiClass();
				String iOrder = Integer.toString(arrayList.get(r).getiOrder());
				Object[] data = { ID, description, iClass, iOrder };

				tableModel.addRow(data);
			}

			scrollPane = new JScrollPane(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN,fondSize ));
			table.setPreferredScrollableViewportSize(new Dimension(450, 63));
			table.setFillsViewportHeight(true);

			topPanel.add(scrollPane, BorderLayout.CENTER);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		JFrame master = new JFrame();
		 JTablePanel mainPanel = new JTablePanel("user");
		//JTablePanel mainPanel = new JTablePanel("role");
		master.add(mainPanel);

		master.setTitle("Lady Bug Tracker - User Profile");
		master.setBackground(Color.yellow);

		master.setSize(1000, 200);
		master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		master.setVisible(true);

	}

}
