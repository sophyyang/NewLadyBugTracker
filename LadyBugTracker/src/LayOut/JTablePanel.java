package LayOut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import Tables.ItemList;
import Tables.LadyBugData;
import Tables.user;

public class JTablePanel extends JPanel {
	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private final int fontSize = 15;
	private final int iWidth = 600;
	private final int iHight = 500;
	private JButton addB = new JButton("Add New ");
	private JButton editB = new JButton("Submit Edit");
	private JButton deleteB = new JButton("Delete");
	private JButton detailB = new JButton("List Detail");
	private String userInputStr;
	private int userInputInt;
	private String selectedID;
	private String userActionStr;
	private LadyBugData rsList = new LadyBugData();
	private Tables.user u = new Tables.user();
	private Tables.ItemList itemList = new Tables.ItemList();
	private DefaultTableModel tableModel;
	private JComboBox itemsDropDown;
	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;

	// Constructor
	public JTablePanel() {
		userInputStr = "USER";
		userInputInt = 0;
		userJTablePanel();
	}

	public JTablePanel(int input) {
		userInputInt = input;
		switch (input) {
		case 0: // User
			userInputStr = "USER";
			userJTablePanel();
			break;
		default: // Status, Role, Priority
			userInputStr = "ITEMS";
			statusJTablePanel();
			break;
		}
	}

	public JTablePanel(String input) {
		userInputStr = input.toUpperCase();
		switch (userInputStr) {
		case "USER":
			userInputInt = 0;
			userJTablePanel();
			break;
		case "STATUS":
			userInputInt = 1;
			statusJTablePanel();
			break;
		case "ROLE":
			userInputInt = 2;
			statusJTablePanel();
			break;
		case "PRIORITY":
			userInputInt = 3;
			statusJTablePanel();
			break;
		}

	}

	public JScrollPane buildTable() {
		switch (userInputStr) {
		case "USER":
			String columnNames[] = u.getColumnNames();
			String[][] dataValues = new String[rsList.LadyBugUser().size()][7];
			itemsDropDown = new JComboBox(rsList.buildDropDownArray(roleNo));
			for (int r = 0; r < rsList.LadyBugUser().size(); r++) {
				dataValues[r][0] = Integer.toString(rsList.LadyBugUser().get(r).getUserID());
				dataValues[r][1] = rsList.LadyBugUser().get(r).getFirstName();
				dataValues[r][2] = rsList.LadyBugUser().get(r).getLastName();
				dataValues[r][3] = rsList.LadyBugUser().get(r).geteMailAdd();
				dataValues[r][4] = rsList.LadyBugUser().get(r).getRoleDescription();
				dataValues[r][5] = rsList.DateToString(rsList.LadyBugUser().get(r).getCreatedDate());
				dataValues[r][6] = rsList.DateToString(rsList.LadyBugUser().get(r).getLastModified());
			}
			table = new JTable(dataValues, columnNames) {
				DefaultTableCellRenderer colorBlack = new DefaultTableCellRenderer();

				{
					colorBlack.setForeground(Color.BLACK);
				}

				DefaultTableCellRenderer colorText = new DefaultTableCellRenderer();

				{
					colorText.setForeground(Color.RED);
				}

				@Override
				public TableCellRenderer getCellRenderer(int row, int column) {
					if (column == 0 || column == 5 || column == 6) {
						return colorText;
					} else {
						return colorBlack;
					}
				}

				@Override
				public boolean isCellEditable(int row, int column) {
					if (column == 0 || column == 5 || column == 6) {
						return false;
					} else {
						return true;
					}
				}
			};
			break;
		case "ITEMS":
			break;
		}

		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
		table.setPreferredScrollableViewportSize(new Dimension(iWidth, iHight));
		table.setFillsViewportHeight(true);

		return scrollPane;
	}

	public JPanel actionButtons() {
		JPanel buttonPanel = new JPanel();
		ButtonListener b = new ButtonListener();
		addB.addActionListener(b);
		editB.addActionListener(b);
		deleteB.addActionListener(b);
		detailB.addActionListener(b);

		buttonPanel.add(addB);
		buttonPanel.add(editB);
		switch (userInputStr) {
		case "USER":
			buttonPanel.add(deleteB);
			buttonPanel.add(detailB);
			break;
		default:
			break;
		}

		return buttonPanel;

	}

	public void userJTablePanel() {
		setBackground(Color.YELLOW);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		add(topPanel);

		scrollPane = new JScrollPane();
		scrollPane = buildTable();
		topPanel.add(scrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel = actionButtons();
		topPanel.add(buttonPanel, BorderLayout.SOUTH);

	}

	public void statusJTablePanel() {

		switch (userInputInt) {
		case 1:
			setBackground(Color.BLUE);
			break;
		case 2:
			setBackground(Color.GREEN);
			break;
		case 3:
			setBackground(Color.RED);
			break;
		}

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		add(topPanel);

		try {
			tableModel = new DefaultTableModel(itemList.getColumnNames(), 0);
			table = new JTable(tableModel) {
				DefaultTableCellRenderer colorBlack = new DefaultTableCellRenderer();

				{
					colorBlack.setForeground(Color.BLACK);
				}

				DefaultTableCellRenderer colorText = new DefaultTableCellRenderer();

				{
					colorText.setForeground(Color.RED);
				}

				@Override
				public TableCellRenderer getCellRenderer(int row, int column) {
					if (column == 0 || column == 1 || column == 2) {
						return colorText;
					} else {
						return colorBlack;
					}
				}

				@Override
				public boolean isCellEditable(int row, int column) {
					if (column == 0 || column == 1 || column == 2) {
						return false;
					} else {
						return true;
					}
				}
			};

			for (int r = 0; r < rsList.LadyBugItems(userInputInt).size(); r++) {
				String iClass = rsList.LadyBugItems(userInputInt).get(r).getiClass();
				String ID = Integer.toString(rsList.LadyBugItems(userInputInt).get(r).getID());
				String description = rsList.LadyBugItems(userInputInt).get(r).getDescription();
				String iOrder = Integer.toString(rsList.LadyBugItems(userInputInt).get(r).getiOrder());
				Object[] data = { ID, iClass, description, iOrder };

				tableModel.addRow(data);
			}

			scrollPane = new JScrollPane(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
			table.setPreferredScrollableViewportSize(new Dimension(iWidth, iHight));
			table.setFillsViewportHeight(true);
			topPanel.add(scrollPane, BorderLayout.CENTER);

			JPanel buttonPanel = new JPanel();
			buttonPanel = actionButtons();
			topPanel.add(buttonPanel, BorderLayout.SOUTH);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectedID = "0";

			if (e.getSource() == addB) {
				removeAll();
				JPanel newPanel = new DetailPanel(userInputStr, "ADDB", selectedID);
				add(newPanel);
				revalidate();
				newPanel.repaint();

			} else if (table.getSelectedRow() >= 0) {
				int id = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				selectedID = Integer.toString(id);
				if (e.getSource() == editB) {
					if (userInputStr.equals("USER")) {
						String fN = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
						String lN = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
						String eMail = table.getModel().getValueAt(table.getSelectedRow(), 3).toString();
						String roleDesc = table.getModel().getValueAt(table.getSelectedRow(), 4).toString();
						u = new user(id, fN, lN, eMail);
						u.setRoleID(roleDesc);
						rsList.updateUser(u);
					} else {
						int iOrder = Integer
								.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
						itemList = new ItemList(id, iOrder);
						rsList.updateItemOrder(itemList);
					}
					System.out.println("Update item to database");

				} else if (e.getSource() == detailB) {
					userActionStr = "DETAILB";
					removeAll();
					JPanel newPanel = new DetailPanel(userInputStr, userActionStr, selectedID);
					add(newPanel);
					revalidate();
					newPanel.repaint();
				} else {
					userActionStr = "DELETEB";
					int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ID" + id);
					// ans=0 (Yes) and=1 (No) ans=2 (Cancel)
					if (ans == 0) {
						JOptionPane.showMessageDialog(null, "ID" + id + " deleted!");
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Please select a record to continue");
			}
		}

	}

} // end
