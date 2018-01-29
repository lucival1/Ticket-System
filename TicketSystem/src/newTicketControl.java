
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class newTicketControl implements ActionListener {
	
	//Attributes
	private newTicketView tickView = null;
	private newTicketModel tickModel = null;
	private techView tempView = null;
	String techListSelection = null;
	String typeListSelection = null;
	
	//constructor
	public newTicketControl(newTicketView v, newTicketModel m, techView temp) {
		this.tickView = v;
		this.tickModel = m;
		this.tempView = temp;
	} //ticketControl()

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == tickView.techList){
			JComboBox cb1 = (JComboBox)e.getSource();
			techListSelection = ((String)cb1.getSelectedItem());
			//System.out.println(techListSelection);
		}
		if(e.getSource() == tickView.typeList){
			JComboBox cb2 = (JComboBox)e.getSource();
			typeListSelection = ((String)cb2.getSelectedItem());
			//System.out.println(typeListSelection);
		}
		if(e.getActionCommand().equals("addTicketBtn")) {
			//send data about ticket issue to model
			tickModel.setTechnician(techListSelection);
			tickModel.setIssue(typeListSelection);
			tickModel.setDescription(tickView.descArea.getText());
			tickModel.insertQuery();
			tempView.dTableModel.addRow(tickModel.getInsertedRow());
			tickView.setVisible(false);
			
		}
		
	}//actionPerformed()

} //ticketControl
