
public class changePasswordModel {	

	private String pass = null;
	private String idRow = null;
	private String query = null;
	adminControl tempControl = null;
	
	//constructor
	public changePasswordModel (adminControl temp){
		tempControl = temp;
		this.idRow = tempControl.getId();
		
	} //loginModel()
	
	//set query statement, log in the database and acquire acc_type
	//call for respective acc_type view
	public void changePassword(){
		query = "update users set password = '"+pass+"' where id = '"+idRow+"'";
		database db = new database();
		db.updateRow(query);
		tempControl.setNewPass(pass);
	} //logDatabase()

	//Getters and Setters
	public String getPass() {
		return pass;
	}

	public void setPass(char[] pass) {
		this.pass = String.valueOf(pass);
	}
	

}
