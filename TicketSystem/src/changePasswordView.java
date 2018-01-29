
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class changePasswordView extends JFrame {
	
	//attributes
	JPasswordField pass = null;
	JPasswordField rePass = null;
	private GridBagConstraints gridConstraints;
	
	//constructor
	public changePasswordView(adminControl temp){
		
		changePasswordModel changePassModel = new changePasswordModel(temp);
		changePasswordControl changePassControl = new changePasswordControl(this, changePassModel);
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("New Password");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//set Panels on the window and respective layout managers
		JPanel loginWrapPanel = new JPanel(new GridBagLayout());
		this.add(loginWrapPanel);
		
		this.setGrid();
		//top grid panel and components
		JLabel userLabel = new JLabel("Type new Password: ");
		loginWrapPanel.add(userLabel, gridConstraints);
		gridConstraints.gridwidth = 50;
		gridConstraints.gridx = 2;
		pass = new JPasswordField(20); //set field size when finish
		loginWrapPanel.add(pass, gridConstraints);		
		
		//mid grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		JLabel passLabel = new JLabel("Re-type new Password: ");
		loginWrapPanel.add(passLabel, gridConstraints);
		gridConstraints.gridwidth = 30;
		gridConstraints.gridx = 2;
		rePass = new JPasswordField(20); //set field size when finish
		rePass.addActionListener(changePassControl);
		loginWrapPanel.add(rePass, gridConstraints);
		
		//bot grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 3;
		JButton changePassBtn = new JButton("Change Password");
		changePassBtn.addActionListener(changePassControl);
		changePassBtn.setActionCommand("changePassBtn");
		loginWrapPanel.add(changePassBtn, gridConstraints);
		
		validate();
    	repaint();
		
	} //changePasswordView()
	
	public void setGrid(){
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
        gridConstraints.weighty = 50;
        // Defines padding top, left, bottom, right
        gridConstraints.insets = new Insets(2,5,2,5);
        // Defines where to place components if they don't
        // fill the space: CENTER, NORTH, SOUTH, EAST, WEST
        // NORTHEAST, etc.
        gridConstraints.anchor = GridBagConstraints.CENTER;
        // How should the component be stretched to fill the
        // space: NONE, HORIZONTAL, VERTICAL, BOTH
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
	}
} //changePasswordView
