package LayOut;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*
 * View shopping list
 * JList on textbox page 413
 */

public class ViewListPanel extends JPanel {
	Container c = getRootPane();

 
	Tables.LadyBugData itemDAO = new Tables.LadyBugData();
	JLabel title = new JLabel("VIEW SHOPPING LIST");

	ArrayList<Tables.user> listModel = new ArrayList<Tables.user>(itemDAO.LadyBugUser());
 	JList list = new JList(listModel.toArray()); // toArray will turn it to
													// Array

	JScrollPane scroll = new JScrollPane(list);
	JButton back = new JButton("Back");
	JButton remove = new JButton("Remove item");

	public ViewListPanel() {
		title.setFont(new Font("Serif", Font.PLAIN, 16));
 
		setLayout(new BorderLayout());

 		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(350, 100));

		add(title, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		ButtonListener l = new ButtonListener();
		back.addActionListener(l);
		remove.addActionListener(l);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(back);
		buttonPanel.add(remove);

		add(buttonPanel, BorderLayout.SOUTH);

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new MainPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint(); // ?? don't need repaint??
			}

			if (e.getSource() == remove) {
				int index = list.getSelectedIndex();
				System.out.println(list.getSelectedValue());

				if (index != -1) {
					Tables.user tempItem = listModel.get(index);
					//itemDAO.deleteItem(tempItem);
					listModel.remove(index);
					list.setListData(listModel.toArray());
					
					scroll.revalidate();
					scroll.repaint();
				}
				System.out.println("Remove selected object");
			}

		}

	}

}
