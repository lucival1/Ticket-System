
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class newUserView extends JFrame {
	
	//attributes
	private String[] typeString = {"","Admin","Manager","Support"};
	JComboBox accType;
	JTextField username = null;
	JTextField password = null;
	
	//constructor
	public newUserView(adminView temp){
		
		newUserModel nUserModel = new newUserModel();
		newUserControl nUserControl = new newUserControl(this, nUserModel, temp);
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("New User");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//set Panels on the window and respective layout managers
		JPanel loginWrapPanel = new JPanel(new GridBagLayout());
		this.add(loginWrapPanel);
		
		// You create a GridBagContraints object that defines
        // defaults for your components
        GridBagConstraints gridConstraints = new GridBagConstraints();
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
		
		
		
		//top grid panel and components
		JLabel accTypeLabel = new JLabel("Account Type: ");
		loginWrapPanel.add(accTypeLabel, gridConstraints);
		gridConstraints.gridwidth = 50;
		gridConstraints.gridx = 2;
		accType = new JComboBox(typeString);
		accType.setSelectedIndex(0);
		loginWrapPanel.add(accType, gridConstraints);
		accType.addActionListener(nUserControl);		
		
		//mid grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		JLabel usernameLabel = new JLabel("Username: ");
		loginWrapPanel.add(usernameLabel, gridConstraints);
		gridConstraints.gridwidth = 30;
		gridConstraints.gridx = 2;
		username = new JTextField(20); //set field size when finish
		username.addActionListener(nUserControl);
		loginWrapPanel.add(username, gridConstraints);
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		JLabel passwordLabel = new JLabel("Password: ");
		loginWrapPanel.add(passwordLabel, gridConstraints);
		gridConstraints.gridwidth = 30;
		gridConstraints.gridx = 2;
		password = new JTextField(20); //set field size when finish
		password.addActionListener(nUserControl);
		loginWrapPanel.add(password, gridConstraints);
		
		//bot grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 4;
		JButton addUserBtn = new JButton("Add User");
		addUserBtn.addActionListener(nUserControl);
		addUserBtn.setActionCommand("addUserBtn");
		loginWrapPanel.add(addUserBtn, gridConstraints);
		
		validate();
    	repaint();
		
	} //newUserView()
} //newUserView
