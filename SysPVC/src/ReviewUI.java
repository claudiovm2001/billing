import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

public class ReviewUI {

	private JFrame frmSyspvc;
	
	private ArrayList<Product> items;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<Product> items) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewUI window = new ReviewUI(items);
					window.frmSyspvc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReviewUI(ArrayList<Product> items) {
		
		this.items = new ArrayList<Product>();
		this.items = items;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSyspvc = new JFrame();
		frmSyspvc.setTitle("SysPVC");
		frmSyspvc.setMinimumSize(new Dimension(800, 600));
		frmSyspvc.setBounds(100, 100, 450, 300);
		frmSyspvc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSyspvc.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Revisar");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(354, 38, 76, 25);
		frmSyspvc.getContentPane().add(lblHeader);
		
		JLabel lblHeader_2 = new JLabel("Verifique a lista de produtos antes de efetivar a transa\u00E7\u00E3o.");
		lblHeader_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeader_2.setBounds(217, 88, 361, 25);
		frmSyspvc.getContentPane().add(lblHeader_2);
		
		String[] codes = new String[this.items.size()];
		String[] names = new String[this.items.size()];
		String[] prices = new String[this.items.size()];
		String[] amounts = new String[this.items.size()];
		
		int cont = 0;
		
		for (Product product : this.items) {
			codes[cont] = Integer.toString(product.getCode()); 
			names[cont] = product.getName();
			prices[cont] = Float.toString(product.getPrice());
			amounts[cont] = Integer.toString(product.getAmount());
			
			++cont;
		}
		
		
		JLabel lblColumn_2 = new JLabel("nome:");
		lblColumn_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_2.setBounds(301, 137, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_2);
		
		JLabel lblColumn_1 = new JLabel("cod:");
		lblColumn_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_1.setBounds(199, 137, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_1);
		
		JLabel lblColumn_3 = new JLabel("preco:");
		lblColumn_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_3.setBounds(403, 137, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_3);
		
		JLabel lblColumn_4 = new JLabel("qtd:");
		lblColumn_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_4.setBounds(505, 137, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_4);

		
		
		JList listItems_name = new JList(names);
		listItems_name.setBounds(301, 152, 92, 359);
		frmSyspvc.getContentPane().add(listItems_name);
		
		JList listItems_cod = new JList(codes);
		listItems_cod.setBounds(199, 152, 92, 359);
		frmSyspvc.getContentPane().add(listItems_cod);
		
		JList listItems_price = new JList(prices);
		listItems_price.setBounds(403, 152, 92, 359);
		frmSyspvc.getContentPane().add(listItems_price);
		
		JList listItems_amount = new JList(amounts);
		listItems_amount.setBounds(505, 152, 92, 359);
		frmSyspvc.getContentPane().add(listItems_amount);
	}
}
