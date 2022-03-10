public class User {
	
	private String username;
	private String password;
	
	public static boolean Login(String login, String passcode) {
		
		if(login.equals("admin") && passcode.equals("passwd")) return true;
		
		return false;
	}
}
