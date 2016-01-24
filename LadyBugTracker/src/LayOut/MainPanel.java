package LayOut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MainPanel extends JPanel{
	JButton view = new JButton("View List");
	JButton add = new JButton("Add Items");
	JButton sort = new JButton("Sort List");
	
	public MainPanel(){

		add(view);
		add(add);
		add(sort);
		
		ButtonHandler handler = new ButtonHandler();
		view.addActionListener(handler);
		add.addActionListener(handler);
		sort.addActionListener(handler);
		
	}
	
	class ButtonHandler implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			
                if (e.getSource() == view) {  
 
                	removeAll();  
                    JPanel newPanel=new ViewListPanel();  
                    add(newPanel);
                    revalidate();  
                
                }
//                if (e.getSource() == add) {
//                	removeAll();
//                    JPanel newPanel=new AddItemsPanel();
//                    add(newPanel);
//                    revalidate();
//                    
//                }
//                if (e.getSource() == sort) {
//                    removeAll();
//                    JPanel newPanel=new SortListPanel();
//                    add(newPanel);
//                    revalidate();
//                  
//            }
                
        }

}


}
