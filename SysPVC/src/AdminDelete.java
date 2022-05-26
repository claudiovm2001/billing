import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDelete extends JFrame {

	private JPanel contentPane;
	private AdminDelete self = this;

	/**
	 * Launch the application.
	 */
	public static void main(String empl_name, AdminPanel_1 main_panel) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDelete frame = new AdminDelete(empl_name, main_panel);
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
	public AdminDelete(String empl_name, AdminPanel_1 main_panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Excluir");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(192, 41, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tem certeza que deseja excluir o cadastro do funcio\u00E1rio abaixo?");
		lblNewLabel_1.setBounds(60, 86, 308, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel(empl_name);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblName.setBounds(104, 133, 216, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_2 = new JLabel("Esta a\u00E7\u00E3o n\u00E3o pode ser desfeita!");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(115, 178, 200, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeEmployee(empl_name);
				main_panel.frame.dispose();
				AdminPanel_1.main(null);
			}
		});
		btnConfirm.setBounds(219, 215, 89, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
		btnCancel.setBounds(120, 215, 89, 23);
		contentPane.add(btnCancel);
	}
}
