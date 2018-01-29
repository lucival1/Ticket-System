import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

@SuppressWarnings("serial")
public class managerView extends JFrame {

	//attributes
	private static JFreeChart chartBar;
	JPanel containerPanel;
	private JPanel centerPanel;
	private ChartPanel gPanel;
	private static JLabel totalOpTickets = new JLabel("");
	private static JLabel totalClsTickets = new JLabel("");
	private static JLabel costOpTickets = new JLabel("");
	private static JLabel costClsTickets = new JLabel("");
	private static JLabel totalTickets = new JLabel("");
	private GridBagConstraints gridConstraints;

	//constructor
	public managerView(){
		
		managerModel mngModel = new managerModel();
		managerControl mngControl = new managerControl(this, mngModel);
		this.setSize(900,500);
		this.setVisible(true);
		this.setTitle("Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);		
		
		//set menu bar
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);		
		JMenu file = new JMenu("File");
		menuBar.add(file);		
		JMenuItem close = new JMenuItem("Close");
		//close.addActionListener(mngControl);
		close.setActionCommand("logOutBtn");
		file.add(close);
		
		//set Panels on the window and respective layout managers
		containerPanel = new JPanel(new BorderLayout());
		this.add(containerPanel);
		centerPanel = new JPanel(new FlowLayout());
		containerPanel.add(centerPanel, BorderLayout.WEST);
		JPanel mngPanel = new JPanel(new GridBagLayout());
		mngPanel.setPreferredSize(new Dimension(900, 100));
		containerPanel.add(mngPanel, BorderLayout.SOUTH);
		
		//Prepares panel to receive the chart
		gPanel = new ChartPanel(chartBar);
		gPanel.setPreferredSize(new Dimension(700, 300));
		centerPanel.removeAll();
		centerPanel.add(gPanel);
		
        this.gridSet();
        JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Open Tickets"));
		p.add(totalOpTickets, gridConstraints);
		mngPanel.add(p, gridConstraints);
		
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 1;
		p = new JPanel();
		p.setBorder(new TitledBorder("Cost Open Tickets"));
		p.add(costOpTickets, gridConstraints);
		mngPanel.add(p, gridConstraints);
		
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 1;
		p = new JPanel();
		p.setBorder(new TitledBorder("Closed Tickets"));
		p.add(totalClsTickets, gridConstraints);
		mngPanel.add(p, gridConstraints);
		
		gridConstraints.gridx = 4;
		gridConstraints.gridy = 1;
		p = new JPanel();
		p.setBorder(new TitledBorder("Cost Closed Tickets"));
		p.add(costClsTickets, gridConstraints);
		mngPanel.add(p, gridConstraints);
		
		gridConstraints.gridx = 5;
		gridConstraints.gridy = 1;
		p = new JPanel();
		p.setBorder(new TitledBorder("Total Tickets"));
		p.add(totalTickets, gridConstraints);
		mngPanel.add(p, gridConstraints);
		
		//buttons
		gridConstraints.gridx = 6;
		gridConstraints.gridy = 1;
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.addActionListener(mngControl);
		refreshBtn.setActionCommand("refreshBtn");
		mngPanel.add(refreshBtn, gridConstraints);
		
		gridConstraints.gridx = 6;
		gridConstraints.gridy = 2;
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(mngControl);
		logOutBtn.setActionCommand("logOutBtn");
		mngPanel.add(logOutBtn, gridConstraints);
		
		validate();
    	repaint();
		
	} //managerView()
	
	//Update Chart UI
	public void chartUpdate(){
		centerPanel.removeAll();
		centerPanel.invalidate();
		centerPanel.repaint();
		gPanel = new ChartPanel(chartBar);
		gPanel.setPreferredSize(new Dimension(700, 300));
		centerPanel.add(gPanel);
		centerPanel.validate();
		centerPanel.repaint();
	}
	
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
	
	//Getters and Setters
	public JFreeChart getChartBar() {
		return chartBar;
	}

	public void setChartBar(JFreeChart graphBar) {
		managerView.chartBar = graphBar;
	}

	public void setTotalOpTickets(String o) {
		managerView.totalOpTickets.setText(o);
	}

	public void setTotalClsTickets(String c) {
		managerView.totalClsTickets.setText(c);
	}
	
	public void setCostOpTickets(String o) {
		managerView.costOpTickets.setText(o);
	}

	public void setCostClsTickets(String c) {
		managerView.costClsTickets.setText(c);
	}
	
	public void setTotalTickets(String c) {
		managerView.totalTickets.setText(c);
	}
}
