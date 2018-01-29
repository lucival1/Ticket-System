import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class managerModel {

	//attributes
	JFreeChart graphBar;
	
	//attributes
	private int index= 0;
	private String[] tech;
	private int[] openTicket;
	private int[] closedTicket;
	private int openCost = 0;
	private int closedCost = 0;
	database dbData = new database();
	DefaultCategoryDataset gData;
	
	//Constructor
	public managerModel(){
		this.refreshData();	
	}//managerModel()

	//set graphic variables based on DB
	public void refreshData(){
		dbData.dbConnection();
		dbData.gData();
		gData = new DefaultCategoryDataset();
		gData.clear();
		graphBar = null;
		this.setIndex();
		tech = new String[index];
		openTicket = new int[index];
		closedTicket = new int[index];
		this.setTech();
		this.setOpenTicket();
		this.setClosedTicket();
	}//refreshData()
	
	//generate a new Bar Chart using the dataset based on the DB
	public void createBarChart(){
		for(int x = 0; x < index; x++){
			gData.setValue(openTicket[x]+closedTicket[x], "Total", tech[x]);
			gData.setValue(openTicket[x], "Open", tech[x]);
			gData.setValue(closedTicket[x], "Closed", tech[x]);
		}
		graphBar = ChartFactory.createBarChart("Tickets Report", "Employee", "Quantity",
				gData, PlotOrientation.HORIZONTAL, true, true, false);
		
		CategoryPlot gPlot = graphBar.getCategoryPlot();
		gPlot.setRangeGridlinePaint(Color.black);
		
	}//creatBarGraph()
	
	//clear data from dataset and calls for a new chart
	public void refreshBarChart(){
		gData.clear();
		this.createBarChart();
	}//refreshBarGraph()

	
	//Getters and Setters
	public JFreeChart getGraphBar() {
		return graphBar;
	}

	public void setGraphBar(JFreeChart graphBar) {
		this.graphBar = graphBar;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex() {
		this.index = dbData.getIndex();
	}

	public String[] getTech() {
		return tech;
	}

	public void setTech() {
		this.tech = dbData.getTech();
	}

	public int[] getOpenTicket() {
		return openTicket;
	}

	public void setOpenTicket() {
		this.openTicket = dbData.getOpenTicket();
	}

	public int[] getClosedTicket() {
		return closedTicket;
	}

	public void setClosedTicket() {
		this.closedTicket = dbData.getClosedTicket();
	}
	
	public String getTotalOpTickets(){
		int total= 0;
		for(int x = 0; x < index; x++){
			total = total + openTicket[x];
		}
		openCost = total*50;
		String t = Integer.toString(total);
		return t;
	}
	
	public String getTotalClsTickets(){
		int total= 0;
		for(int x = 0; x < index; x++){
			total = total + closedTicket[x];
		}
		closedCost = total*50;
		String t = Integer.toString(total);
		return t;
	}

	public String getOpenCost() {
		return Integer.toString(openCost);
	}

	public String getClosedCost() {
		return Integer.toString(closedCost);
	}
	
	public String getTotalTickets() {
		int a = Integer.parseInt(this.getTotalOpTickets());
		int b = Integer.parseInt(this.getTotalClsTickets());
		return Integer.toString(a+b);
	}
	
}
