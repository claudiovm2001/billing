import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AdminPanel_1 {

	private JFrame frame;
	private int employee_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel_1 window = new AdminPanel_1();
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
	public AdminPanel_1() {
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
		
		String[] employees;
		
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
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"EMPLOYEES\";" );
			while ( rs.next() ) {
				++size;
			}
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		employees = new String[size];
		
		int cont = 0;
		
		c = null;
		
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
			        "postgres", "30042001");
			
			
			//CONSULTAR
			Statement stmt = null;
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM \"EMPLOYEES\";" );
			while ( rs.next() ) {
				employees[cont] = rs.getString("username");
				++cont;
			}
			
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("Cadastros");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(252, 44, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(215, 117, 160, 269);
		frame.getContentPane().add(panel);
		
		JLabel lblEmployee = new JLabel("New label");
		lblEmployee.setBounds(468, 237, 46, 14);
		frame.getContentPane().add(lblEmployee);
		
		JList list = new JList(employees);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lblEmployee.setText((String) list.getSelectedValue());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
				
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.setBounds(31, 396, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection c;
				
				try {
					c = DriverManager.getConnection(
							"jdbc:postgresql://localhost:5432/postgres",
					        "postgres", "30042001");
					
					
					//CONSULTAR
					Statement stmt;
					stmt = c.createStatement();
				
					ResultSet rs = stmt.executeQuery( "SELECT * FROM \"EMPLOYEES\" WHERE \"username\"= '"+lblEmployee.getText()+"';" );
					rs.next();
					employee_id = rs.getInt("id");
					
					
					c.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Admin_edit.main(lblEmployee.getText(), employee_id);
			}
		});
		btnEdit.setBounds(411, 279, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin.removeEmployee(lblEmployee.getText());
				
			}
		});
		btnDelete.setBounds(510, 279, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		
		JLabel lblNewLabel_2 = new JLabel("Gerenciar");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(468, 191, 65, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
