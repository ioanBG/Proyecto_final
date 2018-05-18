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
public class Main {

	public JFrame frame;

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdministracin = new JLabel("ADMINISTRACI\u00D3N");
		lblAdministracin.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblAdministracin.setBounds(47, 215, 200, 14);
		frame.getContentPane().add(lblAdministracin);
		
		JLabel lblPedidos = new JLabel("PEDIDOS");
		lblPedidos.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblPedidos.setBounds(350, 215, 101, 14);
		frame.getContentPane().add(lblPedidos);
		
		JButton btnIr = new JButton("IR");
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administracion ventana1 = new Administracion();
				ventana1.frame.setVisible(true);
				frame.dispose();
			}});
		btnIr.setBounds(86, 252, 111, 54);
		frame.getContentPane().add(btnIr);
		
		JButton btnIr_1 = new JButton("IR");
		btnIr_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedidos ventana2 = new Pedidos();
				ventana2.frame.setVisible(true);
				frame.dispose();
			}});
		btnIr_1.setBounds(340, 252, 111, 54);
		frame.getContentPane().add(btnIr_1);
		
		JLabel lblRestaurante = new JLabel("RESTAURANTE");
		lblRestaurante.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblRestaurante.setBounds(182, 24, 171, 54);
		frame.getContentPane().add(lblRestaurante);
		
		JLabel lblElCochino = new JLabel("EL COCHINO");
		lblElCochino.setFont(new Font("Serif", Font.ITALIC, 38));
		lblElCochino.setBounds(151, 71, 234, 86);
		frame.getContentPane().add(lblElCochino);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login ventana3 = new Login();
				ventana3.frame.setVisible(true);
				frame.dispose();
			}});
		btnSalir.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 0));
		panel.setBounds(0, 0, 541, 333);
		frame.getContentPane().add(panel);
	}
}


