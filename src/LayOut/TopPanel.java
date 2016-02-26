package LayOut;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {

	private final int bFontSize = 36;
	private JLabel titleL = new JLabel("<< Lady Bugs Tracker >>");
	private BufferedImage image;
	private MainPanel mainPanel;
	
	public TopPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		
		try {
			image = ImageIO.read(new File("images/LadyBugs.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(image));
			picLabel.setPreferredSize(new Dimension(120, 70));
			titleL.setFont(new Font("Times New Roman", Font.PLAIN, bFontSize ));
			add(picLabel);
			add(titleL);
			
			JButton home = new JButton("Home");
			BackButtonListener h = new BackButtonListener();
			home.addActionListener(h);
			add(home);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	class BackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent h) {
			mainPanel.HomeButton();
		}
	}

}
