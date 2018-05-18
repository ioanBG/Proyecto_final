import java.awt.Component;
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
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("unused")
public class Administracion {

	public JFrame frame;
	private JTable table;
	CONEXIONBBDD Prueba = new CONEXIONBBDD();
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JLabel comboBox;

	public Administracion() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		
		comboBox.setBounds(506, 530, 46, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAdministracion = new JLabel("ADMINISTRACION");
		lblAdministracion.setFont(new Font("Sitka Small", Font.BOLD, 30));
		lblAdministracion.setBounds(238, 21, 297, 36);
		frame.getContentPane().add(lblAdministracion);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				String nombre = textField_1.getText();
				String precio = textField_2.getText();
				String caducidad = textField_3.getText();
				String categoria = (String) comboBox.getSelectedItem();
				Prueba.Aumentar(id, nombre, precio, caducidad, categoria);
				table.setModel(Prueba.Productos());
			}
		});
		btnNewButton.setBounds(61, 421, 133, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				String nombre = textField_1.getText();
				String precio = textField_2.getText();
				String caducidad = textField_3.getText();
				String categoria = (String) comboBox.getSelectedItem();
				Prueba.Modificar(id, nombre, precio, caducidad, categoria);
				table.setModel(Prueba.Productos());
			}
		});
		btnModificar.setBounds(306, 421, 133, 53);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String eliminar = textField.getText();
				Prueba.Eliminar(eliminar);
				table.setModel(Prueba.Productos());
			}
		});
		btnEliminar.setBounds(541, 421, 133, 53);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblElCochino = new JLabel("EL COCHINO");
		lblElCochino.setFont(new Font("Serif", Font.ITALIC, 26));
		lblElCochino.setBounds(602, 556, 164, 37);
		frame.getContentPane().add(lblElCochino);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 114, 694, 268);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_producto", "Nombre", "Precio", "Caducidad"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				frame.dispose();
			}});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(93, 502, 105, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 541, 105, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(318, 502, 105, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(318, 541, 105, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIdproducto = new JLabel("ID_producto:");
		lblIdproducto.setBounds(10, 505, 73, 14);
		frame.getContentPane().add(lblIdproducto);
		
		JLabel lblNombre = new JLabel("*Nombre:");
		lblNombre.setBounds(20, 544, 56, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPrecio = new JLabel("*Precio:");
		lblPrecio.setBounds(262, 505, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblCaducidad = new JLabel("*Caducidad:");
		lblCaducidad.setBounds(238, 543, 75, 17);
		frame.getContentPane().add(lblCaducidad);
		
		JLabel lblOpcional = new JLabel("*opcional");
		lblOpcional.setBounds(639, 505, 65, 14);
		frame.getContentPane().add(lblOpcional);
		
		JLabel lblCategoria = new JLabel("*Categoria:");
		lblCategoria.setBounds(496, 505, 65, 14);
		frame.getContentPane().add(lblCategoria);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 0));
		panel.setBounds(0, 0, 776, 604);
		frame.getContentPane().add(panel);
	}
}