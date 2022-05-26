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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Admin_register extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnCancel;
	
	private Admin_register self = this;

	/**
	 * Launch the application.
	 */
	public static void main(AdminPanel_1 main_panel) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_register frame = new Admin_register(main_panel);
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
	public Admin_register(AdminPanel_1 main_panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_username = new JTextField();
		textField_username.setBounds(38, 167, 156, 20);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(243, 167, 156, 20);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		JButton btnSubmit = new JButton("Salvar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin.registerEmployee(textField_username.getText(), textField_password.getText());
		    	main_panel.frame.dispose();
		    	AdminPanel_1.main(null);
				
			}
		});
		btnSubmit.setBounds(335, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(184, 42, 59, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Informe os dados do novo funcion\u00E1rio abaixo.");
		lblNewLabel_1.setBounds(104, 94, 221, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("usu\u00E1rio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(38, 142, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setBounds(243, 142, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
		btnCancel.setBounds(236, 227, 89, 23);
		contentPane.add(btnCancel);
		
	}
}
