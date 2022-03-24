import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class InsertUI {

	private JFrame frmSyspvc;
	private JTextField textCod;
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textQtd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertUI window = new InsertUI();
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
	public InsertUI() {
		Employee func = new Employee("func1","senha1");
		Transaction trsc = new Transaction();
		initialize(trsc, func);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Transaction trsc, Employee func) {
		frmSyspvc = new JFrame();
		frmSyspvc.setTitle("SysPVC");
		frmSyspvc.setBounds(100, 100, 450, 300);
		frmSyspvc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSyspvc.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Inserir");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(172, 25, 69, 20);
		frmSyspvc.getContentPane().add(lblHeader);
		
		JLabel lblHeader_2 = new JLabel("Informe os dados do produto.");
		lblHeader_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeader_2.setBounds(117, 66, 187, 14);
		frmSyspvc.getContentPane().add(lblHeader_2);
		
		textCod = new JTextField();
		textCod.setBounds(125, 121, 86, 20);
		frmSyspvc.getContentPane().add(textCod);
		textCod.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(218, 121, 86, 20);
		frmSyspvc.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(125, 169, 86, 20);
		frmSyspvc.getContentPane().add(textPreco);
		textPreco.setColumns(10);
		
		textQtd = new JTextField();
		textQtd.setBounds(218, 169, 86, 20);
		frmSyspvc.getContentPane().add(textQtd);
		textQtd.setColumns(10);
		
		JLabel lblInput_1 = new JLabel("cod:");
		lblInput_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_1.setBounds(126, 106, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_1);
		
		JLabel lblInput_2 = new JLabel("nome:");
		lblInput_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_2.setBounds(219, 106, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_2);
		
		JLabel lblInput_3 = new JLabel("pre\u00E7o:");
		lblInput_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_3.setBounds(126, 155, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_3);
		
		JLabel lblInput_4 = new JLabel("qtd:");
		lblInput_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_4.setBounds(219, 155, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_4);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Product> items = trsc.getItems();
				
				ReviewUI.main(items);
			}
		});
		btnFinalizar.setBounds(215, 211, 89, 23);
		frmSyspvc.getContentPane().add(btnFinalizar);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product product = new Product(
							Integer.parseInt(textCod.getText()),
							textNome.getText(),
							Float.parseFloat(textPreco.getText()),
							Integer.parseInt(textQtd.getText()) 
						);
				
				func.insertProduct(product, trsc);
			}
		});
		btnInserir.setBounds(122, 211, 89, 23);
		frmSyspvc.getContentPane().add(btnInserir);
	}

}
