package LayOut;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tables.LadyBugData;

public class DetailPanel extends JPanel {
	private JLabel idL = new JLabel("ID:");
	private JLabel idT = new JLabel("");
	private JLabel classL = new JLabel("");
	private JLabel descL = new JLabel("Desciption: ");
	private JTextField descT = new JTextField(20);
	private JLabel orderL = new JLabel("Order:");
	private JTextField orderT = new JTextField(3);
	private JLabel fNameL = new JLabel("First Name: ");
	private JLabel lNameL = new JLabel("Last Name:");
	private JLabel eMailL = new JLabel("eMail: ");
	private JLabel roleL = new JLabel("Role: ");
	private JLabel dateCreatedL = new JLabel("Date Created:");
	private JLabel lastModifiedL = new JLabel("Last Modified: ");
	private JLabel dateCreatedT = new JLabel();
	private JLabel lastModifiedT = new JLabel();
	private JTextField fNameT = new JTextField(20);
	private JTextField lNameT = new JTextField(20);
	private JTextField eMailT = new JTextField(20);
	private JTextField roleT = new JTextField(10);
	private JButton submitB = new JButton("Submit");
	private JButton backB = new JButton("Back");
	String userAction;
	String userInputStr;
	int userInputInt;
	int iWidth = 600;
	int iHight = 500;
	final String ADDB = "ADDB";
	final String EDITB = "EDITB";
	final String DELETEB = "DELETEB";
	final String DETAILB = "DETAILB";
	final String BACK = "BACK";
	private String selectedID;
	private JComboBox itemsDropDown;

	public DetailPanel() {
		userInputStr = "USER";
		userInputInt = 0;
		userAction = "DETAILB";
		selectedID = "1";
		buildDetail();
	}

	public DetailPanel(String input, String action, String ID) {
		userInputStr = input.toUpperCase();
		userAction = action.toUpperCase();
		selectedID = ID;

		switch (userAction) {
		case ADDB:
			break;
		case EDITB:
			break;
		case DELETEB:
			break;
		case DETAILB:
			break;
		case BACK:
			break;
		}
		switch (userInputStr) {
		case "USER":
			userInputInt = 0;
			break;
		case "STATUS":
			userInputInt = 1;
			break;
		case "ROLE":
			userInputInt = 2;
			break;
		case "PRIORITY":
			userInputInt = 3;
			break;
		}
		buildDetail();

	}

	public void buildDetail() {
		try {
			setLayout(new BorderLayout());
			itemsDropDown = new JComboBox(this.buildDropDownArray(2));

			retriveRecrod();

			JPanel topP = new JPanel();
			idL.setText(userAction.substring(0, (userAction.length() - 1)) + " " + idL.getText());
			idL.setFont(new Font("Serif", Font.PLAIN, 36));
			idT.setFont(new Font("Serif", Font.PLAIN, 36));

			switch (userInputStr) {
			case "USER":
				topP.add(classL);
				topP.add(idL);
				topP.add(idT);
				break;
			default:
				classL.setFont(new Font("Serif", Font.PLAIN, 36));
				topP.add(classL);
				topP.add(idL);
				topP.add(idT);
				break;
			}

			add(topP, BorderLayout.NORTH);
			JPanel centerP = new JPanel();

			switch (userInputStr) {
			case "USER":
				centerP.setLayout(new GridLayout(6, 1));
				centerP.add(fNameL);
				centerP.add(lNameL);
				centerP.add(fNameT);
				centerP.add(lNameT);
				centerP.add(eMailL);
				centerP.add(eMailT);
				centerP.add(roleL);
				centerP.add(itemsDropDown);
				centerP.add(dateCreatedL);
				centerP.add(dateCreatedT);
				centerP.add(lastModifiedL);
				centerP.add(lastModifiedT);
				break;
			default:
				centerP.setLayout(new GridLayout(2, 1));
				centerP.add(descL);
				centerP.add(descT);
				centerP.add(orderL);
				centerP.add(orderT);
				break;
			}

			add(centerP, BorderLayout.CENTER);

			JPanel bottomP = new JPanel();
			ButtonListener b = new ButtonListener();
			submitB.addActionListener(b);
			backB.addActionListener(b);
			bottomP.add(submitB);
			bottomP.add(backB);
			add(bottomP, BorderLayout.SOUTH);
			setSize((iWidth), (iHight));
			setVisible(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Object[] buildDropDownArray(int input) throws SQLException {
		LadyBugData rsList = new LadyBugData();
		Object[] outArray = new String[rsList.LadyBugItems(input).size()];
		for (int r = 0; r < rsList.LadyBugItems(input).size(); r++) {
			outArray[r] = rsList.LadyBugItems(input).get(r).getDescription();
		}
		return outArray;
	}

	public void retriveRecrod() {
		LadyBugData rsList = new LadyBugData();

		if (userInputInt == 0) {
			ArrayList<Tables.user> arrayList = new ArrayList<Tables.user>(rsList.LadyBugUser(selectedID));
			if (arrayList.size() == 1) {
				idT.setText(Integer.toString(arrayList.get(0).getUserID()));
				fNameT.setText(arrayList.get(0).getFirstName());
				lNameT.setText(arrayList.get(0).getLastName());
				eMailT.setText(arrayList.get(0).geteMailAdd());
				dateCreatedT.setText(arrayList.get(0).getCreatedDate().toString());
				lastModifiedT.setText(arrayList.get(0).getLastModified().toString());
			} else if (userAction.equals("ADDB")) {
				dateCreatedT.setText(rsList.currentDateTimeToString());
				lastModifiedT.setText(rsList.currentDateTimeToString());
			}
		} else {
			ArrayList<Tables.dropdownitems> arrayList = new ArrayList<Tables.dropdownitems>(
					rsList.LadyBugDropDownList(selectedID));
			if (arrayList.size() == 1) {
				idT.setText(Integer.toString(arrayList.get(0).getID()));
				descT.setText(arrayList.get(0).getDescription());
				orderT.setText(Integer.toString(arrayList.get(0).getiOrder()));
				classL.setText(userInputStr + "  ====  ");
			}

		}

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == submitB) {
				removeAll();
				System.out.println("remove all");
				JTablePanel newPanel = new JTablePanel(userInputStr);
				System.out.println("will add new Pnael");
				add(newPanel);
				System.out.println("Done added");
				revalidate();

				// newPanel.repaint();
				// System.out.println(store.getSelectedItem());
				// String tempStore = store.getSelectedItem().toString();
				//
				// String tempItem = item.getText();
				//
				// ListItem t = new ListItem(tempStore, tempItem);
				// itemDAO.insertNewItem(t);
				//
				// item.setText("");
				//
				// System.out.println("Add new item to database");
			}

			if (e.getSource() == backB) {
				removeAll();
				JTablePanel newPanel = new JTablePanel(userInputStr);
				add(newPanel);
				newPanel.setSize(iWidth, iHight);
				newPanel.revalidate();
				newPanel.repaint();
			}
		}

	}

}
