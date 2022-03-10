import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI {

	private JFrame frame;
	private JTextField textField_login;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void begin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
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
	public LoginUI() {
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
		
		JLabel lblNewLabel = new JLabel("Caixa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(196, 53, 55, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(140, 132, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setBounds(140, 157, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_login = new JTextField();
		textField_login.setBounds(181, 129, 86, 20);
		frame.getContentPane().add(textField_login);
		textField_login.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(181, 157, 86, 20);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);
		
		
		JLabel lblTest = new JLabel("N\u00E3o logado");
		lblTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTest.setBounds(196, 215, 62, 14);
		frame.getContentPane().add(lblTest);
		
		
		JButton btnSubmit = new JButton("Entrar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean success = User.Login(textField_login.getText(), textField_password.getText());
				
				if(success) {
					lblTest.setText("Logado!");
				}else {
					lblTest.setText("Erro!");
				}
			}
		});
		btnSubmit.setBounds(277, 128, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}

}
