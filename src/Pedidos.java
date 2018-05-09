import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pedidos {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos window = new Pedidos();
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
	public Pedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPedidos = new JLabel("PEDIDOS");
		lblPedidos.setFont(new Font("Calibri", Font.ITALIC, 36));
		lblPedidos.setBounds(214, 30, 141, 58);
		frame.getContentPane().add(lblPedidos);
		
		JButton btnNewButton = new JButton("INICIAR PEDIDO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Iniciar_pedido ventana1 = new Iniciar_pedido();
				ventana1.frame.setVisible(true);
			}});
		btnNewButton.setBounds(74, 208, 159, 70);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnActualizarPedido = new JButton("ACTUALIZAR PEDIDO");
		btnActualizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Actualizar_pedido ventana1 = new Actualizar_pedido();
				ventana1.frame.setVisible(true);
			}});
		btnActualizarPedido.setBounds(340, 208, 159, 70);
		frame.getContentPane().add(btnActualizarPedido);
		
		JButton button = new JButton("ATRAS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main ventana5 = new Main();
				ventana5.frame.setVisible(true);
			}});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel lblElCochino = new JLabel("EL COCHINO");
		lblElCochino.setFont(new Font("Cambria", Font.ITALIC, 24));
		lblElCochino.setBounds(214, 99, 133, 46);
		frame.getContentPane().add(lblElCochino);
	}

}
