
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class newUserControl implements ActionListener {

	//Attributes
	private newUserView nUserWindow = null;
	private newUserModel nUserMod = null;
	private adminView tempView = null;
	String typeListSelection = null;
	
	//constructor receives from newUserView instances of the view and model to add new user
	public newUserControl(newUserView v, newUserModel m, adminView c){
			
		this.nUserWindow = v;
		this.nUserMod = m;
		this.tempView = c;
		
	} //newUserControl()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nUserWindow.accType){
			JComboBox cb2 = (JComboBox)e.getSource();
			typeListSelection = ((String)cb2.getSelectedItem());
		}
		if(e.getActionCommand().equals("addUserBtn")) {
			//send data about ticket issue to model
			nUserMod.setAccType(typeListSelection);
			nUserMod.setUsername(nUserWindow.username.getText());
			nUserMod.setPassword(nUserWindow.password.getText());
			nUserMod.addNewUser();
			tempView.dTableModel.addRow(nUserMod.getInsertedRow());
			nUserWindow.setVisible(false);
		}
	} //actioPerformed()
	
} //newUserControl
