
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class techView extends JFrame {

	//Attributes
	static Object[] columnNames = {"ID","Technician","Issue Type","Status","Issue date","Issue closed","Description"};
	static Object[][] data;
	static DefaultTableModel dTableModel = new DefaultTableModel(data, columnNames){
		 @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
		 
		public Class getColumnClass(int column) {
		Class returnValue;
		  // Verifying that the column exists (index > 0 && index < number of columns
		  if ((column >= 0) && (column < getColumnCount())) {
		    returnValue = getValueAt(0, column).getClass();
		  } else {
		    // Returns the class for the item in the column
		    returnValue = Object.class;
		  }
		  return returnValue;
		}
	};
	static JTable table = null;
	TableModel tm = null;
	
	//Constructor
	public techView(){
		
		techModel techModel = new techModel();
		techControl techControl = new techControl(this, techModel);
		this.setSize(900,500);
		this.setVisible(true);
		this.setTitle("Technical Support Team");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);		
		
		//set menu bar
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);		
		JMenu file = new JMenu("File");
		menuBar.add(file);		
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(techControl);
		close.setActionCommand("logOutBtn");
		file.add(close);
		
		//set Panels on the window and respective layout managers
		JPanel techPanel = new JPanel();
		techPanel.setLayout(new BorderLayout());
		this.add(techPanel);
		
		//create table and assign data from array to respective columns
		Box centerBox = Box.createVerticalBox();
		centerBox.add(Box.createVerticalStrut(10));
		table = new JTable(dTableModel);
		//set columns' width
		// Disable auto resizing
		/**table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(30);
		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(50);
		TableColumn col3 = table.getColumnModel().getColumn(2);
		col3.setPreferredWidth(80);
		TableColumn col4 = table.getColumnModel().getColumn(3);
		col4.setPreferredWidth(30);
		TableColumn col5 = table.getColumnModel().getColumn(4);
		col5.setPreferredWidth(60);
		TableColumn col6 = table.getColumnModel().getColumn(5);
		col6.setPreferredWidth(60);
		TableColumn col7 = table.getColumnModel().getColumn(6);
		col7.setPreferredWidth(100);**/

		JScrollPane sp = new JScrollPane(table);
		tm = table.getModel();
		centerBox.add(sp);
		techPanel.add(centerBox, BorderLayout.CENTER);
		
		/**East Border Layout components
		first I add a JPael to hold all the components then I add an horizontal box
		to work as a wrapper and a vertical box, this way I can add struts
		to manage space between components**/
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(3,1));
		techPanel.add(eastPanel, BorderLayout.EAST);
		Box boxWrapper = Box.createHorizontalBox();
		boxWrapper.add(Box.createHorizontalStrut(10));
		eastPanel.add(boxWrapper);
		Box rightBox = Box.createVerticalBox();
		boxWrapper.add(rightBox);
		boxWrapper.add(Box.createHorizontalStrut(10)); //horizontal space from centre border
		
		//buttons East Border Layout
		JButton newBtn = new JButton("New");
		newBtn.addActionListener(techControl);
		newBtn.setActionCommand("newBtn");
		rightBox.add(newBtn);
		rightBox.add(Box.createVerticalStrut(10)); //vertical space from closeBtn
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(techControl);
		closeBtn.setActionCommand("closeBtn");
		rightBox.add(closeBtn);
		rightBox.add(Box.createVerticalStrut(10)); //vertical space from deleteBtn
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(techControl);
		deleteBtn.setActionCommand("deleteBtn");
		rightBox.add(deleteBtn);
		rightBox.add(Box.createVerticalStrut(10)); //vertical space from logOutBtn
		
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(techControl);
		logOutBtn.setActionCommand("logOutBtn");
		rightBox.add(logOutBtn);
		
	} //techView()

	//getters and setters
	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}
	
} //techView
