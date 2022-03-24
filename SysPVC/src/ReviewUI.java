import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class ReviewUI {

	private JFrame frmSyspvc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewUI window = new ReviewUI();
					window.frmSyspvc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReviewUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSyspvc = new JFrame();
		frmSyspvc.setTitle("SysPVC");
		frmSyspvc.setMinimumSize(new Dimension(800, 600));
		frmSyspvc.setBounds(100, 100, 450, 300);
		frmSyspvc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSyspvc.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Revisar");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(354, 38, 76, 25);
		frmSyspvc.getContentPane().add(lblHeader);
		
		JLabel lblHeader_2 = new JLabel("Verifique a lista de produtos antes de efetivar a transa\u00E7\u00E3o.");
		lblHeader_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeader_2.setBounds(217, 88, 361, 25);
		frmSyspvc.getContentPane().add(lblHeader_2);
		
		String teste[] = {"teste1", "teste2"};
		
		JList listItems = new JList(teste);
		listItems.setBounds(217, 155, 361, 359);
		frmSyspvc.getContentPane().add(listItems);
	}
}
