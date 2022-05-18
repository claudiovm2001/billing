import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_register frame = new Admin_register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(47, 119, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 119, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection c = null;
			      
		    	try {
		    		Class.forName("org.postgresql.Driver");
		    		
		    		c = DriverManager.getConnection(
		    				"jdbc:postgresql://localhost:5432/postgres", "postgres","30042001"
		            );
		            c.setAutoCommit(false);					
					
		            
		            PreparedStatement stmt = c.prepareStatement(
		            		"INSERT INTO \"EMPLOYEES\" (\"username\", \"password\") VALUES (?, ?)"
		        		    );			        		 		
		         
		            stmt.setString(1, textField.getText()); 
			        stmt.setString(2, textField_1.getText());
				        
				        		 
				    stmt.executeUpdate();
		 
		         
		            c.commit();
		            c.close();
		         
		      } catch (Exception e1) {
		          e1.printStackTrace();
		          System.err.println(e1.getClass().getName()+": "+e1.getMessage());
		          System.exit(0);
		       }
		    	
				
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
