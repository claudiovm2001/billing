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
import java.awt.Font;
import java.awt.Color;

public class Admin_edit extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_passwd;
	
	private Admin_edit self = this;

	/**
	 * Launch the application.
	 */
	public static void main( String selectedEmployee, int id, AdminPanel_1 main_panel) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_edit frame = new Admin_edit(selectedEmployee, id, main_panel);
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
	public Admin_edit(String selectedEmployee, int id, AdminPanel_1 main_panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(selectedEmployee);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(227, 86, 186, 14);
		contentPane.add(lblNewLabel);
		
		textField_name = new JTextField();
		textField_name.setBounds(84, 196, 130, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_passwd = new JTextField();
		textField_passwd.setBounds(294, 196, 130, 20);
		contentPane.add(textField_passwd);
		textField_passwd.setColumns(10);
		
		JButton btnUpdate = new JButton("Salvar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin.updateEmployee(id, textField_name.getText(), textField_passwd.getText());
				main_panel.frame.dispose();
				AdminPanel_1.main(null);
				
			}
		});
		btnUpdate.setBounds(335, 227, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Atualizar cadastro de:");
		lblNewLabel_1.setBounds(102, 86, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("nome:");
		lblNewLabel_2.setBounds(28, 199, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("senha:");
		lblNewLabel_3.setBounds(238, 199, 186, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Editar");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(196, 24, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Informe as novas credenciais abaixo.");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(136, 145, 186, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
		btnCancel.setBounds(236, 227, 89, 23);
		contentPane.add(btnCancel);
	}
}
