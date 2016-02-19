package LayOut;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Tables.LadyBugData;
import java.awt.GridLayout;
import java.util.ArrayList; 

public class ReportPanel extends JPanel {
	
	private JLabel infoL = new JLabel(); 
	private JLabel statusL = new JLabel ("Status:  ", SwingConstants.RIGHT); 
	private JLabel assigneeL = new JLabel ("     Assignee:  ", SwingConstants.RIGHT); 
	//private JLabel titleL = new JLabel ("     Title:  ", SwingConstants.RIGHT); 
	private JComboBox statusDrop; 
	private JComboBox assigneeDrop; 
	//private JTextField titleT = new JTextField (45);
	//private JButton submitB = new JButton ("Submit"); 
	private JButton backB = new JButton ("Back"); 
	LadyBugData rsList = new LadyBugData();
	ArrayList<Tables.user> arrayList = new ArrayList<Tables.user>(rsList.LadyBugUser());
	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;

	public ReportPanel() {
		setLayout(new BorderLayout());
		statusDrop = new JComboBox(rsList.buildDropDownArray(statusNo));
		assigneeDrop = new JComboBox(rsList.buildDropDownArray(roleNo));
		
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
		centerP.add(statusL); 
		c.gridx = 1; 
		c.gridy = 0; 
		c.gridwidth = 2; 
		centerP.add(statusDrop);
		c.gridx = 0; 
		c.gridy = 1; 
		c.gridwidth = 1; 
		centerP.add(assigneeL); 
		c.gridx = 1; 
		c.gridy = 1; 
		c.gridwidth = 2; 
		centerP.add(assigneeDrop); 
		c.gridx = 0; 
		c.gridy = 0; 
		c.gridwidth = 1; 
		add(centerP, BorderLayout.CENTER); 
		JPanel bottomP = new JTablePanel();  
		add(bottomP, BorderLayout.SOUTH); 
		setSize(800,800); 
		setVisible(true); 
		

	

	}
	

}
