
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class newTicketView extends JFrame {
	
	//attributes
	JTextArea descArea = null;
	private String[] techString = {"","John","James","Johan"};
	private String[] typeString = {"","Urgent","Normal","Longterm"};
	JComboBox techList;
	JComboBox typeList;
	private techView tempView = null;
	
	//constructor
	public newTicketView(techView temp){
		newTicketModel tickModel = new newTicketModel();
		newTicketControl tickControl = new newTicketControl(this, tickModel, tempView);
		//ticketControl tickControl = new ticketControl(this, tickModel, tempView);
		this.setSize(500,300);
		this.setVisible(true);
		this.setTitle("New Ticket");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		JLabel techLabel = new JLabel("Technician: ");
		loginWrapPanel.add(techLabel, gridConstraints);
		gridConstraints.gridwidth = 50;
		gridConstraints.gridx = 2;
		techList = new JComboBox(techString);
		techList.setSelectedIndex(0);
		loginWrapPanel.add(techList, gridConstraints);
		techList.addActionListener(tickControl);		
		
		//mid grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		JLabel issueLabel = new JLabel("Issue type: ");
		loginWrapPanel.add(issueLabel, gridConstraints);
		gridConstraints.gridwidth = 30;
		gridConstraints.gridx = 2;
		typeList = new JComboBox(typeString);
		typeList.addActionListener(tickControl);
		loginWrapPanel.add(typeList, gridConstraints);
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		JLabel descLabel = new JLabel("Description: ");
		loginWrapPanel.add(descLabel, gridConstraints);
		gridConstraints.gridwidth = 30;
		gridConstraints.gridx = 2;
		descArea = new JTextArea(5,20); //set field size when finish
		loginWrapPanel.add(descArea, gridConstraints);
		
		//bot grid panel and components
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 4;
		JButton addTicketBtn = new JButton("Add Ticket");
		addTicketBtn.addActionListener(tickControl);
		addTicketBtn.setActionCommand("addTicketBtn");
		loginWrapPanel.add(addTicketBtn, gridConstraints);
		
		validate();
		repaint();
		
	} //newUserView()
} //newUserView
