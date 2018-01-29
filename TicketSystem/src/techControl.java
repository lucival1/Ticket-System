
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

public class techControl extends WindowAdapter implements ActionListener{
	
	//Attributes
	private techView techWindow = null;
	private techModel techMod = null;
	private String id = null;
		
	//constructor
	public techControl(techView v, techModel m){
			
		this.techWindow = v;
		this.techMod = m;
		for(Object[] arr: techMod.getData()){
			techWindow.dTableModel.addRow(arr);
		}
	} //techControl()

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newBtn")) {
			//open a new window to create a new ticket
			new newTicketView(techWindow);
		}
		if(e.getActionCommand().equals("closeBtn")) {
			//get time stamp and close the selected ticket
			if(techWindow.table.getSelectedRow() != -1){
				int column = 0;
				int row = techWindow.table.getSelectedRow();
				id = techWindow.tm.getValueAt(row, column).toString();
				this.techMod.changeStatus(id);
				techWindow.dTableModel.setValueAt("closed", row, 3);
				techWindow.dTableModel.setValueAt(techMod.getCloseDate(), row, 5	);
			}
			
		}
		if(e.getActionCommand().equals("deleteBtn")) {
			//delete ticket form the system
			if(techWindow.table.getSelectedRow() != -1){
				if(JOptionPane.showConfirmDialog(techWindow,
						"Are you sure you want to delete this ticket?", "Delete Ticket",
						 JOptionPane.YES_NO_OPTION,
						 JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
					int column = 0;
					int row = techWindow.table.getSelectedRow();
					id = techWindow.tm.getValueAt(row, column).toString();
					techWindow.dTableModel.removeRow(row);
					System.out.println(id);
					this.techMod.deleteData(id);
				}
			}
		}
		if(e.getActionCommand().equals("logOutBtn")) {
			if(JOptionPane.showConfirmDialog(techWindow,
					 "Are you sure to close this window?", "Really Closing?",
					 JOptionPane.YES_NO_OPTION,
					 JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					 System.exit(0);
				}
		}
	} //actioPerformed()
}
