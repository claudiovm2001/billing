import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin extends User{
	
	public Admin(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public static void registerEmployee(String empl_name, String empl_passwd) {
		Connection c;
	      
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		c = DriverManager.getConnection(
    				"jdbc:postgresql://localhost:5432/postgres", "postgres","30042001"
            );
            c.setAutoCommit(false);					
			
            
            PreparedStatement stmt = c.prepareStatement(
            		"INSERT INTO \"EMPLOYEES\" (\"username\", \"password\") VALUES (?, ?)"
        		    );			        		 		
            
            stmt.setString(1, empl_name); 
	        stmt.setString(2, empl_passwd);
            
		        		 
		    stmt.executeUpdate();
 
         
            c.commit();
            c.close();
         
      } catch (Exception e1) {
          e1.printStackTrace();
          System.err.println(e1.getClass().getName()+": "+e1.getMessage());
          System.exit(0);
       }
	}
	
	public static void updateEmployee(int empl_id, String empl_name, String empl_passwd) {
		
		Connection c;
	      
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		c = DriverManager.getConnection(
    				"jdbc:postgresql://localhost:5432/postgres", "postgres","30042001"
            );
            c.setAutoCommit(false);					
			
            
            PreparedStatement stmt = c.prepareStatement(
            		"UPDATE \"EMPLOYEES\""
            		+ "SET \"username\" = ?, \"password\" = ?"
            		+ "WHERE \"id\"= "+empl_id
        		    );			        		 		
         
            stmt.setString(1, empl_name); 
	        stmt.setString(2, empl_passwd);
		        
		        		 
		    stmt.executeUpdate();
 
         
            c.commit();
            c.close();
         
      } catch (Exception e1) {
          e1.printStackTrace();
          System.err.println(e1.getClass().getName()+": "+e1.getMessage());
          System.exit(0);
       }
		
	}
	
	public static void removeEmployee(String empl_name) {
		
		Connection c;
	      
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		c = DriverManager.getConnection(
    				"jdbc:postgresql://localhost:5432/postgres", "postgres","30042001"
            );
            c.setAutoCommit(false);
            
        //CONSULTAR
		Statement stmt;
		stmt = c.createStatement();
		
		ResultSet rs = stmt.executeQuery( "SELECT * FROM \"EMPLOYEES\" WHERE \"username\"= '"+empl_name+"'");
		rs.next();
			
            
        PreparedStatement stmt1 = c.prepareStatement(
            "DELETE FROM \"TRANSACTIONS\" WHERE \"employee\" = "+rs.getInt("id")
        );			        
		        		 
		stmt1.executeUpdate();		 
         
        c.commit();
        
        PreparedStatement stmt2 = c.prepareStatement(
	            "DELETE FROM \"EMPLOYEES\" WHERE \"id\" = "+rs.getInt("id")
	        );			        
			        		 
		stmt2.executeUpdate();		 
	         
	    c.commit();
        
        c.close();
         
      } catch (Exception e1) {
          e1.printStackTrace();
          System.err.println(e1.getClass().getName()+": "+e1.getMessage());
          System.exit(0);
       }
		
	}
	
	public void viewHistory() {
		
		
		
	}
}
