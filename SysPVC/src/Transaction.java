import java.util.ArrayList;
import java.util.List;

public class Transaction {
	
	private ArrayList<Product> items;
	private String user;
	private String date;
	
	public Transaction() {
		
		items = new ArrayList<Product>();
	}
	
	public void insert(Product product) {
		this.items.add(product);
	}
	
	public ArrayList<Product> getItems() {
		return this.items;
	}
}
