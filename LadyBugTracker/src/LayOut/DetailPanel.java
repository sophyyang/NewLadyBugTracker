package LayOut;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
	private JButton submit = new JButton("Submit");
	private JButton back = new JButton("Back");
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

		buildDetail();

	}

	public void buildDetail() {
		setLayout(new BorderLayout());

		retriveRecrod();

		idL.setText(userAction.substring(0, (userAction.length() - 1)) + " " + idL.getText());
		idL.setFont(new Font("Serif", Font.PLAIN, 36));
		idT.setFont(new Font("Serif", Font.PLAIN, 36));
		classL.setFont(new Font("Serif", Font.PLAIN, 36));
		JPanel topP = new JPanel();
		topP.add(classL);
		topP.add(idL);
		topP.add(idT);
		add(topP, BorderLayout.NORTH);

		JPanel centerP = new JPanel();
		centerP.setLayout(new GridLayout(2, 1));
		centerP.add(descL);
		centerP.add(descT);
		centerP.add(orderL);
		centerP.add(orderT);
		add(centerP, BorderLayout.CENTER);

		JPanel bottomP = new JPanel();
		ButtonListener b = new ButtonListener();
		submit.addActionListener(b);
		back.addActionListener(b);
		bottomP.add(submit);
		bottomP.add(back);
		add(bottomP, BorderLayout.SOUTH);
		setSize((iWidth), (iHight));
		setVisible(true);

	}

	public void retriveRecrod() {
		LadyBugData rsList = new LadyBugData();
		
		if (userInputStr.equals("USER")) {
			 ArrayList<Tables.user> arrayList = new ArrayList<Tables.user>(rsList.LadyBugUser(selectedID));
			 if (arrayList.size() == 1) {
				 
			 }
		}else {
			 ArrayList<Tables.dropdownitems> arrayList = new ArrayList<Tables.dropdownitems>(rsList.LadyBugDropDownList(selectedID));
			 if (arrayList.size() == 1) {
				 idT.setText(Integer.toString(arrayList.get(0).getID())); 
				 descT.setText(arrayList.get(0).getDescription());	
				 orderT.setText(Integer.toString(arrayList.get(0).getiOrder()));
				 classL.setText(userInputStr+ "  ====  ");					 
			 }
			
		}
		
 
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == submit) {
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

			if (e.getSource() == back) {
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
