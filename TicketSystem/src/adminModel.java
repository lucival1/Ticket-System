
import java.time.Instant;

public class adminModel {
	
	//attributes
	private Object[][] data = new Object[30][6];
	private String query = null;
	private String closeDate;
	
	//constructor
	public adminModel(){
		database dbData = new database();
		query = "select * from users;";
		dbData.dbConnection();
		data = dbData.getData(query, 4);
		query = null;
	} //techModel()	
	
	//change status from open to closed on the DB 
	//receive the id from the selected row and passes to query
	//call the method then receives the new status and then clear query
	public void changeStatus(String id){
		
		//epoch
		long epoch = Instant.now().getEpochSecond();
		closeDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch*1000));
		query = "update ticket set status = 'closed', close_date ='"+closeDate+"' where id="+id;
		database dbData = new database();
		dbData.updateRow(query);
		query = null;
	} //changeStatus()

	//change status from open to close on the table
	//receive the id from the selected row and passes to query
	//call the method and then clear query
	public void deleteData(String id){
		query = "delete from users where id="+id;
		database dbData = new database();
		dbData.deleteRow(query);
		query = null;
	} //deleteData()
	
	//getters and setters
	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

}
