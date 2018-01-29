import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

public class managerControl extends WindowAdapter implements ActionListener{

	//Attributes
	private managerView mngWindow = null;
	private managerModel mngMod = null;
		
	//constructor
	public managerControl(managerView v, managerModel m){			
		this.mngWindow = v;
		this.mngMod = m;
		mngMod.createBarChart();
		this.createChartData();
	} //managerControl()
	
	public void createChartData(){
		mngWindow.setChartBar(mngMod.getGraphBar());
		mngWindow.setTotalOpTickets(mngMod.getTotalOpTickets());
		mngWindow.setTotalClsTickets(mngMod.getTotalClsTickets());
		mngWindow.setCostOpTickets(mngMod.getOpenCost()+"€");
		mngWindow.setCostClsTickets(mngMod.getClosedCost()+"€");
		mngWindow.setTotalTickets(mngMod.getTotalTickets());
	} //createChart()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("refreshBtn")) {
			mngMod.refreshData();
			mngMod.refreshBarChart();
			this.createChartData();
			mngWindow.chartUpdate();
		}
		if(e.getActionCommand().equals("logOutBtn")) {
			if(JOptionPane.showConfirmDialog(mngWindow,
					 "Are you sure to close this window?", "Really Closing?",
					 JOptionPane.YES_NO_OPTION,
					 JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					 System.exit(0);
				}
		}
	} //actioPerformed()
}
