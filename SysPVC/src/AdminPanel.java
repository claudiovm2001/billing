import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setMinimumSize(new Dimension(640, 480));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] products;
		String[] values;
		String[] employees;
		String[] dates;
		
		int size = 0;
		
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
			        "postgres", "30042001");
			
			//c.setAutoCommit(false);
			
			//CONSULTAR
			Statement stmt = null;
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"TRANSACTIONS\";" );
			while ( rs.next() ) {
				++size;
			}
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		products = new String[size];
		values = new String[size];
		employees = new String[size];
		dates = new String[size];
		
		int cont = 0;
		
		c = null;
		
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
			        "postgres", "30042001");
			
			
			//CONSULTAR
			Statement stmt = null;
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"TRANSACTIONS\" ORDER BY \"time\" DESC;" );
			while ( rs.next() ) {
				products[cont] = rs.getString("product");
				values[cont] = "R$ "+rs.getString("value");
				//employees[cont] = rs.getString("employee");
				
				Timestamp s1 = rs.getTimestamp("time");
				dates[cont] = s1.toString();
				
				++cont;
			}
			
			//RESPONSÁVEIS:
			cont = 0;
			stmt = c.createStatement();
			
			rs = stmt.executeQuery( "SELECT \"EMPLOYEES\".\"username\" FROM \"TRANSACTIONS\", \"EMPLOYEES\" "
					+ "WHERE \"EMPLOYEES\".\"id\"=\"TRANSACTIONS\".\"employee\" "
					+ "ORDER BY \"TRANSACTIONS\".\"time\" DESC;");
			while ( rs.next() ) {
				employees[cont] = rs.getString("username");
				
				++cont;
			}
			
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 110, 158, 320);
		frame.getContentPane().add(panel);
		
		JList list = new JList(products);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(178, 110, 113, 320);
		frame.getContentPane().add(panel_1);
		
		JList list_1 = new JList(values);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(list_1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(list_1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(301, 110, 153, 320);
		frame.getContentPane().add(panel_2);
		
		JList list_2 = new JList(employees);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(list_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(list_2, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(464, 110, 150, 320);
		frame.getContentPane().add(panel_3);
		
		JList list_3 = new JList(dates);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(list_3, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(list_3, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 85, 57, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblValor.setBounds(178, 87, 50, 14);
		frame.getContentPane().add(lblValor);
		
		JLabel lblResponsvel = new JLabel("Respons\u00E1vel");
		lblResponsvel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblResponsvel.setBounds(301, 85, 93, 14);
		frame.getContentPane().add(lblResponsvel);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblHora.setBounds(464, 87, 50, 14);
		frame.getContentPane().add(lblHora);
		
		JLabel lblNewLabel_1 = new JLabel("Hist\u00F3rico");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(258, 38, 72, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel_1.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
