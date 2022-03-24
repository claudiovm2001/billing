public class Employee extends User {
	
	public Employee(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public void insertProduct(int cod, String nome, float preco, int qtd) {
		System.out.print(cod +" "+ nome +" "+ preco +" "+ qtd);
	}
	
	public void review() {
		
	}
}