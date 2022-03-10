import java.util.ArrayList;
import java.util.List;

public class Transaction {
	
	private List items;
	private String user;
	private String date;
	
	public Transaction() {
		
		items = new ArrayList<Product>();
	}
}
