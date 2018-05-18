import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("unused")
public class Iniciar_pedido {

	public JFrame frame;
	public JTable table;
	public JButton btnAgregar;
	public JButton btnEliminar;
	public JTextField textField;
	public JLabel lblCb;
	public JTextField textField_2;
	CONEXIONBBDD Prueba = new CONEXIONBBDD();
	private JTextField textField_3;

	public Iniciar_pedido() {
		initialize();
	}

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
			},
			new String[] {
				"ID_producto", "Nombre"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setFont(new Font("Sitka Small", Font.BOLD, 28));
		lblPedido.setBounds(288, 34, 131, 25);
		frame.getContentPane().add(lblPedido);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				table.setModel(Prueba.Agregar(id,(DefaultTableModel) table.getModel()));
			}
		});
		btnAgregar.setBounds(71, 412, 115, 59);
		frame.getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
		    }
		});
		btnEliminar.setBounds(231, 412, 115, 59);
		frame.getContentPane().add(btnEliminar);
		
		textField = new JTextField();
		textField.setBounds(91, 482, 95, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblCb = new JLabel("ID_producto:");
		lblCb.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCb.setBounds(20, 482, 71, 20);
		frame.getContentPane().add(lblCb);
		
		JLabel lblNmesa = new JLabel("N\u00BA pedido:");
		lblNmesa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNmesa.setBounds(367, 485, 52, 14);
		frame.getContentPane().add(lblNmesa);
		
		JButton button = new JButton("ATRAS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedidos ventana6 = new Pedidos();
				ventana6.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("COBRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pedido = textField_2.getText();
				textField_3.setText(Integer.toString(Prueba.Cobrar(pedido)));
			}
		});
		btnNewButton.setBounds(578, 407, 102, 87);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Cambria", Font.ITALIC, 16));
		lblTotal.setBounds(508, 514, 60, 20);
		frame.getContentPane().add(lblTotal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(427, 482, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(578, 516, 102, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero = textField_2.getText();
				Prueba.Guardar((DefaultTableModel)table.getModel(), numero);
			}
		});
		btnGuardar.setBounds(398, 412, 115, 59);
		frame.getContentPane().add(btnGuardar);
		
		JLabel lblseleccionarFila = new JLabel("(Seleccionar fila)");
		lblseleccionarFila.setBounds(241, 485, 105, 14);
		frame.getContentPane().add(lblseleccionarFila);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 0));
		panel.setBounds(0, 0, 725, 545);
		frame.getContentPane().add(panel);
	}
}

