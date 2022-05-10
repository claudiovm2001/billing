import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class AdminPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hist\u00F3rico");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(192, 21, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		String[] products;
		int size = 0;
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs;
		
		//recuperar do banco de dados
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
			        "postgres", "30042001");
			
			c.setAutoCommit(false);
			
			//CONSULTAR
			stmt = c.createStatement();
			
			rs = stmt.executeQuery( "SELECT * FROM \"TRANSACTIONS\";" );
			
			while(rs.next()) {
				++size;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		products = new String[size];
		rs = null;
		
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery( "SELECT * FROM \"TRANSACTIONS\";" );
			
			int cont = 0;
			
			while(rs.next()) {
				products[cont] = rs.getString("product");
				++cont;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 80, 215, 170);
		frame.getContentPane().add(panel);
		
		JList list = new JList(products);
		panel.add(list);
		list.setForeground(Color.CYAN);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list.setBackground(Color.RED);
	}
}
