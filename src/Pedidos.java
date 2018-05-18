import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("unused")
public class Pedidos {

	public JFrame frame;

	public Pedidos() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPedidos = new JLabel("PEDIDOS");
		lblPedidos.setFont(new Font("Sitka Small", Font.BOLD, 36));
		lblPedidos.setBounds(191, 30, 189, 58);
		frame.getContentPane().add(lblPedidos);
		
		JButton btnNewButton = new JButton("INICIAR PEDIDO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Iniciar_pedido ventana1 = new Iniciar_pedido();
				ventana1.frame.setVisible(true);
				frame.dispose();
			}});
		btnNewButton.setBounds(74, 208, 159, 70);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnActualizarPedido = new JButton("ACTUALIZAR PEDIDO");
		btnActualizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Actualizar_pedido ventana1 = new Actualizar_pedido();
				ventana1.frame.setVisible(true);
				frame.dispose();
			}});
		btnActualizarPedido.setBounds(340, 208, 159, 70);
		frame.getContentPane().add(btnActualizarPedido);
		
		JButton button = new JButton("ATRAS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main ventana5 = new Main();
				ventana5.frame.setVisible(true);
				frame.dispose();
			}});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel lblElCochino = new JLabel("EL COCHINO");
		lblElCochino.setFont(new Font("Serif", Font.ITALIC, 24));
		lblElCochino.setBounds(201, 99, 159, 46);
		frame.getContentPane().add(lblElCochino);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 0));
		panel.setBounds(0, 0, 563, 336);
		frame.getContentPane().add(panel);
	}

}
