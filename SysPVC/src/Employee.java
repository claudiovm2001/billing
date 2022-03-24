public class Employee extends User {
	
	public Employee(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public void insertProduct(Product product, Transaction trsc) {
		trsc.insert(product);
	}
	
	public void review() {
		
	}
}