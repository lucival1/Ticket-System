
public class loginModel {
	private String user = null;
	private String pass = null;
	private String acc = null;
	private String statement = null;
	
	//constructor
	public loginModel (){ 
		
	} //loginModel()
	
	//set query statement, log in the database and acquire acc_type
	//call for respective acc_type view
	public void logDatabase(){
		statement = "select * from users where username = '"+user+"' and password = '"+pass+"'";
		database db = new database();
		try{
	    this.setAcc(db.logDatabase(this.statement));
		} catch(NullPointerException e){
			
		}
	} //logDatabase()

	//Getters and Setters
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(char[] pass) {
		this.pass = String.valueOf(pass);
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

} //loginModel
