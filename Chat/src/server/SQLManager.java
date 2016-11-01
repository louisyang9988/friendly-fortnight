
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SQLManager {
    private static final String USER = "yy294";
    private static final String PASSWORD = "niCg2db22";
    private static final String SERVER = "jdbc:mysql://sql1.njit.edu:3306/yy294";
    private static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";
    
    
  public static void save(String his) 
    
  {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
	  
	  
	  
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    System.out.println("Successfully import MySQL driver!");
		    System.out.println("Connecting...");
		    connection = DriverManager.getConnection(SERVER, USER, PASSWORD);
		    System.out.println("Successfully connect NJIT MySQL server!");
		    statement = connection.createStatement();
		  
		    
		    statement.execute("insert into History (CHATHISTORY) values('"+his+"')");
		    
		    //rs.close();
		    
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
		    System.out.println(ex.toString());
		}
	  
	  
	
	  
	  
	  
  }


  public static ArrayList<String> load() 
  
  {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<String> h = new ArrayList<String>();
	  
	  
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    System.out.println("Successfully import MySQL driver!");
		    System.out.println("Connecting...");
		    connection = DriverManager.getConnection(SERVER, USER, PASSWORD);
		    System.out.println("Successfully connect NJIT MySQL server!");
		    statement = connection.createStatement();
		  
		    
		  rs=  statement.executeQuery("select * from History ");
		  while (rs.next()) {
				h.add(rs.getString("CHATHISTORY"));
			    }
		    rs.close();
		    
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
		    System.out.println(ex.toString());
		}
	  
	  
	return h;
	  
	  
	  
  }

	public static void main(String[] arg){
		
		///SQLManager.save(PASSWORD);

	}
    
    
    
    
    
    
    
    
    
    
    
    
}