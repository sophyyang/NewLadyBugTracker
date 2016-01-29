package LayOut;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPanel extends JPanel {

	public JTabbedPanel() {
		super(new BorderLayout());
		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel userB = new JPanel();
		userB.add(createTableB("user"));
		tabbedPane.addTab("User List", userB);

		JPanel roleB = new JPanel();
		roleB.add(createTableB("role"));
		tabbedPane.addTab("Role Table", roleB);

		JPanel statusB = new JPanel();
		statusB.add(createTableB("Status"));
		tabbedPane.addTab("Status Table", statusB);

		JPanel priorityB = new JPanel();
		priorityB.add(createTableB("priority"));
		tabbedPane.addTab("Priority Table", priorityB);
		
		// Add tabbedPane to this panel.
		add(tabbedPane, BorderLayout.CENTER);
	}

	protected JPanel createTableB(String input) {
		JPanel pane = new JTablePanel(input);
		return pane;
	}
}
