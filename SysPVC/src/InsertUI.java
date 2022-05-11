import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSpinner;

public class InsertUI {

	private JFrame frmSyspvc;
	private JTextField textCod;
	private JTextField textNome;
	private JTextField textPreco;

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
		Employee func = new Employee(Main.currentUser,"");
		Transaction trsc = new Transaction();
		initialize(trsc, func);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Transaction trsc, Employee func) {
		frmSyspvc = new JFrame();
		frmSyspvc.setMinimumSize(new Dimension(640, 480));
		frmSyspvc.setTitle("SysPVC");
		frmSyspvc.setBounds(100, 100, 450, 300);
		frmSyspvc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSyspvc.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Inserir");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(282, 35, 69, 20);
		frmSyspvc.getContentPane().add(lblHeader);
		
		JLabel lblHeader_2 = new JLabel("Informe os dados do produto.");
		lblHeader_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeader_2.setBounds(218, 81, 187, 14);
		frmSyspvc.getContentPane().add(lblHeader_2);
		
		textCod = new JTextField();
		textCod.setBounds(112, 184, 86, 20);
		frmSyspvc.getContentPane().add(textCod);
		textCod.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(252, 184, 257, 20);
		frmSyspvc.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(112, 232, 86, 20);
		frmSyspvc.getContentPane().add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblInput_1 = new JLabel("c\u00F3digo:");
		lblInput_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_1.setBounds(113, 169, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_1);
		
		JLabel lblInput_2 = new JLabel("nome:");
		lblInput_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_2.setBounds(252, 169, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_2);
		
		JLabel lblInput_3 = new JLabel("pre\u00E7o:");
		lblInput_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_3.setBounds(113, 218, 46, 14);
		frmSyspvc.getContentPane().add(lblInput_3);
		
		JLabel lblInput_4 = new JLabel("quantidade: X");
		lblInput_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput_4.setBounds(252, 235, 85, 14);
		frmSyspvc.getContentPane().add(lblInput_4);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ArrayList<Product> items = trsc.getItems();
				
				ReviewUI.main(trsc);
				frmSyspvc.dispose();
			}
		});
		btnFinalizar.setBounds(265, 332, 89, 23);
		frmSyspvc.getContentPane().add(btnFinalizar);
		
		
		JLabel lblNewLabel = new JLabel("R$");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(63, 233, 46, 14);
		frmSyspvc.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(323, 232, 46, 20);
		frmSyspvc.getContentPane().add(spinner);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product product = new Product(
							Integer.parseInt(textCod.getText()),
							textNome.getText(),
							Float.parseFloat(textPreco.getText()),
							Integer.parseInt(spinner.getValue().toString())
						);
				
				func.insertProduct(product, trsc);
				
				
				textCod.setText("");
				textNome.setText("");
				textPreco.setText("");
				spinner.setValue(0);
			}
		});
		btnInserir.setBounds(420, 231, 89, 23);
		frmSyspvc.getContentPane().add(btnInserir);
	}
}
