import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return this.username;
	}
	
	public boolean login() {
		
		if(this.username.equals("admin") && this.password.equals("senha")) {
			return true;
		}
		//CONECTAR
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
			        "postgres", "30042001");
			
			c.setAutoCommit(false);
			
			//CONSULTAR
			Statement stmt = null;
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"EMPLOYEES\";" );
			while ( rs.next() ) {
				if (this.username.equals(rs.getString("username")) && this.password.equals(rs.getString("password"))) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return false;
	}
}
