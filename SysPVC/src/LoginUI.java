import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI {

	private JFrame frame;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel lblHeader = new JLabel("Login");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(186, 25, 55, 25);
		frame.getContentPane().add(lblHeader);
		
		JLabel lblHeader_2 = new JLabel("Informe suas credenciais.");
		lblHeader_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeader_2.setBounds(144, 80, 154, 15);
		frame.getContentPane().add(lblHeader_2);
		
		textUsername = new JTextField();
		textUsername.setBounds(177, 151, 86, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(177, 182, 86, 20);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblCredential_1 = new JLabel("username:");
		lblCredential_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCredential_1.setBounds(112, 154, 55, 14);
		frame.getContentPane().add(lblCredential_1);
		
		JLabel lblCredential_2 = new JLabel("password:");
		lblCredential_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCredential_2.setBounds(112, 185, 55, 14);
		frame.getContentPane().add(lblCredential_2);
		
		JButton btnSubmit = new JButton("Entrar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user = new User(textUsername.getText(), textPassword.getText());
				
				if(user.login()) {
					lblHeader_2.setText("LOGADO COM SUCESSO!");
				}else {
					lblHeader_2.setText("Credenciais n�o reconhecidas!");
				}
			}
		});
		btnSubmit.setBounds(273, 181, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}

}