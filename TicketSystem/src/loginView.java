
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class loginView extends JFrame {
	
	//attributes
	JTextField user = null;
	JPasswordField pass = null;
	private GridBagConstraints gridConstraints;
	
	//constructor
	public loginView(){
		
		loginModel logModel = new loginModel();
		loginControl logControl = new loginControl(this, logModel);
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("Ticket System Login");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//set Panels on the window and respective layout managers
		JPanel loginWrapPanel = new JPanel(new GridBagLayout());
		this.add(loginWrapPanel);
		
		this.gridSet();
		//top grid panel and components
		JLabel userLabel = new JLabel("User: ");
		loginWrapPanel.add(userLabel, gridConstraints);
		gridConstraints.gridwidth = 50;
		gridConstraints.gridx = 2;
		user = new JTextField(""); //set field size when finish
		loginWrapPanel.add(user, gridConstraints);		
		
		//mid grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		JLabel passLabel = new JLabel("Password: ");
		loginWrapPanel.add(passLabel, gridConstraints);
		gridConstraints.gridwidth = 30;
		gridConstraints.gridx = 2;
		pass = new JPasswordField(""); //set field size when finish
		pass.addActionListener(logControl);
		loginWrapPanel.add(pass, gridConstraints);
		
		//fills space for better visualisation of the frame
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		JLabel gapLabel = new JLabel();
		loginWrapPanel.add(gapLabel, gridConstraints);
		
		//bot grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 4;
		JButton logBtn = new JButton("Login");
		logBtn.addActionListener(logControl);
		logBtn.setActionCommand("logBtn");
		loginWrapPanel.add(logBtn, gridConstraints);		
		
		//closing window optionPane with direct import
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			//@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if(JOptionPane.showConfirmDialog(loginWrapPanel,
					 "Are you sure to close this window?", "Really Closing?",
					 JOptionPane.YES_NO_OPTION,
					 JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					 System.exit(0);
				}
			} //windowClosing()
		}); //addWindowListener()
		
		//this.pack();

		validate();
    	repaint();
		
	} //loginView()
	
	//grid settings
		public void gridSet(){		
			// You create a GridBagContraints object that defines
	        // defaults for your components
	        gridConstraints = new GridBagConstraints();
	        // Define the x position of the component
	        gridConstraints.gridx = 1;
	        // Define the y position of the component
	        gridConstraints.gridy = 1;
	        // Number of columns the component takes up
	        gridConstraints.gridwidth = 1;
	        // Number of rows the component takes up
	        gridConstraints.gridheight = 1;
	        // Gives the layout manager a hint on how to adjust
	        // component width (0 equals fixed)
	        gridConstraints.weightx = 20;
	        // Gives the layout manager a hint on how to adjust
	        // component height (0 equals fixed)
	        gridConstraints.weighty = 100;
	        // Defines padding top, left, bottom, right
	        gridConstraints.insets = new Insets(2,5,2,5);
	        // Defines where to place components if they don't
	        // fill the space: CENTER, NORTH, SOUTH, EAST, WEST
	        // NORTHEAST, etc.
	        gridConstraints.anchor = GridBagConstraints.CENTER;
	        // How should the component be stretched to fill the
	        // space: NONE, HORIZONTAL, VERTICAL, BOTH
			gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		}//gridSet()
} //loginView
