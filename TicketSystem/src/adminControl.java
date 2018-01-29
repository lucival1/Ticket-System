
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

public class adminControl extends WindowAdapter implements ActionListener{
	
	//Attributes
	private adminView adminWindow = null;
	private adminModel adminMod = null;
	private String id = null;
	private String newPass = null;
	int row;
		
	//constructor
	public adminControl(adminView v, adminModel m){
			
		this.adminWindow = v;
		this.adminMod = m;
		for(Object[] arr: adminMod.getData()){
			adminWindow.dTableModel.addRow(arr);
		}
	} //adminControl()m

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newAccBtn")) {
			//open a new window to create a new user
			new newUserView(adminWindow);
		}
		if(e.getActionCommand().equals("changePassBtn")) {
			//get time stamp and close the selected ticket
			if(adminWindow.table.getSelectedRow() != -1){
				int column = 0;
				row = adminWindow.table.getSelectedRow();
				id = adminWindow.tm.getValueAt(row, column).toString(); //store id of the row to be changed
				new changePasswordView(this);
			}
			
		}
		if(e.getActionCommand().equals("deleteUserBtn")) {
			//delete user from the system
			if(adminWindow.table.getSelectedRow() != -1){
				if(JOptionPane.showConfirmDialog(adminWindow,
						 "Are you sure you want to delete this user?", "Delete User",
						 JOptionPane.YES_NO_OPTION,
						 JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
					int column = 0;
					int row = adminWindow.table.getSelectedRow();
					id = adminWindow.tm.getValueAt(row, column).toString();
					adminWindow.dTableModel.removeRow(row);
					System.out.println(id);
					this.adminMod.deleteData(id);
				}
			}
		}
		if(e.getActionCommand().equals("logOutBtn")) {
			if(JOptionPane.showConfirmDialog(adminWindow,
					 "Are you sure to close this window?", "Really Closing?",
					 JOptionPane.YES_NO_OPTION,
					 JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					 System.exit(0);
				}
		}
	} //actioPerformed()
	
	//getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
		//receives from changePasswordModel the new password to update on the JTable
		adminWindow.dTableModel.setValueAt(newPass, row, 3);
	}
}
