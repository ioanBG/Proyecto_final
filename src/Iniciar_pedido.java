import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Iniciar_pedido {

	public JFrame frame;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblCb;
	private JLabel lblNombre;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iniciar_pedido window = new Iniciar_pedido();
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
	public Iniciar_pedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 741, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 90, 558, 299);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"COMIDAS", "BEBIDAS"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPedido.setBounds(307, 11, 84, 25);
		frame.getContentPane().add(lblPedido);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(71, 412, 115, 59);
		frame.getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(437, 412, 115, 59);
		frame.getContentPane().add(btnEliminar);
		
		textField = new JTextField();
		textField.setBounds(293, 412, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 451, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblCb = new JLabel("C/B:");
		lblCb.setBounds(225, 412, 33, 20);
		frame.getContentPane().add(lblCb);
		
		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(225, 454, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNmesa = new JLabel("N\u00BAMESA:");
		lblNmesa.setFont(new Font("Cambria", Font.ITALIC, 14));
		lblNmesa.setBounds(71, 65, 60, 14);
		frame.getContentPane().add(lblNmesa);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 63, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("ATRAS");
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("COBRAR");
		btnNewButton.setBounds(578, 407, 102, 87);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Cambria", Font.ITALIC, 16));
		lblTotal.setBounds(508, 514, 60, 20);
		frame.getContentPane().add(lblTotal);
		
		textField_3 = new JTextField();
		textField_3.setBounds(578, 514, 102, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
