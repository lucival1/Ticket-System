
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginControl implements ActionListener {

	//Attributes
	private loginView loginWindow = null;
	private loginModel loginMod = null;
	
	//constructor
	public loginControl(loginView v, loginModel m){
			
		this.loginWindow = v;
		this.loginMod = m;
		
	} //loginControl()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("logBtn")) {
			//check if password field has at least 3 char
			if(loginWindow.user.getText().length() > 2 &&
					loginWindow.pass.getPassword().length > 2){
				if(loginWindow.user.getText() != null && loginWindow.pass.getPassword()!= null){
					loginMod.setUser(loginWindow.user.getText());
					loginMod.setPass(loginWindow.pass.getPassword());		    
			    	loginMod.logDatabase();
			    	loginWindow.setVisible(false);
				}
			    if(loginMod.getAcc().equals("support")){
			    	new techView();
			    } 
			    if(loginMod.getAcc().equals("manager")){
					new managerView();
				}
			    if(loginMod.getAcc().equals("admin")){
					new adminView();
				}
			    //handle failed attempts set user & password field to blank and 
			    //set the login window visible
			    if (loginMod.getAcc().equals("")){
			    	loginWindow.user.setText("");
			    	loginWindow.pass.setText("");
					loginWindow.setVisible(true); 
				}
			}
		}
		
	} //actioPerformed()
	
} //loginControl
