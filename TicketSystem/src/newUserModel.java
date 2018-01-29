public class newUserModel {
	adminControl tempControl = null;
	
	//attributes
	private String accType = null;
	private String username = null;
	private String password = null;
	private String query1 = null;
	private String query2 = null;
	private Object insertedRow[];

	//constructor receives the adminControl that has access to the row's id to be changed
	public newUserModel(){
		
	} //ticketModel()

	//update query values and connect to DB
	public void addNewUser(){
		query1 = "insert into users(acc_type, username, password)"
				+ "values('"+accType+"', '"+username+"', '"+password+"')";
		query2 = "select * from users where id=";
		database db = new database();
		db.dbConnection();
	    insertedRow = db.insertRow(query1, query2, 4);
	} //logDatabase()
	
	//Getters and Setters	
	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Object[] getInsertedRow() {
		return insertedRow;
	}

	public void setInsertedRow(Object[] insertedRow) {
		this.insertedRow = insertedRow;
	}

} //newUserModel
