import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ReviewUI {

	private JFrame frmSyspvc;
	
	private Transaction transaction;
	
	private ArrayList<Product> items;

	/**
	 * Launch the application.
	 */
	public static void main(Transaction trsc) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewUI window = new ReviewUI(trsc);
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
	public ReviewUI(Transaction trsc) {
		
		this.transaction = trsc;
		
		this.items = transaction.getItems();
		
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
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(354, 38, 76, 25);
		frmSyspvc.getContentPane().add(lblHeader);
		
		JLabel lblHeader_2 = new JLabel("Verifique a lista de produtos antes de efetivar a transa\u00E7\u00E3o.");
		lblHeader_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeader_2.setBounds(217, 88, 361, 25);
		frmSyspvc.getContentPane().add(lblHeader_2);
		
		
		//PREPARAÇÃO DA LISTA:
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
		lblColumn_2.setBounds(152, 134, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_2);
		
		JLabel lblColumn_1 = new JLabel("cod:");
		lblColumn_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_1.setBounds(50, 134, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_1);
		
		JLabel lblColumn_3 = new JLabel("preco:");
		lblColumn_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_3.setBounds(254, 134, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_3);
		
		JLabel lblColumn_4 = new JLabel("qtd:");
		lblColumn_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblColumn_4.setBounds(356, 134, 46, 14);
		frmSyspvc.getContentPane().add(lblColumn_4);

		
		
		//PREENCHIMENTO DA LISTA:
		JList listItems_name = new JList(names);
		listItems_name.setBounds(152, 149, 92, 389);
		frmSyspvc.getContentPane().add(listItems_name);
		
		JList listItems_cod = new JList(codes);
		listItems_cod.setBounds(50, 149, 92, 389);
		frmSyspvc.getContentPane().add(listItems_cod);
		
		JList listItems_price = new JList(prices);
		listItems_price.setBounds(254, 149, 92, 389);
		frmSyspvc.getContentPane().add(listItems_price);
		
		JList listItems_amount = new JList(amounts);
		listItems_amount.setBounds(356, 149, 92, 389);
		frmSyspvc.getContentPane().add(listItems_amount);
		
		
		
		//GRAVAR TRANSAÇÃO NO BANCO
		JButton btnSubmit = new JButton("Finalizar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection c = null;
			      
			    	try {
			    		Class.forName("org.postgresql.Driver");
			    		
			    		c = DriverManager.getConnection(
			    				"jdbc:postgresql://localhost:5432/postgres", "postgres","30042001"
			            );
			            c.setAutoCommit(false);
			         
			         
			            PreparedStatement stmt = c.prepareStatement(
			            		"INSERT INTO \"TRANSACTIONS\" VALUES (?, ?, ?, ?)"
			        		    );			        		 		
			         
			            for (Product product : items) {
			 			
			            	stmt.setString(1, product.getName()); 
					        stmt.setDouble(2, product.getPrice() * product.getAmount() );
					        stmt.setString(3, transaction.getEmployee());
					        stmt.setString(4, transaction.getTime());
					        
					        		 
					         stmt.executeUpdate();
			 		    }
			 
			         
			            c.commit();
			            c.close();
			         
			      } catch (Exception e1) {
			          e1.printStackTrace();
			          System.err.println(e1.getClass().getName()+": "+e1.getMessage());
			          System.exit(0);
			       }
			}
		});
		
		
		
		btnSubmit.setBounds(638, 359, 89, 23);
		frmSyspvc.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(535, 359, 89, 23);
		frmSyspvc.getContentPane().add(btnCancel);
		
		
		JLabel lblResult = new JLabel("TOTAL A PAGAR:");
		lblResult.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblResult.setForeground(Color.MAGENTA);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(576, 188, 105, 14);
		frmSyspvc.getContentPane().add(lblResult);
		
		
		//CÁLCULO DE VALOR FINAL
		float total = 0;			
		
		for (Product product : this.items) {
			total += product.getPrice() * product.getAmount();
		}
		
		
		JLabel lblResult_value = new JLabel("R$ "+total);
		lblResult_value.setFont(new Font("Dialog", Font.BOLD, 20));
		lblResult_value.setBorder(new LineBorder(Color.RED, 2));
		lblResult_value.setBounds(535, 236, 192, 57);
		frmSyspvc.getContentPane().add(lblResult_value);
	}
}
