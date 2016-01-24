package LayOut;

import javax.swing.JPanel;

public class DetailPanel extends JPanel{

	public DetailPanel() {
		buildDetail();
	}
	
	public DetailPanel(String input) {
		switch (input.toUpperCase()) {
		case "ADDB":
			buildDetail();
			break;
		case "EDITB":
			break;
		case "DELETEB":
			break;
		case "DETAILB":
			break;
		case "BACK":
			break;
		}
	}
	
	
	public void buildDetail() {
		
	}
	
	
	public void processADDB() {
		
	}
}
