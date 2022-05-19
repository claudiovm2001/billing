import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Admin_edit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main( String selectedEmployee, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_edit frame = new Admin_edit(selectedEmployee, id);
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
	public Admin_edit(String selectedEmployee, int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(selectedEmployee);
		lblNewLabel.setBounds(196, 110, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(124, 167, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 167, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Salvar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection c = null;
			      
		    	try {
		    		Class.forName("org.postgresql.Driver");
		    		
		    		c = DriverManager.getConnection(
		    				"jdbc:postgresql://localhost:5432/postgres", "postgres","30042001"
		            );
		            c.setAutoCommit(false);					
					
		            
		            PreparedStatement stmt = c.prepareStatement(
		            		"UPDATE \"EMPLOYEES\""
		            		+ "SET \"username\" = ?, \"password\" = ?"
		            		+ "WHERE \"id\"= "+id
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
		btnUpdate.setBounds(335, 227, 89, 23);
		contentPane.add(btnUpdate);
	}
}
