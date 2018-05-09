import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Actualizar_pedido {

	public JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actualizar_pedido window = new Actualizar_pedido();
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
	public Actualizar_pedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblActualizarPedido = new JLabel("ACTUALIZAR PEDIDO");
		lblActualizarPedido.setFont(new Font("Cambria", Font.ITALIC, 24));
		lblActualizarPedido.setBounds(132, 35, 227, 29);
		frame.getContentPane().add(lblActualizarPedido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 131, 339, 268);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"PEDIDOS EXISTENTES"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblElijaElPedido = new JLabel("ELIJA EL PEDIDO:");
		lblElijaElPedido.setFont(new Font("Javanese Text", Font.ITALIC, 16));
		lblElijaElPedido.setBounds(61, 103, 150, 23);
		frame.getContentPane().add(lblElijaElPedido);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblInserteNumeroDe = new JLabel("INSERTE NUMERO DE PEDIDO:");
		lblInserteNumeroDe.setBounds(63, 422, 164, 14);
		frame.getContentPane().add(lblInserteNumeroDe);
		
		textField = new JTextField();
		textField.setBounds(221, 422, 103, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(339, 418, 89, 43);
		frame.getContentPane().add(btnOk);
	}
}
