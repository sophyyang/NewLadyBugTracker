package LayOut;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;


public class JTableFrame extends JFrame {

	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;
	
	//Constructor
	public JTableFrame() {
		
		setTitle("Lady Bug Tracker");
		setSize(300,200);
		setBackground(Color.lightGray);
		
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);
		
		String columnNames[] = {"Column 1", "Column 2", "Column 3" };
		String dataValues[][] = {
				{ "12", "234", "67" },
				{ "-123", "43", "853" },
				{ "93", "89.2", "109" },
				{ "279", "9033", "3092" }			
		};
		
		table = new JTable(dataValues, columnNames);
		scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
	public static void main(String args[]) {
		JTableFrame mainFrame = new JTableFrame();
		mainFrame.setVisible(true);
	}
	
}
