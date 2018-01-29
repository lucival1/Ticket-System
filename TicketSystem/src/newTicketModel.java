
import java.time.Instant;

public class newTicketModel {
	
	//attributes
	private String technician = null;
	private String issue = null;
	private String status = "open";
	private String description = null;
	private String query1 = null;
	private String query2 = null;
	private Object insertedRow[];
	private String openDate;
	
	//constructor
	public newTicketModel(){
		
	} //ticketModel()

	//update query values and connect to DB
	public void insertQuery(){
		long epoch = Instant.now().getEpochSecond();
		openDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date (epoch*1000));
		System.out.println(openDate);
		query1 = "insert into ticket(technician, issue, status, open_date, description)"
				+ "values('"+technician+"', '"+issue+"', '"+status+"', '"+openDate+"', '"+description+"')";
		query2 = "select * from ticket where id=";
		database db = new database();
		db.dbConnection();
	    insertedRow = db.insertRow(query1, query2, 7);
	} //logDatabase()

	//Getters and Setters
	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object[] getInsertedRow() {
		return insertedRow;
	}

	public void setInsertedRow(Object[] insertedRow) {
		this.insertedRow = insertedRow;
	}
	
	

} //ticketModel
