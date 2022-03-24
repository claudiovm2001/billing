public class Product {
    
	private int code;
	private String name;
	private Float price;
	private int amount;
	
	public Product(int cod, String nome, Float preco, int qtd) {
		this.code = cod;
		this.name = nome;
		this.price = preco;
		this.amount = qtd;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Float getPrice() {
		return this.price;
	}
	
	public int getAmount() {
		return this.amount;
	}
}
