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
	private JTextField textField_name;
	private JTextField textField_passwd;

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
		
		textField_name = new JTextField();
		textField_name.setBounds(124, 167, 86, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_passwd = new JTextField();
		textField_passwd.setBounds(233, 167, 86, 20);
		contentPane.add(textField_passwd);
		textField_passwd.setColumns(10);
		
		JButton btnUpdate = new JButton("Salvar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin.updateEmployee(id, textField_name.getText(), textField_passwd.getText());
				
			}
		});
		btnUpdate.setBounds(335, 227, 89, 23);
		contentPane.add(btnUpdate);
	}
}
