import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class Administracion {

	public JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administracion window = new Administracion();
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
	public Administracion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdministracion = new JLabel("ADMINISTRACION");
		lblAdministracion.setFont(new Font("Century", Font.ITALIC, 30));
		lblAdministracion.setBounds(238, 21, 297, 36);
		frame.getContentPane().add(lblAdministracion);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR");
		btnNewButton.setBounds(61, 421, 133, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(306, 421, 133, 53);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(541, 421, 133, 53);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblElCochino = new JLabel("EL COCHINO");
		lblElCochino.setFont(new Font("Calibri", Font.ITALIC, 30));
		lblElCochino.setBounds(602, 556, 164, 37);
		frame.getContentPane().add(lblElCochino);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 114, 694, 268);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID_producto", "Nombre", "Precio", "Caducidad"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblColumna = new JLabel("COLUMNA:");
		lblColumna.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblColumna.setBounds(192, 500, 82, 14);
		frame.getContentPane().add(lblColumna);
		
		JLabel lblElemento = new JLabel("ELEMENTO:");
		lblElemento.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblElemento.setBounds(192, 544, 96, 14);
		frame.getContentPane().add(lblElemento);
		
		textField = new JTextField();
		textField.setBounds(306, 499, 168, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(306, 543, 168, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CONEXIONBBDD Prueba = new CONEXIONBBDD();
				table.setModel(Prueba.Productos());
			}
		});
		btnListar.setBounds(341, 74, 89, 29);
		frame.getContentPane().add(btnListar);
		
		JButton button = new JButton("ATRAS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main ventana4 = new Main();
				ventana4.frame.setVisible(true);
			}});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
	}
}
