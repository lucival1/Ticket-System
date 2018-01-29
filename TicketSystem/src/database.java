import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.sql.SQLException;

public class database {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	String accID = "";
	String id = null;
	Object[][] data;
	Object[] row;
	private int index = 0;
	private String tech[];
	private int openTicket[];
	private int closedTicket[];
	
	//connects on database
	public void dbConnection(){
		try {
			  //Initialise the Driver class and register on DriverManager
			  Class.forName("com.mysql.jdbc.Driver").newInstance();		
			}catch(Exception e) {
				
			}
	}//dbConnect()
	
	//method to get data to populate JTable
	public Object[][] getData(String query, int numberColumns){
			try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://localhost/ticketdb?" +
	    	                                   "user=root&password=");
	    	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    	    
	    	    //check rows quantity and create object with right size
	    	    if (numberColumns == 7){
	    	    	rs = stmt.executeQuery("select count(id) from ticket;");
	    	    }
	    	    if (numberColumns == 4){
	    	    	rs = stmt.executeQuery("select count(id) from users;");
	    	    }
	    	    if(rs.next()){
	    	    	int i = rs.getInt(1);
	    	    	data = new Object[i][numberColumns];
	    	    }
	    	    rs = stmt.executeQuery(query);

	    	    // loop over results   	    
	    	    int counter = 0;
	    	    if (numberColumns == 7){
		    	    while(rs.next()){
		    	    	data[counter][0] = rs.getString("id");    	      
		    	    	data[counter][1] = rs.getString("technician");   
		    	    	data[counter][2] = rs.getString("issue");
		    	    	data[counter][3] = rs.getString("status");
		    	    	data[counter][4] = rs.getString("open_date");
		    	    	data[counter][5] = rs.getString("close_date");
		    	    	data[counter][6] = rs.getString("description");		    	        
		    	        counter = counter + 1;
		    	    }
	    	    } else{
	    	    	while(rs.next()){
		    	    	data[counter][0] = rs.getString("id");    	      
		    	    	data[counter][1] = rs.getString("acc_type");   
		    	    	data[counter][2] = rs.getString("username");
		    	    	data[counter][3] = rs.getString("password");		    	        
		    	        counter = counter + 1;
		    	    }
	    	    }
			} catch(SQLException ex) {
				this.errorCode(ex);
	    	} finally{
	    	}
			return data;
			
		} //getData()
		
	//method to log user
	public String logDatabase(String query1){
    	try {
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketdb?user=root&password=");

    	    // Do something with the Connection
    	    stmt = conn.createStatement();
    	    if (stmt.execute(query1)) {
    	        rs = stmt.getResultSet();
    	    }
    	    // loop over results    	    
    	    while(rs.next()){
    	        accID = rs.getString("acc_type");
    	    }
    	    conn.close();
    	    
    	} catch (SQLException ex) {
			this.errorCode(ex);
    	}
		return accID;
    	
	} //logDatabase()
	
	//method to add a row of data in the DB and return the new row to JTable
	public Object[] insertRow(String query1, String query2, int numberColumns){
			//database connection attributes
			Connection conn = null;
	    	Statement stmt = null;
	    try{
		    conn =
    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketdb?user=root&password=");

		    //executes the statement and return the new key generated to result set
		    //then a new query is made to retrieve the new added row and send back to model
		    //to be updated on the table without a refresh button
    	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	    stmt.execute(query1, Statement.RETURN_GENERATED_KEYS);
    	    rs = stmt.getGeneratedKeys();
    	    if(rs.next()){
    	    	int i = rs.getInt(1);
        	    rs = stmt.executeQuery(query2+i);
    	    }
    	    row = new Object[numberColumns];
    	    if(numberColumns == 7){
	    	    while(rs.next()){
	    	    	row[0] = rs.getString("id");    	      
	    	    	row[1] = rs.getString("technician");   
	    	    	row[2] = rs.getString("issue");
	    	    	row[3] = rs.getString("status");
	    	    	row[4] = rs.getString("open_date");
	    	    	row[5] = rs.getString("close_date");
	    	    	row[6] = rs.getString("description");
	    	    }
    	    } else{
    	    	while(rs.next()){
	    	    	row[0] = rs.getString("id");    	      
	    	    	row[1] = rs.getString("acc_type");   
	    	    	row[2] = rs.getString("username");
	    	    	row[3] = rs.getString("password");
    	    	}
    	    }
    	} catch(SQLException ex) {
			this.errorCode(ex);
    	}
	    return row;
	} //insertDatabase()

	
	//method to update ticket status to closed
	public void updateRow(String query){
		try {
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://localhost/ticketdb?" +
    	                                   "user=root&password=");
    	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	    stmt.executeUpdate(query);
		} catch(SQLException ex) {
			this.errorCode(ex);
		}
	} //updateData()

	//method to delete row in the DB
	public void deleteRow(String query) {
		try {
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://localhost/ticketdb?" +
    	                                   "user=root&password=");
    	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	    stmt.executeUpdate(query);
		} catch(SQLException ex) {
			this.errorCode(ex);
		}
	} //deleteRow()
	
	//fetch the data from the DB and send to managerModel to set default category dataset
	public void gData(){
		try {
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://localhost/ticketdb?" +
    	                                   "user=root&password=");
    	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	    rs = stmt.executeQuery("Select distinct count(username) from users where  acc_type = 'support'");
    	    if(rs.next()){
    	    	index = rs.getInt(1);
    	    }
    	    rs = stmt.executeQuery("Select distinct username from users where acc_type = 'support'");
	    	tech = new String[index];   
	    	openTicket = new int[index];
	    	closedTicket = new int[index];
    	    int counter = 0;
    	    while(rs.next()){
    	    	tech[counter] = rs.getString("username");
    	    	counter++;
    	    }
	    	for(int x = 0; x<index; x++){
		    	ResultSet openT = stmt.executeQuery("Select Count(technician) from ticket "
		    			+ "Where technician='"+tech[x]+"' and status ='open'");
		    	if(openT.next()){
		    		openTicket[x] = openT.getInt(1);
		    	}
		    	ResultSet closedT = stmt.executeQuery("Select Count(technician) from ticket "
		    			+ "Where technician='"+tech[x]+"' and status ='closed'");
		    	if(closedT.next()){
		    		closedTicket[x] =closedT.getInt(1);
		    	}
			}
		} catch(SQLException ex) {
			this.errorCode(ex);
		}
	}//gData()

	//send error code messages
	public void errorCode(SQLException ex){
	    // handle any errors
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
		
	}//errorCode()
	
	//Getters
	public int getIndex(){
		return index;
	}
	public String[] getTech() {
		return tech;
	}

	public int[] getOpenTicket() {
		return Arrays.copyOf(openTicket, openTicket.length);
	}

	public int[] getClosedTicket() {
		return Arrays.copyOf(closedTicket, closedTicket.length);
	}
} //dbConnection
