import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Actualizar_pedido {

	public JFrame frame;
	private JTable table;
	private JTextField textField;
	CONEXIONBBDD Prueba = new CONEXIONBBDD();

	public Actualizar_pedido() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblActualizarPedido = new JLabel("ACTUALIZAR PEDIDO");
		lblActualizarPedido.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblActualizarPedido.setBounds(111, 41, 227, 29);
		frame.getContentPane().add(lblActualizarPedido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 131, 339, 268);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PEDIDOS EXISTENTES"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblElijaElPedido = new JLabel("ELIJA EL NUMERO DE PEDIDO:");
		lblElijaElPedido.setFont(new Font("Serif", Font.PLAIN, 16));
		lblElijaElPedido.setBounds(61, 103, 238, 23);
		frame.getContentPane().add(lblElijaElPedido);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos ventana7 = new Pedidos();
				ventana7.frame.setVisible(true);
			}
		});
		btnAtras.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblInserteNumeroDe = new JLabel("INSERTE NUMERO DE PEDIDO:");
		lblInserteNumeroDe.setBounds(57, 425, 154, 14);
		frame.getContentPane().add(lblInserteNumeroDe);
		
		textField = new JTextField();
		textField.setBounds(221, 422, 103, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = textField.getText();
				Iniciar_pedido ventana8 = new Iniciar_pedido();
				ventana8.frame.setVisible(true);
				table.setModel(Prueba.Ok(texto));
			}
		});
		btnOk.setBounds(339, 418, 89, 43);
		frame.getContentPane().add(btnOk);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(Prueba.Actualizar());
			}
		});
		btnListar.setBounds(306, 97, 96, 23);
		frame.getContentPane().add(btnListar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 0));
		panel.setBounds(0, 0, 455, 483);
		frame.getContentPane().add(panel);
	}
}
