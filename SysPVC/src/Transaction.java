import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Transaction {
	
	private ArrayList<Product> items;
	private String employee;
	private String time;
	
	public Transaction() {
		
		items = new ArrayList<Product>();
		employee = Main.currentUser;
	}
	
	public void insert(Product product) {
		this.items.add(product);
	}
	
	public ArrayList<Product> getItems() {
		return this.items;
	}
	
	public void setTime() {
		Date date;
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		date = Calendar.getInstance().getTime();
		this.time = formatter.format(date);
	}
	public String getTime() {
		return this.time;
	}
	
	public String getEmployee() {
		return this.employee;
	}
}
