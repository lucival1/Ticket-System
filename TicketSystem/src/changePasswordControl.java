import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changePasswordControl implements ActionListener {

	//Attributes
	private changePasswordView changePassWindow = null;
	private changePasswordModel changePassMod = null;
	
	//constructor receives from changePasswordView instances of the view and model for change password
	//also receive the id of the row to be changed
	public changePasswordControl(changePasswordView v, changePasswordModel m){
			
		this.changePassWindow = v;
		this.changePassMod = m;
		
	} //changePasswordControl()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//check if password field has at least 3 char
		if(changePassWindow.pass.getPassword().length > 2 &&
				changePassWindow.rePass.getPassword().length > 2){
			if(e.getActionCommand().equals("changePassBtn")) {
				//set id of the row to be updated and the new password field in the model
				changePassMod.setPass(changePassWindow.pass.getPassword());    
				changePassMod.changePassword();
		    	changePassWindow.setVisible(false);
			}
		}
		
	} //actioPerformed()
	
} //changePasswordControl
